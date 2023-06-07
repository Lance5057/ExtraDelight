package com.lance5057.extradelight.blocks;

import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.recipe.FeastRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RecipeFeastBlock extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 4);

	public final boolean hasLeftovers;

	protected final VoxelShape[] SHAPES;

	/**
	 * This block provides up to 4 servings of food to players who interact with it.
	 * If a leftover item is specified, the block lingers at 0 servings, and is
	 * destroyed on right-click.
	 *
	 * @param properties   Block properties.
	 * @param servingItem  The meal to be served.
	 * @param hasLeftovers Whether the block remains when out of servings. If false,
	 *                     the block vanishes once it runs out.
	 */
	public RecipeFeastBlock(Properties properties, boolean hasLeftovers, VoxelShape... shapes) {
		super(properties);
		SHAPES = shapes;
		this.hasLeftovers = hasLeftovers;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
				.setValue(getServingsProperty(), getMaxServings()));
	}

	public IntegerProperty getServingsProperty() {
		return SERVINGS;
	}

	public int getMaxServings() {
		return 4;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		if (SHAPES.length > 1)
			return state.getValue(SERVINGS) == 0 ? SHAPES[0]
					: Shapes.joinUnoptimized(SHAPES[0], rotateShape(state), BooleanOp.OR);
		else
			return SHAPES[0];
	}

	private VoxelShape rotateShape(BlockState state) {
		if (SHAPES.length > 2)
			switch (state.getValue(FACING)) {
			case EAST:
			case WEST:
				return SHAPES[2];
			case SOUTH:
			case NORTH:
			default:
				return SHAPES[1];
			}
		return SHAPES[1];
	}

	public Optional<FeastRecipe> matchRecipe(Level level, ItemStack... itemstack) {
		if (level != null) {
			return level.getServer().getRecipeManager().getRecipeFor(ExtraDelightRecipes.FEAST.get(),
					new SimpleContainer(itemstack), level);
		}
		return Optional.empty();

	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult hit) {
		if (level.isClientSide) {
			if (this.takeServing(level, pos, state, player, hand).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
		}

		return this.takeServing(level, pos, state, player, hand);
	}

	protected InteractionResult takeServing(Level level, BlockPos pos, BlockState state, Player player,
			InteractionHand hand) {

		int servings = state.getValue(getServingsProperty());

		if (servings == 0) {
			level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
			level.destroyBlock(pos, true);
			return InteractionResult.SUCCESS;
		}

		ItemStack heldStack = player.getItemInHand(hand);
		Optional<FeastRecipe> r = level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.FEAST.get(),
				new SimpleContainer(heldStack, new ItemStack(this.asItem())), level);

		if (r.isPresent()) {
			if (servings > 0) {
				ItemStack result = r.get().getResultItem().copy();
				level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
				if (!player.getAbilities().instabuild) {
					if (heldStack.isDamageableItem())
						heldStack.hurtAndBreak(1, player, null);
					else
						heldStack.shrink(1);
				}
				if (!player.getInventory().add(result)) {
					player.drop(result, false);
				}
				if (level.getBlockState(pos).getValue(getServingsProperty()) == 0 && !this.hasLeftovers) {
					level.removeBlock(pos, false);
				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return level.getBlockState(pos.below()).getMaterial().isSolid();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, SERVINGS);
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
		return blockState.getValue(getServingsProperty());
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
		return false;
	}
}

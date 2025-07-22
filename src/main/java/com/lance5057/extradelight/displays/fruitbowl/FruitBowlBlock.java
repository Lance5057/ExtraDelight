package com.lance5057.extradelight.displays.fruitbowl;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.interfaces.IStyleable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;

public class FruitBowlBlock extends Block implements EntityBlock, SimpleWaterloggedBlock, IStyleable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 5.0D, 12.0D);
	public static final IntegerProperty STYLE = IntegerProperty.create("style", 0, Styles.values().length - 1);

	public static enum Styles {
		OAK_PLANKS, SPRUCE_PLANKS, BIRCH_PLANKS, DARK_OAK_PLANKS, ACACIA_PLANKS, MANGROVE_PLANKS, BAMBOO_PLANKS,
		CHERRY_PLANKS, JUNGLE_PLANKS, WARPED_PLANKS, CRIMSON_PLANKS, GLASS, STONE, IRON_BLOCK, GOLD_BLOCK, TERRACOTTA,
		WHITE_TERRACOTTA, LIGHT_GRAY_TERRACOTTA, GRAY_TERRACOTTA, BLACK_TERRACOTTA, BROWN_TERRACOTTA, RED_TERRACOTTA,
		ORANGE_TERRACOTTA, YELLOW_TERRACOTTA, LIME_TERRACOTTA, GREEN_TERRACOTTA, CYAN_TERRACOTTA, LIGHT_BLUE_TERRACOTTA,
		BLUE_TERRACOTTA, MAGENTA_TERRACOTTA, PINK_TERRACOTTA, PURPLE_TERRACOTTA, WHITE_GLAZED_TERRACOTTA,
		LIGHT_GRAY_GLAZED_TERRACOTTA, GRAY_GLAZED_TERRACOTTA, BLACK_GLAZED_TERRACOTTA, BROWN_GLAZED_TERRACOTTA,
		RED_GLAZED_TERRACOTTA, ORANGE_GLAZED_TERRACOTTA, YELLOW_GLAZED_TERRACOTTA, LIME_GLAZED_TERRACOTTA,
		GREEN_GLAZED_TERRACOTTA, CYAN_GLAZED_TERRACOTTA, LIGHT_BLUE_GLAZED_TERRACOTTA, BLUE_GLAZED_TERRACOTTA,
		MAGENTA_GLAZED_TERRACOTTA, PINK_GLAZED_TERRACOTTA, PURPLE_GLAZED_TERRACOTTA
	};

	public FruitBowlBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(STYLE, 0));
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof FruitBowlBlockEntity ent) {

				if (player.getItemInHand(hand).isEmpty())
					ent.extractItem(player);
				else if (player.getItemInHand(hand).is(ExtraDelightTags.FRUIT))
					ent.insertItem(player.getItemInHand(hand));
			}
		}
		return ItemInteractionResult.SUCCESS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return ExtraDelightBlockEntities.FRUIT_BOWL.get().create(pPos, pState);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED, STYLE);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level level = context.getLevel();
		FluidState fluid = level.getFluidState(context.getClickedPos());

		BlockState state = this.defaultBlockState().setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

		return state;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		return state;
	}

	@Override
	public int numStyles() {
		return Styles.values().length;
	}

	@Override
	public int getCurrentStyle(BlockState state) {
		return state.getValue(STYLE);
	}

	@Override
	public void setNextStyle(Level level, BlockPos pos, BlockState state) {
		int next = state.getValue(STYLE) + 1;
		if (state.getValue(STYLE) >= numStyles() - 1) {
			next = 0;
		}

		for (int i = 0; i < 10; i++)
			level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.defaultBlockState()),
					pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0, 0, 0);
		level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

		BlockState nextState = state.setValue(STYLE, next);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public void setPrevStyle(Level level, BlockPos pos, BlockState state) {
		int next = state.getValue(STYLE) - 1;
		if (next < 0) {
			next = this.numStyles() - 1;
		}

		for (int i = 0; i < 10; i++)
			level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.defaultBlockState()),
					pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0, 0, 0);
		level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

		BlockState nextState = state.setValue(STYLE, next);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public BlockState getState(int i) {
		return this.defaultBlockState().setValue(STYLE, i);
	}

	@Override
	public void setStyle(Level level, BlockPos pos, BlockState state, int style) {
		BlockState nextState = state.setValue(STYLE, style);
		level.setBlock(pos, nextState, 3);
	}

	@Override
	public boolean isPatreonStyle(int style) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		MutableComponent textEmpty = Component.translatable(ExtraDelight.MOD_ID + ".tooltip.styleable");
		tooltipComponents.add(textEmpty.withStyle(ChatFormatting.AQUA));
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof FruitBowlBlockEntity te) {
				IItemHandler items = te.getItemHandler();
				for (int i = 0; i < te.getItemHandler().getSlots(); i++) {
					level.addFreshEntity(
							new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), items.getStackInSlot(i)));
				}
				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos,
			Player player) {
		ItemStack stack = new ItemStack(this);
		stack.set(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY.with(STYLE, state.getValue(STYLE)));
		return stack;
	}

	@Override
	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide && !player.isCreative()
				&& level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
			ItemStack itemstack = new ItemStack(this);
			itemstack.set(DataComponents.BLOCK_STATE,
					BlockItemStateProperties.EMPTY.with(STYLE, state.getValue(STYLE)));
			ItemEntity itementity = new ItemEntity(level, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					itemstack);
			itementity.setDefaultPickUpDelay();
			level.addFreshEntity(itementity);
		}

		return super.playerWillDestroy(level, pos, state, player);
	}

}
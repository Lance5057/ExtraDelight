package com.lance5057.extradelight.blocks.jardisplay;

import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.recipe.FeastRecipe;
import com.lance5057.extradelight.recipe.SimpleRecipeWrapper;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.util.CollisionUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class JarDisplayBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

	protected VoxelShape SHAPE_NW = Block.box(1.0D, 0.0D, 1.0D, 7.0D, 8.0D, 7.0D);
	protected VoxelShape SHAPE_NE = Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 7.0D);
	protected VoxelShape SHAPE_SW = Block.box(1.0D, 0.0D, 9.0D, 7.0D, 8.0D, 15.0D);
	protected VoxelShape SHAPE_SE = Block.box(9.0D, 0.0D, 9.0D, 15.0D, 8.0D, 15.0D);

	protected VoxelShape SOUTH_2 = Shapes.join(SHAPE_SE, SHAPE_SW, BooleanOp.OR);
	protected VoxelShape SOUTH_3 = Shapes.join(SHAPE_NE, SOUTH_2, BooleanOp.OR);

	protected VoxelShape NORTH_2 = Shapes.join(SHAPE_NE, SHAPE_NW, BooleanOp.OR);
	protected VoxelShape NORTH_3 = Shapes.join(SHAPE_SW, NORTH_2, BooleanOp.OR);

	protected VoxelShape WEST_2 = Shapes.join(SHAPE_SW, SHAPE_NW, BooleanOp.OR);
	protected VoxelShape WEST_3 = Shapes.join(SHAPE_SE, WEST_2, BooleanOp.OR);

	protected VoxelShape EAST_2 = Shapes.join(SHAPE_SE, SHAPE_NE, BooleanOp.OR);
	protected VoxelShape EAST_3 = Shapes.join(SHAPE_NW, EAST_2, BooleanOp.OR);

	protected VoxelShape FULL = Shapes.join(SHAPE_NW, SOUTH_3, BooleanOp.OR);

	public JarDisplayBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return new JarDisplayBlockEntity(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		BlockEntity be = pLevel.getBlockEntity(pPos);
		if (be != null) {
			if (be instanceof JarDisplayBlockEntity jdbe) {
				IItemHandler items = jdbe.getItems();
				boolean i1 = !items.getStackInSlot(1).isEmpty();
				boolean i2 = !items.getStackInSlot(2).isEmpty();
				boolean i3 = !items.getStackInSlot(3).isEmpty();

				Direction d = pState.getValue(JarDisplayBlock.FACING);

				switch (d) {
				case NORTH:
					return setShape(i1, i2, i3, NORTH_2, NORTH_3);
				case SOUTH:
					return setShape(i1, i2, i3, SOUTH_2, SOUTH_3);
				case WEST:
					return setShape(i1, i2, i3, WEST_2, WEST_3);
				case EAST:
					return setShape(i1, i2, i3, EAST_2, EAST_3);
				}
			}
		}
		return SHAPE;
	}

	private VoxelShape setShape(boolean i1, boolean i2, boolean i3, VoxelShape s2, VoxelShape s3) {
		if (i3)
			return FULL;
		if (i2)
			return s3;

		return s2;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide) {
			if (!stack.isEmpty()) {
				BlockEntity be = level.getBlockEntity(pos);
				if (be != null && be instanceof JarDisplayBlockEntity jdbe) {
					if (!player.isCrouching()) {
						if (stack.getItem() instanceof BlockItem bi && bi.getBlock() instanceof JarSingularBlock b) {
							BlockEntityUtils.Inventory.insertItem(jdbe.getItems(), stack.copy(),
									JarDisplayBlockEntity.NUM_SLOTS);
						} else {
							return takeServingFromIndividual(player, stack, state, level, state.getValue(FACING),
									result, jdbe.getItems(), pos, hand);
						}

					} else {
						extractItem(level, pos, player, jdbe);
					}
				}

				return ItemInteractionResult.SUCCESS;

			}

		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

	}

	private ItemInteractionResult takeServingFromIndividual(Player player, ItemStack stack, BlockState state,
			Level level, Direction dir, BlockHitResult result, IItemHandler iItemHandler, BlockPos pos,
			InteractionHand hand) {

		// this is silly but its kinda jank anyway
		switch (dir) {
		case WEST:
			if (CollisionUtil.AABBPointCollision(SHAPE_NW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(1), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_NE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(3), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(2), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(0), player, hand, state, pos);
			} else {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
		case EAST:
			if (CollisionUtil.AABBPointCollision(SHAPE_NW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(2), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_NE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(0), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(1), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(3), player, hand, state, pos);
			} else {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
		case NORTH:
			if (CollisionUtil.AABBPointCollision(SHAPE_NW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(0), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_NE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(1), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(3), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(2), player, hand, state, pos);
			} else {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
		default:
			if (CollisionUtil.AABBPointCollision(SHAPE_NW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(3), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_NE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(2), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SE.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(0), player, hand, state, pos);
			} else if (CollisionUtil.AABBPointCollision(SHAPE_SW.bounds(), result)) {
				return takeServing(stack, level, iItemHandler.getStackInSlot(1), player, hand, state, pos);
			} else {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
		}
	}

	protected ItemInteractionResult takeServing(ItemStack stack, Level level, ItemStack individual, Player player,
			InteractionHand hand, BlockState state, BlockPos pos) {
		BlockItemStateProperties itemState = individual.get(DataComponents.BLOCK_STATE);

		int servings = itemState.get(JarSingularBlock.SERVINGS);

		if (servings == 0) {
			level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
//				level.destroyBlock(pos, true);
			return ItemInteractionResult.SUCCESS;
		}

		ItemStack heldStack = player.getItemInHand(hand);
		Optional<RecipeHolder<FeastRecipe>> r = level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.FEAST.get(),
				new SimpleRecipeWrapper(individual, stack), level);

		if (r.isPresent()) {
			if (servings > 0) {
				ItemStack result = r.get().value().getResultItem(player.level().registryAccess()).copy();

				individual.update(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY,
						s -> s.with(JarSingularBlock.SERVINGS, servings - 1));

				if (!player.getAbilities().instabuild) {
					if (heldStack.isDamageableItem())
						heldStack.hurtAndBreak(1, player, null);
					else
						heldStack.shrink(1);
				}
				if (!player.getInventory().add(result)) {
					player.drop(result, false);
				}
//				if (servings - 1 <= 0) {
//					List<ItemStack> drops = Block.getDrops(state, (ServerLevel) level, pos, null);
//					individual.setCount(0);
//				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
				level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

				return ItemInteractionResult.SUCCESS;
			}
		} else
			player.displayClientMessage(Component.translatable("extradelight.block.recipefeast.use_container"), true);

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
			BlockHitResult hitResult) {
		if (!level.isClientSide) {
			BlockEntity be = level.getBlockEntity(pos);
			if (player.isCrouching()) {
				if (be != null && be instanceof JarDisplayBlockEntity jdbe) {
					extractItem(level, pos, player, jdbe);

					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.PASS;
	}

	private void extractItem(Level level, BlockPos pos, Player player, JarDisplayBlockEntity jdbe) {
		int i = BlockEntityUtils.Inventory.getLastFilledSlot(jdbe.getItems(), JarDisplayBlockEntity.NUM_SLOTS);
		ItemStackHandler handler = (ItemStackHandler) jdbe.getItems();
		ItemStack s = jdbe.getItems().getStackInSlot(i);
		if (s.getItem() instanceof BlockItem bi) {
			BlockItemStateProperties state = s.get(DataComponents.BLOCK_STATE);
			if (state != null) {
				int servings = state.get(JarSingularBlock.SERVINGS);
				if (servings == 0) {
					List<ItemStack> drops = Block.getDrops(state.apply(bi.getBlock().defaultBlockState()),
							(ServerLevel) level, pos, null);
					drops.forEach(item -> {
						if (!player.addItem(item))
							level.addFreshEntity(
									new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), item.copy()));
					});
					handler.setStackInSlot(i, ItemStack.EMPTY);
				} else {
					if (!player.addItem(s)) {
						level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), s.copy()));
						handler.setStackInSlot(i, ItemStack.EMPTY);
					}
				}
			}

			if (BlockEntityUtils.Inventory.getEmptySlots(jdbe.getItems()) >= 3) {
				convertToSingular(pos, level, jdbe);
			}
		}
		level.sendBlockUpdated(pos, jdbe.getBlockState(), jdbe.getBlockState(), Block.UPDATE_ALL);
	}

	private void convertToSingular(BlockPos pos, Level level, JarDisplayBlockEntity jdbe) {
		int i = BlockEntityUtils.Inventory.getLastFilledSlot(jdbe.getItems(), 4);

		if (i != -1) {
			ItemStack stack = jdbe.getItems().getStackInSlot(i).copy();

			if (stack.getItem() instanceof BlockItem bi) // Gotta check, would be weird if it wasn't
				level.setBlock(pos, stack.get(DataComponents.BLOCK_STATE).apply(bi.getBlock().defaultBlockState()),
						Block.UPDATE_ALL);
		}
	}

}

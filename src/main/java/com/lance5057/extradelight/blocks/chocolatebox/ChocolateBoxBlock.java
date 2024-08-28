package com.lance5057.extradelight.blocks.chocolatebox;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChocolateBoxBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final ResourceLocation CONTENTS = ResourceLocation.withDefaultNamespace("contents");
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final MapCodec<ChocolateBoxBlock> CODEC = simpleCodec(ChocolateBoxBlock::new);
	protected VoxelShape SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
	protected VoxelShape SHAPE2 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 8.0D, 12.0D);

	@Nullable
	private final DyeColor color;

	public ChocolateBoxBlock(Properties p_54120_) {
		super(p_54120_);
		SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
		SHAPE2 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 8.0D, 12.0D);
		this.color = DyeColor.BLACK;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
	}

	@Override
	protected MapCodec<? extends ChocolateBoxBlock> codec() {
		return CODEC;
	}

	public ChocolateBoxBlock(@Nullable DyeColor color, Properties properties) {
		super(properties);
		this.color = color;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ChocolateBoxBlockEntity(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, OPEN);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Direction d = pState.getValue(FACING);

		if (d == Direction.EAST || d == Direction.WEST)
			return SHAPE;
		return SHAPE2;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide) {
			if (player.isCrouching()) {
				level.setBlock(pos, state.setValue(ChocolateBoxBlock.OPEN, !state.getValue(OPEN)),
						Block.UPDATE_CLIENTS);
				return ItemInteractionResult.SUCCESS;
			} else {
				BlockEntity tileEntity = level.getBlockEntity(pos);
				if (tileEntity instanceof ChocolateBoxBlockEntity ent) {
					if (stack.is(ExtraDelightTags.CANDY)) {

						BlockEntityUtils.Inventory.insertItem(stack, ent.getItems(), 8, 1);
//							ent.getItems().insertItem(slot, stack, false);

						return ItemInteractionResult.SUCCESS;
					} else {
						int slot = BlockEntityUtils.Inventory.getLastFilledSlot(ent.getItems(), 8);
						if (slot != -1)
							BlockEntityUtils.Inventory.givePlayerItemStack(ent.getItems().extractItem(slot, 1, false),
									player, level, pos);
						return ItemInteractionResult.SUCCESS;
					}
				}
			}
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
		return ItemInteractionResult.SUCCESS;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
			BlockHitResult hitResult) {
		if (player.isCrouching()) {
			level.setBlock(pos, state.setValue(ChocolateBoxBlock.OPEN, !state.getValue(OPEN)), Block.UPDATE_CLIENTS);
			return InteractionResult.SUCCESS;
		} else {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof ChocolateBoxBlockEntity ent) {
				int slot = BlockEntityUtils.Inventory.getLastFilledSlot(ent.getItems(), 8);
				if (slot != -1)
					BlockEntityUtils.Inventory.givePlayerItemStack(ent.getItems().extractItem(slot, 1, false), player,
							level, pos);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}

//	@Override
//	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
////		BlockEntity blockentity = level.getBlockEntity(pos);
////		if (blockentity instanceof ChocolateBoxBlockEntity be) {
////			if (!level.isClientSide) {
////				ItemStack itemstack = getColoredItemStack(this.getColor());
////				itemstack.applyComponents(blockentity.collectComponents());
////
////				if (!state.getValue(ChocolateBoxBlock.OPEN)) {
////					IItemHandler handler = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
////					if (handler instanceof IItemHandlerModifiable mod)
////						for (int i = 0; i < ChocolateBoxBlockEntity.NUM_SLOTS; i++) {
////							mod.setStackInSlot(i, be.getItems().getStackInSlot(i));
////						}
////				}
////
////				ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5,
////						(double) pos.getZ() + 0.5, itemstack);
////				itementity.setDefaultPickUpDelay();
////				level.addFreshEntity(itementity);
////			}
////		}
//
//		return super.playerWillDestroy(level, pos, state, player);
//	}
//
//	@Override
//	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
//		if (state.getBlock() != newState.getBlock()) {
//			BlockEntity tileEntity = level.getBlockEntity(pos);
//			if (tileEntity instanceof ChocolateBoxBlockEntity te) {
//				if (state.getValue(ChocolateBoxBlock.OPEN)) {
//					IItemHandler items = te.getItems();
//					for (int i = 0; i < te.getItems().getSlots(); i++) {
//						level.addFreshEntity(
//								new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), items.getStackInSlot(i)));
//					}
//				}
//				level.updateNeighbourForOutputSignal(pos, this);
//			}
//
//			super.onRemove(state, level, pos, newState, isMoving);
//		}
//	}

//	@Override
//	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
//			ItemStack stack) {
//		BlockEntity blockentity = level.getBlockEntity(pos);
//		if (blockentity instanceof ChocolateBoxBlockEntity be) {
//			IItemHandler handler = stack.getCapability(Capabilities.ItemHandler.ITEM);
//			IItemHandler entityHandler = be.getItems();
//
//			if (entityHandler instanceof ItemStackHandler item)
//				for (int i = 0; i < ChocolateBoxBlockEntity.NUM_SLOTS; i++) {
//					item.setStackInSlot(i, handler.getStackInSlot(i));
//				}
//		}
//	}
//
//	@Nullable
//	public static DyeColor getColorFromItem(Item item) {
//		return getColorFromBlock(Block.byItem(item));
//	}
//
//	@Nullable
//	public static DyeColor getColorFromBlock(Block block) {
//		return block instanceof ChocolateBoxBlock ? ((ChocolateBoxBlock) block).getColor() : null;
//	}
//
//	public static Block getBlockByColor(@Nullable DyeColor color) {
//		if (color == null) {
//			return ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get();
//		} else {
//			return switch (color) {
//			case WHITE -> ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get();
//			case ORANGE -> ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get();
//			case MAGENTA -> ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get();
//			case LIGHT_BLUE -> ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get();
//			case YELLOW -> ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get();
//			case LIME -> ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get();
//			case PINK -> ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get();
//			case GRAY -> ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get();
//			case LIGHT_GRAY -> ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get();
//			case CYAN -> ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get();
//			case BLUE -> ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get();
//			case BROWN -> ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get();
//			case GREEN -> ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get();
//			case RED -> ExtraDelightBlocks.RED_CHOCOLATE_BOX.get();
//			case BLACK -> ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get();
//			case PURPLE -> ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get();
//			};
//		}
//	}
//
	@Nullable
	public DyeColor getColor() {
		return this.color;
	}
//
//	public static ItemStack getColoredItemStack(@Nullable DyeColor color) {
//		return new ItemStack(getBlockByColor(color));
//	}

}

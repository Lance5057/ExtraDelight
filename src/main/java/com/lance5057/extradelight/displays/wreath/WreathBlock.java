package com.lance5057.extradelight.displays.wreath;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WreathBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

	protected static final VoxelShape SHAPE_E = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_N = Block.box(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_W = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_S = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);

	public WreathBlock() {
		super(Properties.ofFullCopy(Blocks.ACACIA_LEAVES).strength(2.5F, 6.0F).sound(SoundType.WOOD).noOcclusion()
				.noCollission().lightLevel((p_50763_) -> {
					return p_50763_.getValue(BlockStateProperties.LIT) ? 8 : 0;
				}));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
				.setValue(WATERLOGGED, false).setValue(LIT, false));
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Direction d = pState.getValue(FACING);

		if (d == Direction.EAST)
			return SHAPE_E;
		if (d == Direction.WEST)
			return SHAPE_W;
		if (d == Direction.SOUTH)
			return SHAPE_S;
		return SHAPE_N;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack,BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
			if (player.getItemInHand(hand).getItem() == Items.GLOWSTONE_DUST) {
				if (state.getValue(WreathBlock.LIT) == false) {
					// state.setValue(WreathBlock.ENCASED, true);
					level.setBlock(pos, state.setValue(WreathBlock.LIT, true), 2);
					player.getItemInHand(hand).setCount(player.getItemInHand(hand).getCount() - 1);
					return ItemInteractionResult.SUCCESS;
				}
			} else {
				BlockEntity tileEntity = level.getBlockEntity(pos);
				if (tileEntity instanceof WreathEntity ent) {
					MenuProvider containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable(ent.getDisplayName());
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new WreathMenu(windowId, playerInventory, ent);
						}
					};

					player.openMenu(containerProvider, pos);
				}
			}
		}
		return ItemInteractionResult.SUCCESS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return ExtraDelightBlockEntities.WREATH.get().create(pPos, pState);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, LIT, WATERLOGGED);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		FluidState fluid = level.getFluidState(context.getClickedPos());

		BlockState state = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

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

//	@Override
//	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
//		if (state.getBlock() != newState.getBlock()) {
//			BlockEntity tileentity = level.getBlockEntity(pos);
//			if (tileentity instanceof WreathEntity) {
//				tileentity.getCapability(ForgeCapabilities.ITEM_HANDLER)
//						.ifPresent(itemInteractionHandler -> IntStream.range(0, itemInteractionHandler.getSlots())
//								.forEach(i -> Block.popResource(level, pos, itemInteractionHandler.getStackInSlot(i))));
//
//				level.updateNeighbourForOutputSignal(pos, this);
//			}
//			if (state.getValue(WreathBlock.LIT) == true)
//				Block.popResource(level, pos, new ItemStack(Items.GLOWSTONE_DUST));
//
//			super.onRemove(state, level, pos, newState, isMoving);
//		}
//	}
}

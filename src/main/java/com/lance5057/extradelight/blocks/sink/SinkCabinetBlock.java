package com.lance5057.extradelight.blocks.sink;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public class SinkCabinetBlock extends Block implements EntityBlock {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public SinkCabinetBlock() {
		super(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).dynamicShape());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return ExtraDelightBlockEntities.SINK_BLOCK.get().create(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext p_54041_) {
		Direction direction = p_54041_.getHorizontalDirection().getOpposite();
		return this.defaultBlockState().setValue(FACING, direction);
	}
	
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
	
	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}


	@Override
	public BlockState rotate(BlockState p_54094_, Rotation p_54095_) {
		return p_54094_.setValue(FACING, p_54095_.rotate(p_54094_.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState p_54091_, Mirror p_54092_) {
		return p_54091_.rotate(p_54092_.getRotation(p_54091_.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54097_) {
		p_54097_.add(FACING);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {

		BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
		if (tileEntity instanceof SinkCabinetBlockEntity be) {
			if (!pLevel.isClientSide) {
				ItemStack stack = pPlayer.getItemInHand(pHand);
				IFluidHandlerItem handlerItem = FluidUtil.getFluidHandler(stack).orElse(null);
				if (handlerItem != null) {

					FluidStack f = FluidUtil.getFluidContained(stack).orElse(FluidStack.EMPTY);
					if (f.isEmpty()) {
						FluidActionResult far = FluidUtil.tryFillContainer(stack, be.getFluidHandler(),
								Integer.MAX_VALUE, pPlayer, true);
						if (far.isSuccess()) {
							stack.shrink(1);
							pPlayer.setItemInHand(pHand, stack);
							pPlayer.getInventory().placeItemBackInInventory(far.getResult());
							return InteractionResult.SUCCESS;

						}
					} else {
						FluidActionResult far = FluidUtil.tryEmptyContainer(stack, be.getFluidHandler(),
								Integer.MAX_VALUE, pPlayer, true);
						if (far.isSuccess()) {
							stack.shrink(1);
							pPlayer.setItemInHand(pHand, stack);
							pPlayer.getInventory().placeItemBackInInventory(far.getResult());
							return InteractionResult.SUCCESS;

						}
					}
				} else {
					MenuProvider containerProvider = new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable(be.getDisplayName());
						}

						@Override
						public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory,
								Player playerEntity) {
							return new SinkCabinetMenu(windowId, playerInventory, be);
						}
					};
					pPlayer.openMenu(containerProvider, buf -> buf.writeBlockPos(pPos));
					return InteractionResult.SUCCESS;
				}
			}

		}
		return InteractionResult.CONSUME;

	}
}

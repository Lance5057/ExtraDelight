package com.lance5057.extradelight.workstations.meltingpot;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.state.OvenSupport;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.tag.ModTags;

public class MeltingPotBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<OvenSupport> SUPPORT = EnumProperty.create("support", OvenSupport.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public MeltingPotBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
				.setValue(SUPPORT, OvenSupport.NONE).setValue(WATERLOGGED, false));
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}
	
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
	
	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}
	
	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		FluidState fluid = level.getFluidState(context.getClickedPos());

		BlockState state = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

		if (context.getClickedFace().equals(Direction.DOWN)) {
			return state.setValue(SUPPORT, OvenSupport.HANDLE);
		}
		return state.setValue(SUPPORT, getTrayState(level, pos));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new MeltingPotBlockEntity(p_153215_, p_153216_);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (!pLevel.isClientSide())
			return pBlockEntityType == ExtraDelightBlockEntities.MELTING_POT.get() ? MeltingPotBlockEntity::tick : null;
		return null;
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.isClientSide) {
			return ItemInteractionResult.SUCCESS;
		}
		BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
		if (tileEntity instanceof MeltingPotBlockEntity mbe) {
			MenuProvider containerProvider = new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.translatable("screen.melting_pot.name");
				}

				@Override
				public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
					return new MeltingPotMenu(windowId, playerInventory, mbe);
				}
			};
			pPlayer.openMenu(containerProvider, buf -> buf.writeBlockPos(pPos));

		}
		return ItemInteractionResult.CONSUME;

	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		if (facing.getAxis().equals(Direction.Axis.Y) && !state.getValue(SUPPORT).equals(OvenSupport.HANDLE)) {
			return state.setValue(SUPPORT, getTrayState(level, currentPos));
		}
		return state;
	}

	private OvenSupport getTrayState(LevelAccessor level, BlockPos pos) {
		if (level.getBlockState(pos.below()).is(ModTags.TRAY_HEAT_SOURCES)) {
			return OvenSupport.TRAY;
		}
		return OvenSupport.NONE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, SUPPORT, WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
}

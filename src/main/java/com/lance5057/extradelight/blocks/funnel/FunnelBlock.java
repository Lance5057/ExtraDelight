package com.lance5057.extradelight.blocks.funnel;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FunnelBlock extends BaseEntityBlock {
	public static final MapCodec<FunnelBlock> CODEC = simpleCodec(FunnelBlock::new);
	public static final DirectionProperty FACING = BlockStateProperties.FACING_HOPPER;
	public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
	private static final VoxelShape TOP = Block.box(0.0, 10.0, 0.0, 16.0, 16.0, 16.0);
	private static final VoxelShape FUNNEL = Block.box(4.0, 4.0, 4.0, 12.0, 10.0, 12.0);
	private static final VoxelShape CONVEX_BASE = Shapes.or(FUNNEL, TOP);
	private static final VoxelShape INSIDE = box(2.0, 11.0, 2.0, 14.0, 16.0, 14.0);
	private static final VoxelShape BASE = Shapes.join(CONVEX_BASE, INSIDE, BooleanOp.ONLY_FIRST);
	private static final VoxelShape DOWN_SHAPE = Shapes.or(BASE, Block.box(6.0, 0.0, 6.0, 10.0, 4.0, 10.0));
	private static final VoxelShape EAST_SHAPE = Shapes.or(BASE, Block.box(12.0, 4.0, 6.0, 16.0, 8.0, 10.0));
	private static final VoxelShape NORTH_SHAPE = Shapes.or(BASE, Block.box(6.0, 4.0, 0.0, 10.0, 8.0, 4.0));
	private static final VoxelShape SOUTH_SHAPE = Shapes.or(BASE, Block.box(6.0, 4.0, 12.0, 10.0, 8.0, 16.0));
	private static final VoxelShape WEST_SHAPE = Shapes.or(BASE, Block.box(0.0, 4.0, 6.0, 4.0, 8.0, 10.0));
	private static final VoxelShape DOWN_INTERACTION_SHAPE = INSIDE;
	private static final VoxelShape EAST_INTERACTION_SHAPE = Shapes.or(INSIDE,
			Block.box(12.0, 8.0, 6.0, 16.0, 10.0, 10.0));
	private static final VoxelShape NORTH_INTERACTION_SHAPE = Shapes.or(INSIDE,
			Block.box(6.0, 8.0, 0.0, 10.0, 10.0, 4.0));
	private static final VoxelShape SOUTH_INTERACTION_SHAPE = Shapes.or(INSIDE,
			Block.box(6.0, 8.0, 12.0, 10.0, 10.0, 16.0));
	private static final VoxelShape WEST_INTERACTION_SHAPE = Shapes.or(INSIDE,
			Block.box(0.0, 8.0, 6.0, 4.0, 10.0, 10.0));

	@Override
	public MapCodec<FunnelBlock> codec() {
		return CODEC;
	}

	public FunnelBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(ENABLED, Boolean.valueOf(true)));
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		switch ((Direction) state.getValue(FACING)) {
		case DOWN:
			return DOWN_SHAPE;
		case NORTH:
			return NORTH_SHAPE;
		case SOUTH:
			return SOUTH_SHAPE;
		case WEST:
			return WEST_SHAPE;
		case EAST:
			return EAST_SHAPE;
		default:
			return BASE;
		}
	}

	@Override
	protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
		switch ((Direction) state.getValue(FACING)) {
		case DOWN:
			return DOWN_INTERACTION_SHAPE;
		case NORTH:
			return NORTH_INTERACTION_SHAPE;
		case SOUTH:
			return SOUTH_INTERACTION_SHAPE;
		case WEST:
			return WEST_INTERACTION_SHAPE;
		case EAST:
			return EAST_INTERACTION_SHAPE;
		default:
			return INSIDE;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getClickedFace().getOpposite();
		return this.defaultBlockState()
				.setValue(FACING, direction.getAxis() == Direction.Axis.Y ? Direction.DOWN : direction)
				.setValue(ENABLED, Boolean.valueOf(true));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new FunnelBlockEntity(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> blockEntityType) {
		if (!level.isClientSide())
			return blockEntityType == ExtraDelightBlockEntities.FUNNEL.get() ? FunnelBlockEntity::tick : null;
		return null;
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!oldState.is(state.getBlock())) {
			this.checkPoweredState(level, pos, state);
		}
	}

	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos,
			boolean isMoving) {
		this.checkPoweredState(level, pos, state);
	}

	private void checkPoweredState(Level level, BlockPos pos, BlockState state) {
		boolean flag = !level.hasNeighborSignal(pos);
		if (flag != state.getValue(ENABLED)) {
			level.setBlock(pos, state.setValue(ENABLED, Boolean.valueOf(flag)), 2);
		}
	}
	
	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	protected boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}

	@Override
	protected BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	protected BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, ENABLED);
	}

	@Override
	protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
		return false;
	}
}
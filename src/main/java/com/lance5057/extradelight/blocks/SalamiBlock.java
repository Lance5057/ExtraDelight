package com.lance5057.extradelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SalamiBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty COUNT = BlockStateProperties.AGE_3;

	private static final VoxelShape SINGLE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
	private static final VoxelShape DOUBLE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
	private static final VoxelShape TRIPLE_NS = Block.box(2.0, 0.0, 4.0, 14.0, 16.0, 12.0);
	private static final VoxelShape TRIPLE_EW = Block.box(4.0, 0.0, 2.0, 12.0, 16.0, 14.0);
	private static final VoxelShape QUAD_NS = Block.box(0.0, 0.0, 4.0, 16.0, 16.0, 12.0);
	private static final VoxelShape QUAD_EW = Block.box(4.0, 0.0, 0.0, 12.0, 16.0, 16.0);

	public SalamiBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(COUNT, 0));
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		int count = state.getValue(COUNT);
		if (count == 0)
			return SINGLE;
		if (count == 1)
			return DOUBLE;

		switch ((Direction) state.getValue(FACING)) {

		case NORTH:
		case SOUTH:
			if (count == 2)
				return TRIPLE_NS;
			else
				return QUAD_NS;
		case WEST:
		case EAST:
		default:
			if (count == 2)
				return TRIPLE_EW;
			else
				return QUAD_EW;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, COUNT);
	}
}

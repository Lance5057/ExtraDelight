package com.lance5057.extradelight.displays.spice;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpiceRackBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 6.0D);
	protected static final VoxelShape SHAPE2 = Block.box(0.0D, 0.0D, 0.0D, 6.0D, 16.0D, 16.0D);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SpiceRackBlock() {
		super(Properties.of(Material.WOOD));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Direction d = pState.getValue(FACING);

		if (d == Direction.EAST || d == Direction.WEST)
			return SHAPE;
		return SHAPE2;
	}

	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}
}

package com.lance5057.extradelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StepStoolBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	
	public StepStoolBlock(Properties pProperties) {
		super(Properties.of(Material.WOOD));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}
}
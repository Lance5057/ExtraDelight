package com.lance5057.extradelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;

public class FoodDisplay extends BaseEntityBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public FoodDisplay() {
		super(Properties.of(Material.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN));
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		// TODO Auto-generated method stub
		return null;
	}

}

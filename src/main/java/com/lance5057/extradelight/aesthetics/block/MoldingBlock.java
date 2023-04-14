package com.lance5057.extradelight.aesthetics.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;

public class MoldingBlock extends Block {
	public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;

	public MoldingBlock(BlockBehaviour.Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.defaultBlockState().setValue(HALF, Half.BOTTOM));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(HALF);
	}

	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		//BlockPos blockpos = pContext.getClickedPos();
		//BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
		Direction direction = pContext.getClickedFace();
		return this.defaultBlockState().setValue(HALF, direction == Direction.UP ? Half.BOTTOM : Half.TOP);

	}
}

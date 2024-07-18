package com.lance5057.extradelight.blocks;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorizontalPanBlock extends HorizontalDirectionalBlock {
	public static final MapCodec<HorizontalPanBlock> CODEC = simpleCodec(HorizontalPanBlock::new);
	protected VoxelShape SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
	protected VoxelShape SHAPE2 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 8.0D, 12.0D);

	public HorizontalPanBlock(Properties p_54120_) {
		super(p_54120_);
		SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
		SHAPE2 = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 8.0D, 12.0D);
	}

	public HorizontalPanBlock(Properties p_54120_, VoxelShape SHAPE, VoxelShape SHAPE_2) {
		super(p_54120_);
		this.SHAPE = SHAPE;
		this.SHAPE2 = SHAPE_2;
	}
	
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Direction d = pState.getValue(FACING);

		if (d == Direction.EAST || d == Direction.WEST)
			return SHAPE;
		return SHAPE2;
	}

	@Override
	protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
		return CODEC;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}
	
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
    }
}

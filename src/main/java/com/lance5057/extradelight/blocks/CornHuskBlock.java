package com.lance5057.extradelight.blocks;

import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CornHuskBlock extends HayBlock {

	public CornHuskBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt() % 8 == 0)
			pLevel.setBlock(pPos, ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get().defaultBlockState(),
					Block.UPDATE_ALL);
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return true;
	}

}

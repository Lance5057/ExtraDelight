package com.lance5057.extradelight.blocks.crops;

import com.lance5057.extradelight.ExtraDelightConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MintCrop extends Block {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

	public MintCrop() {
		super(Properties.copy(Blocks.WHEAT).noOcclusion().noCollission().randomTicks().instabreak());
	}

	@Override
	public boolean isRandomlyTicking(BlockState pState) {
		return true;
	}

	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (ExtraDelightConfig.MINT_SPREAD.get()) {
			if (!pLevel.isAreaLoaded(pPos, 1))
				return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			if (pRandom.nextInt() % ExtraDelightConfig.MINT_SPREAD_RATE.get() == 0)
				pLevel.setBlock(findValidSpot(pLevel, pPos), pState, 2);
		}
	}

	public BlockPos findValidSpot(ServerLevel pLevel, BlockPos pPos) {
		int size = 5;
		int attempts = 10;
		for (int x = 0; x < attempts; x++) {
			BlockPos pos = new BlockPos(pPos.getX() + pLevel.random.nextInt(size) - (size / 2),
					pPos.getY() + pLevel.random.nextInt(size) - (size / 2),
					pPos.getZ() + pLevel.random.nextInt(size) - (size / 2));

			if (pPos != pos)
				if (pLevel.getBlockState(pos).isAir())
					if (pLevel.getBlockState(pos.below()).is(BlockTags.DIRT))
						if (pLevel.getRawBrightness(pPos, 0) >= 9) {
							return pos;
						}
		}
		return pPos;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}

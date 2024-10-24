package com.lance5057.extradelight.worldgen.features.crops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.blocks.crops.CoffeeBush;
import com.lance5057.extradelight.worldgen.config.WildConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class WildCoffeeFeature extends Feature<WildConfig> {

	public WildCoffeeFeature() {
		super(WildConfig.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<WildConfig> pContext) {
		WildConfig WildConfig = pContext.config();
		RandomSource randomsource = pContext.random();
		BlockPos blockpos = pContext.origin();
		WorldGenLevel worldgenlevel = pContext.level();
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int j = WildConfig.xzSpread() + 1;
		int k = WildConfig.ySpread() + 1;

		int generated = 0;
		int tryCount = 0;
		int maxCount = randomsource.nextIntBetweenInclusive(WildConfig.minCount(), WildConfig.maxCount());
		while (tryCount < WildConfig.tries() && generated < maxCount) {
			pos.setWithOffset(blockpos, randomsource.nextInt(j) - randomsource.nextInt(j),
					randomsource.nextInt(k) - randomsource.nextInt(k),
					randomsource.nextInt(j) - randomsource.nextInt(j));
			if ((worldgenlevel.isEmptyBlock(pos) || worldgenlevel.getBlockState(pos).is(BlockTags.SNOW))
					&& ExtraDelightBlocks.COFFEE_BUSH.get().defaultBlockState().canSurvive(worldgenlevel, pos)) {
				spawn(worldgenlevel, randomsource, pos);
				++generated;
			}
			++tryCount;
		}

		return generated > 0;
	}

	private List<BlockPos> getAdjacentBlocks(BlockPos blockpos) {
		return new ArrayList<>(Arrays.asList(blockpos.east(), blockpos.west(), blockpos.north(), blockpos.south(),
				blockpos.north().east(), blockpos.north().west(), blockpos.south().east(), blockpos.south().west()));
	}

	private void spawn(LevelAccessor worldIn, RandomSource rand, BlockPos generatingPos) {
		worldIn.setBlock(generatingPos,
				ExtraDelightBlocks.COFFEE_BUSH.get().defaultBlockState().setValue(CoffeeBush.AGE, 3), 2);
	}

}

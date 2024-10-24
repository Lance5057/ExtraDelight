package com.lance5057.extradelight.worldgen.features.crops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;
import com.lance5057.extradelight.worldgen.config.WildConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class WildCornFeature extends Feature<WildConfig> {

	public WildCornFeature() {
		super(WildConfig.CODEC);
		// TODO Auto-generated constructor stub
	}

//	FEATURE_PATCH_WILD_CORN = register(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_corn"),
//	ModBiomeFeatures.WILD_CROP.get(),
//	WildCropGeneration.wildCropConfig(ExtraDelightBlocks.CORN_BOTTOM.get(), Blocks.SHORT_GRASS,
//			BlockPredicate.matchesBlocks(WildCropGeneration.BLOCK_BELOW, List.of(Blocks.GRASS_BLOCK,
//					Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.RED_SAND, Blocks.SAND))));

	@Override
	public boolean place(FeaturePlaceContext<WildConfig> pContext) {
		WildConfig WildCornConfig = pContext.config();
		RandomSource randomsource = pContext.random();
		BlockPos blockpos = pContext.origin();
		WorldGenLevel worldgenlevel = pContext.level();
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int j = WildCornConfig.xzSpread() + 1;
		int k = WildCornConfig.ySpread() + 1;

		int generated = 0;
		int tryCount = 0;
		int maxCount = randomsource.nextIntBetweenInclusive(WildCornConfig.minCount(), WildCornConfig.maxCount());
		while (tryCount < WildCornConfig.tries() && generated < maxCount) {
			pos.setWithOffset(blockpos, randomsource.nextInt(j) - randomsource.nextInt(j),
					randomsource.nextInt(k) - randomsource.nextInt(k),
					randomsource.nextInt(j) - randomsource.nextInt(j));
			if ((worldgenlevel.isEmptyBlock(pos) || worldgenlevel.getBlockState(pos).is(BlockTags.SNOW))
					&& ExtraDelightBlocks.CORN_BOTTOM.get().canSurvive(worldgenlevel.getBlockState(pos), worldgenlevel,
							pos)) {
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
		worldIn.setBlock(generatingPos.above(),
				ExtraDelightBlocks.CORN_TOP.get().defaultBlockState().setValue(CornTop.AGE, 3), 2);
		worldIn.setBlock(generatingPos,
				ExtraDelightBlocks.CORN_BOTTOM.get().defaultBlockState().setValue(CornBottom.AGE, 3), 2);
	}

}

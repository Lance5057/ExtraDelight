package com.lance5057.extradelight.worldgen.features.trees;

import java.util.function.BiConsumer;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

public class CinnamonTreeFeature extends EDBaseTreeFeature {

	public CinnamonTreeFeature() {
		super(TreeConfiguration.CODEC);
	}



	@Override
	public boolean doPlace(WorldGenLevel p_225258_, RandomSource p_225259_, BlockPos p_225260_,
			BiConsumer<BlockPos, BlockState> p_225261_, BiConsumer<BlockPos, BlockState> p_225262_,
			FoliagePlacer.FoliageSetter p_273670_, TreeConfiguration p_225264_) {
		if (!p_225258_.getBlockState(p_225260_.below()).is(BlockTags.DIRT))
			return false;
		
		return super.doPlace(p_225258_, p_225259_, p_225260_, p_225262_, p_225262_, p_273670_, p_225264_);
	}
}

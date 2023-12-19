package com.lance5057.extradelight.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CinnamonTreeGrower extends AbstractTreeGrower {

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
		return ExtraDelightTreeFeatures.CINNAMON.getHolder().get();
	}

} 

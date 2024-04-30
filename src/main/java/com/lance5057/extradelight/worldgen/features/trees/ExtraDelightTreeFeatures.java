package com.lance5057.extradelight.worldgen.features.trees;

import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;

public class ExtraDelightTreeFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = FeatureUtils.createKey("extradelight:cinnamon");

	private static TreeConfiguration.TreeConfigurationBuilder createCinnamonTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
				new BendingTrunkPlacer(2, 0, 0, 6, ConstantInt.of(1)),
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
				new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
				new TwoLayersFeatureSize(1, 0, 2));
	}
	
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_256317_) {
		 FeatureUtils.register(p_256317_, CINNAMON, Feature.TREE, createCinnamonTree().build());
	}
}
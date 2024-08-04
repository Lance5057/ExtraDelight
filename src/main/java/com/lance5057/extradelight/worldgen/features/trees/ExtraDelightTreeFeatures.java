package com.lance5057.extradelight.worldgen.features.trees;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;

public class ExtraDelightTreeFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cinnamon"));// FeatureUtils.createKey("extradelight:cinnamon");

	public static TreeConfiguration.TreeConfigurationBuilder createCinnamonTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
				new BendingTrunkPlacer(2, 0, 10, 6, ConstantInt.of(1)),
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
				new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
				new TwoLayersFeatureSize(1, 0, 2));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> p_256317_) {
		FeatureUtils.register(p_256317_, CINNAMON, Feature.TREE, createCinnamonTree().build());
	}
}

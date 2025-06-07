package com.lance5057.extradelight.worldgen.features.trees;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.modules.SummerCitrus;
import com.lance5057.extradelight.worldgen.placers.FruitLeafPlacer;

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
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ExtraDelightTreeFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cinnamon"));

	public static TreeConfiguration.TreeConfigurationBuilder createCinnamonTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
				new StraightTrunkPlacer(4, 2, 2),
				BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
				new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 2));
	}

	public static final ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "hazelnut"));

	public static TreeConfiguration.TreeConfigurationBuilder createHazelnutTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.FRUIT_LOG.get()), new StraightTrunkPlacer(4, 0, 2),
				BlockStateProvider.simple(ExtraDelightBlocks.HAZELNUT_LEAVES.get()),
				new FruitLeafPlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 2, 1));
	}

	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "apple"));

	public static TreeConfiguration.TreeConfigurationBuilder createAppleTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.FRUIT_LOG.get()), new StraightTrunkPlacer(4, 0, 2),
				BlockStateProvider.simple(ExtraDelightBlocks.APPLE_LEAVES.get()),
				new FruitLeafPlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(3, 2, 3));
	}

	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON = ResourceKey.create(Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "lemon"));

	public static TreeConfiguration.TreeConfigurationBuilder createLemonTree() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ExtraDelightBlocks.FRUIT_LOG.get()), new StraightTrunkPlacer(3, 0, 2),
				BlockStateProvider.simple(SummerCitrus.LEMON_LEAVES.get()),
				new FruitLeafPlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(3, 2, 3));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> p_256317_) {
		FeatureUtils.register(p_256317_, CINNAMON, Feature.TREE, createCinnamonTree().build());
		FeatureUtils.register(p_256317_, HAZELNUT, Feature.TREE, createHazelnutTree().build());
		FeatureUtils.register(p_256317_, APPLE, Feature.TREE, createAppleTree().build());
		FeatureUtils.register(p_256317_, LEMON, Feature.TREE, createLemonTree().build());
	}
}

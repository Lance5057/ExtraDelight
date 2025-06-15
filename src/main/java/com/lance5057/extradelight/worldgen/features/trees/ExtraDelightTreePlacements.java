package com.lance5057.extradelight.worldgen.features.trees;

import java.util.List;

import com.lance5057.extradelight.ExtraDelightBlocks;

import com.lance5057.extradelight.modules.SummerCitrus;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ExtraDelightTreePlacements {
	public static final ResourceKey<PlacedFeature> CINNAMON_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("cinnamon");
	public static final ResourceKey<PlacedFeature> HAZELNUT_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("hazelnut");
	public static final ResourceKey<PlacedFeature> APPLE_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("apple");
	public static final ResourceKey<PlacedFeature> LEMON_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("lemon");
	public static final ResourceKey<PlacedFeature> LIME_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("lime");
	public static final ResourceKey<PlacedFeature> ORANGE_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("orange");
	public static final ResourceKey<PlacedFeature> GRAPEFRUIT_TREE_CHECKED = ExtraDelightTreePlacement
			.createKey("grapefruit");

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

		final Holder<ConfiguredFeature<?, ?>> CINNAMON_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.CINNAMON);
		final Holder<ConfiguredFeature<?, ?>> HAZELNUT_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.HAZELNUT);
		final Holder<ConfiguredFeature<?, ?>> APPLE_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.APPLE);
		final Holder<ConfiguredFeature<?, ?>> LEMON_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.LEMON);
		final Holder<ConfiguredFeature<?, ?>> LIME_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.LIME);
		final Holder<ConfiguredFeature<?, ?>> ORANGE_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.ORANGE);
		final Holder<ConfiguredFeature<?, ?>> GRAPEFRUIT_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.GRAPEFRUIT);

		context.register(CINNAMON_TREE_CHECKED, new PlacedFeature(CINNAMON_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));

		context.register(HAZELNUT_TREE_CHECKED, new PlacedFeature(HAZELNUT_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.HAZELNUT_SAPLING.get()))));

		context.register(APPLE_TREE_CHECKED, new PlacedFeature(APPLE_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.APPLE_SAPLING.get()))));

		context.register(LEMON_TREE_CHECKED, new PlacedFeature(LEMON_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(SummerCitrus.LEMON_SAPLING.get()))));

		context.register(LIME_TREE_CHECKED, new PlacedFeature(LIME_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(SummerCitrus.LIME_SAPLING.get()))));

		context.register(ORANGE_TREE_CHECKED, new PlacedFeature(ORANGE_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(SummerCitrus.ORANGE_SAPLING.get()))));

		context.register(GRAPEFRUIT_TREE_CHECKED, new PlacedFeature(GRAPEFRUIT_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(SummerCitrus.GRAPEFRUIT_SAPLING.get()))));
	}
}

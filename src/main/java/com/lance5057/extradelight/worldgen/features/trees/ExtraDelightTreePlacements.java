package com.lance5057.extradelight.worldgen.features.trees;

import java.util.List;

import com.lance5057.extradelight.ExtraDelightBlocks;

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

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

		final Holder<ConfiguredFeature<?, ?>> CINNAMON_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.CINNAMON);
		final Holder<ConfiguredFeature<?, ?>> HAZELNUT_TREE = configuredFeatureGetter
				.getOrThrow(ExtraDelightTreeFeatures.HAZELNUT);

		context.register(CINNAMON_TREE_CHECKED, new PlacedFeature(CINNAMON_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));

		context.register(HAZELNUT_TREE_CHECKED, new PlacedFeature(HAZELNUT_TREE,
				List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.HAZELNUT_SAPLING.get()))));
	}
}

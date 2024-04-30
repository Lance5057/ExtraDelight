package com.lance5057.extradelight.worldgen.features.trees;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ExtraDelightTreePlacement {

//	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister
//			.create(Registry.PLACED_FEATURE_REGISTRY, ExtraDelight.MOD_ID);

//	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON = FeatureUtils.register("cinnamon",
//			Feature.TREE,
//			(new TreeConfiguration.TreeConfigurationBuilder(
//					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
//					new BendingTrunkPlacer(3, 0, 0, 6, ConstantInt.of(1)),
//					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
//					new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
//					new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());

//	public static final DeferredHolder<PlacedFeature, PlacedFeature> CINNAMON_CHECKED = PLACED_FEATURES.register(
//			"cinnamon_checked", () -> new PlacedFeature(ExtraDelightConfiguredFeatures.CINNAMON.getHolder().get(),
//					List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));
//
//	public static final DeferredHolder<PlacedFeature, PlacedFeature> CINNAMON_PLACED = PLACED_FEATURES.register(
//			"cinnamon_placed", () -> new PlacedFeature(ExtraDelightConfiguredFeatures.CINNAMON_SPAWN.getHolder().get(),
//					VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		ExtraDelightTreePlacements.bootstrap(context);
	}

	public static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ExtraDelight.MOD_ID, name));
	}
}

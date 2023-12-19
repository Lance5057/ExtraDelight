package com.lance5057.extradelight.worldgen.features;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightTreeFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister
			.create(Registry.CONFIGURED_FEATURE_REGISTRY, ExtraDelight.MOD_ID);

	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister
			.create(Registry.PLACED_FEATURE_REGISTRY, ExtraDelight.MOD_ID);

//	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON = FeatureUtils.register("cinnamon",
//			Feature.TREE,
//			(new TreeConfiguration.TreeConfigurationBuilder(
//					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
//					new BendingTrunkPlacer(3, 0, 0, 6, ConstantInt.of(1)),
//					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
//					new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
//					new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());

	public static final RegistryObject<ConfiguredFeature<?, ?>> CINNAMON = CONFIGURED_FEATURES
			.register("cinnamon",
					() -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
							BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
							new BendingTrunkPlacer(2, 0, 0, 6, ConstantInt.of(1)),
							BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
							new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
							new TwoLayersFeatureSize(1, 0, 2)).build()));
//
//	public static final RegistryObject<PlacedFeature> CINNAMON_CHECKED = PLACED_FEATURES.register("cinnamon_checked",
//			() -> new PlacedFeature(CINNAMON.getHolder().get(),
//					List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));
//
//	public static final RegistryObject<ConfiguredFeature<?, ?>> CINNAMON_SPAWN = CONFIGURED_FEATURES.register(
//			"cinnamon_spawn",
//			() -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
//					new RandomFeatureConfiguration(
//							List.of(new WeightedPlacedFeature(CINNAMON_CHECKED.getHolder().get(), 0.5F)),
//							CINNAMON_CHECKED.getHolder().get())));
//
//	public static final RegistryObject<PlacedFeature> CINNAMON_PLACED = PLACED_FEATURES.register("cinnamon_placed",
//			() -> new PlacedFeature(CINNAMON_SPAWN.getHolder().get(),
//					VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));

	public static void register(IEventBus eventBus) {
		CONFIGURED_FEATURES.register(eventBus);
		PLACED_FEATURES.register(eventBus);
	}
}

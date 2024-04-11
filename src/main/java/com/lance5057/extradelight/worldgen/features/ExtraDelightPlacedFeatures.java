//package com.lance5057.extradelight.worldgen.features;
//
//import java.util.List;
//
//import com.lance5057.extradelight.ExtraDelight;
//import com.lance5057.extradelight.ExtraDelightBlocks;
//
//import net.minecraft.core.Registry;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.data.worldgen.placement.VegetationPlacements;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraftforge.registries.RegistryObject;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.registries.DeferredRegister;
//
//public class ExtraDelightPlacedFeatures {
//
//
//	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister
//			.create(Registry.PLACED_FEATURE_REGISTRY, ExtraDelight.MOD_ID);
//
////	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON = FeatureUtils.register("cinnamon",
////			Feature.TREE,
////			(new TreeConfiguration.TreeConfigurationBuilder(
////					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
////					new BendingTrunkPlacer(3, 0, 0, 6, ConstantInt.of(1)),
////					BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
////					new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(2), 12),
////					new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
//
//	public static final RegistryObject<PlacedFeature> CINNAMON_CHECKED = PLACED_FEATURES.register("cinnamon_checked",
//			() -> new PlacedFeature(ExtraDelightConfiguredFeatures.CINNAMON.getHolder().get(),
//					List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));
//
//	public static final RegistryObject<PlacedFeature> CINNAMON_PLACED = PLACED_FEATURES.register("cinnamon_placed",
//			() -> new PlacedFeature(ExtraDelightConfiguredFeatures.CINNAMON_SPAWN.getHolder().get(),
//					VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));
//
//	public static void register(IEventBus eventBus) {
//		PLACED_FEATURES.register(eventBus);
//	}
//}

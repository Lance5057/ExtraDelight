package com.lance5057.extradelight.worldgen.generation;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.WildCropGeneration;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;

public class CropGeneration {
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_CORN;
	public static Holder<PlacedFeature> PATCH_WILD_CORN;
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GINGER;
	public static Holder<PlacedFeature> PATCH_WILD_GINGER;

	public static void registerWildCropGeneration() {
		FEATURE_PATCH_WILD_CORN = register(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_corn"),
				ModBiomeFeatures.WILD_CROP.get(),
				WildCropGeneration.wildCropConfig(ExtraDelightBlocks.CORN_BOTTOM.get(), Blocks.GRASS,
						BlockPredicate.matchesBlocks(WildCropGeneration.BLOCK_BELOW, List.of(Blocks.GRASS_BLOCK,
								Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.RED_SAND, Blocks.SAND))));

		PATCH_WILD_CORN = registerPlacement(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_corn"),
				FEATURE_PATCH_WILD_CORN, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP, BiomeFilter.biome()); // TODO config

		FEATURE_PATCH_WILD_GINGER = register(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_ginger"),
				ModBiomeFeatures.WILD_CROP.get(),
				WildCropGeneration.wildCropConfig(ExtraDelightBlocks.GINGER_CROP.get(), Blocks.GRASS,
						BlockPredicate.matchesBlocks(WildCropGeneration.BLOCK_BELOW, List.of(Blocks.GRASS_BLOCK,
								Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.RED_SAND, Blocks.SAND))));

		PATCH_WILD_GINGER = registerPlacement(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_ginger"),
				FEATURE_PATCH_WILD_GINGER, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP, BiomeFilter.biome()); // TODO config
	}

	static Holder<PlacedFeature> registerPlacement(ResourceLocation id,
			Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id,
				new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
	}

	protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(
			ResourceLocation id, F feature, FC featureConfig) {
		return register(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, featureConfig));
	}

	private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
		return (Holder<V>) BuiltinRegistries.<T>register(registry, id, value);
	}
}

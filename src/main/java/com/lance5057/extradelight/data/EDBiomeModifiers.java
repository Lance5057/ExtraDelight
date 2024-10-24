package com.lance5057.extradelight.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.worldgen.config.WildConfig;
import com.lance5057.extradelight.worldgen.features.ExtraDelightFeatures;
import com.lance5057.extradelight.worldgen.features.trees.ExtraDelightTreeFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EDBiomeModifiers extends BaseDatapackRegistryProvider {

	protected EDBiomeModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, ExtraDelight.MOD_ID);
	}

	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
				HolderSet.Named<Biome> plains = context.lookup(Registries.BIOME).getOrThrow(Tags.Biomes.IS_PLAINS);
				HolderSet.Named<Biome> jungle = context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_JUNGLE);
				HolderSet.Named<Biome> forest = context.lookup(Registries.BIOME).getOrThrow(Tags.Biomes.IS_FOREST);
				HolderSet.Named<Biome> hot = context.lookup(Registries.BIOME).getOrThrow(Tags.Biomes.IS_HOT);
				HolderSet.Named<Biome> swamp = context.lookup(Registries.BIOME).getOrThrow(Tags.Biomes.IS_SWAMP);
				HolderSet.Named<Biome> cold = context.lookup(Registries.BIOME).getOrThrow(Tags.Biomes.IS_COLD);
				
				// Corn
				HolderSet.Direct<PlacedFeature> wildCornHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_CORN.get(),
								new WildConfig(120, 250, 12, 25, 256))),
						List.of(RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_corn")),
						new BiomeModifiers.AddFeaturesBiomeModifier(plains, wildCornHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Coffee
				HolderSet.Direct<PlacedFeature> wildCoffeeHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_COFFEE.get(),
								new WildConfig(10, 100, 10, 5, 256))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_coffee")),
						new BiomeModifiers.AddFeaturesBiomeModifier(jungle, wildCoffeeHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Ginger
				HolderSet.Direct<PlacedFeature> wildGingerHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_GINGER.get(),
								new WildConfig(2, 5, 2, 5, 128))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_ginger")),
						new BiomeModifiers.AddFeaturesBiomeModifier(jungle, wildGingerHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Chili
				HolderSet.Direct<PlacedFeature> wildChiliHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_CHILI.get(),
								new WildConfig(2, 5, 2, 5, 128))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_chili")),
						new BiomeModifiers.AddFeaturesBiomeModifier(hot, wildChiliHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Peanut
				HolderSet.Direct<PlacedFeature> wildPeanutHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_PEANUT.get(),
								new WildConfig(10, 100, 10, 5, 256))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_peanut")),
						new BiomeModifiers.AddFeaturesBiomeModifier(jungle, wildPeanutHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Mallow
				HolderSet.Direct<PlacedFeature> wildMallowHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_MALLOW.get(),
								new WildConfig(20, 100, 10, 5, 256))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_mallow")),
						new BiomeModifiers.AddFeaturesBiomeModifier(swamp, wildMallowHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));
				
				// Mint
				HolderSet.Direct<PlacedFeature> wildMintHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_MINT.get(),
								new WildConfig(20, 100, 10, 5, 256))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "patch_wild_mint")),
						new BiomeModifiers.AddFeaturesBiomeModifier(cold, wildMintHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Cinnamon

				HolderSet.Direct<PlacedFeature> cinnamonTreeHolderSet = HolderSet
						.direct(Holder.direct(new PlacedFeature(
								Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_CINNAMON_TREE.get(),
										ExtraDelightTreeFeatures.createCinnamonTree().build())),
								List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(),
										HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
										BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cinnamon_tree")),
						new BiomeModifiers.AddFeaturesBiomeModifier(jungle, cinnamonTreeHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));

				// Hazelnut

				HolderSet.Direct<PlacedFeature> hazelnutTreeHolderSet = HolderSet
						.direct(Holder.direct(new PlacedFeature(
								Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_HAZELNUT_TREE.get(),
										ExtraDelightTreeFeatures.createHazelnutTree().build())),
								List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
										HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
										BiomeFilter.biome()))));

				context.register(
						biomeModifier(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "hazelnut_tree")),
						new BiomeModifiers.AddFeaturesBiomeModifier(forest, hazelnutTreeHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));
			});
}

package com.lance5057.extradelight.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.worldgen.config.WildCornConfig;
import com.lance5057.extradelight.worldgen.features.ExtraDelightFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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

//            	PATCH_WILD_CORN = registerPlacement(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_corn"),
//            	FEATURE_PATCH_WILD_CORN, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
//            	PlacementUtils.HEIGHTMAP, BiomeFilter.biome()); // TODO config

				HolderSet.Direct<PlacedFeature> wildCornHolderSet = HolderSet.direct(Holder.direct(new PlacedFeature(
						Holder.direct(new ConfiguredFeature<>(ExtraDelightFeatures.PATCH_WILD_CORN.get(),
								new WildCornConfig(2, 5, 2, 5, 128))),
						List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
								HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
								BiomeFilter.biome()))));

				context.register(biomeModifier(new ResourceLocation(ExtraDelight.MOD_ID, "patch_wild_corn")),
						new BiomeModifiers.AddFeaturesBiomeModifier(plains, wildCornHolderSet,
								GenerationStep.Decoration.VEGETAL_DECORATION));
			});
}

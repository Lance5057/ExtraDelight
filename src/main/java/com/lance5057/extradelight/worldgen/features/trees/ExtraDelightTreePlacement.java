package com.lance5057.extradelight.worldgen.features.trees;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ExtraDelightTreePlacement {

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		ExtraDelightTreePlacements.bootstrap(context);
	}

	public static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, name));
	}
}

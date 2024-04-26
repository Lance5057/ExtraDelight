package com.lance5057.extradelight;

import java.util.function.Supplier;

import com.lance5057.extradelight.worldgen.features.CornMazeFeature;
import com.lance5057.extradelight.worldgen.features.CornMazeRail;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightWorldGen {
	public static final ResourceKey<Level> CORNFIELD = ResourceKey.create(Registries.DIMENSION,
			new ResourceLocation(ExtraDelight.MOD_ID, "corn_dimension"));

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE,
			ExtraDelight.MOD_ID);

	public static final Supplier<CornMazeFeature> CORN_MAZE = FEATURES.register("corn_maze_feature",
			() -> new CornMazeFeature(SimpleBlockConfiguration.CODEC));
	public static final Supplier<CornMazeRail> CORN_MAZE_RAIL = FEATURES.register("corn_rail_feature",
			() -> new CornMazeRail(SimpleBlockConfiguration.CODEC));
}

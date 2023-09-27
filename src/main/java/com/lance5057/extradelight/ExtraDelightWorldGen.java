package com.lance5057.extradelight;
import com.lance5057.extradelight.worldgen.features.CornMazeFeature;
import com.lance5057.extradelight.worldgen.features.CornMazeRail;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightWorldGen {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			ExtraDelight.MOD_ID);
	
	public static final RegistryObject<CornMazeFeature> CORN_MAZE = FEATURES.register("corn_maze_feature",
			() -> new CornMazeFeature(SimpleBlockConfiguration.CODEC));
	public static final RegistryObject<CornMazeRail> CORN_MAZE_RAIL = FEATURES.register("corn_rail_feature",
			() -> new CornMazeRail(SimpleBlockConfiguration.CODEC));
}

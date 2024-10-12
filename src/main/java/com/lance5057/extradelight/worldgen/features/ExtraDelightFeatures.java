package com.lance5057.extradelight.worldgen.features;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.worldgen.features.trees.CinnamonTreeFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightFeatures {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
			ExtraDelight.MOD_ID);

	public static final DeferredHolder<Feature<?>, WildCornFeature> PATCH_WILD_CORN = FEATURES.register("wild_corn",
			WildCornFeature::new);
	public static final DeferredHolder<Feature<?>, WildGingerFeature> PATCH_WILD_GINGER = FEATURES
			.register("wild_ginger", WildGingerFeature::new);

	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_CINNAMON_TREE = FEATURES
			.register("cinnamon_tree", CinnamonTreeFeature::new);

	public static final DeferredHolder<Feature<?>, CornMazeFeature> CORN_MAZE_FEATURE = FEATURES
			.register("corn_maze_feature", CornMazeFeature::new);
	public static final DeferredHolder<Feature<?>, CornMazeRail> CORN_RAIL_FEATURE = FEATURES
			.register("corn_rail_feature", CornMazeRail::new);
}

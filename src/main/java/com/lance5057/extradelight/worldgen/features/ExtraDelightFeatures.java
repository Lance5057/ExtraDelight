package com.lance5057.extradelight.worldgen.features;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.worldgen.features.crops.WildChiliFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildCoffeeFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildCornFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildGingerFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildMallowFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildMintFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildPeanutFeature;
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
	public static final DeferredHolder<Feature<?>, WildCoffeeFeature> PATCH_WILD_COFFEE = FEATURES
			.register("wild_coffee", WildCoffeeFeature::new);
	public static final DeferredHolder<Feature<?>, WildChiliFeature> PATCH_WILD_CHILI = FEATURES.register("wild_chili",
			WildChiliFeature::new);
	public static final DeferredHolder<Feature<?>, WildMallowFeature> PATCH_WILD_MALLOW = FEATURES
			.register("wild_mallow", WildMallowFeature::new);
	public static final DeferredHolder<Feature<?>, WildPeanutFeature> PATCH_WILD_PEANUT = FEATURES
			.register("wild_peanut", WildPeanutFeature::new);
	public static final DeferredHolder<Feature<?>, WildMintFeature> PATCH_WILD_MINT = FEATURES
			.register("wild_mint", WildMintFeature::new);

	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_CINNAMON_TREE = FEATURES
			.register("cinnamon_tree", CinnamonTreeFeature::new);
	
	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_HAZELNUT_TREE = FEATURES
			.register("hazelnut_tree", CinnamonTreeFeature::new);

	public static final DeferredHolder<Feature<?>, CornMazeFeature> CORN_MAZE_FEATURE = FEATURES
			.register("corn_maze_feature", CornMazeFeature::new);
	public static final DeferredHolder<Feature<?>, CornMazeRail> CORN_RAIL_FEATURE = FEATURES
			.register("corn_rail_feature", CornMazeRail::new);
}

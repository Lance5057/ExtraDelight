package com.lance5057.extradelight.worldgen.features;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.worldgen.features.crops.WildBushStageFourFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildCornFeature;
import com.lance5057.extradelight.worldgen.features.crops.WildCropFeature;
import com.lance5057.extradelight.worldgen.features.trees.CinnamonTreeFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightFeatures {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
			ExtraDelight.MOD_ID);

	public static final DeferredHolder<Feature<?>, WildCornFeature> PATCH_WILD_CORN = FEATURES.register("wild_corn",
			WildCornFeature::new);
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_GINGER = FEATURES
			.register("wild_ginger", (ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.WILD_GINGER.get()));
	public static final DeferredHolder<Feature<?>, WildBushStageFourFeature> PATCH_WILD_COFFEE = FEATURES
			.register("wild_coffee", (ResourceLocation bush) -> new WildBushStageFourFeature(ExtraDelightBlocks.COFFEE_BUSH.get()));
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_CHILI = FEATURES.register("wild_chili",
			(ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.WILD_CHILI.get()));
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_MALLOW = FEATURES
			.register("wild_mallow", (ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.WILD_MALLOW_ROOT.get()));
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_PEANUT = FEATURES
			.register("wild_peanut", (ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.WILD_PEANUT.get()));
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_MINT = FEATURES
			.register("wild_mint", (ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.MINT_CROP.get()));
	public static final DeferredHolder<Feature<?>, WildCropFeature> PATCH_WILD_GARLIC = FEATURES
			.register("wild_garlic", (ResourceLocation crop) -> new WildCropFeature(ExtraDelightBlocks.WILD_GARLIC.get()));

	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_CINNAMON_TREE = FEATURES
			.register("cinnamon_tree", CinnamonTreeFeature::new);
	
	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_HAZELNUT_TREE = FEATURES
			.register("hazelnut_tree", CinnamonTreeFeature::new);

	public static final DeferredHolder<Feature<?>, CinnamonTreeFeature> PATCH_APPLE_TREE = FEATURES
			.register("apple_tree", CinnamonTreeFeature::new);

	public static final DeferredHolder<Feature<?>, CornMazeFeature> CORN_MAZE_FEATURE = FEATURES
			.register("corn_maze_feature", CornMazeFeature::new);
	public static final DeferredHolder<Feature<?>, CornMazeRail> CORN_RAIL_FEATURE = FEATURES
			.register("corn_rail_feature", CornMazeRail::new);
}

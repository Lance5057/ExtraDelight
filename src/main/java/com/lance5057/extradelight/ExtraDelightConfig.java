package com.lance5057.extradelight;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ExtraDelightConfig {
	public static ForgeConfigSpec spec;

	public static final String CATEGORY_RECIPE_BOOK = "recipe_book";
	public static ForgeConfigSpec.BooleanValue ENABLE_RECIPE_BOOK_OVEN;

	static {
		ForgeConfigSpec.Builder Builder = new ForgeConfigSpec.Builder();

		Builder.comment("Recipe book").push(CATEGORY_RECIPE_BOOK);
		ENABLE_RECIPE_BOOK_OVEN = Builder.comment("(Broken!) Should the Oven have a Recipe Book available on its interface?")
				.define("enableRecipeBookOven", false);
		Builder.pop();

		spec = Builder.build();
	}
}

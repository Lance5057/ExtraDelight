package com.lance5057.extradelight;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ExtraDelightConfig {
	public static ForgeConfigSpec spec;

	public static final String CATEGORY_RECIPE_BOOK = "recipe_book";
	public static ForgeConfigSpec.BooleanValue ENABLE_RECIPE_BOOK_OVEN;

	public static final String CATEGORY_MINT_SPREAD = "mint_spread";
	public static ForgeConfigSpec.BooleanValue MINT_SPREAD;
	public static ForgeConfigSpec.IntValue MINT_SPREAD_RATE;

	static {
		ForgeConfigSpec.Builder Builder = new ForgeConfigSpec.Builder();

		Builder.comment("Recipe book").push(CATEGORY_RECIPE_BOOK);
		ENABLE_RECIPE_BOOK_OVEN = Builder.comment("Should the Oven have a Recipe Book available on its interface?")
				.define("enableRecipeBookOven", false);
		Builder.pop();

		Builder.comment("Mint").push(CATEGORY_MINT_SPREAD);
		MINT_SPREAD = Builder.comment("Should mint spread?").define("shouldMintSpread", true);

		MINT_SPREAD_RATE = Builder.comment("How fast should mint spread? (Higher number = Slower)")
				.defineInRange("mintSpreadRate", 6, 1, 100);
		Builder.pop();

		spec = Builder.build();
	}
}

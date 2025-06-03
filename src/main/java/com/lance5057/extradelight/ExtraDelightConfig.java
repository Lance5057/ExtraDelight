package com.lance5057.extradelight;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ExtraDelightConfig {
	public static ModConfigSpec spec;

	public static final String DEBUG = "debug";
	public static ModConfigSpec.BooleanValue ENABLE_DEBUG_MODE;
	
	public static final String CATEGORY_RECIPE_BOOK = "recipe_book";
	public static ModConfigSpec.BooleanValue ENABLE_RECIPE_BOOK_OVEN;

	public static final String CATEGORY_MINT_SPREAD = "mint_spread";
	public static ModConfigSpec.BooleanValue MINT_SPREAD;
	public static ModConfigSpec.IntValue MINT_SPREAD_RATE;
	
	public static final String CATEGORY_SPOOKY = "spooky";
	public static ModConfigSpec.BooleanValue ALL_YEAR;

	static {
		ModConfigSpec.Builder Builder = new ModConfigSpec.Builder();

		Builder.comment("Debug Mode").push(DEBUG);
		ENABLE_DEBUG_MODE = Builder.comment("Enable Debug Mode for Developement")
				.define("enableDebug", false);
		Builder.pop();
		
		Builder.comment("Recipe book").push(CATEGORY_RECIPE_BOOK);
		ENABLE_RECIPE_BOOK_OVEN = Builder.comment("Should the Oven have a Recipe Book available on its interface?")
				.define("enableRecipeBookOven", false);
		Builder.pop();

		Builder.comment("Mint").push(CATEGORY_MINT_SPREAD);
		MINT_SPREAD = Builder.comment("Should mint spread?").define("shouldMintSpread", true);

		MINT_SPREAD_RATE = Builder.comment("How fast should mint spread? (Higher number = Slower)")
				.defineInRange("mintSpreadRate", 6, 1, 100);
		Builder.pop();
		
		Builder.comment("Spooky Things").push(CATEGORY_SPOOKY);
		ALL_YEAR = Builder.comment("All Year Spooky").define("allYearSpooky", false);
		Builder.pop();

		spec = Builder.build();
	}
}

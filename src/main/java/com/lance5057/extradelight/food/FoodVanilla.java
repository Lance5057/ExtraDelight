package com.lance5057.extradelight.food;

import net.minecraft.world.food.FoodProperties;

public class FoodVanilla {
	public static final FoodProperties CUPCAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f)
			.build();
	public static final FoodProperties WHIPPED_CREAM = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.1f)
			.build();
}

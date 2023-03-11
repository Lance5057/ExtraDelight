package com.lance5057.extradelight.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodVanilla {
	public static final FoodProperties CUPCAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f)
			.build();
	public static final FoodProperties WHIPPED_CREAM = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.1f)
			.build();
	public static final FoodProperties EDIBLE_SEEDS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1f)
			.build();
	public static final FoodProperties SLICED_BREAD = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.12f)
			.build();

	// eggs
	public static final FoodProperties BAD_EGG = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.0f)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 10), 75).build();
	public static final FoodProperties SCRAMBLED_EGGS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4f)
			.build();
	public static final FoodProperties OMELETTE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f)
			.build();

	// Condiments
	public static final FoodProperties KETCHUP = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F)
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties MAYO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F)
			.alwaysEat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties BBQ = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
}

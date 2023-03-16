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

	public static final FoodProperties JAM_BREAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f)
			.build();
	public static final FoodProperties GOLDEN_JAM_BREAD = (new FoodProperties.Builder()).nutrition(4)
			.saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

	public static final FoodProperties COOKED_CARROT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4f)
			.build();
	public static final FoodProperties COOKED_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f)
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

	public static final FoodProperties SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat()
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
	public static final FoodProperties COOKED_SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();

	public static final FoodProperties STOCK = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.0F).build();
	public static final FoodProperties GRAVY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();

	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();

	public static final FoodProperties SAUSAGE_ROLL = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F)
			.build();
	public static final FoodProperties SOS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
	public static final FoodProperties LIVERONION = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F)
			.build();
	public static final FoodProperties CHICKEN_FRIED_STEAK = (new FoodProperties.Builder()).nutrition(8)
			.saturationMod(1F).build();
	public static final FoodProperties STUFFED_HEART = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F)
			.build();
	public static final FoodProperties FRIED_BRAIN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F)
			.build();
	public static final FoodProperties GRILLED_CHEESE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.75F)
			.build();

	public static final FoodProperties POTATO_GRAVY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F)
			.build();
	public static final FoodProperties STIRFRY = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F).build();
	public static final FoodProperties WELLINGTON = (new FoodProperties.Builder()).nutrition(12).saturationMod(1F)
			.build();
	public static final FoodProperties HAGGIS = (new FoodProperties.Builder()).nutrition(8).saturationMod(1F).build();

	public static final FoodProperties JELLY = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.2F)
			.alwaysEat().build();

	public static final FoodProperties RIBS = (new FoodProperties.Builder()).nutrition(13).saturationMod(1.2F).meat()
			.build();
	public static final FoodProperties JERKY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat()
			.fast().alwaysEat().build();
}

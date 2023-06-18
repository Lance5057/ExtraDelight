package com.lance5057.extradelight.food;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.food.Foods;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class EDFoods {

	public static final Supplier<MobEffectInstance> GOLDEN_APPLE_1 = () -> new MobEffectInstance(
			MobEffects.REGENERATION, 100, 1);
	public static final Supplier<MobEffectInstance> GOLDEN_APPLE_2 = () -> new MobEffectInstance(MobEffects.ABSORPTION,
			2400, 0);

	public static final Supplier<MobEffectInstance> HUNGER = () -> new MobEffectInstance(MobEffects.HUNGER, 600, 0);
	public static final Supplier<MobEffectInstance> ROT = () -> new MobEffectInstance(MobEffects.CONFUSION,
			FoodValues.SHORT_DURATION, 0);

	public static final Supplier<MobEffectInstance> JUMP_BRIEF = () -> new MobEffectInstance(MobEffects.JUMP,
			FoodValues.BRIEF_DURATION, 0);

	public static final FoodProperties CUSTARD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6f)
			.alwaysEat().build();
	public static final FoodProperties WHIPPED_CREAM = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.1f)
			.build();
	public static final FoodProperties EDIBLE_SEEDS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1f)
			.build();

	public static final FoodProperties JAM_BREAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f)
			.build();
	public static final FoodProperties GOLDEN_JAM_BREAD = (new FoodProperties.Builder()).nutrition(4)
			.saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
			.effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();

	public static final FoodProperties COOKED_CARROT = EDFoods.cookFood("cooked carrot", Foods.CARROT).build();
	public static final FoodProperties COOKED_APPLE = EDFoods.cookFood("cooked apple", Foods.APPLE).build();

	// eggs
	public static final FoodProperties SCRAMBLED_EGGS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4f)
			.build();
	public static final FoodProperties OMELETTE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f)
			.build();

	// Condiments
	public static final FoodProperties KETCHUP = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F)
			.alwaysEat().effect(HUNGER, 0.3F).build();
	public static final FoodProperties MAYO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F)
			.alwaysEat().effect(HUNGER, 0.3F).build();
	public static final FoodProperties BBQ = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).alwaysEat()
			.effect(HUNGER, 0.3F).build();

	public static final FoodProperties GRAVY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();

	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F)
			.effect(HUNGER, 0.3F).build();

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

	public static final FoodProperties CHEESE_SANDWICH = (new FoodProperties.Builder()).nutrition(6)
			.saturationMod(0.65F).build();
	public static final FoodProperties GRILLED_CHEESE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.75F)
			.build();

	public static final FoodProperties POTATO_GRAVY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F)
			.build();
	public static final FoodProperties STIRFRY = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F).build();
	public static final FoodProperties WELLINGTON = (new FoodProperties.Builder()).nutrition(12).saturationMod(1F)
			.build();
	public static final FoodProperties HAGGIS = (new FoodProperties.Builder()).nutrition(8).saturationMod(1F).build();

	public static final FoodProperties JELLY = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.2F)
			.effect(JUMP_BRIEF, 1.0F).alwaysEat().build();

	public static final FoodProperties RIBS = (new FoodProperties.Builder()).nutrition(13).saturationMod(1.2F).meat()
			.build();
	public static final FoodProperties JERKY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat()
			.fast().alwaysEat().build();

	public static final FoodProperties HOTDISH = (new FoodProperties.Builder()).nutrition(10).saturationMod(2.0F)
			.build();
	public static final FoodProperties PASTA = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.0F).build();
	public static final FoodProperties SLICED_BREAD = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.12f)
			.build();
	public static final FoodProperties BUTTERED_BREAD = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.22f)
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.BRIEF_DURATION, 0), 1.0F).build();
	public static final FoodProperties FURIKAKE_RICE = (new FoodProperties.Builder())
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).nutrition(6)
			.saturationMod(0.4f).build();
	public static final FoodProperties FRIED_RICE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8f)
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2f)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();

	public static final FoodProperties BADFOOD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, FoodValues.SHORT_DURATION, 0), 1.0F).build();

	public static Builder addFoods(String name, FoodProperties... foods) {

		int nut = 0;
		float sat = 0;

		for (int i = 0; i < foods.length; i++) {
			nut += foods[i].getNutrition();
			sat += foods[i].getSaturationModifier();
		}

		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return new FoodProperties.Builder().nutrition(nut).saturationMod(sat);
	}

	public static Builder divideFoods(String name, FoodProperties food, int by) {
		int nut = food.getNutrition() / by;
		float sat = food.getSaturationModifier() / by;

		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return new FoodProperties.Builder().nutrition(nut).saturationMod(sat);
	}

	public static Builder cookFood(String name, FoodProperties food) {
		ExtraDelight.logger
				.debug(name + ": " + (food.getNutrition() + 4) + "," + (food.getSaturationModifier() + 0.5f));
		return new FoodProperties.Builder().nutrition(food.getNutrition() + 4)
				.saturationMod(food.getSaturationModifier() + 0.5f);
	}
}

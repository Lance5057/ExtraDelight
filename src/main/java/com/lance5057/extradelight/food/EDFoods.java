package com.lance5057.extradelight.food;

import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.datafixers.util.Pair;

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

	public static final Supplier<MobEffectInstance> REGENERATION_FIVE_SECONDS = () -> new MobEffectInstance(
			MobEffects.REGENERATION, 100, 0);
	public static final Supplier<MobEffectInstance> DAMAGE_RESISTANCE_THIRTY_SECONDS = () -> new MobEffectInstance(
			MobEffects.DAMAGE_RESISTANCE, FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> ABSORPTION_SIXTY_SECONDS = () -> new MobEffectInstance(
			MobEffects.ABSORPTION, FoodValues.SHORT_DURATION, 0);
	public static final Supplier<MobEffectInstance> _SHORT = () -> new MobEffectInstance(MobEffects.DIG_SPEED,
			FoodValues.SHORT_DURATION, 0);

	public static final Supplier<MobEffectInstance> COMFORT_BRIEF = () -> new MobEffectInstance(
			ModEffects.COMFORT.get(), FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_MEDIUM = () -> new MobEffectInstance(
			ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_LONG = () -> new MobEffectInstance(ModEffects.COMFORT.get(),
			FoodValues.LONG_DURATION, 0);

	public static final Supplier<MobEffectInstance> GLOW_SHORT = () -> new MobEffectInstance(MobEffects.GLOWING,
			FoodValues.SHORT_DURATION, 0);

	public static final FoodProperties CUSTARD = new FoodProperties.Builder().nutrition(7).saturationMod(0.6f)
			.alwaysEat().build();
	public static final FoodProperties WHIPPED_CREAM = new FoodProperties.Builder().nutrition(0).saturationMod(0.1f)
			.build();
	public static final FoodProperties EDIBLE_SEEDS = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f)
			.build();
	public static final FoodProperties SUGAR = new FoodProperties.Builder().nutrition(0).saturationMod(0.1f).build();
	public static final FoodProperties OIL = new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).build();
	public static final FoodProperties VINEGAR = new FoodProperties.Builder().nutrition(1).saturationMod(0.0f).build();
	public static final FoodProperties MILK = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).build();
	public static final FoodProperties MUSHROOM = new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build();
	public static final FoodProperties FLOUR = new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).build();

	public static final FoodProperties BADFOOD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.8F).build();

	// Basic Cooked Items
	public static final FoodProperties COOKED_CARROT = EDFoods.cookFood("cooked carrot", Foods.CARROT).build();
	public static final FoodProperties COOKED_APPLE = EDFoods.cookFood("cooked apple", Foods.APPLE).build();

	public static final FoodProperties SLICED_BREAD = EDFoods.divideFoods("sliced bread", Foods.BREAD, 4).build();
	public static final FoodProperties BREADING = EDFoods
			.addFoods("breading", FLOUR, OIL, FoodValues.FRIED_EGG, SLICED_BREAD).build();
	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F)
			.effect(HUNGER, 0.3F).build();

	// Condiments
	public static final FoodProperties MAYO = EDFoods
			.divideFoods("mayo", EDFoods.addFoods("", FoodValues.FRIED_EGG, FoodValues.FRIED_EGG, OIL).build(), 4)
			.effect(ABSORPTION_SIXTY_SECONDS, 1.0F).build();

	public static final FoodProperties MAYO_RAW = EDFoods
			.divideFoods("mayo raw", EDFoods.addFoods("", FoodValues.FRIED_EGG, FoodValues.FRIED_EGG, OIL).build(), 4)
			.effect(HUNGER, 1.0F).build();

	public static final FoodProperties BBQ = EDFoods
			.divideFoods("bbq", EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.ONION, SUGAR, VINEGAR).build(), 4)
			.effect(DAMAGE_RESISTANCE_THIRTY_SECONDS, 1.0F).build();

	public static final FoodProperties BBQ_RAW = EDFoods.divideFoods("bbq raw",
			EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.ONION, SUGAR, VINEGAR).build(), 4).effect(HUNGER, 1.0F)
			.build();

	public static final FoodProperties KETCHUP = EDFoods.divideFoods("ketchup",
			EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.ONION, SUGAR, VINEGAR).build(), 4)
			.effect(REGENERATION_FIVE_SECONDS, 1.0F).build();

	public static final FoodProperties KETCHUP_RAW = EDFoods
			.divideFoods("ketchup raw",
					EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.TOMATO, SUGAR, VINEGAR).build(), 4)
			.effect(HUNGER, 1.0F).build();

	public static final FoodProperties GRAVY = EDFoods
			.divideFoods("gravy", EDFoods.addFoods("", FLOUR, FoodValues.BONE_BROTH).build(), 4)
			.effect(REGENERATION_FIVE_SECONDS, 1.0F).build();

	// Jam
	public static final FoodProperties JAM = EDFoods.divideFoods("jam",
			EDFoods.addFoods("", Foods.SWEET_BERRIES, Foods.SWEET_BERRIES, Foods.SWEET_BERRIES, SUGAR).build(), 4)
			.build();

	public static final FoodProperties GLOW_BERRY_JAM = EDFoods
			.divideFoods("glow berry jam",
					EDFoods.addFoods("", Foods.GLOW_BERRIES, Foods.GLOW_BERRIES, Foods.GLOW_BERRIES, SUGAR).build(), 4)
			.effect(GLOW_SHORT, 0).build();

	public static final FoodProperties GOLDEN_APPLE_JAM = EDFoods
			.divideFoods("golden apple jam",
					EDFoods.addFoods("", Foods.GOLDEN_APPLE, Foods.GOLDEN_APPLE, Foods.GOLDEN_APPLE, SUGAR).build(), 4)
			.effect(GOLDEN_APPLE_1, 1).effect(GOLDEN_APPLE_2, 1).build();

	public static final FoodProperties JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD).build();

	public static final FoodProperties GLOW_JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD).effect(GLOW_SHORT, 0)
			.build();

	public static final FoodProperties GOLDEN_JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD)
			.effect(GOLDEN_APPLE_1, 1).effect(GOLDEN_APPLE_2, 1).build();

	// Eggs
	public static final FoodProperties SCRAMBLED_EGGS = EDFoods
			.addFoods("scrambled_eggs", FoodValues.FRIED_EGG, FoodValues.FRIED_EGG).build();
	public static final FoodProperties OMELETTE = EDFoods.addFoods("omelette", SCRAMBLED_EGGS, Foods.COOKED_BEEF)
			.build();
	public static final FoodProperties QUICHE = EDFoods
			.divideFoods("sliced quiche", EDFoods.addFoods("quiche", OMELETTE, Foods.BREAD).build(), 4).build();

	public static final FoodProperties EGG_BASKET = EDFoods
			.addFoods("egg in a basket", FoodValues.FRIED_EGG, SLICED_BREAD).build();

	public static final FoodProperties EGG_SALAD = EDFoods.addFoods("egg salad", SCRAMBLED_EGGS, MAYO).build();

	public static final FoodProperties FRIED_POTATO = EDFoods.addFoods("fried potato", Foods.BAKED_POTATO, OIL).build();

	public static final FoodProperties GLAZED_CARROT = EDFoods.addFoods("glazed carrot", Foods.CARROT, SUGAR).build();

	public static final FoodProperties CARROT_SALAD = EDFoods
			.addFoods("carrot salad", Foods.CARROT, Foods.CARROT, Foods.APPLE, MAYO).build();

	public static final FoodProperties APPLE_SAUCE = EDFoods
			.addFoods("apple sauce", Foods.APPLE, Foods.APPLE, Foods.APPLE, SUGAR).build();

	// Soup
	public static final FoodProperties POTATO_SOUP = EDFoods
			.addFoods("potato soup", Foods.POTATO, Foods.POTATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK)
			.effect(COMFORT_LONG, 1).build();

	public static final FoodProperties TOMATO_SOUP = EDFoods.addFoods("tomato soup", FoodValues.TOMATO,
			FoodValues.TOMATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK).effect(COMFORT_LONG, 1).build();

	public static final FoodProperties FISH_SOUP = EDFoods
			.addFoods("fish soup", Foods.COD, Foods.COD, FoodValues.ONION, FoodValues.BONE_BROTH, Foods.DRIED_KELP)
			.effect(COMFORT_LONG, 1).build();

	public static final FoodProperties CARROT_SOUP = EDFoods
			.addFoods("carrot soup", Foods.CARROT, Foods.CARROT, FoodValues.ONION, FoodValues.BONE_BROTH, MILK)
			.effect(COMFORT_LONG, 1).build();

	// Butchercraft
	public static final FoodProperties SALISBURY_STEAK = EDFoods.addFoods("salisbury steak", FoodValues.BEEF_PATTY,
			FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, FoodValues.ONION, MUSHROOM, MILK).effect(COMFORT_LONG, 1)
			.build();
	public static final FoodProperties MASHED_POTATO_GRAVY = EDFoods.divideFoods("mashed potato", EDFoods
			.addFoods("", Foods.BAKED_POTATO, Foods.BAKED_POTATO, Foods.BAKED_POTATO, GRAVY, BUTTER, MILK).build(), 4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties PORK_STEW = EDFoods
			.divideFoods("pork stew",
					EDFoods.addFoods("", Foods.COOKED_PORKCHOP, Foods.BAKED_POTATO, EDFoods.COOKED_CARROT,
							FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION).build(),
					4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties LAMB_STEW = EDFoods
			.divideFoods("lamb stew",
					EDFoods.addFoods("", Foods.COOKED_MUTTON, Foods.BAKED_POTATO, EDFoods.COOKED_CARROT,
							FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION).build(),
					4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties CHICKEN_STEW = EDFoods
			.divideFoods("chicken stew",
					EDFoods.addFoods("", Foods.COOKED_CHICKEN, Foods.BAKED_POTATO, EDFoods.COOKED_CARROT,
							FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION).build(),
					4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties CURRY = EDFoods
			.divideFoods("curry",
					EDFoods.addFoods("", Foods.COOKED_CHICKEN, Foods.BAKED_POTATO, EDFoods.COOKED_CARROT,
							FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION).build(),
					4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties BEEF_STEW_RICE = EDFoods
			.addFoods("beef stew rice", FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties PORK_STEW_RICE = EDFoods
			.addFoods("pork stew rice", EDFoods.PORK_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties LAMB_STEW_RICE = EDFoods
			.addFoods("lamb stew rice", EDFoods.LAMB_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties RABBIT_STEW_RICE = EDFoods
			.addFoods("rabbit stew rice", Foods.RABBIT_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties CHICKEN_STEW_RICE = EDFoods
			.addFoods("chicken stew rice", EDFoods.CHICKEN_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties FISH_STEW_RICE = EDFoods
			.addFoods("fish stew rice", FoodValues.FISH_STEW, FoodValues.COOKED_RICE).build();
	public static final FoodProperties CURRY_RICE = EDFoods
			.addFoods("curry stew rice", EDFoods.CURRY, FoodValues.COOKED_RICE).build();

	//TODO: Sort these in the right categories, split if needed, add nourishment/comfort
	public static final FoodProperties COOKED_PASTA = EDFoods
			.cookFood("cooked pasta", FoodValues.RAW_PASTA).build();
	public static final FoodProperties BUTTERED_PASTA = EDFoods
			.addFoods("buttered pasta", EDFoods.COOKED_PASTA, EDFoods.BUTTER).build();
	public static final FoodProperties FRIED_FISH = EDFoods
			.addFoods("fried fish", Foods.COOKED_COD, EDFoods.BREADING).build();
	public static final FoodProperties CHICKEN_FRIED_STEAK = EDFoods
			.addFoods("chicken fried steak", Foods.COOKED_BEEF, EDFoods.BREADING, EDFoods.GRAVY).build();
	public static final FoodProperties PORK_TENDERLOIN = EDFoods
			.addFoods("pork tenderloin", Foods.COOKED_PORKCHOP, EDFoods.BREADING).build();
	public static final FoodProperties PORK_TENDERLOIN_SANDWICH = EDFoods
			.addFoods("pork tenderloin sandwich", EDFoods.PORK_TENDERLOIN, Foods.BREAD, EDFoods.GRAVY).build();
	public static final FoodProperties CHEESE_SANDWICH = EDFoods
			.addFoods("cheese sandwich", EDFoods.SLICED_BREAD, EDFoods.SLICED_BREAD, EDFoods.CHEESE, EDFoods.BUTTER).build();
	public static final FoodProperties GRILLED_CHEESE = EDFoods
			.cookFood("grilled cheese", EDFoods.CHEESE_SANDWICH).build();
	public static final FoodProperties AGAR_AGAR_POWDER = EDFoods
			.addFoods("agar agar powder", Foods.DRIED_KELP, Foods.DRIED_KELP, Foods.DRIED_KELP).build();
	//hash feast&derivatives
	public static final FoodProperties HASH_FEAST = EDFoods
			.addFoods("hash feast",
					Foods.POTATO,
					Foods.POTATO,
					FoodValues.ONION,
					EDFoods.OIL,
					Foods.COOKED_PORKCHOP).build();
	public static final FoodProperties HASH_SERVING = EDFoods.divideFoods("hash",
			EDFoods.HASH_FEAST,4).build();
	//meat loaf feast&derivatives
	public static final FoodProperties MEAT_LOAF_FEAST = EDFoods
			.addFoods("meat loaf feast",
					EDFoods.KETCHUP,
					EDFoods.SLICED_BREAD,
					EDFoods.SCRAMBLED_EGGS,
					FoodValues.BEEF_PATTY,
					FoodValues.BEEF_PATTY,
					FoodValues.BEEF_PATTY,
					FoodValues.ONION).build();
	public static final FoodProperties MEAT_LOAF_SERVING = EDFoods
			.divideFoods("meat loaf plate", EDFoods.MEAT_LOAF_FEAST, 4).build();
	public static final FoodProperties MEAT_LOAF_SANDWICH = EDFoods
			.addFoods("meat loaf sandwich", EDFoods.MEAT_LOAF_SERVING, Foods.BREAD).build();
	//meat pie&derivatives
	public static final FoodProperties MEAT_PIE_WHOLE = EDFoods
			.addFoods("meat pie whole",
					FoodValues.BEEF_PATTY,
					FoodValues.BEEF_PATTY,
					FoodValues.BEEF_PATTY,
					EDFoods.MUSHROOM,
					Foods.POTATO,
					FoodValues.ONION).build();
	public static final FoodProperties MEAT_PIE_SLICE = EDFoods
			.divideFoods("meat pie slice", EDFoods.MEAT_PIE_WHOLE, 4).build();
	//pulled pork feast&derivatives
	public static final FoodProperties PULLED_PORK_FEAST = EDFoods
			.addFoods("pulled pork feast",
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP,
					EDFoods.BBQ).build();
	public static final FoodProperties PULLED_PORK_SERVING = EDFoods
			.divideFoods("pulled pork serving", EDFoods.PULLED_PORK_FEAST, 4).build();
	public static final FoodProperties PULLED_PORK_SANDWICH = EDFoods
			.addFoods("pulled pork sandwich", EDFoods.PULLED_PORK_SERVING, Foods.BREAD).build();
	//stirfry feast&derivatives
	public static final FoodProperties STIRFRY = EDFoods
			.addFoods("stirfry feast",
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP,
					Foods.CARROT,
					Foods.CARROT,
					Foods.CARROT,
					Foods.CARROT).build();
	public static final FoodProperties STIRFRY_SERVING = EDFoods
			.divideFoods("stirfry serving", EDFoods.STIRFRY, 4).build();
	public static final FoodProperties STIRFRY_AND_RICE = EDFoods
			.addFoods("stirfry and rice", EDFoods.STIRFRY_SERVING, FoodValues.COOKED_RICE).build();
	//jelly feast&derivatives
	public static final FoodProperties JELLY_FEAST = EDFoods
			.addFoods("jelly feast",
					EDFoods.MILK,
					Foods.SWEET_BERRIES,
					EDFoods.SUGAR,
					EDFoods.AGAR_AGAR_POWDER).build();
	public static final FoodProperties JELLY_SERVING = EDFoods
			.divideFoods("jelly serving", EDFoods.JELLY_FEAST, 4).build();
	//mac and cheese feast&derivatives
	public static final FoodProperties MACARONI_CHEESE_FEAST = EDFoods
			.addFoods("mac and cheese feast",
					Foods.BREAD,
					Foods.BREAD,
					EDFoods.BUTTER,
					EDFoods.MILK,
					EDFoods.CHEESE,
					EDFoods.CHEESE).build();
	public static final FoodProperties MACARONI_CHEESE_SERVING = EDFoods
			.divideFoods("mac and cheese serving", EDFoods.MACARONI_CHEESE_FEAST, 4).build();
	//lasagna feast&derivatives
	public static final FoodProperties LASAGNA_FEAST = EDFoods
			.addFoods("lasagna feast",
					EDFoods.CHEESE,
					EDFoods.CHEESE,
					FoodValues.TOMATO_SAUCE,
					FoodValues.TOMATO_SAUCE,
					Foods.BREAD,
					Foods.BREAD,
					Foods.BREAD,
					Foods.COOKED_PORKCHOP,
					Foods.COOKED_PORKCHOP).build();
	public static final FoodProperties LASAGNA_SERVING = EDFoods
			.divideFoods("lasagna serving", EDFoods.LASAGNA_FEAST, 4).build();

	public static final FoodProperties JERKY = EDFoods.addFoods("jerky", Foods.COOKED_PORKCHOP).build();

	//TODO: Assign these food values

	public static final FoodProperties HOTDISH = null;
	public static final FoodProperties FURIKAKE_RICE = null;
	public static final FoodProperties FISH_CAKES = null;
	public static final FoodProperties FISH_CHIPS = null;
	public static final FoodProperties FRIED_MUSHROOMS = null;
	public static final FoodProperties MUSHROOM_RISOTTO = null;
	public static final FoodProperties STUFFED_MUSHROOMS = null;
	public static final FoodProperties MUSHROOM_BURGER = null;
	public static final FoodProperties BACON_EGG_SANDWICH = null;
	public static final FoodProperties BACON_EGG_CHEESE_SANDWICH = null;
	public static final FoodProperties BUTTERED_TOAST = null;
	public static final FoodProperties SALAD = null;
	public static final FoodProperties ALFREDO_SAUCE = null;
	public static final FoodProperties PASTA_TOMATO = null;
	public static final FoodProperties PASTA_ALFREDO = null;
	public static final FoodProperties CHICKEN_ALFREDO = null;
	public static final FoodProperties CHICKEN_PARM = null;
	public static final FoodProperties CHEESEBURGER = null;
	public static final FoodProperties BACON_CHEESEBURGER = null;
	public static final FoodProperties RICEBALL = null;
	public static final FoodProperties RICEBALL_FILLED = null;
	public static final FoodProperties FISH_SALAD = null;
	public static final FoodProperties FISH_SALAD_SANDWICH = null;

	//have empty tags
	public static final FoodProperties SAUSAGE_ROLL = null;
	public static final FoodProperties SOS = null;
	public static final FoodProperties LIVERONION = null;
	public static final FoodProperties FRIED_CHICKEN = null;
	public static final FoodProperties STUFFED_HEART = null;
	public static final FoodProperties FRIED_BRAIN = null;
	public static final FoodProperties OXTAIL_SOUP = null;
	public static final FoodProperties POT_ROAST = null;
	public static final FoodProperties BBQ_RIBS = null;
	public static final FoodProperties RACK_LAMB = null;
	public static final FoodProperties WELLINGTON = null;
	public static final FoodProperties HAGGIS = null;

	public static Builder addFoods(String name, FoodProperties... foods) {

		int nut = 0;
		float sat = 0;
		Builder b = new FoodProperties.Builder();

		for (int i = 0; i < foods.length; i++) {
			nut += foods[i].getNutrition();
			sat += foods[i].getSaturationModifier();

			for (Pair<MobEffectInstance, Float> effect : foods[i].getEffects())
				b.effect(effect.getFirst(), effect.getSecond());
		}

		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationMod(sat);
	}

	public static Builder divideFoods(String name, FoodProperties food, int by) {
		int nut = food.getNutrition() / by;
		float sat = food.getSaturationModifier() / by;
		Builder b = new FoodProperties.Builder();
		for (Pair<MobEffectInstance, Float> effect : food.getEffects())
			b.effect(effect.getFirst(), effect.getSecond());

		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationMod(sat);
	}

	public static Builder cookFood(String name, FoodProperties food) {
		ExtraDelight.logger
				.debug(name + ": " + (food.getNutrition() + 4) + "," + (food.getSaturationModifier() + 0.5f));
		return new FoodProperties.Builder().nutrition(food.getNutrition() + 4)
				.saturationMod(food.getSaturationModifier() + 0.5f);
	}
}

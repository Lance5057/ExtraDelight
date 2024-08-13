package com.lance5057.extradelight.food;

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

	public static final Supplier<MobEffectInstance> REGENERATION_FIVE_SECONDS = () -> new MobEffectInstance(
			MobEffects.REGENERATION, 100, 0);
	public static final Supplier<MobEffectInstance> DAMAGE_RESISTANCE_THIRTY_SECONDS = () -> new MobEffectInstance(
			MobEffects.DAMAGE_RESISTANCE, FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> ABSORPTION_SIXTY_SECONDS = () -> new MobEffectInstance(
			MobEffects.ABSORPTION, FoodValues.SHORT_DURATION, 0);
	public static final Supplier<MobEffectInstance> DOLPHIN_BRIEF = () -> new MobEffectInstance(
			MobEffects.DOLPHINS_GRACE, FoodValues.BRIEF_DURATION, 0);

	public static final Supplier<MobEffectInstance> COMFORT_BRIEF = () -> new MobEffectInstance(ModEffects.COMFORT,
			FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_MEDIUM = () -> new MobEffectInstance(ModEffects.COMFORT,
			FoodValues.MEDIUM_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_LONG = () -> new MobEffectInstance(ModEffects.COMFORT,
			FoodValues.LONG_DURATION, 0);

	public static final Supplier<MobEffectInstance> NOURISHMENT_BRIEF = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT, FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> NOURISHMENT_MEDIUM = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT, FoodValues.MEDIUM_DURATION, 0);
	public static final Supplier<MobEffectInstance> NOURISHMENT_LONG = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0);

	public static final Supplier<MobEffectInstance> GLOW_SHORT = () -> new MobEffectInstance(MobEffects.GLOWING,
			FoodValues.SHORT_DURATION, 0);

	public static final Supplier<MobEffectInstance> PAIN = () -> new MobEffectInstance(MobEffects.HARM, 1, 0);

	public static final FoodProperties NOTFOOD = new FoodProperties(0, 0f, true, 0, java.util.Optional.empty(), null);

	public static final FoodProperties CUSTARD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f)
			.alwaysEdible();
	public static final FoodProperties WHIPPED_CREAM = new FoodProperties.Builder().nutrition(0)
			.saturationModifier(0.1f);
	public static final FoodProperties EDIBLE_SEEDS = new FoodProperties.Builder().nutrition(1)
			.saturationModifier(0.1f);
	public static final FoodProperties SUGAR = new FoodProperties.Builder().nutrition(0).saturationModifier(0.1f);
	public static final FoodProperties OIL = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f);
	public static final FoodProperties VINEGAR = new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f);
	public static final FoodProperties MILK = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f);
	public static final FoodProperties MUSHROOM = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f);
	public static final FoodProperties FLOUR = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f);
	public static final FoodProperties SLICED_ONION = EDFoods.divideFoods("sliced onion", FoodValues.ONION, 4);
	public static final FoodProperties SLICED_TOMATO = EDFoods.divideFoods("sliced tomato", FoodValues.TOMATO, 4);
	public static final FoodProperties BADFOOD = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.8F);

	// Basic Cooked Items
	public static final FoodProperties COOKED_CARROT = new FoodProperties.Builder().nutrition(5)
			.saturationModifier(0.5f);
	public static final FoodProperties COOKED_APPLE = new FoodProperties.Builder().nutrition(6)
			.saturationModifier(0.5f);

	public static final FoodProperties SLICED_BREAD = EDFoods.divideFoods("sliced bread", Foods.BREAD, 4);
	public static final FoodProperties BREADING = EDFoods.addFoods("breading", FLOUR, OIL, FoodValues.FRIED_EGG,
			SLICED_BREAD);
	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F);
	public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F)
			.effect(HUNGER, 0.3F);

	// BC basics
	public static final FoodProperties COOKED_SAUSAGE = (new FoodProperties.Builder()).nutrition(6)
			.saturationModifier(0.2F);
	public static final FoodProperties COOKED_BRAIN = (new FoodProperties.Builder()).nutrition(4)
			.saturationModifier(0.2F);
	public static final FoodProperties COOKED_HEART = (new FoodProperties.Builder()).nutrition(6)
			.saturationModifier(0.2F);
	public static final FoodProperties COOKED_LIVER = (new FoodProperties.Builder()).nutrition(6)
			.saturationModifier(0.4F);
	public static final FoodProperties COOKED_LUNG = (new FoodProperties.Builder()).nutrition(8)
			.saturationModifier(0.4F);
	public static final FoodProperties COOKED_STOMACH = (new FoodProperties.Builder()).nutrition(4)
			.saturationModifier(0.2F);
	public static final FoodProperties COOKED_TRIPE = (new FoodProperties.Builder()).nutrition(6)
			.saturationModifier(0.2F);

	// Condiments
	public static final FoodProperties MAYO = EDFoods
			.divideFoods("mayo raw", EDFoods.addFoods("", FoodValues.FRIED_EGG, FoodValues.FRIED_EGG, OIL), 4)
			.effect(HUNGER, 1.0F);

	public static final FoodProperties BBQ = EDFoods
			.divideFoods("bbq raw", EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.ONION, SUGAR, VINEGAR), 4)
			.effect(HUNGER, 1.0F);

	public static final FoodProperties KETCHUP = EDFoods
			.divideFoods("ketchup raw", EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.TOMATO, SUGAR, VINEGAR), 4)
			.effect(HUNGER, 1.0F);

	public static final FoodProperties GRAVY = EDFoods
			.divideFoods("gravy", EDFoods.addFoods("", FLOUR, FoodValues.BONE_BROTH), 4)
			.effect(REGENERATION_FIVE_SECONDS, 1.0F);

	// Jam
	public static final FoodProperties JAM = EDFoods.divideFoods("jam",
			EDFoods.addFoods("", Foods.SWEET_BERRIES, Foods.SWEET_BERRIES, Foods.SWEET_BERRIES, SUGAR), 4);

	public static final FoodProperties GLOW_BERRY_JAM = EDFoods
			.divideFoods("glow berry jam",
					EDFoods.addFoods("", Foods.GLOW_BERRIES, Foods.GLOW_BERRIES, Foods.GLOW_BERRIES, SUGAR), 4)
			.effect(GLOW_SHORT, 0);

	public static final FoodProperties GOLDEN_APPLE_JAM = EDFoods
			.divideFoods("golden apple jam",
					EDFoods.addFoods("", Foods.GOLDEN_APPLE, Foods.GOLDEN_APPLE, Foods.GOLDEN_APPLE, SUGAR), 4)
			.effect(GOLDEN_APPLE_1, 1).effect(GOLDEN_APPLE_2, 1);

	public static final FoodProperties JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD);

	public static final FoodProperties GLOW_JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD).effect(GLOW_SHORT, 0);

	public static final FoodProperties GOLDEN_JAM_BREAD = EDFoods.addFoods("", JAM, SLICED_BREAD)
			.effect(GOLDEN_APPLE_1, 1).effect(GOLDEN_APPLE_2, 1);

	// Eggs
	public static final FoodProperties SCRAMBLED_EGGS = EDFoods.addFoods("scrambled_eggs", FoodValues.FRIED_EGG,
			FoodValues.FRIED_EGG);
	public static final FoodProperties OMELETTE = EDFoods.addFoods("omelette", SCRAMBLED_EGGS, Foods.COOKED_BEEF);
	public static final FoodProperties QUICHE = EDFoods
			.divideFoods("quiche", EDFoods.addFoods("", OMELETTE, Foods.BREAD), 4).effect(NOURISHMENT_BRIEF, 1);

	public static final FoodProperties EGG_BASKET = EDFoods.addFoods("egg in a basket", FoodValues.FRIED_EGG,
			SLICED_BREAD);

	public static final FoodProperties EGG_SALAD = EDFoods.addFoods("egg salad", SCRAMBLED_EGGS, MAYO);

	public static final FoodProperties FRIED_POTATO = EDFoods.addFoods("fried potato", Foods.BAKED_POTATO, OIL);

	public static final FoodProperties GLAZED_CARROT = EDFoods.addFoods("glazed carrot", Foods.CARROT, SUGAR);

	public static final FoodProperties CARROT_SALAD = EDFoods.addFoods("carrot salad", Foods.CARROT, Foods.CARROT,
			Foods.APPLE, MAYO);

	public static final FoodProperties APPLE_SAUCE = EDFoods.addFoods("apple sauce", Foods.APPLE, Foods.APPLE,
			Foods.APPLE, SUGAR);

	// Soup
	public static final FoodProperties POTATO_SOUP = EDFoods
			.divideFoods("potato soup",
					EDFoods.addFoods("", Foods.POTATO, Foods.POTATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK), 2)
			.effect(COMFORT_LONG, 1);

	public static final FoodProperties TOMATO_SOUP = EDFoods.divideFoods("tomato soup",
			EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.TOMATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK),
			2).effect(COMFORT_LONG, 1);

	public static final FoodProperties FISH_SOUP = EDFoods.divideFoods("fish soup",
			EDFoods.addFoods("", Foods.COD, Foods.COD, FoodValues.ONION, FoodValues.BONE_BROTH, Foods.DRIED_KELP), 2)
			.effect(COMFORT_LONG, 1);

	public static final FoodProperties CARROT_SOUP = EDFoods
			.divideFoods("carrot soup",
					EDFoods.addFoods("", Foods.CARROT, Foods.CARROT, FoodValues.ONION, FoodValues.BONE_BROTH, MILK), 2)
			.effect(COMFORT_LONG, 1);

	// Butchercraft
	public static final FoodProperties SALISBURY_STEAK = EDFoods
			.divideFoods("salisbury steak", EDFoods.addFoods("", FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY,
					FoodValues.BEEF_PATTY, FoodValues.ONION, MUSHROOM, MILK), 4)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_MEDIUM, 1);
	public static final FoodProperties MASHED_POTATO_GRAVY = EDFoods.divideFoods("mashed potato",
			EDFoods.addFoods("", Foods.BAKED_POTATO, Foods.BAKED_POTATO, Foods.BAKED_POTATO, GRAVY, BUTTER, MILK), 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties PORK_STEW = EDFoods
			.divideFoods("pork stew", EDFoods.addFoods("", Foods.COOKED_PORKCHOP, Foods.BAKED_POTATO,
					EDFoods.COOKED_CARROT, FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION), 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties LAMB_STEW = EDFoods
			.divideFoods("lamb stew", EDFoods.addFoods("", Foods.COOKED_MUTTON, Foods.BAKED_POTATO,
					EDFoods.COOKED_CARROT, FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION), 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties CHICKEN_STEW = EDFoods
			.divideFoods("chicken stew", EDFoods.addFoods("", Foods.COOKED_CHICKEN, Foods.BAKED_POTATO,
					EDFoods.COOKED_CARROT, FoodValues.BONE_BROTH, FLOUR, FoodValues.ONION), 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties CURRY = EDFoods.divideFoods("curry", EDFoods.addFoods("", Foods.COOKED_CHICKEN,
			Foods.BAKED_POTATO, EDFoods.COOKED_CARROT, FoodValues.BONE_BROTH, FoodValues.ONION), 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties BEEF_STEW_RICE = EDFoods
			.addFoods("beef stew rice", FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties PORK_STEW_RICE = EDFoods
			.addFoods("pork stew rice", EDFoods.PORK_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties LAMB_STEW_RICE = EDFoods
			.addFoods("lamb stew rice", EDFoods.LAMB_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties RABBIT_STEW_RICE = EDFoods
			.addFoods("rabbit stew rice", Foods.RABBIT_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties CHICKEN_STEW_RICE = EDFoods
			.addFoods("chicken stew rice", EDFoods.CHICKEN_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties FISH_STEW_RICE = EDFoods
			.addFoods("fish stew rice", FoodValues.FISH_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);
	public static final FoodProperties CURRY_RICE = EDFoods
			.addFoods("curry stew rice", EDFoods.CURRY, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1);

	// TODO: Sort these in the right categories, split if needed, add
	// nourishment/comfort
	public static final FoodProperties COOKED_PASTA = EDFoods.cookFood("cooked pasta", FoodValues.RAW_PASTA);
	public static final FoodProperties BUTTERED_PASTA = EDFoods
			.addFoods("buttered pasta", EDFoods.COOKED_PASTA, EDFoods.BUTTER).effect(COMFORT_BRIEF, 1);
	public static final FoodProperties FRIED_FISH = EDFoods.addFoods("fried fish", Foods.COOKED_COD, EDFoods.BREADING);
	public static final FoodProperties CHICKEN_FRIED_STEAK = EDFoods
			.addFoods("chicken fried steak", Foods.COOKED_BEEF, EDFoods.BREADING, EDFoods.GRAVY)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties PORK_TENDERLOIN = EDFoods.addFoods("pork tenderloin", Foods.PORKCHOP,
			EDFoods.BREADING);
	public static final FoodProperties PORK_TENDERLOIN_SANDWICH = EDFoods.addFoods("pork tenderloin sandwich",
			EDFoods.PORK_TENDERLOIN, Foods.BREAD);
	public static final FoodProperties CHEESE_SANDWICH = EDFoods.addFoods("cheese sandwich", EDFoods.SLICED_BREAD,
			EDFoods.SLICED_BREAD, EDFoods.CHEESE, EDFoods.BUTTER);
	public static final FoodProperties GRILLED_CHEESE = EDFoods.cookFood("grilled cheese", EDFoods.CHEESE_SANDWICH);
	public static final FoodProperties AGAR_AGAR_POWDER = EDFoods.addFoods("agar agar powder", Foods.DRIED_KELP,
			Foods.DRIED_KELP, Foods.DRIED_KELP);

	// hash feast&derivatives
	public static final FoodProperties HASH_FEAST = EDFoods.addFoods("hash feast", Foods.POTATO, Foods.POTATO,
			FoodValues.ONION, EDFoods.OIL, Foods.COOKED_PORKCHOP);
	public static final FoodProperties HASH_SERVING = EDFoods.divideFoods("hash", EDFoods.HASH_FEAST, 4)
			.effect(COMFORT_BRIEF, 1);

	// meat loaf feast&derivatives
	public static final FoodProperties MEAT_LOAF_FEAST = EDFoods.addFoods("meat loaf feast", EDFoods.KETCHUP,
			EDFoods.SLICED_BREAD, EDFoods.SCRAMBLED_EGGS, FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY,
			FoodValues.BEEF_PATTY, FoodValues.ONION);
	public static final FoodProperties MEAT_LOAF_SERVING = EDFoods
			.divideFoods("meat loaf plate", EDFoods.MEAT_LOAF_FEAST, 4).effect(COMFORT_LONG, 1);
	public static final FoodProperties MEAT_LOAF_SANDWICH = EDFoods
			.addFoods("meat loaf sandwich", EDFoods.MEAT_LOAF_SERVING, Foods.BREAD).effect(COMFORT_LONG, 1)
			.effect(NOURISHMENT_MEDIUM, 1);

	// meat pie&derivatives
	public static final FoodProperties MEAT_PIE_WHOLE = EDFoods.addFoods("meat pie whole", FoodValues.BEEF_PATTY,
			FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, EDFoods.MUSHROOM, Foods.POTATO, FoodValues.ONION);
	public static final FoodProperties MEAT_PIE_SLICE = EDFoods.divideFoods("meat pie slice", EDFoods.MEAT_PIE_WHOLE, 4)
			.effect(COMFORT_BRIEF, 1);

	// pulled pork feast&derivatives
	public static final FoodProperties PULLED_PORK_FEAST = EDFoods.addFoods("pulled pork feast", Foods.COOKED_PORKCHOP,
			Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, EDFoods.BBQ);
	public static final FoodProperties PULLED_PORK_SERVING = EDFoods.divideFoods("pulled pork serving",
			EDFoods.PULLED_PORK_FEAST, 4);
	public static final FoodProperties PULLED_PORK_SANDWICH = EDFoods
			.addFoods("pulled pork sandwich", EDFoods.PULLED_PORK_SERVING, Foods.BREAD).effect(NOURISHMENT_MEDIUM, 1);

	// stirfry feast&derivatives
	public static final FoodProperties STIRFRY = EDFoods.addFoods("stirfry feast", Foods.COOKED_PORKCHOP,
			Foods.COOKED_PORKCHOP, Foods.CARROT, Foods.CARROT, Foods.CARROT, Foods.CARROT);
	public static final FoodProperties STIRFRY_SERVING = EDFoods.divideFoods("stirfry serving", EDFoods.STIRFRY, 4)
			.effect(NOURISHMENT_MEDIUM, 1);
	public static final FoodProperties STIRFRY_AND_RICE = EDFoods
			.addFoods("stirfry and rice", EDFoods.STIRFRY_SERVING, FoodValues.COOKED_RICE).effect(NOURISHMENT_MEDIUM, 1)
			.effect(COMFORT_MEDIUM, 1);

	// jelly feast&derivatives
	public static final FoodProperties JELLY_FEAST = EDFoods.addFoods("jelly feast", EDFoods.MILK, Foods.SWEET_BERRIES,
			EDFoods.SUGAR, EDFoods.AGAR_AGAR_POWDER);
	public static final FoodProperties JELLY_SERVING = EDFoods.divideFoods("jelly serving", EDFoods.JELLY_FEAST, 4);

	// mac and cheese feast&derivatives
	public static final FoodProperties MACARONI_CHEESE_FEAST = EDFoods.addFoods("mac and cheese feast", Foods.BREAD,
			Foods.BREAD, EDFoods.BUTTER, EDFoods.MILK, EDFoods.CHEESE, EDFoods.CHEESE);
	public static final FoodProperties MACARONI_CHEESE_SERVING = EDFoods.divideFoods("mac and cheese serving",
			EDFoods.MACARONI_CHEESE_FEAST, 4);

	// lasagna feast&derivatives
	public static final FoodProperties LASAGNA_FEAST = EDFoods.addFoods("lasagna feast", EDFoods.CHEESE, EDFoods.CHEESE,
			FoodValues.TOMATO_SAUCE, FoodValues.TOMATO_SAUCE, Foods.BREAD, Foods.BREAD, Foods.BREAD,
			Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP);
	public static final FoodProperties LASAGNA_SERVING = EDFoods
			.divideFoods("lasagna serving", EDFoods.LASAGNA_FEAST, 4).effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties JERKY = EDFoods.addFoods("jerky", Foods.COOKED_PORKCHOP);

	public static final FoodProperties SAUSAGE_ROLL = EDFoods.addFoods("sausage roll", Foods.BREAD, COOKED_SAUSAGE);

	public static final FoodProperties SOS = EDFoods.addFoods("sos", Foods.COOKED_BEEF, FLOUR, MILK, SLICED_BREAD);

	public static final FoodProperties LIVERONION = EDFoods.addFoods("liver onions", COOKED_LIVER, FoodValues.ONION)
			.effect(NOURISHMENT_MEDIUM, 1);

	public static final FoodProperties FRIED_CHICKEN = EDFoods.addFoods("fried chicken", Foods.COOKED_CHICKEN, BREADING)
			.effect(COMFORT_BRIEF, 1);

	public static final FoodProperties STUFFED_HEART = EDFoods.addFoods("stuffed heart", COOKED_HEART, SLICED_BREAD,
			MUSHROOM, FoodValues.ONION, FoodValues.FRIED_EGG);

	public static final FoodProperties FRIED_BRAIN = EDFoods.addFoods("fried brain", COOKED_BRAIN, BREADING);

	public static final FoodProperties OXTAIL_SOUP = EDFoods
			.addFoods("oxtail soup", Foods.BEEF, COOKED_CARROT, FoodValues.BONE_BROTH, FoodValues.TOMATO)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_MEDIUM, 1);

	public static final FoodProperties POT_ROAST_FEAST = EDFoods.addFoods("pot roast feast", Foods.COOKED_BEEF,
			COOKED_CARROT, COOKED_CARROT, FoodValues.ONION, Foods.BAKED_POTATO, Foods.BAKED_POTATO);
	public static final FoodProperties POT_ROAST = EDFoods.divideFoods("pot roast", POT_ROAST_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_MEDIUM, 1);

	public static final FoodProperties BBQ_RIBS_FEAST = EDFoods.addFoods("bbq ribs feast", Foods.COOKED_BEEF,
			Foods.COOKED_BEEF, Foods.COOKED_BEEF, Foods.COOKED_BEEF, BBQ);
	public static final FoodProperties BBQ_RIBS = EDFoods.divideFoods("bbq ribs", BBQ_RIBS_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties RACK_LAMB_FEAST = EDFoods.addFoods("rack lamb feast", Foods.COOKED_MUTTON,
			Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, FoodValues.ONION, OIL, Foods.BREAD,
			Foods.SWEET_BERRIES, Foods.SWEET_BERRIES);
	public static final FoodProperties RACK_LAMB = EDFoods.divideFoods("rack lamb", RACK_LAMB_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties WELLINGTON_FEAST = EDFoods.addFoods("wellington feast", Foods.COOKED_BEEF,
			Foods.BREAD, MUSHROOM, MUSHROOM, COOKED_LIVER, BUTTER, FoodValues.COOKED_BACON, FoodValues.ONION);
	public static final FoodProperties WELLINGTON = EDFoods.divideFoods("wellington", WELLINGTON_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_MEDIUM, 1);

	public static final FoodProperties HAGGIS_FEAST = EDFoods.addFoods("haggis feast", COOKED_STOMACH, COOKED_LIVER,
			COOKED_LIVER, COOKED_LIVER, COOKED_LUNG, FLOUR, FLOUR, FLOUR, Foods.COOKED_MUTTON);
	public static final FoodProperties HAGGIS = EDFoods.divideFoods("haggis", HAGGIS_FEAST, 4)
			.effect(NOURISHMENT_MEDIUM, 1).effect(COMFORT_MEDIUM, 1);

	public static final FoodProperties HOTDISH_FEAST = EDFoods.addFoods("hotdish feast", Foods.BAKED_POTATO,
			Foods.BAKED_POTATO, Foods.BAKED_POTATO, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, EDFoods.POTATO_SOUP,
			EDFoods.POTATO_SOUP, EDFoods.COOKED_CARROT, EDFoods.COOKED_CARROT);
	public static final FoodProperties HOTDISH = EDFoods.divideFoods("hotdish", HOTDISH_FEAST, 4)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_LONG, 1);

	public static final FoodProperties FURIKAKE_RICE = EDFoods.addFoods("furikake rice", FoodValues.COOKED_RICE)
			.effect(DOLPHIN_BRIEF, 1);
	public static final FoodProperties FISH_CAKES = EDFoods.addFoods("", Foods.COOKED_COD, Foods.BAKED_POTATO,
			FoodValues.ONION, BREADING);
	public static final FoodProperties FISH_CHIPS = EDFoods.addFoods("fish chips", FRIED_FISH, FRIED_POTATO)
			.effect(NOURISHMENT_MEDIUM, 1);
	public static final FoodProperties FRIED_MUSHROOMS = EDFoods.divideFoods("fried mushrooms",
			EDFoods.addFoods("", MUSHROOM, MUSHROOM, MUSHROOM, BREADING), 3);
	public static final FoodProperties MUSHROOM_RISOTTO = EDFoods.divideFoods("mushroom risotto", EDFoods.addFoods("",
			MUSHROOM, CHEESE, BUTTER, FoodValues.BONE_BROTH, FoodValues.ONION, FoodValues.COOKED_RICE), 2)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties STUFFED_MUSHROOMS = EDFoods.divideFoods("stuffed mushrooms",
			EDFoods.addFoods("stuffed mushrooms", MUSHROOM, MUSHROOM, MUSHROOM, CHEESE, BUTTER, SLICED_BREAD), 3);
	public static final FoodProperties MUSHROOM_BURGER = EDFoods.addFoods("mushroom burger", FoodValues.BEEF_PATTY,
			MUSHROOM, MUSHROOM, CHEESE, SLICED_BREAD);
	public static final FoodProperties BACON_EGG_SANDWICH = EDFoods.addFoods("bacon egg sandwich",
			FoodValues.EGG_SANDWICH, FoodValues.COOKED_BACON);
	public static final FoodProperties BACON_EGG_CHEESE_SANDWICH = EDFoods.addFoods("bacon egg cheese sandwich",
			FoodValues.EGG_SANDWICH, FoodValues.COOKED_BACON, CHEESE);
	public static final FoodProperties BUTTERED_TOAST = EDFoods.addFoods("buttered toast", SLICED_BREAD, BUTTER);
	public static final FoodProperties SALAD = EDFoods
			.divideFoods("chef salad", EDFoods.addFoods("", FoodValues.CABBAGE, FoodValues.ONION, Foods.CARROT,
					SLICED_BREAD, CHEESE, OIL, VINEGAR, FoodValues.FRIED_EGG, Foods.PORKCHOP), 4)
			.effect(NOURISHMENT_MEDIUM, 1);
	public static final FoodProperties ALFREDO_SAUCE = EDFoods.addFoods("alfredo sauce", MILK, CHEESE, BUTTER);
	public static final FoodProperties PASTA_TOMATO = EDFoods.addFoods("pasta tomato", Foods.BREAD,
			FoodValues.TOMATO_SAUCE);
	public static final FoodProperties PASTA_ALFREDO = EDFoods.addFoods("pasta alfredo", Foods.BREAD, ALFREDO_SAUCE)
			.effect(COMFORT_BRIEF, 1);
	public static final FoodProperties CHICKEN_ALFREDO = EDFoods
			.addFoods("chicken alfredo", Foods.COOKED_CHICKEN, PASTA_ALFREDO).effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties CHICKEN_PARM = EDFoods
			.divideFoods("chicken parm", EDFoods.addFoods("", FRIED_CHICKEN, FoodValues.TOMATO_SAUCE, CHEESE), 2)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties CHEESEBURGER = EDFoods.addFoods("cheeseburger", FoodValues.HAMBURGER, CHEESE)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties BACON_CHEESEBURGER = EDFoods
			.addFoods("bacon cheeseburger", CHEESEBURGER, FoodValues.COOKED_BACON).effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties RICEBALL = EDFoods
			.divideFoods("riceball", EDFoods.addFoods("", Foods.DRIED_KELP, FoodValues.COOKED_RICE), 2)
			.effect(NOURISHMENT_BRIEF, 1);
	public static final FoodProperties RICEBALL_FILLED = EDFoods
			.addFoods("riceball filled", RICEBALL, FoodValues.FRIED_EGG).effect(NOURISHMENT_MEDIUM, 1);
	public static final FoodProperties FISH_SALAD = EDFoods.divideFoods("fish salad",
			EDFoods.addFoods("", Foods.COOKED_COD, Foods.COOKED_COD, MAYO), 2);
	public static final FoodProperties FISH_SALAD_SANDWICH = EDFoods.addFoods("fish salad sandwich", FISH_SALAD,
			SLICED_BREAD, SLICED_BREAD);
	public static final FoodProperties SEAWEED_CRISPS = EDFoods.addFoods("seaweed crisps", Foods.DRIED_KELP,
			Foods.DRIED_KELP, FLOUR, OIL);
	public static final FoodProperties SEAWEED_SALAD = EDFoods.addFoods("seaweed salad", Foods.DRIED_KELP,
			Foods.DRIED_KELP, Foods.CARROT, VINEGAR);

	public static final FoodProperties CACTUS = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f)
			.effect(PAIN, 1);
	public static final FoodProperties COOKED_CACTUS = EDFoods.cookFood("cooked cactus", CACTUS);
	public static final FoodProperties CACTUS_EGGS = EDFoods.addFoods("cactus eggs", COOKED_CACTUS, SCRAMBLED_EGGS);
	public static final FoodProperties CACTUS_SOUP = EDFoods.divideFoods("cactus soup", EDFoods.addFoods("",
			COOKED_CACTUS, COOKED_CACTUS, FoodValues.TOMATO, FoodValues.ONION, FoodValues.BONE_BROTH), 2)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_BRIEF, 1);
	public static final FoodProperties CACTUS_SALAD = EDFoods.addFoods("cactus salad", COOKED_CACTUS, FoodValues.TOMATO,
			FoodValues.ONION, CHEESE);
	public static final FoodProperties STUFFED_CACTUS = EDFoods
			.addFoods("stuffed cactus", COOKED_CACTUS, BREADING, CHEESE).effect(COMFORT_MEDIUM, 1);

	// Halloween Start!
	public static final FoodProperties COOKED_CORN = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f);
	public static final FoodProperties GRILLED_CORN = new FoodProperties.Builder().nutrition(3)
			.saturationModifier(0.2f);

	public static final FoodProperties CORN_CHOWDER = EDFoods.divideFoods("corn chowder",
			EDFoods.addFoods("", COOKED_CORN, Foods.BAKED_POTATO, FoodValues.COOKED_BACON, FoodValues.ONION, MILK,
					FoodValues.BONE_BROTH).effect(EDFoods.COMFORT_LONG, 1),
			2);
	public static final FoodProperties CREAMED_CORN = EDFoods.addFoods("creamed corn", COOKED_CORN, MILK, BUTTER);
	public static final FoodProperties CORN_FRITTERS = EDFoods
			.addFoods("corn fritters", COOKED_CORN, FoodValues.FRIED_EGG, SUGAR, FLOUR, OIL, FoodValues.ONION)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties STEWED_APPLES = EDFoods.addFoods("stewed apples", Foods.APPLE, SUGAR, BUTTER)
			.effect(COMFORT_BRIEF, 1);
	public static final FoodProperties APPLE_FRITTERS = EDFoods
			.addFoods("apple fritters", Foods.APPLE, SUGAR, OIL, SUGAR, FLOUR, FoodValues.FRIED_EGG)
			.effect(COMFORT_MEDIUM, 1);
	public static final FoodProperties CARAMEL_SAUCE = EDFoods.addFoods("caramel sauce", SUGAR, BUTTER, MILK);
	public static final FoodProperties CARAMEL_CANDY = EDFoods.divideFoods("caramel candy", CARAMEL_SAUCE, 4)
			.alwaysEdible();
	public static final FoodProperties CANDY = EDFoods.divideFoods("candy", SUGAR, 4).alwaysEdible();
	public static final FoodProperties CANDY_APPLE = EDFoods.addFoods("candy apple", Foods.APPLE, SUGAR, SUGAR);
	public static final FoodProperties CARAMEL_APPLE = EDFoods.addFoods("caramel apple", Foods.APPLE, CARAMEL_SAUCE);
	public static final FoodProperties CANDY_GOLDEN_APPLE = EDFoods.addFoods("candy apple", Foods.APPLE, SUGAR, SUGAR)
			.effect(EDFoods.GOLDEN_APPLE_1, 1).effect(EDFoods.GOLDEN_APPLE_2, 1);
	public static final FoodProperties CARAMEL_GOLDEN_APPLE = EDFoods
			.addFoods("caramel apple", Foods.APPLE, CARAMEL_SAUCE).effect(EDFoods.GOLDEN_APPLE_1, 1)
			.effect(EDFoods.GOLDEN_APPLE_2, 1);
	public static final FoodProperties CARAMEL_POPCORN = EDFoods.addFoods("caramel popcorn", COOKED_CORN,
			CARAMEL_SAUCE);

	public static final FoodProperties CORNBREAD = EDFoods
			.divideFoods("cornbread", EDFoods.addFoods("", FLOUR, FLOUR, SUGAR, BUTTER, FoodValues.FRIED_EGG), 2)
			.effect(EDFoods.NOURISHMENT_BRIEF, 1);
	public static final FoodProperties APPLE_CRISP = EDFoods
			.divideFoods("apple crisp", EDFoods.addFoods("", FLOUR, FLOUR, SUGAR, BUTTER, Foods.APPLE, Foods.APPLE), 2)
			.effect(EDFoods.COMFORT_MEDIUM, 1);
	public static final FoodProperties STUFFING = EDFoods.divideFoods("stuffing",
			EDFoods.addFoods("", SLICED_BREAD, FoodValues.BONE_BROTH, FoodValues.ONION, FoodValues.FRIED_EGG, BUTTER),
			3).effect(EDFoods.COMFORT_BRIEF, 1);
	public static final FoodProperties CORN_PUDDING = EDFoods
			.divideFoods("corn pudding",
					EDFoods.addFoods("", FLOUR, COOKED_CORN, SUGAR, FoodValues.FRIED_EGG, BUTTER, MILK), 2)
			.effect(EDFoods.COMFORT_MEDIUM, 1).effect(EDFoods.NOURISHMENT_BRIEF, 1);
	public static final FoodProperties POTATOES_AU_GRATIN = EDFoods
			.divideFoods("potatoes au gratin",
					EDFoods.addFoods("", FLOUR, CHEESE, BUTTER, MILK, Foods.BAKED_POTATO, Foods.BAKED_POTATO,
							Foods.BAKED_POTATO),
					4)
			.effect(EDFoods.COMFORT_MEDIUM, 1).effect(EDFoods.NOURISHMENT_MEDIUM, 1);

	public static final FoodProperties ICE_CREAM = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f)
			.fast().alwaysEdible();
	public static final FoodProperties TOPPED_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6)
			.saturationModifier(0.5f).fast().alwaysEdible();
	public static final FoodProperties COOKIE_DOUGH = (new FoodProperties.Builder()).nutrition(1)
			.saturationModifier(0.0f).effect(EDFoods.HUNGER, 0.1f);

	public static final FoodProperties FROSTING = EDFoods.divideFoods("frosting",
			EDFoods.addFoods("", BUTTER, WHIPPED_CREAM, SUGAR), 4);

	public static final FoodProperties CANDY_CANE = EDFoods.addFoods("candy cane", SUGAR, SUGAR, SUGAR, SUGAR)
			.alwaysEdible();

	public static final FoodProperties FRENCH_TOAST = EDFoods.divideFoods("french toast", EDFoods.addFoods("", BUTTER,
			SUGAR, FoodValues.FRIED_EGG, MILK, SLICED_BREAD, SLICED_BREAD, SLICED_BREAD, SLICED_BREAD), 4);

	public static final FoodProperties CONGEE = EDFoods.addFoods("congee", FoodValues.COOKED_RICE, SUGAR);

	public static final FoodProperties LUGAW = EDFoods.addFoods("lugaw", FoodValues.COOKED_RICE, SUGAR,
			FoodValues.ONION, FoodValues.BONE_BROTH, FoodValues.FRIED_EGG, Foods.COOKED_CHICKEN);

	public static final FoodProperties MUFFIN = EDFoods.divideFoods("muffin",
			EDFoods.addFoods("", BUTTER, SUGAR, SUGAR, FoodValues.FRIED_EGG, FLOUR, MILK), 6);

	public static final FoodProperties FILLED_BREAD = EDFoods.addFoods("filled bread", Foods.BREAD, Foods.APPLE);

	public static final FoodProperties PICKLED_GINGER = EDFoods.addFoods("pickled ginger", SUGAR, VINEGAR);

	public static final FoodProperties BEET_MINT = EDFoods.addFoods("beet mint", Foods.BEETROOT, Foods.BEETROOT, SUGAR,
			VINEGAR, OIL);

	public static final FoodProperties CRACKER = EDFoods.divideFoods("crackers", EDFoods.addFoods("", BUTTER, FLOUR),
			4);

	public static final FoodProperties CROQUE_MONSIEUR = EDFoods.addFoods("croque monsieur", BUTTER, FLOUR, MILK,
			SLICED_BREAD, CHEESE, Foods.COOKED_PORKCHOP);

	public static final FoodProperties CROQUE_MADAME = EDFoods.addFoods("croque madame", CROQUE_MONSIEUR,
			FoodValues.FRIED_EGG);

	public static final FoodProperties ROLL = EDFoods.divideFoods("roll",
			EDFoods.addFoods("", Foods.BREAD, Foods.BREAD), 6);

	public static final FoodProperties CINNAMON_ROLL = EDFoods.divideFoods("cinnamon roll",
			EDFoods.addFoods("", Foods.BREAD, SUGAR, BUTTER, FROSTING), 4);

	public static final FoodProperties MONKEY_BREAD = EDFoods.divideFoods("monkey bread",
			EDFoods.addFoods("", Foods.BREAD, SUGAR, BUTTER), 4);

	public static final FoodProperties MINT_LAMB = EDFoods.divideFoods("mint lamb", EDFoods.addFoods("",
			Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, Foods.BREAD, OIL), 4);

	public static final FoodProperties CHARCUTERIE = EDFoods.divideFoods("charcuterie",
			EDFoods.addFoods("", Foods.COOKED_PORKCHOP, CHEESE, CRACKER, Foods.COOKED_PORKCHOP, CHEESE, CRACKER), 4);

	public static final FoodProperties CHRISTMAS_PUDDING = EDFoods.divideFoods("christmas pudding", EDFoods.addFoods("",
			Foods.APPLE, Foods.APPLE, Foods.APPLE, FLOUR, FLOUR, SUGAR, SUGAR, FoodValues.FRIED_EGG), 4);

	public static final FoodProperties MILK_TART = EDFoods.divideFoods("milk tart",
			EDFoods.addFoods("", MILK, FLOUR, BUTTER, SUGAR, FoodValues.FRIED_EGG, FoodValues.PIE_CRUST), 4);

	public static FoodProperties addFoods(String name, FoodProperties... foods) {

		int nut = 0;
		float sat = 0;
		Builder b = new FoodProperties.Builder();

		for (int i = 0; i < foods.length; i++) {
			nut += foods[i].nutrition();
			sat += foods[i].saturation();
		}

//		if (name != "")
		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationModifier(sat);
	}

	public static FoodProperties divideFoods(String name, FoodProperties food, int by) {
		int nut = Math.max(food.nutrition() / by, 1);
		float sat = food.saturation() / by;
		Builder b = new FoodProperties.Builder();

//		if (name != "")
		ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationModifier(sat);
	}

	public static FoodProperties cookFood(String name, FoodProperties food) {
		if (name != "")
			ExtraDelight.logger.debug(name + ": " + (food.nutrition() + 4) + "," + (food.saturation() + 0.5f));
		return new FoodProperties.Builder().nutrition(food.nutrition() + 4)
				.saturationModifier(food.saturation() + 0.5f);
	}
}

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

	public static final Supplier<MobEffectInstance> COMFORT_BRIEF = () -> new MobEffectInstance(
			ModEffects.COMFORT.get(), FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_MEDIUM = () -> new MobEffectInstance(
			ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0);
	public static final Supplier<MobEffectInstance> COMFORT_LONG = () -> new MobEffectInstance(ModEffects.COMFORT.get(),
			FoodValues.LONG_DURATION, 0);

	public static final Supplier<MobEffectInstance> NOURISHMENT_BRIEF = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT.get(), FoodValues.BRIEF_DURATION, 0);
	public static final Supplier<MobEffectInstance> NOURISHMENT_MEDIUM = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0);
	public static final Supplier<MobEffectInstance> NOURISHMENT_LONG = () -> new MobEffectInstance(
			ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0);

	public static final Supplier<MobEffectInstance> GLOW_SHORT = () -> new MobEffectInstance(MobEffects.GLOWING,
			FoodValues.SHORT_DURATION, 0);

	public static final Supplier<MobEffectInstance> PAIN = () -> new MobEffectInstance(MobEffects.HARM, 1, 0);

	public static final FoodProperties NOTFOOD = new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat()
			.build();

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
	public static final FoodProperties SLICED_ONION = EDFoods.divideFoods("sliced onion", FoodValues.ONION, 4).build();
	public static final FoodProperties SLICED_TOMATO = EDFoods.divideFoods("sliced tomato", FoodValues.TOMATO, 4)
			.build();
	public static final FoodProperties BADFOOD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 0.8F).build();

	// Basic Cooked Items
	public static final FoodProperties COOKED_CARROT = new FoodProperties.Builder().nutrition(5).saturationMod(0.5f)
			.build();
	public static final FoodProperties COOKED_APPLE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5f)
			.build();

	public static final FoodProperties SLICED_BREAD = EDFoods.divideFoods("sliced bread", Foods.BREAD, 4).build();
	public static final FoodProperties BREADING = EDFoods
			.addFoods("breading", FLOUR, OIL, FoodValues.FRIED_EGG, SLICED_BREAD).build();
	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F)
			.effect(HUNGER, 0.3F).build();

	// BC basics
	public static final FoodProperties COOKED_SAUSAGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties COOKED_BRAIN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties COOKED_HEART = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties COOKED_LIVER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties COOKED_LUNG = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F)
			.meat().build();
	public static final FoodProperties COOKED_STOMACH = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F)
			.meat().build();
	public static final FoodProperties COOKED_TRIPE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F)
			.meat().build();

	// Condiments
	public static final FoodProperties MAYO = EDFoods
			.divideFoods("mayo raw", EDFoods.addFoods("", FoodValues.FRIED_EGG, FoodValues.FRIED_EGG, OIL).build(), 4)
			.effect(HUNGER, 1.0F).build();

	public static final FoodProperties BBQ = EDFoods.divideFoods("bbq raw",
			EDFoods.addFoods("", FoodValues.TOMATO, FoodValues.ONION, SUGAR, VINEGAR).build(), 4).effect(HUNGER, 1.0F)
			.build();

	public static final FoodProperties KETCHUP = EDFoods
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
			.divideFoods("quiche", EDFoods.addFoods("", OMELETTE, Foods.BREAD).build(), 4).effect(NOURISHMENT_BRIEF, 1)
			.build();

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
			.divideFoods("potato soup", EDFoods
					.addFoods("", Foods.POTATO, Foods.POTATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK).build(), 2)
			.effect(COMFORT_LONG, 1).build();

	public static final FoodProperties TOMATO_SOUP = EDFoods.divideFoods("tomato soup", EDFoods
			.addFoods("", FoodValues.TOMATO, FoodValues.TOMATO, FoodValues.ONION, FoodValues.BONE_BROTH, MILK).build(),
			2).effect(COMFORT_LONG, 1).build();

	public static final FoodProperties FISH_SOUP = EDFoods.divideFoods("fish soup", EDFoods
			.addFoods("", Foods.COD, Foods.COD, FoodValues.ONION, FoodValues.BONE_BROTH, Foods.DRIED_KELP).build(), 2)
			.effect(COMFORT_LONG, 1).build();

	public static final FoodProperties CARROT_SOUP = EDFoods
			.divideFoods("carrot soup", EDFoods
					.addFoods("", Foods.CARROT, Foods.CARROT, FoodValues.ONION, FoodValues.BONE_BROTH, MILK).build(), 2)
			.effect(COMFORT_LONG, 1).build();

	// Butchercraft
	public static final FoodProperties SALISBURY_STEAK = EDFoods
			.divideFoods("salisbury steak",
					EDFoods.addFoods("", FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY,
							FoodValues.ONION, MUSHROOM, MILK).build(),
					4)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_MEDIUM, 1).build();
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

	public static final FoodProperties CURRY = EDFoods.divideFoods("curry", EDFoods.addFoods("", Foods.COOKED_CHICKEN,
			Foods.BAKED_POTATO, EDFoods.COOKED_CARROT, FoodValues.BONE_BROTH, FoodValues.ONION).build(), 4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties BEEF_STEW_RICE = EDFoods
			.addFoods("beef stew rice", FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties PORK_STEW_RICE = EDFoods
			.addFoods("pork stew rice", EDFoods.PORK_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties LAMB_STEW_RICE = EDFoods
			.addFoods("lamb stew rice", EDFoods.LAMB_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties RABBIT_STEW_RICE = EDFoods
			.addFoods("rabbit stew rice", Foods.RABBIT_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties CHICKEN_STEW_RICE = EDFoods
			.addFoods("chicken stew rice", EDFoods.CHICKEN_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1)
			.build();
	public static final FoodProperties FISH_STEW_RICE = EDFoods
			.addFoods("fish stew rice", FoodValues.FISH_STEW, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties CURRY_RICE = EDFoods
			.addFoods("curry stew rice", EDFoods.CURRY, FoodValues.COOKED_RICE).effect(COMFORT_LONG, 1).build();

	// TODO: Sort these in the right categories, split if needed, add
	// nourishment/comfort
	public static final FoodProperties COOKED_PASTA = EDFoods.cookFood("cooked pasta", FoodValues.RAW_PASTA).build();
	public static final FoodProperties BUTTERED_PASTA = EDFoods
			.addFoods("buttered pasta", EDFoods.COOKED_PASTA, EDFoods.BUTTER).effect(COMFORT_BRIEF, 1).build();
	public static final FoodProperties FRIED_FISH = EDFoods.addFoods("fried fish", Foods.COOKED_COD, EDFoods.BREADING)
			.build();
	public static final FoodProperties CHICKEN_FRIED_STEAK = EDFoods
			.addFoods("chicken fried steak", Foods.COOKED_BEEF, EDFoods.BREADING, EDFoods.GRAVY)
			.effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties PORK_TENDERLOIN = EDFoods
			.addFoods("pork tenderloin", Foods.PORKCHOP, EDFoods.BREADING).build();
	public static final FoodProperties PORK_TENDERLOIN_SANDWICH = EDFoods
			.addFoods("pork tenderloin sandwich", EDFoods.PORK_TENDERLOIN, Foods.BREAD).build();
	public static final FoodProperties CHEESE_SANDWICH = EDFoods
			.addFoods("cheese sandwich", EDFoods.SLICED_BREAD, EDFoods.SLICED_BREAD, EDFoods.CHEESE, EDFoods.BUTTER)
			.build();
	public static final FoodProperties GRILLED_CHEESE = EDFoods.cookFood("grilled cheese", EDFoods.CHEESE_SANDWICH)
			.build();
	public static final FoodProperties AGAR_AGAR_POWDER = EDFoods
			.addFoods("agar agar powder", Foods.DRIED_KELP, Foods.DRIED_KELP, Foods.DRIED_KELP).build();

	// hash feast&derivatives
	public static final FoodProperties HASH_FEAST = EDFoods
			.addFoods("hash feast", Foods.POTATO, Foods.POTATO, FoodValues.ONION, EDFoods.OIL, Foods.COOKED_PORKCHOP)
			.build();
	public static final FoodProperties HASH_SERVING = EDFoods.divideFoods("hash", EDFoods.HASH_FEAST, 4)
			.effect(COMFORT_BRIEF, 1).build();

	// meat loaf feast&derivatives
	public static final FoodProperties MEAT_LOAF_FEAST = EDFoods
			.addFoods("meat loaf feast", EDFoods.KETCHUP, EDFoods.SLICED_BREAD, EDFoods.SCRAMBLED_EGGS,
					FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, FoodValues.ONION)
			.build();
	public static final FoodProperties MEAT_LOAF_SERVING = EDFoods
			.divideFoods("meat loaf plate", EDFoods.MEAT_LOAF_FEAST, 4).effect(COMFORT_LONG, 1).build();
	public static final FoodProperties MEAT_LOAF_SANDWICH = EDFoods
			.addFoods("meat loaf sandwich", EDFoods.MEAT_LOAF_SERVING, Foods.BREAD).effect(COMFORT_LONG, 1)
			.effect(NOURISHMENT_MEDIUM, 1).build();

	// meat pie&derivatives
	public static final FoodProperties MEAT_PIE_WHOLE = EDFoods.addFoods("meat pie whole", FoodValues.BEEF_PATTY,
			FoodValues.BEEF_PATTY, FoodValues.BEEF_PATTY, EDFoods.MUSHROOM, Foods.POTATO, FoodValues.ONION).build();
	public static final FoodProperties MEAT_PIE_SLICE = EDFoods.divideFoods("meat pie slice", EDFoods.MEAT_PIE_WHOLE, 4)
			.effect(COMFORT_BRIEF, 1).build();

	// pulled pork feast&derivatives
	public static final FoodProperties PULLED_PORK_FEAST = EDFoods.addFoods("pulled pork feast", Foods.COOKED_PORKCHOP,
			Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, EDFoods.BBQ)
			.build();
	public static final FoodProperties PULLED_PORK_SERVING = EDFoods
			.divideFoods("pulled pork serving", EDFoods.PULLED_PORK_FEAST, 4).build();
	public static final FoodProperties PULLED_PORK_SANDWICH = EDFoods
			.addFoods("pulled pork sandwich", EDFoods.PULLED_PORK_SERVING, Foods.BREAD).effect(NOURISHMENT_MEDIUM, 1)
			.build();

	// stirfry feast&derivatives
	public static final FoodProperties STIRFRY = EDFoods.addFoods("stirfry feast", Foods.COOKED_PORKCHOP,
			Foods.COOKED_PORKCHOP, Foods.CARROT, Foods.CARROT, Foods.CARROT, Foods.CARROT).build();
	public static final FoodProperties STIRFRY_SERVING = EDFoods.divideFoods("stirfry serving", EDFoods.STIRFRY, 4)
			.effect(NOURISHMENT_MEDIUM, 1).build();
	public static final FoodProperties STIRFRY_AND_RICE = EDFoods
			.addFoods("stirfry and rice", EDFoods.STIRFRY_SERVING, FoodValues.COOKED_RICE).effect(NOURISHMENT_MEDIUM, 1)
			.effect(COMFORT_MEDIUM, 1).build();

	// jelly feast&derivatives
	public static final FoodProperties JELLY_FEAST = EDFoods
			.addFoods("jelly feast", EDFoods.MILK, Foods.SWEET_BERRIES, EDFoods.SUGAR, EDFoods.AGAR_AGAR_POWDER)
			.build();
	public static final FoodProperties JELLY_SERVING = EDFoods.divideFoods("jelly serving", EDFoods.JELLY_FEAST, 4)
			.build();

	// mac and cheese feast&derivatives
	public static final FoodProperties MACARONI_CHEESE_FEAST = EDFoods.addFoods("mac and cheese feast", Foods.BREAD,
			Foods.BREAD, EDFoods.BUTTER, EDFoods.MILK, EDFoods.CHEESE, EDFoods.CHEESE).build();
	public static final FoodProperties MACARONI_CHEESE_SERVING = EDFoods
			.divideFoods("mac and cheese serving", EDFoods.MACARONI_CHEESE_FEAST, 4).build();

	// lasagna feast&derivatives
	public static final FoodProperties LASAGNA_FEAST = EDFoods
			.addFoods("lasagna feast", EDFoods.CHEESE, EDFoods.CHEESE, FoodValues.TOMATO_SAUCE, FoodValues.TOMATO_SAUCE,
					Foods.BREAD, Foods.BREAD, Foods.BREAD, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP)
			.build();
	public static final FoodProperties LASAGNA_SERVING = EDFoods
			.divideFoods("lasagna serving", EDFoods.LASAGNA_FEAST, 4).effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties JERKY = EDFoods.addFoods("jerky", Foods.COOKED_PORKCHOP).build();

	public static final FoodProperties SAUSAGE_ROLL = EDFoods.addFoods("sausage roll", Foods.BREAD, COOKED_SAUSAGE)
			.build();

	public static final FoodProperties SOS = EDFoods.addFoods("sos", Foods.COOKED_BEEF, FLOUR, MILK, SLICED_BREAD)
			.build();

	public static final FoodProperties LIVERONION = EDFoods.addFoods("liver onions", COOKED_LIVER, FoodValues.ONION)
			.effect(NOURISHMENT_MEDIUM, 1).build();

	public static final FoodProperties FRIED_CHICKEN = EDFoods.addFoods("fried chicken", Foods.COOKED_CHICKEN, BREADING)
			.effect(COMFORT_BRIEF, 1).build();

	public static final FoodProperties STUFFED_HEART = EDFoods
			.addFoods("stuffed heart", COOKED_HEART, SLICED_BREAD, MUSHROOM, FoodValues.ONION, FoodValues.FRIED_EGG)
			.build();

	public static final FoodProperties FRIED_BRAIN = EDFoods.addFoods("fried brain", COOKED_BRAIN, BREADING).build();

	public static final FoodProperties OXTAIL_SOUP = EDFoods
			.addFoods("oxtail soup", Foods.BEEF, COOKED_CARROT, FoodValues.BONE_BROTH, FoodValues.TOMATO)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_MEDIUM, 1).build();

	public static final FoodProperties POT_ROAST_FEAST = EDFoods.addFoods("pot roast feast", Foods.COOKED_BEEF,
			COOKED_CARROT, COOKED_CARROT, FoodValues.ONION, Foods.BAKED_POTATO, Foods.BAKED_POTATO).build();
	public static final FoodProperties POT_ROAST = EDFoods.divideFoods("pot roast", POT_ROAST_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_MEDIUM, 1).build();

	public static final FoodProperties BBQ_RIBS_FEAST = EDFoods
			.addFoods("bbq ribs feast", Foods.COOKED_BEEF, Foods.COOKED_BEEF, Foods.COOKED_BEEF, Foods.COOKED_BEEF, BBQ)
			.build();
	public static final FoodProperties BBQ_RIBS = EDFoods.divideFoods("bbq ribs", BBQ_RIBS_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties RACK_LAMB_FEAST = EDFoods
			.addFoods("rack lamb feast", Foods.COOKED_MUTTON, Foods.COOKED_MUTTON, Foods.COOKED_MUTTON,
					Foods.COOKED_MUTTON, FoodValues.ONION, OIL, Foods.BREAD, Foods.SWEET_BERRIES, Foods.SWEET_BERRIES)
			.build();
	public static final FoodProperties RACK_LAMB = EDFoods.divideFoods("rack lamb", RACK_LAMB_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties WELLINGTON_FEAST = EDFoods.addFoods("wellington feast", Foods.COOKED_BEEF,
			Foods.BREAD, MUSHROOM, MUSHROOM, COOKED_LIVER, BUTTER, FoodValues.COOKED_BACON, FoodValues.ONION).build();
	public static final FoodProperties WELLINGTON = EDFoods.divideFoods("wellington", WELLINGTON_FEAST, 4)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_MEDIUM, 1).build();

	public static final FoodProperties HAGGIS_FEAST = EDFoods.addFoods("haggis feast", COOKED_STOMACH, COOKED_LIVER,
			COOKED_LIVER, COOKED_LIVER, COOKED_LUNG, FLOUR, FLOUR, FLOUR, Foods.COOKED_MUTTON).build();
	public static final FoodProperties HAGGIS = EDFoods.divideFoods("haggis", HAGGIS_FEAST, 4)
			.effect(NOURISHMENT_MEDIUM, 1).effect(COMFORT_MEDIUM, 1).build();

	public static final FoodProperties HOTDISH_FEAST = EDFoods.addFoods("hotdish feast", Foods.BAKED_POTATO,
			Foods.BAKED_POTATO, Foods.BAKED_POTATO, Foods.COOKED_PORKCHOP, Foods.COOKED_PORKCHOP, EDFoods.POTATO_SOUP,
			EDFoods.POTATO_SOUP, EDFoods.COOKED_CARROT, EDFoods.COOKED_CARROT).build();
	public static final FoodProperties HOTDISH = EDFoods.divideFoods("hotdish", HOTDISH_FEAST, 4)
			.effect(COMFORT_LONG, 1).effect(NOURISHMENT_LONG, 1).build();

	public static final FoodProperties FURIKAKE_RICE = EDFoods.addFoods("furikake rice", FoodValues.COOKED_RICE)
			.effect(DOLPHIN_BRIEF, 1).build();
	public static final FoodProperties FISH_CAKES = EDFoods
			.addFoods("", Foods.COOKED_COD, Foods.BAKED_POTATO, FoodValues.ONION, BREADING).build();
	public static final FoodProperties FISH_CHIPS = EDFoods.addFoods("fish chips", FRIED_FISH, FRIED_POTATO)
			.effect(NOURISHMENT_MEDIUM, 1).build();
	public static final FoodProperties FRIED_MUSHROOMS = EDFoods
			.divideFoods("fried mushrooms", EDFoods.addFoods("", MUSHROOM, MUSHROOM, MUSHROOM, BREADING).build(), 3)
			.build();
	public static final FoodProperties MUSHROOM_RISOTTO = EDFoods.divideFoods("mushroom risotto", EDFoods
			.addFoods("", MUSHROOM, CHEESE, BUTTER, FoodValues.BONE_BROTH, FoodValues.ONION, FoodValues.COOKED_RICE)
			.build(), 2).effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties STUFFED_MUSHROOMS = EDFoods.divideFoods("stuffed mushrooms",
			EDFoods.addFoods("stuffed mushrooms", MUSHROOM, MUSHROOM, MUSHROOM, CHEESE, BUTTER, SLICED_BREAD).build(),
			3).build();
	public static final FoodProperties MUSHROOM_BURGER = EDFoods
			.addFoods("mushroom burger", FoodValues.BEEF_PATTY, MUSHROOM, MUSHROOM, CHEESE, SLICED_BREAD).build();
	public static final FoodProperties BACON_EGG_SANDWICH = EDFoods
			.addFoods("bacon egg sandwich", FoodValues.EGG_SANDWICH, FoodValues.COOKED_BACON).build();
	public static final FoodProperties BACON_EGG_CHEESE_SANDWICH = EDFoods
			.addFoods("bacon egg cheese sandwich", FoodValues.EGG_SANDWICH, FoodValues.COOKED_BACON, CHEESE).build();
	public static final FoodProperties BUTTERED_TOAST = EDFoods.addFoods("buttered toast", SLICED_BREAD, BUTTER)
			.build();
	public static final FoodProperties SALAD = EDFoods
			.divideFoods("chef salad",
					EDFoods.addFoods("", FoodValues.CABBAGE, FoodValues.ONION, Foods.CARROT, SLICED_BREAD, CHEESE, OIL,
							VINEGAR, FoodValues.FRIED_EGG, Foods.PORKCHOP).build(),
					4)
			.effect(NOURISHMENT_MEDIUM, 1).build();
	public static final FoodProperties ALFREDO_SAUCE = EDFoods.addFoods("alfredo sauce", MILK, CHEESE, BUTTER).build();
	public static final FoodProperties PASTA_TOMATO = EDFoods
			.addFoods("pasta tomato", Foods.BREAD, FoodValues.TOMATO_SAUCE).build();
	public static final FoodProperties PASTA_ALFREDO = EDFoods.addFoods("pasta alfredo", Foods.BREAD, ALFREDO_SAUCE)
			.effect(COMFORT_BRIEF, 1).build();
	public static final FoodProperties CHICKEN_ALFREDO = EDFoods
			.addFoods("chicken alfredo", Foods.COOKED_CHICKEN, PASTA_ALFREDO).effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties CHICKEN_PARM = EDFoods.divideFoods("chicken parm",
			EDFoods.addFoods("", FRIED_CHICKEN, FoodValues.TOMATO_SAUCE, CHEESE).build(), 2).effect(COMFORT_MEDIUM, 1)
			.build();
	public static final FoodProperties CHEESEBURGER = EDFoods.addFoods("cheeseburger", FoodValues.HAMBURGER, CHEESE)
			.effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties BACON_CHEESEBURGER = EDFoods
			.addFoods("bacon cheeseburger", CHEESEBURGER, FoodValues.COOKED_BACON).effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties RICEBALL = EDFoods
			.divideFoods("riceball", EDFoods.addFoods("", Foods.DRIED_KELP, FoodValues.COOKED_RICE).build(), 2)
			.effect(NOURISHMENT_BRIEF, 1).build();
	public static final FoodProperties RICEBALL_FILLED = EDFoods
			.addFoods("riceball filled", RICEBALL, FoodValues.FRIED_EGG).effect(NOURISHMENT_MEDIUM, 1).build();
	public static final FoodProperties FISH_SALAD = EDFoods
			.divideFoods("fish salad", EDFoods.addFoods("", Foods.COOKED_COD, Foods.COOKED_COD, MAYO).build(), 2)
			.build();
	public static final FoodProperties FISH_SALAD_SANDWICH = EDFoods
			.addFoods("fish salad sandwich", FISH_SALAD, SLICED_BREAD, SLICED_BREAD).build();
	public static final FoodProperties SEAWEED_CRISPS = EDFoods
			.addFoods("seaweed crisps", Foods.DRIED_KELP, Foods.DRIED_KELP, FLOUR, OIL).build();
	public static final FoodProperties SEAWEED_SALAD = EDFoods
			.addFoods("seaweed salad", Foods.DRIED_KELP, Foods.DRIED_KELP, Foods.CARROT, VINEGAR).build();

	public static final FoodProperties CACTUS = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
			.effect(PAIN, 1).build();
	public static final FoodProperties COOKED_CACTUS = EDFoods.cookFood("cooked cactus", CACTUS).build();
	public static final FoodProperties CACTUS_EGGS = EDFoods.addFoods("cactus eggs", COOKED_CACTUS, SCRAMBLED_EGGS)
			.build();
	public static final FoodProperties CACTUS_SOUP = EDFoods
			.divideFoods("cactus soup",
					EDFoods.addFoods("", COOKED_CACTUS, COOKED_CACTUS, FoodValues.TOMATO, FoodValues.ONION,
							FoodValues.BONE_BROTH).build(),
					2)
			.effect(COMFORT_MEDIUM, 1).effect(NOURISHMENT_BRIEF, 1).build();
	public static final FoodProperties CACTUS_SALAD = EDFoods
			.addFoods("cactus salad", COOKED_CACTUS, FoodValues.TOMATO, FoodValues.ONION, CHEESE).build();
	public static final FoodProperties STUFFED_CACTUS = EDFoods
			.addFoods("stuffed cactus", COOKED_CACTUS, BREADING, CHEESE).effect(COMFORT_MEDIUM, 1).build();

	// Halloween Start!
	public static final FoodProperties COOKED_CORN = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
			.build();
	public static final FoodProperties GRILLED_CORN = new FoodProperties.Builder().nutrition(3).saturationMod(0.2f)
			.build();

	public static final FoodProperties CORN_CHOWDER = EDFoods.addFoods("corn chowder", COOKED_CORN, Foods.BAKED_POTATO,
			FoodValues.COOKED_BACON, FoodValues.ONION, MILK, FoodValues.BONE_BROTH).effect(COMFORT_MEDIUM, 1).build();
	public static final FoodProperties CREAMED_CORN = EDFoods.addFoods("creamed corn", COOKED_CORN, MILK, BUTTER)
			.build();
	public static final FoodProperties CORN_FRITTERS = EDFoods
			.addFoods("corn fritters", COOKED_CORN, FoodValues.FRIED_EGG, SUGAR, FLOUR, OIL, FoodValues.ONION).build();
	public static final FoodProperties STEWED_APPLES = EDFoods.addFoods("stewed apples", Foods.APPLE, SUGAR, BUTTER)
			.build();
	public static final FoodProperties APPLE_FRITTERS = EDFoods
			.addFoods("apple fritters", Foods.APPLE, SUGAR, OIL, SUGAR, FLOUR, FoodValues.FRIED_EGG).build();
	public static final FoodProperties CARAMEL_SAUCE = EDFoods.addFoods("caramel sauce", SUGAR, BUTTER, MILK).build();
	public static final FoodProperties CARAMEL_CANDY = EDFoods.divideFoods("caramel candy", CARAMEL_SAUCE, 2).build();
	public static final FoodProperties CANDY_APPLE = EDFoods.addFoods("candy apple", Foods.APPLE, SUGAR, SUGAR).build();
	public static final FoodProperties CARAMEL_APPLE = EDFoods.addFoods("caramel apple", Foods.APPLE, CARAMEL_SAUCE)
			.build();
	public static final FoodProperties CARAMEL_POPCORN = EDFoods.addFoods("caramel popcorn", COOKED_CORN, CARAMEL_SAUCE)
			.build();

	public static final FoodProperties CORNBREAD = EDFoods.divideFoods("cornbread",
			EDFoods.addFoods("", FLOUR, FLOUR, SUGAR, BUTTER, FoodValues.FRIED_EGG).build(), 4).build();
	public static final FoodProperties APPLE_CRISP = EDFoods.divideFoods("apple crisp",
			EDFoods.addFoods("", FLOUR, FLOUR, SUGAR, BUTTER, Foods.APPLE, Foods.APPLE).build(), 4).build();
	public static final FoodProperties STUFFING = EDFoods.divideFoods("stuffing", EDFoods
			.addFoods("", SLICED_BREAD, FoodValues.BONE_BROTH, FoodValues.ONION, FoodValues.FRIED_EGG, BUTTER).build(), 4).build();
	public static final FoodProperties CORN_PUDDING = EDFoods.divideFoods("corn pudding", EDFoods
			.addFoods("", FLOUR, COOKED_CORN, SUGAR, FoodValues.FRIED_EGG, BUTTER, MILK).build(), 4).build();
	public static final FoodProperties POTATOES_AU_GRATIN = EDFoods.divideFoods("potatoes au gratin", EDFoods
			.addFoods("", FLOUR, CHEESE, BUTTER, MILK, Foods.BAKED_POTATO, Foods.BAKED_POTATO, Foods.BAKED_POTATO).build(), 4).build();

	public static Builder addFoods(String name, FoodProperties... foods) {

		int nut = 0;
		float sat = 0;
		Builder b = new FoodProperties.Builder();

		for (int i = 0; i < foods.length; i++) {
			nut += foods[i].getNutrition();
			sat += foods[i].getSaturationModifier();
		}

		if (name != "")
			ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationMod(sat);
	}

	public static Builder divideFoods(String name, FoodProperties food, int by) {
		int nut = food.getNutrition() / by;
		float sat = food.getSaturationModifier() / by;
		Builder b = new FoodProperties.Builder();

		if (name != "")
			ExtraDelight.logger.debug(name + ": " + nut + "," + sat);
		return b.nutrition(nut).saturationMod(sat);
	}

	public static Builder cookFood(String name, FoodProperties food) {
		if (name != "")
			ExtraDelight.logger
					.debug(name + ": " + (food.getNutrition() + 4) + "," + (food.getSaturationModifier() + 0.5f));
		return new FoodProperties.Builder().nutrition(food.getNutrition() + 4)
				.saturationMod(food.getSaturationModifier() + 0.5f);
	}
}

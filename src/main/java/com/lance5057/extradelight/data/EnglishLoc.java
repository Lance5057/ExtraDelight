package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.TranslatableKeys;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {

	public EnglishLoc(DataGenerator gen) {
		super(gen, ExtraDelight.MOD_ID, "en_us");

	}

	@Override
	protected void addTranslations() {
		this.add("itemGroup.extradelight.items", "Extra Delight");
		this.add("itemGroup.extradelight.aesthetic", "Extra Delight Aesthetic");

		this.add("farmersdelight.tooltip.oven.empty", "");
		this.add("container.doughshaper", "Dough Shaping");
		
		this.add("extradelight.dynamicname.1", "%s");
		this.add("extradelight.dynamicname.2", "%s %s");
		this.add("extradelight.dynamicname.3", "%s and %s %s");
		this.add("extradelight.dynamicname.4", "%s, %s and %s %s");
		this.add("extradelight.dynamicname.5", "%s, %s, %s and %s %s");
		this.add("extradelight.dynamicname.6", "%s, %s, %s, %s and %s %s");
		this.add("extradelight.dynamicname.7", "%s, %s, %s, %s, %s and %s %s");
		this.add("extradelight.dynamicname.8", "%s, %s, %s, %s, %s, %s and %s %s");
		this.add("extradelight.dynamicname.9", "%s, %s, %s, %s, %s, %s, %s and %s %s");
		this.add("extradelight.jei.oven", "Oven");
		this.add("extradelight.jei.mixingbowl", "Mixing Bowl");
		this.add("extradelight.jei.dryingrack", "Drying Rack");
		this.add("extradelight.jei.feast", "Feast Servings");
		this.add("extradelight.jei.mortar", "Mortar");
		this.add("extradelight.jei.doughshaping", "Dough Shaping");
		
		this.add("extradelight.corn_dimension.death", "Be more careful in the cornfield next time...");
		
		this.add(ExtraDelight.MOD_ID + ".yeastpot.tooltip", "Use a bottle once the pot begins to bubble.");
		this.add(ExtraDelight.MOD_ID + ".vinegarpot.tooltip", "Use a bottle once the pot begins to bubble.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.start.name", "Extra Delight");
		this.add(ExtraDelight.MOD_ID + ".advancement.start.desc", "Feeling a little extra.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.grater.name", "It's Grate");
		this.add(ExtraDelight.MOD_ID + ".advancement.grater.desc", "Use the grater to grate an ingredient.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.spoon.name", "Tick Approved");
		this.add(ExtraDelight.MOD_ID + ".advancement.spoon.desc", "Make a spoon, you're gonna need it.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.mixingbowl.name", "Normal Sized Cereal Bowl");
		this.add(ExtraDelight.MOD_ID + ".advancement.mixingbowl.desc", "Make a mixing bowl.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.oven.name", "Hot Box");
		this.add(ExtraDelight.MOD_ID + ".advancement.oven.desc", "Make an oven and start preparing even more meals!");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.trays.name", "A Worthy Vessel");
		this.add(ExtraDelight.MOD_ID + ".advancement.trays.desc", "The oven requires baking vessels for its recipes. Make one of each.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.mortar.name", "The Daily Grind");
		this.add(ExtraDelight.MOD_ID + ".advancement.mortar.desc", "Make or find a mortar.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.grind.name", "Crushing Power");
		this.add(ExtraDelight.MOD_ID + ".advancement.grind.desc", "Make or find a pestle.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.flour.name", "A Little Less Ruffage");
		this.add(ExtraDelight.MOD_ID + ".advancement.flour.desc", "Make some flour and make your bread less fiberous.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.amethyst.name", "Regal Purple");
		this.add(ExtraDelight.MOD_ID + ".advancement.amethyst.desc", "Find an Amethyst set.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.gildedblackstone.name", "Deep Shimmer");
		this.add(ExtraDelight.MOD_ID + ".advancement.gildedblackstone.desc", "Find a Gilded Blackstone set.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.doughshaping.name", "I Kneed it");
		this.add(ExtraDelight.MOD_ID + ".advancement.doughshaping.desc", "Make a Dough Shaping Station to work dough into different forms.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.hellskitchen.name", "Hell's Kitchen");
		this.add(ExtraDelight.MOD_ID + ".advancement.hellskitchen.desc", "Make a Netherite utensil set.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.noodles.name", "Oodles Of Noodles");
		this.add(ExtraDelight.MOD_ID + ".advancement.noodles.desc", "Make all available pasta.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.dryingrack.name", "Hydrophobic");
		this.add(ExtraDelight.MOD_ID + ".advancement.dryingrack.desc", "Make a drying rack to dry out ingredients.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.yeastpot.name", "Micro Flatulance");
		this.add(ExtraDelight.MOD_ID + ".advancement.yeastpot.desc", "Make a yeast pot and, once it starts to bubble, get yeast.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.vinegarpot.name", "Positively Pickled");
		this.add(ExtraDelight.MOD_ID + ".advancement.vinegarpot.desc", "Make a vinegar pot and, once it starts to bubble, get vinegar.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.jelly.name", "A Bouncy Castle For Ants");
		this.add(ExtraDelight.MOD_ID + ".advancement.jelly.desc", "Make some Jelly!");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.jellyall.name", "Taste The Rainbow");
		this.add(ExtraDelight.MOD_ID + ".advancement.jellyall.desc", "Make all the Jelly!");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.food.name", "A Small Smackerel");
		this.add(ExtraDelight.MOD_ID + ".advancement.food.desc", "Eat something will ya?");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.badfood.name", "Wall Chicken");
		this.add(ExtraDelight.MOD_ID + ".advancement.badfood.desc", "Maybe eating something you found in a dungeon wasn't the best idea...");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.cactusjuice.name", "It'll Quench Ya!");
		this.add(ExtraDelight.MOD_ID + ".advancement.cactusjuice.desc", "Drink the cactus juice and learn the effects.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.feasts.name", "All You Can Eat Buffet");
		this.add(ExtraDelight.MOD_ID + ".advancement.feasts.desc", "Make every available feast.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.meals.name", "True Gourmand");
		this.add(ExtraDelight.MOD_ID + ".advancement.meals.desc", "Make every available meal.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.desert.name", "There's Always Room");
		this.add(ExtraDelight.MOD_ID + ".advancement.desert.desc", "Make every available desert.");
		
		this.add(ExtraDelight.MOD_ID + ".advancement.ingredients.name", "Sous Chef");
		this.add(ExtraDelight.MOD_ID + ".advancement.ingredients.desc", "Aquire and prepare every ingredient.");

		this.add(ExtraDelightItems.BAKING_STONE.get(), "Baking Stone");
		this.add(ExtraDelightItems.CHEESECAKE_ITEM.get(), "Cheesecake");
		this.add(ExtraDelightItems.CHEESECAKE_SLICE.get(), "Slice of Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get(), "Chocolate Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get(), "Slice of Chocolate Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), "Chocolate Custard");
		this.add(ExtraDelightItems.DOUGH_SHAPING.get(), "Dough Shaping Station");
		this.add(ExtraDelightItems.FLOUR.get(), "Flour");
		this.add(ExtraDelightItems.FOOD_DISPLAY.get(), "Food Display");
		this.add(ExtraDelightItems.FUDGE_POPSICLE.get(), "Fudgsicle");
		this.add(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get(), "Glow Berry Cheesecake");
		this.add(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get(), "Slice of Glow Berry Cheesecake");
		this.add(ExtraDelightItems.GLOW_BERRY_COOKIE.get(), "Glow Berry Cookie");
		this.add(ExtraDelightItems.GLOW_BERRY_JUICE.get(), "Glow Berry Juice");
		this.add(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get(), "Glow Berry Pie");
		this.add(ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get(), "Slice of Glow Berry Pie");
		this.add(ExtraDelightItems.GLOW_BERRY_POPSICLE.get(), "Glowpop");
		this.add(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get(), "Honey Cheesecake");
		this.add(ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get(), "Slice of Honey Cheesecake");
		this.add(ExtraDelightItems.HONEY_CUSTARD.get(), "Honey Custard");
		this.add(ExtraDelightItems.HONEY_POPSICLE.get(), "Honey Cream Popsicle");
		this.add(ExtraDelightItems.LOAF_PAN.get(), "Loaf Pan");
		this.add(ExtraDelightItems.MIXING_BOWL.get(), "Mixing Bowl");
		this.add(ExtraDelightItems.DRYING_RACK.get(), "Drying Rack");
		this.add(ExtraDelightItems.GRATER.get(), "Box Grater");
		this.add(ExtraDelightItems.STONE_SPOON.get(), "Stone Spoon");
		this.add(ExtraDelightItems.DIAMOND_SPOON.get(), "Diamond Spoon");
		this.add(ExtraDelightItems.GOLD_SPOON.get(), "Gold Spoon");
		this.add(ExtraDelightItems.IRON_SPOON.get(), "Iron Spoon");
		this.add(ExtraDelightItems.NETHERITE_SPOON.get(), "Netherite Spoon");
		this.add(ExtraDelightItems.VINEGAR_POT.get(), "Vinegar Pot");

		this.add(ExtraDelightItems.MORTAR_AMETHYST.get(), "Amethyst Mortar");
		this.add(ExtraDelightItems.MORTAR_ANDESITE.get(), "Andesite Mortar");
		this.add(ExtraDelightItems.MORTAR_BASALT.get(), "Basalt Mortar");
		this.add(ExtraDelightItems.MORTAR_BLACKSTONE.get(), "Blackstone Mortar");
		this.add(ExtraDelightItems.MORTAR_DEEPSLATE.get(), "Deepslate Mortar");
		this.add(ExtraDelightItems.MORTAR_DIORITE.get(), "Diorite Mortar");
		this.add(ExtraDelightItems.MORTAR_ENDSTONE.get(), "Endstone Mortar");
		this.add(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get(), "Gilded Blackstone Mortar");
		this.add(ExtraDelightItems.MORTAR_GRANITE.get(), "Granite Mortar");
		this.add(ExtraDelightItems.MORTAR_STONE.get(), "Stone Mortar");

		this.add(ExtraDelightItems.MUFFIN_TIN.get(), "Muffin Tin");
		this.add(ExtraDelightItems.OVEN.get(), "Oven");

		this.add(ExtraDelightItems.PESTLE_AMETHYST.get(), "Amethyst Pestle");
		this.add(ExtraDelightItems.PESTLE_ANDESITE.get(), "Andesite Pestle");
		this.add(ExtraDelightItems.PESTLE_BASALT.get(), "Basalt Pestle");
		this.add(ExtraDelightItems.PESTLE_BLACKSTONE.get(), "Blackstone Pestle");
		this.add(ExtraDelightItems.PESTLE_DEEPSLATE.get(), "Deepslate Pestle");
		this.add(ExtraDelightItems.PESTLE_DIORITE.get(), "Diorite Pestle");
		this.add(ExtraDelightItems.PESTLE_ENDSTONE.get(), "Endstone Pestle");
		this.add(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get(), "Gilded Blackstone Pestle");
		this.add(ExtraDelightItems.PESTLE_GRANITE.get(), "Granite Pestle");
		this.add(ExtraDelightItems.PESTLE_STONE.get(), "Stone Pestle");

		this.add(ExtraDelightItems.PIE_DISH.get(), "Pie Dish");
		this.add(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get(), "Pumpkin Cheesecake");
		this.add(ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get(), "Slice of Pumpkin Cheesecake");
		this.add(ExtraDelightItems.PUMPKIN_COOKIE.get(), "Pumpkin Cookie");
		this.add(ExtraDelightItems.PUMPKIN_CUSTARD.get(), "Pumpkin Custard");
		this.add(ExtraDelightItems.ROUND_PAN.get(), "Round Pan");
		this.add(ExtraDelightItems.SHEET.get(), "Sheet Tray");
		this.add(ExtraDelightItems.SQUARE_PAN.get(), "Square Pan");
		this.add(ExtraDelightItems.SUGAR_COOKIE.get(), "Sugar Cookie");
		this.add(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(), "Sweet Berry Custard");
		this.add(ExtraDelightItems.SWEET_BERRY_JUICE.get(), "Sweet Berry Juice");
		this.add(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get(), "Sweet Berry Pie");
		this.add(ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get(), "Slice of Sweet Berry Pie");
		this.add(ExtraDelightItems.SWEET_BERRY_POPSICLE.get(), "Sweet Berry Popsicle");
		this.add(ExtraDelightItems.TOMATO_JUICE.get(), "Tomato Juice");
		this.add(ExtraDelightItems.TRAY.get(), "Baking Tray");
		this.add(ExtraDelightItems.WOODEN_SPOON.get(), "Wooden Spoon");
		this.add(ExtraDelightItems.YEAST.get(), "Yeast");
		this.add(ExtraDelightItems.YEAST_POT.get(), "Yeast Pot");
		this.add(ExtraDelightItems.GRAVY.get(), "Gravy");
		this.add(ExtraDelightItems.BUTTER.get(), "Butter");
		this.add(ExtraDelightItems.CHEESE.get(), "Cheese");
		this.add(ExtraDelightItems.JERKY.get(), "Jerky");
		this.add(ExtraDelightItems.COOKING_OIL.get(), "Cooking Oil");
		this.add(ExtraDelightItems.SUNFLOWER_SEEDS.get(), "Sunflower Seeds");
		this.add(ExtraDelightItems.SCRAMBLED_EGGS.get(), "Scrambled Eggs");
		this.add(ExtraDelightItems.OMELETTE.get(), "Omelette");
		this.add(ExtraDelightItems.BOILED_EGG.get(), "Hard Boiled Egg");
		this.add(ExtraDelightItems.QUICHE.get(), "Quiche");
		this.add(ExtraDelightItems.QUICHE_SLICE.get(), "Slice of Quiche");
		this.add(ExtraDelightItems.EGG_BASKET.get(), "Egg in a Basket");
		this.add(ExtraDelightItems.EGG_SALAD.get(), "Egg Salad");
		this.add(ExtraDelightItems.APPLE_JAM.get(), "Apple Butter");
		this.add(ExtraDelightItems.CARROT_JAM.get(), "Carrot Jam");
		this.add(ExtraDelightItems.GLOW_BERRY_JAM.get(), "Glow Berry Jam");
		this.add(ExtraDelightItems.GOLDEN_APPLE_JAM.get(), "Golden Jam");
		this.add(ExtraDelightItems.SWEET_BERRY_JAM.get(), "Sweet Berry Jam");
		this.add(ExtraDelightItems.BREAD_SLICE.get(), "Slice of Bread");
		this.add(ExtraDelightItems.TOAST.get(), "Toast");
		this.add(ExtraDelightItems.JAM_TOAST.get(), "Jam on Bread");
		this.add(ExtraDelightItems.GLOW_JAM_TOAST.get(), "Glowing Jam on Bread");
		this.add(ExtraDelightItems.GOLDEN_JAM_TOAST.get(), "Golden Jam on Bread");
		this.add(ExtraDelightItems.GRATED_POTATO.get(), "Grated Potato");
		this.add(ExtraDelightItems.SLICED_POTATO.get(), "Sliced Potato");
		this.add(ExtraDelightItems.POTATO_STICKS.get(), "Potato Sticks");
		this.add(ExtraDelightItems.POTATO_CHIPS.get(), "Potato Chips");
		this.add(ExtraDelightItems.FISH_AND_CHIPS.get(), "Fish n' Chips");
		this.add(ExtraDelightItems.HASHBROWNS.get(), "Hashbrowns");
		this.add(ExtraDelightItems.ROASTED_CARROT.get(), "Roasted Carrot");
		this.add(ExtraDelightItems.GLAZED_CARROT.get(), "Glazed Carrot");
		this.add(ExtraDelightItems.CARROT_SALAD.get(), "Carrot Salad");
		this.add(ExtraDelightItems.SLICED_APPLE.get(), "Apple Slices");
		this.add(ExtraDelightItems.ROASTED_APPLE.get(), "Roasted Apple");
		this.add(ExtraDelightItems.APPLE_SAUCE.get(), "Apple Sauce");
		this.add(ExtraDelightItems.EGG_SALAD_SANDWICH.get(), "Egg Salad Sandwich");
		this.add(ExtraDelightItems.WHIPPED_CREAM.get(), "Whipped Cream");
		this.add(ExtraDelightItems.GRATED_CARROT.get(), "Grated Carrot");
		this.add(ExtraDelightItems.SEAWEED_CRISPS.get(), "Seaweed Crisps");
		this.add(ExtraDelightItems.SEAWEED_SALAD.get(), "Seaweed Salad");
		this.add(ExtraDelightItems.FURIKAKE_RICE.get(), "Furikake Rice");
		this.add(ExtraDelightItems.FISH_CAKES.get(), "Fish Cakes");
		this.add(ExtraDelightItems.FRIED_MUSHROOMS.get(), "Fried Mushrooms");
		this.add(ExtraDelightItems.MUSHROOM_RISOTTO.get(), "Mushroom Risotto");
		this.add(ExtraDelightItems.MUSHROOM_BURGER.get(), "Mushroom and Swiss Burger");
		this.add(ExtraDelightItems.STUFFED_MUSHROOMS.get(), "Stuffed Mushrooms");
		this.add(ExtraDelightItems.SLICED_ONION.get(), "Sliced Onion");
		this.add(ExtraDelightItems.SLICED_TOMATO.get(), "Sliced Tomato");

		this.add(ExtraDelightItems.FURIKAKE.get(), "Furikake");
		this.add(ExtraDelightItems.CURRY_POWDER.get(), "Curry Powder");
		this.add(ExtraDelightItems.FISH_FLAKES.get(), "Fish Flakes");
		this.add(ExtraDelightItems.BREAD_CRUMBS.get(), "Breadcrumbs");
		this.add(ExtraDelightItems.BREADING_MISANPLAS.get(), "Breading Mise en place");

		this.add(ExtraDelightItems.MACARONI.get(), "Macaroni");
		this.add(ExtraDelightItems.LASAGNA_NOODLES.get(), "Lasagna Noodles");

		this.add(ExtraDelightItems.CHEESE_BLOCK_ITEM.get(), "Block of Cheese");
		this.add(ExtraDelightItems.BUTTER_BLOCK_ITEM.get(), "Block of Butter");

		this.add(ExtraDelightItems.POTATO_SOUP.get(), "Potato Soup");
		this.add(ExtraDelightItems.TOMATO_SOUP.get(), "Tomato Soup");
		this.add(ExtraDelightItems.FISH_SOUP.get(), "Fish Soup");
		this.add(ExtraDelightItems.CARROT_SOUP.get(), "Carrot Soup");

		this.add(ExtraDelightItems.BBQ_SAUCE.get(), "BBQ Sauce");
		this.add(ExtraDelightItems.KETCHUP.get(), "Ketchup");
		this.add(ExtraDelightItems.MAYO.get(), "Mayo");
		this.add(ExtraDelightItems.VINEGAR.get(), "Vinegar");

		this.add(ExtraDelightItems.EGG_MIX.get(), "Egg Mix");
		this.add(ExtraDelightItems.OMELETTE_MIX.get(), "Omelette Mix");

		this.add(ExtraDelightItems.AGAR_AGAR.get(), "Agar Agar Powder");
		this.add(ExtraDelightItems.AGAR_SHEETS.get(), "Agar Agar Sheets");
		this.add(ExtraDelightItems.SEAWEED_PASTE.get(), "Seaweed Paste");

		// Feasts
		this.add(ExtraDelightItems.SALISBURY_STEAK.get(), "Plate of Salisbury Steak");
		this.add(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(), "Salisbury Steak");
		this.add(ExtraDelightItems.MASHED_POTATO_GRAVY.get(), "Bowl of Mashed Potatos with Gravy");
		this.add(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(), "Mashed Potatos with Gravy");

		this.add(ExtraDelightItems.PORK_STEW.get(), "Pork Stew");
		this.add(ExtraDelightItems.LAMB_STEW.get(), "Mutton Stew");
		this.add(ExtraDelightItems.CHICKEN_STEW.get(), "Chicken Stew");
		this.add(ExtraDelightItems.CURRY.get(), "Curry");

		this.add(ExtraDelightItems.BEEF_STEW_FEAST.get(), "Pot of Beef Stew");
		this.add(ExtraDelightItems.PORK_STEW_FEAST.get(), "Pot of Pork Stew");
		this.add(ExtraDelightItems.LAMB_STEW_FEAST.get(), "Pot of Lamb Stew");
		this.add(ExtraDelightItems.RABBIT_STEW_FEAST.get(), "Pot of Rabbit Stew");
		this.add(ExtraDelightItems.CHICKEN_STEW_FEAST.get(), "Pot of Chicken Stew");
		this.add(ExtraDelightItems.FISH_STEW_FEAST.get(), "Pot of Fish Stew");
		this.add(ExtraDelightItems.CURRY_FEAST.get(), "Pot of Curry");

		this.add(ExtraDelightItems.SAUSAGE_ROLL.get(), "Sausage Roll");
		this.add(ExtraDelightItems.SOS.get(), "SOS");
		this.add(ExtraDelightItems.LIVER_ONIONS.get(), "Liver and Onions");
		this.add(ExtraDelightItems.FRENCH_FRIES.get(), "French Fries");
		this.add(ExtraDelightItems.FRIED_FISH.get(), "Fried Fish");
		this.add(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(), "Chicken Fried Steak");
		this.add(ExtraDelightItems.PORK_TENDERLOIN.get(), "Pork Tenderloin");
		this.add(ExtraDelightItems.FRIED_CHICKEN.get(), "Fried Chicken");
		this.add(ExtraDelightItems.STUFFED_HEART.get(), "Stuffed Heart");
		this.add(ExtraDelightItems.FRIED_BRAINS.get(), "Fried Brains");
		this.add(ExtraDelightItems.OXTAIL_SOUP.get(), "Oxtail Soup");
		this.add(ExtraDelightItems.GRILLED_CHEESE.get(), "Grilled Cheese");

		this.add(ExtraDelightItems.MACARONI_CHEESE.get(), "Mac and Cheese");
		this.add(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(), "Pot of Mac and Cheese");

		this.add(ExtraDelightItems.MEAT_LOAF.get(), "Plate of Meat Loaf");
		this.add(ExtraDelightItems.MEAT_LOAF_SANDWICH.get(), "Meat Loaf Sandwich");
		this.add(ExtraDelightItems.MEAT_LOAF_FEAST.get(), "Meat Loaf");

		this.add(ExtraDelightItems.LASAGNA.get(), "Lasagna");
		this.add(ExtraDelightItems.LASAGNA_FEAST.get(), "Pan of Lasagna");

		this.add(ExtraDelightItems.HOTDISH.get(), "Hotdish");
		this.add(ExtraDelightItems.HOTDISH_FEAST.get(), "Hotdish Dinner");

		this.add(ExtraDelightItems.HASH.get(), "Bowl of Hash");
		this.add(ExtraDelightItems.HASH_FEAST_ITEM.get(), "Hash");

		this.add(ExtraDelightItems.POT_ROAST.get(), "Bowl of Pot Roast");
		this.add(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get(), "Pot Roast");

		this.add(ExtraDelightItems.BBQ_RIBS.get(), "Plate of BBQ Ribs");
		this.add(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(), "BBQ Ribs");

		this.add(ExtraDelightItems.MEAT_PIE_SLICE.get(), "Slice of Meat Pie");
		this.add(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get(), "Meat Pie");

		this.add(ExtraDelightItems.PULLED_PORK_SANDWICH.get(), "Pulled Pork Sandwich");
		this.add(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), "Pulled Pork");

		this.add(ExtraDelightItems.BACON_EGG_SANDWICH.get(), "Bacon Egg Sandwich");
		this.add(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), "Bacon Egg and Cheese Sandwich");

		this.add(ExtraDelightItems.BUTTERED_TOAST.get(), "Buttered Toast");
		this.add(ExtraDelightItems.CROUTONS.get(), "Croutons");
		this.add(ExtraDelightItems.SALAD.get(), "Chef Salad");
		this.add(ExtraDelightItems.SALAD_FEAST_ITEM.get(), "Chef Salad Feast");
		this.add(ExtraDelightItems.ALFREDO_SAUCE.get(), "Alfredo Sauce");
		this.add(ExtraDelightItems.PASTA_TOMATO.get(), "Tomato Pasta");
		this.add(ExtraDelightItems.PASTA_ALFREDO.get(), "Alfredo Pasta");
		this.add(ExtraDelightItems.CHICKEN_ALFREDO.get(), "Chicken Alfredo Pasta");
		this.add(ExtraDelightItems.CHICKEN_PARM.get(), "Chicken Parmesan");
		this.add(ExtraDelightItems.CHEESEBURGER.get(), "Cheeseburger");
		this.add(ExtraDelightItems.BACON_CHEESEBURGER.get(), "Bacon Cheeseburger");
		this.add(ExtraDelightItems.RICEBALL.get(), "Riceball");
		this.add(ExtraDelightItems.RICEBALL_FILLED.get(), "Filled Riceball");
		this.add(ExtraDelightItems.FISH_SALAD.get(), "Fish Salad");
		this.add(ExtraDelightItems.FISH_SALAD_SANDWICH.get(), "Fish Salad Sandwich");

		this.add(ExtraDelightItems.RACK_LAMB.get(), "Crown Roast of Lamb Plate");
		this.add(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get(), "Crown Roast of Lamb");

		this.add(ExtraDelightItems.STIRFRY.get(), "Bowl of Stirfry");
		this.add(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), "Stirfry");

		this.add(ExtraDelightItems.BEEF_WELLINGTON.get(), "Plate of Beef Wellington");
		this.add(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get(), "Beef Wellington");

		this.add(ExtraDelightItems.HAGGIS.get(), "Bowl of Haggis");
		this.add(ExtraDelightItems.HAGGIS_FEAST_ITEM.get(), "Haggis");

		this.add(ExtraDelightItems.JELLY_BLACK.get(), "Bowl of Blackberry Jelly");
		this.add(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get(), "Blackberry Jelly");

		this.add(ExtraDelightItems.JELLY_RED.get(), "Bowl of Cherry Jelly");
		this.add(ExtraDelightItems.JELLY_RED_FEAST_ITEM.get(), "Cherry Jelly");

		this.add(ExtraDelightItems.JELLY_GREEN.get(), "Bowl of Apple Jelly");
		this.add(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get(), "Apple Jelly");

		this.add(ExtraDelightItems.JELLY_BROWN.get(), "Bowl of Cola Jelly");
		this.add(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get(), "Cola Jelly");

		this.add(ExtraDelightItems.JELLY_BLUE.get(), "Bowl of Blueberry Jelly");
		this.add(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get(), "Blueberry Jelly");

		this.add(ExtraDelightItems.JELLY_PURPLE.get(), "Bowl of Grape Jelly");
		this.add(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get(), "Grape Jelly");

		this.add(ExtraDelightItems.JELLY_CYAN.get(), "Bowl of Punch Jelly");
		this.add(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get(), "Punch Jelly");

		this.add(ExtraDelightItems.JELLY_LIGHT_GREY.get(), "Bowl of Dragonfruit Jelly");
		this.add(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.get(), "Dragonfruit Jelly");

		this.add(ExtraDelightItems.JELLY_GREY.get(), "Bowl of Mystery Jelly");
		this.add(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get(), "Mystery Jelly");

		this.add(ExtraDelightItems.JELLY_PINK.get(), "Bowl of Strawberry Jelly");
		this.add(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get(), "Strawberry Jelly");

		this.add(ExtraDelightItems.JELLY_LIME.get(), "Bowl of Lime Jelly");
		this.add(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get(), "Lime Jelly");

		this.add(ExtraDelightItems.JELLY_YELLOW.get(), "Bowl of Lemon Jelly");
		this.add(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get(), "Lemon Jelly");

		this.add(ExtraDelightItems.JELLY_LIGHT_BLUE.get(), "Bowl of Blue Raspberry Jelly");
		this.add(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.get(), "Blue Raspberry Jelly");

		this.add(ExtraDelightItems.JELLY_MAGENTA.get(), "Bowl of Mixed Berry Jelly");
		this.add(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get(), "Mixed Berry Jelly");

		this.add(ExtraDelightItems.JELLY_ORANGE.get(), "Bowl of Orange Jelly");
		this.add(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get(), "Orange Jelly");

		this.add(ExtraDelightItems.JELLY_WHITE.get(), "Bowl of Coconut Jelly");
		this.add(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get(), "Coconut Jelly");

		this.add(ExtraDelightItems.COOKED_PASTA.get(), "Cooked Pasta");
		this.add(ExtraDelightItems.BUTTERED_PASTA.get(), "Buttered Pasta");

		this.add(ExtraDelightItems.BEEF_STEW_RICE.get(), "Beef Stew with Rice");
		this.add(ExtraDelightItems.PORK_STEW_RICE.get(), "Pork Stew with Rice");
		this.add(ExtraDelightItems.LAMB_STEW_RICE.get(), "Lamb Stew with Rice");
		this.add(ExtraDelightItems.RABBIT_STEW_RICE.get(), "Rabbit Stew with Rice");
		this.add(ExtraDelightItems.CHICKEN_STEW_RICE.get(), "Chicken Stew with Rice");
		this.add(ExtraDelightItems.FISH_STEW_RICE.get(), "Fish Stew with Rice");
		this.add(ExtraDelightItems.CURRY_RICE.get(), "Curry Rice");
		this.add(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get(), "Tenderloin Sandwich");
		this.add(ExtraDelightItems.CHEESE_SANDWICH.get(), "Cheese Sandwich");

		this.add(ExtraDelightItems.BAD_FOOD.get(), "Bad Food");

		this.add(ExtraDelightItems.CACTUS.get(), "Cactus Paddle");
		this.add(ExtraDelightItems.COOKED_CACTUS.get(), "Cooked Cactus Paddle");
		this.add(ExtraDelightItems.CACTUS_SALAD.get(), "Cactus Salad");
		this.add(ExtraDelightItems.CACTUS_SOUP.get(), "Cactus Soup");
		this.add(ExtraDelightItems.CACTUS_EGGS.get(), "Cactus and Eggs");
		this.add(ExtraDelightItems.CACTUS_JUICE.get(), "Cactus Juice");
		this.add(ExtraDelight.MOD_ID + ".cactus_juice.hovertext", "It's the quenchiest!");
		this.add(ExtraDelightItems.STUFFED_CACTUS.get(), "Stuffed Cactus");

		add(TranslatableKeys.OVEN_CONTAINER, "Baking Oven");
		add(TranslatableKeys.OVEN_SERVED_ON, "Served on %s");
		add(TranslatableKeys.MANY_SERVINGS, "Holds %s servings of:");
		add(TranslatableKeys.SINGLE_SERVING, "Holds 1 serving of:");
		add(TranslatableKeys.EMPTY, "Empty");
		
		this.add(ExtraDelightItems.CORN_SEEDS.get(), "Corn");
		this.add(ExtraDelightItems.UNSHUCKED_CORN.get(), "Unshucked Corn");
		this.add(ExtraDelightItems.CORN_ON_COB.get(), "Corn on the Cob");
		this.add(ExtraDelightItems.CORN_HUSK.get(), "Corn Husk");
		this.add(ExtraDelightItems.DRIED_CORN_HUSK.get(), "Dried Corn Husk");
		this.add(ExtraDelightItems.CORN_SILK.get(), "Corn Silk");
		this.add(ExtraDelightItems.CORN_COB.get(), "Corn Cob");
		this.add(ExtraDelightItems.CORN_MEAL.get(), "Cornmeal");
		
		this.add(ExtraDelightItems.CORN_CHOWDER.get(), "Corn Chowder");
		this.add(ExtraDelightItems.CREAM_CORN.get(), "Creamed Corn");
		this.add(ExtraDelightItems.CORN_FRITTERS.get(), "Corn Fritters");
		this.add(ExtraDelightItems.POPCORN.get(), "Popcorn");
		this.add(ExtraDelightItems.GRILLED_CORN_ON_COB.get(), "Grilled Corn on the Cob");
		this.add(ExtraDelightItems.COOKED_CORN.get(), "Cooked Corn");
		this.add(ExtraDelightItems.ROASTED_PUMPKIN_SEEDS.get(), "Roasted Pumpkin Seeds");
		this.add(ExtraDelightItems.CORN_SILK_TEA.get(), "Corn Silk Tea");
		this.add(ExtraDelightItems.STEWED_APPLES.get(), "Stewed Apples");
		this.add(ExtraDelightItems.APPLE_FRITTERS.get(), "Apple Fritters");
		this.add(ExtraDelightItems.CARAMEL_SAUCE.get(), "Caramel Sauce");
		this.add(ExtraDelightItems.CARAMEL_CANDY.get(), "Caramel Candy");
		this.add(ExtraDelightItems.CANDY_APPLE.get(), "Candy Apple");
		this.add(ExtraDelightItems.CARAMEL_APPLE.get(), "Caramel Apple");
		this.add(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(), "Candy Golden Apple");
		this.add(ExtraDelightItems.CARAMEL_GOLDEN_APPLE.get(), "Caramel Golden Apple");
		this.add(ExtraDelightItems.CARAMEL_POPCORN.get(), "Caramel Popcorn");
		this.add(ExtraDelightItems.CARAMEL_CUSTARD.get(), "Caramel Custard");
		this.add(ExtraDelightItems.CARAMEL_POPSICLE.get(), "Caramel Pop");
		this.add(ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE.get(), "Slice of Caramel Cheesecake");
		this.add(ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM.get(), "Caramel Cheesecake");
		this.add(ExtraDelightItems.CORNBREAD.get(), "Slice of Cornbread");
		this.add(ExtraDelightItems.CORNBREAD_FEAST.get(), "Cornbread");
		this.add(ExtraDelightItems.CORN_PUDDING.get(), "Plate of Corn Pudding");
		this.add(ExtraDelightItems.CORN_PUDDING_FEAST.get(), "Corn Pudding");
		this.add(ExtraDelightItems.PUMPKIN_PIE_SLICE.get(), "Slice of Pumpkin Pie");
		this.add(ExtraDelightItems.PUMPKIN_PIE_ITEM.get(), "Pumpkin Pie");
		this.add(ExtraDelightItems.PUMPKIN_ROLL.get(), "Slice of Pumpkin Roll");
		this.add(ExtraDelightItems.PUMPKIN_ROLL_FEAST.get(), "Pumpkin Roll");
		this.add(ExtraDelightItems.APPLE_CRISP.get(), "Bowl of Apple Crisp");
		this.add(ExtraDelightItems.APPLE_CRISP_FEAST.get(), "Apple Crisp");
		this.add(ExtraDelightItems.STUFFING.get(), "Bowl of Stuffing");
		this.add(ExtraDelightItems.STUFFING_FEAST.get(), "Stuffing");
		this.add(ExtraDelightItems.POTATO_AU_GRATIN.get(), "Plate of Potatoes Au Gratin");
		this.add(ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get(), "Potatoes Au Gratin");
		this.add(ExtraDelightItems.CANDY.get(), "Candy");
		
		this.add(ExtraDelightItems.FLOUR_SACK.get(), "Flour Sack");
		this.add(ExtraDelightItems.CORNMEAL_SACK.get(), "Cornmeal Sack");
		this.add(ExtraDelightItems.SUGAR_SACK.get(), "Sugar Sack");
		this.add(ExtraDelightItems.CORN_CRATE.get(), "Corn Crate");
		this.add(ExtraDelightItems.CORN_HUSK_BUNDLE.get(), "Corn Husk Bundle");
		this.add(ExtraDelightItems.DRIED_CORN_HUSK_BUNDLE.get(), "Dried Corn Husk Bundle");
		
		this.add(ExtraDelightItems.CORN_COB_PIPE.get(), "Corn Cob Pipe");
		
		AestheticBlocks.EngLoc(this);
	}
}

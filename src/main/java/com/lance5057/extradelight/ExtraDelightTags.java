package com.lance5057.extradelight;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ExtraDelightTags {

	public static TagKey<Item> neoforgeItemTag(String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}

	public static TagKey<Block> neoforgeBlockTag(String tag) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}

	public static TagKey<Item> modTag(String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("extradelight", tag));
	}

	// General Tags
	public static final TagKey<Item> CATEGORY_BEVERAGES = modTag("category/beverages");
	public static final TagKey<Item> CATEGORY_CASSEROLES = modTag("category/casserole");
	public static final TagKey<Item> CATEGORY_CONDIMENTS = modTag("category/condiments");
	public static final TagKey<Item> CATEGORY_DESERTS = modTag("category/deserts");
	public static final TagKey<Item> CATEGORY_EGGS = modTag("category/eggs");
	public static final TagKey<Item> CATEGORY_FISH = modTag("category/fish");
	public static final TagKey<Item> CATEGORY_MEATS = modTag("category/meats");
	public static final TagKey<Item> CATEGORY_PASTAS = modTag("category/pasta");
	public static final TagKey<Item> CATEGORY_SALADS = modTag("category/salads");
	public static final TagKey<Item> CATEGORY_SANDWICH = modTag("category/sandwich");
	public static final TagKey<Item> CATEGORY_SOUPS = modTag("category/soups");
	public static final TagKey<Item> CATEGORY_VEGETABLES = modTag("category/vegetables");

	public static final TagKey<Block> COLD_SOURCES = neoforgeBlockTag("cold_sources");

	public static final TagKey<Item> SALT = ItemTags
			.create(ResourceLocation.fromNamespaceAndPath("salt", "can_be_salted"));

	public static final TagKey<Block> MORTAR_BLOCK = neoforgeBlockTag("mortars");
	public static final TagKey<Item> MORTAR = neoforgeItemTag("mortars");
	public static final TagKey<Item> PESTLES = neoforgeItemTag("pestles");
	public static final TagKey<Item> SPOONS = neoforgeItemTag("spoons");
	public static final TagKey<Item> TRAYS = modTag("baking_trays");
	public static final TagKey<Item> OFFSET_SPATULAS = neoforgeItemTag("offset_spatula");

	public static final TagKey<Item> MAKES_STOCK = modTag("makes_stock");
	public static final TagKey<Item> FRYING_OIL = modTag("frying_oil");
	public static final TagKey<Item> COOKING_OIL = neoforgeItemTag("cooking_oil");
	public static final TagKey<Item> VINEGAR = neoforgeItemTag("vinegar");
	public static final TagKey<Item> FLOUR = neoforgeItemTag("flour");
	public static final TagKey<Item> SWEETENER = modTag("sweetener");
	public static final TagKey<Item> GRAVY = neoforgeItemTag("gravy");

	public static final TagKey<Item> MEALS = modTag("meals");

	public static final TagKey<Item> CONDIMENTS = neoforgeItemTag("condiments");
	public static final TagKey<Item> MAYO = neoforgeItemTag("condiments/mayonnaise");

	public static final TagKey<Item> FRUIT = neoforgeItemTag("fruit");
	public static final TagKey<Item> FRUIT_APPLE = neoforgeItemTag("fruit/apple");
	public static final TagKey<Item> FRUIT_SWEET_BERRY = neoforgeItemTag("fruit/sweet_berry");
	public static final TagKey<Item> FRUIT_GLOW_BERRY = neoforgeItemTag("fruit/glow_berry");

	public static final TagKey<Item> JAM = neoforgeItemTag("jam");
	public static final TagKey<Item> JAM_MUNDANE = neoforgeItemTag("jam/mundane");
	public static final TagKey<Item> JAM_FRUIT = neoforgeItemTag("jam/fruit");
	public static final TagKey<Item> JAM_GLOW_BERRY = neoforgeItemTag("jam/glow_berry");
	public static final TagKey<Item> JAM_GOLDEN_APPLE = neoforgeItemTag("jam/golden_apple");
	public static final TagKey<Item> JAM_MINT = neoforgeItemTag("jam/mint");

	public static final TagKey<Item> STARCH = neoforgeItemTag("food/starch");

	public static final TagKey<Item> PROCESSED_PRODUCE = modTag("processed/produce");

	public static final TagKey<Item> PROCESSED_VEG = modTag("processed/vegetable");
	public static final TagKey<Item> PROCESSED_FRUIT = modTag("processed/fruit");

	public static final TagKey<Item> PROCESSED_POTATO = modTag("processed/potato");
	public static final TagKey<Item> GRATED_POTATO = neoforgeItemTag("potato/grated");
	public static final TagKey<Item> SLICED_POTATO = neoforgeItemTag("potato/sliced");
	public static final TagKey<Item> POTATO_STICKS = neoforgeItemTag("potato/sticks");

	public static final TagKey<Item> PROCESSED_CARROT = modTag("processed/carrot");
	public static final TagKey<Item> GRATED_CARROT = neoforgeItemTag("carrot/grated");

	public static final TagKey<Item> PROCESSED_ONION = modTag("processed/onion");
	public static final TagKey<Item> SLICED_ONION = neoforgeItemTag("onion/sliced");

	public static final TagKey<Item> PROCESSED_TOMATO = modTag("processed/tomato");
	public static final TagKey<Item> SLICED_TOMATO = neoforgeItemTag("tomato/sliced");

	public static final TagKey<Item> PROCESSED_APPLE = modTag("processed/apple");
	public static final TagKey<Item> SLICED_APPLE = neoforgeItemTag("apple/sliced");

	public static final TagKey<Item> GINGER = neoforgeItemTag("ginger");
	public static final TagKey<Item> PROCESSED_GINGER = modTag("processed/ginger");
	public static final TagKey<Item> SLICED_GINGER = neoforgeItemTag("ginger/sliced");
	public static final TagKey<Item> GRATED_GINGER = neoforgeItemTag("ginger/grated");

	public static final TagKey<Item> CORN = neoforgeItemTag("vegetable/corn");

	public static final TagKey<Item> CACTUS = neoforgeItemTag("vegetable/cactus");

	// Bread
	public static final TagKey<Item> BREAD_SLICE = neoforgeItemTag("bread/sliced");
	public static final TagKey<Item> TOAST = neoforgeItemTag("toast");

	// Butchercraft

	// Generic Meat
	public static final TagKey<Item> MEAT = neoforgeItemTag("meat");
	public static final TagKey<Item> MEAT_RAW = neoforgeItemTag("meat/raw");
	public static final TagKey<Item> MEAT_COOKED = neoforgeItemTag("meat/cooked");

	public static final TagKey<Item> SAUSAGE = neoforgeItemTag("sausage");
	public static final TagKey<Item> SAUSAGE_RAW = neoforgeItemTag("sausage/raw");
	public static final TagKey<Item> SAUSAGE_COOKED = neoforgeItemTag("sausage/cooked");

	public static final TagKey<Item> SCRAP_MEAT = neoforgeItemTag("meat/scrap");
	public static final TagKey<Item> SCRAP_MEAT_RAW = neoforgeItemTag("meat/scrap/raw");
	public static final TagKey<Item> SCRAP_MEAT_COOKED = neoforgeItemTag("meat/scrap/cooked");

	public static final TagKey<Item> ROAST = neoforgeItemTag("meat/roast");
	public static final TagKey<Item> ROAST_RAW = neoforgeItemTag("meat/roast/raw");
	public static final TagKey<Item> ROAST_COOKED = neoforgeItemTag("meat/roast/cooked");

	public static final TagKey<Item> RIBS = neoforgeItemTag("meat/ribs");
	public static final TagKey<Item> RIBS_RAW = neoforgeItemTag("meat/ribs/raw");
	public static final TagKey<Item> RIBS_COOKED = neoforgeItemTag("meat/ribs/cooked");

	public static final TagKey<Item> CUBED_MEAT = neoforgeItemTag("meat/cubed");
	public static final TagKey<Item> CUBED_MEAT_RAW = neoforgeItemTag("meat/cubed/raw");
	public static final TagKey<Item> CUBED_MEAT_COOKED = neoforgeItemTag("meat/cubed/cooked");

	public static final TagKey<Item> STEW_MEAT = neoforgeItemTag("meat/stew");
	public static final TagKey<Item> STEW_MEAT_RAW = neoforgeItemTag("meat/stew/raw");
	public static final TagKey<Item> STEW_MEAT_COOKED = neoforgeItemTag("meat/stew/cooked");

	public static final TagKey<Item> GROUND_MEAT = neoforgeItemTag("ground_meat");
	public static final TagKey<Item> GROUND_MEAT_RAW = neoforgeItemTag("ground_meat/raw");
	public static final TagKey<Item> GROUND_MEAT_COOKED = neoforgeItemTag("ground_meat/cooked");

	// Beef
	public static final TagKey<Item> BEEF = neoforgeItemTag("beef");
	public static final TagKey<Item> SCRAP_BEEF = neoforgeItemTag("beef/scrap");
	public static final TagKey<Item> BEEF_ROAST = neoforgeItemTag("beef/roast");
	public static final TagKey<Item> BEEF_RIBS = neoforgeItemTag("beef/ribs");
	public static final TagKey<Item> CUBED_BEEF = neoforgeItemTag("beef/cubed");
	public static final TagKey<Item> STEW_BEEF = neoforgeItemTag("beef/stew");
	public static final TagKey<Item> OXTAIL = neoforgeItemTag("beef/oxtail");
	public static final TagKey<Item> GROUND_BEEF = neoforgeItemTag("beef/ground");

	public static final TagKey<Item> BEEF_RAW = neoforgeItemTag("beef/raw");
	public static final TagKey<Item> SCRAP_BEEF_RAW = neoforgeItemTag("beef/scrap/raw");
	public static final TagKey<Item> BEEF_ROAST_RAW = neoforgeItemTag("beef/roast/raw");
	public static final TagKey<Item> BEEF_RIBS_RAW = neoforgeItemTag("beef/ribs/raw");
	public static final TagKey<Item> CUBED_BEEF_RAW = neoforgeItemTag("beef/cubed/raw");
	public static final TagKey<Item> STEW_BEEF_RAW = neoforgeItemTag("beef/stew/raw");
	public static final TagKey<Item> OXTAIL_RAW = neoforgeItemTag("beef/oxtail/raw");
	public static final TagKey<Item> GROUND_BEEF_RAW = neoforgeItemTag("beef/ground/raw");

	public static final TagKey<Item> BEEF_COOKED = neoforgeItemTag("beef/cooked");
	public static final TagKey<Item> SCRAP_BEEF_COOKED = neoforgeItemTag("beef/scrap/cooked");
	public static final TagKey<Item> BEEF_ROAST_COOKED = neoforgeItemTag("beef/roast/cooked");
	public static final TagKey<Item> BEEF_RIBS_COOKED = neoforgeItemTag("beef/ribs/cooked");
	public static final TagKey<Item> CUBED_BEEF_COOKED = neoforgeItemTag("beef/cubed/cooked");
	public static final TagKey<Item> STEW_BEEF_COOKED = neoforgeItemTag("beef/stew/cooked");
	public static final TagKey<Item> OXTAIL_COOKED = neoforgeItemTag("beef/oxtail/cooked");
	public static final TagKey<Item> GROUND_BEEF_COOKED = neoforgeItemTag("beef/ground/cooked");

	// Pork
	public static final TagKey<Item> PORK = neoforgeItemTag("pork");
	public static final TagKey<Item> SCRAP_PORK = neoforgeItemTag("pork/scrap");
	public static final TagKey<Item> PORK_ROAST = neoforgeItemTag("pork/roast");
	public static final TagKey<Item> PORK_RIBS = neoforgeItemTag("pork/ribs");
	public static final TagKey<Item> CUBED_PORK = neoforgeItemTag("pork/cubed");
	public static final TagKey<Item> STEW_PORK = neoforgeItemTag("pork/stew");
	public static final TagKey<Item> GROUND_PORK = neoforgeItemTag("pork/ground");

	public static final TagKey<Item> PORK_RAW = neoforgeItemTag("pork/raw");
	public static final TagKey<Item> SCRAP_PORK_RAW = neoforgeItemTag("pork/scrap/raw");
	public static final TagKey<Item> PORK_ROAST_RAW = neoforgeItemTag("pork/roast/raw");
	public static final TagKey<Item> PORK_RIBS_RAW = neoforgeItemTag("pork/ribs/raw");
	public static final TagKey<Item> CUBED_PORK_RAW = neoforgeItemTag("pork/cubed/raw");
	public static final TagKey<Item> STEW_PORK_RAW = neoforgeItemTag("pork/stew/raw");
	public static final TagKey<Item> GROUND_PORK_RAW = neoforgeItemTag("pork/ground/raw");

	public static final TagKey<Item> PORK_COOKED = neoforgeItemTag("pork/cooked");
	public static final TagKey<Item> SCRAP_PORK_COOKED = neoforgeItemTag("pork/scrap/cooked");
	public static final TagKey<Item> PORK_ROAST_COOKED = neoforgeItemTag("pork/roast/cooked");
	public static final TagKey<Item> PORK_RIBS_COOKED = neoforgeItemTag("pork/ribs/cooked");
	public static final TagKey<Item> CUBED_PORK_COOKED = neoforgeItemTag("pork/cubed/cooked");
	public static final TagKey<Item> STEW_PORK_COOKED = neoforgeItemTag("pork/stew/cooked");
	public static final TagKey<Item> GROUND_PORK_COOKED = neoforgeItemTag("pork/ground/cooked");

	// Mutton
	public static final TagKey<Item> MUTTON = neoforgeItemTag("mutton");
	public static final TagKey<Item> SCRAP_MUTTON = neoforgeItemTag("mutton/scrap");
	public static final TagKey<Item> MUTTON_ROAST = neoforgeItemTag("mutton/roast");
	public static final TagKey<Item> MUTTON_RIBS = neoforgeItemTag("mutton/ribs");
	public static final TagKey<Item> CUBED_MUTTON = neoforgeItemTag("mutton/cubed");
	public static final TagKey<Item> STEW_MUTTON = neoforgeItemTag("mutton/stew");
	public static final TagKey<Item> GROUND_MUTTON = neoforgeItemTag("mutton/ground");

	public static final TagKey<Item> MUTTON_RAW = neoforgeItemTag("mutton/raw");
	public static final TagKey<Item> SCRAP_MUTTON_RAW = neoforgeItemTag("mutton/scrap/raw");
	public static final TagKey<Item> MUTTON_ROAST_RAW = neoforgeItemTag("mutton/roast/raw");
	public static final TagKey<Item> MUTTON_RIBS_RAW = neoforgeItemTag("mutton/ribs/raw");
	public static final TagKey<Item> CUBED_MUTTON_RAW = neoforgeItemTag("mutton/cubed/raw");
	public static final TagKey<Item> STEW_MUTTON_RAW = neoforgeItemTag("mutton/stew/raw");
	public static final TagKey<Item> GROUND_MUTTON_RAW = neoforgeItemTag("mutton/ground/raw");

	public static final TagKey<Item> MUTTON_COOKED = neoforgeItemTag("mutton/cooked");
	public static final TagKey<Item> SCRAP_MUTTON_COOKED = neoforgeItemTag("mutton/scrap/cooked");
	public static final TagKey<Item> MUTTON_ROAST_COOKED = neoforgeItemTag("mutton/roast/cooked");
	public static final TagKey<Item> MUTTON_RIBS_COOKED = neoforgeItemTag("mutton/ribs/cooked");
	public static final TagKey<Item> CUBED_MUTTON_COOKED = neoforgeItemTag("mutton/cubed/cooked");
	public static final TagKey<Item> STEW_MUTTON_COOKED = neoforgeItemTag("mutton/stew/cooked");
	public static final TagKey<Item> GROUND_MUTTON_COOKED = neoforgeItemTag("mutton/ground/cooked");

	// Guts
	public static final TagKey<Item> OFFAL = neoforgeItemTag("offal");
	public static final TagKey<Item> OFFAL_RAW = neoforgeItemTag("offal/raw");
	public static final TagKey<Item> OFFAL_COOKED = neoforgeItemTag("offal/cooked");

	public static final TagKey<Item> TRIPE = neoforgeItemTag("tripe");
	public static final TagKey<Item> TRIPE_RAW = neoforgeItemTag("tripe/raw");
	public static final TagKey<Item> TRIPE_COOKED = neoforgeItemTag("tripe/cooked");

	public static final TagKey<Item> STOMACH = neoforgeItemTag("stomach");
	public static final TagKey<Item> STOMACH_RAW = neoforgeItemTag("stomach/raw");
	public static final TagKey<Item> STOMACH_COOKED = neoforgeItemTag("stomach/cooked");

	public static final TagKey<Item> LUNG = neoforgeItemTag("lung");
	public static final TagKey<Item> LUNG_RAW = neoforgeItemTag("lung/raw");
	public static final TagKey<Item> LUNG_COOKED = neoforgeItemTag("lung/cooked");

	public static final TagKey<Item> LIVER = neoforgeItemTag("liver");
	public static final TagKey<Item> LIVER_RAW = neoforgeItemTag("liver/raw");
	public static final TagKey<Item> LIVER_COOKED = neoforgeItemTag("liver/cooked");

	public static final TagKey<Item> KIDNEY = neoforgeItemTag("kidney");
	public static final TagKey<Item> KIDNEY_RAW = neoforgeItemTag("kidney/raw");
	public static final TagKey<Item> KIDNEY_COOKED = neoforgeItemTag("kidney/cooked");

	public static final TagKey<Item> HEART = neoforgeItemTag("heart");
	public static final TagKey<Item> HEART_RAW = neoforgeItemTag("heart/raw");
	public static final TagKey<Item> HEART_COOKED = neoforgeItemTag("heart/cooked");

	public static final TagKey<Item> BRAIN = neoforgeItemTag("brain");
	public static final TagKey<Item> BRAIN_RAW = neoforgeItemTag("brain/raw");
	public static final TagKey<Item> BRAIN_COOKED = neoforgeItemTag("brain/cooked");

	public static final TagKey<Item> TONGUE = neoforgeItemTag("tongue");
	public static final TagKey<Item> TONGUE_RAW = neoforgeItemTag("tongue/raw");
	public static final TagKey<Item> TONGUE_COOKED = neoforgeItemTag("tongue/cooked");

	public static final TagKey<Item> GELATIN = neoforgeItemTag("gelatin");
	public static final TagKey<Item> CHEESE = neoforgeItemTag("cheese");
	public static final TagKey<Item> BUTTER = neoforgeItemTag("butter");

	public static final TagKey<Item> SOUP = neoforgeItemTag("soup");

	public static final TagKey<Item> RICEBALL_FILLING = modTag("riceball_filling");

	public static final TagKey<Item> JELLY = modTag("jelly");

	public static final TagKey<Item> CORN_CONFISCATE = modTag("corn_dim_confiscate");

	public static final TagKey<Item> CANDY = neoforgeItemTag("candy");
	public static final TagKey<Item> CANDY_WHITE = neoforgeItemTag("candy/white");
	public static final TagKey<Item> CANDY_LIGHT_GRAY = neoforgeItemTag("candy/light_gray");
	public static final TagKey<Item> CANDY_GRAY = neoforgeItemTag("candy/gray");
	public static final TagKey<Item> CANDY_BLACK = neoforgeItemTag("candy/black");
	public static final TagKey<Item> CANDY_BROWN = neoforgeItemTag("candy/brown");
	public static final TagKey<Item> CANDY_RED = neoforgeItemTag("candy/red");
	public static final TagKey<Item> CANDY_ORANGE = neoforgeItemTag("candy/orange");
	public static final TagKey<Item> CANDY_YELLOW = neoforgeItemTag("candy/yellow");
	public static final TagKey<Item> CANDY_LIME = neoforgeItemTag("candy/lime");
	public static final TagKey<Item> CANDY_GREEN = neoforgeItemTag("candy/green");
	public static final TagKey<Item> CANDY_CYAN = neoforgeItemTag("candy/cyan");
	public static final TagKey<Item> CANDY_LIGHT_BLUE = neoforgeItemTag("candy/light_blue");
	public static final TagKey<Item> CANDY_BLUE = neoforgeItemTag("candy/blue");
	public static final TagKey<Item> CANDY_PURPLE = neoforgeItemTag("candy/purple");
	public static final TagKey<Item> CANDY_MAGENTA = neoforgeItemTag("candy/magenta");
	public static final TagKey<Item> CANDY_PINK = neoforgeItemTag("candy/pink");

	public static final TagKey<Item> CANDY_BOWL_VALID = modTag("candy_bowl_valid");
	public static final TagKey<Item> COOKIE_DOUGH = neoforgeItemTag("cookie_dough");
	public static final TagKey<Item> GINGERBREAD_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/gingerbread");
	public static final TagKey<Item> SUGAR_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/sugar");

	public static final TagKey<Item> FROSTING = neoforgeItemTag("frosting");
	public static final TagKey<Item> FROSTING_WHITE = neoforgeItemTag("frosting/white");
	public static final TagKey<Item> FROSTING_LIGHT_GRAY = neoforgeItemTag("frosting/light_gray");
	public static final TagKey<Item> FROSTING_GRAY = neoforgeItemTag("frosting/gray");
	public static final TagKey<Item> FROSTING_BLACK = neoforgeItemTag("frosting/black");
	public static final TagKey<Item> FROSTING_BROWN = neoforgeItemTag("frosting/brown");
	public static final TagKey<Item> FROSTING_RED = neoforgeItemTag("frosting/red");
	public static final TagKey<Item> FROSTING_ORANGE = neoforgeItemTag("frosting/orange");
	public static final TagKey<Item> FROSTING_YELLOW = neoforgeItemTag("frosting/yellow");
	public static final TagKey<Item> FROSTING_LIME = neoforgeItemTag("frosting/lime");
	public static final TagKey<Item> FROSTING_GREEN = neoforgeItemTag("frosting/green");
	public static final TagKey<Item> FROSTING_CYAN = neoforgeItemTag("frosting/cyan");
	public static final TagKey<Item> FROSTING_LIGHT_BLUE = neoforgeItemTag("frosting/light_blue");
	public static final TagKey<Item> FROSTING_BLUE = neoforgeItemTag("frosting/blue");
	public static final TagKey<Item> FROSTING_PURPLE = neoforgeItemTag("frosting/purple");
	public static final TagKey<Item> FROSTING_MAGENTA = neoforgeItemTag("frosting/magenta");
	public static final TagKey<Item> FROSTING_PINK = neoforgeItemTag("frosting/pink");

	public static final TagKey<Item> DRIED_FRUIT = neoforgeItemTag("fruit/dried");

	public static final TagKey<Item> CORN_KERNELS = neoforgeItemTag("seeds/corn");
	public static final TagKey<Item> CORN_ON_COB = neoforgeItemTag("crops/corn");
	public static final TagKey<Item> BOILED_EGG = neoforgeItemTag("eggs/boiled");
	public static final TagKey<Item> WHIPPED_CREAM = neoforgeItemTag("whipped_cream");
	public static final TagKey<Item> FISH_FLAKES = neoforgeItemTag("fish_flakes");
	public static final TagKey<Item> CROUTONS = neoforgeItemTag("croutons");
	public static final TagKey<Item> ALFREDO_SAUCE = neoforgeItemTag("alfredo_sauce");
	public static final TagKey<Item> COOKED_CACTUS = neoforgeItemTag("cactus/cooked");
	public static final TagKey<Item> MINT = neoforgeItemTag("mint");
	public static final TagKey<Item> GROUND_CINNAMON = neoforgeItemTag("cinnamon/ground");
	public static final TagKey<Item> CHOCOLATE_CHIP_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/chocolate_chip");
	public static final TagKey<Item> GLOW_BERRY_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/glow_berry");
	public static final TagKey<Item> HONEY_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/honey");
	public static final TagKey<Item> PUMPKIN_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/pumpkin");
	public static final TagKey<Item> SWEET_BERRY_COOKIE_DOUGH = neoforgeItemTag("cookie_dough/sweet_berry");
	public static final TagKey<Item> BREAD_CRUMBS = neoforgeItemTag("bread/crumbs");
	public static final TagKey<Item> CORN_MEAL = neoforgeItemTag("corn/meal");
	public static final TagKey<Item> POPCORN = neoforgeItemTag("popcorn");
	public static final TagKey<Item> CINNAMON_STICK = neoforgeItemTag("cinnamon/stick");

	public static final TagKey<Item> CHILI = neoforgeItemTag("crops/chili");
	public static final TagKey<Item> DRIED_CHILI = neoforgeItemTag("crops/chili/dried");
	public static final TagKey<Item> CHILI_SEEDS = neoforgeItemTag("seeds/chili");

	public static final TagKey<Item> CHOCOLATE_BOX = neoforgeItemTag("chocolate_box");

	public static final TagKey<Item> CHOCOLATE_BLOCK = neoforgeItemTag("block/chocolate");
	public static final TagKey<Item> WHITE_CHOCOLATE_BLOCK = neoforgeItemTag("block/white_chocolate");
	public static final TagKey<Item> BLOOD_CHOCOLATE_BLOCK = neoforgeItemTag("block/blood_chocolate");
	public static final TagKey<Item> DARK_CHOCOLATE_BLOCK = neoforgeItemTag("block/dark_chocolate");
	public static final TagKey<Item> MILK_CHOCOLATE_BLOCK = neoforgeItemTag("block/milk_chocolate");

	public static final TagKey<Item> ROASTED_COCOA_BEANS = neoforgeItemTag("cocoa_beans/roasted");
	public static final TagKey<Item> COCOA_SOLIDS = neoforgeItemTag("cocoa/solids");

	public static final TagKey<Item> WHITE_CHOCOLATE = neoforgeItemTag("chocolate/white");
	public static final TagKey<Item> BLOOD_CHOCOLATE = neoforgeItemTag("chocolate/blood");
	public static final TagKey<Item> DARK_CHOCOLATE = neoforgeItemTag("chocolate/dark");
	public static final TagKey<Item> MILK_CHOCOLATE = neoforgeItemTag("chocolate/milk");

	public static final TagKey<Item> WHITE_CHOCOLATE_BAR = neoforgeItemTag("chocolate/white/bar");
	public static final TagKey<Item> BLOOD_CHOCOLATE_BAR = neoforgeItemTag("chocolate/blood/bar");
	public static final TagKey<Item> DARK_CHOCOLATE_BAR = neoforgeItemTag("chocolate/dark/bar");
	public static final TagKey<Item> MILK_CHOCOLATE_BAR = neoforgeItemTag("chocolate/milk/bar");

	public static final TagKey<Item> WHITE_CHOCOLATE_BAR_FILLED = neoforgeItemTag("chocolate/white/bar/filled");
	public static final TagKey<Item> BLOOD_CHOCOLATE_BAR_FILLED = neoforgeItemTag("chocolate/blood/bar/filled");
	public static final TagKey<Item> DARK_CHOCOLATE_BAR_FILLED = neoforgeItemTag("chocolate/dark/bar/filled");
	public static final TagKey<Item> MILK_CHOCOLATE_BAR_FILLED = neoforgeItemTag("chocolate/milk/bar/filled");

	public static final TagKey<Item> WHITE_CHOCOLATE_CHIPS = neoforgeItemTag("chocolate/white/chips");
	public static final TagKey<Item> BLOOD_CHOCOLATE_CHIPS = neoforgeItemTag("chocolate/blood/chips");
	public static final TagKey<Item> DARK_CHOCOLATE_CHIPS = neoforgeItemTag("chocolate/dark/chips");
	public static final TagKey<Item> MILK_CHOCOLATE_CHIPS = neoforgeItemTag("chocolate/milk/chips");

	public static final TagKey<Item> WHITE_CHOCOLATE_TRUFFLE = neoforgeItemTag("chocolate/white/truffle");
	public static final TagKey<Item> BLOOD_CHOCOLATE_TRUFFLE = neoforgeItemTag("chocolate/blood/truffle");
	public static final TagKey<Item> DARK_CHOCOLATE_TRUFFLE = neoforgeItemTag("chocolate/dark/truffle");
	public static final TagKey<Item> MILK_CHOCOLATE_TRUFFLE = neoforgeItemTag("chocolate/milk/truffle");

	public static final TagKey<Item> RIBBON = neoforgeItemTag("ribbon");

	public static final TagKey<Item> NUTS = neoforgeItemTag("nuts");
	public static final TagKey<Item> ROASTED_NUTS = neoforgeItemTag("nuts/cooked");

	public static final TagKey<Item> ROASTED_PEANUTS = neoforgeItemTag("crops/peanuts/cooked");
	public static final TagKey<Item> PEANUTS = neoforgeItemTag("crops/peanuts/shelled");
	public static final TagKey<Item> PEANUTS_IN_SHELL = neoforgeItemTag("crops/peanuts");

	public static final TagKey<Item> ROASTED_HAZELNUTS = neoforgeItemTag("crops/hazelnut/cooked");
	public static final TagKey<Item> HAZELNUTS = neoforgeItemTag("crops/hazelnut/shelled");
	public static final TagKey<Item> HAZELNUTS_IN_SHELL = neoforgeItemTag("crops/hazelnut");

	public static final TagKey<Item> MALLOWROOT = neoforgeItemTag("crops/mallow_root");
	public static final TagKey<Item> MARSHMALLOW = neoforgeItemTag("marshmallow");
	public static final TagKey<Item> MARSHMALLOW_FLUFF = neoforgeItemTag("marshmallow_fluff");

	public static final TagKey<Item> COFFEE_CHERRIES = neoforgeItemTag("crops/coffee");
	public static final TagKey<Item> GREEN_COFFEE = neoforgeItemTag("crops/coffee/green");
	public static final TagKey<Item> ROASTED_COFFEE_BEANS = neoforgeItemTag("crops/coffee/cooked");
	public static final TagKey<Item> GROUND_COFFEE_BEANS = neoforgeItemTag("crops/coffee/ground");

	public static final TagKey<Item> PUFFED_RICE = neoforgeItemTag("puffed_rice");
	public static final TagKey<Item> CORN_FLAKES = neoforgeItemTag("corn_flakes");

	public static final TagKey<Item> CHOCOLATE_BAR_FILLING = modTag("chocolate_bar_filling");
	public static final TagKey<Item> CHOCOLATE_BAR = neoforgeItemTag("chocolate/bar");
	public static final TagKey<Item> CHOCOLATE_BAR_FILLED = neoforgeItemTag("chocolate/bar/filled");
	public static final TagKey<Item> CHOCOLATE_CHIPS = neoforgeItemTag("chocolate/chips");
	public static final TagKey<Item> CHOCOLATE_TRUFFLE = neoforgeItemTag("chocolate/truffle");
	public static final TagKey<Item> FRUIT_MELON = neoforgeItemTag("fruit/melon");
	public static final TagKey<Item> CHILI_POWDER = neoforgeItemTag("chill/powder");
	public static final TagKey<Item> TOFFEE = neoforgeItemTag("toffee");
	public static final TagKey<Item> GUMMIES = neoforgeItemTag("gummies");
	public static final TagKey<Item> PEANUT_BRITTLE = neoforgeItemTag("peanut_brittle");
	public static final TagKey<Item> TRAIL_MIX = neoforgeItemTag("trail_mix");

	public static final TagKey<Item> CHOCOLATE_TRUFFLE_FILLING = modTag("chocolate_truffle_filling");
	public static final TagKey<Item> FUDGE = neoforgeItemTag("fudge");
	public static final TagKey<Item> NOUGAT = neoforgeItemTag("nougat");

	public static final TagKey<Item> JAMMABLE = neoforgeItemTag("jammable");
	public static final TagKey<Item> PEANUT_BUTTER = neoforgeItemTag("peanut_butter");
	public static final TagKey<Item> CHOCOLATE_SYRUP = neoforgeItemTag("chocolate_syrup");
	public static final TagKey<Item> COOKIE = neoforgeItemTag("cookie");
	public static final TagKey<Item> COFFEE = neoforgeItemTag("coffee");
	public static final TagKey<Item> GRAHAM_CRACKER = neoforgeItemTag("graham_cracker");
	public static final TagKey<Item> MALLOWROOT_POWDER = neoforgeItemTag("mallowroot/powder");
	public static final TagKey<Item> PEPPERMINT_CANDY = neoforgeItemTag("candy/peppermint");

}

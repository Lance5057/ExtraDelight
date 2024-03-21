package com.lance5057.extradelight;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ExtraDelightTags {

	public static TagKey<Item> forgeTag(String tag) {
		return ItemTags.create(new ResourceLocation("forge", tag));
	}

	public static TagKey<Item> modTag(String tag) {
		return ItemTags.create(new ResourceLocation("extradelight", tag));
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

	public static final TagKey<Item> SALT = ItemTags.create(new ResourceLocation("salt", "can_be_salted"));

	public static final TagKey<Block> MORTAR_BLOCK = BlockTags.create(new ResourceLocation("forge", "mortars"));
	public static final TagKey<Item> MORTAR = forgeTag("mortars");
	public static final TagKey<Item> PESTLES = forgeTag("pestles");
	public static final TagKey<Item> SPOONS = forgeTag("spoons");
	public static final TagKey<Item> TRAYS = ItemTags.create(new ResourceLocation("extradelight", "baking_trays"));
	public static final TagKey<Item> OFFSET_SPATULAS = forgeTag("offset_spatula");

	public static final TagKey<Item> MAKES_STOCK = ItemTags.create(new ResourceLocation("extradelight", "makes_stock"));
	public static final TagKey<Item> FRYING_OIL = ItemTags.create(new ResourceLocation("extradelight", "frying_oil"));
	public static final TagKey<Item> COOKING_OIL = forgeTag("cooking_oil");
	public static final TagKey<Item> VINEGAR = forgeTag("vinegar");
	public static final TagKey<Item> FLOUR = forgeTag("flour");
	public static final TagKey<Item> SWEETENER = ItemTags.create(new ResourceLocation("extradelight", "sweetener"));
	public static final TagKey<Item> GRAVY = forgeTag("gravy");

	public static final TagKey<Item> MEALS = modTag("meals");

	public static final TagKey<Item> CONDIMENTS = forgeTag("condiments");
	public static final TagKey<Item> MAYO = forgeTag("condiments/mayonnaise");

	public static final TagKey<Item> FRUIT = forgeTag("fruit");
	public static final TagKey<Item> FRUIT_APPLE = forgeTag("fruit/apple");
	public static final TagKey<Item> FRUIT_SWEET_BERRY = forgeTag("fruit/sweet_berry");
	public static final TagKey<Item> FRUIT_GLOW_BERRY = forgeTag("fruit/glow_berry");

	public static final TagKey<Item> JAM = forgeTag("jam");
	public static final TagKey<Item> JAM_MUNDANE = forgeTag("jam/mundane");
	public static final TagKey<Item> JAM_APPLE = forgeTag("jam/apple");
	public static final TagKey<Item> JAM_SWEET_BERRY = forgeTag("jam/sweet_berry");
	public static final TagKey<Item> JAM_GLOW_BERRY = forgeTag("jam/glow_berry");
	public static final TagKey<Item> JAM_GOLDEN_APPLE = forgeTag("jam/golden_apple");
	public static final TagKey<Item> JAM_CARROT = forgeTag("jam/carrot");
	public static final TagKey<Item> JAM_MINT = forgeTag("jam/mint");

	public static final TagKey<Item> STARCH = forgeTag("food/starch");

	public static final TagKey<Item> PROCESSED_PRODUCE = modTag("processed/produce");

	public static final TagKey<Item> PROCESSED_VEG = modTag("processed/vegetable");
	public static final TagKey<Item> PROCESSED_FRUIT = modTag("processed/fruit");

	public static final TagKey<Item> PROCESSED_POTATO = modTag("processed/potato");
	public static final TagKey<Item> GRATED_POTATO = forgeTag("potato/grated");
	public static final TagKey<Item> SLICED_POTATO = forgeTag("potato/sliced");
	public static final TagKey<Item> POTATO_STICKS = forgeTag("potato/sticks");

	public static final TagKey<Item> PROCESSED_CARROT = modTag("processed/carrot");
	public static final TagKey<Item> GRATED_CARROT = forgeTag("carrot/grated");

	public static final TagKey<Item> PROCESSED_ONION = modTag("processed/onion");
	public static final TagKey<Item> SLICED_ONION = forgeTag("onion/sliced");

	public static final TagKey<Item> PROCESSED_TOMATO = modTag("processed/tomato");
	public static final TagKey<Item> SLICED_TOMATO = forgeTag("tomato/sliced");

	public static final TagKey<Item> PROCESSED_APPLE = modTag("processed/apple");
	public static final TagKey<Item> SLICED_APPLE = forgeTag("apple/sliced");

	public static final TagKey<Item> GINGER = forgeTag("ginger");
	public static final TagKey<Item> PROCESSED_GINGER = modTag("processed/ginger");
	public static final TagKey<Item> SLICED_GINGER = forgeTag("ginger/sliced");
	public static final TagKey<Item> GRATED_GINGER = forgeTag("ginger/grated");

	public static final TagKey<Item> CORN = forgeTag("vegetable/corn");

	public static final TagKey<Item> CACTUS = forgeTag("vegetable/cactus");

	// Bread
	public static final TagKey<Item> BREAD_SLICE = forgeTag("bread/sliced");
	public static final TagKey<Item> TOAST = forgeTag("toast");

	public static final TagKey<Item> GELATIN = forgeTag("gelatin");
	public static final TagKey<Item> CHEESE = forgeTag("cheese");
	public static final TagKey<Item> BUTTER = forgeTag("butter");

	public static final TagKey<Item> SOUP = forgeTag("soup");

	public static final TagKey<Item> RICEBALL_FILLING = modTag("riceball_filling");

	public static final TagKey<Item> JELLY = modTag("jelly");

	public static final TagKey<Item> CORN_CONFISCATE = modTag("corn_dim_confiscate");

	public static final TagKey<Item> CANDY = forgeTag("candy");
	public static final TagKey<Item> CANDY_WHITE = forgeTag("candy/white");
	public static final TagKey<Item> CANDY_LIGHT_GRAY = forgeTag("candy/light_gray");
	public static final TagKey<Item> CANDY_GRAY = forgeTag("candy/gray");
	public static final TagKey<Item> CANDY_BLACK = forgeTag("candy/black");
	public static final TagKey<Item> CANDY_BROWN = forgeTag("candy/brown");
	public static final TagKey<Item> CANDY_RED = forgeTag("candy/red");
	public static final TagKey<Item> CANDY_ORANGE = forgeTag("candy/orange");
	public static final TagKey<Item> CANDY_YELLOW = forgeTag("candy/yellow");
	public static final TagKey<Item> CANDY_LIME = forgeTag("candy/lime");
	public static final TagKey<Item> CANDY_GREEN = forgeTag("candy/green");
	public static final TagKey<Item> CANDY_CYAN = forgeTag("candy/cyan");
	public static final TagKey<Item> CANDY_LIGHT_BLUE = forgeTag("candy/light_blue");
	public static final TagKey<Item> CANDY_BLUE = forgeTag("candy/blue");
	public static final TagKey<Item> CANDY_PURPLE = forgeTag("candy/purple");
	public static final TagKey<Item> CANDY_MAGENTA = forgeTag("candy/magenta");
	public static final TagKey<Item> CANDY_PINK = forgeTag("candy/pink");

	public static final TagKey<Item> CANDY_BOWL_VALID = modTag("candy_bowl_valid");
	public static final TagKey<Item> COOKIE_DOUGH = forgeTag("cookie_dough");
	public static final TagKey<Item> GINGERBREAD_COOKIE_DOUGH = forgeTag("cookie_dough/gingerbread");
	public static final TagKey<Item> SUGAR_COOKIE_DOUGH = forgeTag("cookie_dough/sugar");

	public static final TagKey<Item> FROSTING = forgeTag("frosting");
	public static final TagKey<Item> FROSTING_WHITE = forgeTag("frosting/white");
	public static final TagKey<Item> FROSTING_LIGHT_GRAY = forgeTag("frosting/light_gray");
	public static final TagKey<Item> FROSTING_GRAY = forgeTag("frosting/gray");
	public static final TagKey<Item> FROSTING_BLACK = forgeTag("frosting/black");
	public static final TagKey<Item> FROSTING_BROWN = forgeTag("frosting/brown");
	public static final TagKey<Item> FROSTING_RED = forgeTag("frosting/red");
	public static final TagKey<Item> FROSTING_ORANGE = forgeTag("frosting/orange");
	public static final TagKey<Item> FROSTING_YELLOW = forgeTag("frosting/yellow");
	public static final TagKey<Item> FROSTING_LIME = forgeTag("frosting/lime");
	public static final TagKey<Item> FROSTING_GREEN = forgeTag("frosting/green");
	public static final TagKey<Item> FROSTING_CYAN = forgeTag("frosting/cyan");
	public static final TagKey<Item> FROSTING_LIGHT_BLUE = forgeTag("frosting/light_blue");
	public static final TagKey<Item> FROSTING_BLUE = forgeTag("frosting/blue");
	public static final TagKey<Item> FROSTING_PURPLE = forgeTag("frosting/purple");
	public static final TagKey<Item> FROSTING_MAGENTA = forgeTag("frosting/magenta");
	public static final TagKey<Item> FROSTING_PINK = forgeTag("frosting/pink");

	public static final TagKey<Item> DRIED_FRUIT = forgeTag("fruit/dried");

	public static final TagKey<Item> CORN_KERNELS = forgeTag("seeds/corn");
	public static final TagKey<Item> CORN_ON_COB = forgeTag("crops/corn");
	public static final TagKey<Item> BOILED_EGG = forgeTag("eggs/boiled");
	public static final TagKey<Item> WHIPPED_CREAM = forgeTag("whipped_cream");
	public static final TagKey<Item> FISH_FLAKES = forgeTag("fish_flakes");
	public static final TagKey<Item> CROUTONS = forgeTag("croutons");
	public static final TagKey<Item> ALFREDO_SAUCE = forgeTag("alfredo_sauce");
	public static final TagKey<Item> COOKED_CACTUS = forgeTag("cactus/cooked");
	public static final TagKey<Item> MINT = forgeTag("mint");
	public static final TagKey<Item> GROUND_CINNAMON = forgeTag("cinnamon/ground");
	public static final TagKey<Item> CHOCOLATE_CHIP_COOKIE_DOUGH = forgeTag("cookie_dough/chocolate_chip");
	public static final TagKey<Item> GLOW_BERRY_COOKIE_DOUGH = forgeTag("cookie_dough/glow_berry");
	public static final TagKey<Item> HONEY_COOKIE_DOUGH = forgeTag("cookie_dough/honey");
	public static final TagKey<Item> PUMPKIN_COOKIE_DOUGH = forgeTag("cookie_dough/pumpkin");
	public static final TagKey<Item> SWEET_BERRY_COOKIE_DOUGH = forgeTag("cookie_dough/sweet_berry");
	public static final TagKey<Item> BREAD_CRUMBS = forgeTag("bread/crumbs");
	public static final TagKey<Item> CORN_MEAL = forgeTag("corn/meal");
	public static final TagKey<Item> POPCORN = forgeTag("popcorn");
	public static final TagKey<Item> CINNAMON_STICK = forgeTag("cinnamon/stick");

	// Butchercraft

	// Generic Meat
		public static final TagKey<Item> MEAT = forgeTag("meat");
		public static final TagKey<Item> MEAT_RAW = forgeTag("meat/raw");
		public static final TagKey<Item> MEAT_COOKED = forgeTag("meat/cooked");

		public static final TagKey<Item> SCRAP_MEAT = forgeTag("meat/scrap");
		public static final TagKey<Item> SCRAP_MEAT_RAW = forgeTag("meat/scrap/raw");
		public static final TagKey<Item> SCRAP_MEAT_COOKED = forgeTag("meat/scrap/cooked");

		public static final TagKey<Item> ROAST = forgeTag("meat/roast");
		public static final TagKey<Item> ROAST_RAW = forgeTag("meat/roast/raw");
		public static final TagKey<Item> ROAST_COOKED = forgeTag("meat/roast/cooked");

		public static final TagKey<Item> RIBS = forgeTag("meat/ribs");
		public static final TagKey<Item> RIBS_RAW = forgeTag("meat/ribs/raw");
		public static final TagKey<Item> RIBS_COOKED = forgeTag("meat/ribs/cooked");

		public static final TagKey<Item> CUBED_MEAT = forgeTag("meat/cubed");
		public static final TagKey<Item> CUBED_MEAT_RAW = forgeTag("meat/cubed/raw");
		public static final TagKey<Item> CUBED_MEAT_COOKED = forgeTag("meat/cubed/cooked");

		public static final TagKey<Item> STEW_MEAT = forgeTag("meat/stew");
		public static final TagKey<Item> STEW_MEAT_RAW = forgeTag("meat/stew/raw");
		public static final TagKey<Item> STEW_MEAT_COOKED = forgeTag("meat/stew/cooked");

		public static final TagKey<Item> GROUND_MEAT = forgeTag("ground_meat");
		public static final TagKey<Item> GROUND_MEAT_RAW = forgeTag("ground_meat/raw");
		public static final TagKey<Item> GROUND_MEAT_COOKED = forgeTag("ground_meat/cooked");

		// Beef
		public static final TagKey<Item> BEEF = forgeTag("beef");
		public static final TagKey<Item> SCRAP_BEEF = forgeTag("beef/scrap");
		public static final TagKey<Item> BEEF_ROAST = forgeTag("beef/roast");
		public static final TagKey<Item> BEEF_RIBS = forgeTag("beef/ribs");
		public static final TagKey<Item> CUBED_BEEF = forgeTag("beef/cubed");
		public static final TagKey<Item> STEW_BEEF = forgeTag("beef/stew");
		public static final TagKey<Item> GROUND_BEEF = forgeTag("beef/ground");
		public static final TagKey<Item> OXTAIL = forgeTag("beef/oxtail");

		public static final TagKey<Item> BEEF_RAW = forgeTag("beef/raw");
		public static final TagKey<Item> SCRAP_BEEF_RAW = forgeTag("beef/scrap/raw");
		public static final TagKey<Item> BEEF_ROAST_RAW = forgeTag("beef/roast/raw");
		public static final TagKey<Item> BEEF_RIBS_RAW = forgeTag("beef/ribs/raw");
		public static final TagKey<Item> CUBED_BEEF_RAW = forgeTag("beef/cubed/raw");
		public static final TagKey<Item> STEW_BEEF_RAW = forgeTag("beef/stew/raw");
		public static final TagKey<Item> GROUND_BEEF_RAW = forgeTag("beef/ground/raw");
		public static final TagKey<Item> OXTAIL_RAW = forgeTag("beef/oxtail/raw");

		public static final TagKey<Item> BEEF_COOKED = forgeTag("beef/cooked");
		public static final TagKey<Item> SCRAP_BEEF_COOKED = forgeTag("beef/scrap/cooked");
		public static final TagKey<Item> BEEF_ROAST_COOKED = forgeTag("beef/roast/cooked");
		public static final TagKey<Item> BEEF_RIBS_COOKED = forgeTag("beef/ribs/cooked");
		public static final TagKey<Item> CUBED_BEEF_COOKED = forgeTag("beef/cubed/cooked");
		public static final TagKey<Item> STEW_BEEF_COOKED = forgeTag("beef/stew/cooked");
		public static final TagKey<Item> GROUND_BEEF_COOKED = forgeTag("beef/ground/cooked");
		public static final TagKey<Item> OXTAIL_COOKED = forgeTag("beef/oxtail/cooked");

		// Pork
		public static final TagKey<Item> PORK = forgeTag("pork");
		public static final TagKey<Item> SCRAP_PORK = forgeTag("pork/scrap");
		public static final TagKey<Item> PORK_ROAST = forgeTag("pork/roast");
		public static final TagKey<Item> PORK_RIBS = forgeTag("pork/ribs");
		public static final TagKey<Item> CUBED_PORK = forgeTag("pork/cubed");
		public static final TagKey<Item> STEW_PORK = forgeTag("pork/stew");
		public static final TagKey<Item> GROUND_PORK = forgeTag("pork/ground");

		public static final TagKey<Item> PORK_RAW = forgeTag("pork/raw");
		public static final TagKey<Item> SCRAP_PORK_RAW = forgeTag("pork/scrap/raw");
		public static final TagKey<Item> PORK_ROAST_RAW = forgeTag("pork/roast/raw");
		public static final TagKey<Item> PORK_RIBS_RAW = forgeTag("pork/ribs/raw");
		public static final TagKey<Item> CUBED_PORK_RAW = forgeTag("pork/cubed/raw");
		public static final TagKey<Item> STEW_PORK_RAW = forgeTag("pork/stew/raw");
		public static final TagKey<Item> GROUND_PORK_RAW = forgeTag("pork/ground/raw");

		public static final TagKey<Item> PORK_COOKED = forgeTag("pork/cooked");
		public static final TagKey<Item> SCRAP_PORK_COOKED = forgeTag("pork/scrap/cooked");
		public static final TagKey<Item> PORK_ROAST_COOKED = forgeTag("pork/roast/cooked");
		public static final TagKey<Item> PORK_RIBS_COOKED = forgeTag("pork/ribs/cooked");
		public static final TagKey<Item> CUBED_PORK_COOKED = forgeTag("pork/cubed/cooked");
		public static final TagKey<Item> STEW_PORK_COOKED = forgeTag("pork/stew/cooked");
		public static final TagKey<Item> GROUND_PORK_COOKED = forgeTag("pork/ground/cooked");

		// Mutton
		public static final TagKey<Item> MUTTON = forgeTag("mutton");
		public static final TagKey<Item> SCRAP_MUTTON = forgeTag("mutton/scrap");
		public static final TagKey<Item> MUTTON_ROAST = forgeTag("mutton/roast");
		public static final TagKey<Item> MUTTON_RIBS = forgeTag("mutton/ribs");
		public static final TagKey<Item> CUBED_MUTTON = forgeTag("mutton/cubed");
		public static final TagKey<Item> STEW_MUTTON = forgeTag("mutton/stew");
		public static final TagKey<Item> GROUND_MUTTON = forgeTag("mutton/ground");

		public static final TagKey<Item> MUTTON_RAW = forgeTag("mutton/raw");
		public static final TagKey<Item> SCRAP_MUTTON_RAW = forgeTag("mutton/scrap/raw");
		public static final TagKey<Item> MUTTON_ROAST_RAW = forgeTag("mutton/roast/raw");
		public static final TagKey<Item> MUTTON_RIBS_RAW = forgeTag("mutton/ribs/raw");
		public static final TagKey<Item> CUBED_MUTTON_RAW = forgeTag("mutton/cubed/raw");
		public static final TagKey<Item> STEW_MUTTON_RAW = forgeTag("mutton/stew/raw");
		public static final TagKey<Item> GROUND_MUTTON_RAW = forgeTag("mutton/ground/raw");

		public static final TagKey<Item> MUTTON_COOKED = forgeTag("mutton/cooked");
		public static final TagKey<Item> SCRAP_MUTTON_COOKED = forgeTag("mutton/scrap/cooked");
		public static final TagKey<Item> MUTTON_ROAST_COOKED = forgeTag("mutton/roast/cooked");
		public static final TagKey<Item> MUTTON_RIBS_COOKED = forgeTag("mutton/ribs/cooked");
		public static final TagKey<Item> CUBED_MUTTON_COOKED = forgeTag("mutton/cubed/cooked");
		public static final TagKey<Item> STEW_MUTTON_COOKED = forgeTag("mutton/stew/cooked");
		public static final TagKey<Item> GROUND_MUTTON_COOKED = forgeTag("mutton/ground/cooked");

		// goat
		public static final TagKey<Item> GOAT = forgeTag("goat");
		public static final TagKey<Item> SCRAP_GOAT = forgeTag("goat/scrap");
		public static final TagKey<Item> GOAT_ROAST = forgeTag("goat/roast");
		public static final TagKey<Item> GOAT_RIBS = forgeTag("goat/ribs");
		public static final TagKey<Item> CUBED_GOAT = forgeTag("goat/cubed");
		public static final TagKey<Item> STEW_GOAT = forgeTag("goat/stew");
		public static final TagKey<Item> GROUND_GOAT = forgeTag("goat/ground");
		
		public static final TagKey<Item> GOAT_RAW = forgeTag("goat/raw");
		public static final TagKey<Item> SCRAP_GOAT_RAW = forgeTag("goat/scrap/raw");
		public static final TagKey<Item> GOAT_ROAST_RAW = forgeTag("goat/roast/raw");
		public static final TagKey<Item> GOAT_RIBS_RAW = forgeTag("goat/ribs/raw");
		public static final TagKey<Item> CUBED_GOAT_RAW = forgeTag("goat/cubed/raw");
		public static final TagKey<Item> STEW_GOAT_RAW = forgeTag("goat/stew/raw");
		public static final TagKey<Item> GROUND_GOAT_RAW = forgeTag("goat/ground/raw");

		public static final TagKey<Item> GOAT_COOKED = forgeTag("goat/cooked");
		public static final TagKey<Item> SCRAP_GOAT_COOKED = forgeTag("goat/scrap/cooked");
		public static final TagKey<Item> GOAT_ROAST_COOKED = forgeTag("goat/roast/cooked");
		public static final TagKey<Item> GOAT_RIBS_COOKED = forgeTag("goat/ribs/cooked");
		public static final TagKey<Item> CUBED_GOAT_COOKED = forgeTag("goat/cubed/cooked");
		public static final TagKey<Item> STEW_GOAT_COOKED = forgeTag("goat/stew/cooked");
		public static final TagKey<Item> GROUND_GOAT_COOKED = forgeTag("goat/ground/cooked");

		// Chicken
		public static final TagKey<Item> CHICKEN = forgeTag("chicken");
		public static final TagKey<Item> SCRAP_CHICKEN = forgeTag("chicken/scrap");
		public static final TagKey<Item> CUBED_CHICKEN = forgeTag("chicken/cubed");
		public static final TagKey<Item> STEW_CHICKEN = forgeTag("chicken/stew");
		public static final TagKey<Item> CHICKEN_BREAST = forgeTag("chicken/breast");
		public static final TagKey<Item> CHICKEN_THIGH = forgeTag("chicken/thigh");
		public static final TagKey<Item> CHICKEN_LEG = forgeTag("chicken/leg");
		public static final TagKey<Item> CHICKEN_WING = forgeTag("chicken/wing");
		public static final TagKey<Item> GROUND_CHICKEN = forgeTag("chicken/ground");

		public static final TagKey<Item> CHICKEN_RAW = forgeTag("chicken/raw");
		public static final TagKey<Item> SCRAP_CHICKEN_RAW = forgeTag("chicken/scrap/raw");
		public static final TagKey<Item> CUBED_CHICKEN_RAW = forgeTag("chicken/cubed/raw");
		public static final TagKey<Item> STEW_CHICKEN_RAW = forgeTag("chicken/stew/raw");
		public static final TagKey<Item> CHICKEN_BREAST_RAW = forgeTag("chicken/breast/raw");
		public static final TagKey<Item> CHICKEN_THIGH_RAW = forgeTag("chicken/thigh/raw");
		public static final TagKey<Item> CHICKEN_LEG_RAW = forgeTag("chicken/leg/raw");
		public static final TagKey<Item> CHICKEN_WING_RAW = forgeTag("chicken/wing/raw");
		public static final TagKey<Item> GROUND_CHICKEN_RAW = forgeTag("chicken/ground/raw");

		public static final TagKey<Item> CHICKEN_COOKED = forgeTag("chicken/cooked");
		public static final TagKey<Item> SCRAP_CHICKEN_COOKED = forgeTag("chicken/scrap/cooked");
		public static final TagKey<Item> CUBED_CHICKEN_COOKED = forgeTag("chicken/cubed/cooked");
		public static final TagKey<Item> STEW_CHICKEN_COOKED = forgeTag("chicken/stew/cooked");
		public static final TagKey<Item> CHICKEN_BREAST_COOKED = forgeTag("chicken/breast/cooked");
		public static final TagKey<Item> CHICKEN_THIGH_COOKED = forgeTag("chicken/thigh/cooked");
		public static final TagKey<Item> CHICKEN_LEG_COOKED = forgeTag("chicken/leg/cooked");
		public static final TagKey<Item> CHICKEN_WING_COOKED = forgeTag("chicken/wing/cooked");
		public static final TagKey<Item> GROUND_CHICKEN_COOKED = forgeTag("chicken/ground/cooked");

		// Chicken
		public static final TagKey<Item> RABBIT = forgeTag("rabbit");
		public static final TagKey<Item> SCRAP_RABBIT = forgeTag("rabbit/scrap");
		public static final TagKey<Item> CUBED_RABBIT = forgeTag("rabbit/cubed");
		public static final TagKey<Item> STEW_RABBIT = forgeTag("rabbit/stew");
		public static final TagKey<Item> RABBIT_SADDLE = forgeTag("rabbit/saddle");
		public static final TagKey<Item> RABBIT_THIGH = forgeTag("rabbit/thigh");
		public static final TagKey<Item> RABBIT_LEG = forgeTag("rabbit/leg");
		public static final TagKey<Item> GROUND_RABBIT = forgeTag("rabbit/ground");

		public static final TagKey<Item> RABBIT_RAW = forgeTag("rabbit/raw");
		public static final TagKey<Item> SCRAP_RABBIT_RAW = forgeTag("rabbit/scrap/raw");
		public static final TagKey<Item> CUBED_RABBIT_RAW = forgeTag("rabbit/cubed/raw");
		public static final TagKey<Item> STEW_RABBIT_RAW = forgeTag("rabbit/stew/raw");
		public static final TagKey<Item> RABBIT_SADDLE_RAW = forgeTag("rabbit/saddle/raw");
		public static final TagKey<Item> RABBIT_THIGH_RAW = forgeTag("rabbit/thigh/raw");
		public static final TagKey<Item> RABBIT_LEG_RAW = forgeTag("rabbit/leg/raw");
		public static final TagKey<Item> GROUND_RABBIT_RAW = forgeTag("rabbit/ground/raw");

		public static final TagKey<Item> RABBIT_COOKED = forgeTag("rabbit/cooked");
		public static final TagKey<Item> SCRAP_RABBIT_COOKED = forgeTag("rabbit/scrap/cooked");
		public static final TagKey<Item> CUBED_RABBIT_COOKED = forgeTag("rabbit/cubed/cooked");
		public static final TagKey<Item> STEW_RABBIT_COOKED = forgeTag("rabbit/stew/cooked");
		public static final TagKey<Item> RABBIT_SADDLE_COOKED = forgeTag("rabbit/saddle/cooked");
		public static final TagKey<Item> RABBIT_THIGH_COOKED = forgeTag("rabbit/thigh/cooked");
		public static final TagKey<Item> RABBIT_LEG_COOKED = forgeTag("rabbit/leg/cooked");
		public static final TagKey<Item> GROUND_RABBIT_COOKED = forgeTag("rabbit/ground/cooked");

		// Guts
		public static final TagKey<Item> OFFAL = forgeTag("offal");
		public static final TagKey<Item> OFFAL_RAW = forgeTag("offal/raw");
		public static final TagKey<Item> OFFAL_COOKED = forgeTag("offal/cooked");

		public static final TagKey<Item> TRIPE = forgeTag("tripe");
		public static final TagKey<Item> TRIPE_RAW = forgeTag("tripe/raw");
		public static final TagKey<Item> TRIPE_COOKED = forgeTag("tripe/cooked");

		public static final TagKey<Item> STOMACH = forgeTag("stomach");
		public static final TagKey<Item> STOMACH_RAW = forgeTag("stomach/raw");
		public static final TagKey<Item> STOMACH_COOKED = forgeTag("stomach/cooked");

		public static final TagKey<Item> LUNG = forgeTag("lung");
		public static final TagKey<Item> LUNG_RAW = forgeTag("lung/raw");
		public static final TagKey<Item> LUNG_COOKED = forgeTag("lung/cooked");

		public static final TagKey<Item> LIVER = forgeTag("liver");
		public static final TagKey<Item> LIVER_RAW = forgeTag("liver/raw");
		public static final TagKey<Item> LIVER_COOKED = forgeTag("liver/cooked");

		public static final TagKey<Item> KIDNEY = forgeTag("kidney");
		public static final TagKey<Item> KIDNEY_RAW = forgeTag("kidney/raw");
		public static final TagKey<Item> KIDNEY_COOKED = forgeTag("kidney/cooked");

		public static final TagKey<Item> HEART = forgeTag("heart");
		public static final TagKey<Item> HEART_RAW = forgeTag("heart/raw");
		public static final TagKey<Item> HEART_COOKED = forgeTag("heart/cooked");

		public static final TagKey<Item> BRAIN = forgeTag("brain");
		public static final TagKey<Item> BRAIN_RAW = forgeTag("brain/raw");
		public static final TagKey<Item> BRAIN_COOKED = forgeTag("brain/cooked");

		public static final TagKey<Item> TONGUE = forgeTag("tongue");
		public static final TagKey<Item> TONGUE_RAW = forgeTag("tongue/raw");
		public static final TagKey<Item> TONGUE_COOKED = forgeTag("tongue/cooked");
		
		public static final TagKey<Item> SAUSAGE = forgeTag("sausage");
		public static final TagKey<Item> SAUSAGE_RAW = forgeTag("sausage/raw");
		public static final TagKey<Item> SAUSAGE_COOKED = forgeTag("sausage/cooked");
		
		public static final TagKey<Item> BLOOD_SAUSAGE = forgeTag("blood_sausage");
		public static final TagKey<Item> BLOOD_SAUSAGE_RAW = forgeTag("blood_sausage/raw");
		public static final TagKey<Item> BLOOD_SAUSAGE_COOKED = forgeTag("blood_sausage/cooked");
}

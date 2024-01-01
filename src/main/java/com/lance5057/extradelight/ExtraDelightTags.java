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

	public static final TagKey<Item> SALT = ItemTags.create(new ResourceLocation("salt", "can_be_salted"));

	public static final TagKey<Block> MORTAR_BLOCK = BlockTags.create(new ResourceLocation("forge", "mortars"));
	public static final TagKey<Item> MORTAR = ItemTags.create(new ResourceLocation("forge", "mortars"));
	public static final TagKey<Item> PESTLES = ItemTags.create(new ResourceLocation("forge", "pestles"));
	public static final TagKey<Item> SPOONS = ItemTags.create(new ResourceLocation("forge", "spoons"));
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
	
	public static final TagKey<Item> CONDIMENTS = forgeTag("condiment");
	public static final TagKey<Item> MAYO = forgeTag("mayonnaise");

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

	// Butchercraft

	// Generic Meat
	public static final TagKey<Item> MEAT = forgeTag("meat");
	public static final TagKey<Item> MEAT_RAW = forgeTag("meat/raw");
	public static final TagKey<Item> MEAT_COOKED = forgeTag("meat/cooked");

	public static final TagKey<Item> SAUSAGE = forgeTag("sausage");
	public static final TagKey<Item> SAUSAGE_RAW = forgeTag("sausage/raw");
	public static final TagKey<Item> SAUSAGE_COOKED = forgeTag("sausage/cooked");

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
	public static final TagKey<Item> OXTAIL = forgeTag("beef/oxtail");
	public static final TagKey<Item> GROUND_BEEF = forgeTag("beef/ground");

	public static final TagKey<Item> BEEF_RAW = forgeTag("beef/raw");
	public static final TagKey<Item> SCRAP_BEEF_RAW = forgeTag("beef/scrap/raw");
	public static final TagKey<Item> BEEF_ROAST_RAW = forgeTag("beef/roast/raw");
	public static final TagKey<Item> BEEF_RIBS_RAW = forgeTag("beef/ribs/raw");
	public static final TagKey<Item> CUBED_BEEF_RAW = forgeTag("beef/cubed/raw");
	public static final TagKey<Item> STEW_BEEF_RAW = forgeTag("beef/stew/raw");
	public static final TagKey<Item> OXTAIL_RAW = forgeTag("beef/oxtail/raw");
	public static final TagKey<Item> GROUND_BEEF_RAW = forgeTag("beef/ground/raw");

	public static final TagKey<Item> BEEF_COOKED = forgeTag("beef/cooked");
	public static final TagKey<Item> SCRAP_BEEF_COOKED = forgeTag("beef/scrap/cooked");
	public static final TagKey<Item> BEEF_ROAST_COOKED = forgeTag("beef/roast/cooked");
	public static final TagKey<Item> BEEF_RIBS_COOKED = forgeTag("beef/ribs/cooked");
	public static final TagKey<Item> CUBED_BEEF_COOKED = forgeTag("beef/cubed/cooked");
	public static final TagKey<Item> STEW_BEEF_COOKED = forgeTag("beef/stew/cooked");
	public static final TagKey<Item> OXTAIL_COOKED = forgeTag("beef/oxtail/cooked");
	public static final TagKey<Item> GROUND_BEEF_COOKED = forgeTag("beef/ground/cooked");

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

	public static final TagKey<Item> GELATIN = forgeTag("gelatin");
	public static final TagKey<Item> CHEESE = forgeTag("cheese");
	public static final TagKey<Item> BUTTER = forgeTag("butter");

	public static final TagKey<Item> SOUP = forgeTag("soup");

	public static final TagKey<Item> RICEBALL_FILLING = modTag("riceball_filling");

	public static final TagKey<Item> JELLY = modTag("jelly");

	public static final TagKey<Item> CORN_CONFISCATE = modTag("corn_dim_confiscate");
	public static final TagKey<Item> CANDY = forgeTag("candy");

	public static final TagKey<Item> CANDY_BOWL_VALID = modTag("candy_bowl_valid");
	public static final TagKey<Item> COOKIE_DOUGH = modTag("cookie_dough");
}

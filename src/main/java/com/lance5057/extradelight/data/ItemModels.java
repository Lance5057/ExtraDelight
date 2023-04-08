package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, ExistingFileHelper fh) {
		super(generator, ExtraDelight.MOD_ID, fh);
	}

	@Override
	protected void registerModels() {
		getBuilder(ExtraDelightItems.OVEN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/oven")));
		getBuilder(ExtraDelightItems.FOOD_DISPLAY.getId().getPath()).parent(
				new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/food_display")));
		getBuilder(ExtraDelightItems.DOUGH_SHAPING.getId().getPath()).parent(
				new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/doughforming")));
		getBuilder(ExtraDelightItems.MIXING_BOWL.getId().getPath()).parent(
				new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/mixing_bowl")));
		getBuilder(ExtraDelightItems.YEAST_POT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/yeast_pot")));
		getBuilder(ExtraDelightItems.VINEGAR_POT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/yeast_pot")))
				.texture("0", modLoc("block/vinegarpot"));
		getBuilder(ExtraDelightItems.GRATER.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/grater")));
		getBuilder(ExtraDelightItems.DRYING_RACK.getId().getPath()).parent(
				new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/drying_rack")));

		getBuilder(ExtraDelightItems.MORTAR_STONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/stone"));
		getBuilder(ExtraDelightItems.MORTAR_ANDESITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/andesite"));
		getBuilder(ExtraDelightItems.MORTAR_GRANITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/granite"));
		getBuilder(ExtraDelightItems.MORTAR_DIORITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/diorite"));
		getBuilder(ExtraDelightItems.MORTAR_DEEPSLATE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/deepslate"));
		getBuilder(ExtraDelightItems.MORTAR_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/blackstone"));
		getBuilder(ExtraDelightItems.MORTAR_BASALT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/basalt_top"));
		getBuilder(ExtraDelightItems.MORTAR_ENDSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/end_stone"));

		getBuilder(ExtraDelightItems.MORTAR_AMETHYST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/amethyst_block")); // not craftable, dungeon item
		getBuilder(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/mortar")))
				.texture("0", mcLoc("block/gilded_blackstone")); // not craftable, dungeon item

		getBuilder(ExtraDelightItems.PESTLE_STONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/stone"));
		getBuilder(ExtraDelightItems.PESTLE_ANDESITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/andesite"));
		getBuilder(ExtraDelightItems.PESTLE_GRANITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/granite"));
		getBuilder(ExtraDelightItems.PESTLE_DIORITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/diorite"));
		getBuilder(ExtraDelightItems.PESTLE_DEEPSLATE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/deepslate"));
		getBuilder(ExtraDelightItems.PESTLE_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/blackstone"));
		getBuilder(ExtraDelightItems.PESTLE_BASALT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/basalt_top"));
		getBuilder(ExtraDelightItems.PESTLE_ENDSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/end_stone"));

		getBuilder(ExtraDelightItems.PESTLE_AMETHYST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/amethyst_block")); // not craftable, dungeon item
		getBuilder(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/gilded_blackstone")); // not craftable, dungeon item

		forItem(ExtraDelightItems.ROUND_PAN, "round_pan");
		forItem(ExtraDelightItems.BAKING_STONE, "baking_stone");
		forItem(ExtraDelightItems.LOAF_PAN, "loaf_pan");
		forItem(ExtraDelightItems.MUFFIN_TIN, "muffin_tin");
		forItem(ExtraDelightItems.PIE_DISH, "pie_dish");
		forItem(ExtraDelightItems.SHEET, "sheet");
		forItem(ExtraDelightItems.SQUARE_PAN, "square_pan");
		forItem(ExtraDelightItems.TRAY, "tray");

		forItem(ExtraDelightItems.WOODEN_SPOON, "wooden_spoon");
		forItem(ExtraDelightItems.DIAMOND_SPOON, "diamond_spoon");
		forItem(ExtraDelightItems.GOLD_SPOON, "gold_spoon");
		forItem(ExtraDelightItems.IRON_SPOON, "iron_spoon");
		forItem(ExtraDelightItems.NETHERITE_SPOON, "netherite_spoon");
		forItem(ExtraDelightItems.STONE_SPOON, "stone_spoon");

		forItem(ExtraDelightItems.YEAST, "yeast");
		forItem(ExtraDelightItems.FLOUR, "flour");
		forItem(ExtraDelightItems.COOKING_OIL, "cooking_oil");
		forItem(ExtraDelightItems.SUNFLOWER_SEEDS, "sunflower_seeds");
		forItem(ExtraDelightItems.STOCK_JAR_ITEM, "broth");
		forItem(ExtraDelightItems.GRAVY_ITEM, "gravy");

		forItem(ExtraDelightItems.SEAWEED_PASTE, "seaweed_paste");
		forItem(ExtraDelightItems.AGAR_SHEETS, "agar_sheets");
		forItem(ExtraDelightItems.AGAR_AGAR, "agaragar");

		// Juice
		forItem(ExtraDelightItems.GLOW_BERRY_JUICE, "glow_berry_juice");
		forItem(ExtraDelightItems.SWEET_BERRY_JUICE, "sweet_berry_juice");
		forItem(ExtraDelightItems.TOMATO_JUICE, "tomato_juice");

		// Custard
		forItem(ExtraDelightItems.SWEET_BERRY_CUSTARD, "sweet_berry_custard");
		forItem(ExtraDelightItems.CHOCOLATE_CUSTARD, "chocolate_custard");
		forItem(ExtraDelightItems.PUMPKIN_CUSTARD, "pumpkin_custard");
		forItem(ExtraDelightItems.HONEY_CUSTARD, "honey_custard");

		// Pie
		forItem(ExtraDelightItems.SWEET_BERRY_PIE_SLICE, "sweet_berry_pie_slice");
		forItem(ExtraDelightItems.GLOW_BERRY_PIE_SLICE, "glow_berry_pie_slice");
		forItem(ExtraDelightItems.CHEESECAKE_SLICE, "cheesecake_slice");
		forItem(ExtraDelightItems.HONEY_CHEESECAKE_SLICE, "honey_cheesecake_slice");
		forItem(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE, "chocolate_cheesecake_slice");
		forItem(ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE, "pumpkin_cheesecake_slice");
		forItem(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE, "glow_berry_cheesecake_slice");

		forItem(ExtraDelightItems.SWEET_BERRY_PIE_ITEM, "sweet_berry_pie");
		forItem(ExtraDelightItems.GLOW_BERRY_PIE_ITEM, "glow_berry_pie");
		forItem(ExtraDelightItems.CHEESECAKE_ITEM, "cheesecake");
		forItem(ExtraDelightItems.HONEY_CHEESECAKE_ITEM, "honey_cheesecake");
		forItem(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM, "chocolate_cheesecake");
		forItem(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM, "pumpkin_cheesecake");
		forItem(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM, "glow_berry_cheesecake");

		// Cookies
		forItem(ExtraDelightItems.PUMPKIN_COOKIE, "pumpkin_cookie");
		forItem(ExtraDelightItems.SUGAR_COOKIE, "sugar_cookie");
		forItem(ExtraDelightItems.GLOW_BERRY_COOKIE, "glow_berry_cookie");

		// Popsicle
		forItem(ExtraDelightItems.GLOW_BERRY_POPSICLE, "glow_berry_popsicle");
		forItem(ExtraDelightItems.SWEET_BERRY_POPSICLE, "sweet_berry_popsicle");
		forItem(ExtraDelightItems.FUDGE_POPSICLE, "fudge_popsicle");
		forItem(ExtraDelightItems.HONEY_POPSICLE, "honey_popsicle");

		forItem(ExtraDelightItems.WHIPPED_CREAM, "whipped_cream");
//
//		forItem(ExtraDelightItems.PLAIN_CAKE, "plain_cake");

		// Eggs
		forItem(ExtraDelightItems.EGG_MIX, "egg_mix");
		forItem(ExtraDelightItems.SCRAMBLED_EGGS, "scrambled_eggs");
		forItem(ExtraDelightItems.OMELETTE_MIX, "omelette_mix");
		forItem(ExtraDelightItems.OMELETTE, "omelette");
		forItem(ExtraDelightItems.BOILED_EGG, "hard_boiled_egg");
		forItem(ExtraDelightItems.QUICHE, "quiche");
		forItem(ExtraDelightItems.QUICHE_SLICE, "quiche_slice");
		forItem(ExtraDelightItems.EGG_SALAD, "egg_salad");

		// Condiments
		forItem(ExtraDelightItems.KETCHUP_JAR_ITEM, "ketchup");
		forItem(ExtraDelightItems.BBQ_JAR_ITEM, "bbq");
		forItem(ExtraDelightItems.MAYO_JAR_ITEM, "mayo");
		forItem(ExtraDelightItems.VINEGAR, "vinegar");

		// Bread
		forItem(ExtraDelightItems.BREAD_SLICE, "bread_slice");
		forItem(ExtraDelightItems.TOAST, "toast");
		forItem(ExtraDelightItems.JAM_TOAST, "jam_toast");
		forItem(ExtraDelightItems.GOLDEN_JAM_TOAST, "golden_jam_toast");
		forItem(ExtraDelightItems.EGG_BASKET, "egg_in_the_basket");

		// Jam
		forItem(ExtraDelightItems.APPLE_JAM, "apple_jam");
		forItem(ExtraDelightItems.CARROT_JAM, "carrot_jam");
		forItem(ExtraDelightItems.GLOW_BERRY_JAM, "glow_berry_jam");
		forItem(ExtraDelightItems.SWEET_BERRY_JAM, "sweet_berry_jam");
		forItem(ExtraDelightItems.GOLDEN_APPLE_JAM, "golden_apple_jam");

		// Potato
		forItem(ExtraDelightItems.POTATO_CHIPS, "potato_chips");
		forItem(ExtraDelightItems.SLICED_POTATO, "sliced_potato");
		forItem(ExtraDelightItems.GRATED_POTATO, "grated_potato");
		forItem(ExtraDelightItems.HASHBROWNS, "hashbrowns");
		forItem(ExtraDelightItems.POTATO_STICKS, "potato_sticks");
		forItem(ExtraDelightItems.FRENCH_FRIES, "frenchfries");

		// Carrot
		forItem(ExtraDelightItems.GLAZED_CARROT, "glazed_carrot");
		forItem(ExtraDelightItems.ROASTED_CARROT, "roasted_carrot");
		forItem(ExtraDelightItems.CARROT_SALAD, "carrot_salad");
		forItem(ExtraDelightItems.GRATED_CARROT, "shredded_carrot");

		// Apple
		forItem(ExtraDelightItems.APPLE_SAUCE, "apple_sauce");
		forItem(ExtraDelightItems.ROASTED_APPLE, "roasted_apple");
		forItem(ExtraDelightItems.SLICED_APPLE, "apple_slices");

		// Soup
		forItem(ExtraDelightItems.CARROT_SOUP, "carrot_soup");
		forItem(ExtraDelightItems.FISH_SOUP, "fish_soup");
		forItem(ExtraDelightItems.POTATO_SOUP, "potato_soup");
		forItem(ExtraDelightItems.TOMATO_SOUP, "tomato_soup");

		// Sandwiches
		forItem(ExtraDelightItems.DYNAMIC_SANDWICH, "sandwich");
		forItem(ExtraDelightItems.EGG_SALAD_SANDWICH, "egg_salad_sandwich");

		// Feasts
		forBlockItem(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/salisbury_steak_block_stage0"));
		forItem(ExtraDelightItems.SALISBURY_STEAK, "salisbury_steak");

		forBlockItem(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/mashed_potato_gravy_block_stage0"));
		forItem(ExtraDelightItems.MASHED_POTATO_GRAVY, "mashed_potato_gravy");

		forItem(ExtraDelightItems.SAUSAGE, "sausage");
		forItem(ExtraDelightItems.COOKED_SAUSAGE, "sausagecooked");
		forItem(ExtraDelightItems.JERKY, "beef_jerky");

		forItem(ExtraDelightItems.LAMB_STEW, "lamb_stew");
		forItem(ExtraDelightItems.PORK_STEW, "pork_stew");

		forItem(ExtraDelightItems.SAUSAGE_ROLL, "sausage_roll");
		forItem(ExtraDelightItems.SOS, "sos");
		forItem(ExtraDelightItems.LIVER_ONIONS, "liver_onions");
		forItem(ExtraDelightItems.FRENCH_FRIES, "frenchfries");
		forItem(ExtraDelightItems.FRIED_FISH, "friedfish");
		forItem(ExtraDelightItems.CHICKEN_FRIED_STEAK, "chickenfriedsteak");
		forItem(ExtraDelightItems.PORK_TENDERLOIN, "pork_tenderloin");
		forItem(ExtraDelightItems.FRIED_CHICKEN, "friedchicken");
		forItem(ExtraDelightItems.STUFFED_HEART, "stuffedheart");
		forItem(ExtraDelightItems.FRIED_BRAINS, "friedbrains");
		forItem(ExtraDelightItems.OXTAIL_SOUP, "oxtail_soup");
		forItem(ExtraDelightItems.GRILLED_CHEESE, "grilled_cheese");

		forItem(ExtraDelightItems.CHEESE, "cheese");
		forItem(ExtraDelightItems.BUTTER, "butter");

		forBlockItem(ExtraDelightItems.CHEESE_BLOCK_ITEM, "cheese_block");
		forBlockItem(ExtraDelightItems.BUTTER_BLOCK_ITEM, "butter_block");

		forBlockItem(ExtraDelightItems.HASH_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/hash_block_stage0"));
		forItem(ExtraDelightItems.HASH, "hash");

		forBlockItem(ExtraDelightItems.POT_ROAST_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/potroast_block_stage0"));
		forItem(ExtraDelightItems.POT_ROAST, "pot_roast");

		forBlockItem(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/bbq_ribs_block_stage0"));
		forItem(ExtraDelightItems.BBQ_RIBS, "bbq_ribs");

		forBlockItem(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/meat_pie"));
		forItem(ExtraDelightItems.MEAT_PIE_SLICE, "meat_pie_slice");

		forBlockItem(ExtraDelightItems.PULLED_PORK_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/pulled_pork_block_stage0"));
		forItem(ExtraDelightItems.PULLED_PORK_SANDWICH, "pulled_pork_sandwich");

		forBlockItem(ExtraDelightItems.RACK_LAMB_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/rack_lamb_block_stage0"));
		forItem(ExtraDelightItems.RACK_LAMB, "rack_lamb");

		forBlockItem(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/beef_wellington_block_stage0"));
		forItem(ExtraDelightItems.BEEF_WELLINGTON, "beef_wellington");

		forBlockItem(ExtraDelightItems.HAGGIS_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/haggis_block_stage0"));
		forItem(ExtraDelightItems.HAGGIS, "haggis");

		forBlockItem(ExtraDelightItems.STIRFRY_FEAST_ITEM,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/stirfry_block_stage0"));
		forItem(ExtraDelightItems.STIRFRY, "stirfry");

		this.jellyBlock(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM, "white");
		this.jellyBlock(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM, "orange");
		this.jellyBlock(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM, "magenta");
		this.jellyBlock(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM, "light_blue");
		this.jellyBlock(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM, "yellow");
		this.jellyBlock(ExtraDelightItems.JELLY_LIME_FEAST_ITEM, "lime");
		this.jellyBlock(ExtraDelightItems.JELLY_PINK_FEAST_ITEM, "pink");
		this.jellyBlock(ExtraDelightItems.JELLY_GREY_FEAST_ITEM, "grey");
		this.jellyBlock(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM, "light_grey");
		this.jellyBlock(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM, "cyan");
		this.jellyBlock(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM, "purple");
		this.jellyBlock(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM, "blue");
		this.jellyBlock(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM, "brown");
		this.jellyBlock(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM, "green");
		this.jellyBlock(ExtraDelightItems.JELLY_RED_FEAST_ITEM, "red");
		this.jellyBlock(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM, "black");

		forItem(ExtraDelightItems.JELLY_WHITE, "jelly_white");
		forItem(ExtraDelightItems.JELLY_ORANGE, "jelly_orange");
		forItem(ExtraDelightItems.JELLY_MAGENTA, "jelly_magenta");
		forItem(ExtraDelightItems.JELLY_LIGHT_BLUE, "jelly_light_blue");
		forItem(ExtraDelightItems.JELLY_YELLOW, "jelly_yellow");
		forItem(ExtraDelightItems.JELLY_LIME, "jelly_lime");
		forItem(ExtraDelightItems.JELLY_PINK, "jelly_pink");
		forItem(ExtraDelightItems.JELLY_GREY, "jelly_grey");
		forItem(ExtraDelightItems.JELLY_LIGHT_GREY, "jelly_light_grey");
		forItem(ExtraDelightItems.JELLY_CYAN, "jelly_cyan");
		forItem(ExtraDelightItems.JELLY_PURPLE, "jelly_purple");
		forItem(ExtraDelightItems.JELLY_BLUE, "jelly_blue");
		forItem(ExtraDelightItems.JELLY_BROWN, "jelly_brown");
		forItem(ExtraDelightItems.JELLY_GREEN, "jelly_green");
		forItem(ExtraDelightItems.JELLY_RED, "jelly_red");
		forItem(ExtraDelightItems.JELLY_BLACK, "jelly_black");

		forItem(ExtraDelightItems.MACARONI, "macaroni");
		forItem(ExtraDelightItems.LASAGNA_NOODLES, "lasagna_noodles");

		forItem(ExtraDelightItems.SEAWEED_CRISPS, "seaweed_crisps");
		forItem(ExtraDelightItems.SEAWEED_SALAD, "seaweed_salad");
		forItem(ExtraDelightItems.FURIKAKE, "furikake");
		forItem(ExtraDelightItems.FURIKAKE_RICE, "furikake_rice");
		forItem(ExtraDelightItems.FISH_FLAKES, "fish_flakes");
		forItem(ExtraDelightItems.CURRY_POWDER, "curry_powder");
		forItem(ExtraDelightItems.FISH_CAKES, "fish_cakes");
		forItem(ExtraDelightItems.FISH_AND_CHIPS, "fish_chips");
		forItem(ExtraDelightItems.FRIED_MUSHROOMS, "fried_mushrooms");
		forItem(ExtraDelightItems.MUSHROOM_RISOTTO, "mushroom_risotto");
		forItem(ExtraDelightItems.STUFFED_MUSHROOMS, "stuffed_mushrooms");
		forItem(ExtraDelightItems.MUSHROOM_BURGER, "mushroom_burger");

		forItem(ExtraDelightItems.RABBIT_STEW, "rabbit_stew");
		forItem(ExtraDelightItems.CURRY, "curry");
		forItem(ExtraDelightItems.CHICKEN_STEW, "chicken_stew");

		forBlockItem(ExtraDelightItems.MACARONI_CHEESE_FEAST,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/macaroni_cheese_block_stage0"));
		forItem(ExtraDelightItems.MACARONI_CHEESE, "macaroni_cheese");

		forBlockItem(ExtraDelightItems.HOTDISH_FEAST,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/hotdish_block_stage0"));
		forItem(ExtraDelightItems.HOTDISH, "hotdish");

		forBlockItem(ExtraDelightItems.LASANGA_FEAST,
				new ResourceLocation(ExtraDelight.MOD_ID, "block/lasagna_block_stage0"));
		forItem(ExtraDelightItems.LASAGNA, "lasagna");

		AestheticBlocks.itemModel(this);
	}

	public void forItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, String name) {
		getBuilder(item.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(item.get().getBlock()).getPath())));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation));
	}

	public void forBlockItem(RegistryObject<? extends BlockItem> item, ResourceLocation modelLocation, String key,
			ResourceLocation texture) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation)).texture(key,
				texture);
	}

	public void jellyBlock(RegistryObject<? extends BlockItem> item, String color) {
		ModelFile jellyModel = new ModelFile.UncheckedModelFile(modLoc("block/jelly_block_stage0"));

		getBuilder(item.getId().getPath()).parent(jellyModel).texture("1",
				new ResourceLocation(ExtraDelight.MOD_ID, "block/jelly_" + color));
	}
}
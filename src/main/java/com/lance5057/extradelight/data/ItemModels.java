package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.client.BlockStateItemGeometryLoader;
import com.lance5057.extradelight.items.dynamicfood.client.DynamicFoodGeometryLoader;
import com.lance5057.extradelight.modules.Fermentation;

import com.lance5057.extradelight.modules.SummerCitrus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemModels extends ItemModelProvider {

	public ItemModels(PackOutput output, ExistingFileHelper fh) {
		super(output, ExtraDelight.MOD_ID, fh);
	}

	@Override
	protected void registerModels() {
		getBuilder(ExtraDelightItems.OVEN.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/oven")));
		getBuilder(ExtraDelightItems.DOUGH_SHAPING.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/doughforming")));
		getBuilder(ExtraDelightItems.MIXING_BOWL.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.YEAST_POT.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/yeast_pot")));
		getBuilder(ExtraDelightItems.VINEGAR_POT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/yeast_pot")))
				.texture("0", modLoc("block/vinegarpot"));
		getBuilder(ExtraDelightItems.GRATER.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/grater")));

		getBuilder(ExtraDelightItems.OFFSET_SPATULA_DIAMOND.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/offset_spatula"), existingFileHelper))
				.texture("0", modLoc("item/offset_spatula_diamond"));
		getBuilder(ExtraDelightItems.OFFSET_SPATULA_GOLD.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/offset_spatula"), existingFileHelper))
				.texture("0", modLoc("item/offset_spatula_gold"));
		getBuilder(ExtraDelightItems.OFFSET_SPATULA_IRON.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/offset_spatula"), existingFileHelper))
				.texture("0", modLoc("item/offset_spatula_iron"));
		getBuilder(ExtraDelightItems.OFFSET_SPATULA_NETHERITE.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/offset_spatula"), existingFileHelper))
				.texture("0", modLoc("item/offset_spatula_netherite"));
		getBuilder(ExtraDelightItems.OFFSET_SPATULA_WOOD.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/offset_spatula"), existingFileHelper))
				.texture("0", modLoc("item/offset_spatula_wood"));

		getBuilder(ExtraDelightItems.DRYING_RACK.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/drying_rack")));

		getBuilder(ExtraDelightItems.MORTAR_STONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.PESTLE_STONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/stone"));
		getBuilder(ExtraDelightItems.PESTLE_ANDESITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/andesite"));
		getBuilder(ExtraDelightItems.PESTLE_GRANITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/granite"));
		getBuilder(ExtraDelightItems.PESTLE_DIORITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/diorite"));
		getBuilder(ExtraDelightItems.PESTLE_DEEPSLATE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/deepslate"));
		getBuilder(ExtraDelightItems.PESTLE_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/blackstone"));
		getBuilder(ExtraDelightItems.PESTLE_BASALT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/basalt_top"));
		getBuilder(ExtraDelightItems.PESTLE_ENDSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/end_stone"));

		getBuilder(ExtraDelightItems.PESTLE_AMETHYST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/amethyst_block")); // not craftable, dungeon item
		getBuilder(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/pestle")))
				.texture("0", mcLoc("block/gilded_blackstone")); // not craftable, dungeon item

		getBuilder(ExtraDelightItems.CORN_COB_PIPE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/corncob_pipe")))
				.texture("1", modLoc("item/corncob_pipe"));

		getBuilder(ExtraDelightItems.EVAPORATOR.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		this.getBuilder(ExtraDelightItems.BAKING_STONE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.LOAF_PAN.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.MUFFIN_TIN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.PIE_DISH.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.SHEET.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.TRAY.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.SQUARE_PAN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.SERVING_POT.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.WOODEN_SPOON, "wooden_spoon");
		forItem(this, ExtraDelightItems.DIAMOND_SPOON, "diamond_spoon");
		forItem(this, ExtraDelightItems.GOLD_SPOON, "gold_spoon");
		forItem(this, ExtraDelightItems.IRON_SPOON, "iron_spoon");
		forItem(this, ExtraDelightItems.NETHERITE_SPOON, "netherite_spoon");
		forItem(this, ExtraDelightItems.STONE_SPOON, "stone_spoon");

		forItem(this, ExtraDelightItems.YEAST, "yeast");
		forItem(this, ExtraDelightItems.FLOUR, "flour");
		forItem(this, ExtraDelightItems.COOKING_OIL, "cooking_oil");
		forItem(this, ExtraDelightItems.SUNFLOWER_SEEDS, "sunflower_seeds");
		forItem(this, ExtraDelightItems.GRAVY, "gravy");

		forItem(this, ExtraDelightItems.SEAWEED_PASTE, "seaweed_paste");
		forItem(this, ExtraDelightItems.AGAR_SHEETS, "agar_sheets");
		forItem(this, ExtraDelightItems.AGAR_AGAR, "agaragar");

		// Juice
		forItem(this, ExtraDelightItems.GLOW_BERRY_JUICE, "glow_berry_juice");
		forItem(this, ExtraDelightItems.SWEET_BERRY_JUICE, "sweet_berry_juice");
		forItem(this, ExtraDelightItems.TOMATO_JUICE, "tomato_juice");

		// Custard
		forItem(this, ExtraDelightItems.SWEET_BERRY_CUSTARD, "sweet_berry_custard");
		forItem(this, ExtraDelightItems.CHOCOLATE_CUSTARD, "chocolate_custard");
		forItem(this, ExtraDelightItems.PUMPKIN_CUSTARD, "pumpkin_custard");
		forItem(this, ExtraDelightItems.HONEY_CUSTARD, "honey_custard");
		forItem(this, ExtraDelightItems.APPLE_CUSTARD, "apple_custard");

		// Pie
		forItem(this, ExtraDelightItems.SWEET_BERRY_PIE_SLICE, "sweet_berry_pie_slice");
		forItem(this, ExtraDelightItems.GLOW_BERRY_PIE_SLICE, "glow_berry_pie_slice");
		forItem(this, ExtraDelightItems.CHEESECAKE_SLICE, "cheesecake_slice");
		forItem(this, ExtraDelightItems.HONEY_CHEESECAKE_SLICE, "honey_cheesecake_slice");
		forItem(this, ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE, "chocolate_cheesecake_slice");
		forItem(this, ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE, "pumpkin_cheesecake_slice");
		forItem(this, ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE, "glow_berry_cheesecake_slice");
		forItem(this, ExtraDelightItems.APPLE_CHEESECAKE_SLICE, "apple_cheesecake_slice");

		forItem(this, ExtraDelightItems.SWEET_BERRY_PIE_ITEM, "sweet_berry_pie");
		forItem(this, ExtraDelightItems.GLOW_BERRY_PIE_ITEM, "glow_berry_pie");
		forItem(this, ExtraDelightItems.CHEESECAKE_ITEM, "cheesecake");
		forItem(this, ExtraDelightItems.HONEY_CHEESECAKE_ITEM, "honey_cheesecake");
		forItem(this, ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM, "chocolate_cheesecake");
		forItem(this, ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM, "pumpkin_cheesecake");
		forItem(this, ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM, "glow_berry_cheesecake");
		forItem(this, ExtraDelightItems.APPLE_CHEESECAKE_ITEM, "apple_cheesecake");

		// Cookies
		forItem(this, ExtraDelightItems.PUMPKIN_COOKIE, "pumpkin_cookie");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE, "sugar_cookie");
		forItem(this, ExtraDelightItems.GLOW_BERRY_COOKIE, "glow_berry_cookie");
		forItem(this, ExtraDelightItems.APPLE_COOKIE, "apple_cookie");

		// Popsicle
		forItem(this, ExtraDelightItems.GLOW_BERRY_POPSICLE, "glow_berry_popsicle");
		forItem(this, ExtraDelightItems.SWEET_BERRY_POPSICLE, "sweet_berry_popsicle");
		forItem(this, ExtraDelightItems.FUDGE_POPSICLE, "fudge_popsicle");
		forItem(this, ExtraDelightItems.HONEY_POPSICLE, "honey_popsicle");
		forItem(this, ExtraDelightItems.APPLE_POPSICLE, "apple_popsicle");

		forItem(this, ExtraDelightItems.WHIPPED_CREAM, "whipped_cream");

		// Eggs
		forItem(this, ExtraDelightItems.EGG_MIX, "egg_mix");
		forItem(this, ExtraDelightItems.SCRAMBLED_EGGS, "scrambled_eggs");
		forItem(this, ExtraDelightItems.OMELETTE_MIX, "omelette_mix");
		forItem(this, ExtraDelightItems.OMELETTE, "omelette");
		forItem(this, ExtraDelightItems.BOILED_EGG, "hard_boiled_egg");
		forItem(this, ExtraDelightItems.QUICHE, "quiche");
		forItem(this, ExtraDelightItems.QUICHE_SLICE, "quiche_slice");
		forItem(this, ExtraDelightItems.EGG_SALAD, "egg_salad");

		// Condiments
		forItem(this, ExtraDelightItems.KETCHUP, "ketchup");
		forItem(this, ExtraDelightItems.BBQ_SAUCE, "bbq");
		forItem(this, ExtraDelightItems.MAYO, "mayo");
		forItem(this, ExtraDelightItems.VINEGAR, "vinegar");

		// Bread
		forItem(this, ExtraDelightItems.BREAD_SLICE, "bread_slice");
		forItem(this, ExtraDelightItems.TOAST, "toast");
		forItem(this, ExtraDelightItems.EGG_BASKET, "egg_in_the_basket");

		// Jam
		forItem(this, ExtraDelightItems.GLOW_BERRY_JAM, "glow_berry_jam");
		forItem(this, ExtraDelightItems.JAM, "sweet_berry_jam");
		forItem(this, ExtraDelightItems.GOLDEN_APPLE_JAM, "golden_apple_jam");

		// Potato
		forItem(this, ExtraDelightItems.POTATO_CHIPS, "potato_chips");
		forItem(this, ExtraDelightItems.SLICED_POTATO, "sliced_potato");
		forItem(this, ExtraDelightItems.GRATED_POTATO, "grated_potato");
		forItem(this, ExtraDelightItems.HASHBROWNS, "hashbrowns");
		forItem(this, ExtraDelightItems.POTATO_STICKS, "potato_sticks");
		forItem(this, ExtraDelightItems.FRENCH_FRIES, "frenchfries");

		// Carrot
		forItem(this, ExtraDelightItems.GLAZED_CARROT, "glazed_carrot");
		forItem(this, ExtraDelightItems.ROASTED_CARROT, "roasted_carrot");
		forItem(this, ExtraDelightItems.CARROT_SALAD, "carrot_salad");
		forItem(this, ExtraDelightItems.GRATED_CARROT, "shredded_carrot");

		// Apple
		forItem(this, ExtraDelightItems.APPLE_SAUCE, "apple_sauce");
		forItem(this, ExtraDelightItems.ROASTED_APPLE, "roasted_apple");
		forItem(this, ExtraDelightItems.SLICED_APPLE, "apple_slices");

		// Soup
		forItem(this, ExtraDelightItems.CARROT_SOUP, "carrot_soup");
		forItem(this, ExtraDelightItems.FISH_SOUP, "fish_soup");
		forItem(this, ExtraDelightItems.POTATO_SOUP, "potato_soup");
		forItem(this, ExtraDelightItems.TOMATO_SOUP, "tomato_soup");

		// Sandwiches
		forItem(this, ExtraDelightItems.EGG_SALAD_SANDWICH, "egg_salad_sandwich");

		// Feasts
		getBuilder(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.SALISBURY_STEAK, "salisbury_steak");

		getBuilder(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.MASHED_POTATO_GRAVY, "mashed_potato_gravy");

		forItem(this, ExtraDelightItems.JERKY, "beef_jerky");

		forItem(this, ExtraDelightItems.LAMB_STEW, "lamb_stew");
		forItem(this, ExtraDelightItems.PORK_STEW, "pork_stew");

		forItem(this, ExtraDelightItems.LAMB_STEW_RICE, "lamb_stew_rice");
		forItem(this, ExtraDelightItems.PORK_STEW_RICE, "pork_stew_rice");
		forItem(this, ExtraDelightItems.RABBIT_STEW_RICE, "rabbit_stew_rice");
		forItem(this, ExtraDelightItems.CHICKEN_STEW_RICE, "chicken_stew_rice");
		forItem(this, ExtraDelightItems.BEEF_STEW_RICE, "beef_stew_rice");
		forItem(this, ExtraDelightItems.FISH_STEW_RICE, "fish_stew_rice");
		forItem(this, ExtraDelightItems.CURRY_RICE, "curry_rice");

		forItem(this, ExtraDelightItems.SAUSAGE_ROLL, "sausage_roll");
		forItem(this, ExtraDelightItems.SOS, "sos");
		forItem(this, ExtraDelightItems.LIVER_ONIONS, "liver_onions");
		forItem(this, ExtraDelightItems.FRENCH_FRIES, "frenchfries");
		forItem(this, ExtraDelightItems.FRIED_FISH, "friedfish");
		forItem(this, ExtraDelightItems.CHICKEN_FRIED_STEAK, "chickenfriedsteak");
		forItem(this, ExtraDelightItems.PORK_TENDERLOIN, "pork_tenderloin");
		forItem(this, ExtraDelightItems.PORK_TENDERLOIN_SANDWICH, "pork_tenderloin_sandwich");
		forItem(this, ExtraDelightItems.FRIED_CHICKEN, "friedchicken");
		forItem(this, ExtraDelightItems.STUFFED_HEART, "stuffedheart");
		forItem(this, ExtraDelightItems.FRIED_BRAINS, "friedbrains");
		forItem(this, ExtraDelightItems.OXTAIL_SOUP, "oxtail_soup");

		forItem(this, ExtraDelightItems.CHEESE_SANDWICH, "cheese_sandwich");
		forItem(this, ExtraDelightItems.GRILLED_CHEESE, "grilled_cheese");

		forItem(this, ExtraDelightItems.CHEESE, "cheese");
		forItem(this, ExtraDelightItems.BUTTER, "butter");

		forBlockItem(this, ExtraDelightItems.CHEESE_BLOCK_ITEM, "cheese_block");
		forBlockItem(this, ExtraDelightItems.BUTTER_BLOCK_ITEM, "butter_block");

		getBuilder(ExtraDelightItems.HASH_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.HASH, "hash");

		getBuilder(ExtraDelightItems.POT_ROAST_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.POT_ROAST, "pot_roast");

		getBuilder(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BBQ_RIBS, "bbq_ribs");

		forItem(this, ExtraDelightItems.MEAT_PIE_BLOCK_ITEM, "meat_pie");
		forItem(this, ExtraDelightItems.MEAT_PIE_SLICE, "meat_pie_slice");

		getBuilder(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.PULLED_PORK_SANDWICH, "pulled_pork_sandwich");

		getBuilder(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.RACK_LAMB, "rack_lamb");

		getBuilder(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BEEF_WELLINGTON, "beef_wellington");

		getBuilder(ExtraDelightItems.HAGGIS_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.HAGGIS, "haggis");

		getBuilder(ExtraDelightItems.STIRFRY_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.STIRFRY, "stirfry");

		getBuilder(ExtraDelightItems.MEAT_LOAF_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.MEAT_LOAF, "meatloaf");

		getBuilder(ExtraDelightItems.BEEF_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.CHICKEN_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.FISH_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.LAMB_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.PORK_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.RABBIT_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.CURRY_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		this.getBuilder(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_RED_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		this.getBuilder(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.JELLY_WHITE, "jelly_white");
		forItem(this, ExtraDelightItems.JELLY_ORANGE, "jelly_orange");
		forItem(this, ExtraDelightItems.JELLY_MAGENTA, "jelly_magenta");
		forItem(this, ExtraDelightItems.JELLY_LIGHT_BLUE, "jelly_light_blue");
		forItem(this, ExtraDelightItems.JELLY_YELLOW, "jelly_yellow");
		forItem(this, ExtraDelightItems.JELLY_LIME, "jelly_lime");
		forItem(this, ExtraDelightItems.JELLY_PINK, "jelly_pink");
		forItem(this, ExtraDelightItems.JELLY_GREY, "jelly_grey");
		forItem(this, ExtraDelightItems.JELLY_LIGHT_GREY, "jelly_light_grey");
		forItem(this, ExtraDelightItems.JELLY_CYAN, "jelly_cyan");
		forItem(this, ExtraDelightItems.JELLY_PURPLE, "jelly_purple");
		forItem(this, ExtraDelightItems.JELLY_BLUE, "jelly_blue");
		forItem(this, ExtraDelightItems.JELLY_BROWN, "jelly_brown");
		forItem(this, ExtraDelightItems.JELLY_GREEN, "jelly_green");
		forItem(this, ExtraDelightItems.JELLY_RED, "jelly_red");
		forItem(this, ExtraDelightItems.JELLY_BLACK, "jelly_black");

		forItem(this, ExtraDelightItems.MACARONI, "macaroni");
		forItem(this, ExtraDelightItems.LASAGNA_NOODLES, "lasagna_noodles");

		forItem(this, ExtraDelightItems.SEAWEED_CRISPS, "seaweed_crisps");
		forItem(this, ExtraDelightItems.SEAWEED_SALAD, "seaweed_salad");
		forItem(this, ExtraDelightItems.FURIKAKE, "furikake");
		forItem(this, ExtraDelightItems.FURIKAKE_RICE, "furikake_rice");
		forItem(this, ExtraDelightItems.FISH_FLAKES, "fish_flakes");
		forItem(this, ExtraDelightItems.CURRY_POWDER, "curry_powder");
		forItem(this, ExtraDelightItems.FISH_CAKES, "fish_cakes");
		forItem(this, ExtraDelightItems.FISH_AND_CHIPS, "fish_chips");
		forItem(this, ExtraDelightItems.FRIED_MUSHROOMS, "fried_mushrooms");
		forItem(this, ExtraDelightItems.MUSHROOM_RISOTTO, "mushroom_risotto");
		forItem(this, ExtraDelightItems.STUFFED_MUSHROOMS, "stuffed_mushrooms");
		forItem(this, ExtraDelightItems.MUSHROOM_BURGER, "mushroom_burger");

		forItem(this, ExtraDelightItems.COOKED_PASTA, "cooked_pasta");
		forItem(this, ExtraDelightItems.BUTTERED_PASTA, "buttered_pasta");

		forItem(this, ExtraDelightItems.CURRY, "curry");
		forItem(this, ExtraDelightItems.CHICKEN_STEW, "chicken_stew");

		forItem(this, ExtraDelightItems.MEAT_LOAF, "meatloaf");
		forItem(this, ExtraDelightItems.MEAT_LOAF_SANDWICH, "meatloaf_sandwich");

		getBuilder(ExtraDelightItems.MACARONI_CHEESE_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.MACARONI_CHEESE, "macaroni_cheese");

		getBuilder(ExtraDelightItems.HOTDISH_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.HOTDISH, "hotdish");

		getBuilder(ExtraDelightItems.LASAGNA_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.LASAGNA, "lasagna");

		forItem(this, ExtraDelightItems.BREAD_CRUMBS, "breadcrumbs");
		forItem(this, ExtraDelightItems.BREADING_MISANPLAS, "breading_misanplas");

		forItem(this, ExtraDelightItems.BACON_EGG_SANDWICH, "bacon_egg_sandwich");
		forItem(this, ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH, "bacon_egg_cheese_sandwich");
		forItem(this, ExtraDelightItems.CROUTONS, "croutons");

		forItem(this, ExtraDelightItems.SALAD, "chef_salad");
		getBuilder(ExtraDelightItems.SALAD_FEAST_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.ALFREDO_SAUCE, "alfredo_sauce");
		forItem(this, ExtraDelightItems.CHICKEN_ALFREDO, "chicken_alfredo");
		forItem(this, ExtraDelightItems.PASTA_ALFREDO, "pasta_alfredo_sauce");
		forItem(this, ExtraDelightItems.PASTA_TOMATO, "pasta_tomato_sauce");
		forItem(this, ExtraDelightItems.CHICKEN_PARM, "chicken_parm");
		forItem(this, ExtraDelightItems.CHEESEBURGER, "cheeseburger");
		forItem(this, ExtraDelightItems.BACON_CHEESEBURGER, "pickle_bacon_cheeseburger");

		forItem(this, ExtraDelightItems.RICEBALL, "riceball");
		forItem(this, ExtraDelightItems.RICEBALL_FILLED, "riceball_filled");

		forItem(this, ExtraDelightItems.FISH_SALAD, "fish_salad");
		forItem(this, ExtraDelightItems.FISH_SALAD_SANDWICH, "fish_salad_sandwich");

		forItem(this, ExtraDelightItems.SLICED_TOMATO, "sliced_tomato");
		forItem(this, ExtraDelightItems.SLICED_ONION, "sliced_onion");

		forItem(this, ExtraDelightItems.COOKED_PASTA, "cooked_pasta");
		forItem(this, ExtraDelightItems.BUTTERED_PASTA, "buttered_pasta");

		forItem(this, ExtraDelightItems.BAD_FOOD, "badfood");

		forItem(this, ExtraDelightItems.CACTUS, "cactus_paddle");
		forItem(this, ExtraDelightItems.COOKED_CACTUS, "cactus_paddle_cooked");
		forItem(this, ExtraDelightItems.CACTUS_SALAD, "cactus_salad");
		forItem(this, ExtraDelightItems.CACTUS_SOUP, "cactus_soup");
		forItem(this, ExtraDelightItems.CACTUS_EGGS, "cactus_eggs");
		forItem(this, ExtraDelightItems.CACTUS_JUICE, "cactus_juice");
		forItem(this, ExtraDelightItems.STUFFED_CACTUS, "stuffed_cactus");

		forItem(this, ExtraDelightItems.CORN_SEEDS, "crops/corn/corn_seeds");
		forItem(this, ExtraDelightItems.CORN_COB, "crops/corn/corn_cob");
		forItem(this, ExtraDelightItems.CORN_HUSK, "crops/corn/corn_husk");
		forItem(this, ExtraDelightItems.CORN_ON_COB, "crops/corn/corn_on_cob");
		forItem(this, ExtraDelightItems.CORN_SILK, "crops/corn/corn_silk");
		forItem(this, ExtraDelightItems.DRIED_CORN_HUSK, "crops/corn/dried_corn_husk");
		forItem(this, ExtraDelightItems.UNSHUCKED_CORN, "crops/corn/unshucked_corn");
		forItem(this, ExtraDelightItems.CORN_MEAL, "cornmeal");

		forItem(this, ExtraDelightItems.CORN_CHOWDER, "corn_chowder");
		forItem(this, ExtraDelightItems.CREAM_CORN, "creamed_corn");
		forItem(this, ExtraDelightItems.CORN_FRITTERS, "corn_fritters");
		forItem(this, ExtraDelightItems.POPCORN, "popcorn");
		forItem(this, ExtraDelightItems.GRILLED_CORN_ON_COB, "grilled_corn_on_cob");
		forItem(this, ExtraDelightItems.COOKED_CORN, "cooked_corn");
		forItem(this, ExtraDelightItems.ROASTED_PUMPKIN_SEEDS, "roasted_pumpkin_seeds");
		forItem(this, ExtraDelightItems.TEA, "mint_tea");
		forItem(this, ExtraDelightItems.STEWED_APPLES, "stewed_apples");
		forItem(this, ExtraDelightItems.APPLE_FRITTERS, "apple_fritters");
		forItem(this, ExtraDelightItems.CARAMEL_SAUCE, "caramel_sauce");
		forItem(this, ExtraDelightItems.CARAMEL_CANDY, "caramel_candy");
		forItem(this, ExtraDelightItems.CANDY_APPLE, "candy_apple");
		forItem(this, ExtraDelightItems.CARAMEL_APPLE, "caramel_apple");
		forItem(this, ExtraDelightItems.CANDY_GOLDEN_APPLE, "candy_golden_apple");
		forItem(this, ExtraDelightItems.CARAMEL_GOLDEN_APPLE, "caramel_golden_apple");
		forItem(this, ExtraDelightItems.CARAMEL_POPCORN, "caramel_corn");
		forItem(this, ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM, "caramel_cheesecake");
		forItem(this, ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE, "caramel_cheesecake_slice");
		forItem(this, ExtraDelightItems.CARAMEL_CUSTARD, "caramel_custard");
		forItem(this, ExtraDelightItems.CARAMEL_POPSICLE, "caramel_popsicle");
		forItem(this, ExtraDelightItems.PUMPKIN_PIE_ITEM, "pumpkin_pie");
		forItem(this, ExtraDelightItems.PUMPKIN_PIE_SLICE, "pumpkin_pie_slice");

		forItem(this, ExtraDelightItems.CORNBREAD, "cornbread");
		getBuilder(ExtraDelightItems.CORNBREAD_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.CORN_PUDDING, "corn_pudding");
		getBuilder(ExtraDelightItems.CORN_PUDDING_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.PUMPKIN_ROLL, "pumpkin_roll");
		getBuilder(ExtraDelightItems.PUMPKIN_ROLL_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.APPLE_CRISP, "apple_crisp");
		getBuilder(ExtraDelightItems.APPLE_CRISP_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.STUFFING, "stuffing");
		getBuilder(ExtraDelightItems.STUFFING_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.POTATO_AU_GRATIN, "potato_au_gratin");
		getBuilder(ExtraDelightItems.POTATO_AU_GRATIN_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forBlockItem(this, ExtraDelightItems.FLOUR_SACK, "flour_sack");
		forBlockItem(this, ExtraDelightItems.CORNMEAL_SACK, "cornmeal_sack");
		forBlockItem(this, ExtraDelightItems.SUGAR_SACK, "sugar_sack");
		forBlockItem(this, ExtraDelightItems.CORN_CRATE, "corn_crate");
		forBlockItem(this, ExtraDelightItems.GOLDEN_CARROT_CRATE_BLOCK, "golden_carrot_crate");
		forBlockItem(this, ExtraDelightItems.CORN_HUSK_BUNDLE, "corn_husk_bundle");
		forBlockItem(this, ExtraDelightItems.DRIED_CORN_HUSK_BUNDLE, "dried_corn_husk_bundle");
		forBlockItem(this, ExtraDelightItems.CORN_COB_BUNDLE, "dried_corn_husk_bundle");

		// Holiday
		forBlockItem(this, ExtraDelightItems.STRIPPED_CINNAMON_LOG, "stripped_cinnamon_log");
		forBlockItem(this, ExtraDelightItems.CINNAMON_WOOD, "cinnamon_wood");
		forBlockItem(this, ExtraDelightItems.STRIPPED_CINNAMON_WOOD, "stripped_cinnamon_wood");
		forBlockItem(this, ExtraDelightItems.CINNAMON_LOG, "cinnamon_log");
		forBlockItem(this, ExtraDelightItems.CINNAMON_LEAVES, "cinnamon_leaves");
		forBlockItem(this, ExtraDelightItems.CINNAMON_PLANKS, "cinnamon_planks");
		forBlockItem(ExtraDelightItems.CINNAMON_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_fence_inventory"));
		forItem(this, ExtraDelightItems.CINNAMON_DOOR, "cinnamon_door");
		forBlockItem(this, ExtraDelightItems.CINNAMON_FENCE_GATE, "cinnamon_fence_gate");
		forBlockItem(this, ExtraDelightItems.CINNAMON_STAIRS, "cinnamon_stairs");
		forBlockItem(ExtraDelightItems.CINNAMON_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor_bottom"));
		forBlockItem(this, ExtraDelightItems.CINNAMON_CABINET, "cinnamon_cabinet");
		this.slab(ExtraDelightItems.CINNAMON_SLAB.getId().getPath(), modLoc("block/cinnamon_planks"),
				modLoc("block/cinnamon_planks"), modLoc("block/cinnamon_planks"));
		forBlockItemFlat(this, ExtraDelightItems.CINNAMON_SAPLING, "cinnamon_sapling");
		forItem(this, ExtraDelightItems.CINNAMON_BARK, "cinnamon_bark");
		forItem(this, ExtraDelightItems.CINNAMON_STICK, "cinnamon_stick");
		forItem(this, ExtraDelightItems.GROUND_CINNAMON, "ground_cinnamon");
		forItem(this, ExtraDelightItems.RAW_CINNAMON, "raw_cinnamon");
		this.buttonInventory(ExtraDelightItems.CINNAMON_BUTTON.getId().getPath(), modLoc("block/cinnamon_planks"));
		forBlockItem(this, ExtraDelightItems.CINNAMON_PRESSURE_PLATE, "cinnamon_pressure_plate");

		forItem(this, ExtraDelightItems.MILKSHAKE, "milkshake");
		forItem(this, ExtraDelightItems.APPLE_MILKSHAKE, "apple_milkshake");
		forItem(this, ExtraDelightItems.CHOCOLATE_MILKSHAKE, "chocolate_milkshake");
		forItem(this, ExtraDelightItems.GLOW_BERRY_MILKSHAKE, "glow_berry_milkshake");
		forItem(this, ExtraDelightItems.HONEY_MILKSHAKE, "honey_milkshake");
		forItem(this, ExtraDelightItems.PUMPKIN_MILKSHAKE, "pumpkin_milkshake");
		forItem(this, ExtraDelightItems.SWEET_BERRY_MILKSHAKE, "sweet_berry_milkshake");
		forItem(this, ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE, "cookie_dough_milkshake");
		forItem(this, ExtraDelightItems.MINT_CHIP_MILKSHAKE, "mint_chip_milkshake");

		forItem(this, ExtraDelightItems.CHOCOLATE_MILK, "chocolate_milk");

		forItem(this, ExtraDelightItems.ICE_CREAM, "ice_cream");
		forItem(this, ExtraDelightItems.APPLE_ICE_CREAM, "apple_ice_cream");
		forItem(this, ExtraDelightItems.CHOCOLATE_ICE_CREAM, "chocolate_ice_cream");
		forItem(this, ExtraDelightItems.GLOW_BERRY_ICE_CREAM, "glow_berry_ice_cream");
		forItem(this, ExtraDelightItems.HONEY_ICE_CREAM, "honey_ice_cream");
		forItem(this, ExtraDelightItems.PUMPKIN_ICE_CREAM, "pumpkin_ice_cream");
		forItem(this, ExtraDelightItems.SWEET_BERRY_ICE_CREAM, "sweet_berry_ice_cream");
		forItem(this, ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM, "cookie_dough_ice_cream");
		forItem(this, ExtraDelightItems.MINT_CHIP_ICE_CREAM, "mint_chip_ice_cream");

		forItem(this, ExtraDelightItems.APPLE_COOKIE_DOUGH, "apple_cookie_dough");
		forItem(this, ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH, "chocolate_chip_cookie_dough");
		forItem(this, ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH, "gingerbread_cookie_dough");
		forItem(this, ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH, "glow_berry_cookie_dough");
		forItem(this, ExtraDelightItems.HONEY_COOKIE_DOUGH, "honey_cookie_dough");
		forItem(this, ExtraDelightItems.PUMPKIN_COOKIE_DOUGH, "pumpkin_cookie_dough");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_DOUGH, "sugar_cookie_dough");
		forItem(this, ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH, "sweet_berry_cookie_dough");

		forItem(this, ExtraDelightItems.GINGERBREAD_ALEX, "gingerbread_alex");
		forItem(this, ExtraDelightItems.GINGERBREAD_COOKIE, "gingerbread_cookie");
		forItem(this, ExtraDelightItems.GINGERBREAD_CREEPER, "gingerbread_creeper");
		forItem(this, ExtraDelightItems.GINGERBREAD_PICKAXE, "gingerbread_pickaxe");
		forItem(this, ExtraDelightItems.GINGERBREAD_STEVE, "gingerbread_steve");
		forItem(this, ExtraDelightItems.GINGERBREAD_SWORD, "gingerbread_sword");
		forItem(this, ExtraDelightItems.GINGERBREAD_VILLAGER, "gingerbread_villager");
		forItem(this, ExtraDelightItems.GINGERBREAD_DIAMOND, "gingerbread_diamond");
		forItem(this, ExtraDelightItems.GINGERBREAD_EMERALD, "gingerbread_emerald");

		forItem(this, ExtraDelightItems.SUGAR_COOKIE_ALEX, "sugar_cookie_alex");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_CREEPER, "sugar_cookie_creeper");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_PICKAXE, "sugar_cookie_pickaxe");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_STEVE, "sugar_cookie_steve");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_SWORD, "sugar_cookie_sword");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_VILLAGER, "sugar_cookie_villager");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_DIAMOND, "sugar_cookie_diamond");
		forItem(this, ExtraDelightItems.SUGAR_COOKIE_EMERALD, "sugar_cookie_emerald");

		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_ALEX, "raw_gingerbread_alex");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_CREEPER, "raw_gingerbread_creeper");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_PICKAXE, "raw_gingerbread_pickaxe");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_STEVE, "raw_gingerbread_steve");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_SWORD, "raw_gingerbread_sword");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_VILLAGER, "raw_gingerbread_villager");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_DIAMOND, "raw_gingerbread_diamond");
		forItem(this, ExtraDelightItems.RAW_GINGERBREAD_EMERALD, "raw_gingerbread_emerald");

		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_ALEX, "raw_sugar_cookie_alex");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_CREEPER, "raw_sugar_cookie_creeper");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_PICKAXE, "raw_sugar_cookie_pickaxe");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_STEVE, "raw_sugar_cookie_steve");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_SWORD, "raw_sugar_cookie_sword");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_VILLAGER, "raw_sugar_cookie_villager");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_DIAMOND, "raw_sugar_cookie_diamond");
		forItem(this, ExtraDelightItems.RAW_SUGAR_COOKIE_EMERALD, "raw_sugar_cookie_emerald");

		forBlockItem(this, ExtraDelightItems.APPLE_COOKIE_BLOCK, "apple_cookie_block");
		forBlockItem(this, ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_BLOCK, "chocolate_chip_cookie_block");
		forBlockItem(this, ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK, "gingerbread_cookie_block");
		forBlockItem(this, ExtraDelightItems.GLOW_BERRY_COOKIE_BLOCK, "glow_berry_cookie_block");
		forBlockItem(this, ExtraDelightItems.HONEY_COOKIE_BLOCK, "honey_cookie_block");
		forBlockItem(this, ExtraDelightItems.PUMPKIN_COOKIE_BLOCK, "pumpkin_cookie_block");
		forBlockItem(this, ExtraDelightItems.SUGAR_COOKIE_BLOCK, "sugar_cookie_block");
		forBlockItem(this, ExtraDelightItems.SWEET_BERRY_COOKIE_BLOCK, "sweet_berry_cookie_block");

		forItem(this, ExtraDelightItems.GINGER, "crops/ginger/ginger");
		forItem(this, ExtraDelightItems.GINGER_CUTTING, "crops/ginger/ginger_cutting");
		forItem(this, ExtraDelightItems.PEELED_GINGER, "crops/ginger/peeled_ginger");
		forItem(this, ExtraDelightItems.SLICED_GINGER, "crops/ginger/sliced_ginger");
		forItem(this, ExtraDelightItems.GRATED_GINGER, "grated_ginger");
		forItem(this, ExtraDelightItems.FROSTING_WHITE, "frosting_white");
		forItem(this, ExtraDelightItems.FROSTING_ORANGE, "frosting_orange");
		forItem(this, ExtraDelightItems.FROSTING_MAGENTA, "frosting_magenta");
		forItem(this, ExtraDelightItems.FROSTING_LIGHT_BLUE, "frosting_light_blue");
		forItem(this, ExtraDelightItems.FROSTING_YELLOW, "frosting_yellow");
		forItem(this, ExtraDelightItems.FROSTING_LIME, "frosting_lime");
		forItem(this, ExtraDelightItems.FROSTING_PINK, "frosting_pink");
		forItem(this, ExtraDelightItems.FROSTING_GRAY, "frosting_gray");
		forItem(this, ExtraDelightItems.FROSTING_LIGHT_GRAY, "frosting_light_gray");
		forItem(this, ExtraDelightItems.FROSTING_CYAN, "frosting_cyan");
		forItem(this, ExtraDelightItems.FROSTING_PURPLE, "frosting_purple");
		forItem(this, ExtraDelightItems.FROSTING_BLUE, "frosting_blue");
		forItem(this, ExtraDelightItems.FROSTING_BROWN, "frosting_brown");
		forItem(this, ExtraDelightItems.FROSTING_GREEN, "frosting_green");
		forItem(this, ExtraDelightItems.FROSTING_RED, "frosting_red");
		forItem(this, ExtraDelightItems.FROSTING_BLACK, "frosting_black");

		forItem(this, ExtraDelightItems.CANDY_WHITE, "candy_white");
		forItem(this, ExtraDelightItems.CANDY_ORANGE, "candy_orange");
		forItem(this, ExtraDelightItems.CANDY_MAGENTA, "candy_magenta");
		forItem(this, ExtraDelightItems.CANDY_LIGHT_BLUE, "candy_light_blue");
		forItem(this, ExtraDelightItems.CANDY_YELLOW, "candy_yellow");
		forItem(this, ExtraDelightItems.CANDY_LIME, "candy_lime");
		forItem(this, ExtraDelightItems.CANDY_PINK, "candy_pink");
		forItem(this, ExtraDelightItems.CANDY_GRAY, "candy_gray");
		forItem(this, ExtraDelightItems.CANDY_LIGHT_GRAY, "candy_light_gray");
		forItem(this, ExtraDelightItems.CANDY_CYAN, "candy_cyan");
		forItem(this, ExtraDelightItems.CANDY_PURPLE, "candy_purple");
		forItem(this, ExtraDelightItems.CANDY_BLUE, "candy_blue");
		forItem(this, ExtraDelightItems.CANDY_BROWN, "candy_brown");
		forItem(this, ExtraDelightItems.CANDY_GREEN, "candy_green");
		forItem(this, ExtraDelightItems.CANDY_RED, "candy_red");
		forItem(this, ExtraDelightItems.CANDY_BLACK, "candy_black");

		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_WHITE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_ORANGE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_MAGENTA.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_LIGHT_BLUE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_YELLOW.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_LIME.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_PINK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_GRAY.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_LIGHT_GRAY.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_CYAN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_PURPLE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_BLUE.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_BROWN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_GREEN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_RED.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.GINGERBREAD_BLOCK_BLACK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forBlockItem(this, ExtraDelightItems.CANDY_BOWL_ITEM, "candy_bowl");
		forItem(this, ExtraDelightItems.MINT, "mint");

		forItem(this, ExtraDelightItems.MINT_CANDY_GREEN, "mint_candy_green");
		forItem(this, ExtraDelightItems.MINT_CANDY_RED, "mint_candy_red");
		forItem(this, ExtraDelightItems.MINT_CANDY_BLUE, "mint_candy_blue");
		forItem(this, ExtraDelightItems.CANDY_CANE_GREEN, "candy_cane_green");
		forItem(this, ExtraDelightItems.CANDY_CANE_RED, "candy_cane_red");
		forItem(this, ExtraDelightItems.CANDY_CANE_BLUE, "candy_cane_blue");
		forBlockItem(this, ExtraDelightItems.CANDY_CANE_GREEN_BLOCK, "candy_cane_green_block");
		forBlockItem(this, ExtraDelightItems.CANDY_CANE_RED_BLOCK, "candy_cane_red_block");
		forBlockItem(this, ExtraDelightItems.CANDY_CANE_BLUE_BLOCK, "candy_cane_blue_block");

		forItem(this, ExtraDelightItems.GINGER_BEER, "ginger_beer");
//		forItem(this, ExtraDelightItems.GINGER_TEA, "ginger_tea");
		forItem(this, ExtraDelightItems.HORCHATA, "horchata");
		forItem(this, ExtraDelightItems.EGGNOG, "eggnog");

		forItem(this, ExtraDelightItems.FRENCH_TOAST, "french_toast");
		forItem(this, ExtraDelightItems.CONGEE, "congee");
		forItem(this, ExtraDelightItems.LUGAW, "lugaw");
		forItem(this, ExtraDelightItems.RICE_PUDDING, "rice_pudding");
		forItem(this, ExtraDelightItems.MUFFIN_APPLE, "apple_muffin");
		forItem(this, ExtraDelightItems.MUFFIN_CINNAMON, "cinnamon_muffin");
		forItem(this, ExtraDelightItems.MUFFIN_GINGER, "ginger_muffin");
		forItem(this, ExtraDelightItems.MUFFIN_SWEET_BERRY, "sweet_berry_muffin");
		forItem(this, ExtraDelightItems.ROLL, "roll");
		forItem(this, ExtraDelightItems.DRIED_FRUIT, "dried_fruit");
		forItem(this, ExtraDelightItems.FRUIT_BREAD, "fruit_bread");
		forItem(this, ExtraDelightItems.PICKLED_GINGER, "pickled_ginger");
		forItem(this, ExtraDelightItems.CANDIED_GINGER, "ginger_candy");
		forItem(this, ExtraDelightItems.CINNAMON_POPSICLE, "cinnamon_popsicle");
//		forItem(this, ExtraDelightItems.MINT_TEA, "mint_tea");
		forItem(this, ExtraDelightItems.BEET_MINT_SALAD, "beet_mint_salad");
		forItem(this, ExtraDelightItems.MINT_JELLY, "mint_jelly");
		forItem(this, ExtraDelightItems.CRACKERS, "crackers");
		forItem(this, ExtraDelightItems.CROQUE_MADAME, "croque_madame");
		forItem(this, ExtraDelightItems.CROQUE_MONSIEUR, "croque_monsieur");

		forItem(this, ExtraDelightItems.CINNAMON_ROLL, "cinnamon_roll");
		forItem(this, ExtraDelightItems.MONKEY_BREAD, "monkey_bread");
		forItem(this, ExtraDelightItems.COFFEE_CAKE_SLICE, "coffee_cake_slice");
		forItem(this, ExtraDelightItems.MINT_LAMB, "mint_lamb");
		forItem(this, ExtraDelightItems.CHARCUTERIE_BOARD, "charcuterie_board");
		forItem(this, ExtraDelightItems.CHRISTMAS_PUDDING, "christmas_pudding");
		forItem(this, ExtraDelightItems.MILK_TART_SLICE, "milk_tart_slice");
		forItem(this, ExtraDelightItems.PUNCH, "punch");

		getBuilder(ExtraDelightItems.CINNAMON_ROLLS_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.MONKEY_BREAD_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.COFFEE_CAKE_FEAST, "coffee_cake");
		getBuilder(ExtraDelightItems.MINT_LAMB_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.CHARCUTERIE_BOARD_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.CHRISTMAS_PUDDING_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.MILK_TART_FEAST, "milk_tart");
		getBuilder(ExtraDelightItems.PUNCH_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItemFlat(this, ExtraDelightItems.WILD_GINGER, "crops/ginger/wild_ginger");

		forBlockItem(this, ExtraDelightItems.CHEESE_STAIRS_BLOCK_ITEM, "cheese_stairs");
		forBlockItem(this, ExtraDelightItems.CHEESE_SLAB_BLOCK_ITEM, "cheese_slab");
		forBlockItem(this, ExtraDelightItems.BUTTER_STAIRS_BLOCK_ITEM, "butter_stairs");
		forBlockItem(this, ExtraDelightItems.BUTTER_SLAB_BLOCK_ITEM, "butter_slab");

		forBlockItem(this, ExtraDelightItems.BREADCRUMB_SACK, "breadcrumb_sack");
		forBlockItem(this, ExtraDelightItems.EGG_CRATE, "egg_crate");
		forBlockItem(this, ExtraDelightItems.RAW_CINNAMON_BLOCK, "raw_cinnamon_block");
		forBlockItem(this, ExtraDelightItems.CINNAMON_STICK_BLOCK, "cinnamon_stick_block");
		forBlockItem(this, ExtraDelightItems.GROUND_CINNAMON_BLOCK_ITEM, "ground_cinnamon_block");
		forBlockItem(this, ExtraDelightItems.GINGER_CRATE, "ginger_crate");
		forBlockItem(this, ExtraDelightItems.MINT_SACK, "mint_sack");
		forBlockItem(this, ExtraDelightItems.APPLE_CRATE, "apple_crate");
		forBlockItem(this, ExtraDelightItems.GOLDEN_APPLE_CRATE, "golden_apple_crate");
		forBlockItem(this, ExtraDelightItems.RED_MUSHROOM_CRATE, "red_mushroom_crate");
		forBlockItem(this, ExtraDelightItems.BROWN_MUSHROOM_CRATE, "brown_mushroom_crate");
		forBlockItem(this, ExtraDelightItems.SWEET_BERRY_CRATE, "sweet_berry_crate");
		forBlockItem(this, ExtraDelightItems.GLOW_BERRY_CRATE, "glow_berry_crate");
		forBlockItem(this, ExtraDelightItems.CORN_SILK_SACK, "corn_silk_sack");
		forBlockItem(this, ExtraDelightItems.TAP, "tap");

		forItem(this, ExtraDelightItems.COFFEE_BEANS, "crops/coffee/coffee_beans");
		forItem(this, ExtraDelightItems.GREEN_COFFEE, "crops/coffee/green_coffee");
		forItem(this, ExtraDelightItems.COFFEE_CHERRIES, "crops/coffee/coffee_cherries");

		forBlockItem(ExtraDelightItems.KEG, modLoc("block/keg_vertical"));

		forBlockItem(this, ExtraDelightItems.STRIPPED_FRUIT_LOG, "stripped_fruit_log");
		forBlockItem(this, ExtraDelightItems.FRUIT_LOG, "fruit_log");
		forBlockItem(this, ExtraDelightItems.FRUIT_WOOD, "fruit_wood");
		forBlockItem(this, ExtraDelightItems.STRIPPED_FRUIT_WOOD, "stripped_fruit_wood");
		forBlockItem(this, ExtraDelightItems.FRUIT_PLANKS, "fruit_planks");
		forBlockItem(ExtraDelightItems.FRUIT_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_fence_inventory"));
		forItem(this, ExtraDelightItems.FRUIT_DOOR, "fruit_door");
		forBlockItem(this, ExtraDelightItems.FRUIT_FENCE_GATE, "fruit_fence_gate");
		forBlockItem(this, ExtraDelightItems.FRUIT_STAIRS, "fruit_stairs");
		forBlockItem(ExtraDelightItems.FRUIT_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_trapdoor_bottom"));
		forBlockItem(this, ExtraDelightItems.FRUIT_CABINET, "fruit_cabinet");
		this.slab(ExtraDelightItems.FRUIT_SLAB.getId().getPath(), modLoc("block/fruit_planks"),
				modLoc("block/fruit_planks"), modLoc("block/fruit_planks"));
		this.buttonInventory(ExtraDelightItems.FRUIT_BUTTON.getId().getPath(), modLoc("block/fruit_planks"));
		forBlockItem(this, ExtraDelightItems.FRUIT_PRESSURE_PLATE, "fruit_pressure_plate");

		forItem(this, ExtraDelightItems.CHILI_SEEDS, "crops/chili/chili_seeds");
		forItem(this, ExtraDelightItems.CHILI, "crops/chili/chili_pepper");

		forItem(this, ExtraDelightItems.APPLE_CIDER_FLUID_BUCKET, "apple_cider_bucket");
		forItem(this, ExtraDelightItems.BBQ_FLUID_BUCKET, "bbq_bucket");
		forItem(this, ExtraDelightItems.BROTH_FLUID_BUCKET, "broth_bucket");
		forItem(this, ExtraDelightItems.CACTUS_JUICE_FLUID_BUCKET, "cactus_juice_bucket");
		forItem(this, ExtraDelightItems.CARAMEL_SAUCE_FLUID_BUCKET, "caramel_sauce_bucket");
		forItem(this, ExtraDelightItems.EGG_MIX_FLUID_BUCKET, "egg_mix_bucket");
		forItem(this, ExtraDelightItems.GLOW_BERRY_JUICE_FLUID_BUCKET, "glow_berry_juice_bucket");
		forItem(this, ExtraDelightItems.GLOW_JAM_FLUID_BUCKET, "glow_jam_bucket");
		forItem(this, ExtraDelightItems.GOLDEN_JAM_FLUID_BUCKET, "golden_jam_bucket");
		forItem(this, ExtraDelightItems.GRAVY_FLUID_BUCKET, "gravy_bucket");
		forItem(this, ExtraDelightItems.HOT_COCOA_FLUID_BUCKET, "hot_cocoa_bucket");
		forItem(this, ExtraDelightItems.JAM_FLUID_BUCKET, "jam_bucket");
		forItem(this, ExtraDelightItems.KETCHUP_FLUID_BUCKET, "ketchup_bucket");
		forItem(this, ExtraDelightItems.MAYO_FLUID_BUCKET, "mayo_bucket");
		forItem(this, ExtraDelightItems.MELON_JUICE_FLUID_BUCKET, "melon_juice_bucket");
		forItem(this, ExtraDelightItems.MILKSHAKE_FLUID_BUCKET, "milkshake_bucket");
		forItem(this, ExtraDelightItems.OIL_FLUID_BUCKET, "oil_bucket");
		forItem(this, ExtraDelightItems.SWEET_BERRY_JUICE_FLUID_BUCKET, "sweet_berry_juice_bucket");
		forItem(this, ExtraDelightItems.TEA_FLUID_BUCKET, "tea_bucket");
		forItem(this, ExtraDelightItems.TOMATO_JUICE_FLUID_BUCKET, "tomato_juice_bucket");
		forItem(this, ExtraDelightItems.VINEGAR_FLUID_BUCKET, "vinegar_bucket");
		forItem(this, ExtraDelightItems.WHIPPED_CREAM_FLUID_BUCKET, "whipped_cream_bucket");

		forItem(this, ExtraDelightItems.FUNNEL, "funnel");

		getBuilder(ExtraDelightItems.MELTING_POT.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/melting_pot")));

		this.forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/white_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.ORANGE_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/orange_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.MAGENTA_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/magenta_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.LIGHT_BLUE_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/light_blue_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.YELLOW_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/yellow_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.LIME_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/lime_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.PINK_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pink_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.GRAY_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/gray_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.LIGHT_GRAY_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/light_gray_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.CYAN_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cyan_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.BLUE_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/blue_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.BROWN_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/brown_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.GREEN_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/green_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.RED_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/red_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.BLACK_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/black_chocolate_box"));
		this.forBlockItem(ExtraDelightItems.PURPLE_CHOCOLATE_BOX,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/purple_chocolate_box"));

		getBuilder(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItem(ExtraDelightItems.BLOOD_CHOCOLATE_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/blood_chocolate_fence_inventory"));
		forBlockItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_FENCE_GATE, "blood_chocolate_fence");
		forBlockItem(ExtraDelightItems.BLOOD_CHOCOLATE_STAIRS,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/blood_chocolate_stairs"));
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DOOR, "blood_chocolate_door");
		forBlockItem(ExtraDelightItems.BLOOD_CHOCOLATE_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/blood_chocolate_trapdoor_bottom"));
		forBlockItem(ExtraDelightItems.BLOOD_CHOCOLATE_SLAB, modLoc("block/blood_chocolate_slab"));
		forBlockItem(ExtraDelightItems.BLOOD_CHOCOLATE_PILLAR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/blood_chocolate_pillar"));

		getBuilder(ExtraDelightItems.DARK_CHOCOLATE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItem(ExtraDelightItems.DARK_CHOCOLATE_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/dark_chocolate_fence_inventory"));
		forBlockItem(this, ExtraDelightItems.DARK_CHOCOLATE_FENCE_GATE, "dark_chocolate_fence");
		forBlockItem(ExtraDelightItems.DARK_CHOCOLATE_STAIRS,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/dark_chocolate_stairs"));
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DOOR, "dark_chocolate_door");
		forBlockItem(ExtraDelightItems.DARK_CHOCOLATE_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/dark_chocolate_trapdoor_bottom"));
		forBlockItem(ExtraDelightItems.DARK_CHOCOLATE_SLAB, modLoc("block/dark_chocolate_slab"));
		forBlockItem(ExtraDelightItems.DARK_CHOCOLATE_PILLAR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/dark_chocolate_pillar"));

		getBuilder(ExtraDelightItems.MILK_CHOCOLATE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItem(ExtraDelightItems.MILK_CHOCOLATE_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/milk_chocolate_fence_inventory"));
		forBlockItem(this, ExtraDelightItems.MILK_CHOCOLATE_FENCE_GATE, "milk_chocolate_fence_gate");
		forBlockItem(ExtraDelightItems.MILK_CHOCOLATE_STAIRS,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/milk_chocolate_stairs"));
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DOOR, "milk_chocolate_door");
		forBlockItem(ExtraDelightItems.MILK_CHOCOLATE_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/milk_chocolate_trapdoor_bottom"));
		forBlockItem(ExtraDelightItems.MILK_CHOCOLATE_SLAB, modLoc("block/milk_chocolate_slab"));
		forBlockItem(ExtraDelightItems.MILK_CHOCOLATE_PILLAR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/milk_chocolate_pillar"));

		getBuilder(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_FENCE,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/white_chocolate_fence_inventory"));
		forBlockItem(this, ExtraDelightItems.WHITE_CHOCOLATE_FENCE_GATE, "white_chocolate_fence_gate");
		forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_STAIRS,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/white_chocolate_stairs"));
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DOOR, "white_chocolate_door");
		forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_TRAPDOOR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/white_chocolate_trapdoor_bottom"));
		forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_SLAB, modLoc("block/white_chocolate_slab"));
		forBlockItem(ExtraDelightItems.WHITE_CHOCOLATE_PILLAR,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/white_chocolate_pillar"));

		forItem(this, ExtraDelightItems.ROASTED_COCOA_BEANS, "roasted_cocoa_beans");
		forItem(this, ExtraDelightItems.COCOA_SOLIDS, "cocoa_solids");

		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_BAR, "white_chocolate_bar");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_BAR, "milk_chocolate_bar");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_BAR, "dark_chocolate_bar");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_BAR, "blood_chocolate_bar");

		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_CHIPS, "white_chocolate_chips");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_CHIPS, "milk_chocolate_chips");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_CHIPS, "dark_chocolate_chips");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_CHIPS, "blood_chocolate_chips");

		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_FILLED_BAR, "white_chocolate_filled_bar");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_FILLED_BAR, "milk_chocolate_filled_bar");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_FILLED_BAR, "dark_chocolate_filled_bar");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_FILLED_BAR, "blood_chocolate_filled_bar");

		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_TRUFFLE, "white_chocolate_truffle");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_TRUFFLE, "milk_chocolate_truffle");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_TRUFFLE, "dark_chocolate_truffle");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_TRUFFLE, "blood_chocolate_truffle");

		forItem(this, ExtraDelightItems.MARSHMALLOW, "marshmallow");
		forItem(this, ExtraDelightItems.CHILI_POWDER, "chili_powder");
		forItem(this, ExtraDelightItems.PEANUT_BUTTER_CUP, "peanut_butter_cup");
		forItem(this, ExtraDelightItems.MALLOW_CUP, "mallow_cup");
		forItem(this, ExtraDelightItems.XOCOLATL, "xocolatl");
		forItem(this, ExtraDelightItems.GOURMET_HOT_CHOCOLATE, "gourmet_hot_chocolate");
		forItem(this, ExtraDelightItems.LAVA_CAKE, "lava_cake");
		forItem(this, ExtraDelightItems.COFFEE_JELLY, "coffee_jelly");
		forItem(this, ExtraDelightItems.TOFFEE, "toffee");
		forItem(this, ExtraDelightItems.GRAHAM_CRACKER, "graham_cracker");
		forItem(this, ExtraDelightItems.SMORE, "smore");
		forItem(this, ExtraDelightItems.PEPPERMINT_BARK, "peppermint_bark");
		forItem(this, ExtraDelightItems.DIRT_CAKE, "dirt_cake");
		forItem(this, ExtraDelightItems.EASTER_EGG, "easter_egg");
		forItem(this, ExtraDelightItems.TRAIL_MIX, "trail_mix");
		forItem(this, ExtraDelightItems.NOUGAT, "nougat");
		forItem(this, ExtraDelightItems.GUMMIES, "gummies");
		forItem(this, ExtraDelightItems.PEANUT_BRITTLE, "peanut_brittle");
		forItem(this, ExtraDelightItems.BUTTERSCOTCH, "butterscotch");
		forItem(this, ExtraDelightItems.FLUFFER_NUTTER, "fluffer_nutter");
		forItem(this, ExtraDelightItems.PEANUT_BUTTER_JELLY, "peanut_butter_jelly");
		forItem(this, ExtraDelightItems.COFFEE, "coffee");

		getBuilder(ExtraDelightItems.BROWNIES_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BROWNIE, "brownie");
		getBuilder(ExtraDelightItems.BLONDIES_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BLONDIE, "blondie");

		forItem(this, ExtraDelightItems.CHOCOLATE_CAKE_BLOCK, "chocolate_cake");
		forItem(this, ExtraDelightItems.CHOCOLATE_CAKE, "chocolate_cake_slice");
		getBuilder(ExtraDelightItems.FUDGE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.FUDGE_SLICE, "fudge");
		getBuilder(ExtraDelightItems.STICKY_TOFFEE_PUDDING_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.STICKY_TOFFEE_PUDDING_SLICE, "sticky_toffee_pudding");
		forItem(this, ExtraDelightItems.CRISP_RICE, "crisp_rice");
		forItem(this, ExtraDelightItems.CRISP_RICE_CEREAL, "crisp_rice_cereal");
		getBuilder(ExtraDelightItems.CRISP_RICE_TREATS_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.CRISP_RICE_TREAT, "crisp_rice_treat");
		getBuilder(ExtraDelightItems.SCOTCHAROO_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.SCOTCHAROO, "scotcharoo");
		getBuilder(ExtraDelightItems.BLACK_FOREST_TRIFLE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BLACK_FOREST_TRIFLE, "black_forest_trifle");
		getBuilder(ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		forItem(this, ExtraDelightItems.CORN_FLAKES, "corn_flakes");
		forItem(this, ExtraDelightItems.CORN_FLAKES_CEREAL, "corn_flake_cereal");

		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE, "blood_chocolate_apple_slices");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_BACON, "blood_chocolate_bacon");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN, "blood_chocolate_coffee_beans");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY, "blood_chocolate_glow_berries");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER, "blood_chocolate_graham_cracker");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW, "blood_chocolate_marshmallow");
		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY, "blood_chocolate_sweet_berries");

		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_APPLE_SLICE, "milk_chocolate_apple_slices");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_BACON, "milk_chocolate_bacon");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_COFFEE_BEAN, "milk_chocolate_coffee_beans");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_GLOW_BERRY, "milk_chocolate_glow_berries");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_GRAHAM_CRACKER, "milk_chocolate_graham_cracker");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_MARSHMALLOW, "milk_chocolate_marshmallow");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_DIPPED_SWEET_BERRY, "milk_chocolate_sweet_berries");

		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_APPLE_SLICE, "dark_chocolate_apple_slices");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_BACON, "dark_chocolate_bacon");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_COFFEE_BEAN, "dark_chocolate_coffee_beans");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_GLOW_BERRY, "dark_chocolate_glow_berries");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_GRAHAM_CRACKER, "dark_chocolate_graham_cracker");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_MARSHMALLOW, "dark_chocolate_marshmallow");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_DIPPED_SWEET_BERRY, "dark_chocolate_sweet_berries");

		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_APPLE_SLICE, "white_chocolate_apple_slices");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_BACON, "white_chocolate_bacon");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_COFFEE_BEAN, "white_chocolate_coffee_beans");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_GLOW_BERRY, "white_chocolate_glow_berries");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_GRAHAM_CRACKER, "white_chocolate_graham_cracker");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_MARSHMALLOW, "white_chocolate_marshmallow");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_SWEET_BERRY, "white_chocolate_sweet_berries");

		forItem(this, ExtraDelightItems.DRIED_CHILI, "crops/chili/dried_chili");
		forItem(this, ExtraDelightItems.PEANUTS_IN_SHELL, "crops/peanuts/peanuts_in_shell");
		forItem(this, ExtraDelightItems.PEANUTS, "crops/peanuts/peanuts");
		forItem(this, ExtraDelightItems.ROASTED_PEANUTS, "crops/peanuts/roasted_peanuts");

		forItem(this, ExtraDelightItems.HAZELNUTS_IN_SHELL, "crops/fruit/hazelnut/hazelnut_in_shell");
		forItem(this, ExtraDelightItems.HAZELNUTS, "crops/fruit/hazelnut/hazelnut");
		forItem(this, ExtraDelightItems.ROASTED_HAZELNUTS, "crops/fruit/hazelnut/roasted_hazelnut");

		forItem(this, ExtraDelightItems.MALLOW_ROOT, "crops/mallow/mallow_root");
		forBlockItemFlat(this, ExtraDelightItems.WILD_PEANUT_BLOCK, "crops/peanut/wild_peanut");
		forBlockItemFlat(this, ExtraDelightItems.WILD_CHILI_BLOCK, "crops/chili/wild_chili");
		forBlockItemFlat(this, ExtraDelightItems.WILD_MALLOW_ROOT_BLOCK, "crops/marshmallow/wild_marshmallow");

		forBlockItem(ExtraDelightItems.HAZELNUT_LEAVES, modLoc("block/crops/fruit/hazelnut/hazelnut_leaves_stage0"));

		forBlockItem(this, ExtraDelightItems.CHILLER, "chiller");
		this.getBuilder(ExtraDelightItems.BAR_MOLD.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItemFlat(this, ExtraDelightItems.HAZELNUT_SAPLING, "crops/fruit/hazelnut/hazelnut_sapling");

		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_FLUID_BUCKET, "blood_chocolate_syrup_bucket");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_SYRUP_FLUID_BUCKET, "dark_chocolate_syrup_bucket");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_FLUID_BUCKET, "white_chocolate_syrup_bucket");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_SYRUP_FLUID_BUCKET, "milk_chocolate_syrup_bucket");
		forItem(this, ExtraDelightItems.COFFEE_FLUID_BUCKET, "coffee_bucket");
		forItem(this, ExtraDelightItems.NUT_BUTTER_FLUID_BUCKET, "peanut_butter_bucket");
		forItem(this, ExtraDelightItems.MARSHMALLOW_FLUFF_FLUID_BUCKET, "marshmallow_fluff_bucket");
		forItem(this, ExtraDelightItems.COCOA_NUT_BUTTER_SPREAD_FLUID_BUCKET, "hazelnut_spread_bucket");
		forItem(this, ExtraDelightItems.COCOA_BUTTER_FLUID_BUCKET, "cocoa_butter_bucket");

		forItem(this, ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE, "blood_chocolate_syrup_bottle");
		forItem(this, ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE, "dark_chocolate_syrup_bottle");
		forItem(this, ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_BOTTLE, "white_chocolate_syrup_bottle");
		forItem(this, ExtraDelightItems.MILK_CHOCOLATE_SYRUP_BOTTLE, "milk_chocolate_syrup_bottle");
		forItem(this, ExtraDelightItems.PEANUT_BUTTER_BOTTLE, "peanut_butter_bottle");
		forItem(this, ExtraDelightItems.MARSHMALLOW_FLUFF_BOTTLE, "marshmallow_fluff_bottle");
		forItem(this, ExtraDelightItems.HAZELNUT_SPREAD_BOTTLE, "hazelnut_spread_bottle");
		forItem(this, ExtraDelightItems.COCOA_BUTTER_BOTTLE, "cocoa_butter_bottle");

		forItem(this, ExtraDelightItems.ICE_CREAM_SUNDAE, "ice_cream_sundae");
		forBlockItem(this, ExtraDelightItems.MARSHMALLOW_BLOCK, "marshmallow_block");
		forItem(this, ExtraDelightItems.MALLOW_POWDER, "mallow_root_powder");
		forItem(this, ExtraDelightItems.GROUND_COFFEE, "ground_coffee");

		forBlockItem(ExtraDelightItems.APPLE_LEAVES, modLoc("block/crops/fruit/apple/apple_leaves_stage0"));
		forBlockItemFlat(this, ExtraDelightItems.APPLE_SAPLING, "crops/fruit/apple/apple_sapling");
		forItem(this, ExtraDelightItems.ROMBOSSE, "rombosse");
		forItem(this, ExtraDelightItems.APPLE_SLAW, "apple_slaw");
		getBuilder(ExtraDelightItems.PORK_AND_APPLES_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.PORK_AND_APPLES, "pork_apple_roast");
		forItem(this, ExtraDelightItems.APPLE_CHIPS, "apple_chips");
		getBuilder(ExtraDelightItems.STUFFED_APPLES_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.STUFFED_APPLE, "stuffed_apple");
		forItem(this, ExtraDelightItems.STUFFED_APPLE_ICE_CREAM, "stuffed_apple_ice_cream");
		forItem(this, ExtraDelightItems.MULLIGATAWNY_SOUP, "mulligatawny_soup");
		getBuilder(ExtraDelightItems.TARTE_TATIN_IN_PAN.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/tarte_tatin")));
		getBuilder(ExtraDelightItems.TARTE_TATIN.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.TARTE_TATIN_SLICE, "tarte_tatin_slice");
		forItem(this, ExtraDelightItems.AEBLEFLAESK, "aebleflaesk");
		forItem(this, ExtraDelightItems.CANDY_BAR_SALAD, "candy_bar_salad");

		forBlockItem(this, ExtraDelightItems.HANGING_ONION, "hanging_onion");
		forBlockItem(this, ExtraDelightItems.HANGING_MINT, "hanging_mint");
		forBlockItem(this, ExtraDelightItems.HANGING_HAM, "hanging_ham");
		forBlockItem(this, ExtraDelightItems.HANGING_CHILI, "hanging_chili");
		forBlockItem(this, ExtraDelightItems.HANGING_DRIED_CHILI, "hanging_dried_chili");
		forBlockItem(this, ExtraDelightItems.HANGING_CORN, "hanging_corn");

		forBlockItem(this, ExtraDelightItems.CHILI_CRATE, "chili_crate");
		forBlockItem(this, ExtraDelightItems.APPLE_CRATE, "apple_crate");
		forBlockItem(this, ExtraDelightItems.BROWN_MUSHROOM_CRATE, "brown_mushroom_crate");
		forBlockItem(this, ExtraDelightItems.COFFEE_CHERRY_CRATE, "coffee_cherry_crate");
		forBlockItem(this, ExtraDelightItems.CORN_CRATE, "corn_crate");
		forBlockItem(this, ExtraDelightItems.EGG_CRATE, "egg_crate");
		forBlockItem(this, ExtraDelightItems.GINGER_CRATE, "ginger_crate");
		forBlockItem(this, ExtraDelightItems.GLOW_BERRY_CRATE, "glow_berry_crate");
		forBlockItem(this, ExtraDelightItems.GOLDEN_APPLE_CRATE, "golden_apple_crate");
		forBlockItem(this, ExtraDelightItems.GOLDEN_CARROT_CRATE_BLOCK, "golden_carrot_crate");
		forBlockItem(this, ExtraDelightItems.MALLOW_ROOT_CRATE, "mallow_root_crate");
		forBlockItem(this, ExtraDelightItems.RED_MUSHROOM_CRATE, "red_mushroom_crate");
		forBlockItem(this, ExtraDelightItems.SWEET_BERRY_CRATE, "sweet_berry_crate");

		forBlockItem(this, ExtraDelightItems.BREADCRUMB_SACK, "breadcrumb_sack");
		forBlockItem(this, ExtraDelightItems.CHILI_POWDER_SACK, "chili_powder_sack");
		forBlockItem(this, ExtraDelightItems.COCOA_BEAN_SACK, "cocoa_beans_sack");
		forBlockItem(this, ExtraDelightItems.COCOA_POWDER_SACK, "cocoa_powder_sack");
		forBlockItem(this, ExtraDelightItems.COCOA_SOLIDS_SACK, "cocoa_solids_sack");
		forBlockItem(this, ExtraDelightItems.COFFEE_BEAN_SACK, "coffee_bean_sack");
		forBlockItem(this, ExtraDelightItems.CORN_SILK_SACK, "corn_silk_sack");
		forBlockItem(this, ExtraDelightItems.CORN_SACK, "corn_sack");
		forBlockItem(this, ExtraDelightItems.CORNMEAL_SACK, "cornmeal_sack");
		forBlockItem(this, ExtraDelightItems.FLOUR_SACK, "flour_sack");
		forBlockItem(this, ExtraDelightItems.GREEN_COFFEE_BEAN_SACK, "green_coffee_sack");
		forBlockItem(this, ExtraDelightItems.GROUND_CINNAMON_BLOCK_ITEM, "cinnamon_sack");
		forBlockItem(this, ExtraDelightItems.GROUND_COFFEE_SACK, "ground_coffee_sack");
		forBlockItem(this, ExtraDelightItems.HAZELNUT_IN_SHELL_SACK, "shell_hazelnut_sack");
		forBlockItem(this, ExtraDelightItems.HAZELNUT_SACK, "hazelnut_sack");
		forBlockItem(this, ExtraDelightItems.MALLOW_POWDER_SACK, "mallow_powder_sack");
		forBlockItem(this, ExtraDelightItems.MINT_SACK, "mint_sack");
		forBlockItem(this, ExtraDelightItems.PEANUT_IN_SHELL_SACK, "peanut_in_shell_sack");
		forBlockItem(this, ExtraDelightItems.PEANUT_SACK, "peanut_sack");
		forBlockItem(this, ExtraDelightItems.ROASTED_COCOA_BEAN_SACK, "roasted_cocoa_beans_sack");
		forBlockItem(this, ExtraDelightItems.ROASTED_HAZELNUT_SACK, "roasted_hazelnut_sack");
		forBlockItem(this, ExtraDelightItems.ROASTED_PEANUT_SACK, "roasted_peanut_sack");
		forBlockItem(this, ExtraDelightItems.SUGAR_SACK, "sugar_sack");

		forItem(this, ExtraDelightItems.SLICED_CHILI, "crops/chili/sliced_chili_pepper");
		forItem(this, ExtraDelightItems.JALAPENO_STUFFED_POTATO, "jalapeno_stuffed_potato");
		forItem(this, ExtraDelightItems.JALAPENO_POPPER, "jalapeno_popper");
		forItem(this, ExtraDelightItems.CHILI_CHEESE_CORNBREAD_MUFFIN, "chili_cheese_cornbread_muffin");
		forItem(this, ExtraDelightItems.CHILI_CON_CARNE, "chili_con_carne");
		forItem(this, ExtraDelightItems.WHITE_CHILI, "white_chili");
		forItem(this, ExtraDelightItems.NUT_BUTTER_COOKIE, "nut_butter_cookie");
		forItem(this, ExtraDelightItems.NUT_BUTTER_COOKIE_DOUGH, "nut_butter_cookie_dough");
		forItem(this, ExtraDelightItems.NUT_BUTTER_ICE_CREAM, "nut_butter_ice_cream");
		forItem(this, ExtraDelightItems.NUT_BUTTER_MILKSHAKE, "nut_butter_milkshake");
		forItem(this, ExtraDelightItems.NUT_BUTTER_CUSTARD, "nut_butter_custard");
		forItem(this, ExtraDelightItems.MISSISSIPPI_MUD_PIE_SLICE, "mississippi_mud_pie_slice");
		forItem(this, ExtraDelightItems.HAZELNUT_SOUP, "hazelnut_soup");
		forItem(this, ExtraDelightItems.MARSHMALLOW_SLICE, "marshmallow_slice");
		forItem(this, ExtraDelightItems.GRASSHOPPER_PIE_SLICE, "grasshopper_pie_slice");
		forItem(this, ExtraDelightItems.ROCKY_ROAD, "rocky_road");
		forItem(this, ExtraDelightItems.AFFOGATO, "affogato");
		forItem(this, ExtraDelightItems.COCOA_POWDER, "cocoa_powder");
		forItem(this, ExtraDelightItems.CHOCOLATE_COOKIE_DOUGH, "chocolate_cookie_dough");
		forItem(this, ExtraDelightItems.CHOCOLATE_COOKIE, "chocolate_cookie");
		forItem(this, ExtraDelightItems.POTATO_SALAD, "potato_salad");
		forItem(this, ExtraDelightItems.ONION_SOUP, "onion_soup");
		forItem(this, ExtraDelightItems.BACON_EGG_PIE_SLICE, "bacon_egg_pie_slice");
		forItem(this, ExtraDelightItems.ONION_BHAJI, "onion_bhaji");
		forItem(this, ExtraDelightItems.FAT_POTATOES, "fat_potatoes");
		forItem(this, ExtraDelightItems.CINNAMON_TOAST, "cinnamon_toast");
		forItem(this, ExtraDelightItems.PANFORTE_SLICE, "panforte_slice");
		forItem(this, ExtraDelightItems.CURRYWURST, "currywurst");
		forItem(this, ExtraDelightItems.BORSCHT, "borscht");
		forItem(this, ExtraDelightItems.PANFORTE, "panforte");
		forItem(this, ExtraDelightItems.GRASSHOPPER_PIE, "grasshopper_pie");
		forItem(this, ExtraDelightItems.MISSISSIPPI_MUD_PIE, "mississippi_mud_pie");
		forItem(this, ExtraDelightItems.BACON_EGG_PIE, "bacon_egg_pie");
		forItem(this, ExtraDelightItems.PAMONHA, "pamonha");

		getBuilder(ExtraDelightItems.CHILI_CON_CARNE_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.WHITE_CHILI_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		getBuilder(ExtraDelightItems.MARSHMALLOW_SLICE_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forBlockItem(this, ExtraDelightItems.CHOCOLATE_COOKIE_BLOCK, "chocolate_cookie_block");
		forBlockItem(this, ExtraDelightItems.NUT_BUTTER_COOKIE_BLOCK, "nut_butter_cookie_block");

		forBlockItemFlat(this, ExtraDelightItems.WILD_GARLIC_BLOCK, "crops/garlic/garlic_stage3");
		forItem(this, ExtraDelightItems.GARLIC, "crops/garlic/garlic");
		forBlockItem(this, ExtraDelightItems.GARLIC_CRATE, "garlic_crate");
		forItem(this, ExtraDelightItems.GARLIC_CLOVE, "crops/garlic/garlic_clove");
		forItem(this, ExtraDelightItems.GRATED_GARLIC, "crops/garlic/grated_garlic");
		getBuilder(ExtraDelightItems.BRUSCHETTA_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		forItem(this, ExtraDelightItems.BRUSCHETTA, "bruschetta");
		forItem(this, ExtraDelightItems.AIOLI, "aioli");
		forItem(this, ExtraDelightItems.ROASTED_GARLIC, "crops/garlic/roasted_garlic");
		forItem(this, ExtraDelightItems.GARLIC_BREAD, "garlic_bread");
		forItem(this, ExtraDelightItems.CHEESY_GARLIC_BREAD, "cheesy_garlic_bread");
		forItem(this, ExtraDelightItems.CHICKEN_KIEV, "chicken_kiev");
		forItem(this, ExtraDelightItems.DEVILLED_SAUSAGES, "devilled_sausages");
		forBlockItem(this, ExtraDelightItems.HANGING_GARLIC, "hanging_garlic");
		forItem(this, ExtraDelightItems.AGLIO_E_OLIO, "aglio_e_olio");
		forItem(this, ExtraDelightItems.PENNE, "penne");
		forItem(this, ExtraDelightItems.PENNE_ALL_ARRABIATA, "penne_all_arrabbiata");

		getBuilder(ExtraDelightItems.VAT.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.LID.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		getBuilder(ExtraDelightItems.EVAPORATOR.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
//		getBuilder(ExtraDelightItems.JUICER.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
//				.customLoader(BlockStateItemGeometryLoader::builder);
		
		getBuilder(ExtraDelightItems.JUICER.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/juicer_item"), existingFileHelper));

		getBuilder(ExtraDelightItems.WHISK.getId().getPath()).parent(new ModelFile.ExistingModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/whisk_item"), existingFileHelper));

		getBuilder(ExtraDelightItems.DYNAMIC_TOAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(DynamicFoodGeometryLoader::builder);

		getBuilder(ExtraDelightItems.DYNAMIC_JAM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(DynamicFoodGeometryLoader::builder);

		getBuilder(ExtraDelightItems.FRUIT_BOWL.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);

		Fermentation.itemModels(this);
		SummerCitrus.itemModels(this);
		AestheticBlocks.itemModel(this);
	}

	public static void forItem(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
		tmp.singleTexture(item.getId().getPath(), tmp.mcLoc("item/generated"), "layer0", tmp.modLoc("item/" + name));
	}

	public void forItemModel(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
		tmp.getBuilder(item.getId().getPath()+"_item").parent(new ModelFile.ExistingModelFile(tmp.modLoc("item/" + name), existingFileHelper));
//		getBuilder(item.getId().getPath()).parent(
//				new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "item/" + path)));
	}

	public static void forBlockItemFlat(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
		tmp.singleTexture(item.getId().getPath(), tmp.mcLoc("item/generated"), "layer0", tmp.modLoc("block/" + name));
	}

	public static void forBlockItem(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
		if (item.get() instanceof BlockItem b)
			tmp.getBuilder(item.getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
							"block/" + BuiltInRegistries.BLOCK.getKey(b.getBlock()).getPath())));
	}

	public void forBlockItem(DeferredItem<Item> item, ResourceLocation modelLocation) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation));
	}

	public static void forBlockItem(ItemModelProvider tmp, DeferredItem<Item> item, ResourceLocation modelLocation) {
		tmp.getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation));
	}

	public void forBlockItem(DeferredItem<Item> item, ResourceLocation modelLocation, String key,
			ResourceLocation texture) {
		getBuilder(item.getId().getPath()).parent(new ModelFile.UncheckedModelFile(modelLocation)).texture(key,
				texture);
	}

	private void forBlockItemWithParent(DeferredItem<Item> item) {
		singleTexture(item.getId().getPath(), mcLoc("block/block"), "layer0",
				modLoc("block/" + item.getId().getPath()));
	}

}
package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
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

		forItem(ExtraDelightItems.YEAST, "yeast");
		forItem(ExtraDelightItems.FLOUR, "flour");

		forItem(ExtraDelightItems.CUPCAKE, "cupcake");

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
	}

	public void forItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
	}
}
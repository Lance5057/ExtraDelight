package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
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
		
		getBuilder(ExtraDelightItems.MORTAR_STONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_stone")));
		getBuilder(ExtraDelightItems.MORTAR_ANDESITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_andesite")));
		getBuilder(ExtraDelightItems.MORTAR_GRANITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_granite")));
		getBuilder(ExtraDelightItems.MORTAR_DIORITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_diorite")));
		getBuilder(ExtraDelightItems.MORTAR_DEEPSLATE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_deepslate")));
		getBuilder(ExtraDelightItems.MORTAR_BLACKSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_blackstone")));
		getBuilder(ExtraDelightItems.MORTAR_BASALT.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_basalt")));
		getBuilder(ExtraDelightItems.MORTAR_ENDSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_endstone")));
		
		getBuilder(ExtraDelightItems.MORTAR_AMETHYST.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_amethyst"))); //not craftable, dungeon item
		getBuilder(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"mortar_gilded_blackstone"))); //not craftable, dungeon item	

		getBuilder(ExtraDelightItems.PESTLE_STONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_stone"))).texture("0", mcLoc("block/stone"));
		getBuilder(ExtraDelightItems.PESTLE_ANDESITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_andesite"))).texture("0", mcLoc("block/andesite"));
		getBuilder(ExtraDelightItems.PESTLE_GRANITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_granite"))).texture("0", mcLoc("block/granite"));
		getBuilder(ExtraDelightItems.PESTLE_DIORITE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_diorite"))).texture("0", mcLoc("block/diorite"));
		getBuilder(ExtraDelightItems.PESTLE_DEEPSLATE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_deepslate"))).texture("0", mcLoc("block/deepslate"));
		getBuilder(ExtraDelightItems.PESTLE_BLACKSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_blackstone"))).texture("0", mcLoc("block/blackstone"));
		getBuilder(ExtraDelightItems.PESTLE_BASALT.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_basalt"))).texture("0", mcLoc("block/basalt_top"));
		getBuilder(ExtraDelightItems.PESTLE_ENDSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_endstone"))).texture("0", mcLoc("block/end_stone"));
		
		getBuilder(ExtraDelightItems.PESTLE_AMETHYST.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_amethyst"))).texture("0", mcLoc("block/amethyst_block")); //not craftable, dungeon item
		getBuilder(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.getId().getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,"pestle_gilded_blackstone"))).texture("0", mcLoc("block/gilded_blackstone")); //not craftable, dungeon item	

		
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

		forItem(ExtraDelightItems.CUPCAKE, "cupcake");
	}

	public void forItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
	}
}
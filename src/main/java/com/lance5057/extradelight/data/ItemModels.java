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
		getBuilder(ExtraDelightItems.DOUGH_SHAPING.getId().getPath())
		.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/doughforming")));

		forItem(ExtraDelightItems.ROUND_PAN, "round_pan");
		forItem(ExtraDelightItems.BAKING_STONE, "baking_stone");
		forItem(ExtraDelightItems.LOAF_PAN, "loaf_pan");
		forItem(ExtraDelightItems.MUFFIN_TIN, "muffin_tin");
		forItem(ExtraDelightItems.PIE_DISH, "pie_dish");
		forItem(ExtraDelightItems.SHEET, "sheet");
		forItem(ExtraDelightItems.SQUARE_PAN, "square_pan");
		forItem(ExtraDelightItems.TRAY, "tray");

		forItem(ExtraDelightItems.CUPCAKE, "cupcake");
	}

	public void forItem(RegistryObject<? extends Item> item, String name) {
		this.singleTexture(item.getId().getPath(), mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
	}
}
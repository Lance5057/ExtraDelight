package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {

	public EnglishLoc(DataGenerator gen) {
		super(gen, ExtraDelight.MOD_ID, "en_us");

	}

	@Override
	protected void addTranslations() {
		this.add("itemGroup.extradelight.items", "Extra Delight");
		this.add("farmersdelight.tooltip.oven.empty", "");
		
		this.add(ExtraDelightItems.BAKING_STONE.get(), "Baking Stone");
		this.add(ExtraDelightItems.CHEESECAKE_ITEM.get(), "Cheesecake");
		this.add(ExtraDelightItems.CHEESECAKE_SLICE.get(), "Slice of Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get(), "Chocolate Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get(), "Slice of Chocolate Cheesecake");
		this.add(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), "Chocolate Custard");
		this.add(ExtraDelightItems.CUPCAKE.get(), "Cupcake");
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
		
		this.add(ExtraDelightItems.MORTAR_AMETHYST.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_ANDESITE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_BASALT.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_BLACKSTONE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_DEEPSLATE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_DIORITE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_ENDSTONE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_GRANITE.get(), "Mortar");
		this.add(ExtraDelightItems.MORTAR_STONE.get(), "Mortar");
		
		this.add(ExtraDelightItems.MUFFIN_TIN.get(), "Muffin Tin");
		this.add(ExtraDelightItems.OVEN.get(), "Oven");
		
		this.add(ExtraDelightItems.PESTLE_AMETHYST.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_ANDESITE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_BASALT.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_BLACKSTONE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_DEEPSLATE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_DIORITE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_ENDSTONE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_GRANITE.get(), "Pestle");
		this.add(ExtraDelightItems.PESTLE_STONE.get(), "Pestle");
		
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
	}
}

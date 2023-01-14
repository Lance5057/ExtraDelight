package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightContainers;
import com.lance5057.extradelight.ExtraDelightItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class EnglishLoc extends LanguageProvider {

	public EnglishLoc(DataGenerator gen) {
		super(gen, ExtraDelight.MOD_ID, "en_us");

	}

	@Override
	protected void addTranslations() {
		add(ExtraDelightItems.OVEN.get(), "Oven");
		add(ExtraDelightItems.SHEET.get(), "Baking Sheet");
		add(ExtraDelightItems.TRAY.get(), "Baking Tray");
		add(ExtraDelightItems.LOAF_PAN.get(), "Loaf Pan");
		add(ExtraDelightItems.PIE_DISH.get(), "Pie Dish");
		add(ExtraDelightItems.ROUND_PAN.get(), "Round Pan");
		add(ExtraDelightItems.SQUARE_PAN.get(), "Square Pan");
		add(ExtraDelightItems.BAKING_STONE.get(), "Baking Stone");
		add(ExtraDelightItems.MUFFIN_TIN.get(), "Muffin Tin");
		add(ExtraDelightContainers.OVEN_MENU.get(), "Baking Oven");
	}

	private void add(MenuType<?> key, String name) {
		ResourceLocation menuKey = ForgeRegistries.MENU_TYPES.getKey(key);
		add("%s.container.%s".formatted(menuKey.getNamespace(), menuKey.getPath()), name);
	}
}

package com.lance5057.extradelight;

import java.util.function.Supplier;

import com.lance5057.extradelight.displays.food.FoodDisplayMenu;
import com.lance5057.extradelight.displays.food.FoodDisplayScreen;
import com.lance5057.extradelight.displays.knife.KnifeBlockMenu;
import com.lance5057.extradelight.displays.knife.KnifeBlockScreen;
import com.lance5057.extradelight.displays.spice.SpiceRackMenu;
import com.lance5057.extradelight.displays.spice.SpiceRackScreen;
import com.lance5057.extradelight.displays.wreath.WreathMenu;
import com.lance5057.extradelight.displays.wreath.WreathScreen;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingMenu;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingScreen;
import com.lance5057.extradelight.workstations.oven.OvenMenu;
import com.lance5057.extradelight.workstations.oven.OvenScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightContainers {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU,
			ExtraDelight.MOD_ID);

	public static final Supplier<MenuType<OvenMenu>> OVEN_MENU = MENU_TYPES.register("oven",
			() -> IMenuTypeExtension.create(OvenMenu::new));

	public static final Supplier<MenuType<FoodDisplayMenu>> FOOD_DISPLAY_MENU = MENU_TYPES
			.register("food_display", () -> IMenuTypeExtension.create(FoodDisplayMenu::new));
	public static final Supplier<MenuType<KnifeBlockMenu>> KNIFE_BLOCK_MENU = MENU_TYPES.register("knife_block",
			() -> IMenuTypeExtension.create(KnifeBlockMenu::new));
	public static final Supplier<MenuType<SpiceRackMenu>> SPICE_RACK_MENU = MENU_TYPES.register("spice_rack",
			() -> IMenuTypeExtension.create(SpiceRackMenu::new));

	public static final Supplier<MenuType<DoughShapingMenu>> DOUGH_SHAPING_MENU = MENU_TYPES
			.register("dough_shaping", () -> IMenuTypeExtension.create(DoughShapingMenu::new));
	public static final Supplier<MenuType<WreathMenu>> WREATH_MENU = MENU_TYPES
			.register("wreath", () -> IMenuTypeExtension.create(WreathMenu::new));

	public static void register(IEventBus modBus) {
		MENU_TYPES.register(modBus);
	}

	public static void registerClient(FMLClientSetupEvent event) {
		MenuScreens.register(OVEN_MENU.get(), OvenScreen::new);
		MenuScreens.register(FOOD_DISPLAY_MENU.get(), FoodDisplayScreen::new); 
		MenuScreens.register(KNIFE_BLOCK_MENU.get(), KnifeBlockScreen::new);
		MenuScreens.register(SPICE_RACK_MENU.get(), SpiceRackScreen::new);
		MenuScreens.register(DOUGH_SHAPING_MENU.get(), DoughShapingScreen::new);
		MenuScreens.register(WREATH_MENU.get(), WreathScreen::new);
	}
}

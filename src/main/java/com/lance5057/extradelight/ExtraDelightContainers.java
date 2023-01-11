package com.lance5057.extradelight;

import com.lance5057.extradelight.workstations.OvenMenu;
import com.lance5057.extradelight.workstations.OvenScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightContainers {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
			ExtraDelight.MOD_ID);

	public static final RegistryObject<MenuType<OvenMenu>> OVEN_MENU = MENU_TYPES.register("cooking_pot",
			() -> IForgeMenuType.create(OvenMenu::new));

	public static void register(IEventBus modBus) {
		MENU_TYPES.register(modBus);
	}

	public static void registerClient(FMLClientSetupEvent event) {
		MenuScreens.register(OVEN_MENU.get(), OvenScreen::new);
	}
}

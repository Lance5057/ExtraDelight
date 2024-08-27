package com.lance5057.extradelight;

import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ComponentItemHandler;

public class ExtraDelightCapabilities {
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.CANDY_BOWL.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.DRYING_RACK.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.FOOD_DISPLAY.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.KNIFE_BLOCK.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.MIXING_BOWL.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.MORTAR.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.OVEN.get(),
				(be, context) -> {
					if (context == Direction.DOWN) {
						return be.inputHandler;
					}
					return be.outputHandler;
				});
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.SPICE_RACK.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.SPICE_RACK_FULL.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.WREATH.get(),
				(o, d) -> o.getItemHandler());

		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ExtraDelightBlockEntities.TAP.get(),
				(o, d) -> o.getFluidHandler());

		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ExtraDelightBlockEntities.MELTING_POT.get(),
				(o, d) -> o.getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.MELTING_POT.get(),
				(o, d) -> o.getItemHandler());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ExtraDelightBlockEntities.CHILLER.get(),
				(be, context) -> {
					if (context == Direction.UP) {
						return be.getDripTray();
					}
					return be.getFluidTank();
				});
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.CHILLER.get(),
				(o, d) -> o.getInventory());

		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ExtraDelightBlockEntities.KEG.get(),
				(o, d) -> o.getTank());

		event.registerItem(Capabilities.ItemHandler.ITEM,
				(stack, context) -> new ComponentItemHandler(stack, ExtraDelightComponents.ITEMSTACK_HANDLER.get(), 8),
				ExtraDelightItems.WHITE_CHOCOLATE_BOX.get(), ExtraDelightItems.ORANGE_CHOCOLATE_BOX.get(),
				ExtraDelightItems.MAGENTA_CHOCOLATE_BOX.get(), ExtraDelightItems.LIGHT_BLUE_CHOCOLATE_BOX.get(),
				ExtraDelightItems.YELLOW_CHOCOLATE_BOX.get(), ExtraDelightItems.LIME_CHOCOLATE_BOX.get(),
				ExtraDelightItems.PINK_CHOCOLATE_BOX.get(), ExtraDelightItems.GRAY_CHOCOLATE_BOX.get(),
				ExtraDelightItems.LIGHT_GRAY_CHOCOLATE_BOX.get(), ExtraDelightItems.CYAN_CHOCOLATE_BOX.get(),
				ExtraDelightItems.BLUE_CHOCOLATE_BOX.get(), ExtraDelightItems.BROWN_CHOCOLATE_BOX.get(),
				ExtraDelightItems.GREEN_CHOCOLATE_BOX.get(), ExtraDelightItems.RED_CHOCOLATE_BOX.get(),
				ExtraDelightItems.BLACK_CHOCOLATE_BOX.get(), ExtraDelightItems.PURPLE_CHOCOLATE_BOX.get());

		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ExtraDelightBlockEntities.CHOCOLATE_BOX.get(),
				(be, context) -> be.getItems());
	}
}

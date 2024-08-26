package com.lance5057.extradelight;

import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

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

//		event.registerItem(Capabilities.FluidHandler.ITEM, (i, c) -> new FluidHandlerItemStack(ExtraDelightComponents.FLUID, i, 1000),
//				ExtraDelightItems.JAR.get());
	}
}

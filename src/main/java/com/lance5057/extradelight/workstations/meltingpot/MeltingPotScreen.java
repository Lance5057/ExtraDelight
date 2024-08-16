package com.lance5057.extradelight.workstations.meltingpot;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class MeltingPotScreen extends AbstractContainerScreen<MeltingPotMenu> {

	public MeltingPotScreen(MeltingPotMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		// TODO Auto-generated method stub

	}

}

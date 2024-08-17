package com.lance5057.extradelight.workstations.meltingpot;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MeltingPotScreen extends AbstractContainerScreen<MeltingPotMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation
			.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/melting_pot.png");

	public MeltingPotScreen(MeltingPotMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos - 19, 0, 0, 175, 183);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY-20, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY,
				4210752, false);
	}

}

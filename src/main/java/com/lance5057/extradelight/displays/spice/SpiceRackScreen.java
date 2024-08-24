package com.lance5057.extradelight.displays.spice;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SpiceRackScreen extends AbstractContainerScreen<SpiceRackMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"textures/gui/display.png");

	public SpiceRackScreen(SpiceRackMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
	}

	@Override
	protected void renderBg(GuiGraphics pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
//		this.renderBackground(pPoseStack, pMouseX, pMouseY, pPartialTick);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		pPoseStack.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos + 60, 0, 0, 175, 89);
		pPoseStack.blit(BACKGROUND_TEXTURE, this.leftPos + 45, this.topPos + 36, 136, 227, 86, 29);

	}
	
	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

    }

}

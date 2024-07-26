package com.lance5057.extradelight.displays.food;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FoodDisplayScreen extends AbstractContainerScreen<FoodDisplayMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"textures/gui/display.png");

	public FoodDisplayScreen(FoodDisplayMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
	}

//	@Override
//	protected void renderLabels(GuiGraphics ms, int mouseX, int mouseY) {
//		// this.font.draw(ms, this.title, (float)this.titleLabelX,
//		// (float)this.titleLabelY, 4210752);
//		// this.font.draw(ms, this.playerInventoryTitle, 8.0f, (float) (this.imageHeight
//		// - 96 + 22), 4210752);
//	}

	@Override
	protected void renderBg(GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
//		this.renderBackground(graphics, pMouseX, pMouseY, pPartialTick);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos + 60, 0, 0, 175, 89);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos + 54, this.topPos, 0, 191, 68, 65);

	}

}

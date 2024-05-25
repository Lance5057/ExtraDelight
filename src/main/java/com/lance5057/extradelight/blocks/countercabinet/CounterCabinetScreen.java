package com.lance5057.extradelight.blocks.countercabinet;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CounterCabinetScreen extends AbstractContainerScreen<CounterCabinetMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ExtraDelight.MOD_ID,
			"textures/gui/display.png");

	Renderable r;
	
	public CounterCabinetScreen(CounterCabinetMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos + 69, this.topPos, 68, 126, 38, 65);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos + 60, 0, 0, 175, 89);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos + 3, this.topPos, 0, 191, 68, 65);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos + 105, this.topPos, 0, 191, 68, 65);

	}

	@Override
	protected void renderLabels(GuiGraphics p_281635_, int p_282681_, int p_283686_) {

	}

}
package com.lance5057.extradelight.containers;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FoodDisplayScreen extends AbstractContainerScreen<FoodDisplayMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ExtraDelight.MOD_ID,
			"textures/gui/display.png");

	public FoodDisplayScreen(FoodDisplayMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;
		
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		this.blit(pPoseStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight+16);
	}

}

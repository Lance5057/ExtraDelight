package com.lance5057.extradelight.workstations.chiller;

import java.awt.Rectangle;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.widgets.FluidStackWidget;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ChillerScreen extends AbstractContainerScreen<ChillerMenu> {

	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation
			.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/chiller.png");
	private static final Rectangle HEAT_ICON = new Rectangle(176, 16, 12, 12);
	private static final Rectangle PROGRESS_ARROW = new Rectangle(176, 0, 22, 16);

	private boolean widthTooNarrow;

	public ChillerScreen(ChillerMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void init() {
		super.init();
		this.titleLabelX = 28;
		addRenderableOnly(new FluidStackWidget(this.leftPos + 43, this.topPos + 13, 16, 71, menu::getFluidTank));
		addRenderableOnly(new FluidStackWidget(this.leftPos + 126, this.topPos + 73, 16, 11, menu::getDripTray));
	}
	
	@Override
	public void render(GuiGraphics gui, final int mouseX, final int mouseY, float partialTicks) {
		super.render(gui, mouseX, mouseY, partialTicks);

		this.renderTooltip(gui, mouseX, mouseY);
	}

	@Override
	protected void renderLabels(GuiGraphics ms, int mouseX, int mouseY) {
		ms.drawString(this.font, this.title, 8, this.imageHeight - 163, 4210752, false);
		ms.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 96 + 20), 4210752, false);
	}

	@Override
	protected void renderBg(GuiGraphics ms, float partialTicks, int mouseX, int mouseY) {
		// Render UI background
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		ms.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight + 16);

//		 Render progress arrow
		int l = this.menu.tileEntity.getCookTimeTotal();
		int m = this.menu.tileEntity.getCookTime();
		ms.blit(BACKGROUND_TEXTURE, this.leftPos + 101, this.topPos +  42, PROGRESS_ARROW.x, PROGRESS_ARROW.y,
				m != 0 && l != 0 ? m * 24 / l : 0 + 1, PROGRESS_ARROW.height);
	}

}

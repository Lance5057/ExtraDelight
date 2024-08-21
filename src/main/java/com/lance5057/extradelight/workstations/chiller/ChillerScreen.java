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
	private static final Rectangle HEAT_ICON = new Rectangle(176, 34, 16, 16);
	private static final Rectangle PROGRESS_ARROW = new Rectangle(176, 9, 22, 25);

	private boolean widthTooNarrow;

	public ChillerScreen(ChillerMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void init() {
		super.init();
		this.widthTooNarrow = this.width < 379;
		this.titleLabelX = 28;
		addRenderableOnly(new FluidStackWidget(this.leftPos + 43, this.topPos + 13, 16, 71, menu::getFluidTank));
	}

	@Override
	protected void containerTick() {
		super.containerTick();
	}

	@Override
	public void render(GuiGraphics ms, final int mouseX, final int mouseY, float partialTicks) {
		super.render(ms, mouseX, mouseY, partialTicks);

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

		// Render progress arrow
//		int l = this.menu.getCookProgressionScaled();
//		ms.blit(BACKGROUND_TEXTURE, this.leftPos + 104, this.topPos + 42, PROGRESS_ARROW.x, PROGRESS_ARROW.y, l + 1,
//				PROGRESS_ARROW.height + 7);
	}

	@Override
	protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
		return (!this.widthTooNarrow) && super.isHovering(x, y, width, height, mouseX, mouseY);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
		return this.widthTooNarrow || super.mouseClicked(mouseX, mouseY, buttonId);
	}

	@Override
	protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
		boolean flag = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + this.imageWidth)
				|| mouseY >= (double) (y + this.imageHeight);
		return flag;
	}

}

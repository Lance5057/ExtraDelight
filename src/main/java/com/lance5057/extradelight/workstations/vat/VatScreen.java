package com.lance5057.extradelight.workstations.vat;

import java.awt.Rectangle;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.widgets.FluidStackWidget;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class VatScreen extends AbstractContainerScreen<VatMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation
			.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/vat.png");
	private static final Rectangle PROGRESS_ARROW = new Rectangle(0, 184, 87, 18);

	public VatScreen(VatMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);

	}

	@Override
	public void init() {
		super.init();
		addRenderableOnly(new FluidStackWidget(this.leftPos + 32, this.topPos - 4, 16, 71, menu::getFluidTank));
	}

	@Override
	public void render(GuiGraphics gui, final int mouseX, final int mouseY, float partialTicks) {
		super.render(gui, mouseX, mouseY, partialTicks);

		this.renderTooltip(gui, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		graphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos - 19, 0, 0, 175, 183);

		int l = this.menu.tileEntity.getCookTimeTotal();
		int m = this.menu.tileEntity.getCookTime();

		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.UP);

		graphics.drawString(this.font, df.format((float) ((float) l / (float) 24000)) + " Days", this.leftPos + 95,
				this.topPos + 56, 4210752, false);

		if (l != 0) {
			graphics.drawString(this.font, "Stage", this.leftPos + 125, this.topPos, 4210752, false);

			graphics.drawString(this.font,
					(this.menu.tileEntity.getStage()) + "/" + (this.menu.tileEntity.getStageTotal()),
					this.leftPos + 131, this.topPos + 10, 4210752, false);
		}

		graphics.blit(BACKGROUND_TEXTURE, this.leftPos + 62, this.topPos + 31, PROGRESS_ARROW.x, PROGRESS_ARROW.y,
				m != 0 && l != 0 ? m * 87 / l : 0, PROGRESS_ARROW.height);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
//        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY,
				4210752, false);
	}
}
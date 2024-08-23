package com.lance5057.extradelight.workstations.meltingpot;

import java.awt.Rectangle;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.widgets.FluidStackWidget;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class MeltingPotScreen extends AbstractContainerScreen<MeltingPotMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation
			.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/melting_pot.png");
	private static final Rectangle HEAT_ICON = new Rectangle(47, 55, 17, 15);
	private static final Rectangle PROGRESS_ARROW = new Rectangle(89, 25, 10, 17);

	public MeltingPotScreen(MeltingPotMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);

		
	}

	@Override
    protected void init() {
		super.init();
		addRenderableOnly(new FluidStackWidget(this.leftPos + 90, this.topPos - 5, 16, 71, menu::getFluidTank));
	}
	
	@Override
	public void render(GuiGraphics gui, final int mouseX, final int mouseY, float partialTicks) {
		super.render(gui, mouseX, mouseY, partialTicks);

		this.renderTooltip(gui, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;

		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos - 19, 0, 0, 175, 183);

		int l = this.menu.tileEntity.cookingTime;
		int m = this.menu.tileEntity.cookingProgress;
		guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos + PROGRESS_ARROW.x - 25, this.topPos + PROGRESS_ARROW.y -2, 176,
				15, m != 0 && l != 0 ? m * 24 / l : 0 + 1, PROGRESS_ARROW.height + 7);
		
		if (this.menu.tileEntity.isHeated()) {
			guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos + HEAT_ICON.x-1, this.topPos + HEAT_ICON.y - 14, 176, 0,
					HEAT_ICON.width, HEAT_ICON.height);
		}
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY - 20, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY,
				4210752, false);
	}

	private void renderHeatIndicatorTooltip(GuiGraphics gui, int mouseX, int mouseY) {
		if (this.isHovering(HEAT_ICON.x, HEAT_ICON.y, HEAT_ICON.width, HEAT_ICON.height, mouseX, mouseY)) {
			String key = "container.cooking_pot." + (this.menu.tileEntity.isHeated() ? "heated" : "not_heated");
			gui.renderTooltip(this.font, TextUtils.getTranslation(key), mouseX, mouseY);
		}
	}

}

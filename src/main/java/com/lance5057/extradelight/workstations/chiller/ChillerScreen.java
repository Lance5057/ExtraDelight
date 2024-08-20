package com.lance5057.extradelight.workstations.chiller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.widgets.FluidStackWidget;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.utility.TextUtils;

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
		addRenderableOnly(new FluidStackWidget(this.leftPos + 90, this.topPos - 5, 16, 71, menu::getFluidTank));
	}

	@Override
	protected void containerTick() {
		super.containerTick();
	}

	@Override
	public void render(GuiGraphics ms, final int mouseX, final int mouseY, float partialTicks) {
		if (this.widthTooNarrow) {
			this.renderBg(ms, partialTicks, mouseX, mouseY);
		} else {
			super.render(ms, mouseX, mouseY, partialTicks);
		}

		this.renderMealDisplayTooltip(ms, mouseX, mouseY);
	}

	private void renderHeatIndicatorTooltip(GuiGraphics gui, int mouseX, int mouseY) {
		if (this.isHovering(HEAT_ICON.x, HEAT_ICON.y, HEAT_ICON.width, HEAT_ICON.height, mouseX, mouseY)) {
			String key = "container.cooking_pot." + (this.menu.isHeated() ? "heated" : "not_heated");
			gui.renderTooltip(this.font, TextUtils.getTranslation(key), mouseX, mouseY);
		}
	}

	protected void renderMealDisplayTooltip(GuiGraphics ms, int mouseX, int mouseY) {
		if (this.minecraft != null && this.minecraft.player != null && this.menu.getCarried().isEmpty()
				&& this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
			if (this.hoveredSlot.index == 6) {
				List<Component> tooltip = new ArrayList<>();

				ItemStack mealStack = this.hoveredSlot.getItem();
				tooltip.add(((MutableComponent) mealStack.getItem().getDescription())
						.withStyle(mealStack.getRarity().getStyleModifier()));

				ItemStack containerStack = this.menu.tileEntity.getContainer();
				String container = !containerStack.isEmpty() ? containerStack.getItem().getDescription().getString()
						: "";

				tooltip.add(TextUtils.getTranslation("container.cooking_pot.served_on", container)
						.withStyle(ChatFormatting.GRAY));

				ms.renderComponentTooltip(font, tooltip, mouseX, mouseY);
			} else {
				ms.renderTooltip(font, this.hoveredSlot.getItem(), mouseX, mouseY);
			}
		}
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

		// Render heat icon
		if (this.menu.isHeated()) {
			ms.blit(BACKGROUND_TEXTURE, this.leftPos + 135, this.topPos + 64, HEAT_ICON.x, HEAT_ICON.y, HEAT_ICON.width,
					HEAT_ICON.height);
		}

		// Render progress arrow
		int l = this.menu.getCookProgressionScaled();
		ms.blit(BACKGROUND_TEXTURE, this.leftPos + 101, this.topPos + 42, PROGRESS_ARROW.x, PROGRESS_ARROW.y, l + 1,
				PROGRESS_ARROW.height + 7);
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

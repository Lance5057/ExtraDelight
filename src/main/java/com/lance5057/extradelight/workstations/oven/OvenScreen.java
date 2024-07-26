package com.lance5057.extradelight.workstations.oven;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightConfig;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookComponent;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.utility.TextUtils;

@ParametersAreNonnullByDefault
public class OvenScreen extends AbstractContainerScreen<OvenMenu> implements RecipeUpdateListener {
	private static final WidgetSprites RECIPE_BUTTON = new WidgetSprites(ResourceLocation.fromNamespaceAndPath("recipe_book/button"),
			ResourceLocation.fromNamespaceAndPath("recipe_book/button"));
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"textures/gui/oven.png");
	private static final Rectangle HEAT_ICON = new Rectangle(47, 55, 17, 15);
	private static final Rectangle PROGRESS_ARROW = new Rectangle(89, 25, 10, 17);

	private final OvenRecipeBookComponent recipeBookComponent = new OvenRecipeBookComponent();
	private boolean widthTooNarrow;

	public OvenScreen(OvenMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void init() {
		super.init();
		this.widthTooNarrow = this.width < 379;
		this.titleLabelX = 28;
		this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
		this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
		if (ExtraDelightConfig.ENABLE_RECIPE_BOOK_OVEN.get()) {
			this.addRenderableWidget(
					new ImageButton(this.leftPos + 5, this.height / 2 - 49, 20, 18, RECIPE_BUTTON, (button) -> {
						this.recipeBookComponent.toggleVisibility();
						this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
						button.setPosition(this.leftPos + 5, this.height / 2 - 49);
					}));
		} else {
			this.recipeBookComponent.hide();
			this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
		}
		this.addWidget(this.recipeBookComponent);
		this.setInitialFocus(this.recipeBookComponent);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.recipeBookComponent.tick();
	}

	@Override
	public void render(GuiGraphics ms, final int mouseX, final int mouseY, float partialTicks) {
		if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
			this.renderBg(ms, partialTicks, mouseX, mouseY);
			this.recipeBookComponent.render(ms, mouseX, mouseY, partialTicks);
		} else {
			this.recipeBookComponent.render(ms, mouseX, mouseY, partialTicks);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.recipeBookComponent.renderGhostRecipe(ms, this.leftPos, this.topPos, false, partialTicks);
		}

		this.renderMealDisplayTooltip(ms, mouseX, mouseY);
		this.renderHeatIndicatorTooltip(ms, mouseX, mouseY);
		this.recipeBookComponent.renderTooltip(ms, this.leftPos, this.topPos, mouseX, mouseY);
	}

	private void renderHeatIndicatorTooltip(GuiGraphics ms, int mouseX, int mouseY) {
		if (this.isHovering(HEAT_ICON.x, HEAT_ICON.y, HEAT_ICON.width, HEAT_ICON.height, mouseX, mouseY)) {
			String key = "container.cooking_pot." + (this.menu.isHeated() ? "heated" : "not_heated");
			ms.renderTooltip(this.font, TextUtils.getTranslation(key, menu), mouseX, mouseY);
		}
	}

	protected void renderMealDisplayTooltip(GuiGraphics ms, int mouseX, int mouseY) {
		if (this.minecraft != null && this.minecraft.player != null && this.menu.getCarried().isEmpty()
				&& this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
			if (this.hoveredSlot.index == 6) {
				List<Component> tooltip = new ArrayList<>();

				ItemStack mealStack = this.hoveredSlot.getItem();
				tooltip.add(((MutableComponent) mealStack.getItem().getDescription())
						.withStyle(mealStack.getRarity().color));

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
		super.renderLabels(ms, mouseX, mouseY);
		ms.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 96 + 2), 4210752, false);
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
			ms.blit(BACKGROUND_TEXTURE, this.leftPos + HEAT_ICON.x + 77, this.topPos + HEAT_ICON.y + 5, 176, 0,
					HEAT_ICON.width, HEAT_ICON.height);
		}

		// Render progress arrow
		int l = this.menu.getCookProgressionScaled();
		ms.blit(BACKGROUND_TEXTURE, this.leftPos + PROGRESS_ARROW.x, this.topPos + PROGRESS_ARROW.y + 10, 176, 15,
				l + 1, PROGRESS_ARROW.height + 7);
	}

	@Override
	protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
		return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible())
				&& super.isHovering(x, y, width, height, mouseX, mouseY);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
		if (this.recipeBookComponent.mouseClicked(mouseX, mouseY, buttonId)) {
			this.setFocused(this.recipeBookComponent);
			return true;
		}
		return this.widthTooNarrow && this.recipeBookComponent.isVisible()
				|| super.mouseClicked(mouseX, mouseY, buttonId);
	}

	@Override
	protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
		boolean flag = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + this.imageWidth)
				|| mouseY >= (double) (y + this.imageHeight);
		return flag && this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos,
				this.imageWidth, this.imageHeight, buttonIdx);
	}

	@Override
	protected void slotClicked(Slot slot, int mouseX, int mouseY, ClickType clickType) {
		super.slotClicked(slot, mouseX, mouseY, clickType);
		this.recipeBookComponent.slotClicked(slot);
	}

	@Override
	public void recipesUpdated() {
		this.recipeBookComponent.recipesUpdated();
	}

	@Override
	@Nonnull
	public RecipeBookComponent getRecipeBookComponent() {
		return this.recipeBookComponent;
	}
}

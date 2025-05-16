package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.evaporator.recipes.EvaporatorRecipe;
import com.mojang.blaze3d.systems.RenderSystem;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class EvaporatorRecipeCategory implements IRecipeCategory<EvaporatorRecipe> {
	public static final RecipeType<EvaporatorRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "evaporator",
			EvaporatorRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public EvaporatorRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei3.png"), 101, 0, 62, 73);
		localizedName = Component.translatable("extradelight.jei.evaporator");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.EVAPORATOR.get()));
	}

	@Override
	public RecipeType<EvaporatorRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public @Nullable IDrawable getIcon() {
		return icon;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, EvaporatorRecipe recipe, IFocusGroup focuses) {

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 49, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.getFluid().getFluids()))
				.setFluidRenderer(1000, false, 16, 71);

		builder.addSlot(RecipeIngredientRole.OUTPUT, 45, 30).addIngredients(Ingredient.of(recipe.getResultItem(null)));
	}

	@Override
	public void draw(EvaporatorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
			double mouseY) {
		RenderSystem.enableBlend();

		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.evaporator.extra"), 30, 50, 0xffffff);

		guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.evaporator.view"), 27, 4, 0xffffff);
		guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.evaporator.sky"), 44, 14, 0xffffff);

		RenderSystem.disableBlend();
	}

	@Override
	public int getWidth() {
		return 101;

	}
}

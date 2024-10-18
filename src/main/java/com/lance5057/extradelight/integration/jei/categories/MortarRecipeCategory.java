package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;
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
import net.neoforged.neoforge.fluids.FluidStack;

public class MortarRecipeCategory implements IRecipeCategory<MortarRecipe> {
	public static final RecipeType<MortarRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "mortar",
			MortarRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MortarRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 0, 84, 52);
		localizedName = Component.translatable("extradelight.jei.mortar");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.MORTAR_STONE.get()));
	}

	@Override
	public RecipeType<MortarRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MortarRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.getIngredients().get(0);
		Ingredient pestle = Ingredient.of(ExtraDelightTags.PESTLES);
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());
		FluidStack outputFluid = recipe.getFluid();

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 39 + 6, 18).addIngredients(input);
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 - 39 + 26, 1).addIngredients(pestle);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 13 + 6, 26).addItemStack(output);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 13 + 6, 8)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
				.setFluidRenderer(1000, false, 16, 16);
	}

	@Override
	public void draw(MortarRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
			double mouseY) {
		RenderSystem.enableBlend();

		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		guiGraphics.drawString(fontRenderer, "x" + recipe.getGrinds(), this.getWidth() / 2 - 24 + 24, 8, 0xffffff);

		RenderSystem.disableBlend();
	}

}

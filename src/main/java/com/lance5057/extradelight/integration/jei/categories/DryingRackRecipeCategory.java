package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class DryingRackRecipeCategory implements IRecipeCategory<DryingRackRecipe> {
	public static final RecipeType<DryingRackRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "dryingrack",
			DryingRackRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public DryingRackRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(new ResourceLocation(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 125,
				85, 47);
		localizedName = Component.translatable("extradelight.jei.dryingrack");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.DRYING_RACK.get()));
	}

	@Override
	public RecipeType<DryingRackRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.getInput();
		ItemStack output = recipe.getResultItem();

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 38, 22).addIngredients(input);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 13 + 9, 22).addItemStack(output);
	}
}

package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DryingRackRecipeCatagory implements IRecipeCategory<DryingRackRecipe> {
	public static final RecipeType<DryingRackRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "mixingbowl",
			DryingRackRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public DryingRackRecipeCatagory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(new ResourceLocation(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 156, 0,
				100, 100);
		localizedName = Component.translatable("extradelight.jei.dryingrack");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.DRYING_RACK.get()));
	}

	@Override
	public RecipeType<DryingRackRecipe> getRecipeType() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

	}
}

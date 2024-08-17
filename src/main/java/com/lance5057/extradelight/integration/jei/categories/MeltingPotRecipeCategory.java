package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.meltingpot.MeltingPotRecipe;

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
import net.minecraft.world.phys.Vec2;

public class MeltingPotRecipeCategory implements IRecipeCategory<MeltingPotRecipe> {
	public static final RecipeType<MeltingPotRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "MeltingPot",
			MeltingPotRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MeltingPotRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 156, 0, 100, 100);
		localizedName = Component.translatable("extradelight.jei.MeltingPot");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.MIXING_BOWL.get()));
	}

	@Override
	public RecipeType<MeltingPotRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, MeltingPotRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.input;

		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(input);
	}
}

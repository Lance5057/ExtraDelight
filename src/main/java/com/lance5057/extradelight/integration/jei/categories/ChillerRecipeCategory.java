package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.chiller.ChillerRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ChillerRecipeCategory implements IRecipeCategory<ChillerRecipe> {
	public static final RecipeType<ChillerRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "chiller",
			ChillerRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public ChillerRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 155, 183, 101, 73);
		localizedName = Component.translatable("extradelight.jei.chiller");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.MIXING_BOWL.get()));
	}

	@Override
	public RecipeType<ChillerRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, ChillerRecipe recipe, IFocusGroup focuses) {

		for (int i = 0; i < recipe.getIngredients().size(); i++) {
			builder.addSlot(RecipeIngredientRole.INPUT, 22, 20).addIngredients(recipe.getIngredients().get(i));
		}

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 49, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
				.setFluidRenderer(6000, false, 16, 71);
		
		builder.addSlot(RecipeIngredientRole.CATALYST, 31, 56).addIngredients(Ingredient.of(recipe.getOutputContainer()));

		builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 30).addIngredients(Ingredient.of(recipe.output));
	}

}

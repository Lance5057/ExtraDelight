package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;

public class DoughShapingRecipeCategory implements IRecipeCategory<DoughShapingRecipe> {
	public static final RecipeType<DoughShapingRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "doughshaping",
			DoughShapingRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public DoughShapingRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 238,
				78, 18);
		localizedName = Component.translatable("extradelight.jei.doughshaping");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.DOUGH_SHAPING.get()));
	}

	@Override
	public RecipeType<DoughShapingRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, DoughShapingRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.getIngredients().get(0);
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 38, 1).addIngredients(input);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 13 + 9, 1).addItemStack(output);
	}
}

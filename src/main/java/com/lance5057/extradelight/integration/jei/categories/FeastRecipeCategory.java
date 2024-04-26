package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.recipe.FeastRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class FeastRecipeCategory implements IRecipeCategory<FeastRecipe> {
	public static final RecipeType<FeastRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "feast",
			FeastRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public FeastRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(new ResourceLocation(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 220,
				64, 18);
		localizedName = Component.translatable("extradelight.jei.feast");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.CURRY_FEAST.get()));
	}

	@Override
	public RecipeType<FeastRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, FeastRecipe recipe, IFocusGroup focuses) {
		Ingredient input = recipe.getIngredients().get(0);
		ItemStack feast = recipe.getFeastStack();
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 38, 1).addIngredients(input);
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 - 8, 1).addItemStack(feast);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 15, 1).addItemStack(output);
	}
}

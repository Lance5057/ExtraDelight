package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.recipe.ShapedWithJarRecipe;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

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

public class ShapedWithJarRecipeCategory implements IRecipeCategory<ShapedWithJarRecipe> {
	public static final RecipeType<ShapedWithJarRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "shaped_with_jar",
			ShapedWithJarRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public ShapedWithJarRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 53, 121, 72);
		localizedName = Component.translatable("extradelight.jei.shaped_with_jar");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtraDelightItems.OVEN.get()));
	}

	@Override
	public RecipeType<ShapedWithJarRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, ShapedWithJarRecipe recipe, IFocusGroup focuses) {
		List<Ingredient> input = recipe.getIngredients();
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());

		for (int i = 0; i < input.size(); i++) {
			builder.addSlot(RecipeIngredientRole.INPUT, 1 + (i % 3 * 18), 1 + (i / 3 * 18))
					.addIngredients(input.get(i));

		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 35, 20).addItemStack(output);
	}
}

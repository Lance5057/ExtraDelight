package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class OvenRecipeCategory implements IRecipeCategory<OvenRecipe> {
	public static final RecipeType<OvenRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "oven", OvenRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;
	protected final IDrawable heatIndicator;
	protected final IDrawableAnimated arrow;

	public OvenRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation backgroundImage = new ResourceLocation(ExtraDelight.MOD_ID, "textures/gui/oven.png");
		background = guiHelper.createDrawable(backgroundImage, 29, 16,
				121, 72);
		localizedName = Component.translatable("extradelight.jei.oven");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtraDelightItems.OVEN.get()));
		heatIndicator = guiHelper.createDrawable(backgroundImage, 176, 0, 17, 15);
		arrow = guiHelper.drawableBuilder(backgroundImage, 176, 15, 24, 17)
				.buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
	}

	@Override
	public RecipeType<OvenRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, OvenRecipe recipe, IFocusGroup focuses) {
		List<Ingredient> input = recipe.getIngredients();
		ItemStack pan = recipe.getOutputContainer();
		ItemStack output = recipe.getResultItem();

		for (int i = 0; i < input.size(); i++) {
			builder.addSlot(RecipeIngredientRole.INPUT, 1 + (i % 3 * 18), 1 + (i / 3 * 18))
					.addIngredients(input.get(i));

		}
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 3, 47).addItemStack(pan);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 35, 20).addItemStack(output);
	}
	
	@Override
	public void draw(OvenRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack matrixStack, double mouseX, double mouseY) {
		arrow.draw(matrixStack, 60, 20);
		heatIndicator.draw(matrixStack, 95, 42);
	}
}

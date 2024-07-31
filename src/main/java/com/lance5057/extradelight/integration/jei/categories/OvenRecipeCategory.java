package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

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

public class OvenRecipeCategory implements IRecipeCategory<OvenRecipe> {
	public static final RecipeType<OvenRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "oven", OvenRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public OvenRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 53,
				121, 72);
		localizedName = Component.translatable("extradelight.jei.oven");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtraDelightItems.OVEN.get()));
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
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());

		for (int i = 0; i < input.size(); i++) {
			builder.addSlot(RecipeIngredientRole.INPUT, 1 + (i % 3 * 18), 1 + (i / 3 * 18))
					.addIngredients(input.get(i));

		}
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 3, 47).addItemStack(pan);
		// builder.addSlot(RecipeIngredientRole.CATALYST, (int) center.x, (int)
		// center.y).addIngredients(pestle);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 35, 47).addItemStack(output);
	}
}

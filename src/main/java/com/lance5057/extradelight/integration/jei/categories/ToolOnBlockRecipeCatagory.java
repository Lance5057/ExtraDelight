package com.lance5057.extradelight.integration.jei.categories;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.recipe.ToolOnBlockRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;

public class ToolOnBlockRecipeCatagory implements IRecipeCategory<ToolOnBlockRecipe> {
	public static final RecipeType<ToolOnBlockRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "tool_on_block",
			ToolOnBlockRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public ToolOnBlockRecipeCatagory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 0, 220,
				64, 18);
		localizedName = Component.translatable("extradelight.jei.tool_on_block");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get()));
	}

	@Override
	public RecipeType<ToolOnBlockRecipe> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder builder, ToolOnBlockRecipe recipe, IFocusGroup focuses) {
		BlockItem input = recipe.getIn();
		Ingredient tool = recipe.getTool();
		BlockItem output = recipe.getOut();

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 8, 1).addItemStack(new ItemStack(input));
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 - 38, 1).addIngredients(tool);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 15, 1).addItemStack(new ItemStack(output));
	}

}

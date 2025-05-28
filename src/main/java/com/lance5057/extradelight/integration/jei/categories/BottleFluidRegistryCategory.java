package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.recipe.BottleFluidRegistryRecipe;

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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class BottleFluidRegistryCategory implements IRecipeCategory<BottleFluidRegistryRecipe> {
	public static final RecipeType<BottleFluidRegistryRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID,
			"bottle_registry", BottleFluidRegistryRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public BottleFluidRegistryCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 84, 125, 61, 54);
		localizedName = Component.translatable("extradelight.jei.bottlefluid");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.GLASS_BOTTLE));
	}

	@Override
	public RecipeType<BottleFluidRegistryRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, BottleFluidRegistryRecipe recipe, IFocusGroup focuses) {

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 6, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.fluid.getFluids()))
				.setFluidRenderer(250, false, 16, 16);

		builder.addSlot(RecipeIngredientRole.INPUT, 2, 37).addIngredients(recipe.bottle);

		builder.addSlot(RecipeIngredientRole.INPUT, 45, 37)
				.addIngredients(Ingredient.of(recipe.fluid.getFluids()[0].getFluid().getBucket()));

		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 - 6, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.fluid.getFluids()))
				.setFluidRenderer(250, false, 16, 16);

		builder.addSlot(RecipeIngredientRole.OUTPUT, 2, 37).addIngredients(recipe.bottle);

		builder.addSlot(RecipeIngredientRole.OUTPUT, 45, 37)
				.addIngredients(Ingredient.of(recipe.fluid.getFluids()[0].getFluid().getBucket()));
	}

}

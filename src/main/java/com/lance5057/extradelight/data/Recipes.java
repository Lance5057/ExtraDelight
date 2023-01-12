package com.lance5057.extradelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		OvenRecipeBuilder.OvenRecipe(null, 0, 0, 0, null)
	}

}

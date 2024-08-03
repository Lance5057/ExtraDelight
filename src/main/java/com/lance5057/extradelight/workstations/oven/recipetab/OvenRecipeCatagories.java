package com.lance5057.extradelight.workstations.oven.recipetab;

import com.google.common.collect.ImmutableList;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

import net.minecraft.client.RecipeBookCategories;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

public class OvenRecipeCatagories {

//	public static RecipeBookCategories COOKING_SEARCH = RecipeBookCategories.valueOf("FARMERSDELIGHT_COOKING_SEARCH");

	public static final RecipeBookCategories OVEN_SEARCH = RecipeBookCategories.valueOf("OVEN_SEARCH");
	public static final RecipeBookCategories OVEN_MEALS = RecipeBookCategories.valueOf("OVEN_MEALS");

	public static void init(RegisterRecipeBookCategoriesEvent event) {
		event.registerBookCategories(ExtraDelightRecipes.RECIPE_TYPE_OVEN, ImmutableList.of(OVEN_SEARCH, OVEN_MEALS));
		event.registerAggregateCategory(OVEN_SEARCH, ImmutableList.of(OVEN_MEALS));
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.OVEN.get(), recipe -> {
			if (recipe.value() instanceof OvenRecipe OVENRecipe) {
				OvenRecipeBookTab tab = OVENRecipe.getRecipeBookTab();
				if (tab != null) {
					return switch (tab) {
					case MEALS -> OVEN_MEALS;
					};
				}
			}

			return OVEN_MEALS;
		});
	}
}

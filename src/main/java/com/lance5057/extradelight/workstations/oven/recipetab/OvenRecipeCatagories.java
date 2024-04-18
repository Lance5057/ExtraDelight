package com.lance5057.extradelight.workstations.oven.recipetab;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

public class OvenRecipeCatagories {
	public static final Supplier<RecipeBookCategories> OVEN_SEARCH = Suppliers
			.memoize(() -> RecipeBookCategories.create("OVEN_SEARCH", new ItemStack(Items.COMPASS)));
	public static final Supplier<RecipeBookCategories> OVEN_MEALS = Suppliers.memoize(
			() -> RecipeBookCategories.create("OVEN_MEALS", new ItemStack(Items.CAKE)));

	public static void init(RegisterRecipeBookCategoriesEvent event) {
		event.registerBookCategories(ExtraDelightRecipes.RECIPE_TYPE_OVEN,
				ImmutableList.of(OVEN_SEARCH.get(), OVEN_MEALS.get()));
		event.registerAggregateCategory(OVEN_SEARCH.get(), ImmutableList.of(OVEN_MEALS.get()));
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.OVEN.get(), recipe -> {
			if (recipe.value() instanceof OvenRecipe OVENRecipe) {
				OvenRecipeBookTab tab = OVENRecipe.getRecipeBookTab();
				if (tab != null) {
					return switch (tab) {
					case MEALS -> OVEN_MEALS.get();
					};
				}
			}

			
			return OVEN_MEALS.get();
		});
	}
}

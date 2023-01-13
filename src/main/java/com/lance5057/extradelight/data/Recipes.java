package com.lance5057.extradelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.workstations.recipetab.OvenRecipeBookTab;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		OvenRecipeBuilder.OvenRecipe(Items.CAKE, 1, 0, 0, ExtraDelightItems.ROUND_PAN.get())
				.addIngredient(Items.WHEAT, 3)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK)
				.addIngredient(Items.EGG)
				.addIngredient(Items.SUGAR, 2)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);
	}

}

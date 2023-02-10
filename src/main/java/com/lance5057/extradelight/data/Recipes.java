package com.lance5057.extradelight.data;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.data.recipebuilders.MortarRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookTab;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	public static final int FAST_COOKING = 400; // 20 seconds
	public static final int NORMAL_COOKING = 800; // 40 seconds
	public static final int SLOW_COOKING = 1600; // 80 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

	public static final int STANDARD_GRIND = 4;

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		mortarRecipes(consumer);
		ovenRecipes(consumer);
	}

	void mortarRecipes(Consumer<FinishedRecipe> consumer) {
		MortarRecipeBuilder.grind(Ingredient.of(Items.LAPIS_LAZULI), Items.BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(consumer);
	}

	void ovenRecipes(Consumer<FinishedRecipe> consumer) {
		OvenRecipeBuilder.OvenRecipe(Items.CAKE, 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.ROUND_PAN.get())
				.addIngredient(Items.WHEAT, 3).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK).addIngredient(Items.EGG).addIngredient(Items.SUGAR, 2)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.CUPCAKE.get(), 6, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.MUFFIN_TIN.get())
				.addIngredient(Items.WHEAT, 3).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK).addIngredient(Items.EGG).addIngredient(Items.SUGAR, 2)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);
	}
}

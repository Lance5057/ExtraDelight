package com.lance5057.extradelight.data.recipebuilders;

import com.lance5057.extradelight.recipe.BottleFluidRegistryRecipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class BottleFluidRegistryRecipeBuilder implements RecipeBuilder {

	public Ingredient bottle;
	public SizedFluidIngredient fluid;

	public BottleFluidRegistryRecipeBuilder(Ingredient bottle, SizedFluidIngredient fluid) {
		this.bottle = bottle;
		this.fluid = fluid;
	}

	@Override
	public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
		return this;
	}

	@Override
	public RecipeBuilder group(String groupName) {
		return this;
	}

	@Override
	public Item getResult() {
		return Items.AIR;
	}

	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation id) {
		ResourceLocation recipeId = id.withPrefix("bottlefluid/");
//		Advancement.Builder advancementBuilder = recipeOutput.advancement()
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
//				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);

		BottleFluidRegistryRecipe recipe = new BottleFluidRegistryRecipe("", this.bottle, this.fluid);
		recipeOutput.accept(recipeId, recipe, null);
	}

}

package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.juicer.JuicerRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

public class JuicerRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final Ingredient ingredient;
	private final FluidStack fluid;
	@Nullable
	private String group;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private JuicerRecipeBuilder(ItemStack pResult, Ingredient pIngredient, FluidStack fluidOut) {
		this.result = pResult;
		this.ingredient = pIngredient;
		this.fluid = fluidOut;
	}

	public static JuicerRecipeBuilder squeeze(Ingredient pIngredient, ItemStack pResult, FluidStack fluidOut) {
		return new JuicerRecipeBuilder(pResult, pIngredient, fluidOut);
	}

	public JuicerRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public JuicerRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		if (result != null)
			return this.result.getItem();
		return Items.AIR;
	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
		ResourceLocation recipeId = id.withPrefix("juicer/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

		JuicerRecipe recipe = new JuicerRecipe("", this.ingredient, this.result, this.fluid);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/juicer/")));
	}
}
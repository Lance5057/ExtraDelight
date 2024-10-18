package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;

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

public class MortarRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final Ingredient ingredient;
	private final int grinds;
	private final FluidStack fluid;
	@Nullable
	private String group;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private MortarRecipeBuilder(ItemStack pResult, Ingredient pIngredient, FluidStack fluidOut, int pGrind) {
		this.result = pResult;
		this.ingredient = pIngredient;
		this.grinds = pGrind;
		this.fluid = fluidOut;
	}

	public static MortarRecipeBuilder grind(Ingredient pIngredient, ItemStack pResult, FluidStack fluidOut,
			int grinds) {
		return new MortarRecipeBuilder(pResult, pIngredient, fluidOut, grinds);
	}

	public MortarRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public MortarRecipeBuilder group(@Nullable String pGroupName) {
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
		ResourceLocation recipeId = id.withPrefix("mortar/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

		MortarRecipe recipe = new MortarRecipe("", this.ingredient, this.result, this.fluid, this.grinds);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/mortar/")));
	}
}
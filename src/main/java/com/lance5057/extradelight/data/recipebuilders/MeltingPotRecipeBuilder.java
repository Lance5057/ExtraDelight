package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import com.lance5057.extradelight.workstations.meltingpot.MeltingPotRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

public class MeltingPotRecipeBuilder implements RecipeBuilder {

	private final Ingredient input;
	private final int cooktime;
	private final FluidStack output;

	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public MeltingPotRecipeBuilder(Ingredient input, int cooktime, FluidStack output) {
		this.input = input;
		this.cooktime = cooktime;
		this.output = output;

	}
	
	public static MeltingPotRecipeBuilder melt(Ingredient in, int time, FluidStack out) {
		return new MeltingPotRecipeBuilder(in, time, out);
	}

	@Override
	public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
		this.criteria.put(name, criterion);
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
		ResourceLocation recipeId = id.withPrefix("melting/");
		Advancement.Builder advancementBuilder = recipeOutput.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);
		MeltingPotRecipe recipe = new MeltingPotRecipe(this.input, this.cooktime, this.output);
		recipeOutput.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/melting/")));
	}

}

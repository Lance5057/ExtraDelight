package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.evaporator.recipes.EvaporatorRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class EvaporatorRecipeBuilder implements RecipeBuilder {
	@Nullable
	private String group;
	SizedFluidIngredient fluid;
	ResourceLocation lootTable;
	Block display;

	protected final int cookTime;

	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public EvaporatorRecipeBuilder(SizedFluidIngredient fluid, ResourceLocation lootTable, int cookTime,
			Block displayBlock) {
		this.fluid = fluid;
		this.lootTable = lootTable;
		this.cookTime = cookTime;
		this.display = displayBlock;
	}

	public static EvaporatorRecipeBuilder evaporate(SizedFluidIngredient fluid, ResourceLocation lootTable,
			int cookTime, Block displayBlock) {
		return new EvaporatorRecipeBuilder(fluid, lootTable, cookTime, displayBlock);
	}

	@Override
	public RecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	@Override
	public EvaporatorRecipeBuilder group(String groupName) {
		this.group = groupName;
		return this;
	}

	@Override
	public Item getResult() {
		return Items.STICK; // Cause sometimes other mods are dumb
	}

	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation id) {

		ResourceLocation recipeId = id.withPrefix("evaporator/");
		Advancement.Builder advancementBuilder = recipeOutput.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);
		EvaporatorRecipe recipe = new EvaporatorRecipe("", this.fluid, this.cookTime, this.lootTable,
				BuiltInRegistries.BLOCK.getKey(display));
		recipeOutput.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/evaporator/")));
	}

}

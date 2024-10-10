package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.fluids.FluidStack;

public class MixingBowlRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final NonNullList<Ingredient> ingredients = NonNullList.create();
	private final NonNullList<FluidStack> fluids = NonNullList.create();
	@Nullable
	private String group;
	final int stirs;
	final ItemStack usedItem;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public MixingBowlRecipeBuilder(ItemStack pResult, int stirs, ItemStack usedItem) {
		this.stirs = stirs;
		this.usedItem = usedItem;
		this.result = pResult;
	}

	public static MixingBowlRecipeBuilder stir(ItemStack pResult, int grinds, ItemStack usedItem) {
		return new MixingBowlRecipeBuilder(pResult, grinds, usedItem);
	}

	public MixingBowlRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public MixingBowlRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public MixingBowlRecipeBuilder requires(Ingredient pIngredient) {
		return this.requires(pIngredient, 1);
	}

	public MixingBowlRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
		for (int i = 0; i < pQuantity; ++i) {
			this.ingredients.add(pIngredient);
		}

		return this;
	}

	public MixingBowlRecipeBuilder requires(FluidStack stack) {
		this.fluids.add(stack);
		return this;
	}

	public MixingBowlRecipeBuilder requires(TagKey<Item> pTag) {
		return this.requires(Ingredient.of(pTag));
	}

	public MixingBowlRecipeBuilder requires(ItemLike pItem) {
		return this.requires(pItem, 1);
	}

	public MixingBowlRecipeBuilder requires(ItemLike pItem, int pQuantity) {
		for (int i = 0; i < pQuantity; ++i) {
			this.requires(Ingredient.of(pItem));
		}

		return this;
	}

	public Item getResult() {
		return this.result.getItem();
	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
		if (this.ingredients.size() > 9)
			throw new IllegalStateException("Mixing Bowl Recipe " + id + " has more than 9 ingredients!");

		ResourceLocation recipeId = id.withPrefix("mixing/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);
		MixingBowlRecipe recipe = new MixingBowlRecipe("", this.ingredients, this.fluids, this.result, this.stirs,
				this.usedItem);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/mixing/")));
	}

}

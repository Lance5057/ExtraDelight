package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.vat.recipes.VatRecipe;
import com.lance5057.extradelight.workstations.vat.recipes.VatRecipe.StageIngredient;

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
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class VatRecipeBuilder implements RecipeBuilder {
	final ItemStack containerItem;

	@Nullable
	private String group;
	final ItemStack result;
	final NonNullList<Ingredient> ingredients = NonNullList.create();
	final NonNullList<StageIngredient> stageIngredients = NonNullList.create();
	SizedFluidIngredient fluid;

	protected int stages = 0;
	protected final int cookTime;

	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public VatRecipeBuilder(ItemStack pResult, ItemStack containerItem, int cookTime) {
		this.containerItem = containerItem;
		this.result = pResult;
		this.cookTime = cookTime;
	}

	public static VatRecipeBuilder pickle(ItemStack pResult, ItemStack usedItem, int cookTime) {
		return new VatRecipeBuilder(pResult, usedItem, cookTime);
	}

	public VatRecipeBuilder requiresFluid(SizedFluidIngredient stack) {
		this.fluid = stack;
		return this;
	}

	public VatRecipeBuilder requires(Ingredient pIngredient) {
		return this.requires(pIngredient, 1);
	}

	public VatRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
		for (int i = 0; i < pQuantity; ++i) {
			this.ingredients.add(pIngredient);
		}

		return this;
	}

	public VatRecipeBuilder requires(TagKey<Item> pTag) {
		return this.requires(Ingredient.of(pTag));
	}

	public VatRecipeBuilder requires(ItemLike pItem) {
		return this.requires(pItem, 1);
	}

	public VatRecipeBuilder requires(ItemLike pItem, int pQuantity) {
		for (int i = 0; i < pQuantity; ++i) {
			this.requires(Ingredient.of(pItem));
		}

		return this;
	}

	public VatRecipeBuilder requiresStage(StageIngredient pIngredient) {
		this.stageIngredients.add(pIngredient);
		stages++;

		return this;
	}

	@Override
	public RecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	@Override
	public VatRecipeBuilder group(String groupName) {
		this.group = groupName;
		return this;
	}

	@Override
	public Item getResult() {
		return result.getItem();
	}

	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation id) {
		if (this.ingredients.size() > 6)
			throw new IllegalStateException("Vat Recipe " + id + " has more than 6 ingredients!");

		ResourceLocation recipeId = id.withPrefix("vat/");
		Advancement.Builder advancementBuilder = recipeOutput.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);
		VatRecipe recipe = new VatRecipe("", this.ingredients, stageIngredients, this.fluid, this.result, this.stages,
				this.containerItem);
		recipeOutput.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/vat/")));
	}

}

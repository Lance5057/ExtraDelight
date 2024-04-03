package com.lance5057.extradelight.data.recipebuilders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class DoughShapingRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final Ingredient ingredient;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	private final DoughShapingRecipe.Serializer serializer;

	private DoughShapingRecipeBuilder(ItemLike pResult, Ingredient pIngredient, int count,
			DoughShapingRecipe.Serializer serializer) {
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.serializer = serializer;
		this.count = count;
	}

	public static DoughShapingRecipeBuilder shape(Ingredient pIngredient, Item result, int count) {
		return new DoughShapingRecipeBuilder(result, pIngredient, count,
				ExtraDelightRecipes.DOUGH_SHAPING_SERIALIZER.get());
	}

	@Override
	public DoughShapingRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	@Override
	public DoughShapingRecipeBuilder group(String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	@Override
	public Item getResult() {
		return result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		ResourceLocation saveID = new ResourceLocation(pRecipeId.getNamespace(), "dynamic_feast/" + pRecipeId.getPath());
		this.advancement.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
		pFinishedRecipeConsumer.accept(new DoughShapingRecipeBuilder.Result(saveID,
				this.group == null ? "" : this.group, this.ingredient, this.result, count, this.advancement,
						new ResourceLocation(pRecipeId.getNamespace(),
								"recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath()),
				this.serializer));
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final Ingredient ingredient;
		private final Item result;
		private final int count;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final DoughShapingRecipe.Serializer serializer;

		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, int count,
				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
				DoughShapingRecipe.Serializer pSerializer) {
			this.id = pId;
			this.group = pGroup;
			this.ingredient = pIngredient;
			this.result = pResult;
			this.count = count;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
			this.serializer = pSerializer;
		}

		public void serializeRecipeData(JsonObject pJson) {
			if (!this.group.isEmpty()) {
				pJson.addProperty("group", this.group);
			}

			pJson.add("ingredient", this.ingredient.toJson());
			pJson.addProperty("result", Registry.ITEM.getKey(this.result).toString());
			pJson.addProperty("count", this.count);
		}

		public RecipeSerializer<?> getType() {
			return this.serializer;
		}

		/**
		 * Gets the ID for the recipe.
		 */
		public ResourceLocation getId() {
			return this.id;
		}

		/**
		 * Gets the JSON for the advancement that unlocks this recipe. Null if there is
		 * no advancement.
		 */
		@Nullable
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		/**
		 * Gets the ID for the advancement associated with this recipe. Should not be
		 * null if {@link #getAdvancementJson} is non-null.
		 */
		@Nullable
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}

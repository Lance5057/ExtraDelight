package com.lance5057.extradelight.data.recipebuilders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackSerializer;

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

public class DryingRackRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final Ingredient ingredient;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	private final DryingRackSerializer serializer;

	private DryingRackRecipeBuilder(ItemLike pResult, Ingredient pIngredient, float pExperience, int pCookingTime,
			DryingRackSerializer dryingRackSerializer) {
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.experience = pExperience;
		this.cookingTime = pCookingTime;
		this.serializer = dryingRackSerializer;
	}

	public static DryingRackRecipeBuilder drying(Ingredient pIngredient, ItemLike pResult, float pExperience,
			int pCookingTime) {
		return new DryingRackRecipeBuilder(pResult, pIngredient, pExperience, pCookingTime,
				ExtraDelightRecipes.DRYING_RACK_SERIALIZER.get());
	}

	public DryingRackRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	public DryingRackRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		ResourceLocation saveID = new ResourceLocation(pRecipeId.getNamespace(), "dynamic_feast/" + pRecipeId.getPath());
		this.ensureValid(saveID);
		this.advancement.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(RequirementsStrategy.OR);

		ResourceLocation r = new ResourceLocation(pRecipeId.getNamespace(),
				"recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath());

		pFinishedRecipeConsumer.accept(
				new DryingRackRecipeBuilder.Result(saveID, this.group == null ? "" : this.group, this.ingredient,
						this.result, this.experience, this.cookingTime, this.advancement, r, this.serializer));
	}

	/**
	 * Makes sure that this obtainable.
	 */
	private void ensureValid(ResourceLocation pId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final Ingredient ingredient;
		private final Item result;
		private final float experience;
		private final int cookingTime;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final DryingRackSerializer serializer;

		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, float pExperience,
				int pCookingTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
				DryingRackSerializer pSerializer) {
			this.id = pId;
			this.group = pGroup;
			this.ingredient = pIngredient;
			this.result = pResult;
			this.experience = pExperience;
			this.cookingTime = pCookingTime;
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
			pJson.addProperty("experience", this.experience);
			pJson.addProperty("cookingtime", this.cookingTime);
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
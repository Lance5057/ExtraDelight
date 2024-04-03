package com.lance5057.extradelight.data.recipebuilders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class MortarRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final Ingredient ingredient;
	private final int count;
	private final int grinds;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	private final MortarRecipe.Serializer serializer;

	private MortarRecipeBuilder(ItemLike pResult, Ingredient pIngredient, int pGrind, int count,
			MortarRecipe.Serializer serializer) {
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.count = count;
		this.grinds = pGrind;
		this.serializer = serializer;
	}

	public static MortarRecipeBuilder grind(Ingredient pIngredient, ItemLike pResult, int grinds, int count) {
		return new MortarRecipeBuilder(pResult, pIngredient, grinds, count,
				ExtraDelightRecipes.MORTAR_SERIALIZER.get());
	}

	public MortarRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	public MortarRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":mortar/" + location.getPath());
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		ResourceLocation saveID = new ResourceLocation(pRecipeId.getNamespace(), "dynamic_feast/" + pRecipeId.getPath());
		this.ensureValid(saveID);
		this.advancement.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
		
		ResourceLocation r = new ResourceLocation(pRecipeId.getNamespace(),
				"recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath());
		
		pFinishedRecipeConsumer.accept(new MortarRecipeBuilder.Result(saveID, this.group == null ? "" : this.group,
				this.ingredient, this.result, this.grinds, this.count, this.advancement,
				r,
				this.serializer));
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
		private final int count;
		private final int grinds;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final MortarRecipe.Serializer serializer;

		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, int pGrinds,
				int pCount, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
				MortarRecipe.Serializer pSerializer) {
			this.id = pId;
			this.group = pGroup;
			this.ingredient = pIngredient;
			this.result = pResult;
			this.count = pCount;
			this.grinds = pGrinds;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
			this.serializer = pSerializer;
		}

		public void serializeRecipeData(JsonObject pJson) {
			if (!this.group.isEmpty()) {
				pJson.addProperty("group", this.group);
			}

			pJson.add("ingredient", this.ingredient.toJson());

			JsonObject objectResult = new JsonObject();
			objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
			if (count > 1) {
				objectResult.addProperty("count", count);
			}
			pJson.add("result", objectResult);

			pJson.addProperty("grinds", this.grinds);
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
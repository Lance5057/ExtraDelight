package com.lance5057.extradelight.data.recipebuilders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.recipe.FeastRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class FeastRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final Ingredient ingredient;
	private final BlockItem block;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	private final FeastRecipe.Serializer serializer;

	private FeastRecipeBuilder(ItemLike pResult, Ingredient pIngredient, BlockItem block,
			FeastRecipe.Serializer serializer) {
		this.result = pResult.asItem();
		this.ingredient = pIngredient;
		this.block = block;
		this.serializer = serializer;
	}

	public static FeastRecipeBuilder feast(Ingredient pIngredient, ItemLike pResult, BlockItem block) {
		return new FeastRecipeBuilder(pResult, pIngredient, block, ExtraDelightRecipes.FEAST_SERIALIZER.get());
	}

	public FeastRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	public FeastRecipeBuilder group(@Nullable String pGroupName) {
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
				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(RequirementsStrategy.OR);
		pFinishedRecipeConsumer.accept(new FeastRecipeBuilder.Result(saveID, this.group == null ? "" : this.group,
				this.ingredient, this.result, this.block, this.advancement,
				new ResourceLocation(pRecipeId.getNamespace(),
						"recipes/" + result.getItemCategory().getRecipeFolderName() + "/"
								 + pRecipeId.getPath()),
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
		private final BlockItem block;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final FeastRecipe.Serializer serializer;

		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, BlockItem block,
				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, FeastRecipe.Serializer pSerializer) {
			this.id = pId;
			this.group = pGroup;
			this.ingredient = pIngredient;
			this.result = pResult;
			this.block = block;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
			this.serializer = pSerializer;
		}

		public void serializeRecipeData(JsonObject pJson) {
			if (!this.group.isEmpty()) {
				pJson.addProperty("group", this.group);
			}

			pJson.add("ingredient", this.ingredient.toJson());

			pJson.addProperty("result", ForgeRegistries.ITEMS.getKey(result).toString());
			pJson.addProperty("block", ForgeRegistries.ITEMS.getKey(block).toString());
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

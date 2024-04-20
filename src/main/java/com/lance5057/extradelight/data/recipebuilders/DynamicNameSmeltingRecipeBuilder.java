//package com.lance5057.extradelight.data.recipebuilders;
//
//import java.util.function.Consumer;
//
//import javax.annotation.Nullable;
//
//import com.google.gson.JsonObject;
//import com.lance5057.extradelight.ExtraDelightRecipes;
//
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.advancements.CriterionTriggerInstance;
//import net.minecraft.advancements.RequirementsStrategy;
//import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
//import net.minecraft.core.Registry;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.data.recipes.RecipeBuilder;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.crafting.AbstractCookingRecipe;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.level.ItemLike;
//
//public class DynamicNameSmeltingRecipeBuilder implements RecipeBuilder {
//	private final Item result;
//	private final Ingredient ingredient;
//	private final float experience;
//	private final int cookingTime;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
//	@Nullable
//	private String group;
//	private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;
//
//	private DynamicNameSmeltingRecipeBuilder(ItemLike pResult, Ingredient pIngredient, float pExperience,
//			int pCookingTime, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer) {
//		this.result = pResult.asItem();
//		this.ingredient = pIngredient;
//		this.experience = pExperience;
//		this.cookingTime = pCookingTime;
//		this.serializer = pSerializer;
//	}
//
//	public static DynamicNameSmeltingRecipeBuilder cooking(Ingredient pIngredient, ItemLike pResult, float pExperience,
//			int pCookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
//		return new DynamicNameSmeltingRecipeBuilder(pResult, pIngredient, pExperience, pCookingTime, serializer);
//	}
//
//	public static DynamicNameSmeltingRecipeBuilder campfireCooking(Ingredient pIngredient, ItemLike pResult,
//			float pExperience, int pCookingTime) {
//		return cooking(pIngredient, pResult, pExperience, pCookingTime,
//				ExtraDelightRecipes.DYNAMIC_CAMPFIRE_SERIALIZER.get());
//	}
////
////	public static DynamicNameSimpleCookingRecipeBuilder blasting(Ingredient pIngredient, ItemLike pResult, float pExperience,
////			int pCookingTime) {
////		return cooking(pIngredient, pResult, pExperience, pCookingTime, RecipeSerializer.BLASTING_RECIPE);
////	}
//
//	public static DynamicNameSmeltingRecipeBuilder smelting(Ingredient pIngredient, ItemLike pResult, float pExperience,
//			int pCookingTime) {
//		return cooking(pIngredient, pResult, pExperience, pCookingTime,
//				ExtraDelightRecipes.DYNAMIC_SMELT_SERIALIZER.get());
//	}
//
//	public static DynamicNameSmeltingRecipeBuilder smoking(Ingredient pIngredient, ItemLike pResult, float pExperience,
//			int pCookingTime) {
//		return cooking(pIngredient, pResult, pExperience, pCookingTime,
//				ExtraDelightRecipes.DYNAMIC_SMOKE_SERIALIZER.get());
//	}
//
//	public DynamicNameSmeltingRecipeBuilder unlockedBy(String pCriterionName,
//			CriterionTriggerInstance pCriterionTrigger) {
//		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
//		return this;
//	}
//
//	public DynamicNameSmeltingRecipeBuilder group(@Nullable String pGroupName) {
//		this.group = pGroupName;
//		return this;
//	}
//
//	public Item getResult() {
//		return this.result;
//	}
//
//	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
//		this.ensureValid(pRecipeId);
//		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
//				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
//		pFinishedRecipeConsumer.accept(new DynamicNameSmeltingRecipeBuilder.Result(pRecipeId,
//				this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.cookingTime,
//				this.advancement,
//				new ResourceLocation(pRecipeId.getNamespace(),
//						"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath()),
//				this.serializer));
//	}
//
//	/**
//	 * Makes sure that this obtainable.
//	 */
//	private void ensureValid(ResourceLocation pId) {
//		if (this.advancement.getCriteria().isEmpty()) {
//			throw new IllegalStateException("No way of obtaining recipe " + pId);
//		}
//	}
//
//	public static class Result implements FinishedRecipe {
//		private final ResourceLocation id;
//		private final String group;
//		private final Ingredient ingredient;
//		private final Item result;
//		private final float experience;
//		private final int cookingTime;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;
//
//		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, float pExperience,
//				int pCookingTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
//				RecipeSerializer<? extends AbstractCookingRecipe> pSerializer) {
//			this.id = pId;
//			this.group = pGroup;
//			this.ingredient = pIngredient;
//			this.result = pResult;
//			this.experience = pExperience;
//			this.cookingTime = pCookingTime;
//			this.advancement = pAdvancement;
//			this.advancementId = pAdvancementId;
//			this.serializer = pSerializer;
//		}
//
//		public void serializeRecipeData(JsonObject pJson) {
//			if (!this.group.isEmpty()) {
//				pJson.addProperty("group", this.group);
//			}
//
//			pJson.add("ingredient", this.ingredient.toJson());
//			pJson.addProperty("result", Registry.ITEM.getKey(this.result).toString());
//			pJson.addProperty("experience", this.experience);
//			pJson.addProperty("cookingtime", this.cookingTime);
//		}
//
//		public RecipeSerializer<?> getType() {
//			return this.serializer;
//		}
//
//		/**
//		 * Gets the ID for the recipe.
//		 */
//		public ResourceLocation getId() {
//			return this.id;
//		}
//
//		/**
//		 * Gets the JSON for the advancement that unlocks this recipe. Null if there is
//		 * no advancement.
//		 */
//		@Nullable
//		public JsonObject serializeAdvancement() {
//			return this.advancement.serializeToJson();
//		}
//
//		/**
//		 * Gets the ID for the advancement associated with this recipe. Should not be
//		 * null if {@link #getAdvancementJson} is non-null.
//		 */
//		@Nullable
//		public ResourceLocation getAdvancementId() {
//			return this.advancementId;
//		}
//	}
//}
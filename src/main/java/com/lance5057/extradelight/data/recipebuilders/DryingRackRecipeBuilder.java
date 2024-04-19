package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.dryingrack.DryingRackRecipe;

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
import net.minecraft.world.item.crafting.Ingredient;

public class DryingRackRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final Ingredient ingredient;
	private final float experience;
	private final int cookingTime;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
//	private final DryingRackSerializer serializer;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private DryingRackRecipeBuilder(ItemStack pResult, Ingredient pIngredient, float pExperience, int pCookingTime) {
		this.result = pResult;
		this.ingredient = pIngredient;
		this.experience = pExperience;
		this.cookingTime = pCookingTime;
//		this.serializer = dryingRackSerializer;
	}

	public static DryingRackRecipeBuilder drying(Ingredient pIngredient, ItemStack pResult, float pExperience,
			int pCookingTime) {
		return new DryingRackRecipeBuilder(pResult, pIngredient, pExperience, pCookingTime);
	}

	@Override
	public DryingRackRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public DryingRackRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result.getItem();
	}

	public void save(RecipeOutput output, ResourceLocation id) {
//		ResourceLocation saveID = new ResourceLocation(pRecipeId.getNamespace(),
//				"dynamic_feast/" + pRecipeId.getPath());
//		this.advancement.parent(new ResourceLocation("recipes/root"))
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
//				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(AdvancementRequirements.Strategy.OR);
//
////		ResourceLocation r = new ResourceLocation(pRecipeId.getNamespace(),
////				"recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath());
//
////		pFinishedRecipeConsumer.accept(new DryingRackRecipeBuilder.Result(saveID, this.group == null ? "" : this.group,
////				this.ingredient, this.result, this.experience, this.cookingTime, this.advancement, r, this.serializer));
//		
//		DryingRackRecipeBuilder recipe = new DryingRackRecipeBuilder("", this.tab, this.ingredients, this.resultStack, this.container,
//				this.experience, this.cookingTime);
//		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/cooking/")));

		ResourceLocation recipeId = id.withPrefix("drying/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

//		public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab, NonNullList<Ingredient> inputItems,
//				ItemStack output, ItemStack container, float experience, int cookTime) {
		DryingRackRecipe recipe = new DryingRackRecipe("", this.ingredient, this.result, this.experience,
				this.cookingTime);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/drying/")));
	}

//	public static class Result implements FinishedRecipe {
//		private final ResourceLocation id;
//		private final String group;
//		private final Ingredient ingredient;
//		private final Item result;
//		private final float experience;
//		private final int cookingTime;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final DryingRackSerializer serializer;
//
//		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, float pExperience,
//				int pCookingTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
//				DryingRackSerializer pSerializer) {
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
}
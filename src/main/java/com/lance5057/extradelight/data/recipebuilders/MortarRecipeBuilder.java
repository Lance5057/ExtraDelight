package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;

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

public class MortarRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final Ingredient ingredient;
//	private final int count;
	private final int grinds;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
//	private final MortarRecipe.Serializer serializer;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private MortarRecipeBuilder(ItemStack pResult, Ingredient pIngredient, int pGrind) {
		this.result = pResult;
		this.ingredient = pIngredient;
//		this.count = count;
		this.grinds = pGrind;
//		this.serializer = serializer;
	}

	public static MortarRecipeBuilder grind(Ingredient pIngredient, ItemStack pResult, int grinds) {
		return new MortarRecipeBuilder(pResult, pIngredient, grinds);
	}

	public MortarRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public MortarRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result.getItem();
	}

//	@Override
//	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
//		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
//		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":mortar/" + location.getPath());
//	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
		ResourceLocation recipeId = id.withPrefix("mortar/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

//		public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab, NonNullList<Ingredient> inputItems,
//				ItemStack output, ItemStack container, float experience, int cookTime) {
		MortarRecipe recipe = new MortarRecipe("", this.ingredient, this.result, this.grinds);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/mortar/")));
	}

	/**
	 * Makes sure that this obtainable.
	 */
//	private void ensureValid(ResourceLocation pId) {
//		if (this.advancement.getCriteria().isEmpty()) {
//			throw new IllegalStateException("No way of obtaining recipe " + pId);
//		}
//	}

//	public static class Result implements FinishedRecipe {
//		private final ResourceLocation id;
//		private final String group;
//		private final Ingredient ingredient;
//		private final Item result;
//		private final int count;
//		private final int grinds;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final MortarRecipe.Serializer serializer;
//
//		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, int pGrinds,
//				int pCount, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
//				MortarRecipe.Serializer pSerializer) {
//			this.id = pId;
//			this.group = pGroup;
//			this.ingredient = pIngredient;
//			this.result = pResult;
//			this.count = pCount;
//			this.grinds = pGrinds;
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
//
//			JsonObject objectResult = new JsonObject();
//			objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
//			if (count > 1) {
//				objectResult.addProperty("count", count);
//			}
//			pJson.add("result", objectResult);
//
//			pJson.addProperty("grinds", this.grinds);
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
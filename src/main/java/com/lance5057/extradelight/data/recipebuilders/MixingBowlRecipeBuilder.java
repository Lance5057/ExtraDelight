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

public class MixingBowlRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
//	private final int count;
	private final NonNullList<Ingredient> ingredients = NonNullList.create();
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	final int stirs;
	final ItemStack usedItem;
//	private final MixingBowlRecipe.Serializer serializer;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public MixingBowlRecipeBuilder(ItemStack pResult, int stirs, ItemStack usedItem) {
		this.stirs = stirs;
		this.usedItem = usedItem;
		this.result = pResult;
//		this.count = pCount;
//		this.serializer = serializer;
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

//	@Override
//	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
//		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
//		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":mixingbowl/" + location.getPath());
//	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
		ResourceLocation recipeId = id.withPrefix("mixing/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);
		MixingBowlRecipe recipe = new MixingBowlRecipe("", this.ingredients, this.result, this.stirs, this.usedItem);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/mixing/")));
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
//		private final Item result;
//		private final int count;
//		private final String group;
//		private final List<Ingredient> ingredients;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final int stirs;
//		private final Item usedItem;
//
//		public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, List<Ingredient> pIngredients,
//				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, int stirs, Item usedItem) {
//			this.id = pId;
//			this.result = pResult;
//			this.count = pCount;
//			this.group = pGroup;
//			this.ingredients = pIngredients;
//			this.advancement = pAdvancement;
//			this.advancementId = pAdvancementId;
//			this.stirs = stirs;
//			this.usedItem = usedItem;
//		}
//
//		public void serializeRecipeData(JsonObject pJson) {
//			if (!this.group.isEmpty()) {
//				pJson.addProperty("group", this.group);
//			}
//
//			JsonArray jsonarray = new JsonArray();
//
//			for (Ingredient ingredient : this.ingredients) {
//				jsonarray.add(ingredient.toJson());
//			}
//
//			pJson.add("ingredients", jsonarray);
//
//			JsonObject jsonobject = new JsonObject();
//			jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
//			if (this.count > 1) {
//				jsonobject.addProperty("count", this.count);
//			}
//
//			JsonObject jsonobject2 = new JsonObject();
//			jsonobject2.addProperty("item", Registry.ITEM.getKey(this.usedItem).toString());
//
//			pJson.addProperty("stirs", this.stirs);
//			pJson.add("usedItem", jsonobject2);
//			pJson.add("result", jsonobject);
//		}
//
//		public RecipeSerializer<?> getType() {
//			return ExtraDelightRecipes.MIXING_BOWL_SERIALIZER.get();
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

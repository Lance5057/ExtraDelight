package com.lance5057.extradelight.data.recipebuilders;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class MixingBowlRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final List<Ingredient> ingredients = Lists.newArrayList();
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
	final int stirs;
	final Item usedItem;
	private final MixingBowlRecipe.Serializer serializer;

	public MixingBowlRecipeBuilder(ItemLike pResult, int pCount, int stirs, Item usedItem,
			MixingBowlRecipe.Serializer serializer) {
		this.stirs = stirs;
		this.usedItem = usedItem;
		this.result = pResult.asItem();
		this.count = pCount;
		this.serializer = serializer;
	}

	public static MixingBowlRecipeBuilder stir(ItemLike pResult, int grinds, Item usedItem, int count) {
		return new MixingBowlRecipeBuilder(pResult, count, grinds, usedItem,
				ExtraDelightRecipes.MIXING_BOWL_SERIALIZER.get());
	}

	public MixingBowlRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
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
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":mixingbowl/" + location.getPath());
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		ResourceLocation saveID = new ResourceLocation(pRecipeId.getNamespace(), "mixing/" + pRecipeId.getPath());
		this.ensureValid(saveID);
		this.advancement.parent(new ResourceLocation("recipes/root"))
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(RequirementsStrategy.OR);
		pFinishedRecipeConsumer.accept(new MixingBowlRecipeBuilder.Result(saveID, this.result, this.count,
				this.group == null ? "" : this.group, this.ingredients, this.advancement,
				new ResourceLocation(pRecipeId.getNamespace(),
						"recipes/" + result.getItemCategory().getRecipeFolderName() + "/"
								 + pRecipeId.getPath()),
				this.stirs, this.usedItem));
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
		private final Item result;
		private final int count;
		private final String group;
		private final List<Ingredient> ingredients;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;
		private final int stirs;
		private final Item usedItem;

		public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, List<Ingredient> pIngredients,
				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, int stirs, Item usedItem) {
			this.id = pId;
			this.result = pResult;
			this.count = pCount;
			this.group = pGroup;
			this.ingredients = pIngredients;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
			this.stirs = stirs;
			this.usedItem = usedItem;
		}

		public void serializeRecipeData(JsonObject pJson) {
			if (!this.group.isEmpty()) {
				pJson.addProperty("group", this.group);
			}

			JsonArray jsonarray = new JsonArray();

			for (Ingredient ingredient : this.ingredients) {
				jsonarray.add(ingredient.toJson());
			}

			pJson.add("ingredients", jsonarray);

			JsonObject jsonobject = new JsonObject();
			jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
			if (this.count > 1) {
				jsonobject.addProperty("count", this.count);
			}

			JsonObject jsonobject2 = new JsonObject();
			jsonobject2.addProperty("item", Registry.ITEM.getKey(this.usedItem).toString());

			pJson.addProperty("stirs", this.stirs);
			pJson.add("usedItem", jsonobject2);
			pJson.add("result", jsonobject);
		}

		public RecipeSerializer<?> getType() {
			return ExtraDelightRecipes.MIXING_BOWL_SERIALIZER.get();
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

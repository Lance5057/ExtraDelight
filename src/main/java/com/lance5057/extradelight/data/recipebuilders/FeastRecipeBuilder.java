package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.recipe.FeastRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class FeastRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final Ingredient ingredient;
	private final BlockItem block;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
//	private final FeastRecipe.Serializer serializer;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private FeastRecipeBuilder(ItemStack pResult, Ingredient pIngredient, BlockItem block) {
		this.result = pResult;
		this.ingredient = pIngredient;
		this.block = block;
//		this.serializer = serializer;

	}

	public static FeastRecipeBuilder feast(Ingredient pIngredient, ItemStack pResult, BlockItem block) {
		return new FeastRecipeBuilder(pResult, pIngredient, block);
	}

	@Override
	public FeastRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public FeastRecipeBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.result.getItem();
	}

//	@Override
//	public void save(RecipeOutput output) {
//		ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
//		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":mortar/" + location.getPath());
//	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
//		ResourceLocation saveID = ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(), "dynamic_feast/" + pRecipeId.getPath());
//		this.ensureValid(saveID);
//		this.advancement.parent(ResourceLocation.fromNamespaceAndPath("recipes/root"))
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
//				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(RequirementsStrategy.OR);
//		pFinishedRecipeConsumer.accept(new FeastRecipeBuilder.Result(saveID, this.group == null ? "" : this.group,
//				this.ingredient, this.result, this.block, this.advancement,
//				ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(),
//						"recipes/" + result.getItemCategory().getRecipeFolderName() + "/"
//								 + pRecipeId.getPath()),
//				this.serializer));

		ResourceLocation recipeId = id.withPrefix("feast/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

//		public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab, NonNullList<Ingredient> inputItems,
//				ItemStack output, ItemStack container, float experience, int cookTime) {
		FeastRecipe recipe = new FeastRecipe("", this.block, this.ingredient, this.result);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/feast/")));
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
//		private final BlockItem block;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final FeastRecipe.Serializer serializer;
//
//		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, Item pResult, BlockItem block,
//				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, FeastRecipe.Serializer pSerializer) {
//			this.id = pId;
//			this.group = pGroup;
//			this.ingredient = pIngredient;
//			this.result = pResult;
//			this.block = block;
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
//			pJson.addProperty("result", BuiltInRegistries.ITEM.getKey(result).toString());
//			pJson.addProperty("block", BuiltInRegistries.ITEM.getKey(block).toString());
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
//
//	@Override
//	public RecipeBuilder unlockedBy(String p_176496_, Criterion<?> p_301065_) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void save(RecipeOutput p_301032_, ResourceLocation p_176504_) {
//		// TODO Auto-generated method stub
//		
//	}
}

package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.lance5057.extradelight.recipe.ToolOnBlockRecipe;

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
import net.minecraft.world.item.crafting.Ingredient;

public class ToolOnBlockBuilder implements RecipeBuilder {
	private final BlockItem in;
	private final Ingredient tool;
	private final BlockItem out;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;
//	private final ToolOnBlockRecipe.Serializer serializer;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private ToolOnBlockBuilder(BlockItem pResult, BlockItem block, Ingredient pIngredient) {
		this.in = pResult;
		this.tool = pIngredient;
		this.out = block;
//		this.serializer = serializer;
	}

	public static ToolOnBlockBuilder make(BlockItem pResult, Ingredient pIngredient, BlockItem block) {
		return new ToolOnBlockBuilder(pResult, block, pIngredient);
	}

	public ToolOnBlockBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public ToolOnBlockBuilder group(@Nullable String pGroupName) {
		this.group = pGroupName;
		return this;
	}

	public Item getResult() {
		return this.in;
	}

//	@Override
//	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
//		ResourceLocation location = ForgeRegistries.ITEMS.getKey(in);
//		save(pFinishedRecipeConsumer, ExtraDelight.MOD_ID + ":tool_on_block/" + location.getPath());
//	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
//		ResourceLocation saveID = ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(),
//				"tool_on_block/" + pRecipeId.getPath());
//		this.ensureValid(pRecipeId);
//		this.advancement.parent(ResourceLocation.fromNamespaceAndPath("recipes/root"))
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(saveID))
//				.rewards(AdvancementRewards.Builder.recipe(saveID)).requirements(RequirementsStrategy.OR);
//		pFinishedRecipeConsumer.accept(new ToolOnBlockBuilder.Result(saveID, this.group == null ? "" : this.group,
//				this.tool, this.in, this.out, this.advancement,
//				ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(),
//						"recipes/" + this.in.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath()),
//				this.serializer));

		ResourceLocation recipeId = id.withPrefix("toolonblock/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

//		public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab, NonNullList<Ingredient> inputItems,
//				ItemStack output, ItemStack container, float experience, int cookTime) {
		ToolOnBlockRecipe recipe = new ToolOnBlockRecipe(this.in, this.tool, this.out);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/toolonblock/")));
	}

	/**
	 * Makes sure that this obtainable.
	 */
//	private void ensureValid(ResourceLocation pId) {
//		if (this.advancement.getCriteria().isEmpty()) {
//			throw new IllegalStateException("No way of obtaining recipe " + pId);
//		}
//	}
//
//	public static class Result implements FinishedRecipe {
//		private final ResourceLocation id;
//		private final String group;
//		private final Ingredient tool;
//		private final BlockItem in;
//		private final BlockItem out;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//		private final ToolOnBlockRecipe.Serializer serializer;
//
//		public Result(ResourceLocation pId, String pGroup, Ingredient pIngredient, BlockItem in, BlockItem out,
//				Advancement.Builder pAdvancement, ResourceLocation pAdvancementId,
//				ToolOnBlockRecipe.Serializer pSerializer) {
//			this.id = pId;
//			this.group = pGroup;
//			this.tool = pIngredient;
//			this.in = in;
//			this.out = out;
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
//			pJson.add("ingredient", this.tool.toJson());
//
//			pJson.addProperty("blockIn", ForgeRegistries.ITEMS.getKey(in).toString());
//			pJson.addProperty("blockOut", ForgeRegistries.ITEMS.getKey(out).toString());
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

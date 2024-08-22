package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.workstations.chiller.ChillerRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.fluids.FluidStack;

public class ChillerRecipeBuilder implements RecipeBuilder {

//	private ChillerRecipeBookTab tab;
	private final NonNullList<Ingredient> ingredients = NonNullList.create();
	private final Item result;
	private final ItemStack resultStack;
	private final int cookingTime;
	private final float experience;
	private final ItemStack container;
	private final FluidStack fluid;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private ChillerRecipeBuilder(ItemStack resultIn, int cookingTime, float experience, ItemStack container,
			FluidStack fluid) {
		this.result = resultIn.getItem();
		this.resultStack = resultIn;
		this.cookingTime = cookingTime;
		this.experience = experience;
		this.container = container;
//		this.tab = null;
		this.fluid = fluid;
	}
	
	public static ChillerRecipeBuilder chill(ItemStack mainResult, int cookingTime, float experience,
			ItemStack container, FluidStack fluid) {
		return new ChillerRecipeBuilder(mainResult, cookingTime, experience, container, fluid);
	}

	public ChillerRecipeBuilder addIngredient(TagKey<Item> tagIn) {
		return addIngredient(Ingredient.of(tagIn));
	}

	public ChillerRecipeBuilder addIngredient(TagKey<Item> itemIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			addIngredient(Ingredient.of(itemIn));
		}
		return this;
	}

	public ChillerRecipeBuilder addIngredient(ItemLike itemIn) {
		return addIngredient(itemIn, 1);
	}

	public ChillerRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			addIngredient(Ingredient.of(itemIn));
		}
		return this;
	}

	public ChillerRecipeBuilder addIngredient(Ingredient ingredientIn) {
		return addIngredient(ingredientIn, 1);
	}

	public ChillerRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			ingredients.add(ingredientIn);
		}
		return this;
	}

	public ChillerRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public ChillerRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
		return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
	}

	public ChillerRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
		this.criteria.put("has_any_ingredient",
				InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
		return this;
	}

//	public ChillerRecipeBuilder setRecipeBookTab(ChillerRecipeBookTab tab) {
//		this.tab = tab;
//		return this;
//	}

	public void build(RecipeOutput consumer) {
		ResourceLocation location = BuiltInRegistries.ITEM.getKey(result);
		build(consumer, ExtraDelight.MOD_ID + ":" + location.getPath());
	}

	public void build(RecipeOutput consumerIn, String save) {
		save(consumerIn, ResourceLocation.parse(save));
	}

	@Override
	public RecipeBuilder group(String p_176495_) {
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(RecipeOutput output, ResourceLocation id) {
		ResourceLocation recipeId = id.withPrefix("chilling/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

		ChillerRecipe recipe = new ChillerRecipe("", this.ingredients, this.fluid, this.resultStack, this.container,
				this.experience, this.cookingTime);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/chilling/")));
	}

}

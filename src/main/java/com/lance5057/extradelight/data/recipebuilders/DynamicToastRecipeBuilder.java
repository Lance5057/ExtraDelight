package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lance5057.extradelight.recipe.DynamicToastRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;

public class DynamicToastRecipeBuilder implements RecipeBuilder {
	private final RecipeCategory category;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;
	private final String graphic;

	public DynamicToastRecipeBuilder(RecipeCategory p_249996_, ItemStack result, String graphic) {
		this.category = p_249996_;
		this.result = result;
		this.graphic = graphic;
	}


    public static DynamicToastRecipeBuilder shapeless(RecipeCategory p_252339_, ItemStack result, String graphic) {
        return new DynamicToastRecipeBuilder(p_252339_, result, graphic);
    }

    /**
     * Adds an ingredient that can be any item in the given tag.
     */
    public DynamicToastRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    /**
     * Adds an ingredient of the given item.
     */
    public DynamicToastRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    /**
     * Adds the given ingredient multiple times.
     */
    public DynamicToastRecipeBuilder requires(ItemLike item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.requires(Ingredient.of(item));
        }

        return this;
    }

    /**
     * Adds an ingredient.
     */
    public DynamicToastRecipeBuilder requires(Ingredient ingredient) {
        return this.requires(ingredient, 1);
    }

    /**
     * Adds an ingredient multiple times.
     */
    public DynamicToastRecipeBuilder requires(Ingredient ingredient, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.ingredients.add(ingredient);
        }

        return this;
    }

    public DynamicToastRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public DynamicToastRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation id) {
		this.ensureValid(id);
		Advancement.Builder advancement$builder = recipeOutput.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancement$builder::addCriterion);
		DynamicToastRecipe shapedrecipe = new DynamicToastRecipe(Objects.requireNonNullElse(this.group, ""),
				RecipeBuilder.determineBookCategory(this.category), this.result, this.ingredients, this.graphic);
		recipeOutput.accept(id, shapedrecipe,
				advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
	}

	private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

	
}
package com.lance5057.extradelight.data.recipebuilders;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lance5057.extradelight.recipe.ShapedWithJarRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.fluids.FluidStack;

public class ShapedWithJarRecipeBuilder implements RecipeBuilder {

	private final RecipeCategory category;
	private final Item result;
	private final int count;
	private final ItemStack resultStack; // Neo: add stack result support
	private final List<String> rows = Lists.newArrayList();
	private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
	@Nullable
	private String group;
	private boolean showNotification = true;
	private final List<FluidStack> fluids;

	public ShapedWithJarRecipeBuilder(RecipeCategory category, ItemLike result, int count, List<FluidStack> fluids) {
		this(category, new ItemStack(result, count), fluids);
	}

	public ShapedWithJarRecipeBuilder(RecipeCategory p_249996_, ItemStack result, List<FluidStack> fluids) {
		this.category = p_249996_;
		this.result = result.getItem();
		this.count = result.getCount();
		this.resultStack = result;
		this.fluids = fluids;
	}

//	/**
//	 * Creates a new builder for a shaped recipe.
//	 */
//	public static ShapedWithJarRecipeBuilder shaped(RecipeCategory category, ItemLike result, int i) {
//		return shaped(category, result, 1);
//	}

	/**
	 * Creates a new builder for a shaped recipe.
	 */
	public static ShapedWithJarRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count,
			FluidStack... fluids) {
		return new ShapedWithJarRecipeBuilder(category, result, count, Arrays.asList(fluids));
	}

	public static ShapedWithJarRecipeBuilder shaped(RecipeCategory p_251325_, ItemStack result,
			FluidStack... fluids) {
		return new ShapedWithJarRecipeBuilder(p_251325_, result, Arrays.asList(fluids));
	}

	/**
	 * Adds a key to the recipe pattern.
	 */
	public ShapedWithJarRecipeBuilder define(Character symbol, TagKey<Item> tag) {
		return this.define(symbol, Ingredient.of(tag));
	}

	/**
	 * Adds a key to the recipe pattern.
	 */
	public ShapedWithJarRecipeBuilder define(Character symbol, ItemLike item) {
		return this.define(symbol, Ingredient.of(item));
	}

	/**
	 * Adds a key to the recipe pattern.
	 */
	public ShapedWithJarRecipeBuilder define(Character symbol, Ingredient ingredient) {
		if (this.key.containsKey(symbol)) {
			throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
		} else if (symbol == ' ') {
			throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
		} else {
			this.key.put(symbol, ingredient);
			return this;
		}
	}

	/**
	 * Adds a new entry to the patterns for this recipe.
	 */
	public ShapedWithJarRecipeBuilder pattern(String pattern) {
		if (!this.rows.isEmpty() && pattern.length() != this.rows.get(0).length()) {
			throw new IllegalArgumentException("Pattern must be the same width on every line!");
		} else {
			this.rows.add(pattern);
			return this;
		}
	}

	public ShapedWithJarRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
		this.criteria.put(name, criterion);
		return this;
	}

	public ShapedWithJarRecipeBuilder group(@Nullable String groupName) {
		this.group = groupName;
		return this;
	}

	public ShapedWithJarRecipeBuilder showNotification(boolean showNotification) {
		this.showNotification = showNotification;
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}
	


	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation id) {
		ShapedRecipePattern shapedrecipepattern = this.ensureValid(id);
		Advancement.Builder advancement$builder = recipeOutput.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancement$builder::addCriterion);
		ShapedWithJarRecipe shapedrecipe = new ShapedWithJarRecipe(Objects.requireNonNullElse(this.group, ""),
				RecipeBuilder.determineBookCategory(this.category), shapedrecipepattern, this.fluids, this.resultStack,
				this.showNotification);
		recipeOutput.accept(id, shapedrecipe,
				advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
	}

	private ShapedRecipePattern ensureValid(ResourceLocation loaction) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + loaction);
		} else {
			return ShapedRecipePattern.of(this.key, this.rows);
		}
	}

}

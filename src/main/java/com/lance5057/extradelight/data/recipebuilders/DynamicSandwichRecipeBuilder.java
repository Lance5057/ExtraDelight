//package com.lance5057.extradelight.data.recipebuilders;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//import javax.annotation.Nullable;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.lance5057.extradelight.recipe.DynamicSandwichRecipe;
//
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRequirements;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.advancements.Criterion;
//import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
//import net.minecraft.data.recipes.RecipeBuilder;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.ShapedRecipePattern;
//import net.minecraft.world.level.ItemLike;
//
//public class DynamicSandwichRecipeBuilder implements RecipeBuilder {
//	private final RecipeCategory category;
//	private final Item result;
//	private final int count;
//	private final ItemStack resultStack; // Neo: add stack result support
//	private final List<String> rows = Lists.newArrayList();
//	private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
//	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
//	@Nullable
//	private String group;
//	private boolean showNotification = true;
//
//	public DynamicSandwichRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
//		this(category, new ItemStack(result, count));
//	}
//
//	public DynamicSandwichRecipeBuilder(RecipeCategory p_249996_, ItemStack result) {
//		this.category = p_249996_;
//		this.result = result.getItem();
//		this.count = result.getCount();
//		this.resultStack = result;
//	}
//
//	/**
//	 * Creates a new builder for a shaped recipe.
//	 */
//	public static DynamicSandwichRecipeBuilder shaped(RecipeCategory category, ItemLike result) {
//		return shaped(category, result, 1);
//	}
//
//	/**
//	 * Creates a new builder for a shaped recipe.
//	 */
//	public static DynamicSandwichRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count) {
//		return new DynamicSandwichRecipeBuilder(category, result, count);
//	}
//
//	public static DynamicSandwichRecipeBuilder shaped(RecipeCategory p_251325_, ItemStack result) {
//		return new DynamicSandwichRecipeBuilder(p_251325_, result);
//	}
//
//	/**
//	 * Adds a key to the recipe pattern.
//	 */
//	public DynamicSandwichRecipeBuilder define(Character symbol, TagKey<Item> tag) {
//		return this.define(symbol, Ingredient.of(tag));
//	}
//
//	/**
//	 * Adds a key to the recipe pattern.
//	 */
//	public DynamicSandwichRecipeBuilder define(Character symbol, ItemLike item) {
//		return this.define(symbol, Ingredient.of(item));
//	}
//
//	/**
//	 * Adds a key to the recipe pattern.
//	 */
//	public DynamicSandwichRecipeBuilder define(Character symbol, Ingredient ingredient) {
//		if (this.key.containsKey(symbol)) {
//			throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
//		} else if (symbol == ' ') {
//			throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
//		} else {
//			this.key.put(symbol, ingredient);
//			return this;
//		}
//	}
//
//	/**
//	 * Adds a new entry to the patterns for this recipe.
//	 */
//	public DynamicSandwichRecipeBuilder pattern(String pattern) {
//		if (!this.rows.isEmpty() && pattern.length() != this.rows.get(0).length()) {
//			throw new IllegalArgumentException("Pattern must be the same width on every line!");
//		} else {
//			this.rows.add(pattern);
//			return this;
//		}
//	}
//
//	public DynamicSandwichRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
//		this.criteria.put(name, criterion);
//		return this;
//	}
//
//	public DynamicSandwichRecipeBuilder group(@Nullable String groupName) {
//		this.group = groupName;
//		return this;
//	}
//
//	public DynamicSandwichRecipeBuilder showNotification(boolean showNotification) {
//		this.showNotification = showNotification;
//		return this;
//	}
//
//	@Override
//	public Item getResult() {
//		return this.result;
//	}
//
//	@Override
//	public void save(RecipeOutput recipeOutput, ResourceLocation id) {
//		ShapedRecipePattern shapedrecipepattern = this.ensureValid(id);
//		Advancement.Builder advancement$builder = recipeOutput.advancement()
//				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
//				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
//		this.criteria.forEach(advancement$builder::addCriterion);
//		DynamicSandwichRecipe shapedrecipe = new DynamicSandwichRecipe(Objects.requireNonNullElse(this.group, ""),
//				RecipeBuilder.determineBookCategory(this.category), shapedrecipepattern, this.resultStack);
//		recipeOutput.accept(id, shapedrecipe,
//				advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
//	}
//
//	private ShapedRecipePattern ensureValid(ResourceLocation loaction) {
//		if (this.criteria.isEmpty()) {
//			throw new IllegalStateException("No way of obtaining recipe " + loaction);
//		} else {
//			return ShapedRecipePattern.of(this.key, this.rows);
//		}
//	}
//}

package com.lance5057.extradelight.data.recipebuilders;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookTab;

import net.minecraft.MethodsReturnNonnullByDefault;
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

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class OvenRecipeBuilder implements RecipeBuilder {
	private OvenRecipeBookTab tab;
	private final NonNullList<Ingredient> ingredients = NonNullList.create();
	private final Item result;
	private final ItemStack resultStack;
	private final int cookingTime;
	private final float experience;
	private final ItemStack container;
//	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	private OvenRecipeBuilder(ItemStack resultIn, int cookingTime, float experience, ItemStack container) {
		this.result = resultIn.getItem();
		this.resultStack = resultIn;
		this.cookingTime = cookingTime;
		this.experience = experience;
		this.container = container;
		this.tab = null;
	}

	public static OvenRecipeBuilder OvenRecipe(ItemStack mainResult, int cookingTime, float experience,
			ItemStack container) {
		return new OvenRecipeBuilder(mainResult, cookingTime, experience, container);
	}

	public OvenRecipeBuilder addIngredient(TagKey<Item> tagIn) {
		return addIngredient(Ingredient.of(tagIn));
	}

	public OvenRecipeBuilder addIngredient(TagKey<Item> itemIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			addIngredient(Ingredient.of(itemIn));
		}
		return this;
	}

	public OvenRecipeBuilder addIngredient(ItemLike itemIn) {
		return addIngredient(itemIn, 1);
	}

	public OvenRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			addIngredient(Ingredient.of(itemIn));
		}
		return this;
	}

	public OvenRecipeBuilder addIngredient(Ingredient ingredientIn) {
		return addIngredient(ingredientIn, 1);
	}

	public OvenRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
		for (int i = 0; i < quantity; ++i) {
			ingredients.add(ingredientIn);
		}
		return this;
	}

	public OvenRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
		this.criteria.put(criterionName, criterionTrigger);
		return this;
	}

	public OvenRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
		return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
	}

	public OvenRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
		this.criteria.put("has_any_ingredient",
				InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
		return this;
	}

	public OvenRecipeBuilder setRecipeBookTab(OvenRecipeBookTab tab) {
		this.tab = tab;
		return this;
	}

	public void build(RecipeOutput consumer) {
		ResourceLocation location = BuiltInRegistries.ITEM.getKey(result);
		build(consumer, ExtraDelight.MOD_ID + ":" + location.getPath());
	}

	public void build(RecipeOutput consumerIn, String save) {
		save(consumerIn, new ResourceLocation(save));
	}

//	public void build(RecipeOutput consumerIn, ResourceLocation id) {
//		ResourceLocation saveID = new ResourceLocation(id.getNamespace(), "oven/" + id.getPath());
//		if (!advancement.getCriteria().isEmpty()) {
//			advancement.parent(new ResourceLocation("recipes/root"))
//					.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
//					.rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
//			ResourceLocation advancementId = new ResourceLocation(id.getNamespace(),
//					"recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + id.getPath());
//
//			consumerIn.accept(new OvenRecipeBuilder.Result(saveID, result, count, ingredients, cookingTime, experience,
//					container, tab, advancement, advancementId));
//		} else {
//			consumerIn.accept(new OvenRecipeBuilder.Result(saveID, result, count, ingredients, cookingTime, experience,
//					container, tab));
//		}
//	}

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
		ResourceLocation recipeId = id.withPrefix("cooking/");
		Advancement.Builder advancementBuilder = output.advancement()
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(advancementBuilder::addCriterion);

//		public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab, NonNullList<Ingredient> inputItems,
//				ItemStack output, ItemStack container, float experience, int cookTime) {
		OvenRecipe recipe = new OvenRecipe("", this.tab, this.ingredients, this.resultStack, this.container,
				this.experience, this.cookingTime);
		output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/cooking/")));
	}

//	public static class Result implements RecipeOutput {
//		private final ResourceLocation id;
//		private final OvenRecipeBookTab tab;
//		private final List<Ingredient> ingredients;
//		private final Item result;
//		private final int count;
//		private final int cookingTime;
//		private final float experience;
//		private final Item container;
//		private final Advancement.Builder advancement;
//		private final ResourceLocation advancementId;
//
//		public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn,
//				int cookingTimeIn, float experienceIn, @Nullable Item containerIn, @Nullable OvenRecipeBookTab tabIn,
//				@Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
//			this.id = idIn;
//			this.tab = tabIn;
//			this.ingredients = ingredientsIn;
//			this.result = resultIn;
//			this.count = countIn;
//			this.cookingTime = cookingTimeIn;
//			this.experience = experienceIn;
//			this.container = containerIn;
//			this.advancement = advancement;
//			this.advancementId = advancementId;
//		}
//
//		public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn,
//				int cookingTimeIn, float experienceIn, @Nullable Item containerIn, @Nullable OvenRecipeBookTab tabIn) {
//			this(idIn, resultIn, countIn, ingredientsIn, cookingTimeIn, experienceIn, containerIn, tabIn, null, null);
//		}
//
//		@Override
//		public void serializeRecipeData(JsonObject json) {
//			if (tab != null) {
//				json.addProperty("recipe_book_tab", tab.toString());
//			}
//
//			JsonArray arrayIngredients = new JsonArray();
//
//			for (Ingredient ingredient : ingredients) {
//				arrayIngredients.add(ingredient.toJson());
//			}
//			json.add("ingredients", arrayIngredients);
//
//			JsonObject objectResult = new JsonObject();
//			objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
//			if (count > 1) {
//				objectResult.addProperty("count", count);
//			}
//			json.add("result", objectResult);
//
//			if (container != null) {
//				JsonObject objectContainer = new JsonObject();
//				objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(container).toString());
//				json.add("container", objectContainer);
//			}
//			if (experience > 0) {
//				json.addProperty("experience", experience);
//			}
//			json.addProperty("cookingtime", cookingTime);
//		}
//
//		@Override
//		public ResourceLocation getId() {
//			return id;
//		}
//
//		@Override
//		public RecipeSerializer<?> getType() {
//			return ExtraDelightRecipes.OVEN_SERIALIZER.get();
//		}
//
//		@Nullable
//		@Override
//		public JsonObject serializeAdvancement() {
//			return advancement != null ? advancement.serializeToJson() : null;
//		}
//
//		@Nullable
//		@Override
//		public ResourceLocation getAdvancementId() {
//			return advancementId;
//		}
//	}

}

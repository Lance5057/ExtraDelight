/*
 * package com.lance5057.compendium.recipes;
 * 
 * import java.util.function.Consumer;
 * 
 * import javax.annotation.Nullable;
 * 
 * import com.google.gson.JsonObject;
 * 
 * import net.minecraft.advancements.Advancement; import
 * net.minecraft.advancements.AdvancementRewards; import
 * net.minecraft.advancements.CriterionTriggerInstance; import
 * net.minecraft.advancements.RequirementsStrategy; import
 * net.minecraft.advancements.critereon.RecipeUnlockedTrigger; import
 * net.minecraft.core.Registry; import
 * net.minecraft.data.recipes.FinishedRecipe; import
 * net.minecraft.resources.ResourceLocation; import
 * net.minecraft.world.item.Item; import
 * net.minecraft.world.item.crafting.AbstractCookingRecipe; import
 * net.minecraft.world.item.crafting.Ingredient; import
 * net.minecraft.world.item.crafting.RecipeSerializer; import
 * net.minecraft.world.item.crafting.SimpleCookingSerializer; import
 * net.minecraft.world.level.ItemLike;
 * 
 * public class CustomCookingRecipeBuilder { private final Item result; private
 * final int count; private final Ingredient ingredient; private final float
 * experience; private final int cookingTime; private final Advancement.Builder
 * advancementBuilder = Advancement.Builder.advancement(); private String group;
 * private final SimpleCookingSerializer<?> recipeSerializer;
 * 
 * private CustomCookingRecipeBuilder(ItemLike resultIn, int countIn, Ingredient
 * ingredientIn, float experienceIn, int cookingTimeIn,
 * SimpleCookingSerializer<?> serializer) { this.result = resultIn.asItem();
 * this.ingredient = ingredientIn; this.experience = experienceIn;
 * this.cookingTime = cookingTimeIn; this.recipeSerializer = serializer;
 * this.count = countIn; }
 * 
 * public static CustomCookingRecipeBuilder cookingRecipe(Ingredient
 * ingredientIn, ItemLike resultIn, int countIn, float experienceIn, int
 * cookingTimeIn, SimpleCookingSerializer<?> serializer) { return new
 * CustomCookingRecipeBuilder(resultIn, countIn, ingredientIn, experienceIn,
 * cookingTimeIn, serializer); }
 * 
 * public static CustomCookingRecipeBuilder blastingRecipe(Ingredient
 * ingredientIn, ItemLike resultIn, int countIn, float experienceIn, int
 * cookingTimeIn) { return cookingRecipe(ingredientIn, resultIn, countIn,
 * experienceIn, cookingTimeIn, RecipeSerializer.BLASTING_RECIPE); }
 * 
 * public static CustomCookingRecipeBuilder smeltingRecipe(Ingredient
 * ingredientIn, ItemLike resultIn, int countIn, float experienceIn, int
 * cookingTimeIn) { return cookingRecipe(ingredientIn, resultIn, countIn,
 * experienceIn, cookingTimeIn, RecipeSerializer.SMELTING_RECIPE); }
 * 
 * public CustomCookingRecipeBuilder addCriterion(String name,
 * CriterionTriggerInstance criterionIn) {
 * this.advancementBuilder.addCriterion(name, criterionIn); return this; }
 * 
 * public void build(Consumer<FinishedRecipe> consumerIn) {
 * this.build(consumerIn, Registry.ITEM.getKey(this.result)); }
 * 
 * public void build(Consumer<FinishedRecipe> consumerIn, String save) {
 * ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result);
 * ResourceLocation resourcelocation1 = new ResourceLocation(save); if
 * (resourcelocation1.equals(resourcelocation)) { throw new
 * IllegalStateException("Recipe " + resourcelocation1 +
 * " should remove its 'save' argument"); } else { this.build(consumerIn,
 * resourcelocation1); } }
 * 
 * public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
 * this.validate(id); this.advancementBuilder.parent(new
 * ResourceLocation("recipes/root")) .addCriterion("has_the_recipe",
 * RecipeUnlockedTrigger.unlocked(id))
 * .rewards(AdvancementRewards.Builder.recipe(id)).requirements(
 * RequirementsStrategy.OR); consumerIn.accept( new
 * CustomCookingRecipeBuilder.CustomCookingFinishedRecipe(id, this.group == null
 * ? "" : this.group, this.ingredient, this.result, count, this.experience,
 * this.cookingTime, this.advancementBuilder, new
 * ResourceLocation(id.getNamespace(), "recipes/" +
 * this.result.getItemCategory().getRecipeFolderName() + "/" + id.getPath()),
 * this.recipeSerializer)); }
 * 
 *//**
	 * Makes sure that this obtainable.
	 */
/*
 * private void validate(ResourceLocation id) { if
 * (this.advancementBuilder.getCriteria().isEmpty()) { throw new
 * IllegalStateException("No way of obtaining recipe " + id); } }
 * 
 * public static class CustomCookingFinishedRecipe implements FinishedRecipe {
 * private final ResourceLocation id; private final String group; private final
 * Ingredient ingredient; private final Item result; private final int count;
 * private final float experience; private final int cookingTime; private final
 * Advancement.Builder advancementBuilder; private final ResourceLocation
 * advancementId; private final RecipeSerializer<? extends
 * AbstractCookingRecipe> serializer;
 * 
 * public CustomCookingFinishedRecipe(ResourceLocation idIn, String groupIn,
 * Ingredient ingredientIn, Item resultIn, int countIn, float experienceIn, int
 * cookingTimeIn, Advancement.Builder advancementBuilderIn, ResourceLocation
 * advancementIdIn, RecipeSerializer<? extends AbstractCookingRecipe>
 * serializerIn) { this.id = idIn; this.group = groupIn; this.ingredient =
 * ingredientIn; this.result = resultIn; this.count = countIn; this.experience =
 * experienceIn; this.cookingTime = cookingTimeIn; this.advancementBuilder =
 * advancementBuilderIn; this.advancementId = advancementIdIn; this.serializer =
 * serializerIn; }
 * 
 * public void serializeRecipeData(JsonObject json) { if (!this.group.isEmpty())
 * { json.addProperty("group", this.group); }
 * 
 * json.add("ingredient", this.ingredient.toJson());
 * 
 * JsonObject jsonobject1 = new JsonObject(); jsonobject1.addProperty("item",
 * Registry.ITEM.getKey(this.result).toString()); if (this.count > 1) {
 * jsonobject1.addProperty("count", this.count); }
 * 
 * json.add("result", jsonobject1);
 * 
 * json.addProperty("experience", this.experience);
 * json.addProperty("cookingtime", this.cookingTime); }
 * 
 * public RecipeSerializer<?> getType() { return this.serializer; }
 * 
 *//**
	 * Gets the ID for the recipe.
	 */
/*
 * public ResourceLocation getId() { return this.id; }
 * 
 *//**
	 * Gets the JSON for the advancement that unlocks this recipe. Null if there is
	 * no advancement.
	 */
/*
 * @Nullable public JsonObject serializeAdvancement() { return
 * this.advancementBuilder.serializeToJson(); }
 * 
 *//**
	 * Gets the ID for the advancement associated with this recipe. Should not be
	 * null if {@link #getAdvancementJson} is non-null.
	 *//*
		 * @Nullable public ResourceLocation getAdvancementId() { return
		 * this.advancementId; } } }
		 */
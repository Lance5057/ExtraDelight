package com.lance5057.extradelight.workstations.doughshaping.recipes;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class DoughShapingRecipe extends SingleItemRecipe {
	public DoughShapingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
		super(ExtraDelightRecipes.DOUGH_SHAPING.get(), ExtraDelightRecipes.DOUGH_SHAPING_SERIALIZER.get(), pId, pGroup,
				pIngredient, pResult);
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(Container pInv, Level pLevel) {
		return this.ingredient.test(pInv.getItem(0));
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightBlocks.DOUGH_SHAPING.get());
	}

	public static class Serializer implements RecipeSerializer<DoughShapingRecipe> {
		@Override
		public DoughShapingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
			String s = GsonHelper.getAsString(pJson, "group", "");
			Ingredient ingredient;
			if (GsonHelper.isArrayNode(pJson, "ingredient")) {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
			}

			String s1 = GsonHelper.getAsString(pJson, "result");
			int i = GsonHelper.getAsInt(pJson, "count");
			ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
			return new DoughShapingRecipe(pRecipeId, s1, ingredient, itemstack);
		}

		public DoughShapingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			return new DoughShapingRecipe(pRecipeId, s, ingredient, itemstack);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, DoughShapingRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
		}
	}
}
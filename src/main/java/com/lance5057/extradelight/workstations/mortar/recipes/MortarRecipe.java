package com.lance5057.extradelight.workstations.mortar.recipes;

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
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class MortarRecipe extends SingleItemRecipe {
	protected final int grinds;

	public MortarRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult, int grinds) {
		super(ExtraDelightRecipes.MORTAR.get(), ExtraDelightRecipes.MORTAR_SERIALIZER.get(), pId, pGroup, pIngredient,
				pResult);

		this.grinds = grinds;
	}
	
	public int getStirs()
	{
		return grinds;
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(Container pInv, Level pLevel) {
		return this.ingredient.test(pInv.getItem(0));
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightBlocks.MORTAR_STONE.get());
	}

	public static class Serializer implements RecipeSerializer<MortarRecipe> {
		@Override
		public MortarRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
			String s = GsonHelper.getAsString(pJson, "group", "");
			Ingredient ingredient;
			if (GsonHelper.isArrayNode(pJson, "ingredient")) {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
			}

			if (!pJson.has("result"))
				throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
			ItemStack itemstack;
			if (pJson.get("result").isJsonObject())
				itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
			else {
				String s1 = GsonHelper.getAsString(pJson, "result");
				ResourceLocation resourcelocation = new ResourceLocation(s1);
				itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
					return new IllegalStateException("Item: " + s1 + " does not exist");
				}));
			}
			
			int g = GsonHelper.getAsInt(pJson, "grinds");
			return new MortarRecipe(pRecipeId, s, ingredient, itemstack, g);
		}

		public MortarRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			int g = pBuffer.readInt();
			return new MortarRecipe(pRecipeId, s, ingredient, itemstack, g);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, MortarRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
			pBuffer.writeInt(pRecipe.grinds);
		}
	}
}
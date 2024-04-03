package com.lance5057.extradelight.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.SmokingRecipe;

public class DynamicNameCookingRecipe extends SmokingRecipe {

	public DynamicNameCookingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult,
			float pExperience, int pCookingTime) {
		super(pId, pGroup, pIngredient, pResult, pExperience, pCookingTime);
	}

	@Override
	public ItemStack assemble(Container pInv) {
		ItemStack stack = this.result.copy();
		ItemStack stackIn = pInv.getItem(0);

		if (stackIn.hasTag()) {
			CompoundTag tag = stackIn.getTag();

			stack.getOrCreateTag().put("ingredients", tag.get("ingredients"));
		}

		return stack;
	}

	public static class Serializer implements RecipeSerializer<DynamicNameCookingRecipe> {
		public DynamicNameCookingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
			String s = GsonHelper.getAsString(pJson, "group", "");
			JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(pJson, "ingredient")
					? GsonHelper.getAsJsonArray(pJson, "ingredient")
					: GsonHelper.getAsJsonObject(pJson, "ingredient"));
			Ingredient ingredient = Ingredient.fromJson(jsonelement);
			// Forge: Check if primitive string to keep vanilla or a object which can
			// contain a count field.
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
			float f = GsonHelper.getAsFloat(pJson, "experience", 0.0F);
			int i = GsonHelper.getAsInt(pJson, "cookingtime", 100);
			return new DynamicNameCookingRecipe(pRecipeId, s, ingredient, itemstack, f, i);
		}

		public DynamicNameCookingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			float f = pBuffer.readFloat();
			int i = pBuffer.readVarInt();
			return new DynamicNameCookingRecipe(pRecipeId, s, ingredient, itemstack, f, i);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, DynamicNameCookingRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
			pBuffer.writeFloat(pRecipe.experience);
			pBuffer.writeVarInt(pRecipe.cookingTime);
		}
	}
}

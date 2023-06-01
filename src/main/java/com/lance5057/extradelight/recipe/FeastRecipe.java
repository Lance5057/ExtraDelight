package com.lance5057.extradelight.recipe;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class FeastRecipe extends SingleItemRecipe {

	protected final BlockItem feast;

	public FeastRecipe(ResourceLocation pId, String pGroup, BlockItem feast, Ingredient pIngredient,
			ItemStack pResult) {
		super(ExtraDelightRecipes.FEAST.get(), ExtraDelightRecipes.FEAST_SERIALIZER.get(), pId, pGroup, pIngredient,
				pResult);
		this.feast = feast;
	}

	public BlockItem getFeast() {
		return feast;
	}
	
	public ItemStack getFeastStack() {
		return new ItemStack(feast);
	}

	@Override
	public boolean matches(Container pContainer, Level pLevel) {
		return this.ingredient.test(pContainer.getItem(0)) && this.feast == pContainer.getItem(1).getItem();
	}

	public static class Serializer implements RecipeSerializer<FeastRecipe> {
		@Override
		public FeastRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
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

			BlockItem g = (BlockItem) GsonHelper.getAsItem(pJson, "block");
			return new FeastRecipe(pRecipeId, s, g, ingredient, itemstack);
		}

		public FeastRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			BlockItem g = (BlockItem) pBuffer.readById(Registry.ITEM);
			return new FeastRecipe(pRecipeId, s, g, ingredient, itemstack);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, FeastRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
			pBuffer.writeId(Registry.ITEM, pRecipe.getFeast());
		}
	}
}

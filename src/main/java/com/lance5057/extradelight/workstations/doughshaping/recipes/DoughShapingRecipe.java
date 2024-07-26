package com.lance5057.extradelight.workstations.doughshaping.recipes;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class DoughShapingRecipe extends SingleItemRecipe {
	public DoughShapingRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult) {
		super(ExtraDelightRecipes.DOUGH_SHAPING.get(), ExtraDelightRecipes.DOUGH_SHAPING_SERIALIZER.get(), pGroup,
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
//		@Override
//		public DoughShapingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
//			String s = GsonHelper.getAsString(pJson, "group", "");
//			Ingredient ingredient;
//			if (GsonHelper.isArrayNode(pJson, "ingredient")) {
//				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
//			} else {
//				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
//			}
//
//			String s1 = GsonHelper.getAsString(pJson, "result");
//			int i = GsonHelper.getAsInt(pJson, "count");
//			ItemStack itemstack = new ItemStack(Registry.ITEM.get(ResourceLocation.fromNamespaceAndPath(s1)), i);
//			return new DoughShapingRecipe(pRecipeId, s1, ingredient, itemstack);
//		}

		private static final Codec<DoughShapingRecipe> CODEC = RecordCodecBuilder.create(inst -> inst
				.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "")
						.forGetter(DoughShapingRecipe::getGroup),

						Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),

						ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(r -> r.result))
				.apply(inst, DoughShapingRecipe::new));

		public DoughShapingRecipe fromNetwork(FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			return new DoughShapingRecipe(s, ingredient, itemstack);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, DoughShapingRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
		}

		@Override
		public Codec<DoughShapingRecipe> codec() {
			return CODEC;
		}
	}
}
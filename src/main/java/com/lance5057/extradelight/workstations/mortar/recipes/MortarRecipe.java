package com.lance5057.extradelight.workstations.mortar.recipes;

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

public class MortarRecipe extends SingleItemRecipe {
	protected final int grinds;

	public MortarRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult, int grinds) {
		super(ExtraDelightRecipes.MORTAR.get(), ExtraDelightRecipes.MORTAR_SERIALIZER.get(), pGroup, pIngredient,
				pResult);

		this.grinds = grinds;
	}

	public int getGrinds() {
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
		private static final Codec<MortarRecipe> CODEC = RecordCodecBuilder.create(inst -> inst
				.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(MortarRecipe::getGroup),

						Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),

						ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(r -> r.result),

						ExtraCodecs.strictOptionalField(Codec.INT, "grinds", 200).forGetter(MortarRecipe::getGrinds))
				.apply(inst, MortarRecipe::new));

		public MortarRecipe fromNetwork(FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			int g = pBuffer.readInt();
			return new MortarRecipe(s, ingredient, itemstack, g);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, MortarRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
			pBuffer.writeInt(pRecipe.grinds);
		}

		@Override
		public Codec<MortarRecipe> codec() {
			return CODEC;
		}
	}
}
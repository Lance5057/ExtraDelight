package com.lance5057.extradelight.workstations.doughshaping.recipes;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class DoughShapingRecipe extends SingleItemRecipe {
	public DoughShapingRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult) {
		super(ExtraDelightRecipes.DOUGH_SHAPING.get(), ExtraDelightRecipes.DOUGH_SHAPING_SERIALIZER.get(), pGroup,
				pIngredient, pResult);
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(SingleRecipeInput input, Level level) {
		return this.ingredient.test(input.item());
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightBlocks.DOUGH_SHAPING.get());
	}

	public static class Serializer implements RecipeSerializer<DoughShapingRecipe> {
		private static final MapCodec<DoughShapingRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst
						.group(Codec.STRING.optionalFieldOf("group", "").forGetter(DoughShapingRecipe::getGroup),

								Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
										.forGetter(p_301068_ -> p_301068_.ingredient),

								ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result))
						.apply(inst, DoughShapingRecipe::new));

		public static DoughShapingRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
			return new DoughShapingRecipe(s, ingredient, itemstack);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, DoughShapingRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient);
			ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result);
		}

		@Override
		public MapCodec<DoughShapingRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, DoughShapingRecipe> STREAM_CODEC = StreamCodec
				.of(DoughShapingRecipe.Serializer::toNetwork, DoughShapingRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, DoughShapingRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}
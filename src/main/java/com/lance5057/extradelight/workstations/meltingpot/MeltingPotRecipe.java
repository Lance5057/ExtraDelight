package com.lance5057.extradelight.workstations.meltingpot;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;

public class MeltingPotRecipe implements Recipe<SingleRecipeInput> {

	public Ingredient input;
	public int cooktime;
	public FluidStack result;

	public MeltingPotRecipe(Ingredient in, int time, FluidStack out) {
		this.input = in;
		this.cooktime = time;
		this.result = out;
	}

	@Override
	public boolean matches(SingleRecipeInput input, Level level) {
		return this.input.test(input.item());
	}

	@Override
	public ItemStack assemble(SingleRecipeInput input, Provider registries) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return ItemStack.EMPTY;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.MELTING_POT_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.MELTING_POT.get();
	}

	public static class Serializer implements RecipeSerializer<MeltingPotRecipe> {
		private static final MapCodec<MeltingPotRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
				.group(Ingredient.CODEC.fieldOf("ingredient").forGetter(r -> r.input),
						Codec.INT.optionalFieldOf("cooktime", 100).forGetter(r -> r.cooktime),
						FluidStack.CODEC.fieldOf("result").forGetter(r -> r.result))

				.apply(inst, MeltingPotRecipe::new));

		public static MeltingPotRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);

			int cooktime = pBuffer.readVarInt();
			FluidStack usedItem = FluidStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			return new MeltingPotRecipe(ingredient, cooktime, usedItem);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, MeltingPotRecipe pRecipe) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.input);
			pBuffer.writeVarInt(pRecipe.cooktime);
			FluidStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.result);

		}

		@Override
		public MapCodec<MeltingPotRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, MeltingPotRecipe> STREAM_CODEC = StreamCodec
				.of(MeltingPotRecipe.Serializer::toNetwork, MeltingPotRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, MeltingPotRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}

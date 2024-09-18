package com.lance5057.extradelight.workstations.mortar.recipes;

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
import net.neoforged.neoforge.fluids.FluidStack;

public class MortarRecipe extends SingleItemRecipe {
	protected final int grinds;
	protected final FluidStack fluidOut;

	public MortarRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult, FluidStack fluidResult, int grinds) {
		super(ExtraDelightRecipes.MORTAR.get(), ExtraDelightRecipes.MORTAR_SERIALIZER.get(), pGroup, pIngredient,
				pResult);

		this.grinds = grinds;
		this.fluidOut = fluidResult;
	}

	public int getGrinds() {
		return grinds;
	}

	public FluidStack getFluid() {
		return fluidOut;
	}

	@Override
	public boolean matches(SingleRecipeInput input, Level level) {
		return this.ingredient.test(input.getItem(0));
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightBlocks.MORTAR_STONE.get());
	}

	public static class Serializer implements RecipeSerializer<MortarRecipe> {
		private static final MapCodec<MortarRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst
						.group(Codec.STRING.optionalFieldOf("group", "").forGetter(MortarRecipe::getGroup),

								Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
										.forGetter(p_301068_ -> p_301068_.ingredient),

								ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),
								FluidStack.OPTIONAL_CODEC.fieldOf("fluidOut").forGetter(MortarRecipe::getFluid),
								Codec.INT.optionalFieldOf("grinds", 200).forGetter(MortarRecipe::getGrinds))
						.apply(inst, MortarRecipe::new));

		public static MortarRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
			FluidStack fluid = FluidStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			int g = pBuffer.readInt();
			return new MortarRecipe(s, ingredient, itemstack, fluid, g);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, MortarRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient);
			ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result);
			FluidStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.fluidOut);
			pBuffer.writeInt(pRecipe.grinds);
		}

		@Override
		public MapCodec<MortarRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, MortarRecipe> STREAM_CODEC = StreamCodec
				.of(MortarRecipe.Serializer::toNetwork, MortarRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, MortarRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}
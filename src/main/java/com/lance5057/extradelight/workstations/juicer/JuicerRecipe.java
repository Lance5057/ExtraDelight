package com.lance5057.extradelight.workstations.juicer;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;

public class JuicerRecipe implements Recipe<SingleRecipeInput> {
	final String group;
	public Ingredient input;
	public int cooktime;
	public FluidStack result;

	public JuicerRecipe(Ingredient in, int time, FluidStack out, String group) {
		this.group = group;
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
		return new ItemStack(Items.STICK); // Because other mods expect something regardless
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return new ItemStack(Items.STICK); // Because other mods expect something regardless
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.JUICER_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.JUICER.get();
	}

	@Override
	public String getGroup() {
		return this.group;
	}

	public static class Serializer implements RecipeSerializer<JuicerRecipe> {
		private static final MapCodec<JuicerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
				.group(Ingredient.CODEC.fieldOf("ingredient").forGetter(r -> r.input),
						Codec.INT.optionalFieldOf("cooktime", 100).forGetter(r -> r.cooktime),
						FluidStack.CODEC.fieldOf("result").forGetter(r -> r.result),
						Codec.STRING.optionalFieldOf("group", "").forGetter(JuicerRecipe::getGroup))

				.apply(inst, JuicerRecipe::new));

		public static JuicerRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);

			int cooktime = pBuffer.readVarInt();
			FluidStack usedItem = FluidStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			return new JuicerRecipe(ingredient, cooktime, usedItem, s);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, JuicerRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.input);
			pBuffer.writeVarInt(pRecipe.cooktime);
			FluidStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.result);

		}

		@Override
		public MapCodec<JuicerRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, JuicerRecipe> STREAM_CODEC = StreamCodec
				.of(JuicerRecipe.Serializer::toNetwork, JuicerRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, JuicerRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}

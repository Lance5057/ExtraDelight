package com.lance5057.extradelight.recipe;

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
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class BottleFluidRegistryRecipe implements Recipe<SimpleRecipeWrapper> {
	final String group;
	public Ingredient bottle;

	public Ingredient getBottle() {
		return bottle;
	}

	public SizedFluidIngredient getFluid() {
		return fluid;
	}

	public SizedFluidIngredient fluid;

	public BottleFluidRegistryRecipe(String group, Ingredient b, SizedFluidIngredient f) {
		this.group = group;
		this.fluid = f;
		this.bottle = b;
	}

	@Override
	public boolean matches(SimpleRecipeWrapper input, Level level) {
		return false;
	}

	@Override
	public ItemStack assemble(SimpleRecipeWrapper input, Provider registries) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return false;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return ItemStack.EMPTY;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.BOTTLE_FLUID_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.BOTTLE_FLUID_REGISTRY.get();
	}

	public static class Serializer implements RecipeSerializer<BottleFluidRegistryRecipe> {
		private static final MapCodec<BottleFluidRegistryRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst
						.group(Codec.STRING.optionalFieldOf("group", "").forGetter(BottleFluidRegistryRecipe::getGroup),
								Ingredient.CODEC.fieldOf("bottle").forGetter(BottleFluidRegistryRecipe::getBottle),
								SizedFluidIngredient.FLAT_CODEC.fieldOf("fluid")
										.forGetter(BottleFluidRegistryRecipe::getFluid))
						.apply(inst, BottleFluidRegistryRecipe::new));

		public static BottleFluidRegistryRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			SizedFluidIngredient fluid = SizedFluidIngredient.STREAM_CODEC.decode(pBuffer);
			Ingredient i = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);

			return new BottleFluidRegistryRecipe(s, i, fluid);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, BottleFluidRegistryRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			SizedFluidIngredient.STREAM_CODEC.encode(pBuffer, pRecipe.fluid);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.bottle);
		}

		@Override
		public MapCodec<BottleFluidRegistryRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, BottleFluidRegistryRecipe> STREAM_CODEC = StreamCodec
				.of(BottleFluidRegistryRecipe.Serializer::toNetwork, BottleFluidRegistryRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, BottleFluidRegistryRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}

package com.lance5057.extradelight.workstations.evaporator.recipes;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class EvaporatorRecipe implements Recipe<EvaporatorRecipeWrapper> {
	final String group;
	protected final int cookTime;

	public int getCookTime() {
		return cookTime;
	}

	public ResourceLocation getOutput() {
		return output;
	}

	final SizedFluidIngredient fluid;

	public SizedFluidIngredient getFluid() {
		return fluid;
	}

	final ResourceLocation output;
	final ResourceLocation display;

	final ItemStack outItem;

	public ResourceLocation getDisplay() {
		return display;
	}

	public EvaporatorRecipe(String pGroup, SizedFluidIngredient fluid, int time, ResourceLocation lootTable,
			ResourceLocation displayBlock, ItemStack outItem) {
		this.group = pGroup;
		this.cookTime = time;
		this.fluid = fluid;
		this.output = lootTable;
		this.display = displayBlock;
		this.outItem = outItem;
	}

	@Override
	public boolean matches(EvaporatorRecipeWrapper input, Level level) {
		return this.fluid.test(input.tank.getFluid());
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightBlocks.EVAPORATOR.get());
	}

	@Override
	public ItemStack assemble(EvaporatorRecipeWrapper input, Provider registries) {
		return this.getResultItem(registries).copy();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return outItem;
	}

	public ItemStack getResultItem() {
		return outItem;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.EVAPORATOR_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.EVAPORATOR.get();
	}

	public static class Serializer implements RecipeSerializer<EvaporatorRecipe> {
		private static final MapCodec<EvaporatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
				.group(Codec.STRING.optionalFieldOf("group", "").forGetter(EvaporatorRecipe::getGroup),
						SizedFluidIngredient.FLAT_CODEC.fieldOf("fluid").forGetter(EvaporatorRecipe::getFluid),
						Codec.INT.fieldOf("time").forGetter(EvaporatorRecipe::getCookTime),
						ResourceLocation.CODEC.fieldOf("loottable").forGetter(EvaporatorRecipe::getOutput),
						ResourceLocation.CODEC.fieldOf("display_block").forGetter(EvaporatorRecipe::getDisplay),
						ItemStack.CODEC.fieldOf("outItem").forGetter(EvaporatorRecipe::getResultItem))
				.apply(inst, EvaporatorRecipe::new));

		public static EvaporatorRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			SizedFluidIngredient fluid = SizedFluidIngredient.STREAM_CODEC.decode(pBuffer);
			int g = pBuffer.readVarInt();
			ResourceLocation r = ResourceLocation.STREAM_CODEC.decode(pBuffer);
			ResourceLocation d = ResourceLocation.STREAM_CODEC.decode(pBuffer);

			ItemStack stack = ItemStack.STREAM_CODEC.decode(pBuffer);

			return new EvaporatorRecipe(s, fluid, g, r, d, stack);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, EvaporatorRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			SizedFluidIngredient.STREAM_CODEC.encode(pBuffer, pRecipe.fluid);
			pBuffer.writeVarInt(pRecipe.cookTime);
			ResourceLocation.STREAM_CODEC.encode(pBuffer, pRecipe.output);
			ResourceLocation.STREAM_CODEC.encode(pBuffer, pRecipe.display);

			ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.outItem);
		}

		@Override
		public MapCodec<EvaporatorRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, EvaporatorRecipe> STREAM_CODEC = StreamCodec
				.of(EvaporatorRecipe.Serializer::toNetwork, EvaporatorRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, EvaporatorRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
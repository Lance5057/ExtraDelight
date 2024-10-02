package com.lance5057.extradelight.recipe;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FeastRecipe implements Recipe<SimpleRecipeWrapper> {
	protected final String group;
	protected final BlockItem feast;
	protected final Ingredient container;
	protected final ItemStack result;

	public Ingredient getContainer() {
		return container;
	}

	public FeastRecipe(String pGroup, BlockItem feast, Ingredient pIngredient, ItemStack pResult) {
		this.group = pGroup;
		this.feast = feast;
		this.container = pIngredient;
		this.result = pResult;
	}

	public FeastRecipe(String pGroup, ItemStack feast, Ingredient pIngredient, ItemStack pResult) {
		this.group = pGroup;
		this.feast = (BlockItem) feast.getItem();
		this.container = pIngredient;
		this.result = pResult;
	}

	public BlockItem getFeast() {
		return feast;
	}

	public ItemStack getFeastStack() {
		return new ItemStack(feast);
	}

	@Override
	public boolean matches(SimpleRecipeWrapper pContainer, Level pLevel) {
		return this.container.test(pContainer.getItem(1)) && this.feast == pContainer.getItem(0).getItem();
	}

	public static class Serializer implements RecipeSerializer<FeastRecipe> {

		private static final MapCodec<FeastRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst
						.group(Codec.STRING.optionalFieldOf("group", "").forGetter(FeastRecipe::getGroup),
								ItemStack.SINGLE_ITEM_CODEC.fieldOf("out").forGetter(r -> new ItemStack(r.feast)),
								Ingredient.CODEC_NONEMPTY.fieldOf("container")
										.forGetter(p_301068_ -> p_301068_.container),
								ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result))
						.apply(inst, FeastRecipe::new));

		public static FeastRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
			BlockItem g = (BlockItem) ItemStack.STREAM_CODEC.decode(pBuffer).getItem();
			return new FeastRecipe(s, g, ingredient, itemstack);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, FeastRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.container);
			ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result);
			ItemStack.STREAM_CODEC.encode(pBuffer, new ItemStack(pRecipe.getFeast()));
		}

		@Override
		public MapCodec<FeastRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, FeastRecipe> STREAM_CODEC = StreamCodec
				.of(FeastRecipe.Serializer::toNetwork, FeastRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, FeastRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

	@Override
	public ItemStack assemble(SimpleRecipeWrapper input, Provider registries) {
		return this.result;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return this.result;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.FEAST_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.FEAST.get();
	}
}

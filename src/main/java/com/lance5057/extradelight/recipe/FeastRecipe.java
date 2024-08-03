package com.lance5057.extradelight.recipe;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class FeastRecipe extends SingleItemRecipe {

	protected final BlockItem feast;

	public FeastRecipe(String pGroup, BlockItem feast, Ingredient pIngredient, ItemStack pResult) {
		super(ExtraDelightRecipes.FEAST.get(), ExtraDelightRecipes.FEAST_SERIALIZER.get(), pGroup, pIngredient,
				pResult);
		this.feast = feast;
	}

	public FeastRecipe(String pGroup, ItemStack feast, Ingredient pIngredient, ItemStack pResult) {
		super(ExtraDelightRecipes.FEAST.get(), ExtraDelightRecipes.FEAST_SERIALIZER.get(), pGroup, pIngredient,
				pResult);
		this.feast = (BlockItem) feast.getItem();
	}

	public BlockItem getFeast() {
		return feast;
	}

	public ItemStack getFeastStack() {
		return new ItemStack(feast);
	}

	@Override
	public boolean matches(SingleRecipeInput pContainer, Level pLevel) {
		return this.ingredient.test(pContainer.getItem(0)) && this.feast == pContainer.getItem(1).getItem();
	}

	public static class Serializer implements RecipeSerializer<FeastRecipe> {

		private static final MapCodec<FeastRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
				.group(Codec.STRING.optionalFieldOf("group", "").forGetter(FeastRecipe::getGroup),
						ItemStack.SINGLE_ITEM_CODEC.fieldOf("out").forGetter(r -> new ItemStack(r.feast)),
						Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),
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
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient);
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
}

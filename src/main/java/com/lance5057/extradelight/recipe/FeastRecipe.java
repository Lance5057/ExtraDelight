package com.lance5057.extradelight.recipe;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
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
	public boolean matches(Container pContainer, Level pLevel) {
		return this.ingredient.test(pContainer.getItem(0)) && this.feast == pContainer.getItem(1).getItem();
	}

	public static class Serializer implements RecipeSerializer<FeastRecipe> {

		private static final Codec<FeastRecipe> CODEC = RecordCodecBuilder.create(inst -> inst
				.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(FeastRecipe::getGroup),
						ItemStack.SINGLE_ITEM_CODEC.fieldOf("out").forGetter(r -> new ItemStack(r.feast)),
						Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),
						ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(r -> r.result))
				.apply(inst, FeastRecipe::new));

		public FeastRecipe fromNetwork(FriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			ItemStack itemstack = pBuffer.readItem();
			BlockItem g = (BlockItem) pBuffer.readItem().getItem();
			return new FeastRecipe(s, g, ingredient, itemstack);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, FeastRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			pRecipe.ingredient.toNetwork(pBuffer);
			pBuffer.writeItem(pRecipe.result);
			pBuffer.writeItem(new ItemStack(pRecipe.getFeast()));
		}

		@Override
		public Codec<FeastRecipe> codec() {
			return CODEC;
		}
	}
}

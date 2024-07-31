package com.lance5057.extradelight.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleRecipeInput;

public class DynamicNameCampfireRecipe extends CampfireCookingRecipe {

	public DynamicNameCampfireRecipe(String p_250200_, CookingBookCategory p_251114_, Ingredient p_250340_,
			ItemStack p_250306_, float p_249577_, int p_250030_) {
		super(p_250200_, p_251114_, p_250340_, p_250306_, p_249577_, p_250030_);
	}

	@Override
	public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
		ItemStack stack = this.result.copy();
		ItemStack stackIn = input.item();

		if (stackIn.hasTag()) {
			CompoundTag tag = stackIn.getTag();

			stack.getOrCreateTag().put("ingredients", tag.get("ingredients"));
		}

		return stack;
	}

	public static class Serializer implements RecipeSerializer<DynamicNameCampfireRecipe> {
		private static final MapCodec<DynamicNameCampfireRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
				.group(Codec.STRING.optionalFieldOf("group", "").forGetter(DynamicNameCampfireRecipe::getGroup),
						CookingBookCategory.CODEC.fieldOf("category").forGetter(r -> r.category()),
						Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),

						ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),
						Codec.FLOAT.optionalFieldOf("experience", 1f).forGetter(r -> r.getExperience()),
						Codec.INT.optionalFieldOf("time", 1).forGetter(r -> r.getCookingTime())

				).apply(inst, DynamicNameCampfireRecipe::new));

		public DynamicNameCampfireRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
			float f = pBuffer.readFloat();
			int i = pBuffer.readVarInt();
			return new DynamicNameCampfireRecipe(s, CookingBookCategory.MISC, ingredient, itemstack, f, i);
		}

		public void toNetwork(RegistryFriendlyByteBuf pBuffer, DynamicNameCampfireRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient);
			ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result);
			pBuffer.writeFloat(pRecipe.experience);
			pBuffer.writeVarInt(pRecipe.cookingTime);
		}

		@Override
		public MapCodec<DynamicNameCampfireRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, DynamicNameCampfireRecipe> streamCodec() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}

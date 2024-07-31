package com.lance5057.extradelight.workstations.dryingrack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DryingRackSerializer implements RecipeSerializer<DryingRackRecipe> {
	private static final MapCodec<DryingRackRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst
			.group(Codec.STRING.optionalFieldOf("group", "").forGetter(DryingRackRecipe::getGroup),

					Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(r -> r.ingredient),

					ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),

					Codec.FLOAT.optionalFieldOf("experience", 0f).forGetter(r -> r.experience),
					Codec.INT.optionalFieldOf("cookingtime", 100).forGetter(r -> r.cookingTime))
			.apply(inst, DryingRackRecipe::new));

	public static DryingRackRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
		String s = pBuffer.readUtf();
		Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
		ItemStack itemstack = ItemStack.STREAM_CODEC.decode(pBuffer);
		float f = pBuffer.readFloat();
		int i = pBuffer.readVarInt();
		return new DryingRackRecipe(s, ingredient, itemstack, f, i);
	}

	public static void toNetwork(RegistryFriendlyByteBuf pBuffer, DryingRackRecipe pRecipe) {
		pBuffer.writeUtf(pRecipe.getGroup());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.ingredient);
		ItemStack.STREAM_CODEC.encode(pBuffer, pRecipe.result);
		pBuffer.writeFloat(pRecipe.experience);
		pBuffer.writeVarInt(pRecipe.cookingTime);
	}

	public static final StreamCodec<RegistryFriendlyByteBuf, DryingRackRecipe> STREAM_CODEC = StreamCodec
			.of(DryingRackSerializer::toNetwork, DryingRackSerializer::fromNetwork);

	@Override
	public MapCodec<DryingRackRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, DryingRackRecipe> streamCodec() {
		return STREAM_CODEC;
	}

}

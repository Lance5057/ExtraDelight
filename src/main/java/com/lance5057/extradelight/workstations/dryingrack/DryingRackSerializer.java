package com.lance5057.extradelight.workstations.dryingrack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DryingRackSerializer implements RecipeSerializer<DryingRackRecipe> {

//	@Override
//	public DryingRackRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
//		String s = GsonHelper.getAsString(pJson, "group", "");
//		JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(pJson, "ingredient")
//				? GsonHelper.getAsJsonArray(pJson, "ingredient")
//				: GsonHelper.getAsJsonObject(pJson, "ingredient"));
//		Ingredient ingredient = Ingredient.fromJson(jsonelement);
//		// Forge: Check if primitive string to keep vanilla or a object which can
//		// contain a count field.
//		if (!pJson.has("result"))
//			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
//		ItemStack itemstack;
//		if (pJson.get("result").isJsonObject())
//			itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
//		else {
//			String s1 = GsonHelper.getAsString(pJson, "result");
//			ResourceLocation resourcelocation = new ResourceLocation(s1);
//			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
//				return new IllegalStateException("Item: " + s1 + " does not exist");
//			}));
//		}
//		float f = GsonHelper.getAsFloat(pJson, "experience", 0.0F);
//		int i = GsonHelper.getAsInt(pJson, "cookingtime", 100);
//		return new DryingRackRecipe(pRecipeId, s, ingredient, itemstack, f, i);
//	}

	private static final Codec<DryingRackRecipe> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(DryingRackRecipe::getGroup),

					Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(r -> r.ingredient),

					ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(r -> r.result),

					ExtraCodecs.strictOptionalField(Codec.FLOAT, "experience", 0f).forGetter(r -> r.experience),
					ExtraCodecs.strictOptionalField(Codec.INT, "cookingtime", 100).forGetter(r -> r.cookingTime))
			.apply(inst, DryingRackRecipe::new));

	@Override
	public DryingRackRecipe fromNetwork(FriendlyByteBuf pBuffer) {
		String s = pBuffer.readUtf();
		Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
		ItemStack itemstack = pBuffer.readItem();
		float f = pBuffer.readFloat();
		int i = pBuffer.readVarInt();
		return new DryingRackRecipe(s, ingredient, itemstack, f, i);
	}

	@Override
	public void toNetwork(FriendlyByteBuf pBuffer, DryingRackRecipe pRecipe) {
		pBuffer.writeUtf(pRecipe.getGroup());
		pRecipe.ingredient.toNetwork(pBuffer);
		pBuffer.writeItem(pRecipe.result);
		pBuffer.writeFloat(pRecipe.experience);
		pBuffer.writeVarInt(pRecipe.cookingTime);
	}

	@Override
	public Codec<DryingRackRecipe> codec() {
		return CODEC;
	}

}

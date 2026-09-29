package api.LanceNestAPI.src.recipes.ingredients;

import com.lance5057.butchercraft.workstations.hook.HookRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;

public class ChanceIngredient {
	Ingredient ingredient;
	int chance;
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	public int getChance() {
		return chance;
	}

	public ChanceIngredient(Ingredient in, int c) {
		this.ingredient = in;
		this.chance = c;
	}

	public static final MapCodec<ChanceIngredient> CODEC = RecordCodecBuilder
			.mapCodec(inst -> inst
					.group(Ingredient.CODEC_NONEMPTY.fieldOf("in").forGetter(ChanceIngredient::getIngredient),
							)
					.apply(inst, HookRecipe::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, HookRecipe> STREAM_CODEC = StreamCodec
			.of(ChanceIngredient::write, ChanceIngredient::read);

	private static ChanceIngredient read(RegistryFriendlyByteBuf buffer) {
		Ingredient in = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
		int c = buffer.readVarInt();

		return new ChanceIngredient(in, c);
	}

	private static void write(RegistryFriendlyByteBuf buffer, ChanceIngredient recipe) {
		Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.ingredient);
		buffer.writeVarInt(chance);
	}
}

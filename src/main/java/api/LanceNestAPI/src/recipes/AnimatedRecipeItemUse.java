package api.LanceNestAPI.src.recipes;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import api.LanceNestAPI.src.client.BlacklistedModel;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public record AnimatedRecipeItemUse(int uses, Ingredient tool, int count, boolean damageTool,
		ResourceLocation lootTable, List<RecipeMobEffect> effects, List<BlacklistedModel> model) {

	public static final Codec<AnimatedRecipeItemUse> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(Codec.INT.fieldOf("uses").forGetter(AnimatedRecipeItemUse::uses),
					Ingredient.CODEC_NONEMPTY.fieldOf("tool").forGetter(AnimatedRecipeItemUse::tool),
					Codec.INT.fieldOf("count").forGetter(AnimatedRecipeItemUse::count),
					Codec.BOOL.fieldOf("damage").forGetter(AnimatedRecipeItemUse::damageTool),
					ResourceLocation.CODEC.fieldOf("loot_table").forGetter(AnimatedRecipeItemUse::lootTable),
					Codec.list(RecipeMobEffect.CODEC).fieldOf("effects").forGetter(AnimatedRecipeItemUse::effects),
					Codec.list(BlacklistedModel.CODEC).fieldOf("models").forGetter(AnimatedRecipeItemUse::model))
			.apply(inst, AnimatedRecipeItemUse::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, AnimatedRecipeItemUse> STREAM_CODEC = StreamCodec
			.of(AnimatedRecipeItemUse::write, AnimatedRecipeItemUse::read);

	public static final AnimatedRecipeItemUse EMPTY = new AnimatedRecipeItemUse(RecipeItemUse.EMPTY, List.of(),
			BlacklistedModel.empty);

	public AnimatedRecipeItemUse(RecipeItemUse riu, List<RecipeMobEffect> e, BlacklistedModel... model) {
		this(riu.getUses(), riu.getTool(), riu.getCount(), riu.isDamageTool(), riu.getLootTable(), e, List.of(model));
	}

	private static AnimatedRecipeItemUse read(RegistryFriendlyByteBuf buffer) {
		RecipeItemUse riu = RecipeItemUse.STREAM_CODEC.decode(buffer);

//		Holder<MobEffect> e = MobEffect.STREAM_CODEC.decode(buffer);

		int size = buffer.readInt();

		BlacklistedModel[] b = new BlacklistedModel[size];

		for (int i = 0; i < size; i++)
			b[i] = BlacklistedModel.STREAM_CODEC.decode(buffer);

		int size2 = buffer.readInt();

		RecipeMobEffect[] r = new RecipeMobEffect[size2];

		for (int i = 0; i < size2; i++)
			r[i] = RecipeMobEffect.STREAM_CODEC.decode(buffer);

		return new AnimatedRecipeItemUse(riu, List.of(r), b);
	}

	private static void write(RegistryFriendlyByteBuf buffer, AnimatedRecipeItemUse r) {
		buffer.writeVarInt(r.uses);
		Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, r.tool);
		buffer.writeVarInt(r.count);
		buffer.writeBoolean(r.damageTool);
		buffer.writeResourceLocation(r.lootTable);
//		MobEffect.STREAM_CODEC.encode(buffer, r.effect);

		buffer.writeInt(r.model.size());

		for (int i = 0; i < r.model.size(); i++)
			BlacklistedModel.STREAM_CODEC.encode(buffer, r.model.get(i));

		buffer.writeInt(r.effects.size());

		for (int i = 0; i < r.effects.size(); i++)
			RecipeMobEffect.STREAM_CODEC.encode(buffer, r.effects.get(i));
	}

	public String clipboardData() {
		String s = "";
		for (BlacklistedModel bm : model) {
			s = s.concat(bm.clipboardData() + ",");
		}
		return s;
	}
}

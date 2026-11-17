package api.LanceNestAPI.src.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record RecipeMobEffect(ResourceLocation rc, int duration, int amplify, float chance) {

	public static final Codec<RecipeMobEffect> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(ResourceLocation.CODEC.fieldOf("location").forGetter(RecipeMobEffect::rc),
					Codec.INT.optionalFieldOf("duration", 100).forGetter(RecipeMobEffect::duration),
					Codec.INT.optionalFieldOf("amplification", 1).forGetter(RecipeMobEffect::amplify),
					Codec.FLOAT.optionalFieldOf("chance", 0.1f).forGetter(RecipeMobEffect::chance))
			.apply(inst, RecipeMobEffect::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, RecipeMobEffect> STREAM_CODEC = StreamCodec
			.of(RecipeMobEffect::write, RecipeMobEffect::read);

	public static RecipeMobEffect EMPTY = new RecipeMobEffect(ResourceLocation.fromNamespaceAndPath("", ""), 0, 0,
			0.0f);

	private static RecipeMobEffect read(RegistryFriendlyByteBuf buffer) {
		ResourceLocation rc = buffer.readResourceLocation();

		int dur = buffer.readInt();
		int amp = buffer.readInt();
		float chan = buffer.readFloat();

		return new RecipeMobEffect(rc, dur, amp, chan);
	}

	private static void write(RegistryFriendlyByteBuf buffer, RecipeMobEffect bm) {
		buffer.writeResourceLocation(bm.rc);
		buffer.writeInt(bm.duration);
		buffer.writeInt(bm.amplify);
		buffer.writeFloat(bm.chance);
	}
}

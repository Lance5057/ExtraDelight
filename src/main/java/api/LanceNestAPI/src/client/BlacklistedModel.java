package api.LanceNestAPI.src.client;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import api.LanceNestAPI.src.util.rendering.animation.floats.AnimationFloatTransform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public record BlacklistedModel(ResourceLocation rc, boolean isBlock, AnimationFloatTransform transform) {

	public static final Codec<BlacklistedModel> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(ResourceLocation.CODEC.fieldOf("location").forGetter(BlacklistedModel::rc),
					Codec.BOOL.optionalFieldOf("IsBlock", false).forGetter(BlacklistedModel::isBlock),
					AnimationFloatTransform.CODEC.fieldOf("animation").forGetter(BlacklistedModel::transform))
			.apply(inst, BlacklistedModel::new));

	public static final StreamCodec<RegistryFriendlyByteBuf, BlacklistedModel> STREAM_CODEC = StreamCodec
			.of(BlacklistedModel::write, BlacklistedModel::read);

	public static BlacklistedModel empty = new BlacklistedModel(ResourceLocation.fromNamespaceAndPath("", ""), true,
			AnimationFloatTransform.ZERO);

//	public BlacklistedModel(BlockState block)
//	{
//		ModelLoaderRegistry.
//		this.rc = block.
//		isBlock = true;
//	}

	public BlacklistedModel(Item item, AnimationFloatTransform anim) {
		this(BuiltInRegistries.ITEM.getKey(item), false, anim);
	}

	private static BlacklistedModel read(RegistryFriendlyByteBuf buffer) {
		ResourceLocation rc = buffer.readResourceLocation();

		boolean block = buffer.readBoolean();

		AnimationFloatTransform t = AnimationFloatTransform.STREAM_CODEC.decode(buffer);

		return new BlacklistedModel(rc, block, t);
	}

	private static void write(RegistryFriendlyByteBuf buffer, BlacklistedModel bm) {
		buffer.writeResourceLocation(bm.rc);
		buffer.writeBoolean(bm.isBlock);
		AnimationFloatTransform.STREAM_CODEC.encode(buffer, bm.transform);
	}

	public String clipboardData() {
		return "new BlacklistedModel(ResourceLocation.parse(\"" + this.rc + "\"), " + this.isBlock + ","
				+ transform.clipboardData();
	}
}

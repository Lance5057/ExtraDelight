package com.lance5057.extradelight.items.dynamicfood.api;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record DynamicItemComponent(List<String> graphics) {
	public static final Codec<DynamicItemComponent> CODEC = RecordCodecBuilder.create(p_337946_ -> p_337946_
			.group(Codec.list(Codec.STRING).fieldOf("graphics").forGetter(DynamicItemComponent::graphics))
			.apply(p_337946_, DynamicItemComponent::new));

//	public static final StreamCodec<ByteBuf, DynamicItemComponent> UNIT_STREAM_CODEC = StreamCodec
//			.unit(new DynamicItemComponent(new ArrayList<String>()));

	public static final StreamCodec<RegistryFriendlyByteBuf, DynamicItemComponent> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), DynamicItemComponent::graphics,
			DynamicItemComponent::new);

}

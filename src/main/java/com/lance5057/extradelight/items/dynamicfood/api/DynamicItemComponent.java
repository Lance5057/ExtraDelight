package com.lance5057.extradelight.items.dynamicfood.api;

import java.util.ArrayList;
import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

public record DynamicItemComponent(List<String> graphics, List<ItemStack> stacks) {
	public static final Codec<DynamicItemComponent> CODEC = RecordCodecBuilder.create(p_337946_ -> p_337946_
			.group(Codec.list(Codec.STRING).fieldOf("graphics").forGetter(DynamicItemComponent::graphics),
					Codec.list(ItemStack.CODEC).fieldOf("stacks").forGetter(DynamicItemComponent::stacks))
			.apply(p_337946_, DynamicItemComponent::new));

	public static final StreamCodec<ByteBuf, DynamicItemComponent> UNIT_STREAM_CODEC = StreamCodec
			.unit(new DynamicItemComponent(new ArrayList<String>(), new ArrayList<ItemStack>()));

	public static final StreamCodec<RegistryFriendlyByteBuf, DynamicItemComponent> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), DynamicItemComponent::graphics,
			ItemStack.LIST_STREAM_CODEC, DynamicItemComponent::stacks, DynamicItemComponent::new);

}

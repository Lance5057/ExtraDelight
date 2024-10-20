package com.lance5057.extradelight.items.components;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

public record ChillComponent(int time) implements TooltipProvider {
	public static final Codec<ChillComponent> CODEC = RecordCodecBuilder.create(p_337946_ -> p_337946_
			.group(ExtraCodecs.UNSIGNED_BYTE.fieldOf("flight_duration").forGetter(ChillComponent::time))
			.apply(p_337946_, ChillComponent::new));

	public static final StreamCodec<ByteBuf, ChillComponent> UNIT_STREAM_CODEC = StreamCodec.unit(new ChillComponent(0));
	
	public static final StreamCodec<ByteBuf, ChillComponent> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT,
			ChillComponent::time, ChillComponent::new);

	public ChillComponent(int time) {
		this.time = time;
	}

	@Override
	public void addToTooltip(TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
		tooltipAdder.accept(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.chill").append(CommonComponents.SPACE)
				.append(String.valueOf(this.time)).withStyle(ChatFormatting.AQUA));
	}

}

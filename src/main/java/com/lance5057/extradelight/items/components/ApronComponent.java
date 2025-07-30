package com.lance5057.extradelight.items.components;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.armor.ApronItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

public record ApronComponent(int style) implements TooltipProvider {
	public static final Codec<ApronComponent> CODEC = RecordCodecBuilder.create(p_337946_ -> p_337946_
			.group(Codec.INT.fieldOf("style").forGetter(ApronComponent::style)).apply(p_337946_, ApronComponent::new));

	public static final StreamCodec<ByteBuf, ApronComponent> UNIT_STREAM_CODEC = StreamCodec
			.unit(new ApronComponent(0));

	public static final StreamCodec<ByteBuf, ApronComponent> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT,
			ApronComponent::style, ApronComponent::new);

	public ApronComponent(int style) {
		this.style = style;
	}

	@Override
	public void addToTooltip(TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
		tooltipAdder.accept(
				Component.translatable(ExtraDelight.MOD_ID + ".tooltip.apron", ApronItem.STYLE.values()[this.style])
						.withStyle(ChatFormatting.AQUA));
	}

}

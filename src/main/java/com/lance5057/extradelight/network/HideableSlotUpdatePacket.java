package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.blocks.countercabinet.CounterCabinetScreen;
import com.lance5057.extradelight.blocks.sink.SinkCabinetScreen;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record HideableSlotUpdatePacket(int containerId) implements CustomPacketPayload {
	public static final Type<HideableSlotUpdatePacket> id = new CustomPacketPayload.Type<HideableSlotUpdatePacket>(
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "hideable_slot_packet"));

	public static void handle(HideableSlotUpdatePacket message, IPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.enqueueWork(new Runnable() {

				@Override
				public void run() {
					if (Minecraft.getInstance().screen != null) {
						if (Minecraft.getInstance().screen instanceof SinkCabinetScreen screen) {
							screen.switchTabs();
						}
						if (Minecraft.getInstance().screen instanceof CounterCabinetScreen screen) {
							screen.switchTabs();
						}
					}
				}

			});
		}
	}

	public static StreamCodec<ByteBuf, HideableSlotUpdatePacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,
			HideableSlotUpdatePacket::containerId, HideableSlotUpdatePacket::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return id;
	}
}

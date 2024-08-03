package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.StyleableScreen;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record StyleableMenuSyncPacket(int containerId, BlockPos pos) implements CustomPacketPayload {
	public static final Type<StyleableMenuSyncPacket> id = new CustomPacketPayload.Type<StyleableMenuSyncPacket>(
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "style_packet"));

	public StyleableMenuSyncPacket(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBlockPos());
	}

//	@Override
//	public void write(FriendlyByteBuf buf) {
//		buf.writeInt(containerId);
//		buf.writeBlockPos(pos);
//	}
//
	public static void handle(StyleableMenuSyncPacket message, IPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.enqueueWork(new Runnable() {

				@Override
				public void run() {
					if (Minecraft.getInstance().screen != null
							&& Minecraft.getInstance().screen instanceof StyleableScreen screen) {
						screen.setPos(message.pos());
					}
				}

			});
		}
	}

	public static StreamCodec<ByteBuf, StyleableMenuSyncPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,
			StyleableMenuSyncPacket::containerId, BlockPos.STREAM_CODEC, StyleableMenuSyncPacket::pos,
			StyleableMenuSyncPacket::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return id;
	}
}

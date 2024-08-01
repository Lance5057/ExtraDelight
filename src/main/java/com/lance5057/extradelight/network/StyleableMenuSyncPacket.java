package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.StyleableScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public record StyleableMenuSyncPacket(int containerId, BlockPos pos) implements CustomPacketPayload {
	public static final ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "style_packet");

	public StyleableMenuSyncPacket(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBlockPos());
	}

	@Override
	public void write(FriendlyByteBuf buf) {
		buf.writeInt(containerId);
		buf.writeBlockPos(pos);
	}

	@Override
	public ResourceLocation id() {
		return id;
	}

	public static void handle(StyleableMenuSyncPacket message, PlayPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.workHandler().execute(new Runnable() {

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

	@Override
	public Type<? extends CustomPacketPayload> type() {
		// TODO Auto-generated method stub
		return null;
	}
}

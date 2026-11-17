package api.LanceNestAPI.src.network;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayScreen;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AdvancedDisplaySyncPacket(int containerId, int index, BlockPos pos) implements CustomPacketPayload {

	public static final Type<AdvancedDisplaySyncPacket> id = new CustomPacketPayload.Type<AdvancedDisplaySyncPacket>(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "advanced_display_sync_packet"));

	public AdvancedDisplaySyncPacket(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readInt(), buf.readBlockPos());
	}

	public static void handle(AdvancedDisplaySyncPacket message, IPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.enqueueWork(new Runnable() {

				@Override
				public void run() {
					if (Minecraft.getInstance().screen != null)
						if (Minecraft.getInstance().screen instanceof AdvancedDisplayScreen screen) {
							screen.setPos(message.index(), message.pos());
						}
				}

			});
		}
	}

	public static StreamCodec<ByteBuf, AdvancedDisplaySyncPacket> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.INT, AdvancedDisplaySyncPacket::containerId, ByteBufCodecs.INT,
			AdvancedDisplaySyncPacket::index, BlockPos.STREAM_CODEC, AdvancedDisplaySyncPacket::pos,
			AdvancedDisplaySyncPacket::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return id;
	}
}
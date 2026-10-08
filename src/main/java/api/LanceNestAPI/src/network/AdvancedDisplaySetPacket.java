package api.LanceNestAPI.src.network;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayMenu;
import api.LanceNestAPI.src.util.NBTUtil;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AdvancedDisplaySetPacket(int containerId, int index, Transform transform) implements CustomPacketPayload {

	public static final Type<AdvancedDisplaySetPacket> id = new CustomPacketPayload.Type<AdvancedDisplaySetPacket>(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "display_set_packet"));

	public AdvancedDisplaySetPacket(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readInt(), NBTUtil.TRANSFORM.decode(buf));
	}

	public static void handle(AdvancedDisplaySetPacket message, IPayloadContext ctx) {
		if (ctx.flow().isServerbound()) {
			ctx.enqueueWork(new Runnable() {

				@Override
				public void run() {
					if (ctx.player().containerMenu instanceof AdvancedDisplayMenu ammm) {
						ammm.set(message.index, message.transform);
					}
				}

			});
		}
	}

	public static StreamCodec<ByteBuf, AdvancedDisplaySetPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,
			AdvancedDisplaySetPacket::containerId, ByteBufCodecs.INT, AdvancedDisplaySetPacket::index,
			NBTUtil.TRANSFORM, AdvancedDisplaySetPacket::transform, AdvancedDisplaySetPacket::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return id;
	}
}

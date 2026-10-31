package api.LanceNestAPI.src.network;

import java.util.ArrayList;
import java.util.List;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayMenu;
import api.LanceNestAPI.src.util.NBTUtil;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AdvancedDisplaySetPacket(int containerId, List<Transform> transform) implements CustomPacketPayload {

	public static final Type<AdvancedDisplaySetPacket> id = new CustomPacketPayload.Type<AdvancedDisplaySetPacket>(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "display_set_packet"));

	public AdvancedDisplaySetPacket(FriendlyByteBuf buf) {
		this(buf.readInt(), getTransforms(buf));
	}

	static List<Transform> getTransforms(FriendlyByteBuf buf) {
		int size = buf.readInt();

		List<Transform> t = new ArrayList<Transform>();
		for (int i = 0; i < size; i++) {
			t.add(NBTUtil.TRANSFORM.decode(buf));
		}

		return t;
	}

	public static void handle(AdvancedDisplaySetPacket message, IPayloadContext ctx) {
		if (ctx.flow().isServerbound()) {
			ctx.enqueueWork(new Runnable() {

				@Override
				public void run() {
					if (ctx.player().containerMenu instanceof AdvancedDisplayMenu ammm) {
						ammm.set(message.transform);
					}
				}

			});
		}
	}

	public static StreamCodec<RegistryFriendlyByteBuf, AdvancedDisplaySetPacket> STREAM_CODEC = StreamCodec
			.of(AdvancedDisplaySetPacket::write, AdvancedDisplaySetPacket::read);

	private static AdvancedDisplaySetPacket read(RegistryFriendlyByteBuf buffer) {
		int id = buffer.readVarInt();

		int size = buffer.readVarInt();

		List<Transform> t = new ArrayList<Transform>();
		for (int i = 0; i < size; i++) {
			t.add(NBTUtil.TRANSFORM.decode(buffer));
		}

		return new AdvancedDisplaySetPacket(id, t);
	}

	private static void write(RegistryFriendlyByteBuf buffer, AdvancedDisplaySetPacket r) {
		buffer.writeVarInt(r.containerId);

		buffer.writeVarInt(r.transform.size());

		for (int i = 0; i < r.transform.size(); i++) {
			NBTUtil.TRANSFORM.encode(buffer, r.transform.get(i));
		}
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return id;
	}
}

package api.LanceNestAPI.src.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class SlotToMaterial {
	int slot;

	public int getSlot() {
		return slot;
	}

	public int getMaterialLayer() {
		return materialLayer;
	}

	int materialLayer;

	public static final Codec<SlotToMaterial> CODEC = RecordCodecBuilder.create(inst -> inst
			.group(Codec.INT.fieldOf("slot").forGetter(SlotToMaterial::getSlot),
					Codec.INT.fieldOf("materialLayer").forGetter(SlotToMaterial::getMaterialLayer))
			.apply(inst, SlotToMaterial::new));

	public static final SlotToMaterial EMPTY = new SlotToMaterial(0, 0);

	public SlotToMaterial(int slot, int material) {
		this.slot = slot;
		this.materialLayer = material;
	}

	public static final StreamCodec<RegistryFriendlyByteBuf, SlotToMaterial> STREAM_CODEC = StreamCodec
			.of(SlotToMaterial::write, SlotToMaterial::read);

	private static SlotToMaterial read(RegistryFriendlyByteBuf buffer) {

		int slot = buffer.readInt();
		int mat = buffer.readInt();

		return new SlotToMaterial(slot, mat);
	}

	private static void write(RegistryFriendlyByteBuf buffer, SlotToMaterial r) {
		buffer.writeInt(r.slot);
		buffer.writeInt(r.materialLayer);
	}
}
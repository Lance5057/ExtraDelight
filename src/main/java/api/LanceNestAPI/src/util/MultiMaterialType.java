package api.LanceNestAPI.src.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class MultiMaterialType {
	public static enum MATERIAL_TYPES {
		METAL, WOOD, GEM, GLASS, TEXTILE, CERAMIC, STONE
	}

	public static final Codec<MultiMaterialType> CODEC = RecordCodecBuilder.create(p_337946_ -> p_337946_
			.group(Codec.STRING.fieldOf("current_material").forGetter(MultiMaterialType::getCurrentMaterial),
					Codec.list(Codec.STRING).fieldOf("types").forGetter(MultiMaterialType::getTypeStr))
			.apply(p_337946_, MultiMaterialType::new));

	public static final StreamCodec<ByteBuf, MultiMaterialType> STREAM_CODEC = new StreamCodec<ByteBuf, MultiMaterialType>() {
		public MultiMaterialType decode(ByteBuf p_320431_) {
			int count = p_320431_.readInt();
			List<String> s = new ArrayList<String>();

			for (int i = 0; i < count; i++)
				s.add(ByteBufCodecs.STRING_UTF8.decode(p_320431_));

			String m = ByteBufCodecs.STRING_UTF8.decode(p_320431_);

			return new MultiMaterialType(m, s);
		}

		public void encode(ByteBuf p_320258_, MultiMaterialType p_320532_) {
			ByteBufCodecs.INT.encode(p_320258_, p_320532_.types.size());

			for (int i = 0; i < p_320532_.types.size(); i++) {
				ByteBufCodecs.STRING_UTF8.encode(p_320258_, p_320532_.types.get(i).toString());
			}

			ByteBufCodecs.STRING_UTF8.encode(p_320258_, p_320532_.currentMaterial);
		}
	};

	List<MATERIAL_TYPES> types;
	String currentMaterial;

	public MultiMaterialType copy() {
		MultiMaterialType c = new MultiMaterialType();
		c.types = types;
		c.currentMaterial = currentMaterial;
		return c;
	}

	public List<MATERIAL_TYPES> getType() {
		return types;
	}

	public List<String> getTypeStr() {
		List<String> s = new ArrayList<String>();

		for (MATERIAL_TYPES t : types) {
			s.add(t.toString());
		}

		return s;
	}

	public String getCurrentMaterial() {
		return currentMaterial;
	}

	public void setCurrentMaterial(String m) {
		this.currentMaterial = m;
	}

	private MultiMaterialType() {

	}

//	public MultiMaterialType(MATERIAL_TYPES... t) {
//		types = new ArrayList<MATERIAL_TYPES>();
//		for (int i = 0; i < t.length; i++)
//			this.types.add(t[i]);
//		this.currentMaterial = CompendiumIndex.getDefaultMaterialFromType(t[0]);
//	}

	public MultiMaterialType(List<MATERIAL_TYPES> t, String m) {
		types = new ArrayList<MATERIAL_TYPES>();
		this.types = t;
//		this.types = MATERIAL_TYPES.valueOf(t);
		this.currentMaterial = m;
	}

	private MultiMaterialType(String m, List<String> t) {
		types = new ArrayList<MATERIAL_TYPES>();
		for (int i = 0; i < t.size(); i++)
			this.types.add(MATERIAL_TYPES.valueOf(t.get(i).toUpperCase()));
//		this.types = MATERIAL_TYPES.valueOf(t);
		this.currentMaterial = m;
	}

//	public MultiMaterialType(String... t) { // Turn this into a factory at some point
//		types = new ArrayList<MATERIAL_TYPES>();
//		for (String s : t)
//			this.types.add(MATERIAL_TYPES.valueOf(s.toUpperCase()));
////		this.types = MATERIAL_TYPES.valueOf(t);
//		this.currentMaterial = CompendiumIndex.getDefaultMaterialFromType(MATERIAL_TYPES.valueOf(t[0]));
//	}

	public static MultiMaterialType readNBT(CompoundTag tag, HolderLookup.Provider registries) {
		int count = tag.getInt("count");

		CompoundTag types = tag.getCompound("types");
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < count; i++)
			s.add(types.getString("type" + i));

//		String t = tag.get("type").getAsString();
		String m = tag.get("current_material").getAsString();

		return new MultiMaterialType(m, s);
	}

	public static void writeNBT(MultiMaterialType mmt, CompoundTag nbt, HolderLookup.Provider registries) {
		nbt.putInt("count", mmt.types.size());

		CompoundTag types = new CompoundTag();
		for (int i = 0; i < mmt.types.size(); i++)
			types.putString("type" + i, mmt.types.get(i).toString().toLowerCase());
		nbt.put("types", types);
		nbt.putString("current_material", mmt.currentMaterial);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.types, currentMaterial);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else {
			if (obj instanceof MultiMaterialType mm)
				if (this.types.equals(mm.types))
					if (this.currentMaterial.compareTo(mm.currentMaterial) == 0)
						return true;
			return false;
		}
	}
}

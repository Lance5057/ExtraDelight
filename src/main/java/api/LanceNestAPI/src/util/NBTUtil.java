package api.LanceNestAPI.src.util;

import org.joml.Vector3f;

import api.LanceNestAPI.src.util.rendering.animation.Transform;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.StreamCodec;

public class NBTUtil {
	public static CompoundTag Vec3FtoTag(Vector3f vec) {
		CompoundTag tag = new CompoundTag();

		tag.putFloat("x", vec.x);
		tag.putFloat("y", vec.y);
		tag.putFloat("z", vec.z);

		return tag;
	}

	public static Vector3f TagToVec3F(CompoundTag tag) {
		Vector3f vec = new Vector3f();

		vec.x = tag.getFloat("x");
		vec.y = tag.getFloat("y");
		vec.z = tag.getFloat("z");

		return vec;
	}

	public static StreamCodec<ByteBuf, Vector3f> VECTORF = new StreamCodec<ByteBuf, Vector3f>() {
		public Vector3f decode(ByteBuf p_320253_) {
			Vector3f v = new Vector3f();

			v.x = p_320253_.readFloat();
			v.y = p_320253_.readFloat();
			v.z = p_320253_.readFloat();

			return v;
		}

		public void encode(ByteBuf p_320753_, Vector3f p_330380_) {
			p_320753_.writeFloat(p_330380_.x);
			p_320753_.writeFloat(p_330380_.y);
			p_320753_.writeFloat(p_330380_.z);
		}
	};

	public static StreamCodec<ByteBuf, Transform> TRANSFORM = new StreamCodec<ByteBuf, Transform>() {
		public Transform decode(ByteBuf p_320253_) {
			Transform v = new Transform();

			v.setPosition(VECTORF.decode(p_320253_));
			v.setRotation(VECTORF.decode(p_320253_));
			v.setScale(VECTORF.decode(p_320253_));
			v.setOrigin(VECTORF.decode(p_320253_));

			return v;
		}

		public void encode(ByteBuf buf, Transform t) {
			VECTORF.encode(buf, t.getPosition());
			VECTORF.encode(buf, t.getRotation());
			VECTORF.encode(buf, t.getScale());
			VECTORF.encode(buf, t.getOrigin());
		}
	};
}

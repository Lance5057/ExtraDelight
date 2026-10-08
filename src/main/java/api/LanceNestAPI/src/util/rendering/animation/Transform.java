package api.LanceNestAPI.src.util.rendering.animation;

import org.joml.Vector3f;

import api.LanceNestAPI.src.util.NBTUtil;
import net.minecraft.nbt.CompoundTag;

public class Transform {
	Vector3f position;
	Vector3f rotation;
	Vector3f scale;
	Vector3f origin;

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f translate) {
		this.position = translate;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	public Vector3f getOrigin() {
		return origin;
	}

	public void setOrigin(Vector3f origin) {
		this.origin = origin;
	}

	public Transform() {
		this(0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0);
	}

	public Transform(Vector3f t, Vector3f r, Vector3f s, Vector3f o) {
		this.position = t;
		this.rotation = r;
		this.scale = s;
		this.origin = o;
	}

	public Transform(float tx, float ty, float tz, float rx, float ry, float rz, float sx, float sy, float sz, float ox,
			float oy, float oz) {
		this(new Vector3f(tx, ty, tz), new Vector3f(rx, ry, rz), new Vector3f(sx, sy, sz), new Vector3f(ox, oy, oz));
	}

	public static Transform readNBT(CompoundTag nbt) {
		Transform t = new Transform();

		t.setPosition(NBTUtil.TagToVec3F(nbt.getCompound("position")));
		t.setRotation(NBTUtil.TagToVec3F(nbt.getCompound("rotation")));
		t.setScale(NBTUtil.TagToVec3F(nbt.getCompound("scale")));
		t.setOrigin(NBTUtil.TagToVec3F(nbt.getCompound("origin")));

		return t;
	}

	public static CompoundTag writeNBT(Transform t) {
		CompoundTag c = new CompoundTag();

		c.put("position", NBTUtil.Vec3FtoTag(t.position));
		c.put("rotation", NBTUtil.Vec3FtoTag(t.rotation));
		c.put("scale", NBTUtil.Vec3FtoTag(t.scale));
		c.put("origin", NBTUtil.Vec3FtoTag(t.origin));

		return c;
	}
	
	public String toString()
	{
		return String.format("{ %s, %s, %s, %s }", vecToString(position), vecToString(rotation), vecToString(scale), vecToString(origin));
	}
	
	String vecToString(Vector3f v)
	{
		return String.format("[ %f, %f, %f ]", v.x, v.y, v.z);
	}

}

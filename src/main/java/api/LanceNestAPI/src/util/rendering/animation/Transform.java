package api.LanceNestAPI.src.util.rendering.animation;

import org.joml.Vector3f;

public class Transform {
	Vector3f translate;

	public Vector3f getTranslate() {
		return translate;
	}

	public void setTranslate(Vector3f translate) {
		this.translate = translate;
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

	Vector3f rotation;
	Vector3f scale;
	Vector3f origin;

	public Transform() {
		this(0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0);
	}

	public Transform(Vector3f t, Vector3f r, Vector3f s, Vector3f o) {
		this.translate = t;
		this.rotation = r;
		this.scale = s;
		this.origin = o;
	}

	public Transform(float tx, float ty, float tz, float rx, float ry, float rz, float sx, float sy, float sz, float ox,
			float oy, float oz) {
		this(new Vector3f(tx, ty, tz), new Vector3f(rx, ry, rz), new Vector3f(sx, sy, sz), new Vector3f(ox, oy, oz));
	}

}

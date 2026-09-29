package api.LanceNestAPI.src.util.rendering.animation;

import org.joml.Vector3f;

public class Transform {
	Vector3f translate;
	Vector3f rotation;
	Vector3f scale;
	Vector3f origin;

	public Transform(Vector3f t, Vector3f r, Vector3f s, Vector3f o) {
		this.translate = t;
		this.rotation = r;
		this.scale = s;
	}

	public Transform(float tx, float ty, float tz, float rx, float ry, float rz, float sx, float sy, float sz, float ox,
			float oy, float oz) {
		this(new Vector3f(tx, ty, tz), new Vector3f(rx, ry, rz), new Vector3f(sx, sy, sz), new Vector3f(ox, oy, oz));
	}

	public Vector3f getTranslateVector() {
		return translate;
	}

	public Vector3f getRotationVector() {
		return rotation;
	}

	public Vector3f getScaleVector() {
		return scale;
	}
	
	public Vector3f getOriginVector() {
		return origin;
	}

}

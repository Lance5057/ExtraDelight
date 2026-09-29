package api.LanceNestAPI.src.util.rendering;

public class AnimationUtil {
	// Static Methods
	public static float lerpf(float v0, float v1, float t) {
		return (1 - t) * v0 + t * v1;
	}
}

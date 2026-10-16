package api.LanceNestAPI.src.util;

import org.joml.Vector3f;

import com.lance5057.extradelight.ExtraDelight;

import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.Minecraft;

public class ClipboardUtil {
	public static String Vector3fToString(Vector3f v) {
		return String.format("%-1.2f,%-1.2f,%-1.2f", v.x, v.y, v.z);
	}

	public static void copyVector3f(Vector3f v) {
		String s = Vector3fToString(v);
		Minecraft.getInstance().keyboardHandler.setClipboard(s);
	}

	public static Vector3f pasteVector3f() {
		return vector3fFromString(Minecraft.getInstance().keyboardHandler.getClipboard());
	}

	public static Vector3f vector3fFromString(String s) {

		String[] f = s.split(",");
		if (f.length < 3) {
			ExtraDelight.logger.error("Failed to paste Vector3f");
			return new Vector3f(0, 0, 0);
		}

		Vector3f v = new Vector3f(0, 0, 0);

		try {
			v.x = Float.parseFloat(f[0]);
			v.y = Float.parseFloat(f[1]);
			v.z = Float.parseFloat(f[2]);
		} catch (NumberFormatException e) {
			ExtraDelight.logger.error("Failed to paste Vector3f");
			return new Vector3f(0, 0, 0);
		}

		return v;
	}

	public static void copyTransform(Transform t) {
		String s = String.format("%s %s %s %s", Vector3fToString(t.getOrigin()), Vector3fToString(t.getRotation()),
				Vector3fToString(t.getScale()), Vector3fToString(t.getPosition()));
		Minecraft.getInstance().keyboardHandler.setClipboard(s);
	}

	public static Transform pasteTransform() {
		String s = Minecraft.getInstance().keyboardHandler.getClipboard();

		String[] f = s.split(" ");

		if (f.length < 4) {
			ExtraDelight.logger.error("Failed to paste Vector3f");
			return new Transform();
		}

		Transform t = new Transform();

		t.setOrigin(vector3fFromString(f[0]));
		t.setRotation(vector3fFromString(f[1]));
		t.setScale(vector3fFromString(f[2]));
		t.setPosition(vector3fFromString(f[3]));

		return t;
	}
}

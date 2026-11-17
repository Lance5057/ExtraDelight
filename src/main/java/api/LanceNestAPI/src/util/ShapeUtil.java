package api.LanceNestAPI.src.util;

import net.minecraft.core.Direction.Axis;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapeUtil {
	// Returns first collision
	public static VoxelShape detectCollision(Vec3 point, VoxelShape... shapes) {
		for (VoxelShape s : shapes) {
			if (collides(point, s))
				return s;
		}
		return null;
	}

	public static boolean collides(Vec3 point, VoxelShape shape) {
		if (isBetween(point.x, shape.max(Axis.X), shape.min(Axis.X))) {
			if (isBetween(point.y, shape.max(Axis.Y), shape.min(Axis.Y))) {
				if (isBetween(point.z, shape.max(Axis.Z), shape.min(Axis.Z))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isBetween(double point, double big, double small) {
		return point <= big && point >= small;
	}
}

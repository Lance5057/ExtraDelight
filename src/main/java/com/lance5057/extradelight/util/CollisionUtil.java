package com.lance5057.extradelight.util;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class CollisionUtil {
	public static boolean AABBPointCollision(AABB aabb, BlockHitResult hitResult) {
		Vec3 v = hitResult.getLocation().subtract(hitResult.getBlockPos().getCenter()).add(new Vec3(0.5, 0.5, 0.5));

		if (v.x <= aabb.maxX && v.x >= aabb.minX)
			if (v.y <= aabb.maxY && v.y >= aabb.minY)
				if (v.z <= aabb.maxZ && v.z >= aabb.minZ)
					return true;
		return false;
	}
}

package com.lance5057.extradelight.util;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.Vec3i;

public class RenderUtil {
	public static void buildPlane(Vector3f pos, Vector3f size, VertexConsumer vertexConsumer, Matrix4f mat, int tint,
			Vector4f uv /* x-u0 y-u1 z-v0 w-v1 */, Vec3i vec3i, int packedOverlay, PoseStack poseStack) {
		vertexConsumer.vertex(mat, pos.x, pos.y, pos.z).color(tint).uv(uv.x, uv.w).overlayCoords(packedOverlay)
				.normal(vec3i.getX(), vec3i.getY(), vec3i.getZ()).uv2(LightTexture.FULL_BRIGHT);

		vertexConsumer.vertex(mat, pos.x + size.x, pos.y + size.y, pos.z + size.z).color(tint).uv(uv.y, uv.w)
				.overlayCoords(packedOverlay).normal(vec3i.getX(), vec3i.getY(), vec3i.getZ())
				.uv2(LightTexture.FULL_BRIGHT);

		vertexConsumer.vertex(mat, pos.x + size.x, pos.y + size.y, pos.z + size.z).color(tint).uv(uv.y, uv.z)
				.overlayCoords(packedOverlay).normal(vec3i.getX(), vec3i.getY(), vec3i.getZ())
				.uv2(LightTexture.FULL_BRIGHT);

		vertexConsumer.vertex(mat, pos.x, pos.y, pos.z).color(tint).uv(uv.x, uv.z).overlayCoords(packedOverlay)
				.normal(vec3i.getX(), vec3i.getY(), vec3i.getZ()).uv2(LightTexture.FULL_BRIGHT);
	}
}

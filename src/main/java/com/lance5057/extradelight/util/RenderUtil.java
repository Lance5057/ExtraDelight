package com.lance5057.extradelight.util;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;

public class RenderUtil {
	public static void buildPlane(Vector3f pos1,Vector3f pos2,Vector3f pos3,Vector3f pos4, VertexConsumer vertexConsumer, Matrix4f mat,
			Matrix3f normal, int tint, Vector4f uv /* x-u0 y-u1 z-v0 w-v1 */, Vec3i vec3i, int packedOverlay,
			PoseStack poseStack) {
		vertexConsumer
		.vertex(mat, pos1.x, pos1.y, pos1.z)
		.color(tint)
		.uv(uv.x, uv.w)
		.overlayCoords(packedOverlay)
		.uv2(LightTexture.FULL_BRIGHT)
		.normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ())
		.endVertex();

		vertexConsumer
		.vertex(mat, pos2.x, pos2.y, pos2.z)
		.color(tint)
		.uv(uv.y, uv.w)
		.overlayCoords(packedOverlay)
		.uv2(LightTexture.FULL_BRIGHT)
		.normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ())
		.endVertex();

		vertexConsumer
		.vertex(mat, pos3.x, pos3.y, pos3.z)
		.color(tint)
		.uv(uv.y, uv.z)
		.overlayCoords(packedOverlay)
		.uv2(LightTexture.FULL_BRIGHT)
		.normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ())
		.endVertex();

		vertexConsumer
		.vertex(mat, pos4.x, pos4.y, pos4.z)
		.color(tint)
		.uv(uv.x, uv.z)
		.overlayCoords(packedOverlay)
		.uv2(LightTexture.FULL_BRIGHT)
		.normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ())
		.endVertex();
		
//		vertexconsumer.vertex(matrix4f, 1f / 16f, 2f / 16f, 0).color(255, 255, 255, 255).uv(u0, v1)
//		.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap)
//		.normal(matrix3f, Direction.UP.getNormal().getX(), Direction.UP.getNormal().getY(),
//				Direction.UP.getNormal().getZ())
//		.endVertex();
//
//vertexconsumer.vertex(matrix4f, -1 + 2f / 16f, 2f / 16f, 0).color(255, 255, 255, 255).uv(u0, v0)
//		.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap)
//		.normal(matrix3f, Direction.UP.getNormal().getX(), Direction.UP.getNormal().getY(),
//				Direction.UP.getNormal().getZ())
//		.endVertex();
//
//vertexconsumer.vertex(matrix4f, -1 + 2f / 16f, 2f / 16f, 1).color(255, 255, 255, 255).uv(u1, v0)
//		.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap)
//		.normal(matrix3f, Direction.UP.getNormal().getX(), Direction.UP.getNormal().getY(),
//				Direction.UP.getNormal().getZ())
//		.endVertex();
//vertexconsumer.vertex(matrix4f, 1f / 16f, 2f / 16f, 1).color(255, 255, 255, 255).uv(u1, v1)
//		.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap)
//		.normal(matrix3f, Direction.UP.getNormal().getX(), Direction.UP.getNormal().getY(),
//				Direction.UP.getNormal().getZ())
//		.endVertex();
	}
}

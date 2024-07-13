package com.lance5057.extradelight.util;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

public class RenderUtil {
	public static int WHITE = 0xFFFFFFFF;

	public static Vector4f ZERO4 = new Vector4f(0, 0, 0, 0);

	public static Vector4f getUV(ResourceLocation rc) {
		TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(rc);
		return getUVFromSprite(sprite);
	}

	public static Vector4f getUVFromSprite(TextureAtlasSprite sprite) {
		return new Vector4f(sprite.getU0(), sprite.getU1(), sprite.getV0(), sprite.getV1());
	}

	public static Vector4f getUVFromSprite(TextureAtlasSprite sprite, float x, float y, float z, float w) {
		float uUnit = (sprite.getU0() - sprite.getU1()) / 16;
		float vUnit = (sprite.getV0() - sprite.getV1()) / 16;

		return new Vector4f(sprite.getU0() + (vUnit * x), sprite.getU1() + (uUnit * y), sprite.getV0() + (vUnit * z),
				sprite.getV1() + (vUnit * w));
	}

	public static void buildPlane(Vector3f pos1, Vector3f pos2, Vector3f pos3, Vector3f pos4,
			VertexConsumer vertexConsumer, Matrix4f mat, Matrix3f normal, int tint,
			Vector4f uv /* x-u0 y-u1 z-v0 w-v1 */, Vec3i vec3i, int packedOverlay, PoseStack poseStack) {
		vertexConsumer.vertex(mat, pos1.x, pos1.y, pos1.z).color(tint).uv(uv.x, uv.w).overlayCoords(packedOverlay)
				.uv2(LightTexture.FULL_BRIGHT).normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ()).endVertex();

		vertexConsumer.vertex(mat, pos2.x, pos2.y, pos2.z).color(tint).uv(uv.y, uv.w).overlayCoords(packedOverlay)
				.uv2(LightTexture.FULL_BRIGHT).normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ()).endVertex();

		vertexConsumer.vertex(mat, pos3.x, pos3.y, pos3.z).color(tint).uv(uv.y, uv.z).overlayCoords(packedOverlay)
				.uv2(LightTexture.FULL_BRIGHT).normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ()).endVertex();

		vertexConsumer.vertex(mat, pos4.x, pos4.y, pos4.z).color(tint).uv(uv.x, uv.z).overlayCoords(packedOverlay)
				.uv2(LightTexture.FULL_BRIGHT).normal(normal, vec3i.getX(), vec3i.getY(), vec3i.getZ()).endVertex();
	}

	public static void buildCubeAll(Vector3f start, Vector3f size, VertexConsumer vertexConsumer, Matrix4f mat,
			Matrix3f matrix3f, int tint, Vector4f uv, int overlay, PoseStack ps) {
		RenderUtil.buildPlane(new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.UP.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint,
				uv, Direction.EAST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.WEST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.NORTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.SOUTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.DOWN.getNormal(), overlay, ps);
	}

	public static void buildCube(Vector3f start, Vector3f size, VertexConsumer vertexConsumer, Matrix4f mat,
			Matrix3f matrix3f, int tint, int overlay, PoseStack ps, Vector4f uvUp, Vector4f uvDown, Vector4f uvNorth,
			Vector4f uvSouth, Vector4f uvEast, Vector4f uvWest) {
		RenderUtil.buildPlane(new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvDown,
				Direction.UP.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint,
				uvEast, Direction.EAST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvWest,
				Direction.WEST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvNorth,
				Direction.NORTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uvSouth,
				Direction.SOUTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uvUp,
				Direction.DOWN.getNormal(), overlay, ps);
	}

	public static void buildInvertedCube(Vector3f start, Vector3f size, VertexConsumer vertexConsumer, Matrix4f mat,
			Matrix3f matrix3f, int tint, Vector4f uv, int overlay, PoseStack ps) {
		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.DOWN.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.EAST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z + size.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.WEST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.NORTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),

				vertexConsumer, mat, matrix3f, tint, uv, Direction.SOUTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uv,
				Direction.DOWN.getNormal(), overlay, ps);
	}

	public static void buildInvertedCubePillar(Vector3f start, Vector3f size, VertexConsumer vertexConsumer,
			Matrix4f mat, Matrix3f matrix3f, int tint, Vector4f uvSides, Vector4f uvTop, Vector4f uvBottom, int overlay,
			PoseStack ps) {
		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvTop,
				Direction.DOWN.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvSides,
				Direction.EAST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z + size.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uvSides,
				Direction.WEST.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x, start.y, start.z), new Vector3f(start.x + size.x, start.y, start.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z),
				new Vector3f(start.x, start.y + size.y, start.z), vertexConsumer, mat, matrix3f, tint, uvSides,
				Direction.NORTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y, start.z + size.z),
				new Vector3f(start.x, start.y + size.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y + size.y, start.z + size.z),

				vertexConsumer, mat, matrix3f, tint, uvSides, Direction.SOUTH.getNormal(), overlay, ps);

		RenderUtil.buildPlane(new Vector3f(start.x + size.x, start.y, start.z + size.z),
				new Vector3f(start.x + size.x, start.y, start.z), new Vector3f(start.x, start.y, start.z),
				new Vector3f(start.x, start.y, start.z + size.z), vertexConsumer, mat, matrix3f, tint, uvBottom,
				Direction.DOWN.getNormal(), overlay, ps);
	}
}

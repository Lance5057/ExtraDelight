package com.lance5057.extradelight.blocks.sink;

import java.util.List;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable.Context;
import net.neoforged.neoforge.client.model.renderable.ITextureRenderTypeLookup;

public class SinkRenderer implements BlockEntityRenderer<SinkCabinetBlockEntity> {

	public SinkRenderer(BlockEntityRendererProvider.Context p_173621_) {
	}

	@Override
	public void render(SinkCabinetBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

//		ItemStack item = pBlockEntity.getItemHandler().getStackInSlot(18);
//		List<BakedQuad> copiedQuads = new ArrayList<BakedQuad>();
//
//		if (item != null && !item.isEmpty()) {
//			if (item.getItem() instanceof BlockItem b) {
//
//				for (Direction d : Direction.values()) {
//					List<BakedQuad> q = Minecraft.getInstance().getBlockRenderer()
//							.getBlockModel(b.getBlock().defaultBlockState()).getQuads(b.getBlock().defaultBlockState(),
//									d, pBlockEntity.getLevel().random, ModelData.EMPTY, RenderType.cutout());
//					if (!q.isEmpty()) {
//						copiedQuads.add(q.get(0));
//					}
//				}
//				pPoseStack.pushPose();
//				float f = pBlockEntity.getBlockState().getValue(CounterCabinetBlock.FACING).getClockWise().toYRot();
//
//				pPoseStack.translate(0.5f, 0, 0.5f);
//				pPoseStack.mulPose(Axis.YP.rotationDegrees(-f - 90));
//				pPoseStack.translate(-0.5f, 0, -0.5f);
//				this.render(pPoseStack, pBufferSource, texture -> RenderType.entityTranslucent(texture), pPackedLight,
//						pPackedOverlay, pPartialTick, new Context(ModelData.EMPTY), pBlockEntity.getBlockPos(),
//						copiedQuads);
//
//				pPoseStack.popPose();
//			}
//		}
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource,
			ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick,
			Context context, BlockPos pos, List<BakedQuad> copiedQuads) {

		float f = Mth.sqrt(1 * 1 + 2 * 2);
		float f1 = Mth.sqrt(1 * 1 + 3 * 3 + 2 * 2);
		poseStack.pushPose();
//			poseStack.translate(0, -1.05, 0);
		poseStack.translate(-0.001F, 0.001F, -0.001F);
		float scale = 1.002f;
		poseStack.scale(scale, scale, scale);

		VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(InventoryMenu.BLOCK_ATLAS));
		PoseStack.Pose posestack$pose = poseStack.last();
		Matrix4f matrix4f = posestack$pose.pose();
		Matrix3f matrix3f = posestack$pose.normal();

		if (copiedQuads != null && !copiedQuads.isEmpty()) {
			Vector4f setUVTop = RenderUtil.ZERO4;
			Vector4f setUVBottom = RenderUtil.ZERO4;
			Vector4f setUVNorth = RenderUtil.ZERO4;
			Vector4f setUVSouth = RenderUtil.ZERO4;
			Vector4f setUVEast = RenderUtil.ZERO4;
			Vector4f setUVWest = RenderUtil.ZERO4;

			// Basin
			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 1, 1, 15, 15);
			if (copiedQuads.size() > 2 && copiedQuads.get(4) != null)
				setUVEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 2, 2, 12, 5);

			RenderUtil.buildInvertedCubePillar(new Vector3f(1.02f / 16f, 12f / 16f, 1.02F / 16f),
					new Vector3f(13.96f / 16f, 4f / 16f, 12.8f / 16f), vertexconsumer, matrix4f, matrix3f,
					RenderUtil.WHITE, setUVEast, null, setUVBottom, OverlayTexture.NO_OVERLAY, poseStack);

			// Back
//			if (copiedQuads.get(0) != null)
//				setUVTop = RenderUtil.getsetUVFromSprite(copiedQuads.get(0).getSprite(), 0, 0, 0, 0);
			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 0, 2, 16);
			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
				setUVNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 0, 0, 16, 4);
			if (copiedQuads.size() > 3 && copiedQuads.get(3) != null)
				setUVSouth = RenderUtil.getUVFromSprite(copiedQuads.get(3).getSprite(), 0, 0, 16, 4);
			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
				setUVEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 0, -0, 2, 4);
			if (copiedQuads.size() > 5 && copiedQuads.get(5) != null)
				setUVWest = RenderUtil.getUVFromSprite(copiedQuads.get(5).getSprite(), 0, -0, 2, 4);

			RenderUtil.buildCube(new Vector3f(0, 14f / 16f, 14f / 16f), new Vector3f(1, 4f / 16f, 2f / 16f),
					vertexconsumer, matrix4f, matrix3f, RenderUtil.WHITE, OverlayTexture.NO_OVERLAY, poseStack, null,
					setUVBottom, setUVNorth, setUVSouth, setUVEast, setUVWest);

//			if (copiedQuads.get(0) != null)
//				setUVTop = RenderUtil.getsetUVFromSprite(copiedQuads.get(0).getSprite(), 0, 0, 8, 2);
			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 4, 2, 8);
			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
				setUVNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 4, 0, 8, 2);
			if (copiedQuads.size() > 3 && copiedQuads.get(3) != null)
				setUVSouth = RenderUtil.getUVFromSprite(copiedQuads.get(3).getSprite(), 4, 0, 8, 2);
			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
				setUVEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 4, 0, 2, 2);
			if (copiedQuads.size() > 5 && copiedQuads.get(5) != null)
				setUVWest = RenderUtil.getUVFromSprite(copiedQuads.get(5).getSprite(), 4, 0, 2, 2);

			RenderUtil.buildCube(new Vector3f(4f / 16f, 18f / 16f, 14f / 16f),
					new Vector3f(8f / 16f, 2f / 16f, 2f / 16f), vertexconsumer, matrix4f, matrix3f, RenderUtil.WHITE,
					OverlayTexture.NO_OVERLAY, poseStack, null, setUVBottom, setUVNorth, setUVSouth, setUVEast,
					setUVWest);

			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 15, 15, 1);
			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
				setUVNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 4, 0, 8, 2);
			if (copiedQuads.size() > 5 && copiedQuads.get(5) != null)
				setUVWest = RenderUtil.getUVFromSprite(copiedQuads.get(5).getSprite(), 1, 0, 15, 2);

			RenderUtil.buildCube(new Vector3f(0, 14f / 16f, 0), new Vector3f(1f / 16f, 2f / 16f, 14F / 16F),
					vertexconsumer, matrix4f, matrix3f, RenderUtil.WHITE, OverlayTexture.NO_OVERLAY, poseStack, null,
					setUVBottom, setUVNorth, null, null, setUVWest);

			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 0, 15, 1);
			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
				setUVNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 4, 0, 1, 2);
			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
				setUVEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 1, 0, 15, 2);

			RenderUtil.buildCube(new Vector3f(15f / 16f, 14f / 16f, 0), new Vector3f(1f / 16f, 2f / 16f, 14F / 16F),
					vertexconsumer, matrix4f, matrix3f, RenderUtil.WHITE, OverlayTexture.NO_OVERLAY, poseStack, null,
					setUVBottom, setUVNorth, null, setUVEast, null);

			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
				setUVBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 15, 0, 1, 14);
			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
				setUVNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 1, 0, 14, 2);
			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
				setUVEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 4, 0, 2, 2);

			RenderUtil.buildCube(new Vector3f(1f / 16f, 14f / 16f, 0), new Vector3f(14f / 16f, 2f / 16f, 1F / 16F),
					vertexconsumer, matrix4f, matrix3f, RenderUtil.WHITE, OverlayTexture.NO_OVERLAY, poseStack, null,
					setUVBottom, setUVNorth, null, null, null);

		}

		poseStack.popPose();
	}

	private void drawTop(BlockPos pos, float h, float w, float l, int lightmap, VertexConsumer vertexconsumer,
			Matrix4f matrix4f, Matrix3f matrix3f, PoseStack poseStack, List<BakedQuad> copiedQuads) {

	}

	private void drawLip(BlockPos pos, float h, float w, float l, int lightmap, VertexConsumer vertexconsumer,
			Matrix4f matrix4f, Matrix3f matrix3f, PoseStack poseStack, List<BakedQuad> copiedQuads) {
		if (copiedQuads.get(0) != null) {
			float u0 = copiedQuads.get(0).getSprite().getU0();
			float u1 = copiedQuads.get(0).getSprite().getU1();
			float v0 = copiedQuads.get(0).getSprite().getV0();
			float v1 = copiedQuads.get(0).getSprite().getV1();

			float uUnit = (u1 - u0) / 16;
			float vUnit = (v1 - v0) / 16;

			// Down

			vertexconsumer.addVertex(matrix4f, -1, 0, 0).setColor(255, 255, 255, 255).setUv(u0, v0 + vUnit * 2)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.DOWN.getNormal().getX(), Direction.DOWN.getNormal().getY(),
							Direction.DOWN.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 0, 0).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.DOWN.getNormal().getX(), Direction.DOWN.getNormal().getY(),
							Direction.DOWN.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 0, 1).setColor(255, 255, 255, 255).setUv(u1, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.DOWN.getNormal().getX(), Direction.DOWN.getNormal().getY(),
							Direction.DOWN.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1, 0, 1).setColor(255, 255, 255, 255).setUv(u1, v0 + vUnit * 2)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.DOWN.getNormal().getX(), Direction.DOWN.getNormal().getY(),
							Direction.DOWN.getNormal().getZ());

			// Up
			if (copiedQuads.get(1) != null) {
				u0 = copiedQuads.get(1).getSprite().getU0();
				u1 = copiedQuads.get(1).getSprite().getU1();
				v0 = copiedQuads.get(1).getSprite().getV0();
				v1 = copiedQuads.get(1).getSprite().getV1();
			}

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 4f / 16f, 0).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap).setNormal(Direction.UP.getNormal().getX(),
							Direction.UP.getNormal().getY(), Direction.UP.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 0).setColor(255, 255, 255, 255).setUv(u0, v0 + vUnit * 2)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap).setNormal(Direction.UP.getNormal().getX(),
							Direction.UP.getNormal().getY(), Direction.UP.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 1).setColor(255, 255, 255, 255).setUv(u1, v0 + vUnit * 2)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap).setNormal(Direction.UP.getNormal().getX(),
							Direction.UP.getNormal().getY(), Direction.UP.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 4f / 16f, 1).setColor(255, 255, 255, 255).setUv(u1, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap).setNormal(Direction.UP.getNormal().getX(),
							Direction.UP.getNormal().getY(), Direction.UP.getNormal().getZ());

			// North
			if (copiedQuads.get(2) != null) {
				u0 = copiedQuads.get(2).getSprite().getU0();
				u1 = copiedQuads.get(2).getSprite().getU1();
				v0 = copiedQuads.get(2).getSprite().getV0();
				v1 = copiedQuads.get(2).getSprite().getV1();
			}

			vertexconsumer.addVertex(matrix4f, -14f / 16f, 0, 1).setColor(255, 255, 255, 255).setUv(u0, v1)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.NORTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -14f / 16f, 0, 0).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.NORTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -14f / 16f, 4f / 16f, 0).setColor(255, 255, 255, 255)
					.setUv(u0 + uUnit * 4, v0).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.NORTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -14f / 16f, 4f / 16f, 1).setColor(255, 255, 255, 255)
					.setUv(u0 + uUnit * 4, v1).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.NORTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			// South
			if (copiedQuads.get(3) != null) {
				u0 = copiedQuads.get(3).getSprite().getU0();
				u1 = copiedQuads.get(3).getSprite().getU1();
				v0 = copiedQuads.get(3).getSprite().getV0();
				v1 = copiedQuads.get(3).getSprite().getV1();
			}

			vertexconsumer.addVertex(matrix4f, -1, 0, 0).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.SOUTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1, 0, 1).setColor(255, 255, 255, 255).setUv(u0, v1)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.SOUTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 1).setColor(255, 255, 255, 255).setUv(u0 + uUnit * 4, v1)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.SOUTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 0).setColor(255, 255, 255, 255).setUv(u0 + uUnit * 4, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.NORTH.getNormal().getX(), Direction.SOUTH.getNormal().getY(),
							Direction.NORTH.getNormal().getZ());

			// left
			if (copiedQuads.get(4) != null) {
				u0 = copiedQuads.get(4).getSprite().getU0();
				u1 = copiedQuads.get(4).getSprite().getU1();
				v0 = copiedQuads.get(4).getSprite().getV0();
				v1 = copiedQuads.get(4).getSprite().getV1();
			}

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 0, 0).setColor(255, 255, 255, 255)
					.setUv(u0, v0 + uUnit * 2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.WEST.getNormal().getX(), Direction.WEST.getNormal().getY(),
							Direction.WEST.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1, 0, 0).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.WEST.getNormal().getX(), Direction.WEST.getNormal().getY(),
							Direction.WEST.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 0).setColor(255, 255, 255, 255).setUv(u0 + uUnit * 4, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.WEST.getNormal().getX(), Direction.WEST.getNormal().getY(),
							Direction.WEST.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 4f / 16f, 0).setColor(255, 255, 255, 255)
					.setUv(u0 + uUnit * 4, v0 + uUnit * 2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.WEST.getNormal().getX(), Direction.WEST.getNormal().getY(),
							Direction.WEST.getNormal().getZ());

			// right
			if (copiedQuads.get(5) != null) {
				u0 = copiedQuads.get(5).getSprite().getU0();
				u1 = copiedQuads.get(5).getSprite().getU1();
				v0 = copiedQuads.get(5).getSprite().getV0();
				v1 = copiedQuads.get(5).getSprite().getV1();
			}
			vertexconsumer.addVertex(matrix4f, -1, 0, 1).setColor(255, 255, 255, 255).setUv(u0, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.EAST.getNormal().getX(), Direction.EAST.getNormal().getY(),
							Direction.EAST.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 0, 1).setColor(255, 255, 255, 255)
					.setUv(u0, v0 + uUnit * 2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.EAST.getNormal().getX(), Direction.EAST.getNormal().getY(),
							Direction.EAST.getNormal().getZ());

			vertexconsumer.addVertex(matrix4f, -1 + 2f / 16f, 4f / 16f, 1).setColor(255, 255, 255, 255)
					.setUv(u0 + uUnit * 4, v0 + uUnit * 2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.EAST.getNormal().getX(), Direction.EAST.getNormal().getY(),
							Direction.EAST.getNormal().getZ());
			vertexconsumer.addVertex(matrix4f, -1, 4f / 16f, 1).setColor(255, 255, 255, 255).setUv(u0 + uUnit * 4, v0)
					.setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmap)
					.setNormal(Direction.EAST.getNormal().getX(), Direction.EAST.getNormal().getY(),
							Direction.EAST.getNormal().getZ());

		}
	}

}

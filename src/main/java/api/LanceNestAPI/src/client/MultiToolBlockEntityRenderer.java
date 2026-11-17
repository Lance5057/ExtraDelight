package api.LanceNestAPI.src.client;

import com.mojang.blaze3d.vertex.PoseStack;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

public abstract class MultiToolBlockEntityRenderer<T extends MultiToolRecipeStation<?>>
		implements BlockEntityRenderer<T> {

	@Override
	public final void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource,
			int packedLight, int packedOverlay) {
		this.renderInventory(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
	}

	public abstract void renderInventory(T blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay);

//	public void renderDebug(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource,
//			int packedLight, int packedOverlay) {
//		for (BlockPos p : blockEntity.toolSuppliers) {
//
//			VertexConsumer vertexConsumer = bufferSource.getBuffer(Sheets.translucentCullBlockSheet());
//			Matrix4f mat = poseStack.last().pose();
//			Matrix3f matrix3f = poseStack.last().normal();
//
//			poseStack.pushPose();
//
//			Vec3 v = p.subtract(blockEntity.getBlockPos()).getCenter();
//
//			RenderUtil.buildPlane(new Vec3(0.5, 1.2, 0.5), new Vec3(0.5, 1.1, 0.5), new Vec3(v.x, v.y + 0.6, v.z),
//					new Vec3(v.x, v.y + 0.7, v.z), vertexConsumer, mat, matrix3f, 0xFFFFFFFF,
//					RenderUtil.getUV(Compendium.modLoc("block/gizmo")), Direction.UP.getNormal(), LightTexture.FULL_SKY,
//					packedOverlay, poseStack);
//
//			RenderUtil.buildPlane(new Vec3(0.5, 1.2, 0.5), new Vec3(v.x, v.y + 0.7, v.z), new Vec3(v.x, v.y + 0.6, v.z),
//					new Vec3(0.5, 1.1, 0.5), vertexConsumer, mat, matrix3f, 0xFFFFFFFF,
//					RenderUtil.getUV(Compendium.modLoc("block/gizmo")), Direction.UP.getNormal(), LightTexture.FULL_SKY,
//					packedOverlay, poseStack);
//			poseStack.popPose();
//
//		}
//	}
}

package com.lance5057.extradelight.displays.knife;

import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;

public class KnifeBlockRenderer implements BlockEntityRenderer<KnifeBlockEntity> {

	public KnifeBlockRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(KnifeBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler r = pBlockEntity.getItemHandler();

		Direction dir = pBlockEntity.getBlockState().getValue(KnifeBlock.FACING);

		renderItem(0, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
				0.33f, 0.65f, 0.35f, 0, 1.570796f, 3.141593f);
		renderItem(1, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir, 0.5f,
				0.65f, 0.35f, 0, 1.570796f, 3.141593f);
		renderItem(2, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
				0.67f, 0.65f, 0.35f, 0, 1.570796f, 3.141593f);
		renderItem(3, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
				0.33f, 0.35f, 0.125f, -1.570796f+0.7853982f, 0, 3.141593f+0.7853982f);

	}

	private void renderItem(int slot, KnifeBlockEntity pBlockEntity, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemRenderer itemRenderer,
			@NotNull IItemHandler r, Direction dir, float x, float y, float z, float rx, float ry, float rz) {
		pPoseStack.pushPose();
		ItemStack item = r.getStackInSlot(slot);

		if (!item.isEmpty()) {
			BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
			pPoseStack.pushPose();

			pPoseStack.translate(0.5f, 0, 0.5f);
			pPoseStack.mulPose(Axis.YP.rotationDegrees(-dir.getClockWise().toYRot() - 90));
			pPoseStack.translate(x - 0.5f, y, z - 0.5f);
			pPoseStack.mulPose(new Quaternionf().rotateXYZ(rx, ry, rz));
			float uniscale = 1f;
			pPoseStack.scale(uniscale, uniscale, uniscale);
			itemRenderer.render(item, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
					pPackedOverlay, bakedmodel);
			pPoseStack.popPose();
		}
		pPoseStack.popPose();
	}

	@Override
	public boolean shouldRenderOffScreen(KnifeBlockEntity pBlockEntity) {
		return true;
	}

	@Override
	public int getViewDistance() {
		return 64;
	}

	@Override
	public boolean shouldRender(KnifeBlockEntity pBlockEntity, Vec3 pCameraPos) {
		// return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos,
		// (double) this.getViewDistance());
		return true;
	}
}

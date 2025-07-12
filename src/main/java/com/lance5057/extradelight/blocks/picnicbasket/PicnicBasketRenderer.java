package com.lance5057.extradelight.blocks.picnicbasket;

import org.joml.Quaternionf;

import com.lance5057.extradelight.displays.candybowl.CandyBowlEntity;
import com.mojang.blaze3d.vertex.PoseStack;

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

public class PicnicBasketRenderer implements BlockEntityRenderer<PicnicBasketBlockEntity> {

	public PicnicBasketRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(PicnicBasketBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler itemInteractionHandler = pBlockEntity.getItems();

		Direction dir = pBlockEntity.getBlockState().getValue(PicnicBasketBlock.FACING);

		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(0), 0.4f, 0.2f, 0.3f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+180)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(1), 0.4f, 0.21f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+15)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(2), 0.8f, 0.2f, 0.3f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+150)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(3), 0.8f, 0.21f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+0)));
		
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(4), 0.2f, 0.25f, 0.5f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), (float) Math.toRadians(15) ,(float) Math.toRadians(dir.toYRot()+180)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(5), 0.2f, 0.231f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90),  (float) Math.toRadians(15) ,(float) Math.toRadians(dir.toYRot()+15)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(6), 1f, 0.25f, 0.3f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+10)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(7), 0.9f, 0.251f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+60)));
		
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(8), 0.4f, 0.3f, 0.3f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+180)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(9), 0.4f, 0.31f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+15)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(10), 0.8f, 0.3f, 0.3f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+150)));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(11), 0.8f, 0.31f, 0.7f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ( (float) Math.toRadians(90), 0 ,(float) Math.toRadians(dir.toYRot()+0)));
	}
	
	void renderItem(PicnicBasketBlockEntity pBlockEntity, ItemRenderer itemRenderer, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemStack stack, float x, float y,
			float z, Quaternionf rot, Quaternionf rot2) {
		if (!stack.isEmpty()) {
			pPoseStack.pushPose();
			BakedModel bakedmodel = itemRenderer.getModel(stack, pBlockEntity.getLevel(), null, 0);
			float uniscale = 0.5f;
			pPoseStack.scale(uniscale, uniscale, uniscale);

			pPoseStack.translate(0.5f, 0, 0.5f);

			pPoseStack.mulPose(rot);
			pPoseStack.translate(x, y, z);
			pPoseStack.mulPose(rot2);

			itemRenderer.render(stack, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
					pPackedOverlay, bakedmodel);

			pPoseStack.popPose();
		}
	}

	@Override
	public boolean shouldRenderOffScreen(PicnicBasketBlockEntity pBlockEntity) {
		return true;
	}

	@Override
	public int getViewDistance() {
		return 64;
	}

	@Override
	public boolean shouldRender(PicnicBasketBlockEntity pBlockEntity, Vec3 pCameraPos) {
		// return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos,
		// (double) this.getViewDistance());
		return true;
	}
}
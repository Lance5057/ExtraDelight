package com.lance5057.extradelight.displays.candybowl;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

public class CandyBowlRenderer implements BlockEntityRenderer<CandyBowlEntity> {

	public CandyBowlRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(CandyBowlEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler itemInteractionHandler = pBlockEntity.getItemHandler();

		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(0), -0.1f, 0, -0.025f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ(25, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(1), 0.1f, 0, -0.025f, new Quaternionf().rotateXYZ(0, 90, 0),
				new Quaternionf().rotateXYZ(25, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(2), 0.1f, 0, 0.125f, new Quaternionf().rotateXYZ(0, 180, 0),
				new Quaternionf().rotateXYZ(25, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(3), -0.1f, 0, 0.125f, new Quaternionf().rotateXYZ(0, 270, 0),
				new Quaternionf().rotateXYZ(25, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(4), -0.05f, 0.1f, -0.1f, new Quaternionf().rotateXYZ(0, 45, 0),
				new Quaternionf().rotateXYZ(35, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(5), 0.1f, 0.1f, 0.0f, new Quaternionf().rotateXYZ(0, 135, 0),
				new Quaternionf().rotateXYZ(35, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(6), 0.05f, 0.1f, 0.1f, new Quaternionf().rotateXYZ(0, 215, 0),
				new Quaternionf().rotateXYZ(35, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(7), -0.1f, 0.1f, 0.0f, new Quaternionf().rotateXYZ(0, 305, 0),
				new Quaternionf().rotateXYZ(35, 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(8), -0.1f, 0.25f, -0.2f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ(90, 0, 0));

	}

	void renderItem(CandyBowlEntity pBlockEntity, ItemRenderer itemRenderer, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemStack stack, float x, float y,
			float z, Quaternionf rot, Quaternionf rot2) {
		if (!stack.isEmpty()) {
			pPoseStack.pushPose();
			BakedModel bakedmodel = itemRenderer.getModel(stack, pBlockEntity.getLevel(), null, 0);
			float uniscale = 1.2f;
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
}

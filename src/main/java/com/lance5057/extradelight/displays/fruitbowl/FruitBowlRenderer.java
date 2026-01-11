package com.lance5057.extradelight.displays.fruitbowl;

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

public class FruitBowlRenderer implements BlockEntityRenderer<FruitBowlBlockEntity> {

	public FruitBowlRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(FruitBowlBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler itemInteractionHandler = pBlockEntity.getItemHandler();

		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(0), -0.0f, 0.25f, 0.23f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(1), -0.0f, 0.25f, 0.23f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(90), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(2), -0.0f, 0.25f, 0.23f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(180), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(3), -0.0f, 0.25f, 0.23f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(270), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(4), -0.0f, 0.25f, 0.15f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(45), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(5), -0.0f, 0.25f, 0.15f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(135), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(6), -0.0f, 0.25f, 0.15f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(225), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(7), -0.0f, 0.25f, 0.15f,
				new Quaternionf().rotateXYZ(0, (float) Math.toRadians(315), 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, 0));
		this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay,
				itemInteractionHandler.getStackInSlot(8), -0.0f, 0.25f, -0.05f, new Quaternionf().rotateXYZ(0, 0, 0),
				new Quaternionf().rotateXYZ((float) Math.toRadians(90), 0, 0));

	}

	void renderItem(FruitBowlBlockEntity pBlockEntity, ItemRenderer itemRenderer, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemStack stack, float x, float y,
			float z, Quaternionf rot, Quaternionf rot2) {
		if (!stack.isEmpty()) {
			pPoseStack.pushPose();
			BakedModel bakedmodel = itemRenderer.getModel(stack, pBlockEntity.getLevel(), null, 0);
			

			pPoseStack.translate(0.5f, 0, 0.5f);

			pPoseStack.mulPose(rot);
			pPoseStack.translate(x, y, z);
			pPoseStack.mulPose(rot2);
			
			float uniscale = 0.75f;
			pPoseStack.scale(uniscale, uniscale, uniscale);

			itemRenderer.render(stack, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
					pPackedOverlay, bakedmodel);

			pPoseStack.popPose();
		}
	}
}
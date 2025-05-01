package com.lance5057.extradelight.blocks.jardisplay;

import org.joml.Quaternionf;

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
import net.neoforged.neoforge.items.IItemHandler;

public class JarDisplayRenderer implements BlockEntityRenderer<JarDisplayBlockEntity> {
	public JarDisplayRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(JarDisplayBlockEntity pBlockEntity, float partialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler itemInteractionHandler = pBlockEntity.getItems();

		Direction dir = pBlockEntity.getBlockState().getValue(JarDisplayBlock.FACING);

		pPoseStack.pushPose();

		float xoff = 0;
		float yoff = 0;
		float zoff = 0;

		for (int i = 0; i < JarDisplayBlockEntity.NUM_SLOTS; i++) {
//			xoff = (i % 2) * 0.5f;
//			if (i % 4 == 0) {
//				zoff += 0.5f;
//			}

			ItemStack item = itemInteractionHandler.getStackInSlot(i);

			if (!item.isEmpty()) {
				BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
				pPoseStack.pushPose();
				pPoseStack.translate(0.5f, 0, 0.5f);
				pPoseStack.mulPose(new Quaternionf().rotateXYZ(0, (float) Math.toRadians(-dir.toYRot()), 0));
				pPoseStack.translate(xoff + 0.25, yoff - 0.25, zoff + 0.25);

				if (i == 3)
					pPoseStack.translate(-0.5, 0.0, -0.5);
				if (i == 1)
					pPoseStack.translate(-0.5, 0.0, 0.0);
				if (i == 2)
					pPoseStack.translate(0, 0.0, -0.5);

//				pPoseStack.mulPose(new Quaternionf().rotateXYZ((float) Math.toRadians(-80), 0, 0));
				float uniscale = 4f;
				pPoseStack.scale(uniscale, uniscale, uniscale);
				itemRenderer.render(item, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
						pPackedOverlay, bakedmodel);
				pPoseStack.popPose();
			}
		}
		pPoseStack.popPose();
	}

}

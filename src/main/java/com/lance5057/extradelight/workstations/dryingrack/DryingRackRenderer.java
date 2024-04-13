package com.lance5057.extradelight.workstations.dryingrack;

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
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class DryingRackRenderer implements BlockEntityRenderer<DryingRackBlockEntity> {

	public DryingRackRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(DryingRackBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandlerModifiable inv = pBlockEntity.getItemHandler();
		for (int i = 0; i < DryingRackBlockEntity.NUM_SLOTS; i++) {
			ItemStack item = inv.getStackInSlot(i);

			if (!item.isEmpty()) {
				BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
				pPoseStack.pushPose();

				pPoseStack.translate(0.5f, 0.45f + (i > 3 ? 0.5f : 0), 0.5f);

				pPoseStack.mulPose(new Quaternionf().rotateXYZ(0, 135, 0));
				pPoseStack.mulPose(new Quaternionf().rotateXYZ(0, 90 * (i % 4), 0));
				pPoseStack.mulPose(new Quaternionf().rotateXYZ(90, 0, 0));
				pPoseStack.translate(0.25f, 0, 0);

				float uniscale = 0.65f;
				pPoseStack.scale(uniscale, uniscale, uniscale);
				itemRenderer.render(item, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
						pPackedOverlay, bakedmodel);
				pPoseStack.popPose();
			}
		}
	}

}

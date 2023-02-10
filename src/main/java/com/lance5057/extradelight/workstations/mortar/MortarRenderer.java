package com.lance5057.extradelight.workstations.mortar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class MortarRenderer implements BlockEntityRenderer<MortarBlockEntity> {

	public MortarRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(MortarBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity
				.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

		itemInteractionHandler.ifPresent(inv -> {
			ItemStack item = inv.getStackInSlot(0);

			if (!item.isEmpty()) {
				BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
				pPoseStack.pushPose();

				pPoseStack.translate(0.5f, 0.45f, 0.5f);

				pPoseStack.mulPose(new Quaternion(90, 0, 0, true));
				pPoseStack.translate(0.25f, 0, 0);

				float uniscale = 0.65f;
				pPoseStack.scale(uniscale, uniscale, uniscale);
				itemRenderer.render(item, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
						pPackedLight, pPackedOverlay, bakedmodel);
				pPoseStack.popPose();
			}
		});
	}

}

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
			int g = pBlockEntity.getGrind();

			if (!item.isEmpty()) {
				for (int i = 0; i < item.getCount(); i++) {
					BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
					pPoseStack.pushPose();

					pPoseStack.translate(0.5f, 0.15f, 0.5f);
					pPoseStack.mulPose(new Quaternion(0, (90 * i) + (45 * g), 0, true));
					pPoseStack.mulPose(new Quaternion(45, 0, 45, true));
					pPoseStack.translate(0.15f, 0, 0);

					float scale = 1 - (g * 0.2f);
					pPoseStack.scale(scale, scale, scale);

					float uniscale = 0.65f;
					pPoseStack.scale(uniscale, uniscale, uniscale);
					itemRenderer.render(item, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
							pPackedLight, pPackedOverlay, bakedmodel);
					pPoseStack.popPose();
				}
			}
		});
	}

}

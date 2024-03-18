package com.lance5057.extradelight.displays.candybowl;

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
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
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

		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER);

		itemInteractionHandler.ifPresent(r -> {

			
			
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(0), -0.1f, 0, -0.025f, new Quaternion(0,0,0,true), new Quaternion(25,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(1), 0.1f, 0, -0.025f, new Quaternion(0,90,0,true), new Quaternion(25,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(2), 0.1f, 0, 0.125f, new Quaternion(0,180,0,true), new Quaternion(25,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(3), -0.1f, 0, 0.125f, new Quaternion(0,270,0,true), new Quaternion(25,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(4), -0.05f, 0.1f, -0.1f, new Quaternion(0,45,0,true), new Quaternion(35,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(5), 0.1f, 0.1f, 0.0f, new Quaternion(0,135,0,true), new Quaternion(35,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(6), 0.05f, 0.1f, 0.1f, new Quaternion(0,215,0,true), new Quaternion(35,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(7), -0.1f, 0.1f, 0.0f, new Quaternion(0,305,0,true), new Quaternion(35,0,0,true));
			this.renderItem(pBlockEntity, itemRenderer, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, r.getStackInSlot(8), -0.1f, 0.25f, -0.2f, new Quaternion(0,0,0,true), new Quaternion(90,0,0,true));
			
			
		});
	}

	void renderItem(CandyBowlEntity pBlockEntity, ItemRenderer itemRenderer, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemStack stack, float x, float y,
			float z, Quaternion rot, Quaternion rot2) {
		if (!stack.isEmpty()) {
			pPoseStack.pushPose();
			BakedModel bakedmodel = itemRenderer.getModel(stack, pBlockEntity.getLevel(), null, 0);
			float uniscale = 1.2f;
			pPoseStack.scale(uniscale, uniscale, uniscale);
			
			pPoseStack.translate(0.5f, 0, 0.5f);
			
			pPoseStack.mulPose(rot);
			pPoseStack.translate(x, y, z);
			pPoseStack.mulPose(rot2);
			
			itemRenderer.render(stack, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
					pPackedLight, pPackedOverlay, bakedmodel);
			
			pPoseStack.popPose();
		}
	}
}

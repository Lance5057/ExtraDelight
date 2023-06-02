package com.lance5057.extradelight.displays.spice;

import org.jetbrains.annotations.NotNull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class SpiceRackRenderer implements BlockEntityRenderer<SpiceRackEntity> {

	public SpiceRackRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(SpiceRackEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		LazyOptional<IItemHandler> itemInteractionHandler = pBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER);

		itemInteractionHandler.ifPresent(r -> {

			Direction dir = pBlockEntity.getBlockState().getValue(SpiceRackBlock.FACING);

			renderItem(0, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
					0.2f, 0.55f, 0.15f, 0, 0, 0);
			renderItem(1, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
					0.4f, 0.55f, 0.125f, 0, 0, 0);
			renderItem(2, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
					0.6f, 0.55f, 0.15f, 0, 0, 0);
			renderItem(3, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, itemRenderer, r, dir,
					0.8f, 0.55f, 0.125f, 0, 0, 0);
		});
	}

	private void renderItem(int slot, SpiceRackEntity pBlockEntity, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, ItemRenderer itemRenderer,
			@NotNull IItemHandler r, Direction dir, float x, float y, float z, float rx, float ry, float rz) {
		pPoseStack.pushPose();
		ItemStack item = r.getStackInSlot(slot);

		if (!item.isEmpty()) {
			BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
			pPoseStack.pushPose();
			float uniscale = 0.75f; 

			pPoseStack.translate(0.5f, 0, 0.5f);
			pPoseStack.mulPose(new Quaternion(0, -dir.toYRot(), 0, true));
			pPoseStack.translate(x-0.5f, y, z-0.5f);
			pPoseStack.mulPose(new Quaternion(rx, ry, rz, true));

			pPoseStack.scale(uniscale, uniscale, uniscale);
			itemRenderer.render(item, ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource,
					pPackedLight, pPackedOverlay, bakedmodel);
			pPoseStack.popPose();
		}
		pPoseStack.popPose();
	}

	@Override
	public boolean shouldRenderOffScreen(SpiceRackEntity pBlockEntity) {
		return true;
	}

	@Override
	public int getViewDistance() {
		return 64;
	}

	@Override
	public boolean shouldRender(SpiceRackEntity pBlockEntity, Vec3 pCameraPos) {
		// return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos,
		// (double) this.getViewDistance());
		return true;
	}
}

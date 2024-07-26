package com.lance5057.extradelight.aesthetics.block.cornhuskdoll;

import org.joml.Quaternionf;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable;
import net.neoforged.neoforge.client.model.renderable.IRenderable;

public class CornHuskDollRenderer implements BlockEntityRenderer<CornHuskDollBlockEntity> {

	final ResourceLocation model_down = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "extra/corn_husk_doll");
	final ResourceLocation model_up = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "extra/corn_husk_doll_hang");

	public CornHuskDollRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(CornHuskDollBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

		BlockState blockstate = pBlockEntity.getBlockState();
		float f1 = 22.5F * blockstate.getValue(CornHuskDollBlock.FACING);
		boolean f2 = blockstate.getValue(CornHuskDollBlock.HANGING);
		IRenderable<ModelData> bm;
		if (f2) {
			bm = BakedModelRenderable.of(model_up).withModelDataContext();
		} else {
			bm = BakedModelRenderable.of(model_down).withModelDataContext();
		}

		pPoseStack.pushPose();
		{
			pPoseStack.translate(0.5, 0, 0.5);
			pPoseStack.mulPose(new Quaternionf().rotateXYZ(0f, -f1, 0f));
			pPoseStack.translate(-0.5, 0, -0.5);
			pPoseStack.scale(1, 1, 1);

			bm.render(pPoseStack, pBufferSource, texture -> RenderType.entityTranslucent(texture), pPackedLight,
					pPackedOverlay, pPartialTick, ModelData.EMPTY);

		}
		pPoseStack.popPose();
	}

	public boolean shouldRender(CornHuskDollBlockEntity pBlockEntity, Vec3 pCameraPos) {
		return Vec3.atCenterOf(pBlockEntity.getBlockPos()).closerThan(pCameraPos, (double) this.getViewDistance());
	}
}

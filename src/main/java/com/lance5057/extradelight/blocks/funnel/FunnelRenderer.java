package com.lance5057.extradelight.blocks.funnel;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class FunnelRenderer implements BlockEntityRenderer<FunnelBlockEntity> {

	public FunnelRenderer(BlockEntityRendererProvider.Context p_173621_) {
	}

	@Override
	public void render(FunnelBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		if (!blockEntity.getFluidTank().isEmpty()) {
			VertexConsumer vertexConsumer = bufferSource.getBuffer(Sheets.translucentCullBlockSheet());
			Matrix4f mat = poseStack.last().pose();
			Matrix3f matrix3f = poseStack.last().normal();

			poseStack.pushPose();
			FluidStack fluidStack = blockEntity.getFluidTank().getFluid();
			Fluid fluid = fluidStack.getFluid();
			IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);

			RenderUtil.buildPlane(new Vector3f(1f / 16f, 14f / 16f, 1f / 16f),
					new Vector3f(1f / 16f, 14f / 16f, 15f / 16f), new Vector3f(15f / 16f, 14f / 16f, 15f / 16f),
					new Vector3f(15f / 16f, 14f / 16f, 1f / 16f), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack),
					RenderUtil.getUV(fluidTypeExtensions.getStillTexture()), Direction.UP.getNormal(), packedOverlay,
					poseStack);
			poseStack.popPose();
		}

	}

}

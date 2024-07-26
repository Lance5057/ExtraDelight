package com.lance5057.extradelight.blocks.keg;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class KegRenderer implements BlockEntityRenderer<KegBlockEntity> {

	final ResourceLocation kegTop = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/keg_top");
	final ResourceLocation kegBottom = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/keg_bottom");
	final ResourceLocation kegSide = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/keg_side");

	public KegRenderer(BlockEntityRendererProvider.Context p_173621_) {
	}

	@Override
	public void render(KegBlockEntity tank, float tickDelta, PoseStack ps, MultiBufferSource mbs, int light,
			int overlay) {
		VertexConsumer vertexConsumer = mbs.getBuffer(Sheets.translucentCullBlockSheet());
		Matrix4f mat = ps.last().pose();
		Matrix3f matrix3f = ps.last().normal();

		ps.pushPose();

		RenderUtil.buildInvertedCubePillar(new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), vertexConsumer, mat, matrix3f,
				0xffffffff, RenderUtil.getUV(kegSide), RenderUtil.getUV(kegTop), RenderUtil.getUV(kegBottom), overlay,
				ps);

		ps.popPose();

		if (!tank.getTank().getFluid().isEmpty()) {
			ps.pushPose();

			FluidStack fluidStack = tank.getTank().getFluid();
			Fluid fluid = fluidStack.getFluid();
			IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);

			RenderUtil.buildCubeAll(new Vector3f(1f / 16f, 1f / 16f, 1f / 16f),
					new Vector3f(14f / 16f, tank.getFullness() * (14f / 16f), 14f / 16f), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack),
					RenderUtil.getUV(fluidTypeExtensions.getStillTexture()), overlay, ps);
			ps.popPose();

		}
	}
}

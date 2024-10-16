package com.lance5057.extradelight.blocks.jar;

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
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class JarRenderer implements BlockEntityRenderer<JarBlockEntity> {

	public JarRenderer(BlockEntityRendererProvider.Context p_173621_) {
	}

	@Override
	public void render(JarBlockEntity tank, float tickDelta, PoseStack ps, MultiBufferSource mbs, int light,
			int overlay) {
		VertexConsumer vertexConsumer = mbs.getBuffer(Sheets.translucentCullBlockSheet());
		Matrix4f mat = ps.last().pose();
		Matrix3f matrix3f = ps.last().normal();

		if (!tank.getTank().getFluid().isEmpty()) {
			ps.pushPose();

			FluidStack fluidStack = tank.getTank().getFluid();
			Fluid fluid = fluidStack.getFluid();
			IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);

			RenderUtil.buildCubeAll(new Vector3f(5.5f / 16f, 0.5f / 16f, 5.5f / 16f),
					new Vector3f(5f / 16f, tank.getFullness() * (6f / 16f), 5f / 16f), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack),
					RenderUtil.getUV(fluidTypeExtensions.getStillTexture()), light, overlay, ps);
			ps.popPose();

		}
	}
}

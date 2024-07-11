package com.lance5057.extradelight.blocks.keg;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class KegRenderer implements BlockEntityRenderer<KegBlockEntity> {

	public KegRenderer(BlockEntityRendererProvider.Context p_173621_) {
	}

	@Override
	public void render(KegBlockEntity tank, float tickDelta, PoseStack ps, MultiBufferSource mbs, int light,
			int overlay) {
		if (!tank.getTank().getFluid().isEmpty()) {
			ps.pushPose();

			VertexConsumer vertexConsumer = mbs.getBuffer(Sheets.translucentCullBlockSheet());
			Matrix4f mat = ps.last().pose();
			FluidStack fluidStack = tank.getTank().getFluid();
			Fluid fluid = fluidStack.getFluid();
			IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);
			ResourceLocation stillFluidImageId = fluidTypeExtensions.getStillTexture(fluidStack);
			if (stillFluidImageId == null)
				stillFluidImageId = new ResourceLocation("air");
			TextureAtlasSprite stillFluidSprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
					.apply(stillFluidImageId);
			Vector4f uv = new Vector4f(stillFluidSprite.getU0(), stillFluidSprite.getU1(), stillFluidSprite.getV0(),
					stillFluidSprite.getV1());
			Matrix3f matrix3f = ps.last().normal();

			RenderUtil.buildPlane(new Vector3f(0, 15f / 16f, 0), new Vector3f(0, 15f / 16f, 1),
					new Vector3f(1, 15f / 16f, 1), new Vector3f(1, 15f / 16f, 0), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.UP.getNormal(), overlay, ps);

			RenderUtil.buildPlane(new Vector3f(15f / 16f, 0, 0), new Vector3f(15f / 16f, 1, 0),
					new Vector3f(15f / 16f, 1, 1), new Vector3f(15f / 16f, 0, 1), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.EAST.getNormal(), overlay, ps);

			RenderUtil.buildPlane(new Vector3f(1f / 16f, 0, 0), new Vector3f(1f / 16f, 0, 1),
					new Vector3f(1f / 16f, 1, 1), new Vector3f(1f / 16f, 1, 0), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.EAST.getNormal(), overlay, ps);

			RenderUtil.buildPlane(new Vector3f(0, 0, 1f / 16f), new Vector3f(0, 1, 1f / 16f),
					new Vector3f(1, 1, 1f / 16f), new Vector3f(1, 0, 1f / 16f), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.EAST.getNormal(), overlay, ps);

			RenderUtil.buildPlane(new Vector3f(0, 0, 15f / 16f), new Vector3f(1, 0, 15f / 16f),
					new Vector3f(1, 1, 15f / 16f), new Vector3f(0, 1, 15f / 16f), vertexConsumer, mat, matrix3f,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.EAST.getNormal(), overlay, ps);

			ps.popPose();
		}
	}
}

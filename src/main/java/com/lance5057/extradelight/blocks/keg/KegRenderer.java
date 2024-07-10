package com.lance5057.extradelight.blocks.keg;

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

			RenderUtil.buildPlane(new Vector3f(1, 1, 1), new Vector3f(1, 0, 0), vertexConsumer, mat,
					fluidTypeExtensions.getTintColor(fluidStack), uv, Direction.UP.getNormal(), overlay, ps);
		}
	}
}

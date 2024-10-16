package com.lance5057.extradelight.workstations.mortar;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class MortarRenderer implements BlockEntityRenderer<MortarBlockEntity> {

	public MortarRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(MortarBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandlerModifiable inv = pBlockEntity.getItemHandler();
		ItemStack item = inv.getStackInSlot(0);
		float g = pBlockEntity.getGrind();

		if (!item.isEmpty()) {
			for (int i = 0; i < item.getCount(); i++) {
				BakedModel bakedmodel = itemRenderer.getModel(item, pBlockEntity.getLevel(), null, 0);
				pPoseStack.pushPose();

				pPoseStack.translate(0.5f, 0.15f, 0.5f);
				pPoseStack.mulPose(new Quaternionf().rotateXYZ(0, (float) Math.toRadians((90 * i) + (45 * g)), 0));
				pPoseStack.mulPose(
						new Quaternionf().rotateXYZ((float) Math.toRadians(45), 0, (float) Math.toRadians(45)));
				pPoseStack.translate(0.15f, 0, 0);

				float scale = 1 / (1 + g);
				pPoseStack.scale(scale, scale, scale);

				float uniscale = 0.65f;
				pPoseStack.scale(uniscale, uniscale, uniscale);
				itemRenderer.render(item, ItemDisplayContext.GROUND, false, pPoseStack, pBufferSource, pPackedLight,
						pPackedOverlay, bakedmodel);
				pPoseStack.popPose();
			}
		}

		if (!pBlockEntity.getFluidTank().getFluid().isEmpty()) {
			VertexConsumer vertexConsumer = pBufferSource.getBuffer(Sheets.translucentCullBlockSheet());
			Matrix4f mat = pPoseStack.last().pose();
			Matrix3f matrix3f = pPoseStack.last().normal();

			pPoseStack.pushPose();

			FluidStack fluidStack = pBlockEntity.getFluidTank().getFluid();
			Fluid fluid = fluidStack.getFluid();
			IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);

			RenderUtil.buildCubeAll(new Vector3f(5f / 16f, 2.8F / 16f, 5f / 16f),
					new Vector3f(6f / 16f, pBlockEntity.getFullness() * (3f / 16f), 6f / 16f), vertexConsumer, mat,
					matrix3f, fluidTypeExtensions.getTintColor(fluidStack),
					RenderUtil.getUV(fluidTypeExtensions.getStillTexture()), pPackedLight, pPackedOverlay, pPoseStack);
			pPoseStack.popPose();

		}
	}

}

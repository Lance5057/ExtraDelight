package com.lance5057.extradelight.items.jar;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable;
import net.neoforged.neoforge.client.model.renderable.IRenderable;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.SimpleFluidContent;

public class JarItemModel extends BlockEntityWithoutLevelRenderer {
	private static JarItemModel instance;
	ModelResourceLocation rc = ModelResourceLocation
			.standalone(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "extra/jar"));
	IRenderable<ModelData> bm = BakedModelRenderable.of(rc).withModelDataContext();

	public JarItemModel(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
		super(blockEntityRenderDispatcher, entityModelSet);
	}

	public static JarItemModel getInstance() {
		if (instance == null) {
			instance = new JarItemModel(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
					Minecraft.getInstance().getEntityModels());
		}
		return instance;
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack ps, MultiBufferSource mbs,
			int packedLight, int overlay) {
		if (stack.is(ExtraDelightItems.JAR.get())) {
			ps.pushPose();

			if (displayContext == ItemDisplayContext.GUI) {

				ps.mulPose(new Quaternionf().rotateXYZ((float) Math.toRadians(30), (float) Math.toRadians(225), 0));
				ps.translate(0, 1f, -1.7f);
			} else if (displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND
					|| displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
				ps.translate(0, 0.35, -0.17f);
			} else {
				ps.translate(0, 0.15, -0.17f);

			}

			bm.render(ps, mbs, texture -> RenderType.CUTOUT, packedLight, overlay, 0, ModelData.EMPTY);

			VertexConsumer vertexConsumer = mbs.getBuffer(Sheets.translucentCullBlockSheet());
			Matrix4f mat = ps.last().pose();
			Matrix3f matrix3f = ps.last().normal();

			SimpleFluidContent f = stack.get(ExtraDelightComponents.FLUID.get());
			if (f != null && !f.isEmpty()) {
//				ps.pushPose();

				FluidStack fluidStack = f.copy();
				Fluid fluid = fluidStack.getFluid();
				IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);

				RenderUtil.buildCubeAll(new Vector3f(5.5f / 16f, 0.5f / 16f, 5.5f / 16f),
						new Vector3f(5f / 16f, ((float) f.getAmount() / 1000f) * (6f / 16f), 5f / 16f), vertexConsumer,
						mat, matrix3f, fluidTypeExtensions.getTintColor(fluidStack),
						RenderUtil.getUV(fluidTypeExtensions.getStillTexture()), overlay, ps);
//				ps.popPose();
			}
			ps.popPose();
		}
	}
}

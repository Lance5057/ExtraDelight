package com.lance5057.extradelight.blocks.countercabinet;

import java.util.List;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable.Context;
import net.neoforged.neoforge.client.model.renderable.ITextureRenderTypeLookup;

public class CounterCabinetRenderer implements BlockEntityRenderer<CounterCabinetBlockEntity> {
//	private final CounterTopModel counterTopModel;
	ResourceLocation model = new ResourceLocation(ExtraDelight.MOD_ID, "extra/counter_top");

	public CounterCabinetRenderer(BlockEntityRendererProvider.Context p_173621_) {
//		this.counterTopModel = new CounterTopModel(p_173621_.bakeLayer(CounterTopModel.LAYER));
	}

	@Override
	public void render(CounterCabinetBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemStack item = pBlockEntity.getItemHandler().getStackInSlot(27);

		if (item != null && !item.isEmpty()) {
			if (item.getItem() instanceof BlockItem b) {
				List<BakedQuad> q = Minecraft.getInstance().getBlockRenderer()
						.getBlockModel(b.getBlock().defaultBlockState()).getQuads(b.getBlock().defaultBlockState(),
								Direction.UP, pBlockEntity.getLevel().random, ModelData.EMPTY, RenderType.cutout());
				if (!q.isEmpty()) {
					float f = pBlockEntity.getBlockState().getValue(CounterCabinetBlock.FACING).getClockWise().toYRot();
//					Material m = new Material(TextureAtlas.LOCATION_BLOCKS, .contents().name());

					pPoseStack.pushPose();
//				BakedModelRenderable bmr = BakedModelRenderable.of(model);
//
//				IRenderable<ModelData> bm = bmr.withModelDataContext();
//					VertexConsumer vertexconsumer = q.get(0).getSprite()
//							.wrap(pBufferSource.getBuffer(RenderType.translucent()));
					pPoseStack.mulPose(Axis.YP.rotationDegrees(-f));
					pPoseStack.translate(0, 1.0, 0);
					this.render(Minecraft.getInstance().getModelManager().getModel(model), pPoseStack, pBufferSource,
							texture -> RenderType.entityTranslucent(texture), pPackedLight, pPackedOverlay,
							pPartialTick, new Context(ModelData.EMPTY), q.get(0).getSprite());
//					this.counterTopModel.render(pPoseStack, vertexconsumer, pPackedOverlay, pPackedLight, 1.0F, 1.0F,
//							1.0F, 1.0F);
					pPoseStack.popPose();
				}
			}
		}
	}

	public void render(BakedModel model, PoseStack poseStack, MultiBufferSource bufferSource,
			ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick,
			Context context, TextureAtlasSprite textureAtlasSprite) {
		var buffer = bufferSource.getBuffer(textureRenderTypeLookup.get(InventoryMenu.BLOCK_ATLAS));
		var tint = context.tint();
		var randomSource = context.randomSource();
		PoseStack.Pose posestack$pose = poseStack.last();
		Matrix4f matrix4f = posestack$pose.pose();
		Matrix3f matrix3f = posestack$pose.normal();

		float f4 = 0.0F;
		float f5 = 0.75F;
		float f6 = 0.0F;

//		for (Direction direction : context.faces()) {
//		randomSource.setSeed(context.seed());
		// Given the lack of context, the requested render type has to be null to ensure
		// the model renders all of its geometry
		buffer.vertex(matrix4f, 0.0F, 0.0F, 0.0F).color(0, 0, 0, 255).uv(0, 0).overlayCoords(OverlayTexture.NO_OVERLAY)
				.uv2(lightmap).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 0.0F, 16.0F, 0.0F).color(255, 255, 255, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 16.0F, 0.0F, 0.0F).color(255, 255, 255, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 16.0F, 16.0F, 0.0F).color(0, 0, 0, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmap).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
//		}
	}
}

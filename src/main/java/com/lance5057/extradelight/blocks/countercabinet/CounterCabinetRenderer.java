package com.lance5057.extradelight.blocks.countercabinet;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.butchercraft.Butchercraft;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.model.data.ModelData;

public class CounterCabinetRenderer implements BlockEntityRenderer<CounterCabinetBlockEntity> {
	private final ModelPart root;
	public CounterCabinetRenderer(BlockEntityRendererProvider.Context p_173621_) {
		this.root = p_173621_.bakeLayer(LAYER_LOCATION);
	}

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Butchercraft.MOD_ID, "countertop"), "main");

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 2)
				.addBox(-16.001F, -2.001F, -1.001F, 16.002F, 0.0F, 2.002F, new CubeDeformation(0.0F)).texOffs(0, 2)
				.addBox(-16.001F, 1.999F, -1.001F, 16.002F, 0.0F, 2.002F, new CubeDeformation(0.0F)).texOffs(16, 2)
				.addBox(0.001F, -2.001F, -1.001F, 0.0F, 4.0F, 2.002F, new CubeDeformation(0.0F)).texOffs(16, 2)
				.addBox(-15.999F, -2.001F, -1.001F, 0.0F, 4.0F, 2.002F, new CubeDeformation(0.0F)).texOffs(18, 4)
				.addBox(-15.999F, -2.001F, -1.001F, 16.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(18, 4)
				.addBox(-15.999F, -2.001F, 0.999F, 16.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 8.0F, 7.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(-14, 0)
				.addBox(0.001F, -16.001F, -1.001F, 0.0F, 2.001F, 15.002F, new CubeDeformation(0.0F)).texOffs(-14, 0)
				.addBox(-15.999F, -16.001F, -1.001F, 0.0F, 2.001F, 15.002F, new CubeDeformation(0.0F)).texOffs(1, 15)
				.addBox(-15.999F, -16.001F, -1.001F, 16.0F, 2.001F, 0.0F, new CubeDeformation(0.0F)).texOffs(-16, 0)
				.addBox(-16.001F, -16.001F, -1.001F, 16.002F, 0.0F, 15.002F, new CubeDeformation(0.0F)).texOffs(-16, 0)
				.addBox(-16.001F, -14.001F, -1.001F, 16.002F, 0.0F, 15.002F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void render(CounterCabinetBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (!pBlockEntity.hasLevel()) {
			return;
		}

		ItemStack item = pBlockEntity.getItemHandler().getStackInSlot(27);
		List<BakedQuad> copiedQuads = new ArrayList<BakedQuad>();

		if (item != null && !item.isEmpty()) {
			if (item.getItem() instanceof BlockItem b) {

				for (Direction d : Direction.values()) {
					List<BakedQuad> q = Minecraft.getInstance().getBlockRenderer()
							.getBlockModel(b.getBlock().defaultBlockState()).getQuads(b.getBlock().defaultBlockState(),
									d, pBlockEntity.getLevel().random, ModelData.EMPTY, RenderType.cutout());
					if (!q.isEmpty()) {
						copiedQuads.add(q.get(0));
					}
				}
				pPoseStack.pushPose();
				float f = pBlockEntity.getBlockState().getValue(CounterCabinetBlock.FACING).getClockWise().toYRot();

				pPoseStack.translate(0.5f, 0, 0.5f);
				pPoseStack.mulPose(Axis.YP.rotationDegrees(-f - 90));
				pPoseStack.translate(-0.5f, 0, -0.5f);

				Material m = new Material(InventoryMenu.BLOCK_ATLAS,
						ResourceLocation.withDefaultNamespace("entity/shield/base"));
				VertexConsumer vertexconsumer = m.buffer(pBufferSource, RenderType::entitySolid);
				root.render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay);
//						this.counterTopModel.render(pPoseStack, vertexconsumer, pPackedOverlay, pPackedLight, 1.0F, 1.0F,
//								1.0F, 1.0F);
				pPoseStack.popPose();
			}
		}

//		if (!ItemStack.isSameItem(item, stackCache)) {
//			copiedQuads.clear();
//			stackCache = item;
//		}
	}
//
//	public void render(PoseStack poseStack, MultiBufferSource bufferSource,
//			ITextureRenderTypeLookup textureRenderTypeLookup, int lightmap, int overlay, float partialTick,
//			Context context, BlockPos pos, List<BakedQuad> copiedQuads) {
//
//		float f = Mth.sqrt(1 * 1 + 2 * 2);
//		float f1 = Mth.sqrt(1 * 1 + 3 * 3 + 2 * 2);
//		poseStack.pushPose();
////		poseStack.translate(0, -1.05, 0);
//		poseStack.translate(-0.001F, 0.001F, -0.001F);
//		float scale = 1.002f;
//		poseStack.scale(scale, scale, scale);
//
//		VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(InventoryMenu.BLOCK_ATLAS));
//		PoseStack.Pose posestack$pose = poseStack.last();
//		Matrix4f matrix4f = posestack$pose.pose();
//		Matrix3f matrix3f = posestack$pose.normal();
//
//		if (copiedQuads != null && !copiedQuads.isEmpty()) {
//			Vector4f uvTop = RenderUtil.ZERO4;
//			Vector4f uvBottom = RenderUtil.ZERO4;
//			Vector4f uvNorth = RenderUtil.ZERO4;
//			Vector4f uvSouth = RenderUtil.ZERO4;
//			Vector4f uvEast = RenderUtil.ZERO4;
//			Vector4f uvWest = RenderUtil.ZERO4;
//
//			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
//				uvBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 0, 16, 16);
//			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
//				uvNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 0, 0, 16, 2);
//			if (copiedQuads.size() > 3 && copiedQuads.get(3) != null)
//				uvSouth = RenderUtil.getUVFromSprite(copiedQuads.get(3).getSprite(), 0, 0, 16, 2);
//			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
//				uvEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 0, 0, 16, 2);
//			if (copiedQuads.size() > 5 && copiedQuads.get(5) != null)
//				uvWest = RenderUtil.getUVFromSprite(copiedQuads.get(5).getSprite(), 0, 0, 16, 2);
//
//			RenderUtil.buildCube(new Vector3f(0, 14f / 16f, 0), new Vector3f(1, 2f / 16f, 1), vertexconsumer, matrix4f,
//					matrix3f, RenderUtil.WHITE, lightmap, OverlayTexture.NO_OVERLAY, poseStack, null, uvBottom, uvNorth,
//					uvSouth, uvEast, uvWest);
//
//			if (copiedQuads.size() > 1 && copiedQuads.get(1) != null)
//				uvBottom = RenderUtil.getUVFromSprite(copiedQuads.get(1).getSprite(), 0, 0, 2, 16);
//			if (copiedQuads.size() > 2 && copiedQuads.get(2) != null)
//				uvNorth = RenderUtil.getUVFromSprite(copiedQuads.get(2).getSprite(), 0, 0, 16, 2);
//			if (copiedQuads.size() > 3 && copiedQuads.get(3) != null)
//				uvSouth = RenderUtil.getUVFromSprite(copiedQuads.get(3).getSprite(), 0, 0, 16, 2);
//			if (copiedQuads.size() > 4 && copiedQuads.get(4) != null)
//				uvEast = RenderUtil.getUVFromSprite(copiedQuads.get(4).getSprite(), 0, 0, 2, 2);
//			if (copiedQuads.size() > 5 && copiedQuads.get(5) != null)
//				uvWest = RenderUtil.getUVFromSprite(copiedQuads.get(5).getSprite(), 0, 0, 2, 2);
//
//			RenderUtil.buildCube(new Vector3f(0, 1, 14f / 16f), new Vector3f(1, 2f / 16f, 2f / 16f), vertexconsumer,
//					matrix4f, matrix3f, RenderUtil.WHITE, lightmap, OverlayTexture.NO_OVERLAY, poseStack, null,
//					uvBottom, uvNorth, uvSouth, uvEast, uvWest);
//
//		}
//
//		poseStack.popPose();
//	}

}

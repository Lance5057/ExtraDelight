package api.LanceNestAPI.src.AdvancedDisplay;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;

import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.items.ItemStackHandler;

public class AdvancedDisplayBlockRenderer implements BlockEntityRenderer<AdvancedDisplayBlockEntity> {

	public AdvancedDisplayBlockRenderer(BlockEntityRendererProvider.Context cxt) {

	}

	@Override
	public void render(AdvancedDisplayBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		if (!blockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		ItemStackHandler handler = (ItemStackHandler) blockEntity.getItems();

		int emptyItems = 0;
		for (int i = 0; i < AdvancedDisplayBlockEntity.NUM_SLOTS; i++) {
			ItemStack s = handler.getStackInSlot(i);
			if (s.isEmpty())
				emptyItems++;
			else {
				Transform trans = blockEntity.getItemTransform(i);

				if (trans != null) {
					poseStack.pushPose();

					Vector3f origin = trans.getOriginVector();
					if (origin != null)
						poseStack.translate(origin.x, origin.y, origin.z);

					Vector3f rot = trans.getRotationVector();
					if (rot != null)
						poseStack.mulPose(new Quaternionf().rotateXYZ((float) Math.toRadians(rot.x),
								(float) Math.toRadians(rot.y), (float) Math.toRadians(rot.z)));

					Vector3f pos = trans.getTranslateVector();
					if (pos != null)
						poseStack.translate(pos.x, pos.y, pos.z);

					Vector3f scale = trans.getScaleVector();
					if (scale != null)
						poseStack.scale(scale.x, scale.y, scale.z);

					BakedModel bakedmodel = itemRenderer.getModel(s, blockEntity.getLevel(), null, 0);
					itemRenderer.render(s, ItemDisplayContext.FIXED, false, poseStack, bufferSource, packedLight,
							packedOverlay, bakedmodel);
					poseStack.popPose();
				}
			}
		}

		if (emptyItems >= AdvancedDisplayBlockEntity.NUM_SLOTS) {
			poseStack.pushPose();
			poseStack.translate(0.5f, 0, 0.5f);
			poseStack.mulPose(new Quaternionf().rotateXYZ(0, (float) Math.toRadians(90), 0));
			poseStack.mulPose(new Quaternionf().rotateXYZ((float) Math.toRadians(90), 0, 0));
			BakedModel bakedmodel = itemRenderer.getModel(Items.BARRIER.getDefaultInstance(), blockEntity.getLevel(),
					null, 0);
			itemRenderer.render(Items.BARRIER.getDefaultInstance(), ItemDisplayContext.FIXED, false, poseStack,
					bufferSource, packedLight, packedOverlay, bakedmodel);
			poseStack.popPose();
		}
	}

}

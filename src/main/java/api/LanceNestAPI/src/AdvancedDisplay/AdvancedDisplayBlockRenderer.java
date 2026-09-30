package api.LanceNestAPI.src.AdvancedDisplay;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.neoforged.neoforge.items.IItemHandler;

public class AdvancedDisplayBlockRenderer implements BlockEntityRenderer<AdvancedDisplayBlockEntity> {

	@Override
	public void render(AdvancedDisplayBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		if (!blockEntity.hasLevel()) {
			return;
		}

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

		IItemHandler itemInteractionHandler = blockEntity.getItems();
	}

}

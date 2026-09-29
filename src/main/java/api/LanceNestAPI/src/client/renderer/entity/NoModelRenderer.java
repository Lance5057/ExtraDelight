package api.LanceNestAPI.src.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class NoModelRenderer extends EntityRenderer<Entity> {
	public NoModelRenderer(EntityRendererProvider.Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getTextureLocation(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void renderNameTag(Entity entity, Component displayName, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, float partialTick) {
	}

}

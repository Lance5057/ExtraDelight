package com.lance5057.extradelight.blocks.countercabinet;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class CounterTopModel extends Model {
	private final ModelPart root;
	private final ModelPart top;
//	private final ModelPart backLip;

	public static final ModelLayerLocation LAYER = new ModelLayerLocation(
			new ResourceLocation(ExtraDelight.MOD_ID, "counter_top"), "main");

	public CounterTopModel(ModelPart p_170475_) {
		super(RenderType::entitySolid);
		this.root = p_170475_;
		this.top = p_170475_.getChild("top");
//		this.backLip = p_170475_.getChild("backlip");
	}

	@Override
	public void renderToBuffer(PoseStack p_103111_, VertexConsumer p_103112_, int p_103113_, int p_103114_,
			float p_103115_, float p_103116_, float p_103117_, float p_103118_) {
		// TODO Auto-generated method stub

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("top",
				CubeListBuilder.create().addBox(-0.001F, 14.0F, -1.001F, 16.002F, 0.001F, 16F), PartPose.ZERO);
//		partdefinition.addOrReplaceChild("backlip",
//				CubeListBuilder.create().addBox(-0.001F, 14.0F, 13.999F, 16.002F, 4.0F, 2.002F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	public void render(PoseStack p_102317_, VertexConsumer p_102318_, int p_102319_, int p_102320_, float p_102321_,
			float p_102322_, float p_102323_, float p_102324_) {
		this.root.render(p_102317_, p_102318_, p_102319_, p_102320_, p_102321_, p_102322_, p_102323_, p_102324_);
	}
}

package com.lance5057.extradelight.client.models;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class StrawberryHatModel extends HumanoidModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "strawberry_hat"), "hat");

	public StrawberryHatModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.5f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -32.5F + 24, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.6F)).texOffs(-12, 20)
						.addBox(-6.0F, -27.9F + 23, -6.0F, 12.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F,
				0.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = hat.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(11, 17).addBox(-1.5F,
				-0.9F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.1F, 0.0F));

		PartDefinition leaf_r1 = bone.addOrReplaceChild("leaf_r1",
				CubeListBuilder.create().texOffs(-4, 16).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, -2.7053F));

		PartDefinition leaf_r2 = bone.addOrReplaceChild("leaf_r2",
				CubeListBuilder.create().texOffs(-4, 16).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, -0.4363F));

		PartDefinition leaf_r3 = bone
				.addOrReplaceChild("leaf_r3",
						CubeListBuilder.create().texOffs(-4, 16).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7053F, 0.0F, 0.0F));

		PartDefinition leaf_r4 = bone
				.addOrReplaceChild("leaf_r4",
						CubeListBuilder.create().texOffs(-4, 16).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

}
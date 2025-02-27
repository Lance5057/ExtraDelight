// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class counter_top_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "counter_top_converted"), "main");
	private final ModelPart back;
	private final ModelPart base;

	public counter_top_Converted(ModelPart root) {
		this.back = root.getChild("back");
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 2).addBox(-16.001F, -2.001F, -1.001F, 16.002F, 0.0F, 2.002F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-16.001F, 1.999F, -1.001F, 16.002F, 0.0F, 2.002F, new CubeDeformation(0.0F))
		.texOffs(16, 2).addBox(0.001F, -2.001F, -1.001F, 0.0F, 4.0F, 2.002F, new CubeDeformation(0.0F))
		.texOffs(16, 2).addBox(-15.999F, -2.001F, -1.001F, 0.0F, 4.0F, 2.002F, new CubeDeformation(0.0F))
		.texOffs(18, 4).addBox(-15.999F, -2.001F, -1.001F, 16.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(18, 4).addBox(-15.999F, -2.001F, 0.999F, 16.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 8.0F, 7.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(-14, 0).addBox(0.001F, -16.001F, -1.001F, 0.0F, 2.001F, 15.002F, new CubeDeformation(0.0F))
		.texOffs(-14, 0).addBox(-15.999F, -16.001F, -1.001F, 0.0F, 2.001F, 15.002F, new CubeDeformation(0.0F))
		.texOffs(1, 15).addBox(-15.999F, -16.001F, -1.001F, 16.0F, 2.001F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(-16, 0).addBox(-16.001F, -16.001F, -1.001F, 16.002F, 0.0F, 15.002F, new CubeDeformation(0.0F))
		.texOffs(-16, 0).addBox(-16.001F, -14.001F, -1.001F, 16.002F, 0.0F, 15.002F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
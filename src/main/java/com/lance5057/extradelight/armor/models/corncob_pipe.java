//// Made with Blockbench 4.8.3
//// Exported for Minecraft version 1.17 or later with Mojang mappings
//// Paste this class into your mod and generate all required imports
//
//
//public class corncob_pipe<T extends Entity> extends EntityModel<T> {
//	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "corncob_pipe"), "main");
//	private final ModelPart bone;
//
//	public corncob_pipe(ModelPart root) {
//		this.bone = root.getChild("bone");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 7).addBox(-1.0F, -2.4F, -7.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(8, 7).addBox(-0.8F, -2.4001F, -6.8F, 1.6F, 0.0F, 1.6F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.5F, 5.0F));
//
//		return LayerDefinition.create(meshdefinition, 16, 16);
//	}
//
//	@Override
//	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//	}
//}
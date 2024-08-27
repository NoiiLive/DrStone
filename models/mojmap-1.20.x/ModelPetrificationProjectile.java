// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPetrificationProjectile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "petrificationprojectile"), "main");
	private final ModelPart group;

	public ModelPetrificationProjectile(ModelPart root) {
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.3F, -3.0F, 7.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 0)
						.addBox(-8.3F, -3.0F, 7.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-8.3F, 1.0F, 7.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 1)
						.addBox(-8.3F, -3.0F, 7.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.5F, -2.0F, 5.7F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-7.5F, -2.0F, 5.7F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.5F, -2.0F, 9.7F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(-7.5F, 2.0F, 5.7F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.5F, -1.0F, 10.7F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.5F, -1.0F, 6.7F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-5.5F, -1.0F, 6.7F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-9.5F, -1.0F, 6.7F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 22.0F, -7.5F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}
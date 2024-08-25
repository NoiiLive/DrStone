// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSenkuuCoat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "senkuucoat"), "main");
	private final ModelPart torso;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public ModelSenkuuCoat(ModelPart root) {
		this.torso = root.getChild("torso");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition torso = partdefinition.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, 0.25F, -2.0F, 8.0F, 17.0F, 4.0F, new CubeDeformation(0.51F)).texOffs(16, 13)
						.addBox(-4.0F, -2.75F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.5F)).texOffs(24, 6)
						.addBox(-4.5F, 6.25F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)).texOffs(24, 0)
						.addBox(-4.5F, 8.75F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1",
				CubeListBuilder.create().texOffs(5, 50).addBox(-5.0F, -0.5F, -2.5F, 10.0F, 1.0F, 5.0F,
						new CubeDeformation(0.6F)),
				PartPose.offsetAndRotation(0.25F, 11.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition torso_r2 = torso.addOrReplaceChild("torso_r2",
				CubeListBuilder.create().texOffs(12, 40).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 6.0F, 4.0F,
						new CubeDeformation(0.501F)),
				PartPose.offsetAndRotation(-3.957F, 13.519F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition torso_r3 = torso.addOrReplaceChild("torso_r3",
				CubeListBuilder.create().texOffs(32, 40).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 6.0F, 4.0F,
						new CubeDeformation(0.501F)),
				PartPose.offsetAndRotation(3.957F, 13.519F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition torso_r4 = torso.addOrReplaceChild("torso_r4",
				CubeListBuilder.create().texOffs(30, 50)
						.addBox(-2.0F, -5.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(44, 40)
						.addBox(-1.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.25F, 12.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(0, 37)
						.addBox(-1.0F, 5.65F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(0, 31)
						.addBox(-1.5F, 8.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(20, 32)
						.addBox(-1.0F, -1.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.501F)).texOffs(38, 51)
						.addBox(-1.0F, -1.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(5.0F, 14.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1",
				CubeListBuilder.create().texOffs(0, 44).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 5.0F, 4.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(3.173F, 0.8953F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 37).mirror()
						.addBox(-3.0F, 5.65F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false)
						.texOffs(0, 31).mirror().addBox(-3.5F, 8.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(20, 32).mirror()
						.addBox(-3.0F, -1.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.501F)).mirror(false)
						.texOffs(38, 51).mirror()
						.addBox(-4.0F, -1.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offset(-5.0F, 14.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1",
				CubeListBuilder.create().texOffs(0, 44).mirror()
						.addBox(-0.5F, -2.5F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offsetAndRotation(-3.173F, 0.8953F, 0.0F, 0.0F, 0.0F, 0.2182F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}
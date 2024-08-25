// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSenkuuShoes<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "senkuushoes"), "main");
	private final ModelPart left_foot;
	private final ModelPart right_foot;

	public ModelSenkuuShoes(ModelPart root) {
		this.left_foot = root.getChild("left_foot");
		this.right_foot = root.getChild("right_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_foot = partdefinition.addOrReplaceChild("left_foot",
				CubeListBuilder.create().texOffs(40, 12)
						.addBox(-2.0F, 8.75F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(24, 25)
						.addBox(-2.5F, 7.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-2.0F, 10.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition right_foot = partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create()
				.texOffs(40, 12).mirror().addBox(-2.0F, 8.75F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F))
				.mirror(false).texOffs(24, 25).mirror()
				.addBox(-2.5F, 7.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 21)
				.mirror().addBox(-2.0F, 10.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}
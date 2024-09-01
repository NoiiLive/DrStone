package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.DistillingPotBlockModel;
import net.clozynoii.drstone.block.entity.DistillingPotTileEntity;

public class DistillingPotTileRenderer extends GeoBlockRenderer<DistillingPotTileEntity> {
	public DistillingPotTileRenderer() {
		super(new DistillingPotBlockModel());
	}

	@Override
	public RenderType getRenderType(DistillingPotTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

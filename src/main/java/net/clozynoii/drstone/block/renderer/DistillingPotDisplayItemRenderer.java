package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.DistillingPotDisplayModel;
import net.clozynoii.drstone.block.display.DistillingPotDisplayItem;

public class DistillingPotDisplayItemRenderer extends GeoItemRenderer<DistillingPotDisplayItem> {
	public DistillingPotDisplayItemRenderer() {
		super(new DistillingPotDisplayModel());
	}

	@Override
	public RenderType getRenderType(DistillingPotDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

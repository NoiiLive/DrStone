package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.display.DistillingPotDisplayItem;

public class DistillingPotDisplayModel extends GeoModel<DistillingPotDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DistillingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "animations/distillingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DistillingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "geo/distillingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DistillingPotDisplayItem entity) {
		return new ResourceLocation("drstone", "textures/block/distillingpottexture.png");
	}
}

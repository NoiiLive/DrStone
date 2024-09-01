package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.entity.DistillingPotTileEntity;

public class DistillingPotBlockModel extends GeoModel<DistillingPotTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DistillingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "animations/distillingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DistillingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "geo/distillingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DistillingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "textures/block/distillingpottexture.png");
	}
}

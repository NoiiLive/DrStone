package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.display.StompingPotDisplayItem;

public class StompingPotDisplayModel extends GeoModel<StompingPotDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(StompingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "animations/stompingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StompingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "geo/stompingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StompingPotDisplayItem entity) {
		return new ResourceLocation("drstone", "textures/block/stompingjartexture.png");
	}
}

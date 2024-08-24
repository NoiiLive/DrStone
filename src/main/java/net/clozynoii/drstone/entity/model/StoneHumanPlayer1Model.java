package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneHumanPlayer1Entity;

public class StoneHumanPlayer1Model extends GeoModel<StoneHumanPlayer1Entity> {
	@Override
	public ResourceLocation getAnimationResource(StoneHumanPlayer1Entity entity) {
		return new ResourceLocation("drstone", "animations/stonehuman1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneHumanPlayer1Entity entity) {
		return new ResourceLocation("drstone", "geo/stonehuman1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneHumanPlayer1Entity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

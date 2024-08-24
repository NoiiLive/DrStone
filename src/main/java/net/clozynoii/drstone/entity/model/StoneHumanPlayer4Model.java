package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneHumanPlayer4Entity;

public class StoneHumanPlayer4Model extends GeoModel<StoneHumanPlayer4Entity> {
	@Override
	public ResourceLocation getAnimationResource(StoneHumanPlayer4Entity entity) {
		return new ResourceLocation("drstone", "animations/stonehuman4.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneHumanPlayer4Entity entity) {
		return new ResourceLocation("drstone", "geo/stonehuman4.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneHumanPlayer4Entity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

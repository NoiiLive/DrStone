package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneHumanPlayer2Entity;

public class StoneHumanPlayer2Model extends GeoModel<StoneHumanPlayer2Entity> {
	@Override
	public ResourceLocation getAnimationResource(StoneHumanPlayer2Entity entity) {
		return new ResourceLocation("drstone", "animations/stonehuman2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneHumanPlayer2Entity entity) {
		return new ResourceLocation("drstone", "geo/stonehuman2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneHumanPlayer2Entity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

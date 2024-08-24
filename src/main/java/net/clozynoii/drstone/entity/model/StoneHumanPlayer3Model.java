package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneHumanPlayer3Entity;

public class StoneHumanPlayer3Model extends GeoModel<StoneHumanPlayer3Entity> {
	@Override
	public ResourceLocation getAnimationResource(StoneHumanPlayer3Entity entity) {
		return new ResourceLocation("drstone", "animations/stonehuman3.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneHumanPlayer3Entity entity) {
		return new ResourceLocation("drstone", "geo/stonehuman3.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneHumanPlayer3Entity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

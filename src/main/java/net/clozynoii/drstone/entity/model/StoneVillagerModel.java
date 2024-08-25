package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneVillagerEntity;

public class StoneVillagerModel extends GeoModel<StoneVillagerEntity> {
	@Override
	public ResourceLocation getAnimationResource(StoneVillagerEntity entity) {
		return new ResourceLocation("drstone", "animations/stonevillager.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneVillagerEntity entity) {
		return new ResourceLocation("drstone", "geo/stonevillager.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneVillagerEntity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

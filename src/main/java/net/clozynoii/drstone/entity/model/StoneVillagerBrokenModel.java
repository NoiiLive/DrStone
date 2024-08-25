package net.clozynoii.drstone.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.entity.StoneVillagerBrokenEntity;

public class StoneVillagerBrokenModel extends GeoModel<StoneVillagerBrokenEntity> {
	@Override
	public ResourceLocation getAnimationResource(StoneVillagerBrokenEntity entity) {
		return new ResourceLocation("drstone", "animations/stonevillagerbroken.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StoneVillagerBrokenEntity entity) {
		return new ResourceLocation("drstone", "geo/stonevillagerbroken.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StoneVillagerBrokenEntity entity) {
		return new ResourceLocation("drstone", "textures/entities/" + entity.getTexture() + ".png");
	}

}

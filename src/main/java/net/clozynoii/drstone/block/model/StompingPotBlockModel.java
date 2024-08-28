package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.entity.StompingPotTileEntity;

public class StompingPotBlockModel extends GeoModel<StompingPotTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(StompingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "animations/stompingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StompingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "geo/stompingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StompingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "textures/block/stompingjartexture.png");
	}
}

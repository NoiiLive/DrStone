package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.entity.MixingPotTileEntity;

public class MixingPotBlockModel extends GeoModel<MixingPotTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MixingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "animations/mixingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MixingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "geo/mixingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MixingPotTileEntity animatable) {
		return new ResourceLocation("drstone", "textures/block/mixingpottexture.png");
	}
}

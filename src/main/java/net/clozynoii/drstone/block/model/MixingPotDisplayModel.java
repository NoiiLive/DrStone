package net.clozynoii.drstone.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.drstone.block.display.MixingPotDisplayItem;

public class MixingPotDisplayModel extends GeoModel<MixingPotDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MixingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "animations/mixingpot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MixingPotDisplayItem animatable) {
		return new ResourceLocation("drstone", "geo/mixingpot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MixingPotDisplayItem entity) {
		return new ResourceLocation("drstone", "textures/block/mixingpottexture.png");
	}
}

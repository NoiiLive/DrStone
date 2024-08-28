package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.StompingPotDisplayModel;
import net.clozynoii.drstone.block.display.StompingPotDisplayItem;

public class StompingPotDisplayItemRenderer extends GeoItemRenderer<StompingPotDisplayItem> {
	public StompingPotDisplayItemRenderer() {
		super(new StompingPotDisplayModel());
	}

	@Override
	public RenderType getRenderType(StompingPotDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.MixingPotDisplayModel;
import net.clozynoii.drstone.block.display.MixingPotDisplayItem;

public class MixingPotDisplayItemRenderer extends GeoItemRenderer<MixingPotDisplayItem> {
	public MixingPotDisplayItemRenderer() {
		super(new MixingPotDisplayModel());
	}

	@Override
	public RenderType getRenderType(MixingPotDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.StompingPotBlockModel;
import net.clozynoii.drstone.block.entity.StompingPotTileEntity;

public class StompingPotTileRenderer extends GeoBlockRenderer<StompingPotTileEntity> {
	public StompingPotTileRenderer() {
		super(new StompingPotBlockModel());
	}

	@Override
	public RenderType getRenderType(StompingPotTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

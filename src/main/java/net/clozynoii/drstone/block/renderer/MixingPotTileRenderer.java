package net.clozynoii.drstone.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.drstone.block.model.MixingPotBlockModel;
import net.clozynoii.drstone.block.entity.MixingPotTileEntity;

public class MixingPotTileRenderer extends GeoBlockRenderer<MixingPotTileEntity> {
	public MixingPotTileRenderer() {
		super(new MixingPotBlockModel());
	}

	@Override
	public RenderType getRenderType(MixingPotTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

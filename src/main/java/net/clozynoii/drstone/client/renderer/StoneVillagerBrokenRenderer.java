
package net.clozynoii.drstone.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.clozynoii.drstone.entity.StoneVillagerBrokenEntity;
import net.clozynoii.drstone.client.model.ModelStoneVillagerBroken;

public class StoneVillagerBrokenRenderer extends MobRenderer<StoneVillagerBrokenEntity, ModelStoneVillagerBroken<StoneVillagerBrokenEntity>> {
	public StoneVillagerBrokenRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStoneVillagerBroken(context.bakeLayer(ModelStoneVillagerBroken.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StoneVillagerBrokenEntity entity) {
		return new ResourceLocation("drstone:textures/entities/stone_villager.png");
	}
}

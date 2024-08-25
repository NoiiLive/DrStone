
package net.clozynoii.drstone.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.clozynoii.drstone.entity.StoneVillagerEntity;
import net.clozynoii.drstone.client.model.ModelStoneVillager;

public class StoneVillagerRenderer extends MobRenderer<StoneVillagerEntity, ModelStoneVillager<StoneVillagerEntity>> {
	public StoneVillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStoneVillager(context.bakeLayer(ModelStoneVillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StoneVillagerEntity entity) {
		return new ResourceLocation("drstone:textures/entities/stone_villager.png");
	}
}

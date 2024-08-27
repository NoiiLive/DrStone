
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.drstone.client.model.ModelSenkuuShorts;
import net.clozynoii.drstone.client.model.ModelSenkuuShoes;
import net.clozynoii.drstone.client.model.ModelSenkuuCoat;
import net.clozynoii.drstone.client.model.ModelPetrificationProjectile;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DrstoneModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSenkuuShorts.LAYER_LOCATION, ModelSenkuuShorts::createBodyLayer);
		event.registerLayerDefinition(ModelPetrificationProjectile.LAYER_LOCATION, ModelPetrificationProjectile::createBodyLayer);
		event.registerLayerDefinition(ModelSenkuuCoat.LAYER_LOCATION, ModelSenkuuCoat::createBodyLayer);
		event.registerLayerDefinition(ModelSenkuuShoes.LAYER_LOCATION, ModelSenkuuShoes::createBodyLayer);
	}
}

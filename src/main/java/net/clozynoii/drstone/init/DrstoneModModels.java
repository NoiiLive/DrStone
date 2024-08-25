
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.drstone.client.model.ModelStoneVillagerBroken;
import net.clozynoii.drstone.client.model.ModelStoneVillager;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DrstoneModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelStoneVillagerBroken.LAYER_LOCATION, ModelStoneVillagerBroken::createBodyLayer);
		event.registerLayerDefinition(ModelStoneVillager.LAYER_LOCATION, ModelStoneVillager::createBodyLayer);
	}
}

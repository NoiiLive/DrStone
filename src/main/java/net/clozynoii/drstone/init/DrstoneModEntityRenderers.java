
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.drstone.client.renderer.StoneVillagerRenderer;
import net.clozynoii.drstone.client.renderer.StoneVillagerBrokenRenderer;
import net.clozynoii.drstone.client.renderer.StoneHumanPlayer4Renderer;
import net.clozynoii.drstone.client.renderer.StoneHumanPlayer3Renderer;
import net.clozynoii.drstone.client.renderer.StoneHumanPlayer2Renderer;
import net.clozynoii.drstone.client.renderer.StoneHumanPlayer1Renderer;
import net.clozynoii.drstone.client.renderer.PetrificationThrownRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DrstoneModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DrstoneModEntities.STONE_HUMAN_PLAYER_1.get(), StoneHumanPlayer1Renderer::new);
		event.registerEntityRenderer(DrstoneModEntities.STONE_HUMAN_PLAYER_2.get(), StoneHumanPlayer2Renderer::new);
		event.registerEntityRenderer(DrstoneModEntities.STONE_HUMAN_PLAYER_3.get(), StoneHumanPlayer3Renderer::new);
		event.registerEntityRenderer(DrstoneModEntities.STONE_HUMAN_PLAYER_4.get(), StoneHumanPlayer4Renderer::new);
		event.registerEntityRenderer(DrstoneModEntities.STONE_VILLAGER.get(), StoneVillagerRenderer::new);
		event.registerEntityRenderer(DrstoneModEntities.STONE_VILLAGER_BROKEN.get(), StoneVillagerBrokenRenderer::new);
		event.registerEntityRenderer(DrstoneModEntities.PETRIFICATION_THROWN.get(), PetrificationThrownRenderer::new);
	}
}

package net.clozynoii.drstone.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.drstone.init.DrstoneModBlockEntities;
import net.clozynoii.drstone.block.renderer.StompingPotTileRenderer;
import net.clozynoii.drstone.block.renderer.MixingPotTileRenderer;
import net.clozynoii.drstone.block.renderer.DistillingPotTileRenderer;
import net.clozynoii.drstone.DrstoneMod;

@Mod.EventBusSubscriber(modid = DrstoneMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(DrstoneModBlockEntities.STOMPING_POT.get(), context -> new StompingPotTileRenderer());
		event.registerBlockEntityRenderer(DrstoneModBlockEntities.MIXING_POT.get(), context -> new MixingPotTileRenderer());
		event.registerBlockEntityRenderer(DrstoneModBlockEntities.DISTILLING_POT.get(), context -> new DistillingPotTileRenderer());
	}
}

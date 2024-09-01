
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.drstone.client.particle.SweetberryBubblesParticle;
import net.clozynoii.drstone.client.particle.MiracleDripParticle;
import net.clozynoii.drstone.client.particle.GrapeBubblesParticle;
import net.clozynoii.drstone.client.particle.GlowberryBubblesParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DrstoneModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DrstoneModParticleTypes.GRAPE_BUBBLES.get(), GrapeBubblesParticle::provider);
		event.registerSpriteSet(DrstoneModParticleTypes.GLOWBERRY_BUBBLES.get(), GlowberryBubblesParticle::provider);
		event.registerSpriteSet(DrstoneModParticleTypes.SWEETBERRY_BUBBLES.get(), SweetberryBubblesParticle::provider);
		event.registerSpriteSet(DrstoneModParticleTypes.MIRACLE_DRIP.get(), MiracleDripParticle::provider);
	}
}

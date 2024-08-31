
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DrstoneMod.MODID);
	public static final RegistryObject<SimpleParticleType> GRAPE_BUBBLES = REGISTRY.register("grape_bubbles", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GLOWBERRY_BUBBLES = REGISTRY.register("glowberry_bubbles", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SWEETBERRY_BUBBLES = REGISTRY.register("sweetberry_bubbles", () -> new SimpleParticleType(true));
}


/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.clozynoii.drstone.potion.PetrifiedMobEffect;
import net.clozynoii.drstone.potion.IntoxicatedMobEffect;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DrstoneMod.MODID);
	public static final RegistryObject<MobEffect> PETRIFIED = REGISTRY.register("petrified", () -> new PetrifiedMobEffect());
	public static final RegistryObject<MobEffect> INTOXICATED = REGISTRY.register("intoxicated", () -> new IntoxicatedMobEffect());
}

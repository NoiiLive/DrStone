package net.clozynoii.drstone.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.clozynoii.drstone.init.DrstoneModMobEffects;

public class DrinkAlcoholProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.INTOXICATED.get(), 600, 0, true, true));
	}
}

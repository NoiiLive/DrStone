package net.clozynoii.drstone.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DrinkAlcoholProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.INTOXICATED.get(), 3500, 0, true, true));
	}
}

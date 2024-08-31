package net.clozynoii.drstone.procedures;

import net.minecraftforge.eventbus.api.Event;

public class IntoxicatedEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randomEvent = 0;
		randomEvent = Mth.nextInt(RandomSource.create(), 1, 25);
		if (randomEvent == 1) {
			if (entity.onGround()) {
				entity.setDeltaMovement(new Vec3((Mth.nextInt(RandomSource.create(), (int) 0.4, (int) 0.7)), 0, (Mth.nextInt(RandomSource.create(), (int) 0.4, (int) 0.7))));
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 2, false, false));
	}
}

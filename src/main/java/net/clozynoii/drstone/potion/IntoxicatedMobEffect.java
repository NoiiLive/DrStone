
package net.clozynoii.drstone.potion;

public class IntoxicatedMobEffect extends MobEffect {
	public IntoxicatedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10112933);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IntoxicatedEffectProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
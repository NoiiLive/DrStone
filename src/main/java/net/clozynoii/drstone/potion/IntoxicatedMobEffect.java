
package net.clozynoii.drstone.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.clozynoii.drstone.procedures.IntoxicatedEffectProcedure;

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

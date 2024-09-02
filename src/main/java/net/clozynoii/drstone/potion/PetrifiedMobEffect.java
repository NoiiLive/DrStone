
package net.clozynoii.drstone.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.clozynoii.drstone.procedures.PetrifiedEffectProcedure;

public class PetrifiedMobEffect extends MobEffect {
	public PetrifiedMobEffect() {
		super(MobEffectCategory.HARMFUL, -13369549);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PetrifiedEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

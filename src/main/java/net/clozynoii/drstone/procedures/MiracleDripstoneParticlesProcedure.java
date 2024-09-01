package net.clozynoii.drstone.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.drstone.init.DrstoneModParticleTypes;

public class MiracleDripstoneParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.25) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (DrstoneModParticleTypes.MIRACLE_DRIP.get()), (x + 0.5), (y + 0.3), (z + 0.5), 1, 0.1, 0.1, 0.1, 0);
		}
	}
}

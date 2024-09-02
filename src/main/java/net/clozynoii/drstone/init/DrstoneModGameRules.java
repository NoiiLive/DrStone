
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrstoneModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DS_SPAWN_PETRIFIED = GameRules.register("dsSpawnPetrified", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DS_MASS_PETRIFICATION = GameRules.register("dsMassPetrification", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}

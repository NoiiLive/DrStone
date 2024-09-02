
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrstoneModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DS_SPAWN_PETRIFIED = GameRules.register("dsSpawnPetrified", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> DS_DEVICE_RADIUS = GameRules.register("dsDeviceRadius", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
}

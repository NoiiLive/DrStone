
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrstoneModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> NO_VILLAGERS = GameRules.register("noVillagers", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> SPAWN_PETRIFIED = GameRules.register("spawnPetrified", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}

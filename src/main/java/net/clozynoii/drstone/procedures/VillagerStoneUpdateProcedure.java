package net.clozynoii.drstone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VillagerStoneUpdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean single = false;
		if (entity instanceof Villager) {
			if (DrstoneModVariables.MapVariables.get(world).MassPetrificationEvent == true) {
				if (entity.getPersistentData().getBoolean("Unpetrified") == false) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = DrstoneModEntities.STONE_VILLAGER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
	}
}

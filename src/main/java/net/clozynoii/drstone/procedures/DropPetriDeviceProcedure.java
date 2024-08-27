package net.clozynoii.drstone.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import net.clozynoii.drstone.init.DrstoneModItems;

public class DropPetriDeviceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(DrstoneModItems.PETRIFICATION_DEVICE.get()));
			entityToSpawn.setPickUpDelay(20);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}

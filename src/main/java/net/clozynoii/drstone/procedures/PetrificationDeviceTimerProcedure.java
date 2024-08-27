package net.clozynoii.drstone.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class PetrificationDeviceTimerProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("Seconds") > 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7c" + new java.text.DecimalFormat("##.#").format(itemstack.getOrCreateTag().getDouble("Seconds") / 20) + " Seconds!")), true);
			itemstack.getOrCreateTag().putDouble("Seconds", (itemstack.getOrCreateTag().getDouble("Seconds") - 1));
		}
	}
}

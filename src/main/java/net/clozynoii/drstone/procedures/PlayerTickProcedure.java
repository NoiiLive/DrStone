package net.clozynoii.drstone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModItems;
import net.clozynoii.drstone.entity.PetrificationThrownEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean single = false;
		if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceSeconds > 0) {
			{
				double _setval = (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceSeconds - 1;
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DeviceSeconds = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("\u00A7c" + new java.text.DecimalFormat("##.#").format((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceSeconds / 20) + " Seconds!")),
						true);
		}
		if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceSeconds == 1) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == DrstoneModItems.PETRIFICATION_DEVICE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == DrstoneModItems.PETRIFICATION_DEVICE.get()
					|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DrstoneModItems.PETRIFICATION_DEVICE.get())) : false)) {
				PetrificateProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof PetrificationThrownEntity && single == false) {
							single = true;
							PetrificateProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entity);
						} else if (entityiterator instanceof ItemEntity && (entityiterator.getDisplayName().getString()).equals("Petrification Device") && single == false) {
							single = true;
							PetrificateProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entity);
						}
					}
				}
			}
			{
				double _setval = 0;
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DeviceSeconds = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DeviceMeters = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

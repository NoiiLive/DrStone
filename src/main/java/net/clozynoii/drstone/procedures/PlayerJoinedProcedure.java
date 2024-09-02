package net.clozynoii.drstone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModMobEffects;
import net.clozynoii.drstone.init.DrstoneModGameRules;
import net.clozynoii.drstone.configuration.DrStoneConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinedProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).JoinedWorld == false) {
			{
				boolean _setval = true;
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JoinedWorld = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("drstone:dr_stone_ko_s"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			{
				double _setval = (double) DrStoneConfigConfiguration.NATURALUNPETRIFY.get();
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NaturalUnpetrify = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(DrstoneModGameRules.DS_MASS_PETRIFICATION) == true) {
			if (DrstoneModVariables.MapVariables.get(world).WorldCreated == false) {
				DrstoneModVariables.MapVariables.get(world).WorldCreated = true;
				DrstoneModVariables.MapVariables.get(world).syncData(world);
				DrstoneModVariables.MapVariables.get(world).PetrificationTimer = (double) DrStoneConfigConfiguration.MASSEVENTTIME.get();
				DrstoneModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(DrstoneModGameRules.DS_SPAWN_PETRIFIED) == true) {
			if (DrstoneModVariables.MapVariables.get(world).MassPetrificationEvent == true) {
				if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).FirstUnpetrify == false) {
					if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(DrstoneModMobEffects.PETRIFIED.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 9999999, 0, false, false));
						if (Math.random() <= 0.5) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("summon drstone:stone_human_player_1 ~ ~ ~ {Owner:" + entity.getStringUUID() + "}"));
						} else {
							if (Math.random() <= 0.5) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("summon drstone:stone_human_player_2 ~ ~ ~ {Owner:" + entity.getStringUUID() + "}"));
							} else {
								if (Math.random() <= 0.5) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon drstone:stone_human_player_3 ~ ~ ~ {Owner:" + entity.getStringUUID() + "}"));
								} else {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon drstone:stone_human_player_4 ~ ~ ~ {Owner:" + entity.getStringUUID() + "}"));
								}
							}
						}
					}
				}
			}
		}
	}
}

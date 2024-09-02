package net.clozynoii.drstone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModMobEffects;
import net.clozynoii.drstone.init.DrstoneModGameRules;
import net.clozynoii.drstone.configuration.DrStoneConfigConfiguration;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class MassPetrificationEventProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		boolean single = false;
		if (world.getLevelData().getGameRules().getBoolean(DrstoneModGameRules.DS_MASS_PETRIFICATION) == true) {
			if (DrstoneModVariables.MapVariables.get(world).PetrificationTimer > 1) {
				DrstoneModVariables.MapVariables.get(world).PetrificationTimer = DrstoneModVariables.MapVariables.get(world).PetrificationTimer - 1;
				DrstoneModVariables.MapVariables.get(world).syncData(world);
			}
			if (DrstoneModVariables.MapVariables.get(world).PetrificationTimer == 1) {
				DrstoneModVariables.MapVariables.get(world).MassPetrificationEvent = true;
				DrstoneModVariables.MapVariables.get(world).syncData(world);
				DrstoneModVariables.MapVariables.get(world).PetrificationTimer = 0;
				DrstoneModVariables.MapVariables.get(world).syncData(world);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<???> 12800000 Meters, 1 Second."), false);
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 9999999, 0, false, false));
						if (Math.random() <= 0.5) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
												.withSuppressedOutput(),
										("summon drstone:stone_human_player_1 ~ ~ ~ {Owner:" + entityiterator.getStringUUID() + "}"));
						} else {
							if (Math.random() <= 0.5) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
													.withSuppressedOutput(),
											("summon drstone:stone_human_player_2 ~ ~ ~ {Owner:" + entityiterator.getStringUUID() + "}"));
							} else {
								if (Math.random() <= 0.5) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("summon drstone:stone_human_player_3 ~ ~ ~ {Owner:" + entityiterator.getStringUUID() + "}"));
								} else {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(),
												("summon drstone:stone_human_player_4 ~ ~ ~ {Owner:" + entityiterator.getStringUUID() + "}"));
								}
							}
						}
					}
				}
			}
			if (DrstoneModVariables.MapVariables.get(world).MassPetrificationEvent == true) {
				if (DrstoneModVariables.MapVariables.get(world).MiracleCaveSpawned == false) {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						if (single == false) {
							DrstoneModVariables.MapVariables.get(world).MiracleCaveSpawned = true;
							DrstoneModVariables.MapVariables.get(world).syncData(world);
							single = true;
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("drstone", "miracle_cave"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(entityiterator.getX() - 7, entityiterator.getY() - 1, entityiterator.getZ() - 8),
											BlockPos.containing(entityiterator.getX() - 7, entityiterator.getY() - 1, entityiterator.getZ() - 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
											_serverworld.random, 3);
								}
							}
							{
								double _setval = (double) DrStoneConfigConfiguration.FIRSTAWAKENTIME.get();
								entityiterator.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstAwaken = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
						}
					}
				}
			}
		}
	}
}

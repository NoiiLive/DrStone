package net.clozynoii.drstone.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModMobEffects;
import net.clozynoii.drstone.init.DrstoneModEntities;
import net.clozynoii.drstone.entity.PetrificationThrownEntity;
import net.clozynoii.drstone.configuration.DrStoneConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class PetrificateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double range = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) (50 * (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters),
					((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters / 4),
					((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters / 4),
					((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters / 4), 0);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world
					.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters) / 2d), e -> true)
					.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof PetrificationThrownEntity) {
					entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
					entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				}
				if (entityiterator instanceof Player) {
					if (!(entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(DrstoneModMobEffects.PETRIFIED.get()))) {
						{
							double _setval = (double) DrStoneConfigConfiguration.NATURALUNPETRIFY.get();
							entityiterator.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.NaturalUnpetrify = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
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
				if (entityiterator instanceof Villager) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = DrstoneModEntities.STONE_VILLAGER.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}

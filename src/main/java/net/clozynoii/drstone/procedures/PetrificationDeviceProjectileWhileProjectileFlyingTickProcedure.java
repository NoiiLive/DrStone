package net.clozynoii.drstone.procedures;

import net.minecraftforge.eventbus.api.Event;

public class PetrificationDeviceProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceSeconds == 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 25, (entity.getPersistentData().getDouble("petrificationspread")), (entity.getPersistentData().getDouble("petrificationspread")),
						(entity.getPersistentData().getDouble("petrificationspread")), 0);
			if (entity.getPersistentData().getDouble("petrificationspread") < (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters) {
				entity.getPersistentData().putDouble("petrificationspread", (entity.getPersistentData().getDouble("petrificationspread") + 1));
			} else if (entity.getPersistentData().getDouble("petrificationspread") >= (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).DeviceMeters) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(DrstoneModItems.PETRIFICATION_DEVICE.get()));
					entityToSpawn.setPickUpDelay(1);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("petrificationspread")) / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (!(immediatesourceentity == entityiterator)) {
							if (entityiterator instanceof StoneVillagerEntity) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = DrstoneModEntities.STONE_VILLAGER.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (entityiterator instanceof Player) {
								if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DrstoneModEntities.STONE_HUMAN_PLAYER_1.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (((Entity) world.getEntitiesOfClass(StoneHumanPlayer1Entity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).stream()
											.sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
										_toTame.tame(_owner);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 99999, 0));
								} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DrstoneModEntities.STONE_HUMAN_PLAYER_2.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (((Entity) world.getEntitiesOfClass(StoneHumanPlayer2Entity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).stream()
											.sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
										_toTame.tame(_owner);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 99999, 0));
								} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DrstoneModEntities.STONE_HUMAN_PLAYER_3.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (((Entity) world.getEntitiesOfClass(StoneHumanPlayer3Entity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).stream()
											.sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
										_toTame.tame(_owner);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 99999, 0));
								} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 4) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = DrstoneModEntities.STONE_HUMAN_PLAYER_4.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (((Entity) world.getEntitiesOfClass(StoneHumanPlayer4Entity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).stream()
											.sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()))).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
										_toTame.tame(_owner);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DrstoneModMobEffects.PETRIFIED.get(), 99999, 0));
								}
							}
						}
					}
				}
			}
		}
	}
}

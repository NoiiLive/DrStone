
package net.clozynoii.drstone.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PetrificationDeviceProjectileEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public PetrificationDeviceProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(DrstoneModEntities.PETRIFICATION_DEVICE_PROJECTILE.get(), world);
	}

	public PetrificationDeviceProjectileEntity(EntityType<? extends PetrificationDeviceProjectileEntity> type, Level world) {
		super(type, world);
	}

	public PetrificationDeviceProjectileEntity(EntityType<? extends PetrificationDeviceProjectileEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PetrificationDeviceProjectileEntity(EntityType<? extends PetrificationDeviceProjectileEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		PetrificationDeviceProjectileWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this.getOwner(), this);
		if (this.inGround)
			this.discard();
	}

	public static PetrificationDeviceProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 0.5f, 0, 0);
	}

	public static PetrificationDeviceProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 0.5f, 0, 0);
	}

	public static PetrificationDeviceProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PetrificationDeviceProjectileEntity entityarrow = new PetrificationDeviceProjectileEntity(DrstoneModEntities.PETRIFICATION_DEVICE_PROJECTILE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static PetrificationDeviceProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
		PetrificationDeviceProjectileEntity entityarrow = new PetrificationDeviceProjectileEntity(DrstoneModEntities.PETRIFICATION_DEVICE_PROJECTILE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.5f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}

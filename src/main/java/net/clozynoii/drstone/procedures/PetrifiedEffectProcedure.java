package net.clozynoii.drstone.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModBlocks;

public class PetrifiedEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 9, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 9, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 0, false, false));
		if (entity.onGround()) {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MILK_BUCKET) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == DrstoneModBlocks.MIRACLE_DRIPSTONE.get() || (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == DrstoneModBlocks.MIRACLE_DRIPSTONE.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == DrstoneModBlocks.MIRACLE_DRIPSTONE.get()) {
			if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).NaturalUnpetrify > 1) {
				{
					double _setval = (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).NaturalUnpetrify - 1;
					entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NaturalUnpetrify = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).FirstAwaken > 1) {
			{
				double _setval = (entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).FirstAwaken - 1;
				entity.getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FirstAwaken = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

package net.clozynoii.drstone.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.BlockPos;

import net.clozynoii.drstone.network.DrstoneModVariables;
import net.clozynoii.drstone.init.DrstoneModParticleTypes;
import net.clozynoii.drstone.init.DrstoneModMobEffects;
import net.clozynoii.drstone.init.DrstoneModItems;
import net.clozynoii.drstone.DrstoneMod;

public class UnpetrifyPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(DrstoneModMobEffects.PETRIFIED.get()))) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == DrstoneModItems.REVIVAL_FLUID.get()) {
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(DrstoneModItems.REVIVAL_FLUID.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				DrstoneMod.queueServerWork(1, () -> {
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(DrstoneModItems.COOKED_CLAY_CUP.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				});
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (DrstoneModParticleTypes.MIRACLE_DRIP.get()), x, (y + 2), z, 20, 0.25, 0.25, 0.25, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				DrstoneMod.queueServerWork(30, () -> {
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new BlockParticleOption(ParticleTypes.BLOCK, Blocks.STONE.defaultBlockState())), x, (y + 1), z, 35, 0.5, 0.5, 0.5, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.break")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.break")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity)
						_entity.removeAllEffects();
					if (!entity.level().isClientSide())
						entity.discard();
					if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DrstoneModVariables.PlayerVariables())).FirstUnpetrify == false) {
						{
							boolean _setval = true;
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(DrstoneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstUnpetrify = _setval;
								capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
							});
						}
					}
				});
			}
		}
	}
}

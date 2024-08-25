
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.clozynoii.drstone.entity.StoneVillagerEntity;
import net.clozynoii.drstone.entity.StoneVillagerBrokenEntity;
import net.clozynoii.drstone.entity.StoneHumanPlayer4Entity;
import net.clozynoii.drstone.entity.StoneHumanPlayer3Entity;
import net.clozynoii.drstone.entity.StoneHumanPlayer2Entity;
import net.clozynoii.drstone.entity.StoneHumanPlayer1Entity;
import net.clozynoii.drstone.DrstoneMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrstoneModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DrstoneMod.MODID);
	public static final RegistryObject<EntityType<StoneHumanPlayer1Entity>> STONE_HUMAN_PLAYER_1 = register("stone_human_player_1", EntityType.Builder.<StoneHumanPlayer1Entity>of(StoneHumanPlayer1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneHumanPlayer1Entity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<StoneHumanPlayer2Entity>> STONE_HUMAN_PLAYER_2 = register("stone_human_player_2", EntityType.Builder.<StoneHumanPlayer2Entity>of(StoneHumanPlayer2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneHumanPlayer2Entity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<StoneHumanPlayer3Entity>> STONE_HUMAN_PLAYER_3 = register("stone_human_player_3", EntityType.Builder.<StoneHumanPlayer3Entity>of(StoneHumanPlayer3Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneHumanPlayer3Entity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<StoneHumanPlayer4Entity>> STONE_HUMAN_PLAYER_4 = register("stone_human_player_4", EntityType.Builder.<StoneHumanPlayer4Entity>of(StoneHumanPlayer4Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneHumanPlayer4Entity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<StoneVillagerEntity>> STONE_VILLAGER = register("stone_villager", EntityType.Builder.<StoneVillagerEntity>of(StoneVillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(StoneVillagerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StoneVillagerBrokenEntity>> STONE_VILLAGER_BROKEN = register("stone_villager_broken", EntityType.Builder.<StoneVillagerBrokenEntity>of(StoneVillagerBrokenEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(StoneVillagerBrokenEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			StoneHumanPlayer1Entity.init();
			StoneHumanPlayer2Entity.init();
			StoneHumanPlayer3Entity.init();
			StoneHumanPlayer4Entity.init();
			StoneVillagerEntity.init();
			StoneVillagerBrokenEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(STONE_HUMAN_PLAYER_1.get(), StoneHumanPlayer1Entity.createAttributes().build());
		event.put(STONE_HUMAN_PLAYER_2.get(), StoneHumanPlayer2Entity.createAttributes().build());
		event.put(STONE_HUMAN_PLAYER_3.get(), StoneHumanPlayer3Entity.createAttributes().build());
		event.put(STONE_HUMAN_PLAYER_4.get(), StoneHumanPlayer4Entity.createAttributes().build());
		event.put(STONE_VILLAGER.get(), StoneVillagerEntity.createAttributes().build());
		event.put(STONE_VILLAGER_BROKEN.get(), StoneVillagerBrokenEntity.createAttributes().build());
	}
}

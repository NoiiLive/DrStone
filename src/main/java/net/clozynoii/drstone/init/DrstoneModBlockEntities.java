
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.clozynoii.drstone.block.entity.StompingPotTileEntity;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DrstoneMod.MODID);
	public static final RegistryObject<BlockEntityType<StompingPotTileEntity>> STOMPING_POT = REGISTRY.register("stomping_pot", () -> BlockEntityType.Builder.of(StompingPotTileEntity::new, DrstoneModBlocks.STOMPING_POT.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.clozynoii.drstone.block.entity.SweetberryWineClayPotBlockEntity;
import net.clozynoii.drstone.block.entity.StompingPotTileEntity;
import net.clozynoii.drstone.block.entity.MixingPotTileEntity;
import net.clozynoii.drstone.block.entity.GrapeWineClayPotBlockEntity;
import net.clozynoii.drstone.block.entity.GlowberryWineClayPotBlockEntity;
import net.clozynoii.drstone.block.entity.DistillingPotTileEntity;
import net.clozynoii.drstone.block.entity.ClayPotBlockEntity;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DrstoneMod.MODID);
	public static final RegistryObject<BlockEntityType<StompingPotTileEntity>> STOMPING_POT = REGISTRY.register("stomping_pot", () -> BlockEntityType.Builder.of(StompingPotTileEntity::new, DrstoneModBlocks.STOMPING_POT.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CLAY_POT = register("clay_pot", DrstoneModBlocks.CLAY_POT, ClayPotBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOWBERRY_WINE_CLAY_POT = register("glowberry_wine_clay_pot", DrstoneModBlocks.GLOWBERRY_WINE_CLAY_POT, GlowberryWineClayPotBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRAPE_WINE_CLAY_POT = register("grape_wine_clay_pot", DrstoneModBlocks.GRAPE_WINE_CLAY_POT, GrapeWineClayPotBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SWEETBERRY_WINE_CLAY_POT = register("sweetberry_wine_clay_pot", DrstoneModBlocks.SWEETBERRY_WINE_CLAY_POT, SweetberryWineClayPotBlockEntity::new);
	public static final RegistryObject<BlockEntityType<MixingPotTileEntity>> MIXING_POT = REGISTRY.register("mixing_pot", () -> BlockEntityType.Builder.of(MixingPotTileEntity::new, DrstoneModBlocks.MIXING_POT.get()).build(null));
	public static final RegistryObject<BlockEntityType<DistillingPotTileEntity>> DISTILLING_POT = REGISTRY.register("distilling_pot", () -> BlockEntityType.Builder.of(DistillingPotTileEntity::new, DrstoneModBlocks.DISTILLING_POT.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

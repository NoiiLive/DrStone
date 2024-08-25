
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.clozynoii.drstone.block.GrapeBushVineMatureBlock;
import net.clozynoii.drstone.block.GrapeBushVineBlock;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DrstoneMod.MODID);
	public static final RegistryObject<Block> GRAPE_BUSH_VINE = REGISTRY.register("grape_bush_vine", () -> new GrapeBushVineBlock());
	public static final RegistryObject<Block> GRAPE_BUSH_VINE_MATURE = REGISTRY.register("grape_bush_vine_mature", () -> new GrapeBushVineMatureBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

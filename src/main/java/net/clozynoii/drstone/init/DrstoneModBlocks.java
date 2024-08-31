
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.clozynoii.drstone.block.SweetberryWineClayPotBlock;
import net.clozynoii.drstone.block.SweetberryJuiceCupBlock;
import net.clozynoii.drstone.block.StompingPotBlock;
import net.clozynoii.drstone.block.GrapeWineClayPotBlock;
import net.clozynoii.drstone.block.GrapeJuiceCupBlock;
import net.clozynoii.drstone.block.GrapeBushVineMatureBlock;
import net.clozynoii.drstone.block.GrapeBushVineBlock;
import net.clozynoii.drstone.block.GlowberryWineClayPotBlock;
import net.clozynoii.drstone.block.GlowberryJuiceCupBlock;
import net.clozynoii.drstone.block.EmptyCupBlock;
import net.clozynoii.drstone.block.ClayPotBlock;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DrstoneMod.MODID);
	public static final RegistryObject<Block> GRAPE_BUSH_VINE = REGISTRY.register("grape_bush_vine", () -> new GrapeBushVineBlock());
	public static final RegistryObject<Block> GRAPE_BUSH_VINE_MATURE = REGISTRY.register("grape_bush_vine_mature", () -> new GrapeBushVineMatureBlock());
	public static final RegistryObject<Block> STOMPING_POT = REGISTRY.register("stomping_pot", () -> new StompingPotBlock());
	public static final RegistryObject<Block> EMPTY_CUP = REGISTRY.register("empty_cup", () -> new EmptyCupBlock());
	public static final RegistryObject<Block> GRAPE_JUICE_CUP = REGISTRY.register("grape_juice_cup", () -> new GrapeJuiceCupBlock());
	public static final RegistryObject<Block> SWEETBERRY_JUICE_CUP = REGISTRY.register("sweetberry_juice_cup", () -> new SweetberryJuiceCupBlock());
	public static final RegistryObject<Block> GLOWBERRY_JUICE_CUP = REGISTRY.register("glowberry_juice_cup", () -> new GlowberryJuiceCupBlock());
	public static final RegistryObject<Block> CLAY_POT = REGISTRY.register("clay_pot", () -> new ClayPotBlock());
	public static final RegistryObject<Block> GLOWBERRY_WINE_CLAY_POT = REGISTRY.register("glowberry_wine_clay_pot", () -> new GlowberryWineClayPotBlock());
	public static final RegistryObject<Block> GRAPE_WINE_CLAY_POT = REGISTRY.register("grape_wine_clay_pot", () -> new GrapeWineClayPotBlock());
	public static final RegistryObject<Block> SWEETBERRY_WINE_CLAY_POT = REGISTRY.register("sweetberry_wine_clay_pot", () -> new SweetberryWineClayPotBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

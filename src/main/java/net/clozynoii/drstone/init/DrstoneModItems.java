
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.clozynoii.drstone.item.SweetBerrySakeItem;
import net.clozynoii.drstone.item.SenkuuArmorItem;
import net.clozynoii.drstone.item.RevivalFluidItem;
import net.clozynoii.drstone.item.PetrificationDeviceItem;
import net.clozynoii.drstone.item.GrapesItem;
import net.clozynoii.drstone.item.GrapeSakeItem;
import net.clozynoii.drstone.item.GlowBerrySakeItem;
import net.clozynoii.drstone.item.FriedClayJarItem;
import net.clozynoii.drstone.item.ClayJarItem;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DrstoneMod.MODID);
	public static final RegistryObject<Item> PETRIFICATION_DEVICE = REGISTRY.register("petrification_device", () -> new PetrificationDeviceItem());
	public static final RegistryObject<Item> GRAPES = REGISTRY.register("grapes", () -> new GrapesItem());
	public static final RegistryObject<Item> GRAPE_BUSH_VINE = block(DrstoneModBlocks.GRAPE_BUSH_VINE);
	public static final RegistryObject<Item> GRAPE_BUSH_VINE_MATURE = block(DrstoneModBlocks.GRAPE_BUSH_VINE_MATURE);
	public static final RegistryObject<Item> CLAY_JAR = REGISTRY.register("clay_jar", () -> new ClayJarItem());
	public static final RegistryObject<Item> FRIED_CLAY_JAR = REGISTRY.register("fried_clay_jar", () -> new FriedClayJarItem());
	public static final RegistryObject<Item> GRAPE_SAKE = REGISTRY.register("grape_sake", () -> new GrapeSakeItem());
	public static final RegistryObject<Item> SWEET_BERRY_SAKE = REGISTRY.register("sweet_berry_sake", () -> new SweetBerrySakeItem());
	public static final RegistryObject<Item> GLOW_BERRY_SAKE = REGISTRY.register("glow_berry_sake", () -> new GlowBerrySakeItem());
	public static final RegistryObject<Item> REVIVAL_FLUID = REGISTRY.register("revival_fluid", () -> new RevivalFluidItem());
	public static final RegistryObject<Item> SENKUU_ARMOR_CHESTPLATE = REGISTRY.register("senkuu_armor_chestplate", () -> new SenkuuArmorItem.Chestplate());
	public static final RegistryObject<Item> SENKUU_ARMOR_LEGGINGS = REGISTRY.register("senkuu_armor_leggings", () -> new SenkuuArmorItem.Leggings());
	public static final RegistryObject<Item> SENKUU_ARMOR_BOOTS = REGISTRY.register("senkuu_armor_boots", () -> new SenkuuArmorItem.Boots());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

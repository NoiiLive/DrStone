
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

import net.clozynoii.drstone.item.SenkuuArmorItem;
import net.clozynoii.drstone.item.RevivalFluidItem;
import net.clozynoii.drstone.item.PetrificationDeviceItem;
import net.clozynoii.drstone.item.GrapesItem;
import net.clozynoii.drstone.item.FiredClayBrickItem;
import net.clozynoii.drstone.item.CupWineSweetberryItem;
import net.clozynoii.drstone.item.CupWineGrapeItem;
import net.clozynoii.drstone.item.CupWineGlowberryItem;
import net.clozynoii.drstone.item.CookedClayCupItem;
import net.clozynoii.drstone.item.ClayCupItem;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DrstoneMod.MODID);
	public static final RegistryObject<Item> PETRIFICATION_DEVICE = REGISTRY.register("petrification_device", () -> new PetrificationDeviceItem());
	public static final RegistryObject<Item> GRAPES = REGISTRY.register("grapes", () -> new GrapesItem());
	public static final RegistryObject<Item> GRAPE_BUSH_VINE = block(DrstoneModBlocks.GRAPE_BUSH_VINE);
	public static final RegistryObject<Item> GRAPE_BUSH_VINE_MATURE = block(DrstoneModBlocks.GRAPE_BUSH_VINE_MATURE);
	public static final RegistryObject<Item> REVIVAL_FLUID = REGISTRY.register("revival_fluid", () -> new RevivalFluidItem());
	public static final RegistryObject<Item> SENKUU_ARMOR_CHESTPLATE = REGISTRY.register("senkuu_armor_chestplate", () -> new SenkuuArmorItem.Chestplate());
	public static final RegistryObject<Item> SENKUU_ARMOR_LEGGINGS = REGISTRY.register("senkuu_armor_leggings", () -> new SenkuuArmorItem.Leggings());
	public static final RegistryObject<Item> SENKUU_ARMOR_BOOTS = REGISTRY.register("senkuu_armor_boots", () -> new SenkuuArmorItem.Boots());
	public static final RegistryObject<Item> CUP_WINE_GRAPE = REGISTRY.register("cup_wine_grape", () -> new CupWineGrapeItem());
	public static final RegistryObject<Item> CUP_WINE_SWEETBERRY = REGISTRY.register("cup_wine_sweetberry", () -> new CupWineSweetberryItem());
	public static final RegistryObject<Item> CUP_WINE_GLOWBERRY = REGISTRY.register("cup_wine_glowberry", () -> new CupWineGlowberryItem());
	public static final RegistryObject<Item> CLAY_CUP = REGISTRY.register("clay_cup", () -> new ClayCupItem());
	public static final RegistryObject<Item> COOKED_CLAY_CUP = REGISTRY.register("cooked_clay_cup", () -> new CookedClayCupItem());
	public static final RegistryObject<Item> FIRED_CLAY_BRICK = REGISTRY.register("fired_clay_brick", () -> new FiredClayBrickItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

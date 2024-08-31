
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

import net.clozynoii.drstone.item.SweetberryWineItem;
import net.clozynoii.drstone.item.SenkuuArmorItem;
import net.clozynoii.drstone.item.RevivalFluidItem;
import net.clozynoii.drstone.item.PetrificationDeviceItem;
import net.clozynoii.drstone.item.GrapesItem;
import net.clozynoii.drstone.item.GrapeWineItem;
import net.clozynoii.drstone.item.GlowberryWineItem;
import net.clozynoii.drstone.item.FiredClayBrickItem;
import net.clozynoii.drstone.item.CupSweetberryJuiceItem;
import net.clozynoii.drstone.item.CupGrapeJuiceItem;
import net.clozynoii.drstone.item.CupGlowberryJuiceItem;
import net.clozynoii.drstone.item.CookedClayCupItem;
import net.clozynoii.drstone.item.ClayCupItem;
import net.clozynoii.drstone.block.display.StompingPotDisplayItem;
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
	public static final RegistryObject<Item> CLAY_CUP = REGISTRY.register("clay_cup", () -> new ClayCupItem());
	public static final RegistryObject<Item> COOKED_CLAY_CUP = REGISTRY.register("cooked_clay_cup", () -> new CookedClayCupItem());
	public static final RegistryObject<Item> FIRED_CLAY_BRICK = REGISTRY.register("fired_clay_brick", () -> new FiredClayBrickItem());
	public static final RegistryObject<Item> STOMPING_POT = REGISTRY.register(DrstoneModBlocks.STOMPING_POT.getId().getPath(), () -> new StompingPotDisplayItem(DrstoneModBlocks.STOMPING_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> EMPTY_CUP = block(DrstoneModBlocks.EMPTY_CUP);
	public static final RegistryObject<Item> GRAPE_WINE = REGISTRY.register("grape_wine", () -> new GrapeWineItem());
	public static final RegistryObject<Item> CUP_GRAPE_JUICE = REGISTRY.register("cup_grape_juice", () -> new CupGrapeJuiceItem());
	public static final RegistryObject<Item> GLOWBERRY_JUICE_CUP = block(DrstoneModBlocks.GLOWBERRY_JUICE_CUP);
	public static final RegistryObject<Item> SWEETBERRY_JUICE_CUP = block(DrstoneModBlocks.SWEETBERRY_JUICE_CUP);
	public static final RegistryObject<Item> CUP_SWEETBERRY_JUICE = REGISTRY.register("cup_sweetberry_juice", () -> new CupSweetberryJuiceItem());
	public static final RegistryObject<Item> GLOWBERRY_WINE = REGISTRY.register("glowberry_wine", () -> new GlowberryWineItem());
	public static final RegistryObject<Item> GRAPE_JUICE_CUP = block(DrstoneModBlocks.GRAPE_JUICE_CUP);
	public static final RegistryObject<Item> SWEETBERRY_WINE = REGISTRY.register("sweetberry_wine", () -> new SweetberryWineItem());
	public static final RegistryObject<Item> CUP_GLOWBERRY_JUICE = REGISTRY.register("cup_glowberry_juice", () -> new CupGlowberryJuiceItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

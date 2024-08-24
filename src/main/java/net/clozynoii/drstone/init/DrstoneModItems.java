
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.clozynoii.drstone.item.PetrificationDeviceItem;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DrstoneMod.MODID);
	public static final RegistryObject<Item> PETRIFICATION_DEVICE = REGISTRY.register("petrification_device", () -> new PetrificationDeviceItem());
	// Start of user code block custom items
	// End of user code block custom items
}

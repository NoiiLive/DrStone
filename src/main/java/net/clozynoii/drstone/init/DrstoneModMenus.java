
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.clozynoii.drstone.world.inventory.PetrificationDeviceGUIMenu;
import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DrstoneMod.MODID);
	public static final RegistryObject<MenuType<PetrificationDeviceGUIMenu>> PETRIFICATION_DEVICE_GUI = REGISTRY.register("petrification_device_gui", () -> IForgeMenuType.create(PetrificationDeviceGUIMenu::new));
}

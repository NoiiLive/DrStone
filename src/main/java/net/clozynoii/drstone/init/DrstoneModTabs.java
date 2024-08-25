
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.drstone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.drstone.DrstoneMod;

public class DrstoneModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DrstoneMod.MODID);
	public static final RegistryObject<CreativeModeTab> DR_STONE = REGISTRY.register("dr_stone",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.drstone.dr_stone")).icon(() -> new ItemStack(DrstoneModItems.PETRIFICATION_DEVICE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DrstoneModItems.PETRIFICATION_DEVICE.get());
				tabData.accept(DrstoneModItems.REVIVAL_FLUID.get());
				tabData.accept(DrstoneModItems.GRAPE_SAKE.get());
				tabData.accept(DrstoneModItems.SWEET_BERRY_SAKE.get());
				tabData.accept(DrstoneModItems.GLOW_BERRY_SAKE.get());
				tabData.accept(DrstoneModItems.FRIED_CLAY_JAR.get());
				tabData.accept(DrstoneModItems.CLAY_JAR.get());
				tabData.accept(DrstoneModItems.GRAPES.get());
			}).withSearchBar().build());
}

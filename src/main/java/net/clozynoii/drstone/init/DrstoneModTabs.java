
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
	public static final RegistryObject<CreativeModeTab> DR_DRIP = REGISTRY.register("dr_drip",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.drstone.dr_drip")).icon(() -> new ItemStack(DrstoneModItems.SENKUU_ARMOR_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DrstoneModItems.SENKUU_ARMOR_CHESTPLATE.get());
				tabData.accept(DrstoneModItems.SENKUU_ARMOR_LEGGINGS.get());
				tabData.accept(DrstoneModItems.SENKUU_ARMOR_BOOTS.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> DR_STONE = REGISTRY.register("dr_stone",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.drstone.dr_stone")).icon(() -> new ItemStack(DrstoneModItems.PETRIFICATION_DEVICE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DrstoneModItems.PETRIFICATION_DEVICE.get());
				tabData.accept(DrstoneModItems.REVIVAL_FLUID.get());
				tabData.accept(DrstoneModBlocks.DISTILLING_POT.get().asItem());
				tabData.accept(DrstoneModBlocks.STOMPING_POT.get().asItem());
				tabData.accept(DrstoneModBlocks.MIXING_POT.get().asItem());
				tabData.accept(DrstoneModBlocks.CLAY_POT.get().asItem());
				tabData.accept(DrstoneModItems.FIRED_CLAY_BRICK.get());
				tabData.accept(DrstoneModItems.CLAY_CUP.get());
				tabData.accept(DrstoneModItems.COOKED_CLAY_CUP.get());
				tabData.accept(DrstoneModItems.BAT_GUANO_CUP.get());
				tabData.accept(DrstoneModItems.CUP_DISTILLED_ALCOHOL.get());
				tabData.accept(DrstoneModItems.GRAPES.get());
				tabData.accept(DrstoneModItems.CUP_GRAPE_JUICE.get());
				tabData.accept(DrstoneModItems.GRAPE_WINE.get());
				tabData.accept(DrstoneModItems.CUP_SWEETBERRY_JUICE.get());
				tabData.accept(DrstoneModItems.SWEETBERRY_WINE.get());
				tabData.accept(DrstoneModItems.CUP_GLOWBERRY_JUICE.get());
				tabData.accept(DrstoneModItems.GLOWBERRY_WINE.get());
			}).withSearchBar().build());
}

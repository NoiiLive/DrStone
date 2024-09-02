package net.clozynoii.drstone.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.clozynoii.drstone.configuration.DrStoneConfigConfiguration;
import net.clozynoii.drstone.DrstoneMod;

@Mod.EventBusSubscriber(modid = DrstoneMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrstoneModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DrStoneConfigConfiguration.SPEC, "drstone_main.toml");
		});
	}
}

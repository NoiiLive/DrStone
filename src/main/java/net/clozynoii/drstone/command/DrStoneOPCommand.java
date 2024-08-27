
package net.clozynoii.drstone.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class DrStoneOPCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("drstone").requires(s -> s.hasPermission(2)).then(Commands.literal("masspetrify")));
	}
}

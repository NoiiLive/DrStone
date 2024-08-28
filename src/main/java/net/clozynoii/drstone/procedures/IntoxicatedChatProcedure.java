package net.clozynoii.drstone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.clozynoii.drstone.init.DrstoneModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IntoxicatedChatProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		String drunkText = "";
		double random = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(DrstoneModMobEffects.INTOXICATED.get())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
			drunkText = text;
			drunkText = drunkText.replace("er", "r");
			drunkText = drunkText.replace("ER", "R");
			random = Mth.nextInt(RandomSource.create(), 1, 2);
			if (random == 1) {
				drunkText = drunkText.replace("th", "f");
				drunkText = drunkText.replace("TH", "F");
			}
			if (random == 2) {
				drunkText = drunkText.replace("th", "d");
				drunkText = drunkText.replace("TH", "D");
			}
			drunkText = drunkText.replace("ck", "k");
			drunkText = drunkText.replace("CK", "K");
			drunkText = drunkText.replace("!", "~");
			drunkText = drunkText.replace(".", "...");
			random = Mth.nextInt(RandomSource.create(), 1, 5);
			if (random == 1) {
				drunkText = drunkText.replace("a", "");
				drunkText = drunkText.replace("A", "");
			}
			if (random == 2) {
				drunkText = drunkText.replace("e", "");
				drunkText = drunkText.replace("E", "");
			}
			if (random == 3) {
				drunkText = drunkText.replace("i", "");
				drunkText = drunkText.replace("I", "");
			}
			if (random == 4) {
				drunkText = drunkText.replace("o", "");
				drunkText = drunkText.replace("O", "");
			}
			if (random == 5) {
				drunkText = drunkText.replace("u", "");
				drunkText = drunkText.replace("U", "");
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + drunkText)), false);
		}
	}
}

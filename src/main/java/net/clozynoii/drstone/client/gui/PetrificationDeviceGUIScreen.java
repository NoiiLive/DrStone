package net.clozynoii.drstone.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.clozynoii.drstone.world.inventory.PetrificationDeviceGUIMenu;
import net.clozynoii.drstone.network.PetrificationDeviceGUIButtonMessage;
import net.clozynoii.drstone.DrstoneMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PetrificationDeviceGUIScreen extends AbstractContainerScreen<PetrificationDeviceGUIMenu> {
	private final static HashMap<String, Object> guistate = PetrificationDeviceGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Meters;
	EditBox Seconds;
	Button button_set_conditions;

	public PetrificationDeviceGUIScreen(PetrificationDeviceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("drstone:textures/screens/petrification_device_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Meters.render(guiGraphics, mouseX, mouseY, partialTicks);
		Seconds.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Meters.isFocused())
			return Meters.keyPressed(key, b, c);
		if (Seconds.isFocused())
			return Seconds.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Meters.tick();
		Seconds.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String MetersValue = Meters.getValue();
		String SecondsValue = Seconds.getValue();
		super.resize(minecraft, width, height);
		Meters.setValue(MetersValue);
		Seconds.setValue(SecondsValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.drstone.petrification_device_gui.label_meters"), -17, -32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.drstone.petrification_device_gui.label_seconds"), -21, 8, -1, false);
	}

	@Override
	public void init() {
		super.init();
		Meters = new EditBox(this.font, this.leftPos + -30, this.topPos + -56, 58, 18, Component.translatable("gui.drstone.petrification_device_gui.Meters")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Meters").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Meters").getString());
				else
					setSuggestion(null);
			}
		};
		Meters.setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Meters").getString());
		Meters.setMaxLength(32767);
		guistate.put("text:Meters", Meters);
		this.addWidget(this.Meters);
		Seconds = new EditBox(this.font, this.leftPos + -30, this.topPos + -16, 58, 18, Component.translatable("gui.drstone.petrification_device_gui.Seconds")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Seconds").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Seconds").getString());
				else
					setSuggestion(null);
			}
		};
		Seconds.setSuggestion(Component.translatable("gui.drstone.petrification_device_gui.Seconds").getString());
		Seconds.setMaxLength(32767);
		guistate.put("text:Seconds", Seconds);
		this.addWidget(this.Seconds);
		button_set_conditions = Button.builder(Component.translatable("gui.drstone.petrification_device_gui.button_set_conditions"), e -> {
			if (true) {
				DrstoneMod.PACKET_HANDLER.sendToServer(new PetrificationDeviceGUIButtonMessage(0, x, y, z));
				PetrificationDeviceGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -49, this.topPos + 23, 98, 20).build();
		guistate.put("button:button_set_conditions", button_set_conditions);
		this.addRenderableWidget(button_set_conditions);
	}
}

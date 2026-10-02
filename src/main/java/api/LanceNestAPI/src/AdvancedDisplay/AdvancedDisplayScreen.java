package api.LanceNestAPI.src.AdvancedDisplay;

import java.awt.Color;

import api.LanceNestAPI.src.ui.IntWidget;
import api.LanceNestAPI.src.ui.Vector3Widget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdvancedDisplayScreen extends AbstractContainerScreen<AdvancedDisplayMenu> {

	IntWidget index;

	Vector3Widget pos;
	Vector3Widget rot;
	Vector3Widget scale;
	Vector3Widget origin;

	public AdvancedDisplayScreen(AdvancedDisplayMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		index = new IntWidget(s -> Integer.parseInt(s)).setLimit(0, AdvancedDisplayBlockEntity.NUM_SLOTS - 1);

		pos = new Vector3Widget();
		rot = new Vector3Widget();
		scale = new Vector3Widget();
		origin = new Vector3Widget();
	}

	@Override
	protected void init() {
		super.init();

		index.init(this, leftPos, topPos, 10, font, title);

		pos.init(this, leftPos - 66, topPos + 28, font, true, Color.DARK_GRAY, "Position");
		rot.init(this, leftPos - 66, topPos + 56, font, true, Color.DARK_GRAY, "Rotation");
		scale.init(this, leftPos - 66, topPos + 84, font, true, Color.DARK_GRAY, "Scale");
		origin.init(this, leftPos - 66, topPos + 112, font, true, Color.DARK_GRAY, "Origin");
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		pos.render(guiGraphics, partialTick, mouseX, mouseY, font);
		rot.render(guiGraphics, partialTick, mouseX, mouseY, font);
		scale.render(guiGraphics, partialTick, mouseX, mouseY, font);
		origin.render(guiGraphics, partialTick, mouseX, mouseY, font);
	}

	@Override
	public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
//	        this.renderTransparentBackground(guiGraphics);
		this.renderBg(guiGraphics, partialTick, mouseX, mouseY);

		guiGraphics.drawString(font, this.menu.slots.get(index.get()).getItem().getDisplayName(), this.leftPos,
				this.topPos, Color.white.getRGB());
	}

}

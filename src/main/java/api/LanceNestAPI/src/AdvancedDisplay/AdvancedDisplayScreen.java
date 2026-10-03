package api.LanceNestAPI.src.AdvancedDisplay;

import java.awt.Color;

import org.joml.Vector3f;

import api.LanceNestAPI.src.ui.IntWidget;
import api.LanceNestAPI.src.ui.Vector3Widget;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdvancedDisplayScreen extends AbstractContainerScreen<AdvancedDisplayMenu> {

	int i = 0;
	IntWidget index;

	Vector3Widget pos;
	Vector3Widget rot;
	Vector3Widget scale;
	Vector3Widget origin;

	Vector3f vPos = new Vector3f();
	Vector3f vRot = new Vector3f();
	Vector3f vScale = new Vector3f();
	Vector3f vOrigin = new Vector3f();

	public AdvancedDisplayScreen(AdvancedDisplayMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		index = new IntWidget(s -> {
			if (!s.isEmpty())
				i = Integer.parseInt(s);
			else
				i = 0;

			Transform t = menu.tileEntity.getItemTransform(i);
			pos.set(t.getTranslate());
			rot.set(t.getRotation());
			scale.set(t.getScale());
			origin.set(t.getOrigin());

		}).setLimit(0, AdvancedDisplayBlockEntity.NUM_SLOTS - 1);

		pos = new Vector3Widget(v -> menu.tileEntity.getItemTransform(i).setTranslate(v));
		rot = new Vector3Widget(v -> menu.tileEntity.getItemTransform(i).setRotation(v));
		scale = new Vector3Widget(new Vector3f(1, 1, 1), v -> menu.tileEntity.getItemTransform(i).setScale(v));
		origin = new Vector3Widget(v -> menu.tileEntity.getItemTransform(i).setOrigin(v));
	}

	@Override
	protected void init() {
		super.init();

		index.init(this, leftPos - 120, topPos, 14, font, title, true, Color.DARK_GRAY, "Current");

		pos.init(this, leftPos - 120, topPos + 28, font, true, Color.DARK_GRAY, "Position");
		rot.init(this, leftPos - 120, topPos + 56, font, true, Color.DARK_GRAY, "Rotation");
		scale.init(this, leftPos - 120, topPos + 84, font, true, Color.DARK_GRAY, "Scale");
		origin.init(this, leftPos - 120, topPos + 112, font, true, Color.DARK_GRAY, "Origin");
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		index.render(guiGraphics, partialTick, mouseY, mouseY);
		pos.render(guiGraphics, partialTick, mouseX, mouseY, font);
		rot.render(guiGraphics, partialTick, mouseX, mouseY, font);
		scale.render(guiGraphics, partialTick, mouseX, mouseY, font);
		origin.render(guiGraphics, partialTick, mouseX, mouseY, font);
	}

	@Override
	public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
//	        this.renderTransparentBackground(guiGraphics);
		this.renderBg(guiGraphics, partialTick, mouseX, mouseY);

		guiGraphics.drawString(font, this.menu.slots.get(index.get()).getItem().getDisplayName(), this.leftPos - 90,
				this.topPos + 3, Color.white.getRGB());
	}

}

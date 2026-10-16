package api.LanceNestAPI.src.AdvancedDisplay;

import java.awt.Color;

import org.joml.Vector3f;

import api.LanceNestAPI.src.network.AdvancedDisplaySetPacket;
import api.LanceNestAPI.src.ui.IntWidget;
import api.LanceNestAPI.src.ui.Vector3Widget;
import api.LanceNestAPI.src.util.ClipboardUtil;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;

public class AdvancedDisplayScreen extends AbstractContainerScreen<AdvancedDisplayMenu> {

	int i = 0;
	IntWidget index;

	Vector3Widget pos;
	Vector3Widget rot;
	Vector3Widget scale;
	Vector3Widget origin;

	public Button copy_button_current;
	public Button paste_button_current;
	public Button delete_button_current;

	public Button copy_button_all;
	public Button paste_button_all;
	public Button delete_button_all;

	Transform getTransform() {
		return new Transform(pos.get(), rot.get(), scale.get(), origin.get());
	}

	void setTransform(Transform t) {
		pos.set(t.getPosition());
		rot.set(t.getRotation());
		scale.set(t.getScale());
		origin.set(t.getOrigin());
	}

//	Vector3f vPos = new Vector3f();
//	Vector3f vRot = new Vector3f();
//	Vector3f vScale = new Vector3f();
//	Vector3f vOrigin = new Vector3f();

	public AdvancedDisplayScreen(AdvancedDisplayMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		index = new IntWidget(s -> {
			i = s;

			this.menu.index = i;

			Transform t = menu.tileEntity.getItemTransform(i);
			pos.set(t.getPosition());
			rot.set(t.getRotation());
			scale.set(t.getScale());
			origin.set(t.getOrigin());

		}).setLimit(0, AdvancedDisplayBlockEntity.NUM_SLOTS - 1);

		pos = new Vector3Widget(v -> {
			menu.tileEntity.getItemTransform(i).setPosition(v);
			PacketDistributor.sendToServer(
					new AdvancedDisplaySetPacket(this.menu.containerId, this.index.get(), getTransform()));
		});
		pos.addLimits(new Vector3f(1.2f, 1.2f, 1.2f), new Vector3f(-0.2f, -0.2f, -0.2f));
		pos.addBackground(Color.DARK_GRAY, Color.GRAY);
		rot = new Vector3Widget(v -> {
			menu.tileEntity.getItemTransform(i).setRotation(v);
			PacketDistributor.sendToServer(
					new AdvancedDisplaySetPacket(this.menu.containerId, this.index.get(), getTransform()));
		});
		rot.addBackground(Color.DARK_GRAY, Color.GRAY);
		scale = new Vector3Widget(new Vector3f(1, 1, 1), v -> {
			menu.tileEntity.getItemTransform(i).setScale(v);
			PacketDistributor.sendToServer(
					new AdvancedDisplaySetPacket(this.menu.containerId, this.index.get(), getTransform()));
		}) {
			@Override
			protected Vector3f defaultVector() {
				return new Vector3f(1, 1, 1);
			}
		};
		scale.addBackground(Color.DARK_GRAY, Color.GRAY);
		origin = new Vector3Widget(v -> {
			menu.tileEntity.getItemTransform(i).setOrigin(v);
			PacketDistributor.sendToServer(
					new AdvancedDisplaySetPacket(this.menu.containerId, this.index.get(), getTransform()));
		});
		origin.addBackground(Color.DARK_GRAY, Color.GRAY);

	}

	@Override
	protected void init() {
		super.init();

		int x = -140;
		int y = 14;

		Transform t = menu.tileEntity.getItemTransform(0);

		index.init(this, leftPos + x, topPos, y, font, title, true, Color.DARK_GRAY, "Current", 0);

		origin.init(this, leftPos + x, topPos + 28, font, "Origin", t.getOrigin());
		rot.init(this, leftPos + x, topPos + 56, font, "Rotation", t.getRotation());
		pos.init(this, leftPos + x, topPos + 84, font, "Position", t.getPosition());
		scale.init(this, leftPos + x, topPos + 112, font, "Scale", t.getScale());

		copy_button_current = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.copy"), p -> ClipboardUtil.copyTransform(getTransform()))
				.pos(leftPos + x, topPos + 127).size(47, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.copy"))).build());
		paste_button_current = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.paste"),
						p -> setTransform(ClipboardUtil.pasteTransform()))
				.pos(leftPos + x + 47, topPos + 127).size(47, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.paste"))).build());
		delete_button_current = this.addRenderableWidget(
				Button.builder(Component.translatable("button.widget.delete"), p -> setTransform(new Transform()))
						.pos(leftPos + x + 94, topPos + 127).size(47, 16)
						.tooltip(Tooltip.create(Component.translatable("tooltip.widget.delete"))).build());

		copy_button_all = this
				.addRenderableWidget(Button.builder(Component.translatable("button.widget.copy.all"), p -> copyAll())
						.pos(leftPos + x, topPos + 143).size(70, 16)
						.tooltip(Tooltip.create(Component.translatable("tooltip.widget.copy.all"))).build());
		paste_button_all = this
				.addRenderableWidget(Button.builder(Component.translatable("button.widget.paste.all"), p -> pasteAll())
						.pos(leftPos + x + 71, topPos + 143).size(70, 16)
						.tooltip(Tooltip.create(Component.translatable("tooltip.widget.paste.all"))).build());
	}

	private void copyAll() {
		String s = "";

		for (int i = 0; i < AdvancedDisplayBlockEntity.NUM_SLOTS; i++) {

			Transform t = this.menu.tileEntity.getItemTransform(i);

			if (i < AdvancedDisplayBlockEntity.NUM_SLOTS - 1)
				s += t.toString() + ".";

		}

		Minecraft.getInstance().keyboardHandler.setClipboard(s);
	}

	private void pasteAll() {

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

		guiGraphics.drawString(font, this.menu.slots.get(index.get()).getItem().getDisplayName(), this.leftPos - 110,
				this.topPos + 3, Color.white.getRGB());
	}

	public void setPos(int j, BlockPos pos2) {
//		this.pos = pos;
		BlockEntity e = this.minecraft.level.getBlockEntity(pos2);
		if (e != null) {
			if (e instanceof AdvancedDisplayBlockEntity adbe) {
				Transform t = new Transform();

				t.setOrigin(origin.get());
				t.setPosition(pos.get());
				t.setRotation(rot.get());
				t.setScale(scale.get());

				adbe.setItemTransform(j, t);

				AdvancedDisplayBlockEntity.update(adbe);
			}
		}
	}
}

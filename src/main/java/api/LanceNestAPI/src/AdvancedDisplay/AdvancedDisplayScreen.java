package api.LanceNestAPI.src.AdvancedDisplay;

import java.awt.Color;

import org.joml.Vector3f;

import com.mojang.blaze3d.systems.RenderSystem;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.network.AdvancedDisplaySetPacket;
import api.LanceNestAPI.src.ui.HideableSlot;
import api.LanceNestAPI.src.ui.HideableSlotItemHandler;
import api.LanceNestAPI.src.ui.IntWidget;
import api.LanceNestAPI.src.ui.Vector3Widget;
import api.LanceNestAPI.src.util.ClipboardUtil;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;

public class AdvancedDisplayScreen extends AbstractContainerScreen<AdvancedDisplayMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation
			.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "textures/gui/display.png");

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

	private boolean isInventory = true;
	public Button switchBetween;

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
		pos.addLimits(new Vector3f(0.5f, 0.5f, 0.5f), new Vector3f(-0.5f, -0.5f, -0.5f));
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
			public Vector3f defaultVector() {
				return new Vector3f(1, 1, 1);
			}
		};
		scale.addLimits(new Vector3f(2f, 2f, 2f), new Vector3f(0.1f, 0.1f, 0.1f));
		scale.addBackground(Color.DARK_GRAY, Color.GRAY);

		origin = new Vector3Widget(v -> {
			menu.tileEntity.getItemTransform(i).setOrigin(v);
			PacketDistributor.sendToServer(
					new AdvancedDisplaySetPacket(this.menu.containerId, this.index.get(), getTransform()));
		}) {
			@Override
			public Vector3f defaultVector() {
				return new Vector3f(0.5f, 0.5f, 0.5f);
			}
		};
		origin.addLimits(new Vector3f(1.2f, 1.2f, 1.2f), new Vector3f(-0.2f, -0.2f, -0.2f));
		origin.addBackground(Color.DARK_GRAY, Color.GRAY);

	}

	@Override
	protected void init() {
		super.init();

		int x = -140;
		int y = 14;

		Transform t = menu.tileEntity.getItemTransform(0);

		index.init(this, 0, topPos, y, font, title, true, Color.DARK_GRAY, "widget.current", 0);

		origin.init(this, 0, topPos + 28, font, "widget.origin", t.getOrigin());
		rot.init(this, 0, topPos + 56, font, "widget.rotation", t.getRotation());
		pos.init(this, 0, topPos + 84, font, "widget.position", t.getPosition());
		scale.init(this, 0, topPos + 112, font, "widget.scale", t.getScale());

		copy_button_current = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.transform.copy"),
						p -> ClipboardUtil.copyTransform(getTransform()))
				.pos(0, topPos + 127).size(47, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.transform.copy"))).build());
		paste_button_current = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.transform.paste"),
						p -> setTransform(ClipboardUtil.pasteTransform()))
				.pos(0 + 47, topPos + 127).size(47, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.transform.paste"))).build());
		delete_button_current = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.transform.delete"),
						p -> setTransform(new Transform(pos.defaultVector(), rot.defaultVector(), scale.defaultVector(),
								origin.defaultVector())))
				.pos(0 + 94, topPos + 127).size(47, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.transform.delete"))).build());

		copy_button_all = this.addRenderableWidget(
				Button.builder(Component.translatable("button.widget.transform.copy.all"), p -> copyAll())
						.pos(0, topPos + 143).size(70, 16)
						.tooltip(Tooltip.create(Component.translatable("tooltip.widget.transform.copy.all"))).build());
		paste_button_all = this.addRenderableWidget(
				Button.builder(Component.translatable("button.widget.transform.paste.all"), p -> pasteAll())
						.pos(0 + 71, topPos + 143).size(70, 16)
						.tooltip(Tooltip.create(Component.translatable("tooltip.widget.transform.paste.all"))).build());

		switchBetween = this.addRenderableWidget(Button
				.builder(Component.translatable("button.widget.advanced_display.switch"), p -> hide(!isInventory))
				.pos(0, topPos + 159).size(141, 16)
				.tooltip(Tooltip.create(Component.translatable("tooltip.widget.advanced_display.switch"))).build());

		this.hide(true);
	}

	private void copyAll() {
		String s = "";

		for (int i = 0; i < AdvancedDisplayBlockEntity.NUM_SLOTS; i++) {

			Transform t = this.menu.tileEntity.getItemTransform(i);
			s += t.toString();
			if (i < AdvancedDisplayBlockEntity.NUM_SLOTS - 1)
				s += "_";

		}

		Minecraft.getInstance().keyboardHandler.setClipboard(s);
	}

	private void pasteAll() {
		String s = Minecraft.getInstance().keyboardHandler.getClipboard();
		String[] t = s.split("_");

		if (t.length >= 8)
			for (int i = 0; i < AdvancedDisplayBlockEntity.NUM_SLOTS-1; i++) {
				Transform tr = ClipboardUtil.pasteTransform(t[i]);

				this.menu.tileEntity.setItemTransform(i, tr);
				AdvancedDisplayBlockEntity.update(this.menu.tileEntity);
			}
		else
			Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.VILLAGER_NO, 1, 1));
	}

	public void hide(boolean h) {
		index.hide(h);

		pos.hide(h);
		rot.hide(h);
		scale.hide(h);
		origin.hide(h);

		copy_button_current.visible = !h;
		paste_button_current.visible = !h;
		delete_button_current.visible = !h;

		copy_button_all.visible = !h;
		paste_button_all.visible = !h;

		isInventory = h;

		this.menu.slots.forEach(s -> {
			if (s instanceof HideableSlot slot) {
				slot.setActive(h);
			} else if (s instanceof HideableSlotItemHandler slot) {
				slot.setActive(h);
			}
		});
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
//		guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
//		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY,
//				4210752, false);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		if (!isInventory) {
			index.render(guiGraphics, partialTick, mouseY, mouseY);
			pos.render(guiGraphics, partialTick, mouseX, mouseY, font);
			rot.render(guiGraphics, partialTick, mouseX, mouseY, font);
			scale.render(guiGraphics, partialTick, mouseX, mouseY, font);
			origin.render(guiGraphics, partialTick, mouseX, mouseY, font);
		} else {
			RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
			guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos + 60, 0, 0, 175, 90);
			guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos + 44, this.topPos + 18, 0, 90, 86, 46);
		}
	}

	@Override
	public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		if (!isInventory) {
			guiGraphics.drawString(font, this.menu.slots.get(index.get()).getItem().getDisplayName(), 30,
					this.topPos + 3, Color.white.getRGB());
		} else
			this.renderTransparentBackground(guiGraphics);

		this.renderBg(guiGraphics, partialTick, mouseX, mouseY);
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

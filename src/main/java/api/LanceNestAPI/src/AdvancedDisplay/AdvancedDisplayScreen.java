package api.LanceNestAPI.src.AdvancedDisplay;

import java.awt.Color;

import org.joml.Vector3f;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.InputConstants.Key;

import api.LanceNestAPI.src.network.AdvancedDisplaySetPacket;
import api.LanceNestAPI.src.ui.IntWidget;
import api.LanceNestAPI.src.ui.Vector3Widget;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.client.gui.GuiGraphics;
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

	Transform getTransform() {
		return new Transform(pos.get(), rot.get(), scale.get(), origin.get());
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
//			AdvancedDisplayBlockEntity.update(menu.tileEntity);
		});
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
		});
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

		Transform t = menu.tileEntity.getItemTransform(0);
//		pos.set(t.getPosition());
//		rot.set(t.getRotation());
//		scale.set(t.getScale());
//		origin.set(t.getOrigin());

		index.init(this, leftPos - 120, topPos, 14, font, title, true, Color.DARK_GRAY, "Current", 0);

		origin.init(this, leftPos - 120, topPos + 28, font, "Origin", t.getOrigin());
		rot.init(this, leftPos - 120, topPos + 56, font, "Rotation", t.getRotation());
		pos.init(this, leftPos - 120, topPos + 84, font, "Position", t.getPosition());
		scale.init(this, leftPos - 120, topPos + 112, font, "Scale", t.getScale());

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

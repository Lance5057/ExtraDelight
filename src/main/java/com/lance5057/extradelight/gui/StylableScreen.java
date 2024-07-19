package com.lance5057.extradelight.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class StylableScreen extends AbstractContainerScreen<StyleableMenu> {

	private PageButton forwardButton;

	public StylableScreen(StyleableMenu p_99310_, Inventory p_99311_, Component p_99312_) {
		super(p_99310_, p_99311_, p_99312_);
	}

	@Override
	protected void init() {
		this.forwardButton = this.addRenderableWidget(new PageButton(116, 159, true, p_98144_ -> style(), true));
	}

	@Override
	public void render(GuiGraphics p_281735_, int p_282517_, int p_282840_, float p_282389_) {
		super.render(p_281735_, p_282517_, p_282840_, p_282389_);
	}

	@Override
	protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
		// TODO Auto-generated method stub

	}

	void style() {
		this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 0);
	}
}

package com.lance5057.extradelight.gui;

import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

public class StylableScreen extends AbstractContainerScreen<StyleableMenu> {

	private PageButton forwardButton;
	private PageButton backwardButton;

	private static ResourceLocation BACKGROUND = new ResourceLocation(ExtraDelight.MOD_ID,
			"textures/gui/styleable.png");

	private int current = 0;

	public StylableScreen(StyleableMenu p_99310_, Inventory p_99311_, Component p_99312_) {

		super(p_99310_, p_99311_, p_99312_);
	}

	@Override
	protected void init() {
		this.forwardButton = this.addRenderableWidget(new PageButton(116, 159, true, p_98144_ -> style(), true));
		this.backwardButton = this.addRenderableWidget(new PageButton(116, 159, false, p_98144_ -> style(), true));
	}

	@Override
	public void render(GuiGraphics p_281735_, int p_282517_, int p_282840_, float p_282389_) {
		super.render(p_281735_, p_282517_, p_282840_, p_282389_);

		RenderSystem.setShaderTexture(0, BACKGROUND);
		p_281735_.blit(BACKGROUND, this.leftPos, this.topPos, 186, 186, 70, 70);

		BlockState state = this.minecraft.level.getBlockState(this.menu.pos);
		if (state != null)
			this.minecraft.getBlockRenderer().renderSingleBlock(state, p_281735_.pose(), p_281735_.bufferSource(), 0, 0,
					ModelData.EMPTY, RenderType.cutout());
	}

	@Override
	protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
		// TODO Auto-generated method stub

	}

	void style() {
		this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 0);
	}
}

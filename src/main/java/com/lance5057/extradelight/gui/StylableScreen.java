package com.lance5057.extradelight.gui;

import com.lance5057.extradelight.blocks.interfaces.IStyleable;

import net.minecraft.client.GameNarrator;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class StylableScreen extends Screen {
	BlockState state;
	BlockPos pos;
	Level level;

	private PageButton forwardButton;

	public StylableScreen(BlockState state, BlockPos pos, Level level) {
		super(GameNarrator.NO_TITLE);

		this.state = state;
		this.pos = pos;
		this.level = level;
	}

	@Override
	protected void init() {
		this.forwardButton = this
				.addRenderableWidget(new PageButton(116, 159, true, p_98144_ -> this.nextStyle(), true));
	}

	@Override
	public void render(GuiGraphics p_281735_, int p_282517_, int p_282840_, float p_282389_) {
		super.render(p_281735_, p_282517_, p_282840_, p_282389_);
	}

	void nextStyle() {
		if (state.getBlock() instanceof IStyleable s) {
			s.nextStyle(level, pos, state);
		}
	}
}

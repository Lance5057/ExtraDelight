package com.lance5057.extradelight.gui;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.blocks.interfaces.IStyleable;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.state.BlockState;

public class StyleableScreen extends AbstractContainerScreen<StyleableMenu> {

	private PageButton forwardButton;
	private PageButton backwardButton;

	private BlockPos pos = BlockPos.ZERO;

	private static ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"textures/gui/styleable.png");

	private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.fromNamespaceAndPath("container/stonecutter/scroller");
	private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.fromNamespaceAndPath(
			"container/stonecutter/scroller_disabled");
	private static final ResourceLocation RECIPE_SELECTED_SPRITE = ResourceLocation.fromNamespaceAndPath(
			"container/stonecutter/recipe_selected");
	private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE = ResourceLocation.fromNamespaceAndPath(
			"container/stonecutter/recipe_highlighted");
	private static final ResourceLocation RECIPE_SPRITE = ResourceLocation.fromNamespaceAndPath("container/stonecutter/recipe");
	private static final ResourceLocation BG_LOCATION = ResourceLocation.fromNamespaceAndPath("textures/gui/container/stonecutter.png");

	private float scrollOffs;
	private boolean scrolling;
	private int startIndex;
	private boolean displayRecipes;

	public StyleableScreen(StyleableMenu p_99310_, Inventory p_99311_, Component p_99312_) {

		super(p_99310_, p_99311_, p_99312_);
	}

	@Override
	protected void init() {
		super.init();
		this.inventoryLabelX = -1000;
		this.forwardButton = this.addRenderableWidget(
				new PageButton(this.leftPos+49, this.topPos+86, true, p_98144_ -> style(0), true));
		this.backwardButton = this.addRenderableWidget(
				new PageButton(this.leftPos+13, this.topPos+86, false, p_98144_ -> style(1), true));
	}

	private void renderButtons(IStyleable style, GuiGraphics p_282733_, int p_282136_, int p_282147_, int p_281987_,
			int p_281276_, int p_282688_) {
		for (int i = this.startIndex; i < p_282688_ && i < style.numStyles(); ++i) {
			int j = i - this.startIndex;
			int k = p_281987_ + j % 4 * 16;
			int l = j / 4;
			int i1 = p_281276_ + l * 18 + 2;
			ResourceLocation resourcelocation;
			if (p_282136_ >= k && p_282147_ >= i1 && p_282136_ < k + 16 && p_282147_ < i1 + 18) {
				resourcelocation = RECIPE_HIGHLIGHTED_SPRITE;
			} else {
				resourcelocation = RECIPE_SPRITE;
			}

			p_282733_.blitSprite(resourcelocation, k, i1 - 1, 16, 18);
		}
	}

	void renderBlock(GuiGraphics guiGraphics, BlockState state) {
		guiGraphics.pose().pushPose();

		RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
		guiGraphics.pose().translate(0, 0, 0);

		MultiBufferSource.BufferSource buffers = Minecraft.getInstance().renderBuffers().bufferSource();

		guiGraphics.pose().pushPose();
		guiGraphics.pose().translate(0, 0.5, 0);
		guiGraphics.pose().scale(1f, -1f, 1f);

		Minecraft.getInstance().getBlockRenderer().renderSingleBlock(state, guiGraphics.pose(), buffers, 0xffffff,
				OverlayTexture.NO_OVERLAY);

		buffers.endBatch();

		guiGraphics.pose().popPose();
		guiGraphics.pose().popPose();
	}

	private boolean isScrollBarActive(IStyleable style) {
		return style.numStyles() > 12;
	}

	@Override
	protected void renderBg(GuiGraphics gui, float p_97788_, int p_97789_, int p_97790_) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (this.minecraft == null)
			return;
		
		BlockState state = this.minecraft.level.getBlockState(this.pos);
		if (state != null) {
			if (state.getBlock() instanceof IStyleable style) {
				int i = this.leftPos+8;
				int j = this.topPos+36;

				RenderSystem.setShaderTexture(0, BACKGROUND);
				gui.blit(BACKGROUND, i, j, 97, 186, 159, 70);

				int k = (int) (41.0F * this.scrollOffs);
				ResourceLocation resourcelocation = this.isScrollBarActive(style) ? SCROLLER_SPRITE
						: SCROLLER_DISABLED_SPRITE;
				gui.blitSprite(resourcelocation, i + 138, j + k + 8, 12, 15);

				int j1 = this.startIndex + 12;
				this.renderButtons(style, gui, p_97789_, p_97790_, i + 71, j + 7, j1);

				RenderSystem.enableBlend();
				RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
				Lighting.setupForFlatItems();

				gui.pose().pushPose();
				{
					renderRecipes(state, style, gui, 87, 47, j1);
				}
				gui.pose().popPose();

				gui.pose().pushPose();
				{
					gui.pose().translate(this.leftPos + 43.5, this.topPos + 60, 100);
					gui.pose().scale(30F, 30F, 30F);

					gui.pose().mulPose(Axis.XP.rotationDegrees(-30F));
					gui.pose().mulPose(Axis.YP.rotationDegrees(-45F));

					renderBlock(gui, state);

				}
				gui.pose().popPose();

				RenderSystem.disableBlend();
			}
		}
	}

	private void renderRecipes(BlockState state, IStyleable style, GuiGraphics gui, int p_282658_, int p_282563_,
			int p_283352_) {

		for (int i = this.startIndex; i < p_283352_ && i < style.numStyles(); ++i) {
			int j = i - this.startIndex;
			int k = this.leftPos + p_282658_ + j % 4 * 16;
			int l = j / 4;
			int i1 = this.topPos + p_282563_ + l * 18 + 2;

			gui.pose().pushPose();
			{
				gui.pose().translate(k, i1 + 0.5f, 100);
				gui.pose().scale(9F, 9F, 9F);

				gui.pose().mulPose(Axis.XP.rotationDegrees(-30F));
				gui.pose().mulPose(Axis.YP.rotationDegrees(-45F));

				renderBlock(gui, style.getState(i));
			}
			gui.pose().popPose();

		}
	}

	void style(int button) {
		this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, button);
	}

	public BlockPos getPos() {
		return pos;
	}

	public void setPos(BlockPos pos) {
		this.pos = pos;
	}
}

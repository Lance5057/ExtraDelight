package com.lance5057.extradelight.gui.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlTank;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class MixingBowlFluidWidget extends AbstractWidget {

	private final Supplier<MixingBowlTank> getFluid;

	public MixingBowlFluidWidget(int x, int y, int width, int height, Supplier<MixingBowlTank> getFluid) {

		super(x, y, width, height, Component.empty());
		this.getFluid = getFluid;
	}

	@Override
	protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		Minecraft minecraft = Minecraft.getInstance();
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		MixingBowlTank fluidTank = this.getFluid.get();

		int offset = 0;
		for (int tank = 0; tank < fluidTank.getTanks(); tank++) {
			if (!fluidTank.isEmpty(tank)) {
				FluidStack fluidStack = fluidTank.getFluid(tank);
				IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluidStack.getFluid());
				ResourceLocation still = props.getStillTexture(fluidStack);
				if (still != null) {
					AbstractTexture texture = minecraft.getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
					if (texture instanceof TextureAtlas atlas) {
						TextureAtlasSprite sprite = atlas.getSprite(still);

						int color = props.getTintColor();
						RenderSystem.setShaderColor(FastColor.ARGB32.red(color) / 255.0F,
								FastColor.ARGB32.green(color) / 255.0F, FastColor.ARGB32.blue(color) / 255.0F,
								FastColor.ARGB32.alpha(color) / 255.0F);
						RenderSystem.enableBlend();

						int stored = fluidTank.getFluidAmount(tank);
						float capacity = fluidTank.getCapacity(tank);
						float filledVolume = stored / capacity;
						int renderableHeight = (int) (filledVolume * 12);

						int atlasWidth = (int) (sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
						int atlasHeight = (int) (sprite.contents().height() / (sprite.getV1() - sprite.getV0()));

						guiGraphics.pose().pushPose();
						guiGraphics.pose().translate(0, height - 16 + offset, 0);
						for (int i = 0; i < Math.ceil(renderableHeight / 16f); i++) {
							int drawingHeight = Math.min(16, renderableHeight - 16 * i);
							int notDrawingHeight = 16 - drawingHeight;
							guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, getX(), getY() + notDrawingHeight, 0,
									sprite.getU0() * atlasWidth, sprite.getV0() * atlasHeight + notDrawingHeight, width,
									drawingHeight, atlasWidth, atlasHeight);
							guiGraphics.pose().translate(0, -16, 0);
						}
						RenderSystem.setShaderColor(1, 1, 1, 1);

						offset -= renderableHeight;
						guiGraphics.pose().popPose();
					}
				}

			}
			renderToolTip(guiGraphics, mouseX, mouseY);
		}

		RenderSystem.disableDepthTest();
	}

	public void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (isHovered(mouseX, mouseY)) {
			Minecraft minecraft = Minecraft.getInstance();
			MixingBowlTank fluidTank = this.getFluid.get();
			List<FormattedCharSequence> list = new ArrayList<FormattedCharSequence>();
			if (!getFluid.get().isEmpty(5)) {
				list.add(getFluid.get().getFluid(5).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(5) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			if (!getFluid.get().isEmpty(4)) {
				list.add(getFluid.get().getFluid(4).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(4) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			if (!getFluid.get().isEmpty(3)) {
				list.add(getFluid.get().getFluid(3).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(3) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			if (!getFluid.get().isEmpty(2)) {
				list.add(getFluid.get().getFluid(2).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(2) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			if (!getFluid.get().isEmpty(1)) {
				list.add(getFluid.get().getFluid(1).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(1) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			if (!getFluid.get().isEmpty(0)) {
				list.add(getFluid.get().getFluid(0).getDisplayName().getVisualOrderText());
				list.add(Component.literal(" - " + getFluid.get().getFluidAmount(0) + "mB").withColor(0x999999)
						.getVisualOrderText());
			}
			guiGraphics.renderTooltip(minecraft.font, list, mouseX, mouseY);
		}
	}

	protected boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width
				&& mouseY < this.getY() + this.height;
	}

	@Override
	protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
		// TODO Auto-generated method stub

	}

}

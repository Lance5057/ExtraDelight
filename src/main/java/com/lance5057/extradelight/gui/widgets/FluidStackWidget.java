package com.lance5057.extradelight.gui.widgets;

import java.util.Arrays;
import java.util.function.Supplier;

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
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

//Thanks EnderIO!
public class FluidStackWidget extends AbstractWidget {

	private final Supplier<FluidTank> getFluid;

	public FluidStackWidget(int x, int y, int width, int height, Supplier<FluidTank> getFluid) {

		super(x, y, width, height, Component.empty());
		this.getFluid = getFluid;
	}

	@Override
	protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		Minecraft minecraft = Minecraft.getInstance();
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		FluidTank fluidTank = this.getFluid.get();
		if (!fluidTank.getFluid().isEmpty()) {
			FluidStack fluidStack = fluidTank.getFluid();
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

					int stored = fluidTank.getFluidAmount();
					float capacity = fluidTank.getCapacity();
					float filledVolume = stored / capacity;
					int renderableHeight = (int) (filledVolume * height);

					int atlasWidth = (int) (sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
					int atlasHeight = (int) (sprite.contents().height() / (sprite.getV1() - sprite.getV0()));

					guiGraphics.pose().pushPose();
					guiGraphics.pose().translate(0, height - 16, 0);
					for (int i = 0; i < Math.ceil(renderableHeight / 16f); i++) {
						int drawingHeight = Math.min(16, renderableHeight - 16 * i);
						int notDrawingHeight = 16 - drawingHeight;
						guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, getX(), getY() + notDrawingHeight, 0,
								sprite.getU0() * atlasWidth, sprite.getV0() * atlasHeight + notDrawingHeight, width,
								drawingHeight, atlasWidth, atlasHeight);
						guiGraphics.pose().translate(0, -16, 0);
					}
					RenderSystem.setShaderColor(1, 1, 1, 1);

					guiGraphics.pose().popPose();
				}
			}
			renderToolTip(guiGraphics, mouseX, mouseY);
		}

		RenderSystem.disableDepthTest();
	}

	public void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (isHovered(mouseX, mouseY)) {
			Minecraft minecraft = Minecraft.getInstance();
			guiGraphics.renderTooltip(minecraft.font,
					Arrays.asList(getFluid.get().getFluid().getDisplayName().getVisualOrderText(),
							Component.literal(getFluid.get().getFluidAmount() + "mB").getVisualOrderText()),
					mouseX, mouseY);
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

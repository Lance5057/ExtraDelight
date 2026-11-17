package api.LanceNestAPI.src.ui;

import java.awt.Color;

import net.minecraft.client.gui.GuiGraphics;

public class UIUtil {
	public static void drawOutlineRect(GuiGraphics guiGraphics, int x, int y, int w, int h, Color outline, Color fill) {
		guiGraphics.fill(x, y, x + w, y + h, outline.getRGB());
		guiGraphics.fill(x + 1, y + 1, x + w - 1, y + h - 1, fill.getRGB());
	}
}

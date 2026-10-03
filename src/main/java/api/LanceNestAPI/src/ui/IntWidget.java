package api.LanceNestAPI.src.ui;

import java.awt.Color;
import java.util.function.Consumer;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class IntWidget extends UIWidget {
	public int f = 0;

	private boolean isLimited = false;
	private int min = 0;
	private int max = 0;

	private static final WidgetSprites RIGHT_SMALL_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_arrow_disabled"));
	private static final WidgetSprites LEFT_SMALL_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_arrow_disabled"));

	public EditBox box;
	public ImageButton right_small_button;
	public ImageButton left_small_button;

	public IntWidget(Consumer<String> sup) {
		super(sup);
	}

	public IntWidget setLimit(int min, int max) {
		this.isLimited = true;
		this.max = max;
		this.min = min;
		return this;
	}

	public void init(AbstractContainerScreen<?> screen, int posX, int posY, int w, Font font, String name) {
		init(screen, posX, posY, posY, font, null, false, null, name);
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, int w, Font font, Component msg,
			boolean doBackground, Color backgroundColor, String name) {
		this.posX = x;
		this.posY = y;
		this.width = w;

		box = screen.addRenderableWidget(new EditBox(font, 6 + x, y, w, 14, msg));
		set(f);
		box.setFilter(s -> filter(s));
		box.setResponder(onChanged);

		right_small_button = screen.addRenderableWidget(
				new ImageButton(w + x + 6, y + 2, 6, 10, RIGHT_SMALL_BUTTON, (button) -> addSmall()));
		left_small_button = screen
				.addRenderableWidget(new ImageButton(x, y + 2, 6, 10, LEFT_SMALL_BUTTON, (button) -> subSmall()));

		this.displayBackground = doBackground;
		this.backgroundColor = backgroundColor;
		this.name = name;

	}

	public void hide(boolean h) {
		box.setVisible(!h);
		right_small_button.visible = !h;
		left_small_button.visible = !h;
	}

	public void set(int f) {
		box.setValue(Integer.toString(f));
	}

	public int get() {
		if (box != null)
			try {
				int f = Integer.parseInt(box.getValue());
				return f;
			} catch (Exception e) {

			}
		return 0;
	}

	boolean filter(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	void addSmall() {
		int i = get() + 1;
		i = Math.clamp(i, min, max);
		box.setValue("" + i);
	}

	void subSmall() {
		int i = get() - 1;
		i = Math.clamp(i, min, max);
		box.setValue("" + i);
	}

	public void render(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		if (this.displayBackground) {
			guiGraphics.fill(this.posX, this.posY, this.posX + this.width + 12, this.posY + 14,
					this.backgroundColor.getRGB());
		}
	}
}
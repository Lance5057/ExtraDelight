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

public class FloatWidget {
	private float f = 0;
	Consumer<String> onChanged;

	private static final WidgetSprites RIGHT_SMALL_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_arrow_disabled"));
	private static final WidgetSprites LEFT_SMALL_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_arrow_disabled"));

	private static final WidgetSprites RIGHT_BIG_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_double_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "right_double_arrow_disabled"));
	private static final WidgetSprites LEFT_BIG_BUTTON = new WidgetSprites(
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_double_arrow"),
			ResourceLocation.fromNamespaceAndPath(LanceNestAPI.MOD_ID, "left_double_arrow_disabled"));

	public EditBox box;
	public ImageButton right_small_button;
	public ImageButton right_big_button;
	public ImageButton left_small_button;
	public ImageButton left_big_button;

	private boolean bigButtons;
	private boolean background;
	private Color backgroundColor;

	private int posX = 0;
	private int posY = 0;
	private int width = 0;

	public FloatWidget(Consumer<String> sup) {
		this.onChanged = sup;
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, int w, Font font, Component msg,
			boolean addBigButtons) {
		this.init(screen, x, y, w, font, msg, addBigButtons, false, null);
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, int w, Font font, Component msg,
			boolean addBigButtons, boolean addBackground, Color backgroundColor) {
		this.posX = x;
		this.posY = y;
		this.width = w;

		this.bigButtons = addBigButtons;
		this.background = addBackground;
		this.backgroundColor = backgroundColor;

		box = screen.addRenderableWidget(new EditBox(font, 6 + x, y, w, 14, msg));

		box.setFilter(s -> {
			try {
				Float.parseFloat(s);
			} catch (NumberFormatException exception) {
				return false;
			}
			return true;
		});
		box.setResponder(onChanged);

		right_small_button = screen.addRenderableWidget(
				new ImageButton(w + x + 6, y + 2, 6, 10, RIGHT_SMALL_BUTTON, (button) -> addSmall()));
		left_small_button = screen
				.addRenderableWidget(new ImageButton(x, y + 2, 6, 10, LEFT_SMALL_BUTTON, (button) -> subSmall()));

		if (bigButtons) {
			right_big_button = screen.addRenderableWidget(
					new ImageButton(41 + 7 + x, y + 2, 11, 10, RIGHT_BIG_BUTTON, (button) -> addBig()));
			left_big_button = screen
					.addRenderableWidget(new ImageButton(x - 19, y + 2, 11, 10, LEFT_BIG_BUTTON, (button) -> subBig()));
		}
	}

	public void hide(boolean h) {
		box.setVisible(!h);
		right_small_button.visible = !h;
		left_small_button.visible = !h;

		if (bigButtons) {
			right_big_button.visible = !h;
			left_big_button.visible = !h;
		}
	}

	public void set(float f) {
		box.setValue(Float.toString(f));
	}

	public float get() {
		if (box != null)
			try {
				Float f = Float.parseFloat(box.getValue());
				return f;
			} catch (Exception e) {

			}
		return 0;
	}

	boolean filter(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	void addSmall() {
		box.setValue(String.format("%.1f", get() + 0.1f));
	}

	void subSmall() {
		box.setValue(String.format("%.1f", get() - 0.1f));
	}

	void addBig() {
		box.setValue(String.format("%.1f", get() + 1f));
	}

	void subBig() {
		box.setValue(String.format("%.1f", get() - 1f));
	}

	protected void render(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		if (this.background) {
			guiGraphics.fill(this.posX, this.posY, this.posX + this.width + 12, this.posY + 14,
					this.backgroundColor.getRGB());
		}
	}
}
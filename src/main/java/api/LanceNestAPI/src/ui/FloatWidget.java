package api.LanceNestAPI.src.ui;

import java.util.function.Consumer;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FloatWidget extends UIWidget<Float> {
	private float f = 0;

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

	protected boolean bigButtons;

	public FloatWidget(Consumer<Float> sup) {
		super(sup);
	}

	protected void toEditbox(String s, Consumer<Float> c) {
		c.accept(Float.parseFloat(s));
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, int characters, Font font, Component msg,
			boolean addBigButtons) {

		this.posX = x;
		this.posY = y;
		this.width = characters * 7;

		this.bigButtons = addBigButtons;

		box = screen.addRenderableWidget(new EditBox(font, 6 + x, y, width, 14, msg));
		this.set(f);
		box.setFilter(s -> testFloat(s));
		box.setResponder(s -> toEditbox(s, onChanged));

		right_small_button = screen.addRenderableWidget(
				new ImageButton(width + x + 6, y + 2, 6, 10, RIGHT_SMALL_BUTTON, (button) -> add()));
		left_small_button = screen
				.addRenderableWidget(new ImageButton(x, y + 2, 6, 10, LEFT_SMALL_BUTTON, (button) -> sub()));

//		if (bigButtons) {
//			right_big_button = screen.addRenderableWidget(
//					new ImageButton(41 + 7 + x, y + 2, 11, 10, RIGHT_BIG_BUTTON, (button) -> addBig()));
//			left_big_button = screen
//					.addRenderableWidget(new ImageButton(x - 19, y + 2, 11, 10, LEFT_BIG_BUTTON, (button) -> subBig()));
//		}
	}

	private boolean testFloat(String s) {
		try {
			Float.parseFloat(s);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
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

	void add() {
		float i = 0.1f;

		if (Screen.hasShiftDown())
			i = 1f;
		else if (Screen.hasAltDown())
			i = 0.01f;
		if (Screen.hasControlDown())
			i *= 10;

		i += get();
		if (this.isLimited)
			if (i > this.upperLimit)
				i = this.upperLimit;

		box.setValue(String.format("%.2f", i));
	}

	void sub() {
		float i = 0.1f;

		if (Screen.hasShiftDown())
			i = 1f;
		else if (Screen.hasAltDown())
			i = 0.01f;
		if (Screen.hasControlDown())
			i *= 10;

		i = get() - i;
		if (this.isLimited)
			if (i < this.lowerLimit)
				i = this.lowerLimit;

		box.setValue(String.format("%-1.2f", i));
	}

	protected void render(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		if (this.displayBackground) {
			UIUtil.drawOutlineRect(guiGraphics, this.posX, this.posY, this.width + 12, 14, outlineColor,
					backgroundColor);

		}
	}
}
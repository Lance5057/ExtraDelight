package api.LanceNestAPI.src.ui;

import java.util.function.Consumer;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FloatWidget {
	public float f = 0;
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

	public FloatWidget(Consumer<String> sup) {
		this.onChanged = sup;
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, Font font, Component msg, int leftPos,
			int topPos) {
		box = screen.addRenderableWidget(new EditBox(font, leftPos + x, topPos + y, 40, 14, msg));

//		box.setFilter(s -> filter(s));
		box.setResponder(onChanged);

		right_small_button = screen.addRenderableWidget(
				new ImageButton(leftPos + 41 + x, topPos + y + 2, 6, 10, RIGHT_SMALL_BUTTON, (button) -> addSmall()));
		left_small_button = screen.addRenderableWidget(
				new ImageButton(leftPos + x - 7, topPos + y + 2, 6, 10, LEFT_SMALL_BUTTON, (button) -> subSmall()));
		right_big_button = screen.addRenderableWidget(
				new ImageButton(leftPos + 41 + 7 + x, topPos + y + 2, 11, 10, RIGHT_BIG_BUTTON, (button) -> addBig()));
		left_big_button = screen.addRenderableWidget(
				new ImageButton(leftPos + x - 19, topPos + y + 2, 11, 10, LEFT_BIG_BUTTON, (button) -> subBig()));

	}

	public void hide(boolean h) {
		box.setVisible(!h);
		right_small_button.visible = !h;
		right_big_button.visible = !h;
		left_small_button.visible = !h;
		left_big_button.visible = !h;
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
		box.setValue(String.format("%.1f", Float.parseFloat(box.getValue()) + 0.1f));
	}

	void subSmall() {
		box.setValue(String.format("%.1f", Float.parseFloat(box.getValue()) - 0.1f));
	}

	void addBig() {
		box.setValue(String.format("%.1f", Float.parseFloat(box.getValue()) + 1f));
	}

	void subBig() {
		box.setValue(String.format("%.1f", Float.parseFloat(box.getValue()) - 1f));
	}
}
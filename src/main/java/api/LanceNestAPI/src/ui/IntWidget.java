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

public class IntWidget {
	public int f = 0;

	private boolean isLimited = false;
	private int min = 0;
	private int max = 0;

	Consumer<String> onChanged;

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
		this.onChanged = sup;
	}

	public IntWidget setLimit(int min, int max) {
		this.isLimited = true;
		this.max = max;
		this.min = min;
		return this;
	}

	public void init(AbstractContainerScreen<?> screen, int x, int y, int w, Font font, Component msg) {
		box = screen.addRenderableWidget(new EditBox(font, x, y, w, 14, msg));

//		box.setFilter(s -> filter(s));
		box.setResponder(onChanged);

		right_small_button = screen
				.addRenderableWidget(new ImageButton(41 + x, y + 2, 6, 10, RIGHT_SMALL_BUTTON, (button) -> addSmall()));
		left_small_button = screen
				.addRenderableWidget(new ImageButton(x - 7, y + 2, 6, 10, LEFT_SMALL_BUTTON, (button) -> subSmall()));

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
}
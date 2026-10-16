package api.LanceNestAPI.src.ui;

import java.awt.Color;
import java.util.function.Consumer;

import org.joml.Vector3f;

import api.LanceNestAPI.src.util.ClipboardUtil;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;

public class Vector3Widget extends UIWidget<Vector3f> {
	Vector3f vector = new Vector3f();

	FloatWidget x;
	FloatWidget y;
	FloatWidget z;

	private int posX = 0;
	private int posY = 0;

	private String name = "";

	protected Consumer<Vector3f> onChanged;

	public Button copy_button;
	public Button paste_button;
	public Button delete_button;

	public Vector3Widget(Consumer<Vector3f> sup) {
		this(new Vector3f(), sup);
	}

	public Vector3Widget(Vector3f start, Consumer<Vector3f> sup) {
		super(sup);

		this.vector = start;
		this.onChanged = sup;
		x = new FloatWidget(s -> {
			vector.x = s;

			this.onChanged.accept(vector);
		});
		x.addBackground(Color.RED, Color.MAGENTA);

		y = new FloatWidget(s -> {
			vector.y = s;

			this.onChanged.accept(vector);
		});
		y.addBackground(Color.GREEN, Color.CYAN);

		z = new FloatWidget(s -> {
			vector.z = s;

			this.onChanged.accept(vector);
		});
		z.addBackground(Color.BLUE, Color.lightGray);

	}

	public void init(AbstractContainerScreen<?> screen, int posX, int posY, Font font, String name, Vector3f start) {

		this.vector = start;
		this.posX = posX;
		this.posY = posY;

		x.init(screen, posX, posY, 5, font, Component.literal("0"), false);
		y.init(screen, posX + 47, posY, 5, font, Component.literal("0"), false);
		z.init(screen, posX + 94, posY, 5, font, Component.literal("0"), false);

		x.set(vector.x);
		y.set(vector.y);
		z.set(vector.z);

		this.name = name;

		copy_button = screen.addRenderableWidget(Button
				.builder(Component.literal("c"), p -> ClipboardUtil.copyVector3f(vector)).pos(posX + 104, posY - 13)
				.size(12, 12).tooltip(Tooltip.create(Component.translatable("widget.copy"))).build());
		paste_button = screen.addRenderableWidget(Button
				.builder(Component.literal("p"), p -> set(ClipboardUtil.pasteVector3f())).pos(posX + 116, posY - 13)
				.size(12, 12).tooltip(Tooltip.create(Component.translatable("widget.paste"))).build());
		delete_button = screen.addRenderableWidget(
				Button.builder(Component.literal("x"), p -> set(defaultVector())).pos(posX + 128, posY - 13)
						.size(12, 12).tooltip(Tooltip.create(Component.translatable("widget.delete"))).build());
	}

	protected Vector3f defaultVector() {
		return new Vector3f(0, 0, 0);
	}

	public void hide(boolean h) {
		x.hide(h);
		y.hide(h);
		z.hide(h);
	}

	public void set(Vector3f f) {
		this.vector = new Vector3f(f);
		x.set(f.x);
		y.set(f.y);
		z.set(f.z);
	}

	public Vector3f get() {
		Vector3f v = new Vector3f();

		v.x = x.get();
		v.y = y.get();
		v.z = z.get();

		return v;
	}

	public void render(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY, Font font) {
		if (this.displayBackground) {
			guiGraphics.drawString(font, name, posX + 3, posY - 11, Color.WHITE.getRGB());
			UIUtil.drawOutlineRect(guiGraphics, this.posX, this.posY - 14, ((6 * 7) * 3) + 15, 14, outlineColor,
					backgroundColor);

		}

		x.render(guiGraphics, partialTick, mouseX, mouseY);
		y.render(guiGraphics, partialTick, mouseX, mouseY);
		z.render(guiGraphics, partialTick, mouseX, mouseY);
	}

	@Override
	protected void toEditbox(String s, Consumer<Vector3f> c) {
		// Does nuffin
	}
}

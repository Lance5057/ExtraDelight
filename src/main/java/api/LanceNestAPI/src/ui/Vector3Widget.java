package api.LanceNestAPI.src.ui;

import java.awt.Color;

import org.joml.Vector3f;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;

public class Vector3Widget {
	Vector3f vector = new Vector3f();

	FloatWidget x;
	FloatWidget y;
	FloatWidget z;

	private boolean background;
	private Color backgroundColor;

	private int posX = 0;
	private int posY = 0;

	private String name = "";

//	Consumer<String> onChanged;
//
	public Vector3Widget() {
		x = new FloatWidget(s -> {
			if (!s.isEmpty())
				vector.x = Float.parseFloat(s);
			else
				vector.x = 0;
		});
		y = new FloatWidget(s -> {
			if (!s.isEmpty())
				vector.y = Float.parseFloat(s);
			else
				vector.y = 0;
		});
		z = new FloatWidget(s -> {
			if (!s.isEmpty())
				vector.z = Float.parseFloat(s);
			else
				vector.z = 0;
		});
	}

	public void init(AbstractContainerScreen<?> screen, int posX, int posY, Font font, String name) {
		init(screen, posX, posY, font, false, null, name);
	}

	public void init(AbstractContainerScreen<?> screen, int posX, int posY, Font font, boolean doBackground,
			Color backgroundColor, String name) {
		this.posX = posX;
		this.posY = posY;

		x.init(screen, posX, posY, 10, font, Component.literal("0"), false, true, Color.RED);
		y.init(screen, posX + 22, posY, 10, font, Component.literal("0"), false, true, Color.GREEN);
		z.init(screen, posX + 44, posY, 10, font, Component.literal("0"), false, true, Color.BLUE);

		this.background = doBackground;
		this.backgroundColor = backgroundColor;
		this.name = name;
	}

	public void hide(boolean h) {
		x.hide(h);
		y.hide(h);
		z.hide(h);
	}

	public void set(Vector3f f) {
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
		if (this.background) {
			guiGraphics.drawString(font, name, posX + 3, posY - 11, Color.WHITE.getRGB());
			guiGraphics.fill(this.posX, this.posY - 14, this.posX + 66, this.posY + 14, this.backgroundColor.getRGB());
		}

		x.render(guiGraphics, partialTick, mouseX, mouseY);
		y.render(guiGraphics, partialTick, mouseX, mouseY);
		z.render(guiGraphics, partialTick, mouseX, mouseY);
	}
}

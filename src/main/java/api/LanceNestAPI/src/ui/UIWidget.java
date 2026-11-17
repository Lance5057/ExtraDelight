package api.LanceNestAPI.src.ui;

import java.awt.Color;
import java.util.function.Consumer;

public abstract class UIWidget<T> {

	protected boolean displayBackground;
	protected Color backgroundColor;
	protected Color outlineColor;

	protected boolean displayName;
	protected String name;

	protected int posX = 0;
	protected int posY = 0;
	protected int width = 0;

	protected Consumer<T> onChanged;

	public UIWidget(Consumer<T> sup) {
		this.onChanged = sup;
	}

	protected abstract void toEditbox(String s, Consumer<T> c);

	public void addBackground(Color backgroundColor, Color outlineColor) {
		this.backgroundColor = backgroundColor;
		this.outlineColor = outlineColor;
		this.displayBackground = true;
	}

	boolean isLimited = false;
	T upperLimit;
	T lowerLimit;

	public UIWidget<T> addLimits(T upper, T lower) {
		this.upperLimit = upper;
		this.lowerLimit = lower;
		this.isLimited = true;

		return this;
	}
}

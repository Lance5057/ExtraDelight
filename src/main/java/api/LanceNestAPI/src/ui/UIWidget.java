package api.LanceNestAPI.src.ui;

import java.awt.Color;
import java.util.function.Consumer;

public abstract class UIWidget {

	protected boolean displayBackground;
	protected Color backgroundColor;

	protected boolean displayName;
	protected String name;

	protected int posX = 0;
	protected int posY = 0;
	protected int width = 0;

	protected Consumer<String> onChanged;

	public UIWidget(Consumer<String> sup) {
		this.onChanged = sup;
	}
}

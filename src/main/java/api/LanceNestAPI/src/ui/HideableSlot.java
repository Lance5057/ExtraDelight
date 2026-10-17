package api.LanceNestAPI.src.ui;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;

public class HideableSlot extends Slot {
	private boolean active = true;

	public HideableSlot(Container container, int slot, int x, int y, boolean startShown) {
		super(container, slot, x, y);
		this.active = startShown;
	}

	public HideableSlot setActive(boolean active) {
		this.active = active;
		return this;
	}

	public void toggleActive() {
		active = !active;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public boolean isHighlightable() {
		return active;
	}
}

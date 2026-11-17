package api.LanceNestAPI.src.ui;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class HideableSlotItemHandler extends SlotItemHandler {

	private boolean active = true;

	public HideableSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition, boolean startShown) {
		super(itemHandler, index, xPosition, yPosition);
		active = startShown;
	}

	public HideableSlotItemHandler setActive(boolean active) {
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

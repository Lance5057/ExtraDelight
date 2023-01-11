package com.lance5057.extradelight.workstations.slots;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

@ParametersAreNonnullByDefault
public class OvenMealSlot extends SlotItemHandler {
	public OvenMealSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}

	@Override
	public boolean mayPickup(Player playerIn) {
		return false;
	}
}

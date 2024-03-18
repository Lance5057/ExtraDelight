package com.lance5057.extradelight.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class BlockEntityUtils {
	public static class Inventory {
		// returns -1 on failure
		public static int getLastFilledSlot(IItemHandlerModifiable inventory, int inventorySize) {
			if (inventory.getStackInSlot(inventorySize - 1) != ItemStack.EMPTY)
				return inventorySize - 1;
			for (int i = 0; i <= inventorySize; i++) {
				if (inventory.getStackInSlot(i) == ItemStack.EMPTY)
					return i - 1;
			}
			return -1;
		}

		public static void extractItem(Player playerEntity, IItemHandlerModifiable inventory, int inventorySize) {
			int i = getLastFilledSlot(inventory, inventorySize);
			if (i != -1) {
				ItemStack itemStack = inventory.extractItem(i, 1, false);
				playerEntity.addItem(itemStack);
				return;
			}
		}

		public static void insertItem(IItemHandlerModifiable inventory, ItemStack heldItem, int inventorySize) {
			for (int i = 0; i <= inventorySize - 1; i++) {
				if (!ItemStack.isSameItem(inventory.insertItem(i, heldItem, true), heldItem)) {
					final int leftover = inventory.insertItem(i, heldItem.copy(), false).getCount();
					heldItem.setCount(leftover);
					return;
				}
			}

		}
	}
}

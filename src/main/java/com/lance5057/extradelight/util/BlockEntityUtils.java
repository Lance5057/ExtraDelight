package com.lance5057.extradelight.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
		
		public static int getLastEmptySlot(IItemHandlerModifiable inventory, int inventorySize) {
			for (int i = 0; i < inventory.getSlots(); ++i) {
				ItemStack slotStack = inventory.getStackInSlot(i);
				if (slotStack.isEmpty()) {
					return i;
				}
			}
			return -1;
		}

		public static ItemStack extractItem(IItemHandlerModifiable inventory, int inventorySize) {
			int i = getLastFilledSlot(inventory, inventorySize);
			if (i != -1) {
				return inventory.extractItem(i, 1, false);
			}
			return ItemStack.EMPTY;
		}

		public static void insertItem(ItemStack heldItem, IItemHandlerModifiable inventory, int inventorySize) {
			int slot = getLastEmptySlot(inventory, inventorySize);
			if (slot != -1) {
				inventory.insertItem(slot, heldItem, false);
			}
		}

		public static void givePlayerItemStack(ItemStack stack, Player player, Level level, BlockPos pos) {
			if (!player.addItem(stack))
				level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack));
		}
	}
}

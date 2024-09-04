package com.lance5057.extradelight.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class BlockEntityUtils {
	public static class Inventory {
		// returns -1 on failure
		public static int getLastFilledSlot(IItemHandler iItemHandler, int inventorySize) {
			if (iItemHandler.getStackInSlot(inventorySize - 1) != ItemStack.EMPTY)
				return inventorySize - 1;
			for (int i = 0; i <= inventorySize; i++) {
				if (iItemHandler.getStackInSlot(i) == ItemStack.EMPTY)
					return i - 1;
			}
			return -1;
		}

		public static int getLastEmptySlot(IItemHandler iItemHandler, int inventorySize) {
			for (int i = 0; i < iItemHandler.getSlots(); ++i) {
				ItemStack slotStack = iItemHandler.getStackInSlot(i);
				if (slotStack.isEmpty()) {
					return i;
				}
			}
			return -1;
		}

		public static void extractItem(Player playerEntity, IItemHandler inventory, int inventorySize) {
			int i = getLastFilledSlot(inventory, inventorySize);
			if (i != -1) {
				ItemStack itemStack = inventory.extractItem(i, 1, false);
				playerEntity.addItem(itemStack);
				return;
			}
		}

		public static void insertItem(IItemHandler inventory, ItemStack heldItem, int inventorySize) {
			for (int i = 0; i <= inventorySize - 1; i++) {
				if (!ItemStack.matches(heldItem, inventory.insertItem(i, heldItem, true))) {
					final int leftover = inventory.insertItem(i, heldItem.copy(), false).getCount();
					heldItem.setCount(leftover);
					return;
				}
			}

		}

		public static void givePlayerItemStack(ItemStack stack, Player player, Level level, BlockPos pos) {
			if (!player.addItem(stack))
				level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack));
		}
	}
}
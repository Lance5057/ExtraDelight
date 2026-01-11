package com.lance5057.extradelight.blocks.picnicbasket;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;

public class PicnicBasketItemStackHandler extends ItemStackHandler {
	public PicnicBasketItemStackHandler(int size) {
        stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

	public PicnicBasketItemStackHandler(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

	public NonNullList<ItemStack> getStacks() {
		return this.stacks;
	}
}

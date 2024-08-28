package com.lance5057.extradelight.blocks.chocolatebox;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ChocolateBoxItemStackHandler extends ItemStackHandler {
	public ChocolateBoxItemStackHandler(int size) {
        stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    public ChocolateBoxItemStackHandler(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }
    
	public NonNullList<ItemStack> getStacks() {
		return this.stacks;
	}
}

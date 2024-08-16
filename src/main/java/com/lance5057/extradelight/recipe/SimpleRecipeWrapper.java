package com.lance5057.extradelight.recipe;

import java.util.Arrays;
import java.util.List;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class SimpleRecipeWrapper implements RecipeInput {
	List<ItemStack> items;

	public SimpleRecipeWrapper(ItemStack...itemStacks)
	{
		items = Arrays.asList(itemStacks);
	}
	
	@Override
	public ItemStack getItem(int index) {
		return items.get(index);
	}

	@Override
	public int size() {
		return items.size();
	}

}

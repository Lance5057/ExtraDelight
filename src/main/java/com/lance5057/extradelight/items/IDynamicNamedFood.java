package com.lance5057.extradelight.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface IDynamicNamedFood {
	public MutableComponent getDynamicName(ItemStack i);

	public static void writeNBTIngredientList(ItemStack stack, List<Item> items) {
		CompoundTag tag = stack.getOrCreateTag();

		CompoundTag list = new CompoundTag();
		for (int i = 0; i < items.size(); i++) {
			list.putString("item" + i, items.get(i).getDescriptionId());
		}
		list.putInt("length", items.size());

		tag.put("ingredients", list);
	}

	public static String[] readNBTIngredientList(ItemStack stack) {
		List<String> strings = new ArrayList<String>();

		CompoundTag tag = stack.getTag();
		int count = 0;

		if (tag != null)
			if (tag.contains("ingredients")) {
				CompoundTag list = tag.getCompound("ingredients");
				if (list.contains("length")) {
					count = list.getInt("length");

					for (int i = 0; i < count; i++) {
						if (list.contains("item" + i))
							strings.add(list.getString("item" + i));
					}
				}
			}

		return strings.toArray(new String[count]);
	}
}

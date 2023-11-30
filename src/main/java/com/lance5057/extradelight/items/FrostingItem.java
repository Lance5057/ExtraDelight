package com.lance5057.extradelight.items;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.world.item.Item;

public class FrostingItem extends Item {

	public FrostingItem() {
		super(new Properties().durability(10).setNoRepair().tab(ExtraDelightItems.EXTRA_DELIGHT_TAB));
	}

}

package com.lance5057.extradelight.util.registration.types;

import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.util.registration.SimpleRegistration;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemRegistration extends SimpleRegistration {
	public String name;

	DeferredItem<Item> ITEM;

	public ItemRegistration(String name, Supplier<? extends Item> sup) {
		super(name);
		ITEM = ExtraDelightItems.ITEMS.register(name, sup);
	}

	@Override
	public void tab(Output output) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemTag(ItemTagsProvider itp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void blockTag(BlockTagsProvider btp) {
		// TODO Auto-generated method stub

	}

}

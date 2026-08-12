package com.lance5057.extradelight.util.registration.types;

import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.util.registration.SimpleRegistration;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class BlockRegistration extends SimpleRegistration {
	public DeferredBlock<Block> BLOCK;
	public DeferredItem<Item> ITEM;

	public static BlockRegistration register(String name, Supplier<? extends Block> supBlock) {
		return new BlockRegistration(name, supBlock);

	}

	private BlockRegistration(String name, Supplier<? extends Block> supBlock) {
		super(name);

		ITEM = ExtraDelightItems.ITEMS.register(name, () -> new BlockItem(BLOCK.get(), new Item.Properties()));
		BLOCK = ExtraDelightBlocks.BLOCKS.register(name + "_block", supBlock);
	}

	private BlockRegistration(String name, Supplier<? extends Block> supBlock, Item.Properties prop) {
		super(name);

		ITEM = ExtraDelightItems.ITEMS.register(name, () -> new BlockItem(BLOCK.get(), prop));
		BLOCK = ExtraDelightBlocks.BLOCKS.register(name + "_block", supBlock);
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

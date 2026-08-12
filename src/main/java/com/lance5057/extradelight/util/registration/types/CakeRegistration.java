package com.lance5057.extradelight.util.registration.types;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.util.registration.SimpleRegistration;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

public class CakeRegistration extends SimpleRegistration {

	public DeferredItem<Item> SLICE;

	public DeferredBlock<Block> CAKE_BLOCK;
	public DeferredItem<Item> CAKE_ITEM;

	public CakeRegistration(String name) {
		super(name);

		SLICE = ExtraDelightItems.ITEMS.register(name + "_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE)));
		CAKE_ITEM = ExtraDelightItems.ITEMS.register(name,
				() -> new BlockItem(CAKE_BLOCK.get(), new Item.Properties()));

		CAKE_BLOCK = ExtraDelightBlocks.BLOCKS.register(name,
				() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), SLICE));
	}

	@Override
	public void tab(Output output) {
		output.accept(CAKE_ITEM);
		output.accept(SLICE);
	}

	@Override
	public void itemTag(ItemTagsProvider itp) {
		itp.tag(ExtraDelightTags.CAKE).addOptional(CAKE_ITEM.getId());
		itp.tag(ExtraDelightTags.CAKE_SLICE).addOptional(SLICE.getId());

		itp.tag(ExtraDelightTags.neoforgeItemTag("foods/cake/" + name));
		itp.tag(ExtraDelightTags.neoforgeItemTag("foods/cake/" + name + "/slice"));
	}

	@Override
	public void blockTag(BlockTagsProvider btp) {
		btp.tag(ModTags.MINEABLE_WITH_KNIFE).addOptional(CAKE_BLOCK.getId());
	}

}

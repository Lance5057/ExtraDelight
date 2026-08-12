package com.lance5057.extradelight.util.registration.types;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.util.registration.SimpleRegistration;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class FeastRegistration extends SimpleRegistration {

	public DeferredBlock<Block> FEAST_BLOCK;
	public DeferredItem<Item> FEAST_ITEM;

	FoodProperties fp;
	public DeferredItem<Item> FEAST_FOOD_ITEM;

	public FeastRegistration(String name) {
		super(name);

		FEAST_FOOD_ITEM = ExtraDelightItems.ITEMS.register(name + "_serving", () -> new Item(foodItem(fp)));
		FEAST_ITEM = ExtraDelightItems.ITEMS.register(name,
				() -> new BlockItem(FEAST_BLOCK.get(), new Item.Properties()));

		FEAST_BLOCK = ExtraDelightBlocks.BLOCKS.register(name + "_feast_block",
				() -> new RecipeFeastBlock(
						Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.COLOR_BROWN), true,
						ExtraDelightBlocks.bowl));
	}

	public FeastRegistration setFoodValue(FoodProperties fp) {
		this.fp = fp;
		return this;
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

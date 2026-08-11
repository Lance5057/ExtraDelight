package com.lance5057.extradelight.modules;

import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.blocks.crops.CucumberCrop;
import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.ToolTipConsumableItem;
import com.lance5057.extradelight.util.EDItemGenerator;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class Strawberry {
	//Blocks
	public static final DeferredBlock<StrawberryCrop> STRAWBERRY_CROP = ExtraDelightBlocks.BLOCKS
			.register("strawberry_crop", () -> new CucumberCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));

	public static final DeferredBlock<Block> WILD_STRAWBERRY = ExtraDelightBlocks.BLOCKS.register("wild_strawberry",
			() -> new WildCropBlock(MobEffects.HEAL, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
	
	//Items

	public static final DeferredItem<Item> STRAWBERRY_SEED = ExtraDelightItems.ITEMS.register("strawberry_seed",
			() -> new ItemNameBlockItem(STRAWBERRY_CROP.get(), new Item.Properties()));

	public static final DeferredItem<Item> STRAWBERRY = EDItemGenerator
			.register("strawberry", () -> new ToolTipConsumableItem(foodItem(EDFoods.STRAWBERRY), true))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> STRAWBERRY_CUSTARD = EDItemGenerator
			.register("strawberry_custard", () -> new Item(ExtraDelightItems.bottleFoodItem(EDFoods.CUSTARD)))
			.advancementDessert().finish();

}

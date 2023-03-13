package com.lance5057.extradelight.data;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BlockLootTables extends BlockLoot {
	@Override
	protected void addTables() {
		this.dropSelf(ExtraDelightBlocks.OVEN.get());
		this.dropSelf(ExtraDelightBlocks.DOUGH_SHAPING.get());
		this.dropSelf(ExtraDelightBlocks.FOOD_DISPLAY.get());
		this.dropSelf(ExtraDelightBlocks.MIXING_BOWL.get());
		this.dropSelf(ExtraDelightBlocks.GRATER.get());

		this.add(ExtraDelightBlocks.YEAST_POT.get(),
				LootTable.lootTable()
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(Items.FLOWER_POT)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(ModItems.CANVAS.get()))));

		this.dropSelf(ExtraDelightBlocks.FLOUR.get());
		this.dropSelf(ExtraDelightBlocks.COOKING_OIL.get());

		this.dropSelf(ExtraDelightBlocks.MORTAR_STONE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_ANDESITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_GRANITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_DIORITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_DEEPSLATE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_BLACKSTONE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_BASALT.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_ENDSTONE.get());

		this.dropSelf(ExtraDelightBlocks.MORTAR_AMETHYST.get()); // not craftable, dungeon item
		this.dropSelf(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get()); // not craftable, dungeon item

		this.add(ExtraDelightBlocks.CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), noDrop());

		this.add(ExtraDelightBlocks.QUICHE.get(), noDrop());

		this.add(ExtraDelightBlocks.PLAIN_CAKE.get(), noDrop());
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ExtraDelightBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}

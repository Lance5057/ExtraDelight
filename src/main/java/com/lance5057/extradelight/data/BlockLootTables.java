package com.lance5057.extradelight.data;

import java.util.ArrayList;
import java.util.Collection;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

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
		this.dropSelf(ExtraDelightBlocks.DRYING_RACK.get());

		this.add(ExtraDelightBlocks.YEAST_POT.get(),
				LootTable.lootTable()
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(Items.FLOWER_POT)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(ModItems.CANVAS.get()))));
		this.add(ExtraDelightBlocks.VINEGAR_POT.get(),
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

//		this.dropSelf(ExtraDelightBlocks.OAK_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.ACACIA_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.BIRCH_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.CRIMSON_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.JUNGLE_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.SPRUCE_STEPSTOOL.get());
//		this.dropSelf(ExtraDelightBlocks.WARPED_STEPSTOOL.get());
//		
//		this.dropSelf(ExtraDelightBlocks.OAK_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.ACACIA_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.BIRCH_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.CRIMSON_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.JUNGLE_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.SPRUCE_SPICERACK.get());
//		this.dropSelf(ExtraDelightBlocks.WARPED_SPICERACK.get());
//
//		this.dropSelf(ExtraDelightBlocks.OAK_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.ACACIA_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.BIRCH_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.CRIMSON_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.JUNGLE_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.SPRUCE_SPICERACK_FULL.get());
//		this.dropSelf(ExtraDelightBlocks.WARPED_SPICERACK_FULL.get());
//		
//		this.dropSelf(ExtraDelightBlocks.OAK_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.ACACIA_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.BIRCH_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.CRIMSON_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.DARK_OAK_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.JUNGLE_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.SPRUCE_KNIFEBLOCK.get());
//		this.dropSelf(ExtraDelightBlocks.WARPED_KNIFEBLOCK.get());
		
		this.add(ExtraDelightBlocks.CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), noDrop());

		this.add(ExtraDelightBlocks.QUICHE.get(), noDrop());

		this.add(ExtraDelightBlocks.PLAIN_CAKE.get(), noDrop());

		this.dropOther(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(), Items.BOWL);

		dropSelf(ExtraDelightBlocks.CHEESE_BLOCK.get());
		dropSelf(ExtraDelightBlocks.BUTTER_BLOCK.get());

		this.dropOther(ExtraDelightBlocks.HASH_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.POT_ROAST_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.MEATLOAF_FEAST.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.PULLED_PORK_FEAST.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.RACK_LAMB.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.STIRFRY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.BEEF_WELLINGTON.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.HAGGIS.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.JELLY_WHITE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_ORANGE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_MAGENTA.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_YELLOW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIME.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_PINK.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_GREY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_CYAN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_PURPLE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BLUE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BROWN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_GREEN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_RED.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BLACK.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MACARONI_CHEESE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.HOTDISH.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LASAGNA.get(), Items.AIR);

		this.dropOther(ExtraDelightBlocks.BEEF_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.CHICKEN_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.FISH_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.LAMB_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.PORK_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.RABBIT_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.CURRY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.SALAD.get(), Items.BOWL);
		
		AestheticBlocks.loot(this);
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		Collection<Block> l = new ArrayList<Block>();
		l.addAll(ExtraDelightBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList());
		l.addAll(AestheticBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList());
		return l;
	}
}

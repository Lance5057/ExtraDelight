package com.lance5057.extradelight.data;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableSet;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MiscLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

	public static final ResourceLocation SHUCKED_CORN = new ResourceLocation(ExtraDelight.MOD_ID, "misc/shucked_corn");
	public static final ResourceLocation CORN_TOP = new ResourceLocation(ExtraDelight.MOD_ID, "misc/corn_top");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(SHUCKED_CORN,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CORN_HUSK.get(), 2, 3))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_SILK.get(), 1, 2))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_ON_COB.get(), 1)));

		t.accept(CORN_TOP, createCropDrops(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
				ExtraDelightItems.CORN_SEEDS.get(),
				LootItemBlockStatePropertyCondition.hasBlockStateProperties(ExtraDelightBlocks.CORN_TOP.get())
						.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 3))));

	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int count) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item, int min, int max) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item))
				.apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)));
	}

	@NotNull
	public static LootPool.Builder createPoolWithItem(Item item) {
		return LootPool.lootPool().add(LootItem.lootTableItem(item));
	}

	protected static LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem,
			LootItemCondition.Builder pDropGrownCropCondition) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)
								.otherwise(LootItem.lootTableItem(pSeedsItem))))
				.withPool(LootPool.lootPool().when(pDropGrownCropCondition)
						.add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount
								.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))));
	}

}

package com.lance5057.extradelight.data;

import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import vectorwing.farmersdelight.common.registry.ModItems;

public class MiscLootTables implements LootTableSubProvider {

	protected final HolderLookup.Provider registries;

	public static final ResourceKey<LootTable> SHUCKED_CORN = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "misc/shucked_corn"));
	public static final ResourceKey<LootTable> CORN_TOP = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "misc/corn_top"));
	public static final ResourceKey<LootTable> CINNAMON_LOG = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "misc/cinnamon_log"));

	protected MiscLootTables(HolderLookup.Provider provider) {
		registries = provider;
	}

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, Builder> t) {
		t.accept(SHUCKED_CORN,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CORN_HUSK.get(), 2, 3))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_SILK.get(), 1, 2))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_ON_COB.get(), 1)));

		t.accept(CINNAMON_LOG,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CINNAMON_BARK.get(), 1, 4))
						.withPool(createPoolWithItem(ModItems.TREE_BARK.get(), 0, 2)));

//		t.accept(CORN_TOP, createCropDrops(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
//				ExtraDelightItems.CORN_SEEDS.get(),
//				LootItemBlockStatePropertyCondition.hasBlockStateProperties(ExtraDelightBlocks.CORN_TOP.get())
//						.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 3))));
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

	protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem,
			LootItemCondition.Builder pDropGrownCropCondition) {
		HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)
								.otherwise(LootItem.lootTableItem(pSeedsItem))))
				.withPool(LootPool.lootPool().when(pDropGrownCropCondition)
						.add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(
								registrylookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))));
	}

}

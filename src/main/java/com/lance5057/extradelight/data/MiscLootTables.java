package com.lance5057.extradelight.data;

import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.modules.Fermentation;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
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
	public static final ResourceKey<LootTable> SOYBEANS = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "misc/soybeans"));

	public static final ResourceKey<LootTable> EVAPORATOR_LAVA_TEST = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "evaporator/lava_test"));

	public static final ResourceKey<LootTable> EVAPORATOR_WATER = ResourceKey.create(Registries.LOOT_TABLE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "evaporator/water"));

	protected MiscLootTables(HolderLookup.Provider provider) {
		registries = provider;
	}

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, Builder> t) {
		t.accept(SHUCKED_CORN,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CORN_HUSK.get(), 2, 3))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_SILK.get(), 1, 2))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_ON_COB.get(), 1)));

		t.accept(SOYBEANS,
				LootTable.lootTable().withPool(createPoolWithItem(Fermentation.SOYBEANS.get(), 3)));

		t.accept(CINNAMON_LOG,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CINNAMON_BARK.get(), 1, 4))
						.withPool(createPoolWithItem(ModItems.TREE_BARK.get(), 0, 2)));

		HolderLookup.RegistryLookup<Biome> registrylookup = this.registries.lookupOrThrow(Registries.BIOME);
		t.accept(EVAPORATOR_LAVA_TEST, LootTable.lootTable().withPool(createPoolWithItem(Items.COBBLESTONE, 1, 5))
				.withPool(createPoolWithItem(Items.STONE, 1, 4)
//										.when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
//												.setBiomes(HolderSet.direct(registrylookup.getOrThrow(Biomes.RIVER),
//														registrylookup.getOrThrow(Biomes.OCEAN)))))
				));

		t.accept(EVAPORATOR_WATER,
				LootTable.lootTable()
						.withPool(createPoolWithItem(Fermentation.SALT.get(), 1)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
						.withPool(LootPool.lootPool().name("extras").setRolls(UniformGenerator.between(0, 3))
								.add(LootItem.lootTableItem(Items.COD).setWeight(1))
								.add(LootItem.lootTableItem(Items.BONE_MEAL).setWeight(5))
								.add(LootItem.lootTableItem(Items.STICK).setWeight(10))
								.add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(5))
								.add(LootItem.lootTableItem(Items.LEATHER_BOOTS)
										.apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.05F)))
										.setWeight(1)))

						.withPool(LootPool.lootPool().name("ocean_river").setRolls(UniformGenerator.between(0, 3))
								.add(LootItem.lootTableItem(Items.COD).setWeight(1))
								.add(LootItem.lootTableItem(Items.SALMON).setWeight(1))
								.add(LootItem.lootTableItem(Fermentation.SALT.get()).setWeight(1))
								.add(LootItem.lootTableItem(Items.SAND).setWeight(5))
								.add(LootItem.lootTableItem(Items.GRAVEL).setWeight(5))
								.setRolls(UniformGenerator.between(1, 3))
								.when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
										.setBiomes(HolderSet.direct(registrylookup.getOrThrow(Biomes.RIVER),
												registrylookup.getOrThrow(Biomes.OCEAN))))))
						.withPool(LootPool.lootPool().name("swamp").setRolls(UniformGenerator.between(0, 3))
								.add(LootItem.lootTableItem(Items.CLAY_BALL))
								.add(LootItem.lootTableItem(Items.LILY_PAD).setWeight(1))
								.add(LootItem.lootTableItem(Items.SAND).setWeight(1))
								.setRolls(UniformGenerator.between(1, 3))
								.when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
										.setBiomes(HolderSet.direct(registrylookup.getOrThrow(Biomes.SWAMP),
												registrylookup.getOrThrow(Biomes.MANGROVE_SWAMP)))))));
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

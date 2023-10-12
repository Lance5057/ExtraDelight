package com.lance5057.extradelight.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MiscLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

	public static final ResourceLocation SHUCKED_CORN = new ResourceLocation(ExtraDelight.MOD_ID, "misc/shucked_corn");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(SHUCKED_CORN,
				LootTable.lootTable().withPool(createPoolWithItem(ExtraDelightItems.CORN_HUSK.get(), 2, 3))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_SILK.get(), 1, 2))
						.withPool(createPoolWithItem(ExtraDelightItems.CORN_ON_COB.get(), 1)));
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
}

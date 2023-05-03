package com.lance5057.extradelight.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class StructureLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
	public static ResourceLocation curry_powder = new ResourceLocation(ExtraDelight.MOD_ID, "structures/curry_powder");
	public static ResourceLocation furikake = new ResourceLocation(ExtraDelight.MOD_ID, "structures/furikake");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		t.accept(curry_powder,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 4))
						.add(LootItem.lootTableItem(ExtraDelightItems.CURRY_POWDER.get()))));
		t.accept(furikake,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 4))
						.add(LootItem.lootTableItem(ExtraDelightItems.FURIKAKE.get()))));
	}

}

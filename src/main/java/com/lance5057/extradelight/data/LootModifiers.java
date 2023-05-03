package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.loot.FoodLoot;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class LootModifiers extends GlobalLootModifierProvider {

	public LootModifiers(DataGenerator data) {
		super(data, ExtraDelight.MOD_ID);
	}

	@Override
	protected void start() {
		add("curry_pyramid",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.DESERT_PYRAMID).build() },
						StructureLootTables.curry_powder));
		
		add("curry_mansion",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.75f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION).build() },
						StructureLootTables.curry_powder));
		
		add("curry_ship",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE).build() },
						StructureLootTables.curry_powder));
		
		add("curry_village",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.25f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE).build() },
						StructureLootTables.curry_powder));
	}

}
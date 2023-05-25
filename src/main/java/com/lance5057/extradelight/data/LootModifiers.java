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
		add("mortar_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON).build(), },
						StructureLootTables.mortar_dungeon));

		add("mortar_nether",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.BASTION_OTHER).build(), },
						StructureLootTables.mortar_nether));

		add("pestle_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON).build(), },
						StructureLootTables.pestle_dungeon));

		add("pestle_nether",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.BASTION_OTHER).build(), },
						StructureLootTables.pestle_nether));

		add("food_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON).build(), },
						StructureLootTables.dungeon_rot));

		add("food_city",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.ANCIENT_CITY).build() },
						StructureLootTables.dungeon_rot));

		add("food_city_ice",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.ANCIENT_CITY_ICE_BOX).build() },
						StructureLootTables.meals));

		add("food_igloo",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.IGLOO_CHEST).build() },
						StructureLootTables.meals));

		add("food_outpost",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.PILLAGER_OUTPOST).build() },
						StructureLootTables.meals));

		add("food_ship",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_SUPPLY).build() },
						StructureLootTables.dungeon_rot));

		add("food_ship_feast",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE).build() },
						StructureLootTables.feasts));

		add("food_butcher",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_BUTCHER).build() },
						StructureLootTables.meals));

		add("food_house",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE).build(),
								LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_PLAINS_HOUSE).build(),
								LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SAVANNA_HOUSE).build(),
								LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SNOWY_HOUSE).build(),
								LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TAIGA_HOUSE).build() },
						StructureLootTables.ingredients));

		add("food_mansion1",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION).build() },
						StructureLootTables.feasts));
		add("food_mansion2",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION).build() },
						StructureLootTables.meals));
		add("food_mansion3",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION).build() },
						StructureLootTables.ingredients));

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

		add("furikake_ruins",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_SMALL).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.75f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_BIG).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.25f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_FISHER).build() },
						StructureLootTables.furikake));
	}

}
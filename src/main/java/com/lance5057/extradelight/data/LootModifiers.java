package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.loot.FoodLoot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

public class LootModifiers extends GlobalLootModifierProvider {

	public LootModifiers(CompletableFuture<HolderLookup.Provider> registries, PackOutput data) {
		super(data, registries, ExtraDelight.MOD_ID);
	}

	@Override
	protected void start() {
		add("mortar_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON.location()).build(), },
						StructureLootTables.mortar_dungeon));

		add("mortar_nether",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.BASTION_OTHER.location()).build(), },
						StructureLootTables.mortar_nether));

		add("pestle_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON.location()).build(), },
						StructureLootTables.pestle_dungeon));

		add("pestle_nether",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.BASTION_OTHER.location()).build(), },
						StructureLootTables.pestle_nether));

		add("food_dungeon",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON.location()).build(), },
						StructureLootTables.dungeon_rot));

		add("food_city",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.ANCIENT_CITY.location()).build() },
						StructureLootTables.dungeon_rot));

		add("food_city_ice",
				new FoodLoot(new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
						LootTableIdCondition.builder(BuiltInLootTables.ANCIENT_CITY_ICE_BOX.location()).build() },
						StructureLootTables.meals));

		add("food_igloo",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.IGLOO_CHEST.location()).build() },
						StructureLootTables.meals));

		add("food_outpost",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.PILLAGER_OUTPOST.location()).build() },
						StructureLootTables.meals));

		add("food_ship",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_SUPPLY.location()).build() },
						StructureLootTables.dungeon_rot));

		add("food_butcher",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_BUTCHER.location()).build() },
						StructureLootTables.meals));

		add("food_mansion2",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION.location()).build() },
						StructureLootTables.meals));

		add("curry_pyramid",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.DESERT_PYRAMID.location()).build() },
						StructureLootTables.curry_powder));

		add("curry_mansion",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.75f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION.location()).build() },
						StructureLootTables.curry_powder));

		add("curry_ship",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE.location()).build() },
						StructureLootTables.curry_powder));

		add("curry_village",
				new FoodLoot(new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.25f).build(),
						LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE.location()).build() },
						StructureLootTables.curry_powder));

		add("furikake_ruins",
				new FoodLoot(new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.5f).build(),
						LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_SMALL.location()).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.75f).build(),
						LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_BIG.location()).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1.5f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE.location()).build() },
						StructureLootTables.furikake));

		add("furikake_ruins_big",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(0.25f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_FISHER.location()).build() },
						StructureLootTables.furikake));

		add("cactus_juice_portal",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.RUINED_PORTAL.location()).build(), },
						StructureLootTables.cactus_juice));

		add("cactus_juice_desert",
				new FoodLoot(new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1f).build(),
						LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE.location()).build(), },
						StructureLootTables.cactus_juice));

		add("cactus_juice_pyramid",
				new FoodLoot(
						new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(1f).build(),
								LootTableIdCondition.builder(BuiltInLootTables.DESERT_PYRAMID.location()).build(), },
						StructureLootTables.cactus_juice));
	}

}
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
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class StructureLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
	public static ResourceLocation curry_powder = new ResourceLocation(ExtraDelight.MOD_ID, "structures/curry_powder");
	public static ResourceLocation furikake = new ResourceLocation(ExtraDelight.MOD_ID, "structures/furikake");
	public static ResourceLocation meals = new ResourceLocation(ExtraDelight.MOD_ID, "structures/meals");
	public static ResourceLocation ingredients = new ResourceLocation(ExtraDelight.MOD_ID, "structures/ingredients");
	public static ResourceLocation feasts = new ResourceLocation(ExtraDelight.MOD_ID, "structures/feasts");
	public static ResourceLocation dungeon_rot = new ResourceLocation(ExtraDelight.MOD_ID, "structures/dungeon_rot");
	
	public static ResourceLocation cactus_juice = new ResourceLocation(ExtraDelight.MOD_ID, "structures/cactus_juice");
	
	public static ResourceLocation mortar_nether = new ResourceLocation(ExtraDelight.MOD_ID, "structures/mortar_nether");
	public static ResourceLocation mortar_dungeon = new ResourceLocation(ExtraDelight.MOD_ID, "structures/mortar_dungeon");
	public static ResourceLocation pestle_nether = new ResourceLocation(ExtraDelight.MOD_ID, "structures/pestle_nether");
	public static ResourceLocation pestle_dungeon = new ResourceLocation(ExtraDelight.MOD_ID, "structures/pestle_dungeon");

	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> t) {
		
		t.accept(mortar_nether,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(0, 1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get()))));
		t.accept(mortar_dungeon,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(0, 1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MORTAR_AMETHYST.get()))));
		t.accept(pestle_nether,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(0, 1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get()))));
		t.accept(pestle_dungeon,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(0, 1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PESTLE_AMETHYST.get()))));
		
		t.accept(curry_powder,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 4))
						.add(LootItem.lootTableItem(ExtraDelightItems.CURRY_POWDER.get()))));
		t.accept(furikake,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 4))
						.add(LootItem.lootTableItem(ExtraDelightItems.FURIKAKE.get()))));

		t.accept(meals, LootTable.lootTable()
				.withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 15))
						.add(LootItem.lootTableItem(ExtraDelightItems.APPLE_SAUCE.get()))
						.add(LootItem.lootTableItem(ExtraDelightItems.BACON_CHEESEBURGER.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BACON_EGG_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BBQ_RIBS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BEEF_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BEEF_WELLINGTON.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BOILED_EGG.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BUTTERED_PASTA.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BUTTERED_TOAST.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CARROT_SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CARROT_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHEESE_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHEESEBURGER.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHEESECAKE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_ALFREDO.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_FRIED_STEAK.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_PARM.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_STEW.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CHOCOLATE_CUSTARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CURRY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CURRY_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.EGG_BASKET.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.EGG_SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.EGG_SALAD_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_AND_CHIPS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_CAKES.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_SALAD_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FISH_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FRENCH_FRIES.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FRIED_BRAINS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FRIED_CHICKEN.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FRIED_FISH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FRIED_MUSHROOMS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FUDGE_POPSICLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.FURIKAKE_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLAZED_CARROT.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLOW_BERRY_COOKIE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLOW_BERRY_JUICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GLOW_BERRY_POPSICLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GOLDEN_JAM_TOAST.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.GRILLED_CHEESE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HAGGIS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HASH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HASHBROWNS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HONEY_CUSTARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HONEY_POPSICLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.HOTDISH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JAM_TOAST.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BLACK.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BLUE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BROWN.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_CYAN.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_GREEN.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_GREY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_LIGHT_BLUE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_LIGHT_GREY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_LIME.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_MAGENTA.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_ORANGE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_PINK.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_PURPLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_RED.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_WHITE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_YELLOW.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.JERKY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.LAMB_STEW.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.LAMB_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.LASAGNA.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.LIVER_ONIONS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MACARONI_CHEESE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MASHED_POTATO_GRAVY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MEAT_LOAF.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MEAT_LOAF_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MEAT_PIE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MUSHROOM_BURGER.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.MUSHROOM_RISOTTO.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.OMELETTE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.OXTAIL_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PASTA_ALFREDO.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PASTA_TOMATO.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PORK_STEW.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PORK_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PORK_TENDERLOIN.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.POT_ROAST.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.POTATO_CHIPS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.POTATO_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PULLED_PORK_SANDWICH.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PUMPKIN_COOKIE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.PUMPKIN_CUSTARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.QUICHE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.RABBIT_STEW_RICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.RACK_LAMB.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.RICEBALL.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.RICEBALL_FILLED.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.ROASTED_APPLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.ROASTED_CARROT.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SALISBURY_STEAK.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SAUSAGE_ROLL.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SCRAMBLED_EGGS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SEAWEED_CRISPS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SEAWEED_SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SOS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.STIRFRY.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.STUFFED_HEART.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.STUFFED_MUSHROOMS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SUGAR_COOKIE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SWEET_BERRY_CUSTARD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SWEET_BERRY_JUICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.SWEET_BERRY_POPSICLE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.TOMATO_JUICE.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.TOMATO_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CACTUS_EGGS.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CACTUS_SALAD.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.CACTUS_SOUP.get()).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.STUFFED_CACTUS.get()).setWeight(1))
						));

		t.accept(ingredients,
				LootTable.lootTable()
						.withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 30))
								.add(LootItem.lootTableItem(ExtraDelightItems.AGAR_AGAR.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.ALFREDO_SAUCE.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.APPLE_JAM.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.BBQ_SAUCE.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.BREAD_CRUMBS.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.BREAD_SLICE.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.BUTTER.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.CARROT_JAM.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.CHEESE.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.COOKED_PASTA.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.COOKING_OIL.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.CROUTONS.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.EGG_MIX.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.FISH_FLAKES.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.FLOUR.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.GRATED_CARROT.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.GRATED_POTATO.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.GRAVY.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.KETCHUP.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.MACARONI.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.MAYO.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.OMELETTE_MIX.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.POTATO_STICKS.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.SLICED_APPLE.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.SLICED_ONION.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.SLICED_POTATO.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.SLICED_TOMATO.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.SUNFLOWER_SEEDS.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.TOAST.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.VINEGAR.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.WHIPPED_CREAM.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.YEAST.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.COOKED_CACTUS.get()).setWeight(1))
								.add(LootItem.lootTableItem(ExtraDelightItems.CACTUS.get()).setWeight(1))
								));

		t.accept(feasts, LootTable.lootTable().withPool(LootPool.lootPool().name("main")
				.setRolls(UniformGenerator.between(1, 5))
				.add(LootItem.lootTableItem(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.BEEF_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.CHICKEN_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.CURRY_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.FISH_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.HAGGIS_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.HASH_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.HOTDISH_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_RED_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.LAMB_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.LASAGNA_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.MEAT_LOAF_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.PORK_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.RABBIT_STEW_FEAST.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.SALAD_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get()).setWeight(1))
				.add(LootItem.lootTableItem(ExtraDelightItems.STIRFRY_FEAST_ITEM.get()).setWeight(1))));

		t.accept(dungeon_rot, LootTable.lootTable()
				.withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(1, 15))
						.add(LootTableReference.lootTableReference(StructureLootTables.meals).setWeight(1))
						.add(LootItem.lootTableItem(ExtraDelightItems.BAD_FOOD.get()).setWeight(20))));
		
		t.accept(cactus_juice,
				LootTable.lootTable().withPool(LootPool.lootPool().name("main").setRolls(UniformGenerator.between(0, 5))
						.add(LootItem.lootTableItem(ExtraDelightItems.CACTUS_JUICE.get()))));
	}

}

package com.lance5057.extradelight.modules;

import com.lance5057.extradelight.*;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.crops.CucumberCrop;
import com.lance5057.extradelight.blocks.crops.SoybeanCrop;
import com.lance5057.extradelight.blocks.fluids.VinegarFluidBlock;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.util.EDItemGenerator;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class Fermentation {
	public static final DeferredBlock<CucumberCrop> CUCUMBER_CROP = ExtraDelightBlocks.BLOCKS.register("cucumber_crop",
			() -> new CucumberCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));
	public static final DeferredBlock<SoybeanCrop> SOYBEAN_CROP = ExtraDelightBlocks.BLOCKS.register("soybean_crop",
			() -> new SoybeanCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));

	public static final DeferredBlock<Block> WILD_CUCUMBER = ExtraDelightBlocks.BLOCKS.register("wild_cucumber",
			() -> new WildCropBlock(MobEffects.MOVEMENT_SPEED, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
	public static final DeferredBlock<Block> WILD_SOYBEAN = ExtraDelightBlocks.BLOCKS.register("wild_soybean",
			() -> new WildCropBlock(MobEffects.SATURATION, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));

	public static final DeferredItem<Item> WILD_CUCUMBER_ITEM = ExtraDelightItems.ITEMS.register("wild_cucumber_item",
			() -> new BlockItem(WILD_CUCUMBER.get(), new Item.Properties()));
	public static final DeferredItem<Item> WILD_SOYBEAN_ITEM = ExtraDelightItems.ITEMS.register("wild_soybean_item",
			() -> new BlockItem(WILD_SOYBEAN.get(), new Item.Properties()));

	public static final DeferredItem<Item> CUCUMBER = ExtraDelightItems.ITEMS.register("cucumber",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SOYBEAN_POD = ExtraDelightItems.ITEMS.register("soybean_pod",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> CUCUMBER_SEED = ExtraDelightItems.ITEMS.register("cucumber_seed",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SOYBEANS = ExtraDelightItems.ITEMS.register("soybeans",
			() -> new Item(new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> GHERKINS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("gherkins_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> GHERKINS_BLOCK_ITEM = EDItemGenerator
			.register("gherkins_block_item", () -> new BlockItem(GHERKINS_BLOCK.get(), new Item.Properties()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> GHERKIN_ITEM = EDItemGenerator
			.register("gherkin_item", () -> new Item(new Item.Properties())).advancementIngredients().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_BEETS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_beets_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_BEETS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_beets_block_item", () -> new BlockItem(PICKLED_BEETS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_BEET_ITEM = EDItemGenerator
			.register("pickled_beet_item", () -> new Item(new Item.Properties())).advancementIngredients()
			.servingToolTip().finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_ONIONS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_onions_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_ONIONS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_onions_block_item", () -> new BlockItem(PICKLED_ONIONS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_ONION_ITEM = EDItemGenerator
			.register("pickled_onion_item", () -> new Item(new Item.Properties())).advancementIngredients()
			.servingToolTip().finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_CARROTS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_carrots_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_CARROTS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_carrots_block_item", () -> new BlockItem(PICKLED_CARROTS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_CARROT_ITEM = EDItemGenerator
			.register("pickled_carrot_item", () -> new Item(new Item.Properties())).advancementSnack().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_EGGS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_eggs_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_EGGS_BLOCK_ITEM = ExtraDelightItems.ITEMS
			.register("pickled_eggs_block_item", () -> new BlockItem(PICKLED_EGGS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_EGG_ITEM = EDItemGenerator
			.register("pickled_egg_item", () -> new Item(new Item.Properties())).advancementSnack().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_FISH_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_fish_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_FISH_BLOCK_ITEM = ExtraDelightItems.ITEMS
			.register("pickled_fish_block_item", () -> new BlockItem(PICKLED_FISH_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_FISH_ITEM = EDItemGenerator
			.register("pickled_fish_item", () -> new Item(new Item.Properties())).advancementSnack().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_TOMATOES_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_tomatoes_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_TOMATOES_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_tomatoes_block_item", () -> new BlockItem(PICKLED_TOMATOES_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_TOMATO_ITEM = EDItemGenerator
			.register("pickled_tomato_item", () -> new Item(new Item.Properties())).advancementSnack().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_SAUSAGE_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_sausage_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_SAUSAGE_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_sausage_block_item", () -> new BlockItem(PICKLED_SAUSAGE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PICKLED_SAUSAGE_ITEM = EDItemGenerator
			.register("pickled_sausage_item", () -> new Item(new Item.Properties())).advancementSnack().servingToolTip()
			.finish();

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_GINGER_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_ginger_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_GINGER_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_ginger_block_item", () -> new BlockItem(PICKLED_GINGER_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> SOY_SAUCE_ITEM = ExtraDelightItems.ITEMS.register("soy_sauce_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SAUERKRAUT_ITEM = ExtraDelightItems.ITEMS.register("sauerkraut_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> KIMCHI_ITEM = ExtraDelightItems.ITEMS.register("kimchi_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> HOT_SAUCE_ITEM = ExtraDelightItems.ITEMS.register("hot_sauce_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> MISO_ITEM = ExtraDelightItems.ITEMS.register("miso_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> NATTO_ITEM = ExtraDelightItems.ITEMS.register("natto_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> FISH_SAUCE_ITEM = ExtraDelightItems.ITEMS.register("fish_sauce_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SALAMI_ITEM = ExtraDelightItems.ITEMS.register("salami_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SOAKED_SOYBEANS_ITEM = ExtraDelightItems.ITEMS
			.register("soaked_soybeans_item", () -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> MOO_NAEM_ITEM = ExtraDelightItems.ITEMS.register("moo_naem_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SLICED_CUCUMBER_ITEM = EDItemGenerator
			.register("sliced_cucumber_item", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> SLICED_GHERKIN_ITEM = EDItemGenerator
			.register("sliced_gherkin_item", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	public static final DeferredItem<Item> PICKLE_JUICE = EDItemGenerator
			.register("pickle_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> PICKLE_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register("pickle_juice_fluid_bucket",
			() -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.PICKLE_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> PICKLE_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register("pickle_juice_fluid_block",
			() -> new VinegarFluidBlock(ExtraDelightFluids.PICKLE_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));


	public static void blockModels(BlockStateProvider bsp) {
		BlockModels.recipeFeastBlock(bsp, GHERKINS_BLOCK.get(), "gherkin_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_BEETS_BLOCK.get(), "pickled_beets_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_ONIONS_BLOCK.get(), "pickled_onions_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_CARROTS_BLOCK.get(), "pickled_carrot_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_EGGS_BLOCK.get(), "pickled_egg_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_FISH_BLOCK.get(), "pickled_fish_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_SAUSAGE_BLOCK.get(), "pickled_sausage_jar");
		BlockModels.recipeFeastBlock(bsp, PICKLED_GINGER_BLOCK.get(), "pickled_ginger_jar");

		BlockModels.cropCrossBlock(bsp, Fermentation.CUCUMBER_CROP.get(), "cucumber", CucumberCrop.AGE);
		bsp.simpleBlock(Fermentation.WILD_CUCUMBER.get(), new ConfiguredModel(bsp.models()
				.cross("wild_cucumber", bsp.modLoc("block/crops/cucumber/cucumber_stage7")).renderType("cutout")));
	}

	public static void itemModels(ItemModelProvider tmp) {
		ItemModels.forBlockItemFlat(tmp, Fermentation.WILD_CUCUMBER_ITEM, "crops/cucumber/cucumber_stage7");
		ItemModels.forItem(tmp, Fermentation.CUCUMBER, "crops/cucumber/cucumber");
		tmp.getBuilder(Fermentation.GHERKINS_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/gherkin_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_BEETS_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_beets_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_ONIONS_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_onions_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_CARROTS_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_carrot_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_EGGS_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_egg_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_FISH_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_fish_jar_stage0")));
		tmp.getBuilder(Fermentation.PICKLED_GINGER_BLOCK_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/pickled_ginger_jar_stage0")));
		ItemModels.forItem(tmp, Fermentation.SLICED_CUCUMBER_ITEM, "crops/cucumber/cucumber_slices");
		ItemModels.forItem(tmp, Fermentation.GHERKIN_ITEM, "gherkin");
		ItemModels.forItem(tmp, Fermentation.SLICED_GHERKIN_ITEM, "gherkin_slices");
	}

	public static void Recipes(RecipeOutput consumer) {
		// Vanilla Crafting
//		this.bucket("pickle_juice", consumer, PICKLE_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
//				PICKLE_JUICE.get());

		// Cutting board
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Fermentation.CUCUMBER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						Fermentation.SLICED_CUCUMBER_ITEM.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_cucumber_knife"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Fermentation.GHERKIN_ITEM.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						Fermentation.SLICED_GHERKIN_ITEM.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_gherkin_knife"));

		// Feasts
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(GHERKIN_ITEM.get()),
						GHERKINS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(GHERKINS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("gherkin_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_BEET_ITEM.get()),
						PICKLED_BEETS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_BEETS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_beet_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_ONION_ITEM.get()),
						PICKLED_ONIONS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_ONIONS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_onion_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_CARROT_ITEM.get()),
						PICKLED_CARROTS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_CARROTS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_carrot_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_EGG_ITEM.get()),
						PICKLED_EGGS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_EGGS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_egg_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_FISH_ITEM.get()),
						PICKLED_FISH_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_FISH_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_fish_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_TOMATO_ITEM.get()),
						PICKLED_TOMATOES_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_TOMATOES_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_tomato_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_SAUSAGE_ITEM.get()),
						PICKLED_SAUSAGE_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_SAUSAGE_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_sausage_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(ExtraDelightItems.PICKLED_GINGER.get()),
						PICKLED_GINGER_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_GINGER_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_ginger_pull_feast"));
	}

	public static void EngLoc(LanguageProvider lp) {
		lp.add(CUCUMBER_CROP.get(), "Cucumbers");
		lp.add(SOYBEAN_CROP.get(), "Soybeans");
		lp.add(WILD_CUCUMBER.get(), "Wild Cucumber");
		lp.add(WILD_SOYBEAN.get(), "Wild Soybean");
		lp.add(CUCUMBER.get(), "Cucumber");
		lp.add(SOYBEAN_POD.get(), "Soybean Pod");
		lp.add(CUCUMBER_SEED.get(), "Cucumber Seeds");
		lp.add(SOYBEANS.get(), "Soybeans");
		lp.add(GHERKINS_BLOCK.get(), "Jar of Gherkins");
		lp.add(GHERKIN_ITEM.get(), "Gherkin");
		lp.add(PICKLED_BEETS_BLOCK.get(), "Jar of Pickled Sliced Beetroot");
		lp.add(PICKLED_BEET_ITEM.get(), "Pickled Sliced Beetroot");
		lp.add(PICKLED_ONIONS_BLOCK.get(), "Jar of Pickled Onions");
		lp.add(PICKLED_ONION_ITEM.get(), "Pickled Onion");
		lp.add(PICKLED_CARROTS_BLOCK.get(), "Jar of Pickled Carrot");
		lp.add(PICKLED_CARROT_ITEM.get(), "Pickled Carrot");
		lp.add(PICKLED_EGGS_BLOCK.get(), "Jar of Pickled Eggs");
		lp.add(PICKLED_EGG_ITEM.get(), "Pickled Egg");
		lp.add(PICKLED_FISH_BLOCK.get(), "Jar of Pickled Fish");
		lp.add(PICKLED_FISH_ITEM.get(), "Pickled Fish");
		lp.add(PICKLED_TOMATOES_BLOCK.get(), "Jar of Pickled Tomatoes");
		lp.add(PICKLED_TOMATO_ITEM.get(), "Pickled Tomato");
		lp.add(PICKLED_SAUSAGE_BLOCK.get(), "Jar of Pickled Sausage");
		lp.add(PICKLED_SAUSAGE_ITEM.get(), "Pickled Sausage");
		lp.add(PICKLED_GINGER_BLOCK.get(), "Jar of Pickled Ginger");
		lp.add(SOY_SAUCE_ITEM.get(), "Soy Sauce");
		lp.add(SAUERKRAUT_ITEM.get(), "Sauerkraut");
		lp.add(KIMCHI_ITEM.get(), "Kimchi");
		lp.add(HOT_SAUCE_ITEM.get(), "Hot Sauce");
		lp.add(MISO_ITEM.get(), "Miso");
		lp.add(NATTO_ITEM.get(), "Natto");
		lp.add(FISH_SAUCE_ITEM.get(), "Fish Sauce");
		lp.add(SALAMI_ITEM.get(), "Salami");
		lp.add(SOAKED_SOYBEANS_ITEM.get(), "Soaked Soybeans");
		lp.add(MOO_NAEM_ITEM.get(), "Moo Naem");
		lp.add(SLICED_CUCUMBER_ITEM.get(), "Sliced Cucumber");
		lp.add(SLICED_GHERKIN_ITEM.get(), "Sliced Gherkin");
		lp.add(PICKLE_JUICE.get(), "Pickle Juice");
		lp.add(PICKLE_JUICE_FLUID_BUCKET.get(), "Pickle Juice Bucket");
		lp.add("fluid_type.extradelight.pickle_juice_fluid", "Pickle Juice");
		lp.add("block.extradelight.pickle_juice_fluid_block", "Pickle Juice");
	}
}

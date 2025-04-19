package com.lance5057.extradelight.modules;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.crops.CucumberCrop;
import com.lance5057.extradelight.blocks.crops.SoybeanCrop;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

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
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> GHERKINS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register("gherkins_block_item",
			() -> new BlockItem(GHERKINS_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_BEETS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_beets_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_BEETS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_beets_block_item", () -> new BlockItem(PICKLED_BEETS_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_ONIONS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_onions_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_ONIONS_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_onions_block_item", () -> new BlockItem(PICKLED_ONIONS_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_EGGS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_eggs_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_EGGS_BLOCK_ITEM = ExtraDelightItems.ITEMS
			.register("pickled_eggs_block_item", () -> new BlockItem(PICKLED_EGGS_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_FISH_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_fish_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_FISH_BLOCK_ITEM = ExtraDelightItems.ITEMS
			.register("pickled_fish_block_item", () -> new BlockItem(PICKLED_FISH_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_TOMATOES_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_tomatoes_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_TOMATOES_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_tomatoes_block_item", () -> new BlockItem(PICKLED_TOMATOES_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_WATERMELON_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_watermelon_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_WATERMELON_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_watermelon_block_item",
			() -> new BlockItem(PICKLED_WATERMELON_BLOCK.get(), new Item.Properties()));

	public static final DeferredBlock<RecipeFeastBlock> PICKLED_SAUSAGE_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_sausage_block",
					() -> new RecipeFeastBlock(
							BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(0.8F)
									.sound(SoundType.LANTERN).mapColor(MapColor.COLOR_BROWN),
							true, ExtraDelightBlocks.pot));
	public static final DeferredItem<Item> PICKLED_SAUSAGE_BLOCK_ITEM = ExtraDelightItems.ITEMS.register(
			"pickled_sausage_block_item", () -> new BlockItem(PICKLED_SAUSAGE_BLOCK.get(), new Item.Properties()));

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

	public static final DeferredItem<Item> GHERKIN_ITEM = ExtraDelightItems.ITEMS.register("gherkin_item",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SLICED_CUCUMBER_ITEM = ExtraDelightItems.ITEMS
			.register("sliced_cucumber_item", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SLICED_GHERKIN_ITEM = ExtraDelightItems.ITEMS.register("sliced_gherkin_item",
			() -> new Item(new Item.Properties()));

	public static void blockModels(BlockStateProvider bsp) {
		bsp.getVariantBuilder(GHERKINS_BLOCK.get()).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (GHERKINS_BLOCK.get().getMaxServings() - servings);

			if (servings == 0) {
				suffix = GHERKINS_BLOCK.get().hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/gherkin_jar" + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});

//		bsp.simpleBlock(GHERKINS_BLOCK.get(), bsp.models()
//				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/gherkin_jar")));
	}

	public static void Recipes(RecipeOutput consumer) {
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(GHERKIN_ITEM.get()),
						GHERKINS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(GHERKINS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("gherkin_pull_feast"));
	}
}

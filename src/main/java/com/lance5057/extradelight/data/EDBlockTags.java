package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.ModTags;

public class EDBlockTags extends BlockTagsProvider {
	public EDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, FarmersDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.registerBlockMineableTags();
	}

	protected void registerBlockMineableTags() {
		tag(BlockTags.LOGS).add(ExtraDelightBlocks.CINNAMON_LOG.get(), ExtraDelightBlocks.FRUIT_LOG.get());
		tag(BlockTags.LOGS_THAT_BURN).add(ExtraDelightBlocks.CINNAMON_LOG.get(), ExtraDelightBlocks.FRUIT_LOG.get());
		tag(BlockTags.LEAVES).add(ExtraDelightBlocks.CINNAMON_LEAVES.get(), ExtraDelightBlocks.HAZELNUT_LEAVES.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(ExtraDelightBlocks.DRYING_RACK.get(),
				ExtraDelightBlocks.FOOD_DISPLAY.get(), ExtraDelightBlocks.DOUGH_SHAPING.get(),
				ExtraDelightBlocks.MIXING_BOWL.get(), ExtraDelightBlocks.CINNAMON_LOG.get());
		AestheticBlocks.STEP_STOOLS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.SPICE_RACKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.SPICE_RACKS_FULL.forEach(this::makeMineableWithAxe);
		AestheticBlocks.KNIFE_BLOCKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.CABINETS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.WALLPAPER_BLOCKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.forEach(this::makeMineableWithAxe);

//		tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE).add(
//
//		);

		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
				// Normal blocks
				ExtraDelightBlocks.OVEN.get(), ExtraDelightBlocks.MORTAR_STONE.get(),

				// Feasts in pans
				ExtraDelightBlocks.LASAGNA.get(), ExtraDelightBlocks.HOTDISH.get(),

				// Feasts in pots
				ExtraDelightBlocks.MACARONI_CHEESE.get(), ExtraDelightBlocks.CURRY.get(),
				ExtraDelightBlocks.BEEF_STEW.get(), ExtraDelightBlocks.PORK_STEW.get(),
				ExtraDelightBlocks.LAMB_STEW.get(), ExtraDelightBlocks.RABBIT_STEW.get(),
				ExtraDelightBlocks.CHICKEN_STEW.get(), ExtraDelightBlocks.FISH_STEW.get(),

				ExtraDelightBlocks.SHEET_BLOCK.get(), ExtraDelightBlocks.LOAF_PAN_BLOCK.get(),
				ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), ExtraDelightBlocks.SERVING_POT_BLOCK.get(),
				ExtraDelightBlocks.PIE_DISH_BLOCK.get(), ExtraDelightBlocks.TRAY_BLOCK.get(),
				ExtraDelightBlocks.BAKING_STONE_BLOCK.get(), ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get());

//		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.MINT_CROP.get());

		tag(ModTags.MINEABLE_WITH_KNIFE).add(
				// Pies and plain cake
				ExtraDelightBlocks.SWEET_BERRY_PIE.get(), ExtraDelightBlocks.GLOW_BERRY_PIE.get(),
				ExtraDelightBlocks.CHEESECAKE.get(), ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
				ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
				ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), ExtraDelightBlocks.QUICHE.get(),
				ExtraDelightBlocks.MEAT_PIE_BLOCK.get(),

				// Feasts in bowls
				ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(),
				ExtraDelightBlocks.HASH_FEAST.get(), ExtraDelightBlocks.PULLED_PORK_FEAST.get(),
				ExtraDelightBlocks.STIRFRY.get(), ExtraDelightBlocks.SALAD.get(),

				// Feasts on plates
				ExtraDelightBlocks.MEATLOAF_FEAST.get(), ExtraDelightBlocks.POT_ROAST_FEAST.get(),
				ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), ExtraDelightBlocks.RACK_LAMB.get(),
				ExtraDelightBlocks.BEEF_WELLINGTON.get(), ExtraDelightBlocks.HAGGIS.get(),

				// Jellies (also plated)
				ExtraDelightBlocks.JELLY_WHITE.get(), ExtraDelightBlocks.JELLY_ORANGE.get(),
				ExtraDelightBlocks.JELLY_MAGENTA.get(), ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(),
				ExtraDelightBlocks.JELLY_YELLOW.get(), ExtraDelightBlocks.JELLY_LIME.get(),
				ExtraDelightBlocks.JELLY_PINK.get(), ExtraDelightBlocks.JELLY_GREY.get(),
				ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), ExtraDelightBlocks.JELLY_CYAN.get(),
				ExtraDelightBlocks.JELLY_PURPLE.get(), ExtraDelightBlocks.JELLY_BLUE.get(),
				ExtraDelightBlocks.JELLY_BROWN.get(), ExtraDelightBlocks.JELLY_GREEN.get(),
				ExtraDelightBlocks.JELLY_RED.get(), ExtraDelightBlocks.JELLY_BLACK.get());
		AestheticBlocks.WALLPAPER_BLOCKS.forEach(this::makeMineableWithKnife);
		AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.forEach(this::makeMineableWithKnife);
		AestheticBlocks.DRIED_CORN_FENCE.forEach(this::makeMineableWithAxe);
		AestheticBlocks.DRIED_CORN_FENCE.forEach(this::makeFence);

		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.WILD_GINGER.get());

		tag(BlockTags.MINEABLE_WITH_HOE).add(ExtraDelightBlocks.CINNAMON_LEAVES.get(),
				ExtraDelightBlocks.HAZELNUT_LEAVES.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(ExtraDelightBlocks.CINNAMON_LOG.get(),
				ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(), ExtraDelightBlocks.CINNAMON_PLANKS.get(),
				ExtraDelightBlocks.CINNAMON_CABINET.get(), ExtraDelightBlocks.CINNAMON_DOOR.get(),
				ExtraDelightBlocks.CINNAMON_FENCE.get(), ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				ExtraDelightBlocks.CINNAMON_STAIRS.get(), ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(),
				ExtraDelightBlocks.CINNAMON_SLAB.get(), ExtraDelightBlocks.CINNAMON_WOOD.get(),
				ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get(), ExtraDelightBlocks.CINNAMON_PRESSURE_PLATE.get(),
				ExtraDelightBlocks.CINNAMON_BUTTON.get(), ExtraDelightBlocks.FRUIT_LOG.get(),
				ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get(), ExtraDelightBlocks.FRUIT_PLANKS.get(),
				ExtraDelightBlocks.FRUIT_CABINET.get(), ExtraDelightBlocks.FRUIT_DOOR.get(),
				ExtraDelightBlocks.FRUIT_FENCE.get(), ExtraDelightBlocks.FRUIT_FENCE_GATE.get(),
				ExtraDelightBlocks.FRUIT_STAIRS.get(), ExtraDelightBlocks.FRUIT_TRAPDOOR.get(),
				ExtraDelightBlocks.FRUIT_SLAB.get(), ExtraDelightBlocks.FRUIT_WOOD.get(),
				ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get(), ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get(),
				ExtraDelightBlocks.FRUIT_BUTTON.get());

		tag(BlockTags.PLANKS).add(ExtraDelightBlocks.CINNAMON_PLANKS.get(), ExtraDelightBlocks.FRUIT_PLANKS.get());
		tag(BlockTags.FENCES).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get());
		tag(BlockTags.WOODEN_FENCES).add(ExtraDelightBlocks.CINNAMON_FENCE.get(), ExtraDelightBlocks.FRUIT_FENCE.get());
		tag(BlockTags.FENCE_GATES).add(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(), ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.FRUIT_FENCE_GATE.get(), ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get());
		tag(BlockTags.STAIRS).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(), ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get());
		tag(BlockTags.WOODEN_STAIRS).add(ExtraDelightBlocks.CINNAMON_STAIRS.get(),
				ExtraDelightBlocks.FRUIT_STAIRS.get());
		tag(BlockTags.SLABS).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(), ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get());
		tag(BlockTags.WOODEN_SLABS).add(ExtraDelightBlocks.CINNAMON_SLAB.get(), ExtraDelightBlocks.FRUIT_SLAB.get());
		tag(BlockTags.TRAPDOORS).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get());
		tag(BlockTags.WOODEN_TRAPDOORS).add(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(),
				ExtraDelightBlocks.FRUIT_TRAPDOOR.get());
		tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ExtraDelightBlocks.CINNAMON_PRESSURE_PLATE.get(),
				ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get());
		tag(BlockTags.WOODEN_BUTTONS).add(ExtraDelightBlocks.CINNAMON_BUTTON.get(),
				ExtraDelightBlocks.FRUIT_BUTTON.get());
		tag(BlockTags.DOORS).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(), ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get());
		tag(BlockTags.WOODEN_DOORS).add(ExtraDelightBlocks.CINNAMON_DOOR.get(),
				ExtraDelightBlocks.FRUIT_DOOR.get());
		tag(BlockTags.SAPLINGS).add(ExtraDelightBlocks.CINNAMON_SAPLING.get(),
				ExtraDelightBlocks.HAZELNUT_SAPLING.get());

		tag(ExtraDelightTags.COLD_SOURCES).add(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE,
					Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW_CAULDRON);
		}

	protected void makeMineableWithAxe(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.MINEABLE_WITH_AXE).add(blockDeferredBlock.get());
	}

	protected void makeMineableWithHoe(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.MINEABLE_WITH_HOE).add(blockDeferredBlock.get());
	}

	protected void makeMineableWithPickaxe(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockDeferredBlock.get());
	}

	protected void makeMineableWithShovel(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.MINEABLE_WITH_AXE).add(blockDeferredBlock.get());
	}

	protected void makeMineableWithKnife(DeferredBlock<Block> blockDeferredBlock) {
		tag(ModTags.MINEABLE_WITH_KNIFE).add(blockDeferredBlock.get());
	}

	protected void makeFence(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.FENCES).add(blockDeferredBlock.get());
	}

}

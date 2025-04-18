package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import com.lance5057.extradelight.modules.Fermentation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
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
		tag(BlockTags.LOGS).add(ExtraDelightBlocks.CINNAMON_LOG.get(), ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(),
				ExtraDelightBlocks.FRUIT_LOG.get(), ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get(),
				ExtraDelightBlocks.CINNAMON_WOOD.get(), ExtraDelightBlocks.FRUIT_WOOD.get(),
				ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get(), ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get());
		tag(BlockTags.LOGS_THAT_BURN).add(ExtraDelightBlocks.CINNAMON_LOG.get(),
				ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(), ExtraDelightBlocks.FRUIT_LOG.get(),
				ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get(), ExtraDelightBlocks.CINNAMON_WOOD.get(),
				ExtraDelightBlocks.FRUIT_WOOD.get(), ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get(),
				ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get());
		tag(BlockTags.LEAVES).add(ExtraDelightBlocks.CINNAMON_LEAVES.get(), ExtraDelightBlocks.HAZELNUT_LEAVES.get(),
				ExtraDelightBlocks.APPLE_LEAVES.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(ExtraDelightBlocks.DRYING_RACK.get(),
				ExtraDelightBlocks.FOOD_DISPLAY.get(), ExtraDelightBlocks.DOUGH_SHAPING.get(),
				ExtraDelightBlocks.MIXING_BOWL.get());
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
				ExtraDelightBlocks.CHILI_CON_CARNE_FEAST.get(), ExtraDelightBlocks.WHITE_CHILI_FEAST.get(),
				ExtraDelightBlocks.STUFFING.get(),

				ExtraDelightBlocks.SHEET_BLOCK.get(), ExtraDelightBlocks.LOAF_PAN_BLOCK.get(),
				ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), ExtraDelightBlocks.SERVING_POT_BLOCK.get(),
				ExtraDelightBlocks.PIE_DISH_BLOCK.get(), ExtraDelightBlocks.TRAY_BLOCK.get(),
				ExtraDelightBlocks.BAKING_STONE_BLOCK.get(), ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(),
				ExtraDelightBlocks.KEG.get(), ExtraDelightBlocks.MELTING_POT.get(), ExtraDelightBlocks.CHILLER.get(),
				ExtraDelightBlocks.BAR_MOLD.get(), ExtraDelightBlocks.FUNNEL.get(), ExtraDelightBlocks.JAR.get(),
				ExtraDelightBlocks.TAP.get(), ExtraDelightBlocks.VAT.get(), ExtraDelightBlocks.LID.get(),
				ExtraDelightBlocks.EVAPORATOR.get(),

				// Chocolate
				ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(), ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(), ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(), ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get(),
				ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(), ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(), ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(), ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get(), ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get());

//		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.MINT_CROP.get());

		tag(ModTags.MINEABLE_WITH_KNIFE).add(
				// Pies and plain cake
				ExtraDelightBlocks.SWEET_BERRY_PIE.get(), ExtraDelightBlocks.GLOW_BERRY_PIE.get(),
				ExtraDelightBlocks.CHEESECAKE.get(), ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
				ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
				ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), ExtraDelightBlocks.QUICHE.get(),
				ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(),
				ExtraDelightBlocks.PUMPKIN_PIE.get(), ExtraDelightBlocks.PUMPKIN_ROLL.get(),
				ExtraDelightBlocks.APPLE_CHEESECAKE.get(), ExtraDelightBlocks.COFFEE_CAKE.get(),
				ExtraDelightBlocks.MILK_TART.get(), ExtraDelightBlocks.CHOCOLATE_CAKE.get(),
				ExtraDelightBlocks.TARTE_TATIN.get(),

				// Feasts in bowls
				ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(),
				ExtraDelightBlocks.HASH_FEAST.get(), ExtraDelightBlocks.PULLED_PORK_FEAST.get(),
				ExtraDelightBlocks.STIRFRY.get(), ExtraDelightBlocks.SALAD.get(), ExtraDelightBlocks.PORK_STEW.get(),
				ExtraDelightBlocks.LAMB_STEW.get(), ExtraDelightBlocks.CHICKEN_STEW.get(),
				ExtraDelightBlocks.CURRY.get(), ExtraDelightBlocks.MACARONI_CHEESE.get(),
				ExtraDelightBlocks.LASAGNA.get(), ExtraDelightBlocks.HOTDISH.get(), ExtraDelightBlocks.HASH_FEAST.get(),
				ExtraDelightBlocks.CORNBREAD.get(), ExtraDelightBlocks.CORN_PUDDING.get(),
				ExtraDelightBlocks.APPLE_CRISP.get(), ExtraDelightBlocks.POTATO_AU_GRATIN.get(),
				ExtraDelightBlocks.CINNAMON_ROLLS.get(), ExtraDelightBlocks.PUNCH.get(),
				ExtraDelightBlocks.BROWNIES.get(), ExtraDelightBlocks.BLONDIES.get(), ExtraDelightBlocks.FUDGE.get(),
				ExtraDelightBlocks.CRISP_RICE_TREATS.get(), ExtraDelightBlocks.SCOTCHAROOS.get(),
				ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get(), ExtraDelightBlocks.STUFFED_APPLES_FEAST.get(),
				ExtraDelightBlocks.MARSHMALLOW_SLICE_FEAST.get(), ExtraDelightBlocks.BRUSCHETTA_FEAST.get(),

				// Feasts on plates
				ExtraDelightBlocks.MEATLOAF_FEAST.get(), ExtraDelightBlocks.POT_ROAST_FEAST.get(),
				ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), ExtraDelightBlocks.RACK_LAMB.get(),
				ExtraDelightBlocks.BEEF_WELLINGTON.get(), ExtraDelightBlocks.HAGGIS.get(),
				ExtraDelightBlocks.MINT_LAMB.get(), ExtraDelightBlocks.CHARCUTERIE_BOARD.get(),
				ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), ExtraDelightBlocks.MONKEY_BREAD.get(),
				ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get(), ExtraDelightBlocks.PORK_AND_APPLES_FEAST.get(),

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

		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.WILD_GINGER.get(), ExtraDelightBlocks.WILD_PEANUT.get(),
				ExtraDelightBlocks.WILD_CHILI.get(), ExtraDelightBlocks.WILD_MALLOW_ROOT.get(),
				ExtraDelightBlocks.WILD_GARLIC.get(), Fermentation.WILD_CUCUMBER.get(), Fermentation.WILD_SOYBEAN.get());

		tag(BlockTags.MINEABLE_WITH_HOE).add(ExtraDelightBlocks.CINNAMON_LEAVES.get(),
				ExtraDelightBlocks.HAZELNUT_LEAVES.get(), ExtraDelightBlocks.APPLE_LEAVES.get());
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
		tag(BlockTags.FENCE_GATES).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(), ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get());
		tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				ExtraDelightBlocks.FRUIT_FENCE_GATE.get());
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
		tag(BlockTags.WOODEN_DOORS).add(ExtraDelightBlocks.CINNAMON_DOOR.get(), ExtraDelightBlocks.FRUIT_DOOR.get());
		tag(BlockTags.SAPLINGS).add(ExtraDelightBlocks.CINNAMON_SAPLING.get(),
				ExtraDelightBlocks.HAZELNUT_SAPLING.get(), ExtraDelightBlocks.APPLE_SAPLING.get());

		tag(ExtraDelightTags.COLD_SOURCES).add(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE,
				Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW_CAULDRON);

		tag(BlockTags.BEE_GROWABLES).add(ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightBlocks.CORN_BOTTOM.get(),
				ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightBlocks.GINGER_CROP.get(),
				ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), ExtraDelightBlocks.PEANUT_CROP.get(),
				ExtraDelightBlocks.GARLIC_CROP.get(), Fermentation.CUCUMBER_CROP.get(), Fermentation.SOYBEAN_CROP.get());

		// Dyed Tags
		tag(Tags.Blocks.DYED_BLACK).add(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_BLUE).add(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_BROWN).add(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_CYAN).add(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_GRAY).add(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_GREEN).add(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_LIGHT_BLUE).add(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_LIGHT_GRAY).add(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_LIME).add(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_MAGENTA).add(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_ORANGE).add(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_PINK).add(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_PURPLE).add(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_RED).add(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_WHITE).add(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get());
		tag(Tags.Blocks.DYED_YELLOW).add(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get());

		// Storage Blocks
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ExtraDelightTags.STORAGE_BLOCKS_FLOUR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_MEAL).addTag(ExtraDelightTags.STORAGE_BLOCKS_SUGAR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_ON_COB).addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_HUSK)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_DRIED_CORN_HUSK)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_COB).addTag(ExtraDelightTags.STORAGE_BLOCKS_GINGER)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_EGGS).addTag(ExtraDelightTags.STORAGE_BLOCKS_APPLE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GOLDEN_APPLE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_BROWN_MUSHROOM)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_RED_MUSHROOM)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_SWEET_BERRIES)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GLOW_BERRIES).addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_SILK)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GROUND_CINNAMON)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_RAW_CINNAMON)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CINNAMON_STICK)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_BREAD_CRUMBS).addTag(ExtraDelightTags.STORAGE_BLOCKS_MINT)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_MARSHMALLOW)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GOLDEN_CARROT)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_BLOOD_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_DARK_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_MILK_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_WHITE_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CHILI).addTag(ExtraDelightTags.STORAGE_BLOCKS_CHILI_POWDER)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_PEANUTS_IN_SHELL)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_PEANUTS).addTag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_PEANUTS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_HAZELNUTS_IN_SHELL)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_HAZELNUTS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_HAZELNUTS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_MALLOW_ROOT)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_MALLOW_POWDER)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_COFFEE_CHERRIES)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GREEN_COFFEE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_COFFEE_BEANS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GROUND_COFFEE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_BEANS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_COCOA_BEANS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_SOLIDS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_POWDER)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_KERNELS).addTag(ExtraDelightTags.STORAGE_BLOCKS_GARLIC);

		tag(ExtraDelightTags.STORAGE_BLOCKS_FLOUR).add(ExtraDelightBlocks.FLOUR_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_MEAL).add(ExtraDelightBlocks.CORNMEAL_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_SUGAR).add(ExtraDelightBlocks.SUGAR_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_ON_COB).add(ExtraDelightBlocks.CORN_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_HUSK).add(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_DRIED_CORN_HUSK).add(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_COB).add(ExtraDelightBlocks.CORN_COB_BUNDLE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GINGER).add(ExtraDelightBlocks.GINGER_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_EGGS).add(ExtraDelightBlocks.EGG_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_APPLE).add(ExtraDelightBlocks.APPLE_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GOLDEN_APPLE).add(ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_BROWN_MUSHROOM).add(ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_RED_MUSHROOM).add(ExtraDelightBlocks.RED_MUSHROOM_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_SWEET_BERRIES).add(ExtraDelightBlocks.SWEET_BERRY_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GLOW_BERRIES).add(ExtraDelightBlocks.GLOW_BERRY_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_SILK).add(ExtraDelightBlocks.CORN_SILK_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GROUND_CINNAMON).add(ExtraDelightBlocks.GROUND_CINNAMON_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_RAW_CINNAMON).add(ExtraDelightBlocks.RAW_CINNAMON_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CINNAMON_STICK).add(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_BREAD_CRUMBS).add(ExtraDelightBlocks.BREADCRUMB_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_MINT).add(ExtraDelightBlocks.MINT_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_MARSHMALLOW).add(ExtraDelightBlocks.MARSHMALLOW_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GOLDEN_CARROT).add(ExtraDelightBlocks.GOLDEN_CARROT_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_BLOOD_CHOCOLATE_BAR).add(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_DARK_CHOCOLATE_BAR).add(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_MILK_CHOCOLATE_BAR).add(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_WHITE_CHOCOLATE_BAR).add(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CHILI).add(ExtraDelightBlocks.CHILI_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CHILI_POWDER).add(ExtraDelightBlocks.CHILI_POWDER_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_PEANUTS_IN_SHELL).add(ExtraDelightBlocks.PEANUT_IN_SHELL_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_PEANUTS).add(ExtraDelightBlocks.PEANUT_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_PEANUTS).add(ExtraDelightBlocks.ROASTED_PEANUT_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_HAZELNUTS_IN_SHELL).add(ExtraDelightBlocks.HAZELNUT_IN_SHELL_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_HAZELNUTS).add(ExtraDelightBlocks.HAZELNUT_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_HAZELNUTS).add(ExtraDelightBlocks.ROASTED_HAZELNUT_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_MALLOW_ROOT).add(ExtraDelightBlocks.MALLOW_ROOT_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_MALLOW_POWDER).add(ExtraDelightBlocks.MALLOW_POWDER_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_COFFEE_CHERRIES).add(ExtraDelightBlocks.COFFEE_CHERRY_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GREEN_COFFEE).add(ExtraDelightBlocks.GREEN_COFFEE_BEAN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_COFFEE_BEANS).add(ExtraDelightBlocks.COFFEE_BEAN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GROUND_COFFEE).add(ExtraDelightBlocks.GROUND_COFFEE_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_BEANS).add(ExtraDelightBlocks.COCOA_BEAN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_ROASTED_COCOA_BEANS).add(ExtraDelightBlocks.ROASTED_COCOA_BEAN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_SOLIDS).add(ExtraDelightBlocks.COCOA_SOLIDS_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_COCOA_POWDER).add(ExtraDelightBlocks.COCOA_POWDER_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_CORN_KERNELS).add(ExtraDelightBlocks.CORN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GARLIC).add(ExtraDelightBlocks.GARLIC_CRATE.get());
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
		tag(BlockTags.MINEABLE_WITH_SHOVEL).add(blockDeferredBlock.get());
	}

	protected void makeMineableWithKnife(DeferredBlock<Block> blockDeferredBlock) {
		tag(ModTags.MINEABLE_WITH_KNIFE).add(blockDeferredBlock.get());
	}

	protected void makeFence(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.WOODEN_FENCES).add(blockDeferredBlock.get());
	}

}

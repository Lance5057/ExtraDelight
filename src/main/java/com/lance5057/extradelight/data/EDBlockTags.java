package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.lance5057.extradelight.CompatTags;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import com.lance5057.extradelight.modules.Fermentation;
import com.lance5057.extradelight.modules.SummerCitrus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.CommonTags;
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
				ExtraDelightBlocks.APPLE_LEAVES.get(), SummerCitrus.LEMON_LEAVES.get(), SummerCitrus.LIME_LEAVES.get(),
				SummerCitrus.ORANGE_LEAVES.get(), SummerCitrus.GRAPEFRUIT_LEAVES.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(ExtraDelightBlocks.DRYING_RACK.get(),
				/* ExtraDelightBlocks.FOOD_DISPLAY.get(), */ ExtraDelightBlocks.DOUGH_SHAPING.get(),
				ExtraDelightBlocks.MIXING_BOWL.get());
		AestheticBlocks.STEP_STOOLS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.SPICE_RACKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.SPICE_RACKS_FULL.forEach(this::makeMineableWithAxe);
		AestheticBlocks.KNIFE_BLOCKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.CABINETS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.SINKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.COUNTER_CABINETS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.FOOD_DISPLAY.forEach(this::makeMineableWithAxe);
		AestheticBlocks.WALLPAPER_BLOCKS.forEach(this::makeMineableWithAxe);
		AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.forEach(this::makeMineableWithAxe);

		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
				// Normal blocks
				ExtraDelightBlocks.OVEN.get(), ExtraDelightBlocks.MORTAR_STONE.get(), ExtraDelightBlocks.JUICER.get(),

				// Feasts in pans
				ExtraDelightBlocks.LASAGNA.get(), ExtraDelightBlocks.HOTDISH.get(),
				Fermentation.CHEESYMITE_SCROLL_BLOCK.get(),

				// Feasts in pots
				ExtraDelightBlocks.MACARONI_CHEESE.get(), ExtraDelightBlocks.CURRY.get(),
				ExtraDelightBlocks.BEEF_STEW.get(), ExtraDelightBlocks.PORK_STEW.get(),
				ExtraDelightBlocks.LAMB_STEW.get(), ExtraDelightBlocks.RABBIT_STEW.get(),
				ExtraDelightBlocks.CHICKEN_STEW.get(), ExtraDelightBlocks.FISH_STEW.get(),
				ExtraDelightBlocks.CHILI_CON_CARNE_FEAST.get(), ExtraDelightBlocks.WHITE_CHILI_FEAST.get(),
				ExtraDelightBlocks.STUFFING.get(),

				// Feasts in jars
				Fermentation.GHERKINS_BLOCK.get(), Fermentation.PICKLED_BEETS_BLOCK.get(),
				Fermentation.PICKLED_ONIONS_BLOCK.get(), Fermentation.PICKLED_CARROTS_BLOCK.get(),
				Fermentation.PICKLED_EGGS_BLOCK.get(), Fermentation.PICKLED_FISH_BLOCK.get(),
				Fermentation.PICKLED_SAUSAGE_BLOCK.get(), Fermentation.PICKLED_GINGER_BLOCK.get(),
				SummerCitrus.PRESERVED_LEMONS_BLOCK.get(), SummerCitrus.PICKLED_RINDS_BLOCK.get(),

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
				ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get(),

				// Misc
				ExtraDelightBlocks.CHEESE_BLOCK.get(), ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(),
				ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(),
				ExtraDelightBlocks.BUTTER_BLOCK.get(), ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(),
				ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(),
				ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get(), ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get(),
				ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get(),
				Fermentation.SALT_BLOCK.get(), ExtraDelightBlocks.CANDY_BOWL.get()
		);

//		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.MINT_CROP.get());

		tag(CommonTags.Blocks.MINEABLE_WITH_KNIFE).add(
				// Pies and plain cake
				ExtraDelightBlocks.SWEET_BERRY_PIE.get(), ExtraDelightBlocks.GLOW_BERRY_PIE.get(),
				ExtraDelightBlocks.CHEESECAKE.get(), ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
				ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
				ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), ExtraDelightBlocks.QUICHE.get(),
				ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(),
				ExtraDelightBlocks.PUMPKIN_PIE.get(), ExtraDelightBlocks.PUMPKIN_ROLL.get(),
				ExtraDelightBlocks.APPLE_CHEESECAKE.get(), ExtraDelightBlocks.COFFEE_CAKE.get(),
				ExtraDelightBlocks.MILK_TART.get(), ExtraDelightBlocks.CHOCOLATE_CAKE.get(),
				ExtraDelightBlocks.TARTE_TATIN.get(), Fermentation.STEAK_PICKLED_ONION_PIE.get(),
				SummerCitrus.LEMON_MERINGUE_PIE.get(), SummerCitrus.KEY_LIME_PIE.get(),
				SummerCitrus.LEMON_CUCUMBER_CAKE.get(), SummerCitrus.MELON_LAYER_CAKE.get(), SummerCitrus.PAVLOVA.get(),
				SummerCitrus.KYIV_CAKE.get(), SummerCitrus.RAW_BAKED_ALASKA.get(), SummerCitrus.BAKED_ALASKA.get(),

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
				Fermentation.SOY_GLAZED_SALMON_BLOCK.get(), SummerCitrus.LEMONADE_TRAY.get(),
				SummerCitrus.LIMEADE_TRAY.get(), SummerCitrus.ORANGEADE_TRAY.get(), SummerCitrus.BAKED_COD.get(),

				// Jellies (also plated)
				ExtraDelightBlocks.JELLY_WHITE.get(), ExtraDelightBlocks.JELLY_ORANGE.get(),
				ExtraDelightBlocks.JELLY_MAGENTA.get(), ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(),
				ExtraDelightBlocks.JELLY_YELLOW.get(), ExtraDelightBlocks.JELLY_LIME.get(),
				ExtraDelightBlocks.JELLY_PINK.get(), ExtraDelightBlocks.JELLY_GREY.get(),
				ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), ExtraDelightBlocks.JELLY_CYAN.get(),
				ExtraDelightBlocks.JELLY_PURPLE.get(), ExtraDelightBlocks.JELLY_BLUE.get(),
				ExtraDelightBlocks.JELLY_BROWN.get(), ExtraDelightBlocks.JELLY_GREEN.get(),
				ExtraDelightBlocks.JELLY_RED.get(), ExtraDelightBlocks.JELLY_BLACK.get(),

				SummerCitrus.MELON_FRUIT_SALAD.get(),

				// Sacks
				ExtraDelightBlocks.FLOUR_SACK.get(), ExtraDelightBlocks.CORNMEAL_SACK.get(),
				ExtraDelightBlocks.SUGAR_SACK.get(), ExtraDelightBlocks.BREADCRUMB_SACK.get(),
				ExtraDelightBlocks.CORN_SILK_SACK.get(), ExtraDelightBlocks.CORN_SACK.get(),
				ExtraDelightBlocks.GROUND_CINNAMON_SACK.get(), ExtraDelightBlocks.MINT_SACK.get(),
				ExtraDelightBlocks.CHILI_POWDER_SACK.get(), ExtraDelightBlocks.PEANUT_IN_SHELL_SACK.get(),
				ExtraDelightBlocks.PEANUT_SACK.get(), ExtraDelightBlocks.ROASTED_PEANUT_SACK.get(),
				ExtraDelightBlocks.HAZELNUT_IN_SHELL_SACK.get(), ExtraDelightBlocks.HAZELNUT_SACK.get(),
				ExtraDelightBlocks.ROASTED_HAZELNUT_SACK.get(), ExtraDelightBlocks.MALLOW_POWDER_SACK.get(),
				ExtraDelightBlocks.GREEN_COFFEE_BEAN_SACK.get(), ExtraDelightBlocks.COFFEE_BEAN_SACK.get(),
				ExtraDelightBlocks.COCOA_BEAN_SACK.get(), ExtraDelightBlocks.ROASTED_COCOA_BEAN_SACK.get(),
				ExtraDelightBlocks.COCOA_POWDER_SACK.get(), ExtraDelightBlocks.GROUND_COFFEE_SACK.get(),
				ExtraDelightBlocks.COCOA_SOLIDS_SACK.get(), Fermentation.SOYBEAN_SACK.get(),
				// Bundles
				ExtraDelightBlocks.CORN_HUSK_BUNDLE.get(), ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get(),
				ExtraDelightBlocks.CORN_COB_BUNDLE.get(),

				// Choccy Boxes
				ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get(), ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get(), ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get(), ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get(), ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get(), ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get(), ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get(), ExtraDelightBlocks.RED_CHOCOLATE_BOX.get(),
				ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get(), ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get()
		);
		AestheticBlocks.WALLPAPER_BLOCKS.forEach(this::makeMineableWithKnife);
		AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.forEach(this::makeMineableWithKnife);
		AestheticBlocks.DRIED_CORN_FENCE.forEach(this::makeMineableWithAxe);
		AestheticBlocks.DRIED_CORN_FENCE.forEach(this::makeFence);
		AestheticBlocks.WREATHS.forEach(this::makeMineableWithHoe);
		AestheticBlocks.BOWS.forEach(this::makeMineableWithKnife); // cos we cant shears
		AestheticBlocks.GINGHAM_BLOCKS.forEach(this::makeMineableWithKnife); // cos we cant shears
		AestheticBlocks.GINGHAM_CARPET_BLOCKS.forEach(this::makeMineableWithKnife); // cos we cant shears (also regular carpets have it)

		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.WILD_GINGER.get(), ExtraDelightBlocks.WILD_PEANUT.get(),
				ExtraDelightBlocks.WILD_CHILI.get(), ExtraDelightBlocks.WILD_MALLOW_ROOT.get(),
				ExtraDelightBlocks.WILD_GARLIC.get(), Fermentation.WILD_CUCUMBER.get(), Fermentation.WILD_SOYBEAN.get());

		tag(BlockTags.MINEABLE_WITH_HOE).add(ExtraDelightBlocks.CINNAMON_LEAVES.get(),
				ExtraDelightBlocks.HAZELNUT_LEAVES.get(), ExtraDelightBlocks.APPLE_LEAVES.get(),
				SummerCitrus.LEMON_LEAVES.get(), SummerCitrus.LIME_LEAVES.get(), SummerCitrus.ORANGE_LEAVES.get(),
				SummerCitrus.GRAPEFRUIT_LEAVES.get(),
				SummerCitrus.LEMON_PETAL_LITTER.get(), SummerCitrus.LIME_PETAL_LITTER.get(),
				SummerCitrus.ORANGE_PETAL_LITTER.get(), SummerCitrus.GRAPEFRUIT_PETAL_LITTER.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(ExtraDelightBlocks.JUICER.get(), ExtraDelightBlocks.FRUIT_BOWL.get(),

				ExtraDelightBlocks.CINNAMON_LOG.get(),
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
				ExtraDelightBlocks.FRUIT_BUTTON.get(),

				// Crates
				ExtraDelightBlocks.CORN_CRATE.get(), ExtraDelightBlocks.EGG_CRATE.get(),
				ExtraDelightBlocks.APPLE_CRATE.get(), ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get(),
				ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get(), ExtraDelightBlocks.RED_MUSHROOM_CRATE.get(),
				ExtraDelightBlocks.SWEET_BERRY_CRATE.get(), ExtraDelightBlocks.GLOW_BERRY_CRATE.get(),
				ExtraDelightBlocks.GINGER_CRATE.get(), ExtraDelightBlocks.GOLDEN_CARROT_CRATE.get(),
				ExtraDelightBlocks.CHILI_CRATE.get(), ExtraDelightBlocks.MALLOW_ROOT_CRATE.get(),
				ExtraDelightBlocks.COFFEE_CHERRY_CRATE.get(), ExtraDelightBlocks.GARLIC_CRATE.get(),
				Fermentation.CUCUMBER_CRATE.get(), SummerCitrus.LEMON_CRATE.get(), SummerCitrus.LIME_CRATE.get(),
				SummerCitrus.ORANGE_CRATE.get(), SummerCitrus.GRAPEFRUIT_CRATE.get(),
				// Other misc storage blocks
				ExtraDelightBlocks.RAW_CINNAMON_BLOCK.get(), ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get(),

				// Picnic Baskets
				SummerCitrus.WHITE_PICNIC_BASKET.get(), SummerCitrus.ORANGE_PICNIC_BASKET.get(),
				SummerCitrus.MAGENTA_PICNIC_BASKET.get(), SummerCitrus.LIGHT_BLUE_PICNIC_BASKET.get(),
				SummerCitrus.YELLOW_PICNIC_BASKET.get(), SummerCitrus.LIME_PICNIC_BASKET.get(),
				SummerCitrus.PINK_PICNIC_BASKET.get(), SummerCitrus.GRAY_PICNIC_BASKET.get(),
				SummerCitrus.LIGHT_GRAY_PICNIC_BASKET.get(), SummerCitrus.CYAN_PICNIC_BASKET.get(),
				SummerCitrus.BLUE_PICNIC_BASKET.get(), SummerCitrus.BROWN_PICNIC_BASKET.get(),
				SummerCitrus.GREEN_PICNIC_BASKET.get(), SummerCitrus.RED_PICNIC_BASKET.get(),
				SummerCitrus.BLACK_PICNIC_BASKET.get(), SummerCitrus.PURPLE_PICNIC_BASKET.get()
		);

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
				ExtraDelightBlocks.HAZELNUT_SAPLING.get(), ExtraDelightBlocks.APPLE_SAPLING.get(),
				SummerCitrus.LEMON_SAPLING.get(), SummerCitrus.LIME_SAPLING.get(), SummerCitrus.ORANGE_SAPLING.get(),
				SummerCitrus.GRAPEFRUIT_SAPLING.get());

		tag(ExtraDelightTags.COLD_SOURCES).add(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE,
				Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW_CAULDRON);

		tag(BlockTags.BEE_GROWABLES).add(ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightBlocks.CORN_BOTTOM.get(),
				ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightBlocks.GINGER_CROP.get(),
				ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), ExtraDelightBlocks.PEANUT_CROP.get(),
				ExtraDelightBlocks.GARLIC_CROP.get(), Fermentation.CUCUMBER_CROP.get(), Fermentation.SOYBEAN_CROP.get());

		tag(BlockTags.FLOWER_POTS).add(ExtraDelightBlocks.POTTED_CINNAMON_SAPLING.get(),
				ExtraDelightBlocks.POTTED_HAZELNUT_SAPLING.get(), ExtraDelightBlocks.POTTED_APPLE_SAPLING.get(),
				SummerCitrus.POTTED_LEMON_SAPLING.get(), SummerCitrus.POTTED_LIME_SAPLING.get(),
				SummerCitrus.POTTED_ORANGE_SAPLING.get(), SummerCitrus.POTTED_GRAPEFRUIT_SAPLING.get());

		// Serene Seasons
		tag(CompatTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK).add(ExtraDelightBlocks.CINNAMON_SAPLING.get(),
				ExtraDelightBlocks.GINGER_CROP.get(), ExtraDelightBlocks.MINT_CROP.get(),
				ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightBlocks.CORN_TOP.get(),
				ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), ExtraDelightBlocks.CHILI_CROP.get(),
				ExtraDelightBlocks.PEANUT_CROP.get(), ExtraDelightBlocks.HAZELNUT_SAPLING.get(),
				ExtraDelightBlocks.COFFEE_BUSH.get(), ExtraDelightBlocks.APPLE_SAPLING.get(),
				ExtraDelightBlocks.GARLIC_CROP.get(), Fermentation.CUCUMBER_CROP.get(), Fermentation.SOYBEAN_CROP.get(),
				SummerCitrus.LIME_SAPLING.get(), SummerCitrus.ORANGE_SAPLING.get(),
				SummerCitrus.GRAPEFRUIT_SAPLING.get());
		tag(CompatTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK).add(ExtraDelightBlocks.MINT_CROP.get(),
				ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), ExtraDelightBlocks.CHILI_CROP.get(),
				ExtraDelightBlocks.PEANUT_CROP.get(), ExtraDelightBlocks.HAZELNUT_SAPLING.get(),
				ExtraDelightBlocks.COFFEE_BUSH.get(), ExtraDelightBlocks.APPLE_SAPLING.get(),
				Fermentation.SOYBEAN_CROP.get(), SummerCitrus.LIME_SAPLING.get(),
				SummerCitrus.ORANGE_SAPLING.get(), SummerCitrus.GRAPEFRUIT_SAPLING.get());
		tag(CompatTags.SERENE_SEASONS_WINTER_CROPS_BLOCK).add(ExtraDelightBlocks.GARLIC_CROP.get(),
				SummerCitrus.LEMON_SAPLING.get(), SummerCitrus.ORANGE_SAPLING.get(),
				SummerCitrus.GRAPEFRUIT_SAPLING.get());
		tag(CompatTags.SERENE_SEASONS_SPRING_CROPS_BLOCK).add(ExtraDelightBlocks.CINNAMON_SAPLING.get(),
				ExtraDelightBlocks.GINGER_CROP.get(), ExtraDelightBlocks.MINT_CROP.get(),
				ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightBlocks.CORN_TOP.get(),
				ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightBlocks.HAZELNUT_SAPLING.get(),
				ExtraDelightBlocks.COFFEE_BUSH.get(), ExtraDelightBlocks.APPLE_SAPLING.get(),
				ExtraDelightBlocks.GARLIC_CROP.get(), Fermentation.CUCUMBER_CROP.get(), Fermentation.SOYBEAN_CROP.get(),
				SummerCitrus.LEMON_SAPLING.get(), SummerCitrus.LIME_SAPLING.get());

		// Dyed Tags
		tag(Tags.Blocks.DYED_BLACK).add(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.BLACK.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.BLACK.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.BLACK.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.BLACK.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.BLACK.getId()).get());
		tag(Tags.Blocks.DYED_BLUE).add(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.BLUE.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.BLUE.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.BLUE.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.BLUE.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.BLUE.getId()).get());
		tag(Tags.Blocks.DYED_BROWN).add(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.BROWN.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.BROWN.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.BROWN.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.BROWN.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.BROWN.getId()).get());
		tag(Tags.Blocks.DYED_CYAN).add(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.CYAN.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.CYAN.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.CYAN.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.CYAN.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.CYAN.getId()).get());
		tag(Tags.Blocks.DYED_GRAY).add(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.GRAY.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.GRAY.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.GRAY.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.GRAY.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.GRAY.getId()).get());
		tag(Tags.Blocks.DYED_GREEN).add(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.GREEN.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.GREEN.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.GREEN.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.GREEN.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.GREEN.getId()).get());
		tag(Tags.Blocks.DYED_LIGHT_BLUE).add(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.LIGHT_BLUE.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.LIGHT_BLUE.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.LIGHT_BLUE.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.LIGHT_BLUE.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.LIGHT_BLUE.getId()).get());
		tag(Tags.Blocks.DYED_LIGHT_GRAY).add(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.LIGHT_GRAY.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.LIGHT_GRAY.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.LIGHT_GRAY.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.LIGHT_GRAY.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.LIGHT_GRAY.getId()).get());
		tag(Tags.Blocks.DYED_LIME).add(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.LIME.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.LIME.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.LIME.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.LIME.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.LIME.getId()).get());
		tag(Tags.Blocks.DYED_MAGENTA).add(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.MAGENTA.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.MAGENTA.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.MAGENTA.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.MAGENTA.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.MAGENTA.getId()).get());
		tag(Tags.Blocks.DYED_ORANGE).add(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.ORANGE.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.ORANGE.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.ORANGE.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.ORANGE.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.ORANGE.getId()).get());
		tag(Tags.Blocks.DYED_PINK).add(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.PINK.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.PINK.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.PINK.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.PINK.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.PINK.getId()).get());
		tag(Tags.Blocks.DYED_PURPLE).add(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.PURPLE.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.PURPLE.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.PURPLE.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.PURPLE.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.PURPLE.getId()).get());
		tag(Tags.Blocks.DYED_RED).add(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.RED.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.RED.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.RED.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.RED.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.RED.getId()).get());
		tag(Tags.Blocks.DYED_WHITE).add(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.WHITE.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.WHITE.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.WHITE.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.WHITE.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.WHITE.getId()).get());
		tag(Tags.Blocks.DYED_YELLOW).add(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get(),
				AestheticBlocks.GINGHAM_CARPET_BLOCKS.get(DyeColor.YELLOW.getId()).get(),
				AestheticBlocks.GINGHAM_BLOCKS.get(DyeColor.YELLOW.getId()).get(),
				AestheticBlocks.MOLDED_WALLPAPER_BLOCKS.get(DyeColor.YELLOW.getId()).get(),
				AestheticBlocks.WALLPAPER_BLOCKS.get(DyeColor.YELLOW.getId()).get(),
				AestheticBlocks.BOWS.get(DyeColor.YELLOW.getId()).get());

		// Storage Blocks
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ExtraDelightTags.STORAGE_BLOCKS_CHEESE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_BUTTER).addTag(ExtraDelightTags.STORAGE_BLOCKS_FLOUR)
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
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CORN_KERNELS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GARLIC)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_CUCUMBER)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_SOYBEANS)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_SALT)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_LEMON)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_LIME)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_ORANGE)
				.addTag(ExtraDelightTags.STORAGE_BLOCKS_GRAPEFRUIT);

		tag(ExtraDelightTags.STORAGE_BLOCKS_CHEESE).add(ExtraDelightBlocks.CHEESE_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_BUTTER).add(ExtraDelightBlocks.BUTTER_BLOCK.get());
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
		tag(ExtraDelightTags.STORAGE_BLOCKS_CUCUMBER).add(Fermentation.CUCUMBER_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_SOYBEANS).add(Fermentation.SOYBEAN_SACK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_SALT).add(Fermentation.SALT_BLOCK.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_LEMON).add(SummerCitrus.LEMON_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_LIME).add(SummerCitrus.LIME_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_ORANGE).add(SummerCitrus.ORANGE_CRATE.get());
		tag(ExtraDelightTags.STORAGE_BLOCKS_GRAPEFRUIT).add(SummerCitrus.GRAPEFRUIT_CRATE.get());
		
		AestheticBlocks.GINGHAM_BLOCKS.forEach(b -> {
			tag(BlockTags.DAMPENS_VIBRATIONS).add(b.get());
		});
		AestheticBlocks.GINGHAM_CARPET_BLOCKS.forEach(b -> {
			tag(BlockTags.DAMPENS_VIBRATIONS).add(b.get());
		});
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
		tag(CommonTags.Blocks.MINEABLE_WITH_KNIFE).add(blockDeferredBlock.get());
	}

	protected void makeFence(DeferredBlock<Block> blockDeferredBlock) {
		tag(BlockTags.WOODEN_FENCES).add(blockDeferredBlock.get());
	}

}

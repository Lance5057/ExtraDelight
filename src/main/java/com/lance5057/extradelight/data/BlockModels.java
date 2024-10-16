package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.blocks.BakingStoneBlock;
import com.lance5057.extradelight.blocks.ChocolateStyleBlock;
import com.lance5057.extradelight.blocks.FrostableBlock;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.blocks.HorizontalPanBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.TapBlock;
import com.lance5057.extradelight.blocks.chocolatebox.ChocolateBoxBlock;
import com.lance5057.extradelight.blocks.crops.ChiliCrop;
import com.lance5057.extradelight.blocks.crops.CoffeeBush;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.MallowRootCrop;
import com.lance5057.extradelight.blocks.crops.PeanutCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.lance5057.extradelight.blocks.crops.corn.CornProperties;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockModels extends BlockStateProvider {

	public BlockModels(PackOutput gen, ExistingFileHelper exFileHelper) {
		super(gen, ExtraDelight.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		this.horizontalBlock(ExtraDelightBlocks.DOUGH_SHAPING.get(),
				models().getExistingFile(modLoc("block/doughforming")));
		this.mixingBowlStyleBlock(ExtraDelightBlocks.MIXING_BOWL.get());

		this.simpleBlock(ExtraDelightBlocks.YEAST_POT.get(), models().getExistingFile(modLoc("block/yeast_pot")));
		this.simpleBlock(ExtraDelightBlocks.VINEGAR_POT.get(),
				models().withExistingParent("vinegar_pot", modLoc("block/yeast_pot"))
						.texture("0", modLoc("block/vinegarpot")).texture("particle", modLoc("block/vinegarpot")));
		this.simpleBlock(ExtraDelightBlocks.DRYING_RACK.get(), models().getExistingFile(modLoc("block/drying_rack")));

		this.mortarStyleBlock(ExtraDelightBlocks.MORTAR_STONE.get());

		this.simpleBlock(ExtraDelightBlocks.COOKING_OIL.get(), models()
				.withExistingParent("cooking_oil", mcLoc("block/carpet")).texture("wool", modLoc("block/cooking_oil")));

		pieBlock(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), "sweet_berry_pie");
		pieBlock(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), "glow_berry_pie");
		pieBlock(ExtraDelightBlocks.CHEESECAKE.get(), "cheesecake");
		pieBlock(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), "honey_cheesecake");
		pieBlock(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), "chocolate_cheesecake");
		pieBlock(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), "pumpkin_cheesecake");
		pieBlock(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), "apple_cheesecake");
		pieBlock(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), "glow_berry_cheesecake");

		pieBlock(ExtraDelightBlocks.QUICHE.get(), "quiche");

		this.recipeFeastBlock(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get());
		this.recipeFeastBlock(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get());
		this.simpleBlock(ExtraDelightBlocks.CHEESE_BLOCK.get());
		this.slabBlock(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(), modLoc("block/cheese_block"),
				modLoc("block/cheese_slab"), modLoc("block/cheese_block"), modLoc("block/cheese_block"));
		this.stairsBlock(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(), modLoc("block/cheese_slab"));
		this.simpleBlock(ExtraDelightBlocks.BUTTER_BLOCK.get());
		this.slabBlock(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(), modLoc("block/butter_block"),
				modLoc("block/butter_slab"), modLoc("block/butter_block"), modLoc("block/butter_block"));
		this.stairsBlock(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(), modLoc("block/butter_slab"));

		this.recipeFeastBlock(ExtraDelightBlocks.HASH_FEAST.get());
		this.recipeFeastBlock(ExtraDelightBlocks.POT_ROAST_FEAST.get());

		this.recipeFeastBlock(ExtraDelightBlocks.BBQ_RIBS_FEAST.get());
		this.recipeFeastBlock(ExtraDelightBlocks.PULLED_PORK_FEAST.get());
		this.recipeFeastBlock(ExtraDelightBlocks.MEATLOAF_FEAST.get());

		this.recipeFeastBlock(ExtraDelightBlocks.RACK_LAMB.get());
		this.recipeFeastBlock(ExtraDelightBlocks.STIRFRY.get());
		this.recipeFeastBlock(ExtraDelightBlocks.BEEF_WELLINGTON.get());
		this.recipeFeastBlock(ExtraDelightBlocks.HAGGIS.get());
		this.recipeFeastBlock(ExtraDelightBlocks.MACARONI_CHEESE.get());
		this.recipeFeastBlock(ExtraDelightBlocks.HOTDISH.get());
		this.recipeFeastBlock(ExtraDelightBlocks.LASAGNA.get());

		this.recipeFeastBlock(ExtraDelightBlocks.CURRY.get());
		this.stewBlock(ExtraDelightBlocks.BEEF_STEW.get(), "beef_stew");
		this.stewBlock(ExtraDelightBlocks.CHICKEN_STEW.get(), "chicken_stew");
		this.stewBlock(ExtraDelightBlocks.FISH_STEW.get(), "fish_stew");
		this.stewBlock(ExtraDelightBlocks.LAMB_STEW.get(), "lamb_stew");
		this.stewBlock(ExtraDelightBlocks.PORK_STEW.get(), "pork_stew");
		this.stewBlock(ExtraDelightBlocks.RABBIT_STEW.get(), "rabbit_stew");

		this.jellyBlock(ExtraDelightBlocks.JELLY_WHITE.get(), "white");
		this.jellyBlock(ExtraDelightBlocks.JELLY_ORANGE.get(), "orange");
		this.jellyBlock(ExtraDelightBlocks.JELLY_MAGENTA.get(), "magenta");
		this.jellyBlock(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), "light_blue");
		this.jellyBlock(ExtraDelightBlocks.JELLY_YELLOW.get(), "yellow");
		this.jellyBlock(ExtraDelightBlocks.JELLY_LIME.get(), "lime");
		this.jellyBlock(ExtraDelightBlocks.JELLY_PINK.get(), "pink");
		this.jellyBlock(ExtraDelightBlocks.JELLY_GREY.get(), "grey");
		this.jellyBlock(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), "light_grey");
		this.jellyBlock(ExtraDelightBlocks.JELLY_CYAN.get(), "cyan");
		this.jellyBlock(ExtraDelightBlocks.JELLY_PURPLE.get(), "purple");
		this.jellyBlock(ExtraDelightBlocks.JELLY_BLUE.get(), "blue");
		this.jellyBlock(ExtraDelightBlocks.JELLY_BROWN.get(), "brown");
		this.jellyBlock(ExtraDelightBlocks.JELLY_GREEN.get(), "green");
		this.jellyBlock(ExtraDelightBlocks.JELLY_RED.get(), "red");
		this.jellyBlock(ExtraDelightBlocks.JELLY_BLACK.get(), "black");

		this.pieBlock(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), "meat_pie");
		this.recipeFeastBlock(ExtraDelightBlocks.SALAD.get());

		this.cornBlock(ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightBlocks.CORN_TOP.get());
		simpleBlock(ExtraDelightBlocks.WILD_GINGER.get(), new ConfiguredModel(
				models().cross("wild_ginger", modLoc("block/crops/ginger/ginger_stage3")).renderType("cutout")));

		this.recipeFeastBlock(ExtraDelightBlocks.CORNBREAD.get());
		pieBlock(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), "caramel_cheesecake");
		this.recipeFeastBlock(ExtraDelightBlocks.CORN_PUDDING.get());
		pieBlock(ExtraDelightBlocks.PUMPKIN_PIE.get(), "pumpkin_pie");
		this.pieLikeBlock(ExtraDelightBlocks.PUMPKIN_ROLL.get(), "pumpkin_roll");
		this.recipeFeastBlock(ExtraDelightBlocks.APPLE_CRISP.get());
		this.recipeFeastBlock(ExtraDelightBlocks.STUFFING.get());
		this.recipeFeastBlock(ExtraDelightBlocks.POTATO_AU_GRATIN.get());

		this.axisBlock(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get());
		this.axisBlock(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get());
		this.axisBlock(ExtraDelightBlocks.CORN_COB_BUNDLE.get());

		this.logBlock(ExtraDelightBlocks.CINNAMON_LOG.get());
		this.logBlock(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get());
		this.logBlock(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.CINNAMON_LEAVES.get());
		this.simpleBlock(ExtraDelightBlocks.CINNAMON_PLANKS.get());
		this.simpleCross(ExtraDelightBlocks.CINNAMON_SAPLING.get());
		this.stairsBlock(ExtraDelightBlocks.CINNAMON_STAIRS.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		this.trapdoorBlockWithRenderType(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor"), true, "cutout");
		this.doorBlockWithRenderType(ExtraDelightBlocks.CINNAMON_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_door_top"), "cutout");
		this.fenceBlock(ExtraDelightBlocks.CINNAMON_FENCE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		this.fenceGateBlock(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		this.cabinetBlock(ExtraDelightBlocks.CINNAMON_CABINET.get(), "cinnamon");
		this.slabBlock(ExtraDelightBlocks.CINNAMON_SLAB.get(), modLoc("block/cinnamon_planks"),
				modLoc("block/cinnamon_planks"));

		this.simpleBlock(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get());

		this.cropCrossBlock(ExtraDelightBlocks.GINGER_CROP.get(), "ginger", GingerCrop.AGE);
		this.simpleBlock(ExtraDelightBlocks.CANDY_BOWL.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/candy_bowl")));

		this.frostableBlock(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"white");
		this.frostableBlock(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"light_grey");
		this.frostableBlock(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "grey");
		this.frostableBlock(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"brown");
		this.frostableBlock(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"black");
		this.frostableBlock(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "red");
		this.frostableBlock(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"orange");
		this.frostableBlock(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"yellow");
		this.frostableBlock(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "lime");
		this.frostableBlock(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"green");
		this.frostableBlock(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "cyan");
		this.frostableBlock(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"light_blue");
		this.frostableBlock(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "blue");
		this.frostableBlock(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"purple");
		this.frostableBlock(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"magenta");
		this.frostableBlock(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "pink");

		this.simpleBlock(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get());

		recipeFeastBlock(ExtraDelightBlocks.CINNAMON_ROLLS.get(), "cinnamon_rolls");
		recipeFeastBlock(ExtraDelightBlocks.MONKEY_BREAD.get(), "monkey_bread");
		this.createCakeBlock(ExtraDelightBlocks.COFFEE_CAKE.get(), "coffee");
		recipeFeastBlock(ExtraDelightBlocks.MINT_LAMB.get(), "mint_lamb");
		recipeFeastBlock(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), "charcuterie");
		recipeFeastBlock(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), "christmas_pudding");
		pieLikeBlock(ExtraDelightBlocks.MILK_TART.get(), "milk_tart");
		recipeFeastBlock(ExtraDelightBlocks.PUNCH.get(), "punch");
		tapBlock(ExtraDelightBlocks.TAP.get());
//		coffeeBushBlock(ExtraDelightBlocks.COFFEE_BUSH.get());

		this.axisBlock(ExtraDelightBlocks.KEG.get(),
				models().orientableWithBottom("keg_vertical", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")).renderType("cutout"),
				models().orientableWithBottom("keg_horizontal", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")).renderType("cutout"));

		this.panBlock(ExtraDelightBlocks.SHEET_BLOCK.get(), "block/sheet");
		this.panBlock(ExtraDelightBlocks.TRAY_BLOCK.get(), "block/tray");
		this.panBlock(ExtraDelightBlocks.LOAF_PAN_BLOCK.get(), "block/loaf_pan");
		this.panBlock(ExtraDelightBlocks.PIE_DISH_BLOCK.get(), "block/pie_dish");
		this.panBlock(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), "block/square_pan");
		this.bakingStoneStyleBlock(ExtraDelightBlocks.BAKING_STONE_BLOCK.get());
		this.panBlock(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(), "block/muffin_tray");
		this.panBlock(ExtraDelightBlocks.SERVING_POT_BLOCK.get(), "block/serving_pot");
		this.panBlock(ExtraDelightBlocks.BAR_MOLD.get(), "block/bar_mold");

		this.logBlock(ExtraDelightBlocks.FRUIT_LOG.get());
		this.logBlock(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get());
		this.simpleBlock(ExtraDelightBlocks.FRUIT_PLANKS.get());
		this.stairsBlock(ExtraDelightBlocks.FRUIT_STAIRS.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.trapdoorBlockWithRenderType(ExtraDelightBlocks.FRUIT_TRAPDOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_trapdoor"), true, "cutout");
		this.doorBlockWithRenderType(ExtraDelightBlocks.FRUIT_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_door_top"), "cutout");
		this.fenceBlock(ExtraDelightBlocks.FRUIT_FENCE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.fenceGateBlock(ExtraDelightBlocks.FRUIT_FENCE_GATE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.cabinetBlock(ExtraDelightBlocks.FRUIT_CABINET.get(), "fruit");
		this.slabBlock(ExtraDelightBlocks.FRUIT_SLAB.get(), modLoc("block/fruit_planks"), modLoc("block/fruit_planks"));

		this.fruitLeafBlock(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), "hazelnut");

		styleBlock(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/dark_chocolate");
		this.fenceBlock(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style0"));
		this.fenceGateBlock(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style0"));
		this.stairsBlock(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style1"));
		this.doorBlock(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_door_top"));
		this.trapdoorBlock(ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_trapdoor"), false);
		this.slabBlock(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(), modLoc("block/dark_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_style0"));
		this.axisBlock(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_style0"));

		styleBlock(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/milk_chocolate");
		this.fenceBlock(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style0"));
		this.fenceGateBlock(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style0"));
		this.stairsBlock(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style1"));
		this.doorBlock(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_door_top"));
		this.trapdoorBlock(ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_trapdoor"), false);
		this.slabBlock(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(), modLoc("block/milk_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_style0"));
		this.axisBlock(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_style0"));

		styleBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/white_chocolate");
		this.fenceBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style0"));
		this.fenceGateBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style0"));
		this.stairsBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style1"));
		this.doorBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_door_top"));
		this.trapdoorBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(
				ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_trapdoor"), false);
		this.slabBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(), modLoc("block/white_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/white_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/white_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/white_chocolate_style0"));
		this.axisBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_style0"));

		styleBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/blood_chocolate");
		this.fenceBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style0"));
		this.fenceGateBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style0"));
		this.stairsBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style1"));
		this.doorBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_door_top"));
		this.trapdoorBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(), ResourceLocation.fromNamespaceAndPath(
				ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_trapdoor"), false);
		this.slabBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(), modLoc("block/blood_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_style0"));
		this.axisBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_style0"));

		this.chocolateBox(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get());
		this.chocolateBox(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get());

		this.recipeFeastBlock(ExtraDelightBlocks.BROWNIES.get());
		this.recipeFeastBlock(ExtraDelightBlocks.BLONDIES.get());
		this.createCakeBlock(ExtraDelightBlocks.CHOCOLATE_CAKE.get(), "chocolate");
		this.recipeFeastBlock(ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get());
		this.recipeFeastBlock(ExtraDelightBlocks.CRISP_RICE_TREATS.get());
		this.recipeFeastBlock(ExtraDelightBlocks.SCOTCHAROOS.get());
		this.recipeFeastBlock(ExtraDelightBlocks.FUDGE.get());
		this.recipeFeastBlock(ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get());

		this.fondueBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), "blood");
		this.fondueBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), "white");
		this.fondueBlock(ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), "dark");
		this.fondueBlock(ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), "milk");

		this.cropCrossBlock(ExtraDelightBlocks.PEANUT_CROP.get(), "peanut", PeanutCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_PEANUT.get(), new ConfiguredModel(
				models().cross("wild_peanut", modLoc("block/crops/peanut/wild_peanut")).renderType("cutout")));

		this.cropCrossBlock(ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), "marshmallow", MallowRootCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_MALLOW_ROOT.get(), new ConfiguredModel(models()
				.cross("wild_mallow_root", modLoc("block/crops/marshmallow/wild_marshmallow")).renderType("cutout")));

		this.cropCrossBlock(ExtraDelightBlocks.CHILI_CROP.get(), "chili", ChiliCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_CHILI.get(), new ConfiguredModel(
				models().cross("wild_chili", modLoc("block/crops/chili/wild_chili")).renderType("cutout")));

		this.simpleCross(ExtraDelightBlocks.HAZELNUT_SAPLING.get(), "crops/fruit/hazelnut/hazelnut_sapling");

		this.simpleBlock(ExtraDelightBlocks.JAR.get(),
				models().getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/jar")));

		this.fluid(ExtraDelightBlocks.APPLE_CIDER_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.BBQ_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.BLOOD_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.BROTH_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.CACTUS_JUICE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.CARAMEL_SAUCE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.COCOA_BUTTER_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.COFFEE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.COOKING_OIL_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.DARK_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.EGG_MIX_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.GLOW_BERRY_JUICE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.GLOW_JAM_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.GOLDEN_JAM_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.GRAVY_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.HAZELNUT_SPREAD_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.HOT_COCOA_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.JAM_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.KETCHUP_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.MARSHMALLOW_FLUFF_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.MAYO_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.MELON_JUICE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.MILK_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.MILKSHAKE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.PEANUT_BUTTER_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.SWEET_BERRY_JUICE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.TEA_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.TOMATO_JUICE_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.VINEGAR_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.WHIPPED_CREAM_FLUID_BLOCK.get());
		this.fluid(ExtraDelightBlocks.WHITE_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		
		AestheticBlocks.blockModel(this);
	}

	void fluid(LiquidBlock block) {
		getVariantBuilder(block).forAllStates(state -> {
			return ConfiguredModel.builder().modelFile(
					models().withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), mcLoc("block/water")))
					.build();
		});
	}

	public void chocolateBox(ChocolateBoxBlock block) {
		getVariantBuilder(block).forAllStates(state -> {
			boolean open = state.getValue(ChocolateBoxBlock.OPEN);

			if (open)
				return ConfiguredModel.builder()
						.modelFile(models()
								.withExistingParent(block.getColor() + "_chocolate_box_open",
										modLoc("block/chocolate_box_open"))
								.texture("0", mcLoc("block/" + block.getColor() + "_glazed_terracotta"))
								.texture("1", modLoc("block/ribbon/" + getOppositeColor(block.getColor()) + "_ribbon"))
								.texture("2", mcLoc("block/" + getOppositeColor(block.getColor()) + "_wool"))
								.renderType("cutout"))

						.rotationY(((int) state.getValue(ChocolateBoxBlock.FACING).toYRot() + 180) % 360).build();

			return ConfiguredModel.builder().modelFile(models()

					.withExistingParent(block.getColor() + "_chocolate_box", modLoc("block/chocolate_box"))
					.texture("0", mcLoc("block/" + block.getColor() + "_glazed_terracotta"))
					.texture("1", modLoc("block/ribbon/" + getOppositeColor(block.getColor()) + "_ribbon"))
					.renderType("cutout"))
					.rotationY(((int) state.getValue(ChocolateBoxBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public DyeColor getOppositeColor(DyeColor dye) {
		int i = dye.getId();
		int out = i + 8;
		if (out > 15)
			out = Math.abs(out - 15);
		return DyeColor.byId(out);

	}

	public void bakingStoneStyleBlock(BakingStoneBlock block) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(BakingStoneBlock.STYLE);

			String suffix = BakingStoneBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent("baking_stone" + suffix.toLowerCase(), modLoc("block/baking_stone"))
							.texture("0", mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public void mixingBowlStyleBlock(Block block) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(MixingBowlBlock.STYLE);

			String suffix = MixingBowlBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent("mixing_bowl" + suffix.toLowerCase(), modLoc("block/mixing_bowl"))
							.texture("1", mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public void mortarStyleBlock(Block block) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(MortarBlock.STYLE);

			String suffix = MortarBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent("mortar" + suffix.toLowerCase(), modLoc("block/mortar"))
							.texture("0", mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public void styleBlock(Block style, IntegerProperty count, String path) {
		getVariantBuilder(style).forAllStates(state -> {
			int servings = state.getValue(count);

			String suffix = "_style" + servings;

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent(path + suffix.toLowerCase(), mcLoc("block/cube_all"))
							.texture("all", modLoc(path + suffix.toLowerCase())))
					.build();
		});
	}

	public void fruitLeafBlock(FruitLeafBlock block, String name) {
		getVariantBuilder(block).forAllStates(state -> {
			int age = state.getValue(FruitLeafBlock.AGE);

			String suffix = "_stage" + age;

			ModelFile model = models()
					.getExistingFile(modLoc("block/crops/fruit/" + name + "/" + name + "_leaves" + suffix));

			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public void coffeeBushBlock(CoffeeBush block) {
		getVariantBuilder(block).forAllStates(state -> {
			int age = state.getValue(CoffeeBush.AGE);

			String suffix = "_stage" + age;

			ModelFile model = models().withExistingParent("coffee_plant" + suffix,
					modLoc("block/crops/coffee/coffee_plant" + suffix));

			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public void jellyBlock(FeastBlock block, String color) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			ResourceLocation contentsTexture = modLoc("block/jelly_" + color);
			ResourceLocation particleTexture = modLoc("block/jelly_" + color);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			ModelFile jellyModel = models()
					.withExistingParent("jelly_" + color + "_block" + suffix, modLoc("block/jelly_block" + suffix))
					.texture("1", contentsTexture).renderType("translucent");

			return ConfiguredModel.builder().modelFile(jellyModel)
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	private void createCakeBlock(Block block, String prefix) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(BlockStateProperties.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
							mcLoc("block/cake" + suffix))
					.texture("particle", modLoc("block/" + prefix + "_cake_top"))
					.texture("bottom", modLoc("block/" + prefix + "_cake_bottom"))
					.texture("side", modLoc("block/" + prefix + "_cake_side"))
					.texture("top", modLoc("block/" + prefix + "_cake_top"))
					.texture("inside", modLoc("block/" + prefix + "_cake_inner"))).build();
		});
	}

	public void tapBlock(TapBlock block) {
		getVariantBuilder(block).forAllStates(state -> {
			Direction dir = state.getValue(TapBlock.FACING);
			boolean ground = state.getValue(TapBlock.GROUND);
			if (ground)
				return ConfiguredModel.builder()
						.modelFile(models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + dir + "_down",
								modLoc("block/tap_down")))
						.rotationY(((int) state.getValue(TapBlock.FACING).toYRot() + 180) % 360).build();
			else
				return ConfiguredModel.builder()
						.modelFile(models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + dir + "_up",
								modLoc("block/tap")))
						.rotationY(((int) state.getValue(TapBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void pieBlock(Block block, String prefix) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									modLoc("block/pie" + suffix))
							.texture("particle", modLoc("block/" + prefix + "_top"))
//					.texture("bottom", "farmersdelight:block/pie_bottom")
//					.texture("side", "farmersdelight:block/pie_side")
							.texture("top", modLoc("block/" + prefix + "_top"))
							.texture("inner", modLoc("block/" + prefix + "_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void pieLikeBlock(Block block, String path) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = "_stage" + bites;

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void feastBlock(FeastBlock block) {
		feastBlock(block, BuiltInRegistries.BLOCK.getKey(block).getPath());
	}

	public void feastBlock(FeastBlock block, String path) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void recipeFeastBlock(RecipeFeastBlock block) {
		recipeFeastBlock(block, BuiltInRegistries.BLOCK.getKey(block).getPath());
	}

	public void recipeFeastBlock(RecipeFeastBlock block, String path) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void fondueBlock(RecipeFeastBlock block, String pre) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent(pre + "_chocolate_fondue_pot" + suffix,
							this.modLoc("block/fondue_pot" + suffix))
							.texture("5", this.modLoc("block/cosmetics/chocolate/" + pre + "_chocolate_style0")))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void frostableBlock(FrostableBlock block, String path, String color) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FrostableBlock.STYLE);

			String suffix = FrostableBlock.Styles.values()[servings] + "_";

			if (servings != 7)
				return ConfiguredModel.builder()
						.modelFile(models()
								.withExistingParent(path + "_" + suffix.toLowerCase() + color,
										modLoc("block/double_texture"))
								.texture("0", modLoc(path))
								.texture("1", modLoc("block/frosting_colors/" + suffix.toLowerCase() + color)))
						.build();

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent(path + "_" + suffix.toLowerCase() + color, modLoc("block/grass_like"))
							.texture("0", modLoc(path)).texture("1", modLoc("block/frosting_colors/full_" + color))
							.texture("2", modLoc("block/frosting_colors/" + suffix.toLowerCase() + color)))
					.build();
		});
	}

	public void panBlock(HorizontalPanBlock block, String base) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(HorizontalPanBlock.STYLE);

			String suffix = HorizontalPanBlock.Styles.values()[servings] + "_";

			return ConfiguredModel.builder().modelFile(models()
					.withExistingParent("block/cosmetics/pans/" + base + "_" + suffix.toLowerCase(), modLoc(base))
					.texture("0", modLoc("block/cosmetics/pans/" + suffix.toLowerCase() + "pan"))
					.renderType("translucent"))
					.rotationY(((int) state.getValue(HorizontalPanBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void stewBlock(RecipeFeastBlock block, String texture) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(block.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			ResourceLocation contentsTexture = modLoc("block/" + texture);
			ResourceLocation particleTexture = modLoc("block/" + texture);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
				particleTexture = modLoc("block/pan");
			}

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									modLoc("curry_block" + suffix))
							.texture("1", contentsTexture).texture("particle", particleTexture))
					.rotationY(((int) state.getValue(RecipeFeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void cornBlock(CornBottom bottom, CornTop top) {
		getVariantBuilder(bottom).forAllStates(state -> {
			int age = state.getValue(CornBottom.AGE);
			boolean dry = state.getValue(CornProperties.DIMENSION);
			String suffix = "_stage" + age;

			if (dry)
				return ConfiguredModel.builder()
						.modelFile(models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(bottom).getPath() + "_dimension",
								modLoc("block/crops/corn/dimension_corn_bottom")))
						.build();

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent(BuiltInRegistries.BLOCK.getKey(bottom).getPath() + suffix,
							modLoc("block/crops/corn/corn" + suffix)))
					.build();
		});

		getVariantBuilder(top).forAllStates(state -> {
			int age = state.getValue(CornTop.AGE);
			boolean dry = state.getValue(CornProperties.DIMENSION);
			String suffix = "_stage" + (age + 4);
			String suffix2 = "_stage" + age;

			if (dry)
				return ConfiguredModel.builder()
						.modelFile(models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(top).getPath() + "_dimension",
								modLoc("block/crops/corn/dimension_corn_top")))
						.build();

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent(BuiltInRegistries.BLOCK.getKey(top).getPath() + suffix2,
							modLoc("block/crops/corn/corn" + suffix)))
					.build();
		});
	}

	public void cropCrossBlock(CropBlock block, String name, IntegerProperty age) {
		getVariantBuilder(block).forAllStates(state -> {
			int a = state.getValue(age);
			String suffix = "_stage" + a;

			return ConfiguredModel.builder().modelFile(models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix, mcLoc("block/cross"))
					.texture("cross", modLoc("block/crops/" + name + "/" + name + suffix)).renderType("cutout"))
					.build();
		});

	}

	private void simpleCross(Block block) {
		simpleBlock(block,
				new ConfiguredModel(models()
						.cross(BuiltInRegistries.BLOCK.getKey(block).getPath(),
								modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()))
						.renderType("cutout")));
	}

	private void simpleCross(Block block, String path) {
		simpleBlock(block, new ConfiguredModel(models()
				.cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), modLoc("block/" + path)).renderType("cutout")));
	}

	public void cabinetBlock(Block block, String woodType) {
		this.horizontalBlock(block, state -> {
			String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
			return models().orientable(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_side"),
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
							"block/" + woodType + "_cabinet_front" + suffix),
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_top"));
		});
	}
}
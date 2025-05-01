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
import com.lance5057.extradelight.blocks.RecipeFondueFeastBlock;
import com.lance5057.extradelight.blocks.TapBlock;
import com.lance5057.extradelight.blocks.VanillaFruitLeafBlock;
import com.lance5057.extradelight.blocks.chocolatebox.ChocolateBoxBlock;
import com.lance5057.extradelight.blocks.crops.BushStageFour;
import com.lance5057.extradelight.blocks.crops.ChiliCrop;
import com.lance5057.extradelight.blocks.crops.GarlicCrop;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.MallowRootCrop;
import com.lance5057.extradelight.blocks.crops.PeanutCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.lance5057.extradelight.blocks.crops.corn.CornProperties;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;
import com.lance5057.extradelight.blocks.lid.LidBlock;
import com.lance5057.extradelight.modules.Fermentation;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;
import com.lance5057.extradelight.workstations.vat.VatBlock;

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
		horizontalBlock(ExtraDelightBlocks.DOUGH_SHAPING.get(), models().getExistingFile(modLoc("block/doughforming")));
		mixingBowlStyleBlock(this, ExtraDelightBlocks.MIXING_BOWL.get());

		simpleBlock(ExtraDelightBlocks.YEAST_POT.get(), models().getExistingFile(modLoc("block/yeast_pot")));
		simpleBlock(ExtraDelightBlocks.VINEGAR_POT.get(),
				models().withExistingParent("vinegar_pot", modLoc("block/yeast_pot"))
						.texture("0", modLoc("block/vinegarpot")).texture("particle", modLoc("block/vinegarpot")));
		simpleBlock(ExtraDelightBlocks.DRYING_RACK.get(), models().getExistingFile(modLoc("block/drying_rack")));

		mortarStyleBlock(this, ExtraDelightBlocks.MORTAR_STONE.get());

		simpleBlock(ExtraDelightBlocks.EVAPORATOR.get(), models().getExistingFile(modLoc("block/evaporator")));

//		simpleBlock(ExtraDelightBlocks.COOKING_OIL.get(), models()
//				.withExistingParent("cooking_oil", mcLoc("block/carpet")).texture("wool", modLoc("block/cooking_oil")));

		pieBlock(this, ExtraDelightBlocks.SWEET_BERRY_PIE.get(), "sweet_berry_pie");
		pieBlock(this, ExtraDelightBlocks.GLOW_BERRY_PIE.get(), "glow_berry_pie");
		pieBlock(this, ExtraDelightBlocks.CHEESECAKE.get(), "cheesecake");
		pieBlock(this, ExtraDelightBlocks.HONEY_CHEESECAKE.get(), "honey_cheesecake");
		pieBlock(this, ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), "chocolate_cheesecake");
		pieBlock(this, ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), "pumpkin_cheesecake");
		pieBlock(this, ExtraDelightBlocks.APPLE_CHEESECAKE.get(), "apple_cheesecake");
		pieBlock(this, ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), "glow_berry_cheesecake");

		pieBlock(this, ExtraDelightBlocks.QUICHE.get(), "quiche");

		recipeFeastBlock(this, ExtraDelightBlocks.MASHED_POTATO_GRAVY.get());
		recipeFeastBlock(this, ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get());
		simpleBlock(ExtraDelightBlocks.CHEESE_BLOCK.get());
		slabBlock(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(), modLoc("block/cheese_block"), modLoc("block/cheese_slab"),
				modLoc("block/cheese_block"), modLoc("block/cheese_block"));
		stairsBlock(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(), modLoc("block/cheese_slab"));
		simpleBlock(ExtraDelightBlocks.BUTTER_BLOCK.get());
		slabBlock(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(), modLoc("block/butter_block"), modLoc("block/butter_slab"),
				modLoc("block/butter_block"), modLoc("block/butter_block"));
		stairsBlock(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(), modLoc("block/butter_slab"));

		recipeFeastBlock(this, ExtraDelightBlocks.HASH_FEAST.get());
		recipeFeastBlock(this, ExtraDelightBlocks.POT_ROAST_FEAST.get());

		recipeFeastBlock(this, ExtraDelightBlocks.BBQ_RIBS_FEAST.get());
		recipeFeastBlock(this, ExtraDelightBlocks.PULLED_PORK_FEAST.get());
		recipeFeastBlock(this, ExtraDelightBlocks.MEATLOAF_FEAST.get());

		recipeFeastBlock(this, ExtraDelightBlocks.RACK_LAMB.get());
		recipeFeastBlock(this, ExtraDelightBlocks.STIRFRY.get());
		recipeFeastBlock(this, ExtraDelightBlocks.BEEF_WELLINGTON.get());
		recipeFeastBlock(this, ExtraDelightBlocks.HAGGIS.get());
		recipeFeastBlock(this, ExtraDelightBlocks.MACARONI_CHEESE.get());
		recipeFeastBlock(this, ExtraDelightBlocks.HOTDISH.get());
		recipeFeastBlock(this, ExtraDelightBlocks.LASAGNA.get());

		recipeFeastBlock(this, ExtraDelightBlocks.CURRY.get());
		stewBlock(this, ExtraDelightBlocks.BEEF_STEW.get(), "beef_stew");
		stewBlock(this, ExtraDelightBlocks.CHICKEN_STEW.get(), "chicken_stew");
		stewBlock(this, ExtraDelightBlocks.FISH_STEW.get(), "fish_stew");
		stewBlock(this, ExtraDelightBlocks.LAMB_STEW.get(), "lamb_stew");
		stewBlock(this, ExtraDelightBlocks.PORK_STEW.get(), "pork_stew");
		stewBlock(this, ExtraDelightBlocks.RABBIT_STEW.get(), "rabbit_stew");

		jellyBlock(this, ExtraDelightBlocks.JELLY_WHITE.get(), "white");
		jellyBlock(this, ExtraDelightBlocks.JELLY_ORANGE.get(), "orange");
		jellyBlock(this, ExtraDelightBlocks.JELLY_MAGENTA.get(), "magenta");
		jellyBlock(this, ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), "light_blue");
		jellyBlock(this, ExtraDelightBlocks.JELLY_YELLOW.get(), "yellow");
		jellyBlock(this, ExtraDelightBlocks.JELLY_LIME.get(), "lime");
		jellyBlock(this, ExtraDelightBlocks.JELLY_PINK.get(), "pink");
		jellyBlock(this, ExtraDelightBlocks.JELLY_GREY.get(), "grey");
		jellyBlock(this, ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), "light_grey");
		jellyBlock(this, ExtraDelightBlocks.JELLY_CYAN.get(), "cyan");
		jellyBlock(this, ExtraDelightBlocks.JELLY_PURPLE.get(), "purple");
		jellyBlock(this, ExtraDelightBlocks.JELLY_BLUE.get(), "blue");
		jellyBlock(this, ExtraDelightBlocks.JELLY_BROWN.get(), "brown");
		jellyBlock(this, ExtraDelightBlocks.JELLY_GREEN.get(), "green");
		jellyBlock(this, ExtraDelightBlocks.JELLY_RED.get(), "red");
		jellyBlock(this, ExtraDelightBlocks.JELLY_BLACK.get(), "black");

		pieBlock(this, ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), "meat_pie");
		recipeFeastBlock(this, ExtraDelightBlocks.SALAD.get());

		cornBlock(this, ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightBlocks.CORN_TOP.get());
		simpleBlock(ExtraDelightBlocks.WILD_GINGER.get(), new ConfiguredModel(
				models().cross("wild_ginger", modLoc("block/crops/ginger/ginger_stage3")).renderType("cutout")));

		recipeFeastBlock(this, ExtraDelightBlocks.CORNBREAD.get());
		pieBlock(this, ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), "caramel_cheesecake");
		recipeFeastBlock(this, ExtraDelightBlocks.CORN_PUDDING.get());
		pieBlock(this, ExtraDelightBlocks.PUMPKIN_PIE.get(), "pumpkin_pie");
		pieLikeBlock(this, ExtraDelightBlocks.PUMPKIN_ROLL.get(), "pumpkin_roll");
		recipeFeastBlock(this, ExtraDelightBlocks.APPLE_CRISP.get());
		recipeFeastBlock(this, ExtraDelightBlocks.STUFFING.get());
		recipeFeastBlock(this, ExtraDelightBlocks.POTATO_AU_GRATIN.get());

		axisBlock(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get());
		axisBlock(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get());
		axisBlock(ExtraDelightBlocks.CORN_COB_BUNDLE.get());

		logBlock(ExtraDelightBlocks.CINNAMON_LOG.get());
		axisBlock(ExtraDelightBlocks.CINNAMON_WOOD.get(), modLoc("block/cinnamon_log"), modLoc("block/cinnamon_log"));
		axisBlock(ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get(), modLoc("block/stripped_cinnamon_log"),
				modLoc("block/stripped_cinnamon_log"));
		logBlock(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get());
		logBlock(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.CINNAMON_LEAVES.get());
		simpleBlock(ExtraDelightBlocks.CINNAMON_PLANKS.get());
		simpleCross(this, ExtraDelightBlocks.CINNAMON_SAPLING.get());
		stairsBlock(ExtraDelightBlocks.CINNAMON_STAIRS.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		trapdoorBlock(
				ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(), models()
						.withExistingParent("cinnamon_trapdoor_bottom",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/chocolate_trapdoor_bottom"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor"))
						.renderType("cutout"),
				models().withExistingParent("cinnamon_trapdoor_top",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_top"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor"))
						.renderType("cutout"),
				models().withExistingParent("cinnamon_trapdoor_open",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_open"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor"))
						.renderType("cutout"),
				true);
		doorBlockWithRenderType(ExtraDelightBlocks.CINNAMON_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_door_top"), "cutout");
		fenceBlock(ExtraDelightBlocks.CINNAMON_FENCE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		fenceGateBlock(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		cabinetBlock(this, ExtraDelightBlocks.CINNAMON_CABINET.get(), "cinnamon");
		slabBlock(ExtraDelightBlocks.CINNAMON_SLAB.get(), modLoc("block/cinnamon_planks"),
				modLoc("block/cinnamon_planks"));
		buttonBlock(ExtraDelightBlocks.CINNAMON_BUTTON.get(), modLoc("block/cinnamon_planks"));
		pressurePlateBlock(ExtraDelightBlocks.CINNAMON_PRESSURE_PLATE.get(), modLoc("block/cinnamon_planks"));

		simpleBlock(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get());

		cropCrossBlock(this, ExtraDelightBlocks.GINGER_CROP.get(), "ginger", GingerCrop.AGE);
		simpleBlock(ExtraDelightBlocks.CANDY_BOWL.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/candy_bowl")));

		frostableBlock(this, ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"white");
		frostableBlock(this, ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"light_grey");
		frostableBlock(this, ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"grey");
		frostableBlock(this, ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"brown");
		frostableBlock(this, ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"black");
		frostableBlock(this, ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block", "red");
		frostableBlock(this, ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"orange");
		frostableBlock(this, ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"yellow");
		frostableBlock(this, ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"lime");
		frostableBlock(this, ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"green");
		frostableBlock(this, ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"cyan");
		frostableBlock(this, ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"light_blue");
		frostableBlock(this, ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"blue");
		frostableBlock(this, ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"purple");
		frostableBlock(this, ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"magenta");
		frostableBlock(this, ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(), "block/gingerbread_block",
				"pink");

		simpleBlock(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get());

		recipeFeastBlock(this, ExtraDelightBlocks.CINNAMON_ROLLS.get(), "cinnamon_rolls");
		recipeFeastBlock(this, ExtraDelightBlocks.MONKEY_BREAD.get(), "monkey_bread");
		createCakeBlock(this, ExtraDelightBlocks.COFFEE_CAKE.get(), "coffee");
		recipeFeastBlock(this, ExtraDelightBlocks.MINT_LAMB.get(), "mint_lamb");
		recipeFeastBlock(this, ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), "charcuterie");
		recipeFeastBlock(this, ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), "christmas_pudding");
		pieLikeBlock(this, ExtraDelightBlocks.MILK_TART.get(), "milk_tart");
		recipeFeastBlock(this, ExtraDelightBlocks.PUNCH.get(), "punch");
		tapBlock(this, ExtraDelightBlocks.TAP.get());
		bushStageFourBlock(this, ExtraDelightBlocks.COFFEE_BUSH.get(), "coffee");

		axisBlock(ExtraDelightBlocks.KEG.get(),
				models().orientableWithBottom("keg_vertical", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")).renderType("cutout"),
				models().orientableWithBottom("keg_horizontal", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")).renderType("cutout"));

		panBlock(this, ExtraDelightBlocks.SHEET_BLOCK.get(), "block/sheet");
		panBlock(this, ExtraDelightBlocks.TRAY_BLOCK.get(), "block/tray");
		panBlock(this, ExtraDelightBlocks.LOAF_PAN_BLOCK.get(), "block/loaf_pan");
		panBlock(this, ExtraDelightBlocks.PIE_DISH_BLOCK.get(), "block/pie_dish");
		panBlock(this, ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), "block/square_pan");
		bakingStoneStyleBlock(this, ExtraDelightBlocks.BAKING_STONE_BLOCK.get());
		panBlock(this, ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(), "block/muffin_tray");
		panBlock(this, ExtraDelightBlocks.SERVING_POT_BLOCK.get(), "block/serving_pot");
		panBlock(this, ExtraDelightBlocks.BAR_MOLD.get(), "block/bar_mold");

		logBlock(ExtraDelightBlocks.FRUIT_LOG.get());
		axisBlock(ExtraDelightBlocks.FRUIT_WOOD.get(), modLoc("block/fruit_log"), modLoc("block/fruit_log"));
		axisBlock(ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get(), modLoc("block/stripped_fruit_log"),
				modLoc("block/stripped_fruit_log"));
		logBlock(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get());
		simpleBlock(ExtraDelightBlocks.FRUIT_PLANKS.get());
		stairsBlock(ExtraDelightBlocks.FRUIT_STAIRS.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		trapdoorBlockWithRenderType(ExtraDelightBlocks.FRUIT_TRAPDOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_trapdoor"), true, "cutout");
		doorBlockWithRenderType(ExtraDelightBlocks.FRUIT_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_door_top"), "cutout");
		fenceBlock(ExtraDelightBlocks.FRUIT_FENCE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		fenceGateBlock(ExtraDelightBlocks.FRUIT_FENCE_GATE.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/fruit_planks"));
		cabinetBlock(this, ExtraDelightBlocks.FRUIT_CABINET.get(), "fruit");
		slabBlock(ExtraDelightBlocks.FRUIT_SLAB.get(), modLoc("block/fruit_planks"), modLoc("block/fruit_planks"));
		buttonBlock(ExtraDelightBlocks.FRUIT_BUTTON.get(), modLoc("block/fruit_planks"));
		pressurePlateBlock(ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get(), modLoc("block/fruit_planks"));
		signBlock(ExtraDelightBlocks.FRUIT_STANDING_SIGN.get(), ExtraDelightBlocks.FRUIT_WALL_SIGN.get(),
				modLoc("block/fruit_planks"));

		fruitLeafBlock(this, ExtraDelightBlocks.HAZELNUT_LEAVES.get(), "hazelnut");

		styleBlock(this, ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/dark_chocolate");
		fenceBlock(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style0"));
		fenceGateBlock(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style0"));
		stairsBlock(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/dark_chocolate_style1"));
		doorBlock(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_door_top"));
		trapdoorBlock(
				ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), models()
						.withExistingParent("dark_chocolate_trapdoor_bottom",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/chocolate_trapdoor_bottom"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/dark_chocolate_trapdoor")),
				models().withExistingParent("dark_chocolate_trapdoor_top",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_top"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/dark_chocolate_trapdoor")),
				models().withExistingParent("dark_chocolate_trapdoor_open",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_open"))
						.texture("texture", ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
								"block/cosmetics/chocolate/dark_chocolate_trapdoor")),
				true);
		slabBlock(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(), modLoc("block/dark_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/dark_chocolate_style0"));
		axisBlock(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/dark_chocolate_style0"));

		styleBlock(this, ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/milk_chocolate");
		fenceBlock(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style0"));
		fenceGateBlock(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style0"));
		stairsBlock(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/milk_chocolate_style1"));
		doorBlock(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_door_top"));
		trapdoorBlock(
				ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), models()
						.withExistingParent("milk_chocolate_trapdoor_bottom",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/chocolate_trapdoor_bottom"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/milk_chocolate_trapdoor")),
				models().withExistingParent("milk_chocolate_trapdoor_top",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_top"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/milk_chocolate_trapdoor")),
				models().withExistingParent("milk_chocolate_trapdoor_open",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_open"))
						.texture("texture", ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
								"block/cosmetics/chocolate/milk_chocolate_trapdoor")),
				true);
		slabBlock(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(), modLoc("block/milk_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/milk_chocolate_style0"));
		axisBlock(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/milk_chocolate_style0"));

		styleBlock(this, ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/white_chocolate");
		fenceBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style0"));
		fenceGateBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style0"));
		stairsBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/white_chocolate_style1"));
		doorBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_door_top"));
		trapdoorBlock(
				ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), models()
						.withExistingParent("white_chocolate_trapdoor_bottom",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/chocolate_trapdoor_bottom"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/white_chocolate_trapdoor")),
				models().withExistingParent("white_chocolate_trapdoor_top",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_top"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/white_chocolate_trapdoor")),
				models().withExistingParent("white_chocolate_trapdoor_open",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_open"))
						.texture("texture", ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
								"block/cosmetics/chocolate/white_chocolate_trapdoor")),
				true);
		slabBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(), modLoc("block/white_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/white_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/white_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/white_chocolate_style0"));
		axisBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/white_chocolate_style0"));

		styleBlock(this, ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/blood_chocolate");
		fenceBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style0"));
		fenceGateBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style0"));
		stairsBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(), ResourceLocation
				.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/cosmetics/chocolate/blood_chocolate_style1"));
		doorBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_door_bottom"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_door_top"));
		trapdoorBlock(
				ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(), models()
						.withExistingParent("blood_chocolate_trapdoor_bottom",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/chocolate_trapdoor_bottom"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/blood_chocolate_trapdoor")),
				models().withExistingParent("blood_chocolate_trapdoor_top",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_top"))
						.texture("texture",
								ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
										"block/cosmetics/chocolate/blood_chocolate_trapdoor")),
				models().withExistingParent("blood_chocolate_trapdoor_open",
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/chocolate_trapdoor_open"))
						.texture("texture", ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
								"block/cosmetics/chocolate/blood_chocolate_trapdoor")),
				true);
		slabBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(), modLoc("block/blood_chocolate_slab_double"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_slab"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_style0"),
				modLoc("block/cosmetics/chocolate/blood_chocolate_style0"));
		axisBlock(ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get(),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_pillar"),
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
						"block/cosmetics/chocolate/blood_chocolate_style0"));

		chocolateBox(this, ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.RED_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get());
		chocolateBox(this, ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get());

		recipeFeastBlock(this, ExtraDelightBlocks.BROWNIES.get());
		recipeFeastBlock(this, ExtraDelightBlocks.BLONDIES.get());
		createCakeBlock(this, ExtraDelightBlocks.CHOCOLATE_CAKE.get(), "chocolate");
		recipeFeastBlock(this, ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get());
		recipeFeastBlock(this, ExtraDelightBlocks.CRISP_RICE_TREATS.get());
		recipeFeastBlock(this, ExtraDelightBlocks.SCOTCHAROOS.get());
		recipeFeastBlock(this, ExtraDelightBlocks.FUDGE.get());
		recipeFeastBlock(this, ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get());

		fondueBlock(this, ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), "blood");
		fondueBlock(this, ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), "white");
		fondueBlock(this, ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), "dark");
		fondueBlock(this, ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), "milk");

		cropCrossBlock(this, ExtraDelightBlocks.PEANUT_CROP.get(), "peanut", PeanutCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_PEANUT.get(), new ConfiguredModel(
				models().cross("wild_peanut", modLoc("block/crops/peanut/wild_peanut")).renderType("cutout")));

		cropCrossBlock(this, ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), "marshmallow", MallowRootCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_MALLOW_ROOT.get(), new ConfiguredModel(models()
				.cross("wild_mallow_root", modLoc("block/crops/marshmallow/wild_marshmallow")).renderType("cutout")));

		cropCrossBlock(this, ExtraDelightBlocks.CHILI_CROP.get(), "chili", ChiliCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_CHILI.get(), new ConfiguredModel(
				models().cross("wild_chili", modLoc("block/crops/chili/wild_chili")).renderType("cutout")));

		simpleCross(this, ExtraDelightBlocks.HAZELNUT_SAPLING.get(), "crops/fruit/hazelnut/hazelnut_sapling");

		simpleBlock(ExtraDelightBlocks.JAR.get(),
				models().getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/jar")));

		fluid(this, ExtraDelightBlocks.APPLE_CIDER_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.BBQ_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.BLOOD_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.BROTH_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.CACTUS_JUICE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.CARAMEL_SAUCE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.COCOA_BUTTER_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.COFFEE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.COOKING_OIL_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.DARK_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.EGG_MIX_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.GLOW_BERRY_JUICE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.GLOW_JAM_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.GOLDEN_JAM_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.GRAVY_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.COCOA_NUT_BUTTER_SPREAD_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.HOT_COCOA_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.JAM_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.KETCHUP_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.MARSHMALLOW_FLUFF_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.MAYO_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.MELON_JUICE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.MILK_CHOCOLATE_SYRUP_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.MILKSHAKE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.NUT_BUTTER_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.SWEET_BERRY_JUICE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.TEA_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.TOMATO_JUICE_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.VINEGAR_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.WHIPPED_CREAM_FLUID_BLOCK.get());
		fluid(this, ExtraDelightBlocks.WHITE_CHOCOLATE_SYRUP_FLUID_BLOCK.get());

		simpleBlock(ExtraDelightBlocks.MARSHMALLOW_BLOCK.get());

		vanillaFruitLeafBlock(this, ExtraDelightBlocks.APPLE_LEAVES.get(), "apple");
		simpleCross(this, ExtraDelightBlocks.APPLE_SAPLING.get(), "crops/fruit/apple/apple_sapling");
		recipeFeastBlock(this, ExtraDelightBlocks.PORK_AND_APPLES_FEAST.get());
		recipeFeastBlock(this, ExtraDelightBlocks.STUFFED_APPLES_FEAST.get());
		pieLikeBlock(this, ExtraDelightBlocks.TARTE_TATIN.get(), "tarte_tatin");

		simpleBlock(ExtraDelightBlocks.HANGING_ONIONS.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_onions")));
		simpleBlock(ExtraDelightBlocks.HANGING_MINT.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_mint")));
		simpleBlock(ExtraDelightBlocks.HANGING_HAM.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_ham")));
		simpleBlock(ExtraDelightBlocks.HANGING_CHILI.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_chili")));
		simpleBlock(ExtraDelightBlocks.HANGING_DRIED_CHILI.get(), models().getExistingFile(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_dried_chili")));
		simpleBlock(ExtraDelightBlocks.HANGING_CORN.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_corn")));

		crateBlock(this, ExtraDelightBlocks.CHILI_CRATE.get(), "chili", "spruce");
		crateBlock(this, ExtraDelightBlocks.APPLE_CRATE.get(), "apple", "oak");
		crateBlock(this, ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get(), "brown_mushroom", "spruce");
		crateBlock(this, ExtraDelightBlocks.COFFEE_CHERRY_CRATE.get(), "coffee_cherry", "spruce");
		crateBlock(this, ExtraDelightBlocks.CORN_CRATE.get(), "corn", "spruce");
		crateBlock(this, ExtraDelightBlocks.EGG_CRATE.get(), "egg", "spruce");
		crateBlock(this, ExtraDelightBlocks.GINGER_CRATE.get(), "ginger", "spruce");
		crateBlock(this, ExtraDelightBlocks.GLOW_BERRY_CRATE.get(), "glow_berry", "spruce");
		crateBlock(this, ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get(), "golden_apple", "spruce");
		crateBlock(this, ExtraDelightBlocks.GOLDEN_CARROT_CRATE.get(), "golden_carrot", "spruce");
		crateBlock(this, ExtraDelightBlocks.MALLOW_ROOT_CRATE.get(), "mallow_root", "spruce");
		crateBlock(this, ExtraDelightBlocks.RED_MUSHROOM_CRATE.get(), "red_mushroom", "spruce");
		crateBlock(this, ExtraDelightBlocks.SWEET_BERRY_CRATE.get(), "sweet_berry", "spruce");

		sackBlock(this, ExtraDelightBlocks.BREADCRUMB_SACK.get(), "breadcrumb", "lime");
		sackBlock(this, ExtraDelightBlocks.CHILI_POWDER_SACK.get(), "chili_powder", "green");
		sackBlock(this, ExtraDelightBlocks.COCOA_BEAN_SACK.get(), "cocoa_beans", "blue");
		sackBlock(this, ExtraDelightBlocks.COCOA_POWDER_SACK.get(), "cocoa_powder", "gray");
		sackBlock(this, ExtraDelightBlocks.COCOA_SOLIDS_SACK.get(), "cocoa_solids", "light_blue");
		sackBlock(this, ExtraDelightBlocks.COFFEE_BEAN_SACK.get(), "coffee_bean", "light_gray");
		sackBlock(this, ExtraDelightBlocks.CORN_SILK_SACK.get(), "corn_silk", "yellow");
		sackBlock(this, ExtraDelightBlocks.CORN_SACK.get(), "corn", "green");
		sackBlock(this, ExtraDelightBlocks.CORNMEAL_SACK.get(), "cornmeal", "green");
		sackBlock(this, ExtraDelightBlocks.FLOUR_SACK.get(), "flour", "brown");
		sackBlock(this, ExtraDelightBlocks.GREEN_COFFEE_BEAN_SACK.get(), "green_coffee_beans", "white");
		sackBlock(this, ExtraDelightBlocks.GROUND_CINNAMON_SACK.get(), "ground_cinnamon", "red");
		sackBlock(this, ExtraDelightBlocks.HAZELNUT_IN_SHELL_SACK.get(), "hazelnut_in_shell", "pink");
		sackBlock(this, ExtraDelightBlocks.HAZELNUT_SACK.get(), "hazelnut", "magenta");
		sackBlock(this, ExtraDelightBlocks.MALLOW_POWDER_SACK.get(), "mallow_powder", "black");
		sackBlock(this, ExtraDelightBlocks.MINT_SACK.get(), "mint", "red");
		sackBlock(this, ExtraDelightBlocks.PEANUT_IN_SHELL_SACK.get(), "peanut_in_shell", "light_blue");
		sackBlock(this, ExtraDelightBlocks.PEANUT_SACK.get(), "peanut", "cyan");
		sackBlock(this, ExtraDelightBlocks.ROASTED_COCOA_BEAN_SACK.get(), "roasted_cocoa_beans", "cyan");
		sackBlock(this, ExtraDelightBlocks.ROASTED_HAZELNUT_SACK.get(), "roasted_hazelnut", "purple");
		sackBlock(this, ExtraDelightBlocks.ROASTED_PEANUT_SACK.get(), "roasted_peanut", "blue");
		sackBlock(this, ExtraDelightBlocks.SUGAR_SACK.get(), "sugar", "blue");
		sackBlock(this, ExtraDelightBlocks.GROUND_COFFEE_SACK.get(), "ground_coffee", "gray");

		stewBlock(this, ExtraDelightBlocks.CHILI_CON_CARNE_FEAST.get(), "chili_con_carne");
		stewBlock(this, ExtraDelightBlocks.WHITE_CHILI_FEAST.get(), "white_chili");
		pieBlock(this, ExtraDelightBlocks.MISSISSIPPI_MUD_PIE.get(), "mississippi_mud_pie", "mississippi_mud_pie");
		pieBlock(this, ExtraDelightBlocks.GRASSHOPPER_PIE.get(), "grasshopper_pie", "mississippi_mud_pie");

		recipeFeastBlock(this, ExtraDelightBlocks.MARSHMALLOW_SLICE_FEAST.get(), "marshmallow_slice");
		simpleBlock(ExtraDelightBlocks.CHOCOLATE_COOKIE_BLOCK.get());
		simpleBlock(ExtraDelightBlocks.NUT_BUTTER_COOKIE_BLOCK.get());
		pieBlock(this, ExtraDelightBlocks.BACON_EGG_PIE.get(), "bacon_egg_pie");
		pieLikeBlock(this, ExtraDelightBlocks.PANFORTE.get(), "panforte");

		cropCrossBlock(this, ExtraDelightBlocks.GARLIC_CROP.get(), "garlic", GarlicCrop.AGE);
		simpleBlock(ExtraDelightBlocks.WILD_GARLIC.get(), new ConfiguredModel(
				models().cross("wild_garlic", modLoc("block/crops/garlic/garlic_stage3")).renderType("cutout")));
		crateBlock(this, ExtraDelightBlocks.GARLIC_CRATE.get(), "garlic", "spruce");
		recipeFeastBlock(this, ExtraDelightBlocks.BRUSCHETTA_FEAST.get(), "bruschetta");
		simpleBlock(ExtraDelightBlocks.HANGING_GARLIC.get(), models()
				.getExistingFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/hanging_garlic")));

		getVariantBuilder(ExtraDelightBlocks.VAT.get()).forAllStates(state -> {
			int servings = state.getValue(VatBlock.STYLE);

			String suffix = "_style" + servings;

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent("block/cosmetics/vat/vat" + suffix.toLowerCase(), modLoc("block/vat"))
							.renderType("cutout"))
					.rotationY(((int) state.getValue(VatBlock.FACING).toYRot() + 90) % 360).build();
		});

		getVariantBuilder(ExtraDelightBlocks.LID.get()).forAllStates(state -> {
			int servings = state.getValue(LidBlock.STYLE);

			String suffix = "_style" + servings;

			return ConfiguredModel.builder().modelFile(
					models().withExistingParent("block/cosmetics/lid/lid" + suffix.toLowerCase(), modLoc("block/lid")))
					.build();
		});

		AestheticBlocks.blockModel(this);
		Fermentation.blockModels(this);
	}

	public static void fluid(BlockStateProvider bsp, LiquidBlock block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			return ConfiguredModel.builder()
					.modelFile(bsp.models().getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath())
							.texture("texture", "minecraft:block/water_still")
//					.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), bsp.mcLoc("block/air"))
							.renderType("translucent"))
					.build();
		});
	}

	public static void chocolateBox(BlockStateProvider bsp, ChocolateBoxBlock block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			boolean open = state.getValue(ChocolateBoxBlock.OPEN);

			if (open)
				return ConfiguredModel.builder().modelFile(bsp.models()
						.withExistingParent(block.getColor() + "_chocolate_box_open",
								bsp.modLoc("block/chocolate_box_open"))
						.texture("0", bsp.mcLoc("block/" + block.getColor() + "_glazed_terracotta"))
						.texture("1", bsp.modLoc("block/ribbon/" + getOppositeColor(block.getColor()) + "_ribbon"))
						.texture("2", bsp.mcLoc("block/" + getOppositeColor(block.getColor()) + "_wool"))
						.renderType("cutout"))

						.rotationY(((int) state.getValue(ChocolateBoxBlock.FACING).toYRot() + 180) % 360).build();

			return ConfiguredModel.builder().modelFile(bsp.models()

					.withExistingParent(block.getColor() + "_chocolate_box", bsp.modLoc("block/chocolate_box"))
					.texture("0", bsp.mcLoc("block/" + block.getColor() + "_glazed_terracotta"))
					.texture("1", bsp.modLoc("block/ribbon/" + getOppositeColor(block.getColor()) + "_ribbon"))
					.texture("particle", bsp.mcLoc("block/" + block.getColor() + "_glazed_terracotta"))
					.renderType("cutout"))
					.rotationY(((int) state.getValue(ChocolateBoxBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static DyeColor getOppositeColor(DyeColor dye) {
		int i = dye.getId();
		int out = i + 8;
		if (out > 15)
			out = Math.abs(out - 15);
		return DyeColor.byId(out);

	}

	public static void bakingStoneStyleBlock(BlockStateProvider bsp, BakingStoneBlock block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(BakingStoneBlock.STYLE);

			String suffix = BakingStoneBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent("baking_stone" + suffix.toLowerCase(), bsp.modLoc("block/baking_stone"))
							.texture("0", bsp.mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public static void mixingBowlStyleBlock(BlockStateProvider bsp, Block block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(MixingBowlBlock.STYLE);

			String suffix = MixingBowlBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent("mixing_bowl" + suffix.toLowerCase(), bsp.modLoc("block/mixing_bowl"))
							.texture("1", bsp.mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public static void mortarStyleBlock(BlockStateProvider bsp, Block block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(MortarBlock.STYLE);

			String suffix = MortarBlock.Styles.values()[servings] + "";

			return ConfiguredModel.builder()
					.modelFile(
							bsp.models().withExistingParent("mortar" + suffix.toLowerCase(), bsp.modLoc("block/mortar"))
									.texture("0", bsp.mcLoc("block/" + suffix.toLowerCase())))
					.build();
		});
	}

	public static void styleBlock(BlockStateProvider bsp, Block style, IntegerProperty count, String path) {
		bsp.getVariantBuilder(style).forAllStates(state -> {
			int servings = state.getValue(count);

			String suffix = "_style" + servings;

			return ConfiguredModel.builder()
					.modelFile(bsp.models().withExistingParent(path + suffix.toLowerCase(), bsp.mcLoc("block/cube_all"))
							.texture("all", bsp.modLoc(path + suffix.toLowerCase())))
					.build();
		});
	}

	public static void fruitLeafBlock(BlockStateProvider bsp, FruitLeafBlock block, String name) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int age = state.getValue(FruitLeafBlock.AGE);

			String suffix = "_stage" + age;

			ModelFile model = bsp.models()
					.getExistingFile(bsp.modLoc("block/crops/fruit/" + name + "/" + name + "_leaves" + suffix));

			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public static void vanillaFruitLeafBlock(BlockStateProvider bsp, VanillaFruitLeafBlock block, String name) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int age = state.getValue(VanillaFruitLeafBlock.AGE);

			String suffix = "_stage" + age;

			ModelFile model = bsp.models()
					.getExistingFile(bsp.modLoc("block/crops/fruit/" + name + "/" + name + "_leaves" + suffix));

			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public static void bushStageFourBlock(BlockStateProvider bsp, BushStageFour block, String name) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int age = state.getValue(BushStageFour.AGE);

			String suffix = "_stage" + age;

			ModelFile model = bsp.models().withExistingParent(name + "_bush" + suffix,
					bsp.modLoc("block/crops/" + name + "/" + name + "_bush" + suffix));

			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public static void jellyBlock(BlockStateProvider bsp, RecipeFeastBlock block, String color) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			ResourceLocation contentsTexture = bsp.modLoc("block/jelly_" + color);
			ResourceLocation particleTexture = bsp.modLoc("block/jelly_" + color);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			ModelFile jellyModel = bsp.models()
					.withExistingParent("jelly_" + color + "_block" + suffix, bsp.modLoc("block/jelly_block" + suffix))
					.texture("1", contentsTexture).renderType("translucent");

			return ConfiguredModel.builder().modelFile(jellyModel)
					.rotationY(((int) state.getValue(RecipeFeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	private static void createCakeBlock(BlockStateProvider bsp, Block block, String prefix) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(BlockStateProperties.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									bsp.mcLoc("block/cake" + suffix))
							.texture("particle", bsp.modLoc("block/" + prefix + "_cake_top"))
							.texture("bottom", bsp.modLoc("block/" + prefix + "_cake_bottom"))
							.texture("side", bsp.modLoc("block/" + prefix + "_cake_side"))
							.texture("top", bsp.modLoc("block/" + prefix + "_cake_top"))
							.texture("inside", bsp.modLoc("block/" + prefix + "_cake_inner")))
					.build();
		});
	}

	public static void tapBlock(BlockStateProvider bsp, TapBlock block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			Direction dir = state.getValue(TapBlock.FACING);
			boolean ground = state.getValue(TapBlock.GROUND);
			if (ground)
				return ConfiguredModel.builder()
						.modelFile(bsp.models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + dir + "_down",
								bsp.modLoc("block/tap_down")))
						.rotationY(((int) state.getValue(TapBlock.FACING).toYRot() + 180) % 360).build();
			else
				return ConfiguredModel.builder()
						.modelFile(bsp.models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + dir + "_up",
								bsp.modLoc("block/tap")))
						.rotationY(((int) state.getValue(TapBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void pieBlock(BlockStateProvider bsp, Block block, String prefix) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									bsp.modLoc("block/pie" + suffix))
							.texture("particle", bsp.modLoc("block/" + prefix + "_top"))
//					.texture("bottom", "farmersdelight:block/pie_bottom")
//					.texture("side", "farmersdelight:block/pie_side")
							.texture("top", bsp.modLoc("block/" + prefix + "_top"))
							.texture("inner", bsp.modLoc("block/" + prefix + "_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void pieBlock(BlockStateProvider bsp, Block block, String prefix, String crust) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									bsp.modLoc("block/pie" + suffix))
							.texture("particle", bsp.modLoc("block/" + prefix + "_top"))
							.texture("bottom", bsp.modLoc("block/" + crust + "_bottom"))
							.texture("side", bsp.modLoc("block/" + crust + "_side"))
							.texture("top", bsp.modLoc("block/" + prefix + "_top"))
							.texture("inner", bsp.modLoc("block/" + prefix + "_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void pieLikeBlock(BlockStateProvider bsp, Block block, String path) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = "_stage" + bites;

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void feastBlock(BlockStateProvider bsp, FeastBlock block) {
		feastBlock(bsp, block, BuiltInRegistries.BLOCK.getKey(block).getPath());
	}

	public static void feastBlock(BlockStateProvider bsp, FeastBlock block, String path) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void recipeFeastBlock(BlockStateProvider bsp, RecipeFeastBlock block) {
		recipeFeastBlock(bsp, block, BuiltInRegistries.BLOCK.getKey(block).getPath());
	}

	public static void recipeFeastBlock(BlockStateProvider bsp, RecipeFeastBlock block, String path) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + path + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void fondueBlock(BlockStateProvider bsp, RecipeFondueFeastBlock block, String pre) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFondueFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage7";
			}

			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(pre + "_chocolate_fondue_pot" + suffix,
									bsp.modLoc("block/fondue_pot" + suffix))
							.texture("5", bsp.modLoc("liquid/" + pre + "_chocolate_syrup_still")))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void frostableBlock(BlockStateProvider bsp, FrostableBlock block, String path, String color) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FrostableBlock.STYLE);

			String suffix = FrostableBlock.Styles.values()[servings] + "_";

			if (servings != 7)
				return ConfiguredModel.builder()
						.modelFile(bsp.models()
								.withExistingParent(path + "_" + suffix.toLowerCase() + color,
										bsp.modLoc("block/double_texture"))
								.texture("0", bsp.modLoc(path))
								.texture("1", bsp.modLoc("block/frosting_colors/" + suffix.toLowerCase() + color)))
						.build();

			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent(path + "_" + suffix.toLowerCase() + color, bsp.modLoc("block/grass_like"))
					.texture("0", bsp.modLoc(path)).texture("1", bsp.modLoc("block/frosting_colors/full_" + color))
					.texture("2", bsp.modLoc("block/frosting_colors/" + suffix.toLowerCase() + color))).build();
		});
	}

	public static void panBlock(BlockStateProvider bsp, HorizontalPanBlock block, String base) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(HorizontalPanBlock.STYLE);

			String suffix = HorizontalPanBlock.Styles.values()[servings] + "_";

			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent("block/cosmetics/pans/" + base + "_" + suffix.toLowerCase(), bsp.modLoc(base))
					.texture("0", bsp.modLoc("block/cosmetics/pans/" + suffix.toLowerCase() + "pan"))
					.texture("particle", bsp.modLoc("block/cosmetics/pans/" + suffix.toLowerCase() + "pan"))
					.renderType("translucent"))
					.rotationY(((int) state.getValue(HorizontalPanBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void stewBlock(BlockStateProvider bsp, RecipeFeastBlock block, String texture) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(block.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			ResourceLocation contentsTexture = bsp.modLoc("block/" + texture);
			ResourceLocation particleTexture = bsp.modLoc("block/" + texture);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
				particleTexture = bsp.modLoc("block/pan");
			}

			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
									bsp.modLoc("curry_block" + suffix))
							.texture("1", contentsTexture).texture("particle", particleTexture).renderType("cutout"))
					.rotationY(((int) state.getValue(RecipeFeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void cornBlock(BlockStateProvider bsp, CornBottom bottom, CornTop top) {
		bsp.getVariantBuilder(bottom).forAllStates(state -> {
			int age = state.getValue(CornBottom.AGE);
			boolean dry = state.getValue(CornProperties.DIMENSION);
			String suffix = "_stage" + age;

			if (dry)
				return ConfiguredModel.builder()
						.modelFile(bsp.models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(bottom).getPath() + "_dimension",
								bsp.modLoc("block/crops/corn/dimension_corn_bottom")))
						.build();

			return ConfiguredModel.builder()
					.modelFile(
							bsp.models().withExistingParent(BuiltInRegistries.BLOCK.getKey(bottom).getPath() + suffix,
									bsp.modLoc("block/crops/corn/corn" + suffix)))
					.build();
		});

		bsp.getVariantBuilder(top).forAllStates(state -> {
			int age = state.getValue(CornTop.AGE);
			boolean dry = state.getValue(CornProperties.DIMENSION);
			String suffix = "_stage" + (age + 4);
			String suffix2 = "_stage" + age;

			if (dry)
				return ConfiguredModel.builder()
						.modelFile(bsp.models().withExistingParent(
								BuiltInRegistries.BLOCK.getKey(top).getPath() + "_dimension",
								bsp.modLoc("block/crops/corn/dimension_corn_top")))
						.build();

			return ConfiguredModel.builder()
					.modelFile(bsp.models().withExistingParent(BuiltInRegistries.BLOCK.getKey(top).getPath() + suffix2,
							bsp.modLoc("block/crops/corn/corn" + suffix)))
					.build();
		});
	}

	public static void cropCrossBlock(BlockStateProvider bsp, CropBlock block, String name, IntegerProperty age) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int a = state.getValue(age);
			String suffix = "_stage" + a;

			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
							bsp.mcLoc("block/cross"))
					.texture("cross", bsp.modLoc("block/crops/" + name + "/" + name + suffix)).renderType("cutout"))
					.build();
		});

	}

	private static void simpleCross(BlockStateProvider bsp, Block block) {
		bsp.simpleBlock(block,
				new ConfiguredModel(bsp.models()
						.cross(BuiltInRegistries.BLOCK.getKey(block).getPath(),
								bsp.modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()))
						.renderType("cutout")));
	}

	private static void simpleCross(BlockStateProvider bsp, Block block, String path) {
		bsp.simpleBlock(block,
				new ConfiguredModel(
						bsp.models().cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), bsp.modLoc("block/" + path))
								.renderType("cutout")));
	}

	public static void cabinetBlock(BlockStateProvider bsp, Block block, String woodType) {
		bsp.horizontalBlock(block, state -> {
			String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
			return bsp.models().orientable(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_side"),
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
							"block/" + woodType + "_cabinet_front" + suffix),
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_top"));
		});
	}

	public static void crateBlock(BlockStateProvider bsp, Block block, String type, String woodType) {
		bsp.simpleBlock(block, new ConfiguredModel(bsp.models().cube(type + "_crate",
				bsp.modLoc("block/crates/" + woodType + "_crate_bottom"), bsp.modLoc("block/" + type + "_crate_top"),
				bsp.modLoc("block/" + type + "_crate_side"), bsp.modLoc("block/" + type + "_crate_side"),
				bsp.modLoc("block/" + type + "_crate_side"), bsp.modLoc("block/" + type + "_crate_side"))));
	}

	public static void sackBlock(BlockStateProvider bsp, Block block, String type, String color) {
		bsp.simpleBlock(block, new ConfiguredModel(bsp.models().cube(type + "_sack",
				bsp.modLoc("block/bags/" + color + "_bag_bottom"), bsp.modLoc("block/" + type + "_bag_top"),
				bsp.modLoc("block/bags/" + color + "_bag_side_tied"), bsp.modLoc("block/bags/" + color + "_bag_side"),
				bsp.modLoc("block/bags/" + color + "_bag_side"), bsp.modLoc("block/bags/" + color + "_bag_side"))
				.texture("particle", bsp.modLoc("block/" + type + "_bag_top"))));
	}
}
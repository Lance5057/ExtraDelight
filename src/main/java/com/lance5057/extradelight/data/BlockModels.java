package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.blocks.ChocolateStyleBlock;
import com.lance5057.extradelight.blocks.FrostableBlock;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.TapBlock;
import com.lance5057.extradelight.blocks.crops.ChiliCrop;
import com.lance5057.extradelight.blocks.crops.CoffeeBush;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
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
		this.simpleBlock(ExtraDelightBlocks.MIXING_BOWL.get(), models().getExistingFile(modLoc("block/mixing_bowl")));

		this.simpleBlock(ExtraDelightBlocks.YEAST_POT.get(), models().getExistingFile(modLoc("block/yeast_pot")));
		this.simpleBlock(ExtraDelightBlocks.VINEGAR_POT.get(),
				models().withExistingParent("vinegar_pot", modLoc("block/yeast_pot"))
						.texture("0", modLoc("block/vinegarpot")).texture("particle", modLoc("block/vinegarpot")));
		this.simpleBlock(ExtraDelightBlocks.DRYING_RACK.get(), models().getExistingFile(modLoc("block/drying_rack")));

		this.simpleBlock(ExtraDelightBlocks.MORTAR_STONE.get(),
				models().withExistingParent("mortar_stone", modLoc("block/mortar")).texture("0", mcLoc("block/stone"))
						.texture("particle", mcLoc("block/stone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ANDESITE.get(),
				models().withExistingParent("mortar_andesite", modLoc("block/mortar"))
						.texture("0", mcLoc("block/andesite")).texture("particle", mcLoc("block/andesite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GRANITE.get(),
				models().withExistingParent("mortar_granite", modLoc("block/mortar"))
						.texture("0", mcLoc("block/granite")).texture("particle", mcLoc("block/granite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DIORITE.get(),
				models().withExistingParent("mortar_diorite", modLoc("block/mortar"))
						.texture("0", mcLoc("block/diorite")).texture("particle", mcLoc("block/diorite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DEEPSLATE.get(),
				models().withExistingParent("mortar_deepslate", modLoc("block/mortar"))
						.texture("0", mcLoc("block/deepslate")).texture("particle", mcLoc("block/deepslate")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BLACKSTONE.get(),
				models().withExistingParent("mortar_blackstone", modLoc("block/mortar"))
						.texture("0", mcLoc("block/blackstone")).texture("particle", mcLoc("block/blackstone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BASALT.get(),
				models().withExistingParent("mortar_basalt", modLoc("block/mortar"))
						.texture("0", mcLoc("block/basalt_side")).texture("particle", mcLoc("block/basalt_side")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ENDSTONE.get(),
				models().withExistingParent("mortar_endstone", modLoc("block/mortar"))
						.texture("0", mcLoc("block/end_stone")).texture("particle", mcLoc("block/end_stone")));

		// not craftable, dungeon items
		this.simpleBlock(ExtraDelightBlocks.MORTAR_AMETHYST.get(),
				models().withExistingParent("mortar_amethyst", modLoc("block/mortar"))
						.texture("0", mcLoc("block/amethyst_block"))
						.texture("particle", mcLoc("block/amethyst_block")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(),
				models().withExistingParent("mortar_gilded_blackstone", modLoc("block/mortar"))
						.texture("0", mcLoc("block/gilded_blackstone"))
						.texture("particle", mcLoc("block/gilded_blackstone")));

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

		createCakeBlock(ExtraDelightBlocks.PLAIN_CAKE.get(), "plain");

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
//		this.simpleCross(ExtraDelightBlocks.CINNAMON_SAPLING.get());
		this.stairsBlock(ExtraDelightBlocks.CINNAMON_STAIRS.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		this.trapdoorBlockWithRenderType(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_trapdoor"), true, "cutout");
		this.doorBlockWithRenderType(ExtraDelightBlocks.CINNAMON_DOOR.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_door_bottom"),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_door_top"), "cutout");
		this.fenceBlock(ExtraDelightBlocks.CINNAMON_FENCE.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
		this.fenceGateBlock(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/cinnamon_planks"));
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
		this.simpleBlock(ExtraDelightBlocks.CANDY_BOWL.get(),
				models().getExistingFile(new ResourceLocation(ExtraDelight.MOD_ID, "block/candy_bowl")));

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

//		this.simpleBlock(ExtraDelightBlocks.MINT_CROP.get(), models().getExistingFile(modLoc("block/mint")));

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
		coffeeBushBlock(ExtraDelightBlocks.COFFEE_BUSH.get());

		this.axisBlock(ExtraDelightBlocks.KEG.get(),
				models().orientableWithBottom("keg_vertical", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")),
				models().orientableWithBottom("keg_vertical", modLoc("block/keg_side"), modLoc("block/keg_side"),
						modLoc("block/keg_bottom"), modLoc("block/keg_top")).renderType("cutout"));

		this.horizontalBlock(ExtraDelightBlocks.SHEET_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/sheet")));
		this.horizontalBlock(ExtraDelightBlocks.TRAY_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/tray")));
		this.horizontalBlock(ExtraDelightBlocks.LOAF_PAN_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/loafpan")));
		this.simpleBlock(ExtraDelightBlocks.PIE_DISH_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/piepan")));
		this.simpleBlock(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/cake_pan")));
		this.simpleBlock(ExtraDelightBlocks.BAKING_STONE_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/baking_stone")));
		this.horizontalBlock(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/muffin_tray")));
		this.horizontalBlock(ExtraDelightBlocks.SERVING_POT_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/serving_pot")));
		this.simpleBlock(ExtraDelightBlocks.SERVING_PAN_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/serving_pan")));
		this.simpleBlock(ExtraDelightBlocks.SERVING_BOWL_BLOCK.get(),
				this.models().getExistingFile(this.modLoc("block/serving_bowl")));

		this.logBlock(ExtraDelightBlocks.FRUIT_LOG.get());
		this.logBlock(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get());
		this.simpleBlock(ExtraDelightBlocks.FRUIT_PLANKS.get());
//		this.simpleCross(ExtraDelightBlocks.FRUIT_SAPLING.get());
		this.stairsBlock(ExtraDelightBlocks.FRUIT_STAIRS.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.trapdoorBlockWithRenderType(ExtraDelightBlocks.FRUIT_TRAPDOOR.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_trapdoor"), true, "cutout");
		this.doorBlockWithRenderType(ExtraDelightBlocks.FRUIT_DOOR.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_door_bottom"),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_door_top"), "cutout");
		this.fenceBlock(ExtraDelightBlocks.FRUIT_FENCE.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.fenceGateBlock(ExtraDelightBlocks.FRUIT_FENCE_GATE.get(),
				new ResourceLocation(ExtraDelight.MOD_ID, "block/fruit_planks"));
		this.cabinetBlock(ExtraDelightBlocks.FRUIT_CABINET.get(), "fruit");
		this.slabBlock(ExtraDelightBlocks.FRUIT_SLAB.get(), modLoc("block/fruit_planks"), modLoc("block/fruit_planks"));
		this.fruitLeafBlock(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), "hazelnut");
		this.cropCrossBlock(ExtraDelightBlocks.CHILI_CROP.get(), "chili", ChiliCrop.AGE);

		styleBlock(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/dark_chocolate");
		styleBlock(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/milk_chocolate");
		styleBlock(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), ChocolateStyleBlock.STYLE,
				"block/cosmetics/chocolate/white_chocolate");

		AestheticBlocks.blockModel(this);
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
							new ResourceLocation(ExtraDelight.MOD_ID, "block/" + path + suffix),
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
							new ResourceLocation(ExtraDelight.MOD_ID, "block/" + path + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void recipeFeastBlock(RecipeFeastBlock block) {
		recipeFeastBlock(block, BuiltInRegistries.BLOCK.getKey(block).getPath());
	}

	public void recipeFeastBlock(RecipeFeastBlock block, String path) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							new ResourceLocation(ExtraDelight.MOD_ID, "block/" + path + suffix),
							models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void frostableBlock(FrostableBlock block, String path, String color) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FrostableBlock.STYLE);

			String suffix = FrostableBlock.Styles.values()[servings] + "_";

			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent(path + "_" + suffix.toLowerCase() + color,
									modLoc("block/double_texture"))
							.texture("0", modLoc(path))
							.texture("1", modLoc("block/frosting_colors/" + suffix.toLowerCase() + color)))
					.build();
		});
	}

	public void stewBlock(RecipeFeastBlock block, String texture) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

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
			boolean dry = state.getValue(CornBottom.DIMENSION);
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
			boolean dry = state.getValue(CornBottom.DIMENSION);
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

	public void cabinetBlock(Block block, String woodType) {
		this.horizontalBlock(block, state -> {
			String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
			return models().orientable(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix,
					new ResourceLocation(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_side"),
					new ResourceLocation(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_front" + suffix),
					new ResourceLocation(ExtraDelight.MOD_ID, "block/" + woodType + "_cabinet_top"));
		});
	}
}
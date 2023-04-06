package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockModels extends BlockStateProvider {

	public BlockModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, ExtraDelight.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		this.horizontalBlock(ExtraDelightBlocks.DOUGH_SHAPING.get(),
				models().getExistingFile(modLoc("block/doughforming")));
		this.simpleBlock(ExtraDelightBlocks.MIXING_BOWL.get(), models().getExistingFile(modLoc("block/mixing_bowl")));

		this.simpleBlock(ExtraDelightBlocks.YEAST_POT.get(), models().getExistingFile(modLoc("block/yeast_pot")));
		this.simpleBlock(ExtraDelightBlocks.VINEGAR_POT.get(), models()
				.withExistingParent("vinegar_pot", modLoc("block/yeast_pot")).texture("0", modLoc("block/vinegarpot")));
		this.simpleBlock(ExtraDelightBlocks.GRATER.get(), models().getExistingFile(modLoc("block/grater")));
		this.simpleBlock(ExtraDelightBlocks.DRYING_RACK.get(), models().getExistingFile(modLoc("block/drying_rack")));

		this.simpleBlock(ExtraDelightBlocks.MORTAR_STONE.get(),
				models().withExistingParent("mortar_stone", modLoc("block/mortar")).texture("0", mcLoc("block/stone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ANDESITE.get(), models()
				.withExistingParent("mortar_andesite", modLoc("block/mortar")).texture("0", mcLoc("block/andesite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GRANITE.get(), models()
				.withExistingParent("mortar_granite", modLoc("block/mortar")).texture("0", mcLoc("block/granite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DIORITE.get(), models()
				.withExistingParent("mortar_diorite", modLoc("block/mortar")).texture("0", mcLoc("block/diorite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DEEPSLATE.get(), models()
				.withExistingParent("mortar_deepslate", modLoc("block/mortar")).texture("0", mcLoc("block/deepslate")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BLACKSTONE.get(),
				models().withExistingParent("mortar_blackstone", modLoc("block/mortar")).texture("0",
						mcLoc("block/blackstone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BASALT.get(), models()
				.withExistingParent("mortar_basalt", modLoc("block/mortar")).texture("0", mcLoc("block/basalt_side")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ENDSTONE.get(), models()
				.withExistingParent("mortar_endstone", modLoc("block/mortar")).texture("0", mcLoc("block/end_stone")));

		this.simpleBlock(ExtraDelightBlocks.MORTAR_AMETHYST.get(),
				models().withExistingParent("mortar_amethyst", modLoc("block/mortar")).texture("0",
						mcLoc("block/amethyst_block"))); // not craftable, dungeon item
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(),
				models().withExistingParent("mortar_gilded_blackstone", modLoc("block/mortar")).texture("0",
						mcLoc("block/gilded_blackstone"))); // not craftable, dungeon item

		this.horizontalBlock(ExtraDelightBlocks.OAK_STEPSTOOL.get(),
				models().withExistingParent("oak_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/oak_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.DARK_OAK_STEPSTOOL.get(),
				models().withExistingParent("dark_oak_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/dark_oak_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.ACACIA_STEPSTOOL.get(),
				models().withExistingParent("acacia_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/acacia_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.BIRCH_STEPSTOOL.get(),
				models().withExistingParent("birch_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/birch_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.CRIMSON_STEPSTOOL.get(),
				models().withExistingParent("crimson_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/crimson_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.JUNGLE_STEPSTOOL.get(),
				models().withExistingParent("jungle_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/jungle_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.SPRUCE_STEPSTOOL.get(),
				models().withExistingParent("spruce_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/spruce_planks")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.WARPED_STEPSTOOL.get(),
				models().withExistingParent("warped_step_stool", modLoc("block/stepstool")).texture("0",
						mcLoc("block/warped_planks")).renderType("cutout"));
		
		this.horizontalBlock(ExtraDelightBlocks.OAK_SPICERACK.get(),
				models().withExistingParent("oak_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/oak_planks")).texture("2", modLoc("block/oak_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.DARK_OAK_SPICERACK.get(),
				models().withExistingParent("dark_oak_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/dark_oak_planks")).texture("2", modLoc("block/dark_oak_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.ACACIA_SPICERACK.get(),
				models().withExistingParent("acacia_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/acacia_planks")).texture("2", modLoc("block/acacia_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.BIRCH_SPICERACK.get(),
				models().withExistingParent("birch_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/birch_planks")).texture("2", modLoc("block/birch_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.CRIMSON_SPICERACK.get(),
				models().withExistingParent("crimson_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/crimson_planks")).texture("2", modLoc("block/crimson_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.JUNGLE_SPICERACK.get(),
				models().withExistingParent("jungle_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/jungle_planks")).texture("2", modLoc("block/jungle_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.SPRUCE_SPICERACK.get(),
				models().withExistingParent("spruce_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/spruce_planks")).texture("2", modLoc("block/spruce_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.WARPED_SPICERACK.get(),
				models().withExistingParent("warped_spice_rack", modLoc("block/spicerack")).texture("0",
						mcLoc("block/warped_planks")).texture("2", modLoc("block/warped_ornate")).renderType("cutout"));
		
		this.horizontalBlock(ExtraDelightBlocks.OAK_SPICERACK_FULL.get(),
				models().withExistingParent("oak_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/oak_planks")).texture("2", modLoc("block/oak_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.DARK_OAK_SPICERACK_FULL.get(),
				models().withExistingParent("dark_oak_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/dark_oak_planks")).texture("2", modLoc("block/dark_oak_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.ACACIA_SPICERACK_FULL.get(),
				models().withExistingParent("acacia_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/acacia_planks")).texture("2", modLoc("block/acacia_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.BIRCH_SPICERACK_FULL.get(),
				models().withExistingParent("birch_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/birch_planks")).texture("2", modLoc("block/birch_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.CRIMSON_SPICERACK_FULL.get(),
				models().withExistingParent("crimson_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/crimson_planks")).texture("2", modLoc("block/crimson_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.JUNGLE_SPICERACK_FULL.get(),
				models().withExistingParent("jungle_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/jungle_planks")).texture("2", modLoc("block/jungle_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.SPRUCE_SPICERACK_FULL.get(),
				models().withExistingParent("spruce_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/spruce_planks")).texture("2", modLoc("block/spruce_ornate")).renderType("cutout"));
		this.horizontalBlock(ExtraDelightBlocks.WARPED_SPICERACK_FULL.get(),
				models().withExistingParent("warped_spice_rack_full", modLoc("block/spicerack_filled")).texture("0",
						mcLoc("block/warped_planks")).texture("2", modLoc("block/warped_ornate")).renderType("cutout"));

		this.simpleBlock(ExtraDelightBlocks.COOKING_OIL.get(), models()
				.withExistingParent("cooking_oil", mcLoc("block/carpet")).texture("wool", modLoc("block/cooking_oil")));

		pieBlock(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), "sweet_berry_pie");
		pieBlock(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), "glow_berry_pie");
		pieBlock(ExtraDelightBlocks.CHEESECAKE.get(), "cheesecake");
		pieBlock(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), "honey_cheesecake");
		pieBlock(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), "chocolate_cheesecake");
		pieBlock(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), "pumpkin_cheesecake");
		pieBlock(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), "glow_berry_cheesecake");

		pieBlock(ExtraDelightBlocks.QUICHE.get(), "quiche");

		createCakeBlock(ExtraDelightBlocks.PLAIN_CAKE.get(), "plain");

		this.feastBlock(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get());
		this.feastBlock(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get());
		this.simpleBlock(ExtraDelightBlocks.CHEESE_BLOCK.get());
		this.simpleBlock(ExtraDelightBlocks.BUTTER_BLOCK.get());

		this.feastBlock(ExtraDelightBlocks.HASH_FEAST.get());
		this.feastBlock(ExtraDelightBlocks.POT_ROAST_FEAST.get());

		this.feastBlock(ExtraDelightBlocks.BBQ_RIBS_FEAST.get());
		this.feastBlock(ExtraDelightBlocks.PULLED_PORK_FEAST.get());

		this.feastBlock(ExtraDelightBlocks.RACK_LAMB.get());
		this.feastBlock(ExtraDelightBlocks.STIRFRY.get());
		this.feastBlock(ExtraDelightBlocks.BEEF_WELLINGTON.get());
		this.feastBlock(ExtraDelightBlocks.HAGGIS.get());
		this.feastBlock(ExtraDelightBlocks.MACARONI_CHEESE.get());
		this.feastBlock(ExtraDelightBlocks.HOTDISH.get());
		this.feastBlock(ExtraDelightBlocks.LASAGNA.get());

		this.feastBlock(ExtraDelightBlocks.CURRY.get());
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
	}

	public void jellyBlock(FeastBlock block, String color) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			ModelFile jellyModel = models()
					.withExistingParent("jelly_" + color + "_block" + suffix, modLoc("block/jelly_block" + suffix))
					.texture("1", new ResourceLocation(ExtraDelight.MOD_ID, "block/jelly_" + color))
					.renderType("translucent");

			return ConfiguredModel.builder().modelFile(jellyModel)
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	private void createCakeBlock(Block block, String prefix) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(BlockStateProperties.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(models()
					.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath() + suffix,
							mcLoc("block/cake" + suffix))
					.texture("particle", modLoc("block/" + prefix + "_cake_top"))
					.texture("bottom", modLoc("block/" + prefix + "_cake_bottom"))
					.texture("side", modLoc("block/" + prefix + "_cake_side"))
					.texture("top", modLoc("block/" + prefix + "_cake_top"))
					.texture("inside", modLoc("block/" + prefix + "_cake_inner"))).build();
		});
	}

	public void pieBlock(Block block, String prefix) {
		getVariantBuilder(block).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(models()
							.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath() + suffix,
									modLoc("block/pie" + suffix))
							.texture("particle", modLoc("block/" + prefix + "_top"))
//					.texture("bottom", "farmersdelight:block/pie_bottom")
//					.texture("side", "farmersdelight:block/pie_side")
							.texture("top", modLoc("block/" + prefix + "_top"))
							.texture("inner", modLoc("block/" + prefix + "_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public void feastBlock(FeastBlock block) {
		feastBlock(block, ForgeRegistries.BLOCKS.getKey(block).getPath());
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

	public void stewBlock(FeastBlock block, String texture) {
		getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(models().withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath() + suffix,
							modLoc("curry_block" + suffix)).texture("1", modLoc("block/" + texture)))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}
}
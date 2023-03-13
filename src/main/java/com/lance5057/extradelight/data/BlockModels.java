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
		this.simpleBlock(ExtraDelightBlocks.GRATER.get(), models().getExistingFile(modLoc("block/grater")));

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
}
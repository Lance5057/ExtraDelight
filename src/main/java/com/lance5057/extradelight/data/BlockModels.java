package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
		
		this.simpleBlock(ExtraDelightBlocks.MORTAR_STONE.get(), models().singleTexture("mortar_stone", modLoc("block/mortar"), mcLoc("block/stone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ANDESITE.get(), models().singleTexture("mortar_andesite", modLoc("block/mortar"), mcLoc("block/andesite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GRANITE.get(), models().singleTexture("mortar_granite", modLoc("block/mortar"), mcLoc("block/granite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DIORITE.get(), models().singleTexture("mortar_diorite", modLoc("block/mortar"), mcLoc("block/diorite")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_DEEPSLATE.get(), models().singleTexture("mortar_deepslate", modLoc("block/mortar"), mcLoc("block/deepslate")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BLACKSTONE.get(), models().singleTexture("mortar_blackstone", modLoc("block/mortar"), mcLoc("block/blackstone")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_BASALT.get(), models().singleTexture("mortar_basalt", modLoc("block/mortar"), mcLoc("block/basalt_side")));
		this.simpleBlock(ExtraDelightBlocks.MORTAR_ENDSTONE.get(), models().singleTexture("mortar_endstone", modLoc("block/mortar"), mcLoc("block/end_stone")));
		
		this.simpleBlock(ExtraDelightBlocks.MORTAR_AMETHYST.get(), models().singleTexture("mortar_amethyst", modLoc("block/mortar"), mcLoc("block/amethyst_block"))); //not craftable, dungeon item
		this.simpleBlock(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(), models().singleTexture("mortar_gilded_blackstone", modLoc("block/mortar"), mcLoc("block/gilded_blackstone"))); //not craftable, dungeon item	
	}
}
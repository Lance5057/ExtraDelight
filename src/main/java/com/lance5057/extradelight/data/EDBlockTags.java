package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.tag.ModTags;

public class EDBlockTags extends BlockTagsProvider {
	public EDBlockTags(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
		super(generator, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.registerBlockMineableTags();
	}

	protected void registerBlockMineableTags() {

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
				ExtraDelightBlocks.MORTAR_ANDESITE.get(), ExtraDelightBlocks.MORTAR_GRANITE.get(),
				ExtraDelightBlocks.MORTAR_DIORITE.get(), ExtraDelightBlocks.MORTAR_DEEPSLATE.get(),
				ExtraDelightBlocks.MORTAR_BLACKSTONE.get(), ExtraDelightBlocks.MORTAR_BASALT.get(),
				ExtraDelightBlocks.MORTAR_ENDSTONE.get(), ExtraDelightBlocks.MORTAR_AMETHYST.get(),
				ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(),

				// Feasts in pans
				ExtraDelightBlocks.LASAGNA.get(), ExtraDelightBlocks.HOTDISH.get(),

				// Feasts in pots
				ExtraDelightBlocks.MACARONI_CHEESE.get(), ExtraDelightBlocks.CURRY.get(),
				ExtraDelightBlocks.BEEF_STEW.get(), ExtraDelightBlocks.PORK_STEW.get(),
				ExtraDelightBlocks.LAMB_STEW.get(), ExtraDelightBlocks.RABBIT_STEW.get(),
				ExtraDelightBlocks.CHICKEN_STEW.get(), ExtraDelightBlocks.FISH_STEW.get());

//		tag(BlockTags.SMALL_FLOWERS).add(ExtraDelightBlocks.MINT_CROP.get());

		tag(ModTags.MINEABLE_WITH_KNIFE).add(
				// Pies and plain cake
				ExtraDelightBlocks.SWEET_BERRY_PIE.get(), ExtraDelightBlocks.GLOW_BERRY_PIE.get(),
				ExtraDelightBlocks.CHEESECAKE.get(), ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
				ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
				ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), ExtraDelightBlocks.PLAIN_CAKE.get(), // This may cause
																										// issues as it
																										// doesn't exist
																										// ingame
				ExtraDelightBlocks.QUICHE.get(), ExtraDelightBlocks.MEAT_PIE_BLOCK.get(),

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

	}

	protected void makeMineableWithAxe(RegistryObject<Block> blockRegistryObject) {
		tag(BlockTags.MINEABLE_WITH_AXE).add(blockRegistryObject.get());
	}

	protected void makeMineableWithHoe(RegistryObject<Block> blockRegistryObject) {
		tag(BlockTags.MINEABLE_WITH_HOE).add(blockRegistryObject.get());
	}

	protected void makeMineableWithPickaxe(RegistryObject<Block> blockRegistryObject) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject.get());
	}

	protected void makeMineableWithShovel(RegistryObject<Block> blockRegistryObject) {
		tag(BlockTags.MINEABLE_WITH_AXE).add(blockRegistryObject.get());
	}

	protected void makeMineableWithKnife(RegistryObject<Block> blockRegistryObject) {
		tag(ModTags.MINEABLE_WITH_KNIFE).add(blockRegistryObject.get());
	}

	protected void makeFence(RegistryObject<Block> blockRegistryObject) {
		tag(BlockTags.FENCES).add(blockRegistryObject.get());
	}

}

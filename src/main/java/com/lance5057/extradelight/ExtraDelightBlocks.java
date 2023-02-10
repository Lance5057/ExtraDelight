package com.lance5057.extradelight;

import com.lance5057.extradelight.blocks.FoodDisplayBlock;
import com.lance5057.extradelight.blocks.YeastPotBlock;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingBlock;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;
import com.lance5057.extradelight.workstations.oven.OvenBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);

	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", OvenBlock::new);
	public static final RegistryObject<Block> FOOD_DISPLAY = BLOCKS.register("food_display",
			() -> new FoodDisplayBlock(0, 9));
	public static final RegistryObject<Block> DOUGH_SHAPING = BLOCKS.register("dough_shaping", DoughShapingBlock::new);
	public static final RegistryObject<Block> MIXING_BOWL = BLOCKS.register("mixing_bowl", MixingBowlBlock::new);

	public static final RegistryObject<Block> YEAST_POT = BLOCKS.register("yeast_pot", YeastPotBlock::new);
	
	public static final RegistryObject<Block> MORTAR_STONE = BLOCKS.register("mortar_stone", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_ANDESITE = BLOCKS.register("mortar_andesite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_GRANITE = BLOCKS.register("mortar_granite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_DIORITE = BLOCKS.register("mortar_diorite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_DEEPSLATE = BLOCKS.register("mortar_deepslate", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_BLACKSTONE = BLOCKS.register("mortar_blackstone", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_BASALT = BLOCKS.register("mortar_basalt", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_ENDSTONE = BLOCKS.register("mortar_endstone", MortarBlock::new);
	
	public static final RegistryObject<Block> MORTAR_AMETHYST = BLOCKS.register("mortar_amethyst", MortarBlock::new); //not craftable, dungeon item
	public static final RegistryObject<Block> MORTAR_GILDED_BLACKSTONE = BLOCKS.register("mortar_gilded_blackstone", MortarBlock::new); //not craftable, dungeon item	
}

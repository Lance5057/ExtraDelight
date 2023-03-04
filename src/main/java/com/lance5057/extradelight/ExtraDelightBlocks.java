package com.lance5057.extradelight;

import com.lance5057.extradelight.blocks.FoodDisplayBlock;
import com.lance5057.extradelight.blocks.YeastPotBlock;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingBlock;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;
import com.lance5057.extradelight.workstations.oven.OvenBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

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
	public static final RegistryObject<Block> MORTAR_BLACKSTONE = BLOCKS.register("mortar_blackstone",
			MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_BASALT = BLOCKS.register("mortar_basalt", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_ENDSTONE = BLOCKS.register("mortar_endstone", MortarBlock::new);

	public static final RegistryObject<Block> MORTAR_AMETHYST = BLOCKS.register("mortar_amethyst", MortarBlock::new); // not
																														// craftable,
																														// dungeon
																														// item
	public static final RegistryObject<Block> MORTAR_GILDED_BLACKSTONE = BLOCKS.register("mortar_gilded_blackstone",
			MortarBlock::new); // not craftable, dungeon item

	public static final RegistryObject<Block> FLOUR = BLOCKS.register("flour", () -> new CarpetBlock(
			Properties.of(Material.MOSS).strength(0.1F, 0.0F).sound(SoundType.WOOL).noOcclusion()));
	public static final RegistryObject<Block> COOKING_OIL = BLOCKS.register("cooking_oil",
			() -> new CarpetBlock(Properties.of(Material.WATER).strength(0.1F, 0.0F).sound(SoundType.SLIME_BLOCK)
					.noOcclusion().friction(0.98f)));

	public static final RegistryObject<Block> SWEET_BERRY_PIE = ExtraDelightBlocks.BLOCKS.register("sweet_berry_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.SWEET_BERRY_PIE_SLICE));
	public static final RegistryObject<Block> GLOW_BERRY_PIE = ExtraDelightBlocks.BLOCKS.register("glow_berry_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.GLOW_BERRY_PIE_SLICE));
	public static final RegistryObject<Block> CHEESECAKE = ExtraDelightBlocks.BLOCKS.register("cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.CHEESECAKE_SLICE));
	public static final RegistryObject<Block> HONEY_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register("honey_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.HONEY_CHEESECAKE_SLICE));
	public static final RegistryObject<Block> CHOCOLATE_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
			"chocolate_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE));
	public static final RegistryObject<Block> PUMPKIN_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
			"pumpkin_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE));
	public static final RegistryObject<Block> GLOW_BERRY_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
			"glow_berry_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE));

	public static final RegistryObject<Block> PLAIN_CAKE = ExtraDelightBlocks.BLOCKS.register("plain_cake",
			() -> new CakeBlock(Block.Properties.copy(Blocks.CAKE)));

	public static final RegistryObject<Block> QUICHE = ExtraDelightBlocks.BLOCKS.register("quiche",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.QUICHE_SLICE));
}

package com.lance5057.extradelight;

import com.lance5057.extradelight.blocks.BbqRibsBlock;
import com.lance5057.extradelight.blocks.GraterBlock;
import com.lance5057.extradelight.blocks.HashBowlBlock;
import com.lance5057.extradelight.blocks.JellyBlock;
import com.lance5057.extradelight.blocks.PotRoastBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.SalisburySteakBlock;
import com.lance5057.extradelight.blocks.YeastPotBlock;
import com.lance5057.extradelight.displays.food.FoodDisplayBlock;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingBlock;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackBlock;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;
import com.lance5057.extradelight.workstations.oven.OvenBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ExtraDelightBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);

	public static void register(IEventBus modEventBus) {
//		AestheticBlocks.BLOCKS.register(modEventBus);
		BLOCKS.register(modEventBus);
	}

	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", OvenBlock::new);
	public static final RegistryObject<DryingRackBlock> DRYING_RACK = BLOCKS.register("drying_rack",
			DryingRackBlock::new);
	public static final RegistryObject<Block> FOOD_DISPLAY = BLOCKS.register("food_display",
			() -> new FoodDisplayBlock());
	public static final RegistryObject<Block> DOUGH_SHAPING = BLOCKS.register("dough_shaping", DoughShapingBlock::new);
	public static final RegistryObject<Block> MIXING_BOWL = BLOCKS.register("mixing_bowl", MixingBowlBlock::new);

	public static final RegistryObject<Block> YEAST_POT = BLOCKS.register("yeast_pot",
			() -> new YeastPotBlock(ExtraDelightItems.YEAST, 4));
	public static final RegistryObject<Block> VINEGAR_POT = BLOCKS.register("vinegar_pot",
			() -> new YeastPotBlock(ExtraDelightItems.VINEGAR, 8));
	public static final RegistryObject<Block> GRATER = BLOCKS.register("grater", GraterBlock::new);

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

	// Feasts
	public static final RegistryObject<SalisburySteakBlock> SALISBURY_STEAK_FEAST = BLOCKS.register(
			"salisbury_steak_block",
			() -> new SalisburySteakBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.SALISBURY_STEAK, true));
	public static final RegistryObject<SalisburySteakBlock> MASHED_POTATO_GRAVY = BLOCKS.register(
			"mashed_potato_gravy_block",
			() -> new SalisburySteakBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.MASHED_POTATO_GRAVY, true));

	public static final RegistryObject<HashBowlBlock> HASH_FEAST = BLOCKS.register("hash_block",
			() -> new HashBowlBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.HASH, true));
	public static final RegistryObject<PotRoastBlock> POT_ROAST_FEAST = BLOCKS.register("potroast_block",
			() -> new PotRoastBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.POT_ROAST, true));

	public static final RegistryObject<RecipeFeastBlock> MEATLOAF_FEAST = BLOCKS.register("meatloaf_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN), true,
					Block.box(1.0D, 0.0D, 1.0D, 14.0D, 2.0D, 14.0D), Block.box(2.0D, 2.0D, 2.0D, 14.0D, 8.0D, 14.0D)));

	public static final RegistryObject<BbqRibsBlock> BBQ_RIBS_FEAST = BLOCKS.register("bbq_ribs_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.BBQ_RIBS, true));
	public static final RegistryObject<BbqRibsBlock> PULLED_PORK_FEAST = BLOCKS.register("pulled_pork_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.PULLED_PORK_SANDWICH, true));

	public static final RegistryObject<BbqRibsBlock> RACK_LAMB = BLOCKS.register("rack_lamb_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.RACK_LAMB, true));
	public static final RegistryObject<BbqRibsBlock> STIRFRY = BLOCKS.register("stirfry_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.STIRFRY, true));
	public static final RegistryObject<BbqRibsBlock> BEEF_WELLINGTON = BLOCKS.register("beef_wellington_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.BEEF_WELLINGTON, true));
	public static final RegistryObject<BbqRibsBlock> HAGGIS = BLOCKS.register("haggis_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.HAGGIS, true));

	public static final RegistryObject<JellyBlock> JELLY_WHITE = BLOCKS.register("jelly_white_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE),
					ExtraDelightItems.JELLY_WHITE, true));
	public static final RegistryObject<JellyBlock> JELLY_ORANGE = BLOCKS.register("jelly_orange_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_ORANGE),
					ExtraDelightItems.JELLY_ORANGE, true));
	public static final RegistryObject<JellyBlock> JELLY_MAGENTA = BLOCKS.register("jelly_magenta_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_MAGENTA),
					ExtraDelightItems.JELLY_MAGENTA, true));
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_BLUE = BLOCKS.register("jelly_light_blue_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_BLUE),
					ExtraDelightItems.JELLY_LIGHT_BLUE, true));
	public static final RegistryObject<JellyBlock> JELLY_YELLOW = BLOCKS.register("jelly_yellow_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_YELLOW),
					ExtraDelightItems.JELLY_YELLOW, true));
	public static final RegistryObject<JellyBlock> JELLY_LIME = BLOCKS.register("jelly_lime_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_GREEN),
					ExtraDelightItems.JELLY_LIME, true));
	public static final RegistryObject<JellyBlock> JELLY_PINK = BLOCKS.register("jelly_pink_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_PINK),
					ExtraDelightItems.JELLY_PINK, true));
	public static final RegistryObject<JellyBlock> JELLY_GREY = BLOCKS.register("jelly_grey_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_GRAY),
					ExtraDelightItems.JELLY_GREY, true));
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_GREY = BLOCKS.register("jelly_light_grey_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_LIGHT_GRAY),
					ExtraDelightItems.JELLY_LIGHT_GREY, true));
	public static final RegistryObject<JellyBlock> JELLY_CYAN = BLOCKS.register("jelly_cyan_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_CYAN),
					ExtraDelightItems.JELLY_CYAN, true));
	public static final RegistryObject<JellyBlock> JELLY_PURPLE = BLOCKS.register("jelly_purple_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_PURPLE),
					ExtraDelightItems.JELLY_PURPLE, true));
	public static final RegistryObject<JellyBlock> JELLY_BLUE = BLOCKS.register("jelly_blue_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BLUE),
					ExtraDelightItems.JELLY_BLUE, true));
	public static final RegistryObject<JellyBlock> JELLY_BROWN = BLOCKS.register("jelly_brown_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BROWN),
					ExtraDelightItems.JELLY_BROWN, true));
	public static final RegistryObject<JellyBlock> JELLY_GREEN = BLOCKS.register("jelly_green_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_GREEN),
					ExtraDelightItems.JELLY_GREEN, true));
	public static final RegistryObject<JellyBlock> JELLY_RED = BLOCKS.register("jelly_red_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_RED),
					ExtraDelightItems.JELLY_RED, true));
	public static final RegistryObject<JellyBlock> JELLY_BLACK = BLOCKS.register("jelly_black_block",
			() -> new JellyBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_BLACK),
					ExtraDelightItems.JELLY_BLACK, true));

	public static final RegistryObject<PieBlock> MEAT_PIE_BLOCK = BLOCKS.register("meat_pie",
			() -> new PieBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN),
					ExtraDelightItems.MEAT_PIE_SLICE));

	public static final RegistryObject<Block> CHEESE_BLOCK = BLOCKS.register("cheese_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_ORANGE).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> BUTTER_BLOCK = BLOCKS.register("butter_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.COLOR_YELLOW).friction(0.98F)
					.sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<BbqRibsBlock> MACARONI_CHEESE = BLOCKS.register("macaroni_cheese_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW),
					ExtraDelightItems.MACARONI_CHEESE, true));
	public static final RegistryObject<BbqRibsBlock> LASAGNA = BLOCKS.register("lasagna_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW),
					ExtraDelightItems.LASAGNA, true));
	public static final RegistryObject<BbqRibsBlock> HOTDISH = BLOCKS.register("hotdish_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW),
					ExtraDelightItems.HOTDISH, true));

	// Stew
	public static final RegistryObject<RecipeFeastBlock> CURRY = BLOCKS.register("curry_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE), true,
					Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)));
	public static final RegistryObject<RecipeFeastBlock> BEEF_STEW = BLOCKS.register("beef_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)));
	public static final RegistryObject<RecipeFeastBlock> PORK_STEW = BLOCKS.register("pork_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)));
	public static final RegistryObject<RecipeFeastBlock> LAMB_STEW = BLOCKS.register("lamb_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)));
	public static final RegistryObject<RecipeFeastBlock> RABBIT_STEW = BLOCKS.register("rabbit_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)));
	public static final RegistryObject<RecipeFeastBlock> CHICKEN_STEW = BLOCKS.register("chicken_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(1.0D, 0.0D, 1.0D, 14.0D, 2.0D, 14.0D)));
	public static final RegistryObject<RecipeFeastBlock> FISH_STEW = BLOCKS.register("fish_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN), true,
					Block.box(1.0D, 0.0D, 1.0D, 14.0D, 2.0D, 14.0D)));

	public static final RegistryObject<BbqRibsBlock> SALAD = BLOCKS.register("salad_block",
			() -> new BbqRibsBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN),
					ExtraDelightItems.SALAD, true));
}

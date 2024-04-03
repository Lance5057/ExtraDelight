package com.lance5057.extradelight;

import com.lance5057.extradelight.blocks.FrostableBlock;
import com.lance5057.extradelight.blocks.JellyBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.StrippableLog;
import com.lance5057.extradelight.blocks.YeastPotBlock;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.MintCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;
import com.lance5057.extradelight.data.MiscLootTables;
import com.lance5057.extradelight.displays.candybowl.CandyBowlBlock;
import com.lance5057.extradelight.displays.food.FoodDisplayBlock;
import com.lance5057.extradelight.workstations.doughshaping.DoughShapingBlock;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackBlock;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlock;
import com.lance5057.extradelight.workstations.mortar.MortarBlock;
import com.lance5057.extradelight.workstations.oven.OvenBlock;
import com.lance5057.extradelight.worldgen.features.CinnamonTreeGrower;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class ExtraDelightBlocks {

	public final static VoxelShape bowl = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D);
	public final static VoxelShape plate = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	public final static VoxelShape pan = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D);
	public final static VoxelShape pot = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D);

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);

	public static void register(IEventBus modEventBus) {
//		AestheticBlocks.BLOCKS.register(modEventBus);
		BLOCKS.register(modEventBus);
	}

	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", OvenBlock::new);
	public static final RegistryObject<DryingRackBlock> DRYING_RACK = BLOCKS.register("drying_rack",
			DryingRackBlock::new);
	public static final RegistryObject<Block> FOOD_DISPLAY = BLOCKS.register("food_display", FoodDisplayBlock::new);
	public static final RegistryObject<Block> DOUGH_SHAPING = BLOCKS.register("dough_shaping", DoughShapingBlock::new);
	public static final RegistryObject<Block> MIXING_BOWL = BLOCKS.register("mixing_bowl", MixingBowlBlock::new);

	public static final RegistryObject<Block> YEAST_POT = BLOCKS.register("yeast_pot",
			() -> new YeastPotBlock(ExtraDelightItems.YEAST, 4));
	public static final RegistryObject<Block> VINEGAR_POT = BLOCKS.register("vinegar_pot",
			() -> new YeastPotBlock(ExtraDelightItems.VINEGAR, 8));
	// public static final RegistryObject<Block> GRATER = BLOCKS.register("grater",
	// GraterBlock::new);

	public static final RegistryObject<Block> MORTAR_STONE = BLOCKS.register("mortar_stone", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_ANDESITE = BLOCKS.register("mortar_andesite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_GRANITE = BLOCKS.register("mortar_granite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_DIORITE = BLOCKS.register("mortar_diorite", MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_DEEPSLATE = BLOCKS.register("mortar_deepslate",
			() -> new MortarBlock(SoundType.DEEPSLATE));
	public static final RegistryObject<Block> MORTAR_BLACKSTONE = BLOCKS.register("mortar_blackstone",
			MortarBlock::new);
	public static final RegistryObject<Block> MORTAR_BASALT = BLOCKS.register("mortar_basalt",
			() -> new MortarBlock(SoundType.BASALT));
	public static final RegistryObject<Block> MORTAR_ENDSTONE = BLOCKS.register("mortar_endstone", MortarBlock::new);

	// not craftable, dungeon items
	public static final RegistryObject<Block> MORTAR_AMETHYST = BLOCKS.register("mortar_amethyst",
			() -> new MortarBlock(SoundType.AMETHYST));
	public static final RegistryObject<Block> MORTAR_GILDED_BLACKSTONE = BLOCKS.register("mortar_gilded_blackstone",
			() -> new MortarBlock(SoundType.GILDED_BLACKSTONE));

	public static final RegistryObject<Block> FLOUR = BLOCKS.register("flour", () -> new CarpetBlock(
			Properties.of(Material.MOSS).strength(0.1F, 0.0F).sound(SoundType.WOOL).noOcclusion()));
	public static final RegistryObject<Block> COOKING_OIL = BLOCKS.register("cooking_oil",
			() -> new CarpetBlock(Properties.of(Material.WATER).strength(0.1F, 0.0F).sound(SoundType.SLIME_BLOCK)
					.noOcclusion().friction(0.98f)));
	public static final RegistryObject<Block> BREADCRUMBS = BLOCKS.register("breadcrumbs", () -> new CarpetBlock(
			Properties.of(Material.MOSS).strength(0.1F, 0.0F).sound(SoundType.WOOL).noOcclusion()));
	public static final RegistryObject<Block> CORNMEAL = BLOCKS.register("cornmeal", () -> new CarpetBlock(
			Properties.of(Material.MOSS).strength(0.1F, 0.0F).sound(SoundType.WOOL).noOcclusion()));
	
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
	public static final RegistryObject<RecipeFeastBlock> SALISBURY_STEAK_FEAST = BLOCKS.register(
			"salisbury_steak_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					bowl));
	public static final RegistryObject<RecipeFeastBlock> MASHED_POTATO_GRAVY = BLOCKS.register(
			"mashed_potato_gravy_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					bowl));

	public static final RegistryObject<RecipeFeastBlock> HASH_FEAST = BLOCKS.register("hash_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					bowl));
	public static final RegistryObject<RecipeFeastBlock> POT_ROAST_FEAST = BLOCKS.register("potroast_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(5.0D, 2.0D, 2.0D, 11.0D, 8.0D, 14.0D),
					Block.box(2.0D, 2.0D, 5.0D, 14.0D, 8.0D, 11.0D)));

	public static final RegistryObject<RecipeFeastBlock> MEATLOAF_FEAST = BLOCKS.register("meatloaf_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(5.0D, 2.0D, 3.0D, 11.0D, 8.0D, 13.0D),
					Block.box(3.0D, 2.0D, 5.0D, 13.0D, 8.0D, 11.0D)));

	public static final RegistryObject<RecipeFeastBlock> BBQ_RIBS_FEAST = BLOCKS.register("bbq_ribs_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 6.0D, 14.0D)));
	public static final RegistryObject<RecipeFeastBlock> PULLED_PORK_FEAST = BLOCKS.register("pulled_pork_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					bowl));

	public static final RegistryObject<RecipeFeastBlock> RACK_LAMB = BLOCKS.register("rack_lamb_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(3.0D, 2.0D, 3.0D, 13.0D, 8.0D, 12.0D)));
	public static final RegistryObject<RecipeFeastBlock> STIRFRY = BLOCKS.register("stirfry_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					bowl));
	public static final RegistryObject<RecipeFeastBlock> BEEF_WELLINGTON = BLOCKS.register("beef_wellington_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(4.5D, 2.0D, 2.0D, 11.5D, 9.0D, 14.0D),
					Block.box(2.0D, 2.0D, 4.5D, 14.0D, 9.0D, 11.5D)));
	public static final RegistryObject<RecipeFeastBlock> HAGGIS = BLOCKS.register("haggis_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					plate, Block.box(4.0D, 2.0D, 4.0D, 12.0D, 10.0D, 12.0D)));

	public static final RegistryObject<JellyBlock> JELLY_WHITE = BLOCKS.register("jelly_white_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_WHITE),
					ExtraDelightItems.JELLY_WHITE::get, true));
	public static final RegistryObject<JellyBlock> JELLY_ORANGE = BLOCKS.register("jelly_orange_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_ORANGE),
					ExtraDelightItems.JELLY_ORANGE::get, true));
	public static final RegistryObject<JellyBlock> JELLY_MAGENTA = BLOCKS.register("jelly_magenta_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_MAGENTA),
					ExtraDelightItems.JELLY_MAGENTA::get, true));
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_BLUE = BLOCKS.register("jelly_light_blue_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_LIGHT_BLUE),
					ExtraDelightItems.JELLY_LIGHT_BLUE::get, true));
	public static final RegistryObject<JellyBlock> JELLY_YELLOW = BLOCKS.register("jelly_yellow_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_YELLOW),
					ExtraDelightItems.JELLY_YELLOW::get, true));
	public static final RegistryObject<JellyBlock> JELLY_LIME = BLOCKS.register("jelly_lime_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_LIGHT_GREEN),
					ExtraDelightItems.JELLY_LIME::get, true));
	public static final RegistryObject<JellyBlock> JELLY_PINK = BLOCKS.register("jelly_pink_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_PINK),
					ExtraDelightItems.JELLY_PINK::get, true));
	public static final RegistryObject<JellyBlock> JELLY_GREY = BLOCKS.register("jelly_grey_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_GRAY),
					ExtraDelightItems.JELLY_GREY::get, true));
	public static final RegistryObject<JellyBlock> JELLY_LIGHT_GREY = BLOCKS.register("jelly_light_grey_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_LIGHT_GRAY),
					ExtraDelightItems.JELLY_LIGHT_GREY::get, true));
	public static final RegistryObject<JellyBlock> JELLY_CYAN = BLOCKS.register("jelly_cyan_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_CYAN),
					ExtraDelightItems.JELLY_CYAN::get, true));
	public static final RegistryObject<JellyBlock> JELLY_PURPLE = BLOCKS.register("jelly_purple_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_PURPLE),
					ExtraDelightItems.JELLY_PURPLE::get, true));
	public static final RegistryObject<JellyBlock> JELLY_BLUE = BLOCKS.register("jelly_blue_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_BLUE),
					ExtraDelightItems.JELLY_BLUE::get, true));
	public static final RegistryObject<JellyBlock> JELLY_BROWN = BLOCKS.register("jelly_brown_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_BROWN),
					ExtraDelightItems.JELLY_BROWN::get, true));
	public static final RegistryObject<JellyBlock> JELLY_GREEN = BLOCKS.register("jelly_green_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_GREEN),
					ExtraDelightItems.JELLY_GREEN::get, true));
	public static final RegistryObject<JellyBlock> JELLY_RED = BLOCKS.register("jelly_red_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_RED),
					ExtraDelightItems.JELLY_RED::get, true));
	public static final RegistryObject<JellyBlock> JELLY_BLACK = BLOCKS.register("jelly_black_block",
			() -> new JellyBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.TERRACOTTA_BLACK),
					ExtraDelightItems.JELLY_BLACK::get, true));

	// Used to use:
	// BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN)
	public static final RegistryObject<PieBlock> MEAT_PIE_BLOCK = BLOCKS.register("meat_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE).color(MaterialColor.COLOR_BROWN),
					ExtraDelightItems.MEAT_PIE_SLICE));

	public static final RegistryObject<Block> CHEESE_BLOCK = BLOCKS.register("cheese_block", () -> new Block(
			BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_ORANGE).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<StairBlock> CHEESE_STAIRS_BLOCK = BLOCKS.register("cheese_stairs_block",
			() -> new StairBlock(() -> CHEESE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_ORANGE).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<SlabBlock> CHEESE_SLAB_BLOCK = BLOCKS.register("cheese_slab_block",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_ORANGE)
					.sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<Block> BUTTER_BLOCK = BLOCKS.register("butter_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.COLOR_YELLOW).friction(0.98F)
					.sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<StairBlock> BUTTER_STAIRS_BLOCK = BLOCKS.register("butter_stairs_block",
			() -> new StairBlock(() -> CHEESE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_YELLOW).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<SlabBlock> BUTTER_SLAB_BLOCK = BLOCKS.register("butter_slab_block",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_YELLOW)
					.sound(SoundType.SLIME_BLOCK)));

	public static final RegistryObject<RecipeFeastBlock> MACARONI_CHEESE = BLOCKS.register("macaroni_cheese_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_YELLOW), true, pot));
	public static final RegistryObject<RecipeFeastBlock> LASAGNA = BLOCKS.register("lasagna_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_YELLOW), true, pan));
	public static final RegistryObject<RecipeFeastBlock> HOTDISH = BLOCKS.register("hotdish_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_YELLOW), true, pan));

	// Stew
	public static final RegistryObject<RecipeFeastBlock> CURRY = BLOCKS.register("curry_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_ORANGE), true, pot));
	public static final RegistryObject<RecipeFeastBlock> BEEF_STEW = BLOCKS.register("beef_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));
	public static final RegistryObject<RecipeFeastBlock> PORK_STEW = BLOCKS.register("pork_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));
	public static final RegistryObject<RecipeFeastBlock> LAMB_STEW = BLOCKS.register("lamb_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));
	public static final RegistryObject<RecipeFeastBlock> RABBIT_STEW = BLOCKS.register("rabbit_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));
	public static final RegistryObject<RecipeFeastBlock> CHICKEN_STEW = BLOCKS.register("chicken_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));
	public static final RegistryObject<RecipeFeastBlock> FISH_STEW = BLOCKS.register("fish_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, pot));

	public static final RegistryObject<RecipeFeastBlock> SALAD = BLOCKS.register("salad_block",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_GREEN), true,
					bowl));

//Halloween Start
	public static final RegistryObject<CornBottom> CORN_BOTTOM = BLOCKS.register("corn_bottom",
			() -> new CornBottom(Block.Properties.copy(Blocks.WHEAT).color(MaterialColor.COLOR_GREEN)
					.offsetType(BlockBehaviour.OffsetType.XZ)));
	public static final RegistryObject<CornTop> CORN_TOP = BLOCKS.register("corn_top",
			() -> new CornTop(Block.Properties.copy(Blocks.WHEAT).color(MaterialColor.COLOR_GREEN)
					.offsetType(BlockBehaviour.OffsetType.XZ)));

	public static final RegistryObject<RecipeFeastBlock> CORNBREAD = BLOCKS.register("cornbread",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_YELLOW), true,
					bowl));

	public static final RegistryObject<Block> CARAMEL_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
			"caramel_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE));

	public static final RegistryObject<Block> PUMPKIN_PIE = ExtraDelightBlocks.BLOCKS.register("pumpkin_pie",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.PUMPKIN_PIE_SLICE));

	public static final RegistryObject<RecipeFeastBlock> CORN_PUDDING = BLOCKS.register("corn_pudding",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_YELLOW), true,
					pan));

	public static final RegistryObject<PieBlock> PUMPKIN_ROLL = BLOCKS.register("pumpkin_roll",
			() -> new PieBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN),
					ExtraDelightItems.PUMPKIN_ROLL));

	public static final RegistryObject<RecipeFeastBlock> APPLE_CRISP = BLOCKS.register("apple_crisp",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), false,
					pan));

	public static final RegistryObject<RecipeFeastBlock> STUFFING = BLOCKS.register("stuffing",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), false,
					pot));

	public static final RegistryObject<RecipeFeastBlock> POTATO_AU_GRATIN = BLOCKS.register("potato_au_gratin",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), false,
					pan));

	public static final RegistryObject<Block> FLOUR_SACK = BLOCKS.register("flour_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CORNMEAL_SACK = BLOCKS.register("cornmeal_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> SUGAR_SACK = BLOCKS.register("sugar_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CORN_SACK = BLOCKS.register("corn_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CORN_SILK_SACK = BLOCKS.register("corn_silk_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> CORN_CRATE = BLOCKS.register("corn_crate", () -> new Block(
			Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<HayBlock> CORN_HUSK_BUNDLE = BLOCKS.register("corn_husk_bundle",
			() -> new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK).color(MaterialColor.TERRACOTTA_LIGHT_GREEN)));
	public static final RegistryObject<HayBlock> DRIED_CORN_HUSK_BUNDLE = BLOCKS.register("dried_corn_husk_bundle",
			() -> new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK).color(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<HayBlock> CORN_COB_BUNDLE = BLOCKS.register("corn_cob_bundle",
			() -> new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK).color(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<Block> BREADCRUMB_SACK = BLOCKS.register("breadcrumb_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> EGG_CRATE = BLOCKS.register("egg_crate", () -> new Block(
			Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.TERRACOTTA_YELLOW)));
	public static final RegistryObject<Block> APPLE_CRATE = BLOCKS.register("apple_crate",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_RED)));

	// Winter start!
	public static final RegistryObject<SaplingBlock> CINNAMON_SAPLING = BLOCKS.register("cinnamon_sapling",
			() -> new SaplingBlock(new CinnamonTreeGrower(), Block.Properties.copy(Blocks.DARK_OAK_SAPLING)));
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CINNAMON_LOG = BLOCKS
			.register("stripped_cinnamon_log", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.ACACIA_LOG)));
	public static final RegistryObject<StrippableLog> CINNAMON_LOG = BLOCKS.register("cinnamon_log",
			() -> new StrippableLog(STRIPPED_CINNAMON_LOG.get(), MiscLootTables.CINNAMON_LOG,
					Block.Properties.copy(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<FenceBlock> CINNAMON_FENCE = BLOCKS.register("cinnamon_fence",
			() -> new FenceBlock(Block.Properties.copy(Blocks.ACACIA_FENCE)));
	public static final RegistryObject<FenceGateBlock> CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate",
			() -> new FenceGateBlock(Block.Properties.copy(Blocks.ACACIA_FENCE_GATE)));
	public static final RegistryObject<StairBlock> CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs",
			() -> new StairBlock(() -> CINNAMON_PLANKS.get().defaultBlockState(),
					Block.Properties.copy(Blocks.ACACIA_STAIRS)));
	public static final RegistryObject<DoorBlock> CINNAMON_DOOR = BLOCKS.register("cinnamon_door",
			() -> new DoorBlock(Block.Properties.copy(Blocks.ACACIA_DOOR)));
	public static final RegistryObject<TrapDoorBlock> CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor",
			() -> new TrapDoorBlock(Block.Properties.copy(Blocks.ACACIA_TRAPDOOR)));
	public static final RegistryObject<LeavesBlock> CINNAMON_LEAVES = BLOCKS.register("cinnamon_leaves",
			() -> new LeavesBlock(Block.Properties.copy(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> CINNAMON_CABINET = BLOCKS.register("cinnamon_cabinet",
			() -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)));
	public static final RegistryObject<SlabBlock> CINNAMON_SLAB = BLOCKS.register("cinnamon_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.DARK_OAK_SLAB)));
	public static final RegistryObject<RotatedPillarBlock> CINNAMON_STICK_BLOCK = BLOCKS
			.register("cinnamon_stick_block", () -> new RotatedPillarBlock(
					Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> GROUND_CINNAMON_SACK = BLOCKS.register("ground_cinnamon_sack",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> RAW_CINNAMON_BLOCK = BLOCKS.register("raw_cinnamon_block",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_BROWN)));

	public static final RegistryObject<Block> APPLE_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register("apple_cheesecake",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.APPLE_CHEESECAKE_SLICE));

	public static final RegistryObject<Block> SUGAR_COOKIE_BLOCK = BLOCKS.register("sugar_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> CHOCOLATE_CHIP_COOKIE_BLOCK = BLOCKS
			.register("chocolate_chip_cookie_block", () -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> APPLE_COOKIE_BLOCK = BLOCKS.register("apple_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> HONEY_COOKIE_BLOCK = BLOCKS.register("honey_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_BLOCK = BLOCKS.register("sweet_berry_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> GLOW_BERRY_COOKIE_BLOCK = BLOCKS.register("glow_berry_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> PUMPKIN_COOKIE_BLOCK = BLOCKS.register("pumpkin_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> GINGERBREAD_COOKIE_BLOCK = BLOCKS.register("gingerbread_cookie_block",
			() -> new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)));

	public static final RegistryObject<GingerCrop> GINGER_CROP = BLOCKS.register("ginger_crop",
			() -> new GingerCrop(Block.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> GINGER_CRATE = BLOCKS.register("ginger_crate", () -> new Block(
			Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.TERRACOTTA_BROWN)));
	public static final RegistryObject<Block> WILD_GINGER = BLOCKS.register("wild_ginger",
			() -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
	public static final RegistryObject<MintCrop> MINT_CROP = BLOCKS.register("mint_crop", MintCrop::new);
	public static final RegistryObject<Block> MINT_SACK = BLOCKS.register("mint_sack",
			() -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN)));
	public static final RegistryObject<Block> GOLDEN_APPLE_CRATE = BLOCKS.register("golden_apple_crate",
			() -> new Block(
					Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.TERRACOTTA_BROWN)));
	public static final RegistryObject<Block> BROWN_MUSHROOM_CRATE = BLOCKS.register("brown_mushroom_crate",
			() -> new Block(
					Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.TERRACOTTA_BROWN)));
	public static final RegistryObject<Block> RED_MUSHROOM_CRATE = BLOCKS.register("red_mushroom_crate",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> SWEET_BERRY_CRATE = BLOCKS.register("sweet_berry_crate",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> GLOW_BERRY_CRATE = BLOCKS.register("glow_berry_crate",
			() -> new Block(Block.Properties.copy(ModBlocks.BEETROOT_CRATE.get()).color(MaterialColor.COLOR_YELLOW)));

	public static final RegistryObject<CandyBowlBlock> CANDY_BOWL = BLOCKS.register("candy_bowl",
			() -> new CandyBowlBlock(Block.Properties.copy(Blocks.GLASS)));

	public static RegistryObject<FrostableBlock> WHITE_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"white_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("light_gray_frosted_gingerbread_block",
					() -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> GRAY_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"gray_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> BLACK_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"black_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> BROWN_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"brown_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> RED_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"red_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> ORANGE_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"orange_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> YELLOW_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"yellow_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> LIME_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"lime_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> GREEN_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"green_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> CYAN_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"cyan_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("light_blue_frosted_gingerbread_block",
					() -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> BLUE_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"blue_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> PURPLE_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"purple_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> MAGENTA_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"magenta_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
	public static RegistryObject<FrostableBlock> PINK_FROSTED_GINGERBREAD_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"pink_frosted_gingerbread_block", () -> new FrostableBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));

	public static final RegistryObject<Block> CANDY_CANE_RED_BLOCK = BLOCKS.register("candy_cane_red_block",
			() -> new Block(Block.Properties.copy(Blocks.STONE)));
	public static final RegistryObject<Block> CANDY_CANE_GREEN_BLOCK = BLOCKS.register("candy_cane_green_block",
			() -> new Block(Block.Properties.copy(Blocks.STONE)));
	public static final RegistryObject<Block> CANDY_CANE_BLUE_BLOCK = BLOCKS.register("candy_cane_blue_block",
			() -> new Block(Block.Properties.copy(Blocks.STONE)));

	public static final RegistryObject<RecipeFeastBlock> CINNAMON_ROLLS = BLOCKS.register("cinnamon_rolls",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					pan));
	public static final RegistryObject<RecipeFeastBlock> MONKEY_BREAD = BLOCKS.register("monkey_bread",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					pan));
	public static final RegistryObject<Block> COFFEE_CAKE = ExtraDelightBlocks.BLOCKS.register("coffee_cake",
			() -> new CakeBlock(Block.Properties.copy(Blocks.CAKE)));
	public static final RegistryObject<RecipeFeastBlock> CHRISTMAS_PUDDING = BLOCKS.register("christmas_pudding",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					pan));
	public static final RegistryObject<RecipeFeastBlock> PUNCH = BLOCKS.register("punch",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.GLASS).color(MaterialColor.COLOR_PINK), true, pan));
	public static final RegistryObject<Block> MILK_TART = ExtraDelightBlocks.BLOCKS.register("milk_tart",
			() -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ExtraDelightItems.MILK_TART_SLICE));
	public static final RegistryObject<RecipeFeastBlock> MINT_LAMB = BLOCKS.register("mint_lamb",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					pan));
	public static final RegistryObject<RecipeFeastBlock> CHARCUTERIE_BOARD = BLOCKS.register("charcuterie_board",
			() -> new RecipeFeastBlock(Block.Properties.copy(Blocks.WHITE_WOOL).color(MaterialColor.COLOR_BROWN), true,
					pan));
}

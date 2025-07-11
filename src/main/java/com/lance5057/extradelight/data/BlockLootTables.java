package com.lance5057.extradelight.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lance5057.extradelight.modules.SummerCitrus;
import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.RecipeFondueFeastBlock;
import com.lance5057.extradelight.blocks.RipeSalamiBlock;
import com.lance5057.extradelight.blocks.UnripeSalamiBlock;
import com.lance5057.extradelight.blocks.crops.BushStageFour;
import com.lance5057.extradelight.blocks.crops.ChiliCrop;
import com.lance5057.extradelight.blocks.crops.CucumberCrop;
import com.lance5057.extradelight.blocks.crops.GarlicCrop;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.MallowRootCrop;
import com.lance5057.extradelight.blocks.crops.PeanutCrop;
import com.lance5057.extradelight.blocks.crops.SoybeanCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;
import com.lance5057.extradelight.modules.Fermentation;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BlockLootTables extends BlockLootSubProvider {
	private final Set<Block> generatedLootTables = new HashSet<>();

	private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] { 0.05F * 2, 0.0625F * 2, 0.083333336F * 2,
			0.1F * 2 };
	private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[] { 0.02F, 0.022222223F, 0.025F, 0.033333335F,
			0.1F };

	public BlockLootTables(HolderLookup.Provider provider) {
		super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), provider);
	}

	@Override
	protected void generate() {
		for (DeferredBlock<Block> b : AestheticBlocks.STEP_STOOLS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.SPICE_RACKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.SPICE_RACKS_FULL)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.KNIFE_BLOCKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.CABINETS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.DRIED_CORN_FENCE)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.FOOD_DISPLAY)
			dropSelf(b.get());

		for (DeferredBlock<Block> b : AestheticBlocks.WALLPAPER_BLOCKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.MOLDED_WALLPAPER_BLOCKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.SINKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.COUNTER_CABINETS)
			dropSelf(b.get());

		dropSelf(AestheticBlocks.CORN_HUSK_DOLL.get());

		for (DeferredBlock<Block> b : AestheticBlocks.WREATHS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.BOWS)
			dropSelf(b.get());

		for (DeferredBlock<Block> b : AestheticBlocks.GINGHAM_BLOCKS)
			dropSelf(b.get());
		for (DeferredBlock<Block> b : AestheticBlocks.GINGHAM_CARPET_BLOCKS)
			dropSelf(b.get());

		this.dropSelf(ExtraDelightBlocks.OVEN.get());
		this.dropSelf(ExtraDelightBlocks.DOUGH_SHAPING.get());
		this.dropOther(ExtraDelightBlocks.MIXING_BOWL.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.DRYING_RACK.get());

		this.add(ExtraDelightBlocks.YEAST_POT.get(),
				LootTable.lootTable()
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(Items.FLOWER_POT)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(ModItems.CANVAS.get()))));
		this.add(ExtraDelightBlocks.VINEGAR_POT.get(),
				LootTable.lootTable()
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(Items.FLOWER_POT)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(ModItems.CANVAS.get()))));

		this.dropOther(ExtraDelightBlocks.VAT.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.EVAPORATOR.get(), Items.AIR);

		this.dropSelf(ExtraDelightBlocks.FLOUR.get());
//		this.dropSelf(ExtraDelightBlocks.COOKING_OIL.get());
		this.dropSelf(ExtraDelightBlocks.BREADCRUMBS.get());
		this.dropSelf(ExtraDelightBlocks.CORNMEAL.get());

		this.dropOther(ExtraDelightBlocks.MORTAR_STONE.get(), Items.AIR);

		this.add(ExtraDelightBlocks.CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), noDrop());

		this.add(ExtraDelightBlocks.QUICHE.get(), noDrop());

		feast(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(),
				Items.BOWL);
		feast(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(), ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(),
				Items.BOWL);

		dropSelf(ExtraDelightBlocks.CHEESE_BLOCK.get());
		this.add(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(),
				createSlabItemTable(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get()));
		this.dropSelf(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get());
		dropSelf(ExtraDelightBlocks.BUTTER_BLOCK.get());
		this.add(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(),
				createSlabItemTable(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get()));
		this.dropSelf(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get());

		feast(ExtraDelightBlocks.HASH_FEAST.get(), ExtraDelightItems.HASH_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.POT_ROAST_FEAST.get(), ExtraDelightItems.POT_ROAST_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.MEATLOAF_FEAST.get(), ExtraDelightItems.MEAT_LOAF_FEAST.get(), Items.BOWL);

		feast(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.PULLED_PORK_FEAST.get(), ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), Items.BOWL);

		feast(ExtraDelightBlocks.RACK_LAMB.get(), ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.STIRFRY.get(), ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.BEEF_WELLINGTON.get(), ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.HAGGIS.get(), ExtraDelightItems.HAGGIS_FEAST_ITEM.get(), Items.BOWL);

		feast(ExtraDelightBlocks.JELLY_WHITE.get(), ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_ORANGE.get(), ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_MAGENTA.get(), ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.get(),
				Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_YELLOW.get(), ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_LIME.get(), ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_PINK.get(), ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_GREY.get(), ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.get(),
				Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_CYAN.get(), ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_PURPLE.get(), ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_BLUE.get(), ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_BROWN.get(), ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_GREEN.get(), ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_RED.get(), ExtraDelightItems.JELLY_RED_FEAST_ITEM.get(), Items.BOWL);
		feast(ExtraDelightBlocks.JELLY_BLACK.get(), ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), Items.AIR);
		feast(ExtraDelightBlocks.MACARONI_CHEESE.get(), ExtraDelightItems.MACARONI_CHEESE_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.HOTDISH.get(), ExtraDelightItems.HOTDISH_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		feast(ExtraDelightBlocks.LASAGNA.get(), ExtraDelightItems.LASAGNA_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());

		feast(ExtraDelightBlocks.BEEF_STEW.get(), ExtraDelightItems.BEEF_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.CHICKEN_STEW.get(), ExtraDelightItems.CHICKEN_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.FISH_STEW.get(), ExtraDelightItems.FISH_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.LAMB_STEW.get(), ExtraDelightItems.LAMB_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.PORK_STEW.get(), ExtraDelightItems.PORK_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.RABBIT_STEW.get(), ExtraDelightItems.RABBIT_STEW_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.CURRY.get(), ExtraDelightItems.CURRY_FEAST.get(), ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.SALAD.get(), ExtraDelightItems.SALAD_FEAST_ITEM.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightItems.CORN_SEEDS.get());
//		this.dropOther(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.CORN_SEEDS.get());
		LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CORN_TOP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornTop.AGE, 3));
		crop(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
				ExtraDelightItems.CORN_SEEDS.get(), lootitemcondition$builder2, 3.0f);

		feast(ExtraDelightBlocks.CORNBREAD.get(), ExtraDelightItems.CORNBREAD_FEAST.get(), ModItems.SKILLET.get());
		this.dropOther(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), Items.AIR);
		feast(ExtraDelightBlocks.CORN_PUDDING.get(), ExtraDelightItems.CORN_PUDDING_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		this.dropOther(ExtraDelightBlocks.PUMPKIN_PIE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PUMPKIN_ROLL.get(), Items.AIR);
		feast(ExtraDelightBlocks.APPLE_CRISP.get(), ExtraDelightItems.APPLE_CRISP_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		feast(ExtraDelightBlocks.STUFFING.get(), ExtraDelightItems.STUFFING_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.POTATO_AU_GRATIN.get(), ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());

		this.dropSelf(ExtraDelightBlocks.FLOUR_SACK.get());
		this.dropSelf(ExtraDelightBlocks.CORNMEAL_SACK.get());
		this.dropSelf(ExtraDelightBlocks.SUGAR_SACK.get());
		this.dropSelf(ExtraDelightBlocks.CORN_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get());
		this.dropSelf(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get());
		this.dropSelf(ExtraDelightBlocks.CORN_COB_BUNDLE.get());
		this.dropSelf(ExtraDelightBlocks.GROUND_CINNAMON_SACK.get());
		this.dropSelf(ExtraDelightBlocks.RAW_CINNAMON_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CORN_SACK.get());
		this.dropSelf(ExtraDelightBlocks.CORN_SILK_SACK.get());
		this.dropSelf(ExtraDelightBlocks.BREADCRUMB_SACK.get());
		this.dropSelf(ExtraDelightBlocks.EGG_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GINGER_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.MINT_SACK.get());
		this.dropSelf(ExtraDelightBlocks.SWEET_BERRY_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.APPLE_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.GLOW_BERRY_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.RED_MUSHROOM_CRATE.get());

		this.dropSelf(ExtraDelightBlocks.CINNAMON_LOG.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_WOOD.get());
		this.dropSelf(ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get());
		this.dropSelf(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_PLANKS.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_BUTTON.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_PRESSURE_PLATE.get());

		this.add(ExtraDelightBlocks.CINNAMON_LEAVES.get(), (p_124100_) -> {
			return createLeavesDrops(p_124100_, ExtraDelightBlocks.CINNAMON_SAPLING.get(),
					NORMAL_LEAVES_SAPLING_CHANCES);
		});

		this.createFruitLeavesDrop(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), ExtraDelightBlocks.HAZELNUT_SAPLING.get(),
				ExtraDelightItems.HAZELNUTS_IN_SHELL.get());

		this.dropSelf(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get());

		this.dropSelf(ExtraDelightBlocks.CANDY_BOWL.get());

		this.dropOther(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(), Items.AIR);

		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get());

		LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.GINGER_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCrop.AGE, 3));
		crop(ExtraDelightBlocks.GINGER_CROP.get(), ExtraDelightItems.GINGER.get(),
				ExtraDelightItems.GINGER_CUTTING.get(), lootitemcondition$builder);

		this.dropOther(ExtraDelightBlocks.WILD_GINGER.get(), ExtraDelightItems.GINGER.get());

		feast(ExtraDelightBlocks.CINNAMON_ROLLS.get(), ExtraDelightItems.CINNAMON_ROLLS_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		feast(ExtraDelightBlocks.MONKEY_BREAD.get(), ExtraDelightItems.MONKEY_BREAD_FEAST.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.COFFEE_CAKE.get(), Items.AIR);
		feast(ExtraDelightBlocks.MINT_LAMB.get(), ExtraDelightItems.MINT_LAMB_FEAST.get(), Items.BOWL);
		feast(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), ExtraDelightItems.CHARCUTERIE_BOARD_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.MILK_TART.get(), Items.AIR);
		feast(ExtraDelightBlocks.PUNCH.get(), ExtraDelightItems.PUNCH_FEAST.get(), Items.BOWL);
		feast(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), ExtraDelightItems.CHRISTMAS_PUDDING_FEAST.get(), Items.AIR);

		this.dropSelf(ExtraDelightBlocks.MINT_CROP.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_SAPLING.get());

		this.add(ExtraDelightBlocks.CINNAMON_DOOR.get(), createDoorTable(ExtraDelightBlocks.CINNAMON_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.CINNAMON_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_CABINET.get());
		this.add(ExtraDelightBlocks.CINNAMON_SLAB.get(), createSlabItemTable(ExtraDelightBlocks.CINNAMON_SLAB.get()));

		this.dropSelf(ExtraDelightBlocks.TAP.get());

		this.createFruitBushDrop(ExtraDelightBlocks.COFFEE_BUSH.get(), ExtraDelightItems.COFFEE_CHERRIES.get());

		LootItemCondition.Builder peanut = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.PEANUT_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeanutCrop.AGE, 5));
		crop(ExtraDelightBlocks.PEANUT_CROP.get(), ExtraDelightItems.PEANUTS_IN_SHELL.get(),
				ExtraDelightItems.PEANUTS_IN_SHELL.get(), peanut);
		this.dropOther(ExtraDelightBlocks.WILD_PEANUT.get(), ExtraDelightItems.PEANUTS_IN_SHELL.get());

		LootItemCondition.Builder chili = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CHILI_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliCrop.AGE, 6));
		crop(ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightItems.CHILI.get(), ExtraDelightItems.CHILI_SEEDS.get(),
				chili);
		this.dropOther(ExtraDelightBlocks.WILD_CHILI.get(), ExtraDelightItems.CHILI.get());

		LootItemCondition.Builder mallow = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.MALLOW_ROOT_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MallowRootCrop.AGE, 7));

		crop(ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), ExtraDelightItems.MALLOW_ROOT.get(),
				ExtraDelightItems.MALLOW_ROOT.get(), mallow);
		this.dropOther(ExtraDelightBlocks.WILD_MALLOW_ROOT.get(), ExtraDelightItems.MALLOW_ROOT.get());

		this.dropSelf(ExtraDelightBlocks.KEG.get());

		this.dropOther(ExtraDelightBlocks.SHEET_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.TRAY_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LOAF_PAN_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PIE_DISH_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.BAKING_STONE_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.SERVING_POT_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.BAR_MOLD.get(), Items.AIR);

		this.dropSelf(ExtraDelightBlocks.FRUIT_LOG.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_WOOD.get());
		this.dropSelf(ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get());
		this.dropSelf(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_PLANKS.get());
		this.add(ExtraDelightBlocks.FRUIT_DOOR.get(), createDoorTable(ExtraDelightBlocks.FRUIT_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.FRUIT_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_TRAPDOOR.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_CABINET.get());
		this.add(ExtraDelightBlocks.FRUIT_SLAB.get(), createSlabItemTable(ExtraDelightBlocks.FRUIT_SLAB.get()));
//		this.dropOther(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.FRUIT_BUTTON.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get());

//		this.dropSelf(ExtraDelightBlocks.FRUIT_CEILING_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_STANDING_SIGN.get());
//		this.dropSelf(ExtraDelightBlocks.FRUIT_WALL_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_WALL_SIGN.get());

		this.dropOther(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get());
		this.add(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(),
				createDoorTable(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get());

		this.dropOther(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get());
		this.add(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(),
				createDoorTable(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get());

		this.dropOther(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get());
		this.add(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(),
				createDoorTable(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get());

		this.dropOther(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get());
		this.add(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(),
				createDoorTable(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get());

		this.dropSelf(ExtraDelightBlocks.MELTING_POT.get());
		this.dropSelf(ExtraDelightBlocks.CHILLER.get());
		this.dropSelf(ExtraDelightBlocks.FUNNEL.get());

//		this.add(Blocks.BLACK_SHULKER_BOX, p_248609_ -> this.createShulkerBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get(),
				p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get(),
				p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));
		this.add(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get(), p_248609_ -> this.createChocolateBoxDrop(p_248609_));

		feast(ExtraDelightBlocks.BROWNIES.get(), ExtraDelightItems.BROWNIES_BLOCK.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		feast(ExtraDelightBlocks.BLONDIES.get(), ExtraDelightItems.BLONDIES_BLOCK.get(),
				ExtraDelightItems.SQUARE_PAN.get());
		this.dropOther(ExtraDelightBlocks.CHOCOLATE_CAKE.get(), Items.AIR);
		feast(ExtraDelightBlocks.FUDGE.get(), ExtraDelightItems.FUDGE_BLOCK.get(), ExtraDelightItems.TRAY.get());
		feast(ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get(), ExtraDelightItems.STICKY_TOFFEE_PUDDING_BLOCK.get(),
				Items.BOWL);
		feast(ExtraDelightBlocks.CRISP_RICE_TREATS.get(), ExtraDelightItems.CRISP_RICE_TREATS_BLOCK.get(),
				ExtraDelightItems.TRAY.get());
		feast(ExtraDelightBlocks.SCOTCHAROOS.get(), ExtraDelightItems.SCOTCHAROO_BLOCK.get(),
				ExtraDelightItems.TRAY.get());
		feast(ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get(), ExtraDelightItems.BLACK_FOREST_TRIFLE_BLOCK.get(),
				Items.BOWL);
		feast(ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK.get(),
				Items.BUCKET);
		feast(ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK.get(),
				Items.BUCKET);
		feast(ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.get(),
				Items.BUCKET);
		feast(ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK.get(),
				Items.BUCKET);

		this.dropSelf(ExtraDelightBlocks.HAZELNUT_SAPLING.get());

		this.dropSelf(ExtraDelightBlocks.MARSHMALLOW_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GOLDEN_CARROT_CRATE.get());

		this.add(ExtraDelightBlocks.JAR.get(), p_248609_ -> this.createJarDrop(p_248609_));

		this.createFruitLeavesDrop(ExtraDelightBlocks.APPLE_LEAVES.get(), ExtraDelightBlocks.APPLE_SAPLING.get(),
				Items.APPLE);
		this.dropSelf(ExtraDelightBlocks.APPLE_SAPLING.get());
		feast(ExtraDelightBlocks.PORK_AND_APPLES_FEAST.get(), ExtraDelightItems.PORK_AND_APPLES_FEAST.get(), Items.AIR);
		feast(ExtraDelightBlocks.STUFFED_APPLES_FEAST.get(), ExtraDelightItems.STUFFED_APPLES_FEAST.get(), Items.AIR);
		this.add(ExtraDelightBlocks.TARTE_TATIN.get(), noDrop());

		this.dropSelf(ExtraDelightBlocks.HANGING_ONIONS.get());
		this.dropSelf(ExtraDelightBlocks.HANGING_CHILI.get());
		this.dropSelf(ExtraDelightBlocks.HANGING_CORN.get());
		this.dropSelf(ExtraDelightBlocks.HANGING_DRIED_CHILI.get());
		this.dropSelf(ExtraDelightBlocks.HANGING_HAM.get());
		this.dropSelf(ExtraDelightBlocks.HANGING_MINT.get());

		this.dropSelf(ExtraDelightBlocks.CHILI_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.CHILI_POWDER_SACK.get());
		feast(ExtraDelightBlocks.CHILI_CON_CARNE_FEAST.get(), ExtraDelightItems.CHILI_CON_CARNE_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());
		feast(ExtraDelightBlocks.WHITE_CHILI_FEAST.get(), ExtraDelightItems.WHITE_CHILI_FEAST.get(),
				ExtraDelightItems.SERVING_POT.get());

		this.dropSelf(ExtraDelightBlocks.PEANUT_IN_SHELL_SACK.get());
		this.dropSelf(ExtraDelightBlocks.PEANUT_SACK.get());
		this.dropSelf(ExtraDelightBlocks.ROASTED_PEANUT_SACK.get());
		this.dropSelf(ExtraDelightBlocks.NUT_BUTTER_COOKIE_BLOCK.get());

		this.dropSelf(ExtraDelightBlocks.HAZELNUT_IN_SHELL_SACK.get());
		this.dropSelf(ExtraDelightBlocks.HAZELNUT_SACK.get());
		this.dropSelf(ExtraDelightBlocks.ROASTED_HAZELNUT_SACK.get());
		this.dropOther(ExtraDelightBlocks.MISSISSIPPI_MUD_PIE.get(), Items.AIR);

		this.dropSelf(ExtraDelightBlocks.MALLOW_ROOT_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.MALLOW_POWDER_SACK.get());
		this.dropSelf(ExtraDelightBlocks.GRASSHOPPER_PIE.get());
		feast(ExtraDelightBlocks.MARSHMALLOW_SLICE_FEAST.get(), ExtraDelightItems.MARSHMALLOW_SLICE_FEAST.get(),
				ExtraDelightItems.SQUARE_PAN.get());

		this.dropSelf(ExtraDelightBlocks.COFFEE_CHERRY_CRATE.get());
		this.dropSelf(ExtraDelightBlocks.GREEN_COFFEE_BEAN_SACK.get());
		this.dropSelf(ExtraDelightBlocks.COFFEE_BEAN_SACK.get());
		this.dropSelf(ExtraDelightBlocks.GROUND_COFFEE_SACK.get());

		this.dropSelf(ExtraDelightBlocks.COCOA_BEAN_SACK.get());
		this.dropSelf(ExtraDelightBlocks.ROASTED_COCOA_BEAN_SACK.get());
		this.dropSelf(ExtraDelightBlocks.COCOA_SOLIDS_SACK.get());
		this.dropSelf(ExtraDelightBlocks.COCOA_POWDER_SACK.get());
		this.dropSelf(ExtraDelightBlocks.CHOCOLATE_COOKIE_BLOCK.get());

		this.dropOther(ExtraDelightBlocks.BACON_EGG_PIE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PANFORTE.get(), Items.AIR);

		LootItemCondition.Builder garlic = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.GARLIC_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCrop.AGE, 3));
		crop(ExtraDelightBlocks.GARLIC_CROP.get(), ExtraDelightItems.GARLIC.get(), ExtraDelightItems.GARLIC_CLOVE.get(),
				garlic);
		this.dropOther(ExtraDelightBlocks.WILD_GARLIC.get(), ExtraDelightItems.GARLIC.get());
		this.dropSelf(ExtraDelightBlocks.GARLIC_CRATE.get());
		feast(ExtraDelightBlocks.BRUSCHETTA_FEAST.get(), ExtraDelightItems.BRUSCHETTA_FEAST.get(), Items.BOWL);
		this.dropSelf(ExtraDelightBlocks.HANGING_GARLIC.get());

		this.dropOther(ExtraDelightBlocks.LID.get(), Items.AIR);

		this.dropOther(Fermentation.WILD_CUCUMBER.get(), Fermentation.CUCUMBER.get());
		LootItemCondition.Builder cucumber = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(Fermentation.CUCUMBER_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CucumberCrop.AGE, 7));
		crop(Fermentation.CUCUMBER_CROP.get(), Fermentation.CUCUMBER.get(), Fermentation.CUCUMBER_SEED.get(), cucumber);

		this.dropOther(Fermentation.WILD_SOYBEAN.get(), Fermentation.SOYBEAN_POD.get());
		LootItemCondition.Builder soybean = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(Fermentation.SOYBEAN_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoybeanCrop.AGE, 7));
		crop(Fermentation.SOYBEAN_CROP.get(), Fermentation.SOYBEAN_POD.get(), Fermentation.SOYBEANS.get(), soybean);

		feast(Fermentation.GHERKINS_BLOCK.get(), Fermentation.GHERKINS_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_BEETS_BLOCK.get(), Fermentation.PICKLED_BEETS_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_ONIONS_BLOCK.get(), Fermentation.PICKLED_ONIONS_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_CARROTS_BLOCK.get(), Fermentation.PICKLED_CARROTS_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_EGGS_BLOCK.get(), Fermentation.PICKLED_EGGS_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_FISH_BLOCK.get(), Fermentation.PICKLED_FISH_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_SAUSAGE_BLOCK.get(), Fermentation.PICKLED_SAUSAGE_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		feast(Fermentation.PICKLED_GINGER_BLOCK.get(), Fermentation.PICKLED_GINGER_BLOCK_ITEM.get(),
				Fermentation.PICKLE_JUICE.get());
		this.dropSelf(Fermentation.CUCUMBER_CRATE.get());
		this.dropSelf(Fermentation.SOYBEAN_SACK.get());
		this.add(Fermentation.UNRIPE_SALAMI_BLOCK.get(), i -> this.unsalami(i));
		this.add(Fermentation.SALAMI_BLOCK.get(), i -> this.salami(i));
		feast(Fermentation.SOY_GLAZED_SALMON_BLOCK.get(), Fermentation.SOY_GLAZED_SALMON_BLOCK_ITEM.get(), Items.BOWL);
		this.add(Fermentation.STEAK_PICKLED_ONION_PIE.get(), noDrop());

		this.add(Fermentation.JAR_DISPLAY_BLOCK.get(), noDrop());
		this.dropSelf(Fermentation.SALT_BLOCK.get());

		feast(Fermentation.CHEESYMITE_SCROLL_BLOCK.get(), Fermentation.CHEESYMITE_SCROLL_BLOCK_ITEM.get(), Items.BOWL);

		add(ExtraDelightBlocks.POTTED_CINNAMON_SAPLING.get(),
				createPotFlowerItemTable(ExtraDelightBlocks.CINNAMON_SAPLING.get()));
		add(ExtraDelightBlocks.POTTED_HAZELNUT_SAPLING.get(),
				createPotFlowerItemTable(ExtraDelightBlocks.HAZELNUT_SAPLING.get()));
		add(ExtraDelightBlocks.POTTED_APPLE_SAPLING.get(),
				createPotFlowerItemTable(ExtraDelightBlocks.APPLE_SAPLING.get()));

		this.createFruitLeavesDrop(SummerCitrus.LEMON_LEAVES.get(), SummerCitrus.LEMON_SAPLING.get(),
				SummerCitrus.LEMON.get());
		this.dropSelf(SummerCitrus.LEMON_SAPLING.get());
		add(SummerCitrus.POTTED_LEMON_SAPLING.get(), createPotFlowerItemTable(SummerCitrus.LEMON_SAPLING.get()));
		this.createFruitLeavesDrop(SummerCitrus.LIME_LEAVES.get(), SummerCitrus.LIME_SAPLING.get(),
				SummerCitrus.LIME.get());
		this.dropSelf(SummerCitrus.LIME_SAPLING.get());
		add(SummerCitrus.POTTED_LIME_SAPLING.get(), createPotFlowerItemTable(SummerCitrus.LIME_SAPLING.get()));
		this.createFruitLeavesDrop(SummerCitrus.ORANGE_LEAVES.get(), SummerCitrus.ORANGE_SAPLING.get(),
				SummerCitrus.ORANGE.get());
		this.dropSelf(SummerCitrus.ORANGE_SAPLING.get());
		add(SummerCitrus.POTTED_ORANGE_SAPLING.get(), createPotFlowerItemTable(SummerCitrus.ORANGE_SAPLING.get()));
		this.createFruitLeavesDrop(SummerCitrus.GRAPEFRUIT_LEAVES.get(), SummerCitrus.GRAPEFRUIT_SAPLING.get(),
				SummerCitrus.GRAPEFRUIT.get());
		this.dropSelf(SummerCitrus.GRAPEFRUIT_SAPLING.get());
		add(SummerCitrus.POTTED_GRAPEFRUIT_SAPLING.get(),
				createPotFlowerItemTable(SummerCitrus.GRAPEFRUIT_SAPLING.get()));
		this.dropSelf(SummerCitrus.LEMON_CRATE.get());
		this.dropSelf(SummerCitrus.LIME_CRATE.get());
		this.dropSelf(SummerCitrus.ORANGE_CRATE.get());
		this.dropSelf(SummerCitrus.GRAPEFRUIT_CRATE.get());
		this.add(SummerCitrus.LEMON_MERINGUE_PIE.get(), noDrop());
		this.add(SummerCitrus.KEY_LIME_PIE.get(), noDrop());
		feast(SummerCitrus.MELON_FRUIT_SALAD.get(), SummerCitrus.MELON_FRUIT_SALAD_ITEM.get(),
				SummerCitrus.MELON_RIND.get());

		this.dropSelf(ExtraDelightBlocks.JUICER.get());
	}

	protected void createFruitBushDrop(Block bush, Item fruit) {
		this.add(bush,
				p_249159_ -> this.applyExplosionDecay(p_249159_, LootTable.lootTable().withPool(LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(
								StatePropertiesPredicate.Builder.properties().hasProperty(BushStageFour.AGE, 3)))
						.add(LootItem.lootTableItem(fruit))
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
						.apply(ApplyBonusCount
								.addUniformBonusCount(this.registries.holderOrThrow(Enchantments.FORTUNE))))
						.withPool(LootPool.lootPool()
								.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush)
										.setProperties(StatePropertiesPredicate.Builder.properties()
												.hasProperty(BushStageFour.AGE, 2)))
								.add(LootItem.lootTableItem(fruit))
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
								.apply(ApplyBonusCount
										.addUniformBonusCount(this.registries.holderOrThrow(Enchantments.FORTUNE))))));
	}

	protected void createFruitLeavesDrop(Block leaves, Block sapling, Item fruit) {
		this.add(leaves, (p_124101_) -> {
			return createLeavesDrops(p_124101_, sapling, NORMAL_LEAVES_SAPLING_CHANCES)
					.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leaves).setProperties(
									StatePropertiesPredicate.Builder.properties().hasProperty(FruitLeafBlock.AGE, 3)))
							.add(LootItem.lootTableItem(fruit)));
		});
	}

	protected LootTable.Builder createChocolateBoxDrop(Block block) {
		return LootTable.lootTable()
				.withPool(this.applyExplosionCondition(block,
						LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(block)
										.apply(CopyComponentsFunction
												.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
												.include(DataComponents.CONTAINER)))));
	}

	protected LootTable.Builder createJarDrop(Block block) {
		return LootTable.lootTable()
				.withPool(this.applyExplosionCondition(block,
						LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(block)
										.apply(CopyComponentsFunction
												.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
												.include(ExtraDelightComponents.FLUID.get())))));
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		Collection<Block> l = new ArrayList<Block>();
		l.addAll(ExtraDelightBlocks.BLOCKS.getEntries().stream().map(r -> r.get()).toList());
		l.addAll(AestheticBlocks.BLOCKS.getEntries().stream().map(r -> r.get()).toList());
//		l.addAll(ButchercraftAddon.BLOCKS.getEntries().stream().map(RegistryObject::get).toList());
		return l;
	}

	void crop(CropBlock pCropBlock, ItemLike pGrownCropItem, ItemLike pSeedsItem, Builder pDropGrownCropCondition,
			float amount) {
		this.add(pCropBlock,
				LootTable.lootTable()
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(pSeedsItem).when(pDropGrownCropCondition)))
						.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(amount))
								.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)))
						.withPool(
								LootPool.lootPool().when(pDropGrownCropCondition)
										.add(LootItem.lootTableItem(pGrownCropItem)
												.apply(ApplyBonusCount.addBonusBinomialDistributionCount(
														this.registries.holderOrThrow(Enchantments.FORTUNE), 0.5714286F,
														1)))));
	}

	void crop(CropBlock pCropBlock, ItemLike pGrownCropItem, ItemLike pSeedsItem, Builder pDropGrownCropCondition) {
		this.add(pCropBlock, LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1, 2))
						.add(LootItem.lootTableItem(pSeedsItem).when(pDropGrownCropCondition)))
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)
								.otherwise(LootItem.lootTableItem(pSeedsItem))))
				.withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(
						LootItem.lootTableItem(pGrownCropItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(
								this.registries.holderOrThrow(Enchantments.FORTUNE), 0.5714286F, 1)))));
	}

	net.minecraft.world.level.storage.loot.LootTable.Builder salami(Block block) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
				(LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(
						List.of(2, 3, 4),
						p_249985_ -> SetItemCountFunction.setCount(ConstantValue.exactly((float) p_249985_.intValue()))
								.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
										.setProperties(StatePropertiesPredicate.Builder.properties()
												.hasProperty(RipeSalamiBlock.COUNT, p_249985_.intValue() - 1)))))));
	}

	net.minecraft.world.level.storage.loot.LootTable.Builder unsalami(Block block) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
				(LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(
						List.of(2, 3, 4),
						p_249985_ -> SetItemCountFunction.setCount(ConstantValue.exactly((float) p_249985_.intValue()))
								.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
										.setProperties(StatePropertiesPredicate.Builder.properties()
												.hasProperty(UnripeSalamiBlock.COUNT, p_249985_.intValue() - 1)))))));
	}

	void feast(RecipeFeastBlock block, Item blockItem, Item lastDrop) {
		LootItemCondition.Builder feast0 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RecipeFeastBlock.SERVINGS, 0));

		this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(lastDrop).when(feast0).otherwise(LootItem.lootTableItem(Items.AIR)))));
	}

	void feast(RecipeFondueFeastBlock block, Item blockItem, Item lastDrop) {
		LootItemCondition.Builder feast0 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
				.setProperties(
						StatePropertiesPredicate.Builder.properties().hasProperty(RecipeFondueFeastBlock.SERVINGS, 0));

		this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
				.add(LootItem.lootTableItem(lastDrop).when(feast0).otherwise(LootItem.lootTableItem(Items.AIR)))));
	}

//	void dropOther(Block block, IntegerProperty style) {
//		LootItemCondition.Builder style0 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
//				.setProperties(
//						StatePropertiesPredicate.Builder.properties().hasProperty(style, 0));
//
//		this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
//				.add(LootItem.lootTableItem(block).when(style0).otherwise(LootItem.lootTableItem(Items.AIR)))));
//	}
}

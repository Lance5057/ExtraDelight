package com.lance5057.extradelight.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.blocks.HorizontalPanBlock;
import com.lance5057.extradelight.blocks.crops.ChiliCrop;
import com.lance5057.extradelight.blocks.crops.CoffeeBush;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.MallowRootCrop;
import com.lance5057.extradelight.blocks.crops.PeanutCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyBlockState;
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

	protected BlockLootTables(HolderLookup.Provider provider) {
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

		this.dropSelf(ExtraDelightBlocks.OVEN.get());
		this.dropSelf(ExtraDelightBlocks.DOUGH_SHAPING.get());
		this.dropSelf(ExtraDelightBlocks.FOOD_DISPLAY.get());
		this.dropSelf(ExtraDelightBlocks.MIXING_BOWL.get());
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

		this.dropSelf(ExtraDelightBlocks.FLOUR.get());
		this.dropSelf(ExtraDelightBlocks.COOKING_OIL.get());
		this.dropSelf(ExtraDelightBlocks.BREADCRUMBS.get());
		this.dropSelf(ExtraDelightBlocks.CORNMEAL.get());

		this.dropSelf(ExtraDelightBlocks.MORTAR_STONE.get());

		this.add(ExtraDelightBlocks.CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), noDrop());

		this.add(ExtraDelightBlocks.QUICHE.get(), noDrop());

		this.dropOther(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(), Items.BOWL);

		dropSelf(ExtraDelightBlocks.CHEESE_BLOCK.get());
		this.add(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(),
				createSlabItemTable(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get()));
		this.dropSelf(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get());
		dropSelf(ExtraDelightBlocks.BUTTER_BLOCK.get());
		this.add(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(),
				createSlabItemTable(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get()));
		this.dropSelf(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get());

		this.dropOther(ExtraDelightBlocks.HASH_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.POT_ROAST_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.MEATLOAF_FEAST.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.PULLED_PORK_FEAST.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.RACK_LAMB.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.STIRFRY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.BEEF_WELLINGTON.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.HAGGIS.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.JELLY_WHITE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_ORANGE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_MAGENTA.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_YELLOW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIME.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_PINK.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_GREY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_CYAN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_PURPLE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BLUE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BROWN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_GREEN.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_RED.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.JELLY_BLACK.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MACARONI_CHEESE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.HOTDISH.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.LASAGNA.get(), Items.AIR);

		this.dropOther(ExtraDelightBlocks.BEEF_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.CHICKEN_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.FISH_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.LAMB_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.PORK_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.RABBIT_STEW.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.CURRY.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.SALAD.get(), Items.BOWL);

		this.dropOther(ExtraDelightBlocks.CORN_BOTTOM.get(), ExtraDelightItems.CORN_SEEDS.get());
//		this.dropOther(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.CORN_SEEDS.get());
		LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CORN_TOP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornTop.AGE, 3));
		crop(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
				ExtraDelightItems.CORN_SEEDS.get(), lootitemcondition$builder2, 3.0f);

		this.dropOther(ExtraDelightBlocks.CORNBREAD.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.CORN_PUDDING.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PUMPKIN_PIE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PUMPKIN_ROLL.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.APPLE_CRISP.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.STUFFING.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.POTATO_AU_GRATIN.get(), Items.BOWL);

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

//		this.dropSelf(ExtraDelightBlocks.CINNAMON_CEILING_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_STANDING_SIGN.get());
//		this.dropSelf(ExtraDelightBlocks.CINNAMON_WALL_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_WALL_SIGN.get());

		this.add(ExtraDelightBlocks.CINNAMON_LEAVES.get(), (p_124100_) -> {
			return createLeavesDrops(p_124100_, ExtraDelightBlocks.CINNAMON_SAPLING.get(),
					NORMAL_LEAVES_SAPLING_CHANCES);
		});

		this.dropSelf(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get());

		this.dropSelf(ExtraDelightBlocks.CANDY_BOWL.get());

		this.dropSelf(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get());

		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get());

		LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.GINGER_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCrop.AGE, 3));
		crop(ExtraDelightBlocks.GINGER_CROP.get(), ExtraDelightItems.GINGER.get(),
				ExtraDelightItems.GINGER_CUTTING.get(), lootitemcondition$builder);

		this.dropOther(ExtraDelightBlocks.WILD_GINGER.get(), ExtraDelightItems.GINGER.get());

		this.dropOther(ExtraDelightBlocks.CINNAMON_ROLLS.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MONKEY_BREAD.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.COFFEE_CAKE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MINT_LAMB.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.MILK_TART.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.PUNCH.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), Items.AIR);

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

		this.add(ExtraDelightBlocks.COFFEE_BUSH.get(),
				p_249159_ -> this.applyExplosionDecay(p_249159_, LootTable.lootTable().withPool(LootPool.lootPool()
						.when(LootItemBlockStatePropertyCondition
								.hasBlockStateProperties(ExtraDelightBlocks.COFFEE_BUSH.get()).setProperties(
										StatePropertiesPredicate.Builder.properties().hasProperty(CoffeeBush.AGE, 3)))
						.add(LootItem.lootTableItem(ExtraDelightItems.COFFEE_CHERRIES.get()))
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
						.apply(ApplyBonusCount
								.addUniformBonusCount(this.registries.holderOrThrow(Enchantments.FORTUNE))))
						.withPool(LootPool.lootPool()
								.when(LootItemBlockStatePropertyCondition
										.hasBlockStateProperties(ExtraDelightBlocks.COFFEE_BUSH.get())
										.setProperties(StatePropertiesPredicate.Builder.properties()
												.hasProperty(CoffeeBush.AGE, 2)))
								.add(LootItem.lootTableItem(ExtraDelightItems.COFFEE_CHERRIES.get()))
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
								.apply(ApplyBonusCount
										.addUniformBonusCount(this.registries.holderOrThrow(Enchantments.FORTUNE))))));

		LootItemCondition.Builder peanut = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.PEANUT_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeanutCrop.AGE, 3));
		crop(ExtraDelightBlocks.PEANUT_CROP.get(), ExtraDelightItems.PEANUTS_IN_SHELL.get(),
				ExtraDelightItems.PEANUTS_IN_SHELL.get(), peanut);
		this.dropOther(ExtraDelightBlocks.WILD_PEANUT.get(), ExtraDelightItems.PEANUTS_IN_SHELL.get());

		LootItemCondition.Builder chili = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CHILI_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliCrop.AGE, 3));
		crop(ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightItems.CHILI.get(), ExtraDelightItems.CHILI_SEEDS.get(),
				chili);
		this.dropOther(ExtraDelightBlocks.WILD_CHILI.get(), ExtraDelightItems.CHILI.get());

		LootItemCondition.Builder mallow = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.MALLOW_ROOT_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MallowRootCrop.AGE, 3));

		this.add(ExtraDelightBlocks.MALLOW_ROOT_CROP.get(),
				p_249159_ -> this.applyExplosionDecay(p_249159_,
						LootTable.lootTable()
								.withPool(LootPool.lootPool()
										.when(LootItemBlockStatePropertyCondition
												.hasBlockStateProperties(ExtraDelightBlocks.MALLOW_ROOT_CROP.get())
												.setProperties(StatePropertiesPredicate.Builder.properties()
														.hasProperty(MallowRootCrop.AGE, 3)))
										.add(LootItem.lootTableItem(ExtraDelightItems.MALLOW_ROOT.get()))
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
										.apply(ApplyBonusCount.addUniformBonusCount(
												this.registries.holderOrThrow(Enchantments.FORTUNE))))
								.withPool(LootPool
										.lootPool()
										.when(LootItemBlockStatePropertyCondition
												.hasBlockStateProperties(ExtraDelightBlocks.MALLOW_ROOT_CROP.get())
												.setProperties(StatePropertiesPredicate.Builder.properties()
														.hasProperty(MallowRootCrop.AGE, 2)))
										.add(LootItem.lootTableItem(ExtraDelightItems.MALLOW_ROOT.get()))
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
										.apply(ApplyBonusCount.addUniformBonusCount(
												this.registries.holderOrThrow(Enchantments.FORTUNE))))));
		this.dropOther(ExtraDelightBlocks.WILD_MALLOW_ROOT.get(), ExtraDelightItems.MALLOW_ROOT.get());

		this.dropSelf(ExtraDelightBlocks.KEG.get());

		this.add(ExtraDelightBlocks.SHEET_BLOCK.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(ExtraDelightBlocks.SHEET_BLOCK.get()).apply(CopyBlockState
								.copyState(ExtraDelightBlocks.SHEET_BLOCK.get()).copy(HorizontalPanBlock.STYLE)))));

//		this.dropSelf(ExtraDelightBlocks.SHEET_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.TRAY_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.LOAF_PAN_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.PIE_DISH_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.BAKING_STONE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.SERVING_POT_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.BAR_MOLD.get());

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
		this.dropOther(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), Items.AIR);
		this.dropSelf(ExtraDelightBlocks.FRUIT_BUTTON.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get());

//		this.dropSelf(ExtraDelightBlocks.FRUIT_CEILING_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_STANDING_SIGN.get());
//		this.dropSelf(ExtraDelightBlocks.FRUIT_WALL_HANGING_SIGN.get());
		this.dropSelf(ExtraDelightBlocks.FRUIT_WALL_SIGN.get());

		LootItemCondition.Builder chiliBuilder = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CHILI_CROP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliCrop.AGE, 7));
		crop(ExtraDelightBlocks.CHILI_CROP.get(), ExtraDelightItems.CHILI.get(), ExtraDelightItems.CHILI_SEEDS.get(),
				chiliBuilder);

		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get());
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get());

		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get());
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get());

		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get());
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get());
		this.add(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(),
				createSlabItemTable(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get()));
		this.dropSelf(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get());

		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get());
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

		this.dropOther(ExtraDelightBlocks.BROWNIES.get(), ExtraDelightItems.TRAY);
		this.dropOther(ExtraDelightBlocks.BLONDIES.get(), ExtraDelightItems.TRAY);
		this.dropOther(ExtraDelightBlocks.CHOCOLATE_CAKE.get(), Items.AIR);
		this.dropOther(ExtraDelightBlocks.FUDGE.get(), ExtraDelightItems.TRAY);
		this.dropOther(ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.CRISP_RICE_TREATS.get(), ExtraDelightItems.TRAY);
		this.dropOther(ExtraDelightBlocks.SCOTCHAROOS.get(), ExtraDelightItems.TRAY);
		this.dropOther(ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get(), Items.BOWL);
		this.dropOther(ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), Items.BUCKET);
		this.dropOther(ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), Items.BUCKET);
		this.dropOther(ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), Items.BUCKET);
		this.dropOther(ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), Items.BUCKET);

		this.dropSelf(ExtraDelightBlocks.HAZELNUT_SAPLING.get());

		this.add(ExtraDelightBlocks.JAR.get(), p_248609_ -> this.createJarDrop(p_248609_));
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
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)
								.otherwise(LootItem.lootTableItem(pSeedsItem))))
				.withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(
						LootItem.lootTableItem(pGrownCropItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(
								this.registries.holderOrThrow(Enchantments.FORTUNE), 0.5714286F, 1)))));
	}
}

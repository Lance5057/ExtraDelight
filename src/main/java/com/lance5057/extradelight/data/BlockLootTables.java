package com.lance5057.extradelight.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.blocks.crops.GingerCrop;
import com.lance5057.extradelight.blocks.crops.corn.CornTop;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BlockLootTables extends BlockLootSubProvider {
	private final Set<Block> generatedLootTables = new HashSet<>();

	private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] { 0.05F * 2, 0.0625F * 2, 0.083333336F * 2,
			0.1F * 2 };
	private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[] { 0.02F, 0.022222223F, 0.025F, 0.033333335F,
			0.1F };

	protected BlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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
		this.dropSelf(ExtraDelightBlocks.MORTAR_ANDESITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_GRANITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_DIORITE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_DEEPSLATE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_BLACKSTONE.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_BASALT.get());
		this.dropSelf(ExtraDelightBlocks.MORTAR_ENDSTONE.get());

		this.dropSelf(ExtraDelightBlocks.MORTAR_AMETHYST.get()); // not craftable, dungeon item
		this.dropSelf(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get()); // not craftable, dungeon item

		this.add(ExtraDelightBlocks.CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), noDrop());
		this.add(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), noDrop());
		this.add(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), noDrop());

		this.add(ExtraDelightBlocks.QUICHE.get(), noDrop());

		this.add(ExtraDelightBlocks.PLAIN_CAKE.get(), noDrop());

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
		this.dropOther(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.CORN_SEEDS.get());

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
		this.dropSelf(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_PLANKS.get());

		this.dropOther(ExtraDelightBlocks.CINNAMON_LEAVES.get(), Items.AIR);
//		this.add(ExtraDelightBlocks.CINNAMON_LEAVES.get(), (p_124100_) -> {
//			return createLeavesDrops(p_124100_, ExtraDelightBlocks.CINNAMON_SAPLING.get(),
//					NORMAL_LEAVES_SAPLING_CHANCES);
//		});

//		 createSilkTouchOrShearsDispatchTable(pLeavesBlock, applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pSaplingBlock))
//		.when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pChances))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//				.when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionDecay(pLeavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
//						.when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_STICK_CHANCES))));
//		createSelfDropDispatchTable(pBlock, HAS_SHEARS_OR_SILK_TOUCH, pAlternativeEntryBuilder);
//		LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pBlock).when(pConditionBuilder).otherwise(pAlternativeEntryBuilder)));

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

		LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(ExtraDelightBlocks.CORN_TOP.get())
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornTop.AGE, 3));
//		crop(ExtraDelightBlocks.CORN_TOP.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
//				ExtraDelightItems.CORN_SEEDS.get(), lootitemcondition$builder2, 3.0f);

		this.add(ExtraDelightBlocks.CINNAMON_DOOR.get(), createDoorTable(ExtraDelightBlocks.CINNAMON_DOOR.get()));
		this.dropSelf(ExtraDelightBlocks.CINNAMON_FENCE.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_STAIRS.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get());
		this.dropSelf(ExtraDelightBlocks.CINNAMON_CABINET.get());
		this.add(ExtraDelightBlocks.CINNAMON_SLAB.get(), createSlabItemTable(ExtraDelightBlocks.CINNAMON_SLAB.get()));

//		AestheticBlocks.loot(this);
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
		this.add(pCropBlock, LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(amount))
						.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)))
				.withPool(LootPool.lootPool().when(pDropGrownCropCondition)
						.add(LootItem.lootTableItem(pGrownCropItem).apply(ApplyBonusCount
								.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 1)))));
	}

	void crop(CropBlock pCropBlock, ItemLike pGrownCropItem, ItemLike pSeedsItem, Builder pDropGrownCropCondition) {
		this.add(pCropBlock,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition)
										.otherwise(LootItem.lootTableItem(pSeedsItem))))
						.withPool(LootPool.lootPool().when(pDropGrownCropCondition)
								.add(LootItem.lootTableItem(pGrownCropItem).apply(
										ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE,
												0.5714286F, 1)))));
	}
}

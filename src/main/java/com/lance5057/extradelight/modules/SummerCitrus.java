package com.lance5057.extradelight.modules;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.util.EDItemGenerator;
import com.lance5057.extradelight.worldgen.features.trees.ExtraDelightTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class SummerCitrus {
    // Lemon
    public static final DeferredItem<Item> LEMON = EDItemGenerator.register("lemon",
            () -> new Item(new Item.Properties())).advancementIngredients().finish();
    public static final DeferredBlock<FruitLeafBlock> LEMON_LEAVES = ExtraDelightBlocks.BLOCKS.register("lemon_leaves",
            () -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES),
                    LEMON));
    public static final DeferredItem<Item> LEMON_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("lemon_leaves",
        () -> new BlockItem(LEMON_LEAVES.get(), new Item.Properties()));
    public static final DeferredBlock<SaplingBlock> LEMON_SAPLING = ExtraDelightBlocks.BLOCKS.register("lemon_sapling",
            () -> new SaplingBlock(ExtraDelightTreeGrowers.LEMON,
                    Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final DeferredItem<Item> LEMON_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("lemon_sapling",
        () -> new BlockItem(LEMON_SAPLING.get(), new Item.Properties()));
    public static final DeferredBlock<Block> POTTED_LEMON_SAPLING = ExtraDelightBlocks.BLOCKS.register("potted_lemon_sapling",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));

    // Lime
    public static final DeferredItem<Item> LIME = EDItemGenerator.register("lime",
            () -> new Item(new Item.Properties())).advancementIngredients().finish();
    public static final DeferredBlock<FruitLeafBlock> LIME_LEAVES = ExtraDelightBlocks.BLOCKS.register("lime_leaves",
            () -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES),
                    LIME));
    public static final DeferredItem<Item> LIME_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("lime_leaves",
            () -> new BlockItem(LIME_LEAVES.get(), new Item.Properties()));
    public static final DeferredBlock<SaplingBlock> LIME_SAPLING = ExtraDelightBlocks.BLOCKS.register("lime_sapling",
            () -> new SaplingBlock(ExtraDelightTreeGrowers.LIME,
                    Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final DeferredItem<Item> LIME_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("lime_sapling",
            () -> new BlockItem(LIME_SAPLING.get(), new Item.Properties()));
    public static final DeferredBlock<Block> POTTED_LIME_SAPLING = ExtraDelightBlocks.BLOCKS.register("potted_lime_sapling",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));

    // Orange
    public static final DeferredItem<Item> ORANGE = EDItemGenerator.register("orange",
            () -> new Item(new Item.Properties())).advancementIngredients().finish();
    public static final DeferredBlock<FruitLeafBlock> ORANGE_LEAVES = ExtraDelightBlocks.BLOCKS.register("orange_leaves",
            () -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES),
                    ORANGE));
    public static final DeferredItem<Item> ORANGE_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("orange_leaves",
            () -> new BlockItem(ORANGE_LEAVES.get(), new Item.Properties()));
    public static final DeferredBlock<SaplingBlock> ORANGE_SAPLING = ExtraDelightBlocks.BLOCKS.register("orange_sapling",
            () -> new SaplingBlock(ExtraDelightTreeGrowers.ORANGE,
                    Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final DeferredItem<Item> ORANGE_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("orange_sapling",
            () -> new BlockItem(ORANGE_SAPLING.get(), new Item.Properties()));
    public static final DeferredBlock<Block> POTTED_ORANGE_SAPLING = ExtraDelightBlocks.BLOCKS.register("potted_orange_sapling",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));

    // Grapefruit
    public static final DeferredItem<Item> GRAPEFRUIT = EDItemGenerator.register("grapefruit",
            () -> new Item(new Item.Properties())).advancementIngredients().finish();
    public static final DeferredBlock<FruitLeafBlock> GRAPEFRUIT_LEAVES = ExtraDelightBlocks.BLOCKS.register("grapefruit_leaves",
            () -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES),
                    GRAPEFRUIT));
    public static final DeferredItem<Item> GRAPEFRUIT_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("grapefruit_leaves",
            () -> new BlockItem(GRAPEFRUIT_LEAVES.get(), new Item.Properties()));
    public static final DeferredBlock<SaplingBlock> GRAPEFRUIT_SAPLING = ExtraDelightBlocks.BLOCKS.register("grapefruit_sapling",
            () -> new SaplingBlock(ExtraDelightTreeGrowers.GRAPEFRUIT,
                    Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final DeferredItem<Item> GRAPEFRUIT_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("grapefruit_sapling",
            () -> new BlockItem(GRAPEFRUIT_SAPLING.get(), new Item.Properties()));
    public static final DeferredBlock<Block> POTTED_GRAPEFRUIT_SAPLING = ExtraDelightBlocks.BLOCKS.register("potted_grapefruit_sapling",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));

    public static void blockModels(BlockStateProvider bsp) {
        BlockModels.fruitLeafBlock(bsp, LEMON_LEAVES.get(), "lemon");
        bsp.simpleBlock(LEMON_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("lemon_sapling", bsp.modLoc("block/crops/fruit/lemon/lemon_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_LEMON_SAPLING.get(), "lemon_sapling", "crops/fruit/lemon/lemon_sapling");

        BlockModels.fruitLeafBlock(bsp, LIME_LEAVES.get(), "lime");
        bsp.simpleBlock(LIME_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("lime_sapling", bsp.modLoc("block/crops/fruit/lime/lime_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_LIME_SAPLING.get(), "lime_sapling", "crops/fruit/lime/lime_sapling");

        BlockModels.fruitLeafBlock(bsp, ORANGE_LEAVES.get(), "orange");
//        bsp.simpleBlock(ORANGE_SAPLING.get(), new ConfiguredModel(bsp.models()
//                .cross("orange_sapling", bsp.modLoc("block/crops/fruit/orange/orange_sapling")).renderType("cutout")));
//        BlockModels.pottedBlock(bsp, POTTED_ORANGE_SAPLING.get(), "orange_sapling", "crops/fruit/orange/orange_sapling");

        BlockModels.fruitLeafBlock(bsp, GRAPEFRUIT_LEAVES.get(), "grapefruit");
//        bsp.simpleBlock(GRAPEFRUIT_SAPLING.get(), new ConfiguredModel(bsp.models()
//                .cross("grapefruit_sapling", bsp.modLoc("block/crops/fruit/grapefruit/grapefruit_sapling")).renderType("cutout")));
//        BlockModels.pottedBlock(bsp, POTTED_GRAPEFRUIT_SAPLING.get(), "grapefruit_sapling", "crops/fruit/grapefruit/grapefruit_sapling");
    }

    public static void itemModels(ItemModelProvider tmp) {
        ItemModels.forItem(tmp, LEMON, "crops/fruit/lemon/lemon");
        ItemModels.forBlockItem(tmp, LEMON_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lemon/lemon_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, LEMON_SAPLING_ITEM, "crops/fruit/lemon/lemon_sapling");

        ItemModels.forItem(tmp, LIME, "crops/fruit/lime/lime");
        ItemModels.forBlockItem(tmp, LIME_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lime/lime_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, LIME_SAPLING_ITEM, "crops/fruit/lime/lime_sapling");

        ItemModels.forItem(tmp, ORANGE, "crops/fruit/orange/orange");
        ItemModels.forBlockItem(tmp, ORANGE_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/orange/orange_leaves_stage0"));
//        ItemModels.forBlockItemFlat(tmp, ORANGE_SAPLING_ITEM, "crops/fruit/orange/orange_sapling");

        ItemModels.forItem(tmp, GRAPEFRUIT, "crops/fruit/grapefruit/grapefruit");
        ItemModels.forBlockItem(tmp, GRAPEFRUIT_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/grapefruit/grapefruit_leaves_stage0"));
//        ItemModels.forBlockItemFlat(tmp, GRAPEFRUIT_SAPLING_ITEM, "crops/fruit/grapefruit/grapefruit_sapling");
    }

    public static void EngLoc(LanguageProvider lp) {
        lp.add(LEMON.get(), "Lemon");
        lp.add(LEMON_LEAVES.get(), "Lemon Leaves");
        lp.add(LEMON_SAPLING.get(), "Lemon Sapling");
        lp.add(POTTED_LEMON_SAPLING.get(), "Potted Lemon Sapling");

        lp.add(LIME.get(), "Lime");
        lp.add(LIME_LEAVES.get(), "Lime Leaves");
        lp.add(LIME_SAPLING.get(), "Lime Sapling");
        lp.add(POTTED_LIME_SAPLING.get(), "Potted Lime Sapling");

        lp.add(ORANGE.get(), "Orange");
        lp.add(ORANGE_LEAVES.get(), "Orange Leaves");
        lp.add(ORANGE_SAPLING.get(), "Orange Sapling");
        lp.add(POTTED_ORANGE_SAPLING.get(), "Potted Orange Sapling");

        lp.add(GRAPEFRUIT.get(), "Grapefruit");
        lp.add(GRAPEFRUIT_LEAVES.get(), "Grapefruit Leaves");
        lp.add(GRAPEFRUIT_SAPLING.get(), "Grapefruit Sapling");
        lp.add(POTTED_GRAPEFRUIT_SAPLING.get(), "Potted Grapefruit Sapling");
    }
}

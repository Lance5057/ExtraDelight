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

    public static void blockModels(BlockStateProvider bsp) {
        BlockModels.fruitLeafBlock(bsp, LEMON_LEAVES.get(), "lemon");
        bsp.simpleBlock(LEMON_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("lemon_sapling", bsp.modLoc("block/crops/fruit/lemon/lemon_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_LEMON_SAPLING.get(), "lemon_sapling", "crops/fruit/lemon/lemon_sapling");
    }

    public static void itemModels(ItemModelProvider tmp) {
        ItemModels.forItem(tmp, LEMON, "crops/fruit/lemon/lemon");
        ItemModels.forBlockItem(tmp, LEMON_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lemon/lemon_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, LEMON_SAPLING_ITEM, "crops/fruit/lemon/lemon_sapling");
    }

    public static void EngLoc(LanguageProvider lp) {
        lp.add(LEMON.get(), "Lemon");
        lp.add(LEMON_LEAVES.get(), "Lemon Leaves");
        lp.add(LEMON_SAPLING.get(), "Lemon Sapling");
        lp.add(POTTED_LEMON_SAPLING.get(), "Potted Lemon Sapling");
    }
}

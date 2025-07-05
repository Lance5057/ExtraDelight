package com.lance5057.extradelight.modules;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.blocks.fluids.VinegarFluidBlock;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.data.recipebuilders.JuicerRecipeBuilder;
import com.lance5057.extradelight.util.EDItemGenerator;
import com.lance5057.extradelight.worldgen.features.trees.ExtraDelightTreeGrowers;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.registry.ModBlocks;

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
    public static final DeferredItem<Item> LEMON_JUICE = EDItemGenerator
            .register("lemon_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
            .advancementIngredients().finish();
    public static final DeferredItem<Item> LEMON_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
            "lemon_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.LEMON_JUICE));
    public static final DeferredBlock<VinegarFluidBlock> LEMON_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
            "lemon_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.LEMON_JUICE.FLUID.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final DeferredBlock<Block> LEMON_CRATE = ExtraDelightBlocks.BLOCKS.register("lemon_crate",
            () -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
    public static final DeferredItem<Item> LEMON_CRATE_ITEM = ExtraDelightItems.ITEMS.register("lemon_crate_item",
            () -> new BlockItem(LEMON_CRATE.get(), new Item.Properties()));

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
    public static final DeferredItem<Item> LIME_JUICE = EDItemGenerator
            .register("lime_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
            .advancementIngredients().finish();
    public static final DeferredItem<Item> LIME_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
            "lime_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.LIME_JUICE));
    public static final DeferredBlock<VinegarFluidBlock> LIME_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
            "lime_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.LIME_JUICE.FLUID.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final DeferredBlock<Block> LIME_CRATE = ExtraDelightBlocks.BLOCKS.register("lime_crate",
            () -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
    public static final DeferredItem<Item> LIME_CRATE_ITEM = ExtraDelightItems.ITEMS.register("lime_crate_item",
            () -> new BlockItem(LIME_CRATE.get(), new Item.Properties()));

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
    public static final DeferredItem<Item> ORANGE_JUICE = EDItemGenerator
            .register("orange_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
            .advancementIngredients().finish();
    public static final DeferredItem<Item> ORANGE_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
            "orange_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.ORANGE_JUICE));
    public static final DeferredBlock<VinegarFluidBlock> ORANGE_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
            "orange_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.ORANGE_JUICE.FLUID.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final DeferredBlock<Block> ORANGE_CRATE = ExtraDelightBlocks.BLOCKS.register("orange_crate",
            () -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
    public static final DeferredItem<Item> ORANGE_CRATE_ITEM = ExtraDelightItems.ITEMS.register("orange_crate_item",
            () -> new BlockItem(ORANGE_CRATE.get(), new Item.Properties()));

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
    public static final DeferredItem<Item> GRAPEFRUIT_JUICE = EDItemGenerator
            .register("grapefruit_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
            .advancementIngredients().finish();
    public static final DeferredItem<Item> GRAPEFRUIT_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
            "grapefruit_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.GRAPEFRUIT_JUICE));
    public static final DeferredBlock<VinegarFluidBlock> GRAPEFRUIT_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
            "grapefruit_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.GRAPEFRUIT_JUICE.FLUID.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final DeferredBlock<Block> GRAPEFRUIT_CRATE = ExtraDelightBlocks.BLOCKS.register("grapefruit_crate",
            () -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
    public static final DeferredItem<Item> GRAPEFRUIT_CRATE_ITEM = ExtraDelightItems.ITEMS.register("grapefruit_crate_item",
            () -> new BlockItem(GRAPEFRUIT_CRATE.get(), new Item.Properties()));

    // Egg separating
    public static final DeferredItem<Item> EGG_YOLK = EDItemGenerator.register("egg_yolk",
            () -> new Item(new Item.Properties().craftRemainder(Items.BONE_MEAL))).advancementIngredients().finish();
    public static final DeferredItem<Item> EGG_WHITE = EDItemGenerator.register("egg_white",
            () -> new Item(new Item.Properties().craftRemainder(Items.BOWL))).advancementIngredients().finish();
    public static final DeferredItem<Item> EGG_WHITE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
            "egg_white_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.EGG_WHITE));
    public static final DeferredBlock<LiquidBlock> EGG_WHITE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
            "egg_white_fluid_block", () -> new LiquidBlock(ExtraDelightFluids.EGG_WHITE.FLUID.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));

    public static void blockModels(BlockStateProvider bsp) {
        BlockModels.fruitLeafBlock(bsp, LEMON_LEAVES.get(), "lemon");
        bsp.simpleBlock(LEMON_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("lemon_sapling", bsp.modLoc("block/crops/fruit/lemon/lemon_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_LEMON_SAPLING.get(), "lemon_sapling", "crops/fruit/lemon/lemon_sapling");
        BlockModels.crateBlock(bsp, LEMON_CRATE.get(), "lemon", "oak");

        BlockModels.fruitLeafBlock(bsp, LIME_LEAVES.get(), "lime");
        bsp.simpleBlock(LIME_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("lime_sapling", bsp.modLoc("block/crops/fruit/lime/lime_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_LIME_SAPLING.get(), "lime_sapling", "crops/fruit/lime/lime_sapling");
        BlockModels.crateBlock(bsp, LIME_CRATE.get(), "lime", "oak");

        BlockModels.fruitLeafBlock(bsp, ORANGE_LEAVES.get(), "orange");
        bsp.simpleBlock(ORANGE_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("orange_sapling", bsp.modLoc("block/crops/fruit/orange/orange_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_ORANGE_SAPLING.get(), "orange_sapling", "crops/fruit/orange/orange_sapling");
        BlockModels.crateBlock(bsp, ORANGE_CRATE.get(), "orange", "oak");

        BlockModels.fruitLeafBlock(bsp, GRAPEFRUIT_LEAVES.get(), "grapefruit");
        bsp.simpleBlock(GRAPEFRUIT_SAPLING.get(), new ConfiguredModel(bsp.models()
                .cross("grapefruit_sapling", bsp.modLoc("block/crops/fruit/grapefruit/grapefruit_sapling")).renderType("cutout")));
        BlockModels.pottedBlock(bsp, POTTED_GRAPEFRUIT_SAPLING.get(), "grapefruit_sapling", "crops/fruit/grapefruit/grapefruit_sapling");
        BlockModels.crateBlock(bsp, GRAPEFRUIT_CRATE.get(), "grapefruit", "oak");

        BlockModels.fluid(bsp, EGG_WHITE_FLUID_BLOCK.get());
    }

    public static void itemModels(ItemModelProvider tmp) {
        ItemModels.forItem(tmp, LEMON, "crops/fruit/lemon/lemon");
        ItemModels.forBlockItem(tmp, LEMON_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lemon/lemon_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, LEMON_SAPLING_ITEM, "crops/fruit/lemon/lemon_sapling");
//        ItemModels.forItem(tmp, LEMON_JUICE, "lemon_juice_bottle");
//        ItemModels.forItem(tmp, LEMON_JUICE_FLUID_BUCKET, "lemon_juice_bucket");
        ItemModels.forBlockItem(tmp, LEMON_CRATE_ITEM, "lemon_crate");

        ItemModels.forItem(tmp, LIME, "crops/fruit/lime/lime");
        ItemModels.forBlockItem(tmp, LIME_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lime/lime_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, LIME_SAPLING_ITEM, "crops/fruit/lime/lime_sapling");
//        ItemModels.forItem(tmp, LIME_JUICE, "lime_juice_bottle");
//        ItemModels.forItem(tmp, LIME_JUICE_FLUID_BUCKET, "lime_juice_bucket");
        ItemModels.forBlockItem(tmp, LIME_CRATE_ITEM, "lime_crate");

        ItemModels.forItem(tmp, ORANGE, "crops/fruit/orange/orange");
        ItemModels.forBlockItem(tmp, ORANGE_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/orange/orange_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, ORANGE_SAPLING_ITEM, "crops/fruit/orange/orange_sapling");
//        ItemModels.forItem(tmp, ORANGE_JUICE, "orange_juice_bottle");
//        ItemModels.forItem(tmp, ORANGE_JUICE_FLUID_BUCKET, "orange_juice_bucket");
        ItemModels.forBlockItem(tmp, ORANGE_CRATE_ITEM, "orange_crate");

        ItemModels.forItem(tmp, GRAPEFRUIT, "crops/fruit/grapefruit/grapefruit");
        ItemModels.forBlockItem(tmp, GRAPEFRUIT_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/grapefruit/grapefruit_leaves_stage0"));
        ItemModels.forBlockItemFlat(tmp, GRAPEFRUIT_SAPLING_ITEM, "crops/fruit/grapefruit/grapefruit_sapling");
//        ItemModels.forItem(tmp, GRAPEFRUIT_JUICE, "grapefruit_juice_bottle");
//        ItemModels.forItem(tmp, GRAPEFRUIT_JUICE_FLUID_BUCKET, "grapefruit_juice_bucket");
        ItemModels.forBlockItem(tmp, GRAPEFRUIT_CRATE_ITEM, "grapefruit_crate");

//        ItemModels.forItem(tmp, EGG_YOLK, "egg_yolk");
//        ItemModels.forItem(tmp, EGG_WHITE, "egg_white");
//        ItemModels.forItem(tmp, EGG_WHITE_FLUID_BUCKET, "egg_white_bucket");
    }

    public static void Recipes(RecipeOutput consumer) {
        // Vanilla Crafting
        Recipes.bucket("lemon_juice", consumer, LEMON_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
                LEMON_JUICE.get());
        Recipes.bucket("lime_juice", consumer, LIME_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
                LIME_JUICE.get());
        Recipes.bucket("orange_juice", consumer, ORANGE_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
                ORANGE_JUICE.get());
        Recipes.bucket("grapefruit_juice", consumer, GRAPEFRUIT_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
                GRAPEFRUIT_JUICE.get());
        Recipes.bucket("egg_white", consumer, EGG_WHITE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
                EGG_WHITE.get());

        Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.LEMON), LEMON_CRATE_ITEM.get(), LEMON.get(),
                consumer, "lemon");
        Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.LIME), LIME_CRATE_ITEM.get(), LIME.get(),
                consumer, "lime");
        Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.ORANGE), ORANGE_CRATE_ITEM.get(), ORANGE.get(),
                consumer, "orange");
        Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.GRAPEFRUIT), GRAPEFRUIT_CRATE_ITEM.get(), GRAPEFRUIT.get(),
                consumer, "grapefruit");

        // Juicer
        JuicerRecipeBuilder.squeeze(Ingredient.of(LEMON), new ItemStack(Items.BONE_MEAL),
                new FluidStack(ExtraDelightFluids.LEMON_JUICE.FLUID, 250))
                .save(consumer, ExtraDelight.modLoc("lemon_juice"));
        JuicerRecipeBuilder.squeeze(Ingredient.of(LIME), new ItemStack(Items.BONE_MEAL),
                        new FluidStack(ExtraDelightFluids.LIME_JUICE.FLUID, 250))
                .save(consumer, ExtraDelight.modLoc("lime_juice"));
        JuicerRecipeBuilder.squeeze(Ingredient.of(ORANGE), new ItemStack(Items.BONE_MEAL),
                        new FluidStack(ExtraDelightFluids.ORANGE_JUICE.FLUID, 250))
                .save(consumer, ExtraDelight.modLoc("orange_juice"));
        JuicerRecipeBuilder.squeeze(Ingredient.of(GRAPEFRUIT), new ItemStack(Items.BONE_MEAL),
                        new FluidStack(ExtraDelightFluids.GRAPEFRUIT_JUICE.FLUID, 250))
                .save(consumer, ExtraDelight.modLoc("grapefruit_juice"));
    }

    public static void EngLoc(LanguageProvider lp) {
        lp.add(LEMON.get(), "Lemon");
        lp.add(LEMON_LEAVES.get(), "Lemon Leaves");
        lp.add(LEMON_SAPLING.get(), "Lemon Sapling");
        lp.add(POTTED_LEMON_SAPLING.get(), "Potted Lemon Sapling");
        lp.add(LEMON_JUICE.get(), "Lemon Juice");
        lp.add(LEMON_JUICE_FLUID_BUCKET.get(), "Lemon Juice Bucket");
        lp.add("fluid_type.extradelight.lemon_juice_fluid", "Lemon Juice");
        lp.add("block.extradelight.lemon_juice_fluid_block", "Lemon Juice");
        lp.add(LEMON_CRATE.get(), "Lemon Crate");

        lp.add(LIME.get(), "Lime");
        lp.add(LIME_LEAVES.get(), "Lime Leaves");
        lp.add(LIME_SAPLING.get(), "Lime Sapling");
        lp.add(POTTED_LIME_SAPLING.get(), "Potted Lime Sapling");
        lp.add(LIME_JUICE.get(), "Lime Juice");
        lp.add(LIME_JUICE_FLUID_BUCKET.get(), "Lime Juice Bucket");
        lp.add("fluid_type.extradelight.lime_juice_fluid", "Lime Juice");
        lp.add("block.extradelight.lime_juice_fluid_block", "Lime Juice");
        lp.add(LIME_CRATE.get(), "Lime Crate");

        lp.add(ORANGE.get(), "Orange");
        lp.add(ORANGE_LEAVES.get(), "Orange Leaves");
        lp.add(ORANGE_SAPLING.get(), "Orange Sapling");
        lp.add(POTTED_ORANGE_SAPLING.get(), "Potted Orange Sapling");
        lp.add(ORANGE_JUICE.get(), "Orange Juice");
        lp.add(ORANGE_JUICE_FLUID_BUCKET.get(), "Orange Juice Bucket");
        lp.add("fluid_type.extradelight.orange_juice_fluid", "Orange Juice");
        lp.add("block.extradelight.orange_juice_fluid_block", "Orange Juice");
        lp.add(ORANGE_CRATE.get(), "Orange Crate");

        lp.add(GRAPEFRUIT.get(), "Grapefruit");
        lp.add(GRAPEFRUIT_LEAVES.get(), "Grapefruit Leaves");
        lp.add(GRAPEFRUIT_SAPLING.get(), "Grapefruit Sapling");
        lp.add(POTTED_GRAPEFRUIT_SAPLING.get(), "Potted Grapefruit Sapling");
        lp.add(GRAPEFRUIT_JUICE.get(), "Grapefruit Juice");
        lp.add(GRAPEFRUIT_JUICE_FLUID_BUCKET.get(), "Grapefruit Juice Bucket");
        lp.add("fluid_type.extradelight.grapefruit_juice_fluid", "Grapefruit Juice");
        lp.add("block.extradelight.grapefruit_juice_fluid_block", "Grapefruit Juice");
        lp.add(GRAPEFRUIT_CRATE.get(), "Grapefruit Crate");

        lp.add(EGG_YOLK.get(), "Egg Yolk");
        lp.add(EGG_WHITE.get(), "Egg White");
        lp.add(EGG_WHITE_FLUID_BUCKET.get(), "Egg White Bucket");
        lp.add("fluid_type.extradelight.egg_white_fluid", "Egg White");
        lp.add("block.extradelight.egg_white_fluid_block", "Egg White");
    }
}

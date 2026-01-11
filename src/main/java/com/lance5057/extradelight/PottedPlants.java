package com.lance5057.extradelight;

import com.lance5057.extradelight.modules.SummerCitrus;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedPlants {
    public static void setup() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.CINNAMON_SAPLING.getId(), ExtraDelightBlocks.POTTED_CINNAMON_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.HAZELNUT_SAPLING.getId(), ExtraDelightBlocks.POTTED_HAZELNUT_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.APPLE_SAPLING.getId(), ExtraDelightBlocks.POTTED_APPLE_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SummerCitrus.LEMON_SAPLING.getId(), SummerCitrus.POTTED_LEMON_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SummerCitrus.LIME_SAPLING.getId(), SummerCitrus.POTTED_LIME_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SummerCitrus.ORANGE_SAPLING.getId(), SummerCitrus.POTTED_ORANGE_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SummerCitrus.GRAPEFRUIT_SAPLING.getId(), SummerCitrus.POTTED_GRAPEFRUIT_SAPLING);
    }
}

package com.lance5057.extradelight;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedPlants {
    public static void setup() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.CINNAMON_SAPLING.getId(), ExtraDelightBlocks.POTTED_CINNAMON_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.HAZELNUT_SAPLING.getId(), ExtraDelightBlocks.POTTED_HAZELNUT_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ExtraDelightBlocks.APPLE_SAPLING.getId(), ExtraDelightBlocks.POTTED_APPLE_SAPLING);
    }
}

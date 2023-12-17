package com.lance5057.extradelight.worldgen.features;

import com.lance5057.extradelight.ExtraDelightBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ExtraDelightTreeFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON = FeatureUtils.register("cinnamon", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
            new ForkingTrunkPlacer(5, 2, 2),
            BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
}

package com.lance5057.extradelight.worldgen.placers;

import com.lance5057.extradelight.blocks.AbstractFruitLeafBlock;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluids;

public class FruitLeafPlacer extends FancyFoliagePlacer {
	public static final MapCodec<FruitLeafPlacer> CODEC = RecordCodecBuilder
			.mapCodec(p_68518_ -> blobParts(p_68518_).apply(p_68518_, FruitLeafPlacer::new));

	public FruitLeafPlacer(IntProvider p_161397_, IntProvider p_161398_, int p_161399_) {
		super(p_161397_, p_161398_, p_161399_);
	}

	@Override
	protected FoliagePlacerType<FruitLeafPlacer> type() {
		return FoliagePlacerRegistry.FRUIT_LEAF.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_225582_, FoliagePlacer.FoliageSetter p_273184_,
			RandomSource p_225584_, TreeConfiguration p_225585_, int p_225586_,
			FoliagePlacer.FoliageAttachment p_225587_, int p_225588_, int p_225589_, int p_225590_) {
		for (int i = p_225590_; i >= p_225590_ - p_225588_; i--) {
			int j = p_225589_ + (i != p_225590_ && i != p_225590_ - p_225588_ ? 1 : 0);

			if (i == p_225590_ || i == p_225590_ - p_225588_)
				this.placeLeavesRowFruit(p_225582_, p_273184_, p_225584_, p_225585_, p_225587_.pos(), j, i,
						p_225587_.doubleTrunk());
			else
				this.placeLeavesRow(p_225582_, p_273184_, p_225584_, p_225585_, p_225587_.pos(), j, i,
						p_225587_.doubleTrunk());
		}
	}

	@Override
	protected void placeLeavesRow(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter,
			RandomSource random, TreeConfiguration treeConfiguration, BlockPos pos, int range, int localY,
			boolean large) {
		int i = large ? 1 : 0;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j = -range; j <= range + i; j++) {
			for (int k = -range; k <= range + i; k++) {
				if (!this.shouldSkipLocationSigned(random, j, localY, k, range, large)) {
					blockpos$mutableblockpos.setWithOffset(pos, j, localY, k);
					if (j == -(range - 1) || j == range + i - 1 || k == -(range - 1) || k == range + i - 1)
						tryPlaceFruitLeaf(level, foliageSetter, random, treeConfiguration, blockpos$mutableblockpos);
					else
						tryPlaceSterileFruitLeaf(level, foliageSetter, random, treeConfiguration,
								blockpos$mutableblockpos);
				}
			}
		}
	}

	protected void placeLeavesRowFruit(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter,
			RandomSource random, TreeConfiguration treeConfiguration, BlockPos pos, int range, int localY,
			boolean large) {
		int i = large ? 1 : 0;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j = -range; j <= range + i; j++) {
			for (int k = -range; k <= range + i; k++) {
				if (!this.shouldSkipLocationSigned(random, j, localY, k, range, large)) {
					blockpos$mutableblockpos.setWithOffset(pos, j, localY, k);
					tryPlaceFruitLeaf(level, foliageSetter, random, treeConfiguration, blockpos$mutableblockpos);
				}
			}
		}
	}

	protected static boolean tryPlaceFruitLeaf(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter,
			RandomSource random, TreeConfiguration treeConfiguration, BlockPos pos) {
		if (!TreeFeature.validTreePos(level, pos)) {
			return false;
		} else {
			BlockState blockstate = treeConfiguration.foliageProvider.getState(random, pos);

			blockstate = blockstate.setValue(AbstractFruitLeafBlock.STERILE, random.nextBoolean());

			if (blockstate.hasProperty(BlockStateProperties.WATERLOGGED)) {
				blockstate = blockstate.setValue(BlockStateProperties.WATERLOGGED, Boolean
						.valueOf(level.isFluidAtPosition(pos, p_225638_ -> p_225638_.isSourceOfType(Fluids.WATER))));
			}

			foliageSetter.set(pos, blockstate);
			return true;
		}
	}

	protected static boolean tryPlaceSterileFruitLeaf(LevelSimulatedReader level,
			FoliagePlacer.FoliageSetter foliageSetter, RandomSource random, TreeConfiguration treeConfiguration,
			BlockPos pos) {
		if (!TreeFeature.validTreePos(level, pos)) {
			return false;
		} else {
			BlockState blockstate = treeConfiguration.foliageProvider.getState(random, pos);

			blockstate = blockstate.setValue(AbstractFruitLeafBlock.STERILE, true);

			if (blockstate.hasProperty(BlockStateProperties.WATERLOGGED)) {
				blockstate = blockstate.setValue(BlockStateProperties.WATERLOGGED, Boolean
						.valueOf(level.isFluidAtPosition(pos, p_225638_ -> p_225638_.isSourceOfType(Fluids.WATER))));
			}

			foliageSetter.set(pos, blockstate);
			return true;
		}
	}
}

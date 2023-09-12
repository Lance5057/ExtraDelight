package com.lance5057.extradelight.worldgen.features;

import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class CornMazeFeature extends Feature<SimpleBlockConfiguration> {
	public CornMazeFeature(Codec<SimpleBlockConfiguration> p_66808_) {
		super(p_66808_);
	}

	/**
	 * Places the given feature at the given location. During world generation,
	 * features are provided with a 3x3 region of chunks, centered on the chunk
	 * being generated, that they can safely generate into.
	 * 
	 * @param pContext A context object with a reference to the level and the
	 *                 position the feature is being placed at
	 */
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> p_160341_) {
		SimpleBlockConfiguration simpleblockconfiguration = p_160341_.config();
		WorldGenLevel worldgenlevel = p_160341_.level();
		BlockPos blockpos = p_160341_.origin();
		BlockState blockstate = simpleblockconfiguration.toPlace().getState(p_160341_.random(), blockpos);
		if (blockstate.canSurvive(worldgenlevel, blockpos)) {
			if (blockstate.getBlock() instanceof CornBottom) {
				if (!worldgenlevel.isEmptyBlock(blockpos.above())) {
					return false;
				}

				CornBottom.placeAt(worldgenlevel, blockstate, blockpos, 2);
			} else {
				worldgenlevel.setBlock(blockpos, blockstate, 2);
			}

			return true;
		} else {
			return false;
		}
	}
}
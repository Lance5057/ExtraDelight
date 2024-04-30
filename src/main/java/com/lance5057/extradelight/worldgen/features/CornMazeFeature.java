//package com.lance5057.extradelight.worldgen.features;
//
//import java.util.Arrays;
//import java.util.List;
//
//import com.lance5057.extradelight.ExtraDelightBlocks;
//import com.lance5057.extradelight.blocks.crops.corn.CornBottom;
//import com.lance5057.extradelight.util.EllersGen;
//import com.mojang.serialization.Codec;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.WorldGenLevel;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
//import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
//
//public class CornMazeFeature extends Feature<SimpleBlockConfiguration> {
//	public CornMazeFeature(Codec<SimpleBlockConfiguration> p_66808_) {
//		super(p_66808_);
//	}
//
//	List<Block> expected = Arrays.asList(ExtraDelightBlocks.CORN_BOTTOM.get(), Blocks.AIR);// ExtraDelightBlocks.CORN_BOTTOM.get();
//
//	/**
//	 * Places the given feature at the given location. During world generation,
//	 * features are provided with a 3x3 region of chunks, centered on the chunk
//	 * being generated, that they can safely generate into.
//	 * 
//	 * @param pContext A context object with a reference to the level and the
//	 *                 position the feature is being placed at
//	 */
//	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> p_160341_) {
//		SimpleBlockConfiguration simpleblockconfiguration = p_160341_.config();
//
//		WorldGenLevel worldgenlevel = p_160341_.level();
//		BlockPos blockpos = p_160341_.origin();
//
//		int cx = worldgenlevel.getChunk(blockpos).getPos().getMinBlockX();
//		int cz = worldgenlevel.getChunk(blockpos).getPos().getMinBlockZ();
//
//		blockpos = new BlockPos(cx, blockpos.getY(), cz);
//		BlockState blockstate = simpleblockconfiguration.toPlace().getState(p_160341_.random(), blockpos);
//
//		int h = 18;
//		int w = 18;
//
//		EllersGen maze = new EllersGen(h, w);
//		maze.makeMaze();
//		// maze.printMaze();
//
//		char[][] m = maze.getMaze();
//
////		// scan area
////		for (int x = 0; x < w - 2; x++) {
////			for (int z = 0; z < h - 2; z++) {
////				BlockPos p = new BlockPos(blockpos.getX() + x, blockpos.getY(), blockpos.getZ() + z);
////				// if (worldgenlevel.getBlockState(p).is(ExtraDelightBlocks.CORN_BOTTOM.get()))
////				// {
////
//////				if (worldgenlevel.getBlockState(p).is(expected)) {
//////					return false;
//////				}
////			}
////		}
//
//		for (int x = 1; x < w - 1; x++) {
//			for (int z = 1; z < h - 1; z++) {
//				if (blockstate.canSurvive(worldgenlevel, blockpos)) {
//					if (blockstate.getBlock() instanceof CornBottom) {
//						BlockPos p = new BlockPos(blockpos.getX() + x - 1, blockpos.getY(), blockpos.getZ() + z - 1);
//
//						if (m[x][z] == '#' && worldgenlevel.canSeeSky(p))
//							if (checkAround(worldgenlevel, p, 5))
//								CornBottom.placeAt(worldgenlevel, blockstate, p, 0);
//						// 
//					}
//				}
//			}
//		}
//
//		return true;
//	}
//
//	boolean checkAround(WorldGenLevel level, BlockPos pos, int size) {
//		for (int x = -size; x < size+1; x++) {
//			for (int z = -size; z < size+1; z++) {
//				BlockPos p = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
//
//				Block b = level.getBlockState(p).getBlock();
//				if (!expected.contains(b))
//					return false;
//
//			}
//		}
//
//		return true;
//	}
//
//}
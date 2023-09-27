package com.lance5057.extradelight.worldgen.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class CornMazeRail extends Feature<SimpleBlockConfiguration> {

	public CornMazeRail(Codec<SimpleBlockConfiguration> pCodec) {
		super(pCodec);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> pContext) {
		SimpleBlockConfiguration config = pContext.config();

		WorldGenLevel worldgenlevel = pContext.level();
		BlockPos blockpos = pContext.origin();

		int cx = worldgenlevel.getChunk(blockpos).getPos().getMinBlockX();
		int cz = worldgenlevel.getChunk(blockpos).getPos().getMinBlockZ();
		
		blockpos = new BlockPos(cx, blockpos.getY(), cz);
		
		if(cz == 0)
		{
			for(int i = 0; i < 16; i++)
			{
				BlockPos p = new BlockPos(blockpos.getX() + i, blockpos.getY(), blockpos.getZ()+8);
				
				for(int j = -1; j < 2; j++)
				{
					BlockPos p2 = new BlockPos(blockpos.getX() + i, blockpos.getY()-1, blockpos.getZ()+j+8);
					worldgenlevel.setBlock(p2, Blocks.GRAVEL.defaultBlockState(), 0);
				}
				
				worldgenlevel.setBlock(p, Blocks.RAIL.defaultBlockState().setValue(RailBlock.SHAPE, RailShape.EAST_WEST), 0);
				
				worldgenlevel.setBlock(new BlockPos(blockpos.getX() + i, blockpos.getY(), blockpos.getZ()+12), Blocks.OAK_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true), 3);
				worldgenlevel.setBlock(new BlockPos(blockpos.getX() + i, blockpos.getY(), blockpos.getZ()+4), Blocks.OAK_FENCE.defaultBlockState().setValue(FenceBlock.EAST, true).setValue(FenceBlock.WEST, true), 3);
			}
			
			return true;
		}
		
		return false;
	}

}

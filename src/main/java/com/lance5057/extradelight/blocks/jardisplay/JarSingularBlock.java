package com.lance5057.extradelight.blocks.jardisplay;

import com.lance5057.extradelight.blocks.RecipeFeastBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JarSingularBlock extends RecipeFeastBlock { 
	public static VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	
	public JarSingularBlock(Properties properties) {
		super(properties, true, SHAPE);
	}

}

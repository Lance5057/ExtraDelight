package com.lance5057.extradelight.blocks.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IStyleable {
	public int numStyles();

	public int getCurrentStyle(BlockState state);

	public BlockState nextStyle(Level level, BlockPos pos,BlockState state);

	public void setStyle(int style);
	
	public boolean isPatreonStyle(int style);
}

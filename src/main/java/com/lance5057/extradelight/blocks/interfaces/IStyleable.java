package com.lance5057.extradelight.blocks.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IStyleable {
	public int numStyles();

	public int getCurrentStyle(BlockState state);

	public void setNextStyle(Level level, BlockPos pos, BlockState state);

	public void setPrevStyle(Level level, BlockPos pos, BlockState state);

	public BlockState getState(int i);

	public void setStyle(Level level, BlockPos pos, BlockState state, int style);

	public boolean isPatreonStyle(int style);
}

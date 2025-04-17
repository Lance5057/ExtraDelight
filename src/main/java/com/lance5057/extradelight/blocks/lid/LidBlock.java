package com.lance5057.extradelight.blocks.lid;

import com.lance5057.extradelight.blocks.interfaces.IStyleable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LidBlock extends Block implements EntityBlock, IStyleable {
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	public static final IntegerProperty STYLE = IntegerProperty.create("style", 0, Styles.values().length);

	public static enum Styles {
		COPPER
	}

	public LidBlock() {
		super(Properties.ofFullCopy(Blocks.COPPER_BLOCK));
		this.registerDefaultState(this.stateDefinition.any().setValue(STYLE, 0));
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
		p_53681_.add(STYLE);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public boolean isPathfindable(BlockState pState, PathComputationType pType) {
		return false;
	}

	@Override
	public int numStyles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentStyle(BlockState state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNextStyle(Level level, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPrevStyle(Level level, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public BlockState getState(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStyle(Level level, BlockPos pos, BlockState state, int style) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPatreonStyle(int style) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return null;
	}

}

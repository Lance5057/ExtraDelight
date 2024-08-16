package com.lance5057.extradelight.blocks.crops;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChiliCrop extends CropBlock {

	public static final int MAX_AGE = 7;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
	        Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
	        Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
	    };

	public ChiliCrop(BlockBehaviour.Properties pProperties) {
		super(pProperties);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return MAX_AGE;
	}

	protected ItemLike getBaseSeedId() {
		return ExtraDelightItems.CHILI_SEEDS.get();
	}
	
	@Override
    protected boolean mayPlaceOn(BlockState p_52302_, BlockGetter p_52303_, BlockPos p_52304_) {
        return p_52302_.is(Blocks.FARMLAND);
    }

	/**
	 * Performs a random tick on a block.
	 */
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt(3) != 0) {
			super.randomTick(pState, pLevel, pPos, pRandom);
		}

	}

	protected int getBonemealAgeIncrease(Level pLevel) {
		return super.getBonemealAgeIncrease(pLevel) / 3;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
	}
}

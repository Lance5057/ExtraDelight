package com.lance5057.extradelight.blocks.crops.strawberry;

import com.lance5057.extradelight.blocks.crops.BushStageFour;
import com.lance5057.extradelight.modules.Strawberry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class StrawberryCrop extends BushStageFour {

	public static final EnumProperty<RunnerConnect> CONNECTED = EnumProperty.create("connect", RunnerConnect.class);
	public static final IntegerProperty GENERATION = IntegerProperty.create("generation", 0, 3);

	public StrawberryCrop(Properties properties) {
		super(Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0), Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
				Strawberry.STRAWBERRY_SEED, properties);

		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(CONNECTED, RunnerConnect.NONE)
				.setValue(GENERATION, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57282_) {
		p_57282_.add(AGE, CONNECTED, GENERATION);
	}

	@Override
	public boolean isRandomlyTicking(BlockState p_57284_) {
		if (p_57284_.getValue(AGE) < MAX_AGE) {
			return true;
		}

		if (p_57284_.getValue(GENERATION) < 3)
			return true;

		return false;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
		super.randomTick(state, level, pos, rand);

		if (state.getValue(GENERATION) < 3) {
			if (state.getValue(AGE) > 1) {
//				if (rand.nextInt() % 1 == 0) {
				Direction d = Direction.getRandom(rand);

				if (d != Direction.UP && d != Direction.DOWN) {
					BlockPos b = pos.offset(d.getNormal());

					if (level.getBlockState(b).isAir()) {
						if (level.getBlockState(b.below()).is(BlockTags.DIRT)) {
							BlockState runner = defaultBlockState()
									.setValue(CONNECTED, RunnerConnect.valueOf(d.getOpposite().name()))
									.setValue(GENERATION, state.getValue(GENERATION) + 1);

							level.setBlock(b, runner, UPDATE_ALL);
						}
					}
				}
//			p_222564_.setBlock(findValidSpot(pState, pLevel, pPos), pState, 2);
			}

		}
	}
}

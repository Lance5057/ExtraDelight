package com.lance5057.extradelight.displays.cabinet;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class HalfCabinetBlock extends CabinetBlock {
	protected static final VoxelShape SHAPE_E = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_N = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_W = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_S = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);

	public static final MapCodec<HalfCabinetBlock> CODEC = simpleCodec(HalfCabinetBlock::new);

	public HalfCabinetBlock() {
		this((Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(0.5F).sound(SoundType.WOOD)));
	}

	public HalfCabinetBlock(Properties properties) {
		super(Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(0.5F).sound(SoundType.WOOD));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Direction d = pState.getValue(FACING);

		if (d == Direction.EAST)
			return SHAPE_E;
		if (d == Direction.WEST)
			return SHAPE_W;
		if (d == Direction.SOUTH)
			return SHAPE_S;
		return SHAPE_N;
	}
}

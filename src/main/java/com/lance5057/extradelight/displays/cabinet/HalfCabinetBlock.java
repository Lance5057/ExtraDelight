package com.lance5057.extradelight.displays.cabinet;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.entity.CabinetBlockEntity;

public class HalfCabinetBlock extends CabinetBlock {
	protected static final VoxelShape SHAPE_E = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_N = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_W = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_S = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);

	public HalfCabinetBlock() {
		super(Block.Properties.copy(Blocks.BARREL));
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

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!level.isClientSide) {
			BlockEntity tile = level.getBlockEntity(pos);
			if (tile instanceof HalfCabinetEntity) {
				player.openMenu((HalfCabinetEntity) tile);
			}
		}
		return InteractionResult.SUCCESS;
	}
	
	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ExtraDelightBlockEntities.HALF_CABINET.get().create(pos, state);
	}
}

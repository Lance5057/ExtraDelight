package com.lance5057.extradelight.aesthetics.block.cornhuskdoll;

import java.util.stream.IntStream;

import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class CornHuskDollBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 8.0D, 16.0D);
	public static final IntegerProperty FACING = BlockStateProperties.ROTATION_16;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty HANGING = BlockStateProperties.HANGING;

	public CornHuskDollBlock() {
		super(Block.Properties.copy(Blocks.YELLOW_WOOL));
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;

	}

	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING, WATERLOGGED, HANGING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
		Direction direction = pContext.getClickedFace();

		return this.defaultBlockState()
				.setValue(FACING,
						Integer.valueOf(
								Mth.floor((double) ((180.0F + pContext.getRotation()) * 16.0F / 360.0F) + 0.5D) & 15))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER))
				.setValue(HANGING, direction != Direction.DOWN ? true : false);

	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return level.getBlockState(pos.below()).getMaterial().isSolid();
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		// TODO Auto-generated method stub
		return new MixingBowlBlockEntity(pPos, pState);
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = level.getBlockEntity(pos);
			if (tileentity instanceof MixingBowlBlockEntity) {
				tileentity.getCapability(ForgeCapabilities.ITEM_HANDLER)
						.ifPresent(itemInteractionHandler -> IntStream.range(0, itemInteractionHandler.getSlots() - 1)
								.forEach(i -> Block.popResource(level, pos, itemInteractionHandler.getStackInSlot(i))));

				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

}

package api.LanceNestAPI.src.blocks;

import javax.annotation.Nonnull;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public abstract class StationGuiless extends StationBlock implements EntityBlock, SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public StationGuiless(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Nonnull
	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		BlockEntity blockentity = pLevel.getBlockEntity(pPos);
		if (blockentity instanceof MultiToolRecipeStation be) {
			if (pPlayer.isCrouching()) {
				if (!pPlayer.addItem(be.extractItem()))
					pLevel.addFreshEntity(new ItemEntity(pLevel, pPos.getX(), pPos.getY() + 1, pPos.getZ(), stack));
			} else if (!be.getInventory().isEmpty()) {
				be.use(pLevel, pPlayer, pHand, stack);
			} else
				pPlayer.setItemInHand(pHand, be.insertItem(stack));
			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public void onRemove(BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, BlockState newState,
			boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			worldIn.updateNeighbourForOutputSignal(pos, this);

			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

		BlockState blockstate = this.defaultBlockState()
				.setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
		return blockstate;
	}
}

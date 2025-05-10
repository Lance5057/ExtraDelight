package com.lance5057.extradelight.blocks;

import com.lance5057.extradelight.modules.Fermentation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UnripeSalamiBlock extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final IntegerProperty COUNT = IntegerProperty.create("count", 0, 3);
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

	private static final VoxelShape SINGLE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
	private static final VoxelShape DOUBLE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
	private static final VoxelShape TRIPLE_NS = Block.box(2.0, 0.0, 4.0, 14.0, 16.0, 12.0);
	private static final VoxelShape TRIPLE_EW = Block.box(4.0, 0.0, 2.0, 12.0, 16.0, 14.0);
	private static final VoxelShape QUAD_NS = Block.box(0.0, 0.0, 4.0, 16.0, 16.0, 12.0);
	private static final VoxelShape QUAD_EW = Block.box(4.0, 0.0, 0.0, 12.0, 16.0, 16.0);

	public UnripeSalamiBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(COUNT, 0).setValue(AGE, 0));
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		int count = state.getValue(COUNT);
		if (count == 0)
			return SINGLE;
		if (count == 1)
			return DOUBLE;

		switch ((Direction) state.getValue(FACING)) {

		case NORTH:
		case SOUTH:
			if (count == 2)
				return TRIPLE_NS;
			else
				return QUAD_NS;
		case WEST:
		case EAST:
		default:
			if (count == 2)
				return TRIPLE_EW;
			else
				return QUAD_EW;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, COUNT, AGE);
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		if (level.getBlockState(pos.above()).isSolid())
			return true;
		return false;
	}

	@Override
	public boolean isRandomlyTicking(BlockState p_54449_) {
		return true;
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(AGE) < 15) {
			if (random.nextInt() % 10 == 0) {
				int i = state.getValue(AGE);
				BlockState blockstate = state.setValue(AGE, Integer.valueOf(i + 1));
				level.setBlock(pos, blockstate, 2);
				level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
			}
		} else
			level.setBlock(pos,
					Fermentation.SALAMI_BLOCK.get().defaultBlockState()
							.setValue(RipeSalamiBlock.COUNT, state.getValue(COUNT))
							.setValue(RipeSalamiBlock.FACING, state.getValue(FACING)),
					Block.UPDATE_ALL);
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide)
			if (stack.is(Fermentation.UNRIPE_SALAMI_ITEM)) {
				if (state.getValue(COUNT) < 3) {
					BlockState s = state.setValue(COUNT, state.getValue(COUNT) + 1).setValue(AGE, 0);
					level.setBlock(pos, s, 2);
					player.getItemInHand(hand).setCount(player.getItemInHand(hand).getCount() - 1);
					return ItemInteractionResult.SUCCESS;
				}
			}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
}

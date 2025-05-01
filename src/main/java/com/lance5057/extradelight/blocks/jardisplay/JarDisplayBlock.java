package com.lance5057.extradelight.blocks.jardisplay;

import com.lance5057.extradelight.util.BlockEntityUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;

public class JarDisplayBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

	protected VoxelShape SHAPE_NW = Block.box(1.0D, 0.0D, 1.0D, 7.0D, 8.0D, 7.0D);
	protected VoxelShape SHAPE_NE = Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 7.0D);
	protected VoxelShape SHAPE_SW = Block.box(1.0D, 0.0D, 9.0D, 7.0D, 8.0D, 15.0D);
	protected VoxelShape SHAPE_SE = Block.box(9.0D, 0.0D, 9.0D, 15.0D, 8.0D, 15.0D);

	protected VoxelShape SOUTH_2 = Shapes.join(SHAPE_SE, SHAPE_SW, BooleanOp.OR);
	protected VoxelShape SOUTH_3 = Shapes.join(SHAPE_NE, SOUTH_2, BooleanOp.OR);

	protected VoxelShape NORTH_2 = Shapes.join(SHAPE_NE, SHAPE_NW, BooleanOp.OR);
	protected VoxelShape NORTH_3 = Shapes.join(SHAPE_SW, NORTH_2, BooleanOp.OR);

	protected VoxelShape WEST_2 = Shapes.join(SHAPE_SW, SHAPE_NW, BooleanOp.OR);
	protected VoxelShape WEST_3 = Shapes.join(SHAPE_SE, WEST_2, BooleanOp.OR);

	protected VoxelShape EAST_2 = Shapes.join(SHAPE_SE, SHAPE_NE, BooleanOp.OR);
	protected VoxelShape EAST_3 = Shapes.join(SHAPE_NW, EAST_2, BooleanOp.OR);

	protected VoxelShape FULL = Shapes.join(SHAPE_NW, SOUTH_3, BooleanOp.OR);

	public JarDisplayBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return new JarDisplayBlockEntity(pos, state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		BlockEntity be = pLevel.getBlockEntity(pPos);
		if (be != null) {
			if (be instanceof JarDisplayBlockEntity jdbe) {
				IItemHandler items = jdbe.getItems();
				boolean i1 = !items.getStackInSlot(1).isEmpty();
				boolean i2 = !items.getStackInSlot(2).isEmpty();
				boolean i3 = !items.getStackInSlot(3).isEmpty();

				Direction d = pState.getValue(JarDisplayBlock.FACING);

				switch (d) {
				case NORTH:
					return setShape(i1, i2, i3, NORTH_2, NORTH_3);
				case SOUTH:
					return setShape(i1, i2, i3, SOUTH_2, SOUTH_3);
				case WEST:
					return setShape(i1, i2, i3, WEST_2, WEST_3);
				case EAST:
					return setShape(i1, i2, i3, EAST_2, EAST_3);
				}
			}
		}
		return SHAPE;
	}

	private VoxelShape setShape(boolean i1, boolean i2, boolean i3, VoxelShape s2, VoxelShape s3) {
		if (i3)
			return FULL;
		if (i2)
			return s3;

		return s2;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide) {
			if (stack.getItem() instanceof BlockItem bi) {
				if (bi.getBlock() instanceof JarSingularBlock b) {

					BlockEntity be = level.getBlockEntity(pos);
					if (be != null && be instanceof JarDisplayBlockEntity jdbe) {
						if (!player.isCrouching()) {
							BlockEntityUtils.Inventory.insertItem(jdbe.getItems(), stack.copy(),
									JarDisplayBlockEntity.NUM_SLOTS);
						} else {
							BlockEntityUtils.Inventory.extractItem(player, jdbe.getItems(),
									JarDisplayBlockEntity.NUM_SLOTS);
							// if only a single item remains convert back to singular jar!
						}
					}

					return ItemInteractionResult.SUCCESS;
				}
			}

		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
			BlockHitResult hitResult) {
		BlockEntity be = level.getBlockEntity(pos);
		if (player.isCrouching()) {
			if (be != null && be instanceof JarDisplayBlockEntity jdbe) {
				BlockEntityUtils.Inventory.extractItem(player, jdbe.getItems(), JarDisplayBlockEntity.NUM_SLOTS);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}

}

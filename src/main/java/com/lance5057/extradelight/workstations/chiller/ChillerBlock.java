package com.lance5057.extradelight.workstations.chiller;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.utility.MathUtils;

public class ChillerBlock extends Block implements EntityBlock {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
//	public static final EnumProperty<ChillerSupport> SUPPORT = EnumProperty.create("support", ChillerSupport.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape SHAPE = Block.box(0.0D, 1.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public ChillerBlock() {
		super(Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.5F, 6.0F)
				.sound(SoundType.STONE));
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
			BlockHitResult hitResult) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof ChillerBlockEntity mbe) {
			MenuProvider containerProvider = new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.translatable("screen.melting_pot.name");
				}

				@Override
				public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
					return new ChillerMenu(windowId, playerInventory, mbe);
				}
			};
			player.openMenu(containerProvider, buf -> buf.writeBlockPos(pos));

		}
		return InteractionResult.CONSUME;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

//	@Override
//	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
//		return state.getValue(SUPPORT).equals(ChillerSupport.TRAY) ? SHAPE_WITH_TRAY : SHAPE;
//	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		FluidState fluid = level.getFluidState(context.getClickedPos());

		BlockState state = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

		return state;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
//		if (facing.getAxis().equals(Direction.Axis.Y) && !state.getValue(SUPPORT).equals(ChillerSupport.HANDLE)) {
//			return state.setValue(SUPPORT, getTrayState(level, currentPos));
//		}
		return state;
	}

//	private ChillerSupport getTrayState(LevelAccessor level, BlockPos pos) {
//		if (level.getBlockState(pos.below()).is(ModTags.TRAY_HEAT_SOURCES)) {
//			return ChillerSupport.TRAY;
//		}
//		return ChillerSupport.NONE;
//	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof ChillerBlockEntity ChillerEntity) {
//				Containers.dropContents(level, pos, ChillerEntity.);
				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof ChillerBlockEntity) {
			ItemStackHandler inventory = ((ChillerBlockEntity) tileEntity).getInventory();
			return MathUtils.calcRedstoneFromItemHandler(inventory);
		}
		return 0;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ExtraDelightBlockEntities.CHILLER.get().create(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		if (!pLevel.isClientSide())
			return pBlockEntityType == ExtraDelightBlockEntities.CHILLER.get() ? ChillerBlockEntity::tick : null;
		return null;
	}

}

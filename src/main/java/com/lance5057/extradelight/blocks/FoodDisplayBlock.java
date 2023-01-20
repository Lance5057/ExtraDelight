package com.lance5057.extradelight.blocks;

import java.util.stream.IntStream;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.blocks.entities.FoodDisplayEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;

public class FoodDisplayBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty ENCASED = BooleanProperty.create("encased");
	
	private final int NUM_SLOTS_TOP;
	private final int NUM_SLOTS_BOTTOM;

	public FoodDisplayBlock(int slots_top, int slots_bottom) {
		super(Properties.of(Material.METAL).strength(0.5F, 6.0F).sound(SoundType.WOOD).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
				.setValue(WATERLOGGED, false).setValue(ENCASED, false));
		this.NUM_SLOTS_TOP = slots_top;
		this.NUM_SLOTS_BOTTOM = slots_bottom;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
			if(player.getItemInHand(hand).getItem() == Items.GLASS)
			{
				if(state.getValue(FoodDisplayBlock.ENCASED) == false)
				{
					//state.setValue(FoodDisplayBlock.ENCASED, true);
					level.setBlock(pos, state.setValue(FoodDisplayBlock.ENCASED, true), 2);
					player.getItemInHand(hand).setCount(player.getItemInHand(hand).getCount()-1);
					return InteractionResult.SUCCESS;
				}
			}
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof FoodDisplayEntity ent) {
				NetworkHooks.openScreen((ServerPlayer) player, ent, pos);
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return ExtraDelightBlockEntities.FOOD_DISPLAY.get().create(pPos, pState).setSlots(NUM_SLOTS_TOP, NUM_SLOTS_BOTTOM);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, ENCASED, WATERLOGGED);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

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
		return state;
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = level.getBlockEntity(pos);
			if (tileentity instanceof FoodDisplayEntity) {
				tileentity.getCapability(ForgeCapabilities.ITEM_HANDLER)
						.ifPresent(itemInteractionHandler -> IntStream.range(0, itemInteractionHandler.getSlots())
								.forEach(i -> Block.popResource(level, pos, itemInteractionHandler.getStackInSlot(i))));

				level.updateNeighbourForOutputSignal(pos, this);
			}
			
			if(state.getValue(FoodDisplayBlock.ENCASED) == true)
				Block.popResource(level, pos, new ItemStack(Items.GLASS));
			
			super.onRemove(state, level, pos, newState, isMoving);
		}
	}
}

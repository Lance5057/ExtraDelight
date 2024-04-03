package com.lance5057.extradelight.workstations.mortar;

import java.util.stream.IntStream;

import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.displays.knife.KnifeBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class MortarBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D);

	public MortarBlock() {
		this(SoundType.STONE);
	}

	public MortarBlock(SoundType soundType) {
		//strength used to be (1.5f, 2.0f)
		super(Properties.of(Material.STONE).strength(0.5F, 2.0F).sound(soundType).noOcclusion());
	}

	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
		return false;
	}

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {
		if (pLevel.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
			if (tileEntity instanceof MortarBlockEntity mbe) {

				if (pPlayer.getItemInHand(pHand).is(ExtraDelightTags.PESTLES)) {
					mbe.grind(pPlayer);
				} else {
					if (pPlayer.isCrouching()) {
						mbe.extractItem(pPlayer);
					} else {
						mbe.insertItem(pPlayer.getItemInHand(pHand));
					}
				}

			}
			return InteractionResult.CONSUME;
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new MortarBlockEntity(pPos, pState);
	}
	
	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = level.getBlockEntity(pos);
			if (tileentity instanceof MortarBlockEntity) {
				tileentity.getCapability(ForgeCapabilities.ITEM_HANDLER)
						.ifPresent(itemInteractionHandler -> IntStream.range(0, itemInteractionHandler.getSlots())
								.forEach(i -> Block.popResource(level, pos, itemInteractionHandler.getStackInSlot(i))));

				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}
}

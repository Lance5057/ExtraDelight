package com.lance5057.extradelight.workstations.mortar;

import com.lance5057.extradelight.ExtraDelightTags;

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

public class MortarBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

	public MortarBlock() {
		super(Properties.of(Material.STONE).strength(1.5F, 2.0F).sound(SoundType.STONE).noOcclusion());
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
}

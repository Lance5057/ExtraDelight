package com.lance5057.extradelight.workstations.dryingrack;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class DryingRackBlock extends Block implements EntityBlock {

	public DryingRackBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).strength(1, 1).noOcclusion());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Nonnull
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {
		BlockEntity blockentity = pLevel.getBlockEntity(pPos);
		if (blockentity instanceof DryingRackBlockEntity) {
			DryingRackBlockEntity be = (DryingRackBlockEntity) blockentity;

			if (pPlayer.isCrouching()) {
				if (!pLevel.isClientSide) {
					be.extractItem(pPlayer);
					return InteractionResult.SUCCESS;
				}
				return InteractionResult.CONSUME;
			} else {

				ItemStack itemstack = pPlayer.getItemInHand(pHand);
				Optional<DryingRackRecipe> optional = be.matchRecipe(itemstack);
				if (optional.isPresent()) {
					if (!pLevel.isClientSide) {
						// pPlayer.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
						be.insertItem(itemstack, optional.get().getCookingTime());
						return InteractionResult.SUCCESS;
					}

					return InteractionResult.CONSUME;
				}
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new DryingRackBlockEntity(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		return pBlockEntityType == ExtraDelightBlockEntities.DRYING_RACK.get() ? DryingRackBlockEntity::tick : null;
	}
}

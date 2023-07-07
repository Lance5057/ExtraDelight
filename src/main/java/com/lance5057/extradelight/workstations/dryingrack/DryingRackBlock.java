package com.lance5057.extradelight.workstations.dryingrack;

import java.util.Optional;
import java.util.stream.IntStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.workstations.mortar.MortarBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class DryingRackBlock extends Block implements EntityBlock {

	public DryingRackBlock() {
		// strength used to be (1, 1)
		super(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
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
				if (!pLevel.isClientSide) {
					// pPlayer.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
					be.insertItem(itemstack);
					return InteractionResult.SUCCESS;
				}

				return InteractionResult.CONSUME;
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

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = level.getBlockEntity(pos);
			if (tileentity instanceof DryingRackBlockEntity) {
				tileentity.getCapability(ForgeCapabilities.ITEM_HANDLER)
						.ifPresent(itemInteractionHandler -> IntStream.range(0, itemInteractionHandler.getSlots())
								.forEach(i -> Block.popResource(level, pos, itemInteractionHandler.getStackInSlot(i))));

				level.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}
}

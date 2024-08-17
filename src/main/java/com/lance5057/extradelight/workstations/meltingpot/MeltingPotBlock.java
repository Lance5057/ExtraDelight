package com.lance5057.extradelight.workstations.meltingpot;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MeltingPotBlock extends Block implements EntityBlock {

	public MeltingPotBlock(Properties p_49795_) {
		super(p_49795_);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new MeltingPotBlockEntity(p_153215_, p_153216_);
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.isClientSide) {
			return ItemInteractionResult.SUCCESS;
		}
		BlockEntity tileEntity = pLevel.getBlockEntity(pPos);
		if (tileEntity instanceof MeltingPotBlockEntity mbe) {
			MenuProvider containerProvider = new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.translatable("screen.melting_pot.name");
				}

				@Override
				public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
					return new MeltingPotMenu(windowId, playerInventory, mbe);
				}
			};
			pPlayer.openMenu(containerProvider, buf -> buf.writeBlockPos(pPos));

		}
		return ItemInteractionResult.CONSUME;

	}

}

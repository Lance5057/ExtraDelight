package com.lance5057.extradelight.workstations.meltingpot;

import java.util.Objects;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightContainers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.SlotItemHandler;

public class MeltingPotMenu extends AbstractContainerMenu {
	public final MeltingPotBlockEntity tileEntity;
	private final ContainerLevelAccess canInteractWithCallable;
	protected final Level level;

	protected MeltingPotMenu(int windowId, final Inventory playerInventory, final MeltingPotBlockEntity tileEntity) {
		super(ExtraDelightContainers.MELTING_POT_MENU.get(), windowId);
		this.tileEntity = tileEntity;
		this.level = playerInventory.player.level();
		this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());

		if (tileEntity != null) {
			int startX = 8;
			int startY = 8;
			int inputStartX = 64;
			int inputStartY = 5;
			int borderSlotSize = 18;

			this.addSlot(
					new SlotItemHandler(tileEntity.getItemHandler(), MeltingPotBlockEntity.INPUT_SLOT, 46, 23));
			this.addSlot(
					new SlotItemHandler(tileEntity.getItemHandler(), MeltingPotBlockEntity.BUCKET_SLOT, 114, 26));
			this.addSlot(
					new SlotItemHandler(tileEntity.getItemHandler(), MeltingPotBlockEntity.BUCKET_SLOT_OUT, 114, 50));
			
			// Main Player Inventory
			int startPlayerInvY = startY * 4 + 51;
			for (int row = 0; row < 3; ++row) {
				for (int column = 0; column < 9; ++column) {
					this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * borderSlotSize),
							startPlayerInvY + (row * borderSlotSize)));
				}
			}

			// Hotbar
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInventory, column, startX + (column * borderSlotSize), 141));
			}
		}
	}

	public MeltingPotMenu(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public FluidTank getFluidTank()
	{
		return this.tileEntity.getFluidTank();
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		int indexOutput = 2;
		int startPlayerInv = indexOutput;
		int endPlayerInv = startPlayerInv + 36;

		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();

			if (index < startPlayerInv) {
				if (!this.moveItemStackTo(itemstack1, startPlayerInv, endPlayerInv, true)) {
					return ItemStack.EMPTY;
				}

			} else {
				if (!this.moveItemStackTo(itemstack1, 0, indexOutput, false)) {
					return ItemStack.EMPTY;
				}
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(player, itemstack1);
		}
		return itemstack;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(canInteractWithCallable, pPlayer, ExtraDelightBlocks.MELTING_POT.get());
	}

	private static MeltingPotBlockEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof MeltingPotBlockEntity) {
			return (MeltingPotBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

}

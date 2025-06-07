package com.lance5057.extradelight.workstations.vat;

import java.util.Objects;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightContainers;
import com.lance5057.extradelight.gui.FancyTankInSlot;
import com.lance5057.extradelight.gui.FancyTankOutSlot;
import com.lance5057.extradelight.workstations.FancyTank;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class VatMenu extends AbstractContainerMenu {

	public final VatBlockEntity tileEntity;
	private final ContainerLevelAccess canInteractWithCallable;
	protected final Level level;

	protected VatMenu(int windowId, final Inventory playerInventory, final VatBlockEntity tileEntity) {
		super(ExtraDelightContainers.VAT_MENU.get(), windowId);
		this.tileEntity = tileEntity;
		this.level = playerInventory.player.level();
		this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());

		if (tileEntity != null) {
			// Ingredient Slots - 2 Rows x 3 Columns
			int startX = 8;
			int startY = 8;
			int inputStartX = 55;
			int inputStartY = -5;
			int borderSlotSize = 18;
			for (int row = 0; row < 2; ++row) {
				for (int column = 0; column < 3; ++column) {
					this.addSlot(new SlotItemHandler(tileEntity.getItemHandler(), (row * 3) + column,
							inputStartX + (column * borderSlotSize), inputStartY + (row * borderSlotSize)));
				}
			}

			this.addSlot(
					new SlotItemHandler(tileEntity.getItemHandler(), VatBlockEntity.FERMENTATION_INPUT_SLOT, 55, 51));

			this.addSlot(new FancyTankInSlot(tileEntity.getItemHandler(), tileEntity.getFluidTank(),
					VatBlockEntity.LIQUID_IN_SLOT, 8, -5));
			this.addSlot(new FancyTankOutSlot(tileEntity.getItemHandler(), tileEntity.getFluidTank(),
					VatBlockEntity.LIQUID_OUT_SLOT, 8, 51));

			this.addSlot(new SlotItemHandler(tileEntity.getItemHandler(), VatBlockEntity.OUTPUT_SLOT, 151, 32));

			this.addSlot(new SlotItemHandler(tileEntity.getItemHandler(), VatBlockEntity.CONTAINER_SLOT, 151, 51) {

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			});

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

	public VatMenu(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public FancyTank getFluidTank() {
		return this.tileEntity.getFluidTank();
	}

	private static VatBlockEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof VatBlockEntity) {
			return (VatBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		int indexOutput = 9;
		int startPlayerInv = indexOutput;
		int endPlayerInv = startPlayerInv + 36;

		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(pIndex);
		if (slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();

			if (pIndex < startPlayerInv) {
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

			slot.onTake(pPlayer, itemstack1);
		}
		return itemstack;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(canInteractWithCallable, pPlayer, ExtraDelightBlocks.VAT.get());
	}

}
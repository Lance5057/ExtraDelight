package api.LanceNestAPI.src.AdvancedDisplay;

import java.util.Objects;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.gui.HideableSlot;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.network.AdvancedDisplaySyncPacket;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AdvancedDisplayMenu extends AbstractContainerMenu {

	public final AdvancedDisplayBlockEntity tileEntity;
	private final ContainerLevelAccess canInteractWithCallable;
	protected final Level level;
	private final Player player;
	public int index;

	protected AdvancedDisplayMenu(final int windowId, final Inventory playerInventory,
			final AdvancedDisplayBlockEntity tileEntity) {
		super(LanceNestAPI.ADVANCED_DISPLAY_MENU.get(), windowId);
		this.tileEntity = tileEntity;
		this.player = playerInventory.player;
		this.level = playerInventory.player.level();
		this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());

		if (tileEntity != null) {

			// Ingredient Slots - 2 Rows x 3 Columns
			int startX = 8;
			int startY = 8;
			int inputStartX = 8;
			int inputStartY = 8;
			int borderSlotSize = 18;
			for (int row = 0; row < 2; ++row) {
				for (int column = 0; column < 4; ++column) {
					this.addSlot(new HideableSlot(tileEntity.getItems(), (row * 4) + column,
							inputStartX + (column * borderSlotSize), inputStartY + (row * borderSlotSize), true));
				}
			}

//			this.addSlot(new HideableSlot(tileEntity.getItems(), 27, 80, 36, true).setActive(false));

			// Main Player Inventory
			int startPlayerInvY = startY * 4 + 36;
			for (int row = 0; row < 3; ++row) {
				for (int column = 0; column < 9; ++column) {
					this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * borderSlotSize),
							startPlayerInvY + (row * borderSlotSize)));
				}
			}

			// Hotbar
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInventory, column, startX + (column * borderSlotSize), 126));
			}
		}
	}

	public AdvancedDisplayMenu(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	private static AdvancedDisplayBlockEntity getTileEntity(final Inventory playerInventory,
			final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof AdvancedDisplayBlockEntity) {
			return (AdvancedDisplayBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		int indexOutput = AdvancedDisplayBlockEntity.NUM_SLOTS;
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
		return canInteractWithCallable.evaluate((p_38916_, p_38917_) -> {
			return !(p_38916_.getBlockState(p_38917_).getBlock() instanceof AdvancedDisplayBlock) ? false
					: pPlayer.distanceToSqr((double) p_38917_.getX() + 0.5D, (double) p_38917_.getY() + 0.5D,
							(double) p_38917_.getZ() + 0.5D) <= 64.0D;
		}, true);
	}

	@Override
	public void sendAllDataToRemote() {
		super.sendAllDataToRemote();
		if (this.player instanceof ServerPlayer serverPlayer)
			serverPlayer.connection
					.send(new AdvancedDisplaySyncPacket(this.containerId, index, this.tileEntity.getBlockPos()));
	}

	public void set(int i, Transform t) {
		this.canInteractWithCallable.execute((level, pos) -> {
			BlockEntity state = level.getBlockEntity(pos);
			if (state instanceof AdvancedDisplayBlockEntity adbe) {
				adbe.setItemTransform(i, t);
				ExtraDelight.logger.debug(t.toString());
				AdvancedDisplayBlockEntity.update(adbe);
			}
		});
	}
}

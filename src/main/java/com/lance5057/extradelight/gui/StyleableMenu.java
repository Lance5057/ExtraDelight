package com.lance5057.extradelight.gui;

import com.lance5057.extradelight.ExtraDelightContainers;
import com.lance5057.extradelight.blocks.interfaces.IStyleable;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class StyleableMenu extends AbstractContainerMenu {
	private final ContainerLevelAccess access;

	public StyleableMenu(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory);
	}

	public StyleableMenu(int pContainerId, Inventory pPlayerInventory) {
		this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
	}

	public StyleableMenu(int pContainerId, Inventory pPlayerInventory, final ContainerLevelAccess pAccess) {
		super(ExtraDelightContainers.STYLE_MENU.get(), pContainerId);
		this.access = pAccess;
	}

	@Override
	public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean stillValid(Player p_38874_) {
		return true;
	}

	@Override
	public boolean clickMenuButton(Player p_39465_, int p_39466_) {
		this.access.execute((level, pos) -> {
			BlockState state = level.getBlockState(pos);
			if (state.getBlock() instanceof IStyleable s) {
				BlockState next = s.nextStyle(level, pos, state);
			}
		});
		return true;
	}

}

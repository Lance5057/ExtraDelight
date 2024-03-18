package com.lance5057.extradelight.workstations.dryingrack;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class DryingRackContainer implements Container {
	protected final IItemHandler inv;
	
	public DryingRackContainer(IItemHandlerModifiable h2)
	{
		this.inv = h2;
	}
	
	@Override
	public void clearContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getContainerSize() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getItem(int pSlot) {
		return inv.getStackInSlot(pSlot);
	}

	@Override
	public ItemStack removeItem(int pSlot, int pAmount) {
		return inv.extractItem(pSlot, pAmount, false);
		
	}

	@Override
	public ItemStack removeItemNoUpdate(int pSlot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItem(int pSlot, ItemStack pStack) {
		
	}

	@Override
	public void setChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		// TODO Auto-generated method stub
		return false;
	}

}

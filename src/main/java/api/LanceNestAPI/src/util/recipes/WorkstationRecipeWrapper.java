package api.LanceNestAPI.src.util.recipes;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class WorkstationRecipeWrapper implements Container {
	protected final int width, height;
	protected final IItemHandler inv;

	public WorkstationRecipeWrapper(int w, int h, IItemHandlerModifiable h2)
	{
		this.width = w;
		this.height = h;
		this.inv = h2;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clearContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getContainerSize() {
		// TODO Auto-generated method stub
		return width * height;
	}

	@Override
	public ItemStack getItem(int p_18941_) {
		// TODO Auto-generated method stub
		return inv.getStackInSlot(p_18941_);
	}

	@Override
	public ItemStack removeItem(int p_18942_, int p_18943_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeItemNoUpdate(int p_18951_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItem(int p_18944_, ItemStack p_18945_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stillValid(Player p_18946_) {
		// TODO Auto-generated method stub
		return false;
	}
}

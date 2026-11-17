package api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.ItemStackHandler;

public class BlockEntityItemHandler extends ItemStackHandler {

	BlockEntity be;

	public BlockEntity getBlockEntity() {
		return be;
	}

	public BlockEntityItemHandler(BlockEntity be, int size) {
		super(size);
		this.be = be;
	}

	public boolean isEmpty() {
		for (ItemStack s : this.stacks)
			if (!s.isEmpty())
				return false;
		return true;
	}

	public void shrinkAll() {
		for (ItemStack s : this.stacks) {
			s.shrink(1);
		}
	}

	public void shrinkAll(int i) {
		for (ItemStack s : this.stacks) {
			s.shrink(i);
		}
	}

	public void shrinkRange(int start, int finish) {
		for (int i = start; i < finish; i++) {
			this.stacks.get(i).shrink(1);
		}
	}
	
	public void shrinkRange(int start, int finish, int amount) {
		for (int i = start; i < finish; i++) {
			this.stacks.get(i).shrink(amount);
		}
	}
}

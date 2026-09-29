package api.LanceNestAPI.src.components.item;

import api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item.BlockEntityItemHandler;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.ItemStackHandler;

public class WorkstationCraftingGrid extends _WorkstationInventory {

	public WorkstationCraftingGrid(BlockEntity be, String name, int size, Direction accessDirection) {
		super(be, name, size, size, accessDirection, true);
	}

	@Override
	protected ItemStackHandler createHandler() {
		return new BlockEntityItemHandler(be, this.NUM_SLOTS);
	}

}

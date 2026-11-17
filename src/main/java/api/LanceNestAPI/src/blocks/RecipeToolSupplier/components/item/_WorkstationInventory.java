package api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item;

import api.LanceNestAPI.src.components.WorkstationComponent;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;

public abstract class _WorkstationInventory implements WorkstationComponent {
	protected final BlockEntity be;
	private final String name;
	public final String TAG;
	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public final int NUM_SLOTS;
	public final int WIDTH;
	public final int HEIGHT;
	private final Direction accessDirection;
	private final boolean usedInRecipe;

	public _WorkstationInventory(BlockEntity be, String name, int width, int height, Direction accessDirection,
			boolean usedInRecipe) {
		this.be = be;
		this.name = name;
		TAG = name + "_tag";
		NUM_SLOTS = width * height;
		WIDTH = width;
		HEIGHT = height;
		this.accessDirection = accessDirection;
		this.usedInRecipe = usedInRecipe;
	}

	protected abstract ItemStackHandler createHandler();

	public ItemStack insertItem(ItemStack stack) {
		for (int i = 0; i < NUM_SLOTS; i++)
			stack = items.insertItem(i, stack, false);
		return stack;
	}

	public ItemStack extractItem() {
		ItemStack stack = ItemStack.EMPTY;
		for (int i = 0; i < NUM_SLOTS; i++)
			stack = items.extractItem(i, 1, false);
		return stack;
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	public IItemHandlerModifiable registerHandler(Direction d) {
		if (d == this.accessDirection)
			return itemHandler.get();
		return null;
	}

	@Override
	public CompoundTag writeNBT(HolderLookup.Provider provider, CompoundTag tag) {
		tag.put(TAG, items.serializeNBT(provider));

		return tag;
	}

	@Override
	public void readNBT(HolderLookup.Provider provider, CompoundTag nbt) {
		if (nbt.contains(TAG)) {
			items.deserializeNBT(provider, nbt.getCompound(TAG));
		}
	}

	@Override
	public boolean isUsedInRecipe() {
		return usedInRecipe;
	}
}

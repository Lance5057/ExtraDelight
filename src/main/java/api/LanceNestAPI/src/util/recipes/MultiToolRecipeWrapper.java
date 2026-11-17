package api.LanceNestAPI.src.util.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class MultiToolRecipeWrapper extends RecipeWrapper {
	public static final MultiToolRecipeWrapper EMPTY = new MultiToolRecipeWrapper(0, 0, null);
	private final int width;
	private final int height;
	private final IItemHandler items;
	private final StackedContents stackedContents = new StackedContents();
	private final int ingredientCount;

	private MultiToolRecipeWrapper(int width, int height, IItemHandler item) {
		super(item);
		this.width = width;
		this.height = height;
		this.items = item;
		int x = 0;

		if (item != null)
			for (int i = 0; i < item.getSlots(); i++) {
				if (!item.getStackInSlot(i).isEmpty()) {
					this.stackedContents.accountStack(item.getStackInSlot(i), 1);
					x++;
				}
			}

		this.ingredientCount = x;
	}

	public static MultiToolRecipeWrapper of(int width, int height, IItemHandler items) {
		return ofPositioned(width, height, items).input();
	}

	public static MultiToolRecipeWrapper of(IItemHandler items) {
		return ofPositioned(1, 1, items).input();
	}

	public static MultiToolRecipeWrapper.Positioned ofPositioned(int width, int height, IItemHandler item) {
		if (width != 0 && height != 0) {
			int i = width - 1;
			int j = 0;
			int k = height - 1;
			int l = 0;

			for (int i1 = 0; i1 < height; i1++) {
				boolean flag = true;

				for (int j1 = 0; j1 < width; j1++) {
					ItemStack itemstack = item.getStackInSlot(j1 + i1 * width);
					if (!itemstack.isEmpty()) {
						i = Math.min(i, j1);
						j = Math.max(j, j1);
						flag = false;
					}
				}

				if (!flag) {
					k = Math.min(k, i1);
					l = Math.max(l, i1);
				}
			}

			int i2 = j - i + 1;
			int j2 = l - k + 1;
			if (i2 <= 0 || j2 <= 0) {
				return MultiToolRecipeWrapper.Positioned.EMPTY;
			} else if (i2 == width && j2 == height) {
				return new MultiToolRecipeWrapper.Positioned(new MultiToolRecipeWrapper(width, height, item), i, k);
			} else {
				List<ItemStack> list = new ArrayList<>(i2 * j2);

				for (int k2 = 0; k2 < j2; k2++) {
					for (int k1 = 0; k1 < i2; k1++) {
						int l1 = k1 + i + (k2 + k) * width;
						list.add(item.getStackInSlot(l1));
					}
				}

				return new MultiToolRecipeWrapper.Positioned(
						new MultiToolRecipeWrapper(i2, j2, new ItemStackHandler(NonNullList.copyOf(list))), i, k);
			}
		} else {
			return MultiToolRecipeWrapper.Positioned.EMPTY;
		}
	}

	@Override
	public ItemStack getItem(int index) {
		return this.items.getStackInSlot(index);
	}

	public ItemStack getItem(int row, int column) {
		return this.items.getStackInSlot(row + column * this.width);
	}

	@Override
	public int size() {
		return this.items.getSlots();
	}

	@Override
	public boolean isEmpty() {
		return this.ingredientCount == 0;
	}

	public StackedContents stackedContents() {
		return this.stackedContents;
	}

	public IItemHandler items() {
		return this.items;
	}

	public int ingredientCount() {
		return this.ingredientCount;
	}

	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		} else {
			return !(other instanceof MultiToolRecipeWrapper craftinginput) ? false
					: this.width == craftinginput.width && this.height == craftinginput.height
							&& this.ingredientCount == craftinginput.ingredientCount && ItemStack
									.listMatches(getHandlerAsItems(this.items), getHandlerAsItems(craftinginput.items));
		}
	}

	@Override
	public int hashCode() {
		int i = ItemStack.hashStackList(getHandlerAsItems(this.items));
		i = 31 * i + this.width;
		return 31 * i + this.height;
	}

	List<ItemStack> getHandlerAsItems(IItemHandler i) {
		List<ItemStack> stacks = new ArrayList<ItemStack>();
		for (int j = 0; j <= i.getSlots(); j++) {
			stacks.add(i.getStackInSlot(j));
		}
		return stacks;
	}

	public static record Positioned(MultiToolRecipeWrapper input, int left, int top) {
		public static final MultiToolRecipeWrapper.Positioned EMPTY = new MultiToolRecipeWrapper.Positioned(
				MultiToolRecipeWrapper.EMPTY, 0, 0);
	}
}

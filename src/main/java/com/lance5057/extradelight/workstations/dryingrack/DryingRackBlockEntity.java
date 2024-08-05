package com.lance5057.extradelight.workstations.dryingrack;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.workstations.BlockEntityItemHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;

public class DryingRackBlockEntity extends BlockEntity {
	public static final String TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public static final int NUM_SLOTS = 8;
	// private final NonNullList<ItemStack> items = NonNullList.withSize(4,
	// ItemStack.EMPTY);
	private int[] cookingProgress = new int[8];
	private int[] cookingTime = new int[8];
	private ItemStack[] results = new ItemStack[8];

	public DryingRackBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.DRYING_RACK.get(), pPos, pState);
		for (int i = 0; i < 8; i++)
			results[i] = ItemStack.EMPTY;
	}

//	@Nonnull
//	@Override
//	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
////		if (side != Direction.DOWN)
//		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//			return handler.cast();
//		}
//		return super.getCapability(cap, side);
//	}

	private ItemStackHandler createHandler() {
		return new BlockEntityItemHandler<DryingRackBlockEntity>(this, NUM_SLOTS) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}

			@Override
			@NotNull
			public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {

				Optional<RecipeHolder<DryingRackRecipe>> r = this.getBlockEntity().matchRecipe(stack);
				if (r.isPresent()) {
					if (this.getStackInSlot(slot) == ItemStack.EMPTY) {
						this.getBlockEntity().cookingTime[slot] = r.get().value().cookingTime;
						this.getBlockEntity().cookingProgress[slot] = 0;
						this.getBlockEntity().results[slot] = r.get().value().result;
						this.getBlockEntity().updateInventory();
						return super.insertItem(slot, stack, simulate);
					}
				}
				return stack;
			}

			@Override
			@NotNull
			public ItemStack extractItem(int slot, int amount, boolean simulate) {
				if (this.getBlockEntity().cookingProgress[slot] >= this.getBlockEntity().cookingTime[slot]) {
					if (this.getBlockEntity().results[slot].isEmpty()) {
						this.getBlockEntity().cookingTime[slot] = 0;
						return super.extractItem(slot, amount, simulate);
					}

				}
				return ItemStack.EMPTY;
			}

			@Override
			public boolean isItemValid(int slot, @NotNull ItemStack stack) {
				return this.getBlockEntity().matchRecipe(stack).isPresent();
			}

			@Override
			protected void onContentsChanged(int slot) {
				this.getBlockEntity().updateInventory();
			}
		};
	}

//	public void extractItem(Player playerEntity) {
//		ItemStackHandler inventory = this.items;
//		for (int i = NUM_SLOTS - 1; i >= 0; i--) {
//			if (!inventory.getStackInSlot(i).isEmpty()) {
//				ItemStack itemStack = inventory.getStackInSlot(i).copy();
//				playerEntity.addItem(itemStack);
//				inventory.setStackInSlot(i, ItemStack.EMPTY);
//				updateInventory();
//				this.cookingProgress[i] = 0;
//				this.cookingTime[i] = 0;
//
//				return;
//
//			}
//		}
//		updateInventory();
//	}

//	public ItemStack insertItem(ItemStack heldItem) {
//		ItemStackHandler inventory = this.items;
//		for (int i = 0; i < NUM_SLOTS; i++) {
//			if (inventory.isItemValid(i, heldItem))
//				if (!ItemStack.isSameItemSameTags(inventory.insertItem(i, heldItem, true), heldItem)) {
//					heldItem = inventory.insertItem(i, heldItem.copy(), false);
//
//					updateInventory();
//					return heldItem;
//				}
//		}
//		updateInventory();
//		return heldItem;
//	}

	public void insertItem(ItemStack in) {
		BlockEntityUtils.Inventory.insertItem(in, items, NUM_SLOTS);
		this.updateInventory();
	}

	public void extractItem(ItemStack out) {
		BlockEntityUtils.Inventory.extractItem(items, NUM_SLOTS);
		this.updateInventory();
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

//	public ItemStack getInsertedItem() {
//		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
//	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		DryingRackBlockEntity pBlockEntity = (DryingRackBlockEntity) be;
		boolean flag = false;
		IItemHandlerModifiable h = pBlockEntity.getItemHandler();

		for (int i = 0; i < NUM_SLOTS; ++i) {
			ItemStack itemstack = h.getStackInSlot(i);
			if (!itemstack.isEmpty()) {
				flag = true;
				int j = pBlockEntity.cookingProgress[i]++;
				if (pBlockEntity.cookingProgress[i] >= pBlockEntity.cookingTime[i]) {
					if (!pBlockEntity.results[i].isEmpty()) {
						Container container = new SimpleContainer(itemstack);
						ItemStack itemstack1 = pBlockEntity.results[i].copy();
						pBlockEntity.results[i] = ItemStack.EMPTY;
						h.setStackInSlot(i, itemstack1);
						level.sendBlockUpdated(pos, state, state, 3);
					}
				} else {

					for (int k = 0; k < 1; k++) {
						float yOff = (i > 3 ? 0.5f : 0) + 0.5f;
						float xOff = 0;
						float zOff = 0;
						switch (i % 4) {
						case 0 -> {
							xOff = 0.2f + level.random.nextFloat() * .2f;
							zOff = 0.2f + level.random.nextFloat() * .2f;
						}
						case 1 -> {
							xOff = 0.2f + level.random.nextFloat() * .2f;
							zOff = 0.8f - level.random.nextFloat() * .2f;
						}
						case 2 -> {
							xOff = 0.8f - level.random.nextFloat() * .2f;
							zOff = 0.8f - level.random.nextFloat() * .2f;
						}
						case 3 -> {
							xOff = 0.8f - level.random.nextFloat() * .2f;
							zOff = 0.2f + level.random.nextFloat() * .2f;
						}
						}
						level.addParticle(ParticleTypes.DOLPHIN, pos.getX() + level.random.nextDouble() / 16 + xOff,
								pos.getY() - level.random.nextDouble() / 16 + yOff,
								pos.getZ() + level.random.nextDouble() / 16 + zOff, 0, 1f, 0);
					}
				}
			} else {

			}
		}

		if (flag) {
			setChanged(level, pos, state);
		}

	}

//	public boolean placeFood(ItemStack pStack, int pCookTime) {
//		
//		for (int i = 0; i < this.items.size(); ++i) {
//			ItemStack itemstack = this.items.get(i);
//			if (itemstack.isEmpty()) {
//				this.cookingTime[i] = pCookTime;
//				this.cookingProgress[i] = 0;
//				this.items.set(i, pStack.split(1));
//				this.markUpdated();
//				return true;
//			}
//		}
//
//		return false;
//	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		writeNBT(nbt, registries);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
		readNBT(tag, registries);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
//		CompoundTag tag = new CompoundTag();
//
//		writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains(TAG)) {
			items.deserializeNBT(registries, nbt.getCompound(TAG));
		}

		this.cookingProgress = nbt.getIntArray("CookingTimes");
		this.cookingTime = nbt.getIntArray("CookingTotalTimes");

//		for (int i = 0; i < NUM_SLOTS; i++) {
//			results[i].deserializeNBT(nbt.getCompound("item_" + i));
//		}
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put(TAG, items.serializeNBT(registries));

		tag.putIntArray("CookingTimes", this.cookingProgress);
		tag.putIntArray("CookingTotalTimes", this.cookingTime);

//		for (int i = 0; i < NUM_SLOTS; i++) {
//			tag.put("item_" + i, results[i].serializeNBT());
//		}

		return tag;
	}

	@Override
	public void loadAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.loadAdditional(nbt, registries);
		readNBT(nbt, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		writeNBT(nbt, registries);
	}

	public Optional<RecipeHolder<DryingRackRecipe>> matchRecipe(ItemStack itemstack) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.DRYING_RACK.get(),
					new SingleRecipeInput(itemstack), level);
		}
		return Optional.empty();

	}
}

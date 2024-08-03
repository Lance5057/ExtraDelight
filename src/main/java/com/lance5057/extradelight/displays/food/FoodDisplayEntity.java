package com.lance5057.extradelight.displays.food;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class FoodDisplayEntity extends BlockEntity {

//	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	public static final String TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public static final int NUM_SLOTS = 9;

	public FoodDisplayEntity(BlockPos pPos, BlockState pBlockState) {

		super(ExtraDelightBlockEntities.FOOD_DISPLAY.get(), pPos, pBlockState);

	}

	public int getNumSlots() {
		return NUM_SLOTS;
	}

	public IItemHandler getItemHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}
		};
	}

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
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		if (tag != null)
			readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains(TAG)) {
			items.deserializeNBT(registries, nbt.getCompound(TAG));
		}
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {
		tag.put(TAG, items.serializeNBT(registries));
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
//
//	@Override
//	public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
//		return new FoodDisplayMenu(pContainerId, pPlayerInventory, this);
//	}
//

	public String getDisplayName() {
		return "screen.food_display.name";
	}
}

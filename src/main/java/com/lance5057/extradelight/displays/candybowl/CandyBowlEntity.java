package com.lance5057.extradelight.displays.candybowl;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.util.BlockEntityUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class CandyBowlEntity extends BlockEntity {
	public static final String TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public final static int NUM_SLOTS = 9;

	public CandyBowlEntity(BlockPos pPos, BlockState pBlockState) {
		super(ExtraDelightBlockEntities.CANDY_BOWL.get(), pPos, pBlockState);
	}

	public int getNumSlots() {
		return NUM_SLOTS;
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}
		};
	}

	public void insertItem(ItemStack stack) {
		BlockEntityUtils.Inventory.insertItem(items, stack, NUM_SLOTS);
		this.updateInventory();
	}

	public void extractItem(Player p) {
		BlockEntityUtils.Inventory.extractItem(p, items, NUM_SLOTS);
		this.updateInventory();
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	public IItemHandler getItemHandler() {
		return itemHandler.get();
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

}

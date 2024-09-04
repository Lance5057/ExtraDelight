package com.lance5057.extradelight.blocks.sink;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.capabilities.WellFluidCapability;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class SinkCabinetBlockEntity extends BlockEntity {

	WellFluidCapability water = new WellFluidCapability(Fluids.WATER);
	private final Lazy<IFluidHandler> fluidHandler = Lazy.of(() -> water);

	public static final String TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public final static int NUM_SLOTS = 19;

	public SinkCabinetBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.SINK_BLOCK.get(), pPos, pState);
	}

	public IFluidHandler getFluidHandler() {
		return fluidHandler.get();
	}

	public ItemStack fill(ItemStack stack, Player player) {
		if (stack.getCapability(FluidHandler.ITEM) != null) {
			FluidActionResult r = FluidUtil.tryFillContainer(stack, water, Integer.MAX_VALUE, player, true);
			return r.result;
		}
		return stack;
	}

	public ItemStack drain(ItemStack stack, Player player) {
		FluidActionResult r = FluidUtil.tryEmptyContainer(stack, water, Integer.MAX_VALUE, player, true);
		return r.result;
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS);
	}

//	public void insertItem(ItemStack in) {
//		BlockEntityUtils.Inventory.insertItem(in, items, NUM_SLOTS);
//		this.updateInventory();
//	}
//
//	public void extractItem(ItemStack out) {
//		BlockEntityUtils.Inventory.extractItem(items, NUM_SLOTS);
//		this.updateInventory();
//	}

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

	public String getDisplayName() {
		return "screen.sink.name";
	}
}

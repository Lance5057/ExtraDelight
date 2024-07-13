package com.lance5057.extradelight.blocks.sink;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.capabilities.WellFluidCapability;
import com.lance5057.extradelight.util.BlockEntityUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
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

	public void insertItem(ItemStack stack) {
		BlockEntityUtils.Inventory.insertItem(items, stack, NUM_SLOTS);
		this.updateInventory();
	}

	public void extractItem(Player p, InteractionHand h) {
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
	public CompoundTag getUpdateTag() {
		CompoundTag nbt = super.getUpdateTag();

		writeNBT(nbt);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		readNBT(tag);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag);
	}

	void readNBT(CompoundTag nbt) {
		if (nbt.contains(TAG)) {
			items.deserializeNBT(nbt.getCompound(TAG));
		}
	}

	CompoundTag writeNBT(CompoundTag tag) {
		tag.put(TAG, items.serializeNBT());
		return tag;
	}

	@Override
	public void load(@Nonnull CompoundTag nbt) {
		super.load(nbt);
		readNBT(nbt);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt) {
		super.saveAdditional(nbt);
		writeNBT(nbt);
	}

	public String getDisplayName() {
		return "screen.sink.name";
	}
}

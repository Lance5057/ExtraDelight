package com.lance5057.extradelight.displays.candybowl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.util.BlockEntityUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class CandyBowlEntity extends BlockEntity {

	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	private int NUM_SLOTS = 9;

	public CandyBowlEntity(BlockPos pPos, BlockState pBlockState) {
		super(ExtraDelightBlockEntities.CANDY_BOWL.get(), pPos, pBlockState);
		// TODO Auto-generated constructor stub
	}

	public int getNumSlots() {
		return NUM_SLOTS;
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != Direction.DOWN)
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return handler.cast();
			}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}
		};
	}

	public void insertItem(ItemStack stack) {
		handler.ifPresent(i -> {
//			int s = getEmptySlot(i);
//			if (s != -1) {
//				stack.setCount(i.insertItem(s, stack, false).getCount());
//			}

			BlockEntityUtils.Inventory.insertItem(i, stack, NUM_SLOTS);
			this.updateInventory();
		});
	}

	public void extractItem(Player p, InteractionHand h) {
		handler.ifPresent(i -> {
//			int j = getLastFullSlot(i);
//			if (j != -1) {
//				ItemStack itemStack = i.extractItem(j, 1, false);
//				p.addItem(itemStack);
//				return;
//			}
			BlockEntityUtils.Inventory.extractItem(p, i, NUM_SLOTS);
			this.updateInventory();
		});
	}

//	private int getEmptySlot(@NotNull IItemHandlerModifiable i) {
//		for (int j = 0; j < NUM_SLOTS; j++) {
//			if (i.getStackInSlot(j) == ItemStack.EMPTY)
//				return j;
//		}
//		return -1;
//	}
//
//	private int getLastFullSlot(@NotNull IItemHandlerModifiable i) {
//		for (int j = 0; j < NUM_SLOTS; j++) {
//			if (i.getStackInSlot(j) == ItemStack.EMPTY)
//				return j - 1;
//		}
//		return -1;
//	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
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
		CompoundTag tag = new CompoundTag();

		writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag);
	}

	void readNBT(CompoundTag nbt) {
		final IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		((ItemStackHandler) itemInteractionHandler).deserializeNBT(nbt.getCompound("inventory"));
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

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

}

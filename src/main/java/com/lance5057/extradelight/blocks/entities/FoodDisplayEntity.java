package com.lance5057.extradelight.blocks.entities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.containers.FoodDisplayMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class FoodDisplayEntity extends BlockEntity implements MenuProvider {

	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	private int NUM_SLOTS_TOP;
	private int NUM_SLOTS_BOTTOM;

	public FoodDisplayEntity(BlockPos pPos, BlockState pBlockState) {

		super(ExtraDelightBlockEntities.FOOD_DISPLAY.get(), pPos, pBlockState);

	}

	public FoodDisplayEntity setSlots(int slots_top, int slots_bottom) {
		NUM_SLOTS_TOP = slots_top;
		NUM_SLOTS_BOTTOM = slots_bottom;
		return this;
	}

	public int getTopSlots() {
		return this.NUM_SLOTS_TOP;
	}

	public int getBottomSlots() {
		return this.NUM_SLOTS_BOTTOM;
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
		return new ItemStackHandler(NUM_SLOTS_TOP + NUM_SLOTS_BOTTOM) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
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

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
		return new FoodDisplayMenu(pContainerId, pPlayerInventory, this);
	}

	@Override
	public Component getDisplayName() {
		return TextUtils.getTranslation("screen.food_display.name");
	}
}

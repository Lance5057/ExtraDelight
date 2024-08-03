package com.lance5057.extradelight.displays.wreath;

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

public class WreathEntity extends BlockEntity {

	public static final String TAG = "inv";
//	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public static final int NUM_SLOTS = 8;

	public WreathEntity(BlockPos pPos, BlockState pBlockState) {

		super(ExtraDelightBlockEntities.WREATH.get(), pPos, pBlockState);

	}

	public int getNumSlots() {
		return NUM_SLOTS;
	}

	public IItemHandler getItemHandler() {
		return itemHandler.get();
	}

//	@Nonnull
//	@Override
//	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
//		if (side != Direction.DOWN)
//			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//				return handler.cast();
//			}
//		return super.getCapability(cap, side);
//	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}
		};
	}

//	public boolean containsLight() {
//		if (handler.isPresent()) {
//			if (handler.map(i -> {
//				for (int j = 0; j < i.getSlots(); j++) {
//					ItemStack s = i.getStackInSlot(j);
//					if (s.getItem() instanceof BlockItem b) {
//						if (b.getBlock().getLightEmission(b.getBlock().defaultBlockState(), getLevel(),
//								getBlockPos()) > 0) {
//							return s;
//						}
//					}
//				}
//				return null;
//			}) != null)
//				return true;
//		}
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
		return "screen.wreath.name";
	}
}

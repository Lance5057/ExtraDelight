package com.lance5057.extradelight.displays.wreath;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
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
	private int NUM_SLOTS = 8;

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
		return "screen.wreath.name";
	}
}

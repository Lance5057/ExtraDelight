package api.LanceNestAPI.src.AdvancedDisplay;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import api.LanceNestAPI.src.LanceNestAPI;
import api.LanceNestAPI.src.util.rendering.animation.Transform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class AdvancedDisplayBlockEntity extends BlockEntity {
	public static final String TAG = "inv";
	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public final static int NUM_SLOTS = 8;
	private List<Transform> transforms = new ArrayList<Transform>();

	public AdvancedDisplayBlockEntity(BlockPos pos, BlockState blockState) {
		super(LanceNestAPI.ADVANCED_DISPLAY_ENTITY.get(), pos, blockState);

		for (int i = 0; i < NUM_SLOTS; i++) {
			transforms.add(new Transform());
		}
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}

			@Override
			protected void onContentsChanged(int slot) {
				AdvancedDisplayBlockEntity.this.requestModelDataUpdate();
				AdvancedDisplayBlockEntity.this.getLevel().sendBlockUpdated(
						AdvancedDisplayBlockEntity.this.getBlockPos(), AdvancedDisplayBlockEntity.this.getBlockState(),
						AdvancedDisplayBlockEntity.this.getBlockState(), Block.UPDATE_CLIENTS);
				AdvancedDisplayBlockEntity.this.setChanged();
			}
		};
	}

	public IItemHandler getItems() {
		return this.itemHandler.get();
	}

	public Transform getItemTransform(int i) {
		return this.transforms.get(i);
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

	public String getDisplayName() {
		return "screen.advanceddisplay.name";
	}
}

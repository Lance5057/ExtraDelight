package com.lance5057.extradelight.blocks.countercabinet;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class CounterCabinetBlockEntity extends BlockEntity {
	public static final String TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);
	public final static int NUM_SLOTS = 28;

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				if (slot == 27)
					return stack.getItem() instanceof BlockItem;
				return true;
			}

			@Override
			public int getSlotLimit(int slot) {
				if (slot == 27)
					return 1;
				return 64;
			}
		};
	}

	private ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
		protected void onOpen(Level level, BlockPos pos, BlockState state) {
			CounterCabinetBlockEntity.this.playSound(state, ModSounds.BLOCK_CABINET_OPEN.get());
			CounterCabinetBlockEntity.this.updateBlockState(state, true);
		}

		protected void onClose(Level level, BlockPos pos, BlockState state) {
			CounterCabinetBlockEntity.this.playSound(state, ModSounds.BLOCK_CABINET_CLOSE.get());
			CounterCabinetBlockEntity.this.updateBlockState(state, false);
		}

		protected void openerCountChanged(Level level, BlockPos pos, BlockState sta, int arg1, int arg2) {
		}

		protected boolean isOwnContainer(Player p_155060_) {
			if (p_155060_.containerMenu instanceof ChestMenu) {
				Container container = ((ChestMenu) p_155060_.containerMenu).getContainer();
				return container == CounterCabinetBlockEntity.this;
			} else {
				return false;
			}
		}
	};

	public CounterCabinetBlockEntity(BlockPos pos, BlockState state) {
		super(ExtraDelightBlockEntities.COUNTER_CABINET_BLOCK.get(), pos, state);
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
		super.loadAdditional(nbt,registries);
		readNBT(nbt, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		writeNBT(nbt, registries);
	}

	public void startOpen(Player pPlayer) {
		if (level != null && !this.remove && !pPlayer.isSpectator()) {
			this.openersCounter.incrementOpeners(pPlayer, level, this.getBlockPos(), this.getBlockState());
		}
	}

	public void stopOpen(Player pPlayer) {
		if (level != null && !this.remove && !pPlayer.isSpectator()) {
			this.openersCounter.decrementOpeners(pPlayer, level, this.getBlockPos(), this.getBlockState());
		}
	}

	public void recheckOpen() {
		if (level != null && !this.remove) {
			this.openersCounter.recheckOpeners(level, this.getBlockPos(), this.getBlockState());
		}
	}

	void updateBlockState(BlockState state, boolean open) {
		if (level != null) {
			this.level.setBlock(this.getBlockPos(), state.setValue(CounterCabinetBlock.OPEN, open), 3);
		}
	}

	private void playSound(BlockState state, SoundEvent sound) {
		if (level == null)
			return;

		Vec3i cabinetFacingVector = state.getValue(CounterCabinetBlock.FACING).getNormal();
		double x = (double) worldPosition.getX() + 0.5D + (double) cabinetFacingVector.getX() / 2.0D;
		double y = (double) worldPosition.getY() + 0.5D + (double) cabinetFacingVector.getY() / 2.0D;
		double z = (double) worldPosition.getZ() + 0.5D + (double) cabinetFacingVector.getZ() / 2.0D;
		level.playSound(null, x, y, z, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
	}

	public String getDisplayName() {
		return "screen.countercabinet.name";
	}
}

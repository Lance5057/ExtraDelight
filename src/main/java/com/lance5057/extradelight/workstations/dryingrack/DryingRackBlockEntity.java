package com.lance5057.extradelight.workstations.dryingrack;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class DryingRackBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	public static final int NUM_SLOTS = 8;
	// private final NonNullList<ItemStack> items = NonNullList.withSize(4,
	// ItemStack.EMPTY);
	private int[] cookingProgress = new int[8];
	private int[] cookingTime = new int[8];

	public DryingRackBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.DRYING_RACK.get(), pPos, pState);
		// TODO Auto-generated constructor stub
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
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
	}

	public void extractItem(Player playerEntity, IItemHandler inventory) {
		for (int i = NUM_SLOTS - 1; i >= 0; i--) {
			if (!inventory.getStackInSlot(i).isEmpty()) {
				ItemStack itemStack = inventory.extractItem(i, inventory.getStackInSlot(i).getCount(), false);
				playerEntity.addItem(itemStack);
				updateInventory();
				return;

			}
		}
		updateInventory();
	}

	public void insertItem(IItemHandler inventory, ItemStack heldItem, int cooktime) {
		for (int i = 0; i < NUM_SLOTS; i++) {
			if (inventory.isItemValid(i, heldItem))
				if (!inventory.insertItem(i, heldItem, true).equals(heldItem, false)) {
					final int leftover = inventory.insertItem(i, heldItem.copy(), false).getCount();
					heldItem.setCount(leftover);
					this.cookingTime[i] = cooktime;
					this.cookingProgress[i] = 0;
					updateInventory();
					return;
				}
		}
		updateInventory();

	}

	// External extract handler
	public void extractItem(Player playerEntity) {
		handler.ifPresent(inventory -> this.extractItem(playerEntity, inventory));
	}

	// External insert handler
	public void insertItem(ItemStack heldItem, int cooktime) {
		handler.ifPresent(inventory -> this.insertItem(inventory, heldItem, cooktime));
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	public ItemStack getInsertedItem() {
		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		DryingRackBlockEntity pBlockEntity = (DryingRackBlockEntity) be;
		pBlockEntity.handler.ifPresent(inv -> {
			boolean flag = false;

			for (int i = 0; i < inv.getSlots(); ++i) {
				ItemStack itemstack = inv.getStackInSlot(i);
				if (!itemstack.isEmpty()) {
					flag = true;
					int j = pBlockEntity.cookingProgress[i]++;
					if (pBlockEntity.cookingProgress[i] >= pBlockEntity.cookingTime[i]) {
						Container container = new SimpleContainer(itemstack);
						ItemStack itemstack1 = level.getRecipeManager()
								.getRecipeFor(ExtraDelightRecipes.DRYING_RACK.get(), container, level)
								.map((p_155305_) -> {
									return p_155305_.assemble(container);
								}).orElse(itemstack);
//						Containers.dropItemStack(level, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
//								itemstack1);
						inv.setStackInSlot(i, itemstack1);
						level.sendBlockUpdated(pos, state, state, 3);
					} else {

						for (int k = 0; k < 1; k++) {
							float yOff = (i > 3 ? 0.5f : 0) + 0.5f;
							float xOff = 0;
							float zOff = 0;
							switch (i % 4) {
								case 0 -> {
									xOff = 0.2f + level.random.nextFloat() * .2f;
									zOff = 0.2f + level.random.nextFloat() * .2f;
								}
								case 1 -> {
									xOff = 0.2f + level.random.nextFloat() * .2f;
									zOff = 0.8f - level.random.nextFloat() * .2f;
								}
								case 2 -> {
									xOff = 0.8f - level.random.nextFloat() * .2f;
									zOff = 0.8f - level.random.nextFloat() * .2f;
								}
								case 3 -> {
									xOff = 0.8f - level.random.nextFloat() * .2f;
									zOff = 0.2f + level.random.nextFloat() * .2f;
								}
							}
							level.addParticle(ParticleTypes.DOLPHIN,
									pos.getX() + level.random.nextDouble() / 16 + xOff,
									pos.getY() - level.random.nextDouble() / 16 + yOff,
									pos.getZ() + level.random.nextDouble() / 16 + zOff, 0, 1f, 0);
						}
					}
				}
			}

			if (flag) {
				setChanged(level, pos, state);
			}

		});

	}

//	public boolean placeFood(ItemStack pStack, int pCookTime) {
//		
//		for (int i = 0; i < this.items.size(); ++i) {
//			ItemStack itemstack = this.items.get(i);
//			if (itemstack.isEmpty()) {
//				this.cookingTime[i] = pCookTime;
//				this.cookingProgress[i] = 0;
//				this.items.set(i, pStack.split(1));
//				this.markUpdated();
//				return true;
//			}
//		}
//
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
		final IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		((ItemStackHandler) itemInteractionHandler).deserializeNBT(nbt.getCompound("inventory"));

		this.cookingProgress = nbt.getIntArray("CookingTimes");
		this.cookingTime = nbt.getIntArray("CookingTotalTimes");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

		tag.putIntArray("CookingTimes", this.cookingProgress);
		tag.putIntArray("CookingTotalTimes", this.cookingTime);

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

	public Optional<DryingRackRecipe> matchRecipe(ItemStack itemstack) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.DRYING_RACK.get(),
					new SimpleContainer(itemstack), level);
		}
		return Optional.empty();

	}
}

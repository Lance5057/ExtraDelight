package com.lance5057.extradelight.workstations.mortar;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
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

public class MortarBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);

	private int grinds = 0;

	public MortarBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.MORTAR.get(), pPos, pState);
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
		return new ItemStackHandler(1) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 4;
			}

			@Override
			protected void onContentsChanged(int slot) {
				zeroProgress();
				updateInventory();
			}
		};
	}

	public void extractItem(Player playerEntity, IItemHandler inventory) {
		if (!inventory.getStackInSlot(0).isEmpty()) {
			ItemStack itemStack = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
			playerEntity.addItem(itemStack);
			updateInventory();
			return;

		}
		updateInventory();
	}

	public void insertItem(IItemHandler inventory, ItemStack heldItem) {
		if (!this.matchRecipe(heldItem).isEmpty()) {
			if (inventory.isItemValid(0, heldItem))
				if (!inventory.insertItem(0, heldItem, true).equals(heldItem, false)) {
					final int leftover = inventory.insertItem(0, heldItem.copy(), false).getCount();
					heldItem.setCount(leftover);
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
	public void insertItem(ItemStack heldItem) {
		handler.ifPresent(inventory -> this.insertItem(inventory, heldItem));
	}

	public void zeroProgress() {
		grinds = 0;
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	public ItemStack getInsertedItem() {
		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
	}

	public int getGrind() {
		return grinds;
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

		this.grinds = nbt.getInt("Grinds");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandler itemInteractionHandler = getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

		tag.putInt("Grinds", this.grinds);

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

	public Optional<MortarRecipe> matchRecipe(ItemStack... itemstack) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.MORTAR.get(),
					new SimpleContainer(itemstack), level);
		}
		return Optional.empty();

	}

	public InteractionResult grind(Player Player) {
		handler.ifPresent(inv -> {
			Optional<MortarRecipe> recipeOptional = matchRecipe(getInsertedItem());
			if (recipeOptional.isPresent()) {
				MortarRecipe recipe = recipeOptional.get();

				if (this.grinds < recipe.getStirs()) {
					grinds++;

					for (int i = 0; i < 1 + level.random.nextInt(4); i++)
						level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, getInsertedItem()),
								worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
								worldPosition.getY() - 0.5f - level.random.nextDouble(),
								worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

					level.playSound(Player, worldPosition, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1, 1);
				} else {
					ItemStack in = getInsertedItem();

					for (int i = 0; i < in.getCount(); i++) {

						ItemStack r = recipe.getResultItem().copy();

						level.addFreshEntity(new ItemEntity(level, getBlockPos().getX(), getBlockPos().getY() + 0.5f,
								getBlockPos().getZ(), recipe.getResultItem()));
					}
					inv.setStackInSlot(0, ItemStack.EMPTY);
				}
				updateInventory();
			}
		});

		return InteractionResult.SUCCESS;
	}
}

package com.lance5057.extradelight.workstations.mixingbowl;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class MixingBowlBlockEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);

	private int stirs = 0;
	public boolean complete = false;
	public ItemStack containerItem = ItemStack.EMPTY;

	public MixingBowlBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.MIXING_BOWL.get(), pPos, pState);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != Direction.DOWN)
			if (cap == ForgeCapabilities.ITEM_HANDLER) {
				return handler.cast();
			}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new ItemStackHandler(33) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				if (slot != 32)
					return 1;
				else
					return 64;
			}

			@Override
			protected void onContentsChanged(int slot) {
				zeroProgress();
				updateInventory();
			}

		};
	}

	public int getLastFilledSlot(IItemHandlerModifiable inventory) {
		if (inventory.getStackInSlot(31) != ItemStack.EMPTY)
			return 31;
		for (int i = 0; i <= 31; i++) {
			if (inventory.getStackInSlot(i) == ItemStack.EMPTY)
				return i - 1;
		}
		return -1;
	}

	public void extractItem(Player playerEntity, IItemHandlerModifiable inventory) {
		int i = getLastFilledSlot(inventory);
		if (i != -1) {
			ItemStack itemStack = inventory.extractItem(i, 1, false);
			playerEntity.addItem(itemStack);
			updateInventory();
			return;
		}

		updateInventory();
	}

	public void insertItem(IItemHandlerModifiable inventory, ItemStack heldItem) {
		for (int i = 0; i <= 31; i++) {
			if (!inventory.insertItem(i, heldItem, true).equals(heldItem, false)) {
				final int leftover = inventory.insertItem(i, heldItem.copy(), false).getCount();
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
		stirs = 0;
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

//	public ItemStack getInsertedItem() {
//		return handler.map(inventory -> inventory.getStackInSlot(0)).orElse(ItemStack.EMPTY);
//	}

	public int getStirs() {
		return stirs;
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
		final IItemHandlerModifiable itemInteractionHandler = (IItemHandlerModifiable) getCapability(
				ForgeCapabilities.ITEM_HANDLER).orElseGet(this::createHandler);
		((ItemStackHandler) itemInteractionHandler).deserializeNBT(nbt.getCompound("inventory"));

		this.stirs = nbt.getInt("stirs");
		containerItem = ItemStack.of(nbt.getCompound("usedItem"));
		this.complete = nbt.getBoolean("complete");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		IItemHandlerModifiable itemInteractionHandler = (IItemHandlerModifiable) getCapability(
				ForgeCapabilities.ITEM_HANDLER).orElseGet(this::createHandler);
		tag.put("inventory", ((ItemStackHandler) itemInteractionHandler).serializeNBT());

		tag.putInt("stirs", this.stirs);

		tag.put("usedItem", containerItem.serializeNBT());
		tag.putBoolean("complete", this.complete);

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

	public Optional<MixingBowlRecipe> matchRecipe(ItemStack... itemstack) {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.MIXING_BOWL.get(),
					new SimpleContainer(itemstack), level);
		}
		return Optional.empty();

	}

	private ItemStack[] getItems(IItemHandlerModifiable inventory) {
		int s = getLastFilledSlot(inventory);
		if (s != -1) {
			ItemStack[] stacks = new ItemStack[s + 1];
			for (int i = 0; i < s + 1; i++) {
				stacks[i] = inventory.getStackInSlot(i);
			}
			return stacks;
		}
		return new ItemStack[0];
	}

	private void clearItems(IItemHandlerModifiable inventory) {
		for (int i = 0; i < 32; i++) {
			inventory.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	protected Optional<MixingBowlRecipe> matchRecipe() {
		if (level != null) {

			Optional<MixingBowlRecipe> recipe = handler.map(i -> {
				return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.MIXING_BOWL.get(),
						new SimpleContainer(getItems(i)), level);
			}).get();

			// setRecipe(recipe);
			return recipe;
		}
		return Optional.empty();
	}

	public InteractionResult mix(Player player) {
		handler.ifPresent(inv -> {
			Optional<MixingBowlRecipe> recipeOptional = matchRecipe(getItems(inv));
			if (recipeOptional.isPresent()) {
				MixingBowlRecipe recipe = recipeOptional.get();

				if (this.stirs < recipe.getStirs()) {
					stirs++;

					ItemStack[] items = getItems(inv);
					for (int i = 0; i < 1 + level.random.nextInt(4); i++)
						level.addParticle(
								new ItemParticleOption(ParticleTypes.ITEM,
										items[items.length > 1 ? level.random.nextInt(items.length - 1) : 0]),
								worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
								worldPosition.getY() - 0.5f - level.random.nextDouble(),
								worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

					level.playSound(player, worldPosition, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1, 1);
				} else {
					this.containerItem = recipe.getUsedItem().copy();

					ItemStack i = recipe.getResultItem().copy();

					i.onCraftedBy(player.level, player, 1);
					net.minecraftforge.event.ForgeEventFactory.firePlayerCraftingEvent(player, i,
							new RecipeWrapper(inv));

					dropContainers(inv, player);
					clearItems(inv);
					inv.setStackInSlot(32, i);
					complete = true;
				}
				updateInventory();
			}
		});

		return InteractionResult.SUCCESS;
	}

	public boolean testContainerItem(ItemStack stack) {
		if (this.containerItem.isEmpty())
			return true;
		return this.containerItem.getItem() == stack.getItem();
	}

	public InteractionResult scoop(Player player, InteractionHand pHand) {
		handler.ifPresent(inv -> {

			ItemStack r = inv.extractItem(32, 1, false);

			if (!player.addItem(r)) {
				level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5f, getBlockPos().getY() + 0.5f,
						getBlockPos().getZ() + 0.5f, r, 0, 0, 0));
			}

			if (!this.containerItem.isEmpty()) {
				ItemStack h = player.getItemInHand(pHand);
				h.setCount(h.getCount() - 1);
			}

			if (inv.getStackInSlot(32).isEmpty()) {
				this.containerItem = ItemStack.EMPTY;

				complete = false;
			}
		});

		return InteractionResult.SUCCESS;

	}

	private void dropContainers(@NotNull IItemHandlerModifiable inv, Player player) {
		for (int i = 0; i < 32; i++) {
			player.addItem(inv.getStackInSlot(i).getCraftingRemainingItem());

		}
	}
}
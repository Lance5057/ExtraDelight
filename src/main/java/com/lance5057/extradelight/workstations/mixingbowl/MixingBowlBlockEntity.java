package com.lance5057.extradelight.workstations.mixingbowl;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class MixingBowlBlockEntity extends BlockEntity {
	public static final String INV_TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public static final int CRAFT_SLOTS = 9;
	public static final int CONTAINER_SLOT = 10;
	public static final int LIQUID_IN_SLOT = 11;
	public static final int LIQUID_OUT_SLOT = 12;
	public static final int GHOST_SLOT = 13;

	public static final String FLUID_TAG = "tank";

	private final FluidTank fluids = createFluidHandler();

	private int stirs = 0;
	public boolean complete = false;
	public ItemStack containerItem = ItemStack.EMPTY;

	public MixingBowlBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.MIXING_BOWL.get(), pPos, pState);
	}

	private FluidTank createFluidHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(LIQUID_OUT_SLOT) {
//			@Override
//			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
//				if (slot != 32)
//					return 1;
//				else
//					return 64;
//			}
			
			@Override
		    public boolean isItemValid(int slot, ItemStack stack) {
				if(slot == LIQUID_IN_SLOT)
					if(stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						return true;
				if(slot == LIQUID_OUT_SLOT)
					return false;
				if(slot == GHOST_SLOT)
					return false;
		        return true;
		    }

			@Override
			protected void onContentsChanged(int slot) {
				zeroProgress();
				updateInventory();
			}

		};
	}

	public int getLastFilledSlot(IItemHandlerModifiable inventory) {
		if (inventory.getStackInSlot(9) != ItemStack.EMPTY)
			return 9;
		for (int i = 0; i <= 9; i++) {
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

	public void insertItem(ItemStack in, int slot) {
		BlockEntityUtils.Inventory.insertItem(in, items, LIQUID_OUT_SLOT);
		this.updateInventory();
	}

	public ItemStack extractItem(ItemStack out, int slot) {
		ItemStack stack = BlockEntityUtils.Inventory.extractItem(items, LIQUID_OUT_SLOT);
		this.updateInventory();
		return stack;
	}
	
	public int getNextEmptySlot() {
		for (int i = 0; i < items.getSlots(); ++i) {
			ItemStack slotStack = items.getStackInSlot(i);
			if (slotStack.isEmpty()) {
				return i;
			}
		}
		return -1;
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
		if (nbt.contains(INV_TAG)) {
			items.deserializeNBT(registries, nbt.getCompound(INV_TAG));
		}

		this.stirs = nbt.getInt("stirs");
		ItemStack.parse(registries, nbt.getCompound("usedItem")).ifPresent(i -> containerItem = i);
		this.complete = nbt.getBoolean("complete");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put(INV_TAG, items.serializeNBT(registries));

		tag.putInt("stirs", this.stirs);

		tag.put("usedItem", containerItem.saveOptional(registries));
		tag.putBoolean("complete", this.complete);

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

//	public Optional<RecipeHolder<MixingBowlRecipe>> matchRecipe() {
//		if (this.level != null) {
//			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.MIXING_BOWL.get(),
//					new RecipeWrapper(this.items), level);
//		}
//		return Optional.empty();
//
//	}

	private ItemStack[] getItems() {
		int s = getLastFilledSlot(items);
		if (s != -1) {
			ItemStack[] stacks = new ItemStack[s + 1];
			for (int i = 0; i < s + 1; i++) {
				stacks[i] = items.getStackInSlot(i);
			}
			return stacks;
		}
		return new ItemStack[0];
	}

	private void clearItems() {
		for (int i = 0; i < 9; i++) {
			items.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	protected Optional<RecipeHolder<MixingBowlRecipe>> matchRecipe() {
		if (level != null) {

			Optional<RecipeHolder<MixingBowlRecipe>> recipe = level.getRecipeManager()
					.getRecipeFor(ExtraDelightRecipes.MIXING_BOWL.get(), new RecipeWrapper(this.items), level);

			// setRecipe(recipe);
			return recipe;
		}
		return Optional.empty();

	}

	public InteractionResult mix(Player player) {

		Optional<RecipeHolder<MixingBowlRecipe>> recipeOptional = matchRecipe();
		if (recipeOptional.isPresent()) {
			MixingBowlRecipe recipe = recipeOptional.get().value();

			if (this.stirs < recipe.getStirs()) {
				stirs++;

				ItemStack[] items = getItems();
//				for (int i = 0; i < 1 + level.random.nextInt(4); i++)
//					level.addParticle(
//							new ItemParticleOption(ParticleTypes.ITEM,
//									items[items.length > 1 ? level.random.nextInt(items.length - 1) : 0]),
//							worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
//							worldPosition.getY() - 0.5f - level.random.nextDouble(),
//							worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

				level.playSound(player, worldPosition, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1, 1);
			} else {
				this.containerItem = recipe.getUsedItem().copy();

				ItemStack i = recipe.getResultItem(player.level().registryAccess()).copy();

				i.onCraftedBy(player.level(), player, 1);
//				NeoForgeEventFactory.firePlayerCraftingEvent(player, i, new RecipeWrapper(items));

				dropContainers(items, player);
				clearItems();
				items.setStackInSlot(CONTAINER_SLOT, i);
				complete = true;
			}
			updateInventory();
		}

		return InteractionResult.SUCCESS;
	}

	public boolean testContainerItem(ItemStack stack) {
		if (this.containerItem.isEmpty())
			return true;
		return this.containerItem.getItem() == stack.getItem();
	}

	public InteractionResult scoop(Player player, InteractionHand pHand) {
		ItemStack r = items.extractItem(32, 1, false);

		if (!player.addItem(r)) {
			level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5f, getBlockPos().getY() + 0.5f,
					getBlockPos().getZ() + 0.5f, r, 0, 0, 0));
		}

		if (!this.containerItem.isEmpty()) {
			ItemStack h = player.getItemInHand(pHand);
			h.setCount(h.getCount() - 1);
		}

		if (items.getStackInSlot(32).isEmpty()) {
			this.containerItem = ItemStack.EMPTY;

			complete = false;
		}

		return InteractionResult.SUCCESS;

	}

	private void dropContainers(@NotNull IItemHandlerModifiable inv, Player player) {
		for (int i = 0; i < 9; i++) {
			player.addItem(inv.getStackInSlot(i).getCraftingRemainingItem());

		}
	}
}
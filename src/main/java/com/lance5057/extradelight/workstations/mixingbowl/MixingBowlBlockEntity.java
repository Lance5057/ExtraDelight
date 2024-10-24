package com.lance5057.extradelight.workstations.mixingbowl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipeWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;

public class MixingBowlBlockEntity extends BlockEntity {
	public static final String INV_TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public static final int CRAFT_SLOTS = 8;
	public static final int CONTAINER_SLOT = 9;
	public static final int LIQUID_IN_SLOT = 10;
	public static final int LIQUID_OUT_SLOT = 11;
	public static final int GHOST_SLOT = 12;

	public static final String FLUID_TAG = "tank";

	private final MixingBowlTank fluids = createFluidHandler();

	private int stirs = 0;
	public boolean complete = false;
	public ItemStack containerItem = ItemStack.EMPTY;

	MixingBowlRecipe curRecipe;

	public MixingBowlBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.MIXING_BOWL.get(), pPos, pState);
	}

	private MixingBowlTank createFluidHandler() {
		MixingBowlTank tank = new MixingBowlTank(FluidType.BUCKET_VOLUME) {
			@Override
			protected void onContentsChanged() {
				MixingBowlBlockEntity.this.requestModelDataUpdate();
				MixingBowlBlockEntity.this.getLevel().sendBlockUpdated(MixingBowlBlockEntity.this.getBlockPos(),
						MixingBowlBlockEntity.this.getBlockState(), MixingBowlBlockEntity.this.getBlockState(),
						Block.UPDATE_ALL);
				MixingBowlBlockEntity.this.setChanged();
			}
		};

		return tank;
	}

	public MixingBowlTank getFluidTank() {
		return fluids;
	}

	public static void fillInternal(MixingBowlBlockEntity bowl) {
		ItemStack inputItem = bowl.items.getStackInSlot(LIQUID_IN_SLOT);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() instanceof BucketItem filledBucket) {
				int filled = bowl.getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
						IFluidHandler.FluidAction.SIMULATE);
				if (filled == FluidType.BUCKET_VOLUME) {
					bowl.getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
							IFluidHandler.FluidAction.EXECUTE);
					inputItem.shrink(1);
					bowl.items.setStackInSlot(LIQUID_IN_SLOT, Items.BUCKET.getDefaultInstance());

				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				int filled = FluidUtil.tryFluidTransfer(bowl.getFluidTank(), fluidHandlerItem,
						bowl.getFluidTank().getFluidAmount(), true).getAmount();
				if (filled > 0) {
					bowl.items.setStackInSlot(LIQUID_IN_SLOT, fluidHandlerItem.getContainer());

				}
			}
		}
	}

	public static void drainInternal(MixingBowlBlockEntity bowl) {
		ItemStack inputItem = bowl.items.getStackInSlot(LIQUID_OUT_SLOT);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() == Items.BUCKET) {
				FluidStack stack = bowl.getFluidTank().drain(FluidType.BUCKET_VOLUME,
						IFluidHandler.FluidAction.SIMULATE);
				if (stack.getAmount() == FluidType.BUCKET_VOLUME) {
					bowl.getFluidTank().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
					inputItem.shrink(1);
					bowl.items.setStackInSlot(LIQUID_OUT_SLOT, stack.getFluid().getBucket().getDefaultInstance());
				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				int filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, bowl.getFluidTank(),
						bowl.getFluidTank().getFluidAmount(), true).getAmount();
				if (filled > 0) {
					bowl.items.setStackInSlot(LIQUID_OUT_SLOT, fluidHandlerItem.getContainer());
				}
			}
		}
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(GHOST_SLOT + 1) {
//			@Override
//			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
//				if (slot != 32)
//					return 1;
//				else
//					return 64;
//			}

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				if (slot == LIQUID_IN_SLOT)
					if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						return true;
					else
						return false;
				if (slot == LIQUID_OUT_SLOT)
					if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						return true;
					else
						return false;
				if (slot == GHOST_SLOT)
					return false;
				return true;
			}

			@Override
			protected void onContentsChanged(int slot) {
				if (slot != GHOST_SLOT) {
					zeroProgress();
					updateInventory();
				}

				if (slot == LIQUID_IN_SLOT)
					MixingBowlBlockEntity.fillInternal(MixingBowlBlockEntity.this);
				if (slot == LIQUID_OUT_SLOT)
					MixingBowlBlockEntity.drainInternal(MixingBowlBlockEntity.this);
			}

		};
	}

	private boolean doesMealHaveContainer(ItemStack meal) {
		return meal.hasCraftingRemainingItem();
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
		this.setupRecipe();
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	private void setupRecipe() {
		Optional<RecipeHolder<MixingBowlRecipe>> recipe = this.matchRecipe();
		if (recipe.isPresent()) {
			this.curRecipe = recipe.get().value();
			this.items.setStackInSlot(GHOST_SLOT, curRecipe.getResultItem(this.level.registryAccess()).copy());
		} else {
			this.curRecipe = null;
			this.items.setStackInSlot(GHOST_SLOT, ItemStack.EMPTY.copy());
		}
	}

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
		this.getFluidTank().readFromNBT(registries, nbt);
		this.stirs = nbt.getInt("stirs");
		ItemStack.parse(registries, nbt.getCompound("usedItem")).ifPresent(i -> containerItem = i);
		this.complete = nbt.getBoolean("complete");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put(INV_TAG, items.serializeNBT(registries));
		this.getFluidTank().writeToNBT(registries, tag);
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
			items.getStackInSlot(i).shrink(1);
		}
		items.getStackInSlot(CONTAINER_SLOT).shrink(1);
	}

	protected Optional<RecipeHolder<MixingBowlRecipe>> matchRecipe() {
		if (level != null) {

			Optional<RecipeHolder<MixingBowlRecipe>> recipe = level.getRecipeManager().getRecipeFor(
					ExtraDelightRecipes.MIXING_BOWL.get(), new MixingBowlRecipeWrapper(this.items, this.fluids) {
						@Override
						public int size() {
							return 9;
						}
					}, level);

			// setRecipe(recipe);
			return recipe;
		}
		return Optional.empty();

	}

	public InteractionResult mix(Player player) {

//		Optional<RecipeHolder<MixingBowlRecipe>> recipeOptional = matchRecipe();
		if (curRecipe != null) {
//			MixingBowlRecipe recipe = recipeOptional.get().value();

			if (this.stirs < curRecipe.getStirs()) {
				stirs++;

//				ItemStack[] items = getItems();
//				for (int i = 0; i < 1 + level.random.nextInt(4); i++)
//					level.addParticle(
//							new ItemParticleOption(ParticleTypes.ITEM,
//									items[items.length > 1 ? level.random.nextInt(items.length - 1) : 0]),
//							worldPosition.getX() + 0.25f + level.random.nextDouble() / 2,
//							worldPosition.getY() - 0.5f - level.random.nextDouble(),
//							worldPosition.getZ() + 0.25f + level.random.nextDouble() / 2, 0, 0, 0);

				level.playSound(player, worldPosition, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1, 1);
			} else {
				this.containerItem = curRecipe.getUsedItem().copy();

				ItemStack i = curRecipe.getResultItem(player.level().registryAccess()).copy();

//				

				i.onCraftedBy(player.level(), player, 1);
//				NeoForgeEventFactory.firePlayerCraftingEvent(player, i, new RecipeWrapper(items));
				BlockEntityUtils.Inventory.givePlayerItemStack(i, player, level, worldPosition);
				dropContainers(items, player);
				clearItems();
				removeFluids(curRecipe.getFluids());
				this.stirs = 0;
//				items.setStackInSlot(CONTAINER_SLOT, i);
				this.updateInventory();
				complete = true;
			}
			updateInventory();
		}

		return InteractionResult.SUCCESS;
	}

	private void removeFluids(List<SizedFluidIngredient> list) {
		for (int i = 0; i < list.size(); i++) {
			fluids.drain(list.get(i), FluidAction.EXECUTE);
		}
	}

	public boolean testContainerItem(ItemStack stack) {
		if (this.containerItem.isEmpty())
			return true;
		return this.containerItem.getItem() == stack.getItem();
	}

	private void dropContainers(@NotNull IItemHandlerModifiable inv, Player player) {
		for (int i = 0; i < 9; i++) {
			BlockEntityUtils.Inventory.givePlayerItemStack(inv.getStackInSlot(i).getCraftingRemainingItem(), player,
					level, worldPosition);

		}
	}
}
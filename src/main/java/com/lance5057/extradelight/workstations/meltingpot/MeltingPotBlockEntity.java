package com.lance5057.extradelight.workstations.meltingpot;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
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
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;

public class MeltingPotBlockEntity extends BlockEntity implements HeatableBlockEntity {
	public static final String ITEM_TAG = "inv";

	private final ItemStackHandler items = createItemHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);

	public static final int INPUT_SLOT = 0;
	public static final int BUCKET_SLOT = 1;
	public static final int BUCKET_SLOT_OUT = 2;

	private final FluidTank fluids = createFluidHandler();

	public int cookingTime = 0;
	public int cookingProgress = 0;
//	private FluidStack result;

	private final RecipeManager.CachedCheck<SingleRecipeInput, MeltingPotRecipe> quickCheck;

	public FluidTank getFluidTank() {
		return fluids;
	}

	public MeltingPotBlockEntity(BlockPos pos, BlockState blockState) {
		super(ExtraDelightBlockEntities.MELTING_POT.get(), pos, blockState);
		this.quickCheck = RecipeManager.createCheck(ExtraDelightRecipes.MELTING_POT.get());
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createItemHandler() {
		return new ItemStackHandler(3) {
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				if (slot == 2)
					return false;
				return true;
			}

			@Override
			@NotNull
			public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
//				if (slot == 0) {
//					if (!getStackInSlot(slot).isEmpty()) {
//						return super.insertItem(slot, stack, simulate);
//					} else {
//						Optional<RecipeHolder<MeltingPotRecipe>> r = MeltingPotBlockEntity.this.matchRecipe(stack);
//						if (r.isPresent()) {
//							if (getStackInSlot(slot) == ItemStack.EMPTY) {
//								MeltingPotBlockEntity.this.cookingTime = r.get().value().cooktime;
//								MeltingPotBlockEntity.this.cookingProgress = 0;
//								MeltingPotBlockEntity.this.result = r.get().value().result;
//								MeltingPotBlockEntity.this.updateInventory();
//								return super.insertItem(slot, stack, simulate);
//							}
//						}
//					}
//				}
				if (slot == 1)
					if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						return super.insertItem(slot, stack, simulate);
					else
						return stack;

				return super.insertItem(slot, stack, simulate);
			}

		};
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		MeltingPotBlockEntity pBlockEntity = (MeltingPotBlockEntity) be;
		boolean flag = false;
		IItemHandlerModifiable h = pBlockEntity.getItemHandler();
		FluidTank f = pBlockEntity.getFluidTank();

		ItemStack itemstack = h.getStackInSlot(0);
		RecipeHolder<MeltingPotRecipe> recipeholder;
		if (!itemstack.isEmpty()) {
			recipeholder = pBlockEntity.quickCheck.getRecipeFor(new SingleRecipeInput(itemstack), level).orElse(null);
			pBlockEntity.cookingTime = recipeholder.value().cooktime;
		} else {
			recipeholder = null;
			pBlockEntity.cookingTime = 0;
			pBlockEntity.cookingProgress = 0;
		}

		if (recipeholder != null) {
			FluidStack fluid = recipeholder.value().result.copy();

			if (f.isEmpty() || f.fill(fluid, FluidAction.SIMULATE) == fluid.getAmount())
				if (!itemstack.isEmpty()) {
					flag = true;
					int j = pBlockEntity.cookingProgress++;
					if (pBlockEntity.cookingProgress >= pBlockEntity.cookingTime) {
						f.fill(fluid, FluidAction.EXECUTE);
						itemstack.shrink(1);
						pBlockEntity.cookingProgress = 0;
						if (itemstack.isEmpty()) {
							pBlockEntity.cookingTime = 0;
						}
						level.sendBlockUpdated(pos, state, state, 3);
					} else {

						for (int k = 0; k < 1; k++) {
							level.addParticle(ParticleTypes.DOLPHIN, pos.getX() + level.random.nextDouble() / 16,
									pos.getY() - level.random.nextDouble() / 16,
									pos.getZ() + level.random.nextDouble() / 16, 0, 1f, 0);
						}
					}
				} else {

				}

			if (flag) {
				pBlockEntity.updateInventory();
			}
		}

		if (!h.getStackInSlot(BUCKET_SLOT).isEmpty()) {
			ItemStack inputItem = h.getStackInSlot(BUCKET_SLOT);
			ItemStack outputItem = h.getStackInSlot(BUCKET_SLOT_OUT);
			if (inputItem.getItem() == Items.BUCKET) {
				if (!f.getFluid().isEmpty()) {
					FluidStack stack = f.drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.SIMULATE);
					if (stack.getAmount() == FluidType.BUCKET_VOLUME
							&& (outputItem.isEmpty() || (outputItem.getItem() == stack.getFluid().getBucket()
									&& outputItem.getCount() < outputItem.getMaxStackSize()))) {
						f.drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
						inputItem.shrink(1);
						if (outputItem.isEmpty()) {
							h.setStackInSlot(2, stack.getFluid().getBucket().getDefaultInstance());
						} else {
							outputItem.grow(1);
						}
					}
				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				FluidUtil.tryFluidTransfer(fluidHandlerItem, f, f.getFluidAmount(), flag);
			}

		}
	}

	public boolean isHeated() {
		if (level == null)
			return false;
		return this.isHeated(level, worldPosition);
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(),
				Block.UPDATE_CLIENTS);
		this.setChanged();
	}

//	public Optional<RecipeHolder<MeltingPotRecipe>> matchRecipe(ItemStack itemstack) {
//		if (this.level != null) {
//			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.MELTING_POT.get(),
//					new SingleRecipeInput(itemstack), level);
//		}
//		return Optional.empty();
//
//	}

	private FluidTank createFluidHandler() {
		FluidTank tank = new FluidTank(FluidType.BUCKET_VOLUME * 6) {
			@Override
			protected void onContentsChanged() {
				MeltingPotBlockEntity.this.requestModelDataUpdate();
				MeltingPotBlockEntity.this.getLevel().sendBlockUpdated(MeltingPotBlockEntity.this.getBlockPos(),
						MeltingPotBlockEntity.this.getBlockState(), MeltingPotBlockEntity.this.getBlockState(), 3);
				MeltingPotBlockEntity.this.setChanged();
			}
		};

		return tank;
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
		fluids.readFromNBT(registries, nbt);
		if (nbt.contains(ITEM_TAG)) {
			items.deserializeNBT(registries, nbt.getCompound(ITEM_TAG));
		}

		this.cookingTime = nbt.getInt("cooktime");
		this.cookingProgress = nbt.getInt("cookprogress");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		fluids.writeToNBT(registries, tag);
		tag.put(ITEM_TAG, items.serializeNBT(registries));

		tag.putInt("cooktime", this.cookingTime);
		tag.putInt("cookprogress", cookingProgress);

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

}

package com.lance5057.extradelight.workstations.chiller;

import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ChillerBlockEntity extends BlockEntity {
	public static final int MEAL_DISPLAY_SLOT = 4;
	public static final int CONTAINER_SLOT = 5;
	public static final int OUTPUT_SLOT = 6;
	public static final int FLUID_IN = 7;
	public static final int FLUID_OUT = 8;
	public static final int DRIP_TRAY_OUT = 9;
	public static final int ICE = 10;
	public static final int INVENTORY_SIZE = ICE + 1;
	private final ItemStackHandler inventory;
	private int cookTime;
	private int cookTimeTotal;
	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;
	private final CachedCheck<ChillerRecipeWrapper, ChillerRecipe> quickCheck;

	private final FluidTank fluid = createFluidHandler();
	private final FluidTank dripTray = createDripFluidHandler();

	private FluidTank createFluidHandler() {
		FluidTank tank = new FluidTank(FluidType.BUCKET_VOLUME * 6) {
			@Override
			protected void onContentsChanged() {
				ChillerBlockEntity.this.requestModelDataUpdate();
				ChillerBlockEntity.this.getLevel().sendBlockUpdated(ChillerBlockEntity.this.getBlockPos(),
						ChillerBlockEntity.this.getBlockState(), ChillerBlockEntity.this.getBlockState(),
						Block.UPDATE_ALL);
				ChillerBlockEntity.this.setChanged();
			}
		};

		return tank;
	}

	private FluidTank createDripFluidHandler() {
		FluidTank tank = new FluidTank(FluidType.BUCKET_VOLUME) {
			@Override
			protected void onContentsChanged() {
				ChillerBlockEntity.this.requestModelDataUpdate();
				ChillerBlockEntity.this.getLevel().sendBlockUpdated(ChillerBlockEntity.this.getBlockPos(),
						ChillerBlockEntity.this.getBlockState(), ChillerBlockEntity.this.getBlockState(),
						Block.UPDATE_ALL);
				ChillerBlockEntity.this.setChanged();
			}
		};

		return tank;
	}

	public FluidTank getFluidTank() {
		return fluid;
	}

	public FluidTank getDripTray() {
		return this.dripTray;
	}

	public ChillerBlockEntity(BlockPos pos, BlockState state) {
		super(ExtraDelightBlockEntities.CHILLER.get(), pos, state);
		this.inventory = createHandler();
		this.quickCheck = RecipeManager.createCheck(ExtraDelightRecipes.CHILLER.get());
	}

	private void fillInternal(ChillerBlockEntity Chiller) {
		ItemStack inputItem = Chiller.inventory.getStackInSlot(FLUID_IN);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() instanceof BucketItem filledBucket) {
				int filled = Chiller.getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
						IFluidHandler.FluidAction.SIMULATE);
				if (filled == FluidType.BUCKET_VOLUME) {
					Chiller.getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
							IFluidHandler.FluidAction.EXECUTE);
					inputItem.shrink(1);
					Chiller.inventory.setStackInSlot(FLUID_IN, Items.BUCKET.getDefaultInstance());
				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				int filled = FluidUtil.tryFluidTransfer(Chiller.getFluidTank(), fluidHandlerItem,
						Chiller.getFluidTank().getFluidAmount(), true).getAmount();
				if (filled > 0) {
					Chiller.inventory.setStackInSlot(FLUID_IN, fluidHandlerItem.getContainer());

				}
			}
		}
	}

	private void drainInternal(ChillerBlockEntity Chiller) {
		ItemStack inputItem = Chiller.inventory.getStackInSlot(FLUID_OUT);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() == Items.BUCKET) {
				if (!Chiller.getFluidTank().getFluid().isEmpty()) {
					FluidStack stack = Chiller.getFluidTank().drain(FluidType.BUCKET_VOLUME,
							IFluidHandler.FluidAction.SIMULATE);
					if (stack.getAmount() == FluidType.BUCKET_VOLUME) {
						Chiller.getFluidTank().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
						inputItem.shrink(1);
						Chiller.inventory.setStackInSlot(FLUID_OUT, stack.getFluid().getBucket().getDefaultInstance());
					}
				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				if (fluidHandlerItem != null && Chiller.inventory.getStackInSlot(FLUID_OUT).isEmpty()) {
					int filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, Chiller.getFluidTank(),
							Chiller.getFluidTank().getFluidAmount(), true).getAmount();
					if (filled > 0) {
						Chiller.inventory.setStackInSlot(FLUID_OUT, fluidHandlerItem.getContainer());
					}
				}
			}
		}
	}

	private void drainDripTray(ChillerBlockEntity Chiller) {
		ItemStack inputItem = Chiller.inventory.getStackInSlot(DRIP_TRAY_OUT);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() == Items.BUCKET) {
				if (!Chiller.getDripTray().getFluid().isEmpty()) {
					FluidStack stack = Chiller.getDripTray().drain(FluidType.BUCKET_VOLUME,
							IFluidHandler.FluidAction.SIMULATE);
					if (stack.getAmount() == FluidType.BUCKET_VOLUME) {
						Chiller.getDripTray().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
						inputItem.shrink(1);
						Chiller.inventory.setStackInSlot(DRIP_TRAY_OUT,
								stack.getFluid().getBucket().getDefaultInstance());
					}
				}
			} else {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				if (fluidHandlerItem != null && Chiller.inventory.getStackInSlot(DRIP_TRAY_OUT).isEmpty()) {
					int filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, Chiller.getDripTray(),
							Chiller.getDripTray().getFluidAmount(), true).getAmount();
					if (filled > 0) {
						Chiller.inventory.setStackInSlot(DRIP_TRAY_OUT, fluidHandlerItem.getContainer());
					}
				}
			}
		}
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		ChillerBlockEntity chiller = (ChillerBlockEntity) be;
		chiller.drainInternal(chiller);
		chiller.fillInternal(chiller);
		chiller.drainDripTray(chiller);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		nbt.put("items", this.inventory.serializeNBT(registries));
		this.fluid.writeToNBT(registries, nbt);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
		this.fluid.readFromNBT(registries, tag);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		this.fluid.readFromNBT(registries, tag);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
		super.loadAdditional(compound, registries);
		inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
		cookTime = compound.getInt("CookTime");
		cookTimeTotal = compound.getInt("CookTimeTotal");
		this.fluid.readFromNBT(registries, compound);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
		super.saveAdditional(compound, registries);
		compound.putInt("CookTime", cookTime);
		compound.putInt("CookTimeTotal", cookTimeTotal);
		compound.put("Inventory", inventory.serializeNBT(registries));
		this.fluid.writeToNBT(registries, compound);
	}

	private Optional<RecipeHolder<ChillerRecipe>> getMatchingRecipe(ChillerRecipeWrapper inventoryWrapper) {
		if (level == null)
			return Optional.empty();
		return quickCheck.getRecipeFor(inventoryWrapper, this.level);
	}

	public ItemStackHandler getInventory() {
		return inventory;
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(INVENTORY_SIZE) {
			@Override
			protected void onContentsChanged(int slot) {
				updateInventory();
			}

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				if (slot == FLUID_IN) {
					if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						if (!stack.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0).isEmpty())
							return true;
					return false;
				} else if (slot == FLUID_OUT) {
					if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null)
						if (stack.is(Tags.Items.BUCKETS_EMPTY))
							return true;
						else if (stack.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0).isEmpty()
								&& !stack.is(Tags.Items.BUCKETS))
							return true;
					return false;
				}
				return true;
			}

			@Override
			public int getSlotLimit(int slot) {
				if (slot == FLUID_IN || slot == FLUID_OUT)
					return 1;
				return Item.ABSOLUTE_MAX_STACK_SIZE;
			}
		};
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(),
				Block.UPDATE_CLIENTS);
		this.setChanged();
	}

}

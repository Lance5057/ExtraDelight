package com.lance5057.extradelight.workstations.chiller;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.components.ChillComponent;

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
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ChillerBlockEntity extends BlockEntity {
	public static final int INGREDIENT_SLOTS = 4;
	public static final int CONTAINER_SLOT = 5;
	public static final int OUTPUT_SLOT = 6;
	public static final int FLUID_IN = 7;
	public static final int FLUID_OUT = 8;
	public static final int DRIP_TRAY_OUT = 9;
	public static final int ICE = 10;
	public static final int INVENTORY_SIZE = ICE + 1;
	public static final String ITEM_TAG = "inv";
	private final ItemStackHandler inventory = createHandler();
	private int cookTime;

	public int getCookTime() {
		return cookTime;
	}

	private int cookTimeTotal;

	public int getCookTimeTotal() {
		return cookTimeTotal;
	}

	private int chilltime;
	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;
	private final CachedCheck<ChillerRecipeWrapper, ChillerRecipe> quickCheck = RecipeManager
			.createCheck(ExtraDelightRecipes.CHILLER.get());

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

		if (chiller.chilltime > 0) {
			chiller.chilltime--;
			chiller.dripTray.fill(new FluidStack(Fluids.WATER, 1), FluidAction.EXECUTE);
		}

		RecipeHolder<ChillerRecipe> recipeholder = chiller.quickCheck
				.getRecipeFor(new ChillerRecipeWrapper(chiller.inventory, chiller.fluid.getFluid()), level)
				.orElse(null);

		if (recipeholder != null) {
			chiller.cookTimeTotal = recipeholder.value().getCookTime();

			if (chiller.cookTime >= chiller.cookTimeTotal) {
				subtractItems(chiller);
				chiller.fluid.drain(recipeholder.value().getFluid(), FluidAction.EXECUTE);

				ItemStack result = recipeholder.value().getResultItem(level.registryAccess()).copy();
				ItemStack test = chiller.inventory.insertItem(OUTPUT_SLOT, result, true);
				if (test.isEmpty()) {
					chiller.inventory.insertItem(OUTPUT_SLOT, result, false);
					chiller.cookTime = 0;
				}
			} else {
				if (testChillTime(chiller)) {
					chiller.cookTime++;
				}
			}
		} else {
			chiller.cookTime = 0;
			chiller.cookTimeTotal = 0;
		}
		chiller.updateInventory();
	}

	private static boolean testChillTime(ChillerBlockEntity chiller) {
		if (chiller.dripTray.getFluidAmount() < 1000)
			if (chiller.chilltime <= 0) {
				if (!chiller.inventory.getStackInSlot(ICE).isEmpty()) {
					ItemStack ice = chiller.inventory.getStackInSlot(ICE);

					ChillComponent time = ice.get(ExtraDelightComponents.CHILL.get());
					chiller.chilltime = time.time();

					ice.shrink(1);
					return true;
				} else
					return true;
			} else
				return true;
		return false;
	}

	private static void subtractItems(ChillerBlockEntity chiller) {
		ItemStackHandler i = chiller.inventory;

		i.getStackInSlot(CONTAINER_SLOT).shrink(1);
		for (int j = 0; j < 4; j++)
			i.getStackInSlot(j).shrink(1);
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
		fluid.readFromNBT(registries, nbt.getCompound("tank"));
		this.dripTray.readFromNBT(registries, nbt.getCompound("driptray"));
		if (nbt.contains(ITEM_TAG)) {
			inventory.deserializeNBT(registries, nbt.getCompound(ITEM_TAG));
		}

		this.cookTime = nbt.getInt("cooktime");
		this.cookTimeTotal = nbt.getInt("cookprogress");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put("tank", fluid.writeToNBT(registries, new CompoundTag()));
		tag.put("driptray", this.dripTray.writeToNBT(registries, new CompoundTag()));
		tag.put(ITEM_TAG, inventory.serializeNBT(registries));

		tag.putInt("cooktime", this.cookTime);
		tag.putInt("cookprogress", cookTimeTotal);

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
				} else if (slot == ICE) {
					if (!stack.has(ExtraDelightComponents.CHILL))
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
				Block.UPDATE_ALL);
		this.setChanged();
	}

}

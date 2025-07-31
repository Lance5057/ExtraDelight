package com.lance5057.extradelight.workstations.chiller;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.components.ChillComponent;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.util.BottleFluidRegistry;
import com.lance5057.extradelight.workstations.FancyTank;
import com.lance5057.extradelight.workstations.IFancyTankHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
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
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class ChillerBlockEntity extends BlockEntity implements IFancyTankHandler<ChillerBlockEntity> {
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
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> inventory);
	private int cookTime;

	@Override
	public int getFluidInSlot() {
		return FLUID_IN;
	}

	@Override
	public int getFluidOutSlot() {
		return FLUID_OUT;
	}

	public int getCookTime() {
		return cookTime;
	}

	private int cookTimeTotal;

	public int getCookTimeTotal() {
		return cookTimeTotal;
	}

	private int chilltime;
	private int chillDuration;

	public int getChilltime() {
		return chilltime;
	}

	@Override
	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;
	private final CachedCheck<ChillerRecipeWrapper, ChillerRecipe> quickCheck = RecipeManager
			.createCheck(ExtraDelightRecipes.CHILLER.get());

	private final FancyTank fluid = createFluidHandler();
	private final FluidTank dripTray = createDripFluidHandler();

	private FancyTank createFluidHandler() {
		FancyTank tank = new FancyTank(FluidType.BUCKET_VOLUME, e -> true, 1) {
			@Override
			protected void onContentsChanged() {
				super.onContentsChanged();
				var level = ChillerBlockEntity.this.getLevel();
				if (level == null)
					return;
				ChillerBlockEntity.this.requestModelDataUpdate();
				level.sendBlockUpdated(ChillerBlockEntity.this.getBlockPos(), ChillerBlockEntity.this.getBlockState(),
						ChillerBlockEntity.this.getBlockState(), Block.UPDATE_ALL);
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

	public FancyTank getFluidTank() {
		return fluid;
	}

	public FluidTank getDripTray() {
		return this.dripTray;
	}

	public ChillerBlockEntity(BlockPos pos, BlockState state) {
		super(ExtraDelightBlockEntities.CHILLER.get(), pos, state);
	}

	public static void drainDripTray(ChillerBlockEntity bowl) {
		ItemStack inputItem = bowl.inventory.getStackInSlot(DRIP_TRAY_OUT);
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() == Items.BUCKET) {
				FluidStack stack = bowl.getDripTray().drain(FluidType.BUCKET_VOLUME,
						IFluidHandler.FluidAction.SIMULATE);
				if (stack.getAmount() == FluidType.BUCKET_VOLUME) {
					bowl.getDripTray().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
					inputItem.shrink(1);
					bowl.inventory.setStackInSlot(DRIP_TRAY_OUT, stack.getFluid().getBucket().getDefaultInstance());
				}
			} else if (inputItem.getCapability(Capabilities.FluidHandler.ITEM) != null) {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				int filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, bowl.getDripTray(),
						bowl.getDripTray().getFluidAmount(), true).getAmount();
				if (filled > 0) {
					bowl.inventory.setStackInSlot(DRIP_TRAY_OUT, fluidHandlerItem.getContainer());
				}
			} else {
				// Because the blasted water bottle has no craftRemainder
				if (inputItem.getItem() == Items.GLASS_BOTTLE) {
					FluidStack stack = bowl.getDripTray().drain(250, IFluidHandler.FluidAction.SIMULATE);

					if (stack.getAmount() == 250) {
						bowl.getDripTray().drain(stack, FluidAction.EXECUTE);
						// If we just use Items.POTION we get an item called Uncraftable Potion instead
						// of Water Bottle
						BlockEntityUtils.Inventory.dropItemInWorld(
								PotionContents.createItemStack(Items.POTION, Potions.WATER), bowl.level,
								bowl.getBlockPos());
						inputItem.shrink(1);
					}
				}
			}
		}
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		ChillerBlockEntity chiller = (ChillerBlockEntity) be;

		ChillerBlockEntity.drainDripTray(chiller);
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
				ItemStack result = recipeholder.value().getResultItem(level.registryAccess()).copy();
				ItemStack test = chiller.inventory.insertItem(OUTPUT_SLOT, result, true);
				if (test.isEmpty()) {
					dropContainers(state, chiller, level);
					subtractItems(chiller, recipeholder.value().shouldConsumeContainer(), result.getCount());

					chiller.fluid.drain(recipeholder.value().getFluid(), FluidAction.EXECUTE);

					chiller.inventory.insertItem(OUTPUT_SLOT, result, false);
					chiller.cookTime = 0;
				}
			} else {
				if (isChilling(chiller)) {
					chiller.cookTime++;
				}
			}
		} else {
			chiller.cookTime = 0;
			chiller.cookTimeTotal = 0;
		}
		chiller.updateInventory();
	}

	private static boolean isChilling(ChillerBlockEntity chiller) {
		if (chiller.dripTray.getFluidAmount() < 1000)
			if (chiller.chilltime <= 0) {
				if (!chiller.inventory.getStackInSlot(ICE).isEmpty()) {
					ItemStack ice = chiller.inventory.getStackInSlot(ICE);

					ChillComponent time = ice.get(ExtraDelightComponents.CHILL.get());
					if (time != null) {
						chiller.chilltime = time.time();
						chiller.chillDuration = time.time();

						ice.shrink(1);
						return true;
					}
				}
			} else {
				return true;
			}
		return false;
	}

	private static void subtractItems(ChillerBlockEntity chiller, boolean consumeContainer, int k) {
		ItemStackHandler i = chiller.inventory;

		if (consumeContainer) {
			i.getStackInSlot(CONTAINER_SLOT).shrink(k);
		}
		for (int j = 0; j < 4; j++)
			i.getStackInSlot(j).shrink(1);
	}

	private static void dropContainers(BlockState state, @NotNull ChillerBlockEntity chiller, Level level) {
		Direction direction = state.getValue(ChillerBlock.FACING).getCounterClockWise();
		double x = chiller.worldPosition.getX() + 0.5 + (direction.getStepX() * 0.25);
		double y = chiller.worldPosition.getY() + 0.7;
		double z = chiller.worldPosition.getZ() + 0.5 + (direction.getStepZ() * 0.25);

		for (int i = 0; i < 4; i++) {
			ItemUtils.spawnItemEntity(level, chiller.inventory.getStackInSlot(i).getCraftingRemainingItem().copy(), x,
					y, z, direction.getStepX() * 0.08F, 0.25F, direction.getStepZ() * 0.08F);

		}
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

		this.chillDuration = nbt.getInt("chillduration");
		this.chilltime = nbt.getInt("chilltime");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put("tank", fluid.writeToNBT(registries, new CompoundTag()));
		tag.put("driptray", this.dripTray.writeToNBT(registries, new CompoundTag()));
		tag.put(ITEM_TAG, inventory.serializeNBT(registries));

		tag.putInt("cooktime", this.cookTime);
		tag.putInt("cookprogress", cookTimeTotal);

		tag.putInt("chillduration", this.chillDuration);
		tag.putInt("chilltime", this.chilltime);

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

				if (slot == FLUID_IN)
					ChillerBlockEntity.this.fillInternal(ChillerBlockEntity.this);
				if (slot == FLUID_OUT)
					ChillerBlockEntity.this.drainInternal(ChillerBlockEntity.this);
				if (slot == DRIP_TRAY_OUT)
					ChillerBlockEntity.drainDripTray(ChillerBlockEntity.this);

			}

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				switch (slot) {
				case FLUID_IN:
					return stack.getCapability(Capabilities.FluidHandler.ITEM) != null || stack.is(Items.BUCKET)
							|| !BottleFluidRegistry.getFluidFromBottle(stack).isEmpty();
				case FLUID_OUT:

					return stack.getCapability(Capabilities.FluidHandler.ITEM) != null || stack.is(Items.BUCKET)
							|| ItemStack.isSameItem(stack,
									BottleFluidRegistry.getBottleFromFluid(ChillerBlockEntity.this.getFluidTank()
											.drain(250, IFluidHandler.FluidAction.SIMULATE)).getCraftingRemainingItem())
							|| stack.is(Items.GLASS_BOTTLE);
				case ICE:
					if (stack.has(ExtraDelightComponents.CHILL.get()))
						return true;
					return false;
//				case GHOST_SLOT:
//					return false;
				default:
					return true;
				}
			}
		};
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(),
				Block.UPDATE_ALL);
		this.setChanged();
	}

	public int getChillDuration() {
		return chillDuration;
	}

}

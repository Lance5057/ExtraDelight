package com.lance5057.extradelight.workstations.vat;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightConfig;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.util.BottleFluidRegistry;
import com.lance5057.extradelight.workstations.FancyTank;
import com.lance5057.extradelight.workstations.IFancyTankHandler;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlockEntity;
import com.lance5057.extradelight.workstations.vat.recipes.VatRecipe;
import com.lance5057.extradelight.workstations.vat.recipes.VatRecipeWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
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
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class VatBlockEntity extends BlockEntity implements IFancyTankHandler<VatBlockEntity> {
	public static final String INV_TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public static final int CRAFT_SLOTS = 5;
	public static final int CONTAINER_SLOT = CRAFT_SLOTS + 1;
	public static final int FERMENTATION_INPUT_SLOT = CONTAINER_SLOT + 1;
	public static final int LIQUID_IN_SLOT = FERMENTATION_INPUT_SLOT + 1;
	public static final int LIQUID_OUT_SLOT = LIQUID_IN_SLOT + 1;
	public static final int OUTPUT_SLOT = LIQUID_OUT_SLOT + 1;

	@Override
	public int getFluidInSlot() {
		return LIQUID_IN_SLOT;
	}

	@Override
	public int getFluidOutSlot() {
		return LIQUID_OUT_SLOT;
	}

	public static final String FLUID_TAG = "tank";

	private final FancyTank fluid = createFluidHandler();

	private int cookTime = 0;
	private int cookTimeTotal = 0;

	private int stage = 0;
	private int stageTotal = 0;

	private boolean lidRequired = false;
	private boolean hasLid = false;

	public boolean isHasLid() {
		return hasLid;
	}

	public boolean isLidRequired() {
		return lidRequired;
	}

	public int getStageTotal() {
		return stageTotal;
	}

	public int getStage() {
		return stage;
	}

	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;
	private final CachedCheck<VatRecipeWrapper, VatRecipe> quickCheck = RecipeManager
			.createCheck(ExtraDelightRecipes.VAT.get());

	public int getCookTime() {
		return cookTime;
	}

	public int getCookTimeTotal() {
		return cookTimeTotal;
	}

//	public ItemStack containerItem = ItemStack.EMPTY;

	VatRecipe curRecipe;

	public VatBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.VAT.get(), pPos, pState);
	}

	private FancyTank createFluidHandler() {
		FancyTank tank = new FancyTank(FluidType.BUCKET_VOLUME, e -> true, 1) {
			@Override
			protected void onContentsChanged() {
				super.onContentsChanged();
				var level = VatBlockEntity.this.getLevel();
				if (level == null)
					return;
				VatBlockEntity.this.requestModelDataUpdate();
				level.sendBlockUpdated(VatBlockEntity.this.getBlockPos(), VatBlockEntity.this.getBlockState(),
						VatBlockEntity.this.getBlockState(), Block.UPDATE_ALL);
				VatBlockEntity.this.setChanged();
			}
		};

		return tank;
	}

	public FancyTank getFluidTank() {
		return fluid;
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(OUTPUT_SLOT + 1) {

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				switch (slot) {
				case LIQUID_IN_SLOT:
					return stack.getCapability(Capabilities.FluidHandler.ITEM) != null || stack.is(Items.BUCKET)
							|| !BottleFluidRegistry.getFluidFromBottle(stack).isEmpty();
				case LIQUID_OUT_SLOT:

					return stack.getCapability(Capabilities.FluidHandler.ITEM) != null || stack.is(Items.BUCKET)
							|| ItemStack.isSameItem(stack,
									BottleFluidRegistry.getBottleFromFluid(VatBlockEntity.this.getFluidTank().drain(250,
											IFluidHandler.FluidAction.SIMULATE)).getCraftingRemainingItem())
							|| stack.is(Items.GLASS_BOTTLE);
//				case GHOST_SLOT:
//					return false;
				default:
					return true;
				}
			}

			@Override
			protected void onContentsChanged(int slot) {
//				if (slot != GHOST_SLOT) {
//					zeroProgress();
//					updateInventory();
//				}

				if (slot == LIQUID_IN_SLOT)
					VatBlockEntity.this.fillInternal(VatBlockEntity.this);
				if (slot == LIQUID_OUT_SLOT)
					VatBlockEntity.this.drainInternal(VatBlockEntity.this);
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

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		VatBlockEntity vat = (VatBlockEntity) be;
		if (level.isClientSide()) {
			RandomSource random = level.random;
			double x = (double) pos.getX() + 0.5D + (level.random.nextDouble() * 0.6D - 0.3D);
			double y = (double) pos.getY() + 1.1D;
			double z = (double) pos.getZ() + 0.5D + (level.random.nextDouble() * 0.6D - 0.3D);
			if (vat.cookTime == 0 && vat.stage > 0)
				if (random.nextFloat() < 0.2F) {
					level.addParticle(ParticleTypes.GLOW, x, y, z, 0, 0, 0);
				}
			if (vat.cookTime != 0 && vat.cookTime < vat.cookTimeTotal)
				if (random.nextFloat() < 0.5F) {
					level.addParticle(ParticleTypes.MYCELIUM, x, y, z, 0, 1, 0);
				}
		} else {
			if (level.getBlockState(vat.worldPosition.above()).is(ExtraDelightBlocks.LID)) {
				vat.hasLid = true;
			} else
				vat.hasLid = false;

			RecipeHolder<VatRecipe> recipeholder = vat.quickCheck
					.getRecipeFor(new VatRecipeWrapper(vat.items, vat.fluid), level).orElse(null);

			if (recipeholder != null) {
				vat.stageTotal = recipeholder.value().getStages();
				if (vat.stage >= vat.stageTotal) {// Finish
					ItemStack result = recipeholder.value().getResultItem(level.registryAccess()).copy();
					ItemStack test = vat.items.insertItem(OUTPUT_SLOT, result, true);
					if (test.isEmpty()) {
						dropContainers(state, vat, level);
						subtractItems(vat, result.getCount());

						SizedFluidIngredient sfi = recipeholder.value().getFluid();
						if (sfi.test(vat.fluid.getFluid()))
							vat.fluid.drain(sfi.amount(), FluidAction.EXECUTE);
						BlockEntityUtils.Inventory.dropItemInWorld(
								vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).getCraftingRemainingItem().copy(),
								level, vat.getBlockPos());
//						ItemUtils.spawnItemEntity(level,
//								vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).getCraftingRemainingItem().copy(),
//								vat.getBlockPos().getX(), vat.getBlockPos().getY() + 1, vat.getBlockPos().getZ(), 0, 0,
//								0);
						vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).shrink(1);

						vat.items.insertItem(OUTPUT_SLOT, result, false);
						vat.cookTime = 0;
						vat.stage = 0;
					}
				} else {
					vat.cookTimeTotal = recipeholder.value().getStageIngredients().get(vat.stage).time;
					vat.lidRequired = recipeholder.value().getStageIngredients().get(vat.stage).lid;
					vat.stageTotal = recipeholder.value().getStages();

					if (vat.cookTime >= vat.cookTimeTotal) {
//						ItemUtils.spawnItemEntity(level,
//								vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).copy().getCraftingRemainingItem(),
//								vat.getBlockPos().getX(), vat.getBlockPos().getY() + 1, vat.getBlockPos().getZ(), 0, 0,
//								0);

						BlockEntityUtils.Inventory.dropItemInWorld(
								vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).getCraftingRemainingItem().copy(),
								level, vat.getBlockPos());
						vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT).shrink(1);
						vat.cookTime = 0;
						vat.stage++;
					} else {
						if (!recipeholder.value().getStageIngredients().isEmpty()) {
							if (recipeholder.value().getStageIngredients().size() > vat.stage) {
								if (recipeholder.value().getStageIngredients().get(vat.stage).ingredient
										.test(vat.items.getStackInSlot(FERMENTATION_INPUT_SLOT))) {
									if (recipeholder.value().getStageIngredients().get(vat.stage).lid) {
										if (vat.hasLid) {
											increaseCookTime(vat);
										}
									} else if (!level.getBlockState(vat.worldPosition.above())
											.is(ExtraDelightBlocks.LID)) {
										increaseCookTime(vat);
									}

								}
							}
						} else

							increaseCookTime(vat);
					}
				}
			} else {
				vat.cookTime = 0;
				vat.cookTimeTotal = 0;
			}
			vat.updateInventory();
		}
	}

	static void increaseCookTime(VatBlockEntity vat) {
		if (ExtraDelightConfig.ENABLE_DEBUG_MODE.isFalse())
			vat.cookTime++;
		else
			vat.cookTime += 1000;
	}

	private static void subtractItems(VatBlockEntity chiller, int k) {
		ItemStackHandler i = chiller.items;

		i.getStackInSlot(CONTAINER_SLOT).shrink(k);

		for (int j = 0; j < 6; j++)
			i.getStackInSlot(j).shrink(1);
	}

	private static void dropContainers(BlockState state, @NotNull VatBlockEntity chiller, Level level) {
//		Direction direction = state.getValue(VatBlock.FACING).getCounterClockWise();
		double x = chiller.worldPosition.getX();
		double y = chiller.worldPosition.getY() + 0.7;
		double z = chiller.worldPosition.getZ();

		for (int i = 0; i < 6; i++) {
			ItemUtils.spawnItemEntity(level, chiller.items.getStackInSlot(i).copy().getCraftingRemainingItem().copy(),
					x, y, z, 0, 0, 0);

		}

//		ItemUtils.spawnItemEntity(level,
//				chiller.items.getStackInSlot(FERMENTATION_INPUT_SLOT).getCraftingRemainingItem(), x, y, z, 0, 0, 0);
	}

	public void updateInventory() {
		this.setupRecipe();
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	private void setupRecipe() {
		Optional<RecipeHolder<VatRecipe>> recipe = this.matchRecipe();
		if (recipe.isPresent()) {
			this.curRecipe = recipe.get().value();
//			this.items.setStackInSlot(OUTPUT_SLOT, curRecipe.getResultItem(this.level.registryAccess()).copy());
		} else {
			this.curRecipe = null;
//			this.items.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY.copy());
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
		this.stage = nbt.getInt("stage");
		this.stageTotal = nbt.getInt("stageTotal");
		this.cookTime = nbt.getInt("cookTime");
		this.cookTimeTotal = nbt.getInt("cookTimeTotal");
		this.lidRequired = nbt.getBoolean("needsLid");
		this.hasLid = nbt.getBoolean("hasLid");
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put(INV_TAG, items.serializeNBT(registries));
		this.getFluidTank().writeToNBT(registries, tag);

		tag.putInt("stage", this.stage);
		tag.putInt("stageTotal", this.stageTotal);
		tag.putInt("cookTime", this.cookTime);
		tag.putInt("cookTimeTotal", this.cookTimeTotal);
		tag.putBoolean("needsLid", this.lidRequired);
		tag.putBoolean("hasLid", this.hasLid);

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

	protected Optional<RecipeHolder<VatRecipe>> matchRecipe() {
		if (level != null) {

			Optional<RecipeHolder<VatRecipe>> recipe = level.getRecipeManager()
					.getRecipeFor(ExtraDelightRecipes.VAT.get(), new VatRecipeWrapper(this.items, this.fluid) {
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

}

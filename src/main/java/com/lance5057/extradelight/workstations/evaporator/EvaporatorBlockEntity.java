package com.lance5057.extradelight.workstations.evaporator;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.workstations.evaporator.recipes.EvaporatorRecipe;
import com.lance5057.extradelight.workstations.evaporator.recipes.EvaporatorRecipeWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeManager.CachedCheck;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;

public class EvaporatorBlockEntity extends SyncedBlockEntity implements RecipeCraftingHolder {

	public static final String INV_TAG = "inv";

	private final ItemStackHandler items = createHandler();
	private final Lazy<IItemHandlerModifiable> itemHandler = Lazy.of(() -> items);
	public static final int NUM_SLOTS = 1;

	public static final String FLUID_TAG = "fluid";
	private final FluidTank tank = createFluidHandler();

	private int cookTime = 0;
	private int cookTimeTotal = 0;

	private ResourceLocation displayBlock = BuiltInRegistries.BLOCK.getKey(Blocks.AIR);

	public ResourceLocation getDisplayBlock() {
		return displayBlock;
	}

	public int getCookTime() {
		return cookTime;
	}

	public int getCookTimeTotal() {
		return cookTimeTotal;
	}

	private ResourceLocation lastRecipeID;
	private boolean checkNewRecipe;
	private final CachedCheck<EvaporatorRecipeWrapper, EvaporatorRecipe> quickCheck = RecipeManager
			.createCheck(ExtraDelightRecipes.EVAPORATOR.get());

	private FluidTank createFluidHandler() {
		FluidTank tank = new FluidTank(FluidType.BUCKET_VOLUME) {
			@Override
			protected void onContentsChanged() {
				EvaporatorBlockEntity.this.requestModelDataUpdate();
				EvaporatorBlockEntity.this.getLevel().sendBlockUpdated(EvaporatorBlockEntity.this.getBlockPos(),
						EvaporatorBlockEntity.this.getBlockState(), EvaporatorBlockEntity.this.getBlockState(), 3);
				EvaporatorBlockEntity.this.setChanged();

				zeroProgress();
				updateInventory();
			}
		};

		return tank;
	}

	public EvaporatorBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.EVAPORATOR.get(), pPos, pState);
	}

	public float getFullness() {
		return (float) tank.getFluidAmount() / (float) tank.getCapacity();
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler.get();
	}

	public FluidTank getFluidTank() {
		return tank;
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(9) {
			@Override
			protected void onContentsChanged(int slot) {
				EvaporatorBlockEntity.this.requestModelDataUpdate();
				EvaporatorBlockEntity.this.getLevel().sendBlockUpdated(EvaporatorBlockEntity.this.getBlockPos(),
						EvaporatorBlockEntity.this.getBlockState(), EvaporatorBlockEntity.this.getBlockState(), 3);
				EvaporatorBlockEntity.this.setChanged();

				zeroProgress();
				updateInventory();
			}
		};
	}

	public void insertItem(ItemStack stack) {
		BlockEntityUtils.Inventory.insertItem(items, stack, NUM_SLOTS);
		this.updateInventory();
	}

	public boolean isInventoryEmpty() {
		boolean flag = true;

		for (int i = 0; i < this.items.getSlots(); i++) {
			if (!this.items.getStackInSlot(i).isEmpty())
				flag = false;
		}

		return flag;
	}

	public void zeroProgress() {
		cookTime = cookTimeTotal = 0;
	}

	public void updateInventory() {
		requestModelDataUpdate();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
		this.setChanged();
	}

	public ItemStack getInsertedItem() {
		return items.getStackInSlot(0);
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
		if (nbt.contains(INV_TAG)) {
			items.deserializeNBT(registries, nbt.getCompound(INV_TAG));
		}
		tank.readFromNBT(registries, nbt);

		this.cookTime = nbt.getInt("cookTime");
		this.cookTimeTotal = nbt.getInt("cookTimeTotal");

		this.displayBlock = ResourceLocation.parse(nbt.getString("display"));
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tag.put(INV_TAG, items.serializeNBT(registries));
		tank.writeToNBT(registries, tag);
		tag.putInt("cookTime", this.cookTime);
		tag.putInt("cookTimeTotal", this.cookTimeTotal);

		tag.putString("display", this.displayBlock.toString());

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

	public Optional<RecipeHolder<EvaporatorRecipe>> matchRecipe() {
		if (this.level != null) {
			return level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.EVAPORATOR.get(),
					new EvaporatorRecipeWrapper(this.tank), level);
		}
		return Optional.empty();

	}

	@Override
	public void setRecipeUsed(RecipeHolder<?> p_300902_) {
		// TODO Auto-generated method stub

	}

	@Override
	public RecipeHolder<?> getRecipeUsed() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		EvaporatorBlockEntity evaporator = (EvaporatorBlockEntity) be;

		RecipeHolder<EvaporatorRecipe> recipeholder = evaporator.quickCheck
				.getRecipeFor(new EvaporatorRecipeWrapper(evaporator.tank), level).orElse(null);

		if (recipeholder != null) {
			evaporator.cookTimeTotal = recipeholder.value().getCookTime();
			evaporator.displayBlock = recipeholder.value().getDisplay();

			if (evaporator.cookTime >= evaporator.cookTimeTotal) {
				dropLoot(evaporator, recipeholder.value().getOutput());
				SizedFluidIngredient sfi = recipeholder.value().getFluid();
				evaporator.tank.drain(sfi.amount(), FluidAction.EXECUTE);
			} else {
				evaporator.cookTime++;
			}
		}
	}

	private static void dropLoot(EvaporatorBlockEntity evaporator, ResourceLocation rc) {
		if (evaporator.level != null && !evaporator.level.isClientSide()) {
			final LootParams pParams = new LootParams.Builder((ServerLevel) evaporator.level)
					.create(LootContextParamSets.EMPTY);
			evaporator.level.getServer().reloadableRegistries()
					.getLootTable(ResourceKey.create(Registries.LOOT_TABLE, rc)).getRandomItems(pParams)
					.forEach(itemStack -> {
						evaporator.insertItem(itemStack);
					});

		}
	}

	public void dropItems() {
		for (int i = 0; i < items.getSlots(); i++) {
			ItemStack stack = items.getStackInSlot(i);
			if (!stack.isEmpty()) {
				level.addFreshEntity(new ItemEntity(level, this.worldPosition.getX(), worldPosition.getY(),
						worldPosition.getZ(), stack.copy()));
				items.setStackInSlot(i, ItemStack.EMPTY);
			}
		}
	}
}
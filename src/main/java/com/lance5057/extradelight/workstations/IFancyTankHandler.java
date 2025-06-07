package com.lance5057.extradelight.workstations;

import com.lance5057.extradelight.util.BlockEntityUtils;
import com.lance5057.extradelight.util.BottleFluidRegistry;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public interface IFancyTankHandler<T extends BlockEntity> {
	public FancyTank getFluidTank();

	public IItemHandlerModifiable getItemHandler();

	public void updateInventory();

	public int getFluidInSlot();

	public int getFluidOutSlot();

	public default void fillInternal(T be) {
		ItemStack inputItem = getItemHandler().getStackInSlot(getFluidInSlot());
		if (!inputItem.isEmpty()) {
			if (inputItem.getItem() instanceof BucketItem filledBucket) {
				int filled = getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
						IFluidHandler.FluidAction.SIMULATE);
				if (filled == FluidType.BUCKET_VOLUME) {
					getFluidTank().fill(new FluidStack(filledBucket.content, FluidType.BUCKET_VOLUME),
							IFluidHandler.FluidAction.EXECUTE);
					BlockEntityUtils.Inventory.dropItemInWorld(Items.BUCKET.getDefaultInstance().copy(), be.getLevel(),
							be.getBlockPos());

					getItemHandler().getStackInSlot(getFluidInSlot()).shrink(1);
					updateInventory();
				}
			} else if (inputItem.getCapability(Capabilities.FluidHandler.ITEM) != null) {
				IFluidHandlerItem fluidHandlerItem = inputItem.getCapability(Capabilities.FluidHandler.ITEM);
				int filled = FluidUtil
						.tryFluidTransfer(getFluidTank(), fluidHandlerItem, getFluidTank().getVacancy(), true)
						.getAmount();
				if (filled > 0) {
					BlockEntityUtils.Inventory.dropItemInWorld(fluidHandlerItem.getContainer().copy(), be.getLevel(),
							be.getBlockPos());
					getItemHandler().getStackInSlot(getFluidInSlot()).shrink(1);
					updateInventory();
				}
			} else {
				FluidStack f = BottleFluidRegistry.getFluidFromBottle(inputItem);
				if (!f.isEmpty()) {
					if (getFluidTank().fill(f, FluidAction.SIMULATE) == 250) {
						int sz = inputItem.getCount();
						for (int j = 0; j < sz; j++)
							getFluidTank().fill(f.copy(), FluidAction.EXECUTE);

						if (inputItem.is(Items.POTION)) {
							// Because the blasted water bottle has no craftRemainder
							BlockEntityUtils.Inventory.dropItemInWorld(Items.GLASS_BOTTLE.getDefaultInstance(),
									be.getLevel(), be.getBlockPos());

						} else {
							BlockEntityUtils.Inventory.dropItemInWorld(
									inputItem.getCraftingRemainingItem().copyWithCount(sz), be.getLevel(),
									be.getBlockPos());
						}

						getItemHandler().getStackInSlot(getFluidInSlot()).shrink(sz);
						updateInventory();
					}
				}
			}
		}
	}

	public default void drainInternal(T be) {
		ItemStack inputItem = getItemHandler().getStackInSlot(getFluidOutSlot());
		if (!inputItem.isEmpty()) {
			int sz = inputItem.getCount();
			if (inputItem.getItem() == Items.BUCKET) {
				FluidStack stack = getFluidTank().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.SIMULATE);
				var item = stack.getFluid().getBucket().getDefaultInstance();
				int oitr = Math.min(sz, getFluidTank().getFluidAmount(0) / FluidType.BUCKET_VOLUME);
				int itr = oitr;
				while (stack.getAmount() == FluidType.BUCKET_VOLUME && itr-- >= 0) {
					getFluidTank().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
					BlockEntityUtils.Inventory.dropItemInWorld(item.copy(), be.getLevel(), be.getBlockPos());
					inputItem.shrink(1);
					stack = getFluidTank().drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.SIMULATE);
				}
//				int diff = oitr - itr;
////				int szDiff = sz - oitr;
////				var origin = inputItem.copy();
//////				boolean movedBack = true;
//				ItemStack bucket = getItemHandler().getStackInSlot(getFluidOutSlot());
//				bucket.shrink(diff);
//				var stackInMouse = bowl.menu.getCarried();
//				if(ItemStack.isSameItemSameComponents(stackInMouse, inputItem)) {
//					stackInMouse.grow(itr + szDiff);
//				} else if (stackInMouse.isEmpty()) {
//					// not sure if this condition will ever be satisfied
//					stackInMouse.applyComponentsAndValidate(origin.copyWithCount(itr + szDiff).getComponentsPatch());
//				} else {
//					movedBack = false;
//				}

//				if (movedBack) {
//					getItemHandler().getStackInSlot(getFluidOutSlot()).shrink(itr + szDiff);
//				}
				updateInventory();
			} else if (inputItem.getCapability(Capabilities.FluidHandler.ITEM) != null) {
				IFluidHandlerItem fluidHandlerItem = inputItem.copyWithCount(1)
						.getCapability(Capabilities.FluidHandler.ITEM);
				// not really the actual capacity of fluidHandlerItem
				// this might cause mod compat issues later on
				int maxFill = Math.min(getFluidTank().getFluidAmount(0),
						(fluidHandlerItem.getTankCapacity(0) - fluidHandlerItem.getFluidInTank(0).getAmount()) * sz);
//				int diff = 0;
				int filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, getFluidTank(), maxFill, true).getAmount();
				maxFill -= filled;
				while (filled > 0 && maxFill >= 0) {
					filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, getFluidTank(), maxFill, true).getAmount();
					BlockEntityUtils.Inventory.dropItemInWorld(fluidHandlerItem.getContainer().copy(), be.getLevel(),
							be.getBlockPos());
					inputItem.shrink(1);
//					fluidHandlerItem = inputItem.copyWithCount(1).getCapability(Capabilities.FluidHandler.ITEM);
//					filled = FluidUtil.tryFluidTransfer(fluidHandlerItem, getFluidTank(), maxFill, false).getAmount();
//					maxFill -= filled;
//					diff++;
				}
//				getItemHandler().getStackInSlot(getFluidOutSlot()).shrink(diff);
//				var stackInMouse = bowl.menu.getCarried();
//				boolean movedBack = true;
//				if(ItemStack.isSameItemSameComponents(stackInMouse, inputItem)) {
//					stackInMouse.grow(sz - diff);
//				}else if(stackInMouse.isEmpty()) {
//					stackInMouse.applyComponentsAndValidate(inputItem.copyWithCount(sz - diff).getComponentsPatch());
//				}else {
//					movedBack = false;
//				}
//				
//				if (movedBack) {
//					getItemHandler().getStackInSlot(getFluidOutSlot()).shrink(sz - diff);
//				}
				updateInventory();
			} else {
				if (getFluidTank().getFluid() != null) {
					FluidStack stack = getFluidTank().drain(250, IFluidHandler.FluidAction.SIMULATE);
					ItemStack i = BottleFluidRegistry.getBottleFromFluid(stack);
					if (!i.isEmpty() && ItemStack.isSameItem(i.getCraftingRemainingItem(), inputItem)) {
						for (int j = 0; j < sz; j++)
							getFluidTank().drain(stack, FluidAction.EXECUTE);
						BlockEntityUtils.Inventory.dropItemInWorld(i.copyWithCount(sz), be.getLevel(),
								be.getBlockPos());
//						getItemHandler().setStackInSlot(getFluidOutSlot(), i);
					}
					// Because the blasted water bottle has no craftRemainder
					if (i.getItem() == Items.POTION && inputItem.getItem() == Items.GLASS_BOTTLE) {
						FluidStack stack1 = getFluidTank().drain(250, IFluidHandler.FluidAction.SIMULATE);
						for (int j = 0; j < sz; j++) {
							getFluidTank().drain(stack1, FluidAction.EXECUTE);
							BlockEntityUtils.Inventory.dropItemInWorld(i, be.getLevel(), be.getBlockPos());
						}
					}
					inputItem.shrink(sz);
					updateInventory();
				}
			}
		}
	}

}

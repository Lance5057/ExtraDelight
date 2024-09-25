package com.lance5057.extradelight.workstations.mixingbowl;

import java.util.function.Predicate;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public class MixingBowlTank implements IFluidHandler, IFluidTank {
	protected Predicate<FluidStack> validator;
	protected FluidStack[] fluid;
	protected int capacity;

	public MixingBowlTank(int capacity) {
		this(capacity, e -> true);
	}

	public MixingBowlTank(int capacity, Predicate<FluidStack> validator) {
		this.capacity = capacity;
		this.validator = validator;

		fluid = new FluidStack[getTanks()];
		for (int i = 0; i < getTanks(); i++)
			fluid[i] = FluidStack.EMPTY;
	}

	public MixingBowlTank setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public MixingBowlTank setValidator(Predicate<FluidStack> validator) {
		if (validator != null) {
			this.validator = validator;
		}
		return this;
	}

	public boolean isFluidValid(FluidStack stack) {
		return validator.test(stack);
	}

	public int getCapacity(int tank) {
		return capacity;
	}

	public FluidStack getFluid(int tank) {
		return fluid[tank];
	}

	public int getFluidAmount(int tank) {
		return fluid[tank].getAmount();
	}

	public MixingBowlTank readFromNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
		for (int i = 0; i < this.getTanks(); i++)
			fluid[i] = FluidStack.parseOptional(lookupProvider, nbt.getCompound("Fluid" + i));
		return this;
	}

	public CompoundTag writeToNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
		for (int i = 0; i < this.getTanks(); i++)
			if (!fluid[i].isEmpty()) {
				nbt.put("Fluid" + i, fluid[i].save(lookupProvider));
			}

		return nbt;
	}

	@Override
	public int getTanks() {
		return 6;
	}

	@Override
	public FluidStack getFluidInTank(int tank) {
		return getFluid(tank);
	}

	@Override
	public int getTankCapacity(int tank) {
		return getCapacity(tank);
	}

	@Override
	public boolean isFluidValid(int tank, FluidStack stack) {
		return isFluidValid(tank, stack);
	}

	@Override
	public int fill(FluidStack resource, FluidAction action) {
		for (int i = 0; i < this.getTanks(); i++) {
			int fill = doFill(resource, action, i);
			if (fill != 0)
				return fill;
		}
		return 0;
	}

	private int doFill(FluidStack resource, FluidAction action, int tank) {
		if (resource.isEmpty() || !isFluidValid(resource)) {
			return 0;
		}
		if (action.simulate()) {
			if (fluid[tank].isEmpty()) {
				return Math.min(capacity, resource.getAmount());
			}
			if (!FluidStack.isSameFluidSameComponents(fluid[tank], resource)) {
				return 0;
			}
			return Math.min(capacity - fluid[tank].getAmount(), resource.getAmount());
		}
		if (fluid[tank].isEmpty()) {
			fluid[tank] = resource.copyWithAmount(Math.min(capacity, resource.getAmount()));
			onContentsChanged();
			return fluid[tank].getAmount();
		}
		if (!FluidStack.isSameFluidSameComponents(fluid[tank], resource)) {
			return 0;
		}
		int filled = capacity - fluid[tank].getAmount();

		if (resource.getAmount() < filled) {
			fluid[tank].grow(resource.getAmount());
			filled = resource.getAmount();
		} else {
			fluid[tank].setAmount(capacity);
		}
		if (filled > 0)
			onContentsChanged();
		return filled;
	}

	@Override
	public FluidStack drain(FluidStack resource, FluidAction action) {
		for (int i = 0; i < this.getTanks(); i++) {
			if (resource.isEmpty() || !FluidStack.isSameFluidSameComponents(resource, fluid[i])) {
				return FluidStack.EMPTY;
			}
			return drain(resource.getAmount(), action);
		}
		return FluidStack.EMPTY;
	}

	@Override
	public FluidStack drain(int maxDrain, FluidAction action) {
		for (int i = 0; i < this.getTanks(); i++) {
			return doDrain(maxDrain, action, i);
		}
		return FluidStack.EMPTY;
	}

	private FluidStack doDrain(int maxDrain, FluidAction action, int tank) {
		int drained = maxDrain;
		if (fluid[tank].getAmount() < drained) {
			drained = fluid[tank].getAmount();
		}
		FluidStack stack = fluid[tank].copyWithAmount(drained);
		if (action.execute() && drained > 0) {
			fluid[tank].shrink(drained);
			onContentsChanged();
		}
		return stack;
	}

	protected void onContentsChanged() {
	}

	@Override
	public FluidStack getFluid() {
		return null;
	}
	
	

	@Override
	public int getFluidAmount() {
		return 0;
	}

	@Override
	public int getCapacity() {
		return 0;
	}

	public void setFluid(FluidStack stack, int tank) {
		this.fluid[tank] = stack;
	}

	public boolean isEmpty(int tank) {
		return fluid[tank].isEmpty();
	}

	public int getSpace(int tank) {
		return Math.max(0, capacity - fluid[tank].getAmount());
	}
}

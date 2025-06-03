package com.lance5057.extradelight.workstations.mixingbowl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

import com.lance5057.extradelight.fluids.FluidKey;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class MixingBowlTank implements IFluidHandler, IFluidTank {
	protected Predicate<FluidStack> validator;
	protected LinkedHashMap<FluidKey, Integer> fluid;
	protected int capacity;
	private boolean full;

	public MixingBowlTank(int capacity) {
		this(capacity, e -> true);
	}

	public MixingBowlTank(int capacity, Predicate<FluidStack> validator) {
		this.capacity = capacity;
		this.validator = validator;
		this.fluid = new LinkedHashMap<>();
		this.full = false;
	}

	public int getTotalAmount() {
		return fluid.values().stream().mapToInt(i -> i).sum();
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
		return capacity / 6;
	}

	public FluidStack getFluid(int tank) {
		Iterator<Map.Entry<FluidKey, Integer>> itr = fluid.entrySet().iterator();
		while (tank-- > 0 && itr.hasNext()) {
			itr.next();
		}
		if (!itr.hasNext())
			return FluidStack.EMPTY;
		var tmp = itr.next();
		FluidStack target = tmp.getKey().createStack(tmp.getValue());
		return target;
	}

	public int getFluidAmount(int tank) {
		FluidStack target = getFluid(tank);
		return target.getAmount();
	}

	public synchronized MixingBowlTank readFromNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
		this.fluid.clear();
		int i = 0;
		while (nbt.contains("Fluid" + i)) {
			FluidStack dat = FluidStack.parseOptional(lookupProvider, nbt.getCompound("Fluid" + i));
			if (!dat.isEmpty())
				fill(dat, FluidAction.EXECUTE);
			i++;
		}
		return this;
	}

	public synchronized CompoundTag writeToNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
		int index = 0;
		for (Map.Entry<FluidKey, Integer> entry : fluid.entrySet()) {
			if (entry.getValue() > 0) {
				FluidStack stack = entry.getKey().createStack(entry.getValue());
				if (!stack.isEmpty()) {
					nbt.put("Fluid" + index, stack.save(lookupProvider));
					index++;
				}
			}
		}
		return nbt;
	}

	@Override
	public int getTanks() {
		return fluid.size();
	}

	@Override
	public FluidStack getFluidInTank(int tank) {
		return getFluid(tank);
	}

	@Override
	public int getTankCapacity(int tank) {
		return capacity;
	}

	@Override
	public boolean isFluidValid(int tank, FluidStack stack) {
		return isFluidValid(tank, stack);
	}

	@Override
	public int fill(FluidStack resource, FluidAction action) {
		int fill = doFill(resource, action);
		return fill;
	}

	private synchronized int doFill(FluidStack resource, FluidAction action) {
		if (resource.isEmpty() || !isFluidValid(resource))
			return 0;
		if (full)
			return 0;

		int vacancy = capacity - getTotalAmount();
		int fillTotal = resource.getAmount();
		boolean applyChanges = action.simulate() ? false : true;

		if (vacancy < fillTotal) {
			if (applyChanges && vacancy == 0)
				full = true;
			return 0;
		}
		var key = new FluidKey(resource);

		if (fillTotal <= 0)
			return 0;
		if (applyChanges)
			fluid.merge(key, resource.getAmount(), Integer::sum);
		if (applyChanges)
			onContentsChanged();

		return fillTotal;
	}
	/*
	 * @Override public int fill(FluidStack resource, FluidAction action) { for (int
	 * i = 0; i < this.getTanks(); i++) { int fill = doFill(resource, action, i); if
	 * (fill != 0) return fill; } return 0; }
	 * 
	 * 
	 * private int doFill(FluidStack resource, FluidAction action, int tank) { if
	 * (resource.isEmpty() || !isFluidValid(resource)) { return 0; } if
	 * (action.simulate()) { if (fluid[tank].isEmpty()) { return Math.min(capacity,
	 * resource.getAmount()); } if
	 * (!FluidStack.isSameFluidSameComponents(fluid[tank], resource)) { return 0; }
	 * return Math.min(capacity - fluid[tank].getAmount(), resource.getAmount()); }
	 * if (fluid[tank].isEmpty()) { fluid[tank] =
	 * resource.copyWithAmount(Math.min(capacity, resource.getAmount()));
	 * onContentsChanged(); return fluid[tank].getAmount(); } if
	 * (!FluidStack.isSameFluidSameComponents(fluid[tank], resource)) { return 0; }
	 * int filled = capacity - fluid[tank].getAmount();
	 * 
	 * if (resource.getAmount() < filled) { fluid[tank].grow(resource.getAmount());
	 * filled = resource.getAmount(); } else { fluid[tank].setAmount(capacity); } if
	 * (filled > 0) onContentsChanged(); return filled; }
	 */

	@Override
	public FluidStack drain(FluidStack resource, FluidAction action) {
		return doDrain(resource, action);
	}

	public FluidStack drain(SizedFluidIngredient resource, FluidAction action) {
		FluidStack tmp = resource.getFluids()[0];
		return doDrain(tmp, action);
	}

	@Override
	public FluidStack drain(int maxDrain, FluidAction action) {
		Iterator<Map.Entry<FluidKey, Integer>> itr = fluid.entrySet().iterator();
		while (itr.hasNext()) {
			var i = itr.next();
			FluidStack s = doDrain(i.getKey().createStack(maxDrain), action);
			if (!s.isEmpty())
				return s;
		}
		return FluidStack.EMPTY;
	}

	private FluidStack doDrain(FluidStack drain, FluidAction action) {
		return doDrain(drain, action, false);
	}

	private synchronized FluidStack doDrain(FluidStack drain, FluidAction action, boolean iff) {
		// iff - this will succeed if and only if maxDrain <= amount stored; default is
		// false
		int maxDrain = drain.getAmount();
		if (maxDrain <= 0)
			return FluidStack.EMPTY;

		FluidKey key = new FluidKey(drain);
		int keyval = fluid.getOrDefault(key, -1);
		if (keyval == -1)
			return FluidStack.EMPTY;
		if (iff && maxDrain > keyval)
			return FluidStack.EMPTY;

		boolean applyChanges = action.simulate() ? false : true;

		int maxDrainSanitized = Math.min(maxDrain, keyval);
		FluidStack stack = drain.copyWithAmount(maxDrainSanitized);
		if (applyChanges) {
			fluid.merge(key, 0 - maxDrainSanitized, Integer::sum);
			if (fluid.getOrDefault(key, -1) <= 0)
				fluid.remove(key);
			if (full)
				full = false;
		}
		return stack;
	}

	/*
	 * @Override public FluidStack drain(FluidStack resource, FluidAction action) {
	 * for (int i = 0; i < this.getTanks(); i++) { if (!resource.isEmpty() &&
	 * FluidStack.isSameFluidSameComponents(resource, fluid[i])) { return
	 * doDrain(resource.getAmount(), action, i); } } return FluidStack.EMPTY; }
	 * 
	 * public FluidStack drain(SizedFluidIngredient resource, FluidAction action) {
	 * for (int i = 0; i < this.getTanks(); i++) { if (resource.test(fluid[i])) {
	 * return doDrain(resource.amount(), action, i); }
	 * 
	 * } return FluidStack.EMPTY; }
	 * 
	 * @Override public FluidStack drain(int maxDrain, FluidAction action) { for
	 * (int i = 0; i < this.getTanks(); i++) { FluidStack s = doDrain(maxDrain,
	 * action, i); if (!s.isEmpty()) return s; } return FluidStack.EMPTY; }
	 * 
	 * private FluidStack doDrain(int maxDrain, FluidAction action, int tank) { int
	 * drained = maxDrain; if (fluid[tank].getAmount() < drained) { drained =
	 * fluid[tank].getAmount(); } FluidStack stack =
	 * fluid[tank].copyWithAmount(drained); if (action.execute() && drained > 0) {
	 * fluid[tank].shrink(drained); onContentsChanged(); } return stack; }
	 */
	protected void onContentsChanged() {
	}

	@Override
	public FluidStack getFluid() {
		Entry<FluidKey, Integer> f = this.fluid.lastEntry();
		if (f != null) {
			
			return f.getKey().createStack(f.getValue());
		}
		return FluidStack.EMPTY;
	}

	@Override
	public int getFluidAmount() {
		return 1000;
	}

	@Override
	public int getCapacity() {
		return 0;
	}

//	public void setFluid(FluidStack stack, int tank) {
//		this.fluid[tank] = stack;
//	}

	public boolean isEmpty(int tank) {
		return (getFluidAmount(tank) == 0);
	}

	public int getSpace(int tank) {
		return Math.max(0, capacity - getFluidAmount(tank));
	}

	public List<FluidStack> getAsList() {
		List<FluidStack> l = new ArrayList<FluidStack>();
		for (int i = 0; i < this.getTanks(); i++)
			l.add(getFluid(i));
		return l;
	}
}

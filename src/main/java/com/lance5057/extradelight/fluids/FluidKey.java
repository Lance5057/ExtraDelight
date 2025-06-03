package com.lance5057.extradelight.fluids;

import java.util.Objects;

import net.neoforged.neoforge.fluids.FluidStack;

public class FluidKey {
	private final FluidStack fluid;
	
	public FluidKey(FluidStack fluid) {
		this.fluid = new FluidStack(fluid.getFluid(), 1);
		this.fluid.applyComponents(fluid.getComponents().copy());
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof FluidKey other)) return false;
		return FluidStack.isSameFluidSameComponents(this.fluid,other.fluid);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fluid.getFluid(),fluid.getComponents());
	}
	
	public FluidStack createStack(int amount) {
		FluidStack res = new FluidStack(fluid.getFluid(),amount);
		res.applyComponents(fluid.getComponents().copy());
		return res;
	}
}
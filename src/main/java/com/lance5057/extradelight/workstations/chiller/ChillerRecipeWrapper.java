package com.lance5057.extradelight.workstations.chiller;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class ChillerRecipeWrapper extends RecipeWrapper {
	FluidStack tank;

	public ChillerRecipeWrapper(IItemHandler inv, FluidStack tank) {
		super(inv);
		this.tank = tank;
	}

}

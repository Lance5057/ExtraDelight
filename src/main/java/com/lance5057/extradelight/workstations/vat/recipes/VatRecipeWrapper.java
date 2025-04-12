package com.lance5057.extradelight.workstations.vat.recipes;

import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class VatRecipeWrapper extends RecipeWrapper {

	final FluidTank tank;

	public VatRecipeWrapper(IItemHandler inv, FluidTank tank) {
		super(inv);
		this.tank = tank;
	}

	public FluidTank getTank() {
		return tank;
	}
}

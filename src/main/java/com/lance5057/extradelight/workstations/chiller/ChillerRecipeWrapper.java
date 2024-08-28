package com.lance5057.extradelight.workstations.chiller;

import net.neoforged.neoforge.fluids.FluidStack;
<<<<<<< HEAD
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
=======
>>>>>>> c4286f8806fe5bd7571ff248729167ad29d68ac0
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class ChillerRecipeWrapper extends RecipeWrapper {
	FluidStack tank;

	public ChillerRecipeWrapper(IItemHandler inv, FluidStack tank) {
		super(inv);
		this.tank = tank;
	}

}

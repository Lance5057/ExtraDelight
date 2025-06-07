package com.lance5057.extradelight.workstations.mixingbowl.recipes;

import com.lance5057.extradelight.workstations.FancyTank;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class MixingBowlRecipeWrapper extends RecipeWrapper {

	final FancyTank tank;

	public MixingBowlRecipeWrapper(IItemHandler inv, FancyTank tank) {
		super(inv);
		this.tank = tank;
	}

	public FancyTank getTank() {
		return tank;
	}
}

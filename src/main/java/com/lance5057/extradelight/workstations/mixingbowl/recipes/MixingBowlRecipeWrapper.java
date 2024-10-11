package com.lance5057.extradelight.workstations.mixingbowl.recipes;

import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlTank;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class MixingBowlRecipeWrapper extends RecipeWrapper {

	final MixingBowlTank tank;

	public MixingBowlRecipeWrapper(IItemHandler inv, MixingBowlTank tank) {
		super(inv);
		this.tank = tank;
	}

	public MixingBowlTank getTank() {
		return tank;
	}
}

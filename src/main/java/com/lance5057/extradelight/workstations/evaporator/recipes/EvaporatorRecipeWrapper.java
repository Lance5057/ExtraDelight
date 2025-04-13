package com.lance5057.extradelight.workstations.evaporator.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class EvaporatorRecipeWrapper implements RecipeInput {

	final FluidTank tank;

	public EvaporatorRecipeWrapper(FluidTank tank) {
		this.tank = tank;
	}

	public FluidTank getTank() {
		return tank;
	}

	@Override
	public ItemStack getItem(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public int size() {
		return 0;
	}
	
	@Override
	public boolean isEmpty() {
        return false;
    }
}

package com.lance5057.extradelight.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public class ShapedWithJarRecipe extends ShapedRecipe {

	private final NonNullList<FluidStack> fluids;

	public ShapedWithJarRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
			NonNullList<FluidStack> fluid, ItemStack result) {
		super(group, category, pattern, result, true);
		this.fluids = fluid;
	}

	public ShapedWithJarRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
			NonNullList<FluidStack> fluid, ItemStack result, boolean showNotification) {
		super(group, category, pattern, result, showNotification);
		this.fluids = fluid;
	}

	@Override
	public boolean matches(CraftingInput input, Level level) {
		boolean flag = this.pattern.matches(input);
		boolean flag2 = true;

		for (FluidStack f : fluids) {
			for (ItemStack i : input.items()) {
				testFluid(i, f);
			}
		}

		return flag && flag2;
	}

	boolean testFluid(ItemStack stack, FluidStack fluid) {
		IFluidHandlerItem f = stack.getCapability(Capabilities.FluidHandler.ITEM);
		if (f != null) {
			if (FluidStack.matches(f.drain(fluid, FluidAction.SIMULATE), fluid))
				return true;
		}
		return false;
	}
}

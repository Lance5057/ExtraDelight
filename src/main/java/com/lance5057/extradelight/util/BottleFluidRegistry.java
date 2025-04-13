package com.lance5057.extradelight.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class BottleFluidRegistry {
	private static int bottleMB = 250;

	public static List<BottleFluid> registry = new ArrayList<BottleFluid>();

	public static void register(Ingredient bottle, SizedFluidIngredient fluid) {
		registry.add(new BottleFluid(bottle, fluid));
	}

	public static ItemStack getBottleFromFluid(FluidStack f) {
		if (f.getAmount() >= bottleMB) {
			Optional<BottleFluid> b = registry.stream().filter(bf -> bf.fluid.test(f)).findFirst();
			if (b.isPresent()) {
				return b.get().bottle.getItems()[0].copy();
			}
		}
		return ItemStack.EMPTY;
	}

	public static FluidStack getFluidFromBottle(ItemStack i) {
		Optional<BottleFluid> b = registry.stream().filter(bf -> bf.bottle.test(i)).findFirst();
		if (b.isPresent()) {
			return b.get().fluid.getFluids()[0];
		}
		return FluidStack.EMPTY;
	}

	public static class BottleFluid {
		Ingredient bottle;
		SizedFluidIngredient fluid;

		public BottleFluid(Ingredient b, SizedFluidIngredient f) {
			this.bottle = b;
			this.fluid = f;
		}
	}

	static {
		register(Ingredient.of(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.COCOA_BUTTER_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), bottleMB));

		register(Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.WATER)),
				SizedFluidIngredient.of(Fluids.WATER, bottleMB));
	}
}

package com.lance5057.extradelight.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.data.recipebuilders.BottleFluidRegistryRecipeBuilder;
import com.lance5057.extradelight.modules.Fermentation;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;

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

	public static void createRecipesForJEI(RecipeOutput consumer) {
		registry.forEach(bf -> {
			new BottleFluidRegistryRecipeBuilder(bf.bottle, bf.fluid).save(consumer, bf.fluid.getFluids()[0].getDescriptionId());
		});
	}

	public static class BottleFluid {
		public Ingredient bottle;
		public SizedFluidIngredient fluid;

		public BottleFluid(Ingredient b, SizedFluidIngredient f) {
			this.bottle = b;
			this.fluid = f;
		}

	}

	static {
		register(Ingredient.of(ModItems.APPLE_CIDER.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.APPLE_CIDER.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.BBQ_SAUCE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.BBQ.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), bottleMB));
		register(Ingredient.of(ModItems.BONE_BROTH.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.BROTH.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.CACTUS_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.CACTUS_JUICE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.CARAMEL_SAUCE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.COCOA_BUTTER_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.COFFEE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.COFFEE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.COOKING_OIL.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.OIL.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.EGG_MIX.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.EGG_MIX.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.GLOW_BERRY_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.GLOW_BERRY_JUICE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.GLOW_BERRY_JAM.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.GLOW_JAM.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.GOLDEN_APPLE_JAM.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.GOLDEN_JAM.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.GRAVY.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.GRAVY.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.HAZELNUT_SPREAD_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.COCOA_NUT_BUTTER_SPREAD.FLUID.get(), bottleMB));
		register(Ingredient.of(ModItems.HOT_COCOA.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.HOT_COCOA.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.JAM.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.JAM.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.KETCHUP.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.KETCHUP.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.MARSHMALLOW_FLUFF_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.MARSHMALLOW_FLUFF.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.MAYO.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.MAYO.FLUID.get(), bottleMB));
		register(Ingredient.of(ModItems.MELON_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.MELON_JUICE.FLUID.get(), bottleMB));
		register(Ingredient.of(ModItems.MILK_BOTTLE.get()),
				SizedFluidIngredient.of(NeoForgeMod.MILK.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.MILK_CHOCOLATE_SYRUP_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.MILKSHAKE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.MILKSHAKE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.PEANUT_BUTTER_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.NUT_BUTTER.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.SWEET_BERRY_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.SWEET_BERRY_JUICE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.TEA.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.TEA.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.TOMATO_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.TOMATO_JUICE.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.VINEGAR.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.VINEGAR.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.WHIPPED_CREAM.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), bottleMB));
		register(Ingredient.of(ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_BOTTLE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), bottleMB));
		register(Ingredient.of(Fermentation.PICKLE_JUICE.get()),
				SizedFluidIngredient.of(ExtraDelightFluids.PICKLE_JUICE.FLUID.get(), bottleMB));

		register(Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.WATER)),
				SizedFluidIngredient.of(Fluids.WATER, bottleMB));
	}
}

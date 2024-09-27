package com.lance5057.extradelight.recipe;

import java.util.List;

import com.lance5057.extradelight.ExtraDelightItems;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;

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
		if (!this.pattern.matches(input))
			return false;

		List<ItemStack> jars = gatherJars(input);
		if (jars.size() != fluids.size())
			return false;

		if (!testJars(jars))
			return false;

		return true;
	}

	private List<ItemStack> gatherJars(CraftingInput input) {
		return input.items().stream().filter(j -> j.is(ExtraDelightItems.JAR.get())).toList();
	}

	private boolean testJars(List<ItemStack> jars) {
		List<FluidStack> jarFluids = jars.stream()
				.map(j -> j.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0)).toList();

		return jarFluids.containsAll(fluids);
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
		List<ItemStack> jars = gatherJars(input);

		for (FluidStack f : fluids) {
			ItemStack i = jars.stream()
					.filter(j -> j.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0) == f).findFirst()
					.get();
			i.getCapability(Capabilities.FluidHandler.ITEM).drain(f, FluidAction.EXECUTE);
		}

		return this.getResultItem(registries).copy();
	}

	public static class Serializer implements RecipeSerializer<ShapedWithJarRecipe> {
		public static final MapCodec<ShapedWithJarRecipe> CODEC = ShapedRecipe.Serializer.CODEC.flatComap(s -> {
			return DataResult.success(null)
		});
		
		@Override
		public MapCodec<ShapedWithJarRecipe> codec() {
			return CODEC.xmap(null, null);
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, ShapedWithJarRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}
}

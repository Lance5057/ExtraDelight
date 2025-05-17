package com.lance5057.extradelight.recipe;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FluidRegistryRecipe implements Recipe<SimpleRecipeWrapper> {

	@Override
	public boolean matches(SimpleRecipeWrapper input, Level level) {
		return false;
	}

	@Override
	public ItemStack assemble(SimpleRecipeWrapper input, Provider registries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

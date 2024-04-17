package com.lance5057.extradelight.workstations.dryingrack;

import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class DryingRackRecipe implements Recipe<Container> {

	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookingTime;

	public DryingRackRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult, float pExperience,
			int pCookingTime) {
		this.group = pGroup;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.experience = pExperience;
		this.cookingTime = pCookingTime;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return NonNullList.of(null, ingredient);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.DRYING_RACK_SERIALIZER.get();
	}

	@Override
	public boolean matches(Container pContainer, Level pLevel) {
		return ingredient.test(pContainer.getItem(0));
	}

	@Override
	public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		// TODO Auto-generated method stub
		return true;
	}

	public Ingredient getInput() {
		return ingredient;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess p_267052_) {
		// TODO Auto-generated method stub
		return result;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return ExtraDelightRecipes.DRYING_RACK.get();
	}

}

package com.lance5057.extradelight.workstations.dryingrack;

import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class DryingRackRecipe implements Recipe<SingleRecipeInput> {

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
	public boolean matches(SingleRecipeInput pContainer, Level pLevel) {
		return ingredient.test(pContainer.getItem(0));
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		// TODO Auto-generated method stub
		return true;
	}

	public Ingredient getInput() {
		return ingredient;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return ExtraDelightRecipes.DRYING_RACK.get();
	}

	@Override
	public ItemStack assemble(SingleRecipeInput input, Provider registries) {
		return this.result.copy();
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		// TODO Auto-generated method stub
		return result;
	}

}

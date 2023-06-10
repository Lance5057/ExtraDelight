package com.lance5057.extradelight.workstations.dryingrack;

import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class DryingRackRecipe implements Recipe<Container> {

	protected final ResourceLocation id;
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookingTime;

	public DryingRackRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult,
			float pExperience, int pCookingTime) {
		this.id = pId;
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
	public ItemStack assemble(Container pContainer) {
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
	public ItemStack getResultItem() {
		// TODO Auto-generated method stub
		return result;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return ExtraDelightRecipes.DRYING_RACK.get();
	}

}

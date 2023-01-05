package com.lance5057.extradelight;

import com.lance5057.extradelight.workstations.recipes.OvenRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightRecipes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
			.create(Registry.RECIPE_TYPE.key(), ExtraDelight.MOD_ID);

	public static final RegistryObject<RecipeType<OvenRecipe>> OVEN = RECIPE_TYPES.register("oven",
			() -> registerRecipeType("oven"));

	public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
		return new RecipeType<>() {
			public String toString() {
				return ExtraDelight.MOD_ID + ":" + identifier;
			}
		};
	}
}

package com.lance5057.extradelight;

import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightRecipes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
			.create(Registry.RECIPE_TYPE.key(), ExtraDelight.MOD_ID);

	public static final RegistryObject<RecipeType<OvenRecipe>> OVEN = RECIPE_TYPES.register("oven",
			() -> registerRecipeType("oven"));
	public static final RegistryObject<RecipeType<DoughShapingRecipe>> DOUGH_SHAPING = RECIPE_TYPES
			.register("dough_shaping", () -> registerRecipeType("dough_shaping"));

	public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
		return new RecipeType<>() {
			public String toString() {
				return ExtraDelight.MOD_ID + ":" + identifier;
			}
		};
	}

	// Serializers
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.RECIPE_SERIALIZERS, ExtraDelight.MOD_ID);

	public static final RegistryObject<RecipeSerializer<?>> OVEN_SERIALIZER = RECIPE_SERIALIZERS.register("oven",
			OvenRecipe.Serializer::new);
	public static final RegistryObject<RecipeSerializer<?>> DOUGH_SHAPING_SERIALIZER = RECIPE_SERIALIZERS
			.register("dough_shaping", DoughShapingRecipe.Serializer::new);

	public static final RecipeBookType RECIPE_TYPE_OVEN = RecipeBookType.create("OVEN");
}

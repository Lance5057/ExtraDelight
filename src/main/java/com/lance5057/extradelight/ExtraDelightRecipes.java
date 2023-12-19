package com.lance5057.extradelight;

import com.lance5057.extradelight.recipe.DynamicNameCampfireRecipe;
import com.lance5057.extradelight.recipe.DynamicNameCookingRecipe;
import com.lance5057.extradelight.recipe.DynamicNameSmeltingRecipe;
import com.lance5057.extradelight.recipe.FeastRecipe;
import com.lance5057.extradelight.recipe.ToolOnBlockRecipe;
import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackRecipe;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackSerializer;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightRecipes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
			.create(ForgeRegistries.RECIPE_TYPES, ExtraDelight.MOD_ID);

	public static final RegistryObject<RecipeType<OvenRecipe>> OVEN = RECIPE_TYPES.register("oven",
			() -> registerRecipeType("oven"));
	public static final RegistryObject<RecipeType<DoughShapingRecipe>> DOUGH_SHAPING = RECIPE_TYPES
			.register("dough_shaping", () -> registerRecipeType("dough_shaping"));
	public static final RegistryObject<RecipeType<MortarRecipe>> MORTAR = RECIPE_TYPES.register("mortar",
			() -> registerRecipeType("mortar"));
	public static final RegistryObject<RecipeType<MixingBowlRecipe>> MIXING_BOWL = RECIPE_TYPES.register("mixing_bowl",
			() -> registerRecipeType("mixing_bowl"));
	public static final RegistryObject<RecipeType<DryingRackRecipe>> DRYING_RACK = RECIPE_TYPES.register("drying_rack",
			() -> registerRecipeType("drying_rack"));
	public static final RegistryObject<RecipeType<FeastRecipe>> FEAST = RECIPE_TYPES.register("feast",
			() -> registerRecipeType("feast"));
	public static final RegistryObject<RecipeType<ToolOnBlockRecipe>> TOOL_ON_BLOCK = RECIPE_TYPES
			.register("tool_on_block", () -> registerRecipeType("tool_on_block"));

	// Dynamic Names
	public static final RegistryObject<RecipeType<DynamicNameSmeltingRecipe>> DYNAMIC_SMELT = RECIPE_TYPES
			.register("dynamic_smelt", () -> registerRecipeType("dynamic_smelt"));
	public static final RegistryObject<RecipeType<DynamicNameCookingRecipe>> DYNAMIC_SMOKE = RECIPE_TYPES
			.register("dynamic_smoke", () -> registerRecipeType("dynamic_smoke"));
	public static final RegistryObject<RecipeType<DynamicNameCampfireRecipe>> DYNAMIC_CAMPFIRE = RECIPE_TYPES
			.register("dynamic_campfire", () -> registerRecipeType("dynamic_campfire"));

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

	public static final RegistryObject<OvenRecipe.Serializer> OVEN_SERIALIZER = RECIPE_SERIALIZERS.register("oven",
			OvenRecipe.Serializer::new);
	public static final RegistryObject<DoughShapingRecipe.Serializer> DOUGH_SHAPING_SERIALIZER = RECIPE_SERIALIZERS
			.register("dough_shaping", DoughShapingRecipe.Serializer::new);
	public static final RegistryObject<MortarRecipe.Serializer> MORTAR_SERIALIZER = RECIPE_SERIALIZERS
			.register("mortar", MortarRecipe.Serializer::new);
	public static final RegistryObject<MixingBowlRecipe.Serializer> MIXING_BOWL_SERIALIZER = RECIPE_SERIALIZERS
			.register("mixing_bowl", MixingBowlRecipe.Serializer::new);

	public static final RegistryObject<DynamicNameSmeltingRecipe.Serializer> DYNAMIC_SMELT_SERIALIZER = RECIPE_SERIALIZERS
			.register("dynamic_smelt", DynamicNameSmeltingRecipe.Serializer::new);
	public static final RegistryObject<DynamicNameCookingRecipe.Serializer> DYNAMIC_SMOKE_SERIALIZER = RECIPE_SERIALIZERS
			.register("dynamic_smoke", DynamicNameCookingRecipe.Serializer::new);
	public static final RegistryObject<DynamicNameCampfireRecipe.Serializer> DYNAMIC_CAMPFIRE_SERIALIZER = RECIPE_SERIALIZERS
			.register("dynamic_campfire", DynamicNameCampfireRecipe.Serializer::new);

	public static final RegistryObject<DryingRackSerializer> DRYING_RACK_SERIALIZER = RECIPE_SERIALIZERS
			.register("drying_rack", DryingRackSerializer::new);
	public static final RegistryObject<FeastRecipe.Serializer> FEAST_SERIALIZER = RECIPE_SERIALIZERS.register("feast",
			FeastRecipe.Serializer::new);

	public static final RegistryObject<ToolOnBlockRecipe.Serializer> TOOL_ON_BLOCK_SERIALIZER = RECIPE_SERIALIZERS
			.register("tool_on_block", ToolOnBlockRecipe.Serializer::new);

	public static final RecipeBookType RECIPE_TYPE_OVEN = RecipeBookType.create("OVEN");
}

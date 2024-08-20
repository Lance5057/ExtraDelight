package com.lance5057.extradelight;

import java.util.function.Supplier;

import com.lance5057.extradelight.recipe.FeastRecipe;
import com.lance5057.extradelight.recipe.ToolOnBlockRecipe;
import com.lance5057.extradelight.workstations.chiller.ChillerRecipe;
import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackRecipe;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackSerializer;
import com.lance5057.extradelight.workstations.meltingpot.MeltingPotRecipe;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;
import com.lance5057.extradelight.workstations.mortar.recipes.MortarRecipe;
import com.lance5057.extradelight.workstations.oven.recipes.OvenRecipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightRecipes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
			.create(BuiltInRegistries.RECIPE_TYPE, ExtraDelight.MOD_ID);

	public static final Supplier<RecipeType<OvenRecipe>> OVEN = RECIPE_TYPES.register("oven",
			() -> registerRecipeType("oven"));
	public static final Supplier<RecipeType<DoughShapingRecipe>> DOUGH_SHAPING = RECIPE_TYPES.register("dough_shaping",
			() -> registerRecipeType("dough_shaping"));
	public static final Supplier<RecipeType<MortarRecipe>> MORTAR = RECIPE_TYPES.register("mortar",
			() -> registerRecipeType("mortar"));
	public static final Supplier<RecipeType<MixingBowlRecipe>> MIXING_BOWL = RECIPE_TYPES.register("mixing_bowl",
			() -> registerRecipeType("mixing_bowl"));
	public static final Supplier<RecipeType<DryingRackRecipe>> DRYING_RACK = RECIPE_TYPES.register("drying_rack",
			() -> registerRecipeType("drying_rack"));
	public static final Supplier<RecipeType<FeastRecipe>> FEAST = RECIPE_TYPES.register("feast",
			() -> registerRecipeType("feast"));
	public static final Supplier<RecipeType<ToolOnBlockRecipe>> TOOL_ON_BLOCK = RECIPE_TYPES.register("tool_on_block",
			() -> registerRecipeType("tool_on_block"));
	public static final Supplier<RecipeType<MeltingPotRecipe>> MELTING_POT = RECIPE_TYPES.register("melting_pot",
			() -> registerRecipeType("melting_pot"));
	public static final Supplier<RecipeType<ChillerRecipe>> CHILLER = RECIPE_TYPES.register("chiller",
			() -> registerRecipeType("chiller"));

	// Dynamic Names
	public static final DeferredHolder<RecipeType<?>, RecipeType<Recipe<?>>> DYNAMIC_SMELT = RECIPE_TYPES
			.register("dynamic_smelt", () -> registerRecipeType("dynamic_smelt"));
	public static final DeferredHolder<RecipeType<?>, RecipeType<Recipe<?>>> DYNAMIC_SMOKE = RECIPE_TYPES
			.register("dynamic_smoke", () -> registerRecipeType("dynamic_smoke"));
	public static final DeferredHolder<RecipeType<?>, RecipeType<Recipe<?>>> DYNAMIC_CAMPFIRE = RECIPE_TYPES
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
			.create(BuiltInRegistries.RECIPE_SERIALIZER, ExtraDelight.MOD_ID);

	public static final Supplier<RecipeSerializer<?>> OVEN_SERIALIZER = RECIPE_SERIALIZERS.register("oven",
			OvenRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<?>> DOUGH_SHAPING_SERIALIZER = RECIPE_SERIALIZERS
			.register("dough_shaping", DoughShapingRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<?>> MORTAR_SERIALIZER = RECIPE_SERIALIZERS.register("mortar",
			MortarRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<?>> MIXING_BOWL_SERIALIZER = RECIPE_SERIALIZERS
			.register("mixing_bowl", MixingBowlRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<?>> MELTING_POT_SERIALIZER = RECIPE_SERIALIZERS
			.register("melting_pot", MeltingPotRecipe.Serializer::new);

//	public static final Supplier<RecipeSerializer<?>> DYNAMIC_SMELT_SERIALIZER = RECIPE_SERIALIZERS
//			.register("dynamic_smelt", DynamicNameSmeltingRecipe.Serializer::new);
//	public static final Supplier<RecipeSerializer<?>> DYNAMIC_SMOKE_SERIALIZER = RECIPE_SERIALIZERS
//			.register("dynamic_smoke", DynamicNameCookingRecipe.Serializer::new);
//	public static final Supplier<RecipeSerializer<?>> DYNAMIC_CAMPFIRE_SERIALIZER = RECIPE_SERIALIZERS
//			.register("dynamic_campfire", DynamicNameCampfireRecipe.Serializer::new);

	public static final Supplier<RecipeSerializer<?>> DRYING_RACK_SERIALIZER = RECIPE_SERIALIZERS
			.register("drying_rack", DryingRackSerializer::new);
	public static final Supplier<RecipeSerializer<?>> FEAST_SERIALIZER = RECIPE_SERIALIZERS.register("feast",
			FeastRecipe.Serializer::new);

	public static final Supplier<RecipeSerializer<?>> TOOL_ON_BLOCK_SERIALIZER = RECIPE_SERIALIZERS
			.register("tool_on_block", ToolOnBlockRecipe.Serializer::new);
	public static final Supplier<RecipeSerializer<?>> CHILLER_SERIALIZER = RECIPE_SERIALIZERS.register("chiller",
			ChillerRecipe.Serializer::new);
//	public static final RecipeBookType RECIPE_TYPE_OVEN = RecipeBookType.create("OVEN");
}

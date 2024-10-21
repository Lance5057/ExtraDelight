package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.data.recipebuilders.ChillerRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.DryingRackRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MeltingPotRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MixingBowlRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MortarRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.ToolOnBlockBuilder;
import com.lance5057.extradelight.workstations.doughshaping.recipes.DoughShapingRecipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import net.neoforged.neoforge.fluids.FluidStack;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class Recipes extends RecipeProvider implements IConditionBuilder {
	public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	public static final int SMOKER_COOKING = 100; // 5 seconds
	public static final int FURNACE_COOKING = 200; // 10 seconds
	public static final int FAST_COOKING = 400; // 20 seconds
	public static final int CAMPFIRE_COOKING = 600; // 20 seconds
	public static final int NORMAL_COOKING = 800; // 40 seconds
	public static final int SLOW_COOKING = 1600; // 80 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

	public static final int FAST_GRIND = 2;
	public static final int STANDARD_GRIND = 4;
	public static final int LONG_GRIND = 8;

	public static ResourceLocation EDLoc(String texture) {
		return ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, texture);
	}

//	public static ResourceLocation CreateLoc(String texture) {
//		return ResourceLocation.fromNamespaceAndPath(Create.ID, texture);
//	}

	@Override
	protected void buildRecipes(RecipeOutput consumer) {
		mortarRecipes(consumer);
		ovenRecipes(consumer);
		knifeRecipes(consumer);
		potRecipes(consumer);
		craftingRecipes(consumer);
		mixingbowlRecipes(consumer);
		cookingRecipes(consumer);
		dryingRackRecipes(consumer);
		doughShapeRecipes(consumer);
		feastRecipes(consumer);
		toolOnBlockRecipes(consumer);
		meltingRecipes(consumer);
		chillingRecipes(consumer);

		AestheticBlocks.Recipes(consumer);
	}

	private void chillingRecipes(RecipeOutput consumer) {
		ChillerRecipeBuilder.chill(ExtraDelightItems.MILK_CHOCOLATE_BAR.toStack(), FAST_COOKING, SMALL_EXP,
				ExtraDelightItems.BAR_MOLD.toStack(),
				new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 250)).build(consumer);
		ChillerRecipeBuilder.chill(ExtraDelightItems.DARK_CHOCOLATE_BAR.toStack(), FAST_COOKING, SMALL_EXP,
				ExtraDelightItems.BAR_MOLD.toStack(),
				new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 250)).build(consumer);
		ChillerRecipeBuilder.chill(ExtraDelightItems.WHITE_CHOCOLATE_BAR.toStack(), FAST_COOKING, SMALL_EXP,
				ExtraDelightItems.BAR_MOLD.toStack(),
				new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 250)).build(consumer);
		ChillerRecipeBuilder.chill(ExtraDelightItems.BLOOD_CHOCOLATE_BAR.toStack(), FAST_COOKING, SMALL_EXP,
				ExtraDelightItems.BAR_MOLD.toStack(),
				new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 250)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.BLOOD_CHOCOLATE_FILLED_BAR.toStack(), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.BAR_MOLD.toStack(),
						new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_BAR_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.DARK_CHOCOLATE_FILLED_BAR.toStack(), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.BAR_MOLD.toStack(),
						new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_BAR_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MILK_CHOCOLATE_FILLED_BAR.toStack(), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.BAR_MOLD.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_BAR_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.WHITE_CHOCOLATE_FILLED_BAR.toStack(), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.BAR_MOLD.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_BAR_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.BLOOD_CHOCOLATE_TRUFFLE.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_TRUFFLE_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.DARK_CHOCOLATE_TRUFFLE.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_TRUFFLE_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MILK_CHOCOLATE_TRUFFLE.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_TRUFFLE_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.WHITE_CHOCOLATE_TRUFFLE.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_TRUFFLE_FILLING)).build(consumer);

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.PEANUT_BUTTER_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.PEANUT_BUTTER)).build(consumer, "milk_peanut_butter_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.PEANUT_BUTTER_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.PEANUT_BUTTER)).build(consumer, "dark_peanut_butter_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.PEANUT_BUTTER_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.PEANUT_BUTTER))
				.build(consumer, "white_peanut_butter_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.PEANUT_BUTTER_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.PEANUT_BUTTER))
				.build(consumer, "blood_peanut_butter_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MALLOW_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.MARSHMALLOW_FLUFF)).build(consumer, "milk_mallow_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MALLOW_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.MARSHMALLOW_FLUFF)).build(consumer, "dark_mallow_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MALLOW_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.MARSHMALLOW_FLUFF)).build(consumer, "white_mallow_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.MALLOW_CUP.toStack(6), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 1000))
				.addIngredient(Ingredient.of(ExtraDelightTags.MARSHMALLOW_FLUFF)).build(consumer, "blood_mallow_cup");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.TOFFEE.toStack(4), FAST_COOKING, SMALL_EXP, ExtraDelightItems.TRAY.toStack(),
						new FluidStack(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.ROASTED_NUTS).build(consumer, "blood_toffee");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.TOFFEE.toStack(4), FAST_COOKING, SMALL_EXP, ExtraDelightItems.TRAY.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.ROASTED_NUTS).build(consumer, "milk_toffee");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.TOFFEE.toStack(4), FAST_COOKING, SMALL_EXP, ExtraDelightItems.TRAY.toStack(),
						new FluidStack(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.ROASTED_NUTS).build(consumer, "dark_toffee");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.TOFFEE.toStack(4), FAST_COOKING, SMALL_EXP, ExtraDelightItems.TRAY.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.ROASTED_NUTS).build(consumer, "white_toffee");

		ChillerRecipeBuilder
				.chill(ExtraDelightItems.PEPPERMINT_BARK.toStack(4), FAST_COOKING, SMALL_EXP,
						ExtraDelightItems.TRAY.toStack(),
						new FluidStack(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(ExtraDelightTags.COOKING_OIL).addIngredient(ExtraDelightTags.CHOCOLATE_SYRUP)
				.addIngredient(ExtraDelightTags.PEPPERMINT_CANDY).build(consumer, "peppermint_bark");
	}

	private void meltingRecipes(RecipeOutput consumer) {
		MeltingPotRecipeBuilder.melt(Ingredient.of(Items.ICE), FAST_COOKING, new FluidStack(Fluids.WATER, 1000))
				.save(consumer, EDLoc("test"));
	}

	private void toolOnBlockRecipes(RecipeOutput consumer) {
		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_WHITE),
						ExtraDelightItems.GINGERBREAD_BLOCK_WHITE.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_WHITE))
				.save(consumer, EDLoc("frost_gingerbread_white"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(),
						Ingredient.of(ExtraDelightTags.FROSTING_LIGHT_GRAY),
						ExtraDelightItems.GINGERBREAD_BLOCK_LIGHT_GRAY.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_LIGHT_GRAY))
				.save(consumer, EDLoc("frost_gingerbread_light_gray"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_GRAY),
						ExtraDelightItems.GINGERBREAD_BLOCK_GRAY.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_GRAY))
				.save(consumer, EDLoc("frost_gingerbread_gray"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_BROWN),
						ExtraDelightItems.GINGERBREAD_BLOCK_BROWN.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_BROWN))
				.save(consumer, EDLoc("frost_gingerbread_brown"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_RED),
						ExtraDelightItems.GINGERBREAD_BLOCK_RED.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_RED))
				.save(consumer, EDLoc("frost_gingerbread_red"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_ORANGE),
						ExtraDelightItems.GINGERBREAD_BLOCK_ORANGE.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_ORANGE))
				.save(consumer, EDLoc("frost_gingerbread_orange"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_YELLOW),
						ExtraDelightItems.GINGERBREAD_BLOCK_YELLOW.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_YELLOW))
				.save(consumer, EDLoc("frost_gingerbread_yellow"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_LIME),
						ExtraDelightItems.GINGERBREAD_BLOCK_LIME.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_LIME))
				.save(consumer, EDLoc("frost_gingerbread_lime"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_GREEN),
						ExtraDelightItems.GINGERBREAD_BLOCK_GREEN.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_GREEN))
				.save(consumer, EDLoc("frost_gingerbread_green"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_CYAN),
						ExtraDelightItems.GINGERBREAD_BLOCK_CYAN.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_CYAN))
				.save(consumer, EDLoc("frost_gingerbread_cyan"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(),
						Ingredient.of(ExtraDelightTags.FROSTING_LIGHT_BLUE),
						ExtraDelightItems.GINGERBREAD_BLOCK_LIGHT_BLUE.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_LIGHT_BLUE))
				.save(consumer, EDLoc("frost_gingerbread_light_blue"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_BLUE),
						ExtraDelightItems.GINGERBREAD_BLOCK_BLUE.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_BLUE))
				.save(consumer, EDLoc("frost_gingerbread_blue"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_PURPLE),
						ExtraDelightItems.GINGERBREAD_BLOCK_PURPLE.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_PURPLE))
				.save(consumer, EDLoc("frost_gingerbread_purple"));

		ToolOnBlockBuilder.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(),
				Ingredient.of(ExtraDelightTags.FROSTING_MAGENTA), ExtraDelightItems.GINGERBREAD_BLOCK_MAGENTA.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_MAGENTA))
				.save(consumer, EDLoc("frost_gingerbread_magenta"));

		ToolOnBlockBuilder
				.make(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), Ingredient.of(ExtraDelightTags.FROSTING_PINK),
						ExtraDelightItems.GINGERBREAD_BLOCK_PINK.get())
				.unlockedBy("has_frosting", has(ExtraDelightTags.FROSTING_PINK))
				.save(consumer, EDLoc("frost_gingerbread_pink"));

	}

	private void feastRecipes(RecipeOutput consumer) {
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.MEAT_LOAF.get()),
						ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, EDLoc("meatloaf_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Tags.Items.FOODS_BREAD), new ItemStack(ExtraDelightItems.MEAT_LOAF_SANDWICH.get()),
						ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, EDLoc("meatloaf_sandwich_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(ExtraDelightTags.BREAD_SLICE),
				new ItemStack(ExtraDelightItems.MEAT_LOAF_SANDWICH.get()), ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, EDLoc("meatloaf_sandwich_slice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ModItems.BEEF_STEW.get()),
						ExtraDelightItems.BEEF_STEW_FEAST.get())
				.unlockedBy("has_beef_stew", has(ExtraDelightItems.BEEF_STEW_FEAST.get()))
				.save(consumer, EDLoc("beef_stew_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.BEEF_STEW_RICE.get()),
						ExtraDelightItems.BEEF_STEW_FEAST.get())
				.unlockedBy("has_beef_stew", has(ExtraDelightItems.BEEF_STEW_FEAST.get()))
				.save(consumer, EDLoc("beef_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.PORK_STEW.get()),
						ExtraDelightItems.PORK_STEW_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.PORK_STEW_FEAST.get()))
				.save(consumer, EDLoc("pork_stew_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.PORK_STEW_RICE.get()),
						ExtraDelightItems.PORK_STEW_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.PORK_STEW_FEAST.get()))
				.save(consumer, EDLoc("pork_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CHICKEN_STEW.get()),
						ExtraDelightItems.CHICKEN_STEW_FEAST.get())
				.unlockedBy("has_chicken_stew", has(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
				.save(consumer, EDLoc("chicken_stew_bowl_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(ModItems.COOKED_RICE.get()),
				new ItemStack(ExtraDelightItems.CHICKEN_STEW_RICE.get()), ExtraDelightItems.CHICKEN_STEW_FEAST.get())
				.unlockedBy("has_chicken_stew", has(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
				.save(consumer, EDLoc("chicken_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(Items.RABBIT_STEW),
						ExtraDelightItems.RABBIT_STEW_FEAST.get())
				.unlockedBy("has_rabbit_stew", has(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
				.save(consumer, EDLoc("rabbit_stew_bowl_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(ModItems.COOKED_RICE.get()),
				new ItemStack(ExtraDelightItems.RABBIT_STEW_RICE.get()), ExtraDelightItems.RABBIT_STEW_FEAST.get())
				.unlockedBy("has_rabbit_stew", has(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
				.save(consumer, EDLoc("rabbit_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ModItems.FISH_STEW.get()),
						ExtraDelightItems.FISH_STEW_FEAST.get())
				.unlockedBy("has_fish_stew", has(ExtraDelightItems.FISH_STEW_FEAST.get()))
				.save(consumer, EDLoc("fish_stew_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.FISH_STEW_RICE.get()),
						ExtraDelightItems.FISH_STEW_FEAST.get())
				.unlockedBy("has_fish_stew", has(ExtraDelightItems.FISH_STEW_FEAST.get()))
				.save(consumer, EDLoc("fish_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.LAMB_STEW.get()),
						ExtraDelightItems.LAMB_STEW_FEAST.get())
				.unlockedBy("has_lamb_stew", has(ExtraDelightItems.LAMB_STEW_FEAST.get()))
				.save(consumer, EDLoc("lamb_stew_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.LAMB_STEW_RICE.get()),
						ExtraDelightItems.LAMB_STEW_FEAST.get())
				.unlockedBy("has_lamb_stew", has(ExtraDelightItems.LAMB_STEW_FEAST.get()))
				.save(consumer, EDLoc("lamb_stew_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CURRY.get()),
						ExtraDelightItems.CURRY_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.CURRY_FEAST.get()))
				.save(consumer, EDLoc("curry_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.CURRY_RICE.get()),
						ExtraDelightItems.CURRY_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.CURRY_FEAST.get()))
				.save(consumer, EDLoc("curry_rice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.HOTDISH.get()),
						ExtraDelightItems.HOTDISH_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HOTDISH_FEAST.get()))
				.save(consumer, EDLoc("hotdish_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.MACARONI_CHEESE.get()),
						ExtraDelightItems.MACARONI_CHEESE_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.save(consumer, EDLoc("mac_cheese_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.LASAGNA.get()),
						ExtraDelightItems.LASAGNA_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.LASAGNA_FEAST.get()))
				.save(consumer, EDLoc("lasagna_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.HASH.get()),
						ExtraDelightItems.HASH_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HASH_FEAST_ITEM.get()))
				.save(consumer, EDLoc("hash_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.POT_ROAST.get()),
						ExtraDelightItems.POT_ROAST_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get()))
				.save(consumer, EDLoc("pot_roast_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.SALISBURY_STEAK.get()),
						ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get()))
				.save(consumer, EDLoc("salisbury_steak_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Tags.Items.FOODS_BREAD),
						new ItemStack(ExtraDelightItems.PULLED_PORK_SANDWICH.get()),
						ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()))
				.save(consumer, EDLoc("pulled_pork_bread_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.BREAD_SLICE),
						new ItemStack(ExtraDelightItems.PULLED_PORK_SANDWICH.get()),
						ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()))
				.save(consumer, EDLoc("pulled_pork_bread_slice_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.RACK_LAMB.get()),
						ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get()))
				.save(consumer, EDLoc("rack_lamb_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.BEEF_WELLINGTON.get()),
						ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()))
				.save(consumer, EDLoc("beef_wellington_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.HAGGIS.get()),
						ExtraDelightItems.HAGGIS_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HAGGIS_FEAST_ITEM.get()))
				.save(consumer, EDLoc("haggis_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), new ItemStack(ExtraDelightItems.STIRFRY.get()),
						ExtraDelightItems.STIRFRY_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.STIRFRY_FEAST_ITEM.get()))
				.save(consumer, EDLoc("stirfry_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.BBQ_RIBS.get()),
						ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get()))
				.save(consumer, EDLoc("ribs_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.MASHED_POTATO_GRAVY.get()),
						ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get()))
				.save(consumer, EDLoc("mashed_potato_gravy_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.SALAD.get()),
						ExtraDelightItems.SALAD_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.SALAD_FEAST_ITEM.get()))
				.save(consumer, EDLoc("salad_bowl_feast"));

		// Halloween Start!
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CORNBREAD.get()),
						ExtraDelightItems.CORNBREAD_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.CORNBREAD_FEAST.get()))
				.save(consumer, EDLoc("cornbread_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CORN_PUDDING.get()),
						ExtraDelightItems.CORN_PUDDING_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.CORN_PUDDING_FEAST.get()))
				.save(consumer, EDLoc("corn_pudding_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.APPLE_CRISP.get()),
						ExtraDelightItems.APPLE_CRISP_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.APPLE_CRISP_FEAST.get()))
				.save(consumer, EDLoc("apple_crisp_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.STUFFING.get()),
						ExtraDelightItems.STUFFING_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.STUFFING_FEAST.get()))
				.save(consumer, EDLoc("stuffing_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.POTATO_AU_GRATIN.get()),
						ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get()))
				.save(consumer, EDLoc("potato_au_gratin_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(CommonTags.TOOLS_KNIFE), new ItemStack(ExtraDelightItems.PUMPKIN_ROLL.get()),
						ExtraDelightItems.PUMPKIN_ROLL_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PUMPKIN_ROLL_FEAST.get()))
				.save(consumer, EDLoc("pumpkin_roll_feast_knife_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(ExtraDelightItems.CINNAMON_ROLL.get()),
						ExtraDelightItems.CINNAMON_ROLLS_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PUMPKIN_ROLL_FEAST.get()))
				.save(consumer, EDLoc("cinnamon_roll_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.MONKEY_BREAD.get()),
						ExtraDelightItems.MONKEY_BREAD_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MONKEY_BREAD_FEAST.get()))
				.save(consumer, EDLoc("monkey_bread_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.MINT_LAMB.get()),
						ExtraDelightItems.MINT_LAMB_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MINT_LAMB_FEAST.get()))
				.save(consumer, EDLoc("mint_lamb_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CHARCUTERIE_BOARD.get()),
						ExtraDelightItems.CHARCUTERIE_BOARD_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.CHARCUTERIE_BOARD_FEAST.get()))
				.save(consumer, EDLoc("charcuterie_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(ExtraDelightItems.CHRISTMAS_PUDDING.get()),
						ExtraDelightItems.CHRISTMAS_PUDDING_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.CHRISTMAS_PUDDING_FEAST.get()))
				.save(consumer, EDLoc("christmas_pudding_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.GLASS_BOTTLE), new ItemStack(ExtraDelightItems.PUNCH.get()),
						ExtraDelightItems.PUNCH_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PUNCH_FEAST.get()))
				.save(consumer, EDLoc("punch_feast"));
	}

	private void doughShapeRecipes(RecipeOutput consumer) {
		doughshaping(Ingredient.of(CommonTags.FOODS_DOUGH), RecipeCategory.FOOD, ExtraDelightItems.MACARONI.get(), 1)
				.unlockedBy("has_dough", has(CommonTags.FOODS_DOUGH)).save(consumer, EDLoc("macaroni_pasta"));
		doughshaping(Ingredient.of(CommonTags.FOODS_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.LASAGNA_NOODLES.get(), 1).unlockedBy("has_dough", has(CommonTags.FOODS_DOUGH))
				.save(consumer, EDLoc("lasagna_pasta"));
		doughshaping(Ingredient.of(CommonTags.FOODS_DOUGH), RecipeCategory.FOOD, ModItems.RAW_PASTA.get(), 1)
				.unlockedBy("has_dough", has(CommonTags.FOODS_DOUGH)).save(consumer, EDLoc("raw_pasta"));

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_ALEX.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_CREEPER.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_PICKAXE.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_STEVE.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_SWORD.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_VILLAGER.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_DIAMOND.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_GINGERBREAD_EMERALD.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_ALEX.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_CREEPER.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_PICKAXE.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_STEVE.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_SWORD.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_VILLAGER.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);

		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_DIAMOND.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);
		doughshaping(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH), RecipeCategory.FOOD,
				ExtraDelightItems.RAW_SUGAR_COOKIE_EMERALD.get(), 8)
				.unlockedBy("has_dough", has(ExtraDelightTags.SUGAR_COOKIE_DOUGH)).save(consumer);
		doughshaping(Ingredient.of(ExtraDelightTags.CORN_KERNELS), RecipeCategory.FOOD,
				ExtraDelightItems.CORN_FLAKES.get(), 8).unlockedBy("has_dough", has(ExtraDelightTags.CORN_KERNELS))
				.save(consumer);
	}

	public static SingleItemRecipeBuilder doughshaping(Ingredient p_251375_, RecipeCategory p_248984_,
			ItemLike p_250105_, int p_249506_) {
		return new SingleItemRecipeBuilder(p_248984_, DoughShapingRecipe::new, p_251375_, p_250105_, p_249506_);
	}

	public static SingleItemRecipeBuilder doughshaping(Ingredient p_248596_, RecipeCategory p_250503_,
			ItemLike p_250269_) {
		return new SingleItemRecipeBuilder(p_250503_, DoughShapingRecipe::new, p_248596_, p_250269_, 1);
	}

	private void dryingRackRecipes(RecipeOutput consumer) {
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.WET_SPONGE), new ItemStack(Items.SPONGE), 10, 1000)
				.unlockedBy("has_sponge", has(Items.WET_SPONGE)).save(consumer, EDLoc("sponge"));
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.KELP), new ItemStack(Items.DRIED_KELP), 10, 1000)
				.unlockedBy("has_kelp", has(Items.KELP)).save(consumer, EDLoc("dried_kelp"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightItems.SEAWEED_PASTE.get()),
						new ItemStack(ExtraDelightItems.AGAR_SHEETS.get()), 10, 1000)
				.unlockedBy("has_paste", has(ExtraDelightItems.SEAWEED_PASTE.get()))
				.save(consumer, EDLoc("agar_sheets"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(Tags.Items.FOODS_COOKED_FISH), new ItemStack(ExtraDelightItems.FISH_FLAKES.get()),
						10, 1000)
				.unlockedBy("has_fish", has(Tags.Items.FOODS_COOKED_FISH)).save(consumer, EDLoc("fish_flakes"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightTags.MEAT), new ItemStack(ExtraDelightItems.JERKY.get()), 10, 1000)
				.unlockedBy("has_meat", has(ExtraDelightTags.MEAT)).save(consumer, EDLoc("jerky"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightItems.CORN_HUSK.get()),
						new ItemStack(ExtraDelightItems.DRIED_CORN_HUSK.get()), 10, 1000)
				.unlockedBy("has_husk", has(ExtraDelightItems.CORN_HUSK.get())).save(consumer, EDLoc("corn_husk"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightItems.RAW_CINNAMON.get()),
						new ItemStack(ExtraDelightItems.CINNAMON_STICK.get()), 10, 1000)
				.unlockedBy("has_husk", has(ExtraDelightItems.RAW_CINNAMON.get()))
				.save(consumer, EDLoc("raw_cinnamon"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightTags.PROCESSED_FRUIT),
						new ItemStack(ExtraDelightItems.DRIED_FRUIT.get()), 10, 1000)
				.unlockedBy("has_husk", has(ExtraDelightTags.DRIED_FRUIT)).save(consumer, EDLoc("dried_fruit"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightTags.COFFEE_CHERRIES),
						new ItemStack(ExtraDelightItems.GREEN_COFFEE.get()), 10, 1000)
				.unlockedBy("has_husk", has(ExtraDelightTags.DRIED_FRUIT)).save(consumer, EDLoc("green_coffee"));

		DryingRackRecipeBuilder.drying(Ingredient.of(ExtraDelightTags.CHILI),
				new ItemStack(ExtraDelightItems.DRIED_CHILI.get()), 10, 1000)
				.unlockedBy("has_husk", has(ExtraDelightTags.DRIED_FRUIT)).save(consumer, EDLoc("chili"));
	}

	private void cookingRecipes(RecipeOutput consumer) {
		vanillaCooking(Ingredient.of(ExtraDelightItems.OMELETTE_MIX.get()), ExtraDelightItems.OMELETTE.get(), consumer,
				"omelette_mix");

		vanillaCooking(Ingredient.of(ExtraDelightItems.EGG_MIX.get()), ExtraDelightItems.SCRAMBLED_EGGS.get(), consumer,
				"egg_mix");
		vanillaCooking(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()), ExtraDelightItems.HASHBROWNS.get(),
				consumer, "hashbrowns");
		vanillaCooking(Ingredient.of(Items.CARROT), ExtraDelightItems.ROASTED_CARROT.get(), consumer, "roasted_carrot");
		vanillaCooking(Ingredient.of(Items.APPLE), ExtraDelightItems.ROASTED_APPLE.get(), consumer, "roasted_apple");
		vanillaCooking(Ingredient.of(ExtraDelightItems.CHEESE_SANDWICH.get()), ExtraDelightItems.GRILLED_CHEESE.get(),
				consumer, "grilled_cheese");
		vanillaCooking(Ingredient.of(ExtraDelightItems.BREAD_SLICE.get()), ExtraDelightItems.TOAST.get(), consumer,
				"toast");
		vanillaCooking(Ingredient.of(ExtraDelightItems.CACTUS.get()), ExtraDelightItems.COOKED_CACTUS.get(), consumer,
				"cactus");
		vanillaCooking(Ingredient.of(ExtraDelightTags.CORN_KERNELS), ExtraDelightItems.POPCORN.get(), consumer,
				"popcorn");
		vanillaCooking(Ingredient.of(ExtraDelightTags.CORN_ON_COB), ExtraDelightItems.GRILLED_CORN_ON_COB.get(),
				consumer, "corn_cob");
		vanillaCooking(Ingredient.of(Items.PUMPKIN_SEEDS), ExtraDelightItems.ROASTED_PUMPKIN_SEEDS.get(), consumer,
				"pumpkin_seeds");

		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_ALEX.get()),
				ExtraDelightItems.GINGERBREAD_ALEX.get(), consumer, "gingerbread_alex");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_CREEPER.get()),
				ExtraDelightItems.GINGERBREAD_CREEPER.get(), consumer, "gingerbread_creeper");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_PICKAXE.get()),
				ExtraDelightItems.GINGERBREAD_PICKAXE.get(), consumer, "gingerbread_pickaxe");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_STEVE.get()),
				ExtraDelightItems.GINGERBREAD_STEVE.get(), consumer, "gingerbread_steve");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_SWORD.get()),
				ExtraDelightItems.GINGERBREAD_SWORD.get(), consumer, "gingerbread_sword");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_VILLAGER.get()),
				ExtraDelightItems.GINGERBREAD_VILLAGER.get(), consumer, "gingerbread_villager");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_DIAMOND.get()),
				ExtraDelightItems.GINGERBREAD_DIAMOND.get(), consumer, "gingerbread_diamond");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_EMERALD.get()),
				ExtraDelightItems.GINGERBREAD_EMERALD.get(), consumer, "gingerbread_emerald");

		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_ALEX.get()),
				ExtraDelightItems.SUGAR_COOKIE_ALEX.get(), consumer, "sugar_cookie_alex");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_CREEPER.get()),
				ExtraDelightItems.SUGAR_COOKIE_CREEPER.get(), consumer, "sugar_cookie_creeper");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_PICKAXE.get()),
				ExtraDelightItems.SUGAR_COOKIE_PICKAXE.get(), consumer, "sugar_cookie_pickaxe");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_STEVE.get()),
				ExtraDelightItems.SUGAR_COOKIE_STEVE.get(), consumer, "sugar_cookie_steve");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_SWORD.get()),
				ExtraDelightItems.SUGAR_COOKIE_SWORD.get(), consumer, "sugar_cookie_sword");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_VILLAGER.get()),
				ExtraDelightItems.SUGAR_COOKIE_VILLAGER.get(), consumer, "sugar_cookie_villager");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_DIAMOND.get()),
				ExtraDelightItems.SUGAR_COOKIE_DIAMOND.get(), consumer, "sugar_cookie_diamond");
		vanillaCooking(Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_EMERALD.get()),
				ExtraDelightItems.SUGAR_COOKIE_EMERALD.get(), consumer, "sugar_cookie_emerald");
		vanillaCooking(Ingredient.of(Items.COCOA_BEANS), ExtraDelightItems.ROASTED_COCOA_BEANS.get(), consumer,
				"roasted_cocoa_beans");
		vanillaCooking(Ingredient.of(ExtraDelightTags.GREEN_COFFEE), ExtraDelightItems.COFFEE_BEANS.get(), consumer,
				"roasted_coffee_beans");
		vanillaCooking(Ingredient.of(ExtraDelightTags.PEANUTS), ExtraDelightItems.ROASTED_PEANUTS.get(), consumer,
				"roasted_peanuts");
		vanillaCooking(Ingredient.of(ExtraDelightTags.HAZELNUTS), ExtraDelightItems.ROASTED_HAZELNUTS.get(), consumer,
				"roasted_hazelnuts");
	}

	private void vanillaCooking(Ingredient of, @NotNull Item item, RecipeOutput consumer, String name) {
		SimpleCookingRecipeBuilder.campfireCooking(of, RecipeCategory.FOOD, item, MEDIUM_EXP, CAMPFIRE_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, EDLoc("campfire/" + name + "_fire"));
		SimpleCookingRecipeBuilder.smelting(of, RecipeCategory.FOOD, item, MEDIUM_EXP, FURNACE_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, EDLoc("smelting/" + name + "_smelt"));
		SimpleCookingRecipeBuilder.smoking(of, RecipeCategory.FOOD, item, MEDIUM_EXP, SMOKER_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, EDLoc("smoking/" + name + "_smoke"));
	}

//	private void dynamicCooking(Ingredient of, @NotNull Item item, RecipeOutput consumer, String name) {
//		DynamicNameSmeltingRecipeBuilder.campfireCooking(of, item, MEDIUM_EXP, NORMAL_COOKING)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
//				.save(consumer, EDLoc("campfire/" + name + "_fire"));
//		DynamicNameSmeltingRecipeBuilder.smelting(of, item, MEDIUM_EXP, NORMAL_COOKING)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
//				.save(consumer, EDLoc("smelting/" + name + "_smelt"));
//		DynamicNameSmeltingRecipeBuilder.smoking(of, item, MEDIUM_EXP, NORMAL_COOKING)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
//				.save(consumer, EDLoc("smoking/" + name + "_smoke"));
//	}

	private void mixingbowlRecipes(RecipeOutput consumer) {

		mixing(new ItemStack(ModItems.WHEAT_DOUGH.get(), 3), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.FLOUR),
						Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(Tags.Items.EGGS) },
				new FluidStack[] {}, consumer, "wheat_dough_egg");

		mixing(new ItemStack(ModItems.WHEAT_DOUGH.get(), 3), LONG_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.FLOUR),
						Ingredient.of(ExtraDelightTags.FLOUR) },
				new FluidStack[] {}, consumer, "wheat_dough");

		mixing(new ItemStack(ExtraDelightItems.EGG_MIX.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(Tags.Items.EGGS) },
				new FluidStack[] {}, consumer, "egg_mix");

		mixing(new ItemStack(ExtraDelightItems.MAYO.get(), 1), LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(Tags.Items.EGGS), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightTags.COOKING_OIL), Ingredient.of(ExtraDelightTags.VINEGAR) },
				new FluidStack[] {}, consumer, "mayo");

		mixing(new ItemStack(ExtraDelightItems.CARROT_SALAD.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.GRATED_CARROT),
						Ingredient.of(ExtraDelightTags.GRATED_CARROT), Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.MAYO) },
				new FluidStack[] {}, consumer, "carrot_salad");

		mixing(new ItemStack(ExtraDelightItems.EGG_SALAD.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.BOILED_EGG),
						Ingredient.of(ExtraDelightTags.BOILED_EGG), Ingredient.of(ExtraDelightTags.MAYO) },
				new FluidStack[] {}, consumer, "egg_salad");

		mixing(new ItemStack(ExtraDelightItems.FISH_SALAD.get(), 2), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(Tags.Items.FOODS_COOKED_FISH),
						Ingredient.of(Tags.Items.FOODS_COOKED_FISH), Ingredient.of(ExtraDelightTags.MAYO) },
				new FluidStack[] {}, consumer, "fish_salad");

		mixing(new ItemStack(ExtraDelightItems.BUTTER.get(), 1), LONG_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM) }, new FluidStack[] {}, consumer,
				"butter");

		mixing(new ItemStack(ExtraDelightItems.WHIPPED_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ModItems.MILK_BOTTLE.get()) }, new FluidStack[] {}, consumer,
				"whippedcream_bottle");

		mixing(new ItemStack(ExtraDelightItems.WHIPPED_CREAM.get(), 4), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(Items.MILK_BUCKET) }, new FluidStack[] {}, consumer,
				"whippedcream_bucket");

		mixing(new ItemStack(ExtraDelightItems.SEAWEED_SALAD.get(), 2), STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(Items.KELP), Ingredient.of(Items.KELP),
						Ingredient.of(ExtraDelightTags.GRATED_CARROT), Ingredient.of(ExtraDelightTags.VINEGAR) },
				new FluidStack[] {}, consumer, "seaweed_salad");

		mixing(new ItemStack(ExtraDelightItems.FURIKAKE.get(), 4), STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(Items.KELP), Ingredient.of(Items.KELP),
						Ingredient.of(ExtraDelightTags.FISH_FLAKES), Ingredient.of(ExtraDelightTags.FISH_FLAKES) },
				new FluidStack[] {}, consumer, "furikake_rice");

		mixing(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1), STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ModItems.CABBAGE.get()),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION),
						Ingredient.of(ExtraDelightTags.PROCESSED_CARROT), Ingredient.of(ExtraDelightTags.CROUTONS),
						Ingredient.of(ExtraDelightTags.CHEESE), Ingredient.of(ExtraDelightTags.COOKING_OIL),
						Ingredient.of(ExtraDelightTags.VINEGAR), Ingredient.of(ExtraDelightTags.BOILED_EGG),
						Ingredient.of(ExtraDelightTags.MEAT_COOKED) },
				new FluidStack[] {}, consumer, "salad_meat");

		mixing(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1), STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.CROPS_CABBAGE),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION),
						Ingredient.of(ExtraDelightTags.PROCESSED_CARROT),
						Ingredient.of(ExtraDelightItems.CROUTONS.get()), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightTags.COOKING_OIL), Ingredient.of(ExtraDelightTags.VINEGAR),
						Ingredient.of(ExtraDelightTags.BOILED_EGG), Ingredient.of(ExtraDelightTags.PROCESSED_VEG) },
				new FluidStack[] {}, consumer, "salad_veg");

		mixing(new ItemStack(ExtraDelightItems.PASTA_ALFREDO.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.ALFREDO_SAUCE),
						Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()) },
				new FluidStack[] {}, consumer, "pasta_alfredo");

		mixing(new ItemStack(ExtraDelightItems.CHICKEN_ALFREDO.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.ALFREDO_SAUCE),
						Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()),
						Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN) },
				new FluidStack[] {}, consumer, "chicken_alfredo");

		mixing(new ItemStack(ExtraDelightItems.PASTA_TOMATO.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ModItems.TOMATO_SAUCE.get()),
						Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()) },
				new FluidStack[] {}, consumer, "pasta_tomato");

		mixing(new ItemStack(ModItems.PASTA_WITH_MEATBALLS.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ModItems.TOMATO_SAUCE.get()),
						Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()), Ingredient.of(ModItems.BEEF_PATTY.get()) },
				new FluidStack[] {}, consumer, "pasta_meatballs");

		mixing(new ItemStack(ModItems.PASTA_WITH_MUTTON_CHOP.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ModItems.TOMATO_SAUCE.get()),
						Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()), Ingredient.of(Items.COOKED_MUTTON) },
				new FluidStack[] {}, consumer, "pasta_mutton");

		mixing(new ItemStack(ExtraDelightItems.BUTTERED_PASTA.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()),
						Ingredient.of(ExtraDelightTags.BUTTER) },
				new FluidStack[] {}, consumer, "buttered_pasta");

		mixing(new ItemStack(ExtraDelightItems.CACTUS_SALAD.get(), 1), FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.COOKED_CACTUS),
						Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(ExtraDelightTags.CHEESE) },
				new FluidStack[] {}, consumer, "cactus_salad");

		// Holiday
		mixing(new ItemStack(ExtraDelightItems.ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "ice_cream");

		mixing(new ItemStack(ExtraDelightItems.GLOW_BERRY_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(Items.GLOW_BERRIES),
						Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "glow_berry_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.CHOCOLATE_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.COCOA_BEANS),
						Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "chocolate_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.SWEET_BERRY_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "sweet_berry_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.PUMPKIN_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ModItems.PUMPKIN_SLICE.get()), Ingredient.of(ModItems.PUMPKIN_SLICE.get()),
						Ingredient.of(ModItems.PUMPKIN_SLICE.get()), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "pumpkin_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.HONEY_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.HONEY_BOTTLE),
						Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "honey_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.APPLE_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "apple_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.COOKIE_DOUGH), Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "cookie_dough_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.MINT_CHIP_ICE_CREAM.get(), 1), LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.COCOA_BEANS), Ingredient.of(ExtraDelightTags.MINT),
						Ingredient.of(Items.ICE) },
				new FluidStack[] {}, consumer, "mint_chip_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.MILKSHAKE.get(), 1), STANDARD_GRIND, new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "milkshake");

		mixing(new ItemStack(ExtraDelightItems.APPLE_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE) },
				new FluidStack[] {}, consumer, "apple_milkshake");

		mixing(new ItemStack(ExtraDelightItems.APPLE_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.APPLE_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "apple_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.CHOCOLATE_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(Items.COCOA_BEANS),
						Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.COCOA_BEANS), },
				new FluidStack[] {}, consumer, "chocolate_milkshake");

		mixing(new ItemStack(ExtraDelightItems.CHOCOLATE_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.CHOCOLATE_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "chocolate_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.GLOW_BERRY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(Items.GLOW_BERRIES),
						Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(Items.GLOW_BERRIES), },
				new FluidStack[] {}, consumer, "glow_berry_milkshake");

		mixing(new ItemStack(ExtraDelightItems.GLOW_BERRY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.GLOW_BERRY_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "glow_berry_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.HONEY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(Items.HONEY_BOTTLE),
						Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.HONEY_BOTTLE), },
				new FluidStack[] {}, consumer, "honey_milkshake");

		mixing(new ItemStack(ExtraDelightItems.HONEY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.HONEY_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "honey_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.PUMPKIN_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(ModItems.PUMPKIN_SLICE.get()),
						Ingredient.of(ModItems.PUMPKIN_SLICE.get()), Ingredient.of(ModItems.PUMPKIN_SLICE.get()) },
				new FluidStack[] {}, consumer, "pumpkin_milkshake");

		mixing(new ItemStack(ExtraDelightItems.PUMPKIN_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.PUMPKIN_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "pumpkin_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.SWEET_BERRY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES), },
				new FluidStack[] {}, consumer, "sweet_berry_milkshake");

		mixing(new ItemStack(ExtraDelightItems.SWEET_BERRY_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.SWEET_BERRY_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "sweet_berry_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()),
						Ingredient.of(ExtraDelightTags.COOKIE_DOUGH) },
				new FluidStack[] {}, consumer, "cookie_dough_milkshake");

		mixing(new ItemStack(ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "cookie_dough_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.MINT_CHIP_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(Items.COCOA_BEANS),
						Ingredient.of(ExtraDelightTags.MINT) },
				new FluidStack[] {}, consumer, "mint_chip_milkshake");

		mixing(new ItemStack(ExtraDelightItems.MINT_CHIP_MILKSHAKE.get(), 1), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ExtraDelightItems.MINT_CHIP_ICE_CREAM.get()) },
				new FluidStack[] {}, consumer, "mint_chip_milkshake_ice_cream");

		mixing(new ItemStack(ExtraDelightItems.SUGAR_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS) },
				new FluidStack[] {}, consumer, "sugar_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.APPLE_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON) },
				new FluidStack[] {}, consumer, "apple_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.APPLE_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON) },
				new FluidStack[] {}, consumer, "apple_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(Items.COCOA_BEANS) },
				new FluidStack[] {}, consumer, "chocolate_chip_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(Items.COCOA_BEANS) },
				new FluidStack[] {}, consumer, "chocolate_chip_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightItems.GRATED_GINGER.get()),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON) },
				new FluidStack[] {}, consumer, "gingerbread_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(ExtraDelightItems.GRATED_GINGER.get()),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON) },
				new FluidStack[] {}, consumer, "gingerbread_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(Items.GLOW_BERRIES) },
				new FluidStack[] {}, consumer, "glow_berry_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(Items.GLOW_BERRIES) },
				new FluidStack[] {}, consumer, "glow_berry_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.HONEY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(Items.HONEY_BOTTLE) },
				new FluidStack[] {}, consumer, "honey_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.HONEY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(Items.HONEY_BOTTLE) },
				new FluidStack[] {}, consumer, "honey_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ModItems.PUMPKIN_SLICE.get()) },
				new FluidStack[] {}, consumer, "pumpkin_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(ModItems.PUMPKIN_SLICE.get()) },
				new FluidStack[] {}, consumer, "pumpkin_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(Items.SWEET_BERRIES) },
				new FluidStack[] {}, consumer, "sweet_berry_cookie_dough");

		mixing(new ItemStack(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get(), 1), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH),
						Ingredient.of(Items.SWEET_BERRIES) },
				new FluidStack[] {}, consumer, "sweet_berry_cookie_dough_sugar");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_BLACK.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_BLACK) },
				new FluidStack[] {}, consumer, "frosting_black");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_BLUE.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_BLUE) },
				new FluidStack[] {}, consumer, "frosting_blue");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_BROWN.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_BROWN) },
				new FluidStack[] {}, consumer, "frosting_brown");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_CYAN.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_CYAN) },
				new FluidStack[] {}, consumer, "frosting_cyan");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_GRAY.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_GRAY) },
				new FluidStack[] {}, consumer, "frosting_gray");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_GREEN.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_GREEN) },
				new FluidStack[] {}, consumer, "frosting_green");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_LIGHT_BLUE.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_LIGHT_BLUE) },
				new FluidStack[] {}, consumer, "frosting_light_blue");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_LIGHT_GRAY.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_LIGHT_GRAY) },
				new FluidStack[] {}, consumer, "frosting_light_gray");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_LIME.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_LIME) },
				new FluidStack[] {}, consumer, "frosting_lime");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_MAGENTA.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_MAGENTA) },
				new FluidStack[] {}, consumer, "frosting_magenta");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_ORANGE.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_ORANGE) },
				new FluidStack[] {}, consumer, "frosting_orange");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_PINK.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_PINK) },
				new FluidStack[] {}, consumer, "frosting_pink");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_PURPLE.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_PURPLE) },
				new FluidStack[] {}, consumer, "frosting_purple");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_RED.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_RED) },
				new FluidStack[] {}, consumer, "frosting_red");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_WHITE.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_WHITE) },
				new FluidStack[] {}, consumer, "frosting_white");

		mixing(new ItemStack(ExtraDelightItems.FROSTING_YELLOW.get(), 4), FAST_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.WHIPPED_CREAM),
						Ingredient.of(ExtraDelightItems.BUTTER.get()), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_YELLOW) },
				new FluidStack[] {}, consumer, "frosting_yellow");

		mixing(new ItemStack(ExtraDelightItems.BEET_MINT_SALAD.get(), 2), STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(Items.BEETROOT), Ingredient.of(Items.BEETROOT),
						Ingredient.of(ExtraDelightTags.MINT), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.VINEGAR), Ingredient.of(ExtraDelightTags.COOKING_OIL) },
				new FluidStack[] {}, consumer, "beet_mint_salad");

		mixing(new ItemStack(ExtraDelightItems.COFFEE_JELLY.get(), 2), STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.GELATIN), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.COFFEE), Ingredient.of(ExtraDelightTags.WHIPPED_CREAM) },
				new FluidStack[] { new FluidStack(Fluids.WATER, 100) }, consumer, "coffee_jelly");

		mixing(new ItemStack(ExtraDelightItems.MARSHMALLOW.get(), 4), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.MALLOWROOT_POWDER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.EGGS) },
				new FluidStack[] { new FluidStack(Fluids.WATER, 250) }, consumer, "marshmallow");

		mixing(new ItemStack(ExtraDelightItems.NOUGAT.get(), 4), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightTags.ROASTED_NUTS) },
				new FluidStack[] { new FluidStack(Fluids.WATER, 250) }, consumer, "nougat");

		mixing(new ItemStack(ExtraDelightItems.GUMMIES.get(), 4), STANDARD_GRIND, ItemStack.EMPTY,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.GELATIN), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(Tags.Items.DYES), Ingredient.of(Tags.Items.DYES) },
				new FluidStack[] { new FluidStack(Fluids.WATER, 100) }, consumer, "gummies");
	}

	private void mixing(@NotNull ItemStack output, int grind, ItemStack container, Ingredient[] ingredients,
			FluidStack[] fluids, RecipeOutput consumer, String rc) {
		MixingBowlRecipeBuilder b = MixingBowlRecipeBuilder.stir(output, grind, container);

		for (Ingredient i : ingredients)
			b.requires(i);
		for (FluidStack f : fluids)
			b.requires(f);

		b.unlockedBy(rc, has(output.getItem()));

		b.save(consumer, EDLoc(rc));

//		ProcessingRecipeBuilder<MixingRecipe> p = new ProcessingRecipeBuilder<MixingRecipe>(MixingRecipe::new,
//				CreateLoc(rc + "_create"));
//
//		p.output(output, count);
//		for (Ingredient i : ingredients)
//			p.require(i);
//
//		p.build(consumer);
	}

	private void craftingRecipes(RecipeOutput consumer) {

//		ShapedRecipeBuilder.shaped(ExtraDelightItems.CORN_COB_PIPE.get()).pattern("cs")
//				.define('c', ExtraDelightItems.CORN_COB.get()).define('s', Items.STICK)
//				.unlockedBy(getName(),
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_COB.get()))
//				.save(consumer, EDLoc("corn_cob_pipe"));

//		ShapedWithJarRecipeBuilder.shaped(RecipeCategory.FOOD, Items.DIAMOND, 1, new FluidStack(Fluids.WATER, 100))
//				.pattern("jc").define('j', ExtraDelightItems.JAR.get()).define('c', Items.COAL)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.OVEN.get()).pattern("bBb").pattern("BfB")
				.pattern("BtB").define('b', Items.BRICK).define('B', Items.BRICKS).define('f', Items.FURNACE)
				.define('t', Items.TERRACOTTA)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FOOD_DISPLAY.get()).pattern(" s ")
				.pattern(" S ").pattern(" s ").define('s', Items.STICK).define('S', Items.OAK_SLAB)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_SLAB)).save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.DOUGH_SHAPING.get())
				.requires(Items.STICK, 1).requires(ItemTags.PLANKS).requires(Ingredient.of(ExtraDelightTags.FLOUR))
				.unlockedBy(getName(), has(ExtraDelightTags.FLOUR)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DRYING_RACK.get()).pattern("WSW")
				.pattern("SSS").pattern("WSW").define('W', ItemTags.PLANKS).define('S', Tags.Items.STRINGS)
				.unlockedBy("has_string", has(Tags.Items.STRINGS)).save(consumer, EDLoc("drying_rack"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SHEET.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("sheet"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.TRAY.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("tray"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.LOAF_PAN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 2)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("loaf_pan"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.PIE_DISH.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 3)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("pie_dish"));
//		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SERVING_PAN.get())
//				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 4)
//				.unlockedBy(getName(),
//						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
//				.save(consumer, EDLoc("round_pan"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.MUFFIN_TIN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 6)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("muffin_tin"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BAKING_STONE.get())
				.requires(Items.STONE_PRESSURE_PLATE, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE_PRESSURE_PLATE))
				.save(consumer, EDLoc("baking_stone"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.YEAST_POT.get())
				.requires(Items.FLOWER_POT, 1).requires(ModItems.CANVAS.get(), 1).requires(Items.WATER_BUCKET)
				.requires(ExtraDelightTags.SWEETENER)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer, EDLoc("yeast_pot"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.VINEGAR_POT.get())
				.requires(Items.FLOWER_POT, 1).requires(ModItems.CANVAS.get(), 1).requires(Items.WATER_BUCKET)
				.requires(ExtraDelightTags.SWEETENER).requires(Ingredient.of(ExtraDelightTags.FRUIT))
				.requires(Ingredient.of(ExtraDelightTags.FRUIT))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer, EDLoc("vinegar_pot"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.YEAST_POT.get())
				.requires(Items.FLOWER_POT, 1).requires(ModItems.CANVAS.get(), 1).requires(Items.POTION)
				.requires(ExtraDelightTags.SWEETENER)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer, EDLoc("yeast_pot_potion"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.VINEGAR_POT.get())
				.requires(Items.FLOWER_POT, 1).requires(ModItems.CANVAS.get(), 1).requires(Items.POTION)
				.requires(ExtraDelightTags.SWEETENER).requires(Ingredient.of(ExtraDelightTags.FRUIT))
				.requires(Ingredient.of(ExtraDelightTags.FRUIT))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer, EDLoc("vinegar_pot_potion"));

		// Mortars
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_ANDESITE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.ANDESITE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ANDESITE))
//				.save(consumer, EDLoc("mortar_andesite"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_BASALT.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.BASALT)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BASALT))
//				.save(consumer, EDLoc("mortar_basalt"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_BLACKSTONE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.BLACKSTONE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACKSTONE))
//				.save(consumer, EDLoc("mortar_blackstone"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_DEEPSLATE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.DEEPSLATE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DEEPSLATE))
//				.save(consumer, EDLoc("mortar_deepslate"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_DIORITE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.DIORITE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIORITE))
//				.save(consumer, EDLoc("mortar_diorite"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_ENDSTONE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.END_STONE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.END_STONE))
//				.save(consumer, EDLoc("mortar_endstone"));
//		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_GRANITE.get()).pattern("s s")
//				.pattern(" s ").define('s', Items.GRANITE)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRANITE))
//				.save(consumer, EDLoc("mortar_granite"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MORTAR_STONE.get()).pattern("s s")
				.pattern(" s ").define('s', Items.STONE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE))
				.save(consumer, EDLoc("mortar_stone"));

		// Pestles
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_ANDESITE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.ANDESITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ANDESITE))
				.save(consumer, EDLoc("pestle_andesite"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_BASALT.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.BASALT).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BASALT))
				.save(consumer, EDLoc("pestle_basalt"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_BLACKSTONE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.BLACKSTONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACKSTONE))
				.save(consumer, EDLoc("pestle_blackstone"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_DEEPSLATE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.DEEPSLATE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DEEPSLATE))
				.save(consumer, EDLoc("pestle_deepslate"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_DIORITE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.DIORITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIORITE))
				.save(consumer, EDLoc("pestle_diorite"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_ENDSTONE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.END_STONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.END_STONE))
				.save(consumer, EDLoc("pestle_endstone"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_GRANITE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.GRANITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRANITE))
				.save(consumer, EDLoc("pestle_granite"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PESTLE_STONE.get()).pattern("s  ")
				.pattern(" i ").define('s', Items.STONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE))
				.save(consumer, EDLoc("pestle_stone"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MIXING_BOWL.get()).pattern("w w")
				.pattern("w w").pattern(" w ").define('w', Ingredient.of(ItemTags.PLANKS))
				.unlockedBy(getName(), has(ItemTags.PLANKS)).save(consumer, EDLoc("mixing_bowl"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WOODEN_SPOON.get()).pattern("  w")
				.pattern(" s ").pattern("s  ").define('w', Ingredient.of(ItemTags.PLANKS))
				.define('s', Ingredient.of(Items.STICK)).unlockedBy(getName(), has(ItemTags.PLANKS))
				.save(consumer, EDLoc("wooden_spoon"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.STONE_SPOON.get()).pattern("  w")
				.pattern(" s ").pattern("s  ").define('w', Ingredient.of(Tags.Items.STONES))
				.define('s', Ingredient.of(Items.STICK)).unlockedBy(getName(), has(Tags.Items.STONES))
				.save(consumer, EDLoc("stone_spoon"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.IRON_SPOON.get()).pattern("  w")
				.pattern(" s ").pattern("s  ").define('w', Ingredient.of(Tags.Items.INGOTS_IRON))
				.define('s', Ingredient.of(Items.STICK)).unlockedBy(getName(), has(Tags.Items.INGOTS_IRON))
				.save(consumer, EDLoc("iron_spoon"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.GOLD_SPOON.get()).pattern("  w")
				.pattern(" s ").pattern("s  ").define('w', Ingredient.of(Tags.Items.INGOTS_GOLD))
				.define('s', Ingredient.of(Items.STICK)).unlockedBy(getName(), has(Tags.Items.INGOTS_GOLD))
				.save(consumer, EDLoc("gold_spoon"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DIAMOND_SPOON.get()).pattern("  w")
				.pattern(" s ").pattern("s  ").define('w', Ingredient.of(Tags.Items.GEMS_DIAMOND))
				.define('s', Ingredient.of(Items.STICK)).unlockedBy(getName(), has(Tags.Items.GEMS_DIAMOND))
				.save(consumer, EDLoc("diamond_spoon"));

		SmithingTransformRecipeBuilder
				.smithing(Ingredient.of(ExtraDelightItems.DIAMOND_SPOON.get()), Ingredient.of(Items.NETHERITE_INGOT),
						Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), RecipeCategory.FOOD,
						ExtraDelightItems.NETHERITE_SPOON.get())
				.unlocks("has_netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
				.save(consumer, ExtraDelight.MOD_ID + ":netherite_spoon_smithing");

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.GRATER.get()).pattern(" p ").pattern("pip")
				.pattern(" p ").define('i', Ingredient.of(Tags.Items.INGOTS_IRON))
				.define('p', Ingredient.of(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.unlockedBy(getName(), has(Tags.Items.INGOTS_IRON)).save(consumer, EDLoc("grater"));

//		ShapelessRecipeBuilder.shapeless(ModItems.WHEAT_DOUGH.get(), 3).requires(Items.WATER_BUCKET)
//				.requires(Ingredient.of(ExtraDelightTags.FLOUR), 3)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WATER_BUCKET))
//				.save(consumer, EDLoc("wheat_dough"));
//
//		ShapelessRecipeBuilder.shapeless(ModItems.WHEAT_DOUGH.get(), 3).requires(Tags.Items.EGGS)
//				.requires(Ingredient.of(ExtraDelightTags.FLOUR), 3).unlockedBy(getName(), has(Items.EGG))
//				.save(consumer, EDLoc("wheat_dough_egg"));

		// Juice
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GLOW_BERRY_JUICE.get())
				.requires(Ingredient.of(ExtraDelightTags.FRUIT_GLOW_BERRY), 6).requires(ExtraDelightTags.SWEETENER)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_BERRIES))
				.save(consumer, EDLoc("glow_berry_juice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SWEET_BERRY_JUICE.get())
				.requires(Ingredient.of(ExtraDelightTags.FRUIT_SWEET_BERRY), 6).requires(ExtraDelightTags.SWEETENER)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
				.save(consumer, EDLoc("sweet_berry_juice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.TOMATO_JUICE.get())
				.requires(Ingredient.of(CommonTags.CROPS_TOMATO), 2).requires(ExtraDelightTags.SWEETENER)
				.requires(Items.GLASS_BOTTLE).unlockedBy(getName(), has(CommonTags.CROPS_TOMATO))
				.save(consumer, EDLoc("tomato_juice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CACTUS_JUICE.get())
				.requires(Ingredient.of(ExtraDelightItems.CACTUS.get()), 2).requires(ExtraDelightTags.SWEETENER)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS.get()))
				.save(consumer, EDLoc("cactus_juice"));

		// Pie
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()))
				.save(consumer, EDLoc("sweet_berry_pie_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()))
				.save(consumer, EDLoc("glow_berry_pie_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHEESECAKE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESECAKE_ITEM.get()))
				.save(consumer, EDLoc("cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()))
				.save(consumer, EDLoc("honey_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get())
				.pattern("ff ").pattern("ff ").define('f', ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()))
				.save(consumer, EDLoc("chocolate_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()))
				.save(consumer, EDLoc("pumpkin_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get())
				.pattern("ff ").pattern("ff ").define('f', ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()))
				.save(consumer, EDLoc("glow_berry_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.APPLE_CHEESECAKE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.APPLE_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CHEESECAKE_SLICE.get()))
				.save(consumer, EDLoc("apple_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.QUICHE.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.QUICHE_SLICE.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE.get()))
				.save(consumer, EDLoc("quiche_slice"));

		// Popsicles
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FUDGE_POPSICLE.get()).pattern(" cm")
				.pattern("isc").pattern("Si ").define('m', CommonTags.FOODS_MILK).define('c', Items.COCOA_BEANS)
				.define('s', ExtraDelightTags.SWEETENER).define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("fudge_popsicle"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.HONEY_POPSICLE.get()).pattern(" cm")
				.pattern("imc").pattern("Si ").define('m', CommonTags.FOODS_MILK).define('c', Items.HONEY_BOTTLE)
				.define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("honey_popsicle"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.GLOW_BERRY_POPSICLE.get()).pattern(" gg")
				.pattern("igg").pattern("Si ").define('g', Items.GLOW_BERRIES).define('S', Items.STICK)
				.define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("glow_berry_popsicle"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.SWEET_BERRY_POPSICLE.get()).pattern(" gg")
				.pattern("igg").pattern("Si ").define('g', Items.SWEET_BERRIES).define('S', Items.STICK)
				.define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("sweet_berry_popsicle"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.APPLE_POPSICLE.get()).pattern(" gg")
				.pattern("igg").pattern("Si ").define('g', ExtraDelightTags.PROCESSED_APPLE).define('S', Items.STICK)
				.define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("apple_popsicle"));

		// Omelette
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(Tags.Items.FOODS_VEGETABLE), 2)
				.unlockedBy(getName(), has(Tags.Items.FOODS_VEGETABLE)).save(consumer, EDLoc("omelette_mix_veg"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(Tags.Items.FOODS_VEGETABLE), 1)
				.requires(Ingredient.of(ExtraDelightTags.MEAT), 1)
				.unlockedBy(getName(), has(Tags.Items.FOODS_VEGETABLE)).save(consumer, EDLoc("omelette_mix_mix"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 2)
				.unlockedBy(getName(), has(ExtraDelightTags.MEAT)).save(consumer, EDLoc("omelette_mix_meat"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.CHEESE), 1)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE)).save(consumer, EDLoc("omelette_mix_cheese"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(Tags.Items.FOODS_VEGETABLE), 2)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1)
				.unlockedBy(getName(), has(Tags.Items.FOODS_VEGETABLE))
				.save(consumer, EDLoc("omelette_mix_veg_cheese"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(Tags.Items.FOODS_VEGETABLE), 1)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 1)
				.unlockedBy(getName(), has(Tags.Items.FOODS_VEGETABLE))
				.save(consumer, EDLoc("omelette_mix_mix_cheese"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 2)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1).unlockedBy(getName(), has(ExtraDelightTags.MEAT))
				.save(consumer, EDLoc("omelette_mix_meat_cheese"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM_MUNDANE))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE)).unlockedBy(getName(), has(ExtraDelightTags.JAM))
				.save(consumer, EDLoc("jam_toast"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GLOW_JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM_GLOW_BERRY))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
				.unlockedBy(getName(), has(ExtraDelightTags.JAM_GLOW_BERRY)).save(consumer, EDLoc("glow_jam_toast"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GOLDEN_JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM_GOLDEN_APPLE))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
				.unlockedBy(getName(), has(ExtraDelightTags.JAM_GOLDEN_APPLE))
				.save(consumer, EDLoc("golden_jam_toast"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.EGG_SALAD_SANDWICH.get())
				.requires(Ingredient.of(ExtraDelightItems.EGG_SALAD.get()))
				.requires(Ingredient.of(Tags.Items.FOODS_BREAD))
				.unlockedBy(getName(), has(ExtraDelightItems.EGG_SALAD.get()))
				.save(consumer, EDLoc("egg_salad_sandwich"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.EGG_SALAD_SANDWICH.get())
				.requires(Ingredient.of(ExtraDelightItems.EGG_SALAD.get()))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE), 2)
				.unlockedBy(getName(), has(ExtraDelightItems.EGG_SALAD.get()))
				.save(consumer, EDLoc("egg_salad_sandwich_slice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHEESE_BLOCK_ITEM.get())
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 9).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("cheese_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHEESE_SLAB_BLOCK_ITEM.get(), 6)
				.pattern("ppp").define('p', ExtraDelightItems.CHEESE_BLOCK_ITEM.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("cheese_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHEESE_STAIRS_BLOCK_ITEM.get(), 4)
				.pattern("p  ").pattern("pp ").pattern("ppp").define('p', ExtraDelightItems.CHEESE_BLOCK_ITEM.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("cheese_stairs"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BUTTER_BLOCK_ITEM.get())
				.requires(Ingredient.of(ExtraDelightTags.BUTTER), 9).unlockedBy(getName(), has(ExtraDelightTags.BUTTER))
				.save(consumer, EDLoc("butter_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BUTTER_SLAB_BLOCK_ITEM.get(), 6)
				.pattern("ppp").define('p', ExtraDelightItems.BUTTER_BLOCK_ITEM.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("butters_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BUTTER_STAIRS_BLOCK_ITEM.get(), 4)
				.pattern("p  ").pattern("pp ").pattern("ppp").define('p', ExtraDelightItems.BUTTER_BLOCK_ITEM.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("butter_stairs"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHEESE.get(), 9)
				.requires(Ingredient.of(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("cheese_block_to_item"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BUTTER.get(), 9)
				.requires(Ingredient.of(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.save(consumer, EDLoc("butter_block_to_item"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHEESE_SANDWICH.get()).pattern(" b ")
				.pattern("mc ").pattern(" b ").define('c', ExtraDelightTags.CHEESE).define('m', ExtraDelightTags.MAYO)
				.define('b', ExtraDelightTags.BREAD_SLICE).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("cheese_sandwich"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHEESE_SANDWICH.get()).pattern(" b ")
				.pattern("mc ").pattern(" b ").define('c', ExtraDelightTags.CHEESE).define('m', ExtraDelightTags.BUTTER)
				.define('b', ExtraDelightTags.BREAD_SLICE).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("grilled_cheese_butter"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()).pattern("ss ")
				.pattern("ss ").define('s', ExtraDelightItems.MEAT_PIE_SLICE.get())
				.unlockedBy(getName(), has(ExtraDelightItems.MEAT_PIE_SLICE.get()))
				.save(consumer, EDLoc("meat_pie_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get()).pattern(" b ")
				.pattern("cm ").pattern(" b ")
				.define('c',
						CompoundIngredient.of(Ingredient.of(ExtraDelightTags.CONDIMENTS),
								Ingredient.of(ExtraDelightTags.GRAVY)))
				.define('m', ExtraDelightItems.PORK_TENDERLOIN.get()).define('b', ExtraDelightTags.BREAD_SLICE)
				.unlockedBy(getName(), has(ExtraDelightItems.PORK_TENDERLOIN.get()))
				.save(consumer, EDLoc("pork_tenderloin_sandwich_bread_slice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get(), 1)
				.requires(CompoundIngredient.of(Ingredient.of(ExtraDelightTags.CONDIMENTS),
						Ingredient.of(ExtraDelightTags.GRAVY)))
				.requires(Ingredient.of(Tags.Items.FOODS_BREAD)).requires(ExtraDelightItems.PORK_TENDERLOIN.get())
				.unlockedBy(getName(), has(ExtraDelightItems.PORK_TENDERLOIN.get()))
				.save(consumer, EDLoc("pork_tenderloin_sandwich"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FURIKAKE_RICE.get(), 1)
				.requires(ExtraDelightItems.FURIKAKE.get()).requires(Ingredient.of(ModItems.COOKED_RICE.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.FURIKAKE.get())).save(consumer, EDLoc("furikake_rice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FISH_AND_CHIPS.get(), 1)
				.requires(ExtraDelightItems.FRIED_FISH.get()).requires(ExtraDelightItems.FRENCH_FRIES.get())
				.requires(ExtraDelightTags.VINEGAR).unlockedBy(getName(), has(ExtraDelightItems.FRIED_FISH.get()))
				.save(consumer, EDLoc("fish_and_chips"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BREADING_MISANPLAS.get(), 1)
				.requires(ExtraDelightTags.FLOUR).requires(ExtraDelightItems.EGG_MIX.get())
				.requires(ExtraDelightTags.BREAD_CRUMBS).requires(ExtraDelightTags.FRYING_OIL)
				.unlockedBy(getName(), has(ExtraDelightTags.BREAD_CRUMBS)).save(consumer, EDLoc("breading_misanplas"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.MUSHROOM_BURGER.get(), 1)
				.requires(Tags.Items.FOODS_BREAD).requires(ModItems.BEEF_PATTY.get()).requires(Tags.Items.MUSHROOMS)
				.requires(Tags.Items.MUSHROOMS).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(Tags.Items.MUSHROOMS)).save(consumer, EDLoc("mushroom_burger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHEESEBURGER.get(), 1)
				.requires(Tags.Items.FOODS_BREAD).requires(ModItems.BEEF_PATTY.get()).requires(CommonTags.CROPS_CABBAGE)
				.requires(ExtraDelightTags.CHEESE).requires(ExtraDelightTags.PROCESSED_TOMATO)
				.requires(ExtraDelightTags.PROCESSED_ONION).unlockedBy(getName(), has(ModItems.BEEF_PATTY.get()))
				.save(consumer, EDLoc("cheeseburger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHEESEBURGER.get(), 1)
				.requires(ModItems.HAMBURGER.get()).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ModItems.HAMBURGER.get())).save(consumer, EDLoc("cheeseburger_burger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_CHEESEBURGER.get(), 1)
				.requires(Tags.Items.FOODS_BREAD).requires(ModItems.BEEF_PATTY.get()).requires(CommonTags.CROPS_CABBAGE)
				.requires(ExtraDelightTags.CHEESE).requires(ExtraDelightTags.PROCESSED_TOMATO)
				.requires(ExtraDelightTags.PROCESSED_ONION).requires(CommonTags.FOODS_COOKED_BACON)
				.unlockedBy(getName(), has(ModItems.BEEF_PATTY.get())).save(consumer, EDLoc("bacon_cheeseburger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_CHEESEBURGER.get(), 1)
				.requires(ModItems.HAMBURGER.get()).requires(ExtraDelightTags.CHEESE)
				.requires(CommonTags.FOODS_COOKED_BACON).unlockedBy(getName(), has(ModItems.HAMBURGER.get()))
				.save(consumer, EDLoc("bacon_cheeseburger_burger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_CHEESEBURGER.get(), 1)
				.requires(ExtraDelightItems.CHEESEBURGER.get()).requires(CommonTags.FOODS_COOKED_BACON)
				.unlockedBy(getName(), has(ExtraDelightItems.CHEESEBURGER.get()))
				.save(consumer, EDLoc("bacon_cheeseburger_cheeseburger"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_EGG_SANDWICH.get(), 1)
				.requires(ModItems.EGG_SANDWICH.get()).requires(CommonTags.FOODS_COOKED_BACON)
				.requires(CommonTags.FOODS_COOKED_BACON).unlockedBy(getName(), has(CommonTags.FOODS_COOKED_BACON))
				.save(consumer, EDLoc("bacon_egg_sandwich"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_EGG_SANDWICH.get(), 1)
				.requires(Tags.Items.FOODS_BREAD).requires(CommonTags.FOODS_COOKED_BACON)
				.requires(CommonTags.FOODS_COOKED_BACON).requires(CommonTags.FOODS_COOKED_EGG)
				.requires(CommonTags.FOODS_COOKED_EGG).unlockedBy(getName(), has(CommonTags.FOODS_COOKED_BACON))
				.save(consumer, EDLoc("bacon_egg_sandwich_full"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1)
				.requires(ModItems.EGG_SANDWICH.get()).requires(CommonTags.FOODS_COOKED_BACON)
				.requires(CommonTags.FOODS_COOKED_BACON).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("bacon_egg_cheese_sandwich_egg"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.BACON_EGG_SANDWICH.get()).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("bacon_egg_cheese_sandwich_egg_bacon"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1)
				.requires(Tags.Items.FOODS_BREAD).requires(CommonTags.FOODS_COOKED_BACON)
				.requires(CommonTags.FOODS_COOKED_BACON).requires(CommonTags.FOODS_COOKED_EGG)
				.requires(CommonTags.FOODS_COOKED_EGG).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, EDLoc("bacon_egg_cheese_sandwich_full"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BUTTERED_TOAST.get(), 1)
				.requires(ExtraDelightTags.BREAD_SLICE).requires(ExtraDelightTags.BUTTER)
				.unlockedBy(getName(), has(ExtraDelightTags.BUTTER)).save(consumer, EDLoc("butter_toast"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.RICEBALL.get(), 2)
				.requires(ModItems.COOKED_RICE.get()).requires(Items.DRIED_KELP)
				.requires(ExtraDelightItems.FISH_FLAKES.get()).unlockedBy(getName(), has(ModItems.COOKED_RICE.get()))
				.save(consumer, EDLoc("riceball"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.RICEBALL_FILLED.get(), 1)
				.requires(ModItems.COOKED_RICE.get()).requires(Items.DRIED_KELP)
				.requires(ExtraDelightItems.FISH_FLAKES.get()).requires(ExtraDelightTags.RICEBALL_FILLING)
				.unlockedBy(getName(), has(ModItems.COOKED_RICE.get())).save(consumer, EDLoc("riceball_filled"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FISH_SALAD_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.FISH_SALAD.get()).requires(Items.BREAD)
				.unlockedBy(getName(), has(ExtraDelightItems.FISH_SALAD.get()))
				.save(consumer, EDLoc("fish_salad_sandwich"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FISH_SALAD_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.FISH_SALAD.get()).requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE), 2)
				.unlockedBy(getName(), has(ExtraDelightItems.FISH_SALAD.get()))
				.save(consumer, EDLoc("fish_salad_sandwich_slice"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CACTUS_EGGS.get(), 1)
				.requires(ExtraDelightTags.COOKED_CACTUS).requires(ExtraDelightItems.SCRAMBLED_EGGS.get(), 1)
				.unlockedBy(getName(), has(ExtraDelightTags.COOKED_CACTUS)).save(consumer, EDLoc("cooked_cactus"));

		// Halloween Start!
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CARAMEL_POPCORN.get(), 1)
				.requires(ExtraDelightTags.POPCORN).requires(ExtraDelightItems.CARAMEL_SAUCE.get(), 1)
				.unlockedBy(getName(), has(ExtraDelightTags.POPCORN)).save(consumer, EDLoc("caramel_popcorn"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CARAMEL_POPSICLE.get()).pattern(" cm")
				.pattern("isc").pattern("Si ").define('m', CommonTags.FOODS_MILK)
				.define('c', ExtraDelightItems.CARAMEL_SAUCE.get()).define('s', ExtraDelightTags.SWEETENER)
				.define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("caramel_popsicle"));

		bundleItem9(Ingredient.of(ExtraDelightTags.FLOUR), ExtraDelightItems.FLOUR_SACK.get(),
				ExtraDelightItems.FLOUR.get(), consumer, "flour");
		bundleItem9(Ingredient.of(ExtraDelightTags.CORN_MEAL), ExtraDelightItems.CORNMEAL_SACK.get(),
				ExtraDelightItems.CORN_MEAL.get(), consumer, "cornmeal");
		bundleItem9(Ingredient.of(Items.SUGAR), ExtraDelightItems.SUGAR_SACK.get(), Items.SUGAR, consumer, "sugar");
		bundleItem9(Ingredient.of(ExtraDelightItems.CORN_ON_COB.get()), ExtraDelightItems.CORN_CRATE.get(),
				ExtraDelightItems.CORN_ON_COB.get(), consumer, "corn");
		bundleItem9(Ingredient.of(ExtraDelightItems.CORN_HUSK.get()), ExtraDelightItems.CORN_HUSK_BUNDLE.get(),
				ExtraDelightItems.CORN_HUSK.get(), consumer, "corn_husk");
		bundleItem9(Ingredient.of(ExtraDelightItems.DRIED_CORN_HUSK.get()),
				ExtraDelightItems.DRIED_CORN_HUSK_BUNDLE.get(), ExtraDelightItems.DRIED_CORN_HUSK.get(), consumer,
				"dried_corn_husk");
		bundleItem9(Ingredient.of(ExtraDelightItems.CORN_COB.get()), ExtraDelightItems.CORN_COB_BUNDLE.get(),
				ExtraDelightItems.CORN_COB.get(), consumer, "corn_cob");
		bundleItem9(Ingredient.of(ExtraDelightTags.GINGER), ExtraDelightItems.GINGER_CRATE.get(),
				ExtraDelightItems.GINGER.get(), consumer, "ginger");
		bundleItem9(Ingredient.of(Tags.Items.EGGS), ExtraDelightItems.EGG_CRATE.get(), Items.EGG, consumer, "egg");
		bundleItem9(Ingredient.of(Items.APPLE), ExtraDelightItems.APPLE_CRATE.get(), Items.APPLE, consumer, "apple");
		bundleItem9(Ingredient.of(Items.GOLDEN_APPLE), ExtraDelightItems.GOLDEN_APPLE_CRATE.get(), Items.GOLDEN_APPLE,
				consumer, "golden_apple");
		bundleItem9(Ingredient.of(Items.BROWN_MUSHROOM), ExtraDelightItems.BROWN_MUSHROOM_CRATE.get(),
				Items.BROWN_MUSHROOM, consumer, "brown_mushroom");
		bundleItem9(Ingredient.of(Items.RED_MUSHROOM), ExtraDelightItems.RED_MUSHROOM_CRATE.get(), Items.RED_MUSHROOM,
				consumer, "red_mushroom");
		bundleItem9(Ingredient.of(Items.SWEET_BERRIES), ExtraDelightItems.SWEET_BERRY_CRATE.get(), Items.SWEET_BERRIES,
				consumer, "sweet_berries");
		bundleItem9(Ingredient.of(Items.GLOW_BERRIES), ExtraDelightItems.GLOW_BERRY_CRATE.get(), Items.GLOW_BERRIES,
				consumer, "glow_berries");
		bundleItem9(Ingredient.of(ExtraDelightItems.CORN_SILK), ExtraDelightItems.CORN_SILK_SACK.get(),
				ExtraDelightItems.CORN_SILK.get(), consumer, "corn_silk");
		bundleItem9(Ingredient.of(ExtraDelightItems.GROUND_CINNAMON),
				ExtraDelightItems.GROUND_CINNAMON_BLOCK_ITEM.get(), ExtraDelightItems.GROUND_CINNAMON.get(), consumer,
				"ground_cinnamon");
		bundleItem9(Ingredient.of(ExtraDelightItems.RAW_CINNAMON), ExtraDelightItems.RAW_CINNAMON_BLOCK.get(),
				ExtraDelightItems.RAW_CINNAMON.get(), consumer, "raw_cinnamon");
		bundleItem9(Ingredient.of(ExtraDelightItems.CINNAMON_STICK), ExtraDelightItems.CINNAMON_STICK_BLOCK.get(),
				ExtraDelightItems.CINNAMON_STICK.get(), consumer, "cinnamon_stick");
		bundleItem9(Ingredient.of(ExtraDelightItems.BREAD_CRUMBS), ExtraDelightItems.BREADCRUMB_SACK.get(),
				ExtraDelightItems.BREAD_CRUMBS.get(), consumer, "breadcrumbs");
		bundleItem9(Ingredient.of(ExtraDelightItems.MINT), ExtraDelightItems.MINT_SACK.get(),
				ExtraDelightItems.MINT.get(), consumer, "mint");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHOCOLATE_MILK.get(), 1)
				.requires(ModItems.MILK_BOTTLE.get()).requires(Items.COCOA_BEANS)
				.unlockedBy(getName(), has(ModItems.MILK_BOTTLE.get())).save(consumer, EDLoc("chocolate_milk"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHOCOLATE_MILK.get(), 4)
				.requires(Items.MILK_BUCKET).requires(Items.COCOA_BEANS, 4).requires(Items.GLASS_BOTTLE, 4)
				.unlockedBy(getName(), has(Items.MILK_BUCKET)).save(consumer, EDLoc("chocolate_milk_bucket"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.OFFSET_SPATULA_DIAMOND.get()).pattern(" is")
				.pattern("i  ").define('i', Items.DIAMOND).define('s', Items.STICK)
				.unlockedBy(getName(), has(Items.DIAMOND)).save(consumer, EDLoc("offset_spatula_diamond"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.OFFSET_SPATULA_GOLD.get()).pattern(" is")
				.pattern("i  ").define('i', Items.GOLD_INGOT).define('s', Items.STICK)
				.unlockedBy(getName(), has(Items.GOLD_INGOT)).save(consumer, EDLoc("offset_spatula_gold"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.OFFSET_SPATULA_IRON.get()).pattern(" is")
				.pattern("i  ").define('i', Items.IRON_INGOT).define('s', Items.STICK)
				.unlockedBy(getName(), has(Items.IRON_INGOT)).save(consumer, EDLoc("offset_spatula_iron"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.OFFSET_SPATULA_WOOD.get()).pattern(" is")
				.pattern("i  ").define('i', ItemTags.PLANKS).define('s', Items.STICK)
				.unlockedBy(getName(), has(ItemTags.PLANKS)).save(consumer, EDLoc("offset_spatula_wood"));

		SmithingTransformRecipeBuilder
				.smithing(Ingredient.of(ExtraDelightItems.OFFSET_SPATULA_DIAMOND.get()),
						Ingredient.of(Items.NETHERITE_INGOT), Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
						RecipeCategory.FOOD, ExtraDelightItems.OFFSET_SPATULA_NETHERITE.get())
				.unlocks("has_netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
				.save(consumer, ExtraDelight.MOD_ID + ":netherite_offset_spatula_smithing");

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CANDY_BOWL_ITEM.get()).pattern("gbg")
				.pattern(" g ").define('g', Items.GLASS).define('b', Items.BOWL).unlockedBy(getName(), has(Items.GLASS))
				.save(consumer, EDLoc("candy_bowl"));

		bundleItem4(Ingredient.of(ExtraDelightItems.MINT_CANDY_BLUE.get()), ExtraDelightItems.CANDY_CANE_BLUE.get(),
				ExtraDelightItems.MINT_CANDY_BLUE.get(), consumer, "mint_candy_blue");
		bundleItem4(Ingredient.of(ExtraDelightItems.MINT_CANDY_GREEN.get()), ExtraDelightItems.CANDY_CANE_GREEN.get(),
				ExtraDelightItems.MINT_CANDY_GREEN.get(), consumer, "mint_candy_green");
		bundleItem4(Ingredient.of(ExtraDelightItems.MINT_CANDY_RED.get()), ExtraDelightItems.CANDY_CANE_RED.get(),
				ExtraDelightItems.MINT_CANDY_RED.get(), consumer, "mint_candy_red");

		bundleItem4(Ingredient.of(ExtraDelightItems.CANDY_CANE_BLUE.get()),
				ExtraDelightItems.CANDY_CANE_BLUE_BLOCK.get(), ExtraDelightItems.CANDY_CANE_BLUE.get(), consumer,
				"mint_candy_cane_blue");
		bundleItem4(Ingredient.of(ExtraDelightItems.CANDY_CANE_GREEN.get()),
				ExtraDelightItems.CANDY_CANE_GREEN_BLOCK.get(), ExtraDelightItems.CANDY_CANE_GREEN.get(), consumer,
				"mint_candy_cane_green");
		bundleItem4(Ingredient.of(ExtraDelightItems.CANDY_CANE_RED.get()), ExtraDelightItems.CANDY_CANE_RED_BLOCK.get(),
				ExtraDelightItems.CANDY_CANE_RED.get(), consumer, "mint_candy_cane_red");

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_POPSICLE.get()).pattern(" cm")
				.pattern("isc").pattern("Si ").define('m', CommonTags.FOODS_MILK)
				.define('c', ExtraDelightTags.GROUND_CINNAMON).define('s', ExtraDelightTags.SWEETENER)
				.define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, EDLoc("cinnamon_popsicle"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CROQUE_MONSIEUR.get()).pattern("bfm")
				.pattern("tct").pattern(" h ").define('m', CommonTags.FOODS_MILK).define('b', ExtraDelightTags.BUTTER)
				.define('f', ExtraDelightTags.FLOUR).define('t', ExtraDelightTags.TOAST)
				.define('c', ExtraDelightTags.CHEESE)
				.define('h', Ingredient.of(ModItems.SMOKED_HAM.get(), Items.COOKED_PORKCHOP))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOAST.get()))
				.save(consumer, EDLoc("croque_monsieur"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CROQUE_MADAME.get()).pattern("bfm")
				.pattern("tet").pattern("c h").define('m', CommonTags.FOODS_MILK).define('b', ExtraDelightTags.BUTTER)
				.define('f', ExtraDelightTags.FLOUR).define('t', ExtraDelightTags.TOAST)
				.define('c', ExtraDelightTags.CHEESE)
				.define('h', Ingredient.of(ModItems.SMOKED_HAM.get(), Items.COOKED_PORKCHOP))
				.define('e', CommonTags.FOODS_COOKED_EGG)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOAST.get()))
				.save(consumer, EDLoc("croque_madame"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CROQUE_MADAME.get())
				.requires(ExtraDelightItems.CROQUE_MONSIEUR.get()).requires(CommonTags.FOODS_COOKED_EGG)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOAST.get()))
				.save(consumer, EDLoc("monsieur_to_madam"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.COFFEE_CAKE_FEAST.get())
				.requires(ExtraDelightItems.COFFEE_CAKE_SLICE.get(), 8)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_CAKE_SLICE.get()))
				.save(consumer, EDLoc("coffee_cake_from_slice"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHARCUTERIE_BOARD_FEAST.get()).pattern("cmh")
				.pattern("cmh").pattern(" b ").define('m', ExtraDelightTags.MEAT_COOKED)
				.define('c', ExtraDelightItems.CRACKERS.get()).define('h', ExtraDelightTags.CHEESE)
				.define('b', Items.BOWL)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE.get()))
				.save(consumer, EDLoc("charcuterie_board"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.PUNCH_FEAST.get()).pattern("fff")
				.pattern("sws").pattern(" b ").define('f', ExtraDelightTags.PROCESSED_FRUIT)
				.define('s', ExtraDelightTags.SWEETENER).define('w', Items.WATER_BUCKET).define('b', Items.BOWL)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WATER_BUCKET))
				.save(consumer, EDLoc("punch"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_TART_FEAST.get()).pattern("ss")
				.pattern("ss").define('s', ExtraDelightItems.MILK_TART_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_TART_SLICE.get()))
				.save(consumer, EDLoc("milk_tart"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_PLANKS.get(), 4)
				.requires(ExtraDelightItems.CINNAMON_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_LOG.get()))
				.save(consumer, EDLoc("cinnamon_planks"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_WOOD.get(), 3).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.CINNAMON_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_LOG.get()))
				.save(consumer, EDLoc("cinnamon_wood"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.STRIPPED_CINNAMON_WOOD.get(), 3)
				.pattern("ff ").pattern("ff ").define('f', ExtraDelightItems.STRIPPED_CINNAMON_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STRIPPED_CINNAMON_LOG.get()))
				.save(consumer, EDLoc("stripped_cinnamon_wood"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_PLANKS.get(), 4)
				.requires(ExtraDelightItems.STRIPPED_CINNAMON_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_LOG.get()))
				.save(consumer, EDLoc("cinnamon_planks_stripped"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_CABINET.get()).pattern("sss")
				.pattern("t t").pattern("sss").define('s', ExtraDelightItems.CINNAMON_SLAB.get())
				.define('t', ExtraDelightItems.CINNAMON_TRAPDOOR.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_SLAB.get()))
				.save(consumer, EDLoc("cinnamon_cabinet"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_SLAB.get(), 6).pattern("ppp")
				.define('p', ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_DOOR.get(), 3).pattern("pp ")
				.pattern("pp ").pattern("pp ").define('p', ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_TRAPDOOR.get(), 2).pattern("pp ")
				.pattern("pp ").define('p', ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_FENCE.get(), 3).pattern("psp")
				.pattern("psp").define('p', ExtraDelightItems.CINNAMON_PLANKS.get()).define('s', Items.STICK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_FENCE_GATE.get()).pattern("sps")
				.pattern("sps").define('p', ExtraDelightItems.CINNAMON_PLANKS.get()).define('s', Items.STICK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_STAIRS.get(), 4).pattern("p  ")
				.pattern("pp ").pattern("ppp").define('p', ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_PRESSURE_PLATE.get(), 1)
				.pattern("pp").define('p', ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_pressure_plate"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CINNAMON_BUTTON.get(), 1)
				.requires(ExtraDelightItems.CINNAMON_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_PLANKS.get()))
				.save(consumer, EDLoc("cinnamon_button"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraDelightItems.TAP.get(), 1).pattern(" l ").pattern("bcb")
				.define('l', Items.LEVER).define('b', Items.WATER_BUCKET).define('c', Items.COPPER_INGOT)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
				.save(consumer, EDLoc("tap"));

		this.bucket("apple_cider", consumer, ExtraDelightItems.APPLE_CIDER_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ModItems.APPLE_CIDER.get());
		this.bucket("bbq", consumer, ExtraDelightItems.BBQ_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.BBQ_SAUCE.get());
		this.bucket("broth", consumer, ExtraDelightItems.BROTH_FLUID_BUCKET.get(), Items.BOWL,
				ModItems.BONE_BROTH.get());
		this.bucket("cactus_juice", consumer, ExtraDelightItems.CACTUS_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.CACTUS_JUICE.get());
		this.bucket("caramel_sauce", consumer, ExtraDelightItems.CARAMEL_SAUCE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.CARAMEL_SAUCE.get());
		this.bucket("egg_mix", consumer, ExtraDelightItems.EGG_MIX_FLUID_BUCKET.get(), Items.BOWL,
				ExtraDelightItems.EGG_MIX.get());
		this.bucket("glow_berry_juice", consumer, ExtraDelightItems.GLOW_BERRY_JUICE_FLUID_BUCKET.get(),
				Items.GLASS_BOTTLE, ExtraDelightItems.GLOW_BERRY_JUICE.get());
		this.bucket("glow_berry_jam", consumer, ExtraDelightItems.GLOW_JAM_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.GLOW_BERRY_JAM.get());
		this.bucket("golden_jam", consumer, ExtraDelightItems.GOLDEN_JAM_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.GOLDEN_APPLE_JAM.get());
		this.bucket("gravy", consumer, ExtraDelightItems.GRAVY_FLUID_BUCKET.get(), Items.BOWL,
				ExtraDelightItems.GRAVY.get());
		this.bucket("hot_cocoa", consumer, ExtraDelightItems.HOT_COCOA_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ModItems.HOT_COCOA.get());
		this.bucket("jam", consumer, ExtraDelightItems.JAM_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.JAM.get());
		this.bucket("ketchup", consumer, ExtraDelightItems.KETCHUP_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.KETCHUP.get());
		this.bucket("mayo", consumer, ExtraDelightItems.MAYO_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.MAYO.get());
		this.bucket("melon_juice", consumer, ExtraDelightItems.MELON_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ModItems.MELON_JUICE.get());
		this.bucket("milkshake", consumer, ExtraDelightItems.MILKSHAKE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.MILKSHAKE.get());
		this.bucket("oil", consumer, ExtraDelightItems.OIL_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.COOKING_OIL.get());
		this.bucket("sweet_berry_juice", consumer, ExtraDelightItems.SWEET_BERRY_JUICE_FLUID_BUCKET.get(),
				Items.GLASS_BOTTLE, ExtraDelightItems.SWEET_BERRY_JUICE.get());
		this.bucket("tea", consumer, ExtraDelightItems.TEA_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.TEA.get());
		this.bucket("tomato_juice", consumer, ExtraDelightItems.TOMATO_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.TOMATO_JUICE.get());
		this.bucket("vinegar", consumer, ExtraDelightItems.VINEGAR_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ExtraDelightItems.VINEGAR.get());
		this.bucket("whipped_cream", consumer, ExtraDelightItems.WHIPPED_CREAM_FLUID_BUCKET.get(), Items.BOWL,
				ExtraDelightItems.WHIPPED_CREAM.get());

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.KEG.get(), 1).requires(Items.GLASS, 1)
				.requires(Items.BARREL, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BARREL))
				.save(consumer, EDLoc("keg"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraDelightItems.FUNNEL.get(), 1).pattern("c c").pattern("ckc")
				.pattern(" c ").define('k', ExtraDelightItems.KEG.get()).define('c', Items.COPPER_INGOT)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.KEG.get()))
				.save(consumer, EDLoc("funnel"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_PLANKS.get(), 4)
				.requires(ExtraDelightItems.FRUIT_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_LOG.get()))
				.save(consumer, EDLoc("fruit_planks"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_WOOD.get(), 3).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.FRUIT_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_LOG.get()))
				.save(consumer, EDLoc("fruit_wood"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.STRIPPED_FRUIT_WOOD.get(), 3).pattern("ff ")
				.pattern("ff ").define('f', ExtraDelightItems.STRIPPED_FRUIT_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STRIPPED_FRUIT_LOG.get()))
				.save(consumer, EDLoc("stripped_fruit_wood"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_PLANKS.get(), 4)
				.requires(ExtraDelightItems.STRIPPED_FRUIT_LOG.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_LOG.get()))
				.save(consumer, EDLoc("fruit_planks_stripped"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_CABINET.get()).pattern("sss")
				.pattern("t t").pattern("sss").define('s', ExtraDelightItems.FRUIT_SLAB.get())
				.define('t', ExtraDelightItems.FRUIT_TRAPDOOR.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_SLAB.get()))
				.save(consumer, EDLoc("fruit_cabinet"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_SLAB.get(), 6).pattern("ppp")
				.define('p', ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_DOOR.get(), 3).pattern("pp ")
				.pattern("pp ").pattern("pp ").define('p', ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_TRAPDOOR.get(), 2).pattern("pp ")
				.pattern("pp ").define('p', ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_FENCE.get(), 3).pattern("psp")
				.pattern("psp").define('p', ExtraDelightItems.FRUIT_PLANKS.get()).define('s', Items.STICK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_FENCE_GATE.get()).pattern("sps")
				.pattern("sps").define('p', ExtraDelightItems.FRUIT_PLANKS.get()).define('s', Items.STICK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_STAIRS.get(), 4).pattern("p  ")
				.pattern("pp ").pattern("ppp").define('p', ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_PRESSURE_PLATE.get(), 1).pattern("pp")
				.define('p', ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_pressure_plate"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FRUIT_BUTTON.get(), 1)
				.requires(ExtraDelightItems.FRUIT_PLANKS.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_PLANKS.get()))
				.save(consumer, EDLoc("fruit_button"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CHILI_SEEDS.get(), 1)
				.requires(ExtraDelightItems.CHILI.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHILI.get()))
				.save(consumer, EDLoc("chili_seeds"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.MELTING_POT.get(), 1)
				.requires(ModItems.COOKING_POT.get(), 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHILI.get()))
				.save(consumer, EDLoc("melting_pot"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.CHILLER.get(), 1).pattern("i").pattern("c")
				.pattern("k").define('c', ModTags.CABINETS).define('i', Items.IRON_BLOCK)
				.define('k', ExtraDelightItems.KEG)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.KEG.get()))
				.save(consumer, EDLoc("chiller"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SQUARE_PAN.get(), 1)
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).requires(Items.IRON_NUGGET, 4)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("square_pan"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SERVING_POT.get(), 1)
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).requires(Items.IRON_NUGGET, 5)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("serving_pot"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BAR_MOLD.get(), 1)
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).requires(Items.IRON_NUGGET, 7)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer, EDLoc("bar_mold"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_WHITE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.WHITE.getId())))
				.save(consumer, EDLoc("white_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BLACK_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_BLACK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.BLACK.getId())))
				.save(consumer, EDLoc("black_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BLUE_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_BLUE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.BLUE.getId())))
				.save(consumer, EDLoc("blue_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BROWN_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_BROWN)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.BROWN.getId())))
				.save(consumer, EDLoc("brown_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CYAN_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_CYAN)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.CYAN.getId())))
				.save(consumer, EDLoc("cyan_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GRAY_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_GRAY)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.GRAY.getId())))
				.save(consumer, EDLoc("gray_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GREEN_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_GREEN)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.GREEN.getId())))
				.save(consumer, EDLoc("green_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.LIGHT_BLUE_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_LIGHT_BLUE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.LIGHT_BLUE.getId())))
				.save(consumer, EDLoc("light_blue_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.LIGHT_GRAY_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_LIGHT_GRAY)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.LIGHT_GRAY.getId())))
				.save(consumer, EDLoc("light_gray_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.LIME_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_LIME)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.LIME.getId())))
				.save(consumer, EDLoc("lime_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.MAGENTA_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_MAGENTA)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.MAGENTA.getId())))
				.save(consumer, EDLoc("magenta_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.ORANGE_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_ORANGE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.ORANGE.getId())))
				.save(consumer, EDLoc("orange_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.PINK_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_PINK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.PINK.getId())))
				.save(consumer, EDLoc("pink_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.PURPLE_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_PURPLE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.PURPLE.getId())))
				.save(consumer, EDLoc("purple_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.RED_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_RED)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.RED.getId())))
				.save(consumer, EDLoc("red_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.YELLOW_CHOCOLATE_BOX.get(), 1)
				.requires(ExtraDelightTags.RIBBON).requires(Items.PAPER).requires(Tags.Items.CHESTS)
				.requires(Tags.Items.DYES_YELLOW)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(AestheticBlocks.BOW_ITEMS.get(DyeColor.YELLOW.getId())))
				.save(consumer, EDLoc("yellow_chocolate_box"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_BLOCK.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.MILK_CHOCOLATE_BAR), 9)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BAR))
				.save(consumer, EDLoc("milk_chocolate_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_FENCE.get(), 3).pattern("bsb")
				.pattern("bsb").define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.define('s', ExtraDelightTags.MILK_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_FENCE_GATE.get(), 3)
				.pattern("bsb").pattern("bsb").define('s', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.define('b', ExtraDelightTags.MILK_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_STAIRS.get(), 4).pattern("b  ")
				.pattern("bb ").pattern("bbb").define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_DOOR.get(), 3).pattern("bb")
				.pattern("bb").pattern("bb").define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_TRAPDOOR.get(), 2)
				.pattern("bbb").pattern("bbb").define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_SLAB.get(), 6).pattern("bbb")
				.define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.MILK_CHOCOLATE_PILLAR.get(), 3).pattern("b")
				.pattern("b").pattern("b").define('b', ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("milk_chocolate_pillar"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.BLOOD_CHOCOLATE_BAR), 9)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BAR))
				.save(consumer, EDLoc("blood_chocolate_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_FENCE.get(), 3).pattern("bsb")
				.pattern("bsb").define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.define('s', ExtraDelightTags.BLOOD_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_FENCE_GATE.get(), 3)
				.pattern("bsb").pattern("bsb").define('s', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_STAIRS.get(), 4)
				.pattern("b  ").pattern("bb ").pattern("bbb").define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_DOOR.get(), 3).pattern("bb")
				.pattern("bb").pattern("bb").define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_TRAPDOOR.get(), 2)
				.pattern("bbb").pattern("bbb").define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_SLAB.get(), 6).pattern("bbb")
				.define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.BLOOD_CHOCOLATE_PILLAR.get(), 3).pattern("b")
				.pattern("b").pattern("b").define('b', ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("blood_chocolate_pillar"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_BLOCK.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.WHITE_CHOCOLATE_BAR), 9)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BAR))
				.save(consumer, EDLoc("white_chocolate_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_FENCE.get(), 3).pattern("bsb")
				.pattern("bsb").define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.define('s', ExtraDelightTags.WHITE_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_FENCE_GATE.get(), 3)
				.pattern("bsb").pattern("bsb").define('s', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.define('b', ExtraDelightTags.WHITE_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_STAIRS.get(), 4)
				.pattern("b  ").pattern("bb ").pattern("bbb").define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_DOOR.get(), 3).pattern("bb")
				.pattern("bb").pattern("bb").define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_TRAPDOOR.get(), 2)
				.pattern("bbb").pattern("bbb").define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_SLAB.get(), 6).pattern("bbb")
				.define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.WHITE_CHOCOLATE_PILLAR.get(), 3).pattern("b")
				.pattern("b").pattern("b").define('b', ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("white_chocolate_pillar"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_BLOCK.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.DARK_CHOCOLATE_BAR), 9)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BAR))
				.save(consumer, EDLoc("dark_chocolate_block"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_FENCE.get(), 3).pattern("bsb")
				.pattern("bsb").define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.define('s', ExtraDelightTags.DARK_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_fence"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_FENCE_GATE.get(), 3)
				.pattern("bsb").pattern("bsb").define('s', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.define('b', ExtraDelightTags.DARK_CHOCOLATE_BAR)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_fence_gate"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_STAIRS.get(), 4).pattern("b  ")
				.pattern("bb ").pattern("bbb").define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_stairs"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_DOOR.get(), 3).pattern("bb")
				.pattern("bb").pattern("bb").define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_door"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_TRAPDOOR.get(), 2)
				.pattern("bbb").pattern("bbb").define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_trapdoor"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_SLAB.get(), 6).pattern("bbb")
				.define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_slab"));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ExtraDelightItems.DARK_CHOCOLATE_PILLAR.get(), 3).pattern("b")
				.pattern("b").pattern("b").define('b', ExtraDelightTags.DARK_CHOCOLATE_BLOCK)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BLOCK))
				.save(consumer, EDLoc("dark_chocolate_pillar"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.XOCOLATL.get(), 1)
				.requires(ModItems.HOT_COCOA.get()).requires(ExtraDelightTags.CHILI_POWDER)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HOT_COCOA.get()))
				.save(consumer, EDLoc("xocolatl_crafted"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.GOURMET_HOT_CHOCOLATE.get(), 1)
				.requires(ModItems.HOT_COCOA.get()).requires(ExtraDelightTags.WHIPPED_CREAM)
				.requires(ExtraDelightTags.COOKIE).requires(ExtraDelightTags.GROUND_CINNAMON)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HOT_COCOA.get()))
				.save(consumer, EDLoc("gourmet_hot_chocolate"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.SMORE.get(), 1)
				.requires(ExtraDelightTags.GRAHAM_CRACKER).requires(ExtraDelightTags.CHOCOLATE_BAR)
				.requires(ExtraDelightTags.MARSHMALLOW)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MARSHMALLOW.get()))
				.save(consumer, EDLoc("smore"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.DIRT_CAKE.get(), 1)
				.requires(ExtraDelightTags.COOKIE).requires(ExtraDelightItems.CHOCOLATE_CUSTARD)
				.requires(ExtraDelightTags.GUMMIES)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_CUSTARD.get()))
				.save(consumer, EDLoc("dirt_cake"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.TRAIL_MIX.get(), 3)
				.requires(ExtraDelightTags.CHOCOLATE_CHIPS).requires(ExtraDelightTags.DRIED_FRUIT)
				.requires(ExtraDelightTags.ROASTED_NUTS)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUTS.get()))
				.save(consumer, EDLoc("trail_mix"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.FLUFFER_NUTTER.get(), 1)
				.requires(ExtraDelightTags.BREAD_SLICE).requires(ExtraDelightTags.PEANUT_BUTTER)
				.requires(ExtraDelightTags.MARSHMALLOW_FLUFF).requires(ExtraDelightTags.BREAD_SLICE)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.MARSHMALLOW_FLUFF_BOTTLE.get()))
				.save(consumer, EDLoc("fluffer_nutter"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CRISP_RICE_CEREAL.get(), 1)
				.requires(ExtraDelightTags.PUFFED_RICE).requires(CommonTags.FOODS_MILK).requires(Items.BOWL)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CRISP_RICE.get()))
				.save(consumer, EDLoc("crisp_rice_cereal"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.CORN_FLAKES_CEREAL.get(), 1)
				.requires(ExtraDelightTags.CORN_FLAKES).requires(CommonTags.FOODS_MILK).requires(Items.BOWL)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_FLAKES.get()))
				.save(consumer, EDLoc("corn_flakes_cereal"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ExtraDelightItems.PEANUT_BUTTER_JELLY.get(), 1)
				.requires(ExtraDelightTags.BREAD_SLICE).requires(ExtraDelightTags.PEANUT_BUTTER)
				.requires(ExtraDelightTags.JAM).requires(ExtraDelightTags.BREAD_SLICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JAM.get()))
				.save(consumer, EDLoc("pbj"));
	}

	private void bucket(String name, RecipeOutput consumer, ItemLike fullBucket, ItemLike emptyItem,
			ItemLike fullItem) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, fullBucket, 1).requires(fullItem, 4)
				.requires(Items.BUCKET, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(fullItem))
				.save(consumer, EDLoc(name + "_to_bucket"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, fullItem, 4).requires(fullBucket, 1)
				.requires(emptyItem, 4).unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(fullItem))
				.save(consumer, EDLoc(name + "_from_bucket"));
	}

	private void bundleItem9(Ingredient in, Item b, Item out, RecipeOutput consumer, String name) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, b, 1).requires(in, 9).unlockedBy(getName(), has(out))
				.save(consumer, EDLoc(name + "_to_block"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, out, 9).requires(b).unlockedBy(getName(), has(b))
				.save(consumer, EDLoc(name + "_from_block"));
	}

	private void bundleItem4(Ingredient in, Item b, Item out, RecipeOutput consumer, String name) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, b, 1).pattern("xx").pattern("xx").define('x', in)
				.unlockedBy(getName(), has(out)).save(consumer, EDLoc(name + "_to_block"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, out, 4).requires(b).unlockedBy(getName(), has(b))
				.save(consumer, EDLoc(name + "_from_block"));
	}

	private void potRecipes(RecipeOutput consumer) {

		pot(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(Items.COCOA_BEANS), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(Tags.Items.EGGS), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"chocolate_custard", consumer);

		pot(ExtraDelightItems.PUMPKIN_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ModItems.PUMPKIN_SLICE.get()), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(Tags.Items.EGGS), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"pumpkin_custard", consumer);

		pot(ExtraDelightItems.HONEY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(Tags.Items.EGGS), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"honey_custard", consumer);

		pot(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(Tags.Items.EGGS), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"sweet_berry_custard", consumer);

		pot(ExtraDelightItems.APPLE_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"apple_custard", consumer);

		pot(ExtraDelightItems.KETCHUP.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_TOMATO), Ingredient.of(CommonTags.FOODS_TOMATO),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.VINEGAR) },
				"ketchup_jar", consumer);

		pot(ExtraDelightItems.BBQ_SAUCE.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_TOMATO), Ingredient.of(CommonTags.FOODS_ONION),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.VINEGAR) },
				"bbq_sugar", consumer);

		pot(ModItems.BONE_BROTH.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.MAKES_STOCK), Ingredient.of(Items.BONE) }, "stock",
				consumer);

		pot(ExtraDelightItems.GRAVY.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ModItems.BONE_BROTH.get()) },
				"gravy_boat", consumer);

		pot(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ModItems.MINCED_BEEF.get()), Ingredient.of(ModItems.MINCED_BEEF.get()),
						Ingredient.of(ModItems.MINCED_BEEF.get()), Ingredient.of(CommonTags.FOODS_ONION),
						Ingredient.of(Tags.Items.MUSHROOMS), Ingredient.of(ExtraDelightItems.GRAVY.get()) },
				"salisbury_steak_feast", consumer);

		pot(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Items.POTATO), Ingredient.of(Items.POTATO),
						Ingredient.of(Items.POTATO), Ingredient.of(ExtraDelightItems.GRAVY.get()),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(CommonTags.FOODS_MILK) },
				"mashed_potato_gravy_feast", consumer);

		pot(ExtraDelightItems.FRENCH_FRIES.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(ExtraDelightItems.POTATO_STICKS.get()), Ingredient.of(ExtraDelightTags.FRYING_OIL) },
				"fries", consumer);

		pot(ExtraDelightItems.POTATO_CHIPS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(ExtraDelightItems.SLICED_POTATO.get()), Ingredient.of(ExtraDelightTags.FRYING_OIL) },
				"chips", consumer);

		pot(ExtraDelightItems.CHEESE.get(), 2, CookingRecipes.SLOW_COOKING, 1.0F, null,
				new Ingredient[] { Ingredient.of(Items.MILK_BUCKET), Ingredient.of(ExtraDelightTags.VINEGAR) },
				"cheese_vinegar", consumer);

		pot(ExtraDelightItems.RABBIT_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Items.RABBIT), Ingredient.of(Items.CARROT),
						Ingredient.of(Items.POTATO), Ingredient.of(CommonTags.CROPS_ONION),
						Ingredient.of(ModItems.BONE_BROTH.get()), Ingredient.of(ExtraDelightTags.FLOUR) },
				"rabbit_stew", consumer);

		pot(ExtraDelightItems.CHICKEN_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Items.CHICKEN), Ingredient.of(Items.CARROT),
						Ingredient.of(Items.POTATO), Ingredient.of(CommonTags.CROPS_ONION),
						Ingredient.of(ModItems.BONE_BROTH.get()), Ingredient.of(ExtraDelightTags.FLOUR) },
				"chicken_stew", consumer);

		pot(ExtraDelightItems.FISH_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_SAFE_RAW_FISH), Ingredient.of(Items.CARROT),
						Ingredient.of(Items.POTATO), Ingredient.of(CommonTags.CROPS_ONION),
						Ingredient.of(ModItems.BONE_BROTH.get()), Ingredient.of(ExtraDelightTags.FLOUR) },
				"fish_stew", consumer);

		pot(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.MEAT_RAW), Ingredient.of(ExtraDelightTags.MEAT_RAW),
						Ingredient.of(Tags.Items.FOODS_VEGETABLE), Ingredient.of(Tags.Items.FOODS_VEGETABLE),
						Ingredient.of(Tags.Items.FOODS_VEGETABLE), Ingredient.of(Tags.Items.FOODS_VEGETABLE) },
				"stirfry_feast", consumer);

		pot(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_BLACK), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"black_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_RED_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_RED), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"red_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_GREEN), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"green_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_BROWN), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"brown_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_BLUE), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"blue_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_PURPLE), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"purple_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_CYAN), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"cyan_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_LIGHT_GRAY), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"light_grey_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_GRAY), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"grey_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_PINK), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"pink_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_LIME), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"lime_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_YELLOW), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"yellow_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_LIGHT_BLUE), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"light_blue_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_MAGENTA), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"magenta_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_ORANGE), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"orange_jelly_feast", consumer);

		pot(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.DYES_WHITE), Ingredient.of(ExtraDelightTags.GELATIN),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Items.SWEET_BERRIES),
						Ingredient.of(ExtraDelightItems.WHIPPED_CREAM) },
				"white_jelly_feast", consumer);

		pot(ExtraDelightItems.FRIED_FISH.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(ItemTags.FISHES), Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"fried_fish", consumer);

		pot(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(Items.BEEF), Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()),
						Ingredient.of(ExtraDelightItems.GRAVY.get()) },
				"chicken_fried_steak", consumer);

		pot(ExtraDelightItems.PORK_TENDERLOIN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(Items.PORKCHOP), Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"pork_tenderloin", consumer);

		pot(ExtraDelightItems.FRIED_CHICKEN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(ModItems.CHICKEN_CUTS.get()), Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"fried_chicken", consumer);

		pot(ExtraDelightItems.CARROT_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.CROPS_CARROT), Ingredient.of(Tags.Items.CROPS_CARROT),
						Ingredient.of(CommonTags.CROPS_ONION), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(CommonTags.FOODS_MILK) },
				"carrot_soup", consumer);

		pot(ExtraDelightItems.FISH_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ItemTags.FISHES), Ingredient.of(ItemTags.FISHES),
						Ingredient.of(CommonTags.CROPS_ONION), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(Items.DRIED_KELP) },
				"fish_soup", consumer);

		pot(ExtraDelightItems.POTATO_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.CROPS_POTATO), Ingredient.of(Tags.Items.CROPS_POTATO),
						Ingredient.of(CommonTags.CROPS_ONION), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(CommonTags.FOODS_MILK) },
				"potato_soup", consumer);

		pot(ExtraDelightItems.TOMATO_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(CommonTags.CROPS_TOMATO), Ingredient.of(CommonTags.CROPS_TOMATO),
						Ingredient.of(CommonTags.CROPS_ONION), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(CommonTags.FOODS_MILK) },
				"tomato_soup", consumer);

		pot(ExtraDelightItems.BOILED_EGG.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(Tags.Items.EGGS) }, "boiled_egg", consumer);

		pot(ExtraDelightItems.GLOW_BERRY_JAM.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(Items.GLOW_BERRIES),
						Ingredient.of(Items.GLOW_BERRIES), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"glow_berry_jam", consumer);

		pot(ExtraDelightItems.GOLDEN_APPLE_JAM.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(Items.GOLDEN_APPLE), Ingredient.of(Items.GOLDEN_APPLE),
						Ingredient.of(Items.GOLDEN_APPLE), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"golden_apple_jam", consumer);

		pot(ExtraDelightItems.JAM.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] {
						DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),
								Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)),
						DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),
								Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)),
						DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),
								Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"fruit_jam", consumer);

		pot(ExtraDelightItems.SEAWEED_PASTE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, null, new Ingredient[] {
				Ingredient.of(Items.DRIED_KELP), Ingredient.of(Items.DRIED_KELP), Ingredient.of(Items.DRIED_KELP) },
				"seaweed_paste", consumer);

		pot(ExtraDelightItems.GLAZED_CARROT.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Items.CARROT), Ingredient.of(Items.CARROT),
						Ingredient.of(Items.CARROT), Ingredient.of(ExtraDelightItems.BUTTER.get()),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"glazed_carrot", consumer);

		pot(ExtraDelightItems.APPLE_SAUCE.get(), 4, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"apple_sauce", consumer);

		pot(ExtraDelightItems.HASH_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()),
						Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()), Ingredient.of(CommonTags.CROPS_ONION),
						Ingredient.of(ExtraDelightTags.FRYING_OIL), Ingredient.of(ExtraDelightTags.MEAT) },
				"hash", consumer);

		pot(ExtraDelightItems.SEAWEED_CRISPS.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(Items.DRIED_KELP), Ingredient.of(Items.DRIED_KELP),
						Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.FRYING_OIL) },
				"seaweed_crisps", consumer);

		pot(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.MACARONI.get()),
						Ingredient.of(ExtraDelightItems.MACARONI.get()), Ingredient.of(ExtraDelightTags.BUTTER),
						Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightTags.CHEESE) },
				"macaroni_cheese", consumer);

		pot(ExtraDelightItems.FISH_CAKES.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(Tags.Items.FOODS_COOKED_FISH), Ingredient.of(CommonTags.CROPS_ONION),
						Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()),
						Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"fish_cakes", consumer);

		pot(ExtraDelightItems.FRIED_MUSHROOMS.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(Tags.Items.MUSHROOMS), Ingredient.of(Tags.Items.MUSHROOMS),
						Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"fried_mushrooms", consumer);

		pot(ExtraDelightItems.MUSHROOM_RISOTTO.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(Tags.Items.MUSHROOMS), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(ExtraDelightTags.PROCESSED_ONION) },
				"mushroom_risotto", consumer);

		pot(ExtraDelightItems.CURRY_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_RAW_CHICKEN),
						Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(CommonTags.CROPS_ONION) },
				"curry", consumer);

		pot(ExtraDelightItems.ALFREDO_SAUCE.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightTags.BUTTER) },
				"alfredo_sauce", consumer);

		pot(ExtraDelightItems.COOKED_PASTA.get(), 1, CookingRecipes.FAST_COOKING, 0.15F, Items.BOWL,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_PASTA) }, "cooked_pasta", consumer);

		pot(ExtraDelightItems.CACTUS_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()),
						Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()),
						Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(ModItems.BONE_BROTH.get()) },
				"cactus_soup", consumer);

		pot(ExtraDelightItems.STUFFED_CACTUS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()),
						Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()) },
				"stuffed_cactus", consumer);

		// Halloween Start!

		pot(ExtraDelightItems.CARAMEL_SAUCE.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.BUTTER),
						Ingredient.of(CommonTags.FOODS_MILK) },
				"caramel_sauce", consumer);

		pot(ExtraDelightItems.CARAMEL_CANDY.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()) }, "caramel_candy", consumer);

		pot(ExtraDelightItems.CANDY_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.APPLE), Ingredient.of(ExtraDelightTags.CANDY),
						Ingredient.of(ExtraDelightTags.CANDY) },
				"candy_apple", consumer);

		pot(ExtraDelightItems.CANDY_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.APPLE), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"candy_apple_sugar", consumer);

		pot(ExtraDelightItems.CARAMEL_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.APPLE), Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()) },
				"caramel_apple", consumer);

		pot(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.GOLDEN_APPLE), Ingredient.of(ExtraDelightTags.CANDY),
						Ingredient.of(ExtraDelightTags.CANDY) },
				"candy_golden_apple", consumer);

		pot(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.GOLDEN_APPLE), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"candy_golden_apple_sugar", consumer);

		pot(ExtraDelightItems.CARAMEL_GOLDEN_APPLE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.STICK,
				new Ingredient[] { Ingredient.of(Items.GOLDEN_APPLE),
						Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()) },
				"caramel_golden_apple", consumer);

		pot(ExtraDelightItems.CORN_CHOWDER.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_CORN.get()),
						Ingredient.of(ExtraDelightTags.PROCESSED_POTATO),
						CompoundIngredient.of(Ingredient.of(CommonTags.FOODS_COOKED_BACON),
								Ingredient.of(CommonTags.FOODS_RAW_BACON)),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(ModItems.BONE_BROTH.get()) },
				"corn_chowder", consumer);

		pot(ExtraDelightItems.CREAM_CORN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_CORN.get()),
						Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.BUTTER) },
				"cream_corn", consumer);

		pot(ExtraDelightItems.CORN_FRITTERS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.COOKED_CORN.get()),
						Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightItems.EGG_MIX.get()), Ingredient.of(ExtraDelightTags.FRYING_OIL),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION) },
				"corn_fritters", consumer);

		pot(ExtraDelightItems.COOKED_CORN.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.CORN_SEEDS.get()) }, "corn", consumer);

		pot(ExtraDelightItems.STEWED_APPLES.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SLICED_APPLE),
						Ingredient.of(ExtraDelightTags.SLICED_APPLE), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER) },
				"stewed_apples", consumer);

		pot(ExtraDelightItems.APPLE_FRITTERS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.FLOUR), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightItems.EGG_MIX.get()), Ingredient.of(ExtraDelightTags.FRYING_OIL),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"apple_fritters", consumer);

		pot(ExtraDelightItems.CARAMEL_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()),
						Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(Tags.Items.EGGS),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"caramel_custard", consumer);

		pot(ExtraDelightItems.STUFFING_FEAST.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.CROUTONS.get()),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(ModItems.BONE_BROTH.get()),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(Tags.Items.EGGS) },
				"stuffing", consumer);

		// Holiday

		pot(ExtraDelightItems.EGGNOG.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ModItems.MILK_BOTTLE.get()),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON), Ingredient.of(Items.EGG),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.EGGS) },
				"eggnog", consumer);

		pot(ExtraDelightItems.CANDY_BLACK.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_BLACK) },
				"candy_black", consumer);

		pot(ExtraDelightItems.CANDY_BLUE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_BLUE) },
				"candy_blue", consumer);

		pot(ExtraDelightItems.CANDY_BROWN.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_BROWN) },
				"candy_brown", consumer);

		pot(ExtraDelightItems.CANDY_CYAN.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_CYAN) },
				"candy_cyan", consumer);

		pot(ExtraDelightItems.CANDY_GRAY.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_GRAY) },
				"candy_gray", consumer);

		pot(ExtraDelightItems.CANDY_GREEN.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_GREEN) },
				"candy_green", consumer);

		pot(ExtraDelightItems.CANDY_LIGHT_BLUE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_LIGHT_BLUE) },
				"candy_light_blue", consumer);

		pot(ExtraDelightItems.CANDY_LIGHT_GRAY.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Tags.Items.DYES_LIGHT_GRAY) },
				"candy_light_gray", consumer);

		pot(ExtraDelightItems.CANDY_LIME.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_LIME) },
				"candy_lime", consumer);

		pot(ExtraDelightItems.CANDY_MAGENTA.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_MAGENTA) },
				"candy_magenta", consumer);

		pot(ExtraDelightItems.CANDY_ORANGE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_ORANGE) },
				"candy_orange", consumer);

		pot(ExtraDelightItems.CANDY_PINK.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_PINK) },
				"candy_pink", consumer);

		pot(ExtraDelightItems.CANDY_PURPLE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_PURPLE) },
				"candy_purple", consumer);

		pot(ExtraDelightItems.CANDY_RED.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_RED) },
				"candy_red", consumer);

		pot(ExtraDelightItems.CANDY_WHITE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_WHITE) },
				"candy_white", consumer);

		pot(ExtraDelightItems.CANDY_YELLOW.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_YELLOW) },
				"candy_yellow", consumer);

		pot(ExtraDelightItems.GINGER_BEER.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_GINGER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightItems.YEAST.get()) },
				"ginger_beer", consumer);

		pot(ExtraDelightItems.HORCHATA.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON), Ingredient.of(CommonTags.FOODS_MILK) },
				"horchata", consumer);

		pot(ExtraDelightItems.MINT_CANDY_BLUE.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_BLUE),
						Ingredient.of(ExtraDelightTags.MINT) },
				"mint_candy_blue", consumer);

		pot(ExtraDelightItems.MINT_CANDY_GREEN.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_GREEN),
						Ingredient.of(ExtraDelightTags.MINT) },
				"mint_candy_green", consumer);

		pot(ExtraDelightItems.MINT_CANDY_RED.get(), 4, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(Tags.Items.DYES_RED),
						Ingredient.of(ExtraDelightTags.MINT) },
				"mint_candy_red", consumer);

		pot(ExtraDelightItems.CONGEE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL, new Ingredient[] {
				Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(ExtraDelightTags.PROCESSED_GINGER) }, "congee",
				consumer);

		pot(ExtraDelightItems.LUGAW.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL, new Ingredient[] {
				Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(ExtraDelightTags.PROCESSED_GINGER),
				Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(ModItems.BONE_BROTH.get()),
				Ingredient.of(ExtraDelightItems.BOILED_EGG.get()), Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN) },
				"lugaw", consumer);

		pot(ExtraDelightItems.RICE_PUDDING.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(CommonTags.CROPS_RICE),
						Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.GROUND_CINNAMON) },
				"rice_pudding", consumer);

		pot(ExtraDelightItems.PICKLED_GINGER.get(), 4, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SLICED_GINGER),
						Ingredient.of(ExtraDelightTags.VINEGAR), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"pickled_ginger", consumer);

		pot(ExtraDelightItems.CANDIED_GINGER.get(), 4, CookingRecipes.NORMAL_COOKING, 0.35F, Items.PAPER,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_GINGER),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"candied_ginger", consumer);

		pot(ExtraDelightItems.MINT_JELLY.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.MINT), Ingredient.of(ExtraDelightTags.MINT),
						Ingredient.of(ExtraDelightTags.MINT), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"mint_jelly", consumer);

		pot(ExtraDelightItems.XOCOLATL.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP), Ingredient.of(ExtraDelightTags.CHILI_POWDER) },
				"xocolatl", consumer);

		pot(ModItems.HOT_COCOA.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP) },
				"hot_cocoa", consumer);

		pot(ExtraDelightItems.XOCOLATL.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(CommonTags.FOODS_MILK), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.COCOA_BEANS),
						Ingredient.of(ExtraDelightTags.CHILI_POWDER) },
				"xocolatl_beans", consumer);

		pot(ExtraDelightItems.PEANUT_BRITTLE.get(), 4, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(ExtraDelightTags.ROASTED_NUTS) },
				"peanut_brittle", consumer);

		pot(ExtraDelightItems.BUTTERSCOTCH.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.BUTTER) },
				"butterscotch", consumer);

		pot(ExtraDelightItems.COFFEE.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.GROUND_COFFEE_BEANS) }, "coffee", consumer);

		pot(ExtraDelightItems.CRISP_RICE.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, null,
				new Ingredient[] { Ingredient.of(CommonTags.CROPS_RICE), Ingredient.of(ExtraDelightTags.COOKING_OIL) },
				"crisp_rice", consumer);
	}

	private void knifeRecipes(RecipeOutput consumer) {
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.TOOLS_KNIFE), Items.WHEAT_SEEDS, 2)
				.addResult(ModItems.STRAW.get()).build(consumer, EDLoc("cutting/" + "wheat_seeds"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.SUNFLOWER), Ingredient.of(CommonTags.TOOLS_KNIFE),
						ExtraDelightItems.SUNFLOWER_SEEDS.get(), 2)
				.addResult(Items.YELLOW_DYE, 2).build(consumer, EDLoc("cutting/" + "sunflower_seeds"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.APPLE), Ingredient.of(CommonTags.TOOLS_KNIFE),
				ExtraDelightItems.SLICED_APPLE.get(), 1).build(consumer, EDLoc("cutting/" + "cut_apples"));

		// Grate
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_POTATO),
				Ingredient.of(ExtraDelightItems.GRATER.get()), ExtraDelightItems.GRATED_POTATO.get(), 4)
				.build(consumer, EDLoc("cutting/" + "grate_potato"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_CARROT),
				Ingredient.of(ExtraDelightItems.GRATER.get()), ExtraDelightItems.GRATED_CARROT.get(), 4)
				.build(consumer, EDLoc("cutting/" + "grate_carrot"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Tags.Items.FOODS_BREAD),
				Ingredient.of(ExtraDelightItems.GRATER.get()), ExtraDelightItems.BREAD_CRUMBS.get(), 4)
				.build(consumer, EDLoc("cutting/" + "grate_bread"));

		// Potato
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_POTATO),
				Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.SLICED_POTATO.get(), 4)
				.build(consumer, EDLoc("cutting/" + "sliced_potato"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.SLICED_POTATO.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.POTATO_STICKS.get(), 1)
				.build(consumer, EDLoc("cutting/" + "stick_potato"));

		// Pies
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "glow_berry_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.MEAT_PIE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "meat_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "sweet_berry_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "chocolate_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "glow_berry_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "honey_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "pumpkin_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.APPLE_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.APPLE_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "apple_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "cheesecake_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.QUICHE.get()),
				Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.QUICHE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "quiche_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BREAD), Ingredient.of(CommonTags.TOOLS_KNIFE),
				ExtraDelightItems.BREAD_SLICE.get(), 4).build(consumer, EDLoc("cutting/" + "bread_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightTags.BREAD_SLICE),
				Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.CROUTONS.get(), 4)
				.build(consumer, EDLoc("cutting/" + "croutons_knife"));

		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CommonTags.CROPS_ONION),
				Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.SLICED_ONION.get(), 4)
				.build(consumer, EDLoc("cutting/" + "sliced_onion"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CommonTags.CROPS_TOMATO),
				Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.SLICED_TOMATO.get(), 4)
				.build(consumer, EDLoc("cutting/" + "sliced_tomato"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.CACTUS), Ingredient.of(CommonTags.TOOLS_KNIFE),
				ExtraDelightItems.CACTUS.get(), 2).build(consumer, EDLoc("cutting/" + "sliced_cactus"));

		// Halloween Start
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "caramel_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PUMPKIN_PIE_ITEM.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.PUMPKIN_PIE_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "pumpkin_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PUMPKIN_ROLL_FEAST.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.PUMPKIN_ROLL.get(), 4)
				.build(consumer, EDLoc("cutting/" + "pumpkin_roll_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CORN_ON_COB.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.CORN_SEEDS.get(), 1)
				.addResult(ExtraDelightItems.CORN_COB.get(), 1)
				.addResultWithChance(ExtraDelightItems.CORN_SEEDS.get(), 0.75f, 1)
				.build(consumer, EDLoc("cutting/" + "corn_seeds_knife"));
//		CuttingBoardRecipeBuilder
//				.cuttingRecipe(Ingredient.of(ExtraDelightItems.UNSHUCKED_CORN.get()),
//						Ingredient.of(CommonTags.TOOLS_KNIVES), ExtraDelightItems.CORN_ON_COB.get(), 1)
//				.addResult(ExtraDelightItems.CORN_HUSK.get(), 2).addResult(ExtraDelightItems.CORN_SILK.get(), 1)
//				.addResultWithChance(ExtraDelightItems.CORN_HUSK.get(), 0.75f, 1)
//				.build(consumer, EDLoc("cutting/" + "corn_shuck_knife"));

		// Holidays
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CINNAMON_BARK.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.RAW_CINNAMON.get(), 2)
				.addResultWithChance(ExtraDelightItems.RAW_CINNAMON.get(), 0.75f, 1)
				.addResultWithChance(ModItems.TREE_BARK.get(), 0.75f, 1)
				.build(consumer, EDLoc("cutting/" + "cinnamon_bark_knife"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GINGER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						ExtraDelightItems.GINGER_CUTTING.get(), 1)
				.addResultWithChance(ExtraDelightItems.GINGER_CUTTING.get(), 0.75f, 1)
				.build(consumer, EDLoc("cutting/" + "ginger_cutting_knife"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GINGER.get()), Ingredient.of(ExtraDelightTags.SPOONS),
						ExtraDelightItems.PEELED_GINGER.get(), 1)
				.addResultWithChance(ExtraDelightItems.GINGER_CUTTING.get(), 0.25f, 1)
				.build(consumer, EDLoc("cutting/" + "spoon_ginger"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PEELED_GINGER.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.SLICED_GINGER.get(), 4)
				.build(consumer, EDLoc("cutting/" + "sliced_ginger_knife"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PEELED_GINGER.get()),
						Ingredient.of(ExtraDelightItems.GRATER.get()), ExtraDelightItems.GRATED_GINGER.get(), 4)
				.build(consumer, EDLoc("cutting/" + "grated_ginger"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.COFFEE_CAKE_FEAST.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.COFFEE_CAKE_SLICE.get(), 8)
				.build(consumer, EDLoc("cutting/" + "coffee_cake_knife"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.MILK_TART_FEAST.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.MILK_TART_SLICE.get(), 4)
				.build(consumer, EDLoc("cutting/" + "milk_tart_knife"));

		// Wood and Salvaging
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CINNAMON_LOG.get()),
						new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(),
						ExtraDelightItems.STRIPPED_CINNAMON_LOG.get())
				.addResult(ExtraDelightItems.CINNAMON_BARK.get()).addSound(SoundEvents.AXE_STRIP)
				.build(consumer, EDLoc("cutting/" + "strip_cinnamon_log"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CINNAMON_WOOD.get()),
						new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(),
						ExtraDelightItems.STRIPPED_CINNAMON_WOOD.get())
				.addResult(ExtraDelightItems.CINNAMON_BARK.get()).addSound(SoundEvents.AXE_STRIP)
				.build(consumer, EDLoc("cutting/" + "strip_cinnamon_wood"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.CINNAMON_DOOR.get()),
				new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), ExtraDelightItems.CINNAMON_PLANKS.get())
				.build(consumer, EDLoc("cutting/" + "cinnamon_door_to_plank"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.CINNAMON_TRAPDOOR.get()),
				new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), ExtraDelightItems.CINNAMON_PLANKS.get())
				.build(consumer, EDLoc("cutting/" + "cinnamon_trapdoor_to_plank"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.FRUIT_LOG.get()),
						new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(),
						ExtraDelightItems.STRIPPED_FRUIT_LOG.get())
				.addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP)
				.build(consumer, EDLoc("cutting/" + "strip_fruit_log"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.FRUIT_WOOD.get()),
						new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(),
						ExtraDelightItems.STRIPPED_FRUIT_WOOD.get())
				.addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP)
				.build(consumer, EDLoc("cutting/" + "strip_fruit_wood"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.FRUIT_DOOR.get()),
				new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), ExtraDelightItems.FRUIT_PLANKS.get())
				.build(consumer, EDLoc("cutting/" + "fruit_door_to_plank"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.FRUIT_TRAPDOOR.get()),
				new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), ExtraDelightItems.FRUIT_PLANKS.get())
				.build(consumer, EDLoc("cutting/" + "fruit_trapdoor_to_plank"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.BLOOD_CHOCOLATE_DOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "blood_chocolate_door_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.BLOOD_CHOCOLATE_TRAPDOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "blood_chocolate_trapdoor_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.DARK_CHOCOLATE_DOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.DARK_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "dark_chocolate_door_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.DARK_CHOCOLATE_TRAPDOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.DARK_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "dark_chocolate_trapdoor_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.MILK_CHOCOLATE_DOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.MILK_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "milk_chocolate_door_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.MILK_CHOCOLATE_TRAPDOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.MILK_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "milk_chocolate_trapdoor_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.WHITE_CHOCOLATE_DOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.WHITE_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "white_chocolate_door_to_block"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.WHITE_CHOCOLATE_TRAPDOOR.get()),
						new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(),
						ExtraDelightItems.WHITE_CHOCOLATE_BLOCK.get())
				.build(consumer, EDLoc("cutting/" + "white_chocolate_trapdoor_to_block"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightTags.BLOOD_CHOCOLATE_BAR),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.BLOOD_CHOCOLATE_CHIPS.get(), 5)
				.build(consumer, EDLoc("cutting/" + "blood_chocolate_chips"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightTags.DARK_CHOCOLATE_BAR),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.DARK_CHOCOLATE_CHIPS.get(), 5)
				.build(consumer, EDLoc("cutting/" + "dark_chocolate_chips"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightTags.MILK_CHOCOLATE_BAR),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.MILK_CHOCOLATE_CHIPS.get(), 5)
				.build(consumer, EDLoc("cutting/" + "milk_chocolate_chips"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightTags.WHITE_CHOCOLATE_BAR),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.WHITE_CHOCOLATE_CHIPS.get(), 5)
				.build(consumer, EDLoc("cutting/" + "white_chocolate_chips"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PEANUTS_IN_SHELL.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.PEANUTS.get(), 2)
				.build(consumer, EDLoc("cutting/" + "peanuts"));

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.HAZELNUTS_IN_SHELL.get()),
						Ingredient.of(CommonTags.TOOLS_KNIFE), ExtraDelightItems.HAZELNUTS.get(), 2)
				.build(consumer, EDLoc("cutting/" + "hazelnuts"));
	}

	private void mortarRecipes(RecipeOutput consumer) {
		// Dyes
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.LAPIS_LAZULI), new ItemStack(Items.BLUE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BONE_MEAL), new ItemStack(Items.WHITE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.LILY_OF_THE_VALLEY), new ItemStack(Items.WHITE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LILY_OF_THE_VALLEY))
				.save(consumer, EDLoc("lily_white"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.ORANGE_TULIP), new ItemStack(Items.ORANGE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ORANGE_TULIP))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.ALLIUM), new ItemStack(Items.MAGENTA_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ALLIUM)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.LILAC), new ItemStack(Items.MAGENTA_DYE, 3), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LILAC))
				.save(consumer, EDLoc("lilac_magenta"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BLUE_ORCHID), new ItemStack(Items.LIGHT_BLUE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLUE_ORCHID))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.DANDELION), new ItemStack(Items.YELLOW_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DANDELION)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.SUNFLOWER), new ItemStack(Items.YELLOW_DYE, 3), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUNFLOWER))
				.save(consumer, EDLoc("sunflower_yellow"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.SEA_PICKLE), new ItemStack(Items.LIME_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SEA_PICKLE))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.PINK_TULIP), new ItemStack(Items.PINK_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_TULIP))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.PEONY), new ItemStack(Items.PINK_DYE, 3), FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PEONY))
				.save(consumer, EDLoc("peony_pink"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.OXEYE_DAISY), new ItemStack(Items.LIGHT_GRAY_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.OXEYE_DAISY))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.AZURE_BLUET), new ItemStack(Items.LIGHT_GRAY_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.AZURE_BLUET))
				.save(consumer, EDLoc("lgray_azure"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.WHITE_TULIP), new ItemStack(Items.LIGHT_GRAY_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_TULIP))
				.save(consumer, EDLoc("lgray_tulip"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.CORNFLOWER), new ItemStack(Items.BLUE_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CORNFLOWER))
				.save(consumer, EDLoc("blue_corn"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.COCOA_BEANS), new ItemStack(Items.BROWN_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS))
				.save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.CACTUS), new ItemStack(Items.GREEN_DYE, 2), FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CACTUS)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.RED_TULIP), new ItemStack(Items.RED_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_TULIP)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BEETROOT), new ItemStack(Items.RED_DYE, 2), FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
				.save(consumer, EDLoc("red_beet"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.POPPY), new ItemStack(Items.RED_DYE, 2), FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.POPPY))
				.save(consumer, EDLoc("poppy_red"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.ROSE_BUSH), new ItemStack(Items.RED_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROSE_BUSH))
				.save(consumer, EDLoc("rose_red"));
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.INK_SAC), new ItemStack(Items.BLACK_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.INK_SAC)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.WITHER_ROSE), new ItemStack(Items.BLACK_DYE, 2), FluidStack.EMPTY,
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WITHER_ROSE))
				.save(consumer, EDLoc("wither_black"));

		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BONE), new ItemStack(Items.BONE_MEAL, 4), FluidStack.EMPTY, LONG_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);
		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 3), FluidStack.EMPTY,
						LONG_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(Items.WHEAT_SEEDS), new ItemStack(ExtraDelightItems.FLOUR.get(), 1),
						new FluidStack(ExtraDelightFluids.OIL.FLUID, 100), STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder
				.grind(DifferenceIngredient.of(Ingredient.of(Tags.Items.SEEDS),
						Ingredient.of(Items.WHEAT_SEEDS, ExtraDelightItems.CORN_SEEDS.get())),
						new ItemStack(Items.BONE_MEAL, 1), new FluidStack(ExtraDelightFluids.OIL.FLUID, 250),
						STANDARD_GRIND)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT_SEEDS))
				.save(consumer, "seeds");

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightItems.AGAR_SHEETS.get()),
						new ItemStack(ExtraDelightItems.AGAR_AGAR.get(), 1), FluidStack.EMPTY, LONG_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.AGAR_SHEETS.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.CORN_KERNELS),
						new ItemStack(ExtraDelightItems.CORN_MEAL.get(), 1),
						new FluidStack(ExtraDelightFluids.OIL.FLUID, 100), STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_SEEDS.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.CINNAMON_STICK),
						new ItemStack(ExtraDelightItems.GROUND_CINNAMON.get(), 2), FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_STICK.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.ROASTED_COCOA_BEANS),
						new ItemStack(ExtraDelightItems.COCOA_SOLIDS.get(), 1),
						new FluidStack(ExtraDelightFluids.COCOA_BUTTER.FLUID, 50), STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_COCOA_BEANS.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.ROASTED_NUTS), ItemStack.EMPTY,
						new FluidStack(ExtraDelightFluids.NUT_BUTTER.FLUID, 250), STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_PEANUTS.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.MALLOWROOT), ExtraDelightItems.MALLOW_POWDER.toStack(),
						FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MALLOW_ROOT.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.DRIED_CHILI), ExtraDelightItems.CHILI_POWDER.toStack(),
						FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DRIED_CHILI.get()))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightTags.ROASTED_COFFEE_BEANS), ExtraDelightItems.GROUND_COFFEE.toStack(),
						FluidStack.EMPTY, STANDARD_GRIND)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_BEANS.get()))
				.save(consumer);
	}

	private void ovenRecipes(RecipeOutput consumer) {

//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.HEART)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.STUFFED_HEART.get(), 1, CookingRecipes.NORMAL_COOKING, SMALL_EXP,
//								ExtraDelightItems.TRAY.get())
//						.addIngredient(ExtraDelightTags.HEART).addIngredient(Tags.Items.MUSHROOMS)
//						.addIngredient(ExtraDelightTags.BREAD_CRUMBS).addIngredient(Tags.Items.FOODS_VEGETABLE_ONION)
//						.addIngredient(Items.EGG).build(r, EDLoc("stuffed_heart")))
//				.build(consumer, EDLoc("stuffed_heart_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.ROAST_RAW)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
//								MEDIUM_EXP, ExtraDelightItems.SQUARE_PAN.get())
//						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.ROAST_RAW)
//						.addIngredient(ExtraDelightTags.COOKING_OIL).addIngredient(CommonTags.CROPS_ONION)
//						.addIngredient(Items.POTATO).addIngredient(Items.CARROT).addIngredient(CommonTags.CROPS_ONION)
//						.addIngredient(Items.POTATO).addIngredient(Items.CARROT).build(r, EDLoc("pot_roast_feast")))
//				.build(consumer, EDLoc("pot_roast_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.RIBS_RAW)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
//								MEDIUM_EXP, ExtraDelightItems.TRAY.get())
//						.addIngredient(ExtraDelightTags.RIBS_RAW).addIngredient(ExtraDelightTags.RIBS_RAW)
//						.addIngredient(ExtraDelightTags.RIBS_RAW).addIngredient(ExtraDelightTags.RIBS_RAW)
//						.addIngredient(ExtraDelightItems.BBQ_SAUCE.get()).build(r, EDLoc("bbq_ribs_feast")))
//				.build(consumer, EDLoc("bbq_ribs_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.MUTTON_RIBS)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//								ExtraDelightItems.TRAY.get())
//						.addIngredient(ExtraDelightTags.MUTTON_RIBS).addIngredient(ExtraDelightTags.COOKING_OIL)
//						.addIngredient(ExtraDelightTags.MUTTON_RIBS).addIngredient(ExtraDelightTags.MUTTON_RIBS)
//						.addIngredient(Tags.Items.FOODS_VEGETABLE_ONION).addIngredient(ExtraDelightTags.MUTTON_RIBS)
//						.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.BREAD)
//						.addIngredient(Items.SWEET_BERRIES)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
//				.build(consumer, EDLoc("rack_lamb_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.LIVER)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//								ExtraDelightItems.TRAY.get())
//						.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.BEEF_ROAST)
//						.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.BUTTER)
//						.addIngredient(CommonTags.FOODS_DOUGH).addIngredient(ExtraDelightTags.LIVER)
//						.addIngredient(ModItems.COOKED_BACON.get()).addIngredient(Items.EGG)
//						.addIngredient(ExtraDelightTags.PROCESSED_ONION)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
//				.build(consumer, EDLoc("wellington_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.LIVER)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.HAGGIS_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//								ExtraDelightItems.TRAY.get())
//						.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.OFFAL)
//						.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.LUNG)
//						.addIngredient(ExtraDelightTags.STOMACH).addIngredient(ExtraDelightTags.SCRAP_MEAT)
//						.addIngredient(Items.WHEAT_SEEDS).addIngredient(Items.WHEAT_SEEDS)
//						.addIngredient(Items.WHEAT_SEEDS)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
//				.build(consumer, EDLoc("haggis_test"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(Items.CAKE, 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(CommonTags.FOODS_MILK).addIngredient(CommonTags.FOODS_MILK).addIngredient(Items.EGG)
				.addIngredient(ExtraDelightTags.SWEETENER, 2)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.GLOW_BERRY_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(Items.COOKIE, 8), FAST_COOKING, MEDIUM_EXP,
				new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.CHOCOLATE_CHIP_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.COCOA_BEANS).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.SUGAR_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.SUGAR_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.SUGAR).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.PUMPKIN_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get()).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ModItems.SWEET_BERRY_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
				new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.SWEET_BERRY_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.SWEET_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.HONEY_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.HONEY_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.HONEY_BOTTLE).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.APPLE_COOKIE.get(), 8), FAST_COOKING, MEDIUM_EXP,
				new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightItems.APPLE_COOKIE_DOUGH.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.APPLE).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(Ingredient.of(CommonTags.FOODS_MILK)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(CommonTags.FOODS_MILK))/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.MILK_BUCKET, ModItems.MILK_BOTTLE.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(Items.BAKED_POTATO).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(Items.BAKED_POTATO).addIngredient(CommonTags.FOODS_COOKED_MUTTON)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_COOKED_MUTTON)
				.addIngredient(ExtraDelightTags.PROCESSED_VEG).addIngredient(ExtraDelightTags.PROCESSED_VEG)
				.addIngredient(ExtraDelightTags.PROCESSED_VEG)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("shepard_pie", has(CommonTags.FOODS_COOKED_MUTTON)).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(Items.COCOA_BEANS, 3).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(Items.COCOA_BEANS)
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(Items.GLOW_BERRIES, 3).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ExtraDelightItems.CHEESE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(Items.HONEY_BOTTLE, 3).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ExtraDelightItems.CHEESE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ModItems.PUMPKIN_SLICE.get(), 3).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.APPLE_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.PROCESSED_APPLE).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(ExtraDelightTags.PROCESSED_APPLE).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(Items.SWEET_BERRIES, 3)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).unlockedByAnyIngredient(Items.SWEET_BERRIES)
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(Items.GLOW_BERRIES, 3)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).unlockedByAnyIngredient(Items.GLOW_BERRIES)
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.QUICHE.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightItems.OMELETTE_MIX.get(), 1).addIngredient(ModItems.PIE_CRUST.get(), 1)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(
						ExtraDelightItems.OMELETTE_MIX.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.EGG_BASKET.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.BREAD_SLICE)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedBy("egg_basket", has(Tags.Items.EGGS))
				.build(consumer);

//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.SAUSAGE)))
//				.addRecipe(r -> OvenRecipeBuilder
//						.OvenRecipe(new ItemStack(ExtraDelightItems.SAUSAGE_ROLL.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
//								ExtraDelightItems.SHEET.get())
//						.addIngredient(ExtraDelightTags.SAUSAGE).addIngredient(CommonTags.FOODS_DOUGH)
//						/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//						.unlockedBy("sausage_roll", has(ExtraDelightTags.SAUSAGE)).build(r))
//				.build(consumer, EDLoc("sausage_roll_test"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MEAT_COOKED))).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ExtraDelightItems.LASAGNA_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.SQUARE_PAN.get())
//					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ModItems.TOMATO_SAUCE.get())
//					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
//					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
//					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
//					.addIngredient(ExtraDelightTags.GROUND_MEAT_COOKED).addIngredient(ModItems.TOMATO_SAUCE.get())
//					.addIngredient(ExtraDelightTags.GROUND_MEAT_COOKED)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("lasagna", has(ExtraDelightItems.LASAGNA_NOODLES.get())).build(r, EDLoc("lasagna_bc"));
//		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MEAT_COOKED)).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ExtraDelightItems.LASAGNA_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.SQUARE_PAN.get())
//					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ModItems.TOMATO_SAUCE.get())
//					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
//					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
//					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get()).addIngredient(ExtraDelightTags.MEAT_COOKED)
//					.addIngredient(ModItems.TOMATO_SAUCE.get()).addIngredient(ExtraDelightTags.MEAT_COOKED)
//					/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("lasagna", has(ExtraDelightItems.LASAGNA_NOODLES.get()))
//					.build(r, EDLoc("lasagna_vanilla"));
//		}).build(consumer, EDLoc("lasagna"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MEAT_RAW))).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ExtraDelightItems.MEAT_LOAF_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.LOAF_PAN.get())
//					.addIngredient(ExtraDelightItems.KETCHUP.get()).addIngredient(ExtraDelightTags.BREAD_CRUMBS)
//					.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
//					.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
//					.addIngredient(ExtraDelightTags.PROCESSED_ONION)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("meatloaf", has(ExtraDelightTags.GROUND_MEAT_RAW)).build(r, EDLoc("meatloaf_bc"));
//		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MEAT_RAW)).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ExtraDelightItems.MEAT_LOAF_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.LOAF_PAN.get())
//					.addIngredient(ExtraDelightItems.KETCHUP.get()).addIngredient(ExtraDelightTags.BREAD_CRUMBS)
//					.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(ModItems.BEEF_PATTY.get())
//					.addIngredient(ModItems.BEEF_PATTY.get()).addIngredient(ModItems.BEEF_PATTY.get())
//					.addIngredient(ExtraDelightTags.PROCESSED_ONION)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("meatloaf", has(ExtraDelightItems.LASAGNA_NOODLES.get()))
//					.build(r, EDLoc("meatloaf_vanilla"));
//		}).build(consumer, EDLoc("meatloaf"));
//
//		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MUTTON_COOKED))).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.SQUARE_PAN.get())
//					.addIngredient(Items.BAKED_POTATO).addIngredient(ModItems.BONE_BROTH.get())
//					.addIngredient(Items.BAKED_POTATO).addIngredient(ExtraDelightTags.GROUND_MUTTON_COOKED)
//					.addIngredient(ExtraDelightTags.PROCESSED_CARROT)
//					.addIngredient(ExtraDelightTags.GROUND_MUTTON_COOKED).addIngredient(ExtraDelightTags.FLOUR)
//					.addIngredient(ModItems.TOMATO_SAUCE.get()).addIngredient(ExtraDelightTags.PROCESSED_ONION)
//					/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("shepards_pie", has(ExtraDelightTags.GROUND_MEAT_RAW))
//					.build(r, EDLoc("shepards_pie_bc"));
//		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MUTTON_COOKED)).addRecipe(r -> {
//			OvenRecipeBuilder
//					.OvenRecipe(new ItemStack(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
//							ExtraDelightItems.SQUARE_PAN.get())
//					.addIngredient(Items.BAKED_POTATO).addIngredient(ModItems.BONE_BROTH.get())
//					.addIngredient(Items.BAKED_POTATO).addIngredient(CommonTags.COOKED_MUTTON)
//					.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.COOKED_MUTTON)
//					.addIngredient(ExtraDelightTags.PROCESSED_CARROT).addIngredient(ExtraDelightTags.BUTTER)
//					.addIngredient(ExtraDelightTags.PROCESSED_ONION)/*.setRecipeBookTab(OvenRecipeBookTab.MEALS)*/
//					.unlockedBy("shepards_pie", has(ExtraDelightTags.GROUND_MEAT_RAW))
//					.build(r, EDLoc("shepards_pie_vanilla"));
//		}).build(consumer, EDLoc("shepards_pie"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.HOTDISH_FEAST.get(), 1), SLOW_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.STARCH).addIngredient(ExtraDelightTags.STARCH)
				.addIngredient(ExtraDelightTags.STARCH).addIngredient(ExtraDelightTags.MEAT_COOKED)
				.addIngredient(ExtraDelightTags.SOUP).addIngredient(ExtraDelightTags.MEAT_COOKED)
				.addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(ExtraDelightTags.SOUP)
				.addIngredient(Tags.Items.FOODS_VEGETABLE)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("hotdish", has(ExtraDelightTags.SOUP)).save(consumer, EDLoc("hotdish"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.STUFFED_MUSHROOMS.get(), 3), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(Tags.Items.MUSHROOMS)
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.CHEESE)
				.addIngredient(ExtraDelightTags.BREAD_CRUMBS).addIngredient(ExtraDelightTags.BUTTER)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedBy("stuffed_mushroom",
						has(Tags.Items.MUSHROOMS))
				.save(consumer, EDLoc("stuffed_mushroom"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
				.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(Tags.Items.MUSHROOMS)
				.addIngredient(ExtraDelightTags.PROCESSED_POTATO).addIngredient(ExtraDelightTags.PROCESSED_ONION)
				.addIngredient(ModItems.PIE_CRUST.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("meat_pie", has(ModItems.PIE_CRUST.get())).save(consumer, EDLoc("meat_pie"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CHICKEN_PARM.get(), 2), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightItems.FRIED_CHICKEN.get()).addIngredient(ModItems.TOMATO_SAUCE.get())
				.addIngredient(ExtraDelightTags.CHEESE)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("chicken_parm", has(ExtraDelightItems.FRIED_CHICKEN.get()))
				.save(consumer, EDLoc("chicken_parm"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.ROAST_CHICKEN_BLOCK.get(), 1), SLOW_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.GRAVY)
				.addIngredient(Tags.Items.FOODS_BREAD).addIngredient(ExtraDelightTags.PROCESSED_CARROT)
				.addIngredient(Items.CHICKEN).addIngredient(ExtraDelightTags.PROCESSED_POTATO)
				.addIngredient(ExtraDelightTags.PROCESSED_CARROT).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.PROCESSED_POTATO)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("roast_chicken", has(Items.CHICKEN)).save(consumer, EDLoc("roast_chicken"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.HONEY_GLAZED_HAM_BLOCK.get(), 1), SLOW_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(Items.HONEY_BOTTLE)
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ModItems.HAM.get()).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ModItems.COOKED_RICE.get()).addIngredient(ExtraDelightItems.BUTTER.get())
				.addIngredient(ModItems.COOKED_RICE.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("honey_ham", has(ModItems.HAM.get())).save(consumer, EDLoc("honey_ham"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.CHOCOLATE_PIE.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightTags.WHIPPED_CREAM)
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightItems.EGG_MIX.get())
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ModItems.PIE_CRUST.get())
				.addIngredient(ExtraDelightTags.SWEETENER)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("chocolate_pie", has(Items.COCOA_BEANS)).save(consumer, EDLoc("chocolate_pie"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.PIE_CRUST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(CommonTags.FOODS_MILK)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("pie_crust", has(ExtraDelightTags.FLOUR)).save(consumer, EDLoc("pie_crust"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.SWEET_BERRY_CHEESECAKE.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(CommonTags.FOODS_MILK).addIngredient(ModItems.PIE_CRUST.get())
				.addIngredient(CommonTags.FOODS_MILK)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("sweet_berry", has(Items.SWEET_BERRIES)).save(consumer, EDLoc("sweet_berry_cheesecake"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.APPLE_PIE.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(ExtraDelightTags.PROCESSED_APPLE).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ModItems.PIE_CRUST.get())
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedBy("apple_pie", has(Items.APPLE))
				.save(consumer, EDLoc("apple_pie"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ModItems.APPLE_PIE.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ExtraDelightItems.STEWED_APPLES)
				.addIngredient(ModItems.PIE_CRUST.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedBy("apple_pie", has(Items.APPLE)).save(consumer, EDLoc("apple_pie_stewed"));

		bulkBake(ModItems.FRIED_EGG.get(), Ingredient.of(Items.EGG), consumer, ExtraDelightItems.TRAY.get(),
				"fried_egg");
		bulkBake(ModItems.BEEF_PATTY.get(), Ingredient.of(ModItems.MINCED_BEEF.get()), consumer,
				ExtraDelightItems.TRAY.get(), "beef_patty");
		bulkBake(ModItems.COOKED_CHICKEN_CUTS.get(), Ingredient.of(ModItems.CHICKEN_CUTS.get()), consumer,
				ExtraDelightItems.TRAY.get(), "chicken_cuts");
		bulkBake(ModItems.COOKED_COD_SLICE.get(), Ingredient.of(ModItems.COD_SLICE.get()), consumer,
				ExtraDelightItems.TRAY.get(), "cod_slice");
		bulkBake(ModItems.COOKED_SALMON_SLICE.get(), Ingredient.of(ModItems.SALMON_SLICE.get()), consumer,
				ExtraDelightItems.TRAY.get(), "salmon_slice");
		bulkBake(ModItems.COOKED_BACON.get(), Ingredient.of(ModItems.BACON.get()), consumer,
				ExtraDelightItems.TRAY.get(), "bacon");
		bulkBake(ModItems.COOKED_MUTTON_CHOPS.get(), Ingredient.of(ModItems.MUTTON_CHOPS.get()), consumer,
				ExtraDelightItems.TRAY.get(), "mutton_chops");
		bulkBake(ModItems.SMOKED_HAM.get(), Ingredient.of(ModItems.HAM.get()), consumer, ExtraDelightItems.TRAY.get(),
				"ham");
		bulkBake(Items.BREAD, Ingredient.of(CommonTags.FOODS_DOUGH), consumer, ExtraDelightItems.LOAF_PAN.get(),
				"bread");
		bulkBake(Items.BAKED_POTATO, Ingredient.of(Items.POTATO), consumer, ExtraDelightItems.SHEET.get(), "potato");
		bulkBake(ExtraDelightItems.ROASTED_CARROT.get(), Ingredient.of(Items.CARROT), consumer,
				ExtraDelightItems.SHEET.get(), "carrot");
		bulkBake(ExtraDelightItems.ROASTED_APPLE.get(), Ingredient.of(Items.APPLE), consumer,
				ExtraDelightItems.SHEET.get(), "apple");
		bulkBake(Items.COOKED_BEEF, Ingredient.of(Items.BEEF), consumer, ExtraDelightItems.SHEET.get(), "beef");
		bulkBake(Items.COOKED_CHICKEN, Ingredient.of(Items.CHICKEN), consumer, ExtraDelightItems.SHEET.get(),
				"chicken");
		bulkBake(Items.COOKED_COD, Ingredient.of(Items.COD), consumer, ExtraDelightItems.SHEET.get(), "cod");
		bulkBake(Items.COOKED_MUTTON, Ingredient.of(Items.MUTTON), consumer, ExtraDelightItems.SHEET.get(), "mutton");
		bulkBake(Items.COOKED_PORKCHOP, Ingredient.of(Items.PORKCHOP), consumer, ExtraDelightItems.SHEET.get(),
				"porkchop");
		bulkBake(Items.COOKED_RABBIT, Ingredient.of(Items.RABBIT), consumer, ExtraDelightItems.SHEET.get(), "rabbit");
		bulkBake(Items.COOKED_SALMON, Ingredient.of(Items.SALMON), consumer, ExtraDelightItems.SHEET.get(), "salmon");
		bulkBake(ExtraDelightItems.TOAST.get(), Ingredient.of(ExtraDelightTags.BREAD_SLICE), consumer,
				ExtraDelightItems.SHEET.get(), "toast");
		bulkBake(ExtraDelightItems.GRILLED_CHEESE.get(), Ingredient.of(ExtraDelightItems.CHEESE_SANDWICH.get()),
				consumer, ExtraDelightItems.SHEET.get(), "grilled_cheese");
		bulkBake(ExtraDelightItems.COOKED_CACTUS.get(), Ingredient.of(ExtraDelightItems.CACTUS.get()), consumer,
				ExtraDelightItems.SHEET.get(), "cooked_cactus");

		// Halloween Start!
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ExtraDelightItems.CARAMEL_SAUCE.get(), 3)
				.addIngredient(Ingredient.of(CommonTags.FOODS_MILK)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(CommonTags.FOODS_MILK))/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.CARAMEL_SAUCE.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CORNBREAD_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ModItems.SKILLET.get()))
				.addIngredient(ExtraDelightTags.CORN_MEAL).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ExtraDelightItems.BUTTER.get())
				.addIngredient(ExtraDelightItems.EGG_MIX.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.CORN_MEAL.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CORN_PUDDING_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.CORN_MEAL).addIngredient(ExtraDelightItems.COOKED_CORN.get())
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ExtraDelightItems.BUTTER.get())
				.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(Ingredient.of(CommonTags.FOODS_MILK))
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(
						ExtraDelightItems.CORN_MEAL.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.PUMPKIN_PIE_ITEM.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()))
				.addIngredient(ModItems.PUMPKIN_SLICE.get(), 3).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ExtraDelightItems.EGG_MIX.get())
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.APPLE_CRISP_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(Items.WHEAT_SEEDS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.SLICED_APPLE.get(), Items.APPLE).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.SLICED_POTATO).addIngredient(ExtraDelightTags.SLICED_POTATO)
				.addIngredient(ExtraDelightTags.SLICED_POTATO)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.SLICED_POTATO.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.PUMPKIN_ROLL_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ModItems.PUMPKIN_SLICE.get()).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ModItems.PUMPKIN_SLICE.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get()).build(consumer);

		bulkBake(ExtraDelightItems.GRILLED_CORN_ON_COB.get(), Ingredient.of(ExtraDelightTags.CORN_ON_COB), consumer,
				ExtraDelightItems.SHEET.get(), "cooked_corn_cob");
		bulkBake(ExtraDelightItems.ROASTED_PUMPKIN_SEEDS.get(), Ingredient.of(Items.PUMPKIN_SEEDS), consumer,
				ExtraDelightItems.TRAY.get(), "cooked_pumpkin_seeds");

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE.get(), 8), NORMAL_COOKING,
				MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_BLOCK.get(), 4), NORMAL_COOKING,
				MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get()).build(consumer);

		bulkBake(ExtraDelightItems.GINGERBREAD_ALEX.get(), Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_ALEX.get()),
				consumer, ExtraDelightItems.SHEET.get(), "gingerbread_alex_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_CREEPER.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_CREEPER.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_creeper_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_PICKAXE.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_PICKAXE.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_pickaxe_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_STEVE.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_STEVE.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_steve_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_SWORD.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_SWORD.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_sword_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_VILLAGER.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_VILLAGER.get()), consumer,
				ExtraDelightItems.SHEET.get(), "gingerbread_villager_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_DIAMOND.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_DIAMOND.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_diamond_oven", 1);
		bulkBake(ExtraDelightItems.GINGERBREAD_EMERALD.get(),
				Ingredient.of(ExtraDelightItems.RAW_GINGERBREAD_EMERALD.get()), consumer, ExtraDelightItems.SHEET.get(),
				"gingerbread_emerald_oven", 1);

		bulkBake(ExtraDelightItems.SUGAR_COOKIE_ALEX.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_ALEX.get()), consumer, ExtraDelightItems.SHEET.get(),
				"sugar_cookie_alex_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_CREEPER.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_CREEPER.get()), consumer,
				ExtraDelightItems.SHEET.get(), "sugar_cookie_creeper_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_PICKAXE.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_PICKAXE.get()), consumer,
				ExtraDelightItems.SHEET.get(), "sugar_cookie_pickaxe_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_STEVE.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_STEVE.get()), consumer, ExtraDelightItems.SHEET.get(),
				"sugar_cookie_steve_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_SWORD.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_SWORD.get()), consumer, ExtraDelightItems.SHEET.get(),
				"sugar_cookie_sword_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_VILLAGER.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_VILLAGER.get()), consumer,
				ExtraDelightItems.SHEET.get(), "sugar_cookie_villager_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_DIAMOND.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_DIAMOND.get()), consumer,
				ExtraDelightItems.SHEET.get(), "sugar_cookie_diamond_oven", 1);
		bulkBake(ExtraDelightItems.SUGAR_COOKIE_EMERALD.get(),
				Ingredient.of(ExtraDelightItems.RAW_SUGAR_COOKIE_EMERALD.get()), consumer,
				ExtraDelightItems.SHEET.get(), "sugar_cookie_emerald_oven", 1);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.APPLE_COOKIE_BLOCK.get(), 4), NORMAL_COOKING,
				MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightItems.APPLE_COOKIE_DOUGH.get(), 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.APPLE_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_BLOCK.get(), 4), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.CHOCOLATE_CHIP_COOKIE_DOUGH, 4)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE_BLOCK.get(), 4), NORMAL_COOKING,
				MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.GLOW_BERRY_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.HONEY_COOKIE_BLOCK.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.HONEY_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.HONEY_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE_BLOCK.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.PUMPKIN_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.SUGAR_COOKIE_BLOCK.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.SUGAR_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.SUGAR_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder.OvenRecipe(new ItemStack(ExtraDelightItems.SWEET_BERRY_COOKIE_BLOCK.get(), 4), NORMAL_COOKING,
				MEDIUM_EXP, new ItemStack(ExtraDelightItems.SHEET.get())).addIngredient(
						ExtraDelightTags.SWEET_BERRY_COOKIE_DOUGH, 4)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.FRENCH_TOAST.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.GROUND_CINNAMON).addIngredient(Tags.Items.EGGS)
				.addIngredient(CommonTags.FOODS_MILK).addIngredient(ExtraDelightTags.BREAD_SLICE, 4)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(
						ExtraDelightItems.BREAD_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MUFFIN_APPLE.get(), 6), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.PROCESSED_APPLE).addIngredient(Tags.Items.EGGS)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_MILK)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ExtraDelightItems.GINGER.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MUFFIN_CINNAMON.get(), 6), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.GROUND_CINNAMON).addIngredient(Tags.Items.EGGS)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_MILK)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ExtraDelightItems.GROUND_CINNAMON.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MUFFIN_GINGER.get(), 6), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.PROCESSED_GINGER).addIngredient(Tags.Items.EGGS)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_MILK)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ExtraDelightItems.GINGER.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MUFFIN_SWEET_BERRY.get(), 6), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(CommonTags.FOODS_MILK)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.SWEET_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.FRUIT_BREAD.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.LOAF_PAN.get()))
				.addIngredient(ExtraDelightTags.PROCESSED_FRUIT).addIngredient(CommonTags.FOODS_DOUGH)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.WHEAT_DOUGH.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.FRUIT_BREAD.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.LOAF_PAN.get()))
				.addIngredient(ExtraDelightTags.DRIED_FRUIT).addIngredient(CommonTags.FOODS_DOUGH)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.WHEAT_DOUGH.get())
				.save(consumer, EDLoc("fruit_bread_dried"));

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CRACKERS.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.BUTTER)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ExtraDelightItems.FLOUR.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.ROLL.get(),
						6), NORMAL_COOKING, MEDIUM_EXP, new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(CommonTags.FOODS_DOUGH)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ModItems.WHEAT_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CINNAMON_ROLLS_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(CommonTags.FOODS_DOUGH).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.GROUND_CINNAMON)
				.addIngredient(ExtraDelightItems.FROSTING_WHITE.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ModItems.WHEAT_DOUGH.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MONKEY_BREAD_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(CommonTags.FOODS_DOUGH).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.GROUND_CINNAMON)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(ModItems.WHEAT_DOUGH.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.COFFEE_CAKE_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.GROUND_CINNAMON)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(CommonTags.FOODS_MILK).addIngredient(Items.EGG)
				.addIngredient(ExtraDelightTags.SWEETENER, 2)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MINT_LAMB_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(Items.MUTTON, 4).addIngredient(ExtraDelightTags.MINT)
				.addIngredient(ExtraDelightTags.BREAD_CRUMBS).addIngredient(ExtraDelightTags.COOKING_OIL)
				/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByAnyIngredient(Items.MUTTON).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.CHRISTMAS_PUDDING_FEAST.get(), 1), NORMAL_COOKING,
						MEDIUM_EXP, new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.DRIED_FRUIT, 3).addIngredient(ExtraDelightTags.BREAD_CRUMBS)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.GROUND_CINNAMON)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(Tags.Items.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(Items.MUTTON).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.MILK_TART_FEAST.get(), 1), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()))
				.addIngredient(ExtraDelightTags.GROUND_CINNAMON).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(Tags.Items.EGGS)
				.addIngredient(ModItems.PIE_CRUST.get())/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */
				.unlockedByAnyIngredient(ModItems.PIE_CRUST.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.LAVA_CAKE.get(), 6), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.CHOCOLATE_SYRUP)
				.addIngredient(CommonTags.FOODS_MILK).addIngredient(ExtraDelightTags.CHOCOLATE_SYRUP)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(Tags.Items.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER).unlockedByAnyIngredient(ExtraDelightItems.MUFFIN_TIN.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(ExtraDelightItems.GRAHAM_CRACKER.get(), 4), NORMAL_COOKING, MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.SWEETENER)
				.addIngredient(ExtraDelightTags.GROUND_CINNAMON).addIngredient(ExtraDelightTags.CHOCOLATE_SYRUP)
				.addIngredient(CommonTags.FOODS_MILK).addIngredient(ExtraDelightTags.COOKING_OIL)
				.addIngredient(Tags.Items.EGGS).unlockedByAnyIngredient(ExtraDelightItems.TRAY.get()).build(consumer);

		bulkBake(ExtraDelightItems.ROASTED_COCOA_BEANS.get(), Ingredient.of(ExtraDelightTags.GREEN_COFFEE), consumer,
				ExtraDelightItems.TRAY.get(), "coffee_oven", 1);
		bulkBake(ExtraDelightItems.ROASTED_PEANUTS.get(), Ingredient.of(ExtraDelightTags.PEANUTS), consumer,
				ExtraDelightItems.TRAY.get(), "peanuts_oven", 1);
		bulkBake(ExtraDelightItems.ROASTED_HAZELNUTS.get(), Ingredient.of(ExtraDelightTags.HAZELNUTS), consumer,
				ExtraDelightItems.TRAY.get(), "hazelnuts_oven", 1);
	}

	private void bulkBake(ItemLike mainResult, Ingredient in, RecipeOutput consumer, ItemLike pan, String name) {
		bulkBake(mainResult, in, consumer, pan, name, 1);
	}

	private void bulkBake(ItemLike mainResult, Ingredient in, RecipeOutput consumer, ItemLike pan, String name,
			int count) {
		for (int i = 1; i < 10; i++)
			OvenRecipeBuilder
					.OvenRecipe(new ItemStack(mainResult, i * count), NORMAL_COOKING, MEDIUM_EXP, new ItemStack(pan))
					.addIngredient(in, i)/* .setRecipeBookTab(OvenRecipeBookTab.MEALS) */.unlockedByItems(name, pan)
					.build(consumer, "extradelight:oven/bulk/" + name + i);
	}

	private void pot(ItemLike output, int count, int speed, float xp, ItemLike container, Ingredient[] itemsIn,
			String rc, RecipeOutput consumer) {

//		cookingPotRecipe(ItemLike mainResult, int count, int cookingTime, float experience)

		CookingPotRecipeBuilder b = CookingPotRecipeBuilder.cookingPotRecipe(output, count, speed, xp, container)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS);
		for (Ingredient i : itemsIn)
			b.addIngredient(i);
		b.build(consumer, rc);

//		ProcessingRecipeBuilder<MixingRecipe> p = new ProcessingRecipeBuilder<MixingRecipe>(MixingRecipe::new,
//				CreateLoc(rc + "_create"));
//
//		p.output(output, count);
//		for (Ingredient i : itemsIn)
//			p.require(i);
//
//		p.requiresHeat(HeatCondition.HEATED);
//		p.build(consumer);
	}
}

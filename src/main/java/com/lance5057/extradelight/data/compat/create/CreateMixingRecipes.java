package com.lance5057.extradelight.data.compat.create;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class CreateMixingRecipes extends MixingRecipeGen {

	public CreateMixingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
			String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

	GeneratedRecipe

	WHEAT_DOUGH_EGG = create("wheat_dough_egg",
			b -> b.output(new ItemStack(ModItems.WHEAT_DOUGH.get(), 3)).require(Ingredient.of(ExtraDelightTags.FLOUR))
					.require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.FLOUR))
					.require(Ingredient.of(Tags.Items.EGGS))),

			WHEAT_DOUGH = create("wheat_dough", b -> b.output(new ItemStack(ModItems.WHEAT_DOUGH.get(), 3))
					.require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.FLOUR))
					.require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Fluids.WATER, 1000)),

			EGG_MIX = create("egg_mix",
					b -> b.output(new ItemStack(ExtraDelightItems.EGG_MIX.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(Tags.Items.EGGS))
							.require(NeoForgeMod.MILK.get(), 250)),

			MAYO = create("mayo",
					b -> b.output(new ItemStack(ExtraDelightItems.MAYO.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(Tags.Items.EGGS))
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			CARROT_SALAD = create("carrot_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.CARROT_SALAD.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.GRATED_CARROT))
							.require(Ingredient.of(ExtraDelightTags.GRATED_CARROT))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)),

			EGG_SALAD = create("egg_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.EGG_SALAD.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
							.require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)),

			FISH_SALAD = create("fish_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.FISH_SALAD.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(Tags.Items.FOODS_COOKED_FISH))
							.require(Ingredient.of(Tags.Items.FOODS_COOKED_FISH))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)),

			BUTTER = create("butter",
					b -> b.output(new ItemStack(ExtraDelightItems.BUTTER.get(), 1))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			WHIPPED_CREAM = create("whipped_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.WHIPPED_CREAM.get(), 1)).require(Items.BOWL)
							.require(NeoForgeMod.MILK.get(), 250)),

			SEAWEED_SALAD = create("seaweed_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.SEAWEED_SALAD.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(Items.KELP)).require(Ingredient.of(Items.KELP))
							.require(Ingredient.of(ExtraDelightTags.GRATED_CARROT))
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			FURIKAKE_RICE = create("furikake",
					b -> b.output(new ItemStack(ExtraDelightItems.FURIKAKE.get(), 4)).require(Items.BOWL)
							.require(Ingredient.of(Items.KELP)).require(Ingredient.of(Items.KELP))
							.require(Ingredient.of(ExtraDelightTags.FISH_FLAKES))
							.require(Ingredient.of(ExtraDelightTags.FISH_FLAKES))),

			SALAD_MEAT = create("salad_meat",
					b -> b.output(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT))
							.require(Ingredient.of(ExtraDelightTags.CROUTONS))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
							.require(Ingredient.of(ExtraDelightTags.MEAT_COOKED))
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			SALAD_VEG = create("salad_veg",
					b -> b.output(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT))
							.require(Ingredient.of(ExtraDelightItems.CROUTONS.get()))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			PASTA_ALFREDO = create("pasta_alfredo",
					b -> b.output(new ItemStack(ExtraDelightItems.PASTA_ALFREDO.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.ALFREDO_SAUCE))
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))),

			CHICKEN_ALFREDO = create("chicken_alfredo",
					b -> b.output(new ItemStack(ExtraDelightItems.CHICKEN_ALFREDO.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.ALFREDO_SAUCE))
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))
							.require(Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN))),

			PASTA_TOMATO = create("pasta_tomato",
					b -> b.output(new ItemStack(ExtraDelightItems.PASTA_TOMATO.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ModItems.TOMATO_SAUCE.get()))
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))),

			PASTA_MEATBALLS = create("pasta_meatballs",
					b -> b.output(new ItemStack(ModItems.PASTA_WITH_MEATBALLS.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ModItems.TOMATO_SAUCE.get()))
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))
							.require(Ingredient.of(ModItems.BEEF_PATTY.get()))),

			PASTA_MUTTON = create("pasta_mutton",
					b -> b.output(new ItemStack(ModItems.PASTA_WITH_MUTTON_CHOP.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ModItems.TOMATO_SAUCE.get()))
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))
							.require(Ingredient.of(Items.COOKED_MUTTON))),

			BUTTERED_PASTA = create("buttered_pasta",
					b -> b.output(new ItemStack(ExtraDelightItems.BUTTERED_PASTA.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA.get()))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))),

			CACTUS_SALAD = create("cactus_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.CACTUS_SALAD.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.COOKED_CACTUS))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))),

// Holiday

			MILKSHAKE = create("milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.MILKSHAKE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			APPLE_MILKSHAKE = create("apple_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_MILKSHAKE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(NeoForgeMod.MILK.get(), 250)),

			APPLE_MILKSHAKE_ICE_CREAM = create("apple_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_MILKSHAKE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.APPLE_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			CHOCOLATE_MILKSHAKE = create("chocolate_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))
							.require(NeoForgeMod.MILK.get(), 250)),

			CHOCOLATE_MILKSHAKE_ICE_CREAM = create("chocolate_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.CHOCOLATE_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			GLOW_BERRY_MILKSHAKE = create("glow_berry_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(Items.GLOW_BERRIES)).require(Ingredient.of(Items.GLOW_BERRIES))
							.require(Ingredient.of(Items.GLOW_BERRIES)).require(NeoForgeMod.MILK.get(), 250)),

			GLOW_BERRY_MILKSHAKE_ICE_CREAM = create("glow_berry_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.GLOW_BERRY_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			HONEY_MILKSHAKE = create("honey_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.HONEY_MILKSHAKE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(Items.HONEY_BOTTLE)).require(Ingredient.of(Items.HONEY_BOTTLE))
							.require(Ingredient.of(Items.HONEY_BOTTLE)).require(NeoForgeMod.MILK.get(), 250)),

			HONEY_MILKSHAKE_ICE_CREAM = create("honey_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.HONEY_MILKSHAKE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.HONEY_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			PUMPKIN_MILKSHAKE = create("pumpkin_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.PUMPKIN_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get())).require(NeoForgeMod.MILK.get(), 250)),

			pumpkin_milkshake_ice_cream = create("pumpkin_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.PUMPKIN_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.PUMPKIN_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			SWEET_BERRY_MILKSHAKE = create("sweet_berry_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(Items.SWEET_BERRIES)).require(Ingredient.of(Items.SWEET_BERRIES))
							.require(Ingredient.of(Items.SWEET_BERRIES)).require(NeoForgeMod.MILK.get(), 250)),

			SWEET_BERRY_MILKSHAKE_ICE_CREAM = create("sweet_berry_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.SWEET_BERRY_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			COOKIE_DOUGH_MILKSHAKE = create("cookie_dough_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(ExtraDelightTags.COOKIE_DOUGH))
							.require(NeoForgeMod.MILK.get(), 250)),

			COOKIE_DOUGH_MILKSHAKE_ICE_CREAM = create("cookie_dough_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			MINT_CHIP_MILKSHAKE = create("mint_chip_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_CHIP_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_CHIPS))
							.require(Ingredient.of(ExtraDelightTags.MINT)).require(NeoForgeMod.MILK.get(), 250)),

			MINT_CHIP_MILKSHAKE_ICE_CREAM = create("mint_chip_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_CHIP_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.MINT_CHIP_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			SUGAR_COOKIE_DOUGH = create("sugar_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.SUGAR_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))),

			APPLE_COOKIE_DOUGH = create("apple_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))),

			APPLE_COOKIE_DOUGH_SUGAR = create("apple_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))),

			CHOCOLATE_CHIP_COOKIE_DOUGH = create("chocolate_chip_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_CHIPS))),

			CHOCOLATE_CHIP_COOKIE_DOUGH_SUGAR = create("chocolate_chip_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_CHIPS))),

			GINGERBREAD_COOKIE_DOUGH = create("gingerbread_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightItems.GRATED_GINGER.get()))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))),

			GINGERBREAD_COOKIE_DOUGH_SUGAR = create("gingerbread_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(ExtraDelightItems.GRATED_GINGER.get()))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))),

			GLOW_BERRY_COOKIE_DOUGH = create("glow_berry_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(Items.GLOW_BERRIES))),

			GLOW_BERRY_COOKIE_DOUGH_SUGAR = create("glow_berry_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(Items.GLOW_BERRIES))),

			HONEY_COOKIE_DOUGH = create("honey_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.HONEY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(Items.HONEY_BOTTLE))),

			HONEY_COOKIE_DOUGH_SUGAR = create("honey_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.HONEY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(Items.HONEY_BOTTLE))),

			PUMPKIN_COOKIE_DOUGH = create("pumpkin_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))),

			PUMPKIN_COOKIE_DOUGH_SUGAR = create("pumpkin_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))),

			SWEET_BERRY_COOKIE_DOUGH = create("sweet_berry_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(Items.SWEET_BERRIES))),

			SWEET_BERRY_COOKIE_DOUGH_SUGAR = create("sweet_berry_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(Items.SWEET_BERRIES))),

			FROSTING_BLACK = create("frosting_black",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_BLACK.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BLACK))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_BLUE = create("frosting_blue",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_BLUE.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BLUE))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_BROWN = create("frosting_brown",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_BROWN.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BROWN))),

			FROSTING_CYAN = create("frosting_cyan",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_CYAN.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_CYAN))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_GRAY = create("frosting_gray",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_GRAY.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_GRAY))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_GREEN = create("frosting_green",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_GREEN.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_GREEN))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_LIGHT_BLUE = create("frosting_light_blue",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_LIGHT_BLUE.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIGHT_BLUE))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_LIGHT_GRAY = create("frosting_light_gray",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_LIGHT_GRAY.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIGHT_GRAY))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_LIME = create("frosting_lime",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_LIME.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIME))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_MAGENTA = create("frosting_magenta",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_MAGENTA.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_MAGENTA))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_ORANGE = create("frosting_orange",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_ORANGE.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_ORANGE))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_PINK = create("frosting_pink",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_PINK.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_PINK))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_PURPLE = create("frosting_purple",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_PURPLE.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_PURPLE))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_RED = create("frosting_red",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_RED.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_RED))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_WHITE = create("frosting_white",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_WHITE.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_WHITE))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			FROSTING_YELLOW = create("frosting_yellow",
					b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_YELLOW.get(), 4))
							.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_YELLOW))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			BEET_MINT_SALAD = create("beet_mint_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.BEET_MINT_SALAD.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_BEETROOT))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_BEETROOT))
							.require(Ingredient.of(ExtraDelightTags.MINT))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			COFFEE_JELLY = create("coffee_jelly",
					b -> b.output(new ItemStack(ExtraDelightItems.COFFEE_JELLY.get(), 2)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.GELATIN))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(ExtraDelightFluids.COFFEE.FLUID.get(), 250)
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)),

			MARSHMALLOW = create("marshmallow",
					b -> b.output(new ItemStack(ExtraDelightItems.MARSHMALLOW.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.MALLOWROOT_POWDER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Fluids.WATER, 250)),

			NOUGAT = create("nougat",
					b -> b.output(new ItemStack(ExtraDelightItems.NOUGAT.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.ROASTED_NUTS)).require(Fluids.WATER, 250)),

			GUMMIES = create("gummies", b -> b.output(new ItemStack(ExtraDelightItems.GUMMIES.get(), 4))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.GELATIN))
					.require(Ingredient.of(ExtraDelightTags.GELATIN)).require(Ingredient.of(Tags.Items.DYES))
					.require(Ingredient.of(Tags.Items.DYES)).require(Fluids.WATER, 100)),

			WHITE_CHOCOLATE = create("white_chocolate",
					b -> b.output(new ItemStack(ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_BOTTLE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), 100)
							.require(NeoForgeMod.MILK.get(), 100)),

			MILK_CHOCOLATE = create("milk_chocolate",
					b -> b.output(new ItemStack(ExtraDelightItems.MILK_CHOCOLATE_SYRUP_BOTTLE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.COCOA_SOLIDS))
							.require(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), 100)
							.require(NeoForgeMod.MILK.get(), 50)),

			DARK_CHOCOLATE = create("dark_chocolate",
					b -> b.output(new ItemStack(ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.COCOA_SOLIDS))
							.require(Ingredient.of(ExtraDelightTags.COCOA_SOLIDS))
							.require(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), 100)),

			BLOOD_CHOCOLATE = create("blood_chocolate",
					b -> b.output(new ItemStack(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.COCOA_SOLIDS))
							.require(ExtraDelightFluids.COCOA_BUTTER.FLUID.get(), 100)
							.require(ExtraDelightTags.BLOOD, 50)),

			PULLED_PORK = create("pulled_pork",
					b -> b.output(new ItemStack(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.SCRAP_PORK_COOKED))
							.require(Ingredient.of(ExtraDelightTags.SCRAP_PORK_COOKED))
							.require(Ingredient.of(ExtraDelightTags.SCRAP_PORK_COOKED))
							.require(Ingredient.of(ExtraDelightTags.SCRAP_PORK_COOKED))
							.require(ExtraDelightFluids.BBQ.FLUID.get(), 250)),

			HAZELNUT_SPREAD = create("hazelnut_spread",
					b -> b.output(new ItemStack(ExtraDelightItems.HAZELNUT_SPREAD_BOTTLE.get(), 2))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(ExtraDelightTags.CHOCOLATE_FLUID, 250)
							.require(ExtraDelightFluids.NUT_BUTTER.FLUID.get(), 250)),

			APPLE_SLAW = create("apple_slaw",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_SLAW.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
							.require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			CANDY_BAR_SALAD = create("candy_bar_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_BAR_SALAD.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_BAR))
							.require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.CUSTARD))
							.require(Ingredient.of(ExtraDelightTags.MARSHMALLOW))
							.require(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250)
							.require(ExtraDelightFluids.CARAMEL_SAUCE.FLUID.get(), 250)),

			NUT_BUTTER_COOKIE_DOUGH = create("nut_butter_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(ExtraDelightFluids.NUT_BUTTER.FLUID.get(), 250)),

			NUT_BUTTER_COOKIE_DOUGH_SUGAR = create("nut_butter_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(ExtraDelightFluids.NUT_BUTTER.FLUID.get(), 250)),

			NUT_BUTTER_MILKSHAKE = create("nut_butter_milkshake",
					b -> b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.ICE_CREAM.get()))
							.require(ExtraDelightFluids.NUT_BUTTER.FLUID.get(), 250)
							.require(NeoForgeMod.MILK.get(), 250)),

			NUT_BUTTER_MILKSHAKE_ICE_CREAM = create("nut_butter_milkshake_ice_cream",
					b -> b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_MILKSHAKE.get(), 1))
							.require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.NUT_BUTTER_ICE_CREAM.get()))
							.require(NeoForgeMod.MILK.get(), 250)),

			CHOCOLATE_COOKIE_DOUGH = create("chocolate_cookie_dough",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))),

			CHOCOLATE_COOKIE_DOUGH_SUGAR = create("chocolate_cookie_dough_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_COOKIE_DOUGH.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.SUGAR_COOKIE_DOUGH))
							.require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))),

			POTATO_SALAD = create("potato_salad",
					b -> b.output(new ItemStack(ExtraDelightItems.POTATO_SALAD.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(Items.BAKED_POTATO)).require(Ingredient.of(Items.BAKED_POTATO))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)),

			AIOLI_FROM_SCRATCH = create("aioli_from_scratch",
					b -> b.output(new ItemStack(ExtraDelightItems.AIOLI.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))
							.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)),

			AIOLI_CHEATY = create("aioli_cheaty",
					b -> b.output(new ItemStack(ExtraDelightItems.AIOLI.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))
							.require(ExtraDelightFluids.MAYO.FLUID.get(), 250)),

			AGLIO_E_OLIO_MIXING = create("aglio_e_olio_mixing",
					b -> b.output(new ItemStack(ExtraDelightItems.AGLIO_E_OLIO.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.COOKED_PASTA))
							.require(Ingredient.of(ExtraDelightItems.ROASTED_GARLIC))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250)),

			CHOCOLATE_CUSTARD = create("chocolate_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			PUMPKIN_CUSTARD = create("pumpkin_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.PUMPKIN_CUSTARD.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			HONEY_CUSTARD = create("honey_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.HONEY_CUSTARD.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(Items.HONEY_BOTTLE)).require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.requiresHeat(HeatCondition.HEATED)),

			SWEET_BERRY_CUSTARD = create("sweet_berry_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.SWEET_BERRIES))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			APPLE_CUSTARD = create("apple_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_CUSTARD.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			KETCHUP = create("ketchup_jar", b -> b.output(new ItemStack(ExtraDelightItems.KETCHUP.get(), 1))
					.require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_TOMATO))
					.require(Ingredient.of(CommonTags.FOODS_TOMATO)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.VINEGAR)).requiresHeat(HeatCondition.HEATED)),

			BBQ_SAUCE = create("bbq_sugar", b -> b.output(new ItemStack(ExtraDelightItems.BBQ_SAUCE.get(), 1))
					.require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_TOMATO))
					.require(Ingredient.of(CommonTags.FOODS_ONION)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.VINEGAR)).requiresHeat(HeatCondition.HEATED)),

			BONE_BROTH = create("stock",
					b -> b.output(new ItemStack(ModItems.BONE_BROTH.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(Items.BONE)).require(Ingredient.of(ExtraDelightTags.MAKES_STOCK))
							.requiresHeat(HeatCondition.HEATED)),

			GRAVY = create("gravy_boat",
					b -> b.output(new ItemStack(ExtraDelightItems.GRAVY.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.BROTH)).requiresHeat(HeatCondition.HEATED)),

			SALISBURY_STEAK_FEAST_ITEM = create("salisbury_steak_feast",
					b -> b.output(new ItemStack(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(), 1))
							.require(Items.BOWL).require(Ingredient.of(ModItems.MINCED_BEEF.get()))
							.require(Ingredient.of(ModItems.MINCED_BEEF.get()))
							.require(Ingredient.of(ModItems.MINCED_BEEF.get()))
							.require(Ingredient.of(CommonTags.FOODS_ONION)).require(Ingredient.of(Tags.Items.MUSHROOMS))
							.require(Ingredient.of(ExtraDelightItems.GRAVY.get())).requiresHeat(HeatCondition.HEATED)),

			MASHED_POTATO_GRAVY_FEAST_ITEM = create("mashed_potato_gravy_feast",
					b -> b.output(new ItemStack(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(), 1))
							.require(Items.BOWL).require(Ingredient.of(Items.POTATO))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(Items.POTATO))
							.require(Ingredient.of(ExtraDelightItems.GRAVY.get()))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).requiresHeat(HeatCondition.HEATED)),

			FRENCH_FRIES = create("fries",
					b -> b.output(new ItemStack(ExtraDelightItems.FRENCH_FRIES.get(), 1))
							.require(Ingredient.of(ExtraDelightItems.POTATO_STICKS.get()))
							.require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).requiresHeat(HeatCondition.HEATED)),

			POTATO_CHIPS = create("chips",
					b -> b.output(new ItemStack(ExtraDelightItems.POTATO_CHIPS.get(), 1))
							.require(Ingredient.of(ExtraDelightItems.SLICED_POTATO.get()))
							.require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).requiresHeat(HeatCondition.HEATED)),

			CHEESE = create("cheese_vinegar",
					b -> b.output(new ItemStack(ExtraDelightItems.CHEESE.get(), 2))
							.require(Ingredient.of(Items.MILK_BUCKET)).require(Ingredient.of(ExtraDelightTags.VINEGAR))
							.requiresHeat(HeatCondition.HEATED)),

			BEEF_STEW_FEAST = create("beef_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.BEEF_STEW_FEAST.get(), 1))
							.require(Ingredient.of(Items.BEEF)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			PORK_STEW_FEAST = create("pork_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.PORK_STEW_FEAST.get(), 1))
							.require(Ingredient.of(Items.PORKCHOP)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			LAMB_STEW_FEAST = create("mutton_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.LAMB_STEW_FEAST.get(), 1))
							.require(Ingredient.of(Items.MUTTON)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			RABBIT_STEW_FEAST = create("rabbit_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.RABBIT_STEW_FEAST.get(), 1))
							.require(Ingredient.of(Items.RABBIT)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			CHICKEN_STEW_FEAST = create("chicken_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.CHICKEN_STEW_FEAST.get(), 1))
							.require(Ingredient.of(Items.CHICKEN)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			FISH_STEW_FEAST = create("fish_stew",
					b -> b.output(new ItemStack(ExtraDelightItems.FISH_STEW_FEAST.get(), 1))
							.require(Ingredient.of(CommonTags.FOODS_SAFE_RAW_FISH)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.FLOUR)).requiresHeat(HeatCondition.HEATED)),

			STIRFRY_FEAST_ITEM = create("stirfry_feast",
					b -> b.output(new ItemStack(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.MEAT_RAW))
							.require(Ingredient.of(ExtraDelightTags.MEAT_RAW))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).requiresHeat(HeatCondition.HEATED)),

			FRIED_FISH = create("fried_fish",
					b -> b.output(new ItemStack(ExtraDelightItems.FRIED_FISH.get(), 1))
							.require(Ingredient.of(ItemTags.FISHES))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			CHICKEN_FRIED_STEAK = create("chicken_fried_steak",
					b -> b.output(new ItemStack(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(), 1))
							.require(Ingredient.of(Items.BEEF))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.require(Ingredient.of(ExtraDelightItems.GRAVY.get())).requiresHeat(HeatCondition.HEATED)),

			PORK_TENDERLOIN = create("pork_tenderloin",
					b -> b.output(new ItemStack(ExtraDelightItems.PORK_TENDERLOIN.get(), 1))
							.require(Ingredient.of(Items.PORKCHOP))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			FRIED_CHICKEN = create("fried_chicken",
					b -> b.output(new ItemStack(ExtraDelightItems.FRIED_CHICKEN.get(), 1))
							.require(Ingredient.of(ModItems.CHICKEN_CUTS.get()))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			CARROT_SOUP = create("carrot_soup", b -> b
					.output(new ItemStack(ExtraDelightItems.CARROT_SOUP.get(), 2)).require(Items.BOWL)
					.require(Ingredient.of(Tags.Items.CROPS_CARROT)).require(Ingredient.of(Tags.Items.CROPS_CARROT))
					.require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(CommonTags.FOODS_MILK)).requiresHeat(HeatCondition.HEATED)),

			FISH_SOUP = create("fish_soup", b -> b.output(new ItemStack(ExtraDelightItems.FISH_SOUP.get(), 2))
					.require(Items.BOWL).require(Ingredient.of(ItemTags.FISHES)).require(Ingredient.of(ItemTags.FISHES))
					.require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(Items.DRIED_KELP)).requiresHeat(HeatCondition.HEATED)),

			POTATO_SOUP = create("potato_soup", b -> b
					.output(new ItemStack(ExtraDelightItems.POTATO_SOUP.get(), 2)).require(Items.BOWL)
					.require(Ingredient.of(Tags.Items.CROPS_POTATO)).require(Ingredient.of(Tags.Items.CROPS_POTATO))
					.require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(CommonTags.FOODS_MILK))),

			TOMATO_SOUP = create("tomato_soup", b -> b
					.output(new ItemStack(ExtraDelightItems.TOMATO_SOUP.get(), 2)).require(Items.BOWL)
					.require(Ingredient.of(CommonTags.CROPS_TOMATO)).require(Ingredient.of(CommonTags.CROPS_TOMATO))
					.require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(CommonTags.FOODS_MILK)).requiresHeat(HeatCondition.HEATED)),

			BOILED_EGG = create("boiled_egg",
					b -> b.output(new ItemStack(ExtraDelightItems.BOILED_EGG.get(), 1))
							.require(Ingredient.of(Tags.Items.EGGS)).requiresHeat(HeatCondition.HEATED)),

			GLOW_BERRY_JAM = create("glow_berry_jam",
					b -> b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_JAM.get(), 2)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(Items.GLOW_BERRIES)).require(Ingredient.of(Items.GLOW_BERRIES))
							.require(Ingredient.of(Items.GLOW_BERRIES))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			GOLDEN_APPLE_JAM = create("golden_apple_jam",
					b -> b.output(new ItemStack(ExtraDelightItems.GOLDEN_APPLE_JAM.get(), 2))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.GOLDEN_APPLE))
							.require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(Items.GOLDEN_APPLE))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			JAM = create("fruit_jam", b -> b.output(new ItemStack(ExtraDelightItems.JAM.get(), 2))
					.require(Items.GLASS_BOTTLE)
					.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),
							Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)))
					.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),

							Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)))
					.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE),

							Ingredient.of(Items.GOLDEN_APPLE, Items.GLOW_BERRIES, Items.ENCHANTED_GOLDEN_APPLE)))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			SEAWEED_PASTE = create("seaweed_paste",
					b -> b.output(new ItemStack(ExtraDelightItems.SEAWEED_PASTE.get(), 1))
							.require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(Items.DRIED_KELP))
							.require(Ingredient.of(Items.DRIED_KELP)).requiresHeat(HeatCondition.HEATED)),

			GLAZED_CARROT = create("glazed_carrot",
					b -> b.output(new ItemStack(ExtraDelightItems.GLAZED_CARROT.get(), 3)).require(Items.BOWL)
							.require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(Items.CARROT)).require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			APPLE_SAUCE = create("apple_sauce",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_SAUCE.get(), 4)).require(Items.BOWL)
							.require(Ingredient.of(Items.APPLE)).require(Ingredient.of(Items.APPLE))
							.require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.requiresHeat(HeatCondition.HEATED)),

			HASH_FEAST_ITEM = create("hash",
					b -> b.output(new ItemStack(ExtraDelightItems.HASH_FEAST_ITEM.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()))
							.require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()))
							.require(Ingredient.of(CommonTags.CROPS_ONION))
							.require(Ingredient.of(ExtraDelightTags.FRYING_OIL))
							.require(Ingredient.of(ExtraDelightTags.MEAT)).requiresHeat(HeatCondition.HEATED)),

			SEAWEED_CRISPS = create("seaweed_crisps",
					b -> b.output(new ItemStack(ExtraDelightItems.SEAWEED_CRISPS.get(), 1))
							.require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(Items.DRIED_KELP))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).requiresHeat(HeatCondition.HEATED)),

			MACARONI_CHEESE_FEAST = create("macaroni_cheese",
					b -> b.output(new ItemStack(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(), 1))
							.require(Ingredient.of(ExtraDelightItems.MACARONI.get()))
							.require(Ingredient.of(ExtraDelightItems.MACARONI.get()))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(Ingredient.of(ExtraDelightTags.CHEESE)).requiresHeat(HeatCondition.HEATED)),

			FISH_CAKES = create("fish_cakes", b -> b.output(new ItemStack(ExtraDelightItems.FISH_CAKES.get(), 3))
					.require(Ingredient.of(Tags.Items.FOODS_COOKED_FISH)).require(Ingredient.of(CommonTags.CROPS_ONION))
					.require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()))
					.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
					.requiresHeat(HeatCondition.HEATED)),

			FRIED_MUSHROOMS = create("fried_mushrooms",
					b -> b.output(new ItemStack(ExtraDelightItems.FRIED_MUSHROOMS.get(), 3))
							.require(Ingredient.of(Tags.Items.MUSHROOMS)).require(Ingredient.of(Tags.Items.MUSHROOMS))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			MUSHROOM_RISOTTO = create("mushroom_risotto", b -> b
					.output(new ItemStack(ExtraDelightItems.MUSHROOM_RISOTTO.get(), 2)).require(Items.BOWL)
					.require(Ingredient.of(Tags.Items.MUSHROOMS)).require(Ingredient.of(ExtraDelightTags.CHEESE))
					.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(CommonTags.CROPS_RICE))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).requiresHeat(HeatCondition.HEATED)),

			CURRY_FEAST = create("curry",
					b -> b.output(new ItemStack(ExtraDelightItems.CURRY_FEAST.get(), 1))
							.require(ExtraDelightItems.SERVING_POT).require(Ingredient.of(CommonTags.FOODS_RAW_CHICKEN))
							.require(Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(CommonTags.CROPS_ONION)).requiresHeat(HeatCondition.HEATED)),

			ALFREDO_SAUCE = create("alfredo_sauce",
					b -> b.output(new ItemStack(ExtraDelightItems.ALFREDO_SAUCE.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).requiresHeat(HeatCondition.HEATED)),

			COOKED_PASTA = create("cooked_pasta",
					b -> b.output(new ItemStack(ExtraDelightItems.COOKED_PASTA.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(CommonTags.FOODS_PASTA)).requiresHeat(HeatCondition.HEATED)),

			CACTUS_SOUP = create("cactus_soup",
					b -> b.output(new ItemStack(ExtraDelightItems.CACTUS_SOUP.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()))
							.require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH)).requiresHeat(HeatCondition.HEATED)),

			STUFFED_CACTUS = create("stuffed_cactus",
					b -> b.output(new ItemStack(ExtraDelightItems.STUFFED_CACTUS.get(), 1))
							.require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()))
							.require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()))
							.require(Ingredient.of(ExtraDelightTags.CHEESE))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			// Halloween Start!

			CARAMEL_SAUCE = create("caramel_sauce",
					b -> b.output(new ItemStack(ExtraDelightItems.CARAMEL_SAUCE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).requiresHeat(HeatCondition.HEATED)),

			CARAMEL_CANDY = create("caramel_candy",
					b -> b.output(new ItemStack(ExtraDelightItems.CARAMEL_CANDY.get(), 2)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()))
							.requiresHeat(HeatCondition.HEATED)),

			CANDY_APPLE = create("candy_apple",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.CANDY))
							.require(Ingredient.of(ExtraDelightTags.CANDY)).requiresHeat(HeatCondition.HEATED)),

			CANDY_APPLE_SUGAR = create("candy_apple_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.requiresHeat(HeatCondition.HEATED)),

			CARAMEL_APPLE = create("caramel_apple",
					b -> b.output(new ItemStack(ExtraDelightItems.CARAMEL_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.APPLE))
							.require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()))
							.requiresHeat(HeatCondition.HEATED)),

			CANDY_GOLDEN_APPLE = create("candy_golden_apple",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightTags.CANDY))
							.require(Ingredient.of(ExtraDelightTags.CANDY)).requiresHeat(HeatCondition.HEATED)),

			CANDY_GOLDEN_APPLE_SUGAR = create("candy_golden_apple_sugar",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.GOLDEN_APPLE))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			CARAMEL_GOLDEN_APPLE = create("caramel_golden_apple",
					b -> b.output(new ItemStack(ExtraDelightItems.CARAMEL_GOLDEN_APPLE.get(), 1)).require(Items.STICK)
							.require(Ingredient.of(Items.GOLDEN_APPLE))
							.require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()))
							.requiresHeat(HeatCondition.HEATED)),

			CORN_CHOWDER = create("corn_chowder",
					b -> b.output(new ItemStack(ExtraDelightItems.CORN_CHOWDER.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO))
							.require(CompoundIngredient.of(Ingredient.of(CommonTags.FOODS_COOKED_BACON)))
							.require(Ingredient.of(CommonTags.FOODS_RAW_BACON))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.BROTH)).requiresHeat(HeatCondition.HEATED)),

			CREAM_CORN = create("cream_corn",
					b -> b.output(new ItemStack(ExtraDelightItems.CREAM_CORN.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get()))
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).requiresHeat(HeatCondition.HEATED)),

			CORN_FRITTERS = create("corn_fritters", b -> b
					.output(new ItemStack(ExtraDelightItems.CORN_FRITTERS.get(), 1)).require(Items.BOWL)
					.require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get()))
					.require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightItems.EGG_MIX.get()))
					.require(Ingredient.of(ExtraDelightTags.FRYING_OIL))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).requiresHeat(HeatCondition.HEATED)),

			COOKED_CORN = create("corn",
					b -> b.output(new ItemStack(ExtraDelightItems.COOKED_CORN.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.CORN_SEEDS.get()))),

			STEWED_APPLES = create("stewed_apples",
					b -> b.output(new ItemStack(ExtraDelightItems.STEWED_APPLES.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).requiresHeat(HeatCondition.HEATED)),

			APPLE_FRITTERS = create("apple_fritters",
					b -> b.output(new ItemStack(ExtraDelightItems.APPLE_FRITTERS.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightItems.EGG_MIX.get()))
							.require(Ingredient.of(ExtraDelightTags.FRYING_OIL))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			CARAMEL_CUSTARD = create("caramel_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.CARAMEL_CUSTARD.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get()))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			STUFFING_FEAST = create("stuffing",
					b -> b.output(new ItemStack(ExtraDelightItems.STUFFING_FEAST.get(), 1))
							.require(Ingredient.of(ExtraDelightItems.CROUTONS.get()))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(Tags.Items.EGGS)).requiresHeat(HeatCondition.HEATED)),

			// Holiday

			EGGNOG = create("eggnog",
					b -> b.output(new ItemStack(ExtraDelightItems.EGGNOG.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ModItems.MILK_BOTTLE.get()))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))
							.require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.EGGS)).requiresHeat(HeatCondition.HEATED)),

			CANDY_BLACK = create("candy_black",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_BLACK.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BLACK)).requiresHeat(HeatCondition.HEATED)),

			CANDY_BLUE = create("candy_blue",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_BLUE.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BLUE)).requiresHeat(HeatCondition.HEATED)),

			CANDY_BROWN = create("candy_brown",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_BROWN.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BROWN)).requiresHeat(HeatCondition.HEATED)),

			CANDY_CYAN = create("candy_cyan",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_CYAN.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_CYAN)).requiresHeat(HeatCondition.HEATED)),

			CANDY_GRAY = create("candy_gray",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_GRAY.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_GRAY)).requiresHeat(HeatCondition.HEATED)),

			CANDY_GREEN = create("candy_green",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_GREEN.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_GREEN)).requiresHeat(HeatCondition.HEATED)),

			CANDY_LIGHT_BLUE = create("candy_light_blue",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_LIGHT_BLUE.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIGHT_BLUE)).requiresHeat(HeatCondition.HEATED)),

			CANDY_LIGHT_GRAY = create("candy_light_gray",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_LIGHT_GRAY.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIGHT_GRAY)).requiresHeat(HeatCondition.HEATED)),

			CANDY_LIME = create("candy_lime",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_LIME.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_LIME)).requiresHeat(HeatCondition.HEATED)),

			CANDY_MAGENTA = create("candy_magenta",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_MAGENTA.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_MAGENTA)).requiresHeat(HeatCondition.HEATED)),

			CANDY_ORANGE = create("candy_orange",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_ORANGE.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_ORANGE)).requiresHeat(HeatCondition.HEATED)),

			CANDY_PINK = create("candy_pink",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_PINK.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_PINK)).requiresHeat(HeatCondition.HEATED)),

			CANDY_PURPLE = create("candy_purple",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_PURPLE.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_PURPLE)).requiresHeat(HeatCondition.HEATED)),

			CANDY_RED = create("candy_red",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_RED.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_RED)).requiresHeat(HeatCondition.HEATED)),

			CANDY_WHITE = create("candy_white",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_WHITE.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_WHITE)).requiresHeat(HeatCondition.HEATED)),

			CANDY_YELLOW = create("candy_yellow",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDY_YELLOW.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_YELLOW)).requiresHeat(HeatCondition.HEATED)),

			GINGER_BEER = create("ginger_beer",
					b -> b.output(new ItemStack(ExtraDelightItems.GINGER_BEER.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightItems.YEAST.get())).requiresHeat(HeatCondition.HEATED)),

			HORCHATA = create("horchata",
					b -> b.output(new ItemStack(ExtraDelightItems.HORCHATA.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(CommonTags.CROPS_RICE))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).requiresHeat(HeatCondition.HEATED)),

			MINT_CANDY_BLUE = create("mint_candy_blue",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_BLUE.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_BLUE)).require(Ingredient.of(ExtraDelightTags.MINT))
							.requiresHeat(HeatCondition.HEATED)),

			MINT_CANDY_GREEN = create("mint_candy_green",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_GREEN.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_GREEN)).require(Ingredient.of(ExtraDelightTags.MINT))
							.requiresHeat(HeatCondition.HEATED)),

			MINT_CANDY_RED = create("mint_candy_red",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_RED.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(Tags.Items.DYES_RED)).require(Ingredient.of(ExtraDelightTags.MINT))
							.requiresHeat(HeatCondition.HEATED)),

			CONGEE = create("congee", b -> b.output(new ItemStack(ExtraDelightItems.CONGEE.get(), 1))
					.require(Items.BOWL).require(Ingredient.of(CommonTags.CROPS_RICE))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER)).requiresHeat(HeatCondition.HEATED)),

			LUGAW = create("lugaw", b -> b.output(new ItemStack(ExtraDelightItems.LUGAW.get(), 1))
					.require(Items.BOWL).require(Ingredient.of(CommonTags.CROPS_RICE))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
					.require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(ExtraDelightItems.BOILED_EGG.get()))
					.require(Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN)).requiresHeat(HeatCondition.HEATED)),

			RICE_PUDDING = create("rice_pudding", b -> b
					.output(new ItemStack(ExtraDelightItems.RICE_PUDDING.get(), 1)).require(Items.GLASS_BOTTLE)
					.require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(CommonTags.CROPS_RICE))
					.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON)).requiresHeat(HeatCondition.HEATED)),

			CANDIED_GINGER = create("candied_ginger",
					b -> b.output(new ItemStack(ExtraDelightItems.CANDIED_GINGER.get(), 4)).require(Items.PAPER)
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			MINT_JELLY = create("mint_jelly",
					b -> b.output(new ItemStack(ExtraDelightItems.MINT_JELLY.get(), 2)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.MINT)).require(Ingredient.of(ExtraDelightTags.MINT))
							.require(Ingredient.of(ExtraDelightTags.MINT))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			XOCOLATL = create("xocolatl",
					b -> b.output(new ItemStack(ExtraDelightItems.XOCOLATL.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP))
							.require(Ingredient.of(ExtraDelightTags.CHILI_POWDER)).requiresHeat(HeatCondition.HEATED)),

			HOT_COCOA = create("hot_cocoa", b -> b.output(new ItemStack(ModItems.HOT_COCOA.get(), 1))
					.require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_MILK))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER))
					.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP)).requiresHeat(HeatCondition.HEATED)),

			XOCOLATL_BEANS = create("xocolatl_beans",
					b -> b.output(new ItemStack(ExtraDelightItems.XOCOLATL.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))
							.require(Ingredient.of(ExtraDelightTags.CHILI_POWDER)).requiresHeat(HeatCondition.HEATED)),

			PEANUT_BRITTLE = create("peanut_brittle",
					b -> b.output(new ItemStack(ExtraDelightItems.PEANUT_BRITTLE.get(), 4))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(ExtraDelightTags.ROASTED_NUTS)).requiresHeat(HeatCondition.HEATED)),

			BUTTERSCOTCH = create("butterscotch",
					b -> b.output(new ItemStack(ExtraDelightItems.BUTTERSCOTCH.get(), 2))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).requiresHeat(HeatCondition.HEATED)),

			COFFEE = create("coffee",
					b -> b.output(new ItemStack(ExtraDelightItems.COFFEE.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.GROUND_COFFEE_BEANS))
							.requiresHeat(HeatCondition.HEATED)),

			TEA = create("tea",
					b -> b.output(new ItemStack(ExtraDelightItems.TEA.get(), 1)).require(Items.GLASS_BOTTLE)
							.require(Ingredient.of(ExtraDelightTags.TEA_INGREDIENTS))
							.require(Ingredient.of(ExtraDelightTags.TEA_INGREDIENTS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			CRISP_RICE_TREATS_BLOCK = create("crisp_rice_treats",
					b -> b.output(new ItemStack(ExtraDelightItems.CRISP_RICE_TREATS_BLOCK.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.PUFFED_RICE))
							.require(Ingredient.of(ExtraDelightTags.MARSHMALLOW))
							.require(Ingredient.of(ExtraDelightTags.BUTTER)).requiresHeat(HeatCondition.HEATED)),

			SCOTCHAROO_BLOCK = create("scotcharoos",
					b -> b.output(new ItemStack(ExtraDelightItems.SCOTCHAROO_BLOCK.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.PUFFED_RICE))
							.require(Ingredient.of(ExtraDelightTags.MARSHMALLOW))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(ExtraDelightTags.BUTTERSCOTCH))
							.require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP))
							.require(Ingredient.of(ExtraDelightTags.NUT_BUTTER)).requiresHeat(HeatCondition.HEATED)),

			SOS = create("sos", b -> b.output(new ItemStack(ExtraDelightItems.SOS.get(), 1))
					.require(ExtraDelightItems.BREAD_SLICE.get()).require(Ingredient.of(ExtraDelightTags.SCRAP_BEEF))
					.require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(CommonTags.FOODS_MILK))
					.requiresHeat(HeatCondition.HEATED)),

			OXTAIL_SOUP = create("oxtail_soup",
					b -> b.output(new ItemStack(ExtraDelightItems.OXTAIL_SOUP.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.OXTAIL)).require(Ingredient.of(Items.CARROT))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO))
							.requiresHeat(HeatCondition.HEATED)),

			LIVER_ONIONS = create("liver_onions",
					b -> b.output(new ItemStack(ExtraDelightItems.LIVER_ONIONS.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.LIVER))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.requiresHeat(HeatCondition.HEATED)),

			FRIED_BRAINS = create("fried_brains",
					b -> b.output(new ItemStack(ExtraDelightItems.FRIED_BRAINS.get(), 1))
							.require(Ingredient.of(ExtraDelightTags.BRAIN))
							.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
							.requiresHeat(HeatCondition.HEATED)),

			MULLIGATAWNY_SOUP = create("mulligatawny_soup",
					b -> b.output(new ItemStack(ExtraDelightItems.MULLIGATAWNY_SOUP.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()))
							.require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(CommonTags.FOODS_RAW_CHICKEN))
							.require(Ingredient.of(ModItems.RICE.get())).requiresHeat(HeatCondition.HEATED)),

			AEBLEFLAESK = create("aebleflaesk",
					b -> b.output(new ItemStack(ExtraDelightItems.AEBLEFLAESK.get(), 1))
							.require(ExtraDelightItems.TOAST).require(Ingredient.of(ExtraDelightTags.SLICED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ModItems.BACON.get())).require(Ingredient.of(Items.SUGAR))
							.requiresHeat(HeatCondition.HEATED)),

			CHILI_CON_CARNE_FEAST = create("chili_con_carne", b -> b
					.output(new ItemStack(ExtraDelightItems.CHILI_CON_CARNE_FEAST.get(), 1))
					.require(Ingredient.of(ModItems.TOMATO_SAUCE.get())).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(ExtraDelightTags.MEAT)).require(Ingredient.of(ExtraDelightTags.CHILI_POWDER))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).requiresHeat(HeatCondition.HEATED)),

			WHITE_CHILI_FEAST = create("white_chili",
					b -> b.output(new ItemStack(ExtraDelightItems.WHITE_CHILI_FEAST.get(), 1))
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).requiresHeat(HeatCondition.HEATED)),

			NUT_BUTTER_CUSTARD = create("nut_butter_custard",
					b -> b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_CUSTARD.get(), 1))
							.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.NUT_BUTTER))
							.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).requiresHeat(HeatCondition.HEATED)),

			HAZELNUT_SOUP = create("hazelnut_soup",
					b -> b.output(new ItemStack(ExtraDelightItems.HAZELNUT_SOUP.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.ROASTED_HAZELNUTS))
							.require(Ingredient.of(CommonTags.FOODS_MILK))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO))
							.require(Ingredient.of(ExtraDelightTags.BUTTER))
							.require(Ingredient.of(CommonTags.FOODS_COOKED_BACON)).requiresHeat(HeatCondition.HEATED)),

			ONION_SOUP = create("onion_soup", b -> b.output(new ItemStack(ExtraDelightItems.ONION_SOUP.get(), 3))
					.require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
					.require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BROTH))
					.require(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
					.require(Ingredient.of(ExtraDelightTags.CHEESE)).requiresHeat(HeatCondition.HEATED)),

			ONION_BHAJI = create("onion_bhaji",
					b -> b.output(new ItemStack(ExtraDelightItems.ONION_BHAJI.get(), 2))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.FLOUR))
							.require(Ingredient.of(ExtraDelightItems.CURRY_POWDER))
							.require(Ingredient.of(ExtraDelightTags.COOKING_OIL)).requiresHeat(HeatCondition.HEATED)),

			PAMONHA = create("pamonha", b -> b.output(new ItemStack(ExtraDelightItems.PAMONHA.get(), 2))
					.require(Ingredient.of(ExtraDelightTags.CORN_KERNELS))
					.require(Ingredient.of(ExtraDelightTags.CORN_KERNELS)).require(Ingredient.of(CommonTags.FOODS_MILK))
					.require(Ingredient.of(ExtraDelightItems.CORN_HUSK)).requiresHeat(HeatCondition.HEATED)),

			BORSCHT = create("borscht",
					b -> b.output(new ItemStack(ExtraDelightItems.BORSCHT.get(), 4)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_BEETROOT))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO))
							.require(Ingredient.of(ExtraDelightItems.SLICED_TOMATO, ModItems.TOMATO_SAUCE.get(),
									ModItems.TOMATO.get()))
							.requiresHeat(HeatCondition.HEATED)),

			DEVILLED_SAUSAGES = create("devilled_sausages",
					b -> b.output(new ItemStack(ExtraDelightItems.DEVILLED_SAUSAGES.get(), 2)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightTags.BROTH))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
							.require(Ingredient.of(ExtraDelightTags.SAUSAGE_RAW))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))
							.requiresHeat(HeatCondition.HEATED)),

			AGLIO_E_OLIO = create("aglio_e_olio",
					b -> b.output(new ItemStack(ExtraDelightItems.AGLIO_E_OLIO.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ModItems.RAW_PASTA.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))
							.require(Ingredient.of(ExtraDelightTags.COOKING_OIL))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI))
							.require(Ingredient.of(ExtraDelightTags.CHEESE)).requiresHeat(HeatCondition.HEATED)),

			PENNE_ALL_ARRABIATA = create("penne_all_arrabbiata",
					b -> b.output(new ItemStack(ExtraDelightItems.PENNE_ALL_ARRABIATA.get(), 1)).require(Items.BOWL)
							.require(Ingredient.of(ExtraDelightItems.PENNE.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))
							.require(Ingredient.of(ModItems.TOMATO_SAUCE.get()))
							.require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI))
							.require(Ingredient.of(ExtraDelightTags.COOKING_OIL)).requiresHeat(HeatCondition.HEATED));
}

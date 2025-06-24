package com.lance5057.extradelight.data.compat.create;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class CreateMixingRecipes extends MixingRecipeGen {

	public CreateMixingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
			String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

	public

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

			FISH_SALAD = create("",
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

			FURIKAKE_RICE = create("",
					b -> b.output(new ItemStack(ExtraDelightItems.FURIKAKE.get(), 4)).require(Items.BOWL)
							.require(Ingredient.of(Items.KELP)).require(Ingredient.of(Items.KELP))
							.require(Ingredient.of(ExtraDelightTags.FISH_FLAKES))
							.require(Ingredient.of(ExtraDelightTags.FISH_FLAKES))),

			SALAD_MEAT = create("salad_meat", b -> b.output(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1))
					.require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT))
					.require(Ingredient.of(ExtraDelightTags.CROUTONS)).require(Ingredient.of(ExtraDelightTags.CHEESE))
					.require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
					.require(Ingredient.of(ExtraDelightTags.MEAT_COOKED))
					.require(ExtraDelightFluids.OIL.FLUID.get(), 250)
					.require(ExtraDelightFluids.VINEGAR.FLUID.get(), 250)),

			SALAD_VEG = create("salad_veg", b -> b.output(new ItemStack(ExtraDelightItems.SALAD_FEAST_ITEM.get(), 1))
					.require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
					.require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT))
					.require(Ingredient.of(ExtraDelightItems.CROUTONS.get()))
					.require(Ingredient.of(ExtraDelightTags.CHEESE)).require(Ingredient.of(ExtraDelightTags.BOILED_EGG))
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

			FROSTING_RED = create("frosting_red", b -> b.output(new ItemStack(ExtraDelightItems.FROSTING_RED.get(), 4))
					.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
					.require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_RED))
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
							.require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Fluids.WATER, 100)
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
							.require(ExtraDelightFluids.OIL.FLUID.get(), 250));
}

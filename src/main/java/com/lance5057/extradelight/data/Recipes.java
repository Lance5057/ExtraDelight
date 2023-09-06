package com.lance5057.extradelight.data;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.data.recipebuilders.DoughShapingRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.DryingRackRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.DynamicNameSmeltingRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MixingBowlRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MortarRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookTab;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.DifferenceIngredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class Recipes extends RecipeProvider implements IConditionBuilder {
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	public static final int FAST_COOKING = 400; // 20 seconds
	public static final int NORMAL_COOKING = 800; // 40 seconds
	public static final int SLOW_COOKING = 1600; // 80 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

	public static final int FAST_GRIND = 2;
	public static final int STANDARD_GRIND = 4;
	public static final int LONG_GRIND = 8;

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
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

		AestheticBlocks.Recipes(consumer);
	}

	private void feastRecipes(Consumer<FinishedRecipe> consumer) {
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.MEAT_LOAF.get(),
						ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ForgeTags.BREAD), ExtraDelightItems.MEAT_LOAF_SANDWICH.get(),
						ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf_sandwich"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.BREAD_SLICE), ExtraDelightItems.MEAT_LOAF_SANDWICH.get(),
						ExtraDelightItems.MEAT_LOAF_FEAST.get())
				.unlockedBy("has_meatloaf", has(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf_sandwich_slice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ModItems.BEEF_STEW.get(), ExtraDelightItems.BEEF_STEW_FEAST.get())
				.unlockedBy("has_beef_stew", has(ExtraDelightItems.BEEF_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "beef_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.BEEF_STEW_RICE.get(),
						ExtraDelightItems.BEEF_STEW_FEAST.get())
				.unlockedBy("has_beef_stew", has(ExtraDelightItems.BEEF_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "beef_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.PORK_STEW.get(),
						ExtraDelightItems.PORK_STEW_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.PORK_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.PORK_STEW_RICE.get(),
						ExtraDelightItems.PORK_STEW_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.PORK_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.CHICKEN_STEW.get(),
						ExtraDelightItems.CHICKEN_STEW_FEAST.get())
				.unlockedBy("has_chicken_stew", has(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.CHICKEN_STEW_RICE.get(),
						ExtraDelightItems.CHICKEN_STEW_FEAST.get())
				.unlockedBy("has_chicken_stew", has(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), Items.RABBIT_STEW, ExtraDelightItems.RABBIT_STEW_FEAST.get())
				.unlockedBy("has_rabbit_stew", has(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rabbit_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.RABBIT_STEW_RICE.get(),
						ExtraDelightItems.RABBIT_STEW_FEAST.get())
				.unlockedBy("has_rabbit_stew", has(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rabbit_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ModItems.FISH_STEW.get(), ExtraDelightItems.FISH_STEW_FEAST.get())
				.unlockedBy("has_fish_stew", has(ExtraDelightItems.FISH_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.FISH_STEW_RICE.get(),
						ExtraDelightItems.FISH_STEW_FEAST.get())
				.unlockedBy("has_fish_stew", has(ExtraDelightItems.FISH_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.LAMB_STEW.get(),
						ExtraDelightItems.LAMB_STEW_FEAST.get())
				.unlockedBy("has_lamb_stew", has(ExtraDelightItems.LAMB_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lamb_stew_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.LAMB_STEW_RICE.get(),
						ExtraDelightItems.LAMB_STEW_FEAST.get())
				.unlockedBy("has_lamb_stew", has(ExtraDelightItems.LAMB_STEW_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lamb_stew_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.CURRY.get(), ExtraDelightItems.CURRY_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.CURRY_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "curry_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.CURRY_RICE.get(),
						ExtraDelightItems.CURRY_FEAST.get())
				.unlockedBy("has_pork_stew", has(ExtraDelightItems.CURRY_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "curry_rice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.HOTDISH.get(),
						ExtraDelightItems.HOTDISH_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HOTDISH_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "hotdish_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.MACARONI_CHEESE.get(),
						ExtraDelightItems.MACARONI_CHEESE_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mac_cheese_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.LASAGNA.get(),
						ExtraDelightItems.LASAGNA_FEAST.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.LASAGNA_FEAST.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lasagna_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.HASH.get(), ExtraDelightItems.HASH_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HASH_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "hash_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.POT_ROAST.get(),
						ExtraDelightItems.POT_ROAST_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pot_roast_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.SALISBURY_STEAK.get(),
						ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salisbury_steak_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ForgeTags.BREAD), ExtraDelightItems.PULLED_PORK_SANDWICH.get(),
						ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_bread"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.BREAD_SLICE), ExtraDelightItems.PULLED_PORK_SANDWICH.get(),
						ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_bread_slice"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.RACK_LAMB.get(),
						ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rack_lamb_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.BEEF_WELLINGTON.get(),
						ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "beef_wellington_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.HAGGIS.get(),
						ExtraDelightItems.HAGGIS_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.HAGGIS_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "haggis_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(ModItems.COOKED_RICE.get()), ExtraDelightItems.STIRFRY.get(),
						ExtraDelightItems.STIRFRY_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.STIRFRY_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stirfry_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.BBQ_RIBS.get(),
						ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "ribs_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.MASHED_POTATO_GRAVY.get(),
						ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mashed_potato_gravy_bowl"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), ExtraDelightItems.SALAD.get(),
						ExtraDelightItems.SALAD_FEAST_ITEM.get())
				.unlockedBy("has_hotdish", has(ExtraDelightItems.SALAD_FEAST_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salad_bowl"));
	}

	private void doughShapeRecipes(Consumer<FinishedRecipe> consumer) {
		DoughShapingRecipeBuilder.shape(Ingredient.of(ModItems.WHEAT_DOUGH.get()), ExtraDelightItems.MACARONI.get(), 1)
				.unlockedBy("has_dough", has(ModItems.WHEAT_DOUGH.get())).save(consumer);
		DoughShapingRecipeBuilder
				.shape(Ingredient.of(ModItems.WHEAT_DOUGH.get()), ExtraDelightItems.LASAGNA_NOODLES.get(), 1)
				.unlockedBy("has_dough", has(ModItems.WHEAT_DOUGH.get())).save(consumer);
		DoughShapingRecipeBuilder.shape(Ingredient.of(ModItems.WHEAT_DOUGH.get()), ModItems.RAW_PASTA.get(), 1)
				.unlockedBy("has_dough", has(ModItems.WHEAT_DOUGH.get())).save(consumer);
	}

	private void dryingRackRecipes(Consumer<FinishedRecipe> consumer) {
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.WET_SPONGE), Items.SPONGE, 10, 1000)
				.unlockedBy("has_sponge", has(Items.WET_SPONGE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sponge"));
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.KELP), Items.DRIED_KELP, 10, 1000)
				.unlockedBy("has_kelp", has(Items.KELP))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "dried_kelp"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ExtraDelightItems.SEAWEED_PASTE.get()), ExtraDelightItems.AGAR_SHEETS.get(), 10,
						1000)
				.unlockedBy("has_paste", has(ExtraDelightItems.SEAWEED_PASTE.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "agar_sheets"));

		DryingRackRecipeBuilder
				.drying(Ingredient.of(ForgeTags.COOKED_FISHES), ExtraDelightItems.FISH_FLAKES.get(), 10, 1000)
				.unlockedBy("has_fish", has(ForgeTags.COOKED_FISHES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_flakes"));

		DryingRackRecipeBuilder.drying(Ingredient.of(ExtraDelightTags.MEAT), ExtraDelightItems.JERKY.get(), 10, 1000)
				.unlockedBy("has_meat", has(ExtraDelightTags.MEAT))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "jerky"));

	}

	private void cookingRecipes(Consumer<FinishedRecipe> consumer) {
		dynamicCooking(Ingredient.of(ExtraDelightItems.OMELETTE_MIX.get()), ExtraDelightItems.OMELETTE.get(), consumer,
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
	}

	private void vanillaCooking(Ingredient of, @NotNull Item item, Consumer<FinishedRecipe> consumer, String name) {
		SimpleCookingRecipeBuilder.campfireCooking(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_fire"));
		SimpleCookingRecipeBuilder.smelting(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_smelt"));
		SimpleCookingRecipeBuilder.smoking(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_smoke"));
	}

	private void dynamicCooking(Ingredient of, @NotNull Item item, Consumer<FinishedRecipe> consumer, String name) {
		DynamicNameSmeltingRecipeBuilder.campfireCooking(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_fire"));
		DynamicNameSmeltingRecipeBuilder.smelting(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_smelt"));
		DynamicNameSmeltingRecipeBuilder.smoking(of, item, MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, name + "_smoke"));
	}

	private void mixingbowlRecipes(Consumer<FinishedRecipe> consumer) {

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.EGG_MIX.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(Ingredient.of(ForgeTags.MILK)).requires(Ingredient.of(ForgeTags.EGGS))
				.requires(Ingredient.of(ForgeTags.EGGS)).unlockedBy(getName(), has(ForgeTags.EGGS))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/egg_mix"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.MAYO.get(), LONG_GRIND, Ingredient.of(Items.GLASS_BOTTLE), 1)
				.requires(Ingredient.of(ForgeTags.EGGS), 2).requires(Ingredient.of(ExtraDelightTags.COOKING_OIL))
				.requires(Ingredient.of(ExtraDelightTags.VINEGAR)).unlockedBy(getName(), has(ForgeTags.EGGS))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/mayo"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.CARROT_SALAD.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(Ingredient.of(ExtraDelightItems.GRATED_CARROT.get()), 2)
				.requires(Ingredient.of(ExtraDelightItems.SLICED_APPLE.get()))
				.requires(Ingredient.of(ExtraDelightTags.MAYO))
				.unlockedBy(getName(), has(ExtraDelightItems.GRATED_CARROT.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/carrot_salad"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.EGG_SALAD.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(Ingredient.of(ExtraDelightItems.BOILED_EGG.get()), 2)
				.requires(Ingredient.of(ExtraDelightTags.MAYO))
				.unlockedBy(getName(), has(ExtraDelightItems.BOILED_EGG.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/egg_salad"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.FISH_SALAD.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 2)
				.requires(Ingredient.of(ForgeTags.COOKED_FISHES), 2).requires(Ingredient.of(ExtraDelightTags.MAYO))
				.unlockedBy(getName(), has(ExtraDelightItems.BOILED_EGG.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/fish_salad"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.BUTTER.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(Ingredient.of(ExtraDelightItems.WHIPPED_CREAM.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.WHIPPED_CREAM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/butter"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.WHIPPED_CREAM.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(Ingredient.of(ModItems.MILK_BOTTLE.get()))
				.unlockedBy(getName(), has(ModItems.MILK_BOTTLE.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/whippedcream_bottle"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.WHIPPED_CREAM.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 4)
				.requires(Ingredient.of(Items.MILK_BUCKET)).unlockedBy(getName(), has(Items.MILK_BUCKET))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/whippedcream_bucket"));

		MixingBowlRecipeBuilder
				.stir(ExtraDelightItems.SEAWEED_SALAD.get(), STANDARD_GRIND, Ingredient.of(Items.BOWL), 2)
				.requires(Ingredient.of(Items.KELP)).requires(Ingredient.of(Items.KELP))
				.requires(Ingredient.of(ExtraDelightItems.GRATED_CARROT.get()))
				.requires(Ingredient.of(ExtraDelightItems.VINEGAR.get())).unlockedBy(getName(), has(Items.KELP))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/seaweed_salad"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.FURIKAKE.get(), STANDARD_GRIND, Ingredient.of(Items.BOWL), 4)
				.requires(Ingredient.of(Items.KELP)).requires(Ingredient.of(Items.KELP))
				.requires(Ingredient.of(ExtraDelightItems.FISH_FLAKES.get()))
				.requires(Ingredient.of(ExtraDelightItems.FISH_FLAKES.get())).unlockedBy(getName(), has(Items.KELP))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mixingbowl/furikake"));

		MixingBowlRecipeBuilder
				.stir(ExtraDelightItems.SALAD_FEAST_ITEM.get(), STANDARD_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.CABBAGE.get()).requires(ExtraDelightTags.PROCESSED_ONION)
				.requires(ExtraDelightTags.PROCESSED_CARROT).requires(ExtraDelightItems.CROUTONS.get())
				.requires(ExtraDelightItems.CHEESE.get()).requires(ExtraDelightTags.COOKING_OIL)
				.requires(ExtraDelightTags.VINEGAR).requires(ExtraDelightItems.BOILED_EGG.get())
				.requires(ExtraDelightTags.MEAT_COOKED).unlockedBy(getName(), has(ForgeTags.CROPS_CABBAGE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salad_meat"));

		MixingBowlRecipeBuilder
				.stir(ExtraDelightItems.SALAD_FEAST_ITEM.get(), STANDARD_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.CABBAGE.get()).requires(ExtraDelightTags.PROCESSED_ONION)
				.requires(ExtraDelightTags.PROCESSED_CARROT).requires(ExtraDelightItems.CROUTONS.get())
				.requires(ExtraDelightItems.CHEESE.get()).requires(ExtraDelightTags.COOKING_OIL)
				.requires(ExtraDelightTags.VINEGAR).requires(ExtraDelightItems.BOILED_EGG.get())
				.requires(ExtraDelightTags.PROCESSED_VEG).unlockedBy(getName(), has(ForgeTags.CROPS_CABBAGE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salad_veg"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.PASTA_ALFREDO.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ExtraDelightItems.ALFREDO_SAUCE.get()).requires(ModItems.RAW_PASTA.get())
				.unlockedBy(getName(), has(ExtraDelightItems.ALFREDO_SAUCE.get())).save(consumer);

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.CHICKEN_ALFREDO.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ExtraDelightItems.ALFREDO_SAUCE.get()).requires(ModItems.RAW_PASTA.get())
				.requires(ForgeTags.COOKED_CHICKEN).unlockedBy(getName(), has(ExtraDelightItems.ALFREDO_SAUCE.get()))
				.save(consumer);

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.PASTA_TOMATO.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.TOMATO_SAUCE.get()).requires(ModItems.RAW_PASTA.get())
				.unlockedBy(getName(), has(ModItems.TOMATO_SAUCE.get())).save(consumer);

		MixingBowlRecipeBuilder.stir(ModItems.PASTA_WITH_MEATBALLS.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.TOMATO_SAUCE.get()).requires(ModItems.RAW_PASTA.get())
				.requires(ModItems.BEEF_PATTY.get()).unlockedBy(getName(), has(ModItems.TOMATO_SAUCE.get()))
				.save(consumer);

		MixingBowlRecipeBuilder.stir(ModItems.PASTA_WITH_MUTTON_CHOP.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.TOMATO_SAUCE.get()).requires(ModItems.RAW_PASTA.get()).requires(Items.COOKED_MUTTON)
				.unlockedBy(getName(), has(ModItems.TOMATO_SAUCE.get())).save(consumer);

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.BUTTERED_PASTA.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ExtraDelightItems.COOKED_PASTA.get()).requires(ExtraDelightTags.BUTTER)
				.unlockedBy(getName(), has(ExtraDelightTags.BUTTER)).save(consumer);

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.CACTUS_SALAD.get(), FAST_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ExtraDelightItems.COOKED_CACTUS.get()).requires(ExtraDelightTags.PROCESSED_TOMATO)
				.requires(ExtraDelightTags.PROCESSED_ONION).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.BUTTER)).save(consumer);
	}

	private void craftingRecipes(Consumer<FinishedRecipe> consumer) {

		ShapedRecipeBuilder.shaped(ExtraDelightItems.OVEN.get()).pattern("bBb").pattern("BfB").pattern("BtB")
				.define('b', Items.BRICK).define('B', Items.BRICKS).define('f', Items.FURNACE)
				.define('t', Items.TERRACOTTA)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.FOOD_DISPLAY.get()).pattern(" s ").pattern(" S ").pattern(" s ")
				.define('s', Items.STICK).define('S', Items.OAK_SLAB)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.OAK_SLAB)).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.DOUGH_SHAPING.get()).requires(Items.STICK, 1)
				.requires(ItemTags.PLANKS).requires(Ingredient.of(ExtraDelightTags.FLOUR))
				.unlockedBy(getName(), has(ExtraDelightTags.FLOUR)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.DRYING_RACK.get()).pattern("WSW").pattern("SSS").pattern("WSW")
				.define('W', ItemTags.PLANKS).define('S', Tags.Items.STRING)
				.unlockedBy("has_string", has(Tags.Items.STRING))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "drying_rack"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.SHEET.get()).requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.TRAY.get()).requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1)
				.requires(Items.IRON_NUGGET)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.LOAF_PAN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 2)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.PIE_DISH.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 3)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.ROUND_PAN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 4)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.MUFFIN_TIN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 6)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.SQUARE_PAN.get())
				.requires(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, 1).requires(Items.IRON_NUGGET, 8)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BAKING_STONE.get()).requires(Items.STONE_PRESSURE_PLATE, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE_PRESSURE_PLATE))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.YEAST_POT.get()).requires(Items.FLOWER_POT, 1)
				.requires(ModItems.CANVAS.get(), 1).requires(Items.WATER_BUCKET).requires(Items.SUGAR)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.VINEGAR_POT.get()).requires(Items.FLOWER_POT, 1)
				.requires(ModItems.CANVAS.get(), 1).requires(Items.WATER_BUCKET).requires(Items.SUGAR)
				.requires(Ingredient.of(ExtraDelightTags.FRUIT)).requires(Ingredient.of(ExtraDelightTags.FRUIT))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.FLOWER_POT))
				.save(consumer);

		// Mortars
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_ANDESITE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.ANDESITE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ANDESITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_BASALT.get()).pattern("s s").pattern(" s ")
				.define('s', Items.BASALT)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BASALT)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_BLACKSTONE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.BLACKSTONE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACKSTONE))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_DEEPSLATE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.DEEPSLATE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DEEPSLATE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_DIORITE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.DIORITE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIORITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_ENDSTONE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.END_STONE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.END_STONE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_GRANITE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.GRANITE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRANITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.MORTAR_STONE.get()).pattern("s s").pattern(" s ")
				.define('s', Items.STONE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(consumer);

		// Pestles
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_ANDESITE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.ANDESITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ANDESITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_BASALT.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.BASALT).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BASALT)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_BLACKSTONE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.BLACKSTONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACKSTONE))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_DEEPSLATE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.DEEPSLATE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DEEPSLATE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_DIORITE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.DIORITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIORITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_ENDSTONE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.END_STONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.END_STONE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_GRANITE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.GRANITE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRANITE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PESTLE_STONE.get()).pattern("s  ").pattern(" i ")
				.define('s', Items.STONE).define('i', Items.STICK)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.MIXING_BOWL.get()).pattern("w w").pattern("w w").pattern(" w ")
				.define('w', Ingredient.of(ItemTags.PLANKS)).unlockedBy(getName(), has(ItemTags.PLANKS)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.WOODEN_SPOON.get()).pattern("  w").pattern(" s ").pattern("s  ")
				.define('w', Ingredient.of(ItemTags.PLANKS)).define('s', Ingredient.of(Items.STICK))
				.unlockedBy(getName(), has(ItemTags.PLANKS)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.STONE_SPOON.get()).pattern("  w").pattern(" s ").pattern("s  ")
				.define('w', Ingredient.of(Tags.Items.STONE)).define('s', Ingredient.of(Items.STICK))
				.unlockedBy(getName(), has(Tags.Items.STONE)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.IRON_SPOON.get()).pattern("  w").pattern(" s ").pattern("s  ")
				.define('w', Ingredient.of(Tags.Items.INGOTS_IRON)).define('s', Ingredient.of(Items.STICK))
				.unlockedBy(getName(), has(Tags.Items.INGOTS_IRON)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.GOLD_SPOON.get()).pattern("  w").pattern(" s ").pattern("s  ")
				.define('w', Ingredient.of(Tags.Items.INGOTS_GOLD)).define('s', Ingredient.of(Items.STICK))
				.unlockedBy(getName(), has(Tags.Items.INGOTS_GOLD)).save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.DIAMOND_SPOON.get()).pattern("  w").pattern(" s ").pattern("s  ")
				.define('w', Ingredient.of(Tags.Items.GEMS_DIAMOND)).define('s', Ingredient.of(Items.STICK))
				.unlockedBy(getName(), has(Tags.Items.GEMS_DIAMOND)).save(consumer);

		UpgradeRecipeBuilder
				.smithing(Ingredient.of(ExtraDelightItems.DIAMOND_SPOON.get()), Ingredient.of(Items.NETHERITE_INGOT),
						ExtraDelightItems.NETHERITE_SPOON.get())
				.unlocks("has_netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
				.save(consumer, ExtraDelight.MOD_ID + ":netherite_spoon_smithing");

		ShapedRecipeBuilder.shaped(ExtraDelightItems.GRATER.get()).pattern(" p ").pattern("pip").pattern(" p ")
				.define('i', Ingredient.of(Tags.Items.INGOTS_IRON))
				.define('p', Ingredient.of(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
				.unlockedBy(getName(), has(Tags.Items.INGOTS_IRON)).save(consumer);

		ShapelessRecipeBuilder.shapeless(ModItems.WHEAT_DOUGH.get(), 3).requires(Items.WATER_BUCKET)
				.requires(Ingredient.of(ExtraDelightTags.FLOUR), 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WATER_BUCKET))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "wheat_dough"));

		// Juice
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.GLOW_BERRY_JUICE.get())
				.requires(Ingredient.of(ExtraDelightTags.FRUIT_GLOW_BERRY), 6).requires(Items.SUGAR)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_BERRIES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_berry_juice"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.SWEET_BERRY_JUICE.get())
				.requires(Ingredient.of(ExtraDelightTags.FRUIT_SWEET_BERRY), 6).requires(Items.SUGAR)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_juice"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.TOMATO_JUICE.get())
				.requires(Ingredient.of(ForgeTags.CROPS_TOMATO), 2).requires(Items.SUGAR).requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), has(ForgeTags.CROPS_TOMATO))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "tomato_juice"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CACTUS_JUICE.get())
				.requires(Ingredient.of(ExtraDelightItems.CACTUS.get()), 2).requires(Items.SUGAR)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cactus_juice"));

		// Pie
		ShapedRecipeBuilder.shaped(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_pie_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_berry_pie_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESECAKE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheesecake_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "honey_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chocolate_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pumpkin_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get())
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_berry_cheesecake_slice"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.QUICHE.get()).pattern("ff ").pattern("ff ")
				.define('f', ExtraDelightItems.QUICHE_SLICE.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "quiche_slice"));

		// Popsicles
		ShapedRecipeBuilder.shaped(ExtraDelightItems.FUDGE_POPSICLE.get()).pattern(" cm").pattern("isc").pattern("Si ")
				.define('m', ForgeTags.MILK).define('c', Items.COCOA_BEANS).define('s', Items.SUGAR)
				.define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fudge_popsicle"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.HONEY_POPSICLE.get()).pattern(" cm").pattern("imc").pattern("Si ")
				.define('m', ForgeTags.MILK).define('c', Items.HONEY_BOTTLE).define('S', Items.STICK)
				.define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "honey_popsicle"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_POPSICLE.get()).pattern(" gg").pattern("igg")
				.pattern("Si ").define('g', Items.GLOW_BERRIES).define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_berry_popsicle"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.SWEET_BERRY_POPSICLE.get()).pattern(" gg").pattern("igg")
				.pattern("Si ").define('g', Items.SWEET_BERRIES).define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_popsicle"));

		// Omelette
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ForgeTags.VEGETABLES), 2)
				.unlockedBy(getName(), has(ForgeTags.VEGETABLES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_veg"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ForgeTags.VEGETABLES), 1)
				.requires(Ingredient.of(ExtraDelightTags.MEAT), 1).unlockedBy(getName(), has(ForgeTags.VEGETABLES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_mix"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 2)
				.unlockedBy(getName(), has(ExtraDelightTags.MEAT))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_meat"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.CHEESE), 1)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_cheese"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ForgeTags.VEGETABLES), 2)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1).unlockedBy(getName(), has(ForgeTags.VEGETABLES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_veg_cheese"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ForgeTags.VEGETABLES), 1)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 1)
				.unlockedBy(getName(), has(ForgeTags.VEGETABLES))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_mix_cheese"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ExtraDelightTags.MEAT), 2)
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 1).unlockedBy(getName(), has(ExtraDelightTags.MEAT))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "omelette_mix_meat_cheese"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM)).requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
				.unlockedBy(getName(), has(ExtraDelightTags.JAM))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "jam_toast"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.GLOW_JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM_GLOW_BERRY))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
				.unlockedBy(getName(), has(ExtraDelightTags.JAM_GLOW_BERRY))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_jam_toast"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.GOLDEN_JAM_TOAST.get())
				.requires(Ingredient.of(ExtraDelightTags.JAM_GOLDEN_APPLE))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE))
				.unlockedBy(getName(), has(ExtraDelightTags.JAM_GOLDEN_APPLE)).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.EGG_SALAD_SANDWICH.get())
				.requires(Ingredient.of(ExtraDelightItems.EGG_SALAD.get())).requires(Ingredient.of(ForgeTags.BREAD))
				.unlockedBy(getName(), has(ExtraDelightItems.EGG_SALAD.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.EGG_SALAD_SANDWICH.get())
				.requires(Ingredient.of(ExtraDelightItems.EGG_SALAD.get()))
				.requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE), 2)
				.unlockedBy(getName(), has(ExtraDelightItems.EGG_SALAD.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "egg_salad_sandwich_slice"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CHEESE_BLOCK_ITEM.get())
				.requires(Ingredient.of(ExtraDelightTags.CHEESE), 9).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheese_block"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BUTTER_BLOCK_ITEM.get())
				.requires(Ingredient.of(ExtraDelightTags.BUTTER), 9).unlockedBy(getName(), has(ExtraDelightTags.BUTTER))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "butter_block"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CHEESE.get(), 9)
				.requires(Ingredient.of(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.CHEESE_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheese_block_to_item"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BUTTER.get(), 9)
				.requires(Ingredient.of(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.BUTTER_BLOCK_ITEM.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "butter_block_to_item"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHEESE_SANDWICH.get()).pattern(" b ").pattern("mc ").pattern(" b ")
				.define('c', ExtraDelightTags.CHEESE).define('m', ExtraDelightTags.MAYO)
				.define('b', ExtraDelightItems.BREAD_SLICE.get()).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHEESE_SANDWICH.get()).pattern(" b ").pattern("mc ").pattern(" b ")
				.define('c', ExtraDelightTags.CHEESE).define('m', ExtraDelightTags.BUTTER)
				.define('b', ExtraDelightItems.BREAD_SLICE.get()).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grilled_cheese_butter"));

		ShapedRecipeBuilder.shaped(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()).pattern("ss ").pattern("ss ")
				.define('s', ExtraDelightItems.MEAT_PIE_SLICE.get())
				.unlockedBy(getName(), has(ExtraDelightItems.MEAT_PIE_SLICE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.CONDIMENTS)).requires(Ingredient.of(ForgeTags.BREAD))
				.requires(ExtraDelightItems.PORK_TENDERLOIN.get())
				.unlockedBy(getName(), has(ExtraDelightItems.PORK_TENDERLOIN.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get(), 1)
				.requires(Ingredient.of(ExtraDelightTags.GRAVY)).requires(Ingredient.of(ForgeTags.BREAD))
				.requires(ExtraDelightItems.PORK_TENDERLOIN.get())
				.unlockedBy(getName(), has(ExtraDelightItems.PORK_TENDERLOIN.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_tenderloin_gravy"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.FURIKAKE_RICE.get(), 1)
				.requires(ExtraDelightItems.FURIKAKE.get()).requires(Ingredient.of(ModItems.COOKED_RICE.get()))
				.unlockedBy(getName(), has(ExtraDelightItems.FURIKAKE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.FISH_AND_CHIPS.get(), 1)
				.requires(ExtraDelightItems.FRIED_FISH.get()).requires(ExtraDelightItems.FRENCH_FRIES.get())
				.requires(ExtraDelightTags.VINEGAR).unlockedBy(getName(), has(ExtraDelightItems.FRIED_FISH.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BREADING_MISANPLAS.get(), 1).requires(ExtraDelightTags.FLOUR)
				.requires(ExtraDelightItems.EGG_MIX.get()).requires(ExtraDelightItems.BREAD_CRUMBS.get())
				.requires(ExtraDelightTags.FRYING_OIL).unlockedBy(getName(), has(ExtraDelightItems.BREAD_CRUMBS.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.MUSHROOM_BURGER.get(), 1).requires(ForgeTags.BREAD)
				.requires(ModItems.BEEF_PATTY.get()).requires(Tags.Items.MUSHROOMS).requires(Tags.Items.MUSHROOMS)
				.requires(ExtraDelightTags.CHEESE).unlockedBy(getName(), has(Tags.Items.MUSHROOMS)).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CHEESEBURGER.get(), 1).requires(ForgeTags.BREAD)
				.requires(ModItems.BEEF_PATTY.get()).requires(ForgeTags.CROPS_CABBAGE).requires(ExtraDelightTags.CHEESE)
				.requires(ExtraDelightTags.PROCESSED_TOMATO).requires(ExtraDelightTags.PROCESSED_ONION)
				.unlockedBy(getName(), has(ModItems.BEEF_PATTY.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CHEESEBURGER.get(), 1).requires(ModItems.HAMBURGER.get())
				.requires(ExtraDelightTags.CHEESE).unlockedBy(getName(), has(ModItems.HAMBURGER.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheeseburger_burger"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_CHEESEBURGER.get(), 1).requires(ForgeTags.BREAD)
				.requires(ModItems.BEEF_PATTY.get()).requires(ForgeTags.CROPS_CABBAGE).requires(ExtraDelightTags.CHEESE)
				.requires(ExtraDelightTags.PROCESSED_TOMATO).requires(ExtraDelightTags.PROCESSED_ONION)
				.requires(ForgeTags.COOKED_BACON).unlockedBy(getName(), has(ModItems.BEEF_PATTY.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_CHEESEBURGER.get(), 1)
				.requires(ModItems.HAMBURGER.get()).requires(ExtraDelightTags.CHEESE).requires(ForgeTags.COOKED_BACON)
				.unlockedBy(getName(), has(ModItems.HAMBURGER.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_cheeseburger_burger"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_CHEESEBURGER.get(), 1)
				.requires(ExtraDelightItems.CHEESEBURGER.get()).requires(ForgeTags.COOKED_BACON)
				.unlockedBy(getName(), has(ExtraDelightItems.CHEESEBURGER.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_cheeseburger_cheeseburger"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_EGG_SANDWICH.get(), 1)
				.requires(ModItems.EGG_SANDWICH.get()).requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_BACON)
				.unlockedBy(getName(), has(ForgeTags.COOKED_BACON)).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_EGG_SANDWICH.get(), 1).requires(ForgeTags.BREAD)
				.requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_EGGS)
				.requires(ForgeTags.COOKED_EGGS).unlockedBy(getName(), has(ForgeTags.COOKED_BACON))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_egg_sandwich_full"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1)
				.requires(ModItems.EGG_SANDWICH.get()).requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_BACON)
				.requires(ExtraDelightTags.CHEESE).unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_egg_cheese_sandwich_egg"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.BACON_EGG_SANDWICH.get()).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_egg_cheese_sandwich_egg_bacon"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), 1).requires(ForgeTags.BREAD)
				.requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_BACON).requires(ForgeTags.COOKED_EGGS)
				.requires(ForgeTags.COOKED_EGGS).requires(ExtraDelightTags.CHEESE)
				.unlockedBy(getName(), has(ExtraDelightTags.CHEESE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bacon_egg_cheese_sandwich_full"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.BUTTERED_TOAST.get(), 1)
				.requires(ExtraDelightTags.BREAD_SLICE).requires(ExtraDelightTags.BUTTER)
				.unlockedBy(getName(), has(ExtraDelightTags.BUTTER))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "butter_toast"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.RICEBALL.get(), 2).requires(ModItems.COOKED_RICE.get())
				.requires(Items.DRIED_KELP).requires(ExtraDelightItems.FISH_FLAKES.get())
				.unlockedBy(getName(), has(ModItems.COOKED_RICE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.RICEBALL_FILLED.get(), 1)
				.requires(ModItems.COOKED_RICE.get()).requires(Items.DRIED_KELP)
				.requires(ExtraDelightItems.FISH_FLAKES.get()).requires(ExtraDelightTags.RICEBALL_FILLING)
				.unlockedBy(getName(), has(ModItems.COOKED_RICE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.FISH_SALAD_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.FISH_SALAD.get()).requires(Items.BREAD)
				.unlockedBy(getName(), has(ExtraDelightItems.FISH_SALAD.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.FISH_SALAD_SANDWICH.get(), 1)
				.requires(ExtraDelightItems.FISH_SALAD.get()).requires(Ingredient.of(ExtraDelightTags.BREAD_SLICE), 2)
				.unlockedBy(getName(), has(ExtraDelightItems.FISH_SALAD.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_salad_sandwich_slice"));

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.CACTUS_EGGS.get(), 1)
				.requires(ExtraDelightItems.COOKED_CACTUS.get()).requires(ExtraDelightItems.SCRAMBLED_EGGS.get(), 1)
				.unlockedBy(getName(), has(ExtraDelightItems.COOKED_CACTUS.get()))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cooked_cactus"));

	}

	private void tagConditional(RecipeBuilder rb, Consumer<FinishedRecipe> consumer, String id,
			Collection<TagKey<Item>> tags) {
		ConditionalRecipe.Builder b = ConditionalRecipe.builder();

		for (TagKey<Item> t : tags)
			b.addCondition(not(tagEmpty(t)));

		b.addRecipe(rb::save).build(consumer, new ResourceLocation(id));
	}

	private void potRecipes(Consumer<FinishedRecipe> consumer) {
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.COCOA_BEANS).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER).build(consumer);

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.PUMPKIN_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ModItems.PUMPKIN_SLICE.get()).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER).build(consumer);

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.HONEY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.HONEY_BOTTLE).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER).build(consumer);

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(ExtraDelightTags.SWEETENER).build(consumer);

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.KETCHUP.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ExtraDelightTags.VINEGAR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "ketchup_jar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.BBQ_SAUCE.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(ExtraDelightTags.VINEGAR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_sugar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ModItems.BONE_BROTH.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE)
				.addIngredient(ExtraDelightTags.MAKES_STOCK).addIngredient(Items.BONE)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stock"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.GRAVY.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ModItems.BONE_BROTH.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "gravy_boat"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(ModItems.MINCED_BEEF.get(), 3).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightItems.GRAVY.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salisbury_steak_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(), 1,
						CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
				.addIngredient(Items.POTATO, 3).addIngredient(ExtraDelightItems.GRAVY.get())
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mashed_potato_gravy_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRENCH_FRIES.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.POTATO_STICKS.get()).addIngredient(ExtraDelightTags.FRYING_OIL)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fries"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.POTATO_CHIPS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.SLICED_POTATO.get()).addIngredient(ExtraDelightTags.FRYING_OIL)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chips"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.STOMACH)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.CHEESE.get(), 2, CookingRecipes.SLOW_COOKING, 1.0F)
						.addIngredient(Items.MILK_BUCKET).addIngredient(ExtraDelightTags.STOMACH)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "cheese_stomach")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheese_conditional"));

		CookingPotRecipeBuilder.cookingPotRecipe(ExtraDelightItems.CHEESE.get(), 2, CookingRecipes.SLOW_COOKING, 1.0F)
				.addIngredient(Items.MILK_BUCKET).addIngredient(ExtraDelightTags.VINEGAR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheese_vinegar"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.STEW_PORK)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.PORK_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(ExtraDelightTags.STEW_PORK).addIngredient(Items.CARROT)
						.addIngredient(Items.POTATO).addIngredient(ForgeTags.CROPS_ONION)
						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew_bc")))
				.addCondition(tagEmpty(ExtraDelightTags.STEW_PORK))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.PORK_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(Items.PORKCHOP).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
						.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
						.addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew_vanilla")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.STEW_MUTTON)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.LAMB_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(ExtraDelightTags.STEW_MUTTON).addIngredient(Items.CARROT)
						.addIngredient(Items.POTATO).addIngredient(ForgeTags.CROPS_ONION)
						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "mutton_stew_bc")))
				.addCondition(tagEmpty(ExtraDelightTags.STEW_MUTTON))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.LAMB_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(Items.MUTTON).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
						.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
						.addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "mutton_stew_vanilla")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mutton_stew_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.STEW_BEEF)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.BEEF_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(ExtraDelightTags.STEW_BEEF).addIngredient(Items.CARROT)
						.addIngredient(Items.POTATO).addIngredient(ForgeTags.CROPS_ONION)
						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "beef_stew_bc")))
				.addCondition(tagEmpty(ExtraDelightTags.STEW_BEEF))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.BEEF_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING,
								0.35F, Items.BOWL)
						.addIngredient(ExtraDelightTags.BEEF).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
						.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
						.addIngredient(ExtraDelightTags.FLOUR)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "beef_stew_vanilla")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "beef_stew_test"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.RABBIT_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Items.RABBIT).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
				.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ExtraDelightTags.FLOUR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rabbit_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CHICKEN_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Items.CHICKEN).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
				.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ExtraDelightTags.FLOUR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FISH_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ForgeTags.RAW_FISHES).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
				.addIngredient(ForgeTags.CROPS_ONION).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ExtraDelightTags.FLOUR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_stew"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.STOMACH)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.SOS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
								ExtraDelightItems.BREAD_SLICE.get())
						.addIngredient(ExtraDelightTags.SCRAP_BEEF).addIngredient(ExtraDelightTags.FLOUR)
						.addIngredient(ForgeTags.MILK).build(r, new ResourceLocation(ExtraDelight.MOD_ID, "sos")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sos_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.PORK_ROAST_RAW)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), 1,
								CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
						.addIngredient(ExtraDelightTags.PORK_ROAST).addIngredient(ExtraDelightTags.PORK_ROAST)
						.addIngredient(ExtraDelightItems.BBQ_SAUCE.get())
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_feast")))
				.addCondition(tagEmpty(ExtraDelightTags.PORK_ROAST_RAW))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), 1,
								CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
						.addIngredient(Items.PORKCHOP).addIngredient(Items.PORKCHOP).addIngredient(Items.PORKCHOP)
						.addIngredient(Items.PORKCHOP).addIngredient(Items.PORKCHOP)
						.addIngredient(ExtraDelightItems.BBQ_SAUCE.get())
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_feast_vanilla")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_cond"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightTags.MEAT_RAW).addIngredient(ExtraDelightTags.MEAT_RAW)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.VEGETABLES)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.VEGETABLES)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stirfry_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BLACK).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "black_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_RED_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_RED).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "red_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_GREEN).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "green_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BROWN).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "brown_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BLUE).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "blue_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_PURPLE).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "purple_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_CYAN).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cyan_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIGHT_GRAY).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "light_grey_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_GRAY).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grey_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_PINK).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pink_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIME).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lime_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_YELLOW).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "yellow_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIGHT_BLUE).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "light_blue_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_MAGENTA).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "magenta_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_ORANGE).addIngredient(ExtraDelightTags.GELATIN)
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "orange_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_WHITE).addIngredient(ExtraDelightTags.GELATIN).addIngredient(Items.SUGAR)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "white_jelly_feast"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.LIVER)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.LIVER_ONIONS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
								Items.BOWL)
						.addIngredient(ExtraDelightTags.LIVER).addIngredient(ForgeTags.VEGETABLES_ONION)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "liver_onions")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "liveronions_test"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_FISH.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ItemTags.FISHES).addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_fish"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Items.BEEF).addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.addIngredient(ExtraDelightItems.GRAVY.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_fried_steak"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.PORK_TENDERLOIN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Items.PORKCHOP).addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_tenderloin"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_CHICKEN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ModItems.CHICKEN_CUTS.get()).addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_chicken"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.BRAIN)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.FRIED_BRAINS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
						.addIngredient(ExtraDelightTags.BRAIN).addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "fried_brains")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_brains_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.OXTAIL)))
				.addRecipe(r -> CookingPotRecipeBuilder
						.cookingPotRecipe(ExtraDelightItems.OXTAIL_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
								Items.BOWL)
						.addIngredient(ExtraDelightTags.OXTAIL).addIngredient(Items.CARROT)
						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ForgeTags.VEGETABLES_TOMATO)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "oxtail_soup")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "oxtail_soup_test"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CARROT_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(Tags.Items.CROPS_CARROT), 2)
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION)).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ForgeTags.MILK)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "carrot_soup"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FISH_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ItemTags.FISHES), 2).addIngredient(Ingredient.of(ForgeTags.CROPS_ONION))
				.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(Items.DRIED_KELP)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_soup"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.POTATO_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(Tags.Items.CROPS_POTATO), 2)
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION)).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ForgeTags.MILK)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "potato_soup"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.TOMATO_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ForgeTags.CROPS_TOMATO), 2)
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION)).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ForgeTags.MILK)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "tomato_soup"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.BOILED_EGG.get(), 1, CookingRecipes.FAST_COOKING, 0.35F)
				.addIngredient(Ingredient.of(ForgeTags.EGGS), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "boiled_egg"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.APPLE_JAM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.GLASS_BOTTLE)
				.addIngredient(Ingredient.of(Items.APPLE), 3).addIngredient(Ingredient.of(Items.SUGAR), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "apple_jam"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CARROT_JAM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.GLASS_BOTTLE)
				.addIngredient(Ingredient.of(Tags.Items.CROPS_CARROT), 3).addIngredient(Ingredient.of(Items.SUGAR), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "carrot_jam"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.GLOW_BERRY_JAM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.GLASS_BOTTLE)
				.addIngredient(Ingredient.of(Items.GLOW_BERRIES), 3).addIngredient(Ingredient.of(Items.SUGAR), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glow_berry_jam"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.GOLDEN_APPLE_JAM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.GLASS_BOTTLE)
				.addIngredient(Ingredient.of(Items.GOLDEN_APPLE), 3).addIngredient(Ingredient.of(Items.SUGAR), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "golden_apple_jam"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SWEET_BERRY_JAM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.GLASS_BOTTLE)
				.addIngredient(Ingredient.of(Items.SWEET_BERRIES), 3).addIngredient(Ingredient.of(Items.SUGAR), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_jam"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SEAWEED_PASTE.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F)
				.addIngredient(Ingredient.of(Items.DRIED_KELP), 3)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "seaweed_paste"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.GLAZED_CARROT.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(Items.CARROT), 3)
				.addIngredient(Ingredient.of(ExtraDelightItems.BUTTER.get()))
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "glazed_carrot"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.APPLE_SAUCE.get(), 3, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(Items.APPLE), 3).addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "apple_sauce"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.HASH_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()), 2)
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION))
				.addIngredient(Ingredient.of(ExtraDelightTags.FRYING_OIL))
				.addIngredient(Ingredient.of(ExtraDelightTags.MEAT))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "hash"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SEAWEED_CRISPS.get(), 1, CookingRecipes.FAST_COOKING, 0.35F)
				.addIngredient(Ingredient.of(Items.DRIED_KELP), 2).addIngredient(Ingredient.of(ExtraDelightTags.FLOUR))
				.addIngredient(Ingredient.of(ExtraDelightTags.FRYING_OIL))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "seaweed_crisps"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(), 1, CookingRecipes.NORMAL_COOKING,
						0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ExtraDelightItems.MACARONI.get()), 2)
				.addIngredient(Ingredient.of(ExtraDelightTags.BUTTER)).addIngredient(Ingredient.of(ForgeTags.MILK))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHEESE), 2)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "macaroni_cheese"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FISH_CAKES.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Ingredient.of(ForgeTags.COOKED_FISHES))
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION))
				.addIngredient(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()))
				.addIngredient(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fish_cakes"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_MUSHROOMS.get(), 3, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Ingredient.of(Tags.Items.MUSHROOMS), 3)
				.addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_mushrooms"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.MUSHROOM_RISOTTO.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(Tags.Items.MUSHROOMS))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHEESE))
				.addIngredient(Ingredient.of(ExtraDelightTags.BUTTER))
				.addIngredient(Ingredient.of(ModItems.BONE_BROTH.get()))
				.addIngredient(Ingredient.of(ForgeTags.CROPS_RICE)).addIngredient(Ingredient.of(ForgeTags.CROPS_ONION))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mushroom_risotto"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CURRY_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ForgeTags.RAW_CHICKEN))
				.addIngredient(Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()))
				.addIngredient(Ingredient.of(ModItems.BONE_BROTH.get()))
				.addIngredient(Ingredient.of(ForgeTags.CROPS_ONION))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "curry"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.ALFREDO_SAUCE.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Ingredient.of(ForgeTags.MILK_BOTTLE))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHEESE))
				.addIngredient(Ingredient.of(ExtraDelightTags.BUTTER))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "alfredo_sauce"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.COOKED_PASTA.get(), 1, CookingRecipes.FAST_COOKING, 0.15F)
				.addIngredient(Ingredient.of(ModItems.RAW_PASTA.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cooked_pasta"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CACTUS_SOUP.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.COOKED_CACTUS.get(), 2)
				.addIngredient(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO))
				.addIngredient(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))
				.addIngredient(Ingredient.of(ModItems.BONE_BROTH.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cactus_soup"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.STUFFED_CACTUS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.COOKED_CACTUS.get(), 2)
				.addIngredient(Ingredient.of(ExtraDelightTags.CHEESE))
				.addIngredient(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stuffed_cactus"));

	}

	private void knifeRecipes(Consumer<FinishedRecipe> consumer) {
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.WHEAT), Ingredient.of(ForgeTags.TOOLS_KNIVES), Items.WHEAT_SEEDS, 2)
				.addResult(ModItems.STRAW.get()).build(consumer);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.SUNFLOWER), Ingredient.of(ForgeTags.TOOLS_KNIVES),
				ExtraDelightItems.SUNFLOWER_SEEDS.get(), 2).addResult(Items.YELLOW_DYE, 2).build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.APPLE), Ingredient.of(ForgeTags.TOOLS_KNIVES),
						ExtraDelightItems.SLICED_APPLE.get(), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cut_apples"));

		// Grate
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_POTATO), Ingredient.of(ExtraDelightItems.GRATER.get()),
						ExtraDelightItems.GRATED_POTATO.get(), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grate_potato"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_CARROT), Ingredient.of(ExtraDelightItems.GRATER.get()),
						ExtraDelightItems.GRATED_CARROT.get(), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grate_carrot"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ForgeTags.BREAD), Ingredient.of(ExtraDelightItems.GRATER.get()),
						ExtraDelightItems.BREAD_CRUMBS.get(), 2)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grate_bread"));

		// Potato
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Tags.Items.CROPS_POTATO), Ingredient.of(ForgeTags.TOOLS_KNIVES),
						ExtraDelightItems.SLICED_POTATO.get(), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sliced_potato"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.SLICED_POTATO.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.POTATO_STICKS.get(), 1)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stick_potato"));

		// Pies
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.MEAT_PIE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ExtraDelightItems.CHEESECAKE_ITEM.get()),
						Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.CHEESECAKE_SLICE.get(), 4)
				.build(consumer);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightItems.QUICHE.get()),
				Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.QUICHE_SLICE.get(), 4).build(consumer);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BREAD), Ingredient.of(ForgeTags.TOOLS_KNIVES),
				ExtraDelightItems.BREAD_SLICE.get(), 4).build(consumer);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightTags.BREAD_SLICE),
				Ingredient.of(ForgeTags.TOOLS_KNIVES), ExtraDelightItems.CROUTONS.get(), 4).build(consumer);

		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ForgeTags.CROPS_ONION), Ingredient.of(ForgeTags.TOOLS_KNIVES),
						ExtraDelightItems.SLICED_ONION.get(), 4)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sliced_onion"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(ForgeTags.CROPS_TOMATO), Ingredient.of(ForgeTags.TOOLS_KNIVES),
						ExtraDelightItems.SLICED_TOMATO.get(), 4)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sliced_tomato"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.CACTUS), Ingredient.of(ForgeTags.TOOLS_KNIVES),
						ExtraDelightItems.CACTUS.get(), 2)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sliced_cactus"));
	}

	void mortarRecipes(Consumer<FinishedRecipe> consumer) {
		// Dyes
		MortarRecipeBuilder.grind(Ingredient.of(Items.LAPIS_LAZULI), Items.BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.BONE_MEAL), Items.WHITE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.LILY_OF_THE_VALLEY), Items.WHITE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LILY_OF_THE_VALLEY))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lily_white"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.ORANGE_TULIP), Items.ORANGE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ORANGE_TULIP))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.ALLIUM), Items.MAGENTA_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ALLIUM)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.LILAC), Items.MAGENTA_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LILAC))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lilac_magenta"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.BLUE_ORCHID), Items.LIGHT_BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLUE_ORCHID))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.DANDELION), Items.YELLOW_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DANDELION)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.SUNFLOWER), Items.YELLOW_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUNFLOWER))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sunflower_yellow"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.SEA_PICKLE), Items.LIME_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SEA_PICKLE))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.PINK_TULIP), Items.PINK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_TULIP))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.PEONY), Items.PINK_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PEONY))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "peony_pink"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.OXEYE_DAISY), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.OXEYE_DAISY))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.AZURE_BLUET), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.AZURE_BLUET))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lgray_azure"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.WHITE_TULIP), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_TULIP))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lgray_tulip"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.CORNFLOWER), Items.BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CORNFLOWER))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "blue_corn"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.COCOA_BEANS), Items.BROWN_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.CACTUS), Items.GREEN_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CACTUS)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.RED_TULIP), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_TULIP)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.BEETROOT), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "red_beet"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.POPPY), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.POPPY))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "poppy_red"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.ROSE_BUSH), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROSE_BUSH))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rose_red"));
		MortarRecipeBuilder.grind(Ingredient.of(Items.INK_SAC), Items.BLACK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.INK_SAC)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.WITHER_ROSE), Items.BLACK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WITHER_ROSE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "wither_black"));

		MortarRecipeBuilder.grind(Ingredient.of(Items.BONE), Items.BONE_MEAL, LONG_GRIND, 4)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.BLAZE_ROD), Items.BLAZE_POWDER, LONG_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder.grind(Ingredient.of(Items.WHEAT_SEEDS), ExtraDelightItems.FLOUR.get(), STANDARD_GRIND, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder
				.grind(DifferenceIngredient.of(Ingredient.of(Tags.Items.SEEDS),
						Ingredient.of(Items.WHEAT_SEEDS, ExtraDelightItems.CORN_SEEDS.get())),
						ExtraDelightItems.COOKING_OIL.get(), STANDARD_GRIND, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT_SEEDS))
				.save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(ExtraDelightItems.AGAR_SHEETS.get()), ExtraDelightItems.AGAR_AGAR.get(),
						LONG_GRIND, 1)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.AGAR_SHEETS.get()))
				.save(consumer);
	}

	void ovenRecipes(Consumer<FinishedRecipe> consumer) {

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.HEART)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.STUFFED_HEART.get(), 1, CookingRecipes.NORMAL_COOKING, SMALL_EXP,
								ExtraDelightItems.TRAY.get())
						.addIngredient(ExtraDelightTags.HEART).addIngredient(Tags.Items.MUSHROOMS)
						.addIngredient(ExtraDelightItems.BREAD_CRUMBS.get()).addIngredient(ForgeTags.VEGETABLES_ONION)
						.addIngredient(Items.EGG).build(r, new ResourceLocation(ExtraDelight.MOD_ID, "stuffed_heart")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stuffed_heart_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.ROAST_RAW)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
								MEDIUM_EXP, ExtraDelightItems.SQUARE_PAN.get())
						.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.ROAST_RAW)
						.addIngredient(ExtraDelightTags.COOKING_OIL).addIngredient(ForgeTags.CROPS_ONION)
						.addIngredient(Items.POTATO).addIngredient(Items.CARROT).addIngredient(ForgeTags.CROPS_ONION)
						.addIngredient(Items.POTATO).addIngredient(Items.CARROT)
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "pot_roast_feast")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pot_roast_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.RIBS_RAW)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
								MEDIUM_EXP, ExtraDelightItems.TRAY.get())
						.addIngredient(ExtraDelightTags.RIBS_RAW).addIngredient(ExtraDelightTags.RIBS_RAW)
						.addIngredient(ExtraDelightTags.RIBS_RAW).addIngredient(ExtraDelightTags.RIBS_RAW)
						.addIngredient(ExtraDelightItems.BBQ_SAUCE.get())
						.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_ribs_feast")))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_ribs_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.MUTTON_RIBS)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
								ExtraDelightItems.TRAY.get())
						.addIngredient(ExtraDelightTags.MUTTON_RIBS).addIngredient(ExtraDelightTags.COOKING_OIL)
						.addIngredient(ExtraDelightTags.MUTTON_RIBS).addIngredient(ExtraDelightTags.MUTTON_RIBS)
						.addIngredient(ForgeTags.VEGETABLES_ONION).addIngredient(ExtraDelightTags.MUTTON_RIBS)
						.addIngredient(Items.SWEET_BERRIES).addIngredient(Items.BREAD)
						.addIngredient(Items.SWEET_BERRIES).setRecipeBookTab(OvenRecipeBookTab.MEALS)
						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rack_lamb_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.LIVER)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
								ExtraDelightItems.TRAY.get())
						.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.BEEF_ROAST)
						.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.BUTTER)
						.addIngredient(ModItems.WHEAT_DOUGH.get()).addIngredient(ExtraDelightTags.LIVER)
						.addIngredient(ModItems.COOKED_BACON.get()).addIngredient(Items.EGG)
						.addIngredient(ExtraDelightTags.PROCESSED_ONION).setRecipeBookTab(OvenRecipeBookTab.MEALS)
						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "wellington_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.LIVER)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.HAGGIS_FEAST_ITEM.get(), 1, SLOW_COOKING, MEDIUM_EXP,
								ExtraDelightItems.TRAY.get())
						.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.OFFAL)
						.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.LUNG)
						.addIngredient(ExtraDelightTags.STOMACH).addIngredient(ExtraDelightTags.SCRAP_MEAT)
						.addIngredient(Items.WHEAT_SEEDS).addIngredient(Items.WHEAT_SEEDS)
						.addIngredient(Items.WHEAT_SEEDS).setRecipeBookTab(OvenRecipeBookTab.MEALS)
						.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(r))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "haggis_test"));

		OvenRecipeBuilder.OvenRecipe(Items.CAKE, 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.ROUND_PAN.get())
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK).addIngredient(Items.EGG).addIngredient(Items.SUGAR, 2)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.GLOW_BERRY_COOKIE.get(), 8, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(Items.GLOW_BERRIES)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);

		OvenRecipeBuilder.OvenRecipe(Items.COOKIE, 8, FAST_COOKING, MEDIUM_EXP, ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(Items.COCOA_BEANS)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.COCOA_BEANS).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.SUGAR_COOKIE.get(), 8, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(Items.SUGAR)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.SUGAR).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.PUMPKIN_COOKIE.get(), 8, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(ModItems.PUMPKIN_SLICE.get())
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ModItems.SWEET_BERRY_COOKIE.get(), 8, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(Items.SWEET_BERRIES)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.SWEET_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ModItems.HONEY_COOKIE.get(), 8, FAST_COOKING, MEDIUM_EXP, ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightTags.FLOUR, 2).addIngredient(Items.HONEY_BOTTLE)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.HONEY_BOTTLE).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.CHEESECAKE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(Ingredient.of(ForgeTags.MILK)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ForgeTags.MILK)).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.MILK_BUCKET, ModItems.MILK_BOTTLE.get()).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SQUARE_PAN.get())
				.addIngredient(Items.BAKED_POTATO).addIngredient(ForgeTags.MILK).addIngredient(Items.BAKED_POTATO)
				.addIngredient(ForgeTags.COOKED_MUTTON).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ForgeTags.COOKED_MUTTON).addIngredient(ExtraDelightTags.PROCESSED_VEG)
				.addIngredient(ExtraDelightTags.PROCESSED_VEG).addIngredient(ExtraDelightTags.PROCESSED_VEG)
				.addIngredient(Ingredient.of(ForgeTags.MILK)).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("shepard_pie", has(ForgeTags.COOKED_MUTTON)).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(Items.COCOA_BEANS, 3).addIngredient(Ingredient.of(ForgeTags.MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(ForgeTags.MILK))
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.COCOA_BEANS).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(Items.GLOW_BERRIES, 3).addIngredient(Ingredient.of(ForgeTags.MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(ForgeTags.MILK))
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(ExtraDelightItems.CHEESE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(Items.HONEY_BOTTLE, 3).addIngredient(Ingredient.of(ForgeTags.MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(ForgeTags.MILK))
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(ExtraDelightItems.CHEESE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ModItems.PUMPKIN_SLICE.get(), 3).addIngredient(Ingredient.of(ForgeTags.MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(ForgeTags.MILK))
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(ModItems.PUMPKIN_SLICE.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(Items.SWEET_BERRIES, 3)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.SWEET_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(Items.GLOW_BERRIES, 3)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.QUICHE.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightItems.OMELETTE_MIX.get(), 1).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(ExtraDelightItems.OMELETTE_MIX.get())
				.build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.EGG_BASKET.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ForgeTags.EGGS).addIngredient(ExtraDelightTags.BREAD_SLICE)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("egg_basket", has(ForgeTags.EGGS))
				.build(consumer);

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.SAUSAGE)))
				.addRecipe(r -> OvenRecipeBuilder
						.OvenRecipe(ExtraDelightItems.SAUSAGE_ROLL.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
								ExtraDelightItems.SHEET.get())
						.addIngredient(ExtraDelightTags.SAUSAGE).addIngredient(ForgeTags.DOUGH)
						.setRecipeBookTab(OvenRecipeBookTab.MEALS)
						.unlockedBy("sausage_roll", has(ExtraDelightTags.SAUSAGE)).build(r))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sausage_roll_test"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MEAT_COOKED))).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ExtraDelightItems.LASAGNA_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.SQUARE_PAN.get())
					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ModItems.TOMATO_SAUCE.get())
					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
					.addIngredient(ExtraDelightTags.GROUND_MEAT_COOKED).addIngredient(ModItems.TOMATO_SAUCE.get())
					.addIngredient(ExtraDelightTags.GROUND_MEAT_COOKED).setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("lasagna", has(ExtraDelightItems.LASAGNA_NOODLES.get()))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "lasagna_bc"));
		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MEAT_COOKED)).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ExtraDelightItems.LASAGNA_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.SQUARE_PAN.get())
					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ModItems.TOMATO_SAUCE.get())
					.addIngredient(ExtraDelightTags.CHEESE).addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get())
					.addIngredient(ExtraDelightItems.LASAGNA_NOODLES.get()).addIngredient(ExtraDelightTags.MEAT_COOKED)
					.addIngredient(ModItems.TOMATO_SAUCE.get()).addIngredient(ExtraDelightTags.MEAT_COOKED)
					.setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("lasagna", has(ExtraDelightItems.LASAGNA_NOODLES.get()))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "lasagna_vanilla"));
		}).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lasagna"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MEAT_RAW))).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ExtraDelightItems.MEAT_LOAF_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.LOAF_PAN.get())
					.addIngredient(ExtraDelightItems.KETCHUP.get()).addIngredient(ExtraDelightItems.BREAD_CRUMBS.get())
					.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
					.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
					.addIngredient(ExtraDelightTags.PROCESSED_ONION).setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("meatloaf", has(ExtraDelightTags.GROUND_MEAT_RAW))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf_bc"));
		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MEAT_RAW)).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ExtraDelightItems.MEAT_LOAF_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.LOAF_PAN.get())
					.addIngredient(ExtraDelightItems.KETCHUP.get()).addIngredient(ExtraDelightItems.BREAD_CRUMBS.get())
					.addIngredient(ExtraDelightItems.EGG_MIX.get()).addIngredient(ModItems.BEEF_PATTY.get())
					.addIngredient(ModItems.BEEF_PATTY.get()).addIngredient(ModItems.BEEF_PATTY.get())
					.addIngredient(ExtraDelightTags.PROCESSED_ONION).setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("meatloaf", has(ExtraDelightItems.LASAGNA_NOODLES.get()))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf_vanilla"));
		}).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meatloaf"));

		ConditionalRecipe.builder().addCondition(not(tagEmpty(ExtraDelightTags.GROUND_MUTTON_COOKED))).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.SQUARE_PAN.get())
					.addIngredient(Items.BAKED_POTATO).addIngredient(ModItems.BONE_BROTH.get())
					.addIngredient(Items.BAKED_POTATO).addIngredient(ExtraDelightTags.GROUND_MUTTON_COOKED)
					.addIngredient(ExtraDelightTags.PROCESSED_CARROT)
					.addIngredient(ExtraDelightTags.GROUND_MUTTON_COOKED).addIngredient(ExtraDelightTags.FLOUR)
					.addIngredient(ModItems.TOMATO_SAUCE.get()).addIngredient(ExtraDelightTags.PROCESSED_ONION)
					.setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("shepards_pie", has(ExtraDelightTags.GROUND_MEAT_RAW))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "shepards_pie_bc"));
		}).addCondition(tagEmpty(ExtraDelightTags.GROUND_MUTTON_COOKED)).addRecipe(r -> {
			OvenRecipeBuilder
					.OvenRecipe(ModItems.SHEPHERDS_PIE_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
							ExtraDelightItems.SQUARE_PAN.get())
					.addIngredient(Items.BAKED_POTATO).addIngredient(ModItems.BONE_BROTH.get())
					.addIngredient(Items.BAKED_POTATO).addIngredient(ForgeTags.COOKED_MUTTON)
					.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ForgeTags.COOKED_MUTTON)
					.addIngredient(ExtraDelightTags.PROCESSED_CARROT).addIngredient(ExtraDelightTags.BUTTER)
					.addIngredient(ExtraDelightTags.PROCESSED_ONION).setRecipeBookTab(OvenRecipeBookTab.MEALS)
					.unlockedBy("shepards_pie", has(ExtraDelightTags.GROUND_MEAT_RAW))
					.build(r, new ResourceLocation(ExtraDelight.MOD_ID, "shepards_pie_vanilla"));
		}).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "shepards_pie"));

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.HOTDISH_FEAST.get(), 1, SLOW_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SQUARE_PAN.get())
				.addIngredient(ExtraDelightTags.STARCH).addIngredient(ExtraDelightTags.STARCH)
				.addIngredient(ExtraDelightTags.STARCH).addIngredient(ExtraDelightTags.MEAT_COOKED)
				.addIngredient(ExtraDelightTags.SOUP).addIngredient(ExtraDelightTags.MEAT_COOKED)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(ExtraDelightTags.SOUP)
				.addIngredient(ForgeTags.VEGETABLES).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("hotdish", has(ExtraDelightTags.SOUP))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "hotdish"));

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.STUFFED_MUSHROOMS.get(), 3, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(Tags.Items.MUSHROOMS)
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightTags.CHEESE)
				.addIngredient(ExtraDelightItems.BREAD_CRUMBS.get()).addIngredient(ExtraDelightTags.BUTTER)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("stuffed_mushroom", has(Tags.Items.MUSHROOMS))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stuffed_mushroom"));

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(ExtraDelightTags.GROUND_MEAT_RAW)
				.addIngredient(ExtraDelightTags.GROUND_MEAT_RAW).addIngredient(Tags.Items.MUSHROOMS)
				.addIngredient(ExtraDelightTags.PROCESSED_POTATO).addIngredient(ExtraDelightTags.PROCESSED_ONION)
				.addIngredient(ModItems.PIE_CRUST.get()).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("meat_pie", has(ModItems.PIE_CRUST.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meat_pie"));

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.CHICKEN_PARM.get(), 2, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.TRAY.get())
				.addIngredient(ExtraDelightItems.FRIED_CHICKEN.get()).addIngredient(ModItems.TOMATO_SAUCE.get())
				.addIngredient(ExtraDelightTags.CHEESE).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("chicken_parm", has(ExtraDelightItems.FRIED_CHICKEN.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_parm"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.ROAST_CHICKEN_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
						ExtraDelightItems.TRAY.get())
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.GRAVY)
				.addIngredient(ForgeTags.BREAD).addIngredient(ExtraDelightTags.PROCESSED_CARROT)
				.addIngredient(Items.CHICKEN).addIngredient(ExtraDelightTags.PROCESSED_POTATO)
				.addIngredient(ExtraDelightTags.PROCESSED_CARROT).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.PROCESSED_POTATO).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("roast_chicken", has(Items.CHICKEN))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "roast_chicken"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.HONEY_GLAZED_HAM_BLOCK.get(), 1, SLOW_COOKING, MEDIUM_EXP,
						ExtraDelightItems.TRAY.get())
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(Items.HONEY_BOTTLE)
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ModItems.HAM.get()).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ModItems.COOKED_RICE.get()).addIngredient(ExtraDelightItems.BUTTER.get())
				.addIngredient(ModItems.COOKED_RICE.get()).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("honey_ham", has(ModItems.HAM.get()))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "honey_ham"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.CHOCOLATE_PIE.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightItems.WHIPPED_CREAM.get())
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightItems.EGG_MIX.get())
				.addIngredient(Items.COCOA_BEANS).addIngredient(ExtraDelightTags.FLOUR).addIngredient(Items.SUGAR)
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(Items.SUGAR)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("chocolate_pie", has(Items.COCOA_BEANS))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chocolate_pie"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.PIE_CRUST.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ForgeTags.MILK).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("pie_crust", has(ExtraDelightTags.FLOUR))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pie_crust"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.SWEET_BERRY_CHEESECAKE.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY)
				.addIngredient(ExtraDelightTags.FRUIT_SWEET_BERRY).addIngredient(Items.SUGAR)
				.addIngredient(ForgeTags.MILK).addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ForgeTags.MILK)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("sweet_berry_pie", has(Items.SWEET_BERRIES))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_pie"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.SWEET_BERRY_CHEESECAKE.get(), 1, NORMAL_COOKING, MEDIUM_EXP,
						ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ExtraDelightTags.JAM_SWEET_BERRY).addIngredient(ForgeTags.MILK)
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ForgeTags.MILK)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("sweet_berry_pie", has(Items.SWEET_BERRIES))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sweet_berry_pie_jam"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.APPLE_PIE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(ExtraDelightTags.PROCESSED_APPLE).addIngredient(ExtraDelightTags.PROCESSED_APPLE)
				.addIngredient(Items.SUGAR).addIngredient(ModItems.PIE_CRUST.get())
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy("apple_pie", has(Items.APPLE))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "apple_pie"));

		OvenRecipeBuilder
				.OvenRecipe(ModItems.APPLE_PIE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.PIE_DISH.get())
				.addIngredient(ModItems.PIE_CRUST.get()).addIngredient(ExtraDelightTags.JAM_APPLE)
				.addIngredient(ModItems.PIE_CRUST.get()).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedBy("apple_pie", has(Items.APPLE))
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "apple_pie_jam"));

		bulkBake(ModItems.FRIED_EGG.get(), Items.EGG, consumer, ExtraDelightItems.TRAY.get(), "fried_egg");
		bulkBake(ModItems.BEEF_PATTY.get(), ModItems.MINCED_BEEF.get(), consumer, ExtraDelightItems.TRAY.get(),
				"beef_patty");
		bulkBake(ModItems.COOKED_CHICKEN_CUTS.get(), ModItems.CHICKEN_CUTS.get(), consumer,
				ExtraDelightItems.TRAY.get(), "chicken_cuts");
		bulkBake(ModItems.COOKED_COD_SLICE.get(), ModItems.COD_SLICE.get(), consumer, ExtraDelightItems.TRAY.get(),
				"cod_slice");
		bulkBake(ModItems.COOKED_SALMON_SLICE.get(), ModItems.SALMON_SLICE.get(), consumer,
				ExtraDelightItems.TRAY.get(), "salmon_slice");
		bulkBake(ModItems.COOKED_BACON.get(), ModItems.BACON.get(), consumer, ExtraDelightItems.TRAY.get(), "bacon");
		bulkBake(ModItems.COOKED_MUTTON_CHOPS.get(), ModItems.MUTTON_CHOPS.get(), consumer,
				ExtraDelightItems.TRAY.get(), "mutton_chops");
		bulkBake(ModItems.SMOKED_HAM.get(), ModItems.HAM.get(), consumer, ExtraDelightItems.TRAY.get(), "ham");
		bulkBake(Items.BREAD, ModItems.WHEAT_DOUGH.get(), consumer, ExtraDelightItems.LOAF_PAN.get(), "bread");
		bulkBake(Items.BAKED_POTATO, Items.POTATO, consumer, ExtraDelightItems.SHEET.get(), "potato");
		bulkBake(ExtraDelightItems.ROASTED_CARROT.get(), Items.CARROT, consumer, ExtraDelightItems.SHEET.get(),
				"carrot");
		bulkBake(ExtraDelightItems.ROASTED_APPLE.get(), Items.APPLE, consumer, ExtraDelightItems.SHEET.get(), "apple");
		bulkBake(Items.COOKED_BEEF, Items.BEEF, consumer, ExtraDelightItems.SHEET.get(), "beef");
		bulkBake(Items.COOKED_CHICKEN, Items.CHICKEN, consumer, ExtraDelightItems.SHEET.get(), "chicken");
		bulkBake(Items.COOKED_COD, Items.COD, consumer, ExtraDelightItems.SHEET.get(), "cod");
		bulkBake(Items.COOKED_MUTTON, Items.MUTTON, consumer, ExtraDelightItems.SHEET.get(), "mutton");
		bulkBake(Items.COOKED_PORKCHOP, Items.PORKCHOP, consumer, ExtraDelightItems.SHEET.get(), "porkchop");
		bulkBake(Items.COOKED_RABBIT, Items.RABBIT, consumer, ExtraDelightItems.SHEET.get(), "rabbit");
		bulkBake(Items.COOKED_SALMON, Items.SALMON, consumer, ExtraDelightItems.SHEET.get(), "salmon");
		bulkBake(ExtraDelightItems.TOAST.get(), ExtraDelightItems.BREAD_SLICE.get(), consumer,
				ExtraDelightItems.SHEET.get(), "toast");
		bulkBake(ExtraDelightItems.GRILLED_CHEESE.get(), ExtraDelightItems.CHEESE_SANDWICH.get(), consumer,
				ExtraDelightItems.SHEET.get(), "grilled_cheese");
		bulkBake(ExtraDelightItems.COOKED_CACTUS.get(), ExtraDelightItems.CACTUS.get(), consumer,
				ExtraDelightItems.SHEET.get(), "cooked_cactus");
	}

	void bulkBake(ItemLike mainResult, ItemLike in, Consumer<FinishedRecipe> consumer, ItemLike pan, String name) {
		for (int i = 1; i < 10; i++)
			OvenRecipeBuilder.OvenRecipe(mainResult, i, NORMAL_COOKING, MEDIUM_EXP, pan).addIngredient(in, i)
					.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedBy(name, has(in))
					.build(consumer, "extradelight:" + name + i);
	}
}

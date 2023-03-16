package com.lance5057.extradelight.data;

import java.util.function.Consumer;

import com.lance5057.butchercraft.tags.ExtraDelightItemTags;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.data.recipebuilders.DryingRackRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.DynamicNameSimpleCookingRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MixingBowlRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.MortarRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookTab;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class Recipes extends RecipeProvider {
	public Recipes(DataGenerator generator) {
		super(generator);
	}

	public static final int FAST_COOKING = 400; // 20 seconds
	public static final int NORMAL_COOKING = 800; // 40 seconds
	public static final int SLOW_COOKING = 1600; // 80 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

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
	}

	private void dryingRackRecipes(Consumer<FinishedRecipe> consumer) {
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.WET_SPONGE), Items.SPONGE, 10, 1000)
				.unlockedBy("has_sponge", has(Items.WET_SPONGE))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sponge"));
		DryingRackRecipeBuilder.drying(Ingredient.of(Items.KELP), Items.DRIED_KELP, 10, 1000)
				.unlockedBy("has_kelp", has(Items.KELP))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "dried_kelp"));
	}

	private void cookingRecipes(Consumer<FinishedRecipe> consumer) {
		DynamicNameSimpleCookingRecipeBuilder
				.smelting(Ingredient.of(ExtraDelightItems.OMELETTE_MIX.get()), ExtraDelightItems.OMELETTE.get(),
						MEDIUM_EXP, NORMAL_COOKING)
				.unlockedBy(getName(),
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE_MIX.get()))
				.save(consumer, "omelette_smoker");
//		SimpleCookingRecipeBuilder
//				.campfireCooking(Ingredient.of(ExtraDelightItems.OMELETTE_MIX.get()), ExtraDelightItems.OMELETTE.get(),
//						MEDIUM_EXP, NORMAL_COOKING)
//				.unlockedBy(getName(),
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE_MIX.get()))
//				.save(consumer, "omelette_fire");
//		SimpleCookingRecipeBuilder
//				.smelting(Ingredient.of(ExtraDelightItems.OMELETTE_MIX.get()), ExtraDelightItems.OMELETTE.get(),
//						MEDIUM_EXP, NORMAL_COOKING)
//				.unlockedBy(getName(),
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE_MIX.get()))
//				.save(consumer, "omelette_furnace");
	}

	private void mixingbowlRecipes(Consumer<FinishedRecipe> consumer) {
//		MixingBowlRecipeBuilder.stir(ExtraDelightItems.WHIPPED_CREAM.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
//				.requires(ModItems.MILK_BOTTLE.get())
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MILK_BOTTLE.get()))
//				.save(consumer);
//
//		MixingBowlRecipeBuilder.stir(ExtraDelightItems.WHIPPED_CREAM.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 4)
//				.requires(Items.MILK_BUCKET)
//				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
//				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "whipped_cream_bucket"));

		MixingBowlRecipeBuilder.stir(ExtraDelightItems.EGG_MIX.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.MILK_BOTTLE.get()).requires(Items.EGG).requires(Items.EGG)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.EGG))
				.save(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "egg_mix"));

		// Test, Remove!
		MixingBowlRecipeBuilder.stir(ExtraDelightItems.APPLE_JAM.get(), LONG_GRIND, Ingredient.of(Items.BOWL), 1)
				.requires(ModItems.MILK_BOTTLE.get()).requires(Items.CHAIN).requires(Items.ACACIA_DOOR)
				.requires(Items.BLUE_STAINED_GLASS_PANE).requires(Items.DARK_OAK_LOG).requires(Items.ELYTRA)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MILK_BOTTLE.get()))
				.save(consumer);
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
				.requires(ItemTags.PLANKS).requires(ExtraDelightItems.FLOUR.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FLOUR.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(ExtraDelightItems.DRYING_RACK.get()).pattern("WSW").pattern("SSS")
				.pattern("WSW").define('W', ItemTags.PLANKS).define('S', Tags.Items.STRING)
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

		// Juice
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.GLOW_BERRY_JUICE.get()).requires(Items.GLOW_BERRIES, 6)
				.requires(Items.SUGAR).requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_BERRIES))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.SWEET_BERRY_JUICE.get()).requires(Items.SWEET_BERRIES, 6)
				.requires(Items.SUGAR).requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.TOMATO_JUICE.get()).requires(ModItems.TOMATO.get(), 2)
				.requires(Items.SUGAR).requires(Items.GLASS_BOTTLE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TOMATO.get()))
				.save(consumer);

		// Pie
		ShapedRecipeBuilder.shaped(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()).pattern("fff").pattern("bbb")
				.pattern("sps").define('f', ExtraDelightItems.FLOUR.get()).define('b', Items.SWEET_BERRIES)
				.define('s', Items.SUGAR).define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()).pattern("fff").pattern("bbb")
				.pattern("sps").define('f', ExtraDelightItems.FLOUR.get()).define('b', Items.GLOW_BERRIES)
				.define('s', Items.SUGAR).define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHEESECAKE_ITEM.get()).pattern(" s ").pattern("mpm")
				.define('s', Items.SUGAR).define('m', ForgeTags.MILK).define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()).pattern("hhh").pattern("mpm")
				.define('m', ForgeTags.MILK).define('h', Items.HONEY_BOTTLE).define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()).pattern(" s ").pattern("hhh")
				.pattern("mpm").define('s', Items.SUGAR).define('m', ForgeTags.MILK).define('h', Items.COCOA_BEANS)
				.define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()).pattern(" s ").pattern("hhh")
				.pattern("mpm").define('s', Items.SUGAR).define('m', ForgeTags.MILK)
				.define('h', ModItems.PUMPKIN_SLICE.get()).define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()).pattern("hhh").pattern("hhh")
				.pattern("mpm").define('m', ForgeTags.MILK).define('h', Items.GLOW_BERRIES)
				.define('p', ModItems.PIE_CRUST.get())
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get()))
				.save(consumer);

		// Popsicles
		ShapedRecipeBuilder.shaped(ExtraDelightItems.FUDGE_POPSICLE.get()).pattern(" cm").pattern("isc").pattern("Si ")
				.define('m', ForgeTags.MILK).define('c', Items.COCOA_BEANS).define('s', Items.SUGAR)
				.define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.HONEY_POPSICLE.get()).pattern(" cm").pattern("imc").pattern("Si ")
				.define('m', ForgeTags.MILK).define('c', Items.HONEY_BOTTLE).define('S', Items.STICK)
				.define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.GLOW_BERRY_POPSICLE.get()).pattern(" gg").pattern("igg")
				.pattern("Si ").define('g', Items.GLOW_BERRIES).define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE)).save(consumer);
		ShapedRecipeBuilder.shaped(ExtraDelightItems.SWEET_BERRY_POPSICLE.get()).pattern(" gg").pattern("igg")
				.pattern("Si ").define('g', Items.SWEET_BERRIES).define('S', Items.STICK).define('i', Items.ICE)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ICE)).save(consumer);

		// Omelette
		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1).requires(Ingredient.of(ForgeTags.VEGETABLES))
				.requires(Ingredient.of(ForgeTags.VEGETABLES))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TOMATO.get()))
				.save(consumer, "veg_omelette");

		ShapelessRecipeBuilder.shapeless(ExtraDelightItems.OMELETTE_MIX.get())
				.requires(ExtraDelightItems.EGG_MIX.get(), 1)
				.requires(Ingredient.of(Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.COOKED_MUTTON,
						Items.COOKED_PORKCHOP))
				.requires(Ingredient.of(ForgeTags.VEGETABLES))
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TOMATO.get()))
				.save(consumer, "veg_meat_omelette");
	}

	private void potRecipes(Consumer<FinishedRecipe> consumer) {
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CHOCOLATE_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.COCOA_BEANS).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(Items.SUGAR).build(consumer);
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.PUMPKIN_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ModItems.PUMPKIN_SLICE.get()).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(Items.SUGAR).build(consumer);
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.HONEY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.HONEY_BOTTLE).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(Items.SUGAR).build(consumer);
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(Items.SWEET_BERRIES).addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.EGGS)
				.addIngredient(Items.SUGAR).build(consumer);
		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.KETCHUP_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(Items.SUGAR)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "ketchup_jar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.BBQ_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.SUGAR).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_sugar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.BBQ_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ForgeTags.VEGETABLES_TOMATO).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.HONEY_BOTTLE)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_honey"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.STOCK_JAR_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.GLASS_BOTTLE)
				.addIngredient(ExtraDelightTags.MAKES_STOCK).addIngredient(Items.BONE)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stock_jar"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.GRAVY_ITEM.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.FLOUR.get()).addIngredient(ExtraDelightItems.STOCK_JAR_ITEM.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "gravy_boat"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(ModItems.MINCED_BEEF.get(), 3).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightItems.GRAVY_ITEM.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "salisbury_steak_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(), 1,
						CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
				.addIngredient(Items.POTATO, 4).addIngredient(ExtraDelightItems.GRAVY_ITEM.get())
				.addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "mashed_potato_gravy_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRENCH_FRIES.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Items.POTATO).addIngredient(ExtraDelightTags.FRYING_OIL)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fries"));

		CookingPotRecipeBuilder.cookingPotRecipe(ExtraDelightItems.BUTTER.get(), 2, CookingRecipes.SLOW_COOKING, 1.0F)
				.addIngredient(Items.MILK_BUCKET).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "butter"));

		CookingPotRecipeBuilder.cookingPotRecipe(ExtraDelightItems.CHEESE.get(), 2, CookingRecipes.SLOW_COOKING, 1.0F)
				.addIngredient(Items.MILK_BUCKET).addIngredient(ExtraDelightItems.STOMACH.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cheese"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.LAMB_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.LAMB_STEW_MEAT.get()).addIngredient(Items.CARROT)
				.addIngredient(Items.POTATO).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lamb_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.PORK_STEW.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.PORK_STEW_MEAT.get()).addIngredient(Items.CARROT)
				.addIngredient(Items.POTATO).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_stew"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SAUSAGE_ROLL.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.SAUSAGE.get()).addIngredient(ModItems.WHEAT_DOUGH.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sausage_roll"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.SOS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BREAD)
				.addIngredient(ExtraDelightItems.BEEF_SCRAPS.get()).addIngredient(Items.WHEAT)
				.addIngredient(ForgeTags.MILK).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "sos"));

		CookingPotRecipeBuilder.cookingPotRecipe(ExtraDelightItems.LARD.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.FAT.get()).addIngredient(ExtraDelightItems.FAT.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lard"));

//		CookingPotRecipeBuilder
//				.cookingPotRecipe(ExtraDelightItems.HASH_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
//						Items.BOWL)
//				.addIngredient(ForgeTags.VEGETABLES_ONION).addIngredient(Items.POTATO)
//				.addIngredient(ExtraDelightItems.GROUND_BEEF.get())
//				.addIngredient(ExtraDelightItems.KETCHUP_JAR_ITEM.get()).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "hash_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItemTags.ROAST_RAW).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.POTATO).addIngredient(Items.CARROT)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pot_roast_feast"));

//		CookingPotRecipeBuilder
//				.cookingPotRecipe(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
//						Items.BOWL)
//				.addIngredient(ExtraDelightItemTags.ANY_RIBS_RAW).addIngredient(ExtraDelightItemTags.ANY_RIBS_RAW)
//				.addIngredient(ExtraDelightItemTags.ANY_RIBS_RAW).addIngredient(ExtraDelightItemTags.ANY_RIBS_RAW)
//				.addIngredient(ExtraDelightItems.BBQ_JAR_ITEM.get()).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "bbq_ribs_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItemTags.GROUND_MEAT_RAW).addIngredient(ExtraDelightItemTags.GROUND_MEAT_RAW)
				.addIngredient(ExtraDelightItemTags.GROUND_MEAT_RAW).addIngredient(Items.POTATO)
				.addIngredient(ForgeTags.VEGETABLES_ONION).addIngredient(ModItems.PIE_CRUST.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "meat_pie"));

//		CookingPotRecipeBuilder
//				.cookingPotRecipe(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
//						Items.BOWL)
//				.addIngredient(ExtraDelightItems.PORK_ROAST.get()).addIngredient(ExtraDelightItems.PORK_ROAST.get())
//				.addIngredient(ExtraDelightItems.BBQ_JAR_ITEM.get()).build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pulled_pork_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.LAMB_RIBS.get(), 2).addIngredient(ForgeTags.VEGETABLES_ONION)
				.addIngredient(Items.BREAD).addIngredient(Items.SWEET_BERRIES)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "rack_lamb_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItemTags.SCRAP_MEAT_RAW).addIngredient(ExtraDelightItemTags.SCRAP_MEAT_RAW)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.VEGETABLES)
				.addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.VEGETABLES)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stirfry_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(ExtraDelightItems.BEEF_ROAST.get(), 2).addIngredient(ModItems.WHEAT_DOUGH.get())
				.addIngredient(Tags.Items.MUSHROOMS).addIngredient(ExtraDelightItems.LIVER.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "beef_wellington_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.HAGGIS_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						ExtraDelightItems.STOMACH.get())
				.addIngredient(ExtraDelightItemTags.OFFAL).addIngredient(ExtraDelightItemTags.OFFAL)
				.addIngredient(ExtraDelightItemTags.OFFAL).addIngredient(ExtraDelightItems.LUNG.get())
				.addIngredient(Items.WHEAT).addIngredient(Items.POTATO)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "haggis_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BLACK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BLACK).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "black_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_RED_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_RED).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "red_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_GREEN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_GREEN).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "green_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BROWN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BROWN).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "brown_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_BLUE).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "blue_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_PURPLE).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "purple_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_CYAN_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_CYAN).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "cyan_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIGHT_GRAY).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "light_grey_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_GREY_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_GRAY).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "grey_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_PINK_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_PINK).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pink_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIME_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIME).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "lime_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_YELLOW).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "yellow_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_LIGHT_BLUE).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "light_blue_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_MAGENTA).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "magenta_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING,
						0.35F, Items.BOWL)
				.addIngredient(Tags.Items.DYES_ORANGE).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "orange_jelly_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.JELLY_WHITE_FEAST_ITEM.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(Tags.Items.DYES_WHITE).addIngredient(ExtraDelightItems.GELATIN.get())
				.addIngredient(Items.SUGAR).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.MILK_BUCKET)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "white_jelly_feast"));

		CookingPotRecipeBuilder.cookingPotRecipe(ExtraDelightItems.GELATIN.get(), 4, CookingRecipes.SLOW_COOKING, 0.35F)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.addIngredient(ExtraDelightItemTags.GELATIN_PROVIDER)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "gelatin"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.LIVER_ONIONS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F,
						Items.BOWL)
				.addIngredient(ExtraDelightItems.LIVER.get()).addIngredient(ForgeTags.VEGETABLES_ONION)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "liver_onions"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_FISH.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ItemTags.FISHES).addIngredient(Tags.Items.CROPS_WHEAT)
				.addIngredient(ExtraDelightItems.LARD.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_fish"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Items.BEEF).addIngredient(Tags.Items.CROPS_WHEAT)
				.addIngredient(ExtraDelightItems.LARD.get()).addIngredient(ExtraDelightItems.GRAVY_ITEM.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "chicken_fried_steak"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.PORK_TENDERLOIN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(Items.PORKCHOP).addIngredient(Tags.Items.CROPS_WHEAT)
				.addIngredient(ExtraDelightItems.LARD.get()).addIngredient(Items.BREAD)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "pork_tenderloin"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_CHICKEN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ModItems.CHICKEN_CUTS.get()).addIngredient(Tags.Items.CROPS_WHEAT)
				.addIngredient(ExtraDelightItems.LARD.get())
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_chicken"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.STUFFED_HEART.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.HEART.get()).addIngredient(Tags.Items.MUSHROOMS)
				.addIngredient(Items.BREAD).addIngredient(ForgeTags.VEGETABLES_ONION).addIngredient(Items.EGG)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "stuffed_heart"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.FRIED_BRAINS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.BRAIN.get()).addIngredient(Tags.Items.CROPS_WHEAT)
				.addIngredient(ExtraDelightItems.LARD.get()).addIngredient(Items.EGG)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "fried_brains"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(ExtraDelightItems.OXTAIL_SOUP.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
				.addIngredient(ExtraDelightItems.OXTAIL.get()).addIngredient(Items.CARROT)
				.addIngredient(ExtraDelightItems.STOCK_JAR_ITEM.get()).addIngredient(ForgeTags.VEGETABLES_TOMATO)
				.build(consumer, new ResourceLocation(ExtraDelight.MOD_ID, "oxtail_soup"));
	}

	private void knifeRecipes(Consumer<FinishedRecipe> consumer) {
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.WHEAT), Ingredient.of(ForgeTags.TOOLS_KNIVES), Items.WHEAT_SEEDS, 2)
				.addResult(ModItems.STRAW.get()).build(consumer);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.SUNFLOWER), Ingredient.of(ForgeTags.TOOLS_KNIVES),
				ExtraDelightItems.SUNFLOWER_SEEDS.get(), 2).addResult(Items.YELLOW_DYE, 2).build(consumer);
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
				.save(consumer, "lily_white");
		MortarRecipeBuilder.grind(Ingredient.of(Items.ORANGE_TULIP), Items.ORANGE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ORANGE_TULIP))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.ALLIUM), Items.MAGENTA_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ALLIUM)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.LILAC), Items.MAGENTA_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.LILAC))
				.save(consumer, "lilac_magenta");
		MortarRecipeBuilder.grind(Ingredient.of(Items.BLUE_ORCHID), Items.LIGHT_BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLUE_ORCHID))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.DANDELION), Items.YELLOW_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.DANDELION)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.SUNFLOWER), Items.YELLOW_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUNFLOWER))
				.save(consumer, "sunflower_yellow");
		MortarRecipeBuilder.grind(Ingredient.of(Items.SEA_PICKLE), Items.LIME_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.SEA_PICKLE))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.PINK_TULIP), Items.PINK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_TULIP))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.PEONY), Items.PINK_DYE, STANDARD_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.PEONY))
				.save(consumer, "peony_pink");
		MortarRecipeBuilder.grind(Ingredient.of(Items.OXEYE_DAISY), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.OXEYE_DAISY))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.AZURE_BLUET), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.AZURE_BLUET))
				.save(consumer, "lgray_azure");
		MortarRecipeBuilder.grind(Ingredient.of(Items.WHITE_TULIP), Items.LIGHT_GRAY_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_TULIP))
				.save(consumer, "lgray_tulip");
		MortarRecipeBuilder.grind(Ingredient.of(Items.CORNFLOWER), Items.BLUE_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CORNFLOWER))
				.save(consumer, "blue_corn");
		MortarRecipeBuilder.grind(Ingredient.of(Items.COCOA_BEANS), Items.BROWN_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS))
				.save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.CACTUS), Items.GREEN_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CACTUS)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.RED_TULIP), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_TULIP)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.BEETROOT), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT))
				.save(consumer, "red_beet");
		MortarRecipeBuilder.grind(Ingredient.of(Items.POPPY), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.POPPY))
				.save(consumer, "poppy_red");
		MortarRecipeBuilder.grind(Ingredient.of(Items.ROSE_BUSH), Items.RED_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROSE_BUSH))
				.save(consumer, "rose_red");
		MortarRecipeBuilder.grind(Ingredient.of(Items.INK_SAC), Items.BLACK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.INK_SAC)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.WITHER_ROSE), Items.BLACK_DYE, STANDARD_GRIND, 2)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WITHER_ROSE))
				.save(consumer, "wither_black");

		MortarRecipeBuilder.grind(Ingredient.of(Items.BONE), Items.BONE_MEAL, LONG_GRIND, 4)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);
		MortarRecipeBuilder.grind(Ingredient.of(Items.BLAZE_ROD), Items.BLAZE_POWDER, LONG_GRIND, 3)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder.grind(Ingredient.of(Items.WHEAT_SEEDS), ExtraDelightItems.FLOUR.get(), STANDARD_GRIND, 1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL)).save(consumer);

		MortarRecipeBuilder
				.grind(Ingredient.of(Items.BEETROOT_SEEDS, ModItems.CABBAGE_SEEDS.get(), ModItems.TOMATO_SEEDS.get(),
						ExtraDelightItems.SUNFLOWER_SEEDS.get()), ExtraDelightItems.COOKING_OIL.get(), STANDARD_GRIND,
						1)
				.unlockedBy(getName(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT_SEEDS))
				.save(consumer);
	}

	void ovenRecipes(Consumer<FinishedRecipe> consumer) {
		OvenRecipeBuilder.OvenRecipe(Items.CAKE, 1, NORMAL_COOKING, MEDIUM_EXP, ExtraDelightItems.ROUND_PAN.get())
				.addIngredient(ExtraDelightItems.FLOUR.get(), 3).addIngredient(ForgeTags.MILK)
				.addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.MILK).addIngredient(Items.EGG)
				.addIngredient(Items.SUGAR, 2).setRecipeBookTab(OvenRecipeBookTab.MEALS)
				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

//		OvenRecipeBuilder
//				.OvenRecipe(ExtraDelightItems.CUPCAKE.get(), 6, FAST_COOKING, MEDIUM_EXP,
//						ExtraDelightItems.MUFFIN_TIN.get())
//				.addIngredient(ExtraDelightItems.FLOUR.get(), 3).addIngredient(ForgeTags.MILK)
//				.addIngredient(ForgeTags.MILK).addIngredient(ForgeTags.MILK).addIngredient(Items.EGG)
//				.addIngredient(Items.SUGAR, 2).setRecipeBookTab(OvenRecipeBookTab.MEALS)
//				.unlockedByAnyIngredient(Items.WHEAT, Items.EGG, Items.SUGAR, Items.MILK_BUCKET).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.GLOW_BERRY_COOKIE.get(), 6, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightItems.FLOUR.get(), 2).addIngredient(Items.GLOW_BERRIES)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.SUGAR_COOKIE.get(), 6, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightItems.FLOUR.get(), 2).addIngredient(Items.SUGAR)
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);

		OvenRecipeBuilder
				.OvenRecipe(ExtraDelightItems.PUMPKIN_COOKIE.get(), 6, FAST_COOKING, MEDIUM_EXP,
						ExtraDelightItems.SHEET.get())
				.addIngredient(ExtraDelightItems.FLOUR.get(), 2).addIngredient(ModItems.PUMPKIN_SLICE.get())
				.setRecipeBookTab(OvenRecipeBookTab.MEALS).unlockedByAnyIngredient(Items.GLOW_BERRIES).build(consumer);
	}
}

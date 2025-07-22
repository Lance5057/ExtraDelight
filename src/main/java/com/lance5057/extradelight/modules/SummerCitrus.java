package com.lance5057.extradelight.modules;

import static com.lance5057.extradelight.ExtraDelightBlocks.bowl;
import static com.lance5057.extradelight.ExtraDelightBlocks.plate;
import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.FruitLeafBlock;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.fluids.VinegarFluidBlock;
import com.lance5057.extradelight.blocks.jardisplay.JarSingularBlock;
import com.lance5057.extradelight.blocks.jardisplay.JarSingularItem;
import com.lance5057.extradelight.blocks.picnicbasket.PicnicBasketBlock;
import com.lance5057.extradelight.client.BlockStateItemGeometryLoader;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.data.recipebuilders.ChillerRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.JuicerRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.VatRecipeBuilder;
import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.GlowberryJuiceItem;
import com.lance5057.extradelight.items.GourmetHotCocoa;
import com.lance5057.extradelight.items.ToolTipConsumableItem;
import com.lance5057.extradelight.items.components.ChillComponent;
import com.lance5057.extradelight.util.EDItemGenerator;
import com.lance5057.extradelight.workstations.vat.recipes.VatRecipe;
import com.lance5057.extradelight.worldgen.features.trees.ExtraDelightTreeGrowers;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class SummerCitrus {
	// Lemon
	public static final DeferredItem<Item> LEMON = EDItemGenerator
			.register("lemon", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredBlock<FruitLeafBlock> LEMON_LEAVES = ExtraDelightBlocks.BLOCKS.register("lemon_leaves",
			() -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES), LEMON));
	public static final DeferredItem<Item> LEMON_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("lemon_leaves",
			() -> new BlockItem(LEMON_LEAVES.get(), new Item.Properties()));
	public static final DeferredBlock<SaplingBlock> LEMON_SAPLING = ExtraDelightBlocks.BLOCKS.register("lemon_sapling",
			() -> new SaplingBlock(ExtraDelightTreeGrowers.LEMON,
					Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
	public static final DeferredItem<Item> LEMON_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("lemon_sapling",
			() -> new BlockItem(LEMON_SAPLING.get(), new Item.Properties()));
	public static final DeferredBlock<Block> POTTED_LEMON_SAPLING = ExtraDelightBlocks.BLOCKS
			.register("potted_lemon_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
					LEMON_SAPLING, Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> LEMON_JUICE = EDItemGenerator
			.register("lemon_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> LEMON_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
			"lemon_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.LEMON_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> LEMON_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("lemon_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.LEMON_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final DeferredBlock<Block> LEMON_CRATE = ExtraDelightBlocks.BLOCKS.register("lemon_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> LEMON_CRATE_ITEM = ExtraDelightItems.ITEMS.register("lemon_crate_item",
			() -> new BlockItem(LEMON_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> SLICED_LEMON = EDItemGenerator
			.register("sliced_lemon", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> LEMON_ZEST = EDItemGenerator
			.register("lemon_zest", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// Lime
	public static final DeferredItem<Item> LIME = EDItemGenerator
			.register("lime", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredBlock<FruitLeafBlock> LIME_LEAVES = ExtraDelightBlocks.BLOCKS.register("lime_leaves",
			() -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES), LIME));
	public static final DeferredItem<Item> LIME_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("lime_leaves",
			() -> new BlockItem(LIME_LEAVES.get(), new Item.Properties()));
	public static final DeferredBlock<SaplingBlock> LIME_SAPLING = ExtraDelightBlocks.BLOCKS.register("lime_sapling",
			() -> new SaplingBlock(ExtraDelightTreeGrowers.LIME, Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
	public static final DeferredItem<Item> LIME_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("lime_sapling",
			() -> new BlockItem(LIME_SAPLING.get(), new Item.Properties()));
	public static final DeferredBlock<Block> POTTED_LIME_SAPLING = ExtraDelightBlocks.BLOCKS
			.register("potted_lime_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
					LIME_SAPLING, Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> LIME_JUICE = EDItemGenerator
			.register("lime_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> LIME_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
			"lime_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.LIME_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> LIME_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("lime_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.LIME_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final DeferredBlock<Block> LIME_CRATE = ExtraDelightBlocks.BLOCKS.register("lime_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> LIME_CRATE_ITEM = ExtraDelightItems.ITEMS.register("lime_crate_item",
			() -> new BlockItem(LIME_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> SLICED_LIME = EDItemGenerator
			.register("sliced_lime", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> LIME_ZEST = EDItemGenerator
			.register("lime_zest", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// Orange
	public static final DeferredItem<Item> ORANGE = EDItemGenerator
			.register("orange", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredBlock<FruitLeafBlock> ORANGE_LEAVES = ExtraDelightBlocks.BLOCKS.register(
			"orange_leaves", () -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES), ORANGE));
	public static final DeferredItem<Item> ORANGE_LEAVES_ITEM = ExtraDelightItems.ITEMS.register("orange_leaves",
			() -> new BlockItem(ORANGE_LEAVES.get(), new Item.Properties()));
	public static final DeferredBlock<SaplingBlock> ORANGE_SAPLING = ExtraDelightBlocks.BLOCKS
			.register("orange_sapling", () -> new SaplingBlock(ExtraDelightTreeGrowers.ORANGE,
					Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
	public static final DeferredItem<Item> ORANGE_SAPLING_ITEM = ExtraDelightItems.ITEMS.register("orange_sapling",
			() -> new BlockItem(ORANGE_SAPLING.get(), new Item.Properties()));
	public static final DeferredBlock<Block> POTTED_ORANGE_SAPLING = ExtraDelightBlocks.BLOCKS.register(
			"potted_orange_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_SAPLING,
					Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> ORANGE_JUICE = EDItemGenerator
			.register("orange_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> ORANGE_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
			"orange_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.ORANGE_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> ORANGE_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS.register(
			"orange_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.ORANGE_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final DeferredBlock<Block> ORANGE_CRATE = ExtraDelightBlocks.BLOCKS.register("orange_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> ORANGE_CRATE_ITEM = ExtraDelightItems.ITEMS.register("orange_crate_item",
			() -> new BlockItem(ORANGE_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> SLICED_ORANGE = EDItemGenerator
			.register("sliced_orange", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> ORANGE_ZEST = EDItemGenerator
			.register("orange_zest", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// Grapefruit
	public static final DeferredItem<Item> GRAPEFRUIT = EDItemGenerator
			.register("grapefruit", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredBlock<FruitLeafBlock> GRAPEFRUIT_LEAVES = ExtraDelightBlocks.BLOCKS.register(
			"grapefruit_leaves",
			() -> new FruitLeafBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_LEAVES), GRAPEFRUIT));
	public static final DeferredItem<Item> GRAPEFRUIT_LEAVES_ITEM = ExtraDelightItems.ITEMS
			.register("grapefruit_leaves", () -> new BlockItem(GRAPEFRUIT_LEAVES.get(), new Item.Properties()));
	public static final DeferredBlock<SaplingBlock> GRAPEFRUIT_SAPLING = ExtraDelightBlocks.BLOCKS
			.register("grapefruit_sapling", () -> new SaplingBlock(ExtraDelightTreeGrowers.GRAPEFRUIT,
					Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
	public static final DeferredItem<Item> GRAPEFRUIT_SAPLING_ITEM = ExtraDelightItems.ITEMS
			.register("grapefruit_sapling", () -> new BlockItem(GRAPEFRUIT_SAPLING.get(), new Item.Properties()));
	public static final DeferredBlock<Block> POTTED_GRAPEFRUIT_SAPLING = ExtraDelightBlocks.BLOCKS.register(
			"potted_grapefruit_sapling",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, GRAPEFRUIT_SAPLING,
					Block.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> GRAPEFRUIT_JUICE = EDItemGenerator
			.register("grapefruit_juice", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> GRAPEFRUIT_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
			"grapefruit_juice_fluid_bucket",
			() -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.GRAPEFRUIT_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> GRAPEFRUIT_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("grapefruit_juice_fluid_block", () -> new VinegarFluidBlock(
					ExtraDelightFluids.GRAPEFRUIT_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final DeferredBlock<Block> GRAPEFRUIT_CRATE = ExtraDelightBlocks.BLOCKS.register("grapefruit_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> GRAPEFRUIT_CRATE_ITEM = ExtraDelightItems.ITEMS
			.register("grapefruit_crate_item", () -> new BlockItem(GRAPEFRUIT_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> SLICED_GRAPEFRUIT = EDItemGenerator
			.register("sliced_grapefruit", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// Egg separating
	public static final DeferredItem<Item> EGG_YOLK = EDItemGenerator
			.register("egg_yolk", () -> new Item(new Item.Properties().craftRemainder(Items.BONE_MEAL)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> EGG_WHITE = EDItemGenerator
			.register("egg_white", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> EGG_WHITE_FLUID_BUCKET = ExtraDelightItems.ITEMS
			.register("egg_white_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.EGG_WHITE));
	public static final DeferredBlock<LiquidBlock> EGG_WHITE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("egg_white_fluid_block", () -> new LiquidBlock(ExtraDelightFluids.EGG_WHITE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final DeferredItem<Item> STIFF_PEAKS = EDItemGenerator
			.register("stiff_peaks", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();

	// Watermelon
	public static final DeferredItem<Item> MELON_CHUNKS = EDItemGenerator
			.register("melon_chunks", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> MELON_RIND = EDItemGenerator
			.register("melon_rind", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// The rest!
	public static final DeferredItem<Item> ICE_CUBES = EDItemGenerator
			.register("ice_cubes", () -> new Item(
					new Item.Properties().component(ExtraDelightComponents.CHILL.value(), new ChillComponent(25))))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> MERINGUE = EDItemGenerator
			.register("meringue", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> LEMON_CURD = EDItemGenerator
			.register("lemon_curd", () -> new Item(foodItem(EDFoods.JAM).craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> LEMON_MERINGUE_PIE_SLICE = EDItemGenerator
			.register("lemon_meringue_pie_slice",
					() -> new ToolTipConsumableItem(ExtraDelightItems.stack16FoodItem(EDFoods.GRASSHOPPER_PIE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<Block> LEMON_MERINGUE_PIE = ExtraDelightBlocks.BLOCKS.register(
			"lemon_meringue_pie",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), LEMON_MERINGUE_PIE_SLICE));
	public static final DeferredItem<Item> LEMON_MERINGUE_PIE_ITEM = EDItemGenerator
			.register("lemon_meringue_pie_item", () -> new BlockItem(LEMON_MERINGUE_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> KEY_LIME_PIE_SLICE = EDItemGenerator
			.register("key_lime_pie_slice",
					() -> new ToolTipConsumableItem(ExtraDelightItems.stack16FoodItem(EDFoods.GRASSHOPPER_PIE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<Block> KEY_LIME_PIE = ExtraDelightBlocks.BLOCKS.register("key_lime_pie",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), KEY_LIME_PIE_SLICE));
	public static final DeferredItem<Item> KEY_LIME_PIE_ITEM = EDItemGenerator
			.register("key_lime_pie_item", () -> new BlockItem(KEY_LIME_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> LEMONADE = EDItemGenerator
			.register("lemonade", () -> new GlowberryJuiceItem(ExtraDelightItems.drinkItem())).drink().setHydration(20)
			.setThirst(6).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> LIMEADE = EDItemGenerator
			.register("limeade", () -> new GlowberryJuiceItem(ExtraDelightItems.drinkItem())).drink().setHydration(20)
			.setThirst(6).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> ORANGEADE = EDItemGenerator
			.register("orangeade", () -> new GlowberryJuiceItem(ExtraDelightItems.drinkItem())).drink().setHydration(20)
			.setThirst(6).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> MELON_GAZPACHO = EDItemGenerator
			.register("melon_gazpacho", () -> new Item(bowlFoodItem(EDFoods.GAZPACHO))).advancementMeal().finish();
	public static final DeferredItem<Item> THAI_MELON_SALAD = EDItemGenerator
			.register("thai_melon_salad", () -> new Item(bowlFoodItem(EDFoods.SHIRAZI_SALAD))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> ETON_MESS = EDItemGenerator
			.register("eton_mess", () -> new Item(bowlFoodItem(EDFoods.ICE_CREAM_SUNDAE))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> DALGONA_COFFEE = EDItemGenerator
			.register("dalgona_coffee",
					() -> new GourmetHotCocoa(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.drink().setHydration(40).setThirst(4).isHot(true).setPoison(0).finish();
	public static final DeferredItem<Item> GRAPEFRUIT_BEETROOT_SALAD = EDItemGenerator
			.register("grapefruit_beetroot_salad", () -> new Item(bowlFoodItem(EDFoods.SHIRAZI_SALAD)))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CITRUS_ONION_SALAD = EDItemGenerator
			.register("citrus_onion_salad", () -> new Item(bowlFoodItem(EDFoods.SHIRAZI_SALAD))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> MELON_FRUIT_SALAD_SERVING = EDItemGenerator
			.register("melon_fruit_salad_serving",
					() -> new ToolTipConsumableItem(ExtraDelightItems.stack16FoodItem(EDFoods.SHIRAZI_SALAD), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<RecipeFeastBlock> MELON_FRUIT_SALAD = ExtraDelightBlocks.BLOCKS.register(
			"melon_fruit_salad",
			() -> new RecipeFeastBlock(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.COLOR_GREEN),
					true, bowl));
	public static final DeferredItem<Item> MELON_FRUIT_SALAD_ITEM = EDItemGenerator
			.register("melon_fruit_salad_item", () -> new BlockItem(MELON_FRUIT_SALAD.get(), new Item.Properties()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> LEMON_CUCUMBER_CAKE_SLICE = EDItemGenerator
			.register("lemon_cucumber_cake_slice", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredBlock<Block> LEMON_CUCUMBER_CAKE = ExtraDelightBlocks.BLOCKS
			.register("lemon_cucumber_cake", () -> new CakeBlock(Block.Properties.ofFullCopy(Blocks.CAKE)));
	public static final DeferredItem<Item> LEMON_CUCUMBER_CAKE_ITEM = EDItemGenerator
			.register("lemon_cucumber_cake_item", () -> new BlockItem(LEMON_CUCUMBER_CAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredBlock<RecipeFeastBlock> BAKED_COD = ExtraDelightBlocks.BLOCKS.register("baked_cod",
			() -> new RecipeFeastBlock(
					BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_ORANGE), true,
					Block.box(0, 0, 0, 0, 0, 0), Block.box(-4.0D, 0.0D, 3.5D, 20.0D, 1.0D, 12.5D),
					Block.box(3.5D, 0.0D, -4.0D, 12.5D, 1.0D, 20.0D)));
	public static final DeferredItem<Item> BAKED_COD_ITEM = EDItemGenerator
			.register("baked_cod_item", () -> new BlockItem(BAKED_COD.get(), new Item.Properties())).advancementFeast()
			.finish();
	public static final DeferredItem<Item> BAKED_COD_SERVING = EDItemGenerator
			.register("baked_cod_serving", () -> new Item(new Item.Properties().food(EDFoods.SOY_GLAZED_SALMON)))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> MELON_LAYER_CAKE_SLICE = EDItemGenerator
			.register("melon_layer_cake_slice", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredBlock<Block> MELON_LAYER_CAKE = ExtraDelightBlocks.BLOCKS.register("melon_layer_cake",
			() -> new CakeBlock(Block.Properties.ofFullCopy(Blocks.CAKE)));
	public static final DeferredItem<Item> MELON_LAYER_CAKE_ITEM = EDItemGenerator
			.register("melon_layer_cake_item", () -> new BlockItem(MELON_LAYER_CAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> GRAPEFRUIT_SORBET = EDItemGenerator
			.register("grapefruit_sorbet", () -> new Item(bowlFoodItem(EDFoods.ICE_CREAM_SUNDAE))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_ORANGE = EDItemGenerator
			.register("chocolate_orange", () -> new Item(bowlFoodItem(EDFoods.CHOCOLATE_TRUFFLE))).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_MOUSSE = EDItemGenerator
			.register("chocolate_mousse", () -> new Item(bowlFoodItem(EDFoods.ICE_CREAM_SUNDAE))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> JAFFA_CAKE = EDItemGenerator
			.register("jaffa_cake", () -> new Item(bowlFoodItem(EDFoods.ICE_CREAM_SUNDAE))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> GRILLED_GRAPEFRUIT = EDItemGenerator
			.register("grilled_grapefruit", () -> new Item(bowlFoodItem(EDFoods.APPLE_FRITTERS))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> LEMON_DELICIOUS = EDItemGenerator
			.register("lemon_delicious", () -> new Item(bowlFoodItem(EDFoods.APPLE_FRITTERS))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> ORANGE_CHICKEN = EDItemGenerator
			.register("orange_chicken", () -> new Item(bowlFoodItem(EDFoods.CARAMEL_CHICKEN))).advancementButchercraft()
			.finish();
	public static final DeferredItem<Item> MELON_RIND_STIRFRY = EDItemGenerator
			.register("melon_rind_stirfry", () -> new Item(bowlFoodItem(EDFoods.CARROT_SALAD))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> LIME_SOUFFLE = EDItemGenerator
			.register("lime_souffle", () -> new Item(bowlFoodItem(EDFoods.CARROT_SALAD))).advancementDessert().finish();
	public static final DeferredItem<Item> CHEESE_SOUFFLE = EDItemGenerator
			.register("cheese_souffle", () -> new Item(bowlFoodItem(EDFoods.CARROT_SALAD))).advancementMeal().finish();
	public static final DeferredItem<Item> PAVLOVA_SLICE = EDItemGenerator
			.register("pavlova_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.TARTE_TATIN_SLICE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<PieBlock> PAVLOVA = ExtraDelightBlocks.BLOCKS.register("pavlova",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), PAVLOVA_SLICE) {
				@Override
				public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
						CollisionContext context) {
					return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
				}
			});
	public static final DeferredItem<Item> PAVLOVA_ITEM = EDItemGenerator
			.register("pavlova_item", () -> new BlockItem(PAVLOVA.get(), new Item.Properties())).advancementFeast()
			.feastToolTip().finish();
	public static final DeferredBlock<JarSingularBlock> PRESERVED_LEMONS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("preserved_lemons_block", () -> new JarSingularBlock(BlockBehaviour.Properties
					.ofFullCopy(Blocks.GLASS).strength(0.8F).sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN)));
	public static final DeferredItem<Item> PRESERVED_LEMONS_BLOCK_ITEM = EDItemGenerator
			.register("preserved_lemons_block_item",
					() -> new JarSingularItem(PRESERVED_LEMONS_BLOCK.get(),
							new Item.Properties().component(DataComponents.BLOCK_STATE,
									BlockItemStateProperties.EMPTY.with(RecipeFeastBlock.SERVINGS, 4))))
			.advancementFeast().finish();
	public static final DeferredItem<Item> PRESERVED_LEMON_ITEM = EDItemGenerator
			.register("preserved_lemon_item", () -> new Item(new Item.Properties().food(EDFoods.PICKLED_EGG)))
			.advancementSnack().servingToolTip().finish();
	public static final DeferredBlock<JarSingularBlock> PICKLED_RINDS_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("pickled_rinds_block", () -> new JarSingularBlock(BlockBehaviour.Properties
					.ofFullCopy(Blocks.GLASS).strength(0.8F).sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN)));
	public static final DeferredItem<Item> PICKLED_RINDS_BLOCK_ITEM = EDItemGenerator
			.register("pickled_rinds_block_item",
					() -> new JarSingularItem(PICKLED_RINDS_BLOCK.get(),
							new Item.Properties().component(DataComponents.BLOCK_STATE,
									BlockItemStateProperties.EMPTY.with(RecipeFeastBlock.SERVINGS, 4))))
			.advancementFeast().finish();
	public static final DeferredItem<Item> PICKLED_RIND_ITEM = EDItemGenerator
			.register("pickled_rind_item", () -> new Item(new Item.Properties().food(EDFoods.PICKLED_EGG)))
			.advancementSnack().servingToolTip().finish();
	public static final DeferredItem<Item> PRESERVED_LEMON_PASTA = EDItemGenerator
			.register("preserved_lemon_pasta", () -> new Item(bowlFoodItem(EDFoods.BUTTERED_PASTA))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> CANDIED_CITRUS_ZEST = EDItemGenerator
			.register("candied_citrus_zest", () -> new Item(bowlFoodItem(EDFoods.CANDY_APPLE))).advancementCandy()
			.finish();
	public static final DeferredItem<Item> LEMON_POSSET = EDItemGenerator
			.register("lemon_posset", () -> new Item(bowlFoodItem(EDFoods.CUSTARD))).advancementDessert().finish();
	public static final DeferredItem<Item> MELON_LIME_GLAZED_CHICKEN = EDItemGenerator
			.register("melon_lime_glazed_chicken", () -> new Item(bowlFoodItem(EDFoods.CARAMEL_CHICKEN)))
			.advancementButchercraft().finish();
	public static final DeferredItem<Item> KYIV_CAKE_SLICE = EDItemGenerator
			.register("kyiv_cake_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.TARTE_TATIN_SLICE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<PieBlock> KYIV_CAKE = ExtraDelightBlocks.BLOCKS.register("kyiv_cake",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), KYIV_CAKE_SLICE) {
				@Override
				public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
						CollisionContext context) {
					return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
				}
			});
	public static final DeferredItem<Item> KYIV_CAKE_ITEM = EDItemGenerator
			.register("kyiv_cake_item", () -> new BlockItem(KYIV_CAKE.get(), new Item.Properties())).advancementFeast()
			.feastToolTip().finish();
	public static final DeferredItem<Item> BAKED_ALASKA_SERVING = EDItemGenerator
			.register("baked_alaska_serving",
					() -> new ToolTipConsumableItem(ExtraDelightItems.stack16FoodItem(EDFoods.SHIRAZI_SALAD), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<RecipeFeastBlock> BAKED_ALASKA = ExtraDelightBlocks.BLOCKS
			.register("baked_alaska",
					() -> new RecipeFeastBlock(
							Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE), true,
							plate));
	public static final DeferredItem<Item> BAKED_ALASKA_ITEM = EDItemGenerator
			.register("baked_alaska_item", () -> new BlockItem(BAKED_ALASKA.get(), new Item.Properties()))
			.advancementFeast().finish();

	public static final DeferredBlock<PicnicBasketBlock> WHITE_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"white_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.WHITE, Block.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> ORANGE_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"orange_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.ORANGE, Block.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> MAGENTA_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"magenta_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.MAGENTA, Block.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> LIGHT_BLUE_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"light_blue_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.LIGHT_BLUE, Block.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> YELLOW_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"yellow_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.YELLOW, Block.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> LIME_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"lime_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.LIME, Block.Properties.ofFullCopy(Blocks.LIME_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> PINK_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"pink_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.PINK, Block.Properties.ofFullCopy(Blocks.PINK_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> GRAY_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"gray_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.GRAY, Block.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> LIGHT_GRAY_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"light_gray_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.LIGHT_GRAY, Block.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> CYAN_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"cyan_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.CYAN, Block.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> BLUE_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"blue_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.BLUE, Block.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> BROWN_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"brown_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.BROWN, Block.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> GREEN_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"green_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.GREEN, Block.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> RED_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"red_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.RED, Block.Properties.ofFullCopy(Blocks.RED_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> BLACK_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"black_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.BLACK, Block.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
	public static final DeferredBlock<PicnicBasketBlock> PURPLE_PICNIC_BASKET = ExtraDelightBlocks.BLOCKS.register(
			"purple_picnic_basket",
			() -> new PicnicBasketBlock(DyeColor.PURPLE, Block.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));

	public static final DeferredItem<Item> WHITE_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"white_picnic_basket", () -> new BlockItem(SummerCitrus.WHITE_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> ORANGE_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"orange_picnic_basket", () -> new BlockItem(SummerCitrus.ORANGE_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> MAGENTA_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"magenta_picnic_basket", () -> new BlockItem(SummerCitrus.MAGENTA_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIGHT_BLUE_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"light_blue_picnic_basket",
			() -> new BlockItem(SummerCitrus.LIGHT_BLUE_PICNIC_BASKET.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> YELLOW_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"yellow_picnic_basket", () -> new BlockItem(SummerCitrus.YELLOW_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIME_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"lime_picnic_basket", () -> new BlockItem(SummerCitrus.LIME_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> PINK_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"pink_picnic_basket", () -> new BlockItem(SummerCitrus.PINK_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> GRAY_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"gray_picnic_basket", () -> new BlockItem(SummerCitrus.GRAY_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIGHT_GRAY_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"light_gray_picnic_basket",
			() -> new BlockItem(SummerCitrus.LIGHT_GRAY_PICNIC_BASKET.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> CYAN_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"cyan_picnic_basket", () -> new BlockItem(SummerCitrus.CYAN_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BLUE_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"blue_picnic_basket", () -> new BlockItem(SummerCitrus.BLUE_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BROWN_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"brown_picnic_basket", () -> new BlockItem(SummerCitrus.BROWN_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> GREEN_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"green_picnic_basket", () -> new BlockItem(SummerCitrus.GREEN_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> RED_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"red_picnic_basket", () -> new BlockItem(SummerCitrus.RED_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BLACK_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"black_picnic_basket", () -> new BlockItem(SummerCitrus.BLACK_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> PURPLE_PICNIC_BASKET_ITEM = ExtraDelightItems.ITEMS.register(
			"purple_picnic_basket", () -> new BlockItem(SummerCitrus.PURPLE_PICNIC_BASKET.get(), new Item.Properties()
					.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

//	public static final TagKey<BannerPattern> CITRUS_BANNER_TAG = TagKey.create(Registries.BANNER_PATTERN,
//			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "citrus_rind_banner_tag"));
//	public static final DeferredItem<Item> CITRUS_RIND_PATTERN_ITEM = ExtraDelightItems.ITEMS.register(
//			"citrus_rind_banner_item", () -> new BannerPatternItem(ExtraDelightBanners.CITRUS_RIND_BANNER_PATTERN,
//					new Item.Properties().stacksTo(1)));
//	public static final DeferredHolder<BannerPattern, BannerPattern> CITRUS_RIND = ExtraDelightBanners.BANNER_PATTERNS
//			.register("citrus_rind_banner", () -> new BannerPattern(ExtraDelight.modLoc("citrus_rind_banner"),
//					"block.minecraft.banner.extradelight.citrus_rind"));

	public static void blockModels(BlockStateProvider bsp) {
		BlockModels.fruitLeafBlock(bsp, LEMON_LEAVES.get(), "lemon");
		bsp.simpleBlock(LEMON_SAPLING.get(), new ConfiguredModel(bsp.models()
				.cross("lemon_sapling", bsp.modLoc("block/crops/fruit/lemon/lemon_sapling")).renderType("cutout")));
		BlockModels.pottedBlock(bsp, POTTED_LEMON_SAPLING.get(), "lemon_sapling", "crops/fruit/lemon/lemon_sapling");
		BlockModels.fluid(bsp, LEMON_JUICE_FLUID_BLOCK.get());
		BlockModels.crateBlock(bsp, LEMON_CRATE.get(), "lemon", "oak");

		BlockModels.fruitLeafBlock(bsp, LIME_LEAVES.get(), "lime");
		bsp.simpleBlock(LIME_SAPLING.get(), new ConfiguredModel(bsp.models()
				.cross("lime_sapling", bsp.modLoc("block/crops/fruit/lime/lime_sapling")).renderType("cutout")));
		BlockModels.pottedBlock(bsp, POTTED_LIME_SAPLING.get(), "lime_sapling", "crops/fruit/lime/lime_sapling");
		BlockModels.fluid(bsp, LIME_JUICE_FLUID_BLOCK.get());
		BlockModels.crateBlock(bsp, LIME_CRATE.get(), "lime", "oak");

		BlockModels.fruitLeafBlock(bsp, ORANGE_LEAVES.get(), "orange");
		bsp.simpleBlock(ORANGE_SAPLING.get(), new ConfiguredModel(bsp.models()
				.cross("orange_sapling", bsp.modLoc("block/crops/fruit/orange/orange_sapling")).renderType("cutout")));
		BlockModels.pottedBlock(bsp, POTTED_ORANGE_SAPLING.get(), "orange_sapling",
				"crops/fruit/orange/orange_sapling");
		BlockModels.fluid(bsp, ORANGE_JUICE_FLUID_BLOCK.get());
		BlockModels.crateBlock(bsp, ORANGE_CRATE.get(), "orange", "oak");

		BlockModels.fruitLeafBlock(bsp, GRAPEFRUIT_LEAVES.get(), "grapefruit");
		bsp.simpleBlock(GRAPEFRUIT_SAPLING.get(),
				new ConfiguredModel(bsp.models()
						.cross("grapefruit_sapling", bsp.modLoc("block/crops/fruit/grapefruit/grapefruit_sapling"))
						.renderType("cutout")));
		BlockModels.pottedBlock(bsp, POTTED_GRAPEFRUIT_SAPLING.get(), "grapefruit_sapling",
				"crops/fruit/grapefruit/grapefruit_sapling");
		BlockModels.fluid(bsp, GRAPEFRUIT_JUICE_FLUID_BLOCK.get());
		BlockModels.crateBlock(bsp, GRAPEFRUIT_CRATE.get(), "grapefruit", "oak");

		BlockModels.fluid(bsp, EGG_WHITE_FLUID_BLOCK.get());

		bsp.getVariantBuilder(LEMON_MERINGUE_PIE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(LEMON_MERINGUE_PIE.get()).getPath() + suffix,
							bsp.modLoc("block/pie" + suffix))
					.texture("particle", bsp.modLoc("block/meringue_top"))
					.texture("top", bsp.modLoc("block/meringue_top"))
					.texture("inner", bsp.modLoc("block/lemon_meringue_pie_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
		bsp.getVariantBuilder(KEY_LIME_PIE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(KEY_LIME_PIE.get()).getPath() + suffix,
							bsp.modLoc("block/pie" + suffix))
					.texture("particle", bsp.modLoc("block/key_lime_pie_top"))
					.texture("top", bsp.modLoc("block/key_lime_pie_top"))
					.texture("inner", bsp.modLoc("block/key_lime_pie_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
		BlockModels.recipeFeastBlock(bsp, MELON_FRUIT_SALAD.get());
		BlockModels.createCakeBlock(bsp, LEMON_CUCUMBER_CAKE.get(), "lemon_cucumber");
		BlockModels.recipeFeastBlock(bsp, BAKED_COD.get(), "baked_cod");
		BlockModels.createCakeBlock(bsp, MELON_LAYER_CAKE.get(), "melon_layer");
		BlockModels.pieLikeBlock(bsp, PAVLOVA.get(), "pavlova");
//		BlockModels.recipeFeastBlock(bsp, PRESERVED_LEMONS_BLOCK.get(), "preserved_lemon_jar");
//		BlockModels.recipeFeastBlock(bsp, PICKLED_RINDS_BLOCK.get(), "pickled_rind_jar");
		BlockModels.pieLikeBlock(bsp, KYIV_CAKE.get(), "kyiv_cake");
//		BlockModels.recipeFeastBlock(bsp, BAKED_ALASKA.get());

		picnicBasket(bsp, WHITE_PICNIC_BASKET.get());
		picnicBasket(bsp, ORANGE_PICNIC_BASKET.get());
		picnicBasket(bsp, MAGENTA_PICNIC_BASKET.get());
		picnicBasket(bsp, LIGHT_BLUE_PICNIC_BASKET.get());
		picnicBasket(bsp, YELLOW_PICNIC_BASKET.get());
		picnicBasket(bsp, LIME_PICNIC_BASKET.get());
		picnicBasket(bsp, PINK_PICNIC_BASKET.get());
		picnicBasket(bsp, GRAY_PICNIC_BASKET.get());
		picnicBasket(bsp, LIGHT_GRAY_PICNIC_BASKET.get());
		picnicBasket(bsp, CYAN_PICNIC_BASKET.get());
		picnicBasket(bsp, BLUE_PICNIC_BASKET.get());
		picnicBasket(bsp, BROWN_PICNIC_BASKET.get());
		picnicBasket(bsp, GREEN_PICNIC_BASKET.get());
		picnicBasket(bsp, RED_PICNIC_BASKET.get());
		picnicBasket(bsp, BLACK_PICNIC_BASKET.get());
		picnicBasket(bsp, PURPLE_PICNIC_BASKET.get());
	}

	public static void picnicBasket(BlockStateProvider bsp, PicnicBasketBlock block) {
		bsp.getVariantBuilder(block).forAllStates(state -> {

			return ConfiguredModel.builder().modelFile(bsp.models()

					.withExistingParent(block.getColor() + "_picnic_basket", bsp.modLoc("block/picnic_basket"))
					.texture("2", bsp.modLoc("block/gingham/" + block.getColor())).renderType("cutout"))
					.rotationY(((int) state.getValue(PicnicBasketBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void itemModels(ItemModelProvider tmp) {
		ItemModels.forItem(tmp, LEMON, "crops/fruit/lemon/lemon");
		ItemModels.forBlockItem(tmp, LEMON_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lemon/lemon_leaves_stage0"));
		ItemModels.forBlockItemFlat(tmp, LEMON_SAPLING_ITEM, "crops/fruit/lemon/lemon_sapling");
		ItemModels.forItem(tmp, LEMON_JUICE, "lemon_juice_bottle");
		ItemModels.forItem(tmp, LEMON_JUICE_FLUID_BUCKET, "lemon_juice_bucket");
		ItemModels.forBlockItem(tmp, LEMON_CRATE_ITEM, "lemon_crate");
		ItemModels.forItem(tmp, SLICED_LEMON, "crops/fruit/lemon/sliced_lemon");
		ItemModels.forItem(tmp, LEMON_ZEST, "crops/fruit/lemon/lemon_zest");

		ItemModels.forItem(tmp, LIME, "crops/fruit/lime/lime");
		ItemModels.forBlockItem(tmp, LIME_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/lime/lime_leaves_stage0"));
		ItemModels.forBlockItemFlat(tmp, LIME_SAPLING_ITEM, "crops/fruit/lime/lime_sapling");
		ItemModels.forItem(tmp, LIME_JUICE, "lime_juice_bottle");
		ItemModels.forItem(tmp, LIME_JUICE_FLUID_BUCKET, "lime_juice_bucket");
		ItemModels.forBlockItem(tmp, LIME_CRATE_ITEM, "lime_crate");
		ItemModels.forItem(tmp, SLICED_LIME, "crops/fruit/lime/sliced_lime");
		ItemModels.forItem(tmp, LIME_ZEST, "crops/fruit/lime/lime_zest");

		ItemModels.forItem(tmp, ORANGE, "crops/fruit/orange/orange");
		ItemModels.forBlockItem(tmp, ORANGE_LEAVES_ITEM, tmp.modLoc("block/crops/fruit/orange/orange_leaves_stage0"));
		ItemModels.forBlockItemFlat(tmp, ORANGE_SAPLING_ITEM, "crops/fruit/orange/orange_sapling");
		ItemModels.forItem(tmp, ORANGE_JUICE, "orange_juice_bottle");
		ItemModels.forItem(tmp, ORANGE_JUICE_FLUID_BUCKET, "orange_juice_bucket");
		ItemModels.forBlockItem(tmp, ORANGE_CRATE_ITEM, "orange_crate");
		ItemModels.forItem(tmp, SLICED_ORANGE, "crops/fruit/orange/sliced_orange");
		ItemModels.forItem(tmp, ORANGE_ZEST, "crops/fruit/orange/orange_zest");

		ItemModels.forItem(tmp, GRAPEFRUIT, "crops/fruit/grapefruit/grapefruit");
		ItemModels.forBlockItem(tmp, GRAPEFRUIT_LEAVES_ITEM,
				tmp.modLoc("block/crops/fruit/grapefruit/grapefruit_leaves_stage0"));
		ItemModels.forBlockItemFlat(tmp, GRAPEFRUIT_SAPLING_ITEM, "crops/fruit/grapefruit/grapefruit_sapling");
		ItemModels.forItem(tmp, GRAPEFRUIT_JUICE, "grapefruit_juice_bottle");
		ItemModels.forItem(tmp, GRAPEFRUIT_JUICE_FLUID_BUCKET, "grapefruit_juice_bucket");
		ItemModels.forBlockItem(tmp, GRAPEFRUIT_CRATE_ITEM, "grapefruit_crate");
		ItemModels.forItem(tmp, SLICED_GRAPEFRUIT, "crops/fruit/grapefruit/sliced_grapefruit");

		ItemModels.forItem(tmp, EGG_YOLK, "egg_yolk");
//        ItemModels.forItem(tmp, EGG_WHITE, "egg_white");
		ItemModels.forItem(tmp, EGG_WHITE_FLUID_BUCKET, "egg_white_bucket");
		ItemModels.forItem(tmp, STIFF_PEAKS, "stiff_peaks");

		ItemModels.forItem(tmp, MELON_CHUNKS, "melon_chunks");
		ItemModels.forItem(tmp, MELON_RIND, "melon_rind");

		ItemModels.forItem(tmp, ICE_CUBES, "ice_cubes");
//		ItemModels.forItem(tmp, MERINGUE, "meringue");
//		ItemModels.forItem(tmp, LEMON_CURD, "lemon_curd");
//		ItemModels.forItem(tmp, LEMON_MERINGUE_PIE_ITEM, "lemon_meringue_pie");
		ItemModels.forItem(tmp, LEMON_MERINGUE_PIE_SLICE, "lemon_meringue_pie_slice");
		ItemModels.forItem(tmp, KEY_LIME_PIE_ITEM, "key_lime_pie");
		ItemModels.forItem(tmp, KEY_LIME_PIE_SLICE, "key_lime_pie_slice");
		ItemModels.forItem(tmp, LEMONADE, "lemonade");
		ItemModels.forItem(tmp, LIMEADE, "limeade");
//		ItemModels.forItem(tmp, ORANGEADE, "orangeade");
		ItemModels.forItem(tmp, MELON_GAZPACHO, "melon_gazpacho");
		ItemModels.forItem(tmp, THAI_MELON_SALAD, "thai_melon_salad");
		ItemModels.forItem(tmp, ETON_MESS, "eton_mess");
		ItemModels.forItem(tmp, DALGONA_COFFEE, "dalgona_coffee");
		ItemModels.forItem(tmp, GRAPEFRUIT_BEETROOT_SALAD, "grapefruit_beetroot_salad");
		ItemModels.forItem(tmp, CITRUS_ONION_SALAD, "citrus_onion_mint_salad");
		ItemModels.forItem(tmp, MELON_FRUIT_SALAD_SERVING, "melon_fruit_salad_serving");
		tmp.getBuilder(MELON_FRUIT_SALAD_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("item/generated"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, LEMON_CUCUMBER_CAKE_ITEM, "lemon_cucumber_cake");
		ItemModels.forItem(tmp, LEMON_CUCUMBER_CAKE_SLICE, "lemon_cucumber_cake_slice");
		tmp.getBuilder(BAKED_COD_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile("item/generated"))
				.customLoader(BlockStateItemGeometryLoader::builder);
//		ItemModels.forItem(tmp, BAKED_COD_SERVING, "baked_cod_serving");
		ItemModels.forItem(tmp, MELON_LAYER_CAKE_ITEM, "melon_layer_cake");
		ItemModels.forItem(tmp, MELON_LAYER_CAKE_SLICE, "melon_layer_cake_slice");
		ItemModels.forItem(tmp, GRAPEFRUIT_SORBET, "grapefruit_sorbet");
		ItemModels.forItem(tmp, CHOCOLATE_ORANGE, "chocolate_orange");
		ItemModels.forItem(tmp, CHOCOLATE_MOUSSE, "chocolate_mousse");
//		ItemModels.forItem(tmp, JAFFA_CAKE, "jaffa_cake");
//		ItemModels.forItem(tmp, GRILLED_GRAPEFRUIT, "grilled_grapefruit");
//		ItemModels.forItem(tmp, LEMON_DELICIOUS, "lemon_delicious");
//		ItemModels.forItem(tmp, ORANGE_CHICKEN, "orange_chicken");
//		ItemModels.forItem(tmp, MELON_RIND_STIRFRY, "melon_rind_stirfry");
//		ItemModels.forItem(tmp, LIME_SOUFFLE, "lime_souffle");
//		ItemModels.forItem(tmp, CHEESE_SOUFFLE, "cheese_souffle");
		tmp.getBuilder(PAVLOVA_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
//		ItemModels.forItem(tmp, PAVLOVA_SLICE, "pavlova_slice");
//		tmp.getBuilder(PRESERVED_LEMONS_BLOCK_ITEM.getId().getPath())
//				.parent(new ModelFile.UncheckedModelFile("item/generated"))
//				.customLoader(BlockStateItemGeometryLoader::builder);
//		ItemModels.forItem(tmp, PRESERVED_LEMON_ITEM, "preserved_lemon");
//		tmp.getBuilder(PICKLED_RINDS_BLOCK_ITEM.getId().getPath())
//				.parent(new ModelFile.UncheckedModelFile("item/generated"))
//				.customLoader(BlockStateItemGeometryLoader::builder);
//		ItemModels.forItem(tmp, PICKLED_RIND_ITEM, "pickled_rind");
//		ItemModels.forItem(tmp, PRESERVED_LEMON_PASTA, "preserved_lemon_pasta");
//		ItemModels.forItem(tmp, CANDIED_CITRUS_ZEST, "candied_citrus_zest");
//		ItemModels.forItem(tmp, LEMON_POSSET, "lemon_posset");
//		ItemModels.forItem(tmp, MELON_LIME_GLAZED_CHICKEN, "melon_lime_glazed_chicken");
		tmp.getBuilder(KYIV_CAKE_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, KYIV_CAKE_SLICE, "kyiv_cake_slice");
//		ItemModels.forItem(tmp, BAKED_ALASKA_SERVING, "baked_alaska_serving");
//		tmp.getBuilder(BAKED_ALASKA_ITEM.getId().getPath())
//				.parent(new ModelFile.UncheckedModelFile("item/generated"))
//				.customLoader(BlockStateItemGeometryLoader::builder);

		ItemModels.forBlockItem(tmp, WHITE_PICNIC_BASKET_ITEM, "white_picnic_basket");
		ItemModels.forBlockItem(tmp, ORANGE_PICNIC_BASKET_ITEM, "orange_picnic_basket");
		ItemModels.forBlockItem(tmp, MAGENTA_PICNIC_BASKET_ITEM, "magenta_picnic_basket");
		ItemModels.forBlockItem(tmp, LIGHT_BLUE_PICNIC_BASKET_ITEM, "light_blue_picnic_basket");
		ItemModels.forBlockItem(tmp, YELLOW_PICNIC_BASKET_ITEM, "yellow_picnic_basket");
		ItemModels.forBlockItem(tmp, LIME_PICNIC_BASKET_ITEM, "lime_picnic_basket");
		ItemModels.forBlockItem(tmp, PINK_PICNIC_BASKET_ITEM, "pink_picnic_basket");
		ItemModels.forBlockItem(tmp, GRAY_PICNIC_BASKET_ITEM, "gray_picnic_basket");
		ItemModels.forBlockItem(tmp, LIGHT_GRAY_PICNIC_BASKET_ITEM, "light_gray_picnic_basket");
		ItemModels.forBlockItem(tmp, CYAN_PICNIC_BASKET_ITEM, "cyan_picnic_basket");
		ItemModels.forBlockItem(tmp, BLUE_PICNIC_BASKET_ITEM, "blue_picnic_basket");
		ItemModels.forBlockItem(tmp, BROWN_PICNIC_BASKET_ITEM, "brown_picnic_basket");
		ItemModels.forBlockItem(tmp, GREEN_PICNIC_BASKET_ITEM, "green_picnic_basket");
		ItemModels.forBlockItem(tmp, RED_PICNIC_BASKET_ITEM, "red_picnic_basket");
		ItemModels.forBlockItem(tmp, BLACK_PICNIC_BASKET_ITEM, "black_picnic_basket");
		ItemModels.forBlockItem(tmp, PURPLE_PICNIC_BASKET_ITEM, "purple_picnic_basket");
	}

	public final static int dayTick = 24000;
	public final static int hourTick = 1000;

	public static void Recipes(RecipeOutput consumer) {
		// Vanilla Crafting
		Recipes.bucket("lemon_juice", consumer, LEMON_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE, LEMON_JUICE.get());
		Recipes.bucket("lime_juice", consumer, LIME_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE, LIME_JUICE.get());
		Recipes.bucket("orange_juice", consumer, ORANGE_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				ORANGE_JUICE.get());
		Recipes.bucket("grapefruit_juice", consumer, GRAPEFRUIT_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE,
				GRAPEFRUIT_JUICE.get());
		Recipes.bucket("egg_white", consumer, EGG_WHITE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE, EGG_WHITE.get());

		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.LEMON), LEMON_CRATE_ITEM.get(), LEMON.get(), consumer,
				"lemon");
		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.LIME), LIME_CRATE_ITEM.get(), LIME.get(), consumer, "lime");
		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.ORANGE), ORANGE_CRATE_ITEM.get(), ORANGE.get(), consumer,
				"orange");
		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.GRAPEFRUIT), GRAPEFRUIT_CRATE_ITEM.get(), GRAPEFRUIT.get(),
				consumer, "grapefruit");

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, LEMON_MERINGUE_PIE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', LEMON_MERINGUE_PIE_SLICE.get())
				.unlockedBy("has_pie", InventoryChangeTrigger.TriggerInstance.hasItems(LEMON_MERINGUE_PIE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("lemon_meringue_pie_slice"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, KEY_LIME_PIE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', KEY_LIME_PIE_SLICE.get())
				.unlockedBy("has_pie", InventoryChangeTrigger.TriggerInstance.hasItems(KEY_LIME_PIE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("key_lime_pie_slice"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LEMON_CUCUMBER_CAKE_ITEM.get())
				.requires(LEMON_CUCUMBER_CAKE_SLICE.get(), 7)
				.unlockedBy("has_cake", InventoryChangeTrigger.TriggerInstance.hasItems(LEMON_CUCUMBER_CAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("lemon_cucumber_cake_from_slice"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MELON_LAYER_CAKE_ITEM.get())
				.requires(MELON_LAYER_CAKE_SLICE.get(), 7)
				.unlockedBy("has_cake", InventoryChangeTrigger.TriggerInstance.hasItems(MELON_LAYER_CAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("melon_layer_cake_from_slice"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, PAVLOVA_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', PAVLOVA_SLICE.get())
				.unlockedBy("has_pav", InventoryChangeTrigger.TriggerInstance.hasItems(PAVLOVA_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pavlova_from_slice"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, KYIV_CAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', KYIV_CAKE_SLICE.get())
				.unlockedBy("has_pav", InventoryChangeTrigger.TriggerInstance.hasItems(KYIV_CAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("kyiv_cake_from_slice"));

		// Feasts
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(MELON_FRUIT_SALAD_SERVING.get()),
						MELON_FRUIT_SALAD_ITEM.get())
				.unlockedBy("has_melon_salad", InventoryChangeTrigger.TriggerInstance.hasItems(MELON_FRUIT_SALAD.get()))
				.save(consumer, ExtraDelight.modLoc("melon_salad_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(BAKED_COD_SERVING.get()), BAKED_COD_ITEM.get())
				.unlockedBy("has_baked_cod", InventoryChangeTrigger.TriggerInstance.hasItems(BAKED_COD_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("baked_cod_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PRESERVED_LEMON_ITEM.get()),
						PRESERVED_LEMONS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PRESERVED_LEMONS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("preserved_lemon_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(ExtraDelightTags.SPOONS), new ItemStack(PICKLED_RIND_ITEM.get()),
						PICKLED_RINDS_BLOCK_ITEM.get())
				.unlockedBy("has_pickle_jar",
						InventoryChangeTrigger.TriggerInstance.hasItems(PICKLED_RINDS_BLOCK_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pickled_rind_pull_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(BAKED_ALASKA_SERVING.get()), BAKED_ALASKA_ITEM.get())
				.unlockedBy("has_baked_alaska", InventoryChangeTrigger.TriggerInstance.hasItems(BAKED_ALASKA.get()))
				.save(consumer, ExtraDelight.modLoc("baked_alaska_pull_feast"));

		// Chiller
		ChillerRecipeBuilder
				.chill(GRAPEFRUIT_SORBET.toStack(), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP,
						new ItemStack(Items.BOWL), new FluidStack(ExtraDelightFluids.GRAPEFRUIT_JUICE.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).build(consumer, "grapefruit_sorbet_chilling");
		ChillerRecipeBuilder
				.chill(CHOCOLATE_ORANGE.toStack(), Recipes.FAST_COOKING, Recipes.SMALL_EXP,
						ExtraDelightItems.MUFFIN_TIN.toStack(),
						new FluidStack(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(), 250))
				.addIngredient(Ingredient.of(ORANGE_ZEST)).build(consumer, "chocolate_orange_chilling");
		ChillerRecipeBuilder
				.chill(CHOCOLATE_MOUSSE.toStack(), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP, new ItemStack(Items.BOWL),
						new FluidStack(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250))
				.addIngredient(Ingredient.of(EGG_YOLK)).addIngredient(Ingredient.of(STIFF_PEAKS))
				.addIngredient(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP))
				.addIngredient(Ingredient.of(Items.SUGAR)).build(consumer, "chocolate_mousse_chilling");

		// Cutting Board
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LEMON.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), SLICED_LEMON.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_lemon_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LIME.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), SLICED_LIME.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_lime_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ORANGE.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
				SLICED_ORANGE.get(), 3).build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_orange_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(GRAPEFRUIT.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						SLICED_GRAPEFRUIT.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_grapefruit_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LEMON.get()), Ingredient.of(ExtraDelightItems.GRATER), LEMON_ZEST.get(), 2)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "lemon_zest_grater"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LIME.get()), Ingredient.of(ExtraDelightItems.GRATER), LIME_ZEST.get(), 2)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "lime_zest_grater"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ORANGE.get()), Ingredient.of(ExtraDelightItems.GRATER),
				ORANGE_ZEST.get(), 2).build(consumer, ExtraDelight.modLoc("cutting/" + "orange_zest_grater"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(Items.MELON_SLICE), Ingredient.of(CommonTags.TOOLS_KNIFE),
						MELON_CHUNKS.get(), 2)
				.addResult(MELON_RIND).build(consumer, ExtraDelight.modLoc("cutting/" + "melon_chunks_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.ICE),
				new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), ICE_CUBES.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "ice_cubes_axe"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LEMON_MERINGUE_PIE_ITEM.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						LEMON_MERINGUE_PIE_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "lemon_meringue_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(KEY_LIME_PIE_ITEM.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						KEY_LIME_PIE_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "key_lime_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(LEMON_CUCUMBER_CAKE_ITEM.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						LEMON_CUCUMBER_CAKE_SLICE.get(), 7)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "lemon_cucumber_cake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(MELON_LAYER_CAKE_ITEM.get()), Ingredient.of(CommonTags.TOOLS_KNIFE),
						MELON_LAYER_CAKE_SLICE.get(), 7)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "melon_layer_cake_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(PAVLOVA_ITEM.get()),
				Ingredient.of(CommonTags.TOOLS_KNIFE), PAVLOVA_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "pavlova_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(KYIV_CAKE_ITEM.get()),
				Ingredient.of(CommonTags.TOOLS_KNIFE), KYIV_CAKE_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "kyiv_cake_knife"));

		// Juicer
		JuicerRecipeBuilder
				.squeeze(Ingredient.of(LEMON), new ItemStack(Items.BONE_MEAL),
						new FluidStack(ExtraDelightFluids.LEMON_JUICE.FLUID, 250))
				.save(consumer, ExtraDelight.modLoc("lemon_juice"));
		JuicerRecipeBuilder
				.squeeze(Ingredient.of(LIME), new ItemStack(Items.BONE_MEAL),
						new FluidStack(ExtraDelightFluids.LIME_JUICE.FLUID, 250))
				.save(consumer, ExtraDelight.modLoc("lime_juice"));
		JuicerRecipeBuilder
				.squeeze(Ingredient.of(ORANGE), new ItemStack(Items.BONE_MEAL),
						new FluidStack(ExtraDelightFluids.ORANGE_JUICE.FLUID, 250))
				.save(consumer, ExtraDelight.modLoc("orange_juice"));
		JuicerRecipeBuilder
				.squeeze(Ingredient.of(GRAPEFRUIT), new ItemStack(Items.BONE_MEAL),
						new FluidStack(ExtraDelightFluids.GRAPEFRUIT_JUICE.FLUID, 250))
				.save(consumer, ExtraDelight.modLoc("grapefruit_juice"));

		// Mixing bowl
		Recipes.mixing(new ItemStack(STIFF_PEAKS.get(), 1), Recipes.LONG_GRIND, new ItemStack(Items.BOWL),
				Ingredient.of(ExtraDelightItems.WHISK), new Ingredient[] {},
				new SizedFluidIngredient[] {
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.EGG_WHITE.FLUID, 250)) },
				consumer, "stiff_peaks_mixing");
		Recipes.mixing(new ItemStack(LEMONADE.get(), 4), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE, 4),
				new Ingredient[] { Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR),
						Ingredient.of(ExtraDelightTags.PROCESSED_LEMON),
						Ingredient.of(ExtraDelightTags.PROCESSED_LEMON) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 750)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.LEMON_JUICE.FLUID, 250)) },
				consumer, "lemonade_mixing");
		Recipes.mixing(new ItemStack(LIMEADE.get(), 4), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE, 4),
				new Ingredient[] { Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR),
						Ingredient.of(ExtraDelightTags.PROCESSED_LIME),
						Ingredient.of(ExtraDelightTags.PROCESSED_LIME) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 750)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.LIME_JUICE.FLUID, 250)) },
				consumer, "limeade_mixing");
		Recipes.mixing(new ItemStack(ORANGEADE.get(), 4), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE, 4),
				new Ingredient[] { Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR), Ingredient.of(Items.SUGAR),
						Ingredient.of(ExtraDelightTags.PROCESSED_ORANGE),
						Ingredient.of(ExtraDelightTags.PROCESSED_ORANGE) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 500)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.ORANGE_JUICE.FLUID, 500)) },
				consumer, "orangeade_mixing");
		Recipes.mixing(new ItemStack(MELON_GAZPACHO.get(), 4), Recipes.STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_MELON),
						Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO),
						Ingredient.of(ExtraDelightTags.PROCESSED_CUCUMBER),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION),
						Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC), Ingredient.of(ExtraDelightTags.MINT),
						Ingredient.of(ExtraDelightTags.SALT), Ingredient.of(ExtraDelightTags.BREAD_CRUMBS), },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.OIL.FLUID, 250)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.VINEGAR.FLUID, 250)) },
				consumer, "melon_gazpacho_mixing");
		Recipes.mixing(new ItemStack(THAI_MELON_SALAD.get(), 4), Recipes.STANDARD_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_MELON),
						Ingredient.of(ExtraDelightTags.ROASTED_PEANUTS),
						Ingredient.of(ExtraDelightTags.PROCESSED_CUCUMBER),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION),
						Ingredient.of(ExtraDelightTags.PROCESSED_GINGER), Ingredient.of(ExtraDelightTags.MINT),
						Ingredient.of(Items.SUGAR), Ingredient.of(ExtraDelightTags.FISH_SAUCE), },
				new SizedFluidIngredient[] {
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.LIME_JUICE.FLUID, 250)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.VINEGAR.FLUID, 250)) },
				consumer, "thai_melon_salad_mixing");
		Recipes.mixing(new ItemStack(ETON_MESS.get(), 1), Recipes.LONG_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(MERINGUE), Ingredient.of(Items.SUGAR), Ingredient.of(MERINGUE),
						DifferenceIngredient.of(Ingredient.of(Tags.Items.FOODS_BERRY),
								Ingredient.of(Items.GLOW_BERRIES)),
						Ingredient.of(LEMON_ZEST), Ingredient.of(ExtraDelightTags.PROCESSED_ORANGE) },
				new SizedFluidIngredient[] {
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.WHIPPED_CREAM.FLUID, 250)) },
				consumer, "eton_mess_mixing");
		Recipes.mixing(new ItemStack(DALGONA_COFFEE.get(), 1), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE),
				Ingredient.of(ExtraDelightItems.WHISK),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.GROUND_COFFEE_BEANS), Ingredient.of(Items.SUGAR) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 50)),
						SizedFluidIngredient.of(new FluidStack(NeoForgeMod.MILK, 250)) },
				consumer, "dalgona_coffee_mixing");
		Recipes.mixing(new ItemStack(GRAPEFRUIT_BEETROOT_SALAD.get(), 1), Recipes.FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_GRAPEFRUIT),
						Ingredient.of(ExtraDelightTags.PROCESSED_BEETROOT), Ingredient.of(ExtraDelightTags.SALT),
						Ingredient.of(Items.HONEY_BOTTLE) },
				new SizedFluidIngredient[] {
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.OIL.FLUID, 250)) },
				consumer, "grapefruit_beetroot_salad_mixing");
		Recipes.mixing(new ItemStack(CITRUS_ONION_SALAD.get(), 1), Recipes.FAST_GRIND, new ItemStack(Items.BOWL),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_GRAPEFRUIT),
						Ingredient.of(ExtraDelightTags.PROCESSED_ORANGE), Ingredient.of(Items.HONEY_BOTTLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_ONION), Ingredient.of(ExtraDelightTags.MINT),
						Ingredient.of(ExtraDelightTags.PROCESSED_LIME) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.OIL.FLUID, 250)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.VINEGAR.FLUID, 250)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.ORANGE_JUICE.FLUID, 250)) },
				consumer, "citrus_onion_salad_mixing");
		Recipes.mixing(new ItemStack(MELON_FRUIT_SALAD_ITEM.get(), 1), Recipes.FAST_GRIND, new ItemStack(Items.MELON),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.PROCESSED_APPLE),
						Ingredient.of(ExtraDelightTags.PROCESSED_MELON),
						Ingredient.of(ExtraDelightTags.PROCESSED_ORANGE), Ingredient.of(Tags.Items.FOODS_BERRY),
						Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(ExtraDelightTags.MINT) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(ExtraDelightTags.LEMON_LIME, 250) }, consumer,
				"melon_fruit_salad_mixing");

		// Oven
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(MERINGUE.get(), 6), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()), false)
				.addIngredient(STIFF_PEAKS).addIngredient(Items.SUGAR).addIngredient(STIFF_PEAKS)
				.unlockedByAnyIngredient(STIFF_PEAKS).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(LEMON_MERINGUE_PIE_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()), false)
				.addIngredient(STIFF_PEAKS).addIngredient(Items.SUGAR).addIngredient(STIFF_PEAKS)
				.addIngredient(LEMON_CURD).addIngredient(ModItems.PIE_CRUST.get()).addIngredient(LEMON_CURD)
				.unlockedByAnyIngredient(LEMON).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(KEY_LIME_PIE_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()), false)
				.addIngredient(EGG_YOLK).addIngredient(CommonTags.FOODS_MILK).addIngredient(LIME_JUICE)
				.addIngredient(LIME_ZEST).addIngredient(Items.SUGAR).addIngredient(STIFF_PEAKS)
				.addIngredient(SLICED_LIME).addIngredient(ExtraDelightTags.WHIPPED_CREAM)
				.addIngredient(ModItems.PIE_CRUST.get()).unlockedByAnyIngredient(LIME).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(LEMON_CUCUMBER_CAKE_ITEM.get(), 1), Recipes.NORMAL_COOKING,
						Recipes.MEDIUM_EXP, new ItemStack(ExtraDelightItems.SQUARE_PAN.get()), false)
				.addIngredient(ExtraDelightTags.PROCESSED_CUCUMBER).addIngredient(LEMON_ZEST).addIngredient(LEMON_JUICE)
				.addIngredient(Items.SUGAR).addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.FROSTING_WHITE)
				.addIngredient(ExtraDelightTags.PROCESSED_LEMON).unlockedByAnyIngredient(LEMON_ZEST).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(BAKED_COD_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()), true)
				.addIngredient(Items.COD).addIngredient(ExtraDelightTags.COOKING_OIL)
				.addIngredient(ExtraDelightTags.PROCESSED_GARLIC).addIngredient(ExtraDelightTags.PROCESSED_LEMON)
				.addIngredient(ExtraDelightTags.SALT).unlockedByAnyIngredient(Items.COD).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(MELON_LAYER_CAKE_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SQUARE_PAN.get()), false)
				.addIngredient(ModItems.MELON_JUICE.get()).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(Items.SUGAR).addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.FROSTING_RED)
				.addIngredient(ExtraDelightTags.FROSTING_GREEN).addIngredient(ExtraDelightTags.CHOCOLATE_CHIPS)
				.unlockedByAnyIngredient(Items.MELON_SLICE).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(JAFFA_CAKE.get(), 6), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()), false)
				.addIngredient(Items.SUGAR).addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightItems.JELLY_ORANGE)
				.addIngredient(ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE).addIngredient(ORANGE_ZEST)
				.unlockedByAnyIngredient(ORANGE).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(GRILLED_GRAPEFRUIT.get(), 8), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()), false)
				.addIngredient(GRAPEFRUIT).addIngredient(GRAPEFRUIT).addIngredient(GRAPEFRUIT).addIngredient(GRAPEFRUIT)
				.addIngredient(ExtraDelightTags.SWEETENER).unlockedByAnyIngredient(GRAPEFRUIT).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(LEMON_DELICIOUS.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(Items.BOWL), true)
				.addIngredient(EGG_YOLK).addIngredient(ExtraDelightTags.BUTTER).addIngredient(LEMON_ZEST)
				.addIngredient(LEMON_JUICE).addIngredient(CommonTags.FOODS_MILK).addIngredient(Items.SUGAR)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(STIFF_PEAKS).unlockedByAnyIngredient(LEMON)
				.build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(LIME_SOUFFLE.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(Items.BOWL), true)
				.addIngredient(EGG_YOLK).addIngredient(ExtraDelightTags.BUTTER).addIngredient(LIME_ZEST)
				.addIngredient(LIME_JUICE).addIngredient(CommonTags.FOODS_MILK).addIngredient(Items.SUGAR)
				.addIngredient(STIFF_PEAKS).addIngredient(STIFF_PEAKS).unlockedByAnyIngredient(STIFF_PEAKS)
				.build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(CHEESE_SOUFFLE.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(Items.BOWL), true)
				.addIngredient(EGG_YOLK).addIngredient(ExtraDelightTags.BUTTER).addIngredient(ExtraDelightTags.CHEESE)
				.addIngredient(ExtraDelightTags.CHEESE).addIngredient(CommonTags.FOODS_MILK)
				.addIngredient(CompoundIngredient.of(Ingredient.of(ExtraDelightTags.CHILI_POWDER),
						Ingredient.of(ExtraDelightItems.CURRY_POWDER)))
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(STIFF_PEAKS).addIngredient(STIFF_PEAKS)
				.unlockedByAnyIngredient(STIFF_PEAKS).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(PAVLOVA_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()), false)
				.addIngredient(STIFF_PEAKS).addIngredient(STIFF_PEAKS).addIngredient(STIFF_PEAKS)
				.addIngredient(Items.SUGAR).addIngredient(Items.SUGAR).addIngredient(ExtraDelightItems.WHIPPED_CREAM)
				.addIngredient(ExtraDelightTags.PROCESSED_FRUIT).addIngredient(ExtraDelightTags.PROCESSED_FRUIT)
				.unlockedByAnyIngredient(STIFF_PEAKS).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(KYIV_CAKE_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.SHEET.get()), false)
				.addIngredient(STIFF_PEAKS).addIngredient(STIFF_PEAKS).addIngredient(Items.SUGAR)
				.addIngredient(ExtraDelightTags.ROASTED_HAZELNUTS).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(Tags.Items.EGGS).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.CHOCOLATE_SYRUP).addIngredient(ExtraDelightTags.WHIPPED_CREAM)
				.unlockedByAnyIngredient(STIFF_PEAKS).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(BAKED_ALASKA_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()), true)
				.addIngredient(Items.CAKE).addIngredient(ExtraDelightTags.ICE_CREAM).addIngredient(STIFF_PEAKS)
				.addIngredient(STIFF_PEAKS).addIngredient(Items.SUGAR).unlockedByAnyIngredient(STIFF_PEAKS)
				.build(consumer);

		// Pot
		Recipes.pot(LEMON_CURD.get(), 2, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.BUTTER), Ingredient.of(Items.SUGAR),
						Ingredient.of(LEMON_JUICE), Ingredient.of(LEMON_ZEST), Ingredient.of(EGG_YOLK),
						Ingredient.of(EGG_YOLK) },
				"lemon_curd", consumer);
		Recipes.pot(ORANGE_CHICKEN.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, ModItems.COOKED_RICE.get(),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.CUBED_CHICKEN_RAW), Ingredient.of(Items.SUGAR),
						CompoundIngredient.of(Ingredient.of(ORANGE_JUICE), Ingredient.of(ORANGE_ZEST)),
						Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS),
						Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC),
						Ingredient.of(ExtraDelightTags.PROCESSED_GINGER) },
				"orange_chicken", consumer);
		Recipes.pot(MELON_RIND_STIRFRY.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, ModItems.COOKED_RICE.get(),
				new Ingredient[] { Ingredient.of(MELON_RIND), Ingredient.of(ExtraDelightTags.PROCESSED_CARROT),
						Ingredient.of(ExtraDelightTags.FISH_SAUCE), Ingredient.of(ExtraDelightTags.SOY_SAUCE),
						Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC),
						Ingredient.of(ExtraDelightTags.PROCESSED_GINGER) },
				"melon_rind_stirfry", consumer);
		Recipes.pot(PRESERVED_LEMON_PASTA.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.RAW_PASTA), Ingredient.of(ExtraDelightTags.BUTTER),
						Ingredient.of(PRESERVED_LEMON_ITEM), Ingredient.of(ExtraDelightTags.CHEESE),
						Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC) },
				"preserved_lemon_pasta", consumer);
		Recipes.pot(CANDIED_CITRUS_ZEST.get(), 3, CookingRecipes.NORMAL_COOKING, 1.0F, null,
				new Ingredient[] { Ingredient.of(LEMON_ZEST), Ingredient.of(LIME_ZEST), Ingredient.of(ORANGE_ZEST),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"candied_citrus_zest", consumer);
		Recipes.pot(LEMON_POSSET.get(), 3, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL,
				new Ingredient[] { Ingredient.of(LEMON_ZEST), Ingredient.of(CommonTags.FOODS_MILK),
						Ingredient.of(Items.SUGAR), Ingredient.of(LEMON_JUICE) },
				"lemon_posset", consumer);
		Recipes.pot(MELON_LIME_GLAZED_CHICKEN.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.BOWL,
				new Ingredient[] {
						CompoundIngredient.of(Ingredient.of(ExtraDelightTags.CHICKEN_BREAST_RAW),
								Ingredient.of(ExtraDelightTags.CHICKEN_THIGH_RAW)),
						Ingredient.of(LIME_JUICE), Ingredient.of(ExtraDelightTags.PROCESSED_MELON),
						Ingredient.of(ExtraDelightTags.CHILI_POWDER), Ingredient.of(Items.HONEY_BOTTLE) },
				"melon_lime_glazed_chicken", consumer);

		// Vat
		VatRecipeBuilder.pickle(new ItemStack(PRESERVED_LEMONS_BLOCK_ITEM.get()), new ItemStack(Items.GLASS_BOTTLE))
				.requires(Ingredient.of(LEMON)).requires(Ingredient.of(LEMON)).requires(Ingredient.of(LEMON))
				.requires(Ingredient.of(LEMON))
				.requiresFluid(SizedFluidIngredient.of(ExtraDelightFluids.LEMON_JUICE.FLUID.get(), 250))
				.requiresStage(new VatRecipe.StageIngredient(Ingredient.of(ExtraDelightTags.SALT), dayTick, false))
				.requiresStage(new VatRecipe.StageIngredient(Ingredient.EMPTY, dayTick * 7, true)).save(consumer);
		VatRecipeBuilder.pickle(new ItemStack(PICKLED_RINDS_BLOCK_ITEM.get()), new ItemStack(Items.GLASS_BOTTLE))
				.requires(Ingredient.of(MELON_RIND)).requires(Ingredient.of(MELON_RIND))
				.requires(Ingredient.of(MELON_RIND)).requires(Ingredient.of(MELON_RIND))
				.requires(Ingredient.of(Items.SUGAR))
				.requiresFluid(SizedFluidIngredient.of(ExtraDelightFluids.VINEGAR.FLUID.get(), 250))
				.requiresStage(
						new VatRecipe.StageIngredient(Ingredient.of(ExtraDelightTags.SALT), hourTick * 12, false))
				.requiresStage(new VatRecipe.StageIngredient(Ingredient.EMPTY, dayTick * 7, true)).save(consumer);
	}

	public static void EngLoc(LanguageProvider lp) {
		lp.add("effect.extradelight.sour_pucker", "Pucker Up");

		lp.add(LEMON.get(), "Lemon");
		lp.add(LEMON_LEAVES.get(), "Lemon Leaves");
		lp.add(LEMON_SAPLING.get(), "Lemon Sapling");
		lp.add(POTTED_LEMON_SAPLING.get(), "Potted Lemon Sapling");
		lp.add(LEMON_JUICE.get(), "Lemon Juice");
		lp.add(LEMON_JUICE_FLUID_BUCKET.get(), "Lemon Juice Bucket");
		lp.add("fluid_type.extradelight.lemon_juice_fluid", "Lemon Juice");
		lp.add("block.extradelight.lemon_juice_fluid_block", "Lemon Juice");
		lp.add(LEMON_CRATE.get(), "Lemon Crate");
		lp.add(SLICED_LEMON.get(), "Sliced Lemon");
		lp.add(LEMON_ZEST.get(), "Lemon Zest");

		lp.add(LIME.get(), "Lime");
		lp.add(LIME_LEAVES.get(), "Lime Leaves");
		lp.add(LIME_SAPLING.get(), "Lime Sapling");
		lp.add(POTTED_LIME_SAPLING.get(), "Potted Lime Sapling");
		lp.add(LIME_JUICE.get(), "Lime Juice");
		lp.add(LIME_JUICE_FLUID_BUCKET.get(), "Lime Juice Bucket");
		lp.add("fluid_type.extradelight.lime_juice_fluid", "Lime Juice");
		lp.add("block.extradelight.lime_juice_fluid_block", "Lime Juice");
		lp.add(LIME_CRATE.get(), "Lime Crate");
		lp.add(SLICED_LIME.get(), "Sliced Lime");
		lp.add(LIME_ZEST.get(), "Lime Zest");

		lp.add(ORANGE.get(), "Orange");
		lp.add(ORANGE_LEAVES.get(), "Orange Leaves");
		lp.add(ORANGE_SAPLING.get(), "Orange Sapling");
		lp.add(POTTED_ORANGE_SAPLING.get(), "Potted Orange Sapling");
		lp.add(ORANGE_JUICE.get(), "Orange Juice");
		lp.add(ORANGE_JUICE_FLUID_BUCKET.get(), "Orange Juice Bucket");
		lp.add("fluid_type.extradelight.orange_juice_fluid", "Orange Juice");
		lp.add("block.extradelight.orange_juice_fluid_block", "Orange Juice");
		lp.add(ORANGE_CRATE.get(), "Orange Crate");
		lp.add(SLICED_ORANGE.get(), "Sliced Orange");
		lp.add(ORANGE_ZEST.get(), "Orange Zest");

		lp.add(GRAPEFRUIT.get(), "Grapefruit");
		lp.add(GRAPEFRUIT_LEAVES.get(), "Grapefruit Leaves");
		lp.add(GRAPEFRUIT_SAPLING.get(), "Grapefruit Sapling");
		lp.add(POTTED_GRAPEFRUIT_SAPLING.get(), "Potted Grapefruit Sapling");
		lp.add(GRAPEFRUIT_JUICE.get(), "Grapefruit Juice");
		lp.add(GRAPEFRUIT_JUICE_FLUID_BUCKET.get(), "Grapefruit Juice Bucket");
		lp.add("fluid_type.extradelight.grapefruit_juice_fluid", "Grapefruit Juice");
		lp.add("block.extradelight.grapefruit_juice_fluid_block", "Grapefruit Juice");
		lp.add(GRAPEFRUIT_CRATE.get(), "Grapefruit Crate");
		lp.add(SLICED_GRAPEFRUIT.get(), "Sliced Grapefruit");

		lp.add(EGG_YOLK.get(), "Egg Yolk");
		lp.add(EGG_WHITE.get(), "Egg White");
		lp.add(EGG_WHITE_FLUID_BUCKET.get(), "Egg White Bucket");
		lp.add("fluid_type.extradelight.egg_white_fluid", "Egg White");
		lp.add("block.extradelight.egg_white_fluid_block", "Egg White");
		lp.add(STIFF_PEAKS.get(), "Eggs White Beaten to Stiff Peaks");

		lp.add(MELON_CHUNKS.get(), "Melon Chunks");
		lp.add(MELON_RIND.get(), "Melon Rind");

		lp.add(ICE_CUBES.get(), "Ice Cubes");
		lp.add(MERINGUE.get(), "Meringue");
		lp.add(LEMON_CURD.get(), "Lemon Curd");
		lp.add(LEMON_MERINGUE_PIE.get(), "Lemon Meringue Pie");
		lp.add(LEMON_MERINGUE_PIE_SLICE.get(), "Slice of Lemon Meringue Pie");
		lp.add(KEY_LIME_PIE.get(), "Key Lime Pie");
		lp.add(KEY_LIME_PIE_SLICE.get(), "Slice of Key Lime Pie");
		lp.add(LEMONADE.get(), "Lemonade");
		lp.add(LIMEADE.get(), "Limeade");
		lp.add(ORANGEADE.get(), "Orangeade");
		lp.add(MELON_GAZPACHO.get(), "Melon Gazpacho");
		lp.add(THAI_MELON_SALAD.get(), "Thai Melon Salad");
		lp.add(ETON_MESS.get(), "Eton Mess");
		lp.add(DALGONA_COFFEE.get(), "Dalgona Coffee");
		lp.add(GRAPEFRUIT_BEETROOT_SALAD.get(), "Grapefruit and Beetroot Salad");
		lp.add(CITRUS_ONION_SALAD.get(), "Citrus, Onion and Mint Salad");
		lp.add(MELON_FRUIT_SALAD.get(), "Melon Fruit Salad");
		lp.add(MELON_FRUIT_SALAD_SERVING.get(), "Bowl of Melon Fruit Salad");
		lp.add(LEMON_CUCUMBER_CAKE.get(), "Lemon Cucumber Cake");
		lp.add(LEMON_CUCUMBER_CAKE_SLICE.get(), "Slice of Lemon Cucumber Cake");
		lp.add(BAKED_COD.get(), "Baked Cod");
		lp.add(BAKED_COD_SERVING.get(), "Plate of Baked Cod");
		lp.add(MELON_LAYER_CAKE.get(), "Melon Layer Cake");
		lp.add(MELON_LAYER_CAKE_SLICE.get(), "Slice of Melon Layer Cake");
		lp.add(GRAPEFRUIT_SORBET.get(), "Grapefruit Sorbet");
		lp.add(CHOCOLATE_ORANGE.get(), "Chocolate Orange");
		lp.add(CHOCOLATE_MOUSSE.get(), "Chocolate Mousse");
		lp.add(JAFFA_CAKE.get(), "Jaffa Cake");
		lp.add(GRILLED_GRAPEFRUIT.get(), "Grilled Grapefruit");
		lp.add(LEMON_DELICIOUS.get(), "Lemon Delicious");
		lp.add(ORANGE_CHICKEN.get(), "Orange Chicken");
		lp.add(MELON_RIND_STIRFRY.get(), "Melon Rind Stirfry");
		lp.add(LIME_SOUFFLE.get(), "Lime Soufflé");
		lp.add(CHEESE_SOUFFLE.get(), "Cheese Soufflé");
		lp.add(PAVLOVA.get(), "Pavlova");
		lp.add(PAVLOVA_SLICE.get(), "Slice of Pavlova");
		lp.add(PRESERVED_LEMONS_BLOCK.get(), "Jar of Preserved Lemons");
		lp.add(PRESERVED_LEMON_ITEM.get(), "Preserved Lemon");
		lp.add(PICKLED_RINDS_BLOCK.get(), "Jar of Pickled Melon Rinds");
		lp.add(PICKLED_RIND_ITEM.get(), "Pickled Melon Rind");
		lp.add(PRESERVED_LEMON_PASTA.get(), "Preserved Lemon Pasta");
		lp.add(CANDIED_CITRUS_ZEST.get(), "Candied Citrus Zest");
		lp.add(LEMON_POSSET.get(), "Lemon Posset");
		lp.add(MELON_LIME_GLAZED_CHICKEN.get(), "Melon and Lime Glazed Chicken");
		lp.add(KYIV_CAKE.get(), "Kyiv Cake");
		lp.add(KYIV_CAKE_SLICE.get(), "Slice of Kyiv Cake");
		lp.add(BAKED_ALASKA.get(), "Baked Alaska");
		lp.add(BAKED_ALASKA_SERVING.get(), "Bowl of Baked Alaska");

		lp.add(WHITE_PICNIC_BASKET.get(), "White Picnic Basket");
		lp.add(ORANGE_PICNIC_BASKET.get(), "Orange Picnic Basket");
		lp.add(MAGENTA_PICNIC_BASKET.get(), "Magenta Picnic Basket");
		lp.add(LIGHT_BLUE_PICNIC_BASKET.get(), "Light Blue Picnic Basket");
		lp.add(YELLOW_PICNIC_BASKET.get(), "Yellow Picnic Basket");
		lp.add(LIME_PICNIC_BASKET.get(), "Lime Picnic Basket");
		lp.add(PINK_PICNIC_BASKET.get(), "Pink Picnic Basket");
		lp.add(GRAY_PICNIC_BASKET.get(), "Gray Picnic Basket");
		lp.add(LIGHT_GRAY_PICNIC_BASKET.get(), "Light Gray Picnic Basket");
		lp.add(CYAN_PICNIC_BASKET.get(), "Cyan Picnic Basket");
		lp.add(BLUE_PICNIC_BASKET.get(), "Blue Picnic Basket");
		lp.add(BROWN_PICNIC_BASKET.get(), "Brown Picnic Basket");
		lp.add(GREEN_PICNIC_BASKET.get(), "Green Picnic Basket");
		lp.add(RED_PICNIC_BASKET.get(), "Red Picnic Basket");
		lp.add(BLACK_PICNIC_BASKET.get(), "Black Picnic Basket");
		lp.add(PURPLE_PICNIC_BASKET.get(), "Purple Picnic Basket");

//		lp.add(CITRUS_RIND_PATTERN_ITEM.get(), "Banner Pattern");
//		lp.add("item.extradelight.citrus_rind_banner_item.desc", "Citrus Rind");
	}
}

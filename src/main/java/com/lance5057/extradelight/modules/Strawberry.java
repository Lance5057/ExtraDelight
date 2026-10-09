package com.lance5057.extradelight.modules;

import static com.lance5057.extradelight.ExtraDelightBlocks.plate;
import static com.lance5057.extradelight.ExtraDelightItems.drinkItem;
import static com.lance5057.extradelight.ExtraDelightItems.stack1Item;
import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.crops.StrawberryCrop;
import com.lance5057.extradelight.blocks.fluids.VinegarFluidBlock;
import com.lance5057.extradelight.client.BlockStateItemGeometryLoader;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.data.recipebuilders.ChillerRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.JuicerRecipeBuilder;
import com.lance5057.extradelight.data.recipebuilders.OvenRecipeBuilder;
import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.MilkshakeDrinkItem;
import com.lance5057.extradelight.items.SourJuiceItem;
import com.lance5057.extradelight.items.ToolTipConsumableItem;
import com.lance5057.extradelight.items.XAdeDrink;
import com.lance5057.extradelight.util.EDItemGenerator;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.item.HotCocoaItem;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class Strawberry {
	// Strawberry
	public static final DeferredBlock<StrawberryCrop> STRAWBERRY_CROP = ExtraDelightBlocks.BLOCKS
			.register("strawberry_crop", () -> new StrawberryCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));

	public static final DeferredItem<Item> STRAWBERRY_SEED = ExtraDelightItems.ITEMS.register("strawberry_seed",
			() -> new ItemNameBlockItem(STRAWBERRY_CROP.get(), new Item.Properties()));

	public static final DeferredItem<Item> STRAWBERRY = EDItemGenerator
			.register("strawberry", () -> new ToolTipConsumableItem(foodItem(EDFoods.STRAWBERRY), true))
			.advancementIngredients().finish();

	public static final DeferredBlock<Block> WILD_STRAWBERRY = ExtraDelightBlocks.BLOCKS.register("wild_strawberry",
			() -> new WildCropBlock(MobEffects.HEAL, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
	public static final DeferredItem<Item> WILD_STRAWBERRY_ITEM = ExtraDelightItems.ITEMS
			.register("wild_strawberry_item", () -> new BlockItem(WILD_STRAWBERRY.get(), new Item.Properties()));

	public static final DeferredBlock<Block> STRAWBERRY_CRATE = ExtraDelightBlocks.BLOCKS.register("strawberry_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));
	public static final DeferredItem<Item> STRAWBERRY_CRATE_ITEM = ExtraDelightItems.ITEMS
			.register("strawberry_crate_item", () -> new BlockItem(STRAWBERRY_CRATE.get(), new Item.Properties()));

	public static final DeferredItem<Item> SLICED_STRAWBERRY = EDItemGenerator
			.register("sliced_strawberry", () -> new Item(new Item.Properties().food(EDFoods.STRAWBERRY)))
			.advancementIngredients().finish();

	public static final DeferredBlock<Block> STRAWBIGGY = ExtraDelightBlocks.BLOCKS.register("strawbiggy",
			() -> new Block(Block.Properties.ofFullCopy(Blocks.MOSS_BLOCK).mapColor(MapColor.COLOR_RED)));
	public static final DeferredItem<Item> STRAWBIGGY_ITEM = ExtraDelightItems.ITEMS.register("strawbiggy_item",
			() -> new BlockItem(STRAWBIGGY.get(), new Item.Properties()));

	// Juice
	public static final DeferredItem<Item> STRAWBERRY_JUICE = EDItemGenerator
			.register("strawberry_juice", () -> new SourJuiceItem(drinkItem(), 3, 100)).advancementIngredients().finish();
	public static final DeferredItem<Item> STRAWBERRY_JUICE_FLUID_BUCKET = ExtraDelightItems.ITEMS.register(
			"strawberry_juice_fluid_bucket", () -> ExtraDelightItems.stack1bucketItem(ExtraDelightFluids.STRAWBERRY_JUICE));
	public static final DeferredBlock<VinegarFluidBlock> STRAWBERRY_JUICE_FLUID_BLOCK = ExtraDelightBlocks.BLOCKS
			.register("strawberry_juice_fluid_block", () -> new VinegarFluidBlock(ExtraDelightFluids.STRAWBERRY_JUICE.FLUID.get(),
					BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().strength(100.0F).noLootTable()));

	// Pink Lemonade
	public static final DeferredItem<Item> PINK_LEMONADE = EDItemGenerator
			.register("pink_lemonade", () -> new XAdeDrink(drinkItem(), 2)).drink().setHydration(20).setThirst(8)
			.setPoison(0).isCold(true).finish();
	public static final DeferredBlock<RecipeFeastBlock> PINK_LEMONADE_TRAY = ExtraDelightBlocks.BLOCKS.register(
			"pink_lemonade_tray",
			() -> new RecipeFeastBlock(Block.Properties.ofFullCopy(Blocks.GLASS).mapColor(MapColor.COLOR_PINK), true,
					plate));
	public static final DeferredItem<Item> PINK_LEMONADE_TRAY_ITEM = EDItemGenerator
			.register("pink_lemonade_tray_item", () -> new BlockItem(PINK_LEMONADE_TRAY.get(), new Item.Properties()))
			.advancementFeast().finish();

	// Cheesecake
	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_SLICE = EDItemGenerator
			.register("strawberry_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE)))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<Block> STRAWBERRY_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
			"strawberry_cheesecake",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_CHEESECAKE_SLICE));
	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_ITEM = EDItemGenerator
			.register("strawberry_cheesecake", () -> new BlockItem(STRAWBERRY_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	// Shortcake
	public static final DeferredItem<Item> STRAWBERRY_SHORTCAKE_SLICE = EDItemGenerator
			.register("strawberry_shortcake_slice", () -> new Item(foodItem(FoodValues.CAKE_SLICE)))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<PieBlock> STRAWBERRY_SHORTCAKE = ExtraDelightBlocks.BLOCKS.register(
			"strawberry_shortcake",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_SHORTCAKE_SLICE) {
				@Override
				public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
						CollisionContext context) {
					return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
				}
			});
	public static final DeferredItem<Item> STRAWBERRY_SHORTCAKE_ITEM = EDItemGenerator
			.register("strawberry_shortcake_item",
					() -> new BlockItem(STRAWBERRY_SHORTCAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	// Cloud Cake
	public static final DeferredBlock<RecipeFeastBlock> STRAWBERRY_CLOUD_CAKE = ExtraDelightBlocks.BLOCKS.register(
			"strawberry_cloud_cake",
			() -> new RecipeFeastBlock(Block.Properties.ofFullCopy(Blocks.BROWN_WOOL).mapColor(MapColor.COLOR_PINK),
					true, ExtraDelightBlocks.pan));
	public static final DeferredItem<Item> STRAWBERRY_CLOUD_CAKE_ITEM = EDItemGenerator
			.register("strawberry_cloud_cake_item", () -> new BlockItem(STRAWBERRY_CLOUD_CAKE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> STRAWBERRY_CLOUD_CAKE_SLICE = EDItemGenerator
			.register("strawberry_cloud_cake_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.STRAWBERRY_CLOUD_CAKE), true))
			.advancementDessert().servingToolTip().finish();

	// Pie
	public static final DeferredItem<Item> STRAWBERRY_PIE_SLICE = EDItemGenerator
			.register("strawberry_pie_slice", () -> new ToolTipConsumableItem(foodItem(FoodValues.PIE_SLICE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredBlock<Block> STRAWBERRY_PIE = ExtraDelightBlocks.BLOCKS.register("strawberry_pie",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_PIE_SLICE));
	public static final DeferredItem<Item> STRAWBERRY_PIE_ITEM = EDItemGenerator
			.register("strawberry_pie_item", () -> new BlockItem(STRAWBERRY_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	// Non-block stuff
	public static final DeferredItem<Item> STRAWBERRY_CUSTARD = EDItemGenerator
			.register("strawberry_custard", () -> new Item(ExtraDelightItems.bottleFoodItem(EDFoods.CUSTARD)))
			.advancementDessert().finish();

	public static final DeferredItem<Item> STRAWBERRY_ICE_CREAM = EDItemGenerator
			.register("strawberry_ice_cream", () -> new Item(ExtraDelightItems.bottleFoodItem(EDFoods.ICE_CREAM)))
			.advancementDessert().finish();

	public static final DeferredItem<Item> STRAWBERRY_POPSICLE = EDItemGenerator
			.register("strawberry_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert()
			.isColdFood().finish();

	public static final DeferredItem<Item> STRAWBERRY_MILK = EDItemGenerator
			.register("strawberry_milk", () -> new HotCocoaItem(drinkItem())).drink().setHydration(30).setThirst(2)
			.setPoison(0).isHot(false).finish();

	public static final DeferredItem<Item> STRAWBERRY_MILKSHAKE = EDItemGenerator
			.register("strawberry_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();

	public static final DeferredItem<Item> STRAWBERRY_MOUSSE = EDItemGenerator
			.register("strawberry_mousse", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHOCOLATE_MOUSSE), true))
			.advancementDessert().finish();

	public static final DeferredItem<Item> STRAWBERRY_SYRUP_BOTTLE = EDItemGenerator
			.register("strawberry_syrup_bottle", () -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(Foods.HONEY_BOTTLE)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> STRAWBERRY_PASTA = EDItemGenerator
			.register("strawberry_pasta", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PASTA_ALFREDO), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> STRAWBERRY_BEET_SALAD = EDItemGenerator
			.register("strawberry_beet_salad", () -> new Item(foodItem(EDFoods.BEET_MINT))).advancementMeal().finish();

	public static final DeferredItem<Item> STRAWBERRY_FIELDS_SALAD = EDItemGenerator
			.register("strawberrry_fields_salad", () -> new Item(bowlFoodItem(EDFoods.CARROT_SALAD))).advancementMeal().finish();

	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_STRAWBERRY = EDItemGenerator
			.register("blood_chocolate_dipped_strawberry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_STRAWBERRY), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_STRAWBERRY = EDItemGenerator
			.register("dark_chocolate_dipped_strawberry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_STRAWBERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_STRAWBERRY = EDItemGenerator
			.register("milk_chocolate_dipped_strawberry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_STRAWBERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_STRAWBERRY = EDItemGenerator
			.register("white_chocolate_dipped_strawberry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_STRAWBERRY), true))
			.advancementCandy().finish();

	public static void blockModels(BlockStateProvider bsp) {
//		BlockModels.cropCrossBlock(bsp, STRAWBERRY_CROP.get(), "strawberry", StrawberryCrop.AGE);
//		bsp.simpleBlock(WILD_STRAWBERRY.get(), new ConfiguredModel(bsp.models()
//				.cross("wild_strawberry", bsp.modLoc("block/crops/strawberry/wild_strawberry")).renderType("cutout")));
		BlockModels.bushStageFourBlock(bsp, STRAWBERRY_CROP.get(), "strawberry");
		BlockModels.crateBlock(bsp, STRAWBERRY_CRATE.get(), "strawberry", "bamboo");
		bsp.simpleBlock(STRAWBIGGY.get(), bsp.models().getExistingFile(bsp.modLoc("block/big_strawberry")));
		BlockModels.fluid(bsp, STRAWBERRY_JUICE_FLUID_BLOCK.get());

		bsp.getVariantBuilder(PINK_LEMONADE_TRAY.get()).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (PINK_LEMONADE_TRAY.get().getMaxServings() - servings);

			if (servings == 0) {
				suffix = PINK_LEMONADE_TRAY.get().hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent("block/pink_lemonade_tray" + suffix,
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/lemonade_tray" + suffix))
					.texture("4", bsp.modLoc("item/strawberry_lemonade")))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});

		bsp.getVariantBuilder(STRAWBERRY_CHEESECAKE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(bsp.models()
					.withExistingParent(BuiltInRegistries.BLOCK.getKey(STRAWBERRY_CHEESECAKE.get()).getPath() + suffix,
							bsp.modLoc("block/pie" + suffix))
					.texture("particle", bsp.modLoc("block/strawberry_cheesecake_top"))
					.texture("top", bsp.modLoc("block/strawberry_cheesecake_top"))
					.texture("inner", bsp.modLoc("block/strawberry_cheesecake_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
		bsp.getVariantBuilder(STRAWBERRY_SHORTCAKE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = "_stage" + bites;

			return ConfiguredModel.builder().modelFile(new ModelFile.ExistingModelFile(
					ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/strawberry_shortcake" + suffix),
					bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
		BlockModels.recipeFeastBlock(bsp, STRAWBERRY_CLOUD_CAKE.get());
		bsp.getVariantBuilder(STRAWBERRY_PIE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(BuiltInRegistries.BLOCK.getKey(STRAWBERRY_PIE.get()).getPath() + suffix,
									bsp.modLoc("block/pie" + suffix))
							.texture("particle", bsp.modLoc("block/strawberry_pie_top"))
							.texture("top", bsp.modLoc("block/strawberry_pie_top"))
							.texture("inner", bsp.modLoc("block/strawberry_pie_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void itemModels(ItemModelProvider tmp) {
		ItemModels.forBlockItemFlat(tmp, WILD_STRAWBERRY_ITEM, "crops/strawberry/wild_strawberry");
		ItemModels.forItem(tmp, STRAWBERRY, "crops/strawberry/strawberry");
		ItemModels.forItem(tmp, STRAWBERRY_SEED, "crops/strawberry/seeds");
		ItemModels.forBlockItem(tmp, STRAWBERRY_CRATE_ITEM, "strawberry_crate");
		ItemModels.forItem(tmp, SLICED_STRAWBERRY, "crops/strawberry/strawberry_sliced");
		ItemModels.forBlockItem(tmp, STRAWBIGGY_ITEM,
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/big_strawberry"));
		ItemModels.forItem(tmp, STRAWBERRY_JUICE, "strawberry_juice");
//		ItemModels.forItem(tmp, STRAWBERRY_JUICE_FLUID_BUCKET, "strawberry_juice_bucket");
		ItemModels.forItem(tmp, PINK_LEMONADE, "strawberry_lemonade");
		tmp.getBuilder(PINK_LEMONADE_TRAY_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, STRAWBERRY_CHEESECAKE_SLICE, "strawberry_cheesecake_slice");
		ItemModels.forItem(tmp, STRAWBERRY_CHEESECAKE_ITEM, "strawberry_cheesecake");
		tmp.getBuilder(STRAWBERRY_SHORTCAKE_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, STRAWBERRY_SHORTCAKE_SLICE, "strawberry_shortcake_slice");
		tmp.getBuilder(STRAWBERRY_CLOUD_CAKE_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, STRAWBERRY_CLOUD_CAKE_SLICE, "strawberry_cloud_cake");
		ItemModels.forItem(tmp, STRAWBERRY_PIE_SLICE, "strawberry_pie_slice");
		ItemModels.forItem(tmp, STRAWBERRY_PIE_ITEM, "strawberry_pie");
		ItemModels.forItem(tmp, STRAWBERRY_CUSTARD, "strawberry_custard");
		ItemModels.forItem(tmp, STRAWBERRY_ICE_CREAM, "strawberry_ice_cream");
		ItemModels.forItem(tmp, STRAWBERRY_POPSICLE, "strawberry_popsicle");
		ItemModels.forItem(tmp, STRAWBERRY_MILK, "strawberry_milk");
		ItemModels.forItem(tmp, STRAWBERRY_MILKSHAKE, "strawberry_milkshake");
		ItemModels.forItem(tmp, STRAWBERRY_MOUSSE, "strawberry_mousse");
		ItemModels.forItem(tmp, STRAWBERRY_SYRUP_BOTTLE, "strawberry_syrup_bottle");
//		ItemModels.forItem(tmp, STRAWBERRY_PASTA, "strawberry_pasta");
//		ItemModels.forItem(tmp, STRAWBERRY_BEET_SALAD, "strawberry_beet_salad");
//		ItemModels.forItem(tmp, STRAWBERRY_FIELDS_SALAD, "strawberry_fields_salad");
		ItemModels.forItem(tmp, BLOOD_CHOCOLATE_DIPPED_STRAWBERRY, "blood_chocolate_strawberry");
		ItemModels.forItem(tmp, DARK_CHOCOLATE_DIPPED_STRAWBERRY, "dark_chocolate_strawberry");
		ItemModels.forItem(tmp, MILK_CHOCOLATE_DIPPED_STRAWBERRY, "milk_chocolate_strawberry");
		ItemModels.forItem(tmp, WHITE_CHOCOLATE_DIPPED_STRAWBERRY, "white_chocolate_strawberry");
	}

	public static void Recipes(RecipeOutput consumer) {
		// Vanilla Crafting
		Recipes.bucket("strawberry_juice", consumer, STRAWBERRY_JUICE_FLUID_BUCKET.get(), Items.GLASS_BOTTLE, STRAWBERRY_JUICE.get());
		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.STRAWBERRY), STRAWBERRY_CRATE_ITEM.get(), STRAWBERRY.get(),
				consumer, "strawberry");
		Recipes.bundleItem4(Ingredient.of(STRAWBERRY.get()), STRAWBIGGY_ITEM.get(), STRAWBERRY.get(),
				consumer, "strawbiggy");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PINK_LEMONADE_TRAY_ITEM.get())
				.requires(PINK_LEMONADE.get(), 4).requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_pink_lemonade", InventoryChangeTrigger.TriggerInstance.hasItems(PINK_LEMONADE.get()))
				.save(consumer, ExtraDelight.modLoc("pink_lemonade_tray"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, STRAWBERRY_MILK.get(), 4)
				.requires(Items.MILK_BUCKET).requires(STRAWBERRY_SYRUP_BOTTLE).requires(Items.GLASS_BOTTLE, 4)
				.unlockedBy("has_milk",
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
				.save(consumer, ExtraDelight.modLoc("strawberry_milk_bucket"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, STRAWBERRY_PASTA.get(), 1)
				.requires(ExtraDelightItems.COOKED_PASTA).requires(ExtraDelightTags.PROCESSED_STRAWBERRY)
				.requires(ExtraDelightTags.PROCESSED_STRAWBERRY).requires(Tags.Items.DRINKS_MILK)
				.requires(ExtraDelightTags.SWEETENER).requires(Items.BOWL, 1)
				.unlockedBy("has_milk",
						InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
				.save(consumer, ExtraDelight.modLoc("strawberry_pasta"));

		// Cake/Pie Reconstruction
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, STRAWBERRY_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', STRAWBERRY_CHEESECAKE_SLICE.get())
				.unlockedBy("has_cake",
						InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_CHEESECAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_cheesecake_slice"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, STRAWBERRY_PIE_ITEM.get()).pattern("ff ")
				.pattern("ff ").define('f', STRAWBERRY_PIE_SLICE.get())
				.unlockedBy("has_pie",
						InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_PIE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_pie_slice"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, STRAWBERRY_SHORTCAKE_ITEM.get())
				.requires(STRAWBERRY_SHORTCAKE_SLICE.get(), 7)
				.unlockedBy("has_slice",
						InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_SHORTCAKE_SLICE.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_shortcake_from_slice"));

		// Chiller
		ChillerRecipeBuilder
				.chill(STRAWBERRY_CLOUD_CAKE_ITEM.toStack(1), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP,
						new ItemStack(ExtraDelightItems.TRAY.get()),
						FluidStack.EMPTY, true)
				.addIngredient(Ingredient.of(ExtraDelightTags.GELATIN)).addIngredient(Ingredient.of(ExtraDelightItems.APPLE_SAUCE))
				.addIngredient(Ingredient.of(ExtraDelightTags.PROCESSED_STRAWBERRY)).build(consumer, "strawberry_cloud_cake_chilling");
		ChillerRecipeBuilder
				.chill(new ItemStack(STRAWBERRY_ICE_CREAM.get(), 1), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP,
						new ItemStack(Items.BOWL), new FluidStack(NeoForgeMod.MILK, 250), true)
				.addIngredient(ExtraDelightTags.SWEETENER).addIngredient(STRAWBERRY).addIngredient(STRAWBERRY)
				.addIngredient(STRAWBERRY).build(consumer, "strawberry_ice_cream");
		ChillerRecipeBuilder.chill(STRAWBERRY_POPSICLE.toStack(4), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP,
						new ItemStack(Items.STICK, 4), new FluidStack(ExtraDelightFluids.STRAWBERRY_JUICE.FLUID, 250), true)
				.build(consumer, "strawberry_popsicle_chiller");
		ChillerRecipeBuilder
				.chill(STRAWBERRY_MOUSSE.toStack(2), Recipes.NORMAL_COOKING, Recipes.SMALL_EXP,
						new ItemStack(Items.GLASS_BOTTLE, 2),
						new FluidStack(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(), 250), true)
				.addIngredient(Ingredient.of(ExtraDelightTags.GELATIN)).addIngredient(Ingredient.of(SummerCitrus.STIFF_PEAKS))
				.addIngredient(Ingredient.of(ExtraDelightTags.PROCESSED_STRAWBERRY))
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).build(consumer, "strawberry_mousse_chilling");

		// Cutting Board
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ExtraDelightTags.STRAWBERRY),
						Ingredient.of(CommonTags.Items.TOOLS_KNIFE), SLICED_STRAWBERRY.get(), 3)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "sliced_strawberry_knife"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(STRAWBERRY_CHEESECAKE_ITEM.get()),
						Ingredient.of(CommonTags.Items.TOOLS_KNIFE), STRAWBERRY_CHEESECAKE_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "strawberry_cheesecake_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(STRAWBERRY_PIE_ITEM.get()),
						Ingredient.of(CommonTags.Items.TOOLS_KNIFE), STRAWBERRY_PIE_SLICE.get(), 4)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "strawberry_pie_knife"));
		CuttingBoardRecipeBuilder
				.cuttingRecipe(Ingredient.of(STRAWBERRY_SHORTCAKE_ITEM.get()), Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
						STRAWBERRY_SHORTCAKE_SLICE.get(), 7)
				.build(consumer, ExtraDelight.modLoc("cutting/" + "strawberry_shortcake_knife"));

		// Feasts
		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), new ItemStack(STRAWBERRY_CLOUD_CAKE_SLICE.get()),
						STRAWBERRY_CLOUD_CAKE_ITEM.get())
				.unlockedBy("has_cloud_cake",
						InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_CLOUD_CAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_cloud_cake_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(), new ItemStack(PINK_LEMONADE.get()), PINK_LEMONADE_TRAY_ITEM.get())
				.unlockedBy("has_pink_lemonade_tray",
						InventoryChangeTrigger.TriggerInstance.hasItems(PINK_LEMONADE_TRAY_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pink_lemonade_tray_pull_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(STRAWBERRY),
						new ItemStack(BLOOD_CHOCOLATE_DIPPED_STRAWBERRY.get()),
						ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK.get())
				.unlockedBy("has_fondue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK.get()))
				.save(consumer, ExtraDelight.modLoc("blood_strawberry_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(STRAWBERRY),
						new ItemStack(DARK_CHOCOLATE_DIPPED_STRAWBERRY.get()),
						ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK.get())
				.unlockedBy("has_fondue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK.get()))
				.save(consumer, ExtraDelight.modLoc("dark_strawberry_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(STRAWBERRY),
						new ItemStack(MILK_CHOCOLATE_DIPPED_STRAWBERRY.get()),
						ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.get())
				.unlockedBy("has_fondue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.get()))
				.save(consumer, ExtraDelight.modLoc("milk_strawberry_feast"));
		FeastRecipeBuilder
				.feast(Ingredient.of(STRAWBERRY),
						new ItemStack(WHITE_CHOCOLATE_DIPPED_STRAWBERRY.get()),
						ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK.get())
				.unlockedBy("has_fondue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK.get()))
				.save(consumer, ExtraDelight.modLoc("white_strawberry_feast"));

		// Juicer
		JuicerRecipeBuilder
				.squeeze(Ingredient.of(ExtraDelightTags.STRAWBERRY), new ItemStack(Items.RED_DYE),
						new FluidStack(ExtraDelightFluids.STRAWBERRY_JUICE.FLUID, 250), 25)
				.save(consumer, ExtraDelight.modLoc("strawberry_juice"));

		// Mixing bowl
		Recipes.mixing(new ItemStack(PINK_LEMONADE.get(), 4), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE, 4),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.ICE_CUBES),
						Ingredient.of(ExtraDelightTags.PROCESSED_STRAWBERRY),
						Ingredient.of(ExtraDelightTags.PROCESSED_LEMON) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 750)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.LEMON_JUICE.FLUID, 250)) },
				consumer, "pink_lemonade_mixing");
		Recipes.mixing(new ItemStack(STRAWBERRY_MILKSHAKE.get(), 1), Recipes.STANDARD_GRIND,
				new ItemStack(Items.GLASS_BOTTLE),
				new Ingredient[] { Ingredient.of(ExtraDelightItems.ICE_CREAM.get()), Ingredient.of(STRAWBERRY),
						Ingredient.of(STRAWBERRY), Ingredient.of(STRAWBERRY), },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(NeoForgeMod.MILK, 250)) }, consumer,
				"strawberry_milkshake");

		// Oven
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(STRAWBERRY_CHEESECAKE_ITEM.get(), 1), Recipes.NORMAL_COOKING,
						Recipes.MEDIUM_EXP, new ItemStack(ExtraDelightItems.PIE_DISH.get()), false)
				.addIngredient(STRAWBERRY, 3).addIngredient(Ingredient.of(Tags.Items.DRINKS_MILK))
				.addIngredient(ModItems.PIE_CRUST.get(), 1).addIngredient(Ingredient.of(Tags.Items.DRINKS_MILK))
				.unlockedByAnyIngredient(ExtraDelightItems.CHEESE.get()).build(consumer);
		OvenRecipeBuilder
				.OvenRecipe(new ItemStack(STRAWBERRY_PIE_ITEM.get(), 1), Recipes.NORMAL_COOKING, Recipes.MEDIUM_EXP,
						new ItemStack(ExtraDelightItems.PIE_DISH.get()), false)
				.addIngredient(ExtraDelightTags.FLOUR, 3).addIngredient(STRAWBERRY, 3)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).addIngredient(ModItems.PIE_CRUST.get(), 1)
				.addIngredient(Ingredient.of(ExtraDelightTags.SWEETENER)).unlockedByAnyIngredient(STRAWBERRY)
				.build(consumer);

		// Pot
		Recipes.pot(STRAWBERRY_CUSTARD.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(STRAWBERRY), Ingredient.of(Tags.Items.DRINKS_MILK),
						Ingredient.of(Tags.Items.EGGS), Ingredient.of(ExtraDelightTags.SWEETENER) },
				"strawberry_custard", consumer);
		Recipes.pot(STRAWBERRY_SYRUP_BOTTLE.get(), 1, CookingRecipes.NORMAL_COOKING, 1.0F, Items.GLASS_BOTTLE,
				new Ingredient[] { Ingredient.of(STRAWBERRY), Ingredient.of(STRAWBERRY), Ingredient.of(STRAWBERRY),
						Ingredient.of(STRAWBERRY), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER) },
				"strawberry_syrup", consumer);
	}

	public static void EngLoc(LanguageProvider lp) {
		lp.add(STRAWBERRY_CROP.get(), "Strawberries");
		lp.add(WILD_STRAWBERRY.get(), "Wild Strawberry");
		lp.add(STRAWBERRY_SEED.get(), "Strawberry Seeds");
		lp.add(STRAWBERRY.get(), "Strawberry");
		lp.add(STRAWBERRY_CRATE.get(), "Strawberry Crate");
		lp.add(SLICED_STRAWBERRY.get(), "Sliced Strawberry");
		lp.add(STRAWBIGGY.get(), "Strawbiggy");
		lp.add(STRAWBERRY_JUICE.get(), "Strawberry Juice");
//		lp.add("farmersdelight.tooltip.strawberry_juice", "Minor Instant Health");
		lp.add(STRAWBERRY_JUICE_FLUID_BUCKET.get(), "Strawberry Juice Bucket");
		lp.add("fluid_type.extradelight.strawberry_juice_fluid", "Strawberry Juice");
		lp.add("block.extradelight.strawberry_juice_fluid_block", "Strawberry Juice");
		lp.add(PINK_LEMONADE.get(), "Pink Lemonade");
//		lp.add("farmersdelight.tooltip.pink_lemonade", "Medium Fire Resist, Sunshine 2");
		lp.add(PINK_LEMONADE_TRAY.get(), "Tray of Pink Lemonade");
		lp.add(STRAWBERRY_CHEESECAKE.get(), "Strawberry Cheesecake");
		lp.add(STRAWBERRY_CHEESECAKE_SLICE.get(), "Slice of Strawberry Cheesecake");
		lp.add(STRAWBERRY_SHORTCAKE.get(), "Strawberry Shortcake");
		lp.add(STRAWBERRY_SHORTCAKE_SLICE.get(), "Slice of Strawberry Shortcake");
		lp.add(STRAWBERRY_CLOUD_CAKE.get(), "Strawberry Cloud Cake");
		lp.add(STRAWBERRY_CLOUD_CAKE_SLICE.get(), "Slice of Strawberry Cloud Cake");
		lp.add(STRAWBERRY_PIE.get(), "Strawberry Pie");
		lp.add(STRAWBERRY_PIE_SLICE.get(), "Slice of Strawberry Pie");
		lp.add(STRAWBERRY_CUSTARD.get(), "Strawberry Custard");
		lp.add(STRAWBERRY_ICE_CREAM.get(), "Strawberry Ice Cream");
		lp.add(STRAWBERRY_POPSICLE.get(), "Strawberry Popsicle");
		lp.add(STRAWBERRY_MILK.get(), "Strawberry Milk");
//		lp.add("farmersdelight.tooltip.strawberry_milk", "Minor Instant Health");
		lp.add(STRAWBERRY_MILKSHAKE.get(), "Strawberry Milkshake");
		lp.add(STRAWBERRY_MOUSSE.get(), "Strawberry Mousse");
		lp.add(STRAWBERRY_SYRUP_BOTTLE.get(), "Strawberry Syrup");
		lp.add(STRAWBERRY_PASTA.get(), "Makaron z Truskawkami");
		lp.add(STRAWBERRY_BEET_SALAD.get(), "Strawberry and Beet Salad");
		lp.add(STRAWBERRY_FIELDS_SALAD.get(), "Strawberry Fields Salad");
		lp.add(BLOOD_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Blood Chocolate-Dipped Strawberry");
		lp.add(DARK_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Dark Chocolate-Dipped Strawberry");
		lp.add(MILK_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Milk Chocolate-Dipped Strawberry");
		lp.add(WHITE_CHOCOLATE_DIPPED_STRAWBERRY.get(), "White Chocolate-Dipped Strawberry");
	}
}

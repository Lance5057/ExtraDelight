package com.lance5057.extradelight.modules;

import static com.lance5057.extradelight.ExtraDelightBlocks.plate;
import static com.lance5057.extradelight.ExtraDelightItems.drinkItem;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

import com.lance5057.extradelight.*;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.blocks.crops.StrawberryCrop;
import com.lance5057.extradelight.client.BlockStateItemGeometryLoader;
import com.lance5057.extradelight.data.BlockModels;
import com.lance5057.extradelight.data.ItemModels;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.food.EDFoods;
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
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class Strawberry {
	//Blocks
	public static final DeferredBlock<StrawberryCrop> STRAWBERRY_CROP = ExtraDelightBlocks.BLOCKS
			.register("strawberry_crop", () -> new StrawberryCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));

	public static final DeferredBlock<Block> WILD_STRAWBERRY = ExtraDelightBlocks.BLOCKS.register("wild_strawberry",
			() -> new WildCropBlock(MobEffects.HEAL, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));

	public static final DeferredBlock<Block> STRAWBERRY_CRATE = ExtraDelightBlocks.BLOCKS.register("strawberry_crate",
			() -> new Block(Block.Properties.ofFullCopy(ModBlocks.BEETROOT_CRATE.get()).mapColor(MapColor.PLANT)));

	public static final DeferredBlock<RecipeFeastBlock> PINK_LEMONADE_TRAY = ExtraDelightBlocks.BLOCKS.register(
			"pink_lemonade_tray",
			() -> new RecipeFeastBlock(Block.Properties.ofFullCopy(Blocks.GLASS).mapColor(MapColor.COLOR_PINK), true,
					plate));

	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_SLICE = EDItemGenerator
			.register("strawberry_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredBlock<Block> STRAWBERRY_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register("strawberry_cheesecake",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_CHEESECAKE_SLICE));
	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_ITEM = EDItemGenerator
			.register("strawberry_cheesecake",
					() -> new BlockItem(STRAWBERRY_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> STRAWBERRY_SHORTCAKE_SLICE = EDItemGenerator
			.register("strawberry_shortcake_slice", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredBlock<PieBlock> STRAWBERRY_SHORTCAKE = ExtraDelightBlocks.BLOCKS.register("strawberry_shortcake",
			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_SHORTCAKE_SLICE) {
				@Override
				public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
										   CollisionContext context) {
					return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
				}
			});
	public static final DeferredItem<Item> STRAWBERRY_SHORTCAKE_ITEM = EDItemGenerator
			.register("strawberry_shortcake_item", () -> new BlockItem(STRAWBERRY_SHORTCAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	//Items
	public static final DeferredItem<Item> WILD_STRAWBERRY_ITEM = ExtraDelightItems.ITEMS.register("wild_strawberry_item",
			() -> new BlockItem(WILD_STRAWBERRY.get(), new Item.Properties()));

	public static final DeferredItem<Item> STRAWBERRY_SEED = ExtraDelightItems.ITEMS.register("strawberry_seed",
			() -> new ItemNameBlockItem(STRAWBERRY_CROP.get(), new Item.Properties()));

	public static final DeferredItem<Item> STRAWBERRY = EDItemGenerator
			.register("strawberry", () -> new ToolTipConsumableItem(foodItem(EDFoods.STRAWBERRY), true))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> STRAWBERRY_CRATE_ITEM = ExtraDelightItems.ITEMS.register("strawberry_crate_item",
			() -> new BlockItem(STRAWBERRY_CRATE.get(), new Item.Properties()));

	public static final DeferredItem<Item> SLICED_STRAWBERRY = EDItemGenerator
			.register("sliced_strawberry", () -> new Item(new Item.Properties().food(EDFoods.STRAWBERRY)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> STRAWBERRY_CUSTARD = EDItemGenerator
			.register("strawberry_custard", () -> new Item(ExtraDelightItems.bottleFoodItem(EDFoods.CUSTARD)))
			.advancementDessert().finish();

	public static final DeferredItem<Item> PINK_LEMONADE = EDItemGenerator
			.register("pink_lemonade", () -> new XAdeDrink(drinkItem(), 2)).drink().setHydration(20).setThirst(8)
			.setPoison(0).isCold(true).finish();
	public static final DeferredItem<Item> PINK_LEMONADE_TRAY_ITEM = EDItemGenerator
			.register("pink_lemonade_tray_item", () -> new BlockItem(PINK_LEMONADE_TRAY.get(), new Item.Properties()))
			.advancementFeast().finish();

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
//				.cross("wild_strawberry", bsp.modLoc("block/crops/strawberry/wild_strawberry_2")).renderType("cutout")));
//		BlockModels.crateBlock(bsp, STRAWBERRY_CRATE.get(), "strawberry", "spruce");
//		BlockModels.recipeFeastBlock(bsp, PINK_LEMONADE_TRAY.get());

//		bsp.getVariantBuilder(PINK_LEMONADE_TRAY.get()).forAllStates(state -> {
//			int servings = state.getValue(RecipeFeastBlock.SERVINGS);
//
//			String suffix = "_stage" + (PINK_LEMONADE_TRAY.get().getMaxServings() - servings);
//
//			if (servings == 0) {
//				suffix = PINK_LEMONADE_TRAY.get().hasLeftovers ? "_leftover" : "_stage3";
//			}
//
//			return ConfiguredModel.builder()
//					.modelFile(bsp.models()
//							.withExistingParent("block/pink_lemonade_tray" + suffix,
//									ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
//											"block/lemonade_tray" + suffix))
//							.texture("4", bsp.modLoc("item/pink_lemonade")))
//					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
//		});
		bsp.getVariantBuilder(STRAWBERRY_CHEESECAKE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = bites > 0 ? "_slice" + bites : "";
			return ConfiguredModel.builder().modelFile(bsp.models()
							.withExistingParent(
									BuiltInRegistries.BLOCK.getKey(STRAWBERRY_CHEESECAKE.get()).getPath() + suffix,
									bsp.modLoc("block/pie" + suffix))
							.texture("particle", bsp.modLoc("block/strawberry_cheesecake_top"))
							.texture("top", bsp.modLoc("block/strawberry_cheesecake_top"))
							.texture("inner", bsp.modLoc("block/strawberry_cheesecake_inner")))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
		bsp.getVariantBuilder(STRAWBERRY_SHORTCAKE.get()).forAllStates(state -> {
			int bites = state.getValue(PieBlock.BITES);
			String suffix = "_stage" + bites;

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "block/strawberry_shortcake"  + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
		});
	}


	public static void itemModels(ItemModelProvider tmp) {
//		ItemModels.forBlockItemFlat(tmp, WILD_STRAWBERRY_ITEM, "crops/strawberry/wild_strawberry_stage_2");
		ItemModels.forItem(tmp, STRAWBERRY, "crops/strawberry/strawberry");
		ItemModels.forItem(tmp, STRAWBERRY_SEED, "crops/strawberry/seeds");
//		ItemModels.forBlockItem(tmp, STRAWBERRY_CRATE_ITEM, "strawberry_crate");
		ItemModels.forItem(tmp, PINK_LEMONADE, "strawberry_lemonade");
//		tmp.getBuilder(PINK_LEMONADE_TRAY_ITEM.getId().getPath()).parent(new ModelFile.UncheckedModelFile("block/block"))
//				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, BLOOD_CHOCOLATE_DIPPED_STRAWBERRY, "blood_chocolate_strawberry");
		ItemModels.forItem(tmp, DARK_CHOCOLATE_DIPPED_STRAWBERRY, "dark_chocolate_strawberry");
		ItemModels.forItem(tmp, MILK_CHOCOLATE_DIPPED_STRAWBERRY, "milk_chocolate_strawberry");
		ItemModels.forItem(tmp, WHITE_CHOCOLATE_DIPPED_STRAWBERRY, "white_chocolate_strawberry");
		ItemModels.forItem(tmp, STRAWBERRY_CHEESECAKE_SLICE, "strawberry_cheesecake_slice");
		ItemModels.forItem(tmp, STRAWBERRY_CHEESECAKE_ITEM, "strawberry_cheesecake");
		tmp.getBuilder(STRAWBERRY_SHORTCAKE_ITEM.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile("block/block"))
				.customLoader(BlockStateItemGeometryLoader::builder);
		ItemModels.forItem(tmp, STRAWBERRY_SHORTCAKE_SLICE, "strawberry_shortcake_slice");
	}

	public static void Recipes(RecipeOutput consumer) {
		Recipes.bundleItem9(Ingredient.of(ExtraDelightTags.LEMON), STRAWBERRY_CRATE_ITEM.get(), STRAWBERRY.get(), consumer,
				"strawberry");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PINK_LEMONADE_TRAY_ITEM.get()).requires(PINK_LEMONADE.get(), 4)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_pink_lemonade", InventoryChangeTrigger.TriggerInstance.hasItems(PINK_LEMONADE.get()))
				.save(consumer, ExtraDelight.modLoc("pink_lemonade_tray"));

		// Cake/Pie Reconstruction
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, STRAWBERRY_CHEESECAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', STRAWBERRY_CHEESECAKE_SLICE.get())
				.unlockedBy("has_cake", InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_CHEESECAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_cheesecake_slice"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, STRAWBERRY_SHORTCAKE_ITEM.get()).pattern("ff ").pattern("ff ")
				.define('f', STRAWBERRY_SHORTCAKE_SLICE.get())
				.unlockedBy("has_cake", InventoryChangeTrigger.TriggerInstance.hasItems(STRAWBERRY_SHORTCAKE_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("strawberry_shortcake_slice"));

		FeastRecipeBuilder.feast(Ingredient.of(), new ItemStack(PINK_LEMONADE.get()), PINK_LEMONADE_TRAY_ITEM.get())
				.unlockedBy("has_pink_lemonade_tray",
						InventoryChangeTrigger.TriggerInstance.hasItems(PINK_LEMONADE_TRAY_ITEM.get()))
				.save(consumer, ExtraDelight.modLoc("pink_lemonade_tray_pull_feast"));

		Recipes.mixing(new ItemStack(PINK_LEMONADE.get(), 4), Recipes.LONG_GRIND, new ItemStack(Items.GLASS_BOTTLE, 4),
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.SWEETENER),
						Ingredient.of(ExtraDelightTags.SWEETENER), Ingredient.of(ExtraDelightTags.ICE_CUBES),
						Ingredient.of(ExtraDelightTags.PROCESSED_STRAWBERRY),
						Ingredient.of(ExtraDelightTags.PROCESSED_LEMON) },
				new SizedFluidIngredient[] { SizedFluidIngredient.of(new FluidStack(Fluids.WATER, 750)),
						SizedFluidIngredient.of(new FluidStack(ExtraDelightFluids.LEMON_JUICE.FLUID, 250)) },
				consumer, "pink_lemonade_mixing");
	}

	public static void EngLoc(LanguageProvider lp) {
		lp.add(STRAWBERRY_CROP.get(), "Strawberries");
		lp.add(WILD_STRAWBERRY.get(), "Wild Strawberry");
		lp.add(STRAWBERRY_SEED.get(), "Strawberry Seeds");
		lp.add(STRAWBERRY.get(), "Strawberry");
		lp.add(STRAWBERRY_CRATE.get(), "Strawberry Crate");
		lp.add(SLICED_STRAWBERRY.get(), "Sliced Strawberry");
		lp.add(PINK_LEMONADE.get(), "Pink Lemonade");
		//lp.add("farmersdelight.tooltip.pink_lemonade", "Medium Fire Resist, Sunshine 2");
		lp.add(PINK_LEMONADE_TRAY.get(), "Tray of Pink Lemonade");
		lp.add(BLOOD_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Blood Chocolate-Dipped Strawberry");
		lp.add(DARK_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Dark Chocolate-Dipped Strawberry");
		lp.add(MILK_CHOCOLATE_DIPPED_STRAWBERRY.get(), "Milk Chocolate-Dipped Strawberry");
		lp.add(WHITE_CHOCOLATE_DIPPED_STRAWBERRY.get(), "White Chocolate-Dipped Strawberry");
		lp.add(STRAWBERRY_CHEESECAKE.get(), "Strawberry Cheesecake");
		lp.add(STRAWBERRY_CHEESECAKE_SLICE.get(), "Slice of Strawberry Cheesecake");
		lp.add(STRAWBERRY_SHORTCAKE.get(), "Strawberry Shortcake");
		lp.add(STRAWBERRY_SHORTCAKE_SLICE.get(), "Slice of Strawberry Shortcake");
		lp.add(STRAWBERRY_CUSTARD.get(), "Strawberry Custard");
	}
}

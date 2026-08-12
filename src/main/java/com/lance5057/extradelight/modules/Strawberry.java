package com.lance5057.extradelight.modules;

import com.lance5057.extradelight.ExtraDelightRegistration;
import com.lance5057.extradelight.util.registration.types.CakeRegistration;

public class Strawberry {
	public static CakeRegistration STRAWBERRY_SHORTCAKE;
	public static CakeRegistration STRAWBERRY_CLOUD_CAKE;
	public static CakeRegistration STRAWBERRY_CHEESECAKE;

	public static void init() {
		ExtraDelightRegistration.registry.add(STRAWBERRY_SHORTCAKE = new CakeRegistration("strawberry_shortcake"));
		ExtraDelightRegistration.registry.add(STRAWBERRY_CLOUD_CAKE = new CakeRegistration("strawberry_cloud_cake"));
		ExtraDelightRegistration.registry.add(STRAWBERRY_CHEESECAKE = new CakeRegistration("strawberry_cheesecake"));
	}
//	// Blocks
//	public static final DeferredBlock<StrawberryCrop> STRAWBERRY_CROP = ExtraDelightBlocks.BLOCKS
//			.register("strawberry_crop", () -> new CucumberCrop(Block.Properties.ofFullCopy(Blocks.WHEAT)));
//
//	public static final DeferredBlock<Block> WILD_STRAWBERRY = ExtraDelightBlocks.BLOCKS.register("wild_strawberry",
//			() -> new WildCropBlock(MobEffects.HEAL, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
//
//	// Items
//
//	public static final DeferredItem<Item> STRAWBERRY_SEED = ExtraDelightItems.ITEMS.register("strawberry_seed",
//			() -> new ItemNameBlockItem(STRAWBERRY_CROP.get(), new Item.Properties()));
//
//	public static final DeferredItem<Item> STRAWBERRY = SimpleItemRegistration
//			.register("strawberry", () -> new ToolTipConsumableItem(foodItem(EDFoods.STRAWBERRY), true))
//			.advancementIngredients().finish();
//
//	public static final DeferredItem<Item> STRAWBERRY_CUSTARD = SimpleItemRegistration
//			.register("strawberry_custard", () -> new Item(ExtraDelightItems.bottleFoodItem(EDFoods.CUSTARD)))
//			.advancementDessert().finish();
//	

//
//	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_SLICE = SimpleItemRegistration
//			.register("strawberry_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE)))
//			.advancementDessert().servingToolTip().finish();
//
//	public static final DeferredBlock<Block> STRAWBERRY_CHEESECAKE = ExtraDelightBlocks.BLOCKS.register(
//			"strawberry_cheesecake",
//			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_CHEESECAKE_SLICE));
//
//	public static final DeferredItem<Item> STRAWBERRY_CHEESECAKE_ITEM = SimpleItemRegistration
//			.register("strawberry_cheesecake", () -> new BlockItem(STRAWBERRY_CHEESECAKE.get(), new Item.Properties()))
//			.advancementFeast().feastToolTip().finish();
//
//	public static final DeferredItem<Item> STRAWBERRY_CLOUD_CAKE_SLICE = SimpleItemRegistration
//			.register("strawberry_cloud_cake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE)))
//			.advancementDessert().servingToolTip().finish();
//
//	public static final DeferredBlock<Block> STRAWBERRY_CLOUD_CAKE = ExtraDelightBlocks.BLOCKS.register(
//			"strawberry_cheesecake",
//			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_CHEESECAKE_SLICE));
//
//	public static final DeferredItem<Item> STRAWBERRY_CLOUD_CAKE_ITEM = SimpleItemRegistration
//			.register("strawberry_cloud_cake", () -> new BlockItem(STRAWBERRY_CLOUD_CAKE.get(), new Item.Properties()))
//			.advancementFeast().feastToolTip().finish();
//
//	public static final DeferredItem<Item> STRAWBERRY_SHORTCAKE_SLICE = SimpleItemRegistration
//			.register("strawberry_shortcake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
//			.servingToolTip().finish();
//
//	public static final DeferredBlock<Block> STRAWBERRY_SHORTCAKE = ExtraDelightBlocks.BLOCKS.register(
//			"strawberry_shortcake",
//			() -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), STRAWBERRY_SHORTCAKE_SLICE));
//
//	public static final DeferredItem<Item> STRAWBERRY_SHORT_CAKE_ITEM = SimpleItemRegistration
//			.register("strawberry_shortcake", () -> new BlockItem(STRAWBERRY_SHORTCAKE.get(), new Item.Properties()))
//			.advancementFeast().feastToolTip().finish();
//
//	public static final DeferredItem<Item> PINK_LEMONADE = SimpleItemRegistration
//			.register("pink_lemonade", () -> new XAdeDrink(drinkItem(), 2)).drink().setHydration(20).setThirst(8)
//			.setPoison(0).isCold(true).finish();
//
//	public static final DeferredBlock<RecipeFeastBlock> PINK_LEMONADE_TRAY = ExtraDelightBlocks.BLOCKS.register(
//			"pink_lemonade_tray",
//			() -> new RecipeFeastBlock(Block.Properties.ofFullCopy(Blocks.GLASS).mapColor(MapColor.COLOR_YELLOW), true,
//					plate));
//
//	public static final DeferredItem<Item> PINK_LEMONADE_TRAY_ITEM = SimpleItemRegistration
//			.register("pink_lemonade_tray_item", () -> new BlockItem(PINK_LEMONADE_TRAY.get(), new Item.Properties()))
//			.advancementFeast().finish();

}

package com.lance5057.extradelight;

import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.GlowberryFoodItem;
import com.lance5057.extradelight.items.GlowberryJuiceItem;
import com.lance5057.extradelight.items.GlowberryPopsicleItem;
import com.lance5057.extradelight.items.SimpleDynamicNameFood;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;
import vectorwing.farmersdelight.common.registry.ModEffects;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ExtraDelightItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExtraDelight.MOD_ID);

	public static final CreativeModeTab EXTRA_DELIGHT_TAB = new CreativeModeTab("extradelight.items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(OVEN.get());
		}
	};

	public static final RegistryObject<Item> OVEN = ITEMS.register("oven",
			() -> new BlockItem(ExtraDelightBlocks.OVEN.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FOOD_DISPLAY = ITEMS.register("food_display",
			() -> new BlockItem(ExtraDelightBlocks.FOOD_DISPLAY.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> DOUGH_SHAPING = ITEMS.register("dough_shaping",
			() -> new BlockItem(ExtraDelightBlocks.DOUGH_SHAPING.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MIXING_BOWL = ITEMS.register("mixing_bowl",
			() -> new BlockItem(ExtraDelightBlocks.MIXING_BOWL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MORTAR_STONE = ITEMS.register("mortar_stone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_STONE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_ANDESITE = ITEMS.register("mortar_andesite",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_ANDESITE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_GRANITE = ITEMS.register("mortar_granite",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_GRANITE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_DIORITE = ITEMS.register("mortar_diorite",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_DIORITE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_DEEPSLATE = ITEMS.register("mortar_deepslate",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_DEEPSLATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_BLACKSTONE = ITEMS.register("mortar_blackstone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_BLACKSTONE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_BASALT = ITEMS.register("mortar_basalt",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_BASALT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_ENDSTONE = ITEMS.register("mortar_endstone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_ENDSTONE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MORTAR_AMETHYST = ITEMS.register("mortar_amethyst",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_AMETHYST.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MORTAR_GILDED_BLACKSTONE = ITEMS.register("mortar_gilded_blackstone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PESTLE_STONE = ITEMS.register("pestle_stone",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_ANDESITE = ITEMS.register("pestle_andesite",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_GRANITE = ITEMS.register("pestle_granite",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_DIORITE = ITEMS.register("pestle_diorite",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_DEEPSLATE = ITEMS.register("pestle_deepslate",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_BLACKSTONE = ITEMS.register("pestle_blackstone",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_BASALT = ITEMS.register("pestle_basalt",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));
	public static final RegistryObject<Item> PESTLE_ENDSTONE = ITEMS.register("pestle_endstone",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));

	public static final RegistryObject<Item> PESTLE_AMETHYST = ITEMS.register("pestle_amethyst",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> PESTLE_GILDED_BLACKSTONE = ITEMS.register("pestle_gilded_blackstone",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));

	public static final RegistryObject<Item> SHEET = ITEMS.register("sheet",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> TRAY = ITEMS.register("tray",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> LOAF_PAN = ITEMS.register("loaf_pan",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> PIE_DISH = ITEMS.register("pie_dish",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> ROUND_PAN = ITEMS.register("round_pan",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> SQUARE_PAN = ITEMS.register("square_pan",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> BAKING_STONE = ITEMS.register("baking_stone",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));
	public static final RegistryObject<Item> MUFFIN_TIN = ITEMS.register("muffin_tin",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(35)));

	public static final RegistryObject<Item> GRATER = ITEMS.register("grater",
			() -> new BlockItem(ExtraDelightBlocks.GRATER.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> DRYING_RACK = ITEMS.register("drying_rack_item",
			() -> new BlockItem(ExtraDelightBlocks.DRYING_RACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
			() -> new SwordItem(Tiers.WOOD, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STONE_SPOON = ITEMS.register("stone_spoon",
			() -> new SwordItem(Tiers.STONE, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> IRON_SPOON = ITEMS.register("iron_spoon",
			() -> new SwordItem(Tiers.IRON, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GOLD_SPOON = ITEMS.register("gold_spoon",
			() -> new SwordItem(Tiers.GOLD, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> DIAMOND_SPOON = ITEMS.register("diamond_spoon",
			() -> new SwordItem(Tiers.DIAMOND, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> NETHERITE_SPOON = ITEMS.register("netherite_spoon",
			() -> new SwordItem(Tiers.NETHERITE, -2, -2, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> YEAST = ITEMS.register("yeast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> YEAST_POT = ITEMS.register("yeast_pot",
			() -> new BlockItem(ExtraDelightBlocks.YEAST_POT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> VINEGAR = ITEMS.register("vinegar",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> VINEGAR_POT = ITEMS.register("vinegar_pot",
			() -> new BlockItem(ExtraDelightBlocks.VINEGAR_POT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> COOKING_OIL = ITEMS.register("cooking_oil",
			() -> new BlockItem(ExtraDelightBlocks.COOKING_OIL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STOCK = ITEMS.register("stock_jar_item",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GRAVY = ITEMS.register("gravy_boat_item",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> SLICED_ONION = ITEMS.register("sliced_onion",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EDIBLE_SEEDS)));
	public static final RegistryObject<Item> SLICED_TOMATO = ITEMS.register("sliced_tomato",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EDIBLE_SEEDS)));

	// Seaweed
	// Agar Agar Process
	public static final RegistryObject<Item> SEAWEED_PASTE = ITEMS.register("seaweed_paste",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> AGAR_SHEETS = ITEMS.register("agar_sheets",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> AGAR_AGAR = ITEMS.register("agar_agar",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> SEAWEED_CRISPS = ITEMS.register("seaweed_crisps",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.DRIED_KELP)));
	public static final RegistryObject<Item> SEAWEED_SALAD = ITEMS.register("seaweed_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(Foods.CARROT, Foods.DRIED_KELP).build())));

//	public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
//			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.CUPCAKE)));

	public static final RegistryObject<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EDIBLE_SEEDS)));

	// Juice
	public static final RegistryObject<Item> GLOW_BERRY_JUICE = ITEMS.register("glow_berry_juice",
			() -> new GlowberryJuiceItem(ModItems.drinkItem()));
	public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice",
			() -> new MelonJuiceItem(ModItems.drinkItem()));
	public static final RegistryObject<Item> TOMATO_JUICE = ITEMS.register("tomato_juice",
			() -> new MelonJuiceItem(ModItems.drinkItem()));

	// Custard
	public static final RegistryObject<Item> SWEET_BERRY_CUSTARD = ITEMS.register("sweet_berry_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.GLOW_BERRY_CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> CHOCOLATE_CUSTARD = ITEMS.register("chocolate_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.GLOW_BERRY_CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PUMPKIN_CUSTARD = ITEMS.register("pumpkin_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.GLOW_BERRY_CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> HONEY_CUSTARD = ITEMS.register("honey_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.GLOW_BERRY_CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));

	// Pie
	public static final RegistryObject<Item> SWEET_BERRY_PIE_SLICE = ITEMS.register("sweet_berry_pie_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> GLOW_BERRY_PIE_SLICE = ITEMS.register("glow_berry_pie_slice",
			() -> new GlowberryFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> CHEESECAKE_SLICE = ITEMS.register("cheesecake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> HONEY_CHEESECAKE_SLICE = ITEMS.register("honey_cheesecake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> CHOCOLATE_CHEESECAKE_SLICE = ITEMS.register("chocolate_cheesecake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> PUMPKIN_CHEESECAKE_SLICE = ITEMS.register("pumpkin_cheesecake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<Item> GLOW_BERRY_CHEESECAKE_SLICE = ITEMS.register("glow_berry_cheesecake_slice",
			() -> new GlowberryFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));

	public static final RegistryObject<Item> SWEET_BERRY_PIE_ITEM = ITEMS.register("sweet_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_PIE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GLOW_BERRY_PIE_ITEM = ITEMS.register("glow_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHEESECAKE_ITEM = ITEMS.register("cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHEESECAKE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> HONEY_CHEESECAKE_ITEM = ITEMS.register("honey_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHOCOLATE_CHEESECAKE_ITEM = ITEMS.register("chocolate_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PUMPKIN_CHEESECAKE_ITEM = ITEMS.register("pumpkin_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GLOW_BERRY_CHEESECAKE_ITEM = ITEMS.register("glow_berry_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Cookies
	public static final RegistryObject<Item> PUMPKIN_COOKIE = ITEMS.register("pumpkin_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE = ITEMS.register("sugar_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GLOW_BERRY_COOKIE = ITEMS.register("glow_berry_cookie",
			() -> new GlowberryFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));

	// Popsicle
	public static final RegistryObject<Item> GLOW_BERRY_POPSICLE = ITEMS.register("glow_berry_popsicle",
			() -> new GlowberryPopsicleItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> SWEET_BERRY_POPSICLE = ITEMS.register("sweet_berry_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> FUDGE_POPSICLE = ITEMS.register("fudge_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> HONEY_POPSICLE = ITEMS.register("honey_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));

	public static final RegistryObject<Item> WHIPPED_CREAM = ITEMS.register("whipped_cream",
			() -> new Item(new MilkBottleItem.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.WHIPPED_CREAM)
					.craftRemainder(Items.BOWL)));
//
//	public static final RegistryObject<Item> PLAIN_CAKE = ITEMS.register("plain_cake",
//			() -> new BlockItem(ExtraDelightBlocks.PLAIN_CAKE.get(),
//					new BlockItem.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Eggs
	public static final RegistryObject<Item> EGG_MIX = ITEMS.register("egg_mix", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BAD_EGG).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SCRAMBLED_EGGS).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> OMELETTE_MIX = ITEMS.register("omelette_mix",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.EGG_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BAD_EGG).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> OMELETTE = ITEMS.register("omelette",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.OMELETTE_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.OMELETTE)));
	public static final RegistryObject<Item> BOILED_EGG = ITEMS.register("boiled_egg",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.FRIED_EGG)));
	public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche",
			() -> new BlockItem(ExtraDelightBlocks.QUICHE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.FRIED_EGG)));
	public static final RegistryObject<Item> EGG_BASKET = ITEMS.register("egg_in_the_basket",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SCRAMBLED_EGGS)));
	public static final RegistryObject<Item> EGG_SALAD = ITEMS.register("egg_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SCRAMBLED_EGGS)));

	// Condiments
	public static final RegistryObject<Item> BBQ_SAUCE = ITEMS.register("bbq_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BBQ).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.KETCHUP).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> MAYO = ITEMS.register("mayo_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MAYO).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> FURIKAKE = ITEMS.register("furikake",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CURRY_POWDER = ITEMS.register("curry_powder",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Jams
	public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> GLOW_BERRY_JAM = ITEMS.register("glow_berry_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> CARROT_JAM = ITEMS.register("carrot_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> APPLE_JAM = ITEMS.register("apple_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> GOLDEN_APPLE_JAM = ITEMS.register("golden_apple_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.GOLDEN_APPLE)));

	// Bread

	public static final RegistryObject<Item> JAM_TOAST = ITEMS.register("jam_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM_BREAD)));
	public static final RegistryObject<Item> GOLDEN_JAM_TOAST = ITEMS.register("golden_jam_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GOLDEN_JAM_BREAD)));

	// Potato
	public static final RegistryObject<Item> GRATED_POTATO = ITEMS.register("grated_potato",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> SLICED_POTATO = ITEMS.register("sliced_potato",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> POTATO_STICKS = ITEMS.register("potato_sticks",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));

	public static final RegistryObject<Item> POTATO_CHIPS = ITEMS.register("potato_chips",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.BAKED_POTATO)));
	public static final RegistryObject<Item> HASHBROWNS = ITEMS.register("hashbrowns",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.BAKED_POTATO)));
	public static final RegistryObject<Item> FRENCH_FRIES = ITEMS.register("french_fries",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.BAKED_POTATO)));

	// Carrot
	public static final RegistryObject<Item> GRATED_CARROT = ITEMS.register("grated_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.CARROT)));
	public static final RegistryObject<Item> ROASTED_CARROT = ITEMS.register("roasted_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CARROT)));
	public static final RegistryObject<Item> GLAZED_CARROT = ITEMS.register("glazed_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CARROT)));
	public static final RegistryObject<Item> CARROT_SALAD = ITEMS.register("carrot_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CARROT)));

	// Apple
	public static final RegistryObject<Item> SLICED_APPLE = ITEMS.register("sliced_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> ROASTED_APPLE = ITEMS.register("roasted_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_APPLE)));
	public static final RegistryObject<Item> APPLE_SAUCE = ITEMS.register("apple_sauce",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_APPLE)));

	// Soup
	public static final RegistryObject<Item> POTATO_SOUP = ITEMS.register("potato_soup",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.VEGETABLE_SOUP)));
	public static final RegistryObject<Item> TOMATO_SOUP = ITEMS.register("tomato_soup",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.VEGETABLE_SOUP)));
	public static final RegistryObject<Item> FISH_SOUP = ITEMS.register("fish_soup",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.VEGETABLE_SOUP)));
	public static final RegistryObject<Item> CARROT_SOUP = ITEMS.register("carrot_soup",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.VEGETABLE_SOUP)));

	// Sandwiches
//	public static final RegistryObject<Item> DYNAMIC_SANDWICH = ITEMS.register("dynamic_sandwich",
//			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.BACON_SANDWICH)));
	public static final RegistryObject<Item> EGG_SALAD_SANDWICH = ITEMS.register("egg_salad_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.EGG_SANDWICH)));

	// Feasts
	public static final RegistryObject<BlockItem> SALISBURY_STEAK_FEAST_ITEM = ITEMS
			.register("salisbury_steak_block_item", () -> new BlockItem(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> SALISBURY_STEAK = ITEMS.register("salisbury_steak",
			() -> new Item(new Item.Properties().food(Foods.COOKED_BEEF).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> MASHED_POTATO_GRAVY_FEAST_ITEM = ITEMS.register(
			"mashed_potato_gravy_block_item", () -> new BlockItem(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MASHED_POTATO_GRAVY = ITEMS.register("mashed_potato_gravy",
			() -> new Item(new Item.Properties().food(Foods.BAKED_POTATO).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(
			new Item.Properties().food(EDFoods.CHEESE).stacksTo(64).tab(EXTRA_DELIGHT_TAB).food(EDFoods.CHEESE)));
	public static final RegistryObject<Item> BUTTER = ITEMS.register("butter", () -> new Item(
			new Item.Properties().food(EDFoods.BUTTER).stacksTo(64).tab(EXTRA_DELIGHT_TAB).food(EDFoods.BUTTER)));

	public static final RegistryObject<BlockItem> CHEESE_BLOCK_ITEM = ITEMS.register("cheese_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BUTTER_BLOCK_ITEM = ITEMS.register("butter_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_BLOCK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Stews
	public static final RegistryObject<Item> PORK_STEW = ITEMS.register("pork_stew",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> LAMB_STEW = ITEMS.register("lamb_stew",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> RABBIT_STEW = ITEMS.register("rabbit_stew",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHICKEN_STEW = ITEMS.register("chicken_stew",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CURRY = ITEMS.register("curry", () -> new Item(new Item.Properties()
			.food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> BEEF_STEW_RICE = ITEMS
			.register("beef_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PORK_STEW_RICE = ITEMS
			.register("pork_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> LAMB_STEW_RICE = ITEMS
			.register("lamb_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> RABBIT_STEW_RICE = ITEMS
			.register("rabbit_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHICKEN_STEW_RICE = ITEMS
			.register("chicken_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FISH_STEW_RICE = ITEMS
			.register("fish_stew_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CURRY_RICE = ITEMS
			.register("curry_rice",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(FoodValues.BEEF_STEW, FoodValues.COOKED_RICE).build())
							.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> BEEF_STEW_FEAST = ITEMS.register("beef_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.BEEF_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> PORK_STEW_FEAST = ITEMS.register("pork_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.PORK_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> LAMB_STEW_FEAST = ITEMS.register("lamb_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.LAMB_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> RABBIT_STEW_FEAST = ITEMS.register("rabbit_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.RABBIT_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHICKEN_STEW_FEAST = ITEMS.register("chicken_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHICKEN_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> FISH_STEW_FEAST = ITEMS.register("fish_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.FISH_STEW.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CURRY_FEAST = ITEMS.register("curry_feast",
			() -> new BlockItem(ExtraDelightBlocks.CURRY.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> SAUSAGE_ROLL = ITEMS.register("sausage_roll",
			() -> new Item(new Item.Properties().food(EDFoods.SAUSAGE_ROLL).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> SOS = ITEMS.register("sos",
			() -> new Item(new Item.Properties().food(EDFoods.SOS).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> LIVER_ONIONS = ITEMS.register("liver_onions",
			() -> new Item(new Item.Properties().food(EDFoods.LIVERONION).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_FISH = ITEMS.register("fried_fish",
			() -> new Item(new Item.Properties().food(Foods.COOKED_SALMON).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHICKEN_FRIED_STEAK = ITEMS.register("chicken_fried_steak", () -> new Item(
			new Item.Properties().food(EDFoods.CHICKEN_FRIED_STEAK).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PORK_TENDERLOIN = ITEMS.register("pork_tenderloin", () -> new Item(
			new Item.Properties().food(EDFoods.CHICKEN_FRIED_STEAK).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PORK_TENDERLOIN_SANDWICH = ITEMS
			.register("pork_tenderloin_sandwich",
					() -> new Item(new Item.Properties()
							.food(EDFoods.addFoods(EDFoods.CHICKEN_FRIED_STEAK, Foods.BREAD).build()).stacksTo(16)
							.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken",
			() -> new Item(new Item.Properties().food(Foods.COOKED_CHICKEN).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STUFFED_HEART = ITEMS.register("stuffed_heart",
			() -> new Item(new Item.Properties().food(EDFoods.STUFFED_HEART).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_BRAINS = ITEMS.register("fried_brains",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_BRAIN).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> OXTAIL_SOUP = ITEMS.register("oxtail_soup",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_STEW).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.GRILLED_CHEESE).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GRILLED_CHEESE = ITEMS.register("grilled_cheese",
			() -> new Item(new Item.Properties().food(EDFoods.GRILLED_CHEESE).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> HASH = ITEMS.register("hash", () -> new Item(new Item.Properties()
			.food(Foods.BAKED_POTATO).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> POT_ROAST = ITEMS.register("potroast", () -> new Item(new Item.Properties()
			.food(FoodValues.BEEF_STEW).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> MEAT_LOAF_FEAST = ITEMS.register("meatloaf_feast",
			() -> new BlockItem(ExtraDelightBlocks.MEATLOAF_FEAST.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MEAT_LOAF = ITEMS.register("meatloaf",
			() -> new Item(new Item.Properties().food(EDFoods.addFoods(EDFoods.KETCHUP, FoodValues.BEEF_PATTY).build())
					.craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MEAT_LOAF_SANDWICH = ITEMS.register("meatloaf_sandwich",
			() -> new Item(new Item.Properties().food(FoodValues.HAMBURGER).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> BBQ_RIBS = ITEMS.register("bbq_ribs", () -> new Item(
			new Item.Properties().food(EDFoods.RIBS).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MEAT_PIE_SLICE = ITEMS.register("meat_pie_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PULLED_PORK_SANDWICH = ITEMS.register("pulled_pork_sandwich",
			() -> new Item(new Item.Properties().food(FoodValues.HAMBURGER).craftRemainder(Items.BREAD).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> RACK_LAMB = ITEMS.register("rack_lamb", () -> new Item(
			new Item.Properties().food(EDFoods.RIBS).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STIRFRY = ITEMS.register("stirfry", () -> new Item(
			new Item.Properties().food(EDFoods.STIRFRY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> BEEF_WELLINGTON = ITEMS.register("beef_wellington",
			() -> new Item(new Item.Properties().food(EDFoods.WELLINGTON).craftRemainder(Items.BOWL).stacksTo(4)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> HAGGIS = ITEMS.register("haggis", () -> new Item(
			new Item.Properties().food(EDFoods.HAGGIS).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> JELLY_WHITE = ITEMS.register("jelly_white", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_ORANGE = ITEMS.register("jelly_orange", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_MAGENTA = ITEMS.register("jelly_magenta", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_LIGHT_BLUE = ITEMS.register("jelly_light_blue", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_YELLOW = ITEMS.register("jelly_yellow", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_LIME = ITEMS.register("jelly_lime", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_PINK = ITEMS.register("jelly_pink", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_GREY = ITEMS.register("jelly_grey", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_LIGHT_GREY = ITEMS.register("jelly_light_grey", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_CYAN = ITEMS.register("jelly_cyan", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_PURPLE = ITEMS.register("jelly_purple", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_BLUE = ITEMS.register("jelly_blue", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_BROWN = ITEMS.register("jelly_brown", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_GREEN = ITEMS.register("jelly_green", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_RED = ITEMS.register("jelly_red", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> JELLY_BLACK = ITEMS.register("jelly_black", () -> new Item(
			new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(4).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> HASH_FEAST_ITEM = ITEMS.register("hash_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HASH_FEAST.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> POT_ROAST_FEAST_ITEM = ITEMS.register("pot_roast_block_item",
			() -> new BlockItem(ExtraDelightBlocks.POT_ROAST_FEAST.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> BBQ_RIBS_FEAST_ITEM = ITEMS.register("bbq_ribs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> MEAT_PIE_BLOCK_ITEM = ITEMS.register("meat_pie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> PULLED_PORK_FEAST_ITEM = ITEMS.register("pulled_pork_block_item",
			() -> new BlockItem(ExtraDelightBlocks.PULLED_PORK_FEAST.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> RACK_LAMB_FEAST_ITEM = ITEMS.register("rack_lamb_block_item",
			() -> new BlockItem(ExtraDelightBlocks.RACK_LAMB.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> STIRFRY_FEAST_ITEM = ITEMS.register("stirfry_block_item",
			() -> new BlockItem(ExtraDelightBlocks.STIRFRY.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BEEF_WELLINGTON_FEAST_ITEM = ITEMS
			.register("beef_wellington_block_item", () -> new BlockItem(ExtraDelightBlocks.BEEF_WELLINGTON.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> HAGGIS_FEAST_ITEM = ITEMS.register("haggis_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HAGGIS.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> JELLY_WHITE_FEAST_ITEM = ITEMS.register("jelly_white_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_WHITE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_ORANGE_FEAST_ITEM = ITEMS.register("jelly_orange_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_ORANGE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_MAGENTA_FEAST_ITEM = ITEMS.register("jelly_magenta_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_MAGENTA.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIGHT_BLUE_FEAST_ITEM = ITEMS
			.register("jelly_light_blue_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_YELLOW_FEAST_ITEM = ITEMS.register("jelly_yellow_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_YELLOW.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIME_FEAST_ITEM = ITEMS.register("jelly_lime_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_LIME.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_PINK_FEAST_ITEM = ITEMS.register("jelly_pink_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_PINK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_GREY_FEAST_ITEM = ITEMS.register("jelly_grey_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_GREY.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_LIGHT_GREY_FEAST_ITEM = ITEMS
			.register("jelly_light_grey_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_CYAN_FEAST_ITEM = ITEMS.register("jelly_cyan_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_CYAN.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_PURPLE_FEAST_ITEM = ITEMS.register("jelly_purple_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_PURPLE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BLUE_FEAST_ITEM = ITEMS.register("jelly_blue_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BLUE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BROWN_FEAST_ITEM = ITEMS.register("jelly_brown_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BROWN.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_GREEN_FEAST_ITEM = ITEMS.register("jelly_green_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_GREEN.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_RED_FEAST_ITEM = ITEMS.register("jelly_red_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_RED.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> JELLY_BLACK_FEAST_ITEM = ITEMS.register("jelly_black_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BLACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> JERKY = ITEMS.register("jerky",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JERKY)));

	public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));
	public static final RegistryObject<Item> TOAST = ITEMS.register("toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));
	public static final RegistryObject<Item> BREAD_CRUMBS = ITEMS.register("breadcrumbs",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));

	public static final RegistryObject<Item> BREADING_MISANPLAS = ITEMS.register("breading_misanplas",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Pasta
	public static final RegistryObject<Item> MACARONI = ITEMS.register("macaroni",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> LASAGNA_NOODLES = ITEMS.register("lasagna_noodles",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MACARONI_CHEESE = ITEMS.register("macaroni_cheese", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.PASTA)));
	public static final RegistryObject<BlockItem> MACARONI_CHEESE_FEAST = ITEMS.register("macaroni_cheese_feast",
			() -> new BlockItem(ExtraDelightBlocks.MACARONI_CHEESE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> LASAGNA = ITEMS.register("lasanga", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.PASTA)));
	public static final RegistryObject<BlockItem> LASANGA_FEAST = ITEMS.register("lasanga_feast",
			() -> new BlockItem(ExtraDelightBlocks.LASAGNA.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> HOTDISH = ITEMS.register("hotdish", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.HOTDISH)));
	public static final RegistryObject<BlockItem> HOTDISH_FEAST = ITEMS.register("hotdish_feast",
			() -> new BlockItem(ExtraDelightBlocks.HOTDISH.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Rice
	public static final RegistryObject<Item> FURIKAKE_RICE = ITEMS.register("furikake_rice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)
					.food(EDFoods.FURIKAKE_RICE)));
//	public static final RegistryObject<Item> FRIED_RICE = ITEMS.register("fried_rice", () -> new Item(
//			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.FRIED_RICE)));

	// Fish
	public static final RegistryObject<Item> FISH_FLAKES = ITEMS.register("fish_flakes",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> FISH_CAKES = ITEMS.register("fish_cakes",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.COOKED_SALMON)));
	public static final RegistryObject<Item> FISH_AND_CHIPS = ITEMS.register("fish_chips",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(Foods.BAKED_POTATO, Foods.COOKED_COD)
							.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).build())));

	// Mushrooms
	public static final RegistryObject<Item> FRIED_MUSHROOMS = ITEMS.register("fried_mushrooms",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.MUSHROOM_STEW)));
	public static final RegistryObject<Item> MUSHROOM_RISOTTO = ITEMS.register("mushroom_risotto", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.FRIED_RICE)));
	public static final RegistryObject<Item> STUFFED_MUSHROOMS = ITEMS.register("stuffed_mushrooms",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.MUSHROOM_STEW)));
	public static final RegistryObject<Item> MUSHROOM_BURGER = ITEMS.register("mushroom_burger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.HAMBURGER)));

	public static final RegistryObject<Item> BACON_EGG_SANDWICH = ITEMS.register("bacon_egg_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(FoodValues.BACON_AND_EGGS, Foods.BREAD).build())));
	public static final RegistryObject<Item> BACON_EGG_CHEESE_SANDWICH = ITEMS.register("bacon_egg_cheese_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(FoodValues.BACON_AND_EGGS, EDFoods.CHEESE_SANDWICH).build())));

	public static final RegistryObject<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));

	public static final RegistryObject<Item> CROUTONS = ITEMS.register("croutons",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));
	public static final RegistryObject<Item> SALAD = ITEMS.register("salad", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SALAD).craftRemainder(Items.BOWL)));
	public static final RegistryObject<BlockItem> SALAD_FEAST_ITEM = ITEMS.register("salad_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SALAD.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> ALFREDO_SAUCE = ITEMS.register("alfredo_sauce",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.TOMATO_SAUCE)));
	public static final RegistryObject<Item> PASTA_TOMATO = ITEMS.register("pasta_tomato",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.PASTA)));
	public static final RegistryObject<Item> PASTA_ALFREDO = ITEMS.register("pasta_alfredo",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.PASTA)));
	public static final RegistryObject<Item> CHICKEN_ALFREDO = ITEMS.register("chicken_alfredo",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(EDFoods.PASTA, Foods.COOKED_CHICKEN).build())));
	public static final RegistryObject<Item> CHICKEN_PARM = ITEMS.register("chicken_parm",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CHICKEN_FRIED_STEAK)));

	public static final RegistryObject<Item> CHOPPED_CHEESE = ITEMS.register("chopped_cheese",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(EDFoods.CHEESE_SANDWICH, Foods.COOKED_BEEF).build())));
	public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(EDFoods.CHEESE, FoodValues.HAMBURGER).build())));
	public static final RegistryObject<Item> BACON_CHEESEBURGER = ITEMS.register("bacon_cheeseburger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(FoodValues.BACON, FoodValues.HAMBURGER).build())));

	public static final RegistryObject<Item> RICEBALL = ITEMS.register("riceball", () -> new Item(new Item.Properties()
			.tab(EXTRA_DELIGHT_TAB).food(EDFoods.addFoods(FoodValues.COOKED_RICE, Foods.DRIED_KELP).build())));
	public static final RegistryObject<Item> RICEBALL_FILLED = ITEMS.register("riceball_filled",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)
					.food(EDFoods.addFoods(FoodValues.COOKED_RICE, EDFoods.SCRAMBLED_EGGS).build())));

	public static final RegistryObject<Item> FISH_SALAD = ITEMS.register("fish_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.COOKED_CHICKEN)));
	public static final RegistryObject<Item> FISH_SALAD_SANDWICH = ITEMS.register("fish_salad_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.CHICKEN_SANDWICH)));
}

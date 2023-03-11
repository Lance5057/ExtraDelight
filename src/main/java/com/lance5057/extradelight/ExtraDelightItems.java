package com.lance5057.extradelight;

import com.lance5057.extradelight.food.FoodVanilla;
import com.lance5057.extradelight.items.GlowberryFoodItem;
import com.lance5057.extradelight.items.GlowberryJuiceItem;
import com.lance5057.extradelight.items.GlowberryPopsicleItem;
import com.lance5057.extradelight.items.SimpleDynamicNameFood;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;
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

	public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(150)));

	public static final RegistryObject<Item> YEAST_POT = ITEMS.register("yeast_pot",
			() -> new BlockItem(ExtraDelightBlocks.YEAST_POT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> YEAST = ITEMS.register("yeast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> COOKING_OIL = ITEMS.register("cooking_oil",
			() -> new BlockItem(ExtraDelightBlocks.COOKING_OIL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.CUPCAKE)));

	public static final RegistryObject<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.EDIBLE_SEEDS)));

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
			() -> new Item(new MilkBottleItem.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.WHIPPED_CREAM)
					.craftRemainder(Items.BOWL)));

	public static final RegistryObject<Item> PLAIN_CAKE = ITEMS.register("plain_cake",
			() -> new BlockItem(ExtraDelightBlocks.PLAIN_CAKE.get(),
					new BlockItem.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Eggs
	public static final RegistryObject<Item> EGG_MIX = ITEMS.register("egg_mix", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.BAD_EGG).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.SCRAMBLED_EGGS).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> OMELETTE_MIX = ITEMS.register("omelette_mix",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.EGG_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.BAD_EGG).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> OMELETTE = ITEMS.register("omelette",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.OMELETTE_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.OMELETTE)));
	public static final RegistryObject<Item> BOILED_EGG = ITEMS.register("boiled_egg",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.FRIED_EGG)));
	public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche",
			() -> new BlockItem(ExtraDelightBlocks.QUICHE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.FRIED_EGG)));
	public static final RegistryObject<Item> EGG_BASKET = ITEMS.register("egg_in_a_basket",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.SCRAMBLED_EGGS)));

	// Condiments
	public static final RegistryObject<Item> BBQ_JAR_ITEM = ITEMS.register("bbq_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.BBQ).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> KETCHUP_JAR_ITEM = ITEMS.register("ketchup_jar_item",
			() -> new DrinkableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.KETCHUP)
					.craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> MAYO_JAR_ITEM = ITEMS.register("mayo_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.MAYO).craftRemainder(Items.GLASS_BOTTLE)));
	
	public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.SLICED_BREAD)));
	public static final RegistryObject<Item> TOAST = ITEMS.register("toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.SLICED_BREAD)));

}

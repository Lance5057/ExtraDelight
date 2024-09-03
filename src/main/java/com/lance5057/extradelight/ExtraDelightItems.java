package com.lance5057.extradelight;

import java.util.List;

import javax.annotation.Nullable;

import com.lance5057.extradelight.armor.CorncobPipe;
import com.lance5057.extradelight.armor.EDArmorMaterial;
import com.lance5057.extradelight.data.MiscLootTables;
import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.CactusJuiceItem;
import com.lance5057.extradelight.items.CornSilkTeaItem;
import com.lance5057.extradelight.items.FrostingItem;
import com.lance5057.extradelight.items.GlowberryFoodItem;
import com.lance5057.extradelight.items.GlowberryJuiceItem;
import com.lance5057.extradelight.items.GlowberryPopsicleItem;
import com.lance5057.extradelight.items.MilkshakeDrinkItem;
import com.lance5057.extradelight.items.OffsetSpatulaItem;
import com.lance5057.extradelight.items.ShuckableCorn;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.HotCocoaItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
//import vectorwing.farmersdelight.common.FoodValues;
//import vectorwing.farmersdelight.common.item.ConsumableItem;
//import vectorwing.farmersdelight.common.item.DrinkableItem;
//import vectorwing.farmersdelight.common.item.HotCocoaItem;
//import vectorwing.farmersdelight.common.item.MelonJuiceItem;
//import vectorwing.farmersdelight.common.item.MilkBottleItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

public class ExtraDelightItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExtraDelight.MOD_ID);

//	public static final CreativeModeTab EXTRA_DELIGHT_TAB = new CreativeModeTab("extradelight.items") {
//		@Override
//		public ItemStack makeIcon() {
//			return new ItemStack(OVEN.get());
//		} 
//	};

	public static final DeferredItem<Item> OVEN = ITEMS.register("oven",
			() -> new BlockItem(ExtraDelightBlocks.OVEN.get(), new Item.Properties()));
	public static final DeferredItem<Item> FOOD_DISPLAY = ITEMS.register("food_display",
			() -> new BlockItem(ExtraDelightBlocks.FOOD_DISPLAY.get(), new Item.Properties()));

	public static final DeferredItem<Item> DOUGH_SHAPING = ITEMS.register("dough_shaping",
			() -> new BlockItem(ExtraDelightBlocks.DOUGH_SHAPING.get(), new Item.Properties()));
	public static final DeferredItem<Item> MIXING_BOWL = ITEMS.register("mixing_bowl",
			() -> new BlockItem(ExtraDelightBlocks.MIXING_BOWL.get(), new Item.Properties()));

	public static final DeferredItem<Item> MORTAR_STONE = ITEMS.register("mortar_stone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_STONE.get(), new Item.Properties()));

	public static final DeferredItem<Item> PESTLE_STONE = ITEMS.register("pestle_stone",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_ANDESITE = ITEMS.register("pestle_andesite",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_GRANITE = ITEMS.register("pestle_granite",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_DIORITE = ITEMS.register("pestle_diorite",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_DEEPSLATE = ITEMS.register("pestle_deepslate",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_BLACKSTONE = ITEMS.register("pestle_blackstone",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_BASALT = ITEMS.register("pestle_basalt",
			() -> new Item(new Item.Properties().durability(150)));
	public static final DeferredItem<Item> PESTLE_ENDSTONE = ITEMS.register("pestle_endstone",
			() -> new Item(new Item.Properties().durability(150)));

	public static final DeferredItem<Item> PESTLE_AMETHYST = ITEMS.register("pestle_amethyst",
			() -> new Item(new Item.Properties().durability(35)));
	public static final DeferredItem<Item> PESTLE_GILDED_BLACKSTONE = ITEMS.register("pestle_gilded_blackstone",
			() -> new Item(new Item.Properties().durability(35)));

	public static final DeferredItem<BlockItem> SHEET = ITEMS.register("sheet",
			() -> new BlockItem(ExtraDelightBlocks.SHEET_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> TRAY = ITEMS.register("tray",
			() -> new BlockItem(ExtraDelightBlocks.TRAY_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> LOAF_PAN = ITEMS.register("loaf_pan",
			() -> new BlockItem(ExtraDelightBlocks.LOAF_PAN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> PIE_DISH = ITEMS.register("pie_dish",
			() -> new BlockItem(ExtraDelightBlocks.PIE_DISH_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SQUARE_PAN = ITEMS.register("square_pan",
			() -> new BlockItem(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BAKING_STONE = ITEMS.register("baking_stone",
			() -> new BlockItem(ExtraDelightBlocks.BAKING_STONE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MUFFIN_TIN = ITEMS.register("muffin_tin",
			() -> new BlockItem(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SERVING_POT = ITEMS.register("serving_pot",
			() -> new BlockItem(ExtraDelightBlocks.SERVING_POT_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> GRATER = ITEMS.register("grater",
			() -> new Item(new Item.Properties().durability(250)));

	public static final DeferredItem<OffsetSpatulaItem> OFFSET_SPATULA_WOOD = ITEMS.register("offset_spatula_wood",
			() -> new OffsetSpatulaItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredItem<OffsetSpatulaItem> OFFSET_SPATULA_IRON = ITEMS.register("offset_spatula_iron",
			() -> new OffsetSpatulaItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredItem<OffsetSpatulaItem> OFFSET_SPATULA_GOLD = ITEMS.register("offset_spatula_gold",
			() -> new OffsetSpatulaItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredItem<OffsetSpatulaItem> OFFSET_SPATULA_DIAMOND = ITEMS
			.register("offset_spatula_diamond", () -> new OffsetSpatulaItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredItem<OffsetSpatulaItem> OFFSET_SPATULA_NETHERITE = ITEMS
			.register("offset_spatula_netherite", () -> new OffsetSpatulaItem(Tiers.NETHERITE, new Item.Properties()));

	public static final DeferredItem<BlockItem> DRYING_RACK = ITEMS.register("drying_rack_item",
			() -> new BlockItem(ExtraDelightBlocks.DRYING_RACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
			() -> new SwordItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredItem<Item> STONE_SPOON = ITEMS.register("stone_spoon",
			() -> new SwordItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredItem<Item> IRON_SPOON = ITEMS.register("iron_spoon",
			() -> new SwordItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredItem<Item> GOLD_SPOON = ITEMS.register("gold_spoon",
			() -> new SwordItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredItem<Item> DIAMOND_SPOON = ITEMS.register("diamond_spoon",
			() -> new SwordItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredItem<Item> NETHERITE_SPOON = ITEMS.register("netherite_spoon",
			() -> new SwordItem(Tiers.NETHERITE, new Item.Properties()));

	public static final DeferredItem<Item> YEAST = ITEMS.register("yeast",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> YEAST_POT = ITEMS.register("yeast_pot",
			() -> new BlockItem(ExtraDelightBlocks.YEAST_POT.get(), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack stack, Item.TooltipContext context,
						List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
					tooltipComponents.add(Component.literal("")
							.append(Component.translatable(ExtraDelight.MOD_ID + ".yeastpot.tooltip"))
							.withStyle(ChatFormatting.AQUA));
				}
			});

	public static final DeferredItem<Item> VINEGAR = ITEMS.register("vinegar",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> VINEGAR_POT = ITEMS.register("vinegar_pot",
			() -> new BlockItem(ExtraDelightBlocks.VINEGAR_POT.get(), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack stack, Item.TooltipContext context,
						List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
					tooltipComponents.add(Component.literal("")
							.append(Component.translatable(ExtraDelight.MOD_ID + ".vinegarpot.tooltip"))
							.withStyle(ChatFormatting.AQUA));
				}
			});

	public static final DeferredItem<Item> FLOUR = ITEMS.register("flour",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR.get(), new Item.Properties()));
	public static final DeferredItem<Item> COOKING_OIL = ITEMS.register("cooking_oil",
			() -> new BlockItem(ExtraDelightBlocks.COOKING_OIL.get(), new Item.Properties()));

	public static final DeferredItem<Item> GRAVY = ITEMS.register("gravy_boat_item",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SLICED_ONION = ITEMS.register("sliced_onion",
			() -> new Item(new Item.Properties().food(EDFoods.SLICED_ONION)));
	public static final DeferredItem<Item> SLICED_TOMATO = ITEMS.register("sliced_tomato",
			() -> new Item(new Item.Properties().food(EDFoods.SLICED_TOMATO)));

	// Seaweed
	// Agar Agar Process
	public static final DeferredItem<Item> SEAWEED_PASTE = ITEMS.register("seaweed_paste",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> AGAR_SHEETS = ITEMS.register("agar_sheets",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> AGAR_AGAR = ITEMS.register("agar_agar",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> SEAWEED_CRISPS = ITEMS.register("seaweed_crisps",
			() -> new Item(new Item.Properties().food(EDFoods.SEAWEED_CRISPS)));
	public static final DeferredItem<Item> SEAWEED_SALAD = ITEMS.register("seaweed_salad",
			() -> new Item(new Item.Properties().food(EDFoods.SEAWEED_SALAD)));

	public static final DeferredItem<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
			() -> new Item(new Item.Properties().food(EDFoods.EDIBLE_SEEDS)));

	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
	}

	// Juice
	public static final DeferredItem<Item> GLOW_BERRY_JUICE = ITEMS.register("glow_berry_juice",
			() -> new GlowberryJuiceItem(drinkItem()));
	public static final DeferredItem<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice",
			() -> new MelonJuiceItem(drinkItem()));
	public static final DeferredItem<Item> TOMATO_JUICE = ITEMS.register("tomato_juice",
			() -> new MelonJuiceItem(drinkItem()));
	public static final DeferredItem<Item> CACTUS_JUICE = ITEMS.register("cactus_juice",
			() -> new CactusJuiceItem(drinkItem()));

	// Custard
	public static final DeferredItem<Item> SWEET_BERRY_CUSTARD = ITEMS.register("sweet_berry_custard",
			() -> new ConsumableItem(
					new Item.Properties().food(EDFoods.CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final DeferredItem<Item> CHOCOLATE_CUSTARD = ITEMS.register("chocolate_custard",
			() -> new ConsumableItem(
					new Item.Properties().food(EDFoods.CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final DeferredItem<Item> PUMPKIN_CUSTARD = ITEMS.register("pumpkin_custard", () -> new ConsumableItem(
			new Item.Properties().food(EDFoods.CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final DeferredItem<Item> HONEY_CUSTARD = ITEMS.register("honey_custard", () -> new ConsumableItem(
			new Item.Properties().food(EDFoods.CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final DeferredItem<Item> APPLE_CUSTARD = ITEMS.register("apple_custard", () -> new Item(
			new Item.Properties().food(EDFoods.CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));

	// Pie
	public static final DeferredItem<Item> SWEET_BERRY_PIE_SLICE = ITEMS.register("sweet_berry_pie_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> GLOW_BERRY_PIE_SLICE = ITEMS.register("glow_berry_pie_slice",
			() -> new GlowberryFoodItem(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> CHEESECAKE_SLICE = ITEMS.register("cheesecake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> HONEY_CHEESECAKE_SLICE = ITEMS.register("honey_cheesecake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> CHOCOLATE_CHEESECAKE_SLICE = ITEMS.register("chocolate_cheesecake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> PUMPKIN_CHEESECAKE_SLICE = ITEMS.register("pumpkin_cheesecake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> GLOW_BERRY_CHEESECAKE_SLICE = ITEMS.register("glow_berry_cheesecake_slice",
			() -> new GlowberryFoodItem(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<Item> APPLE_CHEESECAKE_SLICE = ITEMS.register("apple_cheesecake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));

	public static final DeferredItem<BlockItem> SWEET_BERRY_PIE_ITEM = ITEMS.register("sweet_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GLOW_BERRY_PIE_ITEM = ITEMS.register("glow_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHEESECAKE_ITEM = ITEMS.register("cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHEESECAKE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> HONEY_CHEESECAKE_ITEM = ITEMS.register("honey_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHOCOLATE_CHEESECAKE_ITEM = ITEMS.register("chocolate_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> PUMPKIN_CHEESECAKE_ITEM = ITEMS.register("pumpkin_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GLOW_BERRY_CHEESECAKE_ITEM = ITEMS.register("glow_berry_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> APPLE_CHEESECAKE_ITEM = ITEMS.register("apple_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), new Item.Properties()));

	// Cookies
	public static final DeferredItem<Item> PUMPKIN_COOKIE = ITEMS.register("pumpkin_cookie",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE = ITEMS.register("sugar_cookie",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GLOW_BERRY_COOKIE = ITEMS.register("glow_berry_cookie",
			() -> new GlowberryFoodItem(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> APPLE_COOKIE = ITEMS.register("apple_cookie",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));

	// Popsicle
	public static final DeferredItem<Item> GLOW_BERRY_POPSICLE = ITEMS.register("glow_berry_popsicle",
			() -> new GlowberryPopsicleItem(new Item.Properties().food(FoodValues.POPSICLE)));
	public static final DeferredItem<Item> SWEET_BERRY_POPSICLE = ITEMS.register("sweet_berry_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));
	public static final DeferredItem<Item> FUDGE_POPSICLE = ITEMS.register("fudge_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));
	public static final DeferredItem<Item> HONEY_POPSICLE = ITEMS.register("honey_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));
	public static final DeferredItem<Item> APPLE_POPSICLE = ITEMS.register("apple_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));

	public static final DeferredItem<Item> WHIPPED_CREAM = ITEMS.register("whipped_cream",
			() -> new Item(new MilkBottleItem.Properties().food(EDFoods.WHIPPED_CREAM).craftRemainder(Items.BOWL)));

	// Eggs
	public static final DeferredItem<Item> EGG_MIX = ITEMS.register("egg_mix",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));

	public static final DeferredItem<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs",
			() -> new Item(new Item.Properties().food(EDFoods.SCRAMBLED_EGGS).craftRemainder(Items.BOWL)));

	public static final DeferredItem<Item> OMELETTE_MIX = ITEMS.register("omelette_mix",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));

	public static final DeferredItem<Item> OMELETTE = ITEMS.register("omelette",
			() -> new Item(new Item.Properties().food(EDFoods.OMELETTE)));

	public static final DeferredItem<Item> BOILED_EGG = ITEMS.register("boiled_egg",
			() -> new Item(new Item.Properties().food(FoodValues.FRIED_EGG)));

	public static final DeferredItem<Item> QUICHE = ITEMS.register("quiche",
			() -> new BlockItem(ExtraDelightBlocks.QUICHE.get(), new Item.Properties()));

	public static final DeferredItem<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
			() -> new Item(new Item.Properties().food(EDFoods.QUICHE)));

	public static final DeferredItem<Item> EGG_BASKET = ITEMS.register("egg_in_the_basket",
			() -> new Item(new Item.Properties().food(EDFoods.EGG_BASKET)));

	public static final DeferredItem<Item> EGG_SALAD = ITEMS.register("egg_salad",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.EGG_SALAD)));

	// Condiments
	public static final DeferredItem<Item> BBQ_SAUCE = ITEMS.register("bbq_jar_item",
			() -> new DrinkableItem(new Item.Properties().food(EDFoods.BBQ).craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> KETCHUP = ITEMS.register("ketchup_jar_item",
			() -> new DrinkableItem(new Item.Properties().food(EDFoods.KETCHUP).craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> MAYO = ITEMS.register("mayo_jar_item",
			() -> new DrinkableItem(new Item.Properties().food(EDFoods.MAYO).craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> FURIKAKE = ITEMS.register("furikake",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> CURRY_POWDER = ITEMS.register("curry_powder",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

	// Jams
	public static final DeferredItem<Item> JAM = ITEMS.register("jam",
			() -> new Item(new Item.Properties().food(EDFoods.JAM).craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> GLOW_BERRY_JAM = ITEMS.register("glow_berry_jam",
			() -> new Item(new Item.Properties().food(EDFoods.GLOW_JAM).craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<Item> GOLDEN_APPLE_JAM = ITEMS.register("golden_apple_jam",
			() -> new Item(new Item.Properties().food(EDFoods.GOLDEN_JAM).craftRemainder(Items.GLASS_BOTTLE)));

	// Bread

	public static final DeferredItem<Item> JAM_TOAST = ITEMS.register("jam_toast",
			() -> new Item(new Item.Properties().food(EDFoods.JAM_BREAD)));
	public static final DeferredItem<Item> GLOW_JAM_TOAST = ITEMS.register("glow_jam_toast",
			() -> new Item(new Item.Properties().food(EDFoods.GLOW_JAM_BREAD)));
	public static final DeferredItem<Item> GOLDEN_JAM_TOAST = ITEMS.register("golden_jam_toast",
			() -> new Item(new Item.Properties().food(EDFoods.GOLDEN_JAM_BREAD)));

	// Potato
	public static final DeferredItem<Item> GRATED_POTATO = ITEMS.register("grated_potato",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));
	public static final DeferredItem<Item> SLICED_POTATO = ITEMS.register("sliced_potato",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));
	public static final DeferredItem<Item> POTATO_STICKS = ITEMS.register("potato_sticks",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));

	public static final DeferredItem<Item> POTATO_CHIPS = ITEMS.register("potato_chips",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_POTATO)));
	public static final DeferredItem<Item> HASHBROWNS = ITEMS.register("hashbrowns",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_POTATO)));
	public static final DeferredItem<Item> FRENCH_FRIES = ITEMS.register("french_fries",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_POTATO)));

	// Carrot
	public static final DeferredItem<Item> GRATED_CARROT = ITEMS.register("grated_carrot",
			() -> new Item(new Item.Properties().food(Foods.CARROT)));

	public static final DeferredItem<Item> ROASTED_CARROT = ITEMS.register("roasted_carrot",
			() -> new Item(new Item.Properties().food(EDFoods.COOKED_CARROT)));
	public static final DeferredItem<Item> GLAZED_CARROT = ITEMS.register("glazed_carrot",
			() -> new Item(new Item.Properties().food(EDFoods.GLAZED_CARROT)));
	public static final DeferredItem<Item> CARROT_SALAD = ITEMS.register("carrot_salad",
			() -> new Item(new Item.Properties().food(EDFoods.CARROT_SALAD).craftRemainder(Items.BOWL)));

	// Apple
	public static final DeferredItem<Item> SLICED_APPLE = ITEMS.register("sliced_apple",
			() -> new Item(new Item.Properties().food(Foods.APPLE)));
	public static final DeferredItem<Item> ROASTED_APPLE = ITEMS.register("roasted_apple",
			() -> new Item(new Item.Properties().food(EDFoods.COOKED_APPLE)));
	public static final DeferredItem<Item> APPLE_SAUCE = ITEMS.register("apple_sauce",
			() -> new Item(new Item.Properties().food(EDFoods.APPLE_SAUCE).craftRemainder(Items.BOWL)));

	// Soup
	public static final DeferredItem<Item> POTATO_SOUP = ITEMS.register("potato_soup",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.POTATO_SOUP)));
	public static final DeferredItem<Item> TOMATO_SOUP = ITEMS.register("tomato_soup",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.TOMATO_SOUP)));
	public static final DeferredItem<Item> FISH_SOUP = ITEMS.register("fish_soup",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.FISH_SOUP)));
	public static final DeferredItem<Item> CARROT_SOUP = ITEMS.register("carrot_soup",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CARROT_SOUP)));

	// Sandwiches
	public static final DeferredItem<Item> EGG_SALAD_SANDWICH = ITEMS.register("egg_salad_sandwich",
			() -> new Item(new Item.Properties().food(FoodValues.EGG_SANDWICH)));

	// Feasts
	public static final DeferredItem<BlockItem> SALISBURY_STEAK_FEAST_ITEM = ITEMS.register(
			"salisbury_steak_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), new Item.Properties()));
	public static final DeferredItem<Item> SALISBURY_STEAK = ITEMS.register("salisbury_steak", () -> new Item(
			new Item.Properties().food(EDFoods.SALISBURY_STEAK).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<BlockItem> MASHED_POTATO_GRAVY_FEAST_ITEM = ITEMS.register(
			"mashed_potato_gravy_block_item",
			() -> new BlockItem(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(), new Item.Properties()));
	public static final DeferredItem<Item> MASHED_POTATO_GRAVY = ITEMS.register("mashed_potato_gravy", () -> new Item(
			new Item.Properties().food(EDFoods.MASHED_POTATO_GRAVY).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<Item> CHEESE = ITEMS.register("cheese",
			() -> new Item(new Item.Properties().food(EDFoods.CHEESE).stacksTo(64)));
	public static final DeferredItem<Item> BUTTER = ITEMS.register("butter",
			() -> new Item(new Item.Properties().food(EDFoods.BUTTER).stacksTo(64)));

	public static final DeferredItem<BlockItem> CHEESE_BLOCK_ITEM = ITEMS.register("cheese_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHEESE_STAIRS_BLOCK_ITEM = ITEMS.register("cheese_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHEESE_SLAB_BLOCK_ITEM = ITEMS.register("cheese_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BUTTER_BLOCK_ITEM = ITEMS.register("butter_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BUTTER_STAIRS_BLOCK_ITEM = ITEMS.register("butter_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BUTTER_SLAB_BLOCK_ITEM = ITEMS.register("butter_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(), new Item.Properties()));

	// Stews
	public static final DeferredItem<Item> PORK_STEW = ITEMS.register("pork_stew",
			() -> new Item(new Item.Properties().food(EDFoods.PORK_STEW).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> LAMB_STEW = ITEMS.register("lamb_stew",
			() -> new Item(new Item.Properties().food(EDFoods.LAMB_STEW).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> CHICKEN_STEW = ITEMS.register("chicken_stew",
			() -> new Item(new Item.Properties().food(EDFoods.CHICKEN_STEW).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> CURRY = ITEMS.register("curry",
			() -> new Item(new Item.Properties().food(EDFoods.CURRY).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<Item> BEEF_STEW_RICE = ITEMS.register("beef_stew_rice",
			() -> new Item(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> PORK_STEW_RICE = ITEMS.register("pork_stew_rice",
			() -> new Item(new Item.Properties().food(EDFoods.PORK_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> LAMB_STEW_RICE = ITEMS.register("lamb_stew_rice",
			() -> new Item(new Item.Properties().food(EDFoods.LAMB_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> RABBIT_STEW_RICE = ITEMS.register("rabbit_stew_rice", () -> new Item(
			new Item.Properties().food(EDFoods.RABBIT_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> CHICKEN_STEW_RICE = ITEMS.register("chicken_stew_rice", () -> new Item(
			new Item.Properties().food(EDFoods.CHICKEN_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> FISH_STEW_RICE = ITEMS.register("fish_stew_rice",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_STEW_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> CURRY_RICE = ITEMS.register("curry_rice",
			() -> new Item(new Item.Properties().food(EDFoods.CURRY_RICE).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<BlockItem> BEEF_STEW_FEAST = ITEMS.register("beef_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.BEEF_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> PORK_STEW_FEAST = ITEMS.register("pork_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.PORK_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> LAMB_STEW_FEAST = ITEMS.register("lamb_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.LAMB_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> RABBIT_STEW_FEAST = ITEMS.register("rabbit_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.RABBIT_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> CHICKEN_STEW_FEAST = ITEMS.register("chicken_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHICKEN_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> FISH_STEW_FEAST = ITEMS.register("fish_stew_feast",
			() -> new BlockItem(ExtraDelightBlocks.FISH_STEW.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<BlockItem> CURRY_FEAST = ITEMS.register("curry_feast",
			() -> new BlockItem(ExtraDelightBlocks.CURRY.get(), new Item.Properties().stacksTo(1)));

	public static final DeferredItem<Item> SAUSAGE_ROLL = ITEMS.register("sausage_roll",
			() -> new Item(new Item.Properties().food(EDFoods.SAUSAGE_ROLL).stacksTo(16)));
	public static final DeferredItem<Item> SOS = ITEMS.register("sos",
			() -> new Item(new Item.Properties().food(EDFoods.SOS).stacksTo(16)));
	public static final DeferredItem<Item> LIVER_ONIONS = ITEMS.register("liver_onions",
			() -> new Item(new Item.Properties().food(EDFoods.LIVERONION).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> FRIED_FISH = ITEMS.register("fried_fish",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_FISH).stacksTo(16)));
	public static final DeferredItem<Item> CHICKEN_FRIED_STEAK = ITEMS.register("chicken_fried_steak",
			() -> new Item(new Item.Properties().food(EDFoods.CHICKEN_FRIED_STEAK).stacksTo(16)));
	public static final DeferredItem<Item> PORK_TENDERLOIN = ITEMS.register("pork_tenderloin",
			() -> new Item(new Item.Properties().food(EDFoods.PORK_TENDERLOIN).stacksTo(16)));
	public static final DeferredItem<Item> PORK_TENDERLOIN_SANDWICH = ITEMS.register("pork_tenderloin_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.PORK_TENDERLOIN_SANDWICH).stacksTo(16)));
	public static final DeferredItem<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16)));
	public static final DeferredItem<Item> STUFFED_HEART = ITEMS.register("stuffed_heart",
			() -> new Item(new Item.Properties().food(EDFoods.STUFFED_HEART).stacksTo(16)));
	public static final DeferredItem<Item> FRIED_BRAINS = ITEMS.register("fried_brains",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_BRAIN).stacksTo(16)));
	public static final DeferredItem<Item> OXTAIL_SOUP = ITEMS.register("oxtail_soup",
			() -> new Item(new Item.Properties().food(EDFoods.OXTAIL_SOUP).stacksTo(16).craftRemainder(Items.BOWL)));

	public static final DeferredItem<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.CHEESE_SANDWICH).stacksTo(16)));
	public static final DeferredItem<Item> GRILLED_CHEESE = ITEMS.register("grilled_cheese",
			() -> new Item(new Item.Properties().food(EDFoods.GRILLED_CHEESE).stacksTo(16)));

	public static final DeferredItem<Item> HASH = ITEMS.register("hash",
			() -> new Item(new Item.Properties().food(EDFoods.HASH).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> POT_ROAST = ITEMS.register("potroast",
			() -> new Item(new Item.Properties().food(EDFoods.POT_ROAST).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<BlockItem> MEAT_LOAF_FEAST = ITEMS.register("meatloaf_feast",
			() -> new BlockItem(ExtraDelightBlocks.MEATLOAF_FEAST.get(), new Item.Properties().stacksTo(1)));
	public static final DeferredItem<Item> MEAT_LOAF = ITEMS.register("meatloaf",
			() -> new Item(new Item.Properties().food(EDFoods.MEAT_LOAF).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> MEAT_LOAF_SANDWICH = ITEMS.register("meatloaf_sandwich", () -> new Item(
			new Item.Properties().food(EDFoods.MEAT_LOAF_SANDWICH).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<Item> BBQ_RIBS = ITEMS.register("bbq_ribs",
			() -> new Item(new Item.Properties().food(EDFoods.BBQ_RIBS).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> MEAT_PIE_SLICE = ITEMS.register("meat_pie_slice",
			() -> new Item(new Item.Properties().food(EDFoods.MEAT_PIE).stacksTo(16)));
	public static final DeferredItem<Item> PULLED_PORK_SANDWICH = ITEMS.register("pulled_pork_sandwich", () -> new Item(
			new Item.Properties().food(EDFoods.PULLED_PORK_SANDWICH).craftRemainder(Items.BREAD).stacksTo(16)));

	public static final DeferredItem<Item> RACK_LAMB = ITEMS.register("rack_lamb",
			() -> new Item(new Item.Properties().food(EDFoods.RACK_LAMB).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> STIRFRY = ITEMS.register("stirfry",
			() -> new Item(new Item.Properties().food(EDFoods.STIRFRY_RICE).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> BEEF_WELLINGTON = ITEMS.register("beef_wellington",
			() -> new Item(new Item.Properties().food(EDFoods.WELLINGTON).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> HAGGIS = ITEMS.register("haggis",
			() -> new Item(new Item.Properties().food(EDFoods.HAGGIS).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<Item> JELLY_WHITE = ITEMS.register("jelly_white",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_ORANGE = ITEMS.register("jelly_orange",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_MAGENTA = ITEMS.register("jelly_magenta",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_LIGHT_BLUE = ITEMS.register("jelly_light_blue",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_YELLOW = ITEMS.register("jelly_yellow",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_LIME = ITEMS.register("jelly_lime",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_PINK = ITEMS.register("jelly_pink",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_GREY = ITEMS.register("jelly_grey",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_LIGHT_GREY = ITEMS.register("jelly_light_grey",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_CYAN = ITEMS.register("jelly_cyan",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_PURPLE = ITEMS.register("jelly_purple",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_BLUE = ITEMS.register("jelly_blue",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_BROWN = ITEMS.register("jelly_brown",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_GREEN = ITEMS.register("jelly_green",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_RED = ITEMS.register("jelly_red",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final DeferredItem<Item> JELLY_BLACK = ITEMS.register("jelly_black",
			() -> new Item(new Item.Properties().food(EDFoods.JELLY).craftRemainder(Items.BOWL).stacksTo(16)));

	public static final DeferredItem<BlockItem> HASH_FEAST_ITEM = ITEMS.register("hash_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HASH_FEAST.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> POT_ROAST_FEAST_ITEM = ITEMS.register("pot_roast_block_item",
			() -> new BlockItem(ExtraDelightBlocks.POT_ROAST_FEAST.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BBQ_RIBS_FEAST_ITEM = ITEMS.register("bbq_ribs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MEAT_PIE_BLOCK_ITEM = ITEMS.register("meat_pie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> PULLED_PORK_FEAST_ITEM = ITEMS.register("pulled_pork_block_item",
			() -> new BlockItem(ExtraDelightBlocks.PULLED_PORK_FEAST.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> RACK_LAMB_FEAST_ITEM = ITEMS.register("rack_lamb_block_item",
			() -> new BlockItem(ExtraDelightBlocks.RACK_LAMB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> STIRFRY_FEAST_ITEM = ITEMS.register("stirfry_block_item",
			() -> new BlockItem(ExtraDelightBlocks.STIRFRY.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BEEF_WELLINGTON_FEAST_ITEM = ITEMS.register(
			"beef_wellington_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BEEF_WELLINGTON.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> HAGGIS_FEAST_ITEM = ITEMS.register("haggis_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HAGGIS.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> JELLY_WHITE_FEAST_ITEM = ITEMS.register("jelly_white_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_WHITE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_ORANGE_FEAST_ITEM = ITEMS.register("jelly_orange_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_ORANGE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_MAGENTA_FEAST_ITEM = ITEMS.register("jelly_magenta_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_MAGENTA.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_LIGHT_BLUE_FEAST_ITEM = ITEMS.register(
			"jelly_light_blue_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_YELLOW_FEAST_ITEM = ITEMS.register("jelly_yellow_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_YELLOW.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_LIME_FEAST_ITEM = ITEMS.register("jelly_lime_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_LIME.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_PINK_FEAST_ITEM = ITEMS.register("jelly_pink_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_PINK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_GREY_FEAST_ITEM = ITEMS.register("jelly_grey_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_GREY.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_LIGHT_GREY_FEAST_ITEM = ITEMS.register(
			"jelly_light_grey_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_CYAN_FEAST_ITEM = ITEMS.register("jelly_cyan_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_CYAN.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_PURPLE_FEAST_ITEM = ITEMS.register("jelly_purple_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_PURPLE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_BLUE_FEAST_ITEM = ITEMS.register("jelly_blue_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BLUE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_BROWN_FEAST_ITEM = ITEMS.register("jelly_brown_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BROWN.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_GREEN_FEAST_ITEM = ITEMS.register("jelly_green_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_GREEN.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_RED_FEAST_ITEM = ITEMS.register("jelly_red_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_RED.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> JELLY_BLACK_FEAST_ITEM = ITEMS.register("jelly_black_block_item",
			() -> new BlockItem(ExtraDelightBlocks.JELLY_BLACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> JERKY = ITEMS.register("jerky",
			() -> new Item(new Item.Properties().food(EDFoods.JERKY)));

	public static final DeferredItem<Item> BREAD_SLICE = ITEMS.register("bread_slice",
			() -> new Item(new Item.Properties().food(EDFoods.SLICED_BREAD)));
	public static final DeferredItem<Item> TOAST = ITEMS.register("toast",
			() -> new Item(new Item.Properties().food(EDFoods.SLICED_BREAD)));
	public static final DeferredItem<Item> BREAD_CRUMBS = ITEMS.register("breadcrumbs",
			() -> new BlockItem(ExtraDelightBlocks.BREADCRUMBS.get(),
					new Item.Properties().food(EDFoods.SLICED_BREAD)));

	public static final DeferredItem<Item> BREADING_MISANPLAS = ITEMS.register("breading_misanplas",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL)));

	// Pasta
	public static final DeferredItem<Item> MACARONI = ITEMS.register("macaroni", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> LASAGNA_NOODLES = ITEMS.register("lasagna_noodles",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> MACARONI_CHEESE = ITEMS.register("macaroni_cheese",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.MACARONI_AND_CHEESE)));
	public static final DeferredItem<BlockItem> MACARONI_CHEESE_FEAST = ITEMS.register("macaroni_cheese_feast",
			() -> new BlockItem(ExtraDelightBlocks.MACARONI_CHEESE.get(), new Item.Properties()));

	public static final DeferredItem<Item> LASAGNA = ITEMS.register("lasanga",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.LASAGNA)));
	public static final DeferredItem<BlockItem> LASAGNA_FEAST = ITEMS.register("lasanga_feast",
			() -> new BlockItem(ExtraDelightBlocks.LASAGNA.get(), new Item.Properties()));

	public static final DeferredItem<Item> HOTDISH = ITEMS.register("hotdish",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.HOTDISH)));
	public static final DeferredItem<BlockItem> HOTDISH_FEAST = ITEMS.register("hotdish_feast",
			() -> new BlockItem(ExtraDelightBlocks.HOTDISH.get(), new Item.Properties()));

	// Rice
	public static final DeferredItem<Item> FURIKAKE_RICE = ITEMS.register("furikake_rice",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.FURIKAKE_RICE)));

	// Fish
	public static final DeferredItem<Item> FISH_FLAKES = ITEMS.register("fish_flakes",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> FISH_CAKES = ITEMS.register("fish_cakes",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_CAKES)));
	public static final DeferredItem<Item> FISH_AND_CHIPS = ITEMS.register("fish_chips",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_CHIPS)));

	// Mushrooms
	public static final DeferredItem<Item> FRIED_MUSHROOMS = ITEMS.register("fried_mushrooms",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_MUSHROOMS)));
	public static final DeferredItem<Item> MUSHROOM_RISOTTO = ITEMS.register("mushroom_risotto",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.MUSHROOM_RISOTTO)));
	public static final DeferredItem<Item> STUFFED_MUSHROOMS = ITEMS.register("stuffed_mushrooms",
			() -> new Item(new Item.Properties().food(EDFoods.STUFFED_MUSHROOMS)));
	public static final DeferredItem<Item> MUSHROOM_BURGER = ITEMS.register("mushroom_burger",
			() -> new Item(new Item.Properties().food(EDFoods.MUSHROOM_BURGER)));

	public static final DeferredItem<Item> BACON_EGG_SANDWICH = ITEMS.register("bacon_egg_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.BACON_EGG_SANDWICH)));
	public static final DeferredItem<Item> BACON_EGG_CHEESE_SANDWICH = ITEMS.register("bacon_egg_cheese_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.BACON_EGG_CHEESE_SANDWICH)));

	public static final DeferredItem<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
			() -> new Item(new Item.Properties().food(EDFoods.BUTTERED_TOAST)));

	public static final DeferredItem<Item> CROUTONS = ITEMS.register("croutons",
			() -> new Item(new Item.Properties().food(EDFoods.SLICED_BREAD)));
	public static final DeferredItem<Item> SALAD = ITEMS.register("salad",
			() -> new Item(new Item.Properties().food(EDFoods.SALAD).craftRemainder(Items.BOWL)));
	public static final DeferredItem<BlockItem> SALAD_FEAST_ITEM = ITEMS.register("salad_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SALAD.get(), new Item.Properties()));

	public static final DeferredItem<Item> ALFREDO_SAUCE = ITEMS.register("alfredo_sauce",
			() -> new Item(new Item.Properties().food(EDFoods.ALFREDO_SAUCE)));
	public static final DeferredItem<Item> PASTA_TOMATO = ITEMS.register("pasta_tomato",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.PASTA_TOMATO)));
	public static final DeferredItem<Item> PASTA_ALFREDO = ITEMS.register("pasta_alfredo",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.PASTA_ALFREDO)));
	public static final DeferredItem<Item> CHICKEN_ALFREDO = ITEMS.register("chicken_alfredo",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CHICKEN_ALFREDO)));
	public static final DeferredItem<Item> CHICKEN_PARM = ITEMS.register("chicken_parm",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CHICKEN_PARM)));

	public static final DeferredItem<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
			() -> new Item(new Item.Properties().food(EDFoods.CHEESEBURGER)));
	public static final DeferredItem<Item> BACON_CHEESEBURGER = ITEMS.register("bacon_cheeseburger",
			() -> new Item(new Item.Properties().food(EDFoods.BACON_CHEESEBURGER)));

	public static final DeferredItem<Item> RICEBALL = ITEMS.register("riceball",
			() -> new Item(new Item.Properties().food(EDFoods.RICEBALL)));
	public static final DeferredItem<Item> RICEBALL_FILLED = ITEMS.register("riceball_filled",
			() -> new Item(new Item.Properties().food(EDFoods.RICEBALL_FILLED)));

	public static final DeferredItem<Item> FISH_SALAD = ITEMS.register("fish_salad",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.FISH_SALAD)));
	public static final DeferredItem<Item> FISH_SALAD_SANDWICH = ITEMS.register("fish_salad_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_SALAD_SANDWICH)));

	public static final DeferredItem<Item> COOKED_PASTA = ITEMS.register("cooked_pasta",
			() -> new Item(new Item.Properties().food(Foods.BREAD).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> BUTTERED_PASTA = ITEMS.register("buttered_pasta",
			() -> new Item(new Item.Properties().food(EDFoods.BUTTERED_PASTA).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> BAD_FOOD = ITEMS.register("bad_food",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.BADFOOD)));

	public static final DeferredItem<Item> CACTUS = ITEMS.register("cactus",
			() -> new Item(new Item.Properties().food(EDFoods.CACTUS)));
	public static final DeferredItem<Item> COOKED_CACTUS = ITEMS.register("cooked_cactus",
			() -> new Item(new Item.Properties().food(EDFoods.COOKED_CACTUS)));
	public static final DeferredItem<Item> CACTUS_EGGS = ITEMS.register("cactus_eggs",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CACTUS_EGGS)));
	public static final DeferredItem<Item> CACTUS_SOUP = ITEMS.register("cactus_soup",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CACTUS_SOUP)));
	public static final DeferredItem<Item> CACTUS_SALAD = ITEMS.register("cactus_salad",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.CACTUS_SALAD)));
	public static final DeferredItem<Item> STUFFED_CACTUS = ITEMS.register("stuffed_cactus",
			() -> new Item(new Item.Properties().craftRemainder(Items.BOWL).food(EDFoods.STUFFED_CACTUS)));

	public static final DeferredItem<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.CORN_BOTTOM.get(), new Item.Properties()));

	public static final DeferredItem<Item> UNSHUCKED_CORN = ITEMS.register("unshucked_corn",
			() -> new ShuckableCorn(MiscLootTables.SHUCKED_CORN, new Item.Properties()));
	public static final DeferredItem<Item> CORN_ON_COB = ITEMS.register("corn_on_cob",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> CORN_HUSK = ITEMS.register("corn_husk",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DRIED_CORN_HUSK = ITEMS.register("dried_corn_husk",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final DeferredItem<Item> CORN_SILK = ITEMS.register("corn_silk",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final DeferredItem<Item> CORN_COB = ITEMS.register("corn_cob", () -> new Item(new Item.Properties()) {
		public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
			return 200;
		}
	});
	public static final DeferredItem<Item> CORN_MEAL = ITEMS.register("corn_meal",
			() -> new BlockItem(ExtraDelightBlocks.CORNMEAL.get(), new Item.Properties()));

	public static final DeferredItem<Item> CORN_CHOWDER = ITEMS.register("corn_chowder",
			() -> new Item(new Item.Properties().food(EDFoods.CORN_CHOWDER)));
	public static final DeferredItem<Item> CREAM_CORN = ITEMS.register("cream_corn",
			() -> new Item(new Item.Properties().food(EDFoods.CREAMED_CORN)));
	public static final DeferredItem<Item> CORN_FRITTERS = ITEMS.register("corn_fritters",
			() -> new Item(new Item.Properties().food(EDFoods.CORN_FRITTERS)));
	public static final DeferredItem<Item> POPCORN = ITEMS.register("popcorn",
			() -> new Item(new Item.Properties().food(EDFoods.COOKED_CORN)));
	public static final DeferredItem<Item> GRILLED_CORN_ON_COB = ITEMS.register("grilled_corn_on_cob",
			() -> new Item(new Item.Properties().food(EDFoods.GRILLED_CORN)));
	public static final DeferredItem<Item> COOKED_CORN = ITEMS.register("cooked_corn",
			() -> new Item(new Item.Properties().food(EDFoods.COOKED_CORN)));
	public static final DeferredItem<Item> ROASTED_PUMPKIN_SEEDS = ITEMS.register("roasted_pumpkin_seeds",
			() -> new Item(new Item.Properties().food(EDFoods.EDIBLE_SEEDS)));
	public static final DeferredItem<CornSilkTeaItem> TEA = ITEMS.register("tea",
			() -> new CornSilkTeaItem(new Item.Properties()));
	public static final DeferredItem<Item> STEWED_APPLES = ITEMS.register("stewed_apples",
			() -> new Item(new Item.Properties().food(EDFoods.STEWED_APPLES)));
	public static final DeferredItem<Item> APPLE_FRITTERS = ITEMS.register("apple_fritters",
			() -> new Item(new Item.Properties().food(EDFoods.APPLE_FRITTERS)));
	public static final DeferredItem<Item> CARAMEL_SAUCE = ITEMS.register("caramel_sauce",
			() -> new Item(new Item.Properties().food(EDFoods.CARAMEL_SAUCE)));
	public static final DeferredItem<Item> CARAMEL_CANDY = ITEMS.register("caramel_candy",
			() -> new Item(new Item.Properties().food(EDFoods.CARAMEL_CANDY)));
	public static final DeferredItem<Item> CANDY_APPLE = ITEMS.register("candy_apple",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY_APPLE)));
	public static final DeferredItem<Item> CARAMEL_APPLE = ITEMS.register("caramel_apple",
			() -> new Item(new Item.Properties().food(EDFoods.CARAMEL_APPLE)));
	public static final DeferredItem<Item> CANDY_GOLDEN_APPLE = ITEMS.register("candy_golden_apple",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY_GOLDEN_APPLE)));
	public static final DeferredItem<Item> CARAMEL_GOLDEN_APPLE = ITEMS.register("caramel_golden_apple",
			() -> new Item(new Item.Properties().food(EDFoods.CARAMEL_GOLDEN_APPLE)));
	public static final DeferredItem<Item> CARAMEL_POPCORN = ITEMS.register("caramel_popcorn",
			() -> new Item(new Item.Properties().food(EDFoods.CARAMEL_POPCORN)));
	public static final DeferredItem<Item> CARAMEL_CUSTARD = ITEMS.register("caramel_custard",
			() -> new Item(new Item.Properties().food(EDFoods.CUSTARD)));
	public static final DeferredItem<Item> CARAMEL_POPSICLE = ITEMS.register("caramel_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));

	public static final DeferredItem<Item> CARAMEL_CHEESECAKE_SLICE = ITEMS.register("caramel_cheescake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<BlockItem> CARAMEL_CHEESECAKE_ITEM = ITEMS.register("caramel_cheesecake_item",
			() -> new BlockItem(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), new Item.Properties()));

	public static final DeferredItem<Item> CORNBREAD = ITEMS.register("cornbread",
			() -> new Item(new Item.Properties().food(EDFoods.CORNBREAD)));
	public static final DeferredItem<BlockItem> CORNBREAD_FEAST = ITEMS.register("cornbread_feast",
			() -> new BlockItem(ExtraDelightBlocks.CORNBREAD.get(), new Item.Properties()));

	public static final DeferredItem<Item> CORN_PUDDING = ITEMS.register("corn_pudding",
			() -> new Item(new Item.Properties().food(EDFoods.CORN_PUDDING)));
	public static final DeferredItem<BlockItem> CORN_PUDDING_FEAST = ITEMS.register("corn_pudding_feast",
			() -> new BlockItem(ExtraDelightBlocks.CORN_PUDDING.get(), new Item.Properties()));

	public static final DeferredItem<Item> PUMPKIN_PIE_SLICE = ITEMS.register("pumpkin_pie_slice",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<BlockItem> PUMPKIN_PIE_ITEM = ITEMS.register("pumpkin_pie_item",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_PIE.get(), new Item.Properties()));

	public static final DeferredItem<Item> PUMPKIN_ROLL = ITEMS.register("pumpkin_roll",
			() -> new Item(new Item.Properties().food(FoodValues.PIE_SLICE)));
	public static final DeferredItem<BlockItem> PUMPKIN_ROLL_FEAST = ITEMS.register("pumpkin_roll_feast",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_ROLL.get(), new Item.Properties()));

	public static final DeferredItem<Item> APPLE_CRISP = ITEMS.register("apple_crisp",
			() -> new Item(new Item.Properties().food(EDFoods.APPLE_CRISP)));
	public static final DeferredItem<BlockItem> APPLE_CRISP_FEAST = ITEMS.register("apple_crisp_feast",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CRISP.get(), new Item.Properties()));

	public static final DeferredItem<Item> STUFFING = ITEMS.register("stuffing",
			() -> new Item(new Item.Properties().food(EDFoods.STUFFING)));
	public static final DeferredItem<BlockItem> STUFFING_FEAST = ITEMS.register("stuffing_feast",
			() -> new BlockItem(ExtraDelightBlocks.STUFFING.get(), new Item.Properties()));

	public static final DeferredItem<Item> POTATO_AU_GRATIN = ITEMS.register("potato_au_gratin",
			() -> new Item(new Item.Properties().food(EDFoods.POTATOES_AU_GRATIN)));
	public static final DeferredItem<BlockItem> POTATO_AU_GRATIN_FEAST = ITEMS.register("potato_au_gratin_feast",
			() -> new BlockItem(ExtraDelightBlocks.POTATO_AU_GRATIN.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> FLOUR_SACK = ITEMS.register("flour_sack",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR_SACK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CORNMEAL_SACK = ITEMS.register("cornmeal_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORNMEAL_SACK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SUGAR_SACK = ITEMS.register("sugar_sack",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_SACK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CORN_CRATE = ITEMS.register("corn_crate",
			() -> new BlockItem(ExtraDelightBlocks.CORN_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CORN_HUSK_BUNDLE = ITEMS.register("corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DRIED_CORN_HUSK_BUNDLE = ITEMS.register("dried_corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CORN_COB_BUNDLE = ITEMS.register("corn_cob_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_COB_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BREADCRUMB_SACK = ITEMS.register("breadcrumb_sack",
			() -> new BlockItem(ExtraDelightBlocks.BREADCRUMB_SACK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> EGG_CRATE = ITEMS.register("egg_crate",
			() -> new BlockItem(ExtraDelightBlocks.EGG_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> APPLE_CRATE = ITEMS.register("apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GOLDEN_APPLE_CRATE = ITEMS.register("golden_apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BROWN_MUSHROOM_CRATE = ITEMS.register("brown_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> RED_MUSHROOM_CRATE = ITEMS.register("red_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.RED_MUSHROOM_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SWEET_BERRY_CRATE = ITEMS.register("sweet_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GLOW_BERRY_CRATE = ITEMS.register("glow_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CORN_SILK_SACK = ITEMS.register("corn_silk_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORN_SILK_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> CORN_COB_PIPE = ITEMS.register("corn_cob_pipe",
			() -> new CorncobPipe(EDArmorMaterial.CORN_COB, new Item.Properties()));

	// Winter start!
	public static final DeferredItem<BlockItem> CINNAMON_LOG = ITEMS.register("cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> STRIPPED_CINNAMON_LOG = ITEMS.register("stripped_cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_PLANKS = ITEMS.register("cinnamon_planks",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_PLANKS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_LEAVES = ITEMS.register("cinnamon_leaves",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LEAVES.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CINNAMON_FENCE = ITEMS.register("cinnamon_fence",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_FENCE_GATE = ITEMS.register("cinnamon_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_STAIRS = ITEMS.register("cinnamon_stairs",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STAIRS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<DoubleHighBlockItem> CINNAMON_DOOR = ITEMS.register("cinnamon_door",
			() -> new DoubleHighBlockItem(ExtraDelightBlocks.CINNAMON_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CINNAMON_TRAPDOOR = ITEMS.register("cinnamon_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_CABINET = ITEMS.register("cinnamon_cabinet",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_CABINET.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_SLAB = ITEMS.register("cinnamon_slab",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SLAB.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 150;
				}
			});
	public static final DeferredItem<Item> RAW_CINNAMON = ITEMS.register("raw_cinnamon",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final DeferredItem<BlockItem> RAW_CINNAMON_BLOCK = ITEMS.register("raw_cinnamon_block",
			() -> new BlockItem(ExtraDelightBlocks.RAW_CINNAMON_BLOCK.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 900;
				}
			});
	public static final DeferredItem<Item> CINNAMON_STICK = ITEMS.register("cinnamon_stick",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final DeferredItem<BlockItem> CINNAMON_STICK_BLOCK = ITEMS.register("cinnamon_stick_block",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 900;
				}
			});
	public static final DeferredItem<Item> GROUND_CINNAMON = ITEMS.register("ground_cinnamon",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<BlockItem> GROUND_CINNAMON_BLOCK_ITEM = ITEMS.register("ground_cinnamon_block",
			() -> new BlockItem(ExtraDelightBlocks.GROUND_CINNAMON_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> ICE_CREAM = ITEMS.register("ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<GlowberryFoodItem> GLOW_BERRY_ICE_CREAM = ITEMS.register("glow_berry_ice_cream",
			() -> new GlowberryFoodItem(
					new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> SWEET_BERRY_ICE_CREAM = ITEMS.register("sweet_berry_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> PUMPKIN_ICE_CREAM = ITEMS.register("pumpkin_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> HONEY_ICE_CREAM = ITEMS.register("honey_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> APPLE_ICE_CREAM = ITEMS.register("apple_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> COOKIE_DOUGH_ICE_CREAM = ITEMS.register("cookie_dough_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final DeferredItem<Item> MINT_CHIP_ICE_CREAM = ITEMS.register("mint_chip_ice_cream",
			() -> new Item(new Item.Properties().food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));

	public static final DeferredItem<MilkshakeDrinkItem> MILKSHAKE = ITEMS.register("milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 2f));
	public static final DeferredItem<MilkshakeDrinkItem> CHOCOLATE_MILKSHAKE = ITEMS.register("chocolate_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> GLOW_BERRY_MILKSHAKE = ITEMS.register("glow_berry_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> SWEET_BERRY_MILKSHAKE = ITEMS.register("sweet_berry_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> PUMPKIN_MILKSHAKE = ITEMS.register("pumpkin_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> HONEY_MILKSHAKE = ITEMS.register("honey_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> APPLE_MILKSHAKE = ITEMS.register("apple_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> COOKIE_DOUGH_MILKSHAKE = ITEMS.register(
			"cookie_dough_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final DeferredItem<MilkshakeDrinkItem> MINT_CHIP_MILKSHAKE = ITEMS.register("mint_chip_milkshake",
			() -> new MilkshakeDrinkItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE), 4f));

	public static final DeferredItem<HotCocoaItem> CHOCOLATE_MILK = ITEMS.register("chocolate_milk",
			() -> new HotCocoaItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

	public static final DeferredItem<HotCocoaItem> EGGNOG = ITEMS.register("eggnog",
			() -> new HotCocoaItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<MelonJuiceItem> GINGER_BEER = ITEMS.register("ginger_beer",
			() -> new MelonJuiceItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final DeferredItem<HotCocoaItem> HORCHATA = ITEMS.register("horchata",
			() -> new HotCocoaItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

	public static final DeferredItem<Item> GINGERBREAD_COOKIE_DOUGH = ITEMS.register("gingerbread_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> SUGAR_COOKIE_DOUGH = ITEMS.register("sugar_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> PUMPKIN_COOKIE_DOUGH = ITEMS.register("pumpkin_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> GLOW_BERRY_COOKIE_DOUGH = ITEMS.register("glow_berry_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> APPLE_COOKIE_DOUGH = ITEMS.register("apple_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> SWEET_BERRY_COOKIE_DOUGH = ITEMS.register("sweet_berry_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> HONEY_COOKIE_DOUGH = ITEMS.register("honey_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> CHOCOLATE_CHIP_COOKIE_DOUGH = ITEMS.register("chocolate_chip_cookie_dough",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));

	public static final DeferredItem<Item> GINGERBREAD_COOKIE = ITEMS.register("gingerbread_cookie",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));

	public static final DeferredItem<Item> GINGERBREAD_STEVE = ITEMS.register("gingerbread_steve",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_ALEX = ITEMS.register("gingerbread_alex",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_VILLAGER = ITEMS.register("gingerbread_villager",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_CREEPER = ITEMS.register("gingerbread_creeper",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_SWORD = ITEMS.register("gingerbread_sword",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_PICKAXE = ITEMS.register("gingerbread_pickaxe",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_DIAMOND = ITEMS.register("gingerbread_diamond",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> GINGERBREAD_EMERALD = ITEMS.register("gingerbread_emerald",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));

	public static final DeferredItem<Item> SUGAR_COOKIE_STEVE = ITEMS.register("sugar_cookie_steve",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_ALEX = ITEMS.register("sugar_cookie_alex",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_VILLAGER = ITEMS.register("sugar_cookie_villager",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_CREEPER = ITEMS.register("sugar_cookie_creeper",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_SWORD = ITEMS.register("sugar_cookie_sword",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_PICKAXE = ITEMS.register("sugar_cookie_pickaxe",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_DIAMOND = ITEMS.register("sugar_cookie_diamond",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));
	public static final DeferredItem<Item> SUGAR_COOKIE_EMERALD = ITEMS.register("sugar_cookie_emerald",
			() -> new Item(new Item.Properties().food(FoodValues.COOKIES)));

	public static final DeferredItem<Item> RAW_GINGERBREAD_STEVE = ITEMS.register("raw_gingerbread_steve",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_ALEX = ITEMS.register("raw_gingerbread_alex",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_VILLAGER = ITEMS.register("raw_gingerbread_villager",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_CREEPER = ITEMS.register("raw_gingerbread_creeper",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_SWORD = ITEMS.register("raw_gingerbread_sword",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_PICKAXE = ITEMS.register("raw_gingerbread_pickaxe",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_DIAMOND = ITEMS.register("raw_gingerbread_diamond",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_EMERALD = ITEMS.register("raw_gingerbread_emerald",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));

	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_STEVE = ITEMS.register("raw_sugar_cookie_steve",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_ALEX = ITEMS.register("raw_sugar_cookie_alex",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_VILLAGER = ITEMS.register("raw_sugar_cookie_villager",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_CREEPER = ITEMS.register("raw_sugar_cookie_creeper",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_SWORD = ITEMS.register("raw_sugar_cookie_sword",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_PICKAXE = ITEMS.register("raw_sugar_cookie_pickaxe",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_DIAMOND = ITEMS.register("raw_sugar_cookie_diamond",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_EMERALD = ITEMS.register("raw_sugar_cookie_emerald",
			() -> new Item(new Item.Properties().food(EDFoods.COOKIE_DOUGH)));

	public static final DeferredItem<BlockItem> APPLE_COOKIE_BLOCK = ITEMS.register("apple_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHOCOLATE_CHIP_COOKIE_BLOCK = ITEMS.register(
			"chocolate_chip_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_COOKIE_BLOCK = ITEMS.register(
			"gingerbread_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GLOW_BERRY_COOKIE_BLOCK = ITEMS.register("glow_berry_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> HONEY_COOKIE_BLOCK = ITEMS.register("honey_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> PUMPKIN_COOKIE_BLOCK = ITEMS.register("pumpkin_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SUGAR_COOKIE_BLOCK = ITEMS.register("sugar_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> SWEET_BERRY_COOKIE_BLOCK = ITEMS.register(
			"sweet_berry_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> GINGER = ITEMS.register("ginger",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));
	public static final DeferredItem<Item> GINGER_CUTTING = ITEMS.register("ginger_cutting",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.GINGER_CROP.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WILD_GINGER = ITEMS.register("wild_ginger",
			() -> new BlockItem(ExtraDelightBlocks.WILD_GINGER.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGER_CRATE = ITEMS.register("ginger_crate",
			() -> new BlockItem(ExtraDelightBlocks.GINGER_CRATE.get(), new Item.Properties()));

	public static final DeferredItem<Item> MINT = ITEMS.register("mint",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.MINT_CROP.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MINT_SACK = ITEMS.register("mint_sack",
			() -> new BlockItem(ExtraDelightBlocks.MINT_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> PEELED_GINGER = ITEMS.register("peeled_ginger",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));
	public static final DeferredItem<Item> SLICED_GINGER = ITEMS.register("sliced_ginger",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));
	public static final DeferredItem<Item> GRATED_GINGER = ITEMS.register("grated_ginger",
			() -> new Item(new Item.Properties().food(Foods.POTATO)));

	public static final DeferredItem<Item> FROSTING_WHITE = ITEMS.register("frosting_white",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_LIGHT_GRAY = ITEMS.register("frosting_light_gray",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_GRAY = ITEMS.register("frosting_gray",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_BLACK = ITEMS.register("frosting_black",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_BROWN = ITEMS.register("frosting_brown",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_RED = ITEMS.register("frosting_red",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_ORANGE = ITEMS.register("frosting_orange",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_YELLOW = ITEMS.register("frosting_yellow",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_LIME = ITEMS.register("frosting_lime",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_GREEN = ITEMS.register("frosting_green",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_CYAN = ITEMS.register("frosting_cyan",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_LIGHT_BLUE = ITEMS.register("frosting_light_blue",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_BLUE = ITEMS.register("frosting_blue",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_PURPLE = ITEMS.register("frosting_purple",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_MAGENTA = ITEMS.register("frosting_magenta",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));
	public static final DeferredItem<Item> FROSTING_PINK = ITEMS.register("frosting_pink",
			() -> new FrostingItem(new Item.Properties().food(EDFoods.FROSTING)));

	public static final DeferredItem<Item> CANDY_WHITE = ITEMS.register("candy_white",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_LIGHT_GRAY = ITEMS.register("candy_light_gray",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_GRAY = ITEMS.register("candy_gray",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_BLACK = ITEMS.register("candy_black",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_BROWN = ITEMS.register("candy_brown",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_RED = ITEMS.register("candy_red",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_ORANGE = ITEMS.register("candy_orange",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_YELLOW = ITEMS.register("candy_yellow",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_LIME = ITEMS.register("candy_lime",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_GREEN = ITEMS.register("candy_green",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_CYAN = ITEMS.register("candy_cyan",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_LIGHT_BLUE = ITEMS.register("candy_light_blue",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_BLUE = ITEMS.register("candy_blue",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_PURPLE = ITEMS.register("candy_purple",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_MAGENTA = ITEMS.register("candy_magenta",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));
	public static final DeferredItem<Item> CANDY_PINK = ITEMS.register("candy_pink",
			() -> new Item(new Item.Properties().food(EDFoods.CANDY)));

	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_WHITE = ITEMS.register("gingerbread_block_white",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_LIGHT_GRAY = ITEMS.register(
			"gingerbread_block_light_gray",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_GRAY = ITEMS.register("gingerbread_block_gray",
			() -> new BlockItem(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_BLACK = ITEMS.register("gingerbread_block_black",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_BROWN = ITEMS.register("gingerbread_block_brown",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_RED = ITEMS.register("gingerbread_block_red",
			() -> new BlockItem(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_ORANGE = ITEMS.register("gingerbread_block_orange",
			() -> new BlockItem(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_YELLOW = ITEMS.register("gingerbread_block_yellow",
			() -> new BlockItem(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_LIME = ITEMS.register("gingerbread_block_lime",
			() -> new BlockItem(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_GREEN = ITEMS.register("gingerbread_block_green",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_CYAN = ITEMS.register("gingerbread_block_cyan",
			() -> new BlockItem(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_LIGHT_BLUE = ITEMS.register(
			"gingerbread_block_light_blue",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_BLUE = ITEMS.register("gingerbread_block_blue",
			() -> new BlockItem(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_PURPLE = ITEMS.register("gingerbread_block_purple",
			() -> new BlockItem(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_MAGENTA = ITEMS.register("gingerbread_block_magenta",
			() -> new BlockItem(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> GINGERBREAD_BLOCK_PINK = ITEMS.register("gingerbread_block_pink",
			() -> new BlockItem(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> CANDY_BOWL_ITEM = ITEMS.register("candy_bowl_item",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_BOWL.get(), new Item.Properties()));

	public static final DeferredItem<Item> MINT_CANDY_RED = ITEMS.register("mint_candy_red",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));
	public static final DeferredItem<Item> MINT_CANDY_GREEN = ITEMS.register("mint_candy_green",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));
	public static final DeferredItem<Item> MINT_CANDY_BLUE = ITEMS.register("mint_candy_blue",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));

	public static final DeferredItem<Item> CANDY_CANE_RED = ITEMS.register("candy_cane_red",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));
	public static final DeferredItem<Item> CANDY_CANE_GREEN = ITEMS.register("candy_cane_green",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));
	public static final DeferredItem<Item> CANDY_CANE_BLUE = ITEMS.register("candy_cane_blue",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));

	public static final DeferredItem<BlockItem> CANDY_CANE_RED_BLOCK = ITEMS.register("candy_cane_red_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CANDY_CANE_GREEN_BLOCK = ITEMS.register("candy_cane_green_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CANDY_CANE_BLUE_BLOCK = ITEMS.register("candy_cane_blue_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> FRENCH_TOAST = ITEMS.register("french_toast",
			() -> new Item(new Item.Properties().food(EDFoods.FRENCH_TOAST)));
	public static final DeferredItem<Item> CONGEE = ITEMS.register("congee",
			() -> new Item(new Item.Properties().food(EDFoods.CONGEE)));
	public static final DeferredItem<Item> LUGAW = ITEMS.register("lugaw",
			() -> new Item(new Item.Properties().food(EDFoods.LUGAW)));
	public static final DeferredItem<Item> RICE_PUDDING = ITEMS.register("rice_pudding",
			() -> new Item(new Item.Properties().food(FoodValues.GLOW_BERRY_CUSTARD)));

	public static final DeferredItem<Item> MUFFIN_GINGER = ITEMS.register("muffin_ginger",
			() -> new Item(new Item.Properties().food(EDFoods.MUFFIN)));
	public static final DeferredItem<Item> MUFFIN_CINNAMON = ITEMS.register("muffin_cinnamon",
			() -> new Item(new Item.Properties().food(EDFoods.MUFFIN)));
	public static final DeferredItem<Item> MUFFIN_SWEET_BERRY = ITEMS.register("muffin_sweet_berry",
			() -> new Item(new Item.Properties().food(EDFoods.MUFFIN)));
	public static final DeferredItem<Item> MUFFIN_APPLE = ITEMS.register("muffin_apple",
			() -> new Item(new Item.Properties().food(EDFoods.MUFFIN)));

	public static final DeferredItem<Item> DRIED_FRUIT = ITEMS.register("dried_fruit",
			() -> new Item(new Item.Properties().food(Foods.APPLE)));
	public static final DeferredItem<Item> FRUIT_BREAD = ITEMS.register("fruit_bread",
			() -> new Item(new Item.Properties().food(EDFoods.FILLED_BREAD)));
	public static final DeferredItem<Item> PICKLED_GINGER = ITEMS.register("pickled_ginger",
			() -> new Item(new Item.Properties().food(EDFoods.PICKLED_GINGER)));
	public static final DeferredItem<Item> CANDIED_GINGER = ITEMS.register("candied_ginger",
			() -> new Item(new Item.Properties().food(EDFoods.SUGAR)));
	public static final DeferredItem<Item> CINNAMON_POPSICLE = ITEMS.register("cinnamon_popsicle",
			() -> new Item(new Item.Properties().food(FoodValues.POPSICLE)));
	public static final DeferredItem<Item> BEET_MINT_SALAD = ITEMS.register("beet_mint_salad",
			() -> new Item(new Item.Properties().food(EDFoods.BEET_MINT)));
	public static final DeferredItem<Item> MINT_JELLY = ITEMS.register("mint_jelly",
			() -> new Item(new Item.Properties().food(EDFoods.JAM)));
	public static final DeferredItem<Item> CRACKERS = ITEMS.register("crackers",
			() -> new Item(new Item.Properties().food(EDFoods.CRACKER)));
	public static final DeferredItem<Item> CROQUE_MONSIEUR = ITEMS.register("croque_monsieur",
			() -> new Item(new Item.Properties().food(EDFoods.CROQUE_MONSIEUR)));
	public static final DeferredItem<Item> CROQUE_MADAME = ITEMS.register("croque_madame",
			() -> new Item(new Item.Properties().food(EDFoods.CROQUE_MADAME)));
	public static final DeferredItem<Item> ROLL = ITEMS.register("roll",
			() -> new Item(new Item.Properties().food(EDFoods.ROLL)));

	public static final DeferredItem<Item> CINNAMON_ROLL = ITEMS.register("cinnamon_rolls",
			() -> new Item(new Item.Properties().food(EDFoods.CINNAMON_ROLL)));
	public static final DeferredItem<BlockItem> CINNAMON_ROLLS_FEAST = ITEMS.register("cinnamon_rolls_feast",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_ROLLS.get(), new Item.Properties()));

	public static final DeferredItem<Item> MONKEY_BREAD = ITEMS.register("monkey_bread",
			() -> new Item(new Item.Properties().food(EDFoods.MONKEY_BREAD)));
	public static final DeferredItem<BlockItem> MONKEY_BREAD_FEAST = ITEMS.register("monkey_bread_feast",
			() -> new BlockItem(ExtraDelightBlocks.MONKEY_BREAD.get(), new Item.Properties()));

	public static final DeferredItem<Item> COFFEE_CAKE_SLICE = ITEMS.register("coffee_cake_slice",
			() -> new Item(new Item.Properties().food(FoodValues.CAKE_SLICE)));
	public static final DeferredItem<BlockItem> COFFEE_CAKE_FEAST = ITEMS.register("coffe_cake_feast",
			() -> new BlockItem(ExtraDelightBlocks.COFFEE_CAKE.get(), new Item.Properties()));

	public static final DeferredItem<Item> MINT_LAMB = ITEMS.register("mint_lamb",
			() -> new Item(new Item.Properties().food(EDFoods.MINT_LAMB)));
	public static final DeferredItem<BlockItem> MINT_LAMB_FEAST = ITEMS.register("mint_lamb_feast",
			() -> new BlockItem(ExtraDelightBlocks.MINT_LAMB.get(), new Item.Properties()));

	public static final DeferredItem<Item> CHARCUTERIE_BOARD = ITEMS.register("charcuterie_board",
			() -> new Item(new Item.Properties().food(EDFoods.CHARCUTERIE)));
	public static final DeferredItem<BlockItem> CHARCUTERIE_BOARD_FEAST = ITEMS.register("charcuterie_board_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), new Item.Properties()));

	public static final DeferredItem<Item> CHRISTMAS_PUDDING = ITEMS.register("christmas_pudding",
			() -> new Item(new Item.Properties().food(EDFoods.CHRISTMAS_PUDDING)));
	public static final DeferredItem<BlockItem> CHRISTMAS_PUDDING_FEAST = ITEMS.register("christmas_pudding_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), new Item.Properties()));

	public static final DeferredItem<MelonJuiceItem> PUNCH = ITEMS.register("punch",
			() -> new MelonJuiceItem(new Item.Properties()));
	public static final DeferredItem<BlockItem> PUNCH_FEAST = ITEMS.register("punch_feast",
			() -> new BlockItem(ExtraDelightBlocks.PUNCH.get(), new Item.Properties()));

	public static final DeferredItem<Item> MILK_TART_SLICE = ITEMS.register("milk_tart_slice",
			() -> new Item(new Item.Properties().food(EDFoods.MILK_TART)));
	public static final DeferredItem<BlockItem> MILK_TART_FEAST = ITEMS.register("milk_tart_feast",
			() -> new BlockItem(ExtraDelightBlocks.MILK_TART.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> CINNAMON_SAPLING = ITEMS.register("cinnamon_sapling",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SAPLING.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> TAP = ITEMS.register("tap",
			() -> new BlockItem(ExtraDelightBlocks.TAP.get(), new Item.Properties()));

	// Fluids
	public static final DeferredItem<Item> OIL_FLUID_BUCKET = ITEMS.register("oil_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.OIL.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> VINEGAR_FLUID_BUCKET = ITEMS.register("vinegar_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.VINEGAR.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> GRAVY_FLUID_BUCKET = ITEMS.register("gravy_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.GRAVY.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> GLOW_BERRY_JUICE_FLUID_BUCKET = ITEMS.register("glow_berry_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.GLOW_BERRY_JUICE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> SWEET_BERRY_JUICE_FLUID_BUCKET = ITEMS.register("sweet_berry_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.SWEET_BERRY_JUICE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> TOMATO_JUICE_FLUID_BUCKET = ITEMS.register("tomato_juice_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.TOMATO_JUICE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> CACTUS_JUICE_FLUID_BUCKET = ITEMS.register("cactus_juice_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.CACTUS_JUICE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> APPLE_CIDER_FLUID_BUCKET = ITEMS.register("apple_cider_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.APPLE_CIDER.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> HOT_COCOA_FLUID_BUCKET = ITEMS.register("hot_cocoa_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.HOT_COCOA.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> MELON_JUICE_FLUID_BUCKET = ITEMS.register("melon_juice_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.MELON_JUICE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> EGG_MIX_FLUID_BUCKET = ITEMS.register("egg_mix_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.EGG_MIX.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> BBQ_FLUID_BUCKET = ITEMS.register("bbq_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.BBQ.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> KETCHUP_FLUID_BUCKET = ITEMS.register("ketchup_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.KETCHUP.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> MAYO_FLUID_BUCKET = ITEMS.register("mayo_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.MAYO.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> BROTH_FLUID_BUCKET = ITEMS.register("broth_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.BROTH.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> CARAMEL_SAUCE_FLUID_BUCKET = ITEMS.register("caramel_sauce_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.CARAMEL_SAUCE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> MILKSHAKE_FLUID_BUCKET = ITEMS.register("milkshake_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.MILKSHAKE.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> WHIPPED_CREAM_FLUID_BUCKET = ITEMS.register("whipped_cream_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.WHIPPED_CREAM.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> JAM_FLUID_BUCKET = ITEMS.register("jam_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.JAM.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> GOLDEN_JAM_FLUID_BUCKET = ITEMS.register("golden_jam_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.GOLDEN_JAM.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> GLOW_JAM_FLUID_BUCKET = ITEMS.register("glow_jam_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.GLOW_JAM.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<Item> TEA_FLUID_BUCKET = ITEMS.register("tea_fluid_bucket",
			() -> new BucketItem(ExtraDelightFluids.TEA.FLUID.get(),
					new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

	public static final DeferredItem<BlockItem> KEG = ITEMS.register("keg_item",
			() -> new BlockItem(ExtraDelightBlocks.KEG.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> FRUIT_LOG = ITEMS.register("fruit_log",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> STRIPPED_FRUIT_LOG = ITEMS.register("stripped_fruit_log",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<DoubleHighBlockItem> FRUIT_DOOR = ITEMS.register("fruit_door",
			() -> new DoubleHighBlockItem(ExtraDelightBlocks.FRUIT_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> FRUIT_PLANKS = ITEMS.register("fruit_planks",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_PLANKS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_FENCE = ITEMS.register("fruit_fence",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_FENCE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_FENCE_GATE = ITEMS.register("fruit_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_FENCE_GATE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_STAIRS = ITEMS.register("fruit_stairs",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_STAIRS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_TRAPDOOR = ITEMS.register("fruit_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_TRAPDOOR.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_CABINET = ITEMS.register("fruit_cabinet",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_CABINET.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<BlockItem> FRUIT_SLAB = ITEMS.register("fruit_slab",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_SLAB.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<BlockItem> HAZELNUT_LEAVES = ITEMS.register("hazelnut_leaves",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), new Item.Properties()));

	public static final DeferredItem<Item> CHILI_SEEDS = ITEMS.register("chili_seeds",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.CHILI_CROP.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHILI = ITEMS.register("chili", () -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> JAR = ITEMS.register("jar", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> MELTING_POT = ITEMS.register("melting_pot",
			() -> new BlockItem(ExtraDelightBlocks.MELTING_POT.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> CHILLER = ITEMS.register("chiller",
			() -> new BlockItem(ExtraDelightBlocks.CHILLER.get(), new Item.Properties()));

	public static final DeferredItem<Item> BAR_MOLD = ITEMS.register("bar_mold", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> FUNNEL = ITEMS.register("funnel",
			() -> new BlockItem(ExtraDelightBlocks.FUNNEL.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_BOX = ITEMS.register("white_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> ORANGE_CHOCOLATE_BOX = ITEMS.register("orange_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> MAGENTA_CHOCOLATE_BOX = ITEMS.register("magenta_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> LIGHT_BLUE_CHOCOLATE_BOX = ITEMS.register("light_blue_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> YELLOW_CHOCOLATE_BOX = ITEMS.register("yellow_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> LIME_CHOCOLATE_BOX = ITEMS.register("lime_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> PINK_CHOCOLATE_BOX = ITEMS.register("pink_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> GRAY_CHOCOLATE_BOX = ITEMS.register("gray_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> LIGHT_GRAY_CHOCOLATE_BOX = ITEMS.register("light_gray_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> CYAN_CHOCOLATE_BOX = ITEMS.register("cyan_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> BLUE_CHOCOLATE_BOX = ITEMS.register("blue_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> BROWN_CHOCOLATE_BOX = ITEMS.register("brown_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> GREEN_CHOCOLATE_BOX = ITEMS.register("green_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> RED_CHOCOLATE_BOX = ITEMS.register("red_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> BLACK_CHOCOLATE_BOX = ITEMS.register("black_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<BlockItem> PURPLE_CHOCOLATE_BOX = ITEMS.register("purple_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get(), new Item.Properties().stacksTo(1)
					.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_BLOCK = ITEMS.register("milk_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_FENCE = ITEMS.register("milk_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_FENCE_GATE = ITEMS.register("milk_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_STAIRS = ITEMS.register("milk_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_DOOR = ITEMS.register("milk_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_TRAPDOOR = ITEMS.register("milk_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_SLAB = ITEMS.register("milk_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_PILLAR = ITEMS.register("milk_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_BLOCK = ITEMS.register("dark_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_FENCE = ITEMS.register("dark_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_FENCE_GATE = ITEMS.register("dark_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_STAIRS = ITEMS.register("dark_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_DOOR = ITEMS.register("dark_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_TRAPDOOR = ITEMS.register("dark_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_SLAB = ITEMS.register("dark_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_PILLAR = ITEMS.register("dark_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_BLOCK = ITEMS.register("white_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_FENCE = ITEMS.register("white_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_FENCE_GATE = ITEMS.register(
			"white_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_STAIRS = ITEMS.register("white_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_DOOR = ITEMS.register("white_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_TRAPDOOR = ITEMS.register("white_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_SLAB = ITEMS.register("white_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_PILLAR = ITEMS.register("white_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_BLOCK = ITEMS.register("blood_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_FENCE = ITEMS.register("blood_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_FENCE_GATE = ITEMS.register(
			"blood_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_STAIRS = ITEMS.register("blood_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_DOOR = ITEMS.register("blood_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_TRAPDOOR = ITEMS.register("blood_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_SLAB = ITEMS.register("blood_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_PILLAR = ITEMS.register("blood_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<Item> ROASTED_COCOA_BEANS = ITEMS.register("roasted_cocoa_beans",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> COCOA_SOLIDS = ITEMS.register("cocoa_solids",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_BAR = ITEMS.register("white_chocolate_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_BAR = ITEMS.register("milk_chocolate_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_BAR = ITEMS.register("dark_chocolate_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_BAR = ITEMS.register("blood_chocolate_bar",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_CHIPS = ITEMS.register("white_chocolate_chips",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_CHIPS = ITEMS.register("milk_chocolate_chips",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_CHIPS = ITEMS.register("dark_chocolate_chips",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_CHIPS = ITEMS.register("blood_chocolate_chips",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_FILLED_BAR = ITEMS.register("white_chocolate_filled_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_FILLED_BAR = ITEMS.register("milk_chocolate_filled_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_FILLED_BAR = ITEMS.register("dark_chocolate_filled_bar",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_FILLED_BAR = ITEMS.register("blood_chocolate_filled_bar",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_TRUFFLE = ITEMS.register("white_chocolate_truffle",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_TRUFFLE = ITEMS.register("milk_chocolate_truffle",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_TRUFFLE = ITEMS.register("dark_chocolate_truffle",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_TRUFFLE = ITEMS.register("blood_chocolate_truffle",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> CHILI_POWDER = ITEMS.register("chili_powder",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PEANUT_BUTTER_CUP = ITEMS.register("peanut_butter_cup",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MALLOW_CUP = ITEMS.register("mallow_cup",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> XOCOLATL = ITEMS.register("xocolati", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> GOURMET_HOT_CHOCOLATE = ITEMS.register("gourmet_hot_chocolate",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> LAVA_CAKE = ITEMS.register("lava_cake",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> COFFEE_JELLY = ITEMS.register("coffee_jelly",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> TOFFEE = ITEMS.register("toffee", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> GRAHAM_CRACKER = ITEMS.register("graham_cracker",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PEPPERMINT_BARK = ITEMS.register("peppermint_bark",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DIRT_CAKE = ITEMS.register("dirt_cake",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> EASTER_EGG = ITEMS.register("easter_egg",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> TRAIL_MIX = ITEMS.register("trail_mix",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> NOUGAT = ITEMS.register("nougat", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> GUMMIES = ITEMS.register("gummies", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PEANUT_BRITTLE = ITEMS.register("peanut_brittle",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BUTTERSCOTCH = ITEMS.register("butterscotch",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> FLUFFER_NUTTER = ITEMS.register("fluffer_nutter",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> GREEN_COFFEE = ITEMS.register("green_coffee",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> COFFEE_CHERRIES = ITEMS.register("coffee_cherries",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> COFFEE = ITEMS.register("coffee", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> BROWNIES_BLOCK = ITEMS.register("brownies_block",
			() -> new BlockItem(ExtraDelightBlocks.BROWNIES.get(), new Item.Properties()));
	public static final DeferredItem<Item> BROWNIE = ITEMS.register("brownie", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> BLONDIES_BLOCK = ITEMS.register("blondies_block",
			() -> new BlockItem(ExtraDelightBlocks.BLONDIES.get(), new Item.Properties()));
	public static final DeferredItem<Item> BLONDIE = ITEMS.register("blondies", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> CHOCOLATE_CAKE_BLOCK = ITEMS.register("chocolate_cake_block",
			() -> new BlockItem(ExtraDelightBlocks.BLONDIES.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> FUDGE_BLOCK = ITEMS.register("fudge_block",
			() -> new BlockItem(ExtraDelightBlocks.BLONDIES.get(), new Item.Properties()));
	public static final DeferredItem<Item> FUDGE_SLICE = ITEMS.register("fudge", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> STICKY_TOFFEE_PUDDING_BLOCK = ITEMS.register(
			"sticky_toffee_pudding_block",
			() -> new BlockItem(ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get(), new Item.Properties()));
	public static final DeferredItem<Item> STICKY_TOFFEE_PUDDING_SLICE = ITEMS.register("sticky_toffee_pudding_slice",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> CRISP_RICE_TREATS_BLOCK = ITEMS.register("crisp_rice_treats_block",
			() -> new BlockItem(ExtraDelightBlocks.CRISP_RICE_TREATS.get(), new Item.Properties()));
	public static final DeferredItem<Item> CRISP_RICE_TREAT = ITEMS.register("crisp_rice_treat",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> SCOTCHAROO_BLOCK = ITEMS.register("scotcharoo_block",
			() -> new BlockItem(ExtraDelightBlocks.SCOTCHAROOS.get(), new Item.Properties()));
	public static final DeferredItem<Item> SCOTCHAROO = ITEMS.register("scotcharoo",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> BLACK_FOREST_TRIFLE_BLOCK = ITEMS.register("black_forest_trifle_block",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get(), new Item.Properties()));
	public static final DeferredItem<Item> BLACK_FOREST_TRIFLE = ITEMS.register("black_forest_trifle",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> BLOOD_CHOCOLATE_FONDUE_BLOCK = ITEMS.register(
			"blood_chocolate_fondue_block",
			() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY = ITEMS
			.register("blood_chocolate_dipped_sweet_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY = ITEMS
			.register("blood_chocolate_dipped_glow_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE = ITEMS
			.register("blood_chocolate_dipped_apple_slice", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW = ITEMS
			.register("blood_chocolate_dipped_marshmallow", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ITEMS
			.register("blood_chocolate_dipped_graham_cracker", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_BACON = ITEMS.register("blood_chocolate_dipped_bacon",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN = ITEMS
			.register("blood_chocolate_dipped_coffee_bean", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> DARK_CHOCOLATE_FONDUE_BLOCK = ITEMS.register(
			"dark_chocolate_fondue_block",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_SWEET_BERRY = ITEMS
			.register("dark_chocolate_dipped_sweet_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_GLOW_BERRY = ITEMS
			.register("dark_chocolate_dipped_glow_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_APPLE_SLICE = ITEMS
			.register("dark_chocolate_dipped_apple_slice", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_MARSHMALLOW = ITEMS
			.register("dark_chocolate_dipped_marshmallow", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ITEMS
			.register("dark_chocolate_dipped_graham_cracker", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_BACON = ITEMS.register("dark_chocolate_dipped_bacon",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_COFFEE_BEAN = ITEMS
			.register("dark_chocolate_dipped_coffee_bean", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> MILK_CHOCOLATE_FONDUE_BLOCK = ITEMS.register(
			"milk_chocolate_fondue_block",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_SWEET_BERRY = ITEMS
			.register("milk_chocolate_dipped_sweet_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_GLOW_BERRY = ITEMS
			.register("milk_chocolate_dipped_glow_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_APPLE_SLICE = ITEMS
			.register("milk_chocolate_dipped_apple_slice", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_MARSHMALLOW = ITEMS
			.register("milk_chocolate_dipped_marshmallow", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ITEMS
			.register("milk_chocolate_dipped_graham_cracker", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_BACON = ITEMS.register("milk_chocolate_dipped_bacon",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_COFFEE_BEAN = ITEMS
			.register("milk_chocolate_dipped_coffee_bean", () -> new Item(new Item.Properties()));

	public static final DeferredItem<BlockItem> WHITE_CHOCOLATE_FONDUE_BLOCK = ITEMS.register(
			"white_chocolate_fondue_block",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_SWEET_BERRY = ITEMS
			.register("white_chocolate_dipped_sweet_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_GLOW_BERRY = ITEMS
			.register("white_chocolate_dipped_glow_berry", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_APPLE_SLICE = ITEMS
			.register("white_chocolate_dipped_apple_slice", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_MARSHMALLOW = ITEMS
			.register("white_chocolate_dipped_marshmallow", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ITEMS
			.register("white_chocolate_dipped_graham_cracker", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_BACON = ITEMS.register("white_chocolate_dipped_bacon",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_COFFEE_BEAN = ITEMS
			.register("white_chocolate_dipped_coffee_bean", () -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> DRIED_CHILI = ITEMS.register("dried_chili",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> PEANUTS_IN_SHELL = ITEMS.register("peanuts_in_shell",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PEANUTS = ITEMS.register("peanuts", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> ROASTED_PEANUTS = ITEMS.register("roasted_peanuts",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> HAZELNUTS_IN_SHELL = ITEMS.register("hazelnuts_in_shell",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> HAZELNUTS = ITEMS.register("hazelnuts",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> ROASTED_HAZELNUTS = ITEMS.register("roasted_hazelnuts",
			() -> new Item(new Item.Properties()));
}

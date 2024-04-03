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
import com.lance5057.extradelight.items.SimpleDynamicNameFood;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.HotCocoaItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

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
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).durability(250)));

	public static final RegistryObject<OffsetSpatulaItem> OFFSET_SPATULA_WOOD = ITEMS.register("offset_spatula_wood",
			() -> new OffsetSpatulaItem(Tiers.WOOD, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<OffsetSpatulaItem> OFFSET_SPATULA_IRON = ITEMS.register("offset_spatula_iron",
			() -> new OffsetSpatulaItem(Tiers.IRON, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<OffsetSpatulaItem> OFFSET_SPATULA_GOLD = ITEMS.register("offset_spatula_gold",
			() -> new OffsetSpatulaItem(Tiers.GOLD, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<OffsetSpatulaItem> OFFSET_SPATULA_DIAMOND = ITEMS.register(
			"offset_spatula_diamond",
			() -> new OffsetSpatulaItem(Tiers.DIAMOND, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<OffsetSpatulaItem> OFFSET_SPATULA_NETHERITE = ITEMS.register(
			"offset_spatula_netherite",
			() -> new OffsetSpatulaItem(Tiers.NETHERITE, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

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
			() -> new BlockItem(ExtraDelightBlocks.YEAST_POT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				@Override
				public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
						List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
					pTooltipComponents.add(Component.literal("")
							.append(Component.translatable(ExtraDelight.MOD_ID + ".yeastpot.tooltip"))
							.withStyle(ChatFormatting.AQUA));
				}
			});

	public static final RegistryObject<Item> VINEGAR = ITEMS.register("vinegar",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> VINEGAR_POT = ITEMS.register("vinegar_pot",
			() -> new BlockItem(ExtraDelightBlocks.VINEGAR_POT.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				@Override
				public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
						List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
					pTooltipComponents.add(Component.literal("")
							.append(Component.translatable(ExtraDelight.MOD_ID + ".vinegarpot.tooltip"))
							.withStyle(ChatFormatting.AQUA));
				}
			});

	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> COOKING_OIL = ITEMS.register("cooking_oil",
			() -> new BlockItem(ExtraDelightBlocks.COOKING_OIL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> GRAVY = ITEMS.register("gravy_boat_item",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> SLICED_ONION = ITEMS.register("sliced_onion",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_ONION)));
	public static final RegistryObject<Item> SLICED_TOMATO = ITEMS.register("sliced_tomato",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_TOMATO)));

	// Seaweed
	// Agar Agar Process
	public static final RegistryObject<Item> SEAWEED_PASTE = ITEMS.register("seaweed_paste",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> AGAR_SHEETS = ITEMS.register("agar_sheets",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> AGAR_AGAR = ITEMS.register("agar_agar",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> SEAWEED_CRISPS = ITEMS.register("seaweed_crisps",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SEAWEED_CRISPS)));
	public static final RegistryObject<Item> SEAWEED_SALAD = ITEMS.register("seaweed_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SEAWEED_SALAD)));

//	public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
//			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodVanilla.CUPCAKE)));

	public static final RegistryObject<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EDIBLE_SEEDS)));

	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(EXTRA_DELIGHT_TAB);
	}

	// Juice
	public static final RegistryObject<Item> GLOW_BERRY_JUICE = ITEMS.register("glow_berry_juice",
			() -> new GlowberryJuiceItem(drinkItem()));
	public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice",
			() -> new MelonJuiceItem(drinkItem()));
	public static final RegistryObject<Item> TOMATO_JUICE = ITEMS.register("tomato_juice",
			() -> new MelonJuiceItem(drinkItem()));
	public static final RegistryObject<Item> CACTUS_JUICE = ITEMS.register("cactus_juice",
			() -> new CactusJuiceItem(drinkItem()));

	// Custard
	public static final RegistryObject<Item> SWEET_BERRY_CUSTARD = ITEMS.register("sweet_berry_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> CHOCOLATE_CUSTARD = ITEMS.register("chocolate_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PUMPKIN_CUSTARD = ITEMS.register("pumpkin_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> HONEY_CUSTARD = ITEMS.register("honey_custard",
			() -> new ConsumableItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)
					.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> APPLE_CUSTARD = ITEMS.register("apple_custard",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)
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
	public static final RegistryObject<Item> APPLE_CHEESECAKE_SLICE = ITEMS.register("apple_cheesecake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));

	public static final RegistryObject<BlockItem> SWEET_BERRY_PIE_ITEM = ITEMS.register("sweet_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_PIE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GLOW_BERRY_PIE_ITEM = ITEMS.register("glow_berry_pie",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHEESECAKE_ITEM = ITEMS.register("cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHEESECAKE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> HONEY_CHEESECAKE_ITEM = ITEMS.register("honey_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHOCOLATE_CHEESECAKE_ITEM = ITEMS.register("chocolate_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> PUMPKIN_CHEESECAKE_ITEM = ITEMS.register("pumpkin_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GLOW_BERRY_CHEESECAKE_ITEM = ITEMS.register("glow_berry_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> APPLE_CHEESECAKE_ITEM = ITEMS.register("apple_cheesecake",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Cookies
	public static final RegistryObject<Item> PUMPKIN_COOKIE = ITEMS.register("pumpkin_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE = ITEMS.register("sugar_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GLOW_BERRY_COOKIE = ITEMS.register("glow_berry_cookie",
			() -> new GlowberryFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> APPLE_COOKIE = ITEMS.register("apple_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));

	// Popsicle
	public static final RegistryObject<Item> GLOW_BERRY_POPSICLE = ITEMS.register("glow_berry_popsicle",
			() -> new GlowberryPopsicleItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> SWEET_BERRY_POPSICLE = ITEMS.register("sweet_berry_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> FUDGE_POPSICLE = ITEMS.register("fudge_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> HONEY_POPSICLE = ITEMS.register("honey_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<Item> APPLE_POPSICLE = ITEMS.register("apple_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));

	public static final RegistryObject<BowlFoodItem> WHIPPED_CREAM = ITEMS.register("whipped_cream",
			() -> new BowlFoodItem(new MilkBottleItem.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.WHIPPED_CREAM)
					.craftRemainder(Items.BOWL)));
//
//	public static final RegistryObject<Item> PLAIN_CAKE = ITEMS.register("plain_cake",
//			() -> new BlockItem(ExtraDelightBlocks.PLAIN_CAKE.get(),
//					new BlockItem.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Eggs
	public static final RegistryObject<Item> EGG_MIX = ITEMS.register("egg_mix",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)));

	public static final RegistryObject<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SCRAMBLED_EGGS).craftRemainder(Items.BOWL)));

	public static final RegistryObject<Item> OMELETTE_MIX = ITEMS.register("omelette_mix",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.EGG_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)));

	public static final RegistryObject<Item> OMELETTE = ITEMS.register("omelette",
			() -> new SimpleDynamicNameFood(ExtraDelightItems.OMELETTE_MIX.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.OMELETTE)));

	public static final RegistryObject<Item> BOILED_EGG = ITEMS.register("boiled_egg",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.FRIED_EGG)));

	public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche",
			() -> new BlockItem(ExtraDelightBlocks.QUICHE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.QUICHE)));

	public static final RegistryObject<Item> EGG_BASKET = ITEMS.register("egg_in_the_basket",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EGG_BASKET)));

	public static final RegistryObject<BowlFoodItem> EGG_SALAD = ITEMS.register("egg_salad", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.EGG_SALAD)));

	// Condiments
	public static final RegistryObject<Item> BBQ_SAUCE = ITEMS.register("bbq_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BBQ).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.KETCHUP).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> MAYO = ITEMS.register("mayo_jar_item", () -> new DrinkableItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MAYO).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> FURIKAKE = ITEMS.register("furikake",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> CURRY_POWDER = ITEMS.register("curry_powder",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));

	// Jams
	public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_jam", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> GLOW_BERRY_JAM = ITEMS.register("glow_berry_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GLOW_BERRY_JAM)
					.craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> CARROT_JAM = ITEMS.register("carrot_jam", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> APPLE_JAM = ITEMS.register("apple_jam", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> GOLDEN_APPLE_JAM = ITEMS.register("golden_apple_jam",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GOLDEN_APPLE_JAM)
					.craftRemainder(Items.GLASS_BOTTLE)));

	// Bread

	public static final RegistryObject<Item> JAM_TOAST = ITEMS.register("jam_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM_BREAD)));
	public static final RegistryObject<Item> GLOW_JAM_TOAST = ITEMS.register("glow_jam_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GLOW_JAM_BREAD)));
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
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FRIED_POTATO)));
	public static final RegistryObject<Item> HASHBROWNS = ITEMS.register("hashbrowns",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FRIED_POTATO)));
	public static final RegistryObject<Item> FRENCH_FRIES = ITEMS.register("french_fries",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FRIED_POTATO)));

	// Carrot
	public static final RegistryObject<Item> GRATED_CARROT = ITEMS.register("grated_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.CARROT)));

	public static final RegistryObject<Item> ROASTED_CARROT = ITEMS.register("roasted_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CARROT)));
	public static final RegistryObject<Item> GLAZED_CARROT = ITEMS.register("glazed_carrot",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GLAZED_CARROT)));
	public static final RegistryObject<Item> CARROT_SALAD = ITEMS.register("carrot_salad", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARROT_SALAD).craftRemainder(Items.BOWL)));

	// Apple
	public static final RegistryObject<Item> SLICED_APPLE = ITEMS.register("sliced_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> ROASTED_APPLE = ITEMS.register("roasted_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_APPLE)));
	public static final RegistryObject<Item> APPLE_SAUCE = ITEMS.register("apple_sauce", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.APPLE_SAUCE).craftRemainder(Items.BOWL)));

	// Soup
	public static final RegistryObject<BowlFoodItem> POTATO_SOUP = ITEMS.register("potato_soup", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.POTATO_SOUP)));
	public static final RegistryObject<BowlFoodItem> TOMATO_SOUP = ITEMS.register("tomato_soup", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.TOMATO_SOUP)));
	public static final RegistryObject<BowlFoodItem> FISH_SOUP = ITEMS.register("fish_soup", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.FISH_SOUP)));
	public static final RegistryObject<BowlFoodItem> CARROT_SOUP = ITEMS.register("carrot_soup", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.CARROT_SOUP)));

	// Sandwiches
//	public static final RegistryObject<Item> DYNAMIC_SANDWICH = ITEMS.register("dynamic_sandwich",
//			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.BACON_SANDWICH)));
	public static final RegistryObject<Item> EGG_SALAD_SANDWICH = ITEMS.register("egg_salad_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.EGG_SANDWICH)));

	// Feasts
	public static final RegistryObject<BlockItem> SALISBURY_STEAK_FEAST_ITEM = ITEMS
			.register("salisbury_steak_block_item", () -> new BlockItem(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> SALISBURY_STEAK = ITEMS.register("salisbury_steak",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.SALISBURY_STEAK).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> MASHED_POTATO_GRAVY_FEAST_ITEM = ITEMS.register(
			"mashed_potato_gravy_block_item", () -> new BlockItem(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> MASHED_POTATO_GRAVY = ITEMS.register("mashed_potato_gravy",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.MASHED_POTATO_GRAVY).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
			() -> new Item(new Item.Properties().food(EDFoods.CHEESE).stacksTo(64).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
			() -> new Item(new Item.Properties().food(EDFoods.BUTTER).stacksTo(64).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> CHEESE_BLOCK_ITEM = ITEMS.register("cheese_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHEESE_STAIRS_BLOCK_ITEM = ITEMS.register("cheese_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHEESE_SLAB_BLOCK_ITEM = ITEMS.register("cheese_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> BUTTER_BLOCK_ITEM = ITEMS.register("butter_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_BLOCK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BUTTER_STAIRS_BLOCK_ITEM = ITEMS.register("butter_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BUTTER_SLAB_BLOCK_ITEM = ITEMS.register("butter_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Stews
	public static final RegistryObject<BowlFoodItem> PORK_STEW = ITEMS.register("pork_stew",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PORK_STEW).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> LAMB_STEW = ITEMS.register("lamb_stew",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.LAMB_STEW).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> CHICKEN_STEW = ITEMS.register("chicken_stew",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.CHICKEN_STEW).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> CURRY = ITEMS.register("curry", () -> new BowlFoodItem(
			new Item.Properties().food(EDFoods.CURRY).craftRemainder(Items.BOWL).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BEEF_STEW_RICE = ITEMS.register("beef_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> PORK_STEW_RICE = ITEMS.register("pork_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PORK_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> LAMB_STEW_RICE = ITEMS.register("lamb_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.LAMB_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> RABBIT_STEW_RICE = ITEMS.register("rabbit_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.RABBIT_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> CHICKEN_STEW_RICE = ITEMS.register("chicken_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.CHICKEN_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> FISH_STEW_RICE = ITEMS.register("fish_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.FISH_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> CURRY_RICE = ITEMS.register("curry_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.CURRY_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

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
	public static final RegistryObject<BowlFoodItem> LIVER_ONIONS = ITEMS.register("liver_onions",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.LIVERONION).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_FISH = ITEMS.register("fried_fish",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_FISH).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CHICKEN_FRIED_STEAK = ITEMS.register("chicken_fried_steak", () -> new Item(
			new Item.Properties().food(EDFoods.CHICKEN_FRIED_STEAK).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PORK_TENDERLOIN = ITEMS.register("pork_tenderloin",
			() -> new Item(new Item.Properties().food(EDFoods.PORK_TENDERLOIN).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PORK_TENDERLOIN_SANDWICH = ITEMS.register("pork_tenderloin_sandwich",
			() -> new Item(
					new Item.Properties().food(EDFoods.PORK_TENDERLOIN_SANDWICH).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STUFFED_HEART = ITEMS.register("stuffed_heart",
			() -> new Item(new Item.Properties().food(EDFoods.STUFFED_HEART).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FRIED_BRAINS = ITEMS.register("fried_brains",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_BRAIN).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> OXTAIL_SOUP = ITEMS.register("oxtail_soup",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.OXTAIL_SOUP).stacksTo(16)
					.craftRemainder(Items.BOWL).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.CHEESE_SANDWICH).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> GRILLED_CHEESE = ITEMS.register("grilled_cheese",
			() -> new Item(new Item.Properties().food(EDFoods.GRILLED_CHEESE).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> HASH = ITEMS.register("hash",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.HASH_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> POT_ROAST = ITEMS.register("potroast",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.POT_ROAST).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> MEAT_LOAF_FEAST = ITEMS.register("meatloaf_feast",
			() -> new BlockItem(ExtraDelightBlocks.MEATLOAF_FEAST.get(),
					new Item.Properties().stacksTo(1).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> MEAT_LOAF = ITEMS.register("meatloaf",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.MEAT_LOAF_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MEAT_LOAF_SANDWICH = ITEMS.register("meatloaf_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.MEAT_LOAF_SANDWICH).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BBQ_RIBS = ITEMS.register("bbq_ribs",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BBQ_RIBS).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> MEAT_PIE_SLICE = ITEMS.register("meat_pie_slice",
			() -> new Item(new Item.Properties().food(EDFoods.MEAT_PIE_SLICE).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> PULLED_PORK_SANDWICH = ITEMS.register("pulled_pork_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.PULLED_PORK_SANDWICH).craftRemainder(Items.BREAD)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> RACK_LAMB = ITEMS.register("rack_lamb",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.RACK_LAMB).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> STIRFRY = ITEMS.register("stirfry",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.STIRFRY_AND_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> BEEF_WELLINGTON = ITEMS.register("beef_wellington",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.WELLINGTON).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> HAGGIS = ITEMS.register("haggis", () -> new BowlFoodItem(
			new Item.Properties().food(EDFoods.HAGGIS).craftRemainder(Items.BOWL).stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> JELLY_WHITE = ITEMS.register("jelly_white",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_ORANGE = ITEMS.register("jelly_orange",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_MAGENTA = ITEMS.register("jelly_magenta",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_LIGHT_BLUE = ITEMS.register("jelly_light_blue",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_YELLOW = ITEMS.register("jelly_yellow",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_LIME = ITEMS.register("jelly_lime",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_PINK = ITEMS.register("jelly_pink",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_GREY = ITEMS.register("jelly_grey",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_LIGHT_GREY = ITEMS.register("jelly_light_grey",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_CYAN = ITEMS.register("jelly_cyan",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_PURPLE = ITEMS.register("jelly_purple",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_BLUE = ITEMS.register("jelly_blue",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_BROWN = ITEMS.register("jelly_brown",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_GREEN = ITEMS.register("jelly_green",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_RED = ITEMS.register("jelly_red",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BowlFoodItem> JELLY_BLACK = ITEMS.register("jelly_black",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.JELLY_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(EXTRA_DELIGHT_TAB)));

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
			() -> new BlockItem(ExtraDelightBlocks.BREADCRUMBS.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));

	public static final RegistryObject<Item> BREADING_MISANPLAS = ITEMS.register("breading_misanplas",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)));

	// Pasta
	public static final RegistryObject<Item> MACARONI = ITEMS.register("macaroni",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> LASAGNA_NOODLES = ITEMS.register("lasagna_noodles",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> MACARONI_CHEESE = ITEMS.register("macaroni_cheese",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.MACARONI_CHEESE_SERVING)));
	public static final RegistryObject<BlockItem> MACARONI_CHEESE_FEAST = ITEMS.register("macaroni_cheese_feast",
			() -> new BlockItem(ExtraDelightBlocks.MACARONI_CHEESE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> LASAGNA = ITEMS.register("lasanga", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.LASAGNA_SERVING)));
	public static final RegistryObject<BlockItem> LASAGNA_FEAST = ITEMS.register("lasanga_feast",
			() -> new BlockItem(ExtraDelightBlocks.LASAGNA.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> HOTDISH = ITEMS.register("hotdish", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.HOTDISH)));
	public static final RegistryObject<BlockItem> HOTDISH_FEAST = ITEMS.register("hotdish_feast",
			() -> new BlockItem(ExtraDelightBlocks.HOTDISH.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Rice
	public static final RegistryObject<BowlFoodItem> FURIKAKE_RICE = ITEMS.register("furikake_rice",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.FURIKAKE_RICE)));
//	public static final RegistryObject<Item> FRIED_RICE = ITEMS.register("fried_rice", () -> new Item(
//			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.FRIED_RICE)));

	// Fish
	public static final RegistryObject<Item> FISH_FLAKES = ITEMS.register("fish_flakes",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> FISH_CAKES = ITEMS.register("fish_cakes",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FISH_CAKES)));
	public static final RegistryObject<Item> FISH_AND_CHIPS = ITEMS.register("fish_chips",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FISH_CHIPS)));

	// Mushrooms
	public static final RegistryObject<Item> FRIED_MUSHROOMS = ITEMS.register("fried_mushrooms",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FRIED_MUSHROOMS)));
	public static final RegistryObject<BowlFoodItem> MUSHROOM_RISOTTO = ITEMS.register("mushroom_risotto",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.MUSHROOM_RISOTTO)));
	public static final RegistryObject<Item> STUFFED_MUSHROOMS = ITEMS.register("stuffed_mushrooms",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.STUFFED_MUSHROOMS)));
	public static final RegistryObject<Item> MUSHROOM_BURGER = ITEMS.register("mushroom_burger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MUSHROOM_BURGER)));

	public static final RegistryObject<Item> BACON_EGG_SANDWICH = ITEMS.register("bacon_egg_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BACON_EGG_SANDWICH)));
	public static final RegistryObject<Item> BACON_EGG_CHEESE_SANDWICH = ITEMS.register("bacon_egg_cheese_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BACON_EGG_CHEESE_SANDWICH)));

	public static final RegistryObject<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BUTTERED_TOAST)));

	public static final RegistryObject<Item> CROUTONS = ITEMS.register("croutons",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SLICED_BREAD)));
	public static final RegistryObject<BowlFoodItem> SALAD = ITEMS.register("salad", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SALAD).craftRemainder(Items.BOWL)));
	public static final RegistryObject<BlockItem> SALAD_FEAST_ITEM = ITEMS.register("salad_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SALAD.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> ALFREDO_SAUCE = ITEMS.register("alfredo_sauce",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.ALFREDO_SAUCE)));
	public static final RegistryObject<BowlFoodItem> PASTA_TOMATO = ITEMS.register("pasta_tomato",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.PASTA_TOMATO)));
	public static final RegistryObject<BowlFoodItem> PASTA_ALFREDO = ITEMS.register("pasta_alfredo",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.PASTA_ALFREDO)));
	public static final RegistryObject<BowlFoodItem> CHICKEN_ALFREDO = ITEMS.register("chicken_alfredo",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.CHICKEN_ALFREDO)));
	public static final RegistryObject<BowlFoodItem> CHICKEN_PARM = ITEMS.register("chicken_parm",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.CHICKEN_PARM)));

	public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CHEESEBURGER)));
	public static final RegistryObject<Item> BACON_CHEESEBURGER = ITEMS.register("bacon_cheeseburger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BACON_CHEESEBURGER)));

	public static final RegistryObject<Item> RICEBALL = ITEMS.register("riceball",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.RICEBALL)));
	public static final RegistryObject<Item> RICEBALL_FILLED = ITEMS.register("riceball_filled",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.RICEBALL_FILLED)));

	public static final RegistryObject<BowlFoodItem> FISH_SALAD = ITEMS.register("fish_salad", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.FISH_SALAD)));
	public static final RegistryObject<Item> FISH_SALAD_SANDWICH = ITEMS.register("fish_salad_sandwich",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FISH_SALAD_SANDWICH)));

	public static final RegistryObject<Item> COOKED_PASTA = ITEMS.register("cooked_pasta",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.BREAD).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> BUTTERED_PASTA = ITEMS.register("buttered_pasta", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BUTTERED_PASTA).craftRemainder(Items.BOWL)));
	public static final RegistryObject<BowlFoodItem> BAD_FOOD = ITEMS.register("bad_food", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.BADFOOD)));

	public static final RegistryObject<Item> CACTUS = ITEMS.register("cactus",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CACTUS)));
	public static final RegistryObject<Item> COOKED_CACTUS = ITEMS.register("cooked_cactus",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CACTUS)));
	public static final RegistryObject<BowlFoodItem> CACTUS_EGGS = ITEMS.register("cactus_eggs", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.CACTUS_EGGS)));
	public static final RegistryObject<BowlFoodItem> CACTUS_SOUP = ITEMS.register("cactus_soup", () -> new BowlFoodItem(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL).food(EDFoods.CACTUS_SOUP)));
	public static final RegistryObject<BowlFoodItem> CACTUS_SALAD = ITEMS.register("cactus_salad",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.CACTUS_SALAD)));
	public static final RegistryObject<BowlFoodItem> STUFFED_CACTUS = ITEMS.register("stuffed_cactus",
			() -> new BowlFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)
					.food(EDFoods.STUFFED_CACTUS)));

	public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.CORN_BOTTOM.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> UNSHUCKED_CORN = ITEMS.register("unshucked_corn",
			() -> new ShuckableCorn(MiscLootTables.SHUCKED_CORN, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CORN_ON_COB = ITEMS.register("corn_on_cob",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> CORN_HUSK = ITEMS.register("corn_husk",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> DRIED_CORN_HUSK = ITEMS.register("dried_corn_husk",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final RegistryObject<Item> CORN_SILK = ITEMS.register("corn_silk",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final RegistryObject<Item> CORN_COB = ITEMS.register("corn_cob",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 200;
				}
			});
	public static final RegistryObject<Item> CORN_MEAL = ITEMS.register("corn_meal",
			() -> new BlockItem(ExtraDelightBlocks.CORNMEAL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CORN_CHOWDER = ITEMS.register("corn_chowder",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CORN_CHOWDER)));
	public static final RegistryObject<Item> CREAM_CORN = ITEMS.register("cream_corn",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CREAMED_CORN)));
	public static final RegistryObject<Item> CORN_FRITTERS = ITEMS.register("corn_fritters",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CORN_FRITTERS)));
	public static final RegistryObject<Item> POPCORN = ITEMS.register("popcorn",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CORN)));
	public static final RegistryObject<Item> GRILLED_CORN_ON_COB = ITEMS.register("grilled_corn_on_cob",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.GRILLED_CORN)));
	public static final RegistryObject<Item> COOKED_CORN = ITEMS.register("cooked_corn",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKED_CORN)));
	public static final RegistryObject<Item> ROASTED_PUMPKIN_SEEDS = ITEMS.register("roasted_pumpkin_seeds",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.EDIBLE_SEEDS)));
	public static final RegistryObject<CornSilkTeaItem> CORN_SILK_TEA = ITEMS.register("corn_silk_tea",
			() -> new CornSilkTeaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> STEWED_APPLES = ITEMS.register("stewed_apples",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.STEWED_APPLES)));
	public static final RegistryObject<Item> APPLE_FRITTERS = ITEMS.register("apple_fritters",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.APPLE_FRITTERS)));
	public static final RegistryObject<Item> CARAMEL_SAUCE = ITEMS.register("caramel_sauce",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARAMEL_SAUCE)));
	public static final RegistryObject<Item> CARAMEL_CANDY = ITEMS.register("caramel_candy",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARAMEL_CANDY)));
	public static final RegistryObject<Item> CANDY_APPLE = ITEMS.register("candy_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY_APPLE)));
	public static final RegistryObject<Item> CARAMEL_APPLE = ITEMS.register("caramel_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARAMEL_APPLE)));
	public static final RegistryObject<Item> CANDY_GOLDEN_APPLE = ITEMS.register("candy_golden_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY_GOLDEN_APPLE)));
	public static final RegistryObject<Item> CARAMEL_GOLDEN_APPLE = ITEMS.register("caramel_golden_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARAMEL_GOLDEN_APPLE)));
	public static final RegistryObject<Item> CARAMEL_POPCORN = ITEMS.register("caramel_popcorn",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CARAMEL_POPCORN)));
	public static final RegistryObject<Item> CARAMEL_CUSTARD = ITEMS.register("caramel_custard",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CUSTARD)));
	public static final RegistryObject<Item> CARAMEL_POPSICLE = ITEMS.register("caramel_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));

	public static final RegistryObject<Item> CARAMEL_CHEESECAKE_SLICE = ITEMS.register("caramel_cheescake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<BlockItem> CARAMEL_CHEESECAKE_ITEM = ITEMS.register("caramel_cheesecake_item",
			() -> new BlockItem(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CORNBREAD = ITEMS.register("cornbread",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CORNBREAD)));
	public static final RegistryObject<BlockItem> CORNBREAD_FEAST = ITEMS.register("cornbread_feast",
			() -> new BlockItem(ExtraDelightBlocks.CORNBREAD.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CORN_PUDDING = ITEMS.register("corn_pudding",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CORN_PUDDING)));
	public static final RegistryObject<BlockItem> CORN_PUDDING_FEAST = ITEMS.register("corn_pudding_feast",
			() -> new BlockItem(ExtraDelightBlocks.CORN_PUDDING.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> PUMPKIN_PIE_SLICE = ITEMS.register("pumpkin_pie_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<BlockItem> PUMPKIN_PIE_ITEM = ITEMS.register("pumpkin_pie_item",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_PIE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> PUMPKIN_ROLL = ITEMS.register("pumpkin_roll",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.PIE_SLICE)));
	public static final RegistryObject<BlockItem> PUMPKIN_ROLL_FEAST = ITEMS.register("pumpkin_roll_feast",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_ROLL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> APPLE_CRISP = ITEMS.register("apple_crisp",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.APPLE_CRISP)));
	public static final RegistryObject<BlockItem> APPLE_CRISP_FEAST = ITEMS.register("apple_crisp_feast",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CRISP.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> STUFFING = ITEMS.register("stuffing",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.STUFFING)));
	public static final RegistryObject<BlockItem> STUFFING_FEAST = ITEMS.register("stuffing_feast",
			() -> new BlockItem(ExtraDelightBlocks.STUFFING.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> POTATO_AU_GRATIN = ITEMS.register("potato_au_gratin",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.POTATOES_AU_GRATIN)));
	public static final RegistryObject<BlockItem> POTATO_AU_GRATIN_FEAST = ITEMS.register("potato_au_gratin_feast",
			() -> new BlockItem(ExtraDelightBlocks.POTATO_AU_GRATIN.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> FLOUR_SACK = ITEMS.register("flour_sack",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR_SACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CORNMEAL_SACK = ITEMS.register("cornmeal_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORNMEAL_SACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> SUGAR_SACK = ITEMS.register("sugar_sack",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_SACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CORN_CRATE = ITEMS.register("corn_crate",
			() -> new BlockItem(ExtraDelightBlocks.CORN_CRATE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CORN_HUSK_BUNDLE = ITEMS.register("corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> DRIED_CORN_HUSK_BUNDLE = ITEMS.register("dried_corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CORN_COB_BUNDLE = ITEMS.register("corn_cob_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_COB_BUNDLE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BREADCRUMB_SACK = ITEMS.register("breadcrumb_sack",
			() -> new BlockItem(ExtraDelightBlocks.BREADCRUMB_SACK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> EGG_CRATE = ITEMS.register("egg_crate",
			() -> new BlockItem(ExtraDelightBlocks.EGG_CRATE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> APPLE_CRATE = ITEMS.register("apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CRATE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GOLDEN_APPLE_CRATE = ITEMS.register("golden_apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> BROWN_MUSHROOM_CRATE = ITEMS.register("brown_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> RED_MUSHROOM_CRATE = ITEMS.register("red_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.RED_MUSHROOM_CRATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> SWEET_BERRY_CRATE = ITEMS.register("sweet_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_CRATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GLOW_BERRY_CRATE = ITEMS.register("glow_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CRATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CORN_SILK_SACK = ITEMS.register("corn_silk_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORN_SILK_SACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CORN_COB_PIPE = ITEMS.register("corn_cob_pipe",
			() -> new CorncobPipe(EDArmorMaterial.CORNCOB, new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	// Winter start!
	public static final RegistryObject<BlockItem> CINNAMON_LOG = ITEMS.register("cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LOG.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> STRIPPED_CINNAMON_LOG = ITEMS.register("stripped_cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_PLANKS = ITEMS.register("cinnamon_planks",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_PLANKS.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_LEAVES = ITEMS.register("cinnamon_leaves",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LEAVES.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CINNAMON_FENCE = ITEMS.register("cinnamon_fence",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_FENCE_GATE = ITEMS.register("cinnamon_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_STAIRS = ITEMS.register("cinnamon_stairs",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STAIRS.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<DoubleHighBlockItem> CINNAMON_DOOR = ITEMS.register("cinnamon_door",
			() -> new DoubleHighBlockItem(ExtraDelightBlocks.CINNAMON_DOOR.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 200;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_TRAPDOOR = ITEMS.register("cinnamon_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_CABINET = ITEMS.register("cinnamon_cabinet",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_CABINET.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_SLAB = ITEMS.register("cinnamon_slab",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SLAB.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 150;
				}
			});
	public static final RegistryObject<Item> RAW_CINNAMON = ITEMS.register("raw_cinnamon",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final RegistryObject<BlockItem> RAW_CINNAMON_BLOCK = ITEMS.register("raw_cinnamon_block",
			() -> new BlockItem(ExtraDelightBlocks.RAW_CINNAMON_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 900;
				}
			});
	public static final RegistryObject<Item> CINNAMON_STICK = ITEMS.register("cinnamon_stick",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final RegistryObject<BlockItem> CINNAMON_STICK_BLOCK = ITEMS.register("cinnamon_stick_block",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 900;
				}
			});
	public static final RegistryObject<Item> GROUND_CINNAMON = ITEMS.register("ground_cinnamon",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GROUND_CINNAMON_BLOCK_ITEM = ITEMS.register("ground_cinnamon_block",
			() -> new BlockItem(ExtraDelightBlocks.GROUND_CINNAMON_SACK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> ICE_CREAM = ITEMS.register("ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final RegistryObject<GlowberryFoodItem> GLOW_BERRY_ICE_CREAM = ITEMS.register("glow_berry_ice_cream",
			() -> new GlowberryFoodItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM)
					.craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM = ITEMS.register("sweet_berry_ice_cream",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM)
					.craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> PUMPKIN_ICE_CREAM = ITEMS.register("pumpkin_ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> HONEY_ICE_CREAM = ITEMS.register("honey_ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> APPLE_ICE_CREAM = ITEMS.register("apple_ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> COOKIE_DOUGH_ICE_CREAM = ITEMS.register("cookie_dough_ice_cream",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM)
					.craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> MINT_CHIP_ICE_CREAM = ITEMS.register("mint_chip_ice_cream", () -> new Item(
			new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.TOPPED_ICE_CREAM).craftRemainder(Items.BOWL)));

	public static final RegistryObject<MilkshakeDrinkItem> MILKSHAKE = ITEMS.register("milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 2f));
	public static final RegistryObject<MilkshakeDrinkItem> CHOCOLATE_MILKSHAKE = ITEMS.register("chocolate_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> GLOW_BERRY_MILKSHAKE = ITEMS.register("glow_berry_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> SWEET_BERRY_MILKSHAKE = ITEMS
			.register("sweet_berry_milkshake", () -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> PUMPKIN_MILKSHAKE = ITEMS.register("pumpkin_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> HONEY_MILKSHAKE = ITEMS.register("honey_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> APPLE_MILKSHAKE = ITEMS.register("apple_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> COOKIE_DOUGH_MILKSHAKE = ITEMS
			.register("cookie_dough_milkshake", () -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));
	public static final RegistryObject<MilkshakeDrinkItem> MINT_CHIP_MILKSHAKE = ITEMS.register("mint_chip_milkshake",
			() -> new MilkshakeDrinkItem(
					new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE), 4f));

	public static final RegistryObject<HotCocoaItem> CHOCOLATE_MILK = ITEMS.register("chocolate_milk",
			() -> new HotCocoaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));

	public static final RegistryObject<HotCocoaItem> EGGNOG = ITEMS.register("eggnog",
			() -> new HotCocoaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<MelonJuiceItem> GINGER_BEER = ITEMS.register("ginger_beer",
			() -> new MelonJuiceItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<CornSilkTeaItem> GINGER_TEA = ITEMS.register("ginger_tea",
			() -> new CornSilkTeaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<HotCocoaItem> HORCHATA = ITEMS.register("horchata",
			() -> new HotCocoaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).craftRemainder(Items.GLASS_BOTTLE)));

	public static final RegistryObject<Item> GINGERBREAD_COOKIE_DOUGH = ITEMS.register("gingerbread_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> SUGAR_COOKIE_DOUGH = ITEMS.register("sugar_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> PUMPKIN_COOKIE_DOUGH = ITEMS.register("pumpkin_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> GLOW_BERRY_COOKIE_DOUGH = ITEMS.register("glow_berry_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> APPLE_COOKIE_DOUGH = ITEMS.register("apple_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> SWEET_BERRY_COOKIE_DOUGH = ITEMS.register("sweet_berry_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> HONEY_COOKIE_DOUGH = ITEMS.register("honey_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> CHOCOLATE_CHIP_COOKIE_DOUGH = ITEMS.register("chocolate_chip_cookie_dough",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));

	public static final RegistryObject<Item> GINGERBREAD_COOKIE = ITEMS.register("gingerbread_cookie",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));

	public static final RegistryObject<Item> GINGERBREAD_STEVE = ITEMS.register("gingerbread_steve",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_ALEX = ITEMS.register("gingerbread_alex",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_VILLAGER = ITEMS.register("gingerbread_villager",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_CREEPER = ITEMS.register("gingerbread_creeper",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_SWORD = ITEMS.register("gingerbread_sword",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_PICKAXE = ITEMS.register("gingerbread_pickaxe",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_DIAMOND = ITEMS.register("gingerbread_diamond",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> GINGERBREAD_EMERALD = ITEMS.register("gingerbread_emerald",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));

	public static final RegistryObject<Item> SUGAR_COOKIE_STEVE = ITEMS.register("sugar_cookie_steve",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_ALEX = ITEMS.register("sugar_cookie_alex",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_VILLAGER = ITEMS.register("sugar_cookie_villager",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_CREEPER = ITEMS.register("sugar_cookie_creeper",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_SWORD = ITEMS.register("sugar_cookie_sword",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_PICKAXE = ITEMS.register("sugar_cookie_pickaxe",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_DIAMOND = ITEMS.register("sugar_cookie_diamond",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> SUGAR_COOKIE_EMERALD = ITEMS.register("sugar_cookie_emerald",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.COOKIES)));

	public static final RegistryObject<Item> RAW_GINGERBREAD_STEVE = ITEMS.register("raw_gingerbread_steve",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_ALEX = ITEMS.register("raw_gingerbread_alex",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_VILLAGER = ITEMS.register("raw_gingerbread_villager",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_CREEPER = ITEMS.register("raw_gingerbread_creeper",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_SWORD = ITEMS.register("raw_gingerbread_sword",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_PICKAXE = ITEMS.register("raw_gingerbread_pickaxe",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_DIAMOND = ITEMS.register("raw_gingerbread_diamond",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_GINGERBREAD_EMERALD = ITEMS.register("raw_gingerbread_emerald",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));

	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_STEVE = ITEMS.register("raw_sugar_cookie_steve",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_ALEX = ITEMS.register("raw_sugar_cookie_alex",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_VILLAGER = ITEMS.register("raw_sugar_cookie_villager",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_CREEPER = ITEMS.register("raw_sugar_cookie_creeper",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_SWORD = ITEMS.register("raw_sugar_cookie_sword",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_PICKAXE = ITEMS.register("raw_sugar_cookie_pickaxe",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_DIAMOND = ITEMS.register("raw_sugar_cookie_diamond",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));
	public static final RegistryObject<Item> RAW_SUGAR_COOKIE_EMERALD = ITEMS.register("raw_sugar_cookie_emerald",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.COOKIE_DOUGH)));

	public static final RegistryObject<BlockItem> APPLE_COOKIE_BLOCK = ITEMS.register("apple_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CHOCOLATE_CHIP_COOKIE_BLOCK = ITEMS.register(
			"chocolate_chip_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_COOKIE_BLOCK = ITEMS.register(
			"gingerbread_cookie_block_item", () -> new BlockItem(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GLOW_BERRY_COOKIE_BLOCK = ITEMS.register(
			"glow_berry_cookie_block_item", () -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> HONEY_COOKIE_BLOCK = ITEMS.register("honey_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> PUMPKIN_COOKIE_BLOCK = ITEMS.register("pumpkin_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> SUGAR_COOKIE_BLOCK = ITEMS.register("sugar_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> SWEET_BERRY_COOKIE_BLOCK = ITEMS.register(
			"sweet_berry_cookie_block_item", () -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> GINGER = ITEMS.register("ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> GINGER_CUTTING = ITEMS.register("ginger_cutting",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.GINGER_CROP.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> WILD_GINGER = ITEMS.register("wild_ginger",
			() -> new BlockItem(ExtraDelightBlocks.WILD_GINGER.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGER_CRATE = ITEMS.register("ginger_crate",
			() -> new BlockItem(ExtraDelightBlocks.GINGER_CRATE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MINT = ITEMS.register("mint",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.MINT_CROP.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> MINT_SACK = ITEMS.register("mint_sack",
			() -> new BlockItem(ExtraDelightBlocks.MINT_SACK.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> PEELED_GINGER = ITEMS.register("peeled_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> SLICED_GINGER = ITEMS.register("sliced_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));
	public static final RegistryObject<Item> GRATED_GINGER = ITEMS.register("grated_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.POTATO)));

	public static final RegistryObject<Item> FROSTING_WHITE = ITEMS.register("frosting_white",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_LIGHT_GRAY = ITEMS.register("frosting_light_gray",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_GRAY = ITEMS.register("frosting_gray",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_BLACK = ITEMS.register("frosting_black",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_BROWN = ITEMS.register("frosting_brown",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_RED = ITEMS.register("frosting_red",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_ORANGE = ITEMS.register("frosting_orange",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_YELLOW = ITEMS.register("frosting_yellow",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_LIME = ITEMS.register("frosting_lime",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_GREEN = ITEMS.register("frosting_green",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_CYAN = ITEMS.register("frosting_cyan",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_LIGHT_BLUE = ITEMS.register("frosting_light_blue",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_BLUE = ITEMS.register("frosting_blue",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_PURPLE = ITEMS.register("frosting_purple",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_MAGENTA = ITEMS.register("frosting_magenta",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));
	public static final RegistryObject<Item> FROSTING_PINK = ITEMS.register("frosting_pink",
			() -> new FrostingItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FROSTING)));

	public static final RegistryObject<Item> CANDY_WHITE = ITEMS.register("candy_white",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_LIGHT_GRAY = ITEMS.register("candy_light_gray",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_GRAY = ITEMS.register("candy_gray",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_BLACK = ITEMS.register("candy_black",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_BROWN = ITEMS.register("candy_brown",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_RED = ITEMS.register("candy_red",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_ORANGE = ITEMS.register("candy_orange",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_YELLOW = ITEMS.register("candy_yellow",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_LIME = ITEMS.register("candy_lime",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_GREEN = ITEMS.register("candy_green",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_CYAN = ITEMS.register("candy_cyan",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_LIGHT_BLUE = ITEMS.register("candy_light_blue",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_BLUE = ITEMS.register("candy_blue",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_PURPLE = ITEMS.register("candy_purple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_MAGENTA = ITEMS.register("candy_magenta",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));
	public static final RegistryObject<Item> CANDY_PINK = ITEMS.register("candy_pink",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CANDY)));

	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_WHITE = ITEMS.register("gingerbread_block_white",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_LIGHT_GRAY = ITEMS.register(
			"gingerbread_block_light_gray",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_GRAY = ITEMS.register("gingerbread_block_gray",
			() -> new BlockItem(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_BLACK = ITEMS.register("gingerbread_block_black",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_BROWN = ITEMS.register("gingerbread_block_brown",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_RED = ITEMS.register("gingerbread_block_red",
			() -> new BlockItem(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_ORANGE = ITEMS.register("gingerbread_block_orange",
			() -> new BlockItem(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_YELLOW = ITEMS.register("gingerbread_block_yellow",
			() -> new BlockItem(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_LIME = ITEMS.register("gingerbread_block_lime",
			() -> new BlockItem(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_GREEN = ITEMS.register("gingerbread_block_green",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_CYAN = ITEMS.register("gingerbread_block_cyan",
			() -> new BlockItem(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_LIGHT_BLUE = ITEMS.register(
			"gingerbread_block_light_blue",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_BLUE = ITEMS.register("gingerbread_block_blue",
			() -> new BlockItem(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_PURPLE = ITEMS.register("gingerbread_block_purple",
			() -> new BlockItem(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_MAGENTA = ITEMS.register(
			"gingerbread_block_magenta", () -> new BlockItem(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK_PINK = ITEMS.register("gingerbread_block_pink",
			() -> new BlockItem(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> CANDY_BOWL_ITEM = ITEMS.register("candy_bowl_item",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_BOWL.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MINT_CANDY_RED = ITEMS.register("mint_candy_red",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));
	public static final RegistryObject<Item> MINT_CANDY_GREEN = ITEMS.register("mint_candy_green",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));
	public static final RegistryObject<Item> MINT_CANDY_BLUE = ITEMS.register("mint_candy_blue",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));

	public static final RegistryObject<Item> CANDY_CANE_RED = ITEMS.register("candy_cane_red",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));
	public static final RegistryObject<Item> CANDY_CANE_GREEN = ITEMS.register("candy_cane_green",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));
	public static final RegistryObject<Item> CANDY_CANE_BLUE = ITEMS.register("candy_cane_blue",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));

	public static final RegistryObject<BlockItem> CANDY_CANE_RED_BLOCK = ITEMS.register("candy_cane_red_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CANDY_CANE_GREEN_BLOCK = ITEMS.register("candy_cane_green_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> CANDY_CANE_BLUE_BLOCK = ITEMS.register("candy_cane_blue_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> FRENCH_TOAST = ITEMS.register("french_toast",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FRENCH_TOAST)));
	public static final RegistryObject<Item> CONGEE = ITEMS.register("congee",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CONGEE)));
	public static final RegistryObject<Item> LUGAW = ITEMS.register("lugaw",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.LUGAW)));
	public static final RegistryObject<Item> RICE_PUDDING = ITEMS.register("rice_pudding",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.GLOW_BERRY_CUSTARD)));

	public static final RegistryObject<Item> MUFFIN_GINGER = ITEMS.register("muffin_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MUFFIN)));
	public static final RegistryObject<Item> MUFFIN_CINNAMON = ITEMS.register("muffin_cinnamon",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MUFFIN)));
	public static final RegistryObject<Item> MUFFIN_SWEET_BERRY = ITEMS.register("muffin_sweet_berry",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MUFFIN)));
	public static final RegistryObject<Item> MUFFIN_APPLE = ITEMS.register("muffin_apple",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MUFFIN)));

	public static final RegistryObject<Item> DRIED_FRUIT = ITEMS.register("dried_fruit",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(Foods.APPLE)));
	public static final RegistryObject<Item> FRUIT_BREAD = ITEMS.register("fruit_bread",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.FILLED_BREAD)));
	public static final RegistryObject<Item> PICKLED_GINGER = ITEMS.register("pickled_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.PICKLED_GINGER)));
	public static final RegistryObject<Item> CANDIED_GINGER = ITEMS.register("candied_ginger",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.SUGAR)));
	public static final RegistryObject<Item> CINNAMON_POPSICLE = ITEMS.register("cinnamon_popsicle",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.POPSICLE)));
	public static final RegistryObject<CornSilkTeaItem> MINT_TEA = ITEMS.register("mint_tea",
			() -> new CornSilkTeaItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<Item> BEET_MINT_SALAD = ITEMS.register("beet_mint_salad",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.BEET_MINT)));
	public static final RegistryObject<Item> MINT_JELLY = ITEMS.register("mint_jelly",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.JAM)));
	public static final RegistryObject<Item> CRACKERS = ITEMS.register("crackers",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CRACKER)));
	public static final RegistryObject<Item> CROQUE_MONSIEUR = ITEMS.register("croque_monsieur",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CROQUE_MONSIEUR)));
	public static final RegistryObject<Item> CROQUE_MADAME = ITEMS.register("croque_madame",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CROQUE_MADAME)));
	public static final RegistryObject<Item> ROLL = ITEMS.register("roll",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.ROLL)));

	public static final RegistryObject<Item> CINNAMON_ROLL = ITEMS.register("cinnamon_rolls",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CINNAMON_ROLL)));
	public static final RegistryObject<BlockItem> CINNAMON_ROLLS_FEAST = ITEMS.register("cinnamon_rolls_feast",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_ROLLS.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MONKEY_BREAD = ITEMS.register("monkey_bread",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MONKEY_BREAD)));
	public static final RegistryObject<BlockItem> MONKEY_BREAD_FEAST = ITEMS.register("monkey_bread_feast",
			() -> new BlockItem(ExtraDelightBlocks.MONKEY_BREAD.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> COFFEE_CAKE_SLICE = ITEMS.register("coffee_cake_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(FoodValues.CAKE_SLICE)));
	public static final RegistryObject<BlockItem> COFFEE_CAKE_FEAST = ITEMS.register("coffe_cake_feast",
			() -> new BlockItem(ExtraDelightBlocks.COFFEE_CAKE.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MINT_LAMB = ITEMS.register("mint_lamb",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MINT_LAMB)));
	public static final RegistryObject<BlockItem> MINT_LAMB_FEAST = ITEMS.register("mint_lamb_feast",
			() -> new BlockItem(ExtraDelightBlocks.MINT_LAMB.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHARCUTERIE_BOARD = ITEMS.register("charcuterie_board",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CHARCUTERIE)));
	public static final RegistryObject<BlockItem> CHARCUTERIE_BOARD_FEAST = ITEMS.register("charcuterie_board_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHRISTMAS_PUDDING = ITEMS.register("christmas_pudding",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.CHRISTMAS_PUDDING)));
	public static final RegistryObject<BlockItem> CHRISTMAS_PUDDING_FEAST = ITEMS.register("christmas_pudding_feast",
			() -> new BlockItem(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<MelonJuiceItem> PUNCH = ITEMS.register("punch",
			() -> new MelonJuiceItem(new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
	public static final RegistryObject<BlockItem> PUNCH_FEAST = ITEMS.register("punch_feast",
			() -> new BlockItem(ExtraDelightBlocks.PUNCH.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> MILK_TART_SLICE = ITEMS.register("milk_tart_slice",
			() -> new Item(new Item.Properties().tab(EXTRA_DELIGHT_TAB).food(EDFoods.MILK_TART)));
	public static final RegistryObject<BlockItem> MILK_TART_FEAST = ITEMS.register("milk_tart_feast",
			() -> new BlockItem(ExtraDelightBlocks.MILK_TART.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> CINNAMON_SAPLING = ITEMS.register("cinnamon_sapling",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SAPLING.get(),
					new Item.Properties().tab(EXTRA_DELIGHT_TAB)));
}

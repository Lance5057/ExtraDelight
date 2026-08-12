package com.lance5057.extradelight;

import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.lance5057.extradelight.aesthetics.HelmetBlockItem;
import com.lance5057.extradelight.data.MiscLootTables;
import com.lance5057.extradelight.fluids.FluidRegistration;
import com.lance5057.extradelight.food.EDFoods;
import com.lance5057.extradelight.items.CactusJuiceItem;
import com.lance5057.extradelight.items.CoffeeItem;
import com.lance5057.extradelight.items.CornSilkTeaItem;
import com.lance5057.extradelight.items.CorncobPipe;
import com.lance5057.extradelight.items.DeprecatedItem;
import com.lance5057.extradelight.items.FrostingItem;
import com.lance5057.extradelight.items.GarlicCureDrinkableItem;
import com.lance5057.extradelight.items.GarlicCureItem;
import com.lance5057.extradelight.items.GarlicTooltipItem;
import com.lance5057.extradelight.items.GlowberryFoodItem;
import com.lance5057.extradelight.items.GlowberryJuiceItem;
import com.lance5057.extradelight.items.GlowberryPopsicleItem;
import com.lance5057.extradelight.items.GourmetHotCocoa;
import com.lance5057.extradelight.items.MilkshakeDrinkItem;
import com.lance5057.extradelight.items.OffsetSpatulaItem;
import com.lance5057.extradelight.items.ShuckableCorn;
import com.lance5057.extradelight.items.ToolTipConsumableItem;
import com.lance5057.extradelight.items.XocolatlItem;
import com.lance5057.extradelight.items.dynamicfood.DynamicJam;
import com.lance5057.extradelight.items.dynamicfood.DynamicToast;
import com.lance5057.extradelight.items.dynamicfood.api.DynamicItemComponent;
import com.lance5057.extradelight.items.jar.JarItem;
import com.lance5057.extradelight.modules.Fermentation;
import com.lance5057.extradelight.modules.SummerCitrus;
import com.lance5057.extradelight.util.registration.types.BlockRegistration;
import com.lance5057.extradelight.util.registration.types.ItemRegistration;

import mezz.jei.api.recipe.RecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.common.EffectCure;
import net.neoforged.neoforge.fluids.DispenseFluidContainer;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.HotCocoaItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ExtraDelightItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExtraDelight.MOD_ID);

	public static final EffectCure GARLIC_CURE = EffectCure.get("vampirism:garlic");

	public static void setup() {
		DispenserBlock.registerBehavior(ExtraDelightItems.APPLE_CIDER_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.BBQ_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.BROTH_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.CACTUS_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.CARAMEL_SAUCE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.COCOA_BUTTER_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.COCOA_NUT_BUTTER_SPREAD_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.COFFEE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.DARK_CHOCOLATE_SYRUP_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.EGG_MIX_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.GLOW_BERRY_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.GRAVY_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.HOT_COCOA_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.JAM_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.KETCHUP_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.MARSHMALLOW_FLUFF_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.MAYO_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.MELON_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.MILK_CHOCOLATE_SYRUP_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.MILKSHAKE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.NUT_BUTTER_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.OIL_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.SWEET_BERRY_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.TEA_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.TOMATO_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.VINEGAR_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.WHIPPED_CREAM_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(Fermentation.PICKLE_JUICE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(SummerCitrus.LEMON_JUICE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(SummerCitrus.LIME_JUICE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(SummerCitrus.ORANGE_JUICE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(SummerCitrus.GRAPEFRUIT_JUICE_FLUID_BUCKET,
				DispenseFluidContainer.getInstance());
		DispenserBlock.registerBehavior(SummerCitrus.EGG_WHITE_FLUID_BUCKET, DispenseFluidContainer.getInstance());
	}

	// Helper methods

	
//	public static final DeferredItem<Item> OVEN = ItemRegistration
//			.register("oven", () -> new BlockItem(ExtraDelightBlocks.OVEN.get(), new Item.Properties())).finish();

	public static final DeferredItem<Item> DRYING_RACK = ITEMS.register("drying_rack_item",
			() -> new BlockItem(ExtraDelightBlocks.DRYING_RACK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

//	public static final DeferredItem<Item> FOOD_DISPLAY = ITEMS.register("food_display",
//			() -> new BlockItem(ExtraDelightBlocks.FOOD_DISPLAY.get(), new Item.Properties()));

	public static final DeferredItem<Item> DOUGH_SHAPING = ITEMS.register("dough_shaping",
			() -> new BlockItem(ExtraDelightBlocks.DOUGH_SHAPING.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> MIXING_BOWL = ITEMS.register("mixing_bowl",
			() -> new BlockItem(ExtraDelightBlocks.MIXING_BOWL.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> MORTAR_STONE = ITEMS.register("mortar_stone",
			() -> new BlockItem(ExtraDelightBlocks.MORTAR_STONE.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> MELTING_POT = ITEMS.register("melting_pot",
			() -> new BlockItem(ExtraDelightBlocks.MELTING_POT.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> CHILLER = ITEMS.register("chiller",
			() -> new BlockItem(ExtraDelightBlocks.CHILLER.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> VAT = ITEMS.register("vat", () -> new BlockItem(ExtraDelightBlocks.VAT.get(),
			new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> LID = ITEMS.register("lid",
			() -> new HelmetBlockItem(ExtraDelightBlocks.LID.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> EVAPORATOR = ITEMS.register("evaporator",
			() -> new BlockItem(ExtraDelightBlocks.EVAPORATOR.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> JUICER = ITEMS.register("juicer",
			() -> new BlockItem(ExtraDelightBlocks.JUICER.get(), new Item.Properties()));

	public static final DeferredItem<Item> BAR_MOLD = ITEMS.register("bar_mold",
			() -> new BlockItem(ExtraDelightBlocks.BAR_MOLD.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

	public static final DeferredItem<Item> FUNNEL = ITEMS.register("funnel",
			() -> new BlockItem(ExtraDelightBlocks.FUNNEL.get(), new Item.Properties()));

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

	public static final DeferredItem<Item> SHEET = ITEMS.register("sheet",
			() -> new BlockItem(ExtraDelightBlocks.SHEET_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> TRAY = ITEMS.register("tray",
			() -> new BlockItem(ExtraDelightBlocks.TRAY_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> LOAF_PAN = ITEMS.register("loaf_pan",
			() -> new BlockItem(ExtraDelightBlocks.LOAF_PAN_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> PIE_DISH = ITEMS.register("pie_dish",
			() -> new BlockItem(ExtraDelightBlocks.PIE_DISH_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> SQUARE_PAN = ITEMS.register("square_pan",
			() -> new BlockItem(ExtraDelightBlocks.SQUARE_PAN_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> BAKING_STONE = ITEMS.register("baking_stone",
			() -> new BlockItem(ExtraDelightBlocks.BAKING_STONE_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> MUFFIN_TIN = ITEMS.register("muffin_tin",
			() -> new BlockItem(ExtraDelightBlocks.MUFFIN_TIN_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));
	public static final DeferredItem<Item> SERVING_POT = ITEMS.register("serving_pot",
			() -> new HelmetBlockItem(ExtraDelightBlocks.SERVING_POT_BLOCK.get(),
					new Item.Properties().component(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY)));

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

	public static final DeferredItem<Item> TAP = ITEMS.register("tap",
			() -> new BlockItem(ExtraDelightBlocks.TAP.get(), new Item.Properties()));

	public static final DeferredItem<Item> KEG = ITEMS.register("keg_item",
			() -> new BlockItem(ExtraDelightBlocks.KEG.get(), new Item.Properties()));

	public static final DeferredItem<Item> JAR = ITEMS.register("jar", () -> new JarItem(ExtraDelightBlocks.JAR.get(),
			new Item.Properties().component(ExtraDelightComponents.FLUID.get(), SimpleFluidContent.EMPTY).stacksTo(1)));

	public static final DeferredItem<Item> WHISK = ITEMS.register("whisk",
			() -> new SwordItem(Tiers.WOOD, new Item.Properties()));

	public static final DeferredItem<Item> FRUIT_BOWL = ITEMS.register("fruit_bowl",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_BOWL.get(), new Item.Properties()));

	public static final DeferredItem<Item> YEAST = ItemRegistration
			.register("yeast", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
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

	public static final DeferredItem<Item> VINEGAR = ItemRegistration
			.register("vinegar", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
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

	public static final DeferredItem<Item> FLOUR = ItemRegistration
			.register("flour", () -> new BlockItem(ExtraDelightBlocks.FLOUR.get(), new Item.Properties()))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> COOKING_OIL = ItemRegistration
			.register("cooking_oil", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> GRAVY = ItemRegistration
			.register("gravy_boat_item", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().isHotFood().finish();

	public static final DeferredItem<Item> SLICED_ONION = ItemRegistration
			.register("sliced_onion", () -> new Item(foodItem(EDFoods.SLICED_ONION))).advancementIngredients().finish();
	public static final DeferredItem<Item> SLICED_TOMATO = ItemRegistration
			.register("sliced_tomato", () -> new Item(foodItem(EDFoods.SLICED_TOMATO))).advancementIngredients()
			.finish();

	// Seaweed
	// Agar Agar Process
	public static final DeferredItem<Item> SEAWEED_PASTE = ITEMS.register("seaweed_paste",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> AGAR_SHEETS = ITEMS.register("agar_sheets",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> AGAR_AGAR = ItemRegistration
			.register("agar_agar", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	public static final DeferredItem<Item> SEAWEED_CRISPS = ItemRegistration
			.register("seaweed_crisps", () -> new ToolTipConsumableItem(foodItem(EDFoods.SEAWEED_CRISPS), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> SEAWEED_SALAD = ItemRegistration
			.register("seaweed_salad", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.SEAWEED_SALAD), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> SUNFLOWER_SEEDS = ItemRegistration
			.register("sunflower_seeds", () -> new Item(foodItem(EDFoods.EDIBLE_SEEDS))).advancementSnack().finish();

	// Juice
	public static final DeferredItem<Item> GLOW_BERRY_JUICE = ItemRegistration
			.register("glow_berry_juice", () -> new GlowberryJuiceItem(drinkItem())).drink().setHydration(20)
			.setThirst(6).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> SWEET_BERRY_JUICE = ItemRegistration
			.register("sweet_berry_juice", () -> new MelonJuiceItem(drinkItem())).drink().setHydration(20).setThirst(6)
			.setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> TOMATO_JUICE = ItemRegistration
			.register("tomato_juice", () -> new MelonJuiceItem(drinkItem())).drink().setHydration(30).setThirst(6)
			.setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> CACTUS_JUICE = ItemRegistration
			.register("cactus_juice", () -> new CactusJuiceItem(drinkItem())).drink().setHydration(60).setThirst(6)
			.setPoison(0).isHot(false).finish();

	// Custard
	public static final DeferredItem<Item> SWEET_BERRY_CUSTARD = ItemRegistration
			.register("sweet_berry_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_CUSTARD = ItemRegistration
			.register("chocolate_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> PUMPKIN_CUSTARD = ItemRegistration
			.register("pumpkin_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert().finish();
	public static final DeferredItem<Item> HONEY_CUSTARD = ItemRegistration
			.register("honey_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert().finish();
	public static final DeferredItem<Item> APPLE_CUSTARD = ItemRegistration
			.register("apple_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert().finish();

	// Pie
	public static final DeferredItem<Item> SWEET_BERRY_PIE_SLICE = ItemRegistration
			.register("sweet_berry_pie_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> GLOW_BERRY_PIE_SLICE = ItemRegistration
			.register("glow_berry_pie_slice", () -> new GlowberryFoodItem(foodItem(FoodValues.PIE_SLICE)))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> CHEESECAKE_SLICE = ItemRegistration
			.register("cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> HONEY_CHEESECAKE_SLICE = ItemRegistration
			.register("honey_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> CHOCOLATE_CHEESECAKE_SLICE = ItemRegistration
			.register("chocolate_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> PUMPKIN_CHEESECAKE_SLICE = ItemRegistration
			.register("pumpkin_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> GLOW_BERRY_CHEESECAKE_SLICE = ItemRegistration
			.register("glow_berry_cheesecake_slice", () -> new GlowberryFoodItem(foodItem(FoodValues.PIE_SLICE)))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> APPLE_CHEESECAKE_SLICE = ItemRegistration
			.register("apple_cheesecake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();

	public static final DeferredItem<Item> SWEET_BERRY_PIE_ITEM = ItemRegistration
			.register("sweet_berry_pie",
					() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> GLOW_BERRY_PIE_ITEM = ItemRegistration
			.register("glow_berry_pie",
					() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> CHEESECAKE_ITEM = ItemRegistration
			.register("cheesecake", () -> new BlockItem(ExtraDelightBlocks.CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> HONEY_CHEESECAKE_ITEM = ItemRegistration
			.register("honey_cheesecake",
					() -> new BlockItem(ExtraDelightBlocks.HONEY_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> CHOCOLATE_CHEESECAKE_ITEM = ItemRegistration
			.register("chocolate_cheesecake",
					() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> PUMPKIN_CHEESECAKE_ITEM = ItemRegistration
			.register("pumpkin_cheesecake",
					() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> GLOW_BERRY_CHEESECAKE_ITEM = ItemRegistration
			.register("glow_berry_cheesecake",
					() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> APPLE_CHEESECAKE_ITEM = ItemRegistration
			.register("apple_cheesecake",
					() -> new BlockItem(ExtraDelightBlocks.APPLE_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	// Cookies
	public static final DeferredItem<Item> PUMPKIN_COOKIE = ItemRegistration
			.register("pumpkin_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> SUGAR_COOKIE = ItemRegistration
			.register("sugar_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GLOW_BERRY_COOKIE = ItemRegistration
			.register("glow_berry_cookie", () -> new GlowberryFoodItem(foodItem(FoodValues.COOKIES)))
			.advancementCookie().finish();
	public static final DeferredItem<Item> APPLE_COOKIE = ItemRegistration
			.register("apple_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();

	// Popsicle
	public static final DeferredItem<Item> GLOW_BERRY_POPSICLE = ItemRegistration
			.register("glow_berry_popsicle", () -> new GlowberryPopsicleItem(foodItem(FoodValues.POPSICLE)))
			.advancementDessert().isColdFood().finish();
	public static final DeferredItem<Item> SWEET_BERRY_POPSICLE = ItemRegistration
			.register("sweet_berry_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert()
			.isColdFood().finish();
	public static final DeferredItem<Item> FUDGE_POPSICLE = ItemRegistration
			.register("fudge_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert().isColdFood()
			.finish();
	public static final DeferredItem<Item> HONEY_POPSICLE = ItemRegistration
			.register("honey_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert().isColdFood()
			.finish();
	public static final DeferredItem<Item> APPLE_POPSICLE = ItemRegistration
			.register("apple_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert().isColdFood()
			.finish();

	public static final DeferredItem<Item> WHIPPED_CREAM = ItemRegistration
			.register("whipped_cream",
					() -> new Item(
							new MilkBottleItem.Properties().food(EDFoods.WHIPPED_CREAM).craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();

	// Eggs
	public static final DeferredItem<Item> EGG_MIX = ItemRegistration
			.register("egg_mix", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> SCRAMBLED_EGGS = ItemRegistration
			.register("scrambled_eggs", () -> new Item(bowlFoodItem(EDFoods.SCRAMBLED_EGGS))).advancementMeal()
			.finish();

	public static final DeferredItem<Item> OMELETTE_MIX = ItemRegistration
			.register("omelette_mix", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> OMELETTE = ItemRegistration
			.register("omelette", () -> new Item(new Item.Properties().food(EDFoods.OMELETTE))).advancementMeal()
			.finish();

	public static final DeferredItem<Item> BOILED_EGG = ItemRegistration
			.register("boiled_egg", () -> new Item(foodItem(FoodValues.FRIED_EGG))).advancementSnack().finish();

	public static final DeferredItem<Item> QUICHE = ItemRegistration
			.register("quiche", () -> new BlockItem(ExtraDelightBlocks.QUICHE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> QUICHE_SLICE = ItemRegistration
			.register("quiche_slice", () -> new Item(foodItem(EDFoods.QUICHE))).advancementMeal().servingToolTip()
			.finish();

	public static final DeferredItem<Item> EGG_BASKET = ItemRegistration
			.register("egg_in_the_basket", () -> new Item(foodItem(EDFoods.EGG_BASKET))).advancementMeal().finish();

	public static final DeferredItem<Item> EGG_SALAD = ItemRegistration
			.register("egg_salad", () -> new Item(bowlFoodItem(EDFoods.EGG_SALAD))).advancementMeal().finish();

	// Condiments
	public static final DeferredItem<Item> BBQ_SAUCE = ItemRegistration
			.register("bbq_jar_item", () -> new DrinkableItem(foodItem(EDFoods.BBQ).craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> KETCHUP = ItemRegistration
			.register("ketchup_jar_item",
					() -> new DrinkableItem(foodItem(EDFoods.KETCHUP).craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> MAYO = ItemRegistration
			.register("mayo_jar_item",
					() -> new DrinkableItem(foodItem(EDFoods.MAYO).craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> FURIKAKE = ItemRegistration
			.register("furikake", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> CURRY_POWDER = ITEMS.register("curry_powder",
			() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

	// Bread

//	public static final DeferredItem<Item> JAM_TOAST = EDItemGenerator
//			.register("jam_toast", () -> new Item(foodItem(EDFoods.JAM_BREAD))).advancementMeal().finish();
//	public static final DeferredItem<Item> GLOW_JAM_TOAST = EDItemGenerator
//			.register("glow_jam_toast", () -> new ToolTipConsumableItem(foodItem(EDFoods.GLOW_JAM_BREAD), true))
//			.advancementMeal().finish();
//	public static final DeferredItem<Item> GOLDEN_JAM_TOAST = EDItemGenerator
//			.register("golden_jam_toast", () -> new ToolTipConsumableItem(foodItem(EDFoods.GOLDEN_JAM_BREAD), true))
//			.advancementMeal().finish();

	// Potato
	public static final DeferredItem<Item> GRATED_POTATO = ItemRegistration
			.register("grated_potato", () -> new Item(foodItem(Foods.POTATO))).advancementIngredients().finish();
	public static final DeferredItem<Item> SLICED_POTATO = ItemRegistration
			.register("sliced_potato", () -> new Item(foodItem(Foods.POTATO))).advancementIngredients().finish();
	public static final DeferredItem<Item> POTATO_STICKS = ItemRegistration
			.register("potato_sticks", () -> new Item(foodItem(Foods.POTATO))).advancementIngredients().finish();

	public static final DeferredItem<Item> POTATO_CHIPS = ItemRegistration
			.register("potato_chips", () -> new Item(foodItem(EDFoods.FRIED_POTATO))).advancementSnack().finish();
	public static final DeferredItem<Item> HASHBROWNS = ItemRegistration
			.register("hashbrowns", () -> new Item(foodItem(EDFoods.FRIED_POTATO))).advancementMeal().finish();
	public static final DeferredItem<Item> FRENCH_FRIES = ItemRegistration
			.register("french_fries", () -> new Item(foodItem(EDFoods.FRIED_POTATO))).advancementMeal().finish();

	// Carrot
	public static final DeferredItem<Item> GRATED_CARROT = ItemRegistration
			.register("grated_carrot", () -> new Item(foodItem(Foods.CARROT))).advancementIngredients().finish();

	public static final DeferredItem<Item> ROASTED_CARROT = ItemRegistration
			.register("roasted_carrot", () -> new Item(foodItem(EDFoods.COOKED_CARROT))).advancementMeal().finish();
	public static final DeferredItem<Item> GLAZED_CARROT = ItemRegistration
			.register("glazed_carrot", () -> new Item(foodItem(EDFoods.GLAZED_CARROT))).advancementMeal().finish();
	public static final DeferredItem<Item> CARROT_SALAD = ItemRegistration
			.register("carrot_salad", () -> new Item(bowlFoodItem(EDFoods.CARROT_SALAD))).advancementMeal().finish();

	// Apple
	public static final DeferredItem<Item> SLICED_APPLE = ItemRegistration
			.register("sliced_apple", () -> new Item(foodItem(Foods.APPLE))).advancementIngredients().finish();
	public static final DeferredItem<Item> ROASTED_APPLE = ItemRegistration
			.register("roasted_apple", () -> new Item(foodItem(EDFoods.COOKED_APPLE))).advancementMeal().finish();
	public static final DeferredItem<Item> APPLE_SAUCE = ItemRegistration
			.register("apple_sauce", () -> new Item(bowlFoodItem(EDFoods.APPLE_SAUCE))).advancementIngredients()
			.finish();

	// Soup
	public static final DeferredItem<Item> POTATO_SOUP = ItemRegistration
			.register("potato_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.POTATO_SOUP), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> TOMATO_SOUP = ItemRegistration
			.register("tomato_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.TOMATO_SOUP), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> FISH_SOUP = ItemRegistration
			.register("fish_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FISH_SOUP), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> CARROT_SOUP = ItemRegistration
			.register("carrot_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CARROT_SOUP), true))
			.advancementMeal().isHotFood().finish();

	// Sandwiches
	public static final DeferredItem<Item> EGG_SALAD_SANDWICH = ItemRegistration
			.register("egg_salad_sandwich", () -> new Item(foodItem(FoodValues.EGG_SANDWICH))).advancementMeal()
			.finish();

	// Feasts
	public static final DeferredItem<Item> SALISBURY_STEAK_FEAST_ITEM = ItemRegistration
			.register("salisbury_steak_block_item",
					() -> new BlockItem(ExtraDelightBlocks.SALISBURY_STEAK_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> SALISBURY_STEAK = ItemRegistration
			.register("salisbury_steak", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.SALISBURY_STEAK), true))
			.advancementMeal().servingToolTip().finish();

	public static final DeferredItem<Item> MASHED_POTATO_GRAVY_FEAST_ITEM = ItemRegistration
			.register("mashed_potato_gravy_block_item",
					() -> new BlockItem(ExtraDelightBlocks.MASHED_POTATO_GRAVY.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> MASHED_POTATO_GRAVY = ItemRegistration
			.register("mashed_potato_gravy",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MASHED_POTATO_GRAVY), true))
			.advancementMeal().servingToolTip().finish();

	public static final DeferredItem<Item> CHEESE = ItemRegistration
			.register("cheese", () -> new Item(foodItem(EDFoods.CHEESE))).advancementIngredients().finish();
	public static final DeferredItem<Item> BUTTER = ItemRegistration
			.register("butter", () -> new Item(foodItem(EDFoods.BUTTER))).advancementIngredients().finish();

	public static final DeferredItem<Item> CHEESE_BLOCK_ITEM = ITEMS.register("cheese_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHEESE_STAIRS_BLOCK_ITEM = ITEMS.register("cheese_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_STAIRS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHEESE_SLAB_BLOCK_ITEM = ITEMS.register("cheese_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHEESE_SLAB_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> BUTTER_BLOCK_ITEM = ITEMS.register("butter_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> BUTTER_STAIRS_BLOCK_ITEM = ITEMS.register("butter_stairs_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_STAIRS_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> BUTTER_SLAB_BLOCK_ITEM = ITEMS.register("butter_slab_block_item",
			() -> new BlockItem(ExtraDelightBlocks.BUTTER_SLAB_BLOCK.get(), new Item.Properties()));

	// Stews
	public static final DeferredItem<Item> PORK_STEW = ItemRegistration
			.register("pork_stew", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PORK_STEW), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> LAMB_STEW = ItemRegistration
			.register("lamb_stew", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.LAMB_STEW), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> CHICKEN_STEW = ItemRegistration
			.register("chicken_stew", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHICKEN_STEW), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> CURRY = ItemRegistration
			.register("curry", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CURRY), true)).advancementMeal()
			.servingToolTip().isHotFood().finish();

	public static final DeferredItem<Item> BEEF_STEW_RICE = ItemRegistration
			.register("beef_stew_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.BEEF_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> PORK_STEW_RICE = ItemRegistration
			.register("pork_stew_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PORK_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> LAMB_STEW_RICE = ItemRegistration
			.register("lamb_stew_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.LAMB_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> RABBIT_STEW_RICE = ItemRegistration
			.register("rabbit_stew_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.RABBIT_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> CHICKEN_STEW_RICE = ItemRegistration
			.register("chicken_stew_rice",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHICKEN_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> FISH_STEW_RICE = ItemRegistration
			.register("fish_stew_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FISH_STEW_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> CURRY_RICE = ItemRegistration
			.register("curry_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CURRY_RICE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();

	public static final DeferredItem<Item> BEEF_STEW_FEAST = ItemRegistration
			.register("beef_stew_feast", () -> new BlockItem(ExtraDelightBlocks.BEEF_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> PORK_STEW_FEAST = ItemRegistration
			.register("pork_stew_feast", () -> new BlockItem(ExtraDelightBlocks.PORK_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> LAMB_STEW_FEAST = ItemRegistration
			.register("lamb_stew_feast", () -> new BlockItem(ExtraDelightBlocks.LAMB_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> RABBIT_STEW_FEAST = ItemRegistration
			.register("rabbit_stew_feast", () -> new BlockItem(ExtraDelightBlocks.RABBIT_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> CHICKEN_STEW_FEAST = ItemRegistration
			.register("chicken_stew_feast", () -> new BlockItem(ExtraDelightBlocks.CHICKEN_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> FISH_STEW_FEAST = ItemRegistration
			.register("fish_stew_feast", () -> new BlockItem(ExtraDelightBlocks.FISH_STEW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> CURRY_FEAST = ItemRegistration
			.register("curry_feast", () -> new BlockItem(ExtraDelightBlocks.CURRY.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> SAUSAGE_ROLL = ItemRegistration
			.register("sausage_roll", () -> new Item(foodItem(EDFoods.SAUSAGE_ROLL))).advancementButchercraft()
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> SOS = ItemRegistration.register("sos", () -> new Item(foodItem(EDFoods.SOS)))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> LIVER_ONIONS = ItemRegistration
			.register("liver_onions", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.LIVERONION), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> FRIED_FISH = ItemRegistration
			.register("fried_fish", () -> new Item(foodItem(EDFoods.FRIED_FISH))).advancementMeal().finish();
	public static final DeferredItem<Item> CHICKEN_FRIED_STEAK = ItemRegistration
			.register("chicken_fried_steak",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHICKEN_FRIED_STEAK), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> PORK_TENDERLOIN = ItemRegistration
			.register("pork_tenderloin", () -> new ToolTipConsumableItem(foodItem(EDFoods.PORK_TENDERLOIN), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> PORK_TENDERLOIN_SANDWICH = ItemRegistration
			.register("pork_tenderloin_sandwich",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.PORK_TENDERLOIN_SANDWICH), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> FRIED_CHICKEN = ItemRegistration
			.register("fried_chicken", () -> new ToolTipConsumableItem(foodItem(EDFoods.FRIED_CHICKEN), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> STUFFED_HEART = ItemRegistration
			.register("stuffed_heart", () -> new Item(foodItem(EDFoods.STUFFED_HEART))).advancementButchercraft()
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> FRIED_BRAINS = ItemRegistration
			.register("fried_brains", () -> new Item(foodItem(EDFoods.FRIED_BRAIN))).advancementButchercraft()
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> OXTAIL_SOUP = ItemRegistration
			.register("oxtail_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.OXTAIL_SOUP), true))
			.advancementButchercraft().butchercraftToolTip().isHotFood().finish();

	public static final DeferredItem<Item> CHEESE_SANDWICH = ItemRegistration
			.register("cheese_sandwich", () -> new Item(foodItem(EDFoods.CHEESE_SANDWICH))).advancementMeal().finish();
	public static final DeferredItem<Item> GRILLED_CHEESE = ItemRegistration
			.register("grilled_cheese", () -> new Item(foodItem(EDFoods.GRILLED_CHEESE))).advancementMeal().finish();

	public static final DeferredItem<Item> HASH = ItemRegistration
			.register("hash", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.HASH), true)).advancementMeal()
			.servingToolTip().finish();
	public static final DeferredItem<Item> POT_ROAST = ItemRegistration
			.register("potroast", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.POT_ROAST), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();

	public static final DeferredItem<Item> MEAT_LOAF_FEAST = ItemRegistration
			.register("meatloaf_feast", () -> new BlockItem(ExtraDelightBlocks.MEATLOAF_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> MEAT_LOAF = ItemRegistration
			.register("meatloaf", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MEAT_LOAF), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> MEAT_LOAF_SANDWICH = ItemRegistration
			.register("meatloaf_sandwich", () -> new ToolTipConsumableItem(foodItem(EDFoods.MEAT_LOAF_SANDWICH), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> BBQ_RIBS = ItemRegistration
			.register("bbq_ribs", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.BBQ_RIBS), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();
	public static final DeferredItem<Item> MEAT_PIE_SLICE = ItemRegistration
			.register("meat_pie_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.MEAT_PIE), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> PULLED_PORK_SANDWICH = ItemRegistration
			.register("pulled_pork_sandwich",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.PULLED_PORK_SANDWICH), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();

	public static final DeferredItem<Item> RACK_LAMB = ItemRegistration
			.register("rack_lamb", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.RACK_LAMB), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();
	public static final DeferredItem<Item> STIRFRY = ItemRegistration
			.register("stirfry", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STIRFRY_RICE), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> BEEF_WELLINGTON = ItemRegistration
			.register("beef_wellington", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.WELLINGTON), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();
	public static final DeferredItem<Item> HAGGIS = ItemRegistration
			.register("haggis", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.HAGGIS), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();

	public static final DeferredItem<Item> JELLY_WHITE = ItemRegistration
			.register("jelly_white", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_ORANGE = ItemRegistration
			.register("jelly_orange", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_MAGENTA = ItemRegistration
			.register("jelly_magenta", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_LIGHT_BLUE = ItemRegistration
			.register("jelly_light_blue", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_YELLOW = ItemRegistration
			.register("jelly_yellow", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_LIME = ItemRegistration
			.register("jelly_lime", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_PINK = ItemRegistration
			.register("jelly_pink", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_GREY = ItemRegistration
			.register("jelly_grey", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_LIGHT_GREY = ItemRegistration
			.register("jelly_light_grey", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_CYAN = ItemRegistration
			.register("jelly_cyan", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_PURPLE = ItemRegistration
			.register("jelly_purple", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_BLUE = ItemRegistration
			.register("jelly_blue", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_BROWN = ItemRegistration
			.register("jelly_brown", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_GREEN = ItemRegistration
			.register("jelly_green", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_RED = ItemRegistration
			.register("jelly_red", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> JELLY_BLACK = ItemRegistration
			.register("jelly_black", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.JELLY), true))
			.advancementDessert().servingToolTip().finish();

	public static final DeferredItem<Item> HASH_FEAST_ITEM = ItemRegistration
			.register("hash_block_item", () -> new BlockItem(ExtraDelightBlocks.HASH_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> POT_ROAST_FEAST_ITEM = ItemRegistration
			.register("pot_roast_block_item",
					() -> new BlockItem(ExtraDelightBlocks.POT_ROAST_FEAST.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> BBQ_RIBS_FEAST_ITEM = ItemRegistration
			.register("bbq_ribs_block_item", () -> new BlockItem(ExtraDelightBlocks.BBQ_RIBS_FEAST.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> MEAT_PIE_BLOCK_ITEM = ItemRegistration
			.register("meat_pie_block_item",
					() -> new BlockItem(ExtraDelightBlocks.MEAT_PIE_BLOCK.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> PULLED_PORK_FEAST_ITEM = ItemRegistration
			.register("pulled_pork_block_item",
					() -> new BlockItem(ExtraDelightBlocks.PULLED_PORK_FEAST.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> RACK_LAMB_FEAST_ITEM = ItemRegistration
			.register("rack_lamb_block_item", () -> new BlockItem(ExtraDelightBlocks.RACK_LAMB.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> STIRFRY_FEAST_ITEM = ItemRegistration
			.register("stirfry_block_item", () -> new BlockItem(ExtraDelightBlocks.STIRFRY.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> BEEF_WELLINGTON_FEAST_ITEM = ItemRegistration
			.register("beef_wellington_block_item",
					() -> new BlockItem(ExtraDelightBlocks.BEEF_WELLINGTON.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> HAGGIS_FEAST_ITEM = ItemRegistration
			.register("haggis_block_item", () -> new BlockItem(ExtraDelightBlocks.HAGGIS.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> JELLY_WHITE_FEAST_ITEM = ItemRegistration
			.register("jelly_white_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_WHITE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_ORANGE_FEAST_ITEM = ItemRegistration
			.register("jelly_orange_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_ORANGE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_MAGENTA_FEAST_ITEM = ItemRegistration
			.register("jelly_magenta_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_MAGENTA.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_LIGHT_BLUE_FEAST_ITEM = ItemRegistration
			.register("jelly_light_blue_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_YELLOW_FEAST_ITEM = ItemRegistration
			.register("jelly_yellow_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_YELLOW.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_LIME_FEAST_ITEM = ItemRegistration
			.register("jelly_lime_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_LIME.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_PINK_FEAST_ITEM = ItemRegistration
			.register("jelly_pink_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_PINK.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_GREY_FEAST_ITEM = ItemRegistration
			.register("jelly_grey_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_GREY.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_LIGHT_GREY_FEAST_ITEM = ItemRegistration
			.register("jelly_light_grey_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_LIGHT_GREY.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_CYAN_FEAST_ITEM = ItemRegistration
			.register("jelly_cyan_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_CYAN.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_PURPLE_FEAST_ITEM = ItemRegistration
			.register("jelly_purple_block_item",
					() -> new BlockItem(ExtraDelightBlocks.JELLY_PURPLE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_BLUE_FEAST_ITEM = ItemRegistration
			.register("jelly_blue_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_BLUE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_BROWN_FEAST_ITEM = ItemRegistration
			.register("jelly_brown_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_BROWN.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_GREEN_FEAST_ITEM = ItemRegistration
			.register("jelly_green_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_GREEN.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_RED_FEAST_ITEM = ItemRegistration
			.register("jelly_red_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_RED.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> JELLY_BLACK_FEAST_ITEM = ItemRegistration
			.register("jelly_black_block_item", () -> new BlockItem(ExtraDelightBlocks.JELLY_BLACK.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> JERKY = ItemRegistration
			.register("jerky", () -> new Item(foodItem(EDFoods.JERKY))).advancementSnack().finish();

	public static final DeferredItem<Item> BREAD_SLICE = ItemRegistration
			.register("bread_slice", () -> new Item(foodItem(EDFoods.SLICED_BREAD))).advancementIngredients().finish();
	public static final DeferredItem<Item> TOAST = ItemRegistration
			.register("toast", () -> new Item(foodItem(EDFoods.SLICED_BREAD))).advancementSnack().finish();
	public static final DeferredItem<Item> BREAD_CRUMBS = ItemRegistration
			.register("breadcrumbs",
					() -> new BlockItem(ExtraDelightBlocks.BREADCRUMBS.get(), foodItem(EDFoods.SLICED_BREAD)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> BREADING_MISANPLAS = ItemRegistration
			.register("breading_misanplas", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();

	// Pasta
	public static final DeferredItem<Item> MACARONI = ItemRegistration
			.register("macaroni", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> LASAGNA_NOODLES = ItemRegistration
			.register("lasagna_noodles", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	public static final DeferredItem<Item> MACARONI_CHEESE = ItemRegistration
			.register("macaroni_cheese",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MACARONI_AND_CHEESE), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> MACARONI_CHEESE_FEAST = ItemRegistration
			.register("macaroni_cheese_feast",
					() -> new BlockItem(ExtraDelightBlocks.MACARONI_CHEESE.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> LASAGNA = ItemRegistration
			.register("lasanga", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.LASAGNA), true)).advancementMeal()
			.servingToolTip().finish();
	public static final DeferredItem<Item> LASAGNA_FEAST = ItemRegistration
			.register("lasanga_feast", () -> new BlockItem(ExtraDelightBlocks.LASAGNA.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> HOTDISH = ItemRegistration
			.register("hotdish", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.HOTDISH), true)).advancementMeal()
			.servingToolTip().finish();
	public static final DeferredItem<Item> HOTDISH_FEAST = ItemRegistration
			.register("hotdish_feast", () -> new BlockItem(ExtraDelightBlocks.HOTDISH.get(), stack1Item()))
			.advancementFeast().finish();

	// Rice
	public static final DeferredItem<Item> FURIKAKE_RICE = ItemRegistration
			.register("furikake_rice", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FURIKAKE_RICE), true))
			.advancementMeal().finish();

	// Fish
	public static final DeferredItem<Item> FISH_FLAKES = ItemRegistration
			.register("fish_flakes", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> FISH_CAKES = ItemRegistration
			.register("fish_cakes", () -> new Item(foodItem(EDFoods.FISH_CAKES))).advancementMeal().finish();
	public static final DeferredItem<Item> FISH_AND_CHIPS = ItemRegistration
			.register("fish_chips", () -> new ToolTipConsumableItem(foodItem(EDFoods.FISH_CHIPS), true))
			.advancementMeal().finish();

	// Mushrooms
	public static final DeferredItem<Item> FRIED_MUSHROOMS = ItemRegistration
			.register("fried_mushrooms", () -> new Item(foodItem(EDFoods.FRIED_MUSHROOMS))).advancementMeal().finish();
	public static final DeferredItem<Item> MUSHROOM_RISOTTO = ItemRegistration
			.register("mushroom_risotto", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MUSHROOM_RISOTTO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> STUFFED_MUSHROOMS = ItemRegistration
			.register("stuffed_mushrooms", () -> new Item(foodItem(EDFoods.STUFFED_MUSHROOMS))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> MUSHROOM_BURGER = ItemRegistration
			.register("mushroom_burger", () -> new Item(foodItem(EDFoods.MUSHROOM_BURGER))).advancementMeal().finish();

	public static final DeferredItem<Item> BACON_EGG_SANDWICH = ItemRegistration
			.register("bacon_egg_sandwich", () -> new Item(foodItem(EDFoods.BACON_EGG_SANDWICH))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> BACON_EGG_CHEESE_SANDWICH = ItemRegistration
			.register("bacon_egg_cheese_sandwich", () -> new Item(foodItem(EDFoods.BACON_EGG_CHEESE_SANDWICH)))
			.advancementMeal().finish();

//	public static final DeferredItem<Item> BUTTERED_TOAST = EDItemGenerator
//			.register("buttered_toast", () -> new Item(foodItem(EDFoods.BUTTERED_TOAST))).advancementMeal().finish();

	public static final DeferredItem<Item> CROUTONS = ItemRegistration
			.register("croutons", () -> new Item(foodItem(EDFoods.SLICED_BREAD))).advancementIngredients().finish();
	public static final DeferredItem<Item> SALAD = ItemRegistration
			.register("salad", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.SALAD), true)).advancementMeal()
			.finish();
	public static final DeferredItem<Item> SALAD_FEAST_ITEM = ItemRegistration
			.register("salad_block_item", () -> new BlockItem(ExtraDelightBlocks.SALAD.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> ALFREDO_SAUCE = ItemRegistration
			.register("alfredo_sauce", () -> new Item(foodItem(EDFoods.ALFREDO_SAUCE))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> PASTA_TOMATO = ItemRegistration
			.register("pasta_tomato", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PASTA_TOMATO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> PASTA_ALFREDO = ItemRegistration
			.register("pasta_alfredo", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PASTA_ALFREDO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CHICKEN_ALFREDO = ItemRegistration
			.register("chicken_alfredo", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHICKEN_ALFREDO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CHICKEN_PARM = ItemRegistration
			.register("chicken_parm", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHICKEN_PARM), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> CHEESEBURGER = ItemRegistration
			.register("cheeseburger", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHEESEBURGER), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> BACON_CHEESEBURGER = ItemRegistration
			.register("bacon_cheeseburger", () -> new ToolTipConsumableItem(foodItem(EDFoods.BACON_CHEESEBURGER), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> RICEBALL = ItemRegistration
			.register("riceball", () -> new ToolTipConsumableItem(foodItem(EDFoods.RICEBALL), true)).advancementMeal()
			.finish();
	public static final DeferredItem<Item> RICEBALL_FILLED = ItemRegistration
			.register("riceball_filled", () -> new ToolTipConsumableItem(foodItem(EDFoods.RICEBALL_FILLED), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> FISH_SALAD = ItemRegistration
			.register("fish_salad", () -> new Item(bowlFoodItem(EDFoods.FISH_SALAD))).advancementMeal().finish();
	public static final DeferredItem<Item> FISH_SALAD_SANDWICH = ItemRegistration
			.register("fish_salad_sandwich", () -> new Item(foodItem(EDFoods.FISH_SALAD_SANDWICH))).advancementMeal()
			.finish();

	public static final DeferredItem<Item> COOKED_PASTA = ItemRegistration
			.register("cooked_pasta", () -> new Item(foodItem(Foods.BREAD).craftRemainder(Items.BOWL)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> BUTTERED_PASTA = ItemRegistration
			.register("buttered_pasta", () -> new Item(bowlFoodItem(EDFoods.BUTTERED_PASTA))).advancementMeal()
			.finish();
	public static final DeferredItem<Item> BAD_FOOD = ITEMS.register("bad_food",
			() -> new Item(foodItem(EDFoods.BADFOOD)));

	public static final DeferredItem<Item> CACTUS = ItemRegistration
			.register("cactus", () -> new Item(foodItem(EDFoods.CACTUS))).advancementIngredients().finish();
	public static final DeferredItem<Item> COOKED_CACTUS = ItemRegistration
			.register("cooked_cactus", () -> new Item(foodItem(EDFoods.COOKED_CACTUS))).advancementMeal().finish();
	public static final DeferredItem<Item> CACTUS_EGGS = ItemRegistration
			.register("cactus_eggs", () -> new Item(bowlFoodItem(EDFoods.CACTUS_EGGS))).advancementMeal().finish();
	public static final DeferredItem<Item> CACTUS_SOUP = ItemRegistration
			.register("cactus_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CACTUS_SOUP), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> CACTUS_SALAD = ItemRegistration
			.register("cactus_salad", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CACTUS_SALAD), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> STUFFED_CACTUS = ItemRegistration
			.register("stuffed_cactus", () -> new ToolTipConsumableItem(foodItem(EDFoods.STUFFED_CACTUS), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> CORN_SEEDS = ItemRegistration
			.register("corn_seeds",
					() -> new ItemNameBlockItem(ExtraDelightBlocks.CORN_BOTTOM.get(), new Item.Properties()))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> UNSHUCKED_CORN = ITEMS.register("unshucked_corn",
			() -> new ShuckableCorn(MiscLootTables.SHUCKED_CORN, new Item.Properties()));
	public static final DeferredItem<Item> CORN_ON_COB = ItemRegistration
			.register("corn_on_cob", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> CORN_HUSK = ITEMS.register("corn_husk",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DRIED_CORN_HUSK = ITEMS.register("dried_corn_husk",
			() -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			});
	public static final DeferredItem<Item> CORN_SILK = ItemRegistration
			.register("corn_silk", () -> new Item(new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 100;
				}
			}).advancementIngredients().finish();
	public static final DeferredItem<Item> CORN_COB = ITEMS.register("corn_cob", () -> new Item(new Item.Properties()) {
		public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
			return 200;
		}
	});
	public static final DeferredItem<Item> CORN_MEAL = ItemRegistration
			.register("corn_meal", () -> new BlockItem(ExtraDelightBlocks.CORNMEAL.get(), new Item.Properties()))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> CORN_CHOWDER = ItemRegistration
			.register("corn_chowder", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CORN_CHOWDER), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> CREAM_CORN = ItemRegistration
			.register("cream_corn", () -> new Item(bowlFoodItem(EDFoods.CREAMED_CORN))).advancementMeal().finish();
	public static final DeferredItem<Item> CORN_FRITTERS = ItemRegistration
			.register("corn_fritters", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CORN_FRITTERS), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> POPCORN = ItemRegistration
			.register("popcorn", () -> new Item(bowlFoodItem(EDFoods.POPCORN))).advancementSnack().finish();
	public static final DeferredItem<Item> GRILLED_CORN_ON_COB = ItemRegistration
			.register("grilled_corn_on_cob", () -> new Item(foodItem(EDFoods.GRILLED_CORN))).advancementMeal().finish();
	public static final DeferredItem<Item> COOKED_CORN = ItemRegistration
			.register("cooked_corn", () -> new Item(foodItem(EDFoods.COOKED_CORN))).advancementIngredients().finish();
	public static final DeferredItem<Item> ROASTED_PUMPKIN_SEEDS = ItemRegistration
			.register("roasted_pumpkin_seeds", () -> new Item(foodItem(EDFoods.EDIBLE_SEEDS))).advancementSnack()
			.finish();
	public static final DeferredItem<Item> TEA = ItemRegistration
			.register("tea", () -> new CornSilkTeaItem(drinkItem())).drink().setHydration(20).setThirst(4).setPoison(0)
			.isHot(true).finish();
	public static final DeferredItem<Item> STEWED_APPLES = ItemRegistration
			.register("stewed_apples", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STEWED_APPLES), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> APPLE_FRITTERS = ItemRegistration
			.register("apple_fritters", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.APPLE_FRITTERS), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CARAMEL_SAUCE = ItemRegistration
			.register("caramel_sauce", () -> new Item(bottleFoodItem(EDFoods.CARAMEL_SAUCE))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> CARAMEL_CANDY = ItemRegistration
			.register("caramel_candy", () -> new ToolTipConsumableItem(foodItem(EDFoods.CARAMEL_CANDY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_APPLE = ItemRegistration
			.register("candy_apple", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY_APPLE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> CARAMEL_APPLE = ItemRegistration
			.register("caramel_apple", () -> new ToolTipConsumableItem(foodItem(EDFoods.CARAMEL_APPLE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> CANDY_GOLDEN_APPLE = ItemRegistration
			.register("candy_golden_apple", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY_GOLDEN_APPLE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> CARAMEL_GOLDEN_APPLE = ItemRegistration
			.register("caramel_golden_apple",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CARAMEL_GOLDEN_APPLE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> CARAMEL_POPCORN = ItemRegistration
			.register("caramel_popcorn", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CARAMEL_POPCORN), true))
			.advancementSnack().finish();
	public static final DeferredItem<Item> CARAMEL_CUSTARD = ItemRegistration
			.register("caramel_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert().finish();
	public static final DeferredItem<Item> CARAMEL_POPSICLE = ItemRegistration
			.register("caramel_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert()
			.isColdFood().finish();

	public static final DeferredItem<Item> CARAMEL_CHEESECAKE_SLICE = ItemRegistration
			.register("caramel_cheescake_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> CARAMEL_CHEESECAKE_ITEM = ItemRegistration
			.register("caramel_cheesecake_item",
					() -> new BlockItem(ExtraDelightBlocks.CARAMEL_CHEESECAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> CORNBREAD = ItemRegistration
			.register("cornbread", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CORNBREAD), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> CORNBREAD_FEAST = ItemRegistration
			.register("cornbread_feast", () -> new BlockItem(ExtraDelightBlocks.CORNBREAD.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> CORN_PUDDING = ItemRegistration
			.register("corn_pudding", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CORN_PUDDING), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> CORN_PUDDING_FEAST = ItemRegistration
			.register("corn_pudding_feast", () -> new BlockItem(ExtraDelightBlocks.CORN_PUDDING.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> PUMPKIN_PIE_SLICE = ItemRegistration
			.register("pumpkin_pie_slice", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> PUMPKIN_PIE_ITEM = ItemRegistration
			.register("pumpkin_pie_item",
					() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> PUMPKIN_ROLL = ItemRegistration
			.register("pumpkin_roll", () -> new Item(foodItem(FoodValues.PIE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> PUMPKIN_ROLL_FEAST = ItemRegistration
			.register("pumpkin_roll_feast",
					() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_ROLL.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> APPLE_CRISP = ItemRegistration
			.register("apple_crisp", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.APPLE_CRISP), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> APPLE_CRISP_FEAST = ItemRegistration
			.register("apple_crisp_feast", () -> new BlockItem(ExtraDelightBlocks.APPLE_CRISP.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> STUFFING = ItemRegistration
			.register("stuffing", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STUFFING), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> STUFFING_FEAST = ItemRegistration
			.register("stuffing_feast", () -> new BlockItem(ExtraDelightBlocks.STUFFING.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> POTATO_AU_GRATIN = ItemRegistration
			.register("potato_au_gratin",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.POTATOES_AU_GRATIN), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> POTATO_AU_GRATIN_FEAST = ItemRegistration
			.register("potato_au_gratin_feast",
					() -> new BlockItem(ExtraDelightBlocks.POTATO_AU_GRATIN.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> FLOUR_SACK = ITEMS.register("flour_sack",
			() -> new BlockItem(ExtraDelightBlocks.FLOUR_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORNMEAL_SACK = ITEMS.register("cornmeal_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORNMEAL_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> SUGAR_SACK = ITEMS.register("sugar_sack",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORN_CRATE = ITEMS.register("corn_crate",
			() -> new BlockItem(ExtraDelightBlocks.CORN_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORN_HUSK_BUNDLE = ITEMS.register("corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_HUSK_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DRIED_CORN_HUSK_BUNDLE = ITEMS.register("dried_corn_husk_bundle",
			() -> new BlockItem(ExtraDelightBlocks.DRIED_CORN_HUSK_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORN_COB_BUNDLE = ITEMS.register("corn_cob_bundle",
			() -> new BlockItem(ExtraDelightBlocks.CORN_COB_BUNDLE.get(), new Item.Properties()));
	public static final DeferredItem<Item> BREADCRUMB_SACK = ITEMS.register("breadcrumb_sack",
			() -> new BlockItem(ExtraDelightBlocks.BREADCRUMB_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> EGG_CRATE = ITEMS.register("egg_crate",
			() -> new BlockItem(ExtraDelightBlocks.EGG_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> APPLE_CRATE = ITEMS.register("apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> GOLDEN_APPLE_CRATE = ITEMS.register("golden_apple_crate",
			() -> new BlockItem(ExtraDelightBlocks.GOLDEN_APPLE_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> BROWN_MUSHROOM_CRATE = ITEMS.register("brown_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_MUSHROOM_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> RED_MUSHROOM_CRATE = ITEMS.register("red_mushroom_crate",
			() -> new BlockItem(ExtraDelightBlocks.RED_MUSHROOM_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> SWEET_BERRY_CRATE = ITEMS.register("sweet_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> GLOW_BERRY_CRATE = ITEMS.register("glow_berry_crate",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORN_SILK_SACK = ITEMS.register("corn_silk_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORN_SILK_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CORN_SACK = ITEMS.register("corn_sack",
			() -> new BlockItem(ExtraDelightBlocks.CORN_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> CORN_COB_PIPE = ITEMS.register("corn_cob_pipe",
			() -> new CorncobPipe(new Item.Properties()));

	// Winter start!
	public static final DeferredItem<Item> CINNAMON_LOG = ITEMS.register("cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_WOOD = ITEMS.register("cinnamon_wood",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_WOOD.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> STRIPPED_CINNAMON_LOG = ITEMS.register("stripped_cinnamon_log",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_CINNAMON_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> STRIPPED_CINNAMON_WOOD = ITEMS.register("strippedcinnamon_wood",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_CINNAMON_WOOD.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_PLANKS = ITEMS.register("cinnamon_planks",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_PLANKS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_LEAVES = ITEMS.register("cinnamon_leaves",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_LEAVES.get(), new Item.Properties()));
	public static final DeferredItem<Item> CINNAMON_FENCE = ITEMS.register("cinnamon_fence",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_FENCE_GATE = ITEMS.register("cinnamon_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_FENCE_GATE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_STAIRS = ITEMS.register("cinnamon_stairs",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STAIRS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_DOOR = ITEMS.register("cinnamon_door",
			() -> new DoubleHighBlockItem(ExtraDelightBlocks.CINNAMON_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> CINNAMON_TRAPDOOR = ITEMS.register("cinnamon_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_TRAPDOOR.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_CABINET = ITEMS.register("cinnamon_cabinet",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_CABINET.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> CINNAMON_SLAB = ITEMS.register("cinnamon_slab",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SLAB.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> CINNAMON_BUTTON = ITEMS.register("cinnamon_button",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_BUTTON.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> CINNAMON_PRESSURE_PLATE = ITEMS.register("cinnamon_pressure_plate",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_PRESSURE_PLATE.get(), new Item.Properties()) {
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
	public static final DeferredItem<Item> RAW_CINNAMON_BLOCK = ITEMS.register("raw_cinnamon_block",
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
	public static final DeferredItem<Item> CINNAMON_STICK_BLOCK = ITEMS.register("cinnamon_stick_block",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_STICK_BLOCK.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 900;
				}
			});
	public static final DeferredItem<Item> GROUND_CINNAMON = ItemRegistration
			.register("ground_cinnamon", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> GROUND_CINNAMON_BLOCK_ITEM = ITEMS.register("ground_cinnamon_sack",
			() -> new BlockItem(ExtraDelightBlocks.GROUND_CINNAMON_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> ICE_CREAM = ItemRegistration
			.register("ice_cream", () -> new Item(bowlFoodItem(EDFoods.ICE_CREAM))).advancementDessert().isColdFood()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ItemRegistration
			.register("chocolate_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().isColdFood().finish();
	public static final DeferredItem<Item> GLOW_BERRY_ICE_CREAM = ItemRegistration
			.register("glow_berry_ice_cream", () -> new GlowberryFoodItem(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().isColdFood().finish();
	public static final DeferredItem<Item> SWEET_BERRY_ICE_CREAM = ItemRegistration
			.register("sweet_berry_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().isColdFood().finish();
	public static final DeferredItem<Item> PUMPKIN_ICE_CREAM = ItemRegistration
			.register("pumpkin_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM))).advancementDessert()
			.isColdFood().finish();
	public static final DeferredItem<Item> HONEY_ICE_CREAM = ItemRegistration
			.register("honey_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM))).advancementDessert()
			.isColdFood().finish();
	public static final DeferredItem<Item> APPLE_ICE_CREAM = ItemRegistration
			.register("apple_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM))).advancementDessert()
			.isColdFood().finish();
	public static final DeferredItem<Item> COOKIE_DOUGH_ICE_CREAM = ItemRegistration
			.register("cookie_dough_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().isColdFood().finish();
	public static final DeferredItem<Item> MINT_CHIP_ICE_CREAM = ItemRegistration
			.register("mint_chip_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().isColdFood().finish();

	public static final DeferredItem<Item> MILKSHAKE = ItemRegistration
			.register("milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 2f)).drink().setHydration(20).setThirst(2)
			.setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> CHOCOLATE_MILKSHAKE = ItemRegistration
			.register("chocolate_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> GLOW_BERRY_MILKSHAKE = ItemRegistration
			.register("glow_berry_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> SWEET_BERRY_MILKSHAKE = ItemRegistration
			.register("sweet_berry_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> PUMPKIN_MILKSHAKE = ItemRegistration
			.register("pumpkin_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> HONEY_MILKSHAKE = ItemRegistration
			.register("honey_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> APPLE_MILKSHAKE = ItemRegistration
			.register("apple_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> COOKIE_DOUGH_MILKSHAKE = ItemRegistration
			.register("cookie_dough_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> MINT_CHIP_MILKSHAKE = ItemRegistration
			.register("mint_chip_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();

	public static final DeferredItem<Item> CHOCOLATE_MILK = ItemRegistration
			.register("chocolate_milk", () -> new HotCocoaItem(drinkItem())).drink().setHydration(30).setThirst(2)
			.setPoison(0).isHot(false).finish();

	public static final DeferredItem<Item> EGGNOG = ItemRegistration
			.register("eggnog", () -> new HotCocoaItem(drinkItem())).drink().setHydration(20).setThirst(2).setPoison(0)
			.isHot(true).finish();
	public static final DeferredItem<Item> GINGER_BEER = ItemRegistration
			.register("ginger_beer", () -> new MelonJuiceItem(drinkItem())).drink().setHydration(30).setThirst(4)
			.setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> HORCHATA = ItemRegistration
			.register("horchata", () -> new HotCocoaItem(drinkItem())).drink().setHydration(40).setThirst(4)
			.setPoison(0).isHot(false).finish();

	public static final DeferredItem<Item> GINGERBREAD_COOKIE_DOUGH = ItemRegistration
			.register("gingerbread_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_DOUGH = ItemRegistration
			.register("sugar_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> PUMPKIN_COOKIE_DOUGH = ItemRegistration
			.register("pumpkin_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> GLOW_BERRY_COOKIE_DOUGH = ItemRegistration
			.register("glow_berry_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> APPLE_COOKIE_DOUGH = ItemRegistration
			.register("apple_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> SWEET_BERRY_COOKIE_DOUGH = ItemRegistration
			.register("sweet_berry_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> HONEY_COOKIE_DOUGH = ItemRegistration
			.register("honey_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_CHIP_COOKIE_DOUGH = ItemRegistration
			.register("chocolate_chip_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> GINGERBREAD_COOKIE = ItemRegistration
			.register("gingerbread_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();

	public static final DeferredItem<Item> GINGERBREAD_STEVE = ItemRegistration
			.register("gingerbread_steve", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_ALEX = ItemRegistration
			.register("gingerbread_alex", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_VILLAGER = ItemRegistration
			.register("gingerbread_villager", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();
	public static final DeferredItem<Item> GINGERBREAD_CREEPER = ItemRegistration
			.register("gingerbread_creeper", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_SWORD = ItemRegistration
			.register("gingerbread_sword", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_PICKAXE = ItemRegistration
			.register("gingerbread_pickaxe", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_DIAMOND = ItemRegistration
			.register("gingerbread_diamond", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> GINGERBREAD_EMERALD = ItemRegistration
			.register("gingerbread_emerald", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();

	public static final DeferredItem<Item> SUGAR_COOKIE_STEVE = ItemRegistration
			.register("sugar_cookie_steve", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_ALEX = ItemRegistration
			.register("sugar_cookie_alex", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_VILLAGER = ItemRegistration
			.register("sugar_cookie_villager", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_CREEPER = ItemRegistration
			.register("sugar_cookie_creeper", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_SWORD = ItemRegistration
			.register("sugar_cookie_sword", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_PICKAXE = ItemRegistration
			.register("sugar_cookie_pickaxe", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_DIAMOND = ItemRegistration
			.register("sugar_cookie_diamond", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();
	public static final DeferredItem<Item> SUGAR_COOKIE_EMERALD = ItemRegistration
			.register("sugar_cookie_emerald", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie()
			.finish();

	public static final DeferredItem<Item> RAW_GINGERBREAD_STEVE = ITEMS.register("raw_gingerbread_steve",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_ALEX = ITEMS.register("raw_gingerbread_alex",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_VILLAGER = ITEMS.register("raw_gingerbread_villager",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_CREEPER = ITEMS.register("raw_gingerbread_creeper",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_SWORD = ITEMS.register("raw_gingerbread_sword",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_PICKAXE = ITEMS.register("raw_gingerbread_pickaxe",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_DIAMOND = ITEMS.register("raw_gingerbread_diamond",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_GINGERBREAD_EMERALD = ITEMS.register("raw_gingerbread_emerald",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));

	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_STEVE = ITEMS.register("raw_sugar_cookie_steve",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_ALEX = ITEMS.register("raw_sugar_cookie_alex",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_VILLAGER = ITEMS.register("raw_sugar_cookie_villager",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_CREEPER = ITEMS.register("raw_sugar_cookie_creeper",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_SWORD = ITEMS.register("raw_sugar_cookie_sword",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_PICKAXE = ITEMS.register("raw_sugar_cookie_pickaxe",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_DIAMOND = ITEMS.register("raw_sugar_cookie_diamond",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));
	public static final DeferredItem<Item> RAW_SUGAR_COOKIE_EMERALD = ITEMS.register("raw_sugar_cookie_emerald",
			() -> new Item(foodItem(EDFoods.COOKIE_DOUGH)));

	public static final DeferredItem<Item> APPLE_COOKIE_BLOCK = ITEMS.register("apple_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHOCOLATE_CHIP_COOKIE_BLOCK = ITEMS.register(
			"chocolate_chip_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CHIP_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_COOKIE_BLOCK = ITEMS.register("gingerbread_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.GINGERBREAD_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GLOW_BERRY_COOKIE_BLOCK = ITEMS.register("glow_berry_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.GLOW_BERRY_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> HONEY_COOKIE_BLOCK = ITEMS.register("honey_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.HONEY_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PUMPKIN_COOKIE_BLOCK = ITEMS.register("pumpkin_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.PUMPKIN_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> SUGAR_COOKIE_BLOCK = ITEMS.register("sugar_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SUGAR_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> SWEET_BERRY_COOKIE_BLOCK = ITEMS.register("sweet_berry_cookie_block_item",
			() -> new BlockItem(ExtraDelightBlocks.SWEET_BERRY_COOKIE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> GINGER = ITEMS.register("ginger", () -> new Item(foodItem(Foods.POTATO)));
	public static final DeferredItem<Item> GINGER_CUTTING = ITEMS.register("ginger_cutting",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.GINGER_CROP.get(), new Item.Properties()));
	public static final DeferredItem<Item> WILD_GINGER = ITEMS.register("wild_ginger",
			() -> new BlockItem(ExtraDelightBlocks.WILD_GINGER.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGER_CRATE = ITEMS.register("ginger_crate",
			() -> new BlockItem(ExtraDelightBlocks.GINGER_CRATE.get(), new Item.Properties()));

	public static final DeferredItem<Item> MINT = ItemRegistration
			.register("mint", () -> new ItemNameBlockItem(ExtraDelightBlocks.MINT_CROP.get(), new Item.Properties()))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> MINT_SACK = ITEMS.register("mint_sack",
			() -> new BlockItem(ExtraDelightBlocks.MINT_SACK.get(), new Item.Properties()));

	public static final DeferredItem<Item> PEELED_GINGER = ITEMS.register("peeled_ginger",
			() -> new Item(foodItem(Foods.POTATO)));
	public static final DeferredItem<Item> SLICED_GINGER = ItemRegistration
			.register("sliced_ginger", () -> new Item(foodItem(Foods.POTATO))).advancementIngredients().finish();
	public static final DeferredItem<Item> GRATED_GINGER = ItemRegistration
			.register("grated_ginger", () -> new Item(foodItem(Foods.POTATO))).advancementIngredients().finish();

	public static final DeferredItem<Item> FROSTING_WHITE = ItemRegistration
			.register("frosting_white", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_LIGHT_GRAY = ItemRegistration
			.register("frosting_light_gray", () -> new FrostingItem(foodItem(EDFoods.FROSTING)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> FROSTING_GRAY = ItemRegistration
			.register("frosting_gray", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_BLACK = ItemRegistration
			.register("frosting_black", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_BROWN = ItemRegistration
			.register("frosting_brown", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_RED = ItemRegistration
			.register("frosting_red", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_ORANGE = ItemRegistration
			.register("frosting_orange", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_YELLOW = ItemRegistration
			.register("frosting_yellow", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_LIME = ItemRegistration
			.register("frosting_lime", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_GREEN = ItemRegistration
			.register("frosting_green", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_CYAN = ItemRegistration
			.register("frosting_cyan", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_LIGHT_BLUE = ItemRegistration
			.register("frosting_light_blue", () -> new FrostingItem(foodItem(EDFoods.FROSTING)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> FROSTING_BLUE = ItemRegistration
			.register("frosting_blue", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_PURPLE = ItemRegistration
			.register("frosting_purple", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_MAGENTA = ItemRegistration
			.register("frosting_magenta", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> FROSTING_PINK = ItemRegistration
			.register("frosting_pink", () -> new FrostingItem(foodItem(EDFoods.FROSTING))).advancementIngredients()
			.finish();

	public static final DeferredItem<Item> CANDY_WHITE = ItemRegistration
			.register("candy_white", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_LIGHT_GRAY = ItemRegistration
			.register("candy_light_gray", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_GRAY = ItemRegistration
			.register("candy_gray", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_BLACK = ItemRegistration
			.register("candy_black", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_BROWN = ItemRegistration
			.register("candy_brown", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_RED = ItemRegistration
			.register("candy_red", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_ORANGE = ItemRegistration
			.register("candy_orange", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_YELLOW = ItemRegistration
			.register("candy_yellow", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_LIME = ItemRegistration
			.register("candy_lime", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_GREEN = ItemRegistration
			.register("candy_green", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_CYAN = ItemRegistration
			.register("candy_cyan", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_LIGHT_BLUE = ItemRegistration
			.register("candy_light_blue", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_BLUE = ItemRegistration
			.register("candy_blue", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_PURPLE = ItemRegistration
			.register("candy_purple", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> CANDY_MAGENTA = ItemRegistration
			.register("candy_magenta", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_PINK = ItemRegistration
			.register("candy_pink", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY), true)).advancementCandy()
			.finish();

	public static final DeferredItem<Item> GINGERBREAD_BLOCK_WHITE = ITEMS.register("gingerbread_block_white",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_LIGHT_GRAY = ITEMS.register("gingerbread_block_light_gray",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_GRAY_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_GRAY = ITEMS.register("gingerbread_block_gray",
			() -> new BlockItem(ExtraDelightBlocks.GRAY_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_BLACK = ITEMS.register("gingerbread_block_black",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_BROWN = ITEMS.register("gingerbread_block_brown",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_RED = ITEMS.register("gingerbread_block_red",
			() -> new BlockItem(ExtraDelightBlocks.RED_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_ORANGE = ITEMS.register("gingerbread_block_orange",
			() -> new BlockItem(ExtraDelightBlocks.ORANGE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_YELLOW = ITEMS.register("gingerbread_block_yellow",
			() -> new BlockItem(ExtraDelightBlocks.YELLOW_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_LIME = ITEMS.register("gingerbread_block_lime",
			() -> new BlockItem(ExtraDelightBlocks.LIME_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_GREEN = ITEMS.register("gingerbread_block_green",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_CYAN = ITEMS.register("gingerbread_block_cyan",
			() -> new BlockItem(ExtraDelightBlocks.CYAN_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_LIGHT_BLUE = ITEMS.register("gingerbread_block_light_blue",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_BLUE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_BLUE = ITEMS.register("gingerbread_block_blue",
			() -> new BlockItem(ExtraDelightBlocks.BLUE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_PURPLE = ITEMS.register("gingerbread_block_purple",
			() -> new BlockItem(ExtraDelightBlocks.PURPLE_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_MAGENTA = ITEMS.register("gingerbread_block_magenta",
			() -> new BlockItem(ExtraDelightBlocks.MAGENTA_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GINGERBREAD_BLOCK_PINK = ITEMS.register("gingerbread_block_pink",
			() -> new BlockItem(ExtraDelightBlocks.PINK_FROSTED_GINGERBREAD_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> CANDY_BOWL_ITEM = ITEMS.register("candy_bowl_item",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_BOWL.get(), new Item.Properties()));

	public static final DeferredItem<Item> MINT_CANDY_RED = ItemRegistration
			.register("mint_candy_red", () -> new Item(foodItem(EDFoods.SUGAR))).advancementCandy().finish();
	public static final DeferredItem<Item> MINT_CANDY_GREEN = ItemRegistration
			.register("mint_candy_green", () -> new Item(foodItem(EDFoods.SUGAR))).advancementCandy().finish();
	public static final DeferredItem<Item> MINT_CANDY_BLUE = ItemRegistration
			.register("mint_candy_blue", () -> new Item(foodItem(EDFoods.SUGAR))).advancementCandy().finish();

	public static final DeferredItem<Item> CANDY_CANE_RED = ItemRegistration
			.register("candy_cane_red", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY_CANE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_CANE_GREEN = ItemRegistration
			.register("candy_cane_green", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY_CANE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> CANDY_CANE_BLUE = ItemRegistration
			.register("candy_cane_blue", () -> new ToolTipConsumableItem(foodItem(EDFoods.CANDY_CANE), true))
			.advancementCandy().finish();

	public static final DeferredItem<Item> CANDY_CANE_RED_BLOCK = ITEMS.register("candy_cane_red_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_RED_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CANDY_CANE_GREEN_BLOCK = ITEMS.register("candy_cane_green_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_GREEN_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CANDY_CANE_BLUE_BLOCK = ITEMS.register("candy_cane_blue_block",
			() -> new BlockItem(ExtraDelightBlocks.CANDY_CANE_BLUE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> FRENCH_TOAST = ItemRegistration
			.register("french_toast", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FRENCH_TOAST), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> CONGEE = ItemRegistration
			.register("congee", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CONGEE), true)).advancementMeal()
			.isHotFood().finish();
	public static final DeferredItem<Item> LUGAW = ItemRegistration
			.register("lugaw", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.LUGAW), true)).advancementMeal()
			.isHotFood().finish();
	public static final DeferredItem<Item> RICE_PUDDING = ItemRegistration
			.register("rice_pudding", () -> new Item(bottleFoodItem(FoodValues.GLOW_BERRY_CUSTARD)))
			.advancementDessert().finish();

	public static final DeferredItem<Item> MUFFIN_GINGER = ItemRegistration
			.register("muffin_ginger", () -> new Item(foodItem(EDFoods.MUFFIN))).advancementDessert().finish();
	public static final DeferredItem<Item> MUFFIN_CINNAMON = ItemRegistration
			.register("muffin_cinnamon", () -> new Item(foodItem(EDFoods.MUFFIN))).advancementDessert().finish();
	public static final DeferredItem<Item> MUFFIN_SWEET_BERRY = ItemRegistration
			.register("muffin_sweet_berry", () -> new Item(foodItem(EDFoods.MUFFIN))).advancementDessert().finish();
	public static final DeferredItem<Item> MUFFIN_APPLE = ItemRegistration
			.register("muffin_apple", () -> new Item(foodItem(EDFoods.MUFFIN))).advancementDessert().finish();

	public static final DeferredItem<Item> DRIED_FRUIT = ItemRegistration
			.register("dried_fruit", () -> new Item(foodItem(Foods.APPLE))).advancementIngredients().finish();
	public static final DeferredItem<Item> FRUIT_BREAD = ItemRegistration
			.register("fruit_bread", () -> new Item(foodItem(EDFoods.FILLED_BREAD))).advancementDessert().finish();
	public static final DeferredItem<Item> PICKLED_GINGER = ItemRegistration
			.register("pickled_ginger", () -> new Item(foodItem(EDFoods.PICKLED_GINGER))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> CANDIED_GINGER = ItemRegistration
			.register("candied_ginger", () -> new Item(foodItem(EDFoods.SUGAR))).advancementCandy().finish();
	public static final DeferredItem<Item> CINNAMON_POPSICLE = ItemRegistration
			.register("cinnamon_popsicle", () -> new Item(foodItem(FoodValues.POPSICLE))).advancementDessert().finish();
	public static final DeferredItem<Item> BEET_MINT_SALAD = ItemRegistration
			.register("beet_mint_salad", () -> new Item(foodItem(EDFoods.BEET_MINT))).advancementMeal().finish();
//	public static final DeferredItem<Item> MINT_JELLY = EDItemGenerator
//			.register("mint_jelly", () -> new Item(foodItem(EDFoods.JAM))).advancementIngredients().finish();
	public static final DeferredItem<Item> CRACKERS = ItemRegistration
			.register("crackers", () -> new Item(foodItem(EDFoods.CRACKER))).advancementSnack().finish();
	public static final DeferredItem<Item> CROQUE_MONSIEUR = ItemRegistration
			.register("croque_monsieur", () -> new ToolTipConsumableItem(foodItem(EDFoods.CROQUE_MONSIEUR), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CROQUE_MADAME = ItemRegistration
			.register("croque_madame", () -> new ToolTipConsumableItem(foodItem(EDFoods.CROQUE_MADAME), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> ROLL = ItemRegistration
			.register("roll", () -> new Item(foodItem(EDFoods.ROLL))).advancementSnack().finish();

	public static final DeferredItem<Item> CINNAMON_ROLL = ItemRegistration
			.register("cinnamon_rolls", () -> new ToolTipConsumableItem(foodItem(EDFoods.CINNAMON_ROLL), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> CINNAMON_ROLLS_FEAST = ItemRegistration
			.register("cinnamon_rolls_feast",
					() -> new BlockItem(ExtraDelightBlocks.CINNAMON_ROLLS.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> MONKEY_BREAD = ItemRegistration
			.register("monkey_bread", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MONKEY_BREAD), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> MONKEY_BREAD_FEAST = ItemRegistration
			.register("monkey_bread_feast", () -> new BlockItem(ExtraDelightBlocks.MONKEY_BREAD.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> COFFEE_CAKE_SLICE = ItemRegistration
			.register("coffee_cake_slice", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert()
			.servingToolTip().finish();
	public static final DeferredItem<Item> COFFEE_CAKE_FEAST = ItemRegistration
			.register("coffe_cake_feast",
					() -> new BlockItem(ExtraDelightBlocks.COFFEE_CAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> MINT_LAMB = ItemRegistration
			.register("mint_lamb", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MINT_LAMB), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();
	public static final DeferredItem<Item> MINT_LAMB_FEAST = ItemRegistration
			.register("mint_lamb_feast", () -> new BlockItem(ExtraDelightBlocks.MINT_LAMB.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> CHARCUTERIE_BOARD = ItemRegistration
			.register("charcuterie_board", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHARCUTERIE), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> CHARCUTERIE_BOARD_FEAST = ItemRegistration
			.register("charcuterie_board_feast",
					() -> new BlockItem(ExtraDelightBlocks.CHARCUTERIE_BOARD.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> CHRISTMAS_PUDDING = ItemRegistration
			.register("christmas_pudding",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHRISTMAS_PUDDING), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> CHRISTMAS_PUDDING_FEAST = ItemRegistration
			.register("christmas_pudding_feast",
					() -> new BlockItem(ExtraDelightBlocks.CHRISTMAS_PUDDING.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> PUNCH = ItemRegistration
			.register("punch", () -> new MelonJuiceItem(drinkItem())).servingToolTip().drink().setHydration(60)
			.setThirst(6).isHot(false).setPoison(0).finish();
	public static final DeferredItem<Item> PUNCH_FEAST = ItemRegistration
			.register("punch_feast", () -> new BlockItem(ExtraDelightBlocks.PUNCH.get(), stack1Item()))
			.advancementFeast().finish();

	public static final DeferredItem<Item> MILK_TART_SLICE = ItemRegistration
			.register("milk_tart_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.MILK_TART), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> MILK_TART_FEAST = ItemRegistration
			.register("milk_tart_feast", () -> new BlockItem(ExtraDelightBlocks.MILK_TART.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();

	public static final DeferredItem<Item> CINNAMON_SAPLING = ITEMS.register("cinnamon_sapling",
			() -> new BlockItem(ExtraDelightBlocks.CINNAMON_SAPLING.get(), new Item.Properties()));

	public static final DeferredItem<Item> FRUIT_LOG = ITEMS.register("fruit_log",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_WOOD = ITEMS.register("fruit_wood",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_WOOD.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> STRIPPED_FRUIT_LOG = ITEMS.register("stripped_fruit_log",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_FRUIT_LOG.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> STRIPPED_FRUIT_WOOD = ITEMS.register("stripped_fruit_wood",
			() -> new BlockItem(ExtraDelightBlocks.STRIPPED_FRUIT_WOOD.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_DOOR = ITEMS.register("fruit_door",
			() -> new DoubleHighBlockItem(ExtraDelightBlocks.FRUIT_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> FRUIT_PLANKS = ITEMS.register("fruit_planks",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_PLANKS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_FENCE = ITEMS.register("fruit_fence",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_FENCE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_FENCE_GATE = ITEMS.register("fruit_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_FENCE_GATE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_STAIRS = ITEMS.register("fruit_stairs",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_STAIRS.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_TRAPDOOR = ITEMS.register("fruit_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_TRAPDOOR.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_CABINET = ITEMS.register("fruit_cabinet",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_CABINET.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});
	public static final DeferredItem<Item> FRUIT_SLAB = ITEMS.register("fruit_slab",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_SLAB.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> FRUIT_BUTTON = ITEMS.register("fruit_button",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_BUTTON.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> FRUIT_PRESSURE_PLATE = ITEMS.register("fruit_pressure_plate",
			() -> new BlockItem(ExtraDelightBlocks.FRUIT_PRESSURE_PLATE.get(), new Item.Properties()) {
				public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final DeferredItem<Item> HAZELNUT_LEAVES = ITEMS.register("hazelnut_leaves",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_LEAVES.get(), new Item.Properties()));

	public static final DeferredItem<Item> MARSHMALLOW_BLOCK = ITEMS.register("marshmallow_block",
			() -> new BlockItem(ExtraDelightBlocks.MARSHMALLOW_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> GOLDEN_CARROT_CRATE_BLOCK = ITEMS.register("golden_carrot_crate_block",
			() -> new BlockItem(ExtraDelightBlocks.GOLDEN_CARROT_CRATE.get(), new Item.Properties()));

	public static final DeferredItem<Item> CHILI_SEEDS = ITEMS.register("chili_seeds",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.CHILI_CROP.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHILI = ItemRegistration
			.register("chili", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHILI), true)).advancementIngredients()
			.isHotFood().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_BOX = ITEMS.register("white_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> ORANGE_CHOCOLATE_BOX = ITEMS.register("orange_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.ORANGE_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> MAGENTA_CHOCOLATE_BOX = ITEMS.register("magenta_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.MAGENTA_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIGHT_BLUE_CHOCOLATE_BOX = ITEMS.register("light_blue_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_BLUE_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> YELLOW_CHOCOLATE_BOX = ITEMS.register("yellow_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.YELLOW_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIME_CHOCOLATE_BOX = ITEMS.register("lime_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIME_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> PINK_CHOCOLATE_BOX = ITEMS.register("pink_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.PINK_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> GRAY_CHOCOLATE_BOX = ITEMS.register("gray_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.GRAY_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> LIGHT_GRAY_CHOCOLATE_BOX = ITEMS.register("light_gray_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.LIGHT_GRAY_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> CYAN_CHOCOLATE_BOX = ITEMS.register("cyan_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.CYAN_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BLUE_CHOCOLATE_BOX = ITEMS.register("blue_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BLUE_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BROWN_CHOCOLATE_BOX = ITEMS.register("brown_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BROWN_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> GREEN_CHOCOLATE_BOX = ITEMS.register("green_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> RED_CHOCOLATE_BOX = ITEMS.register("red_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.RED_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> BLACK_CHOCOLATE_BOX = ITEMS.register("black_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.BLACK_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
	public static final DeferredItem<Item> PURPLE_CHOCOLATE_BOX = ITEMS.register("purple_chocolate_box",
			() -> new BlockItem(ExtraDelightBlocks.PURPLE_CHOCOLATE_BOX.get(),
					stack1Item().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

	public static final DeferredItem<Item> MILK_CHOCOLATE_BLOCK = ITEMS.register("milk_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_FENCE = ITEMS.register("milk_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_FENCE_GATE = ITEMS.register("milk_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_STAIRS = ITEMS.register("milk_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_DOOR = ITEMS.register("milk_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_TRAPDOOR = ITEMS.register("milk_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_SLAB = ITEMS.register("milk_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<Item> MILK_CHOCOLATE_PILLAR = ITEMS.register("milk_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<Item> DARK_CHOCOLATE_BLOCK = ITEMS.register("dark_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_FENCE = ITEMS.register("dark_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_FENCE_GATE = ITEMS.register("dark_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_STAIRS = ITEMS.register("dark_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_DOOR = ITEMS.register("dark_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_TRAPDOOR = ITEMS.register("dark_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_SLAB = ITEMS.register("dark_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<Item> DARK_CHOCOLATE_PILLAR = ITEMS.register("dark_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_BLOCK = ITEMS.register("white_chocolate_block",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_FENCE = ITEMS.register("white_chocolate_fence",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_FENCE_GATE = ITEMS.register("white_chocolate_fence_gate",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_STAIRS = ITEMS.register("white_chocolate_stairs",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_STAIRS.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DOOR = ITEMS.register("white_chocolate_door",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_DOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_TRAPDOOR = ITEMS.register("white_chocolate_trapdoor",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_SLAB = ITEMS.register("white_chocolate_slab",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_SLAB.get(), new Item.Properties()));
	public static final DeferredItem<Item> WHITE_CHOCOLATE_PILLAR = ITEMS.register("white_chocolate_pillar",
			() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_PILLAR.get(), new Item.Properties()));

	public static final DeferredItem<Item> BLOOD_CHOCOLATE_BLOCK = ItemRegistration
			.register("blood_chocolate_block",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_BLOCK.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_FENCE = ItemRegistration
			.register("blood_chocolate_fence",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_FENCE_GATE = ItemRegistration
			.register("blood_chocolate_fence_gate",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FENCE_GATE.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_STAIRS = ItemRegistration
			.register("blood_chocolate_stairs",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_STAIRS.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DOOR = ItemRegistration
			.register("blood_chocolate_door",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_DOOR.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_TRAPDOOR = ItemRegistration
			.register("blood_chocolate_trapdoor",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_TRAPDOOR.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_SLAB = ItemRegistration
			.register("blood_chocolate_slab",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_SLAB.get(), new Item.Properties()))
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_PILLAR = ItemRegistration
			.register("blood_chocolate_pillar",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_PILLAR.get(), new Item.Properties()))
			.butchercraftToolTip().finish();

	public static final DeferredItem<Item> ROASTED_COCOA_BEANS = ItemRegistration
			.register("roasted_cocoa_beans", () -> new Item(foodItem(EDFoods.NUTS))).advancementIngredients().finish();
	public static final DeferredItem<Item> COCOA_SOLIDS = ItemRegistration
			.register("cocoa_solids", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_BAR = ItemRegistration
			.register("white_chocolate_bar", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_BAR = ItemRegistration
			.register("milk_chocolate_bar", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_BAR = ItemRegistration
			.register("dark_chocolate_bar", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_BAR = ItemRegistration
			.register("blood_chocolate_bar", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_BAR), true))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_CHIPS = ItemRegistration
			.register("white_chocolate_chips", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_CHIPS), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_CHIPS = ItemRegistration
			.register("milk_chocolate_chips", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_CHIPS), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_CHIPS = ItemRegistration
			.register("dark_chocolate_chips", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_CHIPS), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_CHIPS = ItemRegistration
			.register("blood_chocolate_chips", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_CHIPS), true))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_FILLED_BAR = ItemRegistration
			.register("white_chocolate_filled_bar",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.FILLED_CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_FILLED_BAR = ItemRegistration
			.register("milk_chocolate_filled_bar",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.FILLED_CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_FILLED_BAR = ItemRegistration
			.register("dark_chocolate_filled_bar",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.FILLED_CHOCOLATE_BAR), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_FILLED_BAR = ItemRegistration
			.register("blood_chocolate_filled_bar",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.FILLED_CHOCOLATE_BAR), true))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_TRUFFLE = ItemRegistration
			.register("white_chocolate_truffle",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_TRUFFLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_TRUFFLE = ItemRegistration
			.register("milk_chocolate_truffle",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_TRUFFLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_TRUFFLE = ItemRegistration
			.register("dark_chocolate_truffle",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_TRUFFLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_TRUFFLE = ItemRegistration
			.register("blood_chocolate_truffle",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHOCOLATE_TRUFFLE), true))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> MARSHMALLOW = ItemRegistration
			.register("marshmallow", () -> new Item(foodItem(EDFoods.MARSHMALLOW))).advancementCandy().finish();
	public static final DeferredItem<Item> CHILI_POWDER = ItemRegistration
			.register("chili_powder", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> PEANUT_BUTTER_CUP = ItemRegistration
			.register("peanut_butter_cup", () -> new Item(foodItem(EDFoods.CHOCOLATE_TRUFFLE))).advancementCandy()
			.finish();
	public static final DeferredItem<Item> MALLOW_CUP = ItemRegistration
			.register("mallow_cup", () -> new Item(foodItem(EDFoods.CHOCOLATE_TRUFFLE))).advancementCandy().finish();
	public static final DeferredItem<Item> XOCOLATL = ItemRegistration
			.register("xocolati", () -> new XocolatlItem(drinkItem())).drink().setHydration(40).setThirst(5).isHot(true)
			.setPoison(0).finish();
	public static final DeferredItem<Item> GOURMET_HOT_CHOCOLATE = ItemRegistration
			.register("gourmet_hot_chocolate", () -> new GourmetHotCocoa(drinkItem())).drink().setHydration(40)
			.setThirst(4).isHot(true).setPoison(0).finish();
	public static final DeferredItem<Item> LAVA_CAKE = ItemRegistration
			.register("lava_cake", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert().finish();
	public static final DeferredItem<Item> COFFEE_JELLY = ItemRegistration
			.register("coffee_jelly", () -> new Item(bottleFoodItem(EDFoods.JELLY))).advancementDessert().finish();
	public static final DeferredItem<Item> TOFFEE = ItemRegistration
			.register("toffee", () -> new Item(foodItem(EDFoods.TOFFEE))).advancementCandy().finish();
	public static final DeferredItem<Item> GRAHAM_CRACKER = ItemRegistration
			.register("graham_cracker", () -> new Item(foodItem(EDFoods.GRAHAM_CRACKER))).advancementSnack().finish();
	public static final DeferredItem<Item> SMORE = ItemRegistration
			.register("smore", () -> new ToolTipConsumableItem(foodItem(EDFoods.SMORE), true)).advancementDessert()
			.finish();
	public static final DeferredItem<Item> PEPPERMINT_BARK = ItemRegistration
			.register("peppermint_bark", () -> new ToolTipConsumableItem(foodItem(EDFoods.PEPPERMINT_BARK), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DIRT_CAKE = ItemRegistration
			.register("dirt_cake", () -> new ToolTipConsumableItem(bottleFoodItem(EDFoods.DIRT_CAKE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> EASTER_EGG = ITEMS.register("easter_egg",
			() -> new Item(foodItem(EDFoods.CHOCOLATE_BAR)));
	public static final DeferredItem<Item> TRAIL_MIX = ItemRegistration
			.register("trail_mix", () -> new ToolTipConsumableItem(foodItem(EDFoods.TRAIL_MIX), true))
			.advancementSnack().finish();
	public static final DeferredItem<Item> NOUGAT = ItemRegistration
			.register("nougat", () -> new Item(foodItem(EDFoods.NOUGAT))).advancementCandy().finish();
	public static final DeferredItem<Item> GUMMIES = ItemRegistration
			.register("gummies", () -> new ToolTipConsumableItem(foodItem(EDFoods.GUMMIES), true)).advancementCandy()
			.finish();
	public static final DeferredItem<Item> PEANUT_BRITTLE = ItemRegistration
			.register("peanut_brittle", () -> new Item(foodItem(EDFoods.PEANUT_BRITTLE))).advancementCandy().finish();
	public static final DeferredItem<Item> BUTTERSCOTCH = ItemRegistration
			.register("butterscotch", () -> new Item(foodItem(EDFoods.BUTTERSCOTCH))).advancementCandy().finish();
	public static final DeferredItem<Item> FLUFFER_NUTTER = ItemRegistration
			.register("fluffer_nutter", () -> new Item(foodItem(EDFoods.FLUFFER_NUTTER))).advancementMeal().finish();

	public static final DeferredItem<Item> GREEN_COFFEE = ItemRegistration
			.register("green_coffee", () -> new ToolTipConsumableItem(foodItem(EDFoods.COFFEE_BEANS), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> COFFEE_BEANS = ItemRegistration
			.register("coffee_beans", () -> new ToolTipConsumableItem(foodItem(EDFoods.ROASTED_COFFEE_BEANS), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> COFFEE_CHERRIES = ITEMS.register("coffee_cherries",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.COFFEE_BUSH.get(),
					new Item.Properties().food(EDFoods.COFFEE_BEANS)));
	public static final DeferredItem<Item> COFFEE = ItemRegistration
			.register("coffee", () -> new CoffeeItem(drinkItem())).drink().setHydration(20).setThirst(2).isHot(true)
			.setPoison(0).finish();

	public static final DeferredItem<Item> BROWNIES_BLOCK = ItemRegistration
			.register("brownies_block", () -> new BlockItem(ExtraDelightBlocks.BROWNIES.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> BROWNIE = ItemRegistration
			.register("brownie", () -> new ToolTipConsumableItem(foodItem(EDFoods.BROWNIE), true)).advancementDessert()
			.servingToolTip().finish();

	public static final DeferredItem<Item> BLONDIES_BLOCK = ItemRegistration
			.register("blondies_block", () -> new BlockItem(ExtraDelightBlocks.BLONDIES.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> BLONDIE = ItemRegistration
			.register("blondie", () -> new ToolTipConsumableItem(foodItem(EDFoods.BLONDIE), true)).advancementDessert()
			.servingToolTip().finish();

	public static final DeferredItem<Item> CHOCOLATE_CAKE_BLOCK = ItemRegistration
			.register("chocolate_cake_block",
					() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_CAKE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> CHOCOLATE_CAKE = ItemRegistration
			.register("chocolate_cake", () -> new Item(foodItem(FoodValues.CAKE_SLICE))).advancementDessert()
			.servingToolTip().finish();

	public static final DeferredItem<Item> FUDGE_BLOCK = ItemRegistration
			.register("fudge_block", () -> new BlockItem(ExtraDelightBlocks.FUDGE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> FUDGE_SLICE = ItemRegistration
			.register("fudge", () -> new ToolTipConsumableItem(foodItem(EDFoods.FUDGE), true)).advancementCandy()
			.servingToolTip().finish();

	public static final DeferredItem<Item> STICKY_TOFFEE_PUDDING_BLOCK = ItemRegistration
			.register("sticky_toffee_pudding_block",
					() -> new BlockItem(ExtraDelightBlocks.STICKY_TOFFEE_PUDDING.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> STICKY_TOFFEE_PUDDING_SLICE = ItemRegistration
			.register("sticky_toffee_pudding_slice",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STICKY_TOFFEE_PUDDING), true))
			.advancementDessert().servingToolTip().finish();

	public static final DeferredItem<Item> CRISP_RICE = ItemRegistration
			.register("crisp_rice", () -> new Item(foodItem(FoodValues.COOKED_RICE))).advancementIngredients().finish();
	public static final DeferredItem<Item> CRISP_RICE_CEREAL = ItemRegistration
			.register("crisp_rice_cereal", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CEREAL), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> CRISP_RICE_TREATS_BLOCK = ItemRegistration
			.register("crisp_rice_treats_block",
					() -> new BlockItem(ExtraDelightBlocks.CRISP_RICE_TREATS.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> CRISP_RICE_TREAT = ItemRegistration
			.register("crisp_rice_treat", () -> new ToolTipConsumableItem(foodItem(EDFoods.PUFFED_RICE_TREAT), true))
			.advancementDessert().servingToolTip().finish();

	public static final DeferredItem<Item> SCOTCHAROO_BLOCK = ItemRegistration
			.register("scotcharoo_block", () -> new BlockItem(ExtraDelightBlocks.SCOTCHAROOS.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> SCOTCHAROO = ItemRegistration
			.register("scotcharoo", () -> new ToolTipConsumableItem(foodItem(EDFoods.SCOTCHAROO), true))
			.advancementDessert().servingToolTip().finish();

	public static final DeferredItem<Item> BLACK_FOREST_TRIFLE_BLOCK = ItemRegistration
			.register("black_forest_trifle_block",
					() -> new BlockItem(ExtraDelightBlocks.BLACK_FOREST_TRIFLE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> BLACK_FOREST_TRIFLE = ItemRegistration
			.register("black_forest_trifle",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.BLACK_FOREST_TRIFLE), true))
			.advancementDessert().servingToolTip().finish();

	public static final DeferredItem<Item> CORN_FLAKES = ItemRegistration
			.register("corn_flakes", () -> new Item(foodItem(EDFoods.COOKED_CORN))).advancementIngredients().finish();
	public static final DeferredItem<Item> CORN_FLAKES_CEREAL = ItemRegistration
			.register("corn_flakes_cereal", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CEREAL), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> BLOOD_CHOCOLATE_FONDUE_BLOCK = ItemRegistration
			.register("blood_chocolate_fondue_block",
					() -> new BlockItem(ExtraDelightBlocks.BLOOD_CHOCOLATE_FONDUE.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY = ItemRegistration
			.register("blood_chocolate_dipped_sweet_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_SWEET_BERRY), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY = ItemRegistration
			.register("blood_chocolate_dipped_glow_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GLOW_BERRY), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE = ItemRegistration
			.register("blood_chocolate_dipped_apple_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_APPLE), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW = ItemRegistration
			.register("blood_chocolate_dipped_marshmallow",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_MARSHMALLOW), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ItemRegistration
			.register("blood_chocolate_dipped_graham_cracker",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GRAHAM_CRACKER), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_BACON = ItemRegistration
			.register("blood_chocolate_dipped_bacon",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_BACON), true))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN = ItemRegistration
			.register("blood_chocolate_dipped_coffee_bean",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_COFFEE_BEAN), true))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> DARK_CHOCOLATE_FONDUE_BLOCK = ItemRegistration
			.register("dark_chocolate_fondue_block",
					() -> new BlockItem(ExtraDelightBlocks.DARK_CHOCOLATE_FONDUE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_SWEET_BERRY = ItemRegistration
			.register("dark_chocolate_dipped_sweet_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_SWEET_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_GLOW_BERRY = ItemRegistration
			.register("dark_chocolate_dipped_glow_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GLOW_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_APPLE_SLICE = ItemRegistration
			.register("dark_chocolate_dipped_apple_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_APPLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_MARSHMALLOW = ItemRegistration
			.register("dark_chocolate_dipped_marshmallow",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_MARSHMALLOW), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ItemRegistration
			.register("dark_chocolate_dipped_graham_cracker",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GRAHAM_CRACKER), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_BACON = ItemRegistration
			.register("dark_chocolate_dipped_bacon",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_BACON), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> DARK_CHOCOLATE_DIPPED_COFFEE_BEAN = ItemRegistration
			.register("dark_chocolate_dipped_coffee_bean",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_COFFEE_BEAN), true))
			.advancementCandy().finish();

	public static final DeferredItem<Item> MILK_CHOCOLATE_FONDUE_BLOCK = ItemRegistration
			.register("milk_chocolate_fondue_block",
					() -> new BlockItem(ExtraDelightBlocks.MILK_CHOCOLATE_FONDUE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_SWEET_BERRY = ItemRegistration
			.register("milk_chocolate_dipped_sweet_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_SWEET_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_GLOW_BERRY = ItemRegistration
			.register("milk_chocolate_dipped_glow_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GLOW_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_APPLE_SLICE = ItemRegistration
			.register("milk_chocolate_dipped_apple_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_APPLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_MARSHMALLOW = ItemRegistration
			.register("milk_chocolate_dipped_marshmallow",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_MARSHMALLOW), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ItemRegistration
			.register("milk_chocolate_dipped_graham_cracker",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GRAHAM_CRACKER), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_BACON = ItemRegistration
			.register("milk_chocolate_dipped_bacon",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_BACON), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> MILK_CHOCOLATE_DIPPED_COFFEE_BEAN = ItemRegistration
			.register("milk_chocolate_dipped_coffee_bean",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_COFFEE_BEAN), true))
			.advancementCandy().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_FONDUE_BLOCK = ItemRegistration
			.register("white_chocolate_fondue_block",
					() -> new BlockItem(ExtraDelightBlocks.WHITE_CHOCOLATE_FONDUE.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_SWEET_BERRY = ItemRegistration
			.register("white_chocolate_dipped_sweet_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_SWEET_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_GLOW_BERRY = ItemRegistration
			.register("white_chocolate_dipped_glow_berry",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GLOW_BERRY), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_APPLE_SLICE = ItemRegistration
			.register("white_chocolate_dipped_apple_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_APPLE), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_MARSHMALLOW = ItemRegistration
			.register("white_chocolate_dipped_marshmallow",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_MARSHMALLOW), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_GRAHAM_CRACKER = ItemRegistration
			.register("white_chocolate_dipped_graham_cracker",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_GRAHAM_CRACKER), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_BACON = ItemRegistration
			.register("white_chocolate_dipped_bacon",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_BACON), true))
			.advancementCandy().finish();
	public static final DeferredItem<Item> WHITE_CHOCOLATE_DIPPED_COFFEE_BEAN = ItemRegistration
			.register("white_chocolate_dipped_coffee_bean",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.DIPPED_COFFEE_BEAN), true))
			.advancementCandy().finish();

	public static final DeferredItem<Item> DRIED_CHILI = ITEMS.register("dried_chili",
			() -> new Item(foodItem(EDFoods.CHILI)));

	public static final DeferredItem<Item> PEANUTS_IN_SHELL = ITEMS.register("peanuts_in_shell",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PEANUTS = ItemRegistration
			.register("peanuts",
					() -> new ItemNameBlockItem(ExtraDelightBlocks.PEANUT_CROP.get(), foodItem(EDFoods.NUTS)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> ROASTED_PEANUTS = ItemRegistration
			.register("roasted_peanuts", () -> new Item(foodItem(EDFoods.ROASTED_NUTS))).advancementIngredients()
			.finish();

	public static final DeferredItem<Item> HAZELNUTS_IN_SHELL = ITEMS.register("hazelnuts_in_shell",
			() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> HAZELNUTS = ItemRegistration
			.register("hazelnuts", () -> new Item(foodItem(EDFoods.NUTS))).advancementIngredients().finish();
	public static final DeferredItem<Item> ROASTED_HAZELNUTS = ItemRegistration
			.register("roasted_hazelnuts", () -> new Item(foodItem(EDFoods.ROASTED_NUTS))).advancementIngredients()
			.finish();

	public static final DeferredItem<Item> WILD_PEANUT_BLOCK = ITEMS.register("wild_peanut_block",
			() -> new BlockItem(ExtraDelightBlocks.WILD_PEANUT.get(), new Item.Properties()));

	public static final DeferredItem<Item> WILD_CHILI_BLOCK = ITEMS.register("wild_chili_block",
			() -> new BlockItem(ExtraDelightBlocks.WILD_CHILI.get(), new Item.Properties()));

	public static final DeferredItem<Item> WILD_MALLOW_ROOT_BLOCK = ITEMS.register("wild_mallow_root_block",
			() -> new BlockItem(ExtraDelightBlocks.WILD_MALLOW_ROOT.get(), new Item.Properties()));
	public static final DeferredItem<Item> MALLOW_ROOT = ITEMS.register("mallow_root",
			() -> new ItemNameBlockItem(ExtraDelightBlocks.MALLOW_ROOT_CROP.get(), new Item.Properties()));

	public static final DeferredItem<Item> PEANUT_BUTTER_JELLY = ItemRegistration
			.register("peanut_butter_jelly", () -> new ToolTipConsumableItem(foodItem(EDFoods.PBJ), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> HAZELNUT_SAPLING = ITEMS.register("hazelnut_sapling",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_SAPLING.get(), new Item.Properties()));

	public static final DeferredItem<Item> ICE_CREAM_SUNDAE = ItemRegistration
			.register("ice_cream_sundae",
					() -> new ToolTipConsumableItem(bottleFoodItem(EDFoods.ICE_CREAM_SUNDAE), true))
			.advancementDessert().isColdFood().finish();

	public static final DeferredItem<Item> MALLOW_POWDER = ItemRegistration
			.register("mallow_powder", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> GROUND_COFFEE = ItemRegistration
			.register("ground_coffee", () -> new Item(new Item.Properties())).advancementIngredients().finish();

	// Fluids
	public static final DeferredItem<Item> OIL_FLUID_BUCKET = ITEMS.register("oil_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.OIL));

	public static final DeferredItem<Item> VINEGAR_FLUID_BUCKET = ITEMS.register("vinegar_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.VINEGAR));

	public static final DeferredItem<Item> GRAVY_FLUID_BUCKET = ITEMS.register("gravy_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.GRAVY));

	public static final DeferredItem<Item> GLOW_BERRY_JUICE_FLUID_BUCKET = ITEMS.register("glow_berry_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.GLOW_BERRY_JUICE));

	public static final DeferredItem<Item> SWEET_BERRY_JUICE_FLUID_BUCKET = ITEMS.register("sweet_berry_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.SWEET_BERRY_JUICE));

	public static final DeferredItem<Item> TOMATO_JUICE_FLUID_BUCKET = ITEMS.register("tomato_juice_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.TOMATO_JUICE));

	public static final DeferredItem<Item> CACTUS_JUICE_FLUID_BUCKET = ITEMS.register("cactus_juice_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.CACTUS_JUICE));

	public static final DeferredItem<Item> APPLE_CIDER_FLUID_BUCKET = ITEMS.register("apple_cider_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.APPLE_CIDER));

	public static final DeferredItem<Item> HOT_COCOA_FLUID_BUCKET = ITEMS.register("hot_cocoa_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.HOT_COCOA));

	public static final DeferredItem<Item> MELON_JUICE_FLUID_BUCKET = ITEMS.register("melon_juice_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.MELON_JUICE));

	public static final DeferredItem<Item> EGG_MIX_FLUID_BUCKET = ITEMS.register("egg_mix_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.EGG_MIX));

	public static final DeferredItem<Item> BBQ_FLUID_BUCKET = ITEMS.register("bbq_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.BBQ));

	public static final DeferredItem<Item> KETCHUP_FLUID_BUCKET = ITEMS.register("ketchup_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.KETCHUP));

	public static final DeferredItem<Item> MAYO_FLUID_BUCKET = ITEMS.register("mayo_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.MAYO));

	public static final DeferredItem<Item> BROTH_FLUID_BUCKET = ITEMS.register("broth_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.BROTH));

	public static final DeferredItem<Item> CARAMEL_SAUCE_FLUID_BUCKET = ITEMS.register("caramel_sauce_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.CARAMEL_SAUCE));

	public static final DeferredItem<Item> MILKSHAKE_FLUID_BUCKET = ITEMS.register("milkshake_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.MILKSHAKE));

	public static final DeferredItem<Item> WHIPPED_CREAM_FLUID_BUCKET = ITEMS.register("whipped_cream_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.WHIPPED_CREAM));

	public static final DeferredItem<Item> JAM_FLUID_BUCKET = ITEMS.register("jam_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.JAM));

	public static final DeferredItem<Item> TEA_FLUID_BUCKET = ITEMS.register("tea_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.TEA));

	public static final DeferredItem<Item> COCOA_BUTTER_FLUID_BUCKET = ITEMS.register("cocoa_butter_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.COCOA_BUTTER));

	public static final DeferredItem<Item> WHITE_CHOCOLATE_SYRUP_FLUID_BUCKET = ITEMS.register(
			"white_chocolate_syrup_fluid_bucket", () -> stack1bucketItem(ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP));

	public static final DeferredItem<Item> DARK_CHOCOLATE_SYRUP_FLUID_BUCKET = ITEMS.register(
			"dark_chocolate_syrup_fluid_bucket", () -> stack1bucketItem(ExtraDelightFluids.DARK_CHOCOLATE_SYRUP));

	public static final DeferredItem<Item> MILK_CHOCOLATE_SYRUP_FLUID_BUCKET = ITEMS.register(
			"milk_chocolate_syrup_fluid_bucket", () -> stack1bucketItem(ExtraDelightFluids.MILK_CHOCOLATE_SYRUP));

	public static final DeferredItem<Item> BLOOD_CHOCOLATE_SYRUP_FLUID_BUCKET = ItemRegistration
			.register("blood_chocolate_syrup_fluid_bucket",
					() -> stack1bucketItem(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP))
			.butchercraftToolTip().finish();

	public static final DeferredItem<Item> COFFEE_FLUID_BUCKET = ITEMS.register("coffee_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.COFFEE));

	public static final DeferredItem<Item> NUT_BUTTER_FLUID_BUCKET = ITEMS.register("peanut_butter_fluid_bucket",
			() -> stack1bucketItem(ExtraDelightFluids.NUT_BUTTER));

	public static final DeferredItem<Item> MARSHMALLOW_FLUFF_FLUID_BUCKET = ITEMS
			.register("marshmallow_fluff_fluid_bucket", () -> stack1bucketItem(ExtraDelightFluids.MARSHMALLOW_FLUFF));

	public static final DeferredItem<Item> COCOA_NUT_BUTTER_SPREAD_FLUID_BUCKET = ITEMS.register(
			"cocoa_nut_butter_spread_fluid_bucket", () -> stack1bucketItem(ExtraDelightFluids.COCOA_NUT_BUTTER_SPREAD));

	public static final DeferredItem<Item> COCOA_BUTTER_BOTTLE = ItemRegistration
			.register("cocoa_butter_bottle", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> WHITE_CHOCOLATE_SYRUP_BOTTLE = ItemRegistration
			.register("white_chocolate_syrup_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.CHOCOLATE_BAR)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> DARK_CHOCOLATE_SYRUP_BOTTLE = ItemRegistration
			.register("dark_chocolate_syrup_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.CHOCOLATE_BAR)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> MILK_CHOCOLATE_SYRUP_BOTTLE = ItemRegistration
			.register("milk_chocolate_syrup_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.CHOCOLATE_BAR)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> BLOOD_CHOCOLATE_SYRUP_BOTTLE = ItemRegistration
			.register("blood_chocolate_syrup_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.CHOCOLATE_BAR)))
			.advancementButchercraft().butchercraftToolTip().finish();

	public static final DeferredItem<Item> PEANUT_BUTTER_BOTTLE = ItemRegistration
			.register("peanut_butter_bottle",
					() -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.NUT_BUTTER)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> MARSHMALLOW_FLUFF_BOTTLE = ItemRegistration
			.register("marshmallow_fluff_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.MARSHMALLOW_FLUFF)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> HAZELNUT_SPREAD_BOTTLE = ItemRegistration
			.register("hazelnut_spread_bottle",
					() -> new Item(
							new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.HAZELNUT_SPREAD)))
			.advancementIngredients().finish();

	public static final DeferredItem<Item> APPLE_LEAVES = ITEMS.register("apple_leaves",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_LEAVES.get(), new Item.Properties()));
	public static final DeferredItem<Item> APPLE_SAPLING = ITEMS.register("apple_sapling",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_SAPLING.get(), new Item.Properties()));

	public static final DeferredItem<Item> ROMBOSSE = ItemRegistration
			.register("rombosse", () -> new ToolTipConsumableItem(foodItem(EDFoods.ROMBOSSE), true))
			.advancementDessert().finish();
	public static final DeferredItem<Item> APPLE_SLAW = ItemRegistration
			.register("apple_slaw", () -> new Item(bowlFoodItem(EDFoods.APPLE_SLAW))).advancementMeal().finish();
	public static final DeferredItem<Item> PORK_AND_APPLES_FEAST = ItemRegistration
			.register("pork_and_apples_feast",
					() -> new BlockItem(ExtraDelightBlocks.PORK_AND_APPLES_FEAST.get(), stack1Item()))
			.advancementButchercraft().butchercraftToolTip().finish();
	public static final DeferredItem<Item> PORK_AND_APPLES = ItemRegistration
			.register("pork_and_apples", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.PORK_AND_APPLES), true))
			.advancementButchercraft().servingToolTip().butchercraftToolTip().finish();
	public static final DeferredItem<Item> APPLE_CHIPS = ItemRegistration
			.register("apple_chips", () -> new Item(foodItem(EDFoods.APPLE_CHIPS))).advancementSnack().finish();
	public static final DeferredItem<Item> STUFFED_APPLES_FEAST = ItemRegistration
			.register("stuffed_apples_feast",
					() -> new BlockItem(ExtraDelightBlocks.STUFFED_APPLES_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> STUFFED_APPLE = ItemRegistration
			.register("stuffed_apple", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STUFFED_APPLE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> STUFFED_APPLE_ICE_CREAM = ItemRegistration
			.register("stuffed_apple_ice_cream",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.STUFFED_APPLE_ICE_CREAM), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> MULLIGATAWNY_SOUP = ItemRegistration
			.register("mulligatawny_soup",
					() -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.MULLIGATAWNY_SOUP), true))
			.advancementMeal().isHotFood().finish();

	public static final DeferredItem<Item> TARTE_TATIN_IN_PAN = ItemRegistration.register("tarte_tatin_in_pan",
			() -> new SolidBucketItem(ExtraDelightBlocks.TARTE_TATIN.get(), SoundEvents.DYE_USE, stack1Item()) {
				@Override
				public InteractionResult useOn(UseOnContext context) {
					InteractionResult interactionresult = super.useOn(context);
					Player player = context.getPlayer();
					if (interactionresult.consumesAction() && player != null) {
						player.setItemInHand(context.getHand(), new ItemStack(ModItems.SKILLET.get()));
					}

					return interactionresult;
				}
			}).advancementFeast().finish();

	public static final DeferredItem<Item> TARTE_TATIN = ItemRegistration
			.register("tarte_tatin", () -> new BlockItem(ExtraDelightBlocks.TARTE_TATIN.get(), stack1Item()))
			.feastToolTip().finish();
	public static final DeferredItem<Item> TARTE_TATIN_SLICE = ItemRegistration
			.register("tarte_tatin_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.TARTE_TATIN_SLICE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> AEBLEFLAESK = ItemRegistration
			.register("aebleflaesk", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.AEBLEFLAESK), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CANDY_BAR_SALAD = ItemRegistration
			.register("candy_bar_salad", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CANDY_BAR_SALAD), true))
			.advancementDessert().finish();

	public static final DeferredItem<Item> HANGING_ONION = ITEMS.register("hanging_onion",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_ONIONS.get(), new Item.Properties()));
	public static final DeferredItem<Item> HANGING_MINT = ITEMS.register("hanging_mint",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_MINT.get(), new Item.Properties()));
	public static final DeferredItem<Item> HANGING_HAM = ITEMS.register("hanging_ham",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_HAM.get(), new Item.Properties()));
	public static final DeferredItem<Item> HANGING_CHILI = ITEMS.register("hanging_chili",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_CHILI.get(), new Item.Properties()));
	public static final DeferredItem<Item> HANGING_DRIED_CHILI = ITEMS.register("hanging_dried_chili",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_DRIED_CHILI.get(), new Item.Properties()));
	public static final DeferredItem<Item> HANGING_CORN = ITEMS.register("hanging_corn",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_CORN.get(), new Item.Properties()));

	public static final DeferredItem<Item> CHILI_CRATE = ITEMS.register("chili_crate",
			() -> new BlockItem(ExtraDelightBlocks.CHILI_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHILI_POWDER_SACK = ITEMS.register("chili_powder_sack",
			() -> new BlockItem(ExtraDelightBlocks.CHILI_POWDER_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> SLICED_CHILI = ItemRegistration
			.register("sliced_chili", () -> new ToolTipConsumableItem(foodItem(EDFoods.CHILI), true))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> JALAPENO_STUFFED_POTATO = ItemRegistration
			.register("jalapeno_stuffed_potato",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.JALAPENO_STUFFED_POTATO), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> JALAPENO_POPPER = ItemRegistration
			.register("jalapeno_popper", () -> new ToolTipConsumableItem(foodItem(EDFoods.JALAPENO_POPPER), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> CHILI_CHEESE_CORNBREAD_MUFFIN = ItemRegistration
			.register("chili_cheese_cornbread_muffin",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.CHILI_CHEESE_CORNBREAD_MUFFIN), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CHILI_CON_CARNE_FEAST = ItemRegistration
			.register("chili_con_carne_feast",
					() -> new BlockItem(ExtraDelightBlocks.CHILI_CON_CARNE_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> CHILI_CON_CARNE = ItemRegistration
			.register("chili_con_carne", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.CHILI_CON_CARNE), true))
			.advancementMeal().isHotFood().servingToolTip().finish();
	public static final DeferredItem<Item> WHITE_CHILI_FEAST = ItemRegistration
			.register("white_chili_feast",
					() -> new BlockItem(ExtraDelightBlocks.WHITE_CHILI_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> WHITE_CHILI = ItemRegistration
			.register("white_chili", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.WHITE_CHILI), true))
			.advancementMeal().servingToolTip().isHotFood().finish();

	public static final DeferredItem<Item> PEANUT_IN_SHELL_SACK = ITEMS.register("peanut_in_shell_sack",
			() -> new BlockItem(ExtraDelightBlocks.PEANUT_IN_SHELL_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> PEANUT_SACK = ITEMS.register("peanut_sack",
			() -> new BlockItem(ExtraDelightBlocks.PEANUT_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> ROASTED_PEANUT_SACK = ITEMS.register("roasted_peanut_sack",
			() -> new BlockItem(ExtraDelightBlocks.ROASTED_PEANUT_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> NUT_BUTTER_COOKIE = ItemRegistration
			.register("nut_butter_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementCookie().finish();
	public static final DeferredItem<Item> NUT_BUTTER_COOKIE_DOUGH = ItemRegistration
			.register("nut_butter_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> NUT_BUTTER_ICE_CREAM = ItemRegistration
			.register("nut_butter_ice_cream", () -> new Item(bowlFoodItem(EDFoods.TOPPED_ICE_CREAM)))
			.advancementDessert().finish();
	public static final DeferredItem<Item> NUT_BUTTER_MILKSHAKE = ItemRegistration
			.register("nut_butter_milkshake", () -> new MilkshakeDrinkItem(drinkItem(), 4f)).drink().setHydration(20)
			.setThirst(2).setPoison(0).isHot(false).finish();
	public static final DeferredItem<Item> NUT_BUTTER_CUSTARD = ItemRegistration
			.register("nut_butter_custard", () -> new Item(bottleFoodItem(EDFoods.CUSTARD))).advancementDessert()
			.finish();
	public static final DeferredItem<Item> NUT_BUTTER_COOKIE_BLOCK = ITEMS.register("nut_butter_cookie_block",
			() -> new BlockItem(ExtraDelightBlocks.NUT_BUTTER_COOKIE_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> HAZELNUT_IN_SHELL_SACK = ITEMS.register("hazelnut_in_shell_sack",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_IN_SHELL_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> HAZELNUT_SACK = ITEMS.register("hazelnut_sack",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> ROASTED_HAZELNUT_SACK = ITEMS.register("roasted_hazelnut_sack",
			() -> new BlockItem(ExtraDelightBlocks.ROASTED_HAZELNUT_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> MISSISSIPPI_MUD_PIE = ItemRegistration
			.register("mississippi_mud_pie",
					() -> new BlockItem(ExtraDelightBlocks.MISSISSIPPI_MUD_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> MISSISSIPPI_MUD_PIE_SLICE = ItemRegistration
			.register("mississippi_mud_pie_slice",
					() -> new ToolTipConsumableItem(foodItem(EDFoods.MISSISSIPPI_MUD_PIE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> HAZELNUT_SOUP = ItemRegistration
			.register("hazelnut_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.HAZELNUT_SOUP), true))
			.advancementMeal().isHotFood().finish();

	public static final DeferredItem<Item> MALLOW_ROOT_CRATE = ITEMS.register("mallow_root_crate",
			() -> new BlockItem(ExtraDelightBlocks.MALLOW_ROOT_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> MALLOW_POWDER_SACK = ITEMS.register("mallow_powder_sack",
			() -> new BlockItem(ExtraDelightBlocks.MALLOW_POWDER_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GRASSHOPPER_PIE = ItemRegistration
			.register("grasshopper_pie",
					() -> new BlockItem(ExtraDelightBlocks.GRASSHOPPER_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> MARSHMALLOW_SLICE_FEAST = ItemRegistration
			.register("marshmallow_slice_feast",
					() -> new BlockItem(ExtraDelightBlocks.MARSHMALLOW_SLICE_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> GRASSHOPPER_PIE_SLICE = ItemRegistration
			.register("grasshopper_pie_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.GRASSHOPPER_PIE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> MARSHMALLOW_SLICE = ItemRegistration
			.register("marshmallow_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.MARSHMALLOW_SLICE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> ROCKY_ROAD = ItemRegistration
			.register("rocky_road", () -> new Item(foodItem(EDFoods.ROCKY_ROAD))).advancementDessert().finish();

	public static final DeferredItem<Item> COFFEE_CHERRY_CRATE = ITEMS.register("coffee_cherry_crate",
			() -> new BlockItem(ExtraDelightBlocks.COFFEE_CHERRY_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> GREEN_COFFEE_BEAN_SACK = ITEMS.register("green_coffee_bean_sack",
			() -> new BlockItem(ExtraDelightBlocks.GREEN_COFFEE_BEAN_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> COFFEE_BEAN_SACK = ITEMS.register("coffee_bean_sack",
			() -> new BlockItem(ExtraDelightBlocks.COFFEE_BEAN_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> AFFOGATO = ItemRegistration
			.register("affogato", () -> new ToolTipConsumableItem(bottleFoodItem(EDFoods.AFFOGATO), true))
			.advancementDessert().isColdFood().finish();

	public static final DeferredItem<Item> COCOA_BEAN_SACK = ITEMS.register("cocoa_bean_sack",
			() -> new BlockItem(ExtraDelightBlocks.COCOA_BEAN_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> ROASTED_COCOA_BEAN_SACK = ITEMS.register("roasted_cocoa_bean_sack",
			() -> new BlockItem(ExtraDelightBlocks.ROASTED_COCOA_BEAN_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> GROUND_COFFEE_SACK = ITEMS.register("ground_coffee_sack",
			() -> new BlockItem(ExtraDelightBlocks.GROUND_COFFEE_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> COCOA_POWDER_SACK = ITEMS.register("cocoa_powder_sack",
			() -> new BlockItem(ExtraDelightBlocks.COCOA_POWDER_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> COCOA_SOLIDS_SACK = ITEMS.register("cocoa_solids_sack",
			() -> new BlockItem(ExtraDelightBlocks.COCOA_SOLIDS_SACK.get(), new Item.Properties()));
	public static final DeferredItem<Item> CHOCOLATE_COOKIE_BLOCK = ITEMS.register("chocolate_cookie_block",
			() -> new BlockItem(ExtraDelightBlocks.CHOCOLATE_COOKIE_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> COCOA_POWDER = ItemRegistration
			.register("cocoa_powder", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> CHOCOLATE_COOKIE_DOUGH = ItemRegistration
			.register("chocolate_cookie_dough", () -> new Item(foodItem(EDFoods.COOKIE_DOUGH))).advancementIngredients()
			.finish();
	public static final DeferredItem<Item> CHOCOLATE_COOKIE = ItemRegistration
			.register("chocolate_cookie", () -> new Item(foodItem(FoodValues.COOKIES))).advancementDessert().finish();

	public static final DeferredItem<Item> POTATO_SALAD = ItemRegistration
			.register("potato_salad", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.POTATO_SALAD), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> ONION_SOUP = ItemRegistration
			.register("onion_soup", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FRENCH_ONION_SOUP), true))
			.advancementMeal().isHotFood().finish();
	public static final DeferredItem<Item> BACON_EGG_PIE = ItemRegistration
			.register("bacon_egg_pie",
					() -> new BlockItem(ExtraDelightBlocks.BACON_EGG_PIE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> BACON_EGG_PIE_SLICE = ItemRegistration
			.register("bacon_egg_pie_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.BACON_EGG_PIE), true))
			.advancementMeal().servingToolTip().finish();
	public static final DeferredItem<Item> ONION_BHAJI = ItemRegistration
			.register("onion_bhaji", () -> new Item(foodItem(EDFoods.ONION_BHAJI))).advancementMeal().finish();
	public static final DeferredItem<Item> FAT_POTATOES = ItemRegistration
			.register("fat_potatoes", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.FAT_POTATO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> CINNAMON_TOAST = ItemRegistration
			.register("cinnamon_toast", () -> new ToolTipConsumableItem(foodItem(EDFoods.CINNAMON_TOAST), true))
			.advancementSnack().finish();
	public static final DeferredItem<Item> PANFORTE = ItemRegistration
			.register("panforte", () -> new BlockItem(ExtraDelightBlocks.PANFORTE.get(), new Item.Properties()))
			.advancementFeast().feastToolTip().finish();
	public static final DeferredItem<Item> PANFORTE_SLICE = ItemRegistration
			.register("panforte_slice", () -> new ToolTipConsumableItem(foodItem(EDFoods.PANFORTE), true))
			.advancementDessert().servingToolTip().finish();
	public static final DeferredItem<Item> CURRYWURST = ItemRegistration
			.register("currywurst", () -> new Item(bowlFoodItem(EDFoods.CURRYWURST))).advancementMeal()
			.butchercraftToolTip().finish();
	public static final DeferredItem<Item> BORSCHT = ItemRegistration
			.register("borscht", () -> new ToolTipConsumableItem(bowlFoodItem(EDFoods.BORSCHT), true)).advancementMeal()
			.isHotFood().finish();
	public static final DeferredItem<Item> PAMONHA = ItemRegistration
			.register("pamonha", () -> new ToolTipConsumableItem(foodItem(EDFoods.PAMONHA), true)).advancementMeal()
			.finish();

	public static final DeferredItem<Item> WILD_GARLIC_BLOCK = ITEMS.register("wild_garlic_block",
			() -> new BlockItem(ExtraDelightBlocks.WILD_GARLIC.get(), new Item.Properties()));
	public static final DeferredItem<Item> GARLIC = ITEMS.register("garlic", () -> new Item(foodItem(EDFoods.GARLIC)));
	public static final DeferredItem<Item> GARLIC_CRATE = ITEMS.register("garlic_crate",
			() -> new BlockItem(ExtraDelightBlocks.GARLIC_CRATE.get(), new Item.Properties()));
	public static final DeferredItem<Item> GARLIC_CLOVE = ItemRegistration
			.register("garlic_clove",
					() -> new ItemNameBlockItem(ExtraDelightBlocks.GARLIC_CROP.get(), foodItem(EDFoods.GARLIC)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> GRATED_GARLIC = ItemRegistration
			.register("grated_garlic", () -> new Item(foodItem(EDFoods.GARLIC))).advancementIngredients().finish();
	public static final DeferredItem<Item> BRUSCHETTA_FEAST = ItemRegistration
			.register("bruschetta_feast", () -> new BlockItem(ExtraDelightBlocks.BRUSCHETTA_FEAST.get(), stack1Item()))
			.advancementFeast().finish();
	public static final DeferredItem<Item> BRUSCHETTA = ItemRegistration
			.register("bruschetta", () -> new GarlicTooltipItem(foodItem(EDFoods.BRUSCETTA), true)).advancementSnack()
			.servingToolTip().finish();
	public static final DeferredItem<Item> AIOLI = ItemRegistration
			.register("aioli_jar_item",
					() -> new GarlicCureDrinkableItem(foodItem(EDFoods.AIOLI).craftRemainder(Items.GLASS_BOTTLE)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> ROASTED_GARLIC = ItemRegistration
			.register("roasted_garlic", () -> new GarlicCureItem(foodItem(EDFoods.ROASTED_GARLIC)))
			.advancementIngredients().finish();
	public static final DeferredItem<Item> GARLIC_BREAD = ItemRegistration
			.register("garlic_bread", () -> new GarlicCureItem(foodItem(EDFoods.GARLIC_BREAD))).advancementSnack()
			.finish();
	public static final DeferredItem<Item> CHEESY_GARLIC_BREAD = ItemRegistration
			.register("cheesy_garlic_bread", () -> new GarlicCureItem(foodItem(EDFoods.CHEESY_GARLIC_BREAD)))
			.advancementSnack().finish();
	public static final DeferredItem<Item> CHICKEN_KIEV = ItemRegistration
			.register("chicken_kiev", () -> new GarlicTooltipItem(foodItem(EDFoods.CHICKEN_KIEV), true))
			.advancementButchercraft().finish();
	public static final DeferredItem<Item> DEVILLED_SAUSAGES = ItemRegistration
			.register("devilled_sausages", () -> new GarlicTooltipItem(bowlFoodItem(EDFoods.DEVILLED_SAUSAGES), true))
			.advancementButchercraft().finish();
	public static final DeferredItem<Item> HANGING_GARLIC = ITEMS.register("hanging_garlic",
			() -> new BlockItem(ExtraDelightBlocks.HANGING_GARLIC.get(), new Item.Properties()));
	public static final DeferredItem<Item> AGLIO_E_OLIO = ItemRegistration
			.register("aglio_e_olio", () -> new GarlicTooltipItem(bowlFoodItem(EDFoods.AGLIO_E_OLIO), true))
			.advancementMeal().finish();
	public static final DeferredItem<Item> PENNE = ItemRegistration
			.register("penne", () -> new Item(new Item.Properties())).advancementIngredients().finish();
	public static final DeferredItem<Item> PENNE_ALL_ARRABIATA = ItemRegistration
			.register("penne_all_arrabbiata",
					() -> new GarlicTooltipItem(bowlFoodItem(EDFoods.PENNE_ALL_ARRABBIATA), true))
			.advancementMeal().finish();

	public static final DeferredItem<Item> DYNAMIC_TOAST = ITEMS.register("dynamic_toast",
			() -> new DynamicToast(new Item.Properties()
					.component(ExtraDelightComponents.ITEMSTACK_HANDLER.get(), ItemContainerContents.EMPTY)
					.food(EDFoods.BUTTERED_TOAST)));
	public static final DeferredItem<Item> DYNAMIC_JAM = ITEMS.register("dynamic_jam",
			() -> new DynamicJam(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(EDFoods.JAM)));

	public static final DeferredItem<Item> HAZELNUT_PETAL_LITTER_ITEM = ExtraDelightItems.ITEMS.register(
			"hazelnut_petal_litter_item",
			() -> new BlockItem(ExtraDelightBlocks.HAZELNUT_PETAL_LITTER.get(), new Item.Properties()));

	public static final DeferredItem<Item> APPLE_PETAL_LITTER_ITEM = ExtraDelightItems.ITEMS.register(
			"apple_petal_litter_item",
			() -> new BlockItem(ExtraDelightBlocks.APPLE_PETAL_LITTER.get(), new Item.Properties()));
}
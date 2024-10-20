package com.lance5057.extradelight;

import java.util.List;
import java.util.Set;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@EventBusSubscriber(modid = ExtraDelight.MOD_ID, value = Dist.CLIENT)
public class ExtraDelightForgeClientEvents {
//	@SubscribeEvent
//	public static void onFogDensityEvent(ViewportEvent.RenderFog event) {
//		if (Minecraft.getInstance().player.level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
//			event.setNearPlaneDistance(-8);
//			event.scaleFarPlaneDistance(0.25f);
//			event.setFogShape(FogShape.CYLINDER);
//			event.setCanceled(true);
//		}
//
//	}
//
//	@SubscribeEvent
//	public static void onFogColorEvent(ViewportEvent.ComputeFogColor event) {
//		if (Minecraft.getInstance().player.level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
//			float f = 0.5f;
//			event.setRed(f);
//			event.setBlue(f);
//			event.setGreen(f);
//		}
//	}

	@SubscribeEvent
	public static void registerComponentToolTips(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		TooltipContext ctx = event.getContext();
		List<Component> tooltip = event.getToolTip();
		TooltipFlag flag = event.getFlags();

		TooltipProvider tooltipProvider = stack.get(ExtraDelightComponents.CHILL.get());

		if (tooltipProvider != null) {
			tooltipProvider.addToTooltip(ctx, i -> {
				tooltip.add(i);
			}, flag);
		}
	}

	@SubscribeEvent
	public static void addToolTip(ItemTooltipEvent event) {
		if (feasts.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip()
					.add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.feast").withStyle(ChatFormatting.BLUE));
		}

		if (servings.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip()
					.add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.serving").withStyle(ChatFormatting.BLUE));
		}

		if (butchercraft.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip().add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.butchercraft")
					.withStyle(ChatFormatting.RED));
		}
	}

	static Set<DeferredItem<Item>> feasts = Set.of(
			ExtraDelightItems.JELLY_WHITE_FEAST_ITEM,
			ExtraDelightItems.JELLY_ORANGE_FEAST_ITEM,
			ExtraDelightItems.JELLY_MAGENTA_FEAST_ITEM,
			ExtraDelightItems.JELLY_LIGHT_BLUE_FEAST_ITEM,
			ExtraDelightItems.JELLY_YELLOW_FEAST_ITEM,
			ExtraDelightItems.JELLY_LIME_FEAST_ITEM,
			ExtraDelightItems.JELLY_PINK_FEAST_ITEM,
			ExtraDelightItems.JELLY_GREY_FEAST_ITEM,
			ExtraDelightItems.JELLY_LIGHT_GREY_FEAST_ITEM,
			ExtraDelightItems.JELLY_CYAN_FEAST_ITEM,
			ExtraDelightItems.JELLY_PURPLE_FEAST_ITEM,
			ExtraDelightItems.JELLY_BLUE_FEAST_ITEM,
			ExtraDelightItems.JELLY_BROWN_FEAST_ITEM,
			ExtraDelightItems.JELLY_GREEN_FEAST_ITEM,
			ExtraDelightItems.JELLY_RED_FEAST_ITEM,
			ExtraDelightItems.JELLY_BLACK_FEAST_ITEM,
			// Cakes and Pies
			ExtraDelightItems.CHEESECAKE_ITEM,
			ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM,
			ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM,
			ExtraDelightItems.GLOW_BERRY_PIE_ITEM,
			ExtraDelightItems.HONEY_CHEESECAKE_ITEM,
			ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM,
			ExtraDelightItems.SWEET_BERRY_PIE_ITEM,
			ExtraDelightItems.QUICHE,
			ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM,
			ExtraDelightItems.PUMPKIN_PIE_ITEM,
			ExtraDelightItems.PUMPKIN_ROLL_FEAST,
			ExtraDelightItems.APPLE_CHEESECAKE_ITEM,
			ExtraDelightItems.COFFEE_CAKE_FEAST,
			ExtraDelightItems.MILK_TART_FEAST,
			ExtraDelightItems.CHOCOLATE_CAKE_BLOCK
	);

	static Set<DeferredItem<Item>> servings = Set.of(
			ExtraDelightItems.JELLY_WHITE,
			ExtraDelightItems.JELLY_ORANGE,
			ExtraDelightItems.JELLY_MAGENTA,
			ExtraDelightItems.JELLY_LIGHT_BLUE,
			ExtraDelightItems.JELLY_YELLOW,
			ExtraDelightItems.JELLY_LIME,
			ExtraDelightItems.JELLY_PINK,
			ExtraDelightItems.JELLY_GREY,
			ExtraDelightItems.JELLY_LIGHT_GREY,
			ExtraDelightItems.JELLY_CYAN,
			ExtraDelightItems.JELLY_PURPLE,
			ExtraDelightItems.JELLY_BLUE,
			ExtraDelightItems.JELLY_BROWN,
			ExtraDelightItems.JELLY_GREEN,
			ExtraDelightItems.JELLY_RED,
			ExtraDelightItems.JELLY_BLACK,
			ExtraDelightItems.SALISBURY_STEAK,
			ExtraDelightItems.MASHED_POTATO_GRAVY,
			ExtraDelightItems.PORK_STEW,
			ExtraDelightItems.LAMB_STEW,
			ExtraDelightItems.CHICKEN_STEW,
			ExtraDelightItems.CURRY,
			ExtraDelightItems.MACARONI_CHEESE,
			ExtraDelightItems.MEAT_LOAF,
			ExtraDelightItems.LASAGNA,
			ExtraDelightItems.HOTDISH,
			ExtraDelightItems.HASH,
			ExtraDelightItems.POT_ROAST,
			ExtraDelightItems.BBQ_RIBS,
			ExtraDelightItems.PULLED_PORK_SANDWICH,
			ExtraDelightItems.RACK_LAMB,
			ExtraDelightItems.STIRFRY,
			ExtraDelightItems.BEEF_WELLINGTON,
			ExtraDelightItems.HAGGIS,
			ExtraDelightItems.CORNBREAD,
			ExtraDelightItems.CORN_PUDDING,
			ExtraDelightItems.APPLE_CRISP,
			ExtraDelightItems.STUFFING,
			ExtraDelightItems.POTATO_AU_GRATIN,
			ExtraDelightItems.CINNAMON_ROLL,
			ExtraDelightItems.MINT_LAMB,
			ExtraDelightItems.CHARCUTERIE_BOARD,
			ExtraDelightItems.CHRISTMAS_PUDDING,
			ExtraDelightItems.PUNCH,
			ExtraDelightItems.BROWNIE,
			ExtraDelightItems.BLONDIE,
			ExtraDelightItems.FUDGE_SLICE,
			ExtraDelightItems.STICKY_TOFFEE_PUDDING_SLICE,
			ExtraDelightItems.CRISP_RICE_TREAT,
			ExtraDelightItems.SCOTCHAROO,
			ExtraDelightItems.BLACK_FOREST_TRIFLE,
			// Cakes and Pies
			ExtraDelightItems.CHEESECAKE_SLICE,
			ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE,
			ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE,
			ExtraDelightItems.GLOW_BERRY_PIE_SLICE,
			ExtraDelightItems.HONEY_CHEESECAKE_SLICE,
			ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE,
			ExtraDelightItems.SWEET_BERRY_PIE_SLICE,
			ExtraDelightItems.QUICHE_SLICE,
			ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE,
			ExtraDelightItems.PUMPKIN_PIE_SLICE,
			ExtraDelightItems.PUMPKIN_ROLL,
			ExtraDelightItems.APPLE_CHEESECAKE_SLICE,
			ExtraDelightItems.MONKEY_BREAD,
			ExtraDelightItems.COFFEE_CAKE_SLICE,
			ExtraDelightItems.MILK_TART_SLICE,
			ExtraDelightItems.CHOCOLATE_CAKE
	);

	static Set<DeferredItem<Item>> butchercraft = Set.of(
			ExtraDelightItems.SAUSAGE_ROLL,
			ExtraDelightItems.SOS,
			ExtraDelightItems.LIVER_ONIONS,
			ExtraDelightItems.STUFFED_HEART,
			ExtraDelightItems.FRIED_BRAINS,
			ExtraDelightItems.OXTAIL_SOUP,
			ExtraDelightItems.MEAT_LOAF_FEAST,
			ExtraDelightItems.MEAT_LOAF,
			ExtraDelightItems.POT_ROAST_FEAST_ITEM,
			ExtraDelightItems.POT_ROAST,
			ExtraDelightItems.BBQ_RIBS_FEAST_ITEM,
			ExtraDelightItems.BBQ_RIBS,
			ExtraDelightItems.PULLED_PORK_FEAST_ITEM,
			ExtraDelightItems.PULLED_PORK_SANDWICH,
			ExtraDelightItems.RACK_LAMB_FEAST_ITEM,
			ExtraDelightItems.RACK_LAMB,
			ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM,
			ExtraDelightItems.BEEF_WELLINGTON,
			ExtraDelightItems.HAGGIS_FEAST_ITEM,
			ExtraDelightItems.HAGGIS,
			ExtraDelightItems.HOTDISH_FEAST,
			ExtraDelightItems.HOTDISH,
			ExtraDelightItems.MINT_LAMB_FEAST,
			ExtraDelightItems.MINT_LAMB,
			ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK,
			ExtraDelightItems.BLOOD_CHOCOLATE_FENCE,
			ExtraDelightItems.BLOOD_CHOCOLATE_FENCE_GATE,
			ExtraDelightItems.BLOOD_CHOCOLATE_STAIRS,
			ExtraDelightItems.BLOOD_CHOCOLATE_DOOR,
			ExtraDelightItems.BLOOD_CHOCOLATE_TRAPDOOR,
			ExtraDelightItems.BLOOD_CHOCOLATE_SLAB,
			ExtraDelightItems.BLOOD_CHOCOLATE_PILLAR,
			ExtraDelightItems.BLOOD_CHOCOLATE_BAR,
			ExtraDelightItems.BLOOD_CHOCOLATE_CHIPS,
			ExtraDelightItems.BLOOD_CHOCOLATE_FILLED_BAR,
			ExtraDelightItems.BLOOD_CHOCOLATE_TRUFFLE,
			ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER,
			ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN
	);
}

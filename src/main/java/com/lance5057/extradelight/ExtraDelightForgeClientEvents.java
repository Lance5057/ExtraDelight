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

		if (butchercraft.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip().add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.butchercraft")
					.withStyle(ChatFormatting.RED));
		}
	}

	static Set<DeferredItem<Item>> feasts = Set.of(ExtraDelightItems.APPLE_CRISP_FEAST);

	static Set<DeferredItem<Item>> butchercraft = Set.of(ExtraDelightItems.STUFFED_HEART);
}

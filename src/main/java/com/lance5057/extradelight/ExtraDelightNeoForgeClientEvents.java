package com.lance5057.extradelight;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mojang.blaze3d.shaders.FogShape;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@EventBusSubscriber(modid = ExtraDelight.MOD_ID, value = Dist.CLIENT)
public class ExtraDelightNeoForgeClientEvents {
	@SubscribeEvent
	public static void onFogDensityEvent(ViewportEvent.RenderFog event) {
		if (Minecraft.getInstance().player.level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
			event.setNearPlaneDistance(-8);
			event.scaleFarPlaneDistance(0.25f);
			event.setFogShape(FogShape.CYLINDER);
			event.setCanceled(true);
		}

	}

	@SubscribeEvent
	public static void onFogColorEvent(ViewportEvent.ComputeFogColor event) {
		if (Minecraft.getInstance().player.level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
			float f = 0.5f;
			event.setRed(f);
			event.setBlue(f);
			event.setGreen(f);
		}
	}

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

//		TooltipProvider tooltipProvider1 = stack.get(ExtraDelightComponents.DYNAMIC_FOOD.get());
//
//		if (tooltipProvider1 != null) {
//			tooltipProvider1.addToTooltip(ctx, i -> {
//				tooltip.add(i);
//			}, flag);
//		}
	}

	@SubscribeEvent
	public static void addToolTip(ItemTooltipEvent event) {
		if (feasts.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip()
					.add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.feast").withStyle(ChatFormatting.BLUE));
		}

		if (servings.stream().anyMatch(s -> event.getItemStack().is(s))) {
			event.getToolTip().add(
					Component.translatable(ExtraDelight.MOD_ID + ".tooltip.serving").withStyle(ChatFormatting.BLUE));
		}

		if (!ModList.get().isLoaded("butchercraft"))
			if (butchercraft.stream().anyMatch(s -> event.getItemStack().is(s))) {
				event.getToolTip().add(Component.translatable(ExtraDelight.MOD_ID + ".tooltip.butchercraft")
						.withStyle(ChatFormatting.RED));
			}
	}

	public static Set<DeferredItem<Item>> feasts = new HashSet<DeferredItem<Item>>();

	public static Set<DeferredItem<Item>> servings = new HashSet<DeferredItem<Item>>();

	public static Set<DeferredItem<Item>> butchercraft = new HashSet<DeferredItem<Item>>();

	@SubscribeEvent
	public static void puckerEffect(ComputeFovModifierEvent event) {
		if (event.getPlayer().hasEffect(ExtraDelightMobEffects.SOUR_PUCKER)) {
			int i = event.getPlayer().getEffect(ExtraDelightMobEffects.SOUR_PUCKER).getAmplifier() + 1;
			float s = i * 0.25f;

			event.setNewFovModifier(event.getFovModifier() - s);
		}
	}

}

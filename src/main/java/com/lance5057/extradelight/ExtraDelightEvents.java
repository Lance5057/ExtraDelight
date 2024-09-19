package com.lance5057.extradelight;

import java.util.Set;

import com.lance5057.extradelight.items.components.ChillComponent;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID)
public class ExtraDelightEvents {

//	@SubscribeEvent
//	public static void stopDimensionDestruction(BlockEvent.BreakEvent event) {
//		if (!event.getPlayer().isCreative())
//			if (event.getPlayer().level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
//				if (event.getState().getBlock() == ExtraDelightBlocks.CORN_BOTTOM.get()
//						|| event.getState().getBlock() == ExtraDelightBlocks.CORN_TOP.get()) {
//					event.getPlayer().hurt(event.getPlayer().damageSources().magic(), 1);
//					event.getLevel().playSound(event.getPlayer(), event.getPos(), SoundEvents.WITCH_CELEBRATE,
//							SoundSource.HOSTILE, 0, 1);
//					event.setCanceled(true);
//				} else {
//					event.getPlayer().addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 1));
//				}
//			}
//	}

	@SubscribeEvent
	public static void modifyComponents(ModifyDefaultComponentsEvent event) {
		// Sets the component on melon seeds
		event.modify(Items.ICE, builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(1000)));
		event.modify(Items.SNOWBALL,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(250)));
	}

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

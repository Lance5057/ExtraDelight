package com.lance5057.extradelight.events;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.items.IDynamicNamedFood;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SetDynamicFoodName {
	@SubscribeEvent
	public static void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		ItemStack items = event.getCrafting();

		if (items.getItem() instanceof IDynamicNamedFood dnf) {
			items.setHoverName(Component.literal(
					dnf.getDynamicName(event.getEntity(), event.getEntity().level, items, "ye", event.getInventory())));
		}
	}
}

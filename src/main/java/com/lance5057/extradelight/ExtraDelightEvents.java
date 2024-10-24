package com.lance5057.extradelight;

import com.lance5057.extradelight.items.components.ChillComponent;

import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID)
public class ExtraDelightEvents {

	@SubscribeEvent
	public static void modifyComponents(ModifyDefaultComponentsEvent event) {
		// Sets the component on melon seeds
		event.modify(Items.ICE, builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(1000)));
		event.modify(Items.SNOWBALL,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(250)));
	}

}

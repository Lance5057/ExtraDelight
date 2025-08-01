package com.lance5057.extradelight;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap;
import com.lance5057.extradelight.items.components.ChillComponent;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.FarmersDelight;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID)
public class ExtraDelightEvents {

	@SubscribeEvent
	public static void modifyComponents(ModifyDefaultComponentsEvent event) {
		event.modify(Items.BLUE_ICE,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(10000)));
		event.modify(Items.PACKED_ICE,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(1000)));
		event.modify(Items.ICE, builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(100)));
		event.modify(Items.SNOW_BLOCK,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(250)));
		event.modify(Items.SNOWBALL,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(50)));
	}

//	@SubscribeEvent
//	public static void itemRemapping(FMLCommonSetupEvent event) {
//		event.enqueueWork(() -> {
//			Map<ResourceLocation, DeferredItem<Item>> itemRemapping = (new ImmutableMap.Builder<ResourceLocation, DeferredItem<Item>>())
//					.put(ExtraDelight.modLoc("carrot_jam"), ExtraDelightItems.DYNAMIC_JAM).build();
//
//			for (Map.Entry<ResourceLocation, DeferredItem<Item>> mapping : itemRemapping.entrySet()) {
//				Supplier<Item> itemSupplier = itemRemapping.get(mapping.getKey());
//
//				if (itemSupplier != null) {
//					Item item = itemSupplier.get();
//					if (item != null && BuiltInRegistries.ITEM.getKey(item) != null) {
//						ExtraDelightItems.ITEMS.addAlias(mapping.getKey(), BuiltInRegistries.ITEM.getKey(item));
//						FarmersDelight.LOGGER.warn("Remapping item '{}' to '{}'...", mapping.getKey().toString(),
//								BuiltInRegistries.ITEM.getKey(item).toString());
//					}
//				}
//			}
//		});
//	}
}

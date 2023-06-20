package com.lance5057.extradelight.events;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.items.IDynamicNamedFood;

import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SetDynamicFoodName {
	@SubscribeEvent
	public static void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		ItemStack craftedItemStack = event.getCrafting();

		if (!(craftedItemStack.getItem() instanceof IDynamicNamedFood))
			return;

		List<Item> ingredients = new ArrayList<Item>();
		Container craftMatrix = event.getInventory();

		for (int i = 0; i < craftMatrix.getContainerSize(); i++) {
			if (craftMatrix.getItem(i).isEmpty()) continue;

			ingredients.add(craftMatrix.getItem(i).getItem());
		}

		ingredients.sort(Comparator.comparing(Item::toString));
		IDynamicNamedFood.writeNBTIngredientList(craftedItemStack, ingredients);

//		if (items.getItem() instanceof IDynamicNamedFood dnf) {
//			items.setHoverName(
//					dnf.getDynamicName(event.getEntity(), event.getEntity().level, items, "ye", event.getInventory()));
//		}
	}

}

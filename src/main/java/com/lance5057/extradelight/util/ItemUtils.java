package com.lance5057.extradelight.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemUtils {

	public static void giveOrDrop(ItemStack itemstack, Player p) {
		boolean flag = p.getInventory().add(itemstack);
		if (flag && itemstack.isEmpty()) {
			itemstack.setCount(1);
			ItemEntity itementity1 = p.drop(itemstack, false);
			if (itementity1 != null) {
				itementity1.makeFakeItem();
			}

			p.level().playSound((Player) null, p.getX(), p.getY(), p.getZ(),
					SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F,
					((p.getRandom().nextFloat() - p.getRandom().nextFloat()) * 0.7F + 1.0F)
							* 2.0F);
			p.containerMenu.broadcastChanges();
		} else {
			ItemEntity itementity = p.drop(itemstack, false);
			if (itementity != null) {
				itementity.setNoPickUpDelay();
				itementity.setThrower(p);
			}
		}
	}
}

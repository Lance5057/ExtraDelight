package com.lance5057.extradelight.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class MilkshakeDrinkItem extends DrinkableItem {

	protected final float heal;

	public MilkshakeDrinkItem(Properties properties, float heal) {
		super(properties, false, true);
		this.heal = heal;
	}

	public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
		player.isInPowderSnow = true;
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(heal);
		if (consumer.isOnFire())
			consumer.clearFire();
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 64;
	}
}

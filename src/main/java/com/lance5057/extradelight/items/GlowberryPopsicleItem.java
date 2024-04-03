package com.lance5057.extradelight.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GlowberryPopsicleItem extends ConsumableItem
{
	public GlowberryPopsicleItem(Properties properties) {
		super(properties);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.clearFire();
	}
}
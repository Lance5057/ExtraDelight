package com.lance5057.extradelight.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

public class ChocolateMilkItem extends MilkBottleItem {

	public ChocolateMilkItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(2.0F);
	}
}

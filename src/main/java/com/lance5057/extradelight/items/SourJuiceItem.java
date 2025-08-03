package com.lance5057.extradelight.items;

import com.lance5057.extradelight.ExtraDelightMobEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class SourJuiceItem extends DrinkableItem {
	final int potency;

	public SourJuiceItem(Properties properties, int potency) {
		super(properties, false, true);
		this.potency = potency;
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.addEffect(new MobEffectInstance(ExtraDelightMobEffects.SOUR_PUCKER, 100, potency));
	}
}

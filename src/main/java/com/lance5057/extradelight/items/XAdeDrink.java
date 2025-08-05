package com.lance5057.extradelight.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class XAdeDrink extends DrinkableItem {
	final int potency;

	public XAdeDrink(Properties properties, int potency) {

		super(properties, false, true);
		this.potency = potency;
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, FoodValues.MEDIUM_DURATION));
//		consumer.addEffect(new MobEffectInstance(ExtraDelightMobEffects.SUNSHINE.get(), FoodValues.MEDIUM_DURATION, potency));
	}

}

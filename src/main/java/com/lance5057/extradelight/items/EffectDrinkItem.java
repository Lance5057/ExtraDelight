package com.lance5057.extradelight.items;

import java.util.List;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class EffectDrinkItem extends DrinkableItem {

	final List<MobEffectInstance> effects;
	final int healAmount;

	public EffectDrinkItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip,
			int healAmount, MobEffectInstance... effects) {
		super(properties, hasPotionEffectTooltip, hasCustomTooltip);
		this.effects = List.of(effects);
		this.healAmount = healAmount;
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(healAmount);
		for (MobEffectInstance mbi : effects)
			consumer.addEffect(mbi);
	}
}

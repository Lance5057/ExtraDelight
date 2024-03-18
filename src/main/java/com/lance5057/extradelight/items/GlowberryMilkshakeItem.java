package com.lance5057.extradelight.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GlowberryMilkshakeItem extends MilkshakeDrinkItem {

	public GlowberryMilkshakeItem(Properties properties, float heal) {
		super(properties, heal);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(heal);
		consumer.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100));
	}
}

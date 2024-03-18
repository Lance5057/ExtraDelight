package com.lance5057.extradelight.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class GlowberryJuiceItem extends DrinkableItem {
	public GlowberryJuiceItem(Properties properties) {
		super(properties, false, true);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(2.0F);
		consumer.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100));
	}
}
package com.lance5057.extradelight.items;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class GourmetHotCocoa extends DrinkableItem {
	public GourmetHotCocoa(Item.Properties properties) {
		super(properties, false, true);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		Iterator<MobEffectInstance> itr = consumer.getActiveEffects().iterator();
		ArrayList<Holder<MobEffect>> compatibleEffects = new ArrayList<>();

		while (itr.hasNext()) {
			MobEffectInstance effect = itr.next();
			if (effect.getEffect().value().getCategory().equals(MobEffectCategory.HARMFUL)
					&& effect.getCures().contains(EffectCures.MILK)) {
				compatibleEffects.add(effect.getEffect());
			}
		}

		if (compatibleEffects.size() > 0) {
			for (Holder<MobEffect> effect : compatibleEffects) {
				MobEffectInstance selectedEffect = consumer.getEffect(effect);
				if (selectedEffect != null && !net.neoforged.neoforge.event.EventHooks.onEffectRemoved(consumer,
						selectedEffect, EffectCures.MILK)) {
					consumer.removeEffect(selectedEffect.getEffect());
				}
			}
		}
	}
}

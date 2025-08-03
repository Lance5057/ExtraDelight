package com.lance5057.extradelight.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class SunshineEffect extends MobEffect {

	public SunshineEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xffff00);
	}

	@Override
	public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
		if (livingEntity.hasEffect(MobEffects.BLINDNESS)) {
			MobEffectInstance mbi = livingEntity.getEffect(MobEffects.BLINDNESS);
			if (mbi.getAmplifier() <= amplifier) {
				int i = mbi.getAmplifier() - amplifier;
				if (i == 0)
					livingEntity.removeEffect(MobEffects.BLINDNESS);
				else
					livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, i));
			}
		}

		return true;
	}

}
package com.lance5057.extradelight.effects;

import com.lance5057.extradelight.ExtraDelightMobEffects;

import net.minecraft.core.Holder;
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

		amplifier = breakdownEffect(livingEntity, amplifier, MobEffects.BLINDNESS);
		amplifier = breakdownEffect(livingEntity, amplifier, MobEffects.DARKNESS);

		return true;
	}

	private int breakdownEffect(LivingEntity livingEntity, int amplifier, Holder<MobEffect> blindness) {
		if (amplifier >= 0)
			if (livingEntity.hasEffect(blindness)) {
				MobEffectInstance mbi = livingEntity.getEffect(blindness);

				int i = mbi.getAmplifier() - 1;
				livingEntity.removeEffect(blindness);
				if (i > -1)
					livingEntity.addEffect(new MobEffectInstance(blindness, mbi.getDuration(), i));

				amplifier--;

				int mbi2 = livingEntity.getEffect(ExtraDelightMobEffects.SUNSHINE).getDuration();

				livingEntity.removeEffect(ExtraDelightMobEffects.SUNSHINE);

				if (amplifier >= 0)
					livingEntity.addEffect(new MobEffectInstance(ExtraDelightMobEffects.SUNSHINE, mbi2, amplifier));
			}

		return amplifier;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

}
package com.lance5057.extradelight;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ExtraDelightNeoforgeEvents {
	@SubscribeEvent
	public static void picklePoison(LivingIncomingDamageEvent event) {
		if (event.getSource().is(NeoForgeMod.POISON_DAMAGE)) {
			LivingEntity le = event.getEntity();
			if (le.hasEffect(ExtraDelightMobEffects.PICKLED)) {
				float amp = le.getEffect(ExtraDelightMobEffects.PICKLED).getAmplifier();

				if (le.level().getRandom().nextFloat() <= (amp + 1) / 4f) {
					event.setCanceled(true);
				}
			}
		}
	}
}

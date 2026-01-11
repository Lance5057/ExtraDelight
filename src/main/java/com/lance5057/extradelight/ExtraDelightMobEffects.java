package com.lance5057.extradelight;

import com.lance5057.extradelight.effects.PickledEffect;
import com.lance5057.extradelight.effects.SourPuckerEffect;
import com.lance5057.extradelight.effects.SunshineEffect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightMobEffects {
	private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT,
			ExtraDelight.MOD_ID);

	public static final DeferredHolder<MobEffect, PickledEffect> PICKLED = EFFECTS.register("pickled",
			PickledEffect::new);
	public static final DeferredHolder<MobEffect, SourPuckerEffect> SOUR_PUCKER = EFFECTS.register("sour_pucker",
			SourPuckerEffect::new);
	public static final DeferredHolder<MobEffect, SunshineEffect> SUNSHINE = EFFECTS.register("sunshine",
			SunshineEffect::new);

	public static void register(IEventBus modBus) {
		EFFECTS.register(modBus);
	}
}

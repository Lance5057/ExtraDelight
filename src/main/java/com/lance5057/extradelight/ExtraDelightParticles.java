package com.lance5057.extradelight;

import java.util.function.Supplier;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightParticles {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(Registries.PARTICLE_TYPE, ExtraDelight.MOD_ID);

	public static final Supplier<SimpleParticleType> PETALS = PARTICLE_TYPES.register("petals",
			() -> new SimpleParticleType(true));
}

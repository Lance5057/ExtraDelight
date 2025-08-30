package com.lance5057.extradelight;

import java.util.function.Supplier;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightParticles {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(Registries.PARTICLE_TYPE, ExtraDelight.MOD_ID);

	public static final Supplier<SimpleParticleType> CITRUS_PETALS = PARTICLE_TYPES.register("citrus_petals",
			() -> new SimpleParticleType(true));
	
	public static final Supplier<SimpleParticleType> HAZELNUT_PETALS = PARTICLE_TYPES.register("hazelnut_petals",
			() -> new SimpleParticleType(true));
}

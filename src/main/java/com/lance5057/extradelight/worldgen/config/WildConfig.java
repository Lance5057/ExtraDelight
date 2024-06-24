package com.lance5057.extradelight.worldgen.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record WildConfig(int minCount, int maxCount, int xzSpread, int ySpread, int tries)
		implements FeatureConfiguration {
	public static final Codec<WildConfig> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(ExtraCodecs.NON_NEGATIVE_INT.fieldOf("min_count").orElse(2).forGetter(WildConfig::minCount),
					ExtraCodecs.POSITIVE_INT.fieldOf("max_count").orElse(5).forGetter(WildConfig::maxCount),
					ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(7).forGetter(WildConfig::xzSpread),
					ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(WildConfig::ySpread),
					ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(WildConfig::tries))
			.apply(instance, WildConfig::new));
	

}
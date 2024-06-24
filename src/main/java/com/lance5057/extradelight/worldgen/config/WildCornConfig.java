package com.lance5057.extradelight.worldgen.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record WildCornConfig(int minCount, int maxCount, int xzSpread, int ySpread, int tries)
		implements FeatureConfiguration {
	public static final Codec<WildCornConfig> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(ExtraCodecs.NON_NEGATIVE_INT.fieldOf("min_count").orElse(2).forGetter(WildCornConfig::minCount),
					ExtraCodecs.POSITIVE_INT.fieldOf("max_count").orElse(5).forGetter(WildCornConfig::maxCount),
					ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(7).forGetter(WildCornConfig::xzSpread),
					ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(WildCornConfig::ySpread),
					ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(WildCornConfig::tries))
			.apply(instance, WildCornConfig::new));
	

}

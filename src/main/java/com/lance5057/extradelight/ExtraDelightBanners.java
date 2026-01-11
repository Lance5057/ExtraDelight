package com.lance5057.extradelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightBanners {
	public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister
			.create(Registries.BANNER_PATTERN, ExtraDelight.MOD_ID);

	public static final TagKey<BannerPattern> CITRUS_PATTERN_TAG = TagKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("citrus"));

	public static final DeferredHolder<BannerPattern, BannerPattern> CITRUS_PITH = BANNER_PATTERNS.register("banner_pattern_citrus_pith",
			() -> new BannerPattern(ExtraDelight.modLoc("banner_pattern_citrus_pith"),
					"block.minecraft.banner.extradelight.banner_pattern_citrus_pith"));
	
	public static final DeferredHolder<BannerPattern, BannerPattern> CITRUS_FRUIT = BANNER_PATTERNS.register("banner_pattern_citrus_fruit",
			() -> new BannerPattern(ExtraDelight.modLoc("banner_pattern_citrus_fruit"),
					"block.minecraft.banner.extradelight.banner_pattern_citrus_fruit"));
}

package com.lance5057.extradelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightBanners {
	public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister
			.create(Registries.BANNER_PATTERN, ExtraDelight.MOD_ID);

	public static final TagKey<BannerPattern> CITRUS_PATTERN_TAG = TagKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("citrus"));

	public static final TagKey<BannerPattern> STRAWBERRY_PATTERN_TAG = TagKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("strawberry"));

	public static final ResourceKey<BannerPattern> CITRUS_PITH = ResourceKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("banner_pattern_citrus_pith"));

	public static final ResourceKey<BannerPattern> CITRUS_FRUIT = ResourceKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("banner_pattern_citrus_fruit"));

	public static final ResourceKey<BannerPattern> STRAWBERRY_OUTLINE = ResourceKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("banner_pattern_strawberry"));

	public static final ResourceKey<BannerPattern> STRAWBERRY_FILL = ResourceKey.create(Registries.BANNER_PATTERN,
			ExtraDelight.modLoc("banner_pattern_strawberry_fill"));

	public static final ResourceKey<BannerPattern> STRAWBERRY_LEAVES_OUTLINE = ResourceKey
			.create(Registries.BANNER_PATTERN, ExtraDelight.modLoc("banner_pattern_strawberry_leaves"));

	public static final ResourceKey<BannerPattern> STRAWBERRY_LEAVES_FILL = ResourceKey
			.create(Registries.BANNER_PATTERN, ExtraDelight.modLoc("banner_pattern_strawberry_leaves_fill"));
}

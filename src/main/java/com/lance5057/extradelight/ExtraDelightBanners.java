package com.lance5057.extradelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ExtraDelightBanners {
//	 public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, ExtraDelight.MOD_ID);

	public static final ResourceKey<BannerPattern> CITRUS_RIND = register("citrus_rind");

	private static ResourceKey<BannerPattern> register(String name) {
		return ResourceKey.create(Registries.BANNER_PATTERN, ExtraDelight.modLoc(name));
	}

	public static void bootstrap(BootstrapContext<BannerPattern> context) {
		context.register(CITRUS_RIND, new BannerPattern(CITRUS_RIND.location(),
				"block.minecraft.banner.extradelight.citrus_rind"));
	}
	
	public static final TagKey<BannerPattern> CITRUS_RIND_BANNER_PATTERN = create("pattern_item/citrus_rind");
	
	private static TagKey<BannerPattern> create(String name) {
		return TagKey.create(Registries.BANNER_PATTERN, ExtraDelight.modLoc(name));
	}
}

package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBanners;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class EDBannerTags extends TagsProvider<BannerPattern> {

	public EDBannerTags(PackOutput output, CompletableFuture<Provider> provider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, Registries.BANNER_PATTERN, provider, ExtraDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(ExtraDelightBanners.CITRUS_PATTERN_TAG).add(ExtraDelightBanners.CITRUS_PITH)
				.add(ExtraDelightBanners.CITRUS_FRUIT);
		this.tag(ExtraDelightBanners.STRAWBERRY_PATTERN_TAG).add(ExtraDelightBanners.STRAWBERRY_FILL)
				.add(ExtraDelightBanners.STRAWBERRY_OUTLINE).add(ExtraDelightBanners.STRAWBERRY_LEAVES_FILL)
				.add(ExtraDelightBanners.STRAWBERRY_LEAVES_OUTLINE);
	}
}

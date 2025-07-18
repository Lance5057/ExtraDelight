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
//		this.tag(ExtraDelightBanners.CITRUS_RIND_BANNER_PATTERN).add(ExtraDelightBanners.CITRUS_RIND);
	}
}

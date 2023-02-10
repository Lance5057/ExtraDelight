package com.lance5057.extradelight.data;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {

	public ItemTags(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ExtraDelightTags.PESTLES).add(ExtraDelightItems.PESTLE_AMETHYST.get(),
				ExtraDelightItems.PESTLE_ANDESITE.get(), ExtraDelightItems.PESTLE_BASALT.get(),
				ExtraDelightItems.PESTLE_BLACKSTONE.get(), ExtraDelightItems.PESTLE_DEEPSLATE.get(),
				ExtraDelightItems.PESTLE_DIORITE.get(), ExtraDelightItems.PESTLE_ENDSTONE.get(),
				ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get(), ExtraDelightItems.PESTLE_GRANITE.get(),
				ExtraDelightItems.PESTLE_STONE.get());
	}

}

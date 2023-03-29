package com.lance5057.extradelight.data;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EDItemTags extends ItemTagsProvider {

	public EDItemTags(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId,
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

		tag(ExtraDelightTags.SPOONS).add(ExtraDelightItems.WOODEN_SPOON.get(), ExtraDelightItems.STONE_SPOON.get(),
				ExtraDelightItems.IRON_SPOON.get(), ExtraDelightItems.GOLD_SPOON.get(),
				ExtraDelightItems.DIAMOND_SPOON.get(), ExtraDelightItems.NETHERITE_SPOON.get());

		tag(ExtraDelightTags.MAKES_STOCK).add(Items.BONE).addOptionalTag(new ResourceLocation("forge", "vegetables"))
				.add(Items.BEEF, Items.COOKED_BEEF, Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.CHICKEN,
						Items.COOKED_CHICKEN, Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON);

		tag(ExtraDelightTags.FRUIT_APPLE).add(Items.APPLE);
		tag(ExtraDelightTags.FRUIT_GLOW_BERRY).add(Items.GLOW_BERRIES);
		tag(ExtraDelightTags.FRUIT_SWEET_BERRY).add(Items.SWEET_BERRIES);

		tag(ExtraDelightTags.FRUIT).addTag(ExtraDelightTags.FRUIT_APPLE).addTag(ExtraDelightTags.FRUIT_GLOW_BERRY)
				.addTag(ExtraDelightTags.FRUIT_SWEET_BERRY);

		tag(ExtraDelightTags.FRYING_OIL).add(ExtraDelightItems.COOKING_OIL.get());
		tag(ExtraDelightTags.VINEGAR).add(ExtraDelightItems.VINEGAR.get());

		tag(ExtraDelightTags.BREAD_SLICE).add(ExtraDelightItems.BREAD_SLICE.get());
		tag(ExtraDelightTags.TOAST).add(ExtraDelightItems.TOAST.get());
		tag(ExtraDelightTags.BREAD).add(Items.BREAD);

		tag(Tags.Items.SLIMEBALLS).add(ExtraDelightItems.SEAWEED_PASTE.get());
	}

}

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
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

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

		tag(ExtraDelightTags.COOKING_OIL).add(ExtraDelightItems.COOKING_OIL.get());
		tag(ExtraDelightTags.FRYING_OIL).add(ExtraDelightItems.COOKING_OIL.get());
		tag(ExtraDelightTags.VINEGAR).add(ExtraDelightItems.VINEGAR.get());

		tag(ExtraDelightTags.TOAST).add(ExtraDelightItems.TOAST.get());

		tag(Tags.Items.SLIMEBALLS).add(ExtraDelightItems.SEAWEED_PASTE.get());

		tag(ExtraDelightTags.FLOUR).add(ExtraDelightItems.FLOUR.get());

		tag(ExtraDelightTags.JAM_APPLE).add(ExtraDelightItems.APPLE_JAM.get());
		tag(ExtraDelightTags.JAM_GLOW_BERRY).add(ExtraDelightItems.GLOW_BERRY_JAM.get());
		tag(ExtraDelightTags.JAM_SWEET_BERRY).add(ExtraDelightItems.SWEET_BERRY_JAM.get());
		tag(ExtraDelightTags.JAM_CARROT).add(ExtraDelightItems.CARROT_JAM.get());
		tag(ExtraDelightTags.JAM_GOLDEN_APPLE).add(ExtraDelightItems.GOLDEN_APPLE_JAM.get());

		tag(ExtraDelightTags.JAM_MUNDANE).addTag(ExtraDelightTags.JAM_APPLE).addTag(ExtraDelightTags.JAM_CARROT)
				.addTag(ExtraDelightTags.JAM_SWEET_BERRY);
		tag(ExtraDelightTags.JAM).addTag(ExtraDelightTags.JAM_MUNDANE).addTag(ExtraDelightTags.JAM_GOLDEN_APPLE)
				.addTag(ExtraDelightTags.JAM_GLOW_BERRY);

		tag(ExtraDelightTags.MEAT_COOKED).add(Items.COOKED_BEEF).add(Items.COOKED_CHICKEN).add(Items.COOKED_MUTTON)
				.add(Items.COOKED_PORKCHOP).add(Items.COOKED_RABBIT);
		tag(ExtraDelightTags.MEAT_RAW).add(Items.BEEF).add(Items.CHICKEN).add(Items.MUTTON).add(Items.PORKCHOP)
				.add(Items.RABBIT);
		tag(ExtraDelightTags.MEAT).addTag(ExtraDelightTags.MEAT_COOKED).addTag(ExtraDelightTags.MEAT_RAW);
		tag(ExtraDelightTags.BEEF_COOKED).add(Items.COOKED_BEEF);
		tag(ExtraDelightTags.BEEF_RAW).add(Items.BEEF);
		tag(ExtraDelightTags.BEEF).addTag(ExtraDelightTags.BEEF_COOKED).addTag(ExtraDelightTags.BEEF_RAW);

		tag(ExtraDelightTags.SWEETENER).add(Items.HONEY_BOTTLE).add(Items.SUGAR);
		tag(ExtraDelightTags.MAYO).add(ExtraDelightItems.MAYO.get());
		tag(ExtraDelightTags.BREAD_SLICE).add(ExtraDelightItems.BREAD_SLICE.get()).add(ExtraDelightItems.TOAST.get());
		tag(ExtraDelightTags.TOAST).add(ExtraDelightItems.TOAST.get());
		tag(ExtraDelightTags.CHEESE).add(ExtraDelightItems.CHEESE.get());
		tag(ExtraDelightTags.GROUND_MEAT_RAW).add(ModItems.MINCED_BEEF.get());
		tag(ExtraDelightTags.GELATIN).add(ExtraDelightItems.AGAR_AGAR.get());
		tag(ExtraDelightTags.BUTTER).add(ExtraDelightItems.BUTTER.get());
		tag(ExtraDelightTags.GRAVY).add(ExtraDelightItems.GRAVY.get());
		tag(ExtraDelightTags.CONDIMENTS).add(ExtraDelightItems.KETCHUP.get()).add(ExtraDelightItems.BBQ_SAUCE.get())
				.add(ExtraDelightItems.MAYO.get());

		tag(ExtraDelightTags.STARCH).add(ModItems.RICE.get(), ExtraDelightItems.POTATO_STICKS.get(),
				ExtraDelightItems.GRATED_POTATO.get(), ExtraDelightItems.SLICED_POTATO.get());

		tag(ExtraDelightTags.SOUP).add(ExtraDelightItems.CARROT_SOUP.get(), ExtraDelightItems.FISH_SOUP.get(),
				ExtraDelightItems.OXTAIL_SOUP.get(), ExtraDelightItems.POTATO_SOUP.get(),
				ExtraDelightItems.TOMATO_SOUP.get(), ModItems.CHICKEN_SOUP.get(), ModItems.NOODLE_SOUP.get(),
				ModItems.PUMPKIN_SOUP.get(), ModItems.VEGETABLE_SOUP.get(), Items.BEETROOT_SOUP, Items.MUSHROOM_STEW);

		tag(ExtraDelightTags.PROCESSED_ONION).addOptionalTag(ForgeTags.CROPS_ONION.location())
				.add(ExtraDelightItems.SLICED_ONION.get());
		tag(ExtraDelightTags.SLICED_ONION).add(ExtraDelightItems.SLICED_ONION.get());

		tag(ExtraDelightTags.PROCESSED_POTATO).addTag(Tags.Items.CROPS_POTATO).add(
				ExtraDelightItems.POTATO_STICKS.get(), ExtraDelightItems.SLICED_POTATO.get(),
				ExtraDelightItems.GRATED_POTATO.get());
		tag(ExtraDelightTags.POTATO_STICKS).add(ExtraDelightItems.POTATO_STICKS.get());
		tag(ExtraDelightTags.SLICED_POTATO).add(ExtraDelightItems.SLICED_POTATO.get());
		tag(ExtraDelightTags.GRATED_POTATO).add(ExtraDelightItems.GRATED_POTATO.get());

		tag(ExtraDelightTags.PROCESSED_CARROT).addTag(Tags.Items.CROPS_CARROT)
				.add(ExtraDelightItems.GRATED_CARROT.get());
		tag(ExtraDelightTags.GRATED_CARROT).add(ExtraDelightItems.GRATED_CARROT.get());

		tag(ExtraDelightTags.PROCESSED_TOMATO).addOptionalTag(ForgeTags.CROPS_TOMATO.location())
				.add(ExtraDelightItems.SLICED_TOMATO.get());
		tag(ExtraDelightTags.SLICED_TOMATO).add(ExtraDelightItems.SLICED_TOMATO.get());

		tag(ExtraDelightTags.PROCESSED_APPLE).addTag(ExtraDelightTags.FRUIT_APPLE)
				.add(ExtraDelightItems.SLICED_APPLE.get());
		tag(ExtraDelightTags.SLICED_APPLE).add(ExtraDelightItems.SLICED_APPLE.get());

		tag(ExtraDelightTags.PROCESSED_VEG).addTag(ExtraDelightTags.PROCESSED_CARROT)
				.addTag(ExtraDelightTags.PROCESSED_TOMATO).addTag(ExtraDelightTags.PROCESSED_POTATO)
				.addTag(ExtraDelightTags.PROCESSED_ONION);

		tag(ExtraDelightTags.PROCESSED_FRUIT).addTag(ExtraDelightTags.PROCESSED_APPLE);
		tag(ExtraDelightTags.PROCESSED_PRODUCE).addTag(ExtraDelightTags.PROCESSED_FRUIT)
				.addTag(ExtraDelightTags.PROCESSED_VEG);

		tag(ForgeTags.COOKED_EGGS).add(ExtraDelightItems.BOILED_EGG.get(), ExtraDelightItems.SCRAMBLED_EGGS.get());

		tag(ExtraDelightTags.RICEBALL_FILLING)
				.add(ExtraDelightItems.EGG_SALAD.get(), ExtraDelightItems.SCRAMBLED_EGGS.get(),
						ExtraDelightItems.FISH_SALAD.get(), ExtraDelightItems.BOILED_EGG.get())
				.addTag(ExtraDelightTags.CHEESE);

		tag(ExtraDelightTags.JELLY).add(ExtraDelightItems.JELLY_BLACK.get(), ExtraDelightItems.JELLY_BLUE.get(),
				ExtraDelightItems.JELLY_BROWN.get(), ExtraDelightItems.JELLY_CYAN.get(),
				ExtraDelightItems.JELLY_GREEN.get(), ExtraDelightItems.JELLY_GREY.get(),
				ExtraDelightItems.JELLY_LIGHT_BLUE.get(),ExtraDelightItems.JELLY_LIGHT_GREY.get(),
				ExtraDelightItems.JELLY_LIME.get(),ExtraDelightItems.JELLY_MAGENTA.get(),
				ExtraDelightItems.JELLY_ORANGE.get(),ExtraDelightItems.JELLY_PINK.get(),
				ExtraDelightItems.JELLY_PURPLE.get(),ExtraDelightItems.JELLY_RED.get(),
				ExtraDelightItems.JELLY_WHITE.get(),ExtraDelightItems.JELLY_YELLOW.get());
	}

}

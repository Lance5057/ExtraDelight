package com.lance5057.extradelight.data;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

public class EDItemTags extends ItemTagsProvider {

	public EDItemTags(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(ExtraDelightTags.TRAYS).add(ExtraDelightItems.TRAY.get(), ExtraDelightItems.BAKING_STONE.get(),
				ExtraDelightItems.PIE_DISH.get(), ExtraDelightItems.SQUARE_PAN.get(), ExtraDelightItems.LOAF_PAN.get(),
				ExtraDelightItems.ROUND_PAN.get(), ExtraDelightItems.SHEET.get(), ExtraDelightItems.MUFFIN_TIN.get());

		tag(ExtraDelightTags.MORTAR).add(ExtraDelightItems.MORTAR_AMETHYST.get(),
				ExtraDelightItems.MORTAR_ANDESITE.get(), ExtraDelightItems.MORTAR_BASALT.get(),
				ExtraDelightItems.MORTAR_BLACKSTONE.get(), ExtraDelightItems.MORTAR_DEEPSLATE.get(),
				ExtraDelightItems.MORTAR_DIORITE.get(), ExtraDelightItems.MORTAR_ENDSTONE.get(),
				ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get(), ExtraDelightItems.MORTAR_GRANITE.get(),
				ExtraDelightItems.MORTAR_STONE.get());

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
		tag(ExtraDelightTags.JAM_MINT).add(ExtraDelightItems.MINT_JELLY.get());

		tag(ExtraDelightTags.JAM_MUNDANE).addTag(ExtraDelightTags.JAM_APPLE).addTag(ExtraDelightTags.JAM_CARROT)
				.addTag(ExtraDelightTags.JAM_SWEET_BERRY).addTag(ExtraDelightTags.JAM_MINT);
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

		tag(ExtraDelightTags.PROCESSED_FRUIT).addTag(ExtraDelightTags.PROCESSED_APPLE).add(Items.SWEET_BERRIES,
				Items.GLOW_BERRIES, Items.MELON_SLICE);
		tag(ExtraDelightTags.PROCESSED_PRODUCE).addTag(ExtraDelightTags.PROCESSED_FRUIT)
				.addTag(ExtraDelightTags.PROCESSED_VEG);

		tag(ForgeTags.COOKED_EGGS).add(ExtraDelightItems.BOILED_EGG.get(), ExtraDelightItems.SCRAMBLED_EGGS.get());

		tag(ExtraDelightTags.CACTUS).add(ExtraDelightItems.CACTUS.get());

		tag(ExtraDelightTags.RICEBALL_FILLING).add(ExtraDelightItems.EGG_SALAD.get(),
				ExtraDelightItems.SCRAMBLED_EGGS.get(), ExtraDelightItems.FISH_SALAD.get(),
				ExtraDelightItems.BOILED_EGG.get(), ExtraDelightItems.PICKLED_GINGER.get())
				.addTag(ExtraDelightTags.CHEESE);

		tag(ExtraDelightTags.JELLY).add(ExtraDelightItems.JELLY_BLACK.get(), ExtraDelightItems.JELLY_BLUE.get(),
				ExtraDelightItems.JELLY_BROWN.get(), ExtraDelightItems.JELLY_CYAN.get(),
				ExtraDelightItems.JELLY_GREEN.get(), ExtraDelightItems.JELLY_GREY.get(),
				ExtraDelightItems.JELLY_LIGHT_BLUE.get(), ExtraDelightItems.JELLY_LIGHT_GREY.get(),
				ExtraDelightItems.JELLY_LIME.get(), ExtraDelightItems.JELLY_MAGENTA.get(),
				ExtraDelightItems.JELLY_ORANGE.get(), ExtraDelightItems.JELLY_PINK.get(),
				ExtraDelightItems.JELLY_PURPLE.get(), ExtraDelightItems.JELLY_RED.get(),
				ExtraDelightItems.JELLY_WHITE.get(), ExtraDelightItems.JELLY_YELLOW.get());

		tag(ExtraDelightTags.CORN_CONFISCATE).add(ExtraDelightItems.CORN_COB.get(), ExtraDelightItems.CORN_HUSK.get(),
				ExtraDelightItems.CORN_ON_COB.get(), ExtraDelightItems.CORN_SEEDS.get(),
				ExtraDelightItems.CORN_SILK.get(), ExtraDelightItems.UNSHUCKED_CORN.get(),
				ExtraDelightItems.CORN_CHOWDER.get(), ExtraDelightItems.CORN_FRITTERS.get(),
				ExtraDelightItems.CORN_MEAL.get(), ExtraDelightItems.CORN_PUDDING.get(),
				ExtraDelightItems.CORN_PUDDING_FEAST.get(), ExtraDelightItems.CORN_SILK_TEA.get(),
				ExtraDelightItems.CORNBREAD.get(), ExtraDelightItems.CORNBREAD_FEAST.get(),
				ExtraDelightItems.CARAMEL_POPCORN.get(), ExtraDelightItems.COOKED_CORN.get(),
				ExtraDelightItems.CREAM_CORN.get(), ExtraDelightItems.DRIED_CORN_HUSK.get(),
				ExtraDelightItems.GRILLED_CORN_ON_COB.get(), ExtraDelightItems.POPCORN.get(),
				AestheticBlocks.CORN_HUSK_DOLL_ITEM.get());

		tag(ExtraDelightTags.CANDY).add(ExtraDelightItems.CANDY_BLACK.get(), ExtraDelightItems.CANDY_BLUE.get(),
				ExtraDelightItems.CANDY_BROWN.get(), ExtraDelightItems.CANDY_CYAN.get(),
				ExtraDelightItems.CANDY_GREEN.get(), ExtraDelightItems.CANDY_GRAY.get(),
				ExtraDelightItems.CANDY_LIGHT_BLUE.get(), ExtraDelightItems.CANDY_LIGHT_GRAY.get(),
				ExtraDelightItems.CANDY_LIME.get(), ExtraDelightItems.CANDY_MAGENTA.get(),
				ExtraDelightItems.CANDY_ORANGE.get(), ExtraDelightItems.CANDY_PINK.get(),
				ExtraDelightItems.CANDY_PURPLE.get(), ExtraDelightItems.CANDY_RED.get(),
				ExtraDelightItems.CANDY_WHITE.get(), ExtraDelightItems.CANDY_YELLOW.get());

		tag(ExtraDelightTags.CANDY_BOWL_VALID).addTag(ExtraDelightTags.CANDY).add(ExtraDelightItems.CARAMEL_CANDY.get(),
				ExtraDelightItems.MINT_CANDY_BLUE.get(), ExtraDelightItems.MINT_CANDY_GREEN.get(),
				ExtraDelightItems.MINT_CANDY_RED.get(), ExtraDelightItems.CANDY_CANE_BLUE.get(),
				ExtraDelightItems.CANDY_CANE_RED.get(), ExtraDelightItems.CANDY_CANE_GREEN.get(),
				ExtraDelightItems.CANDIED_GINGER.get());

		tag(ExtraDelightTags.OFFSET_SPATULAS).add(ExtraDelightItems.OFFSET_SPATULA_DIAMOND.get(),
				ExtraDelightItems.OFFSET_SPATULA_GOLD.get(), ExtraDelightItems.OFFSET_SPATULA_IRON.get(),
				ExtraDelightItems.OFFSET_SPATULA_NETHERITE.get(), ExtraDelightItems.OFFSET_SPATULA_WOOD.get());

		tag(ExtraDelightTags.GINGER).add(ExtraDelightItems.GINGER.get());
		tag(ExtraDelightTags.GRATED_GINGER).add(ExtraDelightItems.GRATED_GINGER.get());
		tag(ExtraDelightTags.SLICED_GINGER).add(ExtraDelightItems.SLICED_GINGER.get());
		tag(ExtraDelightTags.PROCESSED_GINGER).addTag(ExtraDelightTags.GRATED_GINGER)
				.addTag(ExtraDelightTags.SLICED_GINGER);

		tag(ExtraDelightTags.COOKIE_DOUGH).add(ExtraDelightItems.APPLE_COOKIE_DOUGH.get(),
				ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get(), ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get(),
				ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get(), ExtraDelightItems.HONEY_COOKIE_DOUGH.get(),
				ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get(), ExtraDelightItems.SUGAR_COOKIE_DOUGH.get(),
				ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get());

		tag(ExtraDelightTags.SALT).add(ExtraDelightItems.BACON_CHEESEBURGER.get(),
				ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get(), ExtraDelightItems.BACON_EGG_SANDWICH.get(),
				ExtraDelightItems.BAD_FOOD.get(), ExtraDelightItems.BBQ_RIBS.get(),
				ExtraDelightItems.BEEF_STEW_RICE.get(), ExtraDelightItems.BEEF_WELLINGTON.get(),
				ExtraDelightItems.BEET_MINT_SALAD.get(), ExtraDelightItems.BOILED_EGG.get(),
				ExtraDelightItems.BUTTERED_PASTA.get(), ExtraDelightItems.BUTTERED_TOAST.get(),
				ExtraDelightItems.CACTUS_EGGS.get(), ExtraDelightItems.CACTUS_SALAD.get(),
				ExtraDelightItems.CACTUS_SOUP.get(), ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE.get(),
				ExtraDelightItems.CARAMEL_CUSTARD.get(), ExtraDelightItems.CARAMEL_POPCORN.get(),
				ExtraDelightItems.CARAMEL_POPSICLE.get(), ExtraDelightItems.CARROT_SALAD.get(),
				ExtraDelightItems.CHEESE_SANDWICH.get(), ExtraDelightItems.CHEESEBURGER.get(),
				ExtraDelightItems.CHICKEN_ALFREDO.get(), ExtraDelightItems.CHICKEN_FRIED_STEAK.get(),
				ExtraDelightItems.CHICKEN_PARM.get(), ExtraDelightItems.CHICKEN_STEW.get(),
				ExtraDelightItems.CHICKEN_STEW_RICE.get(), ExtraDelightItems.CONGEE.get(),
				ExtraDelightItems.COOKED_CACTUS.get(), ExtraDelightItems.COOKED_CORN.get(),
				ExtraDelightItems.COOKED_PASTA.get(), ExtraDelightItems.CORN_CHOWDER.get(),
				ExtraDelightItems.CORN_FRITTERS.get(), ExtraDelightItems.CORN_PUDDING.get(),
				ExtraDelightItems.CORNBREAD.get(), ExtraDelightItems.CROQUE_MADAME.get(),
				ExtraDelightItems.CROQUE_MONSIEUR.get(), ExtraDelightItems.CURRY.get(),
				ExtraDelightItems.CURRY_RICE.get(), ExtraDelightItems.DRIED_FRUIT.get(),
				ExtraDelightItems.EGG_BASKET.get(), ExtraDelightItems.EGG_SALAD.get(),
				ExtraDelightItems.EGG_SALAD_SANDWICH.get(), ExtraDelightItems.FISH_AND_CHIPS.get(),
				ExtraDelightItems.FISH_CAKES.get(), ExtraDelightItems.FISH_SALAD.get(),
				ExtraDelightItems.FISH_SALAD_SANDWICH.get(), ExtraDelightItems.FISH_SOUP.get(),
				ExtraDelightItems.FISH_STEW_RICE.get(), ExtraDelightItems.FRENCH_FRIES.get(),
				ExtraDelightItems.FRENCH_TOAST.get(), ExtraDelightItems.FRIED_BRAINS.get(),
				ExtraDelightItems.FRIED_CHICKEN.get(), ExtraDelightItems.FRIED_FISH.get(),
				ExtraDelightItems.FRIED_MUSHROOMS.get(), ExtraDelightItems.FURIKAKE_RICE.get(),
				ExtraDelightItems.GRILLED_CHEESE.get(), ExtraDelightItems.GRILLED_CORN_ON_COB.get(),
				ExtraDelightItems.HAGGIS.get(), ExtraDelightItems.HASH.get(), ExtraDelightItems.HASHBROWNS.get(),
				ExtraDelightItems.HOTDISH.get(), ExtraDelightItems.JERKY.get(), ExtraDelightItems.LAMB_STEW.get(),
				ExtraDelightItems.LAMB_STEW_RICE.get(), ExtraDelightItems.LASAGNA.get(),
				ExtraDelightItems.LIVER_ONIONS.get(), ExtraDelightItems.LUGAW.get(),
				ExtraDelightItems.MACARONI_CHEESE.get(), ExtraDelightItems.MASHED_POTATO_GRAVY.get(),
				ExtraDelightItems.MEAT_LOAF.get(), ExtraDelightItems.MEAT_LOAF_SANDWICH.get(),
				ExtraDelightItems.MEAT_PIE_SLICE.get(), ExtraDelightItems.MUSHROOM_BURGER.get(),
				ExtraDelightItems.MUSHROOM_RISOTTO.get(), ExtraDelightItems.OMELETTE.get(),
				ExtraDelightItems.OXTAIL_SOUP.get(), ExtraDelightItems.PASTA_ALFREDO.get(),
				ExtraDelightItems.PASTA_TOMATO.get(), ExtraDelightItems.POPCORN.get(),
				ExtraDelightItems.PORK_STEW.get(), ExtraDelightItems.PORK_STEW_RICE.get(),
				ExtraDelightItems.PORK_TENDERLOIN.get(), ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get(),
				ExtraDelightItems.POT_ROAST.get(), ExtraDelightItems.POTATO_AU_GRATIN.get(),
				ExtraDelightItems.POTATO_CHIPS.get(), ExtraDelightItems.POTATO_SOUP.get(),
				ExtraDelightItems.PULLED_PORK_SANDWICH.get(), ExtraDelightItems.QUICHE_SLICE.get(),
				ExtraDelightItems.RABBIT_STEW_RICE.get(), ExtraDelightItems.RACK_LAMB.get(),
				ExtraDelightItems.RICEBALL.get(), ExtraDelightItems.RICEBALL_FILLED.get(),
				ExtraDelightItems.ROASTED_CARROT.get(), ExtraDelightItems.ROASTED_PUMPKIN_SEEDS.get(),
				ExtraDelightItems.ROLL.get(), ExtraDelightItems.SALAD.get(), ExtraDelightItems.SALISBURY_STEAK.get(),
				ExtraDelightItems.SAUSAGE_ROLL.get(), ExtraDelightItems.SCRAMBLED_EGGS.get(),
				ExtraDelightItems.SEAWEED_CRISPS.get(), ExtraDelightItems.SEAWEED_SALAD.get(),
				ExtraDelightItems.SLICED_APPLE.get(), ExtraDelightItems.SLICED_ONION.get(),
				ExtraDelightItems.SLICED_TOMATO.get(), ExtraDelightItems.SOS.get(), ExtraDelightItems.STIRFRY.get(),
				ExtraDelightItems.STUFFED_CACTUS.get(), ExtraDelightItems.STUFFED_HEART.get(),
				ExtraDelightItems.STUFFED_MUSHROOMS.get(), ExtraDelightItems.STUFFING.get(),
				ExtraDelightItems.SUNFLOWER_SEEDS.get(), ExtraDelightItems.TOMATO_SOUP.get());

		tag(ExtraDelightTags.CORN).add(ExtraDelightItems.CORN_ON_COB.get());
		tag(ExtraDelightTags.CORN_ON_COB).add(ExtraDelightItems.CORN_ON_COB.get());
		tag(ExtraDelightTags.CORN_KERNELS).add(ExtraDelightItems.CORN_SEEDS.get());
		tag(ExtraDelightTags.CORN_MEAL).add(ExtraDelightItems.CORN_MEAL.get());
		tag(ExtraDelightTags.COOKED_CACTUS).add(ExtraDelightItems.COOKED_CACTUS.get());
		tag(ExtraDelightTags.GROUND_CINNAMON).add(ExtraDelightItems.GROUND_CINNAMON.get());
		tag(ExtraDelightTags.MINT).add(ExtraDelightItems.MINT.get());
		tag(ExtraDelightTags.WHIPPED_CREAM).add(ExtraDelightItems.WHIPPED_CREAM.get());
		tag(ExtraDelightTags.FISH_FLAKES).add(ExtraDelightItems.FISH_FLAKES.get());
		tag(ExtraDelightTags.BOILED_EGG).add(ExtraDelightItems.BOILED_EGG.get());
		tag(ExtraDelightTags.ALFREDO_SAUCE).add(ExtraDelightItems.ALFREDO_SAUCE.get());
		tag(ExtraDelightTags.CROUTONS).add(ExtraDelightItems.CROUTONS.get());
		tag(ExtraDelightTags.DRIED_FRUIT).add(ExtraDelightItems.DRIED_FRUIT.get());
		tag(ExtraDelightTags.BREAD_CRUMBS).add(ExtraDelightItems.BREAD_CRUMBS.get());
		tag(ExtraDelightTags.POPCORN).add(ExtraDelightItems.POPCORN.get());
		tag(ExtraDelightTags.CINNAMON_STICK).add(ExtraDelightItems.CINNAMON_STICK.get());

		tag(ExtraDelightTags.SUGAR_COOKIE_DOUGH).add(ExtraDelightItems.SUGAR_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.GINGERBREAD_COOKIE_DOUGH).add(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.GLOW_BERRY_COOKIE_DOUGH).add(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.HONEY_COOKIE_DOUGH).add(ExtraDelightItems.HONEY_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.PUMPKIN_COOKIE_DOUGH).add(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.SWEET_BERRY_COOKIE_DOUGH).add(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get());
		tag(ExtraDelightTags.CHOCOLATE_CHIP_COOKIE_DOUGH).add(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get());

		tag(ExtraDelightTags.COOKIE_DOUGH).add(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get())
				.add(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get())
				.add(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get()).add(ExtraDelightItems.HONEY_COOKIE_DOUGH.get())
				.add(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get()).add(ExtraDelightItems.SWEET_BERRY_COOKIE_DOUGH.get())
				.add(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get());

		tag(ExtraDelightTags.FROSTING_BLACK).add(ExtraDelightItems.FROSTING_BLACK.get());
		tag(ExtraDelightTags.FROSTING_BLUE).add(ExtraDelightItems.FROSTING_BLUE.get());
		tag(ExtraDelightTags.FROSTING_BROWN).add(ExtraDelightItems.FROSTING_BROWN.get());
		tag(ExtraDelightTags.FROSTING_CYAN).add(ExtraDelightItems.FROSTING_CYAN.get());
		tag(ExtraDelightTags.FROSTING_GRAY).add(ExtraDelightItems.FROSTING_GRAY.get());
		tag(ExtraDelightTags.FROSTING_GREEN).add(ExtraDelightItems.FROSTING_GREEN.get());
		tag(ExtraDelightTags.FROSTING_LIGHT_BLUE).add(ExtraDelightItems.FROSTING_LIGHT_BLUE.get());
		tag(ExtraDelightTags.FROSTING_LIGHT_GRAY).add(ExtraDelightItems.FROSTING_LIGHT_GRAY.get());
		tag(ExtraDelightTags.FROSTING_LIME).add(ExtraDelightItems.FROSTING_LIME.get());
		tag(ExtraDelightTags.FROSTING_MAGENTA).add(ExtraDelightItems.FROSTING_MAGENTA.get());
		tag(ExtraDelightTags.FROSTING_ORANGE).add(ExtraDelightItems.FROSTING_ORANGE.get());
		tag(ExtraDelightTags.FROSTING_PINK).add(ExtraDelightItems.FROSTING_PINK.get());
		tag(ExtraDelightTags.FROSTING_PURPLE).add(ExtraDelightItems.FROSTING_PURPLE.get());
		tag(ExtraDelightTags.FROSTING_RED).add(ExtraDelightItems.FROSTING_RED.get());
		tag(ExtraDelightTags.FROSTING_WHITE).add(ExtraDelightItems.FROSTING_WHITE.get());
		tag(ExtraDelightTags.FROSTING_YELLOW).add(ExtraDelightItems.FROSTING_YELLOW.get());

		tag(ExtraDelightTags.FROSTING).add(ExtraDelightItems.FROSTING_BLACK.get())
				.add(ExtraDelightItems.FROSTING_BLUE.get()).add(ExtraDelightItems.FROSTING_BROWN.get())
				.add(ExtraDelightItems.FROSTING_CYAN.get()).add(ExtraDelightItems.FROSTING_GRAY.get())
				.add(ExtraDelightItems.FROSTING_GREEN.get()).add(ExtraDelightItems.FROSTING_LIGHT_BLUE.get())
				.add(ExtraDelightItems.FROSTING_LIGHT_GRAY.get()).add(ExtraDelightItems.FROSTING_LIME.get())
				.add(ExtraDelightItems.FROSTING_MAGENTA.get()).add(ExtraDelightItems.FROSTING_ORANGE.get())
				.add(ExtraDelightItems.FROSTING_PINK.get()).add(ExtraDelightItems.FROSTING_PURPLE.get())
				.add(ExtraDelightItems.FROSTING_RED.get()).add(ExtraDelightItems.FROSTING_WHITE.get())
				.add(ExtraDelightItems.FROSTING_YELLOW.get());
	}

}

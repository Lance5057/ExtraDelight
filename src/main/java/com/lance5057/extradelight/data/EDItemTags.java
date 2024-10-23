package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelightBlocks;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class EDItemTags extends ItemTagsProvider {

	public EDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
			CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, blockTagProvider, FarmersDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(ExtraDelightTags.TRAYS).add(ExtraDelightItems.TRAY.get(), ExtraDelightItems.BAKING_STONE.get(),
				ExtraDelightItems.PIE_DISH.get(), ExtraDelightItems.LOAF_PAN.get(), ExtraDelightItems.SHEET.get(),
				ExtraDelightItems.MUFFIN_TIN.get());

		tag(ExtraDelightTags.MORTAR).add(ExtraDelightItems.MORTAR_STONE.get());

		tag(ExtraDelightTags.PESTLES).add(ExtraDelightItems.PESTLE_AMETHYST.get(),
				ExtraDelightItems.PESTLE_ANDESITE.get(), ExtraDelightItems.PESTLE_BASALT.get(),
				ExtraDelightItems.PESTLE_BLACKSTONE.get(), ExtraDelightItems.PESTLE_DEEPSLATE.get(),
				ExtraDelightItems.PESTLE_DIORITE.get(), ExtraDelightItems.PESTLE_ENDSTONE.get(),
				ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get(), ExtraDelightItems.PESTLE_GRANITE.get(),
				ExtraDelightItems.PESTLE_STONE.get());

		tag(ExtraDelightTags.SPOONS).add(ExtraDelightItems.WOODEN_SPOON.get(), ExtraDelightItems.STONE_SPOON.get(),
				ExtraDelightItems.IRON_SPOON.get(), ExtraDelightItems.GOLD_SPOON.get(),
				ExtraDelightItems.DIAMOND_SPOON.get(), ExtraDelightItems.NETHERITE_SPOON.get());

		tag(ExtraDelightTags.MAKES_STOCK).add(Items.BONE)
				.add(Items.BEEF, Items.COOKED_BEEF, Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.CHICKEN,
						Items.COOKED_CHICKEN, Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON)
				.addOptionalTag(ResourceLocation.fromNamespaceAndPath("forge", "vegetables"));

		tag(ExtraDelightTags.FRUIT_APPLE).add(Items.APPLE);
		tag(ExtraDelightTags.FRUIT_GLOW_BERRY).add(Items.GLOW_BERRIES);
		tag(ExtraDelightTags.FRUIT_SWEET_BERRY).add(Items.SWEET_BERRIES);
		tag(ExtraDelightTags.FRUIT_MELON).add(Items.MELON_SLICE);

		tag(ExtraDelightTags.FRUIT).addTag(ExtraDelightTags.FRUIT_APPLE).addTag(ExtraDelightTags.FRUIT_GLOW_BERRY)
				.addTag(ExtraDelightTags.FRUIT_SWEET_BERRY).addTag(ExtraDelightTags.FRUIT_MELON);

		tag(ExtraDelightTags.COOKING_OIL).add(ExtraDelightItems.COOKING_OIL.get());
		tag(ExtraDelightTags.FRYING_OIL).add(ExtraDelightItems.COOKING_OIL.get());
		tag(ExtraDelightTags.VINEGAR).add(ExtraDelightItems.VINEGAR.get());

		tag(ExtraDelightTags.TOAST).add(ExtraDelightItems.TOAST.get());

		tag(Tags.Items.SLIMEBALLS).add(ExtraDelightItems.SEAWEED_PASTE.get());

		tag(ExtraDelightTags.FLOUR).add(ExtraDelightItems.FLOUR.get());

		tag(ExtraDelightTags.JAM_GLOW_BERRY).add(ExtraDelightItems.GLOW_BERRY_JAM.get());
		tag(ExtraDelightTags.JAM_FRUIT).add(ExtraDelightItems.JAM.get());
		tag(ExtraDelightTags.JAM_GOLDEN_APPLE).add(ExtraDelightItems.GOLDEN_APPLE_JAM.get());
		tag(ExtraDelightTags.JAM_MINT).add(ExtraDelightItems.MINT_JELLY.get());

		tag(ExtraDelightTags.JAM_MUNDANE).addTag(ExtraDelightTags.JAM_FRUIT).addTag(ExtraDelightTags.JAM_MINT);
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

		tag(ExtraDelightTags.SOUP).add(ExtraDelightItems.CARROT_SOUP.get(), ExtraDelightItems.CACTUS_SOUP.get(),
				ExtraDelightItems.FISH_SOUP.get(), ExtraDelightItems.OXTAIL_SOUP.get(),
				ExtraDelightItems.POTATO_SOUP.get(), ExtraDelightItems.TOMATO_SOUP.get(), ModItems.CHICKEN_SOUP.get(),
				ModItems.NOODLE_SOUP.get(), ModItems.PUMPKIN_SOUP.get(), ModItems.VEGETABLE_SOUP.get(),
				Items.BEETROOT_SOUP, Items.MUSHROOM_STEW);

		tag(ExtraDelightTags.PROCESSED_ONION).add(ExtraDelightItems.SLICED_ONION.get())
				.addOptionalTag(CommonTags.CROPS_ONION.location());

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

		tag(ExtraDelightTags.PROCESSED_TOMATO).add(ExtraDelightItems.SLICED_TOMATO.get())
				.addOptionalTag(CommonTags.CROPS_TOMATO.location());
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

		tag(CommonTags.FOODS_COOKED_EGG).add(ExtraDelightItems.BOILED_EGG.get(),
				ExtraDelightItems.SCRAMBLED_EGGS.get());

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
				ExtraDelightItems.CORN_SILK.get(), /* ExtraDelightItems.UNSHUCKED_CORN.get(), */
				ExtraDelightItems.CORN_CHOWDER.get(), ExtraDelightItems.CORN_FRITTERS.get(),
				ExtraDelightItems.CORN_MEAL.get(), ExtraDelightItems.CORN_PUDDING.get(),
				ExtraDelightItems.CORN_PUDDING_FEAST.get(), /* ExtraDelightItems.CORN_SILK_TEA.get(), */
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

		for (int i = 0; i < AestheticBlocks.BOW_ITEMS.size(); i++)
			tag(ExtraDelightTags.RIBBON).add(AestheticBlocks.BOW_ITEMS.get(i).get());

		tag(ExtraDelightTags.CINNAMON_LOGS).add(ExtraDelightItems.CINNAMON_LOG.get(),
				ExtraDelightItems.CINNAMON_WOOD.get(), ExtraDelightItems.STRIPPED_CINNAMON_LOG.get(),
				ExtraDelightItems.STRIPPED_CINNAMON_WOOD.get());
		tag(ExtraDelightTags.FRUIT_LOGS).add(ExtraDelightItems.FRUIT_LOG.get(), ExtraDelightItems.FRUIT_WOOD.get(),
				ExtraDelightItems.STRIPPED_FRUIT_LOG.get(),	ExtraDelightItems.STRIPPED_FRUIT_WOOD.get());

		tag(ItemTags.LOGS).add(ExtraDelightItems.CINNAMON_LOG.get(), ExtraDelightItems.STRIPPED_CINNAMON_LOG.get(),
				ExtraDelightItems.FRUIT_LOG.get(), ExtraDelightItems.STRIPPED_FRUIT_LOG.get(),
				ExtraDelightItems.CINNAMON_WOOD.get(), ExtraDelightItems.FRUIT_WOOD.get(),
				ExtraDelightItems.STRIPPED_CINNAMON_WOOD.get(), ExtraDelightItems.STRIPPED_FRUIT_WOOD.get());
		tag(ItemTags.LOGS_THAT_BURN).add(ExtraDelightItems.CINNAMON_LOG.get(), ExtraDelightItems.STRIPPED_CINNAMON_LOG.get(),
				ExtraDelightItems.FRUIT_LOG.get(), ExtraDelightItems.STRIPPED_FRUIT_LOG.get(),
				ExtraDelightItems.CINNAMON_WOOD.get(), ExtraDelightItems.FRUIT_WOOD.get(),
				ExtraDelightItems.STRIPPED_CINNAMON_WOOD.get(), ExtraDelightItems.STRIPPED_FRUIT_WOOD.get());
		tag(ItemTags.PLANKS).add(ExtraDelightItems.CINNAMON_PLANKS.get(), ExtraDelightItems.FRUIT_PLANKS.get());
		tag(ItemTags.FENCES).add(ExtraDelightItems.BLOOD_CHOCOLATE_FENCE.get(),
				ExtraDelightItems.DARK_CHOCOLATE_FENCE.get(), ExtraDelightItems.MILK_CHOCOLATE_FENCE.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_FENCE.get());
		tag(ItemTags.WOODEN_FENCES).add(ExtraDelightItems.CINNAMON_FENCE.get(), ExtraDelightItems.FRUIT_FENCE.get());
		tag(ItemTags.FENCE_GATES).add(ExtraDelightItems.CINNAMON_FENCE_GATE.get(),
				ExtraDelightItems.BLOOD_CHOCOLATE_FENCE_GATE.get(), ExtraDelightItems.DARK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightItems.FRUIT_FENCE_GATE.get(), ExtraDelightItems.MILK_CHOCOLATE_FENCE_GATE.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_FENCE_GATE.get());
		tag(ItemTags.STAIRS).add(ExtraDelightItems.BLOOD_CHOCOLATE_STAIRS.get(),
				ExtraDelightItems.DARK_CHOCOLATE_STAIRS.get(), ExtraDelightItems.MILK_CHOCOLATE_STAIRS.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_STAIRS.get());
		tag(ItemTags.WOODEN_STAIRS).add(ExtraDelightItems.CINNAMON_STAIRS.get(), ExtraDelightItems.FRUIT_STAIRS.get());
		tag(ItemTags.SLABS).add(ExtraDelightItems.BLOOD_CHOCOLATE_SLAB.get(),
				ExtraDelightItems.DARK_CHOCOLATE_SLAB.get(), ExtraDelightItems.MILK_CHOCOLATE_SLAB.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_SLAB.get());
		tag(ItemTags.WOODEN_SLABS).add(ExtraDelightItems.CINNAMON_SLAB.get(), ExtraDelightItems.FRUIT_SLAB.get());
		tag(ItemTags.TRAPDOORS).add(ExtraDelightItems.BLOOD_CHOCOLATE_TRAPDOOR.get(),
				ExtraDelightItems.DARK_CHOCOLATE_TRAPDOOR.get(), ExtraDelightItems.MILK_CHOCOLATE_TRAPDOOR.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_TRAPDOOR.get());
		tag(ItemTags.WOODEN_TRAPDOORS).add(ExtraDelightItems.CINNAMON_TRAPDOOR.get(),
				ExtraDelightItems.FRUIT_TRAPDOOR.get());
		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ExtraDelightItems.CINNAMON_PRESSURE_PLATE.get(),
				ExtraDelightItems.FRUIT_PRESSURE_PLATE.get());
		tag(ItemTags.WOODEN_BUTTONS).add(ExtraDelightItems.CINNAMON_BUTTON.get(), ExtraDelightItems.FRUIT_BUTTON.get());
		tag(ItemTags.DOORS).add(ExtraDelightItems.BLOOD_CHOCOLATE_DOOR.get(),
				ExtraDelightItems.DARK_CHOCOLATE_DOOR.get(), ExtraDelightItems.MILK_CHOCOLATE_DOOR.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_DOOR.get());
		tag(ItemTags.WOODEN_DOORS).add(ExtraDelightItems.CINNAMON_DOOR.get(), ExtraDelightItems.FRUIT_DOOR.get());
		tag(ItemTags.SAPLINGS).add(ExtraDelightItems.CINNAMON_SAPLING.get(), ExtraDelightItems.HAZELNUT_SAPLING.get());

		tag(ExtraDelightTags.MILK_CHOCOLATE_BAR).add(ExtraDelightItems.MILK_CHOCOLATE_BAR.get());
		tag(ExtraDelightTags.MILK_CHOCOLATE_BAR_FILLED).add(ExtraDelightItems.MILK_CHOCOLATE_FILLED_BAR.get());
		tag(ExtraDelightTags.MILK_CHOCOLATE_BLOCK).add(ExtraDelightItems.MILK_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.MILK_CHOCOLATE_CHIPS).add(ExtraDelightItems.MILK_CHOCOLATE_CHIPS.get());
		tag(ExtraDelightTags.MILK_CHOCOLATE_TRUFFLE).add(ExtraDelightItems.MILK_CHOCOLATE_TRUFFLE.get());

		tag(ExtraDelightTags.DARK_CHOCOLATE_BAR).add(ExtraDelightItems.DARK_CHOCOLATE_BAR.get());
		tag(ExtraDelightTags.DARK_CHOCOLATE_BAR_FILLED).add(ExtraDelightItems.DARK_CHOCOLATE_FILLED_BAR.get());
		tag(ExtraDelightTags.DARK_CHOCOLATE_BLOCK).add(ExtraDelightItems.DARK_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.DARK_CHOCOLATE_CHIPS).add(ExtraDelightItems.DARK_CHOCOLATE_CHIPS.get());
		tag(ExtraDelightTags.DARK_CHOCOLATE_TRUFFLE).add(ExtraDelightItems.DARK_CHOCOLATE_TRUFFLE.get());

		tag(ExtraDelightTags.BLOOD_CHOCOLATE_BAR).add(ExtraDelightItems.BLOOD_CHOCOLATE_BAR.get());
		tag(ExtraDelightTags.BLOOD_CHOCOLATE_BAR_FILLED).add(ExtraDelightItems.BLOOD_CHOCOLATE_FILLED_BAR.get());
		tag(ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK).add(ExtraDelightItems.BLOOD_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.BLOOD_CHOCOLATE_CHIPS).add(ExtraDelightItems.BLOOD_CHOCOLATE_CHIPS.get());
		tag(ExtraDelightTags.BLOOD_CHOCOLATE_TRUFFLE).add(ExtraDelightItems.BLOOD_CHOCOLATE_TRUFFLE.get());

		tag(ExtraDelightTags.WHITE_CHOCOLATE_BAR).add(ExtraDelightItems.WHITE_CHOCOLATE_BAR.get());
		tag(ExtraDelightTags.WHITE_CHOCOLATE_BAR_FILLED).add(ExtraDelightItems.WHITE_CHOCOLATE_FILLED_BAR.get());
		tag(ExtraDelightTags.WHITE_CHOCOLATE_BLOCK).add(ExtraDelightItems.WHITE_CHOCOLATE_BLOCK.get());
		tag(ExtraDelightTags.WHITE_CHOCOLATE_CHIPS).add(ExtraDelightItems.WHITE_CHOCOLATE_CHIPS.get());
		tag(ExtraDelightTags.WHITE_CHOCOLATE_TRUFFLE).add(ExtraDelightItems.WHITE_CHOCOLATE_TRUFFLE.get());

		tag(ExtraDelightTags.CHOCOLATE_BAR).addTag(ExtraDelightTags.WHITE_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.DARK_CHOCOLATE_BAR).addTag(ExtraDelightTags.MILK_CHOCOLATE_BAR)
				.addTag(ExtraDelightTags.BLOOD_CHOCOLATE_BAR);
		tag(ExtraDelightTags.CHOCOLATE_BAR_FILLED).addTag(ExtraDelightTags.WHITE_CHOCOLATE_BAR_FILLED)
				.addTag(ExtraDelightTags.DARK_CHOCOLATE_BAR_FILLED).addTag(ExtraDelightTags.MILK_CHOCOLATE_BAR_FILLED)
				.addTag(ExtraDelightTags.BLOOD_CHOCOLATE_BAR_FILLED);
		tag(ExtraDelightTags.CHOCOLATE_BLOCK).addTag(ExtraDelightTags.WHITE_CHOCOLATE_BLOCK)
				.addTag(ExtraDelightTags.DARK_CHOCOLATE_BLOCK).addTag(ExtraDelightTags.MILK_CHOCOLATE_BLOCK)
				.addTag(ExtraDelightTags.BLOOD_CHOCOLATE_BLOCK);
		tag(ExtraDelightTags.CHOCOLATE_CHIPS).addTag(ExtraDelightTags.WHITE_CHOCOLATE_CHIPS)
				.addTag(ExtraDelightTags.DARK_CHOCOLATE_CHIPS).addTag(ExtraDelightTags.MILK_CHOCOLATE_CHIPS)
				.addTag(ExtraDelightTags.BLOOD_CHOCOLATE_CHIPS);
		tag(ExtraDelightTags.CHOCOLATE_TRUFFLE).addTag(ExtraDelightTags.WHITE_CHOCOLATE_TRUFFLE)
				.addTag(ExtraDelightTags.DARK_CHOCOLATE_TRUFFLE).addTag(ExtraDelightTags.MILK_CHOCOLATE_TRUFFLE)
				.addTag(ExtraDelightTags.BLOOD_CHOCOLATE_TRUFFLE);

		tag(ExtraDelightTags.COCOA_SOLIDS).add(ExtraDelightItems.COCOA_SOLIDS.get());
		tag(ExtraDelightTags.ROASTED_COCOA_BEANS).add(ExtraDelightItems.ROASTED_COCOA_BEANS.get());

		tag(ExtraDelightTags.ROASTED_PEANUTS).add(ExtraDelightItems.ROASTED_PEANUTS.get());
		tag(ExtraDelightTags.PEANUTS).add(ExtraDelightItems.PEANUTS.get());

		tag(ExtraDelightTags.HAZELNUTS).add(ExtraDelightItems.HAZELNUTS.get());
		tag(ExtraDelightTags.ROASTED_HAZELNUTS).add(ExtraDelightItems.ROASTED_HAZELNUTS.get());

		tag(ExtraDelightTags.NUTS).addTag(ExtraDelightTags.HAZELNUTS).addTag(ExtraDelightTags.PEANUTS);
		tag(ExtraDelightTags.ROASTED_NUTS).addTag(ExtraDelightTags.ROASTED_HAZELNUTS)
				.addTag(ExtraDelightTags.ROASTED_PEANUTS);

		tag(ExtraDelightTags.PUFFED_RICE).add(ExtraDelightItems.CRISP_RICE.get());
		tag(ExtraDelightTags.CORN_FLAKES).add(ExtraDelightItems.CORN_FLAKES.get());
		tag(ExtraDelightTags.CHILI_POWDER).add(ExtraDelightItems.CHILI_POWDER.get());
		tag(ExtraDelightTags.TOFFEE).add(ExtraDelightItems.TOFFEE.get());
		tag(ExtraDelightTags.GUMMIES).add(ExtraDelightItems.GUMMIES.get());
		tag(ExtraDelightTags.PEANUT_BRITTLE).add(ExtraDelightItems.PEANUT_BRITTLE.get());
		tag(ExtraDelightTags.TRAIL_MIX).add(ExtraDelightItems.TRAIL_MIX.get());
		tag(ExtraDelightTags.FUDGE).add(ExtraDelightItems.FUDGE_SLICE.get());
		tag(ExtraDelightTags.NOUGAT).add(ExtraDelightItems.NOUGAT.get());
		tag(ExtraDelightTags.DRIED_CHILI).add(ExtraDelightItems.DRIED_CHILI.get());

		tag(ExtraDelightTags.CHOCOLATE_BAR_FILLING).addTag(ExtraDelightTags.NUTS).addTag(ExtraDelightTags.ROASTED_NUTS)
				.addTag(ExtraDelightTags.FRUIT).addTag(ExtraDelightTags.CHOCOLATE_CHIPS)
				.addTag(ExtraDelightTags.PUFFED_RICE).addTag(ExtraDelightTags.CORN_FLAKES)
				.addTag(ExtraDelightTags.CHILI_POWDER).addTag(ExtraDelightTags.TOFFEE).addTag(ExtraDelightTags.GUMMIES)
				.addTag(ExtraDelightTags.PEANUT_BRITTLE).addTag(ExtraDelightTags.TRAIL_MIX)
				.addTag(ExtraDelightTags.MINT).addTag(ExtraDelightTags.CANDY).addTag(ExtraDelightTags.PROCESSED_FRUIT)
				.addTag(ExtraDelightTags.DRIED_FRUIT).addTag(ExtraDelightTags.DRIED_CHILI);
		tag(ExtraDelightTags.CHOCOLATE_TRUFFLE_FILLING).addTag(ExtraDelightTags.FROSTING).addTag(ExtraDelightTags.FUDGE)
				.addTag(ExtraDelightTags.NOUGAT).addTag(ExtraDelightTags.WHIPPED_CREAM).addTag(ExtraDelightTags.JAM);

		tag(ExtraDelightTags.JAMMABLE).addTag(Tags.Items.FOODS_FRUIT).addTag(Tags.Items.FOODS_BERRY)
				.addTag(Tags.Items.CROPS_CARROT);

		tag(ExtraDelightTags.MARSHMALLOW_FLUFF).add(ExtraDelightItems.MARSHMALLOW_FLUFF_BOTTLE.get());
		tag(ExtraDelightTags.PEANUT_BUTTER).add(ExtraDelightItems.PEANUT_BUTTER_BOTTLE.get());
		tag(ExtraDelightTags.CHOCOLATE_SYRUP).add(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE.get(),
				ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE.get(),
				ExtraDelightItems.MILK_CHOCOLATE_SYRUP_BOTTLE.get(),
				ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_BOTTLE.get());
		tag(ExtraDelightTags.COOKIE).add(Items.COOKIE, ExtraDelightItems.APPLE_COOKIE.get(),
				ExtraDelightItems.GINGERBREAD_COOKIE.get(), ExtraDelightItems.GLOW_BERRY_COOKIE.get(),
				ExtraDelightItems.PUMPKIN_COOKIE.get(), ExtraDelightItems.SUGAR_COOKIE.get());
		tag(ExtraDelightTags.COFFEE_CHERRIES).add(ExtraDelightItems.COFFEE_CHERRIES.get());
		tag(ExtraDelightTags.GROUND_COFFEE_BEANS).add(ExtraDelightItems.GROUND_COFFEE.get());
		tag(ExtraDelightTags.GREEN_COFFEE).add(ExtraDelightItems.GREEN_COFFEE.get());
		tag(ExtraDelightTags.PEANUTS_IN_SHELL).add(ExtraDelightItems.PEANUTS_IN_SHELL.get());

		tag(ExtraDelightTags.TEA_INGREDIENTS).addTag(ExtraDelightTags.MINT).addTag(ExtraDelightTags.PROCESSED_GINGER)
				.add(ExtraDelightItems.CORN_SILK.get());

		tag(ExtraDelightTags.BUTTERSCOTCH).add(ExtraDelightItems.BUTTERSCOTCH.get());

		tag(ExtraDelightTags.ICE_CREAM).add(ExtraDelightItems.ICE_CREAM.get())
				.add(ExtraDelightItems.APPLE_ICE_CREAM.get()).add(ExtraDelightItems.CHOCOLATE_ICE_CREAM.get())
				.add(ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM.get()).add(ExtraDelightItems.GLOW_BERRY_ICE_CREAM.get())
				.add(ExtraDelightItems.HONEY_ICE_CREAM.get()).add(ExtraDelightItems.MINT_CHIP_ICE_CREAM.get())
				.add(ExtraDelightItems.PUMPKIN_ICE_CREAM.get()).add(ExtraDelightItems.SWEET_BERRY_ICE_CREAM.get());

		tag(ExtraDelightTags.ROASTED_COFFEE_BEANS).add(ExtraDelightItems.COFFEE_BEANS.get());
		tag(ExtraDelightTags.MALLOWROOT).add(ExtraDelightItems.MALLOW_ROOT.get());
		tag(ExtraDelightTags.MALLOWROOT_POWDER).add(ExtraDelightItems.MALLOW_POWDER.get());
		tag(ExtraDelightTags.MARSHMALLOW).add(ExtraDelightItems.MARSHMALLOW.get());
		tag(ExtraDelightTags.GRAHAM_CRACKER).add(ExtraDelightItems.GRAHAM_CRACKER.get());
		tag(ExtraDelightTags.PEPPERMINT_CANDY).add(ExtraDelightItems.MINT_CANDY_BLUE.get(),
				ExtraDelightItems.MINT_CANDY_GREEN.get(), ExtraDelightItems.MINT_CANDY_RED.get());
		tag(ExtraDelightTags.COFFEE).add(ExtraDelightItems.COFFEE.get());
		tag(ExtraDelightTags.CHILI).add(ExtraDelightItems.CHILI.get());
	}
}

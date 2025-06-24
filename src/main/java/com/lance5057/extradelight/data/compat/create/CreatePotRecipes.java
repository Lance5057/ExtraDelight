package com.lance5057.extradelight.data.compat.create;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class CreatePotRecipes extends MixingRecipeGen {

	public CreatePotRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
			String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

	GeneratedRecipe

	CHOCOLATE_CUSTARD = create(ExtraDelight.modLoc("mixing/chocolate_custard"),
			b->b.output(new ItemStack(ExtraDelightItems.CHOCOLATE_CUSTARD.get(),1))
			.require(Items.GLASS_BOTTLE)
			.require(Ingredient.of(ExtraDelightTags.COCOA_POWDER))
	.require(Ingredient.of(CommonTags.FOODS_MILK))
	.require(Ingredient.of(Tags.Items.EGGS))
	.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

	PUMPKIN_CUSTARD=create(ExtraDelight.modLoc("mixing/pumpkin_custard"),
			b->b.output(new ItemStack(ExtraDelightItems.PUMPKIN_CUSTARD.get(),1))
			.require(Items.GLASS_BOTTLE).require(Ingredient.of(ModItems.PUMPKIN_SLICE.get()))
			.require(Ingredient.of(CommonTags.FOODS_MILK))
			.require(Ingredient.of(Tags.Items.EGGS))
			.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

	HONEY_CUSTARD=create(ExtraDelight.modLoc("mixing/honey_custard"),
			b->b.output(new ItemStack(ExtraDelightItems.HONEY_CUSTARD.get(),1))
			.require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.HONEY_BOTTLE))
			.require(Ingredient.of(CommonTags.FOODS_MILK))
			.require(Ingredient.of(Tags.Items.EGGS))
			.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

	SWEET_BERRY_CUSTARD=create(ExtraDelight.modLoc("mixing/sweet_berry_custard"),
		b->b.output(new ItemStack(ExtraDelightItems.SWEET_BERRY_CUSTARD.get(),1))
		.require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.SWEET_BERRIES))
		.require(Ingredient.of(CommonTags.FOODS_MILK))
		.require(Ingredient.of(Tags.Items.EGGS))
		.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

	APPLE_CUSTARD=create(ExtraDelight.modLoc("mixing/apple_custard"),
			b->b.output(new ItemStack(ExtraDelightItems.APPLE_CUSTARD.get(),1))
			.require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE))
			.require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS))
			.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

KETCHUP=create(ExtraDelight.modLoc("mixing/ketchup_jar"),
		b->b.output(new ItemStack(ExtraDelightItems.KETCHUP.get(),1))
		.require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_TOMATO))
		.require(Ingredient.of(CommonTags.FOODS_TOMATO))
		.require(Ingredient.of(ExtraDelightTags.SWEETENER))
		.require(Ingredient.of(ExtraDelightTags.VINEGAR))),

	BBQ_SAUCE=create(ExtraDelight.modLoc("mixing/bbq_sugar"),b->b.output(new ItemStack(ExtraDelightItems.BBQ_SAUCE.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_TOMATO)).require(Ingredient.of(CommonTags.FOODS_ONION)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.VINEGAR))),

	BONE_BROTH=create(ExtraDelight.modLoc("mixing/stock"),b->b.output(new ItemStack(ModItems.BONE_BROTH.get(),1).require(Items.BOWL).require(Ingredient.of(Items.BONE)).require(Ingredient.of(ExtraDelightTags.MAKES_STOCK))),

GRAVY=create(ExtraDelight.modLoc("mixing/gravy_boat"),b->b.output(new ItemStack(ExtraDelightItems.GRAVY.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.BROTH))),

SALISBURY_STEAK_FEAST_ITEM=create(ExtraDelight.modLoc("mixing/salisbury_steak_feast"),
		b->b.output(new ItemStack(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get(),1))
		.require(Items.BOWL).require(Ingredient.of(ModItems.MINCED_BEEF.get()))
		.require(Ingredient.of(ModItems.MINCED_BEEF.get()))
				.require(Ingredient.of(ModItems.MINCED_BEEF.get()))
						.require(Ingredient.of(CommonTags.FOODS_ONION))
						.require(Ingredient.of(Tags.Items.MUSHROOMS))
						.require(Ingredient.of(ExtraDelightItems.GRAVY.get()))),

MASHED_POTATO_GRAVY_FEAST_ITEM=create(ExtraDelight.modLoc("mixing/mashed_potato_gravy_feast"),
		b->b.output(new ItemStack(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get(),1))
		.require(Items.BOWL)
		.require(Ingredient.of(Items.POTATO))
		.require(Ingredient.of(Items.POTATO))
		.require(Ingredient.of(Items.POTATO))
		.require(Ingredient.of(ExtraDelightItems.GRAVY.get()))
				.require(Ingredient.of(ExtraDelightTags.BUTTER))
				.require(Ingredient.of(CommonTags.FOODS_MILK))),

FRENCH_FRIES=create(ExtraDelight.modLoc("mixing/fries"),
		b->b.output(new ItemStack(ExtraDelightItems.FRENCH_FRIES.get(),1))
		.require(Ingredient.of(ExtraDelightItems.POTATO_STICKS.get()))
				.require(Ingredient.of(ExtraDelightTags.FRYING_OIL))),

POTATO_CHIPS=create(ExtraDelight.modLoc("mixing/chips"),b->b.output(new ItemStack(ExtraDelightItems.POTATO_CHIPS.get(),1)).require(Ingredient.of(ExtraDelightItems.SLICED_POTATO.get())).require(Ingredient.of(ExtraDelightTags.FRYING_OIL))),

CHEESE=create(ExtraDelight.modLoc("mixing/cheese_vinegar"),b->b.output(new ItemStack(ExtraDelightItems.CHEESE.get(),2)).require(Ingredient.of(Items.MILK_BUCKET)).require(Ingredient.of(ExtraDelightTags.VINEGAR))),

BEEF_STEW_FEAST=create(ExtraDelight.modLoc("mixing/beef_stew"),b->b.output(new ItemStack(ExtraDelightItems.BEEF_STEW_FEAST.get(),1)).require(Ingredient.of(Items.BEEF)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

PORK_STEW_FEAST=create(ExtraDelight.modLoc("mixing/pork_stew"),b->b.output(new ItemStack(ExtraDelightItems.PORK_STEW_FEAST.get(),1)).require(Ingredient.of(Items.PORKCHOP)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

LAMB_STEW_FEAST=create(ExtraDelight.modLoc("mixing/mutton_stew"),b->b.output(new ItemStack(ExtraDelightItems.LAMB_STEW_FEAST.get(),1)).require(Ingredient.of(Items.MUTTON)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

RABBIT_STEW_FEAST=create(ExtraDelight.modLoc("mixing/rabbit_stew"),b->b.output(new ItemStack(ExtraDelightItems.RABBIT_STEW_FEAST.get(),1)).require(Ingredient.of(Items.RABBIT)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

CHICKEN_STEW_FEAST=create(ExtraDelight.modLoc("mixing/chicken_stew"),b->b.output(new ItemStack(ExtraDelightItems.CHICKEN_STEW_FEAST.get(),1)).require(Ingredient.of(Items.CHICKEN)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

FISH_STEW_FEAST=create(ExtraDelight.modLoc("mixing/fish_stew"),b->b.output(new ItemStack(ExtraDelightItems.FISH_STEW_FEAST.get(),1)).require(Ingredient.of(CommonTags.FOODS_SAFE_RAW_FISH)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(Items.POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.FLOUR))),

STIRFRY_FEAST_ITEM=create(ExtraDelight.modLoc("mixing/stirfry_feast"),b->b.output(new ItemStack(ExtraDelightItems.STIRFRY_FEAST_ITEM.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.MEAT_RAW)).require(Ingredient.of(ExtraDelightTags.MEAT_RAW)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))),

FRIED_FISH=create(ExtraDelight.modLoc("mixing/fried_fish"),b->b.output(new ItemStack(ExtraDelightItems.FRIED_FISH.get(),1)).require(Ingredient.of(ItemTags.FISHES)).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))),

CHICKEN_FRIED_STEAK=create(ExtraDelight.modLoc("mixing/chicken_fried_steak"),b->b.output(new ItemStack(ExtraDelightItems.CHICKEN_FRIED_STEAK.get(),1)).require(Ingredient.of(Items.BEEF)).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get())).require(Ingredient.of(ExtraDelightItems.GRAVY.get()))),

PORK_TENDERLOIN=create(ExtraDelight.modLoc("mixing/pork_tenderloin"),
		b->b.output(new ItemStack(ExtraDelightItems.PORK_TENDERLOIN.get(),1))
		.require(Ingredient.of(Items.PORKCHOP))
		.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))),

FRIED_CHICKEN=create(ExtraDelight.modLoc("mixing/fried_chicken"),
		b->b.output(new ItemStack(ExtraDelightItems.FRIED_CHICKEN.get(),1))
		.require(Ingredient.of(ModItems.CHICKEN_CUTS.get()))
		.require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get()))),

CARROT_SOUP=create(ExtraDelight.modLoc("mixing/carrot_soup"),
		b->b.output(new ItemStack(ExtraDelightItems.CARROT_SOUP.get(),2)).require(Items.BOWL).require(Ingredient.of(Tags.Items.CROPS_CARROT)).require(Ingredient.of(Tags.Items.CROPS_CARROT)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.FOODS_MILK))),

FISH_SOUP=create(ExtraDelight.modLoc("mixing/fish_soup"),
		b->b.output(new ItemStack(ExtraDelightItems.FISH_SOUP.get(),2)).require(Items.BOWL).require(Ingredient.of(ItemTags.FISHES)).require(Ingredient.of(ItemTags.FISHES)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(Items.DRIED_KELP))),

POTATO_SOUP=create(ExtraDelight.modLoc("mixing/potato_soup"),
		b->b.output(new ItemStack(ExtraDelightItems.POTATO_SOUP.get(),2))
		.require(Items.BOWL).require(Ingredient.of(Tags.Items.CROPS_POTATO)).require(Ingredient.of(Tags.Items.CROPS_POTATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.FOODS_MILK))),

TOMATO_SOUP=create(ExtraDelight.modLoc("mixing/tomato_soup")
		,b->b.output(new ItemStack(ExtraDelightItems.TOMATO_SOUP.get(),2)).require(Items.BOWL).require(Ingredient.of(CommonTags.CROPS_TOMATO)).require(Ingredient.of(CommonTags.CROPS_TOMATO)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.FOODS_MILK))),

BOILED_EGG=create(ExtraDelight.modLoc("mixing/boiled_egg"),b->b.output(new ItemStack(ExtraDelightItems.BOILED_EGG.get(),1)).require(Ingredient.of(Tags.Items.EGGS))),


GLOW_BERRY_JAM=create(ExtraDelight.modLoc("mixing/glow_berry_jam"),b->b.output(new ItemStack(ExtraDelightItems.GLOW_BERRY_JAM.get(),2)).require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.GLOW_BERRIES)).require(Ingredient.of(Items.GLOW_BERRIES)).require(Ingredient.of(Items.GLOW_BERRIES)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

GOLDEN_APPLE_JAM=create(ExtraDelight.modLoc("mixing/golden_apple_jam"),b->b.output(new ItemStack(ExtraDelightItems.GOLDEN_APPLE_JAM.get(),2)).require(Items.GLASS_BOTTLE).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

JAM=create(ExtraDelight.modLoc("mixing/fruit_jam"),
		b->b.output(new ItemStack(ExtraDelightItems.JAM.get(),2))
		.require(Items.GLASS_BOTTLE)
		.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE)))
		.require(Ingredient.of(Items.GOLDEN_APPLE,Items.GLOW_BERRIES,Items.ENCHANTED_GOLDEN_APPLE))
		.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE)))
		.require(Ingredient.of(Items.GOLDEN_APPLE,Items.GLOW_BERRIES,Items.ENCHANTED_GOLDEN_APPLE))
		.require(DifferenceIngredient.of(Ingredient.of(ExtraDelightTags.JAMMABLE)))
		.require(Ingredient.of(Items.GOLDEN_APPLE,Items.GLOW_BERRIES,Items.ENCHANTED_GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

SEAWEED_PASTE=create(ExtraDelight.modLoc("mixing/seaweed_paste"),b->b.output(new ItemStack(ExtraDelightItems.SEAWEED_PASTE.get(),1)).require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(Items.DRIED_KELP))),

GLAZED_CARROT=create(ExtraDelight.modLoc("mixing/glazed_carrot"),
		b->b.output(new ItemStack(ExtraDelightItems.GLAZED_CARROT.get(),3))
		.require(Items.BOWL).require(Ingredient.of(Items.CARROT))
		.require(Ingredient.of(Items.CARROT))
		.require(Ingredient.of(Items.CARROT))
		.require(Ingredient.of(ExtraDelightItems.BUTTER.get()))
				.require(Ingredient.of(ExtraDelightTags.SWEETENER))),

APPLE_SAUCE=create(ExtraDelight.modLoc("mixing/apple_sauce"),b->b.output(new ItemStack(ExtraDelightItems.APPLE_SAUCE.get(),4).require(Items.BOWL).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

HASH_FEAST_ITEM=create(ExtraDelight.modLoc("mixing/hash"),b->b.output(new ItemStack(ExtraDelightItems.HASH_FEAST_ITEM.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get())).require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).require(Ingredient.of(ExtraDelightTags.MEAT))),

SEAWEED_CRISPS=create(ExtraDelight.modLoc("mixing/seaweed_crisps"),b->b.output(new ItemStack(ExtraDelightItems.SEAWEED_CRISPS.get(),1)).require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(Items.DRIED_KELP)).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.FRYING_OIL))),

MACARONI_CHEESE_FEAST=create(ExtraDelight.modLoc("mixing/macaroni_cheese"),b->b.output(new ItemStack(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(),1)).require(Ingredient.of(ExtraDelightItems.MACARONI.get())).require(Ingredient.of(ExtraDelightItems.MACARONI.get()).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.CHEESE)).require(Ingredient.of(ExtraDelightTags.CHEESE))),

FISH_CAKES=create(ExtraDelight.modLoc("mixing/fish_cakes"),b->b.output(new ItemStack(ExtraDelightItems.FISH_CAKES.get(),3).require(Ingredient.of(Tags.Items.FOODS_COOKED_FISH)).require(Ingredient.of(CommonTags.CROPS_ONION)).require(Ingredient.of(ExtraDelightItems.GRATED_POTATO.get()).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get())),

FRIED_MUSHROOMS=create(ExtraDelight.modLoc("mixing/fried_mushrooms"),b->b.output(new ItemStack(ExtraDelightItems.FRIED_MUSHROOMS.get(),3).require(Ingredient.of(Tags.Items.MUSHROOMS)).require(Ingredient.of(Tags.Items.MUSHROOMS)).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get())),

MUSHROOM_RISOTTO=create(ExtraDelight.modLoc("mixing/mushroom_risotto"),b->b.output(new ItemStack(ExtraDelightItems.MUSHROOM_RISOTTO.get(),2).require(Items.BOWL).require(Ingredient.of(Tags.Items.MUSHROOMS)).require(Ingredient.of(ExtraDelightTags.CHEESE)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))),

CURRY_FEAST=create(ExtraDelight.modLoc("mixing/curry"),b->b.output(new ItemStack(ExtraDelightItems.CURRY_FEAST.get(),1)).require(ExtraDelightItems.SERVING_POT).require(Ingredient.of(CommonTags.FOODS_RAW_CHICKEN)).require(Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.CROPS_ONION))),

ALFREDO_SAUCE=create(ExtraDelight.modLoc("mixing/alfredo_sauce"),b->b.output(new ItemStack(ExtraDelightItems.ALFREDO_SAUCE.get(),1)).require(Items.BOWL).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.CHEESE)).require(Ingredient.of(ExtraDelightTags.BUTTER))),

COOKED_PASTA=create(ExtraDelight.modLoc("mixing/cooked_pasta"),b->b.output(new ItemStack(ExtraDelightItems.COOKED_PASTA.get(),1)).require(Items.BOWL).require(Ingredient.of(CommonTags.FOODS_PASTA))),

CACTUS_SOUP=create(ExtraDelight.modLoc("mixing/cactus_soup"),b->b.output(new ItemStack(ExtraDelightItems.CACTUS_SOUP.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get())).require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()).require(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH))),

STUFFED_CACTUS=create(ExtraDelight.modLoc("mixing/stuffed_cactus"),b->b.output(new ItemStack(ExtraDelightItems.STUFFED_CACTUS.get(),1)).require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get())).require(Ingredient.of(ExtraDelightItems.COOKED_CACTUS.get()).require(Ingredient.of(ExtraDelightTags.CHEESE)).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get())),

// Halloween Start!

CARAMEL_SAUCE=create(ExtraDelight.modLoc("mixing/caramel_sauce"),b->b.output(new ItemStack(ExtraDelightItems.CARAMEL_SAUCE.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(CommonTags.FOODS_MILK))),

CARAMEL_CANDY=create(ExtraDelight.modLoc("mixing/caramel_candy"),b->b.output(new ItemStack(ExtraDelightItems.CARAMEL_CANDY.get(),2).require(Items.PAPER).require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get())),

CANDY_APPLE=create(ExtraDelight.modLoc("mixing/candy_apple"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.CANDY)).require(Ingredient.of(ExtraDelightTags.CANDY))),

CANDY_APPLE=create(ExtraDelight.modLoc("mixing/candy_apple_sugar"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

CARAMEL_APPLE=create(ExtraDelight.modLoc("mixing/caramel_apple"),b->b.output(new ItemStack(ExtraDelightItems.CARAMEL_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.APPLE)).require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get())),

CANDY_GOLDEN_APPLE=create(ExtraDelight.modLoc("mixing/candy_golden_apple"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightTags.CANDY)).require(Ingredient.of(ExtraDelightTags.CANDY))),

CANDY_GOLDEN_APPLE=create(ExtraDelight.modLoc("mixing/candy_golden_apple_sugar"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_GOLDEN_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

CARAMEL_GOLDEN_APPLE=create(ExtraDelight.modLoc("mixing/caramel_golden_apple"),b->b.output(new ItemStack(ExtraDelightItems.CARAMEL_GOLDEN_APPLE.get(),1)).require(Items.STICK).require(Ingredient.of(Items.GOLDEN_APPLE)).require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get())),

CORN_CHOWDER=create(ExtraDelight.modLoc("mixing/corn_chowder"),b->b.output(new ItemStack(ExtraDelightItems.CORN_CHOWDER.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get())).require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO)).require(CompoundIngredient.of(Ingredient.of(CommonTags.FOODS_COOKED_BACON)).require(Ingredient.of(CommonTags.FOODS_RAW_BACON)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.BROTH))),

CREAM_CORN=create(ExtraDelight.modLoc("mixing/cream_corn"),b->b.output(new ItemStack(ExtraDelightItems.CREAM_CORN.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get())).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.BUTTER))),

CORN_FRITTERS=create(ExtraDelight.modLoc("mixing/corn_fritters"),b->b.output(new ItemStack(ExtraDelightItems.CORN_FRITTERS.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.COOKED_CORN.get())).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightItems.EGG_MIX.get()).require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))),

COOKED_CORN=create(ExtraDelight.modLoc("mixing/corn"),b->b.output(new ItemStack(ExtraDelightItems.COOKED_CORN.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.CORN_SEEDS.get())),

STEWED_APPLES=create(ExtraDelight.modLoc("mixing/stewed_apples"),b->b.output(new ItemStack(ExtraDelightItems.STEWED_APPLES.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.SLICED_APPLE)).require(Ingredient.of(ExtraDelightTags.SLICED_APPLE)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.BUTTER))),

APPLE_FRITTERS=create(ExtraDelight.modLoc("mixing/apple_fritters"),b->b.output(new ItemStack(ExtraDelightItems.APPLE_FRITTERS.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE)).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightItems.EGG_MIX.get()).require(Ingredient.of(ExtraDelightTags.FRYING_OIL)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

CARAMEL_CUSTARD=create(ExtraDelight.modLoc("mixing/caramel_custard"),b->b.output(new ItemStack(ExtraDelightItems.CARAMEL_CUSTARD.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightItems.CARAMEL_SAUCE.get())).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

STUFFING_FEAST=create(ExtraDelight.modLoc("mixing/stuffing"),b->b.output(new ItemStack(ExtraDelightItems.STUFFING_FEAST.get(),1)).require(Ingredient.of(ExtraDelightItems.CROUTONS.get())).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(Tags.Items.EGGS))),

// Holiday

EGGNOG=create(ExtraDelight.modLoc("mixing/eggnog"),b->b.output(new ItemStack(ExtraDelightItems.EGGNOG.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ModItems.MILK_BOTTLE.get())).require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON)).require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.EGGS))),

CANDY_BLACK=create(ExtraDelight.modLoc("mixing/candy_black"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_BLACK.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_BLACK))),

CANDY_BLUE=create(ExtraDelight.modLoc("mixing/candy_blue"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_BLUE.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_BLUE))),

CANDY_BROWN=create(ExtraDelight.modLoc("mixing/candy_brown"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_BROWN.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_BROWN))),

CANDY_CYAN=create(ExtraDelight.modLoc("mixing/candy_cyan"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_CYAN.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_CYAN))),

CANDY_GRAY=create(ExtraDelight.modLoc("mixing/candy_gray"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_GRAY.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_GRAY))),

CANDY_GREEN=create(ExtraDelight.modLoc("mixing/candy_green"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_GREEN.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_GREEN))),

CANDY_LIGHT_BLUE=create(ExtraDelight.modLoc("mixing/candy_light_blue"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_LIGHT_BLUE.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_LIGHT_BLUE))),

CANDY_LIGHT_GRAY=create(ExtraDelight.modLoc("mixing/candy_light_gray"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_LIGHT_GRAY.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_LIGHT_GRAY))),

CANDY_LIME=create(ExtraDelight.modLoc("mixing/candy_lime"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_LIME.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_LIME))),

CANDY_MAGENTA=create(ExtraDelight.modLoc("mixing/candy_magenta"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_MAGENTA.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_MAGENTA))),

CANDY_ORANGE=create(ExtraDelight.modLoc("mixing/candy_orange"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_ORANGE.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_ORANGE))),

CANDY_PINK=create(ExtraDelight.modLoc("mixing/candy_pink"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_PINK.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_PINK))),

CANDY_PURPLE=create(ExtraDelight.modLoc("mixing/candy_purple"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_PURPLE.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_PURPLE))),

CANDY_RED=create(ExtraDelight.modLoc("mixing/candy_red"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_RED.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_RED))),

CANDY_WHITE=create(ExtraDelight.modLoc("mixing/candy_white"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_WHITE.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_WHITE))),

CANDY_YELLOW=create(ExtraDelight.modLoc("mixing/candy_yellow"),b->b.output(new ItemStack(ExtraDelightItems.CANDY_YELLOW.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_YELLOW))),

GINGER_BEER=create(ExtraDelight.modLoc("mixing/ginger_beer"),b->b.output(new ItemStack(ExtraDelightItems.GINGER_BEER.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightItems.YEAST.get())),

HORCHATA=create(ExtraDelight.modLoc("mixing/horchata"),b->b.output(new ItemStack(ExtraDelightItems.HORCHATA.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON)).require(Ingredient.of(CommonTags.FOODS_MILK))),

MINT_CANDY_BLUE=create(ExtraDelight.modLoc("mixing/mint_candy_blue"),b->b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_BLUE.get(),4).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_BLUE)).require(Ingredient.of(ExtraDelightTags.MINT))),

MINT_CANDY_GREEN=create(ExtraDelight.modLoc("mixing/mint_candy_green"),b->b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_GREEN.get(),4).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_GREEN)).require(Ingredient.of(ExtraDelightTags.MINT))),

MINT_CANDY_RED=create(ExtraDelight.modLoc("mixing/mint_candy_red"),b->b.output(new ItemStack(ExtraDelightItems.MINT_CANDY_RED.get(),4).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(Tags.Items.DYES_RED)).require(Ingredient.of(ExtraDelightTags.MINT)))),

CONGEE=create(ExtraDelight.modLoc("mixing/congee"),b->b.output(new ItemStack(ExtraDelightItems.CONGEE.get(),1)).require(Items.BOWL).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER))),

LUGAW=create(ExtraDelight.modLoc("mixing/lugaw"),b->b.output(new ItemStack(ExtraDelightItems.LUGAW.get(),1)).require(Items.BOWL).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightItems.BOILED_EGG.get()).require(Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN))),

RICE_PUDDING=create(ExtraDelight.modLoc("mixing/rice_pudding"),b->b.output(new ItemStack(ExtraDelightItems.RICE_PUDDING.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(CommonTags.CROPS_RICE)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.GROUND_CINNAMON))),

//	PICKLED_GINGER =create(ExtraDelight.modLoc("mixing/pickled_ginger"), b -> b.output(new ItemStack(ExtraDelightItems.PICKLED_GINGER.get(), 4).require( null)
//			.require(Ingredient.of(ExtraDelightTags.SLICED_GINGER))
//					.require(Ingredient.of(ExtraDelightTags.VINEGAR)) .require(Ingredient.of(ExtraDelightTags.SWEETENER)) },
//			 ., consumer);

CANDIED_GINGER=create(ExtraDelight.modLoc("mixing/candied_ginger"),b->b.output(new ItemStack(ExtraDelightItems.CANDIED_GINGER.get(),4).require(Items.PAPER).require(Ingredient.of(ExtraDelightTags.PROCESSED_GINGER)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

MINT_JELLY=create(ExtraDelight.modLoc("mixing/mint_jelly"),b->b.output(new ItemStack(ExtraDelightItems.MINT_JELLY.get(),2).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.MINT)).require(Ingredient.of(ExtraDelightTags.MINT)).require(Ingredient.of(ExtraDelightTags.MINT)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

XOCOLATL=create(ExtraDelight.modLoc("mixing/xocolatl"),b->b.output(new ItemStack(ExtraDelightItems.XOCOLATL.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP)).require(Ingredient.of(ExtraDelightTags.CHILI_POWDER))),

HOT_COCOA=create(ExtraDelight.modLoc("mixing/hot_cocoa"),b->b.output(new ItemStack(ModItems.HOT_COCOA.get(),1).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP))),

XOCOLATL=create(ExtraDelight.modLoc("mixing/xocolatl_beans"),b->b.output(new ItemStack(ExtraDelightItems.XOCOLATL.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.COCOA_POWDER)).require(Ingredient.of(ExtraDelightTags.CHILI_POWDER))),

PEANUT_BRITTLE=create(ExtraDelight.modLoc("mixing/peanut_brittle"),b->b.output(new ItemStack(ExtraDelightItems.PEANUT_BRITTLE.get(),4).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.ROASTED_NUTS))),

BUTTERSCOTCH=create(ExtraDelight.modLoc("mixing/butterscotch"),b->b.output(new ItemStack(ExtraDelightItems.BUTTERSCOTCH.get(),2).require(Ingredient.of(ExtraDelightTags.SWEETENER)).require(Ingredient.of(ExtraDelightTags.BUTTER))),

COFFEE=create(ExtraDelight.modLoc("mixing/coffee"),b->b.output(new ItemStack(ExtraDelightItems.COFFEE.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.GROUND_COFFEE_BEANS))),

TEA=create(ExtraDelight.modLoc("mixing/tea"),b->b.output(new ItemStack(ExtraDelightItems.TEA.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.TEA_INGREDIENTS)).require(Ingredient.of(ExtraDelightTags.TEA_INGREDIENTS)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

CRISP_RICE_TREATS_BLOCK=create(ExtraDelight.modLoc("mixing/crisp_rice_treats"),b->b.output(new ItemStack(ExtraDelightItems.CRISP_RICE_TREATS_BLOCK.get(),1)).require(Ingredient.of(ExtraDelightTags.PUFFED_RICE)).require(Ingredient.of(ExtraDelightTags.MARSHMALLOW)).require(Ingredient.of(ExtraDelightTags.BUTTER))),

SCOTCHAROO_BLOCK=create(ExtraDelight.modLoc("mixing/scotcharoos"),b->b.output(new ItemStack(ExtraDelightItems.SCOTCHAROO_BLOCK.get(),1)).require(Ingredient.of(ExtraDelightTags.PUFFED_RICE)).require(Ingredient.of(ExtraDelightTags.MARSHMALLOW)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BUTTERSCOTCH)).require(Ingredient.of(ExtraDelightTags.CHOCOLATE_SYRUP)).require(Ingredient.of(ExtraDelightTags.NUT_BUTTER))),

SOS=create(ExtraDelight.modLoc("mixing/sos"),b->b.output(new ItemStack(ExtraDelightItems.SOS.get(),1)).require(ExtraDelightItems.BREAD_SLICE.get()).require(Ingredient.of(ExtraDelightTags.SCRAP_BEEF)).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(CommonTags.FOODS_MILK))),

OXTAIL_SOUP=create(ExtraDelight.modLoc("mixing/oxtail_soup"),b->b.output(new ItemStack(ExtraDelightItems.OXTAIL_SOUP.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.OXTAIL)).require(Ingredient.of(Items.CARROT)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.PROCESSED_TOMATO))),

LIVER_ONIONS=create(ExtraDelight.modLoc("mixing/liver_onions"),b->b.output(new ItemStack(ExtraDelightItems.LIVER_ONIONS.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.LIVER)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION))),

FRIED_BRAINS=create(ExtraDelight.modLoc("mixing/fried_brains"),b->b.output(new ItemStack(ExtraDelightItems.FRIED_BRAINS.get(),1)).require(Ingredient.of(ExtraDelightTags.BRAIN)).require(Ingredient.of(ExtraDelightItems.BREADING_MISANPLAS.get())),

MULLIGATAWNY_SOUP=create(ExtraDelight.modLoc("mixing/mulligatawny_soup"),b->b.output(new ItemStack(ExtraDelightItems.MULLIGATAWNY_SOUP.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.CURRY_POWDER.get())).require(Ingredient.of(ExtraDelightTags.SLICED_APPLE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.FOODS_RAW_CHICKEN)).require(Ingredient.of(ModItems.RICE.get())),

AEBLEFLAESK=create(ExtraDelight.modLoc("mixing/aebleflaesk"),b->b.output(new ItemStack(ExtraDelightItems.AEBLEFLAESK.get(),1)).require(ExtraDelightItems.TOAST).require(Ingredient.of(ExtraDelightTags.SLICED_APPLE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ModItems.BACON.get()).require(Ingredient.of(Items.SUGAR))),

CHILI_CON_CARNE_FEAST=create(ExtraDelight.modLoc("mixing/chili_con_carne"),b->b.output(new ItemStack(ExtraDelightItems.CHILI_CON_CARNE_FEAST.get(),1)).require(Ingredient.of(ModItems.TOMATO_SAUCE.get())).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.MEAT)).require(Ingredient.of(ExtraDelightTags.CHILI_POWDER)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))),

WHITE_CHILI_FEAST=create(ExtraDelight.modLoc("mixing/white_chili"),b->b.output(new ItemStack(ExtraDelightItems.WHITE_CHILI_FEAST.get(),1)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(CommonTags.FOODS_COOKED_CHICKEN)).require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG)).require(Ingredient.of(ExtraDelightTags.PROCESSED_VEG))),

NUT_BUTTER_CUSTARD=create(ExtraDelight.modLoc("mixing/nut_butter_custard"),b->b.output(new ItemStack(ExtraDelightItems.NUT_BUTTER_CUSTARD.get(),1)).require(Items.GLASS_BOTTLE).require(Ingredient.of(ExtraDelightTags.NUT_BUTTER)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(Tags.Items.EGGS)).require(Ingredient.of(ExtraDelightTags.SWEETENER))),

HAZELNUT_SOUP=create(ExtraDelight.modLoc("mixing/hazelnut_soup"),b->b.output(new ItemStack(ExtraDelightItems.HAZELNUT_SOUP.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.ROASTED_HAZELNUTS)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(CommonTags.FOODS_COOKED_BACON))),

ONION_SOUP=create(ExtraDelight.modLoc("mixing/onion_soup"),b->b.output(new ItemStack(ExtraDelightItems.ONION_SOUP.get(),3).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.BUTTER)).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.BREAD_SLICE)).require(Ingredient.of(ExtraDelightTags.CHEESE))),

ONION_BHAJI=create(ExtraDelight.modLoc("mixing/onion_bhaji"),b->b.output(new ItemStack(ExtraDelightItems.ONION_BHAJI.get(),2).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.FLOUR)).require(Ingredient.of(ExtraDelightItems.CURRY_POWDER)).require(Ingredient.of(ExtraDelightTags.COOKING_OIL))),

PAMONHA=create(ExtraDelight.modLoc("mixing/pamonha"),b->b.output(new ItemStack(ExtraDelightItems.PAMONHA.get(),2).require(Ingredient.of(ExtraDelightTags.CORN_KERNELS)).require(Ingredient.of(ExtraDelightTags.CORN_KERNELS)).require(Ingredient.of(CommonTags.FOODS_MILK)).require(Ingredient.of(ExtraDelightItems.CORN_HUSK))),

BORSCHT=create(ExtraDelight.modLoc("mixing/borscht"),b->b.output(new ItemStack(ExtraDelightItems.BORSCHT.get(),4).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.PROCESSED_BEETROOT)).require(Ingredient.of(ExtraDelightTags.PROCESSED_CARROT)).require(Ingredient.of(ExtraDelightTags.PROCESSED_CABBAGE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_POTATO)).require(Ingredient.of(ExtraDelightItems.SLICED_TOMATO,ModItems.TOMATO_SAUCE.get(),ModItems.TOMATO.get()))),

DEVILLED_SAUSAGES=create(ExtraDelight.modLoc("mixing/devilled_sausages"),b->b.output(new ItemStack(ExtraDelightItems.DEVILLED_SAUSAGES.get(),2).require(Items.BOWL).require(Ingredient.of(ExtraDelightTags.BROTH)).require(Ingredient.of(ExtraDelightTags.PROCESSED_ONION)).require(Ingredient.of(ExtraDelightTags.SAUSAGE_RAW)).require(Ingredient.of(ExtraDelightTags.PROCESSED_APPLE)).require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC))),

AGLIO_E_OLIO=create(ExtraDelight.modLoc("mixing/aglio_e_olio"),b->b.output(new ItemStack(ExtraDelightItems.AGLIO_E_OLIO.get(),1)).require(Items.BOWL).require(Ingredient.of(ModItems.RAW_PASTA.get())).require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC)).require(Ingredient.of(ExtraDelightTags.COOKING_OIL)).require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI)).require(Ingredient.of(ExtraDelightTags.CHEESE))),

PENNE_ALL_ARRABIATA=create(ExtraDelight.modLoc("mixing/penne_all_arrabbiata"),b->b.output(new ItemStack(ExtraDelightItems.PENNE_ALL_ARRABIATA.get(),1)).require(Items.BOWL).require(Ingredient.of(ExtraDelightItems.PENNE.get())).require(Ingredient.of(ExtraDelightTags.PROCESSED_GARLIC)).require(Ingredient.of(ModItems.TOMATO_SAUCE.get()).require(Ingredient.of(ExtraDelightTags.PROCESSED_CHILI)).require(Ingredient.of(ExtraDelightTags.COOKING_OIL));
}

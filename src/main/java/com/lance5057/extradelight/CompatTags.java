package com.lance5057.extradelight;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CompatTags {

	public static TagKey<Item> neoforgeItemTag(String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
	}
	public static TagKey<Item> otherModItemTag(String othermod, String tag) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath(othermod, tag));
	}

	// Tags for other mod compat
	// Make items stand up on Create belts
	public static final TagKey<Item> UPRIGHT_ON_BELT = otherModItemTag("create", "upright_on_belt");

	// Foods
	// Flour
	public static final TagKey<Item> FLOURS_WHEAT = neoforgeItemTag("flours/wheat"); // For Create
	// Dough
	public static final TagKey<Item> DOUGHS = neoforgeItemTag("doughs"); // For Create & Croptopia
	// Cheese
	public static final TagKey<Item> FOODS_CHEESE = neoforgeItemTag("foods/cheese"); // For Expanded Delight
	public static final TagKey<Item> CHEESES = neoforgeItemTag("cheeses"); // For Croptopia
	public static final TagKey<Item> CHEESE_WEDGE = otherModItemTag("brewinandchewin", "foods/cheese_wedge");
	// Sliced Bread
	public static final TagKey<Item> BREAD_SLICES = neoforgeItemTag("bread_slices"); // For More Delight
	// Chili
	public static final TagKey<Item> CHILI_PEPPER = neoforgeItemTag("crops/chili_pepper"); // For Expanded Delight
	public static final TagKey<Item> CHILIPEPPER = neoforgeItemTag("crops/chili_pepper"); // For PHC
	public static final TagKey<Item> CHILE_PEPPER = neoforgeItemTag("crops/chile_pepper"); // For Croptopia
	// Cornmeal
	public static final TagKey<Item> CORNMEAL = neoforgeItemTag("cornmeal"); // For PHC
	// Ground Cinnamon
	public static final TagKey<Item> DUSTS_CINNAMON = neoforgeItemTag("dusts/cinnamon"); // For Expanded Delight
	public static final TagKey<Item> GROUNDCINNAMON = neoforgeItemTag("groundcinnamon"); // For PHC
	// Coffee
	public static final TagKey<Item> CROPS_COFFEEBEAN = neoforgeItemTag("crops/coffeebean"); // For PHC
	public static final TagKey<Item> CROPS_COFFEE_BEANS = neoforgeItemTag("crops/coffee_beans"); // For Croptopia
	// Cooking Oil
	public static final TagKey<Item> OLIVE_OILS = neoforgeItemTag("olive_oils"); // For Croptopia
	public static final TagKey<Item> COOKINGOIL = neoforgeItemTag("cookingoil"); // For PHC
	public static final TagKey<Item> FRYINGOIL = neoforgeItemTag("cookingoil/cookingoil"); // For PHC
	// Salt
	public static final TagKey<Item> DUSTS_SALT = neoforgeItemTag("dusts/salt"); // For Expanded Delight
	// Mayo
	public static final TagKey<Item> MAYONAISE = neoforgeItemTag("condiments/mayonaise"); // For PHC
	// BBQ Sauce
	public static final TagKey<Item> BBQSAUCE = neoforgeItemTag("condiments/bbqsauce"); // For PHC
	// Raw Meat
	public static final TagKey<Item> RAWMEATS = neoforgeItemTag("rawmeats"); // For PHC
	// Raw Ground Beef
	public static final TagKey<Item> GROUNDBEEF = neoforgeItemTag("groundmeats/groundbeef"); // For PHC
	// Raw Ground Pork
	public static final TagKey<Item> GROUNDPORK = neoforgeItemTag("groundmeats/groundpork"); // For PHC
	// Raw Ground Mutton
	public static final TagKey<Item> GROUNDMUTTON = neoforgeItemTag("groundmeats/groundmutton"); // For PHC
	// Raw Ground Rabbit
	public static final TagKey<Item> GROUNDRABBIT = neoforgeItemTag("groundmeats/groundrabbit"); // For PHC
	// Stock
	public static final TagKey<Item> STOCK = neoforgeItemTag("stock"); // For PHC
	// Popcorn
	public static final TagKey<Item> FOODS_POPCORN = neoforgeItemTag("foods/popcorn"); // For Corn Delight & Cultural Delights
	// Jam/Jelly
	public static final TagKey<Item> JELLIES = neoforgeItemTag("jellies"); // For PHC
	// Nut Butters
	public static final TagKey<Item> NUTBUTTERS = neoforgeItemTag("nutbutters"); // For PHC
	// Soy Sauce
	public static final TagKey<Item> SOYSAUCE = neoforgeItemTag("condiments/soysauce"); // For PHC
	public static final TagKey<Item> SOY_SAUCES = neoforgeItemTag("soy_sauces"); // For Croptopia
	// Hot Sauce
	public static final TagKey<Item> HOTSAUCE = neoforgeItemTag("condiments/hotsauce"); // For PHC
	// Soy Milk
	public static final TagKey<Item> SOYMILK = neoforgeItemTag("milk/soymilk"); // For PHC
	public static final TagKey<Item> SOY_MILKS = neoforgeItemTag("soy_milks");
	// Processed Cucumber
	public static final TagKey<Item> CUCUMBERS = otherModItemTag("culturaldelights", "cucumbers"); // contains sliced as well
}

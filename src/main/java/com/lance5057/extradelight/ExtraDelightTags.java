package com.lance5057.extradelight;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ExtraDelightTags {
	public static final TagKey<Item> PESTLES = ItemTags.create(new ResourceLocation("forge", "pestles"));
	public static final TagKey<Item> SPOONS = ItemTags.create(new ResourceLocation("forge", "spoons"));
	
	public static final TagKey<Item> MAKES_STOCK = ItemTags.create(new ResourceLocation("extradelight", "makes_stock"));
	public static final TagKey<Item> STOCK = ItemTags.create(new ResourceLocation("extradelight", "stock"));
	public static final TagKey<Item> FRYING_OIL = ItemTags.create(new ResourceLocation("extradelight", "frying_oil"));
	
	
}

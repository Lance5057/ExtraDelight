package com.lance5057.extradelight.util.registration;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelightNeoForgeClientEvents;
import com.lance5057.extradelight.ExtraDelightRegistration;
import com.lance5057.extradelight.data.advancement.EDAdvancementGenerator;
import com.lance5057.extradelight.fluids.FluidRegistration;

import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredItem;

public abstract class SimpleRegistration {
	public String name;

	public transient List<TagKey<Item>> itemTag = new ArrayList<TagKey<Item>>();
	public transient List<TagKey<Block>> blockTag = new ArrayList<TagKey<Block>>();

//	public static List<Drink> drinks = new ArrayList<Drink>();

//	public static List<DeferredItem<Item>> hotFood = new ArrayList<DeferredItem<Item>>();
//	public static List<DeferredItem<Item>> coldFood = new ArrayList<DeferredItem<Item>>();

	public SimpleRegistration(String name) {
		this.name = name;
	}

//	public abstract void registerItems();
//
//	public abstract void registerBlocks();
//
//	public abstract void registerFluids();

	public void setupItemTag(ResourceLocation rc) {
		this.itemTag.add(ItemTags.create(rc));
	}

	public void setupItemTag(TagKey<Item> tag) {
		this.itemTag.add(tag);
	}

	public void setupBlockTag(ResourceLocation rc) {
		this.blockTag.add(BlockTags.create(rc));
	}

	public void setupBlockTag(TagKey<Block> tag) {
		this.blockTag.add(tag);
	}

	public abstract void tab(Output output);

	public abstract void itemTag(ItemTagsProvider itp);
//	{
//			for (TagKey<Item> tag : itemTag)
//				itp.tag(tag).addOptional(BLOCK_ITEM.getId());
//	}

	public abstract void blockTag(BlockTagsProvider btp);
//	{
//			for (TagKey<Block> tag : blockTag)
//				btp.tag(tag).addOptional(BLOCK.getId());
//	}

	public SimpleRegistration advancementSnack(DeferredItem<Item> item) {
		EDAdvancementGenerator.SNACKS.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementFeast(DeferredItem<Item> item) {
		EDAdvancementGenerator.FEASTS.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementMeal(DeferredItem<Item> item) {
		EDAdvancementGenerator.MEALS.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementDessert(DeferredItem<Item> item) {
		EDAdvancementGenerator.DESSERTS.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementCandy(DeferredItem<Item> item) {
		EDAdvancementGenerator.CANDY.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementCookie(DeferredItem<Item> item) {
		EDAdvancementGenerator.COOKIES.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementButchercraft(DeferredItem<Item> item) {
		EDAdvancementGenerator.BUTCHERCRAFT.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration advancementIngredients(DeferredItem<Item> item) {
		EDAdvancementGenerator.INGREDIENTS.put(item.getRegisteredName(), item);
		return this;
	}

	public SimpleRegistration butchercraftToolTip(DeferredItem<Item> item) {
		ExtraDelightNeoForgeClientEvents.butchercraft.add(item);
		return this;
	}

	public SimpleRegistration feastToolTip(DeferredItem<Item> item) {
		ExtraDelightNeoForgeClientEvents.feasts.add(item);
		return this;
	}

	public SimpleRegistration servingToolTip(DeferredItem<Item> item) {
		ExtraDelightNeoForgeClientEvents.servings.add(item);
		return this;
	}

	public SimpleRegistration isHotFood(DeferredItem<Item> item) {
//		SimpleItemRegistration.hotFood.add(item);
		return this;
	}

	public SimpleRegistration isColdFood(DeferredItem<Item> item) {
//		SimpleItemRegistration.coldFood.add(item);
		return this;
	}

	public SimpleRegistration finish() {
		ExtraDelightRegistration.registry.add(this);
		return this;
	}

	public Item.Properties foodItem(FoodProperties food) {
		return (new Item.Properties()).food(food).stacksTo(16);
	}

	public Item.Properties bowlFoodItem(FoodProperties food) {
		return (new Item.Properties()).food(food).craftRemainder(Items.BOWL).stacksTo(16);
	}

	public Item.Properties bottleFoodItem(FoodProperties food) {
		return (new Item.Properties()).food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
	}

	public Item.Properties stack1Item() {
		return new Item.Properties().stacksTo(1);
	}

	public BucketItem stack1bucketItem(FluidRegistration fluid) {
		return new BucketItem(fluid.FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
	}

	public static Item.Properties drinkItem() {
		return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
	}
}

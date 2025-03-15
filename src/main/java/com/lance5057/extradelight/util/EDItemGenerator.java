package com.lance5057.extradelight.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightNeoForgeClientEvents;
import com.lance5057.extradelight.data.advancement.EDAdvancementGenerator;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class EDItemGenerator {
	public static List<Drink> drinks = new ArrayList<Drink>();

	public static List<DeferredItem<Item>> hotFood = new ArrayList<DeferredItem<Item>>();
	public static List<DeferredItem<Item>> coldFood = new ArrayList<DeferredItem<Item>>();
	DeferredItem<Item> item;

	private EDItemGenerator(DeferredItem<Item> item) {
		this.item = item;
	}

	public static <I extends Item> EDItemGenerator register(String registrationName, Supplier<? extends I> item) {
		return new EDItemGenerator(ExtraDelightItems.ITEMS.register(registrationName, item));
	}

	public EDItemGenerator advancementSnack() {
		EDAdvancementGenerator.SNACKS.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementFeast() {
		EDAdvancementGenerator.FEASTS.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementMeal() {
		EDAdvancementGenerator.MEALS.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementDessert() {
		EDAdvancementGenerator.DESSERTS.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementCandy() {
		EDAdvancementGenerator.CANDY.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementCookie() {
		EDAdvancementGenerator.COOKIES.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementButchercraft() {
		EDAdvancementGenerator.BUTCHERCRAFT.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator advancementIngredients() {
		EDAdvancementGenerator.INGREDIENTS.put(item.getRegisteredName(), item);
		return this;
	}

	public EDItemGenerator butchercraftToolTip() {
		ExtraDelightNeoForgeClientEvents.butchercraft.add(item);
		return this;
	}

	public EDItemGenerator feastToolTip() {
		ExtraDelightNeoForgeClientEvents.feasts.add(item);
		return this;
	}

	public EDItemGenerator servingToolTip() {
		ExtraDelightNeoForgeClientEvents.servings.add(item);
		return this;
	}

	public EDItemGenerator isHotFood() {
		EDItemGenerator.hotFood.add(item);
		return this;
	}

	public EDItemGenerator isColdFood() {
		EDItemGenerator.coldFood.add(item);
		return this;
	}

	public DeferredItem<Item> finish() {
		return item;
	}

	public Drink drink() {
		EDAdvancementGenerator.DRINKS.put(item.getRegisteredName(), item);
		return new Drink(item);
	}

	public class Drink {
		public DeferredItem<Item> item;
		public int thirst;
		public int hydration;
		public int poison;
		public boolean isHot;

		public Drink(DeferredItem<Item> item2) {
			this.item = item2;
		}

		public Drink setThirst(int t) {
			thirst = t;
			return this;
		}

		public Drink setHydration(int h) {
			hydration = h;
			return this;
		}

		public Drink setPoison(int p) {
			poison = p;
			return this;
		}

		public Drink isHot(boolean hot) {
			isHot = hot;
			return this;
		}

		public DeferredItem<Item> finish() {
			EDItemGenerator.drinks.add(this);
			return item;
		}
	}

}

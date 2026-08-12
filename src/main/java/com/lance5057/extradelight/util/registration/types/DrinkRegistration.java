package com.lance5057.extradelight.util.registration.types;

import java.util.function.Supplier;

import com.lance5057.extradelight.data.advancement.EDAdvancementGenerator;

import net.minecraft.world.item.Item;

public class DrinkRegistration extends ItemRegistration {
	public int thirst;
	public int hydration;
	public int poison;
	public boolean isHot;
	public boolean isCold;

	public DrinkRegistration(String name, Supplier<? extends Item> sup) {
		super(name, sup);

		EDAdvancementGenerator.DRINKS.put(ITEM.getRegisteredName(), ITEM);
	}

	public DrinkRegistration setThirst(int t) {
		thirst = t;
		return this;
	}

	public DrinkRegistration setHydration(int h) {
		hydration = h;
		return this;
	}

	public DrinkRegistration setPoison(int p) {
		poison = p;
		return this;
	}

	public DrinkRegistration isHot(boolean hot) {
		isHot = hot;
		return this;
	}

	public DrinkRegistration isCold(boolean cold) {
		isCold = cold;
		return this;
	}

	public DrinkRegistration finish() {
//		SimpleItemRegistration.drinks.add(this);
		return this;
	}
}

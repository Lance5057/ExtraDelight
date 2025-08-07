package com.lance5057.extradelight.integration.jei.interpreters;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.items.dynamicfood.api.DynamicItemComponent;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.world.item.ItemStack;

public class DynamicItemInterpreter implements ISubtypeInterpreter<ItemStack> {
	public static final DynamicItemInterpreter INSTANCE = new DynamicItemInterpreter();
	@Override
	public @Nullable Object getSubtypeData(ItemStack ingredient, UidContext context) {
		DynamicItemComponent d = ingredient.get(ExtraDelightComponents.DYNAMIC_FOOD);
		if (d == null)
			return null;
		return d.graphics().getFirst();
	}

	@Override
	public String getLegacyStringSubtypeInfo(ItemStack ingredient, UidContext context) {
		DynamicItemComponent d = ingredient.get(ExtraDelightComponents.DYNAMIC_FOOD);
		if (d == null)
			return null;
		return d.graphics().getFirst();
	}

}

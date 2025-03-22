package com.lance5057.extradelight.items;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class GarlicCureDrinkableItem extends DrinkableItem {

	public GarlicCureDrinkableItem(Properties properties) {
		super(properties);
	}

	public GarlicCureDrinkableItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip);
	}

	public GarlicCureDrinkableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
	}

	@NotNull
	@Override
	public ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn,
			@NotNull LivingEntity entityLiving) {
		if (!worldIn.isClientSide) {
			if (ModList.get().isLoaded("vampirism"))
				entityLiving.removeEffectsCuredBy(ExtraDelightItems.GARLIC_CURE);
		}
		return super.finishUsingItem(stack, worldIn, entityLiving);
	}
}

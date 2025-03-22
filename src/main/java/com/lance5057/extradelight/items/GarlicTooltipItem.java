package com.lance5057.extradelight.items;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;

public class GarlicTooltipItem extends ToolTipConsumableItem {

	public GarlicTooltipItem(Properties properties) {
		super(properties);
	}

	public GarlicTooltipItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip);
	}

	public GarlicTooltipItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
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

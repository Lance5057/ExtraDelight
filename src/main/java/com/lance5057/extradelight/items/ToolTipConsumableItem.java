package com.lance5057.extradelight.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class ToolTipConsumableItem extends Item {

	private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

	public ToolTipConsumableItem(Properties properties) {
		super(properties);
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = false;
	}

	public ToolTipConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = false;
	}

	public ToolTipConsumableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = hasCustomTooltip;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip,
			TooltipFlag isAdvanced) {
		if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
			if (this.hasCustomTooltip) {
				MutableComponent textEmpty = TextUtils
						.getTranslation("tooltip." + BuiltInRegistries.ITEM.getKey(this).getPath());
				tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
			}
			if (this.hasFoodEffectTooltip) {
				TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
			}
		}
	}
}

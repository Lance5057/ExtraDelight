package com.lance5057.extradelight.items;

import java.util.List;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CactusJuiceItem extends DrinkableItem {
	public CactusJuiceItem(Properties properties) {
		super(properties, false, true);
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		consumer.heal(2.0F);

		if (consumer.isOnFire())
			consumer.setRemainingFireTicks(0);

		int r = level.random.nextInt(10);

		switch (r) {
		case 0:
			consumer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));
		case 1:
			consumer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100));
		case 2:
			consumer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100));
		case 3:
			consumer.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100));
		case 4:
			consumer.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
		default:
			break;
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		tooltipComponents.add(
				Component.literal("").append(Component.translatable(ExtraDelight.MOD_ID + ".cactus_juice.hovertext"))
						.withStyle(ChatFormatting.GREEN));
	}
}
package com.lance5057.extradelight.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GlowberryFoodItem extends Item {

	public GlowberryFoodItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

		pLivingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100));

		return super.finishUsingItem(pStack, pLevel, pLivingEntity);
	}
}

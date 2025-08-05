package com.lance5057.extradelight.items;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public abstract class DeprecatedItem extends Item {
	public DeprecatedItem() {
		super(new Properties());
	}

	@NotNull
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		return InteractionResultHolder.success(changeToStack(player.getItemInHand(usedHand)));
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		MutableComponent textEmpty = Component.translatable(ExtraDelight.MOD_ID + ".tooltip.deprecated");
		tooltipComponents.add(textEmpty.withStyle(ChatFormatting.RED));
	}

	public abstract ItemStack changeToStack(ItemStack itemStack);

}

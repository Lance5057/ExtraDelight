package com.lance5057.extradelight.items.jar;

import java.util.List;
import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.blocks.jar.JarBlock;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.fluids.SimpleFluidContent;

public class JarItem extends BlockItem {

	public JarItem(JarBlock jarBlock, Properties p_41383_) {
		super(jarBlock, p_41383_);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		SimpleFluidContent f = stack.getComponents().get(ExtraDelightComponents.FLUID.get());

		if (f != null && !f.isEmpty()) {
			ResourceLocation r = BuiltInRegistries.FLUID.getKey(f.getFluid());
			tooltipComponents.add(Component.literal("Contains: " + f.getAmount() + "mb - ")
					.append(Component.translatable(f.getFluidType().getDescriptionId()))
					.withStyle(ChatFormatting.WHITE));
		}
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return JarItemModel.getInstance();
			}
		});
	}
}

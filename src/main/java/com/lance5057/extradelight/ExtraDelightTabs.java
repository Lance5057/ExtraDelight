package com.lance5057.extradelight;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightTabs {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
			ExtraDelight.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("tab",
			() -> CreativeModeTab.builder().title(Component.translatable("itemGroup.extradelight.tab"))
					.icon(() -> new ItemStack(ExtraDelightItems.WOODEN_SPOON.get()))
					.displayItems((parameters, output) -> {
						for(DeferredHolder<Item, ? extends Item> i : ExtraDelightItems.ITEMS.getEntries())
							output.accept(i.get());
						for(DeferredHolder<Item, ? extends Item> i : AestheticBlocks.ITEMS.getEntries())
							output.accept(i.get());
					}).build());
}

package com.lance5057.extradelight.items.dynamicfood.api;

import java.util.Collection;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public interface IDynamic {
	Collection<ResourceLocation> getPieces(ItemStack itemStack);
}

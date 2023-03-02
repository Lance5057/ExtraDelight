package com.lance5057.extradelight.items;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IDynamicNamedFood {
	public String getDynamicName(Player p, Level l, ItemStack i, String base, Container c);
}

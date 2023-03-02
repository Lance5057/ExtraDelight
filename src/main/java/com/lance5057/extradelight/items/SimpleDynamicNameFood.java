package com.lance5057.extradelight.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SimpleDynamicNameFood extends Item implements IDynamicNamedFood {

	final Item ignore;

	public SimpleDynamicNameFood(Item ignore, Properties pProperties) {

		super(pProperties);
		this.ignore = ignore;
	}

	@Override
	public String getDynamicName(Player p, Level l, ItemStack i, String base, Container c) {

		String s = "";
		List<String> items = new ArrayList<String>();
		if (l.isClientSide()) {
			for (int j = 0; j < c.getContainerSize() - 1; j++) {
				if (c.getItem(j) != ItemStack.EMPTY) {
					if (c.getItem(j).getItem() != ignore)
						items.add(c.getItem(j).getDescriptionId());
				}
			}

			for (int k = 0; k < items.size() - 1; k++) {
				s += I18n.get(items.get(k)) + " ";
			}
			s += "and " + I18n.get(items.get(items.size() - 1)) + " ";
			s += I18n.get(i.getItem().getDescriptionId());
		}
		return s;
	}

}
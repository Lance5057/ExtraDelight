package com.lance5057.extradelight.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimpleDynamicNameFood extends Item implements IDynamicNamedFood {

	final Item ignore;

	public SimpleDynamicNameFood(Item ignore, Properties pProperties) {

		super(pProperties);
		this.ignore = ignore;
	}

	@Override
	public Component getName(ItemStack pStack) {
		return getDynamicName(pStack);
	}

	@Override
	public MutableComponent getDynamicName(ItemStack stack) {
		StringBuilder sb = new StringBuilder();
		String[] items = IDynamicNamedFood.readNBTIngredientList(stack, ignore);
		List<String> trans = new ArrayList<String>();

		if (items.length <= 0)
			return Component.translatable(this.getDescriptionId());

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (items[i] != ignore.getDescriptionId())
					trans.add(Component.translatable(items[i]).getString());
			}
		}

		trans.add(Component.translatable(this.getDescriptionId()).getString());

		sb.append(Component.translatable("extradelight.dynamicname." + items.length, trans.toArray()).getString());

//		for (int i = 0; i < items.length; i++) {
//			if (items[i] != ignore.getDescriptionId()) {
//				sb.append(Component.translatable(items[i]).getString());
//				sb.append(" ");
//			}
//		}
//		// if (l.isClientSide()) {
//		for (int j = 0; j < c.getContainerSize() - 1; j++) {
//			if (c.getItem(j) != ItemStack.EMPTY) {
//				if (c.getItem(j).getItem() != ignore)
//					items.add(c.getItem(j).getDescriptionId());
//			}
//		}
//
//		for (int k = 0; k < items.size() - 1; k++) {
//			s += new TranslatableContents(items.get(k)).toString();
//			// s += I18n.get(items.get(k)) + " ";
//		}
//		s += "and " + new TranslatableContents(items.get(items.size() - 1)) + " ";
//		s += new TranslatableContents(i.getItem().getDescriptionId());
//		// }

		// sb.append(Component.translatable(this.getDescriptionId()).getString());

		return Component.literal(sb.toString());
	}

}
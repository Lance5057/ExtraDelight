package com.lance5057.extradelight.items.dynamicfood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.items.dynamicfood.api.IDynamic;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;

public class DynamicToast extends Item implements IDynamic {
	static final ResourceLocation base_model = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"extra/dynamics/toast/toast");
	static final ResourceLocation missing_model = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"extra/dynamics/toast/empty_toast");

	public DynamicToast(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<ResourceLocation> getPieces(ItemStack itemStack) {
		List<ResourceLocation> i = new ArrayList<ResourceLocation>();

		i.add(base_model);

		ItemContainerContents comp = itemStack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());
		if (comp != null) {
			{
				if (comp.getSlots() > 1) {
					ItemStack s = comp.getStackInSlot(1);
					String str = s.getItem().getDescriptionId();
					str = str.substring(str.lastIndexOf('.') + 1);
					ResourceLocation rc = ExtraDelight.modLoc("extra/dynamics/toast/" + str);
					i.add(rc);
				} else
					i.add(missing_model);
			}
		} else
			i.add(missing_model);

//		i.add(bm);
		return i;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip,
			TooltipFlag isAdvanced) {
		ItemContainerContents comp = stack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());

		if (comp != null) {
			{
				if (comp.nonEmptyItems() != null) {
					tooltip.add(Component.translatable("tooltip.dynamic.ingredients"));
					for (ItemStack s : comp.nonEmptyItems()) {
						tooltip.add(Component.literal(" - ").append(Component.translatable(s.getDescriptionId())));
						if (isAdvanced.hasShiftDown()) {
							s.getItem().appendHoverText(stack, context, tooltip, isAdvanced);
						}
					}
					if (!isAdvanced.hasShiftDown())
						tooltip.add(Component.translatable("tooltip.see_more").withColor(0xFF555555));
				}
			}
		}
	}

	@Override
	public Component getName(ItemStack itemStack) {
		ItemContainerContents comp = itemStack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());
		if (comp != null) {
			if (comp.getSlots() > 1)
				return Component.translationArg(Component.translatable(this.getDescriptionId(itemStack),
						Component.translatable(comp.getStackInSlot(1).getDescriptionId())));
		}

		return Component.translatable("dynamic.toast");
	}

}

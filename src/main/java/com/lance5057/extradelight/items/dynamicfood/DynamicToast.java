package com.lance5057.extradelight.items.dynamicfood;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.items.dynamicfood.api.DynamicItemComponent;
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
	}

	@Override
	public List<ResourceLocation> getPieces(ItemStack itemStack) {

		List<ResourceLocation> i = new ArrayList<ResourceLocation>();

		i.add(base_model);

		DynamicItemComponent comp = itemStack.getComponents().get(ExtraDelightComponents.DYNAMIC_FOOD.get());
		ItemContainerContents items = itemStack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());
		if (comp != null && items != null) {
			{
				if (comp.graphics().size() > 0) {
					ResourceLocation rc = missing_model;
					String str = "extra/dynamics/toast/";

					for (ItemStack s : items.nonEmptyItems()) {
//					ItemStack s = items.getStackInSlot(1);
						if (!s.is(ExtraDelightTags.TOAST)) {
							if (s.getItem() instanceof IDynamic id) {
								DynamicItemComponent dyn = s.get(ExtraDelightComponents.DYNAMIC_FOOD.get());
								rc = ExtraDelight.modLoc(str + "dynamic_jam/" + dyn.graphics().get(0));
							} else
								rc = ExtraDelight.modLoc(str + comp.graphics().get(0));

							i.add(rc);
						}
					}
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
						tooltip.add(Component.literal(" - ").append(s.getItem().getName(s)));
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
						comp.getStackInSlot(1).getItem().getName(comp.getStackInSlot(1))));
		}

		return Component.translatable("dynamic.toast");
	}

}

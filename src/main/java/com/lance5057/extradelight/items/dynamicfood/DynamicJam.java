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

public class DynamicJam extends Item implements IDynamic {
	public static final ResourceLocation base_model = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"extra/dynamics/jam/jam_jar");
	public static final ResourceLocation missing_model = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"extra/dynamics/jam/jam_missing");

	public DynamicJam(Properties properties) {
		super(properties);
	}

	@Override
	public List<ResourceLocation> getPieces(ItemStack itemStack) {
		List<ResourceLocation> i = new ArrayList<ResourceLocation>();

		i.add(base_model);

		DynamicItemComponent comp = itemStack.getComponents().get(ExtraDelightComponents.DYNAMIC_FOOD.get());
		if (comp != null) {
			{
				if (comp.graphics().size() > 0) {
					ResourceLocation rc = ExtraDelight.modLoc("extra/dynamics/jam/" + comp.graphics().get(0));

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
//						if (isAdvanced.hasShiftDown()) {
//							if (!(s.getItem() instanceof DynamicJam))
//								s.getItem().appendHoverText(stack, context, tooltip, isAdvanced);
//						}
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
		DynamicItemComponent dyn = itemStack.getComponents().get(ExtraDelightComponents.DYNAMIC_FOOD.get());

		if (comp != null) {
			if (comp.getSlots() > 0) {
				if (comp.getStackInSlot(0).is(ExtraDelightTags.IS_MARMALADE_INGREDIENT))
					return Component.translationArg(Component.translatable(this.getDescriptionId(itemStack),
							Component.translatable("extradelight.jam." + dyn.graphics().get(0)),
							Component.translatable("extradelight.marmalade")));
				else
					return Component.translationArg(Component.translatable(this.getDescriptionId(itemStack),
							Component.translatable("extradelight.jam."
									+ dyn.graphics().get(0)), Component.translatable("extradelight.jam")));
			}
		}

		return Component.translatable("dynamic.jam");
	}

}

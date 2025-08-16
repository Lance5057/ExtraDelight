package com.lance5057.extradelight.items.dynamicfood;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.items.dynamicfood.api.DynamicItemComponent;
import com.lance5057.extradelight.items.dynamicfood.api.IDynamic;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

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
				if (isAdvanced.hasShiftDown()) {
					if (comp.nonEmptyItems() != null) {
						tooltip.add(Component.translatable("tooltip.dynamic.ingredients"));
						for (ItemStack s : comp.nonEmptyItems()) {
							tooltip.add(Component.literal(" - ").append(Component.translatable(s.getDescriptionId())));
						}
					}
				} else {
					tooltip.add(Component.translatable("tooltip.see_more").withColor(0xFFAAAAAA));
				}
			}
		}
	}

	@Override
	public Component getName(ItemStack itemStack) {
		DynamicItemComponent dyn = itemStack.getComponents().get(ExtraDelightComponents.DYNAMIC_FOOD.get());

		if (dyn != null) {
			return Component.translatable("extradelight.jam." + dyn.graphics().get(0));

		}

		return Component.translatable(getDescriptionId());
	}

}

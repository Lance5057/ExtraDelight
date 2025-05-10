package com.lance5057.extradelight.items.dynamicfood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.items.dynamicfood.api.IDynamic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.renderable.BakedModelRenderable;
import net.neoforged.neoforge.client.model.renderable.IRenderable;

public class DynamicToast extends Item implements IDynamic {
	static final ModelResourceLocation base_model = ModelResourceLocation
			.standalone(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "extra/dynamics/toast/toast"));
	static final ModelResourceLocation missing_model = ModelResourceLocation
			.standalone(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "extra/dynamics/toast/empty_toast"));

	public DynamicToast(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<BakedModel> getPieces(ItemStack itemStack) {
		List<BakedModel> i = new ArrayList<BakedModel>();
//		Minecraft.getInstance().getItemRenderer().getModel(itemStack, null, null, 0);

		BakedModel bm = Minecraft.getInstance().getModelManager().getModel(base_model);
		i.add(bm);

		ItemContainerContents comp = itemStack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());
		if (comp != null) {
			{
				if (comp.getSlots() > 1) {
					ItemStack s = comp.getStackInSlot(1);
					String str = s.getItem().getDescriptionId();
					str = str.substring(str.lastIndexOf('.') + 1);
//					IRenderable<ModelData> m = BakedModelRenderable
//							.of(ModelResourceLocation.standalone(ExtraDelight.modLoc("extra/dynamics/toast/" + str)))
//							.withModelDataContext();
					ResourceLocation rc = ExtraDelight.modLoc("extra/dynamics/toast/" + str);
					i.add(Minecraft.getInstance().getModelManager().getModel(ModelResourceLocation.standalone(rc)));
//					i.add(Minecraft.getInstance().getItemRenderer().getModel(comp.getStackInSlot(1), null, null, 0));
				} else
					i.add(Minecraft.getInstance().getModelManager().getModel(missing_model));
			}
		} else
			i.add(Minecraft.getInstance().getModelManager().getModel(missing_model));

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
					for (ItemStack s : comp.nonEmptyItems())
						tooltip.add(Component.literal(" - ").append(Component.translatable(s.getDescriptionId())));
				}
			}
		}
	}

	@Override
	public Component getName(ItemStack itemStack) {
		ItemContainerContents comp = itemStack.getComponents().get(ExtraDelightComponents.ITEMSTACK_HANDLER.get());
		if (comp != null) {
			if (comp.getSlots() > 1)
				return Component.translatable(comp.getStackInSlot(1).getDescriptionId()).append(" ")
						.append(Component.translatable(this.getDescriptionId(itemStack)));
		}

		return Component.translatable(this.getDescriptionId(itemStack));
	}

}

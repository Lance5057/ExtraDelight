package com.lance5057.extradelight.armor;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ApronItem extends ArmorItem {

	public enum STYLE {
		BLACK, WHITE, RED, BLUE, YELLOW, GREEN, ORANGE, PURPLE, LIGHT_BLUE, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, BROWN,
		MAGENTA
	}

	public ApronItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
		super(pMaterial, Type.LEGGINGS, pProperties);
	}

	@Override
	public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot,
			ArmorMaterial.Layer layer, boolean innerModel) {
		if (innerModel)
			if (stack.has(ExtraDelightComponents.APRON)) {
				int i = stack.get(ExtraDelightComponents.APRON).style();
				String s = STYLE.values()[i].toString();
				ResourceLocation rc = ExtraDelight.modLoc("textures/models/armor/" + s.toLowerCase() + "_apron.png");
				return rc;
			}
		return null;
	}
}
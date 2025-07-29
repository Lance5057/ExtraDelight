package com.lance5057.extradelight.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ApronItem extends ArmorItem {
    public ApronItem(Holder<ArmorMaterial> pMaterial, Properties pProperties) {
        super(pMaterial, Type.LEGGINGS, pProperties);
    }
}
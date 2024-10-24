package com.lance5057.extradelight.armor;

import java.util.List;
import java.util.Map;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EDArmorMaterial {

	private static final Map<ArmorItem.Type, Integer> ZERO = Map.of(ArmorItem.Type.HELMET, 1, ArmorItem.Type.CHESTPLATE,
			1, ArmorItem.Type.LEGGINGS, 1, ArmorItem.Type.BOOTS, 1, ArmorItem.Type.BODY, 1);

	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister
			.create(Registries.ARMOR_MATERIAL, ExtraDelight.MOD_ID);

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CORN_COB = ARMOR_MATERIALS.register("corncob",
			() -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ExtraDelightItems.CORN_COB.get()), List.of(), 0.0F, 0.0F));

	public static void register(IEventBus modBus) {
		ARMOR_MATERIALS.register(modBus);
	}
}

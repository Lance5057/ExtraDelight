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

	private static final Map<ArmorItem.Type, Integer> ZERO = Map.of(ArmorItem.Type.HELMET, 0, ArmorItem.Type.CHESTPLATE,
			0, ArmorItem.Type.LEGGINGS, 0, ArmorItem.Type.BOOTS, 0, ArmorItem.Type.BODY, 0);

	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister
			.create(Registries.ARMOR_MATERIAL, ExtraDelight.MOD_ID);

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CORN_COB = ARMOR_MATERIALS
			.register("extradelight:corncob", () -> new ArmorMaterial(ZERO, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
					() -> Ingredient.of(ExtraDelightItems.CORN_COB.get()), List.of(), 0.0F, 0.0F));

	public static void register(IEventBus modBus) {
		ARMOR_MATERIALS.register(modBus);
	}

//	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
//	private final String name;
//	private final int durabilityMultiplier;
//	private final int[] slotProtections;
//	private final int enchantmentValue;
//	private final SoundEvent sound;
//	private final float toughness;
//	private final float knockbackResistance;
//	@SuppressWarnings("deprecation")
//	private final LazyLoadedValue<Ingredient> repairIngredient;
//
//	EDArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent sound,
//			float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
//		this.name = name;
//		this.durabilityMultiplier = durability;
//		this.slotProtections = protection;
//		this.enchantmentValue = enchantability;
//		this.sound = sound;
//		this.toughness = toughness;
//		this.knockbackResistance = knockbackResistance;
//		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
//	}
//
//	public int getDurabilityForSlot(EquipmentSlot slot) {
//		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
//	}
//
//	public int getDefenseForSlot(EquipmentSlot slot) {
//		return this.slotProtections[slot.getIndex()];
//	}
//
//	public int getEnchantmentValue() {
//		return this.enchantmentValue;
//	}
//
//	public SoundEvent getEquipSound() {
//		return this.sound;
//	}
//
//	public Ingredient getRepairIngredient() {
//		return this.repairIngredient.get();
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public float getToughness() {
//		return this.toughness;
//	}
//
//	public float getKnockbackResistance() {
//		return this.knockbackResistance;
//	}
//
//	@Override
//	public int getDurabilityForType(Type p_266807_) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getDefenseForType(Type p_267168_) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}

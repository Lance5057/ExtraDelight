package com.lance5057.extradelight.armor;

import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum EDArmorMaterial implements ArmorMaterial {

	CORNCOB("extradelight:corncob", 3, new int[] { 0, 0, 0, 0 }, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->

	{
		return Ingredient.of(ExtraDelightItems.CORN_COB.get());
	});

	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	@SuppressWarnings("deprecation")
	private final LazyLoadedValue<Ingredient> repairIngredient;

	EDArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent sound,
			float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durability;
		this.slotProtections = protection;
		this.enchantmentValue = enchantability;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	public int getDurabilityForSlot(EquipmentSlot slot) {
		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.slotProtections[slot.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public int getDurabilityForType(Type p_266807_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDefenseForType(Type p_267168_) {
		// TODO Auto-generated method stub
		return 0;
	}
}

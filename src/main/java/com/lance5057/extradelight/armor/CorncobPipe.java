package com.lance5057.extradelight.armor;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CorncobPipe extends ArmorItem {
	public CorncobPipe(Holder<ArmorMaterial> pMaterial, Item.Properties pProperties) {
		super(pMaterial, ArmorItem.Type.HELMET, pProperties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isHeld) {
		if(slot == 39)
		if (level instanceof ServerLevel s) {
			if (level.random.nextInt(5) == 0) {
				double scale = 0.5;
				Vec3 v2 = Vec3.directionFromRotation(entity.getRotationVector().add(new Vec2(0f, 30f))).multiply(scale,
						scale, scale);
				Vec3 v = entity.position().add(v2);
				s.sendParticles(ParticleTypes.EFFECT, v.x, v.y + 1.7, v.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
			}
		}
	}

}
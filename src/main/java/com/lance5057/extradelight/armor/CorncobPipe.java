package com.lance5057.extradelight.armor;

import java.util.function.Consumer;

import com.lance5057.extradelight.armor.models.CorncobPipeModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class CorncobPipe extends ArmorItem {
	public CorncobPipe(Holder<ArmorMaterial> pMaterial, Item.Properties pProperties) {
		super(pMaterial, ArmorItem.Type.HELMET, pProperties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot,
					HumanoidModel<?> defaultModel) {
				EntityModelSet models = Minecraft.getInstance().getEntityModels();
				ModelPart root = models.bakeLayer(CorncobPipeModel.LAYER_LOCATION);
				return new CorncobPipeModel(root);
			}

		});
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isHeld) {
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
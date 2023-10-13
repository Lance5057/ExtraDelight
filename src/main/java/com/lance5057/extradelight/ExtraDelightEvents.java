package com.lance5057.extradelight;

import com.lance5057.extradelight.armor.models.CorncobPipeModel;

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExtraDelightEvents {

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CorncobPipeModel.LAYER_LOCATION, () -> LayerDefinition
				.create(CorncobPipeModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
	}

	public static void stopDimensionDestruction(BlockEvent.BreakEvent event) {
		if (event.getPlayer().level.dimension() == ExtraDelightWorldGen.CORNFIELD) {
			if (event.getState().getBlock() == ExtraDelightBlocks.CORN_BOTTOM.get()
					|| event.getState().getBlock() == ExtraDelightBlocks.CORN_TOP.get()) {
				event.getPlayer().hurt(DamageSource.MAGIC, 1);
				event.getLevel().playSound(event.getPlayer(), event.getPos(), SoundEvents.WITCH_CELEBRATE, SoundSource.HOSTILE, 0, 1);
				event.setCanceled(true);
			}
		}
	}
}

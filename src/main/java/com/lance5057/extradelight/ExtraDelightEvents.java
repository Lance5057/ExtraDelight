package com.lance5057.extradelight;

import com.lance5057.extradelight.armor.models.CorncobPipeModel;

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExtraDelightEvents {

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CorncobPipeModel.LAYER_LOCATION, () -> LayerDefinition
				.create(CorncobPipeModel.createLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 16, 16));
	}
}

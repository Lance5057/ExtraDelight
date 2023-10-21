package com.lance5057.extradelight;

import com.mojang.blaze3d.shaders.FogShape;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ExtraDelight.MOD_ID, value = Dist.CLIENT)
public class ExtraDelightForgeClientEvents {
	@SubscribeEvent
	public static void onFogDensityEvent(ViewportEvent.RenderFog event) {
		if (Minecraft.getInstance().player.level.dimension() == ExtraDelightWorldGen.CORNFIELD) {
			event.setNearPlaneDistance(-8);
			event.scaleFarPlaneDistance(0.25f);
			event.setFogShape(FogShape.CYLINDER);
			event.setCanceled(true);
		}

	}

	@SubscribeEvent
	public static void onFogColorEvent(ViewportEvent.ComputeFogColor event) {
		if (Minecraft.getInstance().player.level.dimension() == ExtraDelightWorldGen.CORNFIELD) {
			float f = 0.5f;
			event.setRed(f);
			event.setBlue(f);
			event.setGreen(f);
			event.setCanceled(true);
		}
	}
}

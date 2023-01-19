package com.lance5057.extradelight;

import com.lance5057.extradelight.containers.FoodDisplayRenderer;
import com.lance5057.extradelight.workstations.recipetab.OvenRecipeCatagories;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtraDelightClientEvents {
	
	@SubscribeEvent
	public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
		OvenRecipeCatagories.init(event);
	}
	
	public static void setTERenderers() {
		BlockEntityRenderers.register(ExtraDelightBlockEntities.FOOD_DISPLAY.get(), FoodDisplayRenderer::new);
	}
}

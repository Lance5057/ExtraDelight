package com.lance5057.extradelight.data;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import vectorwing.farmersdelight.FarmersDelight;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
		}
		if (event.includeClient()) {

		}
	}
}
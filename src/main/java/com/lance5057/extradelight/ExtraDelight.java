package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.worldgen.generation.CropGeneration;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "1.1.8";

	public static Logger logger = LogManager.getLogger();

	public ExtraDelight() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ExtraDelightConfig.spec);

		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);
		modEventBus.addListener(this::setupCommon);

		AestheticBlocks.setup();
		AestheticBlocks.BLOCKS.register(modEventBus);
		AestheticBlocks.ITEMS.register(modEventBus);

		ExtraDelightBlocks.register(modEventBus);
		ExtraDelightItems.ITEMS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
		ExtraDelightLoot.register(modEventBus);

		ExtraDelightWorldGen.FEATURES.register(modEventBus);

		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.addListener(ExtraDelightEvents::stopDimensionDestruction);
	}

	public void setupClient(FMLClientSetupEvent event) {

		// event.enqueueWork(() -> {
		ExtraDelightClientEvents.setTERenderers();
		ExtraDelightContainers.registerClient(event);
		// });
	}

	public void setupCommon(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CropGeneration.registerWildCropGeneration();
		});
	}
}

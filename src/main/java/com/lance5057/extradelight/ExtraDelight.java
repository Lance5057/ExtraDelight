package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "2.0.0";

	public static Logger logger = LogManager.getLogger();

	public ExtraDelight(IEventBus modEventBus) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ExtraDelightConfig.spec);

//		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);
		modEventBus.addListener(this::setupCommon);
		modEventBus.addListener(ExtraDelightCapabilities::registerCapabilities);

		AestheticBlocks.setup();
		AestheticBlocks.BLOCKS.register(modEventBus);
		AestheticBlocks.ITEMS.register(modEventBus);
//
		ExtraDelightBlocks.register(modEventBus);
		ExtraDelightItems.ITEMS.register(modEventBus);
		ExtraDelightTabs.TABS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
//		ExtraDelightLoot.register(modEventBus);
//
//		ExtraDelightWorldGen.FEATURES.register(modEventBus);
//
//		ExtraDelightConfiguredFeatures.register(modEventBus);
//		ExtraDelightPlacedFeatures.register(modEventBus);
//
//		IEventBus bus = MinecraftForge.EVENT_BUS;
//		bus.addListener(ExtraDelightEvents::stopDimensionDestruction);
	}

	public void setupClient(FMLClientSetupEvent event) {

		event.enqueueWork(() -> {
			ExtraDelightClientEvents.setTERenderers();
			ExtraDelightContainers.registerClient(event);
		});
	}

	public void setupCommon(FMLCommonSetupEvent event) {
//		event.enqueueWork(CropGeneration::registerWildCropGeneration);
	}
}

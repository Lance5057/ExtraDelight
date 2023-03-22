package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "0.2a";

	public static Logger logger = LogManager.getLogger();

	public ExtraDelight() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ExtraDelightConfig.spec);

		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);

		ExtraDelightBlocks.BLOCKS.register(modEventBus);
		ExtraDelightItems.ITEMS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
	}

	public void setupClient(FMLClientSetupEvent event) {

		// event.enqueueWork(() -> {
		ExtraDelightClientEvents.setTERenderers();
		ExtraDelightContainers.registerClient(event);
		// });
	}
}

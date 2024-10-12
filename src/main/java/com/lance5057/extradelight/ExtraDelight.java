package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.armor.EDArmorMaterial;
import com.lance5057.extradelight.network.NetworkHandler;
import com.lance5057.extradelight.worldgen.features.ExtraDelightFeatures;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "2.0.4";

	public static Logger logger = LogManager.getLogger();

	public ExtraDelight(IEventBus modEventBus, ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, ExtraDelightConfig.spec);

//		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);
		modEventBus.addListener(this::setupCommon);
		modEventBus.addListener(ExtraDelightCapabilities::registerCapabilities);
		modEventBus.addListener(NetworkHandler::setupPackets);

		AestheticBlocks.setup();
		AestheticBlocks.BLOCKS.register(modEventBus);
		AestheticBlocks.ITEMS.register(modEventBus);

		ExtraDelightComponents.COMPONENTS.register(modEventBus);
		ExtraDelightBlocks.register(modEventBus);
		ExtraDelightFluids.register(modEventBus);
		ExtraDelightItems.ITEMS.register(modEventBus);
		ExtraDelightTabs.TABS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
		ExtraDelightLootModifiers.LOOT_MODIFIERS.register(modEventBus);
		EDArmorMaterial.register(modEventBus);
		ExtraDelightWorldGen.FEATURES.register(modEventBus);

		ExtraDelightFeatures.FEATURES.register(modEventBus);
	}

	public void setupClient(FMLClientSetupEvent event) {

		event.enqueueWork(() -> {
			ExtraDelightClientEvents.setTERenderers();
//			NeoForge.EVENT_BUS.register(ExtraDelightContainers.class);
		});
	}

	public void setupCommon(FMLCommonSetupEvent event) {
//		event.enqueueWork(CropGeneration::registerWildCropGeneration);
	}
}

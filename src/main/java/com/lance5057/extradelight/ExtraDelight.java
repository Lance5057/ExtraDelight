package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.modules.Fermentation;
import com.lance5057.extradelight.network.NetworkHandler;
import com.lance5057.extradelight.worldgen.features.ExtraDelightFeatures;
import com.lance5057.extradelight.worldgen.placers.FoliagePlacerRegistry;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "2.5.1";

	public static ResourceLocation modLoc(String s) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, s);
	}

	public static Logger logger = LogManager.getLogger();

	public ExtraDelight(IEventBus modEventBus, ModContainer modContainer) {
		NeoForgeMod.enableMilkFluid();
		modContainer.registerConfig(ModConfig.Type.COMMON, ExtraDelightConfig.spec);

//		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupClient);
		modEventBus.addListener(this::setupCommon);
		modEventBus.addListener(ExtraDelightCapabilities::registerCapabilities);
		modEventBus.addListener(NetworkHandler::setupPackets);
		modEventBus.addListener(ExtraDelightBlockEntities::addCabinets);

		Fermentation f = new Fermentation();

		AestheticBlocks.setup();
		AestheticBlocks.BLOCKS.register(modEventBus);
		AestheticBlocks.ITEMS.register(modEventBus);

		ExtraDelightComponents.COMPONENTS.register(modEventBus);
		ExtraDelightBlocks.register(modEventBus);
		ExtraDelightFluids.register(modEventBus);

//		PieceTypes.PIECES.register(modEventBus);

		ExtraDelightItems.ITEMS.register(modEventBus);
		ExtraDelightTabs.TABS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
		ExtraDelightLootModifiers.LOOT_MODIFIERS.register(modEventBus);

		FoliagePlacerRegistry.PLACER.register(modEventBus);
		ExtraDelightWorldGen.FEATURES.register(modEventBus);

		ExtraDelightFeatures.FEATURES.register(modEventBus);

		ExtraDelightMobEffects.register(modEventBus);
	}

	public void setupClient(FMLClientSetupEvent event) {

		event.enqueueWork(() -> {
			ExtraDelightClientEvents.setTERenderers();
			ExtraDelightClientEvents.doFluidRenderLayer();
		});
	}

	public void setupCommon(FMLCommonSetupEvent event) {
		ExtraDelightBlocks.setup();
		ExtraDelightItems.setup();
	}
}

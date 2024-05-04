package com.lance5057.extradelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lance5057.extradelight.addons.ButchercraftAddon;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.worldgen.features.ExtraDelightConfiguredFeatures;
import com.lance5057.extradelight.worldgen.features.ExtraDelightPlacedFeatures;
import com.lance5057.extradelight.worldgen.generation.CropGeneration;

import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mod(ExtraDelight.MOD_ID)
public class ExtraDelight {
	public final static String MOD_ID = "extradelight";
	public static final String VERSION = "1.3.2";

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

		ButchercraftAddon.BLOCKS.register(modEventBus);
		ButchercraftAddon.ITEMS.register(modEventBus);

		ExtraDelightBlockEntities.TILES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_TYPES.register(modEventBus);
		ExtraDelightRecipes.RECIPE_SERIALIZERS.register(modEventBus);
		ExtraDelightContainers.MENU_TYPES.register(modEventBus);
		ExtraDelightLoot.register(modEventBus);

		ExtraDelightWorldGen.FEATURES.register(modEventBus);

		ExtraDelightConfiguredFeatures.register(modEventBus);
		ExtraDelightPlacedFeatures.register(modEventBus);

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
			compost();
		});
	}

	public void compost() {
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CINNAMON_BARK.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CINNAMON_LEAVES.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CINNAMON_STICK.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.RAW_CINNAMON.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GROUND_CINNAMON.get(), 0.3F);

		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CORN_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SUNFLOWER_SEEDS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.MINT.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GINGER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CORN_COB.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CORN_HUSK.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CORN_SILK.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CORN_ON_COB.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GINGER_CUTTING.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.PEELED_GINGER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GRATED_GINGER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SLICED_GINGER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SLICED_ONION.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SLICED_POTATO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SLICED_TOMATO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GRATED_POTATO.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.POTATO_STICKS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.GRATED_CARROT.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CINNAMON_BARK.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.SLICED_APPLE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CHEESE.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.BUTTER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.MACARONI.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.LASAGNA_NOODLES.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(ExtraDelightItems.CACTUS.get(), 0.3F);
	}
}

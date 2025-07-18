package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.data.compat.create.CreateMixingRecipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGen {
//	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.PLACED_FEATURE,
//			ExtraDelightTreePlacement::bootstrap);

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		
		generator.addProvider(event.includeClient(), new ItemModels(output, helper));
		generator.addProvider(true, new BlockModels(output, helper));

		generator.addProvider(true, new AllLootTables(output, lookupProvider));

		EDBlockTags blockTags = new EDBlockTags(output, lookupProvider, event.getExistingFileHelper());
		generator.addProvider(true, blockTags);
		generator.addProvider(event.includeServer(),
				new EDItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));
		generator.addProvider(event.includeServer(), new EDFluidTags(output, lookupProvider, helper));
		

		generator.addProvider(event.includeServer(), new Recipes(output, lookupProvider));
		generator.addProvider(event.includeServer(), new LootModifiers(lookupProvider, output));
		generator.addProvider(event.includeServer(), new Advancements(output, lookupProvider, helper));
		generator.addProvider(event.includeClient(), new EnglishLoc(output));

		generator.addProvider(event.includeServer(), new EDBiomeModifiers(output, lookupProvider));
		generator.addProvider(event.includeServer(), EDRegistries.provider(output, lookupProvider));
		

		generator.addProvider(event.includeServer(), new DataMapGen(output, lookupProvider));

		generator.addProvider(event.includeClient(),
				new PatchouliGen(output, ExtraDelight.MOD_ID, "en_us", lookupProvider));

		generator.addProvider(event.includeClient(), new CreateMixingRecipes(output, lookupProvider, "create"));
		
		generator.addProvider(true, new EDBannerTags(output, lookupProvider, helper));
	}
}
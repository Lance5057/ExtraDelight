package com.lance5057.extradelight.data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import vectorwing.farmersdelight.data.Advancements;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new ItemModels(output, helper));
		generator.addProvider(true, new BlockModels(output, helper));

		generator.addProvider(true, new LootTableProvider(output, Collections.emptySet(),
				List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK),
						new LootTableProvider.SubProviderEntry(MiscLootTables::new, LootContextParamSets.EMPTY),
						new LootTableProvider.SubProviderEntry(StructureLootTables::new, LootContextParamSets.EMPTY))));

		EDBlockTags blockTags = new EDBlockTags(output, lookupProvider, event.getExistingFileHelper());
		generator.addProvider(true, blockTags);
		generator.addProvider(event.includeServer(),
				new EDItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));

		generator.addProvider(event.includeServer(), new Recipes(output));
		generator.addProvider(event.includeServer(), new LootModifiers(output));
		generator.addProvider(event.includeServer(), new Advancements(output, lookupProvider, helper));
		generator.addProvider(event.includeClient(), new EnglishLoc(output));

//		generator.addProvider(event.includeClient(), new PatchouliGen(generator, ExtraDelight.MOD_ID, "en_us"));
	}
}
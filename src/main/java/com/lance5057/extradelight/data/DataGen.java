package com.lance5057.extradelight.data;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.worldgen.features.trees.ExtraDelightTreePlacement;

import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import vectorwing.farmersdelight.data.Advancements;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.PLACED_FEATURE,
			ExtraDelightTreePlacement::bootstrap);

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

		generator.addProvider(event.includeServer(),
				new RegistriesDatapackGenerator(output,
						event.getLookupProvider().thenApply(r -> constructRegistries(r, BUILDER)),
						Set.of(ExtraDelight.MOD_ID)));

		generator.addProvider(event.includeServer(), new EDBiomeModifiers(output, lookupProvider));

//		generator.addProvider(event.includeClient(), new PatchouliGen(generator, ExtraDelight.MOD_ID, "en_us"));
	}

	private static HolderLookup.Provider constructRegistries(HolderLookup.Provider original,
			RegistrySetBuilder datapackEntriesBuilder) {
		Cloner.Factory clonerFactory = new Cloner.Factory();
		var builderKeys = new HashSet<>(datapackEntriesBuilder.getEntryKeys());
		RegistryDataLoader.WORLDGEN_REGISTRIES.stream().forEach(data -> {
			// Add keys for missing registries
			if (!builderKeys.contains(data.key()))
				datapackEntriesBuilder.add(data.key(), context -> {
				});

			data.runWithArguments(clonerFactory::addCodec);
		});

		return datapackEntriesBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY),
				original, clonerFactory).patches();
	}
}
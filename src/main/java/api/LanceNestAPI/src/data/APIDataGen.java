package api.LanceNestAPI.src.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class APIDataGen {

	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new ItemModels(output, helper));
		generator.addProvider(true, new BlockModels(output, helper));

//		generator.addProvider(event.includeServer(), new Recipes(output, lookupProvider));
//		generator.addProvider(event.includeClient(), new EnglishLoc(output));
	}
}

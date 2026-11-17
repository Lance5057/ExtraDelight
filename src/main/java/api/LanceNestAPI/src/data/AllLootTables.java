package api.LanceNestAPI.src.data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class AllLootTables extends LootTableProvider {
	public AllLootTables(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(pOutput, Collections.emptySet(), List.of(new SubProviderEntry(BlockLoot::new, LootContextParamSets.BLOCK)

		), registries);
	}
}
package api.LanceNestAPI.src.data;

import java.util.Collections;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

public class BlockLoot extends BlockLootSubProvider {
	public BlockLoot(HolderLookup.Provider provider) {
		super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), provider);
	}

	@Override
	protected void generate() {
		dropSelf(LanceNestAPI.ADVANCED_DISPLAY_BLOCK.get());
	}

}

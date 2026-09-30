package api.LanceNestAPI.src.data;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModels extends BlockStateProvider {

	public BlockModels(PackOutput gen, ExistingFileHelper exFileHelper) {
		super(gen, LanceNestAPI.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(LanceNestAPI.ADVANCED_DISPLAY_BLOCK.get(), this.models()
				.withExistingParent("jar_display", this.mcLoc("air")).texture("particle", this.mcLoc("block/glass")));
	}

}

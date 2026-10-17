package api.LanceNestAPI.src.data;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemModels extends ItemModelProvider {

	public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, LanceNestAPI.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerModels() {
		forItem(this, LanceNestAPI.ADVANCED_DISPLAY_ITEM, "advanced_item_frame");
	}

	public static void forItem(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
		tmp.singleTexture(item.getId().getPath(), tmp.mcLoc("item/generated"), "layer0", tmp.modLoc("item/" + name));
	}
}

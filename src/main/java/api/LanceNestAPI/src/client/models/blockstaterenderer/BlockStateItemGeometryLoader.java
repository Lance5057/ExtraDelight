package api.LanceNestAPI.src.client.models.blockstaterenderer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import api.LanceNestAPI.src.util.ResourceLocationUtil;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.CustomLoaderBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.geometry.IGeometryLoader;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockStateItemGeometryLoader implements IGeometryLoader<BlockStateItemUnbakedGeometry> {
	public static ResourceLocation ID = ResourceLocationUtil.apiLoc("blockstateitem");

	@Override
	public BlockStateItemUnbakedGeometry read(JsonObject jsonObject, JsonDeserializationContext deserializationContext)
			throws JsonParseException {
		return new BlockStateItemUnbakedGeometry();
	}

	public static <T extends ModelBuilder<T>> CustomLoaderBuilder<T> builder(T parent,
			ExistingFileHelper existingFileHelper) { 
		return new CustomLoaderBuilder<T>(ID, parent, existingFileHelper, true) {
		};
	}
}
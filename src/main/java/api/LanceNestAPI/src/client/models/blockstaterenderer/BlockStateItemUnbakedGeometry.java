package api.LanceNestAPI.src.client.models.blockstaterenderer;

import java.util.function.Function;

import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;
import net.neoforged.neoforge.client.model.geometry.IUnbakedGeometry;

public class BlockStateItemUnbakedGeometry implements IUnbakedGeometry<BlockStateItemUnbakedGeometry> {

//    @Override
//    public Collection<Material> getMaterials(IGeometryBakingContext context, Function modelGetter, Set missingTextureErrors) {
//        return Collections.emptyList();
//    }

	@Override
	public BakedModel bake(IGeometryBakingContext context, ModelBaker baker,
			Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides) {

		return new BlockStateItemBakedGeometry();
	}
}
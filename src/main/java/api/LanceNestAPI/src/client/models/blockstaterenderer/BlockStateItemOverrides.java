package api.LanceNestAPI.src.client.models.blockstaterenderer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.level.block.state.BlockState;

public class BlockStateItemOverrides extends ItemOverrides {
//	private final Cache<Integer, MetalTileBakedGeometry> cache;

	public BlockStateItemOverrides() {
//		this.cache = CacheBuilder.newBuilder().expireAfterWrite(Duration.of(5, ChronoUnit.MINUTES)).build();
	}

	@Override
	@Nullable
	@ParametersAreNonnullByDefault
	public BakedModel resolve(BakedModel pModel, ItemStack pStack, @Nullable ClientLevel pLevel,
			@Nullable LivingEntity pEntity, int pSeed) {
		if (pStack.getItem() instanceof BlockItem bi) {
			if (pStack.has(DataComponents.BLOCK_STATE)) {
				BlockItemStateProperties bisp = pStack.get(DataComponents.BLOCK_STATE);

				BlockState bs = bisp.apply(bi.getBlock().defaultBlockState());

				BakedModel bm = Minecraft.getInstance().getBlockRenderer().getBlockModel(bs);

				return bm;
			} else
				return Minecraft.getInstance().getBlockRenderer().getBlockModel(bi.getBlock().defaultBlockState());
		}
		return pModel;
	}
}
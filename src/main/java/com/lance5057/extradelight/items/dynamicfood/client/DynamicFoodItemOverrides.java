package com.lance5057.extradelight.items.dynamicfood.client;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.items.dynamicfood.DynamicJam;
import com.lance5057.extradelight.items.dynamicfood.api.IDynamic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class DynamicFoodItemOverrides extends ItemOverrides {
	private final Cache<Integer, DynamicFoodChildBakedGeometry> cache;

	public DynamicFoodItemOverrides() {
		this.cache = CacheBuilder.newBuilder().expireAfterWrite(Duration.of(5, ChronoUnit.MINUTES)).build();
	}

	@Override
	@Nullable
	@ParametersAreNonnullByDefault
	public BakedModel resolve(BakedModel pModel, ItemStack pStack, @Nullable ClientLevel pLevel,
			@Nullable LivingEntity pEntity, int pSeed) {
		if (pStack.getItem() instanceof IDynamic customizable) {
			Collection<ResourceLocation> resources = customizable.getPieces(pStack);
			List<BakedModel> pieces = new ArrayList<BakedModel>();

			for (ResourceLocation rc : resources) {
				BakedModel bm = Minecraft.getInstance().getModelManager()
						.getModel(ModelResourceLocation.standalone(rc));
				if (bm == Minecraft.getInstance().getModelManager().getMissingModel())
					bm = Minecraft.getInstance().getModelManager()
							.getModel(ModelResourceLocation.standalone(DynamicJam.missing_model));
				pieces.add(bm);
			}

			try {
				return cache.get(pieces.size(), () -> {
					List<BakedModel> pieceBakedModels = new ArrayList<>(pieces.size());
					for (BakedModel iPiece : pieces) {
						pieceBakedModels.add(iPiece);
					}
					return new DynamicFoodChildBakedGeometry(pieceBakedModels);
				});
			} catch (ExecutionException e) {
				ExtraDelight.logger.error("FAILED TO CREATE GEOMETRY FOR MODEL", e);
			}
		}
		return pModel;
	}
}
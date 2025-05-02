package com.lance5057.extradelight.client;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

public class BlockStateItemBakedGeometry implements BakedModel {

	public BlockStateItemBakedGeometry() {
	}

	@Override
	@NotNull
	@SuppressWarnings("deprecation")
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand) {
		List<BakedQuad> bakedQuads = new ArrayList<>();

		return bakedQuads;
	}
//
//	@Override
//	@NotNull
//	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand,
//			@NotNull ModelData data, @Nullable RenderType renderType) {
//		List<BakedQuad> bakedQuads = new ArrayList<>();
//		for (BakedModel bakedModel : childrenModels) {
//			bakedQuads.addAll(bakedModel.getQuads(state, side, rand, data, renderType));
//		}
//		return bakedQuads;
//	}
//
//	@Override
//	@NotNull
//	public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand,
//			@NotNull ModelData data) {
//		Set<ChunkRenderTypeSet> chunkRenderTypeSets = new HashSet<>();
//		for (BakedModel bakedModel : childrenModels) {
//			chunkRenderTypeSets.add(bakedModel.getRenderTypes(state, rand, data));
//		}
//		return ChunkRenderTypeSet.union(chunkRenderTypeSets);
//	}

	@Override
	public boolean useAmbientOcclusion() {
		return true;
	}

	@Override
	public boolean isGui3d() {
		return true;
	}

	@Override
	public boolean usesBlockLight() {
		return true;
	}

	@Override
	public boolean isCustomRenderer() {
		return true;
	}

	@Override
	@NotNull
	@SuppressWarnings("deprecation")
	public TextureAtlasSprite getParticleIcon() {
		return ModelBakery.FIRE_0.sprite();
	}

	@Override
	@NotNull
	public TextureAtlasSprite getParticleIcon(@NotNull ModelData modelData) {
		return ModelBakery.FIRE_0.sprite();
	}

	@Override
	@NotNull
	public ItemOverrides getOverrides() {
		return new BlockStateItemOverrides();
	}
}